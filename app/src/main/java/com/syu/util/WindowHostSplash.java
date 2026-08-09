package com.syu.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.preference.PreferenceManager;

import com.android.launcher66.settings.Helpers;
import com.android.launcher66.settings.Keys;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Cosmetic launch cover for an embedded app.
 */
public final class WindowHostSplash {

    private static final String TAG = "WindowHostSplash";

    /** How often the pane's display is polled for visible content. */
    private static final long POLL_MS = 80L;
    /**
     * ActivityTaskManager reports a stack VISIBLE as soon as the activity is resumed -- which is
     * still ~200 ms before its first frame is composited. Dismissing on the bare visible flag therefore
     * uncovers a black pane for a moment. Two things guard against that: the flag has to hold for
     * STABLE_POLLS consecutive polls, and we still sit on it for SETTLE_MS afterwards.
     */
    private static final long SETTLE_MS = 500L;
    private static final int  STABLE_POLLS = 2;
    /** getAllStackInfos() is a binder round-trip; one snapshot serves every pane. */
    private static final long SNAPSHOT_TTL_MS = 80L;
    /**
     * Fade-out duration.
     * A slower fade also blurs whatever residual flash is left underneath.
     */
    private static final long FADE_MS = 260L;

    private static final String TAG_KEY = "WindowHostSplash#cover";

    /** Which package a live cover is currently showing, so attach() can update it in place. */
    private static final Map<View, String> coverPackage = new java.util.WeakHashMap<>();

    private static final Handler MAIN = new Handler(Looper.getMainLooper());
    /**
     * Every attach() bumps a cover's generation. A dismissal scheduled for an older generation is
     * abandoned, so re-covering a pane (e.g. the drag cover being re-raised, or a handoff cover
     * going up while a previous fade was still pending) can never be undone by the stale timer.
     */
    private static final Map<View, int[]> coverGeneration = new java.util.WeakHashMap<>();
    /** Active synchronised reveal, if any (see beginSyncedReveal). */
    private static RevealGroup sGroup;
    private static long snapshotAtMs = 0L;
    private static java.util.HashSet<Integer> snapshot = null;
    private static final Map<String, Integer> colorCache = new HashMap<>();

    private WindowHostSplash() { }

    // =====================================================================================
    // Synchronised reveal
    // =====================================================================================
    //
    // A "swap everything" gesture runs two separate swaps, and each of them settles on its own
    // schedule, so the covers used to come down one after another. Worse: swapActivityViewSurfaces()
    // blocks the main thread for ~350 ms (Thread.sleep(25) in a polling loop), so whatever is on
    // screen is frozen for that whole time.
    //
    // beginSyncedReveal(n) makes the next n covers wait for each other: whichever is ready first
    // parks its fade until all n are ready, or until the group times out. The result is one
    // simultaneous transition instead of a staggered one.

    private static final class RevealGroup {
        final int expected;
        final java.util.ArrayList<Runnable> fades = new java.util.ArrayList<>();
        boolean fired;
        RevealGroup(int expected) { this.expected = Math.max(1, expected); }
    }

    /**
     * @param expectedMembers how many covers will take part -- must match the number of panes that
     *                        actually get covered, otherwise the group waits for the timeout
     * @param timeoutMs       backstop; after this the covers still up are revealed regardless
     */
    public static void beginSyncedReveal(int expectedMembers, long timeoutMs) {
        final RevealGroup g = new RevealGroup(expectedMembers);
        sGroup = g;
        MAIN.postDelayed(() -> fireGroup(g), Math.max(250L, timeoutMs));
        Log.i(TAG, "beginSyncedReveal: expecting " + expectedMembers + " covers");
    }

    /** Cancels a pending synchronised reveal without revealing anything. */
    public static void cancelSyncedReveal() {
        RevealGroup g = sGroup;
        sGroup = null;
        if (g != null) g.fades.clear();
    }

    /** Fades now, or parks the fade in the active group when this cover is part of one. */
    private static void reveal(boolean syncable, Runnable fade) {
        if (syncable) joinReveal(fade);
        else runQuietly(fade);
    }

    /**
     * Gives a barrier slot back without anything to fade. Used by every early exit in
     * dismissKeyed(): a member that silently disappears would otherwise hold the whole group
     * hostage until its timeout.
     */
    private static void releaseMember(boolean syncable) {
        if (syncable) joinReveal(null);
    }

