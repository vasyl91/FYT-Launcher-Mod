package qin.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import syu.reflex.ReflexMethod;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018B\u001b\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0017\u0010\u001bB#\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u0017\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lqin/widgets/BubbleImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "pressed", "", "setPressed", "Landroid/graphics/Canvas;", "canvas", "onDraw", "Landroid/graphics/LinearGradient;", "a", "Landroid/graphics/LinearGradient;", "getMShader", "()Landroid/graphics/LinearGradient;", "mShader", "Landroid/graphics/Paint;", "b", "Landroid/graphics/Paint;", "getMPaint", "()Landroid/graphics/Paint;", "mPaint", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Components_release"}, k = 1, mv = {1, 7, 1})
public final class BubbleImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final LinearGradient mShader;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Paint mPaint;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleImageView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mShader = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, Color.parseColor("#A0000000"), Color.parseColor("#A0000000"), Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.mPaint = paint;
    }

    public final Paint getMPaint() {
        return this.mPaint;
    }

    public final LinearGradient getMShader() {
        return this.mShader;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas canvas) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Integer num;
        if (isPressed()) {
            Matrix matrix = new Matrix();
            matrix.setScale(1.0f, getHeight());
            this.mShader.setLocalMatrix(matrix);
            this.mPaint.setShader(this.mShader);
            ReflexMethod reflexMethod = new ReflexMethod("saveUnclippedLayer").target(canvas).setupClass(Canvas.class);
            Class<?> cls = Integer.TYPE;
            num = (Integer) reflexMethod.paramClasses(cls, cls, cls, cls).params(0, 0, Integer.valueOf(getWidth()), Integer.valueOf(getHeight())).call();
        } else {
            num = null;
        }
        super.onDraw(canvas);
        if (!isPressed() || num == null) {
            return;
        }
        new ReflexMethod("restoreUnclippedLayer").target(canvas).setupClass(Canvas.class).paramClasses(Integer.TYPE, Paint.class).params(Integer.valueOf(num.intValue()), this.mPaint).call();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
        postInvalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mShader = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, Color.parseColor("#A0000000"), Color.parseColor("#A0000000"), Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.mPaint = paint;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mShader = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, Color.parseColor("#A0000000"), Color.parseColor("#A0000000"), Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.mPaint = paint;
    }
}
