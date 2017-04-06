package fi.gekkio.roboticchameleon.formats;

import java.nio.ByteBuffer;

import fi.gekkio.roboticchameleon.lowlevel.RoboticChameleonJNI;

public final class YV12 {

    public static final YV12 INSTANCE = new YV12();

    private YV12() {
    }

    public void toARGB(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height) {

        RoboticChameleonJNI.I420ToARGB(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstARGB, dstStrideARGB,
            width, height);
    }

    public void toI420(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I420Copy(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

    public void toYV12(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstV, int dstStrideV,
        ByteBuffer dstU, int dstStrideU,
        int width, int height) {

        RoboticChameleonJNI.I420Copy(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

}
