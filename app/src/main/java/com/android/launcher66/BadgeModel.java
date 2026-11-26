package com.android.launcher66;

import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

import androidx.preference.PreferenceManager;

import com.android.launcher66.settings.Keys;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The number of notifications of each app, for the badges on the icons (H1).
 *
 * <p>The rules (the owner, 2026-11-25): NotificationListener tells this model when it connects and when a notification is
 * posted or removed; the model reads all active notifications on a thread of its own (a call into the system, not for the
 * main thread), counts them ({@link BadgeCounts}) and, on the main thread, tells the views of the apps whose number changed
 * ({@link BadgeViews}). With the badges off nothing is counted and nothing is kept: the map is empty and the views draw
 * nothing. The look ({@link BadgeStyle}) is made again when a badge setting, the accent or "Stock layout" changes, and then
 * every view is drawn again. The access to notifications is the launcher's own step of the permission flow. Singleton.
 */
final class BadgeModel {

    private static final BadgeModel INSTANCE = new BadgeModel();

    private final Handler mMain = new Handler(Looper.getMainLooper());
    private final ExecutorService mWorker = Executors.newSingleThreadExecutor(r -> new Thread(r, "BadgeModel"));
    private volatile Map<String, Integer> mCounts = Collections.emptyMap();
    private BadgeStyle mStyle;
    private WeakReference<NotificationListenerService> mService;
    private SharedPreferences.OnSharedPreferenceChangeListener mPrefListener;

    private BadgeModel() {
    }

    static BadgeModel get() {
        return INSTANCE;
    }

    /** The number of this app, 0 for none. Any thread. */
    int count(String packageName) {
        Integer n = packageName == null ? null : mCounts.get(packageName);
        return n == null ? 0 : n;
    }

    /** The look of the badges now. Main thread. */
    BadgeStyle style(Context context) {
        if (mStyle == null) {
            Context app = context.getApplicationContext();
            mStyle = BadgeStyle.load(app);
            if (mPrefListener == null) {
                mPrefListener = (prefs, key) -> {
                    if (BadgeStyle.isBadgeSetting(key)) {
                        onSettingsChanged(app);
                    }
                };
                PreferenceManager.getDefaultSharedPreferences(app).registerOnSharedPreferenceChangeListener(mPrefListener);
            }
        }
        return mStyle;
    }

    /** The colour of the numbers on the icons of the home screen, the folders and the bars (D1: the icon text colour). */
    static int iconTextColor(Context context) {
        return IconTextColor.workspace(PreferenceManager.getDefaultSharedPreferences(context), context);
    }

    /** NotificationListener connected, or a notification was posted or removed: the numbers are read again. */
    void refresh(NotificationListenerService service) {
        mService = new WeakReference<>(service);
        final Context app = service.getApplicationContext();
        mWorker.execute(() -> compute(service, app));
    }

    /** A badge setting changed: the look is made again, the numbers are read again (they are dropped with the badges off). */
    private void onSettingsChanged(Context app) {
        mStyle = BadgeStyle.load(app);
        NotificationListenerService service = mService == null ? null : mService.get();
        if (service != null) {
            refresh(service);
        } else if (!mStyle.enabled) {
            mCounts = Collections.emptyMap();
        }
        BadgeViews.refreshAll(null);
    }

    private void compute(NotificationListenerService service, Context app) {
        Map<String, Integer> next;
        if (!PreferenceManager.getDefaultSharedPreferences(app).getBoolean(Keys.BADGES_ENABLED, true)) {
            next = Collections.emptyMap();
        } else {
            StatusBarNotification[] active;
            NotificationListenerService.RankingMap ranking;
            try {
                active = service.getActiveNotifications();
                ranking = service.getCurrentRanking();
            } catch (RuntimeException e) {
                return;   // not connected (any more): the numbers stay as they were
            }
            List<BadgeCounts.Entry> entries = new ArrayList<>();
            NotificationListenerService.Ranking one = new NotificationListenerService.Ranking();
            if (active != null) {
                for (StatusBarNotification sbn : active) {
                    Notification n = sbn.getNotification();
                    boolean canShowBadge = true;
                    if (ranking != null && ranking.getRanking(sbn.getKey(), one)) {
                        canShowBadge = one.canShowBadge();
                    }
                    entries.add(new BadgeCounts.Entry(sbn.getPackageName(), n.number,
                            (n.flags & Notification.FLAG_GROUP_SUMMARY) != 0,
                            (n.flags & Notification.FLAG_ONGOING_EVENT) != 0,
                            (n.flags & Notification.FLAG_FOREGROUND_SERVICE) != 0, canShowBadge));
                }
            }
            next = BadgeCounts.count(entries);
        }
        final Set<String> changed = BadgeCounts.changed(mCounts, next);
        mCounts = next;
        if (!changed.isEmpty()) {
            mMain.post(() -> BadgeViews.refreshAll(changed));
        }
    }
}
