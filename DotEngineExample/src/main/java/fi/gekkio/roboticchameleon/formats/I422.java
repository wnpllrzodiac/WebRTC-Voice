package fi.gekkio.roboticchameleon.formats;

import java.nio.ByteBuffer;

import fi.gekkio.roboticchameleon.lowlevel.RoboticChameleonJNI;

public final class I422 {

    public static final I422 INSTANCE = new I422();

    private I422() {
    }

    public void toARGB(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height) {

        RoboticChameleonJNI.I422ToARGB(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstARGB, dstStrideARGB,
            width, height);
    }

    public void toARGB(
        ByteBuffer srcI422, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height) {

        RoboticChameleonJNI.I422ToARGB(
            srcI422, srcStrideY, srcStrideU, srcStrideV,
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

        RoboticChameleonJNI.I422ToI420(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

    public void toI420(
        ByteBuffer srcI422, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I422ToI420(
            srcI422, srcStrideY, srcStrideU, srcStrideV,
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

        RoboticChameleonJNI.I422ToI420(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstI420, dstStrideY, dstStrideU, dstStrideV,
            width, height);
    }

    public void toI420(
        ByteBuffer srcI422, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I422ToI420(
            srcI422, srcStrideY, srcStrideU, srcStrideV,
            dstI420, dstStrideY, dstStrideU, dstStrideV,
            width, height);
    }

    public void toI422(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I422Copy(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

    public void toI422(
        ByteBuffer srcI422, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I422Copy(
            srcI422, srcStrideY, srcStrideU, srcStrideV,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

    public void toI422(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstI422, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I422Copy(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstI422, dstStrideY, dstStrideU, dstStrideV,
            width, height);
    }

    public void toI422(
        ByteBuffer srcI422, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstI422, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I422Copy(
            srcI422, srcStrideY, srcStrideU, srcStrideV,
            dstI422, dstStrideY, dstStrideU, dstStrideV,
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

        RoboticChameleonJNI.I422ToI420(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

}
