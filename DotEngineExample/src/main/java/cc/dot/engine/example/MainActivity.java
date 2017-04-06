package cc.dot.engine.example;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.callback.StringCallback;

import cc.dot.engine.DotVoice;
import cc.dot.engine.listener.UserListener;

/**
 * Created by linSir
 * date at 2017/4/4.
 * describe:
 */

public class MainActivity extends Activity implements UserListener
{

    private String mToken;
    private TextView mId;
    private String myId;
    private TextView begin;
    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("lin","---*lin*--->   开始执行获取token的命令");
        myId = "mx" + String.valueOf((int)(Math.random()*10000));
        mId = (TextView) findViewById(R.id.m_id);
        begin = (TextView) findViewById(R.id.begin);
        mId.setText(myId);
        DotVoice.getDotVoice().setContext(this);

        begin.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                DotVoice.getDotVoice().getToken(myId,new StringCallback() {
                    @Override public void onError(Request request, Exception e) {
                        Log.i("lin","---*lin*--->   获取token失败   ->  " + e.toString());
                    }

                    @Override public void onResponse(String response) {
                        Log.i("lin","---*lin*--->   获取token成功   " + response);
                        mToken = response.split("\"")[3];
                        Log.i("lin","---*lin*--->   解析后的token   " + mToken);
                        DotVoice.getDotVoice().joinRoom(mToken);
                    }
                },MainActivity.this);
            }
        });


    }

    @Override public void onJoind(String user) {
        if (myId.equals(user)){
            Toast.makeText(MainActivity.this,"我自己加入房间已经成功了",Toast.LENGTH_SHORT).show();
            //DotVoice.getDotVoice().publish();



        }
        Log.i("lin","---*lin*--->   用户加入 id " + user);
    }

    @Override public void onReceivePublishers() {
        Log.i("lin","---*lin*--->   收到有人发布  ");

    }

    @Override public void otherJoinInRoom(String room) {
        Log.i("lin","---*lin*--->   有人加入我们的房间   "+room);
    }

    @Override public void onAddLocalStream() {
        Log.i("lin","---*lin*--->  有本地流加入 ");
    }

    @Override public void onError() {
        Toast.makeText(MainActivity.this,"初始化失败",Toast.LENGTH_SHORT).show();
    }
}
