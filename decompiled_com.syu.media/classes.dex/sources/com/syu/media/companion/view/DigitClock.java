package com.syu.media.companion.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import chip.FinalChip;
import com.syu.media.R;
import com.syu.media.companion.utils.TimeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DigitClock.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\f\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0014\u001a\u00020\u0015H\u0003J\b\u0010\u0016\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/syu/media/companion/view/DigitClock;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "images", FinalChip.BSP_PLATFORM_Null, "timeHandler", "Landroid/os/Handler;", "timeRunnable", "com/syu/media/companion/view/DigitClock$timeRunnable$1", "Lcom/syu/media/companion/view/DigitClock$timeRunnable$1;", "tv1", "Landroid/widget/TextView;", "tv2", "tv3", "tv4", "tv5", "initViews", FinalChip.BSP_PLATFORM_Null, "timeRun", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DigitClock extends RelativeLayout {
    private final Context context;
    private final int[] images;
    private Handler timeHandler;
    private final DigitClock$timeRunnable$1 timeRunnable;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.syu.media.companion.view.DigitClock$timeRunnable$1] */
    public DigitClock(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        this.context = context;
        this.images = new int[]{R.drawable.t0, R.drawable.t1, R.drawable.t2, R.drawable.t3, R.drawable.t4, R.drawable.t5, R.drawable.t6, R.drawable.t7, R.drawable.t8, R.drawable.t9};
        this.timeRunnable = new Runnable() { // from class: com.syu.media.companion.view.DigitClock$timeRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                this.this$0.postInvalidate();
                String curTimeHour = TimeUtils.INSTANCE.getCurTimeHour(this.this$0.context);
                Intrinsics.checkNotNull(curTimeHour);
                char[] charArray = curTimeHour.toCharArray();
                Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
                int length = charArray.length;
                TextView textView = null;
                if (length == 3) {
                    TextView textView2 = this.this$0.tv1;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tv1");
                        textView2 = null;
                    }
                    textView2.setVisibility(8);
                    TextView textView3 = this.this$0.tv1;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tv1");
                        textView3 = null;
                    }
                    textView3.setBackgroundResource(0);
                } else if (length > 3) {
                    TextView textView4 = this.this$0.tv1;
                    if (textView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tv1");
                        textView4 = null;
                    }
                    textView4.setVisibility(0);
                }
                int iCoerceAtLeast = RangesKt.coerceAtLeast(0, RangesKt.coerceAtMost(Integer.parseInt(new String(new char[]{charArray[0]})), this.this$0.images.length));
                TextView textView5 = this.this$0.tv1;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tv1");
                    textView5 = null;
                }
                textView5.setBackgroundResource(this.this$0.images[iCoerceAtLeast]);
                int iCoerceAtLeast2 = RangesKt.coerceAtLeast(0, RangesKt.coerceAtMost(Integer.parseInt(new String(new char[]{charArray[1]})), this.this$0.images.length));
                TextView textView6 = this.this$0.tv2;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tv2");
                    textView6 = null;
                }
                textView6.setBackgroundResource(this.this$0.images[iCoerceAtLeast2]);
                int iCoerceAtLeast3 = RangesKt.coerceAtLeast(0, RangesKt.coerceAtMost(Integer.parseInt(new String(new char[]{charArray[2]})), this.this$0.images.length));
                TextView textView7 = this.this$0.tv4;
                if (textView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tv4");
                    textView7 = null;
                }
                textView7.setBackgroundResource(this.this$0.images[iCoerceAtLeast3]);
                int iCoerceAtLeast4 = RangesKt.coerceAtLeast(0, RangesKt.coerceAtMost(Integer.parseInt(new String(new char[]{charArray[3]})), this.this$0.images.length));
                TextView textView8 = this.this$0.tv5;
                if (textView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tv5");
                } else {
                    textView = textView8;
                }
                textView.setBackgroundResource(this.this$0.images[iCoerceAtLeast4]);
                Handler handler = this.this$0.timeHandler;
                Intrinsics.checkNotNull(handler);
                handler.postDelayed(this, 1000L);
            }
        };
        initViews();
    }

    private final void initViews() {
        this.tv1 = new TextView(this.context);
        this.tv2 = new TextView(this.context);
        this.tv3 = new TextView(this.context);
        this.tv4 = new TextView(this.context);
        this.tv5 = new TextView(this.context);
        TextView textView = this.tv1;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv1");
            textView = null;
        }
        textView.setId(1);
        TextView textView3 = this.tv2;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv2");
            textView3 = null;
        }
        textView3.setId(2);
        TextView textView4 = this.tv3;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv3");
            textView4 = null;
        }
        textView4.setId(3);
        TextView textView5 = this.tv4;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv4");
            textView5 = null;
        }
        textView5.setId(4);
        TextView textView6 = this.tv5;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv5");
            textView6 = null;
        }
        textView6.setId(5);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(20);
        TextView textView7 = this.tv1;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv1");
            textView7 = null;
        }
        addView(textView7, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        TextView textView8 = this.tv1;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv1");
            textView8 = null;
        }
        layoutParams2.addRule(17, textView8.getId());
        TextView textView9 = this.tv2;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv2");
            textView9 = null;
        }
        addView(textView9, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        TextView textView10 = this.tv2;
        if (textView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv2");
            textView10 = null;
        }
        layoutParams3.addRule(17, textView10.getId());
        TextView textView11 = this.tv3;
        if (textView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv3");
            textView11 = null;
        }
        addView(textView11, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        TextView textView12 = this.tv3;
        if (textView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv3");
            textView12 = null;
        }
        layoutParams4.addRule(17, textView12.getId());
        TextView textView13 = this.tv4;
        if (textView13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv4");
            textView13 = null;
        }
        addView(textView13, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        TextView textView14 = this.tv4;
        if (textView14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv4");
            textView14 = null;
        }
        layoutParams5.addRule(17, textView14.getId());
        TextView textView15 = this.tv5;
        if (textView15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv5");
            textView15 = null;
        }
        addView(textView15, layoutParams5);
        TextView textView16 = this.tv3;
        if (textView16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv3");
        } else {
            textView2 = textView16;
        }
        textView2.setBackgroundResource(R.drawable.tdot);
        timeRun();
    }

    private final void timeRun() {
        Handler handler = new Handler();
        this.timeHandler = handler;
        Intrinsics.checkNotNull(handler);
        handler.post(this.timeRunnable);
    }
}
