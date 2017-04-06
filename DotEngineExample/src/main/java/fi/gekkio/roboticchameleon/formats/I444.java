package fi.gekkio.roboticchameleon.formats;

import java.nio.ByteBuffer;

import fi.gekkio.roboticchameleon.lowlevel.RoboticChameleonJNI;

public final class I444 {

    public static final I444 INSTANCE = new I444();

    private I444() {
    }

    public void toARGB(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height) {

        RoboticChameleonJNI.I444ToARGB(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstARGB, dstStrideARGB,
            width, height);
    }

    public void toARGB(
        ByteBuffer srcI444, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height) {

        RoboticChameleonJNI.I444ToARGB(
            srcI444, srcStrideY, srcStrideU, srcStrideV,
            dstARGB, dstStrideARGB,
            width, height);
    }

    public void toI420(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I444ToI420(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

    public void toI420(
        ByteBuffer srcI444, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I444ToI420(
            srcI444, srcStrideY, srcStrideU, srcStrideV,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

    public void toI420(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I444ToI420(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstI420, dstStrideY, dstStrideU, dstStrideV,
            width, height);
    }

    public void toI420(
        ByteBuffer srcI444, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I444ToI420(
            srcI444, srcStrideY, srcStrideU, srcStrideV,
            dstI420, dstStrideY, dstStrideU, dstStrideV,
            width, height);
    }

    public void toI444(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I444Copy(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

    public void toI444(
        ByteBuffer srcI444, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I444Copy(
            srcI444, srcStrideY, srcStrideU, srcStrideV,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

    public void toI444(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstI444, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I444Copy(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstI444, dstStrideY, dstStrideU, dstStrideV,
            width, height);
    }

    public void toI444(
        ByteBuffer srcI444, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstI444, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I444Copy(
            srcI444, srcStrideY, srcStrideU, srcStrideV,
            dstI444, dstStrideY, dstStrideU, dstStrideV,
            width, height);
    }

    public void toYV12(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstV, int dstStrideV,
        ByteBuffer dstU, int dstStrideU,
        int width, int height) {

        RoboticChameleonJNI.I444ToI420(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

}
