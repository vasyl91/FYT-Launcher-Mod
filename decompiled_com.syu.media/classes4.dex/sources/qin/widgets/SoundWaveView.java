package qin.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.syu.utils.BitmapUtils;
import java.util.Comparator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0014\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010A\u001a\u00020@¢\u0006\u0004\bB\u0010CB\u001b\b\u0016\u0012\u0006\u0010A\u001a\u00020@\u0012\b\u0010E\u001a\u0004\u0018\u00010D¢\u0006\u0004\bB\u0010FB#\b\u0016\u0012\u0006\u0010A\u001a\u00020@\u0012\b\u0010E\u001a\u0004\u0018\u00010D\u0012\u0006\u0010G\u001a\u00020\u0002¢\u0006\u0004\bB\u0010HJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010R.\u0010*\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\"8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\f\u001a\u0004\b,\u0010\u000e\"\u0004\b-\u0010\u0010R\"\u00102\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\f\u001a\u0004\b0\u0010\u000e\"\u0004\b1\u0010\u0010R\u001b\u00108\u001a\u0002038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R*\u0010<\u001a\u0002092\u0006\u0010#\u001a\u0002098\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006I"}, d2 = {"Lqin/widgets/SoundWaveView;", "Landroid/view/View;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "Landroid/graphics/Canvas;", "canvas", "onDraw", "drawCenterDrawable", "a", "I", "getInnerRadius", "()I", "setInnerRadius", "(I)V", "innerRadius", "b", "getOuterRadius", "setOuterRadius", "outerRadius", "", "c", "[F", "getMRadius", "()[F", "setMRadius", "([F)V", "mRadius", "d", "getSpeed", "setSpeed", "speed", "Landroid/graphics/drawable/Drawable;", "value", "e", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "drawable", "f", "getWaveColor", "setWaveColor", "waveColor", "g", "getWaveCount", "setWaveCount", "waveCount", "Landroid/os/Handler;", "i", "Lkotlin/Lazy;", "getMHandler", "()Landroid/os/Handler;", "mHandler", "", "j", "Z", "isPlaying", "()Z", "setPlaying", "(Z)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Components_release"}, k = 1, mv = {1, 7, 1})
public final class SoundWaveView extends View {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public int innerRadius;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public int outerRadius;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public float[] mRadius;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public int speed;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public Drawable drawable;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public int waveColor;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public int waveCount;
    public final Paint h;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final Lazy mHandler;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public boolean isPlaying;
    public final Runnable k;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SoundWaveView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void a(SoundWaveView soundWaveView) {
        Intrinsics.checkNotNullParameter(soundWaveView, "this$0");
        soundWaveView.postInvalidate();
    }

    public final void drawCenterDrawable(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Drawable drawable = this.drawable;
        if (drawable != null) {
            int i = this.innerRadius;
            drawable.setBounds(i, i, drawable.getIntrinsicWidth() + i, drawable.getIntrinsicHeight() + this.innerRadius);
            drawable.draw(canvas);
        }
    }

    public final Drawable getDrawable() {
        return this.drawable;
    }

    public final int getInnerRadius() {
        return this.innerRadius;
    }

    public final Handler getMHandler() {
        return (Handler) this.mHandler.getValue();
    }

    public final float[] getMRadius() {
        return this.mRadius;
    }

    public final int getOuterRadius() {
        return this.outerRadius;
    }

    public final int getSpeed() {
        return this.speed;
    }

    public final int getWaveColor() {
        return this.waveColor;
    }

    public final int getWaveCount() {
        return this.waveCount;
    }

