package cc.dot.engine.Utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.CameraEnumerationAndroid;
import org.webrtc.IceCandidate;
import org.webrtc.Logging;
import org.webrtc.PeerConnection;
import org.webrtc.SessionDescription;
import org.webrtc.StatsReport;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import cc.dot.engine.model.PeerMode;

/**
 * Created by linSir
 * date at 2017/4/4.
 * describe:
 */

public class DotEngineUtils {

    private String TAG = DotEngineUtils.class.getSimpleName();

    public static boolean checkCurrentEnvironment(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
            return false;
        }
        if (CameraEnumerationAndroid.getDeviceCount() < 1) {
            return false;
        }
        ActivityManager am = (ActivityManager) context.getSystemService("activity");
        ConfigurationInfo info = am.getDeviceConfigurationInfo();
        if (info.reqGlEsVersion < 0x00020000) {
            return false;
        }


        return true;
    }





    public static JSONObject statToJSON(StatsReport[] reports) {

        return null;
    }


    public static JSONObject sdpToJSON(SessionDescription sdp) {


        JSONObject data = new JSONObject();

        try {
            data.put("type",sdp.type.canonicalForm());
            data.put("sdp",sdp.description);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static JSONObject candidateToJSON(IceCandidate ice) {

        JSONObject candidate = new JSONObject();

        try {
            candidate.put("sdpMLineIndex", ice.sdpMLineIndex);
            candidate.put("sdpMid", ice.sdpMid);
            candidate.put("candidate", ice.sdp);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return candidate;
    }


    public static ArrayList<PeerMode> parsePeers(JSONArray data) {

        ArrayList<PeerMode> peers = new ArrayList<PeerMode>();
        try {

            for (int i=0; i < data.length(); i++){
                JSONObject object = data.getJSONObject(i);
                PeerMode peerMode = new PeerMode();
                peerMode.setId(object.getString("id"));
                peerMode.setPublished(object.getBoolean("published"));
                peers.add(peerMode);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return peers;
    }


    public static ArrayList<PeerConnection.IceServer> parseIceServer(JSONArray data){

        ArrayList<PeerConnection.IceServer> iceServers = new ArrayList<PeerConnection.IceServer>();

        try {
            JSONArray iceServerArray = data;

            for (int i = 0; i < iceServerArray.length(); i++) {
                JSONObject _o = null;

                _o = iceServerArray.getJSONObject(i);

                PeerConnection.IceServer server = new PeerConnection.IceServer(_o.getString("url"),
                        _o.optString("username", ""), _o.optString("credential", ""));
                iceServers.add(server);

                Logging.d("DotEngineUtils", server.toString());
            }
        } catch (JSONException e){
            e.printStackTrace();
        }

        return iceServers;
    }

}
