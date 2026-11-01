package com.android.launcher66;

import android.graphics.Paint;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Sizes the children of the home screen's radio widget (absolute_radio) from the size the widget
 * has, following the plan RadioWidgetPlan makes: the band and unit labels, the prev/next buttons
 * and the frequency. Like MusicWidgetSizer it listens for the widget's layout, so a resize in the
 * layout wizard is followed, and it does nothing when the inputs are those of the last time (no
 * layout loop).
 */
final class RadioWidgetSizer implements View.OnLayoutChangeListener {

    private static final String TAG = "RadioWidgetSizer";

    /** Every label the widget can show: the widest decides the column. */
    private static final String[] LABELS = {"FM", "AM", "FM1", "FM2", "FM3", "AM1", "AM2", "MHz", "KHz"};

    /** The widest frequency the widget can show. */
    private static final String WIDEST_FREQ = "108.00";

    private final View mRoot;
    private final Runnable mApply = this::applyScheduled;
    private boolean mScheduled;
    private int mLastW = -1;
    private int mLastH = -1;
    private String mLastPlan;

    private RadioWidgetSizer(View root) {
        mRoot = root;
    }

    /** Starts sizing {@code root}; a sizer the root already has is replaced, not added to. */
    static RadioWidgetSizer attach(View root) {
        if (root == null) {
            return null;
        }
        Object old = root.getTag(R.id.rl_radio);
        if (old instanceof RadioWidgetSizer) {
            root.removeOnLayoutChangeListener((RadioWidgetSizer) old);
        }
        RadioWidgetSizer sizer = new RadioWidgetSizer(root);
        root.setTag(R.id.rl_radio, sizer);
        root.addOnLayoutChangeListener(sizer);
        root.post(sizer.mApply);
        return sizer;
    }

    @Override
    public void onLayoutChange(View v, int left, int top, int right, int bottom,
            int oldLeft, int oldTop, int oldRight, int oldBottom) {
        if (right - left == oldRight - oldLeft && bottom - top == oldBottom - oldTop) {
            return;
        }
        if (!mScheduled) {
            mScheduled = true;
            mRoot.post(mApply);
        }
    }

    private void applyScheduled() {
        mScheduled = false;
        if (!mRoot.isAttachedToWindow() || !mRoot.isLaidOut()) {
            return;
        }
        int w = mRoot.getWidth();
        int h = mRoot.getHeight();
        if (w <= 0 || h <= 0 || (w == mLastW && h == mLastH)) {
            return;
        }
        mLastW = w;
        mLastH = h;

        TextView freq = mRoot.findViewById(R.id.tv_freq);
        TextView band = mRoot.findViewById(R.id.tv_band);
        float density = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 1f,
                mRoot.getResources().getDisplayMetrics());
        float labelPerPx = 0f;
        Paint labelPaint = new Paint((band != null ? band.getPaint() : new Paint()));
        labelPaint.setTextSize(100f);
        for (String label : LABELS) {
            labelPerPx = Math.max(labelPerPx, labelPaint.measureText(label) / 100f);
        }
        Paint freqPaint = new Paint((freq != null ? freq.getPaint() : new Paint()));
        freqPaint.setTextSize(100f);
        // A little air on both sides of the frequency.
        float freqPerPx = freqPaint.measureText(WIDEST_FREQ) / 100f * 1.08f;

        RadioWidgetPlan.Plan plan = RadioWidgetPlan.plan(w, h, density, labelPerPx, freqPerPx);

        if (mRoot.getPaddingLeft() != plan.paddingPx || mRoot.getPaddingTop() != plan.paddingPx) {
            mRoot.setPadding(plan.paddingPx, plan.paddingPx, plan.paddingPx, plan.paddingPx);
        }
        sizeColumn(R.id.radio_col_left, plan);
        sizeColumn(R.id.radio_col_right, plan);
        sizeLabel(band, plan);
        sizeLabel(mRoot.findViewById(R.id.tv_unit), plan);
        sizeButton(mRoot.findViewById(R.id.radio_btn_prev), plan);
        sizeButton(mRoot.findViewById(R.id.radio_btn_next), plan);
        if (freq != null) {
            setTextPx(freq, plan.freqTextPx);
            setMargins(freq, plan.gapPx, 0);
        }

        String planText = plan.toString();
        if (!planText.equals(mLastPlan)) {
            mLastPlan = planText;
            Log.d(TAG, w + "x" + h + " -> " + planText);
        }
    }

    private void sizeColumn(int id, RadioWidgetPlan.Plan plan) {
        View column = mRoot.findViewById(id);
        if (column == null) {
            return;
        }
        ViewGroup.LayoutParams lp = column.getLayoutParams();
        if (lp != null && lp.width != plan.columnPx) {
            lp.width = plan.columnPx;
            column.setLayoutParams(lp);
        }
    }

    private void sizeLabel(TextView label, RadioWidgetPlan.Plan plan) {
        if (label == null) {
            return;
        }
        setTextPx(label, plan.labelTextPx);
        ViewGroup.LayoutParams lp = label.getLayoutParams();
        if (lp != null && lp.height != plan.labelRowPx) {
            lp.height = plan.labelRowPx;
            label.setLayoutParams(lp);
        }
    }

    private void sizeButton(View button, RadioWidgetPlan.Plan plan) {
        if (button == null) {
            return;
        }
        ViewGroup.LayoutParams lp = button.getLayoutParams();
        if (lp != null && (lp.width != plan.buttonPx || lp.height != plan.buttonPx)) {
            lp.width = plan.buttonPx;
            lp.height = plan.buttonPx;
            button.setLayoutParams(lp);
        }
        setMargins(button, 0, plan.gapPx);
    }

    /** Left/right margin {@code side}, top margin {@code top}. */
    private static void setMargins(View view, int side, int top) {
        ViewGroup.LayoutParams raw = view.getLayoutParams();
        if (!(raw instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) raw;
        if (lp.leftMargin != side || lp.rightMargin != side || lp.topMargin != top) {
            lp.leftMargin = side;
            lp.rightMargin = side;
            lp.topMargin = top;
            view.setLayoutParams(lp);
        }
    }

    private static void setTextPx(TextView view, float px) {
        if (Math.abs(view.getTextSize() - px) > 0.5f) {
            view.setTextSize(TypedValue.COMPLEX_UNIT_PX, px);
        }
    }
}
