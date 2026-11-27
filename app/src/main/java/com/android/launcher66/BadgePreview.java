package com.android.launcher66;

import android.content.Context;
import android.widget.ImageView;

/**
 * What the badge settings' preview needs of the launcher: the size of the icons of the home screen (the grid's icon size
 * in pixels, a plain size where the launcher has not made its grid yet) and the badge over the preview icon, made with
 * {@link BadgeStyle} like the real ones. Public, as the settings are another package.
 */
public final class BadgePreview {

    /** The number the preview shows. */
    static final int NUMBER = 4;

    private BadgePreview() {
    }

    /** The size of an icon of the home screen, in pixels. */
    public static int iconSizePx(Context context) {
        LauncherAppState state = LauncherAppState.getInstanceNoCreate();
        try {
            if (state != null && state.getDynamicGrid() != null) {
                int px = (int) state.getDynamicGrid().getDeviceProfile().iconSizePx;
                if (px > 0) {
                    return px;
                }
            }
        } catch (RuntimeException e) {
            // no grid yet: the plain size below
        }
        return Math.round(56f * context.getResources().getDisplayMetrics().density);
    }

    /** Puts the badge of "4" over the icon image of the preview, in the colour of the home screen's icon text. */
    public static void show(ImageView icon, int sizePx) {
        Context context = icon.getContext();
        Object old = icon.getTag(R.id.badge_host);
        if (old instanceof BadgeDrawable) {
            icon.getOverlay().remove((BadgeDrawable) old);
        }
        BadgeDrawable drawable = new BadgeDrawable(context);
        drawable.setBounds(0, 0, sizePx, sizePx);
        // sized by the picture as it is seen, as on the home screen
        drawable.setVisible(IconBounds.of(icon.getDrawable()));
        drawable.set(NUMBER, BadgeStyle.load(context), BadgeModel.iconTextColor(context));
        icon.getOverlay().add(drawable);
        icon.setTag(R.id.badge_host, drawable);
    }
}
