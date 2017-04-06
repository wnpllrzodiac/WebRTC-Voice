package cc.dot.engine.listener;

import org.webrtc.IceCandidate;
import org.webrtc.MediaStream;
import org.webrtc.PeerConnection;
import org.webrtc.SessionDescription;
import org.webrtc.StatsReport;

import cc.dot.engine.DotPeer;


/**
 * Created by xiang on 18/03/2017.
 */

public interface DotPeerListener {

    void onReceiveRemoteStream(DotPeer peer, MediaStream stream);

    void onRemoveRemoteStream(DotPeer peer, MediaStream stream);

    void onGotError(DotPeer peer, String error);

    void onGotStat(DotPeer peer, StatsReport[] stats);

    void onChangeIceGatheringState(DotPeer peer, PeerConnection.IceGatheringState iceGatheringState);

    void onGotIceCandidates(DotPeer peer, IceCandidate[] candidates);

    void onPeerChangeState(DotPeer peer, DotPeer.PeerStatus status);

    void onGotSessionDescription(DotPeer peer, SessionDescription sdp);

    void onHaveSdp(SessionDescription sdp);

}
