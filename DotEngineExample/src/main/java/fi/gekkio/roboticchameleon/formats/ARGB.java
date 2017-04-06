package fi.gekkio.roboticchameleon.formats;

import java.nio.ByteBuffer;

import fi.gekkio.roboticchameleon.lowlevel.RoboticChameleonJNI;

public final class ARGB {

    public static final ARGB INSTANCE = new ARGB();

    private ARGB() {
    }

    public void toARGB(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height) {

        RoboticChameleonJNI.ARGBCopy(
            srcARGB, srcStrideARGB,
            dstARGB, dstStrideARGB,
            width, height);
    }

    public void toI420(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.ARGBToI420(
            srcARGB, srcStrideARGB,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

    public void toI420(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.ARGBToI420(
            srcARGB, srcStrideARGB,
            dstI420, dstStrideY, dstStrideU, dstStrideV,
            width, height);
    }

    public void toI422(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.ARGBToI422(
            srcARGB, srcStrideARGB,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

    public void toI422(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstI422, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.ARGBToI422(
            srcARGB, srcStrideARGB,
            dstI422, dstStrideY, dstStrideU, dstStrideV,
            width, height);
    }

    public void toI444(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.ARGBToI444(
            srcARGB, srcStrideARGB,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

    public void toI444(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstI444, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.ARGBToI444(
            srcARGB, srcStrideARGB,
            dstI444, dstStrideY, dstStrideU, dstStrideV,
            width, height);
    }

    public void toI411(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.ARGBToI411(
            srcARGB, srcStrideARGB,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

    public void toI411(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstI411, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.ARGBToI411(
            srcARGB, srcStrideARGB,
            dstI411, dstStrideY, dstStrideU, dstStrideV,
            width, height);
    }

    public void toI400(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstY, int dstStrideY,
        int width, int height) {

        RoboticChameleonJNI.ARGBToI400(
            srcARGB, srcStrideARGB,
            dstY, dstStrideY,
            width, height);
    }

    public void toNV12(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstUV, int dstStrideUV,
        int width, int height) {

        RoboticChameleonJNI.ARGBToNV12(
            srcARGB, srcStrideARGB,
            dstY, dstStrideY,
            dstUV, dstStrideUV,
            width, height);
    }

    public void toNV12(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstNV12, int dstStrideY, int dstStrideUV,
        int width, int height) {

        RoboticChameleonJNI.ARGBToNV12(
            srcARGB, srcStrideARGB,
            dstNV12, dstStrideY, dstStrideUV,
            width, height);
    }

    public void toNV21(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstVU, int dstStrideVU,
        int width, int height) {

        RoboticChameleonJNI.ARGBToNV21(
            srcARGB, srcStrideARGB,
            dstY, dstStrideY,
            dstVU, dstStrideVU,
            width, height);
    }

    public void toNV21(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstNV21, int dstStrideY, int dstStrideVU,
        int width, int height) {

        RoboticChameleonJNI.ARGBToNV21(
            srcARGB, srcStrideARGB,
            dstNV21, dstStrideY, dstStrideVU,
            width, height);
    }

    public void toYUY2(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstYUY2, int dstStrideYUY2,
        int width, int height) {

        RoboticChameleonJNI.ARGBToYUY2(
            srcARGB, srcStrideARGB,
            dstYUY2, dstStrideYUY2,
            width, height);
    }

    public void toUYVY(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstUYVY, int dstStrideUYVY,
        int width, int height) {

        RoboticChameleonJNI.ARGBToUYVY(
            srcARGB, srcStrideARGB,
            dstUYVY, dstStrideUYVY,
            width, height);
    }

    public void toBGRA(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstBGRA, int dstStrideBGRA,
        int width, int height) {

        RoboticChameleonJNI.BGRAToARGB(
            srcARGB, srcStrideARGB,
            dstBGRA, dstStrideBGRA,
            width, height);
    }

    public void toABGR(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstABGR, int dstStrideABGR,
        int width, int height) {

        RoboticChameleonJNI.ABGRToARGB(
            srcARGB, srcStrideARGB,
            dstABGR, dstStrideABGR,
            width, height);
    }

    public void toRGBA(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstRGBA, int dstStrideRGBA,
        int width, int height) {

        RoboticChameleonJNI.ARGBToRGBA(
            srcARGB, srcStrideARGB,
            dstRGBA, dstStrideRGBA,
            width, height);
    }

    public void toRGB24(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstRGB24, int dstStrideRGB24,
        int width, int height) {

        RoboticChameleonJNI.ARGBToRGB24(
            srcARGB, srcStrideARGB,
            dstRGB24, dstStrideRGB24,
            width, height);
    }

    public void toRAW(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstRAW, int dstStrideRAW,
        int width, int height) {

        RoboticChameleonJNI.ARGBToRAW(
            srcARGB, srcStrideARGB,
            dstRAW, dstStrideRAW,
            width, height);
    }

    public void toRGB565(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstRGB565, int dstStrideRGB565,
        int width, int height) {

        RoboticChameleonJNI.ARGBToRGB565(
            srcARGB, srcStrideARGB,
            dstRGB565, dstStrideRGB565,
            width, height);
    }

    public void toARGB1555(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstARGB1555, int dstStrideARGB1555,
        int width, int height) {

        RoboticChameleonJNI.ARGBToARGB1555(
            srcARGB, srcStrideARGB,
            dstARGB1555, dstStrideARGB1555,
            width, height);
    }

    public void toARGB4444(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstARGB4444, int dstStrideARGB4444,
        int width, int height) {

        RoboticChameleonJNI.ARGBToARGB4444(
            srcARGB, srcStrideARGB,
            dstARGB4444, dstStrideARGB4444,
            width, height);
    }

    public void toYV12(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstV, int dstStrideV,
        ByteBuffer dstU, int dstStrideU,
        int width, int height) {

        RoboticChameleonJNI.ARGBToI420(
            srcARGB, srcStrideARGB,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

}
