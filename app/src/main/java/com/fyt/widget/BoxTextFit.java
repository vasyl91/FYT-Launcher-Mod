package com.fyt.widget;

import android.text.TextPaint;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.android.launcher66.Launcher;

/**
 * Keeps the text of a view that sits alone in a box (the date and the week day of the date
 * widget) inside that box: its parent. The size comes from the width and the height the parent
 * really has, measured with the view's own paint, so a long text (Wednesday, a long date) is made
 * smaller and a short one grows back to the widget text size. Not AppCompat autosize: that one
 * left the last character of the date cut off.
 *
 * The view's line takes {@link #HEIGHT_SHARE} of the box, the layout splits the rest into equal
 * gaps with spacers.
 */
final class BoxTextFit implements View.OnLayoutChangeListener {

    /** Two lines of 30 % leave 40 % for the three gaps. */
    static final float HEIGHT_SHARE = 0.3f;

    /** As the radio widget: never smaller. */
    private static final float MIN_SP = 8f;

    private final TextView mView;
    private View mParent;

    BoxTextFit(TextView view) {
        mView = view;
    }

    void attach() {
        detach();
        if (mView.getParent() instanceof View) {
            mParent = (View) mView.getParent();
            mParent.addOnLayoutChangeListener(this);
        }
    }

    void detach() {
        if (mParent != null) {
            mParent.removeOnLayoutChangeListener(this);
            mParent = null;
        }
    }

    @Override
    public void onLayoutChange(View v, int left, int top, int right, int bottom,
                               int oldLeft, int oldTop, int oldRight, int oldBottom) {
        fit();
    }

    void fit() {
        if (mParent == null) return;
        float availableWidth = mParent.getWidth() - mParent.getPaddingLeft() - mParent.getPaddingRight()
                - mView.getPaddingLeft() - mView.getPaddingRight();
        float availableHeight = mParent.getHeight();
        CharSequence text = mView.getText();
        if (availableWidth <= 0f || availableHeight <= 0f || text == null || text.length() == 0) return;

        float density = mView.getResources().getDisplayMetrics().scaledDensity;
        float maxPx = Math.max(Launcher.widgetTextSizeBasic, MIN_SP) * density;
        TextPaint paint = new TextPaint(mView.getPaint());
        paint.setTextSize(maxPx);
        TextPaint.FontMetrics fm = paint.getFontMetrics();
        float sizePx = TextFit.fitBox(maxPx, paint.measureText(text.toString()),
                fm.descent - fm.ascent, availableWidth, availableHeight, HEIGHT_SHARE);
        sizePx = Math.max(sizePx, MIN_SP * density);
        if (Math.abs(mView.getTextSize() - sizePx) >= 0.5f) {
            mView.setTextSize(TypedValue.COMPLEX_UNIT_PX, sizePx);
        }
    }
}
