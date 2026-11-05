package com.syu.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J&\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006J2\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0006J \u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018J*\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0010J(\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0010J(\u0010\"\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0010J \u0010#\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006J\u0010\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020\u0002¨\u0006&"}, d2 = {"Lcom/syu/utils/BitmapUtils;", "", "", "path", "Landroid/graphics/Bitmap;", "loadBitmap", "", "outWidth", "outHeight", "", "color", "createColorBitmap", "bitmap", "getCroppedBitmap", "radius", "filletBitmap", "", "recycle", "extraScale", "fillBitmap", "image", "Landroid/content/Context;", "context", "blur", "Landroid/graphics/drawable/Drawable;", "drawable", "drawable2Bitmap", "origin", "scaleX", "scaleY", "zoomBitmap", "scaleBitmap", "outMaxWidth", "outMaxHeight", "scaleNotDeform", "bitmap2Base64", "base64Str", "base64ToBitmap", "Library_release"}, k = 1, mv = {1, 7, 1})
public final class BitmapUtils {
    public static final BitmapUtils INSTANCE = new BitmapUtils();

    public static /* synthetic */ Bitmap blur$default(BitmapUtils bitmapUtils, Bitmap bitmap, Context context, float f, int i, Object obj) {
        if ((i & 4) != 0) {
            f = 25.0f;
        }
        return bitmapUtils.blur(bitmap, context, f);
    }

