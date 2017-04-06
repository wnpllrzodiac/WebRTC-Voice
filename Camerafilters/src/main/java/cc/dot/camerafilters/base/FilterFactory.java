package cc.dot.camerafilters.base;

import android.content.Context;

import cc.dot.camerafilters.filter.CameraFilter;
import cc.dot.camerafilters.filter.CameraFilterBeauty;
import cc.dot.camerafilters.filter.IFilter;



public class FilterFactory {
    private static int[] mCurveArrays = new int[]{

    };

    private FilterFactory() {
    }

    /**
     *
     * @param context
     * @param index
     * @return
     */
    public static IFilter getCameraFilter(Context context, int index) {

        switch (index) {
            case 0:
                return new CameraFilter(context);
            case 1:
                return new CameraFilterBeauty(context);

        }

        return new CameraFilter(context);
    }
}

