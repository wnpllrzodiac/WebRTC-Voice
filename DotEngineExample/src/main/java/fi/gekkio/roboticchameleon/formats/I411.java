package fi.gekkio.roboticchameleon.formats;

import java.nio.ByteBuffer;

import fi.gekkio.roboticchameleon.lowlevel.RoboticChameleonJNI;

public final class I411 {

    public static final I411 INSTANCE = new I411();

    private I411() {
    }

    public void toARGB(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height) {

        RoboticChameleonJNI.I411ToARGB(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstARGB, dstStrideARGB,
            width, height);
    }

    public void toARGB(
        ByteBuffer srcI411, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height) {

        RoboticChameleonJNI.I411ToARGB(
            srcI411, srcStrideY, srcStrideU, srcStrideV,
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

        RoboticChameleonJNI.I411ToI420(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

    public void toI420(
        ByteBuffer srcI411, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I411ToI420(
            srcI411, srcStrideY, srcStrideU, srcStrideV,
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

        RoboticChameleonJNI.I411ToI420(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstI420, dstStrideY, dstStrideU, dstStrideV,
            width, height);
    }

    public void toI420(
        ByteBuffer srcI411, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I411ToI420(
            srcI411, srcStrideY, srcStrideU, srcStrideV,
            dstI420, dstStrideY, dstStrideU, dstStrideV,
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

        RoboticChameleonJNI.I411ToI420(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

}
