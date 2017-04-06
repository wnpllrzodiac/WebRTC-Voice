package fi.gekkio.roboticchameleon.lowlevel;

import java.nio.ByteBuffer;

public final class RoboticChameleonJNI {

    static {
        System.loadLibrary("robotic-chameleon");
    }

    private RoboticChameleonJNI() {
    }

    // Conversions to I420

    public static native void I420Copy(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void I420Copy(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void I420Copy(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void I420Copy(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void I422ToI420(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void I422ToI420(
        ByteBuffer srcI422, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void I422ToI420(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void I422ToI420(
        ByteBuffer srcI422, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void I444ToI420(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void I444ToI420(
        ByteBuffer srcI444, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void I444ToI420(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void I444ToI420(
        ByteBuffer srcI444, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void I411ToI420(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void I411ToI420(
        ByteBuffer srcI411, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void I411ToI420(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void I411ToI420(
        ByteBuffer srcI411, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void I400ToI420(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void I400ToI420(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void NV12ToI420(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcUV, int srcStrideUV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void NV12ToI420(
        ByteBuffer srcNV12, int srcStrideY, int srcStrideUV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void NV12ToI420(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcUV, int srcStrideUV,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void NV12ToI420(
        ByteBuffer srcNV12, int srcStrideY, int srcStrideUV,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void NV21ToI420(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcVU, int srcStrideVU,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void NV21ToI420(
        ByteBuffer srcNV21, int srcStrideY, int srcStrideUV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void NV21ToI420(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcUV, int srcStrideUV,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void NV21ToI420(
        ByteBuffer srcNV21, int srcStrideY, int srcStrideUV,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void YUY2ToI420(
        ByteBuffer srcYUY2, int srcStrideYUY2,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void YUY2ToI420(
        ByteBuffer srcYUY2, int srcStrideYUY2,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void UYVYToI420(
        ByteBuffer srcUYVY, int srcStrideUYVY,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void UYVYToI420(
        ByteBuffer srcUYVY, int srcStrideUYVY,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void M420ToI420(
        ByteBuffer srcM420, int srcStrideM420,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void M420ToI420(
        ByteBuffer srcM420, int srcStrideM420,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void Q420ToI420(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcYUY2, int srcStrideYUY2,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void Q420ToI420(
        ByteBuffer srcQ420, int srcStrideY, int srcStrideYUY2,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void Q420ToI420(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcYUY2, int srcStrideYUY2,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void Q420ToI420(
        ByteBuffer srcQ420, int srcStrideY, int srcStrideYUY2,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void ARGBToI420(
        ByteBuffer srcFrame, int srcStrideFrame,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void ARGBToI420(
        ByteBuffer srcFrame, int srcStrideFrame,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void BGRAToI420(
        ByteBuffer srcFrame, int srcStrideFrame,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void BGRAToI420(
        ByteBuffer srcFrame, int srcStrideFrame,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void ABGRToI420(
        ByteBuffer srcFrame, int srcStrideFrame,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void ABGRToI420(
        ByteBuffer srcFrame, int srcStrideFrame,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void RGBAToI420(
        ByteBuffer srcFrame, int srcStrideFrame,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void RGBAToI420(
        ByteBuffer srcFrame, int srcStrideFrame,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void RGB24ToI420(
        ByteBuffer srcFrame, int srcStrideFrame,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void RGB24ToI420(
        ByteBuffer srcFrame, int srcStrideFrame,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void RAWToI420(
        ByteBuffer srcFrame, int srcStrideFrame,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void RAWToI420(
        ByteBuffer srcFrame, int srcStrideFrame,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void RGB565ToI420(
        ByteBuffer srcFrame, int srcStrideFrame,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void RGB565ToI420(
        ByteBuffer srcFrame, int srcStrideFrame,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void ARGB1555ToI420(
        ByteBuffer srcFrame, int srcStrideFrame,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void ARGB1555ToI420(
        ByteBuffer srcFrame, int srcStrideFrame,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void ARGB4444ToI420(
        ByteBuffer srcFrame, int srcStrideFrame,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void ARGB4444ToI420(
        ByteBuffer srcFrame, int srcStrideFrame,
        ByteBuffer dstI420, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    // Conversions to ARGB

    public static native void I420ToARGB(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height);

    public static native void I420ToARGB(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height);

    public static native void I422ToARGB(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height);

    public static native void I422ToARGB(
        ByteBuffer srcI422, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height);

    public static native void I444ToARGB(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height);

    public static native void I444ToARGB(
        ByteBuffer srcI444, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height);

    public static native void I411ToARGB(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height);

    public static native void I411ToARGB(
        ByteBuffer srcI411, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height);

    public static native void I400ToARGB(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height);

    public static native void NV12ToARGB(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcUV, int srcStrideUV,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height);

    public static native void NV12ToARGB(
        ByteBuffer srcNV12, int srcStrideY, int srcStrideUV,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height);

    public static native void NV21ToARGB(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcVU, int srcStrideVU,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height);

    public static native void NV21ToARGB(
        ByteBuffer srcNV21, int srcStrideY, int srcStrideVU,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height);

    public static native void YUY2ToARGB(
        ByteBuffer srcYUY2, int srcStrideYUY2,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height);

    public static native void UYVYToARGB(
        ByteBuffer srcUYVY, int srcStrideUYVY,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height);

    public static native void M420ToARGB(
        ByteBuffer srcM420, int srcStrideM420,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height);

    // No Q420ToARGB

    public static native void ARGBCopy(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height);

    public static native void BGRAToARGB(
        ByteBuffer srcFrame, int srcStrideFrame,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height);

    public static native void ABGRToARGB(
        ByteBuffer srcFrame, int srcStrideFrame,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height);

    public static native void RGBAToARGB(
        ByteBuffer srcFrame, int srcStrideFrame,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height);

    public static native void RGB24ToARGB(
        ByteBuffer srcFrame, int srcStrideFrame,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height);

    public static native void RAWToARGB(
        ByteBuffer srcFrame, int srcStrideFrame,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height);

    public static native void RGB565ToARGB(
        ByteBuffer srcFrame, int srcStrideFrame,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height);

    public static native void ARGB1555ToARGB(
        ByteBuffer srcFrame, int srcStrideFrame,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height);

    public static native void ARGB4444ToARGB(
        ByteBuffer srcFrame, int srcStrideFrame,
        ByteBuffer dstARGB, int dstStrideARGB,
        int width, int height);

    // = I420Copy

    public static native void I420ToI422(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void I420ToI422(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void I420ToI422(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstI422, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void I420ToI422(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstI422, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void I420ToI444(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void I420ToI444(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void I420ToI444(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstI444, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void I420ToI444(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstI444, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void I420ToI411(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void I420ToI411(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void I420ToI411(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstI411, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void I420ToI411(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstI411, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    // = I400Copy

    public static native void I420ToNV12(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstUV, int dstStrideUV,
        int width, int height);

    public static native void I420ToNV12(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstUV, int dstStrideUV,
        int width, int height);

    public static native void I420ToNV12(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstNV12, int dstStrideY, int dstStrideUV,
        int width, int height);

    public static native void I420ToNV12(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstNV12, int dstStrideY, int dstStrideUV,
        int width, int height);

    public static native void I420ToNV21(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstVU, int dstStrideVU,
        int width, int height);

    public static native void I420ToNV21(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstVU, int dstStrideVU,
        int width, int height);

    public static native void I420ToNV21(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstNV21, int dstStrideY, int dstStrideVU,
        int width, int height);

    public static native void I420ToNV21(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstNV21, int dstStrideY, int dstStrideVU,
        int width, int height);

    public static native void I420ToYUY2(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstYUY2, int dstStrideYUY2,
        int width, int height);

    public static native void I420ToYUY2(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstYUY2, int dstStrideYUY2,
        int width, int height);

    public static native void I420ToUYVY(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstUYVY, int dstStrideUYVY,
        int width, int height);

    public static native void I420ToUYVY(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstUYVY, int dstStrideUYVY,
        int width, int height);

    // No I420ToM420
    // No I420ToQ420
    // = I420ToARGB

    public static native void I420ToBGRA(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstBGRA, int dstStrideBGRA,
        int width, int height);

    public static native void I420ToBGRA(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstBGRA, int dstStrideBGRA,
        int width, int height);

    public static native void I420ToABGR(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstABGR, int dstStrideABGR,
        int width, int height);

    public static native void I420ToABGR(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstABGR, int dstStrideABGR,
        int width, int height);

    public static native void I420ToRGBA(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstRGBA, int dstStrideRGBA,
        int width, int height);

    public static native void I420ToRGBA(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstRGBA, int dstStrideRGBA,
        int width, int height);

    public static native void I420ToRGB24(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstRGB24, int dstStrideRGB24,
        int width, int height);

    public static native void I420ToRGB24(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstRGB24, int dstStrideRGB24,
        int width, int height);

    public static native void I420ToRAW(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstRAW, int dstStrideRAW,
        int width, int height);

    public static native void I420ToRAW(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstRAW, int dstStrideRAW,
        int width, int height);

    public static native void I420ToRGB565(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstRGB565, int dstStrideRGB565,
        int width, int height);

    public static native void I420ToRGB565(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstRGB565, int dstStrideRGB565,
        int width, int height);

    public static native void I420ToARGB1555(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstARGB1555, int dstStrideARGB1555,
        int width, int height);

    public static native void I420ToARGB1555(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstARGB1555, int dstStrideARGB1555,
        int width, int height);

    public static native void I420ToARGB4444(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstARGB4444, int dstStrideARGB4444,
        int width, int height);

    public static native void I420ToARGB4444(
        ByteBuffer srcI420, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstARGB4444, int dstStrideARGB4444,
        int width, int height);

    // Conversions from ARGB

    // = ARGBToI420

    public static native void ARGBToI422(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void ARGBToI422(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstI422, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void ARGBToI444(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void ARGBToI444(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstI444, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void ARGBToI411(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void ARGBToI411(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstI411, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void ARGBToI400(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstY, int dstStrideY,
        int width, int height);

    public static native void ARGBToNV12(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstUV, int dstStrideUV,
        int width, int height);

    public static native void ARGBToNV12(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstNV12, int dstStrideY, int dstStrideUV,
        int width, int height);

    public static native void ARGBToNV21(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstVU, int dstStrideVU,
        int width, int height);

    public static native void ARGBToNV21(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstNV21, int dstStrideY, int dstStrideVU,
        int width, int height);

    public static native void ARGBToYUY2(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstYUY2, int dstStrideYUY2,
        int width, int height);

    public static native void ARGBToUYVY(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstUYVY, int dstStrideUYVY,
        int width, int height);

    // No ARGBToM420
    // No ARGBToQ420
    // ARGBCopy
    // BGRAToARGB
    // ABGRToARGB

    public static native void ARGBToRGBA(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstRGBA, int dstStrideRGBA,
        int width, int height);

    public static native void ARGBToRGB24(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstRGB24, int dstStrideRGB24,
        int width, int height);

    public static native void ARGBToRAW(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstRAW, int dstStrideRAW,
        int width, int height);

    public static native void ARGBToRGB565(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstRGB565, int dstStrideRGB565,
        int width, int height);

    public static native void ARGBToARGB1555(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstARGB1555, int dstStrideARGB1555,
        int width, int height);

    public static native void ARGBToARGB4444(
        ByteBuffer srcARGB, int srcStrideARGB,
        ByteBuffer dstARGB4444, int dstStrideARGB4444,
        int width, int height);

    // Other planar YUV conversions

    public static native void I422Copy(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void I422Copy(
        ByteBuffer srcI422, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void I422Copy(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstI422, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void I422Copy(
        ByteBuffer srcI422, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstI422, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void I444Copy(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void I444Copy(
        ByteBuffer srcI444, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstY, int dstStrideY,
        ByteBuffer dstU, int dstStrideU,
        ByteBuffer dstV, int dstStrideV,
        int width, int height);

    public static native void I444Copy(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcU, int srcStrideU,
        ByteBuffer srcV, int srcStrideV,
        ByteBuffer dstI444, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void I444Copy(
        ByteBuffer srcI444, int srcStrideY, int srcStrideU, int srcStrideV,
        ByteBuffer dstI444, int dstStrideY, int dstStrideU, int dstStrideV,
        int width, int height);

    public static native void I400Copy(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer dstY, int dstStrideY,
        int width, int height);

    public static native void NV12ToRGB565(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcUV, int srcStrideUV,
        ByteBuffer dstRGB565, int dstStrideRGB565,
        int width, int height);

    public static native void NV12ToRGB565(
        ByteBuffer srcNV12, int srcStrideY, int srcStrideUV,
        ByteBuffer dstRGB565, int dstStrideRGB565,
        int width, int height);

    public static native void NV21ToRGB565(
        ByteBuffer srcY, int srcStrideY,
        ByteBuffer srcVU, int srcStrideVU,
        ByteBuffer dstRGB565, int dstStrideRGB565,
        int width, int height);

    public static native void NV21ToRGB565(
        ByteBuffer srcNV21, int srcStrideY, int srcStrideVU,
        ByteBuffer dstRGB565, int dstStrideRGB565,
        int width, int height);

}