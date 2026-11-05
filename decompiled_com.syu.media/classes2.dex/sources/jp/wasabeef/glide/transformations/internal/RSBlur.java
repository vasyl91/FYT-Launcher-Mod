package jp.wasabeef.glide.transformations.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class RSBlur {
    /* JADX WARN: Code duplicated, block: B:26:0x005a  */
    /* JADX WARN: Code duplicated, block: B:28:0x005f  */
    /* JADX WARN: Code duplicated, block: B:30:0x0064  */
    /* JADX WARN: Code duplicated, block: B:32:0x0069  */
    /* JADX WARN: Multi-variable type inference failed */
    public static Bitmap blur(Context context, Bitmap bitmap, int i) throws Throwable {
        ScriptIntrinsicBlur scriptIntrinsicBlur;
        Allocation allocationCreateFromBitmap;
        Allocation allocationCreateTyped;
        RenderScript renderScript = null;
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate = null;
        try {
            RenderScript renderScriptCreate = RenderScript.create(context);
            try {
                renderScriptCreate.setMessageHandler(new RenderScript.RSMessageHandler());
                allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
                try {
                    allocationCreateTyped = Allocation.createTyped(renderScriptCreate, allocationCreateFromBitmap.getType());
                    try {
                        scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
                        scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
                        scriptIntrinsicBlurCreate.setRadius(i);
                        scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
                        allocationCreateTyped.copyTo(bitmap);
                        if (renderScriptCreate != null) {
                            RenderScript.releaseAllContexts();
                        }
                        if (allocationCreateFromBitmap != null) {
                            allocationCreateFromBitmap.destroy();
                        }
                        if (allocationCreateTyped != null) {
                            allocationCreateTyped.destroy();
                        }
                        if (scriptIntrinsicBlurCreate != null) {
                            scriptIntrinsicBlurCreate.destroy();
                        }
                        return bitmap;
                    } catch (Throwable th) {
                        th = th;
                        ScriptIntrinsicBlur scriptIntrinsicBlur2 = scriptIntrinsicBlurCreate;
                        renderScript = renderScriptCreate;
                        scriptIntrinsicBlur = scriptIntrinsicBlur2;
                        if (renderScript != null) {
                            RenderScript.releaseAllContexts();
                        }
                        if (allocationCreateFromBitmap != null) {
                            allocationCreateFromBitmap.destroy();
                        }
                        if (allocationCreateTyped != null) {
                            allocationCreateTyped.destroy();
                        }
                        if (scriptIntrinsicBlur != 0) {
                            scriptIntrinsicBlur.destroy();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    allocationCreateTyped = null;
                    renderScript = renderScriptCreate;
                    scriptIntrinsicBlur = allocationCreateTyped;
                    if (renderScript != null) {
                        RenderScript.releaseAllContexts();
                    }
                    if (allocationCreateFromBitmap != null) {
                        allocationCreateFromBitmap.destroy();
                    }
                    if (allocationCreateTyped != null) {
                        allocationCreateTyped.destroy();
                    }
                    if (scriptIntrinsicBlur != 0) {
                        scriptIntrinsicBlur.destroy();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                allocationCreateFromBitmap = null;
                allocationCreateTyped = null;
            }
        } catch (Throwable th4) {
            th = th4;
            scriptIntrinsicBlur = 0;
            allocationCreateFromBitmap = null;
            allocationCreateTyped = null;
        }
    }
}
