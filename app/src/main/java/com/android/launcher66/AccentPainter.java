package com.android.launcher66;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.AbsSeekBar;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CompoundButtonCompat;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Colours a tree of views with the one accent colour of the settings ({@link ThemeAccent}).
 *
 * <p>The rules (the owner, 2026-11-25, D-86):
 * <ul>
 *   <li>What the layouts and the themes colour with the default accent ({@code R.color.colorAccent}) is coloured with
 *       the chosen one: a text in that colour, a progress or a thumb tinted with it, a background or a drawable
 *       (also inside a layer list) that is that colour, a view tagged {@code @string/tag_accent}. The colour a view
 *       was painted with is kept in it ({@code R.id.accent_painted}), so that a later change finds what the
 *       last one painted: a colour counts as the accent when it is the default or the last painted one.</li>
 *   <li>Check boxes and radio buttons have the mark in the accent when checked. A switch is not one of them:
 *       it has colours of its own.</li>
 *   <li>The colour is the user's only with the creator on ({@link ThemeAccent#color}); with "Stock layout" the
 *       default comes back.</li>
 * </ul>
 * Painting is a walk over the views with a few compares; it is done when a row of a list is attached, when a
 * dialog is shown and when the colour changes. Main thread only.
 */
public final class AccentPainter {

    private static final int DEFAULT = ThemeAccent.DEFAULT;

    private AccentPainter() {
    }

    /** Paints the views under {@code root} with the accent now. */
    public static void paint(View root) {
        if (root != null) {
            paint(root, ThemeAccent.color(root.getContext()));
        }
    }

