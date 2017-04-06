package fi.gekkio.roboticchameleon.formats;

import java.nio.ByteBuffer;

import fi.gekkio.roboticchameleon.lowlevel.RoboticChameleonJNI;

public final class I400 {

    public static final I400 INSTANCE = new I400();

    private I400() {
    }

    public void toARGB(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height) {

        RoboticChameleonJNI.I400ToARGB(
            srcY, srcStrideY,
            dstARGB, dstStrideARGB,
            width, height);
    }

    public void toI400(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer dstY, int dstStrideY,
        int width, int height) {

        RoboticChameleonJNI.I400Copy(
            srcY, srcStrideY,
            dstY, dstStrideY,
            width, height);
    }

    public void toI420(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I400ToI420(
            srcY, srcStrideY,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

    public void toI420(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I400ToI420(
            srcY, srcStrideY,
            dstI420, dstStrideY, dstStrideU, dstStrideV,
            width, height);
    }

    public void toYV12(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstV, int dstStrideV,
        ByteBuffer dstU, int dstStrideU,
        int width, int height) {

        RoboticChameleonJNI.I400ToI420(
            srcY, srcStrideY,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

}
