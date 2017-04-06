package fi.gekkio.roboticchameleon.formats;

import java.nio.ByteBuffer;

import fi.gekkio.roboticchameleon.lowlevel.RoboticChameleonJNI;

public final class ARGB4444 {

    public static final ARGB4444 INSTANCE = new ARGB4444();

    private ARGB4444() {
    }

    public void toARGB(
        ByteBuffer srcARGB4444, int srcStrideARGB4444,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height) {

        RoboticChameleonJNI.ARGB4444ToARGB(
            srcARGB4444, srcStrideARGB4444,
            dstARGB, dstStrideARGB,
            width, height);
    }

    public void toI420(
        ByteBuffer srcARGB4444, int srcStrideARGB4444,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.ARGB4444ToI420(
            srcARGB4444, srcStrideARGB4444,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

    public void toI420(
        ByteBuffer srcARGB4444, int srcStrideARGB4444,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.ARGB4444ToI420(
            srcARGB4444, srcStrideARGB4444,
            dstI420, dstStrideY, dstStrideU, dstStrideV,
            width, height);
    }

    public void toYV12(
        ByteBuffer srcARGB4444, int srcStrideARGB4444,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstV, int dstStrideV,
        ByteBuffer dstU, int dstStrideU,
        int width, int height) {

        RoboticChameleonJNI.ARGB4444ToI420(
            srcARGB4444, srcStrideARGB4444,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

}
