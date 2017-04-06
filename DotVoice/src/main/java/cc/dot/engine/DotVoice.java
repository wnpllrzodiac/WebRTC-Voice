package cc.dot.engine;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.AudioSource;
import org.webrtc.AudioTrack;
import org.webrtc.EglBase;
import org.webrtc.IceCandidate;
import org.webrtc.MediaConstraints;
import org.webrtc.MediaStream;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.SessionDescription;
import org.webrtc.StatsReport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import cc.dot.engine.Utils.DotEngineUtils;
import cc.dot.engine.listener.DotPeerListener;
import cc.dot.engine.listener.UserListener;
import cc.dot.engine.model.AuthonModel;
import cc.dot.engine.model.PeerMode;
import cc.dot.engine.model.SignalingMessageModel;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

import static org.webrtc.PeerConnection.BundlePolicy.MAXBUNDLE;
import static org.webrtc.PeerConnection.RtcpMuxPolicy.REQUIRE;
import static org.webrtc.SessionDescription.Type.ANSWER;

/**
 * Created by linSir
 * date at 2017/4/4.
 * describe:
 */

public class DotVoice implements DotPeerListener{

    private static DotVoice dotVoice;
    private AuthonModel mAuthon;
    private String mUserId;
    private WebSocket mWebSocket;
    private List<PeerConnection.IceServer> _iceServers = new ArrayList();
    private PeerConnectionFactory peerConnectionFactory;
    private UserListener userListener;
    private MediaStream localStream;
    private AudioSource audioSource;
    private AudioTrack localAudioTrack;
    private Context _context;
    private OkHttpClient client;
    private String _connectionId;
    private IceCandidate[] _candidates;
    protected EglBase rootEglBase;
    public HashMap<String, DotPeer> peers = new HashMap<>();
    public  DotPeer  localPeer;
    private Timer timer;
    public android.os.Handler handler2 = new Handler(Looper.getMainLooper());
    public android.os.Handler handler = new Handler(new Handler.Callback() {

        @Override public boolean handleMessage(Message message) {
            if (message.what == 1){
                userListener.onJoind(mUserId);
            }else if (message.what == 2){
                userListener.onReceivePublishers();
            }else if (message.what ==3){
                Log.i("lin","---*lin*--->  localPeer CreateOffer");
                CreateOffer(_connectionId);


            }






            return true;
        }
    });


    private DotVoice(){

    }

    private void initInternal(){
        if (localStream != null){
            Log.i("lin","---*lin*--->    initInternal   失败");
            return;
        }

        rootEglBase = EglBase.create();
        EglBase.Context renderEGLContext = rootEglBase.getEglBaseContext();

        if (!PeerConnectionFactory.initializeAndroidGlobals(_context,true,false,false)){
            Log.i("lin","---*lin*--->   initInternal    error   ");
            userListener.onError();
            return;
        }
        peerConnectionFactory = new PeerConnectionFactory();
        localStream = peerConnectionFactory.createLocalMediaStream("ARDAMS");
        localStream.addTrack(createAudioTrack());
        Log.i("lin","---*lin*--->   DotVoice    init    success");
    }

    public enum DotEngineICEFilter {

        DotEngineICEFilter_Local,
        DotEngineICEFilter_Stun,
        DotEngineICEFilter_Turn,
        DotEngineICEFilter_Any
    }

    public static DotVoice getDotVoice(){
        if (dotVoice == null){
            dotVoice = new DotVoice();
        }
        return dotVoice;
    }

    public void setContext(Context context){
        this._context = context;
        client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .pingInterval(20, TimeUnit.SECONDS)
                .build();

        handler2.post(new Runnable() {
            @Override public void run() {
                initInternal();
            }
        });
    }


    public void getToken( String mId, StringCallback callback, final UserListener userListener){
        Log.i("lin","---*lin*--->  getToken");
        this.userListener = userListener;
        mUserId = mId;
        OkHttpUtils
                .post()
                .url("http://10.1.0.106:10000/api/generateTestToken")
                .addParams("appkey", "45")
                .addParams("app_secret","dc5cabddba054ffe894ba79c2910866c")
                .addParams("room","lalala")
                .addParams("user_id", mId)
                .build()
                .execute(callback);
    }




