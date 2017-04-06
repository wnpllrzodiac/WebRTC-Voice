package fi.gekkio.roboticchameleon.formats;

import java.nio.ByteBuffer;

import fi.gekkio.roboticchameleon.lowlevel.RoboticChameleonJNI;

public final class RGB565 {

    public static final RGB565 INSTANCE = new RGB565();

    private RGB565() {
    }

    public void toARGB(
        ByteBuffer srcRGB565, int srcStrideRGB565,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height) {

        RoboticChameleonJNI.RGB565ToARGB(
            srcRGB565, srcStrideRGB565,
            dstARGB, dstStrideARGB,
            width, height);
    }

    public void toI420(
        ByteBuffer srcRGB565, int srcStrideRGB565,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.RGB565ToI420(
            srcRGB565, srcStrideRGB565,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

    public void toI420(
        ByteBuffer srcRGB565, int srcStrideRGB565,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.RGB565ToI420(
            srcRGB565, srcStrideRGB565,
            dstI420, dstStrideY, dstStrideU, dstStrideV,
            width, height);
    }

    public void toYV12(
        ByteBuffer srcRGB565, int srcStrideRGB565,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstV, int dstStrideV,
        ByteBuffer dstU, int dstStrideU,
        int width, int height) {

        RoboticChameleonJNI.RGB565ToI420(
            srcRGB565, srcStrideRGB565,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

}
