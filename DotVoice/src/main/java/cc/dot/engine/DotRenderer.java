package cc.dot.engine;

import android.content.Context;
import android.util.AttributeSet;

import org.webrtc.EglBase;
import org.webrtc.MediaStream;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoRenderer;
import org.webrtc.VideoTrack;

/**
 * Created by linSir
 * date at 2017/4/4.
 * describe:
 */

public class DotRenderer extends SurfaceViewRenderer {


    public DotRenderer(Context context, EglBase.Context glContext) {
        super(context);
        this.init(glContext, null);
    }

    public DotRenderer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void renderFrame(VideoRenderer.I420Frame frame) {
        super.renderFrame(frame);
    }


    public void setMediaStream(MediaStream mediaStream){

        if (mediaStream.videoTracks.size() > 0){
            VideoTrack videoTrack = mediaStream.videoTracks.getFirst();

            videoTrack.addRenderer(new VideoRenderer(this));

        }
    }
}

