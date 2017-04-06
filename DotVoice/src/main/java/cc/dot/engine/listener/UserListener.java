package cc.dot.engine.listener;

/**
 * Created by linSir
 * date at 2017/4/4.
 * describe:
 */

public interface UserListener {

    void onJoind(String user);

    void onReceivePublishers();

    void otherJoinInRoom(String room);

    void onAddLocalStream();

    void onError();


}
