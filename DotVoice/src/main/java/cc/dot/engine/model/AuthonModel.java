package cc.dot.engine.model;

import android.text.TextUtils;
import android.util.Base64;

import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.Logging;

import java.io.UnsupportedEncodingException;

/**
 * Created by linSir
 * date at 2017/4/4.
 * describe:
 */

public class AuthonModel {

    private String wsUrl;
    private String user_id;
    private String room;
    private String token;
    private String app_key;


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }



    public String getWsUrl() {
        return wsUrl;
    }

    public void setWsUrl(String wsUrl) {
        this.wsUrl = wsUrl;
    }

    public  String getToken() { return token;}

    public void setToken(String token) {this.token = token;}

    public  String getAppKey() { return app_key; }

    public  void  setAppKey(String  app_key) { this.app_key = app_key; }


    public static  AuthonModel parseToken(String dotToken) {

        String[] arrays = dotToken.split("[.]");
        if (arrays.length != 3) {
            Logging.e("DotEngineUtils", "decoderDotToken: 非法的 token ");
            return null;
        }
        String item = arrays[1];
        String json;
        try {
            byte[] base64 = Base64.decode(item, Base64.URL_SAFE);
            json = new String(base64, "UTF-8");

            Logging.d("DotEngineUtils", "decoderDotToken: jons=" + json);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
        if (TextUtils.isEmpty(json)) {
            return null;
        }

        AuthonModel auth = new AuthonModel();

        try {
            JSONObject jsonObject = new JSONObject(json);
            auth.setRoom(jsonObject.optString("room"));
            auth.setWsUrl(jsonObject.optString("wsUrl"));
            auth.setUser_id(jsonObject.optString("user_id"));
            auth.setAppKey(jsonObject.optString("app_key"));
            auth.setToken(dotToken);
        } catch (JSONException e) {
            e.printStackTrace();

            return null;
        }

        return auth;
    }

}