    public void joinRoom(String token){
        final AuthonModel authon = AuthonModel.parseToken(token);
        mAuthon = authon;
        mUserId = authon.getUser_id();


        Request request = new Request.Builder()
                .url(authon.getWsUrl() + "?token=" + token).build();

        mWebSocket = client.newWebSocket(request, new WebSocketListener() {
            @Override public void onOpen(WebSocket webSocket, Response response) {
                mWebSocket = webSocket;
                super.onOpen(webSocket, response);
                Log.i("lin","--lin--*lin*--->   onOpen  ->  " + response.toString());
                sendJoin(false);
                setupKeepLive();

            }

            @Override public void onMessage(WebSocket webSocket, final String text) {
                super.onMessage(webSocket, text);
                Log.i("lin","--guan--->  服务器给我发了消息 onMessage  ->  " + text);




                new Thread(new Runnable() {
                    @Override public void run() {
                        if (!TextUtils.isEmpty(text)){
                            JSONObject json;
                            try {
                                json = new JSONObject(text);
                            } catch (JSONException e) {
                                e.printStackTrace();
                                return;
                            }
                            String from = json.optString("from");
                            String target = json.optString("target");
                            String type =  json.optString("type");
                            Log.i("lin","--guan--->  服务器给我发了消息 onMessage  ->  " + type);
                            String connectionId = json.optString("connectionId");
                            JSONObject data = json.optJSONObject("data");
                            JSONObject jsep = json.optJSONObject("jsep");
                            _connectionId = connectionId;
                            Log.i("lin","---*lin*--->   服务器给我发的消息的类型  onMessage  ->  " + type);

                            if (jsep != null){
                                try{
                                    SessionDescription answer = new SessionDescription(ANSWER,jsep.optString("sdp"));
                                    localPeer.setRemoteAnswer(answer);
                                    Log.i("lin","--lin--*lin*--->   setRemoteAnswer    成功");
                                }catch (Exception e){

                                }
                            }
                            SignalingMessageModel message = new SignalingMessageModel(from,type,target,connectionId,data,jsep);
                            switch (message.getType()){
                                case "joined":
                                    JSONObject data2 = message.getData();
                                    JSONArray peers = data2.optJSONArray("peers");
                                    ArrayList<PeerMode> peerArr = DotEngineUtils.parsePeers(peers);
                                    ArrayList<String> publishedPeers = new ArrayList<String>();
                                    for (PeerMode peer : peerArr){
                                        if (peer.isPublished()){
                                            publishedPeers.add(peer.getId());
                                        }
                                    }
                                    JSONArray iceServerArray = data.optJSONArray("iceServers");
                                    _iceServers = DotEngineUtils.parseIceServer(iceServerArray);
                                    Message message1 = new Message();
                                    message1.what = 1;
                                    message1.obj = mUserId;
                                    handler.sendMessage(message1);

                                    if (publishedPeers.size() > 0){
                                        Message message2 = new Message();
                                        message2.what = 2;
                                        handler.sendMessage(message2);
                                    }

                                    Message message3 = new Message();
                                    message3.what = 3;
                                    message3.obj = message.getConnectionId();
                                    handler.sendMessage(message3);

                                    break;

                                case "peer_connected":
                                    userListener.otherJoinInRoom(message.getFrom());
                                    break;

                                case "configured":
//                                    Log.i("lin","---*lin*--->   发送candidates");
//                                    JSONArray jsonArray = new JSONArray();
//                                    for(int i=0;i<_candidates.length;i++){
//                                        JSONObject temp = new JSONObject();
//                                        try {
//                                            temp.put("sdpMid",_candidates[i].sdpMid);
//                                            temp.put("sdpMLineIndex",_candidates[i].sdpMLineIndex);
//                                            temp.put("sdp",_candidates[i].sdp);
//                                        } catch (JSONException e) {
//                                            e.printStackTrace();
//                                        }
//                                        jsonArray.put(temp);
//                                    }
//
//                                    JSONObject data5 = new JSONObject();
//                                    try {
//                                        data5.put("candidates",jsonArray);
//                                    } catch (JSONException e) {
//                                        e.printStackTrace();
//                                    }
//
//                                    SignalingMessageModel message4 = new SignalingMessageModel(mUserId,"candidates",_connectionId,data5);
//                                    message4.setFrom(mUserId);
//                                    JSONObject json5 = message4.toJson();
//                                    String jsonString5 = json5.toString();
//                                    mWebSocket.send(jsonString5);
//                                    Log.i("lin","---*lin*--->   发送candidates  完毕    ->  "+jsonString5  );

                            }
                            if(message.getData() != null){
                                Log.i("lin","---*lin*--->   message data" + message.getData());
                            }

                        }
                    }
                }).start();



            }

            @Override public void onMessage(WebSocket webSocket, ByteString bytes) {
                Log.i("lin","--lin--*lin*--->   onClosing  ->  " + bytes.size());
                super.onMessage(webSocket, bytes);
            }

            @Override public void onClosing(WebSocket webSocket, int code, String reason) {
                Log.i("lin","--lin--*lin*--->   onClosing  ->  " + reason);
                super.onClosing(webSocket, code, reason);
            }

            @Override public void onClosed(WebSocket webSocket, int code, String reason) {
                Log.i("lin","--lin--*lin*--->   onClosed  ->  " + reason);
                super.onClosed(webSocket, code, reason);
            }

            @Override public void onFailure(WebSocket webSocket, Throwable t, Response response) {
                Log.i("lin","--lin--*lin*--->   onFailure  ->  " + t.toString());
                super.onFailure(webSocket, t, response);
            }
        });

    }

