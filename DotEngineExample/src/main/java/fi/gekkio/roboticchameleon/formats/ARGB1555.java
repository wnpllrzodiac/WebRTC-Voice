package fi.gekkio.roboticchameleon.formats;

import java.nio.ByteBuffer;

import fi.gekkio.roboticchameleon.lowlevel.RoboticChameleonJNI;

public final class ARGB1555 {

    public static final ARGB1555 INSTANCE = new ARGB1555();

    private ARGB1555() {
    }

    public void toARGB(
        ByteBuffer srcARGB1555, int srcStrideARGB1555,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height) {

        RoboticChameleonJNI.ARGB1555ToARGB(
            srcARGB1555, srcStrideARGB1555,
            dstARGB, dstStrideARGB,
            width, height);
    }

    public void toI420(
        ByteBuffer srcARGB1555, int srcStrideARGB1555,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.ARGB1555ToI420(
            srcARGB1555, srcStrideARGB1555,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

    public void toI420(
        ByteBuffer srcARGB1555, int srcStrideARGB1555,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.ARGB1555ToI420(
            srcARGB1555, srcStrideARGB1555,
            dstI420, dstStrideY, dstStrideU, dstStrideV,
            width, height);
    }

    public void toYV12(
        ByteBuffer srcARGB1555, int srcStrideARGB1555,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstV, int dstStrideV,
        ByteBuffer dstU, int dstStrideU,
        int width, int height) {

        RoboticChameleonJNI.ARGB1555ToI420(
            srcARGB1555, srcStrideARGB1555,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

}
