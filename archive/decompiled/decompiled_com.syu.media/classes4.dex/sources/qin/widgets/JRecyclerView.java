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
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import syu.reflex.ReflexMethod;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015B\u001b\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0014\u0010\u0018B#\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u0014\u0010\u001bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lqin/widgets/JRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/graphics/Canvas;", "canvas", "", "dispatchDraw", "Landroid/graphics/LinearGradient;", "a", "Landroid/graphics/LinearGradient;", "getMShader", "()Landroid/graphics/LinearGradient;", "mShader", "Landroid/graphics/Paint;", "b", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Components_release"}, k = 1, mv = {1, 7, 1})
public final class JRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final LinearGradient mShader;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Paint paint;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JRecyclerView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void dispatchDraw(Canvas canvas) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Matrix matrix = new Matrix();
        matrix.setScale(1.0f, getHeight());
        this.mShader.setLocalMatrix(matrix);
        this.paint.setShader(this.mShader);
        ReflexMethod reflexMethod = new ReflexMethod("saveUnclippedLayer").target(canvas).setupClass(Canvas.class);
        Class<?> cls = Integer.TYPE;
        Integer num = (Integer) reflexMethod.paramClasses(cls, cls, cls, cls).params(0, 0, Integer.valueOf(getWidth()), Integer.valueOf(getHeight())).call();
        super.dispatchDraw(canvas);
        if (num != null) {
            new ReflexMethod("restoreUnclippedLayer").target(canvas).setupClass(Canvas.class).paramClasses(cls, Paint.class).params(Integer.valueOf(num.intValue()), this.paint).call();
        }
    }

    public final LinearGradient getMShader() {
        return this.mShader;
    }

    public final Paint getPaint() {
        return this.paint;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mShader = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, Color.parseColor("#00000000"), Color.parseColor("#A0000000"), Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.paint = paint;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mShader = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, Color.parseColor("#00000000"), Color.parseColor("#A0000000"), Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.paint = paint;
    }
}