    private static void joinReveal(Runnable fade) {
        RevealGroup g = sGroup;
        if (g == null || g.fired) { runQuietly(fade); return; }

        g.fades.add(fade);   // null == member released its slot with nothing to fade
        if (g.fades.size() >= g.expected) fireGroup(g);
    }

    private static void fireGroup(RevealGroup g) {
        if (g == null || g.fired) return;
        g.fired = true;
        if (sGroup == g) sGroup = null;

        for (Runnable r : g.fades) runQuietly(r);
        g.fades.clear();
    }

    // =====================================================================================
    // Public API
    // =====================================================================================

    /**
     * Adds (or refreshes) the splash cover on top of everything already in paneHost.
     * Safe to call repeatedly; the cover is reused.
     */
    public static View attach(ViewGroup paneHost, String pkg) {
        return attach(paneHost, TAG_KEY, pkg, null);
    }

    /**
     * Adds (or refreshes) a cover inside container, identified by key.
     * If a cover for this key already exists it is REUSED and, when the package changed, its icon
     * and background are swapped in place -- no remove/re-add, so no flicker.
     */
    public static View attach(ViewGroup container, String key, String pkg, ViewGroup.LayoutParams lp) {
        return attach(container, key, pkg, lp, false);
    }

    /**
     * @param keepExistingIcon when a cover for this key is already up, leave its icon alone.
     *        A swap should show ONE icon for its whole duration -- the app that was there when it
     *        started -- and then fade straight to the incoming app. Repainting mid-swap produces
     *        the "old splash, then new splash, then the app" sequence.
     */
    public static View attach(ViewGroup container, String key, String pkg,
                              ViewGroup.LayoutParams lp, boolean keepExistingIcon) {
        if (container == null) return null;
        try {
            View existing = container.findViewWithTag(key);
            if (existing != null) {
                try { existing.animate().cancel(); } catch (Throwable ignore) { }
                existing.setAlpha(1f);
                existing.setVisibility(View.VISIBLE);

                String shown = coverPackage.get(existing);
                if (!keepExistingIcon && pkg != null && !pkg.equals(shown)
                        && existing instanceof FrameLayout) {
                    repaint((FrameLayout) existing, pkg);
                }
                if (lp != null) existing.setLayoutParams(lp);
                existing.bringToFront();
                bumpGeneration(existing);
                return existing;
            }

            View cover = build(container.getContext(), pkg);
            cover.setTag(key);
            bumpGeneration(cover);
            container.addView(cover, lp != null ? lp : new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            cover.bringToFront();
            return cover;
        } catch (Throwable t) {
            Log.w(TAG, "attach failed for " + pkg, t);
            return null;
        }
    }

    public static void dismissWhenReady(ViewGroup container, String key, Object paneAV,
                                        long minMs, long maxMs, Runnable onDone) {
        // Keyed == handoff cover, and only those take part in a synchronised reveal. A divider
        // drag or a cold start must never be parked behind a swap barrier that happens to be
        // pending -- it would leave that pane covered (and touch-inert) for up to the group
        // timeout for no reason.
        dismissKeyed(container, key, paneAV, minMs, maxMs, onDone, true);
    }

    /**
     * Same, with an explicit cap. Use a short cap (400-800 ms) for paths where the app is ALREADY
     * running and only its surface is being re-created -- a swap or a divider-drag restore. There
     * the black gap lasts a frame or two, so a long cap would keep the pane covered (and touch
     * inert) far longer than the glitch it hides.
     */
    public static void dismissWhenReady(ViewGroup paneHost, Object paneAV,
                                        long minMs, long maxMs, Runnable onDone) {
        dismissKeyed(paneHost, TAG_KEY, paneAV, minMs, maxMs, onDone, false);
    }

    private static void dismissKeyed(final ViewGroup paneHost, final String key,
                                     final Object paneAV, final long minMs, final long maxMs,
                                     final Runnable onDone, final boolean syncable) {
        if (paneHost == null) { releaseMember(syncable); runQuietly(onDone); return; }

        final View cover = paneHost.findViewWithTag(key);
        if (cover == null) {
            // Nothing to take down here -- but the barrier is still counting on this member.
            // Without this the other covers would hang until the group times out.
            releaseMember(syncable);
            runQuietly(onDone);
            return;
        }

        final int myGeneration = generationOf(cover);
        final long startedAt = SystemClock.uptimeMillis();
        final long deadline = startedAt + Math.max(120L, maxMs);
        final long notBefore = startedAt + Math.max(0L, minMs);

        // Short-cap callers (swap / drag restore) must not sit on the full settle delay.
        final long settleMs = Math.min(SETTLE_MS, Math.max(80L, maxMs / 3));
        final int[] positiveStreak = new int[]{ 0 };

        final Runnable poll = new Runnable() {
            @Override public void run() {
                if (cover.getParent() != paneHost) {
                    releaseMember(syncable);
                    runQuietly(onDone);
                    return;
                }
                if (generationOf(cover) != myGeneration) {
                    releaseMember(syncable);
                    return;
                }

                boolean timedOut = SystemClock.uptimeMillis() >= deadline;
                int displayId = (paneAV != null) ? WindowHostActivityView.getVirtualDisplayId(paneAV) : -1;
                Boolean visible = (displayId >= 0) ? hasVisibleTask(displayId) : Boolean.FALSE;

                if (visible == null) {
                    // Cannot query the display on this ROM -- do not hold the app hostage.
                    MAIN.postDelayed(() -> reveal(syncable, () -> fadeOut(paneHost, cover, myGeneration, onDone)), 600L);
                    return;
                }

                if (visible) positiveStreak[0]++;
                else positiveStreak[0] = 0;

                if (timedOut) {
                    reveal(syncable, () -> fadeOut(paneHost, cover, myGeneration, onDone));
                    return;
                }

                if (positiveStreak[0] >= STABLE_POLLS) {
                    // minMs exists for paths where the display ALREADY hosts a visible task and the
                    // readiness query therefore answers "yes" instantly -- a pane swap, where what
                    // we are really waiting for is our own SurfaceControl re-parent to be
                    // composited, not for the app to start.
                    long wait = Math.max(settleMs, notBefore - SystemClock.uptimeMillis());
                    MAIN.postDelayed(() -> reveal(syncable, () -> fadeOut(paneHost, cover, myGeneration, onDone)),
                            wait);
                    return;
                }

                MAIN.postDelayed(this, POLL_MS);
            }
        };
        MAIN.postDelayed(poll, POLL_MS);
    }

    /** Drops the cover without any animation. For hard teardown paths. */
    public static void removeImmediately(ViewGroup paneHost) {
        removeImmediately(paneHost, TAG_KEY);
    }

    public static void removeImmediately(ViewGroup container, String key) {
        if (container == null) return;
        try {
            View cover = container.findViewWithTag(key);
            if (cover != null) {
                bumpGeneration(cover);          // kill any pending dismissal
                container.removeView(cover);
            }
        } catch (Throwable ignore) { }
    }

    // =====================================================================================
    // Internals
    // =====================================================================================

    private static View build(Context ctx, String pkg) {
        FrameLayout cover = new FrameLayout(ctx);
        cover.setTag(TAG_KEY);
        cover.setClickable(false);
        cover.setFocusable(false);
        cover.setFocusableInTouchMode(false);
        cover.setAlpha(1f);
        repaint(cover, pkg);
        return cover;
    }

    /** Replaces the icon + background of a live cover without removing it from the hierarchy. */
    private static void repaint(FrameLayout cover, String pkg) {
        Context ctx = cover.getContext();
        cover.removeAllViews();
        coverPackage.put(cover, pkg);

        Drawable icon = null;
        try {
            if (pkg != null && !pkg.isEmpty()) {
                icon = ctx.getPackageManager().getApplicationIcon(pkg);
            }
        } catch (Throwable ignore) { }

        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        if (mPrefs.getBoolean(Keys.COVER_SPLASH, true)) {
            cover.setBackgroundColor(backgroundFor(pkg, icon));
        } else {
            Helpers helpers = new Helpers();
            int bgColor = helpers.isDay()
                ? Color.rgb(247, 247, 247)
                : Color.rgb(169, 169, 169);    
            cover.setBackgroundColor(bgColor);        
        }

        if (icon != null) {
            ImageView iv = new ImageView(ctx);
            iv.setImageDrawable(icon);
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);

            int size = Math.round(ctx.getResources().getDisplayMetrics().density * 72);
            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(size, size);
            lp.gravity = Gravity.CENTER;
            cover.addView(iv, lp);
        }
    }

