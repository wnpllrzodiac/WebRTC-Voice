package fi.gekkio.roboticchameleon;

import fi.gekkio.roboticchameleon.formats.ABGR;
import fi.gekkio.roboticchameleon.formats.ARGB;
import fi.gekkio.roboticchameleon.formats.ARGB1555;
import fi.gekkio.roboticchameleon.formats.ARGB4444;
import fi.gekkio.roboticchameleon.formats.BGRA;
import fi.gekkio.roboticchameleon.formats.I400;
import fi.gekkio.roboticchameleon.formats.I411;
import fi.gekkio.roboticchameleon.formats.I420;
import fi.gekkio.roboticchameleon.formats.I422;
import fi.gekkio.roboticchameleon.formats.I444;
import fi.gekkio.roboticchameleon.formats.M420;
import fi.gekkio.roboticchameleon.formats.NV12;
import fi.gekkio.roboticchameleon.formats.NV21;
import fi.gekkio.roboticchameleon.formats.Q420;
import fi.gekkio.roboticchameleon.formats.RAW;
import fi.gekkio.roboticchameleon.formats.RGB24;
import fi.gekkio.roboticchameleon.formats.RGB565;
import fi.gekkio.roboticchameleon.formats.RGBA;
import fi.gekkio.roboticchameleon.formats.UYVY;
import fi.gekkio.roboticchameleon.formats.YUY2;
import fi.gekkio.roboticchameleon.formats.YV12;

public final class RoboticChameleon {

    private RoboticChameleon() {
    }

    public static ABGR fromABGR() {
        return ABGR.INSTANCE;
    }

    public static ARGB fromARGB() {
        return ARGB.INSTANCE;
    }

    public static ARGB1555 fromARGB1555() {
        return ARGB1555.INSTANCE;
    }

    public static ARGB4444 fromARGB4444() {
        return ARGB4444.INSTANCE;
    }

    public static BGRA fromBGRA() {
        return BGRA.INSTANCE;
    }

    public static I400 fromI400() {
        return I400.INSTANCE;
    }

    public static I411 fromI411() {
        return I411.INSTANCE;
    }

    public static I420 fromI420() {
        return I420.INSTANCE;
    }

    public static I422 fromI422() {
        return I422.INSTANCE;
    }

    public static I444 fromI444() {
        return I444.INSTANCE;
    }

    public static M420 fromM420() {
        return M420.INSTANCE;
    }

    public static NV12 fromNV12() {
        return NV12.INSTANCE;
    }

    public static NV21 fromNV21() {
        return NV21.INSTANCE;
    }

    public static Q420 fromQ420() {
        return Q420.INSTANCE;
    }

    public static RAW fromRAW() {
        return RAW.INSTANCE;
    }

    public static RGB24 fromRGB24() {
        return RGB24.INSTANCE;
    }

    public static RGB565 fromRGB565() {
        return RGB565.INSTANCE;
    }

    public static RGBA fromRGBA() {
        return RGBA.INSTANCE;
    }

    public static UYVY fromUYVY() {
        return UYVY.INSTANCE;
    }

    public static YUY2 fromYUY2() {
        return YUY2.INSTANCE;
    }

    public static YV12 fromYV12() {
        return YV12.INSTANCE;
    }

}
