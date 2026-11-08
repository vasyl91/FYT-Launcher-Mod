package com.android.launcher66.settings;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.android.launcher66.CreatorBars;
import com.android.launcher66.R;

/**
 * The parts of the bars that a layout creator shows beside its own controls, as the home screen shows them
 * (see {@link CreatorBars} for the rules): the collapsed bar's button with its arrow, and the edge handle's
 * strip. They are pictures, with no touch: the creator's double tap hides its controls (the bar), and this is
 * what the home screen has in its place, so they are shown while the controls are hidden. Their height is that
 * of the controls' bar, which is the height of the horizontal bar in the preview.
 */
final class CreatorBarMarks {

    private static final int STRIP_COLOR = 0x73FFFFFF;     // the handle's colour at rest
    private static final float BUTTON_ALPHA = 0.5f;

    private final View button;
    private final View strip;

    private CreatorBarMarks(View button, View strip) {
        this.button = button;
        this.strip = strip;
    }

    /**
     * @param withButtonView add the button too (the creator of the first page has its own, in its layout)
     * @param buttonWidthPx  the button's width, the vertical bar's
     */
    static CreatorBarMarks install(ConstraintLayout root, View controls, CreatorBars bars, boolean withButtonView,
                                   int buttonWidthPx) {
        Context context = root.getContext();
        View button = null;
        View strip = null;
        if (withButtonView && bars.button != null) {
            button = buildButton(context, bars.arrowRotation);
            boolean right = bars.arrowRotation == 180f;
            root.addView(button, anchored(buttonWidthPx, bars.top, right));
        }
        if (bars.handle != null) {
            DisplayMetrics metrics = context.getResources().getDisplayMetrics();
            // The strip is a share of the longer edge, in the preview as on the screen
            int width = Math.max(1, Math.round(Math.max(metrics.widthPixels, metrics.heightPixels)
                    * com.android.launcher66.CreatorBars.STRIP_WIDTH_FRACTION));
            strip = new View(context);
            strip.setBackgroundColor(STRIP_COLOR);
            root.addView(strip, anchored(width, bars.top, bars.handleRight));
        }
        CreatorBarMarks marks = new CreatorBarMarks(button, strip);
        marks.follow(root, controls);
        marks.setControlsShown(controls == null || controls.getVisibility() == View.VISIBLE);
        return marks;
    }

    /** Adds the arrow to the creator's own collapsed bar (a coloured rectangle in its layout). */
    static void addArrow(View collapsedBar, float rotation) {
        if (!(collapsedBar instanceof ViewGroup) || collapsedBar.findViewWithTag("creator_arrow") != null) {
            return;
        }
        ViewGroup group = (ViewGroup) collapsedBar;
        ImageView arrow = buildArrow(group.getContext(), rotation);
        arrow.setTag("creator_arrow");
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(0, 0);
        params.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        params.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        params.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
        group.addView(arrow, params);
    }

    void setControlsShown(boolean controlsShown) {
        int visibility = controlsShown ? View.GONE : View.VISIBLE;
        if (button != null) {
            button.setVisibility(visibility);
        }
        if (strip != null) {
            strip.setVisibility(visibility);
        }
    }

    private static ConstraintLayout.LayoutParams anchored(int widthPx, boolean top, boolean right) {
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(widthPx, 0);
        if (top) {
            params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        } else {
            params.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
        }
        if (right) {
            params.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        } else {
            params.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        }
        return params;
    }

    private static View buildButton(Context context, float rotation) {
        FrameLayout frame = new FrameLayout(context);
        frame.setBackgroundResource(R.color.colorPrimaryDark);
        frame.addView(buildArrow(context, rotation), new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, Gravity.CENTER));
        return frame;
    }

    private static ImageView buildArrow(Context context, float rotation) {
        ImageView arrow = new ImageView(context);
        arrow.setImageResource(R.drawable.show_bar);
        arrow.setScaleType(ImageView.ScaleType.FIT_CENTER);
        arrow.setAlpha(BUTTON_ALPHA);
        arrow.setRotation(rotation);
        int pad = Math.round(context.getResources().getDisplayMetrics().density * 6);
        arrow.setPadding(pad, pad, pad, pad);
        return arrow;
    }

    /** Keeps the height of the marks that of the controls' bar, also while the controls are hidden. */
    private void follow(ConstraintLayout root, View controls) {
        final int[] cached = {0};
        root.addOnLayoutChangeListener((v, l, t, r, b, ol, ot, or, ob) -> {
            int height = controls != null && controls.getHeight() > 0 ? controls.getHeight() : cached[0];
            if (height <= 0) {
                height = Math.round((b - t) * 0.1638f);   // the share the creators' layouts give the bar
            }
            cached[0] = height;
            setHeight(button, height);
            setHeight(strip, height);
        });
    }

    private static void setHeight(View view, int height) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params != null && params.height != height) {
            params.height = height;
            view.setLayoutParams(params);
        }
    }
}