    private static void fadeOut(final ViewGroup paneHost, final View cover,
                                final int expectedGeneration, final Runnable onDone) {
        if (generationOf(cover) != expectedGeneration) return;
        try {
            cover.animate()
                    .alpha(0f)
                    .setDuration(FADE_MS)
                    .withEndAction(() -> {
                        if (generationOf(cover) != expectedGeneration) {
                            cover.setAlpha(1f);   // someone re-covered mid-fade
                            return;
                        }
                        try { paneHost.removeView(cover); } catch (Throwable ignore) { }
                        runQuietly(onDone);
                    })
                    .start();
        } catch (Throwable t) {
            try { paneHost.removeView(cover); } catch (Throwable ignore) { }
            runQuietly(onDone);
        }
    }

    private static void bumpGeneration(View cover) {
        int[] g = coverGeneration.computeIfAbsent(cover, k -> new int[]{0});
        ++g[0];
    }

    private static int generationOf(View cover) {
        int[] g = coverGeneration.get(cover);
        return g == null ? 0 : g[0];
    }

    private static void runQuietly(Runnable r) {
        if (r == null) return;
        try { r.run(); } catch (Throwable ignore) { }
    }

    /**
     * @return TRUE when a visible stack with at least one task lives on that display,
     *         FALSE when it does not (yet),
     *         null when the question cannot be answered on this ROM.
     */
    private static Boolean hasVisibleTask(int displayId) {
        if (displayId < 0) return Boolean.FALSE;

        long now = SystemClock.uptimeMillis();
        if (snapshot == null || (now - snapshotAtMs) > SNAPSHOT_TTL_MS) {
            snapshot = queryVisibleDisplays();
            snapshotAtMs = now;
        }
        if (snapshot == null) return null;
        return snapshot.contains(displayId) ? Boolean.TRUE : Boolean.FALSE;
    }

