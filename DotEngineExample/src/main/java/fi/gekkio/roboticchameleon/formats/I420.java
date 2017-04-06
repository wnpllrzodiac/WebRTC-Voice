package fi.gekkio.roboticchameleon.formats;

import java.nio.ByteBuffer;

import fi.gekkio.roboticchameleon.lowlevel.RoboticChameleonJNI;

public final class I420 {

    public static final I420 INSTANCE = new I420();

    private I420() {
    }

    public void toARGB(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height) {

        RoboticChameleonJNI.I420ToARGB(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstARGB, dstStrideARGB,
            width, height);
    }

    public void toARGB(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height) {

        RoboticChameleonJNI.I420ToARGB(
            srcI420, srcStrideY, srcStrideU, srcStrideV,
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

        RoboticChameleonJNI.I420Copy(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

    public void toI420(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I420Copy(
            srcI420, srcStrideY, srcStrideU, srcStrideV,
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

        RoboticChameleonJNI.I420Copy(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstI420, dstStrideY, dstStrideU, dstStrideV,
            width, height);
    }

    public void toI420(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I420Copy(
            srcI420, srcStrideY, srcStrideU, srcStrideV,
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

        RoboticChameleonJNI.I420ToI422(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

    public void toI422(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I420ToI422(
            srcI420, srcStrideY, srcStrideU, srcStrideV,
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

        RoboticChameleonJNI.I420ToI422(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstI422, dstStrideY, dstStrideU, dstStrideV,
            width, height);
    }

    public void toI422(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstI422, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I420ToI422(
            srcI420, srcStrideY, srcStrideU, srcStrideV,
            dstI422, dstStrideY, dstStrideU, dstStrideV,
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

        RoboticChameleonJNI.I420ToI444(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

    public void toI444(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I420ToI444(
            srcI420, srcStrideY, srcStrideU, srcStrideV,
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

        RoboticChameleonJNI.I420ToI444(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstI444, dstStrideY, dstStrideU, dstStrideV,
            width, height);
    }

    public void toI444(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstI444, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I420ToI444(
            srcI420, srcStrideY, srcStrideU, srcStrideV,
            dstI444, dstStrideY, dstStrideU, dstStrideV,
            width, height);
    }

    public void toI411(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I420ToI411(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

    public void toI411(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I420ToI411(
            srcI420, srcStrideY, srcStrideU, srcStrideV,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

    public void toI411(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstI411, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I420ToI411(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstI411, dstStrideY, dstStrideU, dstStrideV,
            width, height);
    }

    public void toI411(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstI411, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height) {

        RoboticChameleonJNI.I420ToI411(
            srcI420, srcStrideY, srcStrideU, srcStrideV,
            dstI411, dstStrideY, dstStrideU, dstStrideV,
            width, height);
    }

    public void toNV12(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstUV, int dstStrideUV,
        int width, int height) {

        RoboticChameleonJNI.I420ToNV12(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstY, dstStrideY,
            dstUV, dstStrideUV,
            width, height);
    }

    public void toNV12(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstUV, int dstStrideUV,
        int width, int height) {

        RoboticChameleonJNI.I420ToNV12(
            srcI420, srcStrideY, srcStrideU, srcStrideV,
            dstY, dstStrideY,
            dstUV, dstStrideUV,
            width, height);
    }

    public void toNV12(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstNV12, int dstStrideY, int dstStrideUV,
        int width, int height) {

        RoboticChameleonJNI.I420ToNV12(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstNV12, dstStrideY, dstStrideUV,
            width, height);
    }

    public void toNV12(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstNV12, int dstStrideY, int dstStrideUV,
        int width, int height) {

        RoboticChameleonJNI.I420ToNV12(
            srcI420, srcStrideY, srcStrideU, srcStrideV,
            dstNV12, dstStrideY, dstStrideUV,
            width, height);
    }

    public void toNV21(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstVU, int dstStrideVU,
        int width, int height) {

        RoboticChameleonJNI.I420ToNV21(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstY, dstStrideY,
            dstVU, dstStrideVU,
            width, height);
    }

    public void toNV21(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstVU, int dstStrideVU,
        int width, int height) {

        RoboticChameleonJNI.I420ToNV21(
            srcI420, srcStrideY, srcStrideU, srcStrideV,
            dstY, dstStrideY,
            dstVU, dstStrideVU,
            width, height);
    }

    public void toNV21(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstNV21, int dstStrideY, int dstStrideVU,
        int width, int height) {

        RoboticChameleonJNI.I420ToNV21(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstNV21, dstStrideY, dstStrideVU,
            width, height);
    }

    public void toNV21(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstNV21, int dstStrideY, int dstStrideVU,
        int width, int height) {

        RoboticChameleonJNI.I420ToNV21(
            srcI420, srcStrideY, srcStrideU, srcStrideV,
            dstNV21, dstStrideY, dstStrideVU,
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

        RoboticChameleonJNI.I420Copy(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstY, dstStrideY,
            dstU, dstStrideU,
            dstV, dstStrideV,
            width, height);
    }

    public void toYUY2(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstYUY2, int dstStrideYUY2,
        int width, int height) {

        RoboticChameleonJNI.I420ToYUY2(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstYUY2, dstStrideYUY2,
            width, height);
    }

    public void toYUY2(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstYUY2, int dstStrideYUY2,
        int width, int height) {

        RoboticChameleonJNI.I420ToYUY2(
            srcI420, srcStrideY, srcStrideU, srcStrideV,
            dstYUY2, dstStrideYUY2,
            width, height);
    }

    public void toUYVY(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstUYVY, int dstStrideUYVY,
        int width, int height) {

        RoboticChameleonJNI.I420ToUYVY(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstUYVY, dstStrideUYVY,
            width, height);
    }

    public void toUYVY(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstUYVY, int dstStrideUYVY,
        int width, int height) {

        RoboticChameleonJNI.I420ToUYVY(
            srcI420, srcStrideY, srcStrideU, srcStrideV,
            dstUYVY, dstStrideUYVY,
            width, height);
    }

    public void toBGRA(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstBGRA, int dstStrideBGRA,
        int width, int height) {

        RoboticChameleonJNI.I420ToBGRA(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstBGRA, dstStrideBGRA,
            width, height);
    }

    public void toBGRA(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstBGRA, int dstStrideBGRA,
        int width, int height) {

        RoboticChameleonJNI.I420ToBGRA(
            srcI420, srcStrideY, srcStrideU, srcStrideV,
            dstBGRA, dstStrideBGRA,
            width, height);
    }

    public void toABGR(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstABGR, int dstStrideABGR,
        int width, int height) {

        RoboticChameleonJNI.I420ToABGR(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstABGR, dstStrideABGR,
            width, height);
    }

    public void toABGR(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstABGR, int dstStrideABGR,
        int width, int height) {

        RoboticChameleonJNI.I420ToABGR(
            srcI420, srcStrideY, srcStrideU, srcStrideV,
            dstABGR, dstStrideABGR,
            width, height);
    }

    public void toRGBA(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstRGBA, int dstStrideRGBA,
        int width, int height) {

        RoboticChameleonJNI.I420ToRGBA(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstRGBA, dstStrideRGBA,
            width, height);
    }

    public void toRGBA(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstRGBA, int dstStrideRGBA,
        int width, int height) {

        RoboticChameleonJNI.I420ToRGBA(
            srcI420, srcStrideY, srcStrideU, srcStrideV,
            dstRGBA, dstStrideRGBA,
            width, height);
    }

    public void toRGB24(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstRGB24, int dstStrideRGB24,
        int width, int height) {

        RoboticChameleonJNI.I420ToRGB24(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstRGB24, dstStrideRGB24,
            width, height);
    }

    public void toRGB24(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstRGB24, int dstStrideRGB24,
        int width, int height) {

        RoboticChameleonJNI.I420ToRGB24(
            srcI420, srcStrideY, srcStrideU, srcStrideV,
            dstRGB24, dstStrideRGB24,
            width, height);
    }

    public void toRAW(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstRAW, int dstStrideRAW,
        int width, int height) {

        RoboticChameleonJNI.I420ToRAW(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstRAW, dstStrideRAW,
            width, height);
    }

    public void toRAW(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstRAW, int dstStrideRAW,
        int width, int height) {

        RoboticChameleonJNI.I420ToRAW(
            srcI420, srcStrideY, srcStrideU, srcStrideV,
            dstRAW, dstStrideRAW,
            width, height);
    }

    public void toRGB565(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstRGB565, int dstStrideRGB565,
        int width, int height) {

        RoboticChameleonJNI.I420ToRGB565(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstRGB565, dstStrideRGB565,
            width, height);
    }

    public void toRGB565(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstRGB565, int dstStrideRGB565,
        int width, int height) {

        RoboticChameleonJNI.I420ToRGB565(
            srcI420, srcStrideY, srcStrideU, srcStrideV,
            dstRGB565, dstStrideRGB565,
            width, height);
    }

    public void toARGB1555(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstARGB1555, int dstStrideARGB1555,
        int width, int height) {

        RoboticChameleonJNI.I420ToARGB1555(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstARGB1555, dstStrideARGB1555,
            width, height);
    }

    public void toARGB1555(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstARGB1555, int dstStrideARGB1555,
        int width, int height) {

        RoboticChameleonJNI.I420ToARGB1555(
            srcI420, srcStrideY, srcStrideU, srcStrideV,
            dstARGB1555, dstStrideARGB1555,
            width, height);
    }

    public void toARGB4444(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstARGB4444, int dstStrideARGB4444,
        int width, int height) {

        RoboticChameleonJNI.I420ToARGB4444(
            srcY, srcStrideY,
            srcU, srcStrideU,
            srcV, srcStrideV,
            dstARGB4444, dstStrideARGB4444,
            width, height);
    }

    public void toARGB4444(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstARGB4444, int dstStrideARGB4444,
        int width, int height) {

        RoboticChameleonJNI.I420ToARGB4444(
            srcI420, srcStrideY, srcStrideU, srcStrideV,
            dstARGB4444, dstStrideARGB4444,
            width, height);
    }

}
