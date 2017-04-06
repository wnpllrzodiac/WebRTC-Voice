package cc.dot.engine.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by linSir
 * date at 2017/4/4.
 * describe:
 */

public class SignalingMessageModel {

    private  String target;
    private  String from;
    private  String type;
    private  String connectionId;
    private JSONObject data;
    private  JSONObject jsep;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(String connectionId) {
        this.connectionId = connectionId;
    }

    public JSONObject getJsep() {
        return jsep;
    }

    public void setJsep(JSONObject jsep) {
        this.jsep = jsep;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }


    public  SignalingMessageModel(){

    }

    public SignalingMessageModel(String from, String type) {
        this.from = from;
        this.type = type;
    }

    public SignalingMessageModel(String from,String type,String connectionId,JSONObject jsep,JSONObject data){
        this.from = from;
        this.type = type;
        this.connectionId = connectionId;
        this.jsep = jsep;
        this.data = data;
    }


    public SignalingMessageModel(String from,String type,String connectionId,JSONObject data){
        this.from = from;
        this.type = type;
        this.connectionId = connectionId;
        this.jsep = jsep;
        this.data = data;
    }

    public SignalingMessageModel(String from, String type, String target, JSONObject data, JSONObject... jsep) {

        this.from = from;
        this.type = type;
        this.target = target;
        this.data = data;

        if (jsep.length == 1){
            this.setJsep(jsep[0]);
        }

    }


    public SignalingMessageModel(String from, String type, String target, String connectionId,JSONObject data, JSONObject... jsep) {

        this.from = from;
        this.type = type;
        this.target = target;
        this.connectionId = connectionId;
        this.data = data;

        if (jsep.length == 1) {
            this.setJsep(jsep[0]);
        }
    }

    public JSONObject toJson() {


        try {
            JSONObject json = new JSONObject();
            json.put("type",this.type);

            if (this.getFrom() != null){
                json.put("from",this.from);
            }
            if (this.getTarget() != null){
                json.put("target",this.target);
            }
            if (this.getConnectionId() != null){
                json.put("connectionId",this.connectionId);
            }
            if (this.getData() != null){
                json.put("data",this.data);
            }
            if (this.getJsep() != null){
                json.put("jsep",this.getJsep());
            }

            return json;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

}
