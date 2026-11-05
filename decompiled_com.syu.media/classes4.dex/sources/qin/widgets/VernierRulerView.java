package qin.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\bF\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001zB\u0011\b\u0016\u0012\u0006\u0010r\u001a\u00020q¢\u0006\u0004\bs\u0010tB\u001b\b\u0016\u0012\u0006\u0010r\u001a\u00020q\u0012\b\u0010v\u001a\u0004\u0018\u00010u¢\u0006\u0004\bs\u0010wB#\b\u0016\u0012\u0006\u0010r\u001a\u00020q\u0012\b\u0010v\u001a\u0004\u0018\u00010u\u0012\u0006\u0010x\u001a\u00020\u0002¢\u0006\u0004\bs\u0010yJ\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0014J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016R$\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00028\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR*\u0010%\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00168\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R*\u0010*\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001b\u001a\u0004\b'\u0010(\"\u0004\b)\u0010\u001dR*\u0010.\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u001b\u001a\u0004\b,\u0010(\"\u0004\b-\u0010\u001dR*\u00102\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00168\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010 \u001a\u0004\b0\u0010\"\"\u0004\b1\u0010$R*\u00106\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00168\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010 \u001a\u0004\b4\u0010\"\"\u0004\b5\u0010$R*\u0010:\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00168\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010 \u001a\u0004\b8\u0010\"\"\u0004\b9\u0010$R*\u0010>\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010\u001b\u001a\u0004\b<\u0010(\"\u0004\b=\u0010\u001dR*\u0010B\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010\u001b\u001a\u0004\b@\u0010(\"\u0004\bA\u0010\u001dR*\u0010F\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010\u001b\u001a\u0004\bD\u0010(\"\u0004\bE\u0010\u001dR*\u0010J\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00168\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010 \u001a\u0004\bH\u0010\"\"\u0004\bI\u0010$R\"\u0010M\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR*\u0010T\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00168\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010 \u001a\u0004\bR\u0010\"\"\u0004\bS\u0010$R\"\u0010X\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010 \u001a\u0004\bV\u0010\"\"\u0004\bW\u0010$R\"\u0010\\\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010 \u001a\u0004\bZ\u0010\"\"\u0004\b[\u0010$R\u001b\u0010b\u001a\u00020]8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u0017\u0010h\u001a\u00020c8\u0006¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gR$\u0010p\u001a\u0004\u0018\u00010i8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010o¨\u0006{"}, d2 = {"Lqin/widgets/VernierRulerView;", "Landroid/view/View;", "", "min", "max", "step", "", "setup", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroid/graphics/Canvas;", "canvas", "onDraw", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "event", "onTouchEvent", "tick", "updateTick", "", "position", "validPosition", "value", "d", "I", "setMTick", "(I)V", "mTick", "f", "F", "getRulerPadding", "()F", "setRulerPadding", "(F)V", "rulerPadding", "g", "getRulerColor", "()I", "setRulerColor", "rulerColor", "h", "getTickColor", "setTickColor", "tickColor", "i", "getTickWidth", "setTickWidth", "tickWidth", "j", "getTickHeight", "setTickHeight", "tickHeight", "k", "getTickTextSize", "setTickTextSize", "tickTextSize", "l", "getTickTextMarginTop", "setTickTextMarginTop", "tickTextMarginTop", "m", "getTickTextSpace", "setTickTextSpace", "tickTextSpace", "n", "getVernierColor", "setVernierColor", "vernierColor", "o", "getVernierWidth", "setVernierWidth", "vernierWidth", "s", "Z", "isContinuously", "()Z", "setContinuously", "(Z)V", "x", "getTickPosition", "setTickPosition", "tickPosition", "y", "getMoveSpeed", "setMoveSpeed", "moveSpeed", "z", "getMDx", "setMDx", "mDx", "Landroid/os/Handler;", "A", "Lkotlin/Lazy;", "getMHandler", "()Landroid/os/Handler;", "mHandler", "Ljava/lang/Runnable;", "B", "Ljava/lang/Runnable;", "getResetTouch", "()Ljava/lang/Runnable;", "resetTouch", "Lqin/widgets/VernierRulerView$OnTickChangedListener;", "C", "Lqin/widgets/VernierRulerView$OnTickChangedListener;", "getOnTickChangedListener", "()Lqin/widgets/VernierRulerView$OnTickChangedListener;", "setOnTickChangedListener", "(Lqin/widgets/VernierRulerView$OnTickChangedListener;)V", "onTickChangedListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OnTickChangedListener", "Components_release"}, k = 1, mv = {1, 7, 1})
public final class VernierRulerView extends View {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    public final Lazy mHandler;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    public final Runnable resetTouch;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    public OnTickChangedListener onTickChangedListener;
    public final VernierRulerView$updateVernier$1 D;
    public int a;
    public int b;
    public int c;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public int mTick;
    public final float e;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public float rulerPadding;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public int rulerColor;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public int tickColor;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public float tickWidth;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public float tickHeight;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public float tickTextSize;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public int tickTextMarginTop;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public int tickTextSpace;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public int vernierColor;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public float vernierWidth;
    public boolean p;
    public boolean q;
    public boolean r;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public boolean isContinuously;
    public float t;
    public final Paint u;
    public final Paint v;
    public final Paint w;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    public float tickPosition;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    public float moveSpeed;

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    public float mDx;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lqin/widgets/VernierRulerView$OnTickChangedListener;", "", "onTickChanged", "", "tick", "", "Components_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface OnTickChangedListener {
        void onTickChanged(int tick);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VernierRulerView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final float access$speed(VernierRulerView vernierRulerView, float f) {
        vernierRulerView.getClass();
        float f2 = 1;
        return f2 * ((float) Math.sqrt(Math.abs(f / f2)));
    }

    public static final int access$tickAt(VernierRulerView vernierRulerView, float f) {
        int iRoundToInt = MathKt.roundToInt(((f - vernierRulerView.rulerPadding) / vernierRulerView.t) / vernierRulerView.e);
        int i = vernierRulerView.b;
        int i2 = iRoundToInt + i;
        boolean z = vernierRulerView.isContinuously;
        if (!z && i2 > 7400) {
            i2 += 1250;
        }
        int i3 = (z || i2 > 740) ? vernierRulerView.c : 3;
        int i4 = (i3 / 2) + i2;
        return i4 - ((i4 - i) % i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setMTick(int i) {
        if (this.mTick != i) {
            this.mTick = i;
            setTickPosition(a(i));
        }
    }

    public final float a(int i) {
        boolean z = this.isContinuously;
        if (!z) {
            if (7401 <= i && i < 8750) {
                i = i < 16150 ? 7400 : 8750;
            }
        }
        return (((z || i <= 7400) ? i - this.b : (i - this.b) - 1250) * this.e * this.t) + this.rulerPadding;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(ev);
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

    public final OnTickChangedListener getOnTickChangedListener() {
        return this.onTickChangedListener;
    }

    public final Runnable getResetTouch() {
        return this.resetTouch;
    }

    public final int getRulerColor() {
        return this.rulerColor;
    }

    public final float getRulerPadding() {
        return this.rulerPadding;
    }

    public final int getTickColor() {
        return this.tickColor;
    }

    public final float getTickHeight() {
        return this.tickHeight;
    }

    public final float getTickPosition() {
        return this.tickPosition;
    }

    public final int getTickTextMarginTop() {
        return this.tickTextMarginTop;
    }

    public final float getTickTextSize() {
        return this.tickTextSize;
    }

    public final int getTickTextSpace() {
        return this.tickTextSpace;
    }

    public final float getTickWidth() {
        return this.tickWidth;
    }

    public final int getVernierColor() {
        return this.vernierColor;
    }

    public final float getVernierWidth() {
        return this.vernierWidth;
    }

    /* JADX INFO: renamed from: isContinuously, reason: from getter */
    public final boolean getIsContinuously() {
        return this.isContinuously;
    }

    /* JADX WARN: Code duplicated, block: B:91:0x021f A[LOOP:0: B:26:0x0081->B:91:0x021f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:95:0x0228 A[EDGE_INSN: B:95:0x0228->B:92:0x0228 BREAK  A[LOOP:0: B:26:0x0081->B:91:0x021f], SYNTHETIC] */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float width;
        int i;
        int i2;
        int i3;
        int i4;
        float f;
        float f2;
        int i5;
        String strValueOf;
        String strValueOf2;
        int i6;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (getWidth() <= 0 || this.a <= this.b) {
            return;
        }
        canvas.save();
        setTickHeight(30.0f);
        int i7 = this.b;
        boolean z = 6400 <= i7 && i7 < 10801;
        this.r = z;
        this.isContinuously = i7 >= 7400 || !z;
        int iRoundToInt = MathKt.roundToInt(i7 * this.e);
        int iRoundToInt2 = MathKt.roundToInt(this.a * this.e);
        float f3 = this.rulerPadding;
        int i8 = this.b % 10;
        int i9 = 2;
        if (this.isContinuously) {
            width = getWidth() - (2 * f3);
            i = iRoundToInt2 - iRoundToInt;
        } else {
            width = getWidth() - (2 * f3);
            i = (iRoundToInt2 - iRoundToInt) - 125;
        }
        this.t = width / i;
        float height = getHeight() / 2.0f;
        if (iRoundToInt <= iRoundToInt2) {
            int i10 = iRoundToInt;
            while (true) {
                int i11 = this.tickTextSpace;
                boolean z2 = this.isContinuously;
                if (!z2) {
                    int i12 = i11 + 1;
                    i3 = i10 > 740 ? i10 + STBorder.INT_NORTHWEST : i10;
                    if (i3 > 1080) {
                        break;
                    } else {
                        i2 = i12;
                    }
                } else {
                    i2 = i11;
                    i3 = i10;
                }
                if (z2 || i3 <= 740 || i3 >= 875) {
                    if (z2 || i3 < 875 || (i3 - 875) % 10 != 0) {
                        int i13 = i3;
                        i4 = i10;
                        f = height;
                        if (z2 || i13 < 875 || (i13 - 875) % 5 != 0) {
                            int i14 = i13 - iRoundToInt;
                            if (i14 % 10 == 0) {
                                float f4 = 2;
                                float f5 = this.tickHeight / f4;
                                canvas.drawLine(f3, f - f5, f3, f5 + f, this.u);
                                float f6 = i13;
                                boolean z3 = this.r;
                                float f7 = (f6 / (z3 ? 10.0f : 0.1f)) + i8;
                                float f8 = this.a;
                                if (f7 > f8) {
                                    f7 = f8;
                                }
                                if (z3) {
                                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                    strValueOf = String.format(Locale.US, "%.02f", Arrays.copyOf(new Object[]{Float.valueOf(f7)}, 1));
                                    Intrinsics.checkNotNullExpressionValue(strValueOf, "format(locale, format, *args)");
                                } else {
                                    strValueOf = String.valueOf(MathKt.roundToInt(f7));
                                }
                                Rect rect = new Rect();
                                float fMeasureText = this.v.measureText(strValueOf);
                                this.v.getTextBounds(strValueOf, 0, strValueOf.length(), rect);
                                if (!this.r || (i14 / 10) % i2 == 0) {
                                    canvas.drawText(strValueOf, f3 - (fMeasureText / f4), (this.tickHeight / f4) + f + this.tickTextMarginTop + rect.height(), this.v);
                                }
                            } else {
                                if (i14 % 5 != 0) {
                                    f2 = this.tickHeight;
                                    i5 = 8;
                                }
                                float f9 = f2 / i5;
                                canvas.drawLine(f3, f - f9, f3, f9 + f, this.u);
                            }
                        }
                        f2 = this.tickHeight;
                        i5 = 4;
                        float f10 = f2 / i5;
                        canvas.drawLine(f3, f - f10, f3, f10 + f, this.u);
                    } else {
                        float f11 = i9;
                        float f12 = this.tickHeight / f11;
                        int i15 = i3;
                        i4 = i10;
                        f = height;
                        canvas.drawLine(f3, height - f12, f3, f12 + height, this.u);
                        float f13 = i15;
                        boolean z4 = this.r;
                        float f14 = (f13 / (z4 ? 10.0f : 0.1f)) + i8;
                        float f15 = this.a;
                        if (f14 > f15) {
                            f14 = f15;
                        }
                        if (z4) {
                            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                            strValueOf2 = String.format(Locale.US, "%.02f", Arrays.copyOf(new Object[]{Float.valueOf(f14)}, 1));
                            Intrinsics.checkNotNullExpressionValue(strValueOf2, "format(locale, format, *args)");
                        } else {
                            strValueOf2 = String.valueOf(MathKt.roundToInt(f14));
                        }
                        Rect rect2 = new Rect();
                        float fMeasureText2 = this.v.measureText(strValueOf2);
                        this.v.getTextBounds(strValueOf2, 0, strValueOf2.length(), rect2);
                        if (((i15 - iRoundToInt) / 10) % i2 == 0) {
                            canvas.drawText(strValueOf2, f3 - (fMeasureText2 / f11), (this.tickHeight / f11) + f + this.tickTextMarginTop + rect2.height(), this.v);
                        }
                    }
                    canvas.translate(this.t, 0.0f);
                    i6 = i4;
                    if (i6 != iRoundToInt2) {
                        break;
                    }
                    i10 = i6 + 1;
                    height = f;
                    i9 = 2;
                } else {
                    canvas.drawPoint(f3, height, this.u);
                    i4 = i10;
                    f = height;
                }
                canvas.translate(this.t, 0.0f);
                i6 = i4;
                if (i6 != iRoundToInt2) {
                    break;
                    break;
                } else {
                    i10 = i6 + 1;
                    height = f;
                    i9 = 2;
                }
            }
        }
        canvas.restore();
        float f16 = this.tickPosition;
        float height2 = getHeight() / 2.0f;
        float f17 = this.tickHeight / 2;
        canvas.drawLine(f16, height2 - f17, f16, f17 + height2, this.w);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int measuredWidth = getMeasuredWidth() > 0 ? getMeasuredWidth() : widthMeasureSpec;
        if (getMeasuredHeight() > 0) {
            widthMeasureSpec = getMeasuredHeight();
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        boolean z = (mode == 1073741824 && mode2 == 1073741824) ? false : true;
        if (mode != 1073741824) {
            measuredWidth = MathKt.roundToInt((this.t * (this.a - this.b)) + paddingLeft + paddingRight);
        }
        if (mode2 != 1073741824) {
            widthMeasureSpec = MathKt.roundToInt(this.tickHeight + this.tickTextSize + paddingTop + paddingBottom);
        }
        if (z) {
            setMeasuredDimension(measuredWidth, widthMeasureSpec);
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0016  */
    /* JADX WARN: Code duplicated, block: B:19:0x003b  */
    /* JADX WARN: Code duplicated, block: B:21:0x0072  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int i;
        boolean z;
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action == 1) {
                int iRoundToInt = MathKt.roundToInt(((event.getX() - this.rulerPadding) / this.t) / this.e);
                int i2 = this.b;
                i = iRoundToInt + i2;
                z = this.isContinuously;
                if (!z && i > 7400) {
                    i += 1250;
                }
                int i3 = (!z || i > 740) ? this.c : 3;
                int i4 = (i3 / 2) + i;
                float fValidPosition = validPosition(a(i4 - ((i4 - i2) % i3))) - this.tickPosition;
                this.mDx = fValidPosition;
                float f = 1;
                this.moveSpeed = f * ((float) Math.sqrt(Math.abs(fValidPosition / f)));
                getMHandler().removeCallbacks(this.D);
                this.D.run();
                this.p = false;
            } else if (action == 2) {
                this.p = true;
                this.q = true;
                float fValidPosition2 = validPosition(event.getX()) - this.tickPosition;
                this.mDx = fValidPosition2;
                float f2 = 1;
                this.moveSpeed = f2 * ((float) Math.sqrt(Math.abs(fValidPosition2 / f2)));
                getMHandler().removeCallbacks(this.D);
                this.D.run();
            } else if (action == 3) {
                int iRoundToInt2 = MathKt.roundToInt(((event.getX() - this.rulerPadding) / this.t) / this.e);
                int i5 = this.b;
                i = iRoundToInt2 + i5;
                z = this.isContinuously;
                if (!z) {
                    i += 1250;
                }
                if (z) {
                }
                int i6 = (i3 / 2) + i;
                float fValidPosition3 = validPosition(a(i6 - ((i6 - i5) % i3))) - this.tickPosition;
                this.mDx = fValidPosition3;
                float f3 = 1;
                this.moveSpeed = f3 * ((float) Math.sqrt(Math.abs(fValidPosition3 / f3)));
                getMHandler().removeCallbacks(this.D);
                this.D.run();
                this.p = false;
            }
        } else {
            this.p = true;
            this.q = true;
            float fValidPosition4 = validPosition(event.getX()) - this.tickPosition;
            this.mDx = fValidPosition4;
            float f4 = 1;
            this.moveSpeed = f4 * ((float) Math.sqrt(Math.abs(fValidPosition4 / f4)));
            getMHandler().removeCallbacks(this.D);
            this.D.run();
        }
        return true;
    }

    public final void setContinuously(boolean z) {
        this.isContinuously = z;
    }

    public final void setMDx(float f) {
        this.mDx = f;
    }

    public final void setMoveSpeed(float f) {
        this.moveSpeed = f;
    }

    public final void setOnTickChangedListener(OnTickChangedListener onTickChangedListener) {
        this.onTickChangedListener = onTickChangedListener;
    }

    public final void setRulerColor(int i) {
        if (this.rulerColor != i) {
            this.rulerColor = i;
            postInvalidate();
        }
    }

    public final void setRulerPadding(float f) {
        if (this.rulerPadding == f) {
            return;
        }
        this.rulerPadding = f;
        postInvalidate();
    }

    public final void setTickColor(int i) {
        if (this.tickColor != i) {
            this.tickColor = i;
            postInvalidate();
        }
    }

    public final void setTickHeight(float f) {
        if (this.tickHeight == f) {
            return;
        }
        this.tickHeight = f;
        postInvalidate();
    }

    public final void setTickPosition(float f) {
        if (this.tickPosition == f) {
            return;
        }
        this.tickPosition = f;
        postInvalidate();
    }

    public final void setTickTextMarginTop(int i) {
        if (this.tickTextMarginTop != i) {
            this.tickTextMarginTop = i;
            postInvalidate();
        }
    }

    public final void setTickTextSize(float f) {
        if (this.tickTextSize == f) {
            return;
        }
        this.tickTextSize = f;
        postInvalidate();
    }

    public final void setTickTextSpace(int i) {
        if (this.tickTextSpace != i) {
            this.tickTextSpace = i;
            postInvalidate();
        }
    }

    public final void setTickWidth(float f) {
        if (this.tickWidth == f) {
            return;
        }
        this.tickWidth = f;
        postInvalidate();
    }

    public final void setVernierColor(int i) {
        if (this.vernierColor != i) {
            this.vernierColor = i;
            postInvalidate();
        }
    }

    public final void setVernierWidth(float f) {
        if (this.vernierWidth == f) {
            return;
        }
        this.vernierWidth = f;
        postInvalidate();
    }

    public final void setup(int min, int max, int step) {
        this.a = max;
        this.b = min;
        this.c = step;
        invalidate();
    }

    public final void updateTick(int tick) {
        int i = this.a;
        int i2 = this.b;
        if (!(1 <= i2 && i2 < i) || this.c <= 0) {
            return;
        }
        float fValidPosition = validPosition(a(tick)) - this.tickPosition;
        this.mDx = fValidPosition;
        float f = 1;
        this.moveSpeed = f * ((float) Math.sqrt(Math.abs(fValidPosition / f)));
        getMHandler().removeCallbacks(this.D);
        this.D.run();
    }

    public final float validPosition(float position) {
        float f = this.rulerPadding;
        if (position <= f) {
            return f;
        }
        return position >= ((float) getWidth()) - this.rulerPadding ? getWidth() - this.rulerPadding : position;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VernierRulerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void a(VernierRulerView vernierRulerView) {
        Intrinsics.checkNotNullParameter(vernierRulerView, "this$0");
        if (vernierRulerView.p) {
            vernierRulerView.p = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VernierRulerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = 10800;
        this.b = 6400;
        this.c = 10;
        this.mTick = 6400;
        this.e = 0.1f;
        this.rulerPadding = 24.0f;
        this.rulerColor = Color.parseColor("#d1d1d1");
        this.tickColor = Color.parseColor("#d1d1d1");
        this.tickWidth = 1.0f;
        this.tickHeight = 30.0f;
        this.tickTextSize = 18.0f;
        this.tickTextMarginTop = 4;
        this.tickTextSpace = 2;
        this.vernierColor = -65536;
        this.vernierWidth = 3.0f;
        this.r = true;
        this.isContinuously = true;
        this.t = 4.0f;
        Paint paint = new Paint(1);
        this.u = paint;
        Paint paint2 = new Paint(1);
        this.v = paint2;
        Paint paint3 = new Paint(1);
        this.w = paint3;
        this.tickPosition = this.rulerPadding;
        this.mHandler = LazyKt.lazy(new Function0<Handler>() { // from class: qin.widgets.VernierRulerView$mHandler$2
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Handler m1invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        this.resetTouch = new Runnable() { // from class: qin.widgets.VernierRulerView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                VernierRulerView.a(this.f$0);
            }
        };
        this.D = new VernierRulerView$updateVernier$1(this);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.VernierRulerView, i, 0);
        this.a = typedArrayObtainStyledAttributes.getInt(R.styleable.VernierRulerView_max, this.a);
        this.b = typedArrayObtainStyledAttributes.getInt(R.styleable.VernierRulerView_min, this.b);
        this.c = typedArrayObtainStyledAttributes.getInt(R.styleable.VernierRulerView_step, this.c);
        setRulerPadding(typedArrayObtainStyledAttributes.getFloat(R.styleable.VernierRulerView_rulerPadding, 24.0f));
        setRulerColor(typedArrayObtainStyledAttributes.getColor(R.styleable.VernierRulerView_rulerColor, this.rulerColor));
        setTickWidth(typedArrayObtainStyledAttributes.getFloat(R.styleable.VernierRulerView_tickWidth, 1.0f));
        paint.setColor(this.rulerColor);
        paint.setStrokeWidth(this.tickWidth);
        setTickHeight(typedArrayObtainStyledAttributes.getFloat(R.styleable.VernierRulerView_maxTickHeight, 30.0f));
        setTickColor(typedArrayObtainStyledAttributes.getColor(R.styleable.VernierRulerView_tickTextColor, -65536));
        setTickTextSize(typedArrayObtainStyledAttributes.getFloat(R.styleable.VernierRulerView_tickTextSize, this.tickTextSize));
        setTickTextMarginTop(typedArrayObtainStyledAttributes.getInt(R.styleable.VernierRulerView_tickText_marginTop, this.tickTextMarginTop));
        setTickTextSpace(typedArrayObtainStyledAttributes.getInt(R.styleable.VernierRulerView_tickText_space, this.tickTextSpace));
        paint2.setTextSize(this.tickTextSize);
        paint2.setColor(this.tickColor);
        setVernierColor(typedArrayObtainStyledAttributes.getColor(R.styleable.VernierRulerView_vernierColor, this.vernierColor));
        setVernierWidth(typedArrayObtainStyledAttributes.getFloat(R.styleable.VernierRulerView_vernierWidth, 3.0f));
        paint3.setColor(this.vernierColor);
        paint3.setStrokeWidth(this.vernierWidth);
        typedArrayObtainStyledAttributes.recycle();
    }
}
