package fi.gekkio.roboticchameleon.formats;

import java.nio.ByteBuffer;

import fi.gekkio.roboticchameleon.lowlevel.RoboticChameleonJNI;

public final class RGB24 {

    public static final RGB24 INSTANCE = new RGB24();

    private RGB24() {
    }

    public void toARGB(
        ByteBuffer srcRGB24, int srcStrideRGB24,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height) {

        RoboticChameleonJNI.RGB24ToARGB(
            srcRGB24, srcStrideRGB24,
            dstARGB, dstStrideARGB,
            width, height);
    }

    public void toI420(
        ByteBuffer srcRGB24, int srcStrideRGB24,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.RGB24ToI420(
            srcRGB24, srcStrideRGB24,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

    public void toI420(
        ByteBuffer srcRGB24, int srcStrideRGB24,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.RGB24ToI420(
            srcRGB24, srcStrideRGB24,
            dstI420, dstStrideY, dstStrideU, dstStrideV,
            width, height);
    }

    public void toYV12(
        ByteBuffer srcRGB24, int srcStrideRGB24,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstV, int dstStrideV,
        ByteBuffer dstU, int dstStrideU,
        int width, int height) {

        RoboticChameleonJNI.RGB24ToI420(
            srcRGB24, srcStrideRGB24,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

}
