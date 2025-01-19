package com.android.launcher66;

import android.graphics.PointF;

/* compiled from: DynamicGrid.java */
class DeviceProfileQuery {
    PointF dimens;
    float heightDps;
    float value;
    float widthDps;

    DeviceProfileQuery(float w, float h, float v) {
        this.widthDps = w;
        this.heightDps = h;
        this.value = v;
        this.dimens = new PointF(w, h);
    }
}
