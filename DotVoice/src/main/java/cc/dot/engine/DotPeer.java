package cc.dot.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import org.webrtc.DataChannel;
import org.webrtc.IceCandidate;
import org.webrtc.Logging;
import org.webrtc.MediaConstraints;
import org.webrtc.MediaStream;
import org.webrtc.PeerConnection;
import org.webrtc.RtpParameters;
import org.webrtc.RtpSender;
import org.webrtc.SdpObserver;
import org.webrtc.SessionDescription;
import org.webrtc.SurfaceViewRenderer;

import java.util.LinkedList;

import cc.dot.engine.listener.DotPeerListener;


/**
 * Created by linSir
 * date at 2017/4/4.
 * describe:
 */

public class DotPeer implements SdpObserver, PeerConnection.Observer{

    private static String TAG = DotPeer.class.getSimpleName();
    public enum PeerConnectionRole {
        PeerConnectionRoleInitiator,
        PeerConnectionRoleReceiver,
    }

    public enum  PeerStatus {
        PeerStatusNew,
        PeerStatusConnecting,
        PeerStatusConnected,
        PeerStatusDisConnected,
        PeerStatusError,
    }

    private static int MSG_AUDIOLEVEL = 1;
    private static int MSG_BITRATE = 2;

    private DotPeerListener mListener;

    public String connectionId;

    public String peerId;

    public  PeerConnection peerConnection;

    public LinkedList<IceCandidate> queuedRemoteCandidates;

    public LinkedList<IceCandidate> queuedLocalCandidates;

    public PeerConnectionRole  peerConnectionRole;

    public MediaStream remoteStream;

    public  PeerStatus  peerStatus;

    public  int  iceAttempts;

    public  boolean local;


    public DotPeer(DotPeerListener listener) {
        this.queuedLocalCandidates = new LinkedList<IceCandidate>();
        this.queuedRemoteCandidates = new LinkedList<IceCandidate>();
        this.peerConnectionRole = PeerConnectionRole.PeerConnectionRoleInitiator;
        this.iceAttempts = 0;
        this.peerStatus = PeerStatus.PeerStatusNew;
        this.mListener = listener;
    }



    public void addLocalStream(MediaStream stream) {
        if (this.peerConnection != null){
            this.peerConnection.addStream(stream);
        }

    }

    public  void removeLocalStream(MediaStream stream) {
        if (this.peerConnection != null){
            this.peerConnection.removeStream(stream);
        }

    }


    public void createOffer(MediaConstraints constraints) {
        this.peerConnection.createOffer(this,constraints);
    }

    public  void setRemoteAnswer(SessionDescription answer){
        this.peerConnection.setRemoteDescription(this,answer);
    }

    public  void close(){
        if (peerStatus != PeerStatus.PeerStatusConnected || peerStatus != PeerStatus.PeerStatusConnecting){
            return;
        }
        this.peerConnection.dispose();
        this.peerConnection = null;
    }



    public void queueLocalCandidate(IceCandidate candidate) {
        this.queuedLocalCandidates.add(candidate);
    }

    public  void removeLocalCandidates(){
        this.queuedLocalCandidates.clear();
    }
    // does not need this if we use janus
    public  void addRemoteCandidate(IceCandidate candidate) {
        boolean queue = this.peerConnection == null || this.peerConnection.signalingState() != PeerConnection.SignalingState.STABLE;
        if (queue){
            this.queuedRemoteCandidates.add(candidate);
        } else {
            this.peerConnection.addIceCandidate(candidate);
        }
    }

    public void drainRemoteCandidate(){
        for (IceCandidate candidate : queuedRemoteCandidates){
            this.peerConnection.addIceCandidate(candidate);
        }
        queuedRemoteCandidates.clear();
    }

    public  void removeRemoteCandidates() {
        queuedRemoteCandidates.clear();
    }

    // these are observers
    @Override
    public void onSignalingChange(PeerConnection.SignalingState newState) {
        if (newState == PeerConnection.SignalingState.STABLE){
            this.drainRemoteCandidate();
        }
    }

    @Override
    public void onIceConnectionChange(PeerConnection.IceConnectionState newState) {
        switch (newState){
            case NEW:
            case CHECKING:
            case COMPLETED:
                break;
            case CONNECTED:
                break;
            case CLOSED:
            case FAILED:
            case DISCONNECTED:
                this.close();
                break;
            default:
                break;
        }
    }

    @Override
    public void onIceConnectionReceivingChange(boolean receiving) {
        Log.d(TAG, "IceConnectionReceiving changed to " + receiving);
    }

    @Override
    public void onIceGatheringChange(PeerConnection.IceGatheringState newState) {
        if (newState == PeerConnection.IceGatheringState.GATHERING){
            this.removeRemoteCandidates();
        } else if (newState == PeerConnection.IceGatheringState.COMPLETE){
            IceCandidate[]  candidates = this.queuedLocalCandidates.toArray(new IceCandidate[this.queuedLocalCandidates.size()]);
            mListener.onGotIceCandidates(this,candidates);
            this.removeLocalCandidates();
        }
    }

    @Override
    public void onIceCandidate(IceCandidate candidate) {
        this.queueLocalCandidate(candidate);
    }

    @Override
    public void onIceCandidatesRemoved(IceCandidate[] candidates) {
        Log.d(TAG, "onIceCandidatesRemoved " + candidates);
    }



    @Override
    public void onAddStream(MediaStream stream) {
        remoteStream = stream;
        mListener.onReceiveRemoteStream(this,stream);
    }

    @Override
    public void onRemoveStream(MediaStream stream) {
        mListener.onRemoveRemoteStream(this,stream);
    }

    @Override
    public void onDataChannel(DataChannel dataChannel) {
        Logging.d(TAG, "onDataChannel ");
    }

    @Override
    public void onRenegotiationNeeded() {
        Logging.d(TAG, "onRenegotiationNeeded ");
    }

    @Override
    public void onCreateSuccess(SessionDescription sdp) {
        Log.i("lin","---*lin*--->   DotPeer -> sdp  -> " + sdp.type);
        Log.i("lin","---*lin*--->   DotPeer -> sdp  -> " + sdp.description);
        peerConnection.setLocalDescription(this,sdp);
            // 这里的处理不是特别严密,  应该等setSuccess 之后再回调,
            // 但在这里处理的话  逻辑更简单,  测试还没出现问题
        //mListener.onGotSessionDescription(this, peerConnection.getLocalDescription());
        mListener.onHaveSdp(sdp);
    }

    @Override
    public void onSetSuccess() {
        Log.i("lin","---*lin*--->   DotPeer -> sdp  -> onSetSuccess 000000000000" );
        Logging.d(TAG,  "SetSuccess  state " + peerConnection.signalingState());
    }

    @Override
    public void onCreateFailure(String error) {
        mListener.onGotError(this,error);
        this.removeRemoteCandidates();
    }

    @Override
    public void onSetFailure(String error) {
        mListener.onGotError(this,error);
        this.removeRemoteCandidates();
    }
}