    public void CreateOffer(String connectionId){
        if (localStream.audioTracks.size() > 0) {
            userListener.onAddLocalStream();
        }
        DotPeer peer = newPeer(mUserId,true);
        localPeer = peer;
        localPeer.connectionId = _connectionId;
        localPeer.addLocalStream(localStream);
        AudioMediaConstrains audioConstraints = new AudioMediaConstrains();
        localPeer.createOffer(audioConstraints);
    }

    public DotPeer  newPeer(String peerId, boolean local) {
        DotPeer peer = new DotPeer(this);
        peer.peerId = peerId;
        peer.local = local;

        if (_iceServers.size() == 0){
            Log.i("lin","--lin--*lin*--->   onClosed  ->   ice server error  !!!!!!");
        }else {
            Log.i("lin","--lin--*lin*--->   onClosed  ->   ice server size " + _iceServers.size());
        }

        PeerConnection.RTCConfiguration configuration = new PeerConnection.RTCConfiguration(_iceServers);
        configuration.bundlePolicy = MAXBUNDLE;
        configuration.rtcpMuxPolicy = REQUIRE;
        MediaConstraints constraints = DotEngineSDPFactory.connectionConstraints();
        PeerConnection peerConnection = peerConnectionFactory.createPeerConnection(configuration,constraints,peer);
        peer.peerConnection = peerConnection;
        peers.put(peerId,peer);
        return peer;
    }

    private AudioTrack createAudioTrack() {
        audioSource =  peerConnectionFactory.createAudioSource(new AudioMediaConstrains());
        localAudioTrack =  peerConnectionFactory.createAudioTrack("ARDAMSa0", audioSource);
        localAudioTrack.setEnabled(true);
        return localAudioTrack;
    }

