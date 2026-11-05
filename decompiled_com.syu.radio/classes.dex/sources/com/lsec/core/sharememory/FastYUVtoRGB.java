package com.lsec.core.sharememory;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class FastYUVtoRGB {
    private Allocation in;
    private Allocation out;
    private Type.Builder rgbaType;
    private RenderScript rs;
    private ScriptIntrinsicYuvToRGB yuvToRgbIntrinsic;
    private Type.Builder yuvType;

    public FastYUVtoRGB(Context context) {
        this.rs = RenderScript.create(context);
        this.yuvToRgbIntrinsic = ScriptIntrinsicYuvToRGB.create(this.rs, Element.U8_4(this.rs));
    }

    public Bitmap convertYUVtoRGB(byte[] yuvData, int width, int height) {
        if (yuvData == null) {
            return null;
        }
        if (this.yuvType == null) {
            this.yuvType = new Type.Builder(this.rs, Element.U8(this.rs)).setX(yuvData.length);
            this.in = Allocation.createTyped(this.rs, this.yuvType.create(), 1);
            this.rgbaType = new Type.Builder(this.rs, Element.RGBA_8888(this.rs)).setX(width).setY(height);
            this.out = Allocation.createTyped(this.rs, this.rgbaType.create(), 1);
        }
        this.in.copyFrom(yuvData);
        this.yuvToRgbIntrinsic.setInput(this.in);
        this.yuvToRgbIntrinsic.forEach(this.out);
        Bitmap bmpout = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.out.copyTo(bmpout);
        return bmpout;
    }
}
