package cc.dot.camerafilters.base;

import android.content.Context;

import cc.dot.camerafilters.filter.IFilter;



public interface onExtFilterListener {
    IFilter onCreateExtFilter(Context context, int index);
}