    private void sendJoin(boolean reconnect){
        Log.i("lin","---*lin*--->   sendJoin false");
        JSONObject data = new JSONObject();
        try {
            data.put("app_key",mAuthon.getAppKey());
            data.put("room",mAuthon.getRoom());
            data.put("user_id",mAuthon.getUser_id());
            data.put("token",mAuthon.getToken());
            data.put("reconnect",reconnect);
        } catch (JSONException e) {
            Log.i("lin","---*lin*--->   sendJoin error");
            e.printStackTrace();
        }

        SignalingMessageModel message = new SignalingMessageModel(mAuthon.getUser_id(),"join",null,data);
        message.setFrom(mUserId);
        JSONObject json = message.toJson();
        String jsonString = json.toString();
        if (jsonString != null){
            Log.i("lin","---*lin*--->   sendJoin ...");
            mWebSocket.send(jsonString);
        }else {
            Log.i("lin","---*lin*--->   sendJoin ...    error");
        }

    }

    public void setupKeepLive(){
        if (timer == null) {
            timer = new Timer();
        }

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                sendKeepLive(mUserId);
            }
        }, 0, 20000);
    }

    public void shutdownKeepLive() {
        if (timer == null)
            return;
        timer.cancel();
    }

    public void sendKeepLive(String myUserId) {
        SignalingMessageModel message = new SignalingMessageModel(myUserId, "keeplive");
        message.setFrom(mUserId);
        JSONObject json = message.toJson();
        String jsonString = json.toString();
        mWebSocket.send(jsonString);
    }

    @Override public void onReceiveRemoteStream(DotPeer peer, MediaStream stream) {
        Log.i("lin","---*lin*--->  &&&&&&&&         onReceiveRemoteStream");

    }

    @Override public void onRemoveRemoteStream(DotPeer peer, MediaStream stream) {
        Log.i("lin","---*lin*--->  &&&&&&&&         onRemoveRemoteStream");

    }

    @Override public void onGotError(DotPeer peer, String error) {
        Log.i("lin","---*lin*--->  &&&&&&&&         onGotError  " + error);

    }

    @Override public void onGotStat(DotPeer peer, StatsReport[] stats) {
        Log.i("lin","---*lin*--->  &&&&&&&&         onGotStat");

    }

    @Override public void onChangeIceGatheringState(DotPeer peer, PeerConnection.IceGatheringState iceGatheringState) {
        Log.i("lin","---*lin*--->  &&&&&&&&         onGotStat");

    }

    @Override public void onGotIceCandidates(DotPeer peer, IceCandidate[] candidates) {
            Log.i("lin","---*lin*--->   收集到 candidates  ");
            Log.i("lin","---*lin*--->   candidates size "+ candidates.length);
        JSONArray ices = new JSONArray();

        for (IceCandidate ice : candidates){
            ices.put(DotEngineUtils.candidateToJSON(ice));
        }

        JSONObject data = new JSONObject();
        try {
            data.put("candidates",ices);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        SignalingMessageModel message = new SignalingMessageModel(null,"candidates",peer.peerId,peer.connectionId,data);
        message.setFrom(mUserId);
        JSONObject json = message.toJson();
        String jsonString = json.toString();
        mWebSocket.send(jsonString);







    }

    @Override public void onPeerChangeState(DotPeer peer, DotPeer.PeerStatus status) {
        Log.i("lin","---*lin*--->  &&&&&&&&         onPeerChangeState   " + status.toString());

    }

    @Override public void onGotSessionDescription(DotPeer peer, SessionDescription sdp) {
        Log.i("lin","---*lin*--->  &&&&&&&&         onGotSessionDescription");
        //localPeer.setRemoteAnswer(sdp);




    }

    @Override public void onHaveSdp(SessionDescription sdp) {

        //获取到offer
        //sdp.type
        //sdp.description
        JSONObject data2 = new JSONObject();
        try {
            data2.put("muted",false);
            data2.put("quality",8);
            data2.put("volume",80);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        JSONObject jsep = new JSONObject();
        try {
            String type = sdp.type.toString();
            jsep.put("type",type.toLowerCase());
            jsep.put("sdp",sdp.description);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        SignalingMessageModel message = new SignalingMessageModel(mUserId,"configure",_connectionId,jsep,data2);
        message.setFrom(mUserId);
        JSONObject json = message.toJson();
        String jsonString = json.toString();
        mWebSocket.send(jsonString);

    }
}