    /** @return ids of displays currently showing a visible, non-empty stack, or null on failure. */
    private static HashSet<Integer> queryVisibleDisplays() {
        try {
            Class<?> atmCls = Class.forName("android.app.ActivityTaskManager");
            Method getService = atmCls.getMethod("getService");
            Object atm = getService.invoke(null);
            if (atm == null) return null;

            Method getAllStackInfos = atm.getClass().getMethod("getAllStackInfos");
            getAllStackInfos.setAccessible(true);
            Object result = getAllStackInfos.invoke(atm);
            if (!(result instanceof List)) return null;

            java.util.HashSet<Integer> out = new java.util.HashSet<>();
            for (Object stackInfo : (List<?>) result) {
                if (stackInfo == null) continue;

                Field fTasks = stackInfo.getClass().getField("taskIds");
                Object taskIds = fTasks.get(stackInfo);
                if (!(taskIds instanceof int[]) || ((int[]) taskIds).length == 0) continue;

                try {
                    Field fVisible = stackInfo.getClass().getField("visible");
                    if (!fVisible.getBoolean(stackInfo)) continue;
                } catch (NoSuchFieldException ignore) {
                    // Field absent on this ROM -> a populated stack is good enough.
                }

                Field fDisplay = stackInfo.getClass().getField("displayId");
                out.add(fDisplay.getInt(stackInfo));
            }
            return out;
        } catch (Throwable t) {
            Log.w(TAG, "queryVisibleDisplays failed", t);
            return null;
        }
    }

    /** Average of the icon's opaque pixels, darkened a little so a light icon stays readable. */
    private static int backgroundFor(String pkg, Drawable icon) {
        final int fallback = Color.rgb(32, 33, 36);
        if (icon == null) return fallback;

        if (pkg != null) {
            Integer cached = colorCache.get(pkg);
            if (cached != null) return cached;
        }

        int color = fallback;
        try {
            Bitmap bmp;
            if (icon instanceof BitmapDrawable && ((BitmapDrawable) icon).getBitmap() != null) {
                bmp = Bitmap.createScaledBitmap(((BitmapDrawable) icon).getBitmap(), 16, 16, true);
            } else {
                bmp = Bitmap.createBitmap(16, 16, Bitmap.Config.ARGB_8888);
                Canvas c = new Canvas(bmp);
                icon.setBounds(0, 0, 16, 16);
                icon.draw(c);
            }

            long r = 0, g = 0, b = 0, n = 0;
            int[] px = new int[16 * 16];
            bmp.getPixels(px, 0, 16, 0, 0, 16, 16);
            for (int p : px) {
                if (Color.alpha(p) < 128) continue;
                r += Color.red(p); g += Color.green(p); b += Color.blue(p);
                n++;
            }
            if (n > 0) {
                // 0.62 keeps the hue but pushes it dark enough for the icon to stand out.
                color = Color.rgb(
                        (int) (r / n * 0.62f),
                        (int) (g / n * 0.62f),
                        (int) (b / n * 0.62f));
            }
        } catch (Throwable ignored) {
        }

        if (pkg != null) colorCache.put(pkg, color);
        return color;
    }
}
