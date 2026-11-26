package com.android.launcher66;

import android.content.ComponentName;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * The views that show a notification badge, and what they need to be told: which app an icon stands for, and when the number
 * of an app changed ({@link BadgeModel}).
 *
 * <p>The rule (H1): only the views of the apps whose number changed are redrawn. Every icon view that draws a badge
 * ({@code BubbleTextView}, {@code PagedViewIcon}, {@code FolderIcon}) registers itself here while it is on a window; an icon of
 * a bar's list (an ImageView of the recycler lists, in windows of their own) is given its badge by {@link #bindBarIcon}. A
 * registry keeps the hosts weakly, so that nothing is held after a view is gone. Main thread.
 */
public final class BadgeViews {

    /** A view that draws a badge. */
    interface Host {
        /** Whether the view shows an app of the set ({@code null}: any). */
        boolean showsPackage(Set<String> packages);

        /** The number may have changed: draw again. */
        void refreshBadge();
    }

    private static final Set<Host> HOSTS = Collections.newSetFromMap(new WeakHashMap<Host, Boolean>());

    private BadgeViews() {
    }

    static void register(Host host) {
        HOSTS.add(host);
    }

    static void unregister(Host host) {
        HOSTS.remove(host);
    }

    /** The views of these apps are drawn again ({@code null}: every view). */
    static void refreshAll(Set<String> packages) {
        for (Host host : new ArrayList<>(HOSTS)) {
            if (packages == null || host.showsPackage(packages)) {
                host.refreshBadge();
            }
        }
    }

    /** The package of an item's intent, or null. */
    static String packageOf(Intent intent) {
        if (intent == null) {
            return null;
        }
        ComponentName component = intent.getComponent();
        return component != null ? component.getPackageName() : intent.getPackage();
    }

    // ------------------------------------------------------------------ the icons of the bars' lists

    /** The badge of one icon in a bar's list: its overlay drawable, and the app the icon stands for. */
    private static final class BarBadge implements Host {
        final ImageView icon;
        final BadgeDrawable drawable;
        String packageName;

        BarBadge(ImageView icon) {
            this.icon = icon;
            this.drawable = new BadgeDrawable(icon.getContext());
            icon.getOverlay().add(drawable);
            icon.addOnLayoutChangeListener((v, l, t, r, b, ol, ot, or, ob) -> drawable.setBounds(0, 0, r - l, b - t));
            icon.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                @Override
                public void onViewAttachedToWindow(View v) {
                    register(BarBadge.this);
                    refreshBadge();
                }

                @Override
                public void onViewDetachedFromWindow(View v) {
                    unregister(BarBadge.this);
                }
            });
            drawable.setBounds(0, 0, icon.getWidth(), icon.getHeight());
        }

        @Override
        public boolean showsPackage(Set<String> packages) {
            return packageName != null && packages.contains(packageName);
        }

        @Override
        public void refreshBadge() {
            BadgeModel model = BadgeModel.get();
            int count = packageName == null ? 0 : model.count(packageName);
            drawable.setBounds(0, 0, icon.getWidth(), icon.getHeight());
            // the text colour of the bars' icons is the home screen's (the icon text colour)
            drawable.set(count, model.style(icon.getContext()), BadgeModel.iconTextColor(icon.getContext()));
        }
    }

    /**
     * An icon of a bar's list stands for this app now (a row of the list is bound again for another app, or the same):
     * the badge follows. Call with {@code null} for a row that is no app.
     */
    public static void bindBarIcon(ImageView icon, String packageName) {
        Object tag = icon.getTag(R.id.badge_host);
        BarBadge badge;
        if (tag instanceof BarBadge) {
            badge = (BarBadge) tag;
        } else {
            badge = new BarBadge(icon);
            icon.setTag(R.id.badge_host, badge);
        }
        badge.packageName = packageName;
        badge.refreshBadge();
    }
}