    public static /* synthetic */ Bitmap fillBitmap$default(BitmapUtils bitmapUtils, Bitmap bitmap, float f, float f2, boolean z, float f3, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            f3 = 1.5f;
        }
        return bitmapUtils.fillBitmap(bitmap, f, f2, z2, f3);
    }

    public static /* synthetic */ Bitmap scaleBitmap$default(BitmapUtils bitmapUtils, Bitmap bitmap, float f, float f2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return bitmapUtils.scaleBitmap(bitmap, f, f2, z);
    }

    public static /* synthetic */ Bitmap scaleNotDeform$default(BitmapUtils bitmapUtils, Bitmap bitmap, float f, float f2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return bitmapUtils.scaleNotDeform(bitmap, f, f2, z);
    }

    public static /* synthetic */ Bitmap zoomBitmap$default(BitmapUtils bitmapUtils, Bitmap bitmap, float f, float f2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            f2 = f;
        }
        if ((i & 8) != 0) {
            z = true;
        }
        return bitmapUtils.zoomBitmap(bitmap, f, f2, z);
    }

    public final Bitmap base64ToBitmap(String base64Str) {
        Intrinsics.checkNotNullParameter(base64Str, "base64Str");
        byte[] bArrDecode = Base64.decode(base64Str, 8);
        return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
    }

    public final String bitmap2Base64(Bitmap bitmap, float outMaxWidth, float outMaxHeight) throws IOException {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            zoomBitmap$default(INSTANCE, bitmap, Math.min(outMaxWidth < ((float) bitmap.getWidth()) ? outMaxWidth / bitmap.getWidth() : 1.0f, outMaxHeight < ((float) bitmap.getHeight()) ? outMaxHeight / bitmap.getHeight() : 1.0f), 0.0f, false, 12, null).compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "baos.toByteArray()");
            String strEncodeToString = Base64.encodeToString(byteArray, 8);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(byteArrayOutputStream, null);
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return strEncodeToString;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(byteArrayOutputStream, th);
                throw th2;
            }
        }
    }

    public final Bitmap blur(Bitmap image, Context context, float blur) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(context, "context");
        Bitmap outputBitmap = Bitmap.createBitmap(image);
        RenderScript renderScriptCreate = RenderScript.create(context);
        Intrinsics.checkNotNullExpressionValue(renderScriptCreate, "create(context)");
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, image);
        Intrinsics.checkNotNullExpressionValue(allocationCreateFromBitmap, "createFromBitmap(renderScript, image)");
        Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, outputBitmap);
        Intrinsics.checkNotNullExpressionValue(allocationCreateFromBitmap2, "createFromBitmap(renderScript, outputBitmap)");
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
        Intrinsics.checkNotNullExpressionValue(scriptIntrinsicBlurCreate, "create(renderScript, Element.U8_4(renderScript))");
        scriptIntrinsicBlurCreate.setRadius(blur);
        scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
        scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
        allocationCreateFromBitmap2.copyTo(outputBitmap);
        Intrinsics.checkNotNullExpressionValue(outputBitmap, "outputBitmap");
        return outputBitmap;
    }

    public final Bitmap createColorBitmap(float outWidth, float outHeight, int color) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) outWidth, (int) outHeight, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(\n          …onfig.ARGB_8888\n        )");
        new Canvas(bitmapCreateBitmap).drawColor(color);
        return bitmapCreateBitmap;
    }

    public final Bitmap drawable2Bitmap(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        Bitmap bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        drawable.draw(new Canvas(bitmap));
        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
        return bitmap;
    }

    public final Bitmap fillBitmap(Bitmap bitmap, float outWidth, float outHeight, boolean recycle, float extraScale) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        float width = (((float) bitmap.getHeight()) / ((float) bitmap.getWidth()) > outHeight / outWidth ? outWidth / bitmap.getWidth() : outHeight / bitmap.getHeight()) * extraScale;
        return zoomBitmap(bitmap, width, width, recycle);
    }

    public final Bitmap filletBitmap(Bitmap bitmap, float outWidth, float outHeight, float radius) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) outWidth, (int) outHeight, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(\n          …onfig.ARGB_8888\n        )");
        float fMax = Math.max(outHeight / bitmap.getHeight(), outWidth / bitmap.getWidth());
        Bitmap bitmapZoomBitmap = zoomBitmap(bitmap, fMax, fMax, false);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        float f = 2;
        Rect rect = new Rect((int) ((outWidth - bitmapZoomBitmap.getWidth()) / f), (int) ((outHeight - bitmapZoomBitmap.getHeight()) / f), (int) ((bitmapZoomBitmap.getWidth() + outWidth) / f), (int) ((bitmapZoomBitmap.getHeight() + outHeight) / f));
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, outWidth, outHeight), radius, radius, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmapZoomBitmap, rect, rect, paint);
        return bitmapCreateBitmap;
    }

    public final Bitmap getCroppedBitmap(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int iMin = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(\n          …onfig.ARGB_8888\n        )");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        Rect rect = new Rect((iMin - bitmap.getWidth()) / 2, (iMin - bitmap.getHeight()) / 2, (bitmap.getWidth() + iMin) / 2, (bitmap.getHeight() + iMin) / 2);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        float f = iMin / 2.0f;
        canvas.drawCircle(f, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmapCreateBitmap;
    }

    public final Bitmap loadBitmap(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return BitmapFactory.decodeFile(path);
    }

    public final Bitmap scaleBitmap(Bitmap origin, float outWidth, float outHeight, boolean recycle) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        return zoomBitmap(origin, outWidth / origin.getWidth(), outHeight / origin.getHeight(), recycle);
    }

    public final Bitmap scaleNotDeform(Bitmap bitmap, float outMaxWidth, float outMaxHeight, boolean recycle) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return zoomBitmap$default(this, bitmap, Math.min(outMaxWidth < ((float) bitmap.getWidth()) ? outMaxWidth / bitmap.getWidth() : 1.0f, outMaxHeight < ((float) bitmap.getHeight()) ? outMaxHeight / bitmap.getHeight() : 1.0f), 0.0f, recycle, 4, null);
    }

    public final Bitmap zoomBitmap(Bitmap origin, float scaleX, float scaleY, boolean recycle) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        int height = origin.getHeight();
        int width = origin.getWidth();
        Matrix matrix = new Matrix();
        matrix.postScale(scaleX, scaleY);
        Bitmap newBM = Bitmap.createBitmap(origin, 0, 0, width, height, matrix, false);
        if (recycle && !origin.isRecycled()) {
            origin.recycle();
        }
        Intrinsics.checkNotNullExpressionValue(newBM, "newBM");
        return newBM;
    }
}