    /** Paints the views under {@code root} with this colour. */
    public static void paint(View root, int accent) {
        if (root == null) {
            return;
        }
        paintOne(root, accent);
        if (root instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) root;
            for (int i = 0; i < group.getChildCount(); i++) {
                paint(group.getChildAt(i), accent);
            }
        }
    }

    /**
     * Keeps the rows of a list painted: every row that comes onto the list is painted when it is attached (the
     * settings' lists bind their rows before they attach them), and the rows there now are painted at once.
     */
    public static void attach(final RecyclerView list) {
        if (list == null) {
            return;
        }
        list.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {
                paint(view);
            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {
            }
        });
        for (int i = 0; i < list.getChildCount(); i++) {
            paint(list.getChildAt(i));
        }
    }

    /** The colour changed: the rows of the list are painted again, those off the screen when they come. */
    public static void repaint(RecyclerView list) {
        if (list == null) {
            return;
        }
        for (int i = 0; i < list.getChildCount(); i++) {
            paint(list.getChildAt(i));
        }
        RecyclerView.Adapter<?> adapter = list.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    /**
     * Paints a dialog with the accent when it is shown and for the first layouts after it (a list's rows are made by
     * the first of them). It does not use the dialog's show listener, which its maker may set for itself.
     */
    public static void watch(Dialog dialog) {
        Window window = dialog == null ? null : dialog.getWindow();
        if (window == null) {
            return;
        }
        final View decor = window.getDecorView();
        decor.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View v) {
                paint(decor);
                final int[] passes = {0};
                decor.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        paint(decor);
                        if (++passes[0] >= 4) {
                            ViewTreeObserver observer = decor.getViewTreeObserver();
                            if (observer.isAlive()) {
                                observer.removeOnGlobalLayoutListener(this);
                            }
                        }
                    }
                });
            }

            @Override
            public void onViewDetachedFromWindow(View v) {
            }
        });
    }

    // ------------------------------------------------------------------ one view

    /** The colour this view was last painted with, 0 if never. */
    private static int last(View view) {
        Object tag = view.getTag(R.id.accent_painted);
        return tag instanceof Integer ? (Integer) tag : 0;
    }

    private static boolean tagged(View view) {
        return "accent".equals(view.getTag());
    }

    /** Whether a colour is the accent as it was last painted on this view, or the default. */
    private static boolean isAccent(int color, int last) {
        return color == DEFAULT || (last != 0 && color == last);
    }

    private static boolean isAccent(ColorStateList list, int last) {
        return list != null && isAccent(list.getDefaultColor(), last);
    }

    private static void paintOne(View view, int accent) {
        int last = last(view);
        boolean tagged = tagged(view);
        boolean painted = false;

        if (view instanceof TextView) {
            TextView text = (TextView) view;
            if (tagged || isAccent(text.getCurrentTextColor(), last)) {
                text.setTextColor(accent);
                painted = true;
            }
        }

        if (view instanceof CompoundButton && !(view instanceof SwitchCompat)) {
            CompoundButton button = (CompoundButton) view;
            // A check box or a radio button has no tint of its own, the theme gives it its colours: the mark of one
            // that is checked is the accent
            CompoundButtonCompat.setButtonTintList(button, marks(button.getContext(), accent));
            painted = true;
        }

        if (view instanceof AbsSeekBar) {
            AbsSeekBar seek = (AbsSeekBar) view;
            if (tagged || isAccent(seek.getProgressTintList(), last)) {
                seek.setProgressTintList(ColorStateList.valueOf(accent));
                seek.setProgressTintMode(PorterDuff.Mode.SRC_IN);
                painted = true;
            }
            Drawable thumb = seek.getThumb();
            if (thumb != null && (tagged || isAccent(seek.getThumbTintList(), last) || recolor(thumb, accent, last))) {
                if (isAccent(seek.getThumbTintList(), last) || (tagged && !recolor(thumb, accent, last))) {
                    seek.setThumbTintList(ColorStateList.valueOf(accent));
                    seek.setThumbTintMode(PorterDuff.Mode.SRC_IN);
                }
                painted = true;
            }
        } else if (view instanceof ProgressBar) {
            ProgressBar bar = (ProgressBar) view;
            if (tagged || isAccent(bar.getProgressTintList(), last) || isAccent(bar.getIndeterminateTintList(), last)) {
                bar.setProgressTintList(ColorStateList.valueOf(accent));
                bar.setIndeterminateTintList(ColorStateList.valueOf(accent));
                painted = true;
            }
        }

        ColorStateList backgroundTint = ViewCompat.getBackgroundTintList(view);
        if (isAccent(backgroundTint, last)) {
            ViewCompat.setBackgroundTintList(view, ColorStateList.valueOf(accent));
            painted = true;
        }
        Drawable background = view.getBackground();
        if (background != null) {
            if (background instanceof ColorDrawable && (tagged || isAccent(((ColorDrawable) background).getColor(), last))) {
                view.setBackgroundColor(accent);
                painted = true;
            } else if (!(background instanceof ColorDrawable) && recolor(background, accent, last)) {
                painted = true;
            } else if (tagged && !(view instanceof TextView) && backgroundTint == null
                    && !(background instanceof ColorDrawable)) {
                ViewCompat.setBackgroundTintList(view, ColorStateList.valueOf(accent));
                painted = true;
            }
        }

        if (painted) {
            view.setTag(R.id.accent_painted, accent);
        }
    }

    /**
     * Gives the plain fills of the accent inside a drawable (a shape, a layer list of shapes) the new colour; whether it
     * found any. The fills of other colours (a transparent one in the same layer list) stay.
     */
    static boolean recolor(Drawable drawable, int accent, int last) {
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layers = (LayerDrawable) drawable;
            boolean any = false;
            for (int i = 0; i < layers.getNumberOfLayers(); i++) {
                any |= recolor(layers.getDrawable(i), accent, last);
            }
            return any;
        }
        if (drawable instanceof GradientDrawable) {
            GradientDrawable shape = (GradientDrawable) drawable;
            ColorStateList fill = shape.getColor();
            if (fill != null && isAccent(fill.getDefaultColor(), last)) {
                ((GradientDrawable) shape.mutate()).setColor(accent);
                return true;
            }
            return false;
        }
        if (drawable instanceof ColorDrawable && isAccent(((ColorDrawable) drawable).getColor(), last)) {
            ((ColorDrawable) drawable.mutate()).setColor(accent);
            return true;
        }
        return false;
    }

    /** Checked in the accent, otherwise the colour the theme gives an unchecked control. */
    private static ColorStateList marks(Context context, int accent) {
        TypedValue normal = new TypedValue();
        int unchecked = 0xff808080;
        if (context.getTheme().resolveAttribute(androidx.appcompat.R.attr.colorControlNormal, normal, true)) {
            unchecked = normal.resourceId != 0 ? ContextCompat.getColor(context, normal.resourceId) : normal.data;
        }
        return new ColorStateList(
                new int[][] {new int[] {android.R.attr.state_checked}, new int[0]},
                new int[] {accent, unchecked});
    }
}
