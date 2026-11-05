package qin.widgets.meter.adapter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import qin.widgets.meter.Meter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006\u0012\b\b\u0002\u0010 \u001a\u00020\u0006\u0012\b\b\u0002\u0010!\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016R\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006$"}, d2 = {"Lqin/widgets/meter/adapter/RoundLevelAdapter;", "Lqin/widgets/meter/Meter$MeterAdapter;", "Landroid/graphics/Canvas;", "canvas", "", "drawDial", "", "tick", "drawTick", "acceleration", "", "e", "Z", "getClip", "()Z", "clip", "Landroid/graphics/Bitmap;", "f", "Landroid/graphics/Bitmap;", "getMBitmap", "()Landroid/graphics/Bitmap;", "setMBitmap", "(Landroid/graphics/Bitmap;)V", "mBitmap", "Landroid/graphics/Paint;", "g", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint", "startVal", "sweep", "minVal", "maxVal", "<init>", "(ZLandroid/graphics/Bitmap;IIII)V", "Components_release"}, k = 1, mv = {1, 7, 1})
public final class RoundLevelAdapter extends Meter.MeterAdapter {

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final boolean clip;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public Bitmap mBitmap;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final Paint paint;

    public RoundLevelAdapter(boolean z, Bitmap bitmap, int i, int i2, int i3, int i4) {
        super(i, i2, i3 * 1000, i4 * 1000);
        this.clip = z;
        this.mBitmap = bitmap;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-1);
        this.paint = paint;
    }

    @Override // qin.widgets.meter.Meter.MeterAdapter
    public int acceleration() {
        return getMax() / STBorder.INT_VINE;
    }

    @Override // qin.widgets.meter.Meter.MeterAdapter
    public void drawDial(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
    }

    @Override // qin.widgets.meter.Meter.MeterAdapter
    public void drawTick(Canvas canvas, int tick) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float fSweepAngleOf = sweepAngleOf(tick);
        float width = canvas.getWidth() / 2.0f;
        float height = canvas.getHeight() / 2.0f;
        RectF rectF = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        canvas.save();
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            if (this.clip) {
                canvas.drawArc(rectF, getStartAngle(), fSweepAngleOf, true, this.paint);
                this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), rectF, this.paint);
                this.paint.setXfermode(null);
            } else {
                canvas.rotate((-getStartAngle()) + fSweepAngleOf, width, height);
                canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), rectF, this.paint);
            }
        }
        canvas.restore();
    }

    public final boolean getClip() {
        return this.clip;
    }

    public final Bitmap getMBitmap() {
        return this.mBitmap;
    }

    public final Paint getPaint() {
        return this.paint;
    }

    public final void setMBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public /* synthetic */ RoundLevelAdapter(boolean z, Bitmap bitmap, int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i5 & 2) != 0 ? null : bitmap, (i5 & 4) != 0 ? STBorder.INT_PEOPLE : i, (i5 & 8) != 0 ? 270 : i2, (i5 & 16) != 0 ? 0 : i3, (i5 & 32) != 0 ? 240 : i4);
    }
}
