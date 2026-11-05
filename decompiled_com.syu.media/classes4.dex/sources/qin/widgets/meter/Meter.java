package qin.widgets.meter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import qin.widgets.BaseCustomView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0001hB\u0013\b\u0016\u0012\b\u0010`\u001a\u0004\u0018\u00010_¢\u0006\u0004\ba\u0010bB\u001d\b\u0016\u0012\b\u0010`\u001a\u0004\u0018\u00010_\u0012\b\u0010d\u001a\u0004\u0018\u00010c¢\u0006\u0004\ba\u0010eB%\b\u0016\u0012\b\u0010`\u001a\u0004\u0018\u00010_\u0012\b\u0010d\u001a\u0004\u0018\u00010c\u0012\u0006\u0010f\u001a\u00020\u0002¢\u0006\u0004\ba\u0010gJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0004J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0002R\u001a\u0010\u001a\u001a\u00020\u00158\u0006X\u0086D¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010 \u001a\u00020\u001b8\u0006X\u0086D¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR$\u0010(\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010,\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010#\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R$\u00103\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R.\u0010<\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u0001048\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R*\u0010C\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR*\u0010G\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010>\u001a\u0004\bE\u0010@\"\u0004\bF\u0010BR\"\u0010N\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010R\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010I\u001a\u0004\bP\u0010K\"\u0004\bQ\u0010MR\u001b\u0010X\u001a\u00020S8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u001a\u0010^\u001a\u00020Y8\u0004X\u0084\u0004¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]¨\u0006i"}, d2 = {"Lqin/widgets/meter/Meter;", "Lqin/widgets/BaseCustomView;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "measureSetup", "Landroid/graphics/Canvas;", "canvas", "onDraw", "", "position", "updatePosition", "dx", "speed", "validPosition", "angle", "tickAt", "tick", "updateTick", "", "a", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "", "b", "Z", "getDEBUG", "()Z", "DEBUG", "Landroid/graphics/Bitmap;", "c", "Landroid/graphics/Bitmap;", "getDial", "()Landroid/graphics/Bitmap;", "setDial", "(Landroid/graphics/Bitmap;)V", "dial", "d", "getMCache", "setMCache", "mCache", "e", "Landroid/graphics/Canvas;", "getCacheCanvas", "()Landroid/graphics/Canvas;", "setCacheCanvas", "(Landroid/graphics/Canvas;)V", "cacheCanvas", "Lqin/widgets/meter/Meter$MeterAdapter;", "value", "f", "Lqin/widgets/meter/Meter$MeterAdapter;", "getAdapter", "()Lqin/widgets/meter/Meter$MeterAdapter;", "setAdapter", "(Lqin/widgets/meter/Meter$MeterAdapter;)V", "adapter", "g", "I", "getProgress", "()I", "setProgress", "(I)V", "progress", "h", "getTickPosition", "setTickPosition", "tickPosition", "i", "F", "getMoveSpeed", "()F", "setMoveSpeed", "(F)V", "moveSpeed", "j", "getMDx", "setMDx", "mDx", "Landroid/os/Handler;", "k", "Lkotlin/Lazy;", "getMHandler", "()Landroid/os/Handler;", "mHandler", "Ljava/lang/Runnable;", "l", "Ljava/lang/Runnable;", "getUpdateVernier", "()Ljava/lang/Runnable;", "updateVernier", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MeterAdapter", "Components_release"}, k = 1, mv = {1, 7, 1})
public class Meter extends BaseCustomView {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final String TAG;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final boolean DEBUG;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public Bitmap dial;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public Bitmap mCache;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public Canvas cacheCanvas;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public MeterAdapter adapter;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public int progress;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public int tickPosition;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public float moveSpeed;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public float mDx;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final Lazy mHandler;
    public final Meter$updateVernier$1 l;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001a\b&\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u0012\b\b\u0002\u0010!\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016R\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\"\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014¨\u0006$"}, d2 = {"Lqin/widgets/meter/Meter$MeterAdapter;", "", "", "angle", "", "tickAt", "tick", "sweepAngleOf", "Landroid/graphics/Canvas;", "canvas", "", "drawDial", "drawTick", "fps", "acceleration", "a", "I", "getStartAngle", "()I", "setStartAngle", "(I)V", "startAngle", "b", "getSweepAngle", "setSweepAngle", "sweepAngle", "c", "getMin", "setMin", "min", "d", "getMax", "setMax", "max", "<init>", "(IIII)V", "Components_release"}, k = 1, mv = {1, 7, 1})
    public static abstract class MeterAdapter {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        public int startAngle;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public int sweepAngle;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public int min;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        public int max;

        public MeterAdapter() {
            this(0, 0, 0, 0, 15, null);
        }

        public int acceleration() {
            return 88;
        }

        public abstract void drawDial(Canvas canvas);

        public abstract void drawTick(Canvas canvas, int tick);

        public int fps() {
            return 30;
        }

        public final int getMax() {
            return this.max;
        }

        public final int getMin() {
            return this.min;
        }

        public final int getStartAngle() {
            return this.startAngle;
        }

        public final int getSweepAngle() {
            return this.sweepAngle;
        }

        public final void setMax(int i) {
            this.max = i;
        }

        public final void setMin(int i) {
            this.min = i;
        }

        public final void setStartAngle(int i) {
            this.startAngle = i;
        }

        public final void setSweepAngle(int i) {
            this.sweepAngle = i;
        }

        public float sweepAngleOf(int tick) {
            return (Math.max(this.min, Math.min(tick, this.max)) * this.sweepAngle) / (this.max - this.min);
        }

        public int tickAt(float angle) {
            float f;
            int i = this.startAngle;
            float f2 = i;
            if (angle < f2) {
                f = 0.0f;
            } else {
                int i2 = this.sweepAngle;
                f = angle > ((float) (i + i2)) ? i2 : angle - f2;
            }
            return (int) (((double) ((f / this.sweepAngle) * (this.max - this.min))) + 0.5d);
        }

        public MeterAdapter(int i, int i2, int i3, int i4) {
            this.startAngle = i;
            this.sweepAngle = i2;
            this.min = i3;
            this.max = i4;
        }

        public /* synthetic */ MeterAdapter(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? STBorder.INT_PEOPLE : i, (i5 & 2) != 0 ? 270 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? STBorder.INT_VINE : i4);
        }
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [qin.widgets.meter.Meter$updateVernier$1] */
    public Meter(Context context) {
        super(context);
        this.TAG = "Meter";
        this.DEBUG = true;
        this.progress = 50;
        MeterAdapter meterAdapter = this.adapter;
        this.tickPosition = meterAdapter != null ? meterAdapter.getMin() : 0;
        this.mHandler = LazyKt.lazy(Meter$mHandler$2.INSTANCE);
        this.l = new Runnable() { // from class: qin.widgets.meter.Meter$updateVernier$1
            @Override // java.lang.Runnable
            public void run() {
                if (Math.abs(this.a.getMDx()) <= this.a.getMoveSpeed()) {
                    Meter meter = this.a;
                    meter.setProgress(meter.validPosition(this.a.getMDx() + meter.getTickPosition()));
                    this.a.setMDx(0.0f);
                    this.a.setMoveSpeed(0.0f);
                    return;
                }
                float moveSpeed = this.a.getMDx() > 0.0f ? -this.a.getMoveSpeed() : this.a.getMoveSpeed();
                Meter meter2 = this.a;
                meter2.setMDx(meter2.getMDx() + moveSpeed);
                Meter meter3 = this.a;
                meter3.setMoveSpeed(meter3.speed(meter3.getMDx()));
                Handler mHandler = this.a.getMHandler();
                Meter.MeterAdapter adapter = this.a.getAdapter();
                mHandler.postDelayed(this, 1000 / (adapter != null ? adapter.fps() : 30));
                Meter meter4 = this.a;
                this.a.setTickPosition(meter4.validPosition(meter4.getTickPosition() - moveSpeed));
            }
        };
    }

    public final MeterAdapter getAdapter() {
        return this.adapter;
    }

    public final Canvas getCacheCanvas() {
        return this.cacheCanvas;
    }

    public final boolean getDEBUG() {
        return this.DEBUG;
    }

    public final Bitmap getDial() {
        return this.dial;
    }

    public final Bitmap getMCache() {
        return this.mCache;
    }

    public final float getMDx() {
        return this.mDx;
    }

    public final Handler getMHandler() {
        return (Handler) this.mHandler.getValue();
    }

    public final float getMoveSpeed() {
        return this.moveSpeed;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final int getTickPosition() {
        return this.tickPosition;
    }

    public final Runnable getUpdateVernier() {
        return this.l;
    }

    public void measureSetup(int widthMeasureSpec, int heightMeasureSpec) {
        if (getMeasuredWidth() <= 0 || getMeasuredHeight() <= 0) {
            return;
        }
        if (this.DEBUG) {
            Log.e(this.TAG, "-------- onMeasure " + getMeasuredWidth() + " x " + getMeasuredHeight());
        }
        Bitmap bitmap = this.mCache;
        if (bitmap != null && bitmap.getWidth() == getMeasuredWidth()) {
            Bitmap bitmap2 = this.mCache;
            if (bitmap2 != null && bitmap2.getHeight() == getMeasuredHeight()) {
                return;
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.cacheCanvas = new Canvas(bitmapCreateBitmap);
        this.mCache = bitmapCreateBitmap;
        if (this.DEBUG) {
            Log.e(this.TAG, "--- create mCache : " + this.mCache + "   " + getMeasuredWidth() + " x " + getMeasuredHeight());
        }
        Bitmap bitmap3 = this.dial;
        if (bitmap3 != null) {
            bitmap3.recycle();
        }
        this.dial = null;
        postInvalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Canvas canvas2;
        Canvas canvas3;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        if (this.DEBUG) {
            Log.e(this.TAG, "--- Meter onDraw : " + this.mCache + "  view: " + getWidth() + " x " + getHeight() + "  Canvas size: " + canvas.getWidth() + " x " + canvas.getHeight());
        }
        if (this.DEBUG) {
            Log.e(this.TAG, "--- Meter drawDial adapter: " + this.adapter);
        }
        MeterAdapter meterAdapter = this.adapter;
        if (meterAdapter != null && this.dial == null) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            if (this.DEBUG) {
                Log.e(this.TAG, "--- drawDial " + getMeasuredWidth() + " x " + getMeasuredHeight());
            }
            meterAdapter.drawDial(new Canvas(bitmapCreateBitmap));
            this.dial = bitmapCreateBitmap;
        }
        Canvas canvas4 = this.cacheCanvas;
        if (canvas4 != null) {
            canvas4.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        Bitmap bitmap = this.dial;
        if (bitmap != null && (canvas3 = this.cacheCanvas) != null) {
            canvas3.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
        if (this.DEBUG) {
            Log.e(this.TAG, "--- Meter drawMarks adapter: " + this.adapter + "  tick: " + this.tickPosition);
        }
        MeterAdapter meterAdapter2 = this.adapter;
        if (meterAdapter2 != null && (canvas2 = this.cacheCanvas) != null) {
            meterAdapter2.drawTick(canvas2, this.tickPosition);
        }
        Bitmap bitmap2 = this.mCache;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight()), new Rect(0, 0, canvas.getWidth(), canvas.getHeight()), (Paint) null);
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureSetup(widthMeasureSpec, heightMeasureSpec);
    }

    public final void setAdapter(MeterAdapter meterAdapter) {
        if (Intrinsics.areEqual(this.adapter, meterAdapter)) {
            return;
        }
        this.adapter = meterAdapter;
        setTickPosition(meterAdapter != null ? meterAdapter.getMin() : 0);
    }

    public final void setCacheCanvas(Canvas canvas) {
        this.cacheCanvas = canvas;
    }

    public final void setDial(Bitmap bitmap) {
        this.dial = bitmap;
    }

    public final void setMCache(Bitmap bitmap) {
        this.mCache = bitmap;
    }

    public final void setMDx(float f) {
        this.mDx = f;
    }

    public final void setMoveSpeed(float f) {
        this.moveSpeed = f;
    }

    public final void setProgress(int i) {
        if (this.progress != i) {
            this.progress = i;
            setTickPosition(i);
        }
    }

    public final void setTickPosition(int i) {
        if (this.tickPosition != i) {
            this.tickPosition = i;
            postInvalidate();
        }
    }

    public final float speed(float dx) {
        MeterAdapter meterAdapter = this.adapter;
        float fAcceleration = meterAdapter != null ? meterAdapter.acceleration() : 88;
        return fAcceleration * ((float) Math.sqrt(Math.abs(dx / fAcceleration)));
    }

    public final int tickAt(float angle) {
        MeterAdapter meterAdapter = this.adapter;
        if (meterAdapter != null) {
            return meterAdapter.tickAt(angle);
        }
        return -1;
    }

    public void updatePosition(float position) {
        float fValidPosition = validPosition(position) - this.tickPosition;
        this.mDx = fValidPosition;
        this.moveSpeed = speed(fValidPosition);
        getMHandler().removeCallbacks(this.l);
        run();
    }

    public final void updateTick(int tick) {
        updatePosition(tick);
    }

    public int validPosition(float position) {
        MeterAdapter meterAdapter = this.adapter;
        if (meterAdapter == null) {
            return -1;
        }
        if (position < meterAdapter.getMin()) {
            return meterAdapter.getMin();
        }
        return position > ((float) meterAdapter.getMax()) ? meterAdapter.getMax() : (int) (position + 0.5f);
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [qin.widgets.meter.Meter$updateVernier$1] */
    public Meter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "Meter";
        this.DEBUG = true;
        this.progress = 50;
        MeterAdapter meterAdapter = this.adapter;
        this.tickPosition = meterAdapter != null ? meterAdapter.getMin() : 0;
        this.mHandler = LazyKt.lazy(Meter$mHandler$2.INSTANCE);
        this.l = new Runnable() { // from class: qin.widgets.meter.Meter$updateVernier$1
            @Override // java.lang.Runnable
            public void run() {
                if (Math.abs(this.a.getMDx()) <= this.a.getMoveSpeed()) {
                    Meter meter = this.a;
                    meter.setProgress(meter.validPosition(this.a.getMDx() + meter.getTickPosition()));
                    this.a.setMDx(0.0f);
                    this.a.setMoveSpeed(0.0f);
                    return;
                }
                float moveSpeed = this.a.getMDx() > 0.0f ? -this.a.getMoveSpeed() : this.a.getMoveSpeed();
                Meter meter2 = this.a;
                meter2.setMDx(meter2.getMDx() + moveSpeed);
                Meter meter3 = this.a;
                meter3.setMoveSpeed(meter3.speed(meter3.getMDx()));
                Handler mHandler = this.a.getMHandler();
                Meter.MeterAdapter adapter = this.a.getAdapter();
                mHandler.postDelayed(this, 1000 / (adapter != null ? adapter.fps() : 30));
                Meter meter4 = this.a;
                this.a.setTickPosition(meter4.validPosition(meter4.getTickPosition() - moveSpeed));
            }
        };
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [qin.widgets.meter.Meter$updateVernier$1] */
    public Meter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "Meter";
        this.DEBUG = true;
        this.progress = 50;
        MeterAdapter meterAdapter = this.adapter;
        this.tickPosition = meterAdapter != null ? meterAdapter.getMin() : 0;
        this.mHandler = LazyKt.lazy(Meter$mHandler$2.INSTANCE);
        this.l = new Runnable() { // from class: qin.widgets.meter.Meter$updateVernier$1
            @Override // java.lang.Runnable
            public void run() {
                if (Math.abs(this.a.getMDx()) <= this.a.getMoveSpeed()) {
                    Meter meter = this.a;
                    meter.setProgress(meter.validPosition(this.a.getMDx() + meter.getTickPosition()));
                    this.a.setMDx(0.0f);
                    this.a.setMoveSpeed(0.0f);
                    return;
                }
                float moveSpeed = this.a.getMDx() > 0.0f ? -this.a.getMoveSpeed() : this.a.getMoveSpeed();
                Meter meter2 = this.a;
                meter2.setMDx(meter2.getMDx() + moveSpeed);
                Meter meter3 = this.a;
                meter3.setMoveSpeed(meter3.speed(meter3.getMDx()));
                Handler mHandler = this.a.getMHandler();
                Meter.MeterAdapter adapter = this.a.getAdapter();
                mHandler.postDelayed(this, 1000 / (adapter != null ? adapter.fps() : 30));
                Meter meter4 = this.a;
                this.a.setTickPosition(meter4.validPosition(meter4.getTickPosition() - moveSpeed));
            }
        };
        setLayerType(1, null);
    }
}