    /* JADX INFO: renamed from: isPlaying, reason: from getter */
    public final boolean getIsPlaying() {
        return this.isPlaying;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        List listSortedWith;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int i = 0;
        canvas.drawColor(0);
        if (this.isPlaying) {
            getMHandler().removeCallbacks(this.k);
            float[] fArr = this.mRadius;
            float[] floatArray = (fArr == null || (listSortedWith = ArraysKt.sortedWith(fArr, new Comparator() { // from class: qin.widgets.SoundWaveView$drawWaves$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Float.valueOf(((Number) t).floatValue()), Float.valueOf(((Number) t2).floatValue()));
                }
            })) == null) ? null : CollectionsKt.toFloatArray(listSortedWith);
            this.mRadius = floatArray;
            if (floatArray != null) {
                int length = floatArray.length;
                while (i < length) {
                    Paint paint = this.h;
                    float f = floatArray[i];
                    int i2 = this.innerRadius;
                    paint.setAlpha((int) (255 - (((f - i2) * 255.0f) / (this.outerRadius - i2))));
                    Path path = new Path();
                    float f2 = floatArray[i];
                    path.addCircle(getWidth() / 2.0f, getHeight() / 2.0f, i == 0 ? this.innerRadius : floatArray[i - 1], Path.Direction.CW);
                    path.addCircle(getWidth() / 2.0f, getHeight() / 2.0f, f2, Path.Direction.CCW);
                    path.close();
                    canvas.drawPath(path, this.h);
                    float f3 = floatArray[i] + 1.0f;
                    floatArray[i] = f3;
                    if (f3 > this.outerRadius) {
                        floatArray[i] = this.innerRadius;
                    }
                    i++;
                }
            }
            if (this.isPlaying) {
                getMHandler().postDelayed(this.k, 1000 / ((long) this.speed));
            }
        }
        drawCenterDrawable(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable drawable;
        Drawable drawable2;
        int iMin = widthMeasureSpec;
        super.onMeasure(iMin, iMin);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int measuredWidth = getMeasuredWidth() > 0 ? getMeasuredWidth() : iMin;
        if (getMeasuredHeight() > 0) {
            iMin = getMeasuredHeight();
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        boolean z = (mode == 1073741824 && mode2 == 1073741824) ? false : true;
        if (mode != 1073741824 && (drawable2 = this.drawable) != null) {
            measuredWidth = Math.min(drawable2.getIntrinsicWidth() * 2, measuredWidth) + paddingLeft + paddingRight;
        }
        if (mode2 != 1073741824 && (drawable = this.drawable) != null) {
            iMin = Math.min(drawable.getIntrinsicHeight() * 2, iMin) + paddingTop + paddingBottom;
        }
        int iMin2 = Math.min(measuredWidth, iMin) / 2;
        if (iMin2 != this.outerRadius) {
            this.outerRadius = iMin2;
            int iRoundToInt = MathKt.roundToInt(iMin2 / 2.0f);
            this.innerRadius = iRoundToInt;
            Drawable drawable3 = this.drawable;
            if (drawable3 != null && iRoundToInt > 0 && iRoundToInt * 2 != drawable3.getIntrinsicWidth()) {
                BitmapUtils bitmapUtils = BitmapUtils.INSTANCE;
                Bitmap croppedBitmap = bitmapUtils.getCroppedBitmap(bitmapUtils.drawable2Bitmap(drawable3));
                setDrawable(new BitmapDrawable(BitmapUtils.zoomBitmap$default(BitmapUtils.INSTANCE, croppedBitmap, (this.innerRadius * 2.0f) / croppedBitmap.getWidth(), (this.innerRadius * 2.0f) / croppedBitmap.getHeight(), false, 8, (Object) null)));
            }
            int i = this.waveCount;
            for (int i2 = 0; i2 < i; i2++) {
                float[] fArr = this.mRadius;
                if (fArr != null) {
                    float f = this.innerRadius;
                    fArr[i2] = ((f / this.waveCount) * i2) + f;
                }
            }
        }
        if (z) {
            setMeasuredDimension(measuredWidth, iMin);
        }
    }

    public final void setDrawable(Drawable drawable) {
        if (Intrinsics.areEqual(this.drawable, drawable)) {
            return;
        }
        if (drawable != null) {
            int i = this.innerRadius;
            if (i > 0 && i * 2 != drawable.getIntrinsicWidth()) {
                Bitmap bitmapDrawable2Bitmap = BitmapUtils.INSTANCE.drawable2Bitmap(drawable);
                drawable = new BitmapDrawable(BitmapUtils.INSTANCE.getCroppedBitmap(BitmapUtils.zoomBitmap$default(BitmapUtils.INSTANCE, bitmapDrawable2Bitmap, (this.innerRadius * 2.0f) / bitmapDrawable2Bitmap.getWidth(), (this.innerRadius * 2.0f) / bitmapDrawable2Bitmap.getHeight(), false, 8, (Object) null)));
            }
        } else {
            drawable = null;
        }
        this.drawable = drawable;
        postInvalidate();
    }

    public final void setInnerRadius(int i) {
        this.innerRadius = i;
    }

    public final void setMRadius(float[] fArr) {
        this.mRadius = fArr;
    }

    public final void setOuterRadius(int i) {
        this.outerRadius = i;
    }

    public final void setPlaying(boolean z) {
        if (this.isPlaying != z) {
            this.isPlaying = z;
            if (z) {
                postInvalidate();
            }
        }
    }

    public final void setSpeed(int i) {
        this.speed = i;
    }

    public final void setWaveColor(int i) {
        this.waveColor = i;
    }

    public final void setWaveCount(int i) {
        this.waveCount = i;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SoundWaveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SoundWaveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.speed = 50;
        this.waveCount = 4;
        Paint paint = new Paint(1);
        this.h = paint;
        this.mHandler = LazyKt.lazy(new Function0<Handler>() { // from class: qin.widgets.SoundWaveView$mHandler$2
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Handler m0invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        this.k = new Runnable() { // from class: qin.widgets.SoundWaveView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SoundWaveView.a(this.f$0);
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SoundWaveView, i, 0);
        this.speed = typedArrayObtainStyledAttributes.getInt(R.styleable.SoundWaveView_speed, this.speed);
        setDrawable(typedArrayObtainStyledAttributes.getDrawable(R.styleable.SoundWaveView_image));
        this.waveColor = typedArrayObtainStyledAttributes.getColor(R.styleable.SoundWaveView_waveColor, 0);
        int i2 = typedArrayObtainStyledAttributes.getInt(R.styleable.SoundWaveView_waveCount, 4);
        this.waveCount = i2;
        if (i2 < 2) {
            this.waveCount = 2;
        }
        this.mRadius = new float[this.waveCount];
        paint.setColor(this.waveColor);
        paint.setStyle(Paint.Style.FILL);
        setPlaying(typedArrayObtainStyledAttributes.getBoolean(R.styleable.SoundWaveView_playing, false));
        typedArrayObtainStyledAttributes.recycle();
    }
}
