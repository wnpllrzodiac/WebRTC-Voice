package fi.gekkio.roboticchameleon.formats;

import java.nio.ByteBuffer;

import fi.gekkio.roboticchameleon.lowlevel.RoboticChameleonJNI;

public final class ABGR {

    public static final ABGR INSTANCE = new ABGR();

    private ABGR() {
    }

    public void toARGB(
        ByteBuffer srcABGR, int srcStrideABGR,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height) {

        RoboticChameleonJNI.ABGRToARGB(
            srcABGR, srcStrideABGR,
            dstARGB, dstStrideARGB,
            width, height);
    }

    public void toI420(
        ByteBuffer srcABGR, int srcStrideABGR,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.ABGRToI420(
            srcABGR, srcStrideABGR,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

    public void toI420(
        ByteBuffer srcABGR, int srcStrideABGR,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.ABGRToI420(
            srcABGR, srcStrideABGR,
            dstI420, dstStrideY, dstStrideU, dstStrideV,
            width, height);
    }

    public void toYV12(
        ByteBuffer srcABGR, int srcStrideABGR,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstV, int dstStrideV,
        ByteBuffer dstU, int dstStrideU,
        int width, int height) {

        RoboticChameleonJNI.ABGRToI420(
            srcABGR, srcStrideABGR,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

}
