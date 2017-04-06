package fi.gekkio.roboticchameleon.formats;

import java.nio.ByteBuffer;

import fi.gekkio.roboticchameleon.lowlevel.RoboticChameleonJNI;

public final class Q420 {

    public static final Q420 INSTANCE = new Q420();

    private Q420() {
    }

    public void toI420(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcYUY2, int srcStrideYUY2,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.Q420ToI420(
            srcY, srcStrideY,
            srcYUY2, srcStrideYUY2,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

    public void toI420(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcYUY2, int srcStrideYUY2,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.Q420ToI420(
            srcY, srcStrideY,
            srcYUY2, srcStrideYUY2,
            dstI420, dstStrideY, dstStrideU, dstStrideV,
            width, height);
    }

    public void toYV12(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcYUY2, int srcStrideYUY2,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstV, int dstStrideV,
        ByteBuffer dstU, int dstStrideU,
        int width, int height) {

        RoboticChameleonJNI.Q420ToI420(
            srcY, srcStrideY,
            srcYUY2, srcStrideYUY2,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

}
