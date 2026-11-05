package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class NotificationCompat {
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    public static final String EXTRA_PEOPLE = "android.people";
    public static final String EXTRA_PICTURE = "android.picture";
    public static final String EXTRA_PROGRESS = "android.progress";
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    public static final String EXTRA_SMALL_ICON = "android.icon";
    public static final String EXTRA_SUB_TEXT = "android.subText";
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
    public static final String EXTRA_TEXT = "android.text";
    public static final String EXTRA_TEXT_LINES = "android.textLines";
    public static final String EXTRA_TITLE = "android.title";
    public static final String EXTRA_TITLE_BIG = "android.title.big";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    private static final NotificationCompatImpl IMPL;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;

    public interface Extender {
        Builder extend(Builder builder);
    }

    interface NotificationCompatImpl {
        Notification build(Builder builder);

        Action getAction(Notification notification, int i);

        int getActionCount(Notification notification);

        Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> arrayList);

        Bundle getExtras(Notification notification);

        String getGroup(Notification notification);

        boolean getLocalOnly(Notification notification);

        ArrayList<Parcelable> getParcelableArrayListForActions(Action[] actionArr);

        String getSortKey(Notification notification);

        boolean isGroupSummary(Notification notification);
    }

    static class NotificationCompatImplBase implements NotificationCompatImpl {
        NotificationCompatImplBase() {
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public Notification build(Builder b) {
            Notification result = b.mNotification;
            result.setLatestEventInfo(b.mContext, b.mContentTitle, b.mContentText, b.mContentIntent);
            if (b.mPriority > 0) {
                result.flags |= 128;
            }
            return result;
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public Bundle getExtras(Notification n) {
            return null;
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public int getActionCount(Notification n) {
            return 0;
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public Action getAction(Notification n, int actionIndex) {
            return null;
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> parcelables) {
            return null;
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public ArrayList<Parcelable> getParcelableArrayListForActions(Action[] actions) {
            return null;
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public boolean getLocalOnly(Notification n) {
            return false;
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public String getGroup(Notification n) {
            return null;
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public boolean isGroupSummary(Notification n) {
            return false;
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public String getSortKey(Notification n) {
            return null;
        }
    }

    static class NotificationCompatImplGingerbread extends NotificationCompatImplBase {
        NotificationCompatImplGingerbread() {
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public Notification build(Builder b) {
            Notification result = b.mNotification;
            result.setLatestEventInfo(b.mContext, b.mContentTitle, b.mContentText, b.mContentIntent);
            Notification result2 = NotificationCompatGingerbread.add(result, b.mContext, b.mContentTitle, b.mContentText, b.mContentIntent, b.mFullScreenIntent);
            if (b.mPriority > 0) {
                result2.flags |= 128;
            }
            return result2;
        }
    }

    static class NotificationCompatImplHoneycomb extends NotificationCompatImplBase {
        NotificationCompatImplHoneycomb() {
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public Notification build(Builder b) {
            return NotificationCompatHoneycomb.add(b.mContext, b.mNotification, b.mContentTitle, b.mContentText, b.mContentInfo, b.mTickerView, b.mNumber, b.mContentIntent, b.mFullScreenIntent, b.mLargeIcon);
        }
    }

    static class NotificationCompatImplIceCreamSandwich extends NotificationCompatImplBase {
        NotificationCompatImplIceCreamSandwich() {
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public Notification build(Builder b) {
            return NotificationCompatIceCreamSandwich.add(b.mContext, b.mNotification, b.mContentTitle, b.mContentText, b.mContentInfo, b.mTickerView, b.mNumber, b.mContentIntent, b.mFullScreenIntent, b.mLargeIcon, b.mProgressMax, b.mProgress, b.mProgressIndeterminate);
        }
    }

    static class NotificationCompatImplJellybean extends NotificationCompatImplBase {
        NotificationCompatImplJellybean() {
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public Notification build(Builder b) {
            NotificationCompatJellybean.Builder builder = new NotificationCompatJellybean.Builder(b.mContext, b.mNotification, b.mContentTitle, b.mContentText, b.mContentInfo, b.mTickerView, b.mNumber, b.mContentIntent, b.mFullScreenIntent, b.mLargeIcon, b.mProgressMax, b.mProgress, b.mProgressIndeterminate, b.mUseChronometer, b.mPriority, b.mSubText, b.mLocalOnly, b.mExtras, b.mGroupKey, b.mGroupSummary, b.mSortKey);
            NotificationCompat.addActionsToBuilder(builder, b.mActions);
            NotificationCompat.addStyleToBuilderJellybean(builder, b.mStyle);
            return builder.build();
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public Bundle getExtras(Notification n) {
            return NotificationCompatJellybean.getExtras(n);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public int getActionCount(Notification n) {
            return NotificationCompatJellybean.getActionCount(n);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public Action getAction(Notification n, int actionIndex) {
            return (Action) NotificationCompatJellybean.getAction(n, actionIndex, Action.FACTORY, RemoteInput.FACTORY);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> parcelables) {
            return (Action[]) NotificationCompatJellybean.getActionsFromParcelableArrayList(parcelables, Action.FACTORY, RemoteInput.FACTORY);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public ArrayList<Parcelable> getParcelableArrayListForActions(Action[] actions) {
            return NotificationCompatJellybean.getParcelableArrayListForActions(actions);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public boolean getLocalOnly(Notification n) {
            return NotificationCompatJellybean.getLocalOnly(n);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public String getGroup(Notification n) {
            return NotificationCompatJellybean.getGroup(n);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public boolean isGroupSummary(Notification n) {
            return NotificationCompatJellybean.isGroupSummary(n);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public String getSortKey(Notification n) {
            return NotificationCompatJellybean.getSortKey(n);
        }
    }

    static class NotificationCompatImplKitKat extends NotificationCompatImplJellybean {
        NotificationCompatImplKitKat() {
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplJellybean, android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public Notification build(Builder b) {
            NotificationCompatKitKat.Builder builder = new NotificationCompatKitKat.Builder(b.mContext, b.mNotification, b.mContentTitle, b.mContentText, b.mContentInfo, b.mTickerView, b.mNumber, b.mContentIntent, b.mFullScreenIntent, b.mLargeIcon, b.mProgressMax, b.mProgress, b.mProgressIndeterminate, b.mUseChronometer, b.mPriority, b.mSubText, b.mLocalOnly, b.mExtras, b.mGroupKey, b.mGroupSummary, b.mSortKey);
            NotificationCompat.addActionsToBuilder(builder, b.mActions);
            NotificationCompat.addStyleToBuilderJellybean(builder, b.mStyle);
            return builder.build();
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplJellybean, android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public Bundle getExtras(Notification n) {
            return NotificationCompatKitKat.getExtras(n);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplJellybean, android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public int getActionCount(Notification n) {
            return NotificationCompatKitKat.getActionCount(n);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplJellybean, android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public Action getAction(Notification n, int actionIndex) {
            return (Action) NotificationCompatKitKat.getAction(n, actionIndex, Action.FACTORY, RemoteInput.FACTORY);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplJellybean, android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public boolean getLocalOnly(Notification n) {
            return NotificationCompatKitKat.getLocalOnly(n);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplJellybean, android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public String getGroup(Notification n) {
            return NotificationCompatKitKat.getGroup(n);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplJellybean, android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public boolean isGroupSummary(Notification n) {
            return NotificationCompatKitKat.isGroupSummary(n);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplJellybean, android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public String getSortKey(Notification n) {
            return NotificationCompatKitKat.getSortKey(n);
        }
    }

    static class NotificationCompatImplApi20 extends NotificationCompatImplKitKat {
        NotificationCompatImplApi20() {
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplKitKat, android.support.v4.app.NotificationCompat.NotificationCompatImplJellybean, android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public Notification build(Builder b) {
            NotificationCompatApi20.Builder builder = new NotificationCompatApi20.Builder(b.mContext, b.mNotification, b.mContentTitle, b.mContentText, b.mContentInfo, b.mTickerView, b.mNumber, b.mContentIntent, b.mFullScreenIntent, b.mLargeIcon, b.mProgressMax, b.mProgress, b.mProgressIndeterminate, b.mUseChronometer, b.mPriority, b.mSubText, b.mLocalOnly, b.mExtras, b.mGroupKey, b.mGroupSummary, b.mSortKey);
            NotificationCompat.addActionsToBuilder(builder, b.mActions);
            NotificationCompat.addStyleToBuilderJellybean(builder, b.mStyle);
            return builder.build();
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplKitKat, android.support.v4.app.NotificationCompat.NotificationCompatImplJellybean, android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public Action getAction(Notification n, int actionIndex) {
            return (Action) NotificationCompatApi20.getAction(n, actionIndex, Action.FACTORY, RemoteInput.FACTORY);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplJellybean, android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> parcelables) {
            return (Action[]) NotificationCompatApi20.getActionsFromParcelableArrayList(parcelables, Action.FACTORY, RemoteInput.FACTORY);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplJellybean, android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public ArrayList<Parcelable> getParcelableArrayListForActions(Action[] actions) {
            return NotificationCompatApi20.getParcelableArrayListForActions(actions);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplKitKat, android.support.v4.app.NotificationCompat.NotificationCompatImplJellybean, android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public boolean getLocalOnly(Notification n) {
            return NotificationCompatApi20.getLocalOnly(n);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplKitKat, android.support.v4.app.NotificationCompat.NotificationCompatImplJellybean, android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public String getGroup(Notification n) {
            return NotificationCompatApi20.getGroup(n);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplKitKat, android.support.v4.app.NotificationCompat.NotificationCompatImplJellybean, android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public boolean isGroupSummary(Notification n) {
            return NotificationCompatApi20.isGroupSummary(n);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImplKitKat, android.support.v4.app.NotificationCompat.NotificationCompatImplJellybean, android.support.v4.app.NotificationCompat.NotificationCompatImplBase, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public String getSortKey(Notification n) {
            return NotificationCompatApi20.getSortKey(n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void addActionsToBuilder(NotificationBuilderWithActions builder, ArrayList<Action> actions) {
        for (Action action : actions) {
            builder.addAction(action);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void addStyleToBuilderJellybean(NotificationBuilderWithBuilderAccessor builder, Style style) {
        if (style != null) {
            if (style instanceof BigTextStyle) {
                BigTextStyle bigTextStyle = (BigTextStyle) style;
                NotificationCompatJellybean.addBigTextStyle(builder, bigTextStyle.mBigContentTitle, bigTextStyle.mSummaryTextSet, bigTextStyle.mSummaryText, bigTextStyle.mBigText);
            } else if (style instanceof InboxStyle) {
                InboxStyle inboxStyle = (InboxStyle) style;
                NotificationCompatJellybean.addInboxStyle(builder, inboxStyle.mBigContentTitle, inboxStyle.mSummaryTextSet, inboxStyle.mSummaryText, inboxStyle.mTexts);
            } else if (style instanceof BigPictureStyle) {
                BigPictureStyle bigPictureStyle = (BigPictureStyle) style;
                NotificationCompatJellybean.addBigPictureStyle(builder, bigPictureStyle.mBigContentTitle, bigPictureStyle.mSummaryTextSet, bigPictureStyle.mSummaryText, bigPictureStyle.mPicture, bigPictureStyle.mBigLargeIcon, bigPictureStyle.mBigLargeIconSet);
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 20) {
            IMPL = new NotificationCompatImplApi20();
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            IMPL = new NotificationCompatImplKitKat();
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            IMPL = new NotificationCompatImplJellybean();
            return;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new NotificationCompatImplIceCreamSandwich();
            return;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new NotificationCompatImplHoneycomb();
        } else if (Build.VERSION.SDK_INT >= 9) {
            IMPL = new NotificationCompatImplGingerbread();
        } else {
            IMPL = new NotificationCompatImplBase();
        }
    }

    public static class Builder {
        CharSequence mContentInfo;
        PendingIntent mContentIntent;
        CharSequence mContentText;
        CharSequence mContentTitle;
        Context mContext;
        Bundle mExtras;
        PendingIntent mFullScreenIntent;
        String mGroupKey;
        boolean mGroupSummary;
        Bitmap mLargeIcon;
        int mNumber;
        int mPriority;
        int mProgress;
        boolean mProgressIndeterminate;
        int mProgressMax;
        String mSortKey;
        Style mStyle;
        CharSequence mSubText;
        RemoteViews mTickerView;
        boolean mUseChronometer;
        ArrayList<Action> mActions = new ArrayList<>();
        boolean mLocalOnly = false;
        Notification mNotification = new Notification();

        public Builder(Context context) {
            this.mContext = context;
            this.mNotification.when = System.currentTimeMillis();
            this.mNotification.audioStreamType = -1;
            this.mPriority = 0;
        }

        public Builder setWhen(long when) {
            this.mNotification.when = when;
            return this;
        }

        public Builder setUsesChronometer(boolean b) {
            this.mUseChronometer = b;
            return this;
        }

        public Builder setSmallIcon(int icon) {
            this.mNotification.icon = icon;
            return this;
        }

        public Builder setSmallIcon(int icon, int level) {
            this.mNotification.icon = icon;
            this.mNotification.iconLevel = level;
            return this;
        }

        public Builder setContentTitle(CharSequence title) {
            this.mContentTitle = title;
            return this;
        }

        public Builder setContentText(CharSequence text) {
            this.mContentText = text;
            return this;
        }

        public Builder setSubText(CharSequence text) {
            this.mSubText = text;
            return this;
        }

        public Builder setNumber(int number) {
            this.mNumber = number;
            return this;
        }

        public Builder setContentInfo(CharSequence info) {
            this.mContentInfo = info;
            return this;
        }

        public Builder setProgress(int max, int progress, boolean indeterminate) {
            this.mProgressMax = max;
            this.mProgress = progress;
            this.mProgressIndeterminate = indeterminate;
            return this;
        }

        public Builder setContent(RemoteViews views) {
            this.mNotification.contentView = views;
            return this;
        }

        public Builder setContentIntent(PendingIntent intent) {
            this.mContentIntent = intent;
            return this;
        }

        public Builder setDeleteIntent(PendingIntent intent) {
            this.mNotification.deleteIntent = intent;
            return this;
        }

        public Builder setFullScreenIntent(PendingIntent intent, boolean highPriority) {
            this.mFullScreenIntent = intent;
            setFlag(128, highPriority);
            return this;
        }

        public Builder setTicker(CharSequence tickerText) {
            this.mNotification.tickerText = tickerText;
            return this;
        }

        public Builder setTicker(CharSequence tickerText, RemoteViews views) {
            this.mNotification.tickerText = tickerText;
            this.mTickerView = views;
            return this;
        }

        public Builder setLargeIcon(Bitmap icon) {
            this.mLargeIcon = icon;
            return this;
        }

        public Builder setSound(Uri sound) {
            this.mNotification.sound = sound;
            this.mNotification.audioStreamType = -1;
            return this;
        }

        public Builder setSound(Uri sound, int streamType) {
            this.mNotification.sound = sound;
            this.mNotification.audioStreamType = streamType;
            return this;
        }

        public Builder setVibrate(long[] pattern) {
            this.mNotification.vibrate = pattern;
            return this;
        }

        public Builder setLights(int argb, int onMs, int offMs) {
            this.mNotification.ledARGB = argb;
            this.mNotification.ledOnMS = onMs;
            this.mNotification.ledOffMS = offMs;
            boolean showLights = (this.mNotification.ledOnMS == 0 || this.mNotification.ledOffMS == 0) ? false : true;
            this.mNotification.flags = (showLights ? 1 : 0) | (this.mNotification.flags & (-2));
            return this;
        }

        public Builder setOngoing(boolean ongoing) {
            setFlag(2, ongoing);
            return this;
        }

        public Builder setOnlyAlertOnce(boolean onlyAlertOnce) {
            setFlag(8, onlyAlertOnce);
            return this;
        }

        public Builder setAutoCancel(boolean autoCancel) {
            setFlag(16, autoCancel);
            return this;
        }

        public Builder setLocalOnly(boolean b) {
            this.mLocalOnly = b;
            return this;
        }

        public Builder setDefaults(int defaults) {
            this.mNotification.defaults = defaults;
            if ((defaults & 4) != 0) {
                this.mNotification.flags |= 1;
            }
            return this;
        }

        private void setFlag(int mask, boolean value) {
            if (value) {
                this.mNotification.flags |= mask;
            } else {
                this.mNotification.flags &= mask ^ (-1);
            }
        }

        public Builder setPriority(int pri) {
            this.mPriority = pri;
            return this;
        }

        public Builder setGroup(String groupKey) {
            this.mGroupKey = groupKey;
            return this;
        }

        public Builder setGroupSummary(boolean isGroupSummary) {
            this.mGroupSummary = isGroupSummary;
            return this;
        }

        public Builder setSortKey(String sortKey) {
            this.mSortKey = sortKey;
            return this;
        }

        public Builder addExtras(Bundle extras) {
            if (extras != null) {
                if (this.mExtras == null) {
                    this.mExtras = new Bundle(extras);
                } else {
                    this.mExtras.putAll(extras);
                }
            }
            return this;
        }

        public Builder setExtras(Bundle extras) {
            this.mExtras = extras;
            return this;
        }

        public Bundle getExtras() {
            if (this.mExtras == null) {
                this.mExtras = new Bundle();
            }
            return this.mExtras;
        }

        public Builder addAction(int icon, CharSequence title, PendingIntent intent) {
            this.mActions.add(new Action(icon, title, intent));
            return this;
        }

        public Builder addAction(Action action) {
            this.mActions.add(action);
            return this;
        }

        public Builder setStyle(Style style) {
            if (this.mStyle != style) {
                this.mStyle = style;
                if (this.mStyle != null) {
                    this.mStyle.setBuilder(this);
                }
            }
            return this;
        }

        public Builder extend(Extender extender) {
            extender.extend(this);
            return this;
        }

        @Deprecated
        public Notification getNotification() {
            return NotificationCompat.IMPL.build(this);
        }

        public Notification build() {
            return NotificationCompat.IMPL.build(this);
        }
    }

    public static abstract class Style {
        CharSequence mBigContentTitle;
        Builder mBuilder;
        CharSequence mSummaryText;
        boolean mSummaryTextSet = false;

        public void setBuilder(Builder builder) {
            if (this.mBuilder != builder) {
                this.mBuilder = builder;
                if (this.mBuilder != null) {
                    this.mBuilder.setStyle(this);
                }
            }
        }

        public Notification build() {
            if (this.mBuilder == null) {
                return null;
            }
            Notification notification = this.mBuilder.build();
            return notification;
        }
    }

    public static class BigPictureStyle extends Style {
        Bitmap mBigLargeIcon;
        boolean mBigLargeIconSet;
        Bitmap mPicture;

        public BigPictureStyle() {
        }

        public BigPictureStyle(Builder builder) {
            setBuilder(builder);
        }

        public BigPictureStyle setBigContentTitle(CharSequence title) {
            this.mBigContentTitle = title;
            return this;
        }

        public BigPictureStyle setSummaryText(CharSequence cs) {
            this.mSummaryText = cs;
            this.mSummaryTextSet = true;
            return this;
        }

        public BigPictureStyle bigPicture(Bitmap b) {
            this.mPicture = b;
            return this;
        }

        public BigPictureStyle bigLargeIcon(Bitmap b) {
            this.mBigLargeIcon = b;
            this.mBigLargeIconSet = true;
            return this;
        }
    }

    public static class BigTextStyle extends Style {
        CharSequence mBigText;

        public BigTextStyle() {
        }

        public BigTextStyle(Builder builder) {
            setBuilder(builder);
        }

        public BigTextStyle setBigContentTitle(CharSequence title) {
            this.mBigContentTitle = title;
            return this;
        }

        public BigTextStyle setSummaryText(CharSequence cs) {
            this.mSummaryText = cs;
            this.mSummaryTextSet = true;
            return this;
        }

        public BigTextStyle bigText(CharSequence cs) {
            this.mBigText = cs;
            return this;
        }
    }

    public static class InboxStyle extends Style {
        ArrayList<CharSequence> mTexts = new ArrayList<>();

        public InboxStyle() {
        }

        public InboxStyle(Builder builder) {
            setBuilder(builder);
        }

        public InboxStyle setBigContentTitle(CharSequence title) {
            this.mBigContentTitle = title;
            return this;
        }

        public InboxStyle setSummaryText(CharSequence cs) {
            this.mSummaryText = cs;
            this.mSummaryTextSet = true;
            return this;
        }

        public InboxStyle addLine(CharSequence cs) {
            this.mTexts.add(cs);
            return this;
        }
    }

    public static class Action extends NotificationCompatBase.Action {
        public static final NotificationCompatBase.Action.Factory FACTORY = new NotificationCompatBase.Action.Factory() { // from class: android.support.v4.app.NotificationCompat.Action.1
            @Override // android.support.v4.app.NotificationCompatBase.Action.Factory
            public Action build(int icon, CharSequence title, PendingIntent actionIntent, Bundle extras, RemoteInputCompatBase.RemoteInput[] remoteInputs) {
                return new Action(icon, title, actionIntent, extras, (RemoteInput[]) remoteInputs);
            }

            @Override // android.support.v4.app.NotificationCompatBase.Action.Factory
            public Action[] newArray(int length) {
                return new Action[length];
            }
        };
        public PendingIntent actionIntent;
        public int icon;
        private final Bundle mExtras;
        private final RemoteInput[] mRemoteInputs;
        public CharSequence title;

        public interface Extender {
            Builder extend(Builder builder);
        }

        public Action(int icon, CharSequence title, PendingIntent intent) {
            this(icon, title, intent, new Bundle(), null);
        }

        private Action(int icon, CharSequence title, PendingIntent intent, Bundle extras, RemoteInput[] remoteInputs) {
            this.icon = icon;
            this.title = title;
            this.actionIntent = intent;
            this.mExtras = extras == null ? new Bundle() : extras;
            this.mRemoteInputs = remoteInputs;
        }

        @Override // android.support.v4.app.NotificationCompatBase.Action
        protected int getIcon() {
            return this.icon;
        }

        @Override // android.support.v4.app.NotificationCompatBase.Action
        protected CharSequence getTitle() {
            return this.title;
        }

        @Override // android.support.v4.app.NotificationCompatBase.Action
        protected PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        @Override // android.support.v4.app.NotificationCompatBase.Action
        public Bundle getExtras() {
            return this.mExtras;
        }

        @Override // android.support.v4.app.NotificationCompatBase.Action
        public RemoteInput[] getRemoteInputs() {
            return this.mRemoteInputs;
        }

        public static final class Builder {
            private final Bundle mExtras;
            private final int mIcon;
            private final PendingIntent mIntent;
            private ArrayList<RemoteInput> mRemoteInputs;
            private final CharSequence mTitle;

            public Builder(int icon, CharSequence title, PendingIntent intent) {
                this(icon, title, intent, new Bundle());
            }

            public Builder(Action action) {
                this(action.icon, action.title, action.actionIntent, new Bundle(action.mExtras));
            }

            private Builder(int icon, CharSequence title, PendingIntent intent, Bundle extras) {
                this.mIcon = icon;
                this.mTitle = title;
                this.mIntent = intent;
                this.mExtras = extras;
            }

            public Builder addExtras(Bundle extras) {
                if (extras != null) {
                    this.mExtras.putAll(extras);
                }
                return this;
            }

            public Bundle getExtras() {
                return this.mExtras;
            }

            public Builder addRemoteInput(RemoteInput remoteInput) {
                if (this.mRemoteInputs == null) {
                    this.mRemoteInputs = new ArrayList<>();
                }
                this.mRemoteInputs.add(remoteInput);
                return this;
            }

            public Builder extend(Extender extender) {
                extender.extend(this);
                return this;
            }

            public Action build() {
                RemoteInput[] remoteInputs = this.mRemoteInputs != null ? (RemoteInput[]) this.mRemoteInputs.toArray(new RemoteInput[this.mRemoteInputs.size()]) : null;
                return new Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, remoteInputs);
            }
        }

        public static final class WearableExtender implements Extender {
            private static final int DEFAULT_FLAGS = 1;
            private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
            private static final int FLAG_AVAILABLE_OFFLINE = 1;
            private static final String KEY_FLAGS = "flags";
            private int mFlags;

            public WearableExtender() {
                this.mFlags = 1;
            }

            public WearableExtender(Action action) {
                this.mFlags = 1;
                Bundle wearableBundle = action.getExtras().getBundle(EXTRA_WEARABLE_EXTENSIONS);
                if (wearableBundle != null) {
                    this.mFlags = wearableBundle.getInt(KEY_FLAGS, 1);
                }
            }

            @Override // android.support.v4.app.NotificationCompat.Action.Extender
            public Builder extend(Builder builder) {
                Bundle wearableBundle = new Bundle();
                if (this.mFlags != 1) {
                    wearableBundle.putInt(KEY_FLAGS, this.mFlags);
                }
                builder.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, wearableBundle);
                return builder;
            }

            /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
            public WearableExtender m0clone() {
                WearableExtender that = new WearableExtender();
                that.mFlags = this.mFlags;
                return that;
            }

            public WearableExtender setAvailableOffline(boolean availableOffline) {
                setFlag(1, availableOffline);
                return this;
            }

            public boolean isAvailableOffline() {
                return (this.mFlags & 1) != 0;
            }

            private void setFlag(int mask, boolean value) {
                if (value) {
                    this.mFlags |= mask;
                } else {
                    this.mFlags &= mask ^ (-1);
                }
            }
        }
    }

    public static final class WearableExtender implements Extender {
        private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
        private static final int DEFAULT_FLAGS = 1;
        private static final int DEFAULT_GRAVITY = 80;
        private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
        private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
        private static final int FLAG_HINT_HIDE_ICON = 2;
        private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
        private static final int FLAG_START_SCROLL_BOTTOM = 8;
        private static final String KEY_ACTIONS = "actions";
        private static final String KEY_BACKGROUND = "background";
        private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
        private static final String KEY_CONTENT_ICON = "contentIcon";
        private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
        private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
        private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
        private static final String KEY_DISPLAY_INTENT = "displayIntent";
        private static final String KEY_FLAGS = "flags";
        private static final String KEY_GRAVITY = "gravity";
        private static final String KEY_PAGES = "pages";
        public static final int SIZE_DEFAULT = 0;
        public static final int SIZE_FULL_SCREEN = 5;
        public static final int SIZE_LARGE = 4;
        public static final int SIZE_MEDIUM = 3;
        public static final int SIZE_SMALL = 2;
        public static final int SIZE_XSMALL = 1;
        public static final int UNSET_ACTION_INDEX = -1;
        private ArrayList<Action> mActions;
        private Bitmap mBackground;
        private int mContentActionIndex;
        private int mContentIcon;
        private int mContentIconGravity;
        private int mCustomContentHeight;
        private int mCustomSizePreset;
        private PendingIntent mDisplayIntent;
        private int mFlags;
        private int mGravity;
        private ArrayList<Notification> mPages;

        public WearableExtender() {
            this.mActions = new ArrayList<>();
            this.mFlags = 1;
            this.mPages = new ArrayList<>();
            this.mContentIconGravity = 8388613;
            this.mContentActionIndex = -1;
            this.mCustomSizePreset = 0;
            this.mGravity = 80;
        }

        public WearableExtender(Notification notif) {
            this.mActions = new ArrayList<>();
            this.mFlags = 1;
            this.mPages = new ArrayList<>();
            this.mContentIconGravity = 8388613;
            this.mContentActionIndex = -1;
            this.mCustomSizePreset = 0;
            this.mGravity = 80;
            Bundle extras = NotificationCompat.getExtras(notif);
            Bundle wearableBundle = extras != null ? extras.getBundle(EXTRA_WEARABLE_EXTENSIONS) : null;
            if (wearableBundle != null) {
                Action[] actions = NotificationCompat.IMPL.getActionsFromParcelableArrayList(wearableBundle.getParcelableArrayList(KEY_ACTIONS));
                if (actions != null) {
                    Collections.addAll(this.mActions, actions);
                }
                this.mFlags = wearableBundle.getInt(KEY_FLAGS, 1);
                this.mDisplayIntent = (PendingIntent) wearableBundle.getParcelable(KEY_DISPLAY_INTENT);
                Notification[] pages = NotificationCompat.getNotificationArrayFromBundle(wearableBundle, KEY_PAGES);
                if (pages != null) {
                    Collections.addAll(this.mPages, pages);
                }
                this.mBackground = (Bitmap) wearableBundle.getParcelable(KEY_BACKGROUND);
                this.mContentIcon = wearableBundle.getInt(KEY_CONTENT_ICON);
                this.mContentIconGravity = wearableBundle.getInt(KEY_CONTENT_ICON_GRAVITY, 8388613);
                this.mContentActionIndex = wearableBundle.getInt(KEY_CONTENT_ACTION_INDEX, -1);
                this.mCustomSizePreset = wearableBundle.getInt(KEY_CUSTOM_SIZE_PRESET, 0);
                this.mCustomContentHeight = wearableBundle.getInt(KEY_CUSTOM_CONTENT_HEIGHT);
                this.mGravity = wearableBundle.getInt(KEY_GRAVITY, 80);
            }
        }

        @Override // android.support.v4.app.NotificationCompat.Extender
        public Builder extend(Builder builder) {
            Bundle wearableBundle = new Bundle();
            if (!this.mActions.isEmpty()) {
                wearableBundle.putParcelableArrayList(KEY_ACTIONS, NotificationCompat.IMPL.getParcelableArrayListForActions((Action[]) this.mActions.toArray(new Action[this.mActions.size()])));
            }
            if (this.mFlags != 1) {
                wearableBundle.putInt(KEY_FLAGS, this.mFlags);
            }
            if (this.mDisplayIntent != null) {
                wearableBundle.putParcelable(KEY_DISPLAY_INTENT, this.mDisplayIntent);
            }
            if (!this.mPages.isEmpty()) {
                wearableBundle.putParcelableArray(KEY_PAGES, (Parcelable[]) this.mPages.toArray(new Notification[this.mPages.size()]));
            }
            if (this.mBackground != null) {
                wearableBundle.putParcelable(KEY_BACKGROUND, this.mBackground);
            }
            if (this.mContentIcon != 0) {
                wearableBundle.putInt(KEY_CONTENT_ICON, this.mContentIcon);
            }
            if (this.mContentIconGravity != 8388613) {
                wearableBundle.putInt(KEY_CONTENT_ICON_GRAVITY, this.mContentIconGravity);
            }
            if (this.mContentActionIndex != -1) {
                wearableBundle.putInt(KEY_CONTENT_ACTION_INDEX, this.mContentActionIndex);
            }
            if (this.mCustomSizePreset != 0) {
                wearableBundle.putInt(KEY_CUSTOM_SIZE_PRESET, this.mCustomSizePreset);
            }
            if (this.mCustomContentHeight != 0) {
                wearableBundle.putInt(KEY_CUSTOM_CONTENT_HEIGHT, this.mCustomContentHeight);
            }
            if (this.mGravity != 80) {
                wearableBundle.putInt(KEY_GRAVITY, this.mGravity);
            }
            builder.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, wearableBundle);
            return builder;
        }

        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public WearableExtender m1clone() {
            WearableExtender that = new WearableExtender();
            that.mActions = new ArrayList<>(this.mActions);
            that.mFlags = this.mFlags;
            that.mDisplayIntent = this.mDisplayIntent;
            that.mPages = new ArrayList<>(this.mPages);
            that.mBackground = this.mBackground;
            that.mContentIcon = this.mContentIcon;
            that.mContentIconGravity = this.mContentIconGravity;
            that.mContentActionIndex = this.mContentActionIndex;
            that.mCustomSizePreset = this.mCustomSizePreset;
            that.mCustomContentHeight = this.mCustomContentHeight;
            that.mGravity = this.mGravity;
            return that;
        }

        public WearableExtender addAction(Action action) {
            this.mActions.add(action);
            return this;
        }

        public WearableExtender addActions(List<Action> actions) {
            this.mActions.addAll(actions);
            return this;
        }

        public WearableExtender clearActions() {
            this.mActions.clear();
            return this;
        }

        public List<Action> getActions() {
            return this.mActions;
        }

        public WearableExtender setDisplayIntent(PendingIntent intent) {
            this.mDisplayIntent = intent;
            return this;
        }

        public PendingIntent getDisplayIntent() {
            return this.mDisplayIntent;
        }

        public WearableExtender addPage(Notification page) {
            this.mPages.add(page);
            return this;
        }

        public WearableExtender addPages(List<Notification> pages) {
            this.mPages.addAll(pages);
            return this;
        }

        public WearableExtender clearPages() {
            this.mPages.clear();
            return this;
        }

        public List<Notification> getPages() {
            return this.mPages;
        }

        public WearableExtender setBackground(Bitmap background) {
            this.mBackground = background;
            return this;
        }

        public Bitmap getBackground() {
            return this.mBackground;
        }

        public WearableExtender setContentIcon(int icon) {
            this.mContentIcon = icon;
            return this;
        }

        public int getContentIcon() {
            return this.mContentIcon;
        }

        public WearableExtender setContentIconGravity(int contentIconGravity) {
            this.mContentIconGravity = contentIconGravity;
            return this;
        }

        public int getContentIconGravity() {
            return this.mContentIconGravity;
        }

        public WearableExtender setContentAction(int actionIndex) {
            this.mContentActionIndex = actionIndex;
            return this;
        }

        public int getContentAction() {
            return this.mContentActionIndex;
        }

        public WearableExtender setGravity(int gravity) {
            this.mGravity = gravity;
            return this;
        }

        public int getGravity() {
            return this.mGravity;
        }

        public WearableExtender setCustomSizePreset(int sizePreset) {
            this.mCustomSizePreset = sizePreset;
            return this;
        }

        public int getCustomSizePreset() {
            return this.mCustomSizePreset;
        }

        public WearableExtender setCustomContentHeight(int height) {
            this.mCustomContentHeight = height;
            return this;
        }

        public int getCustomContentHeight() {
            return this.mCustomContentHeight;
        }

        public WearableExtender setStartScrollBottom(boolean startScrollBottom) {
            setFlag(8, startScrollBottom);
            return this;
        }

        public boolean getStartScrollBottom() {
            return (this.mFlags & 8) != 0;
        }

        public WearableExtender setContentIntentAvailableOffline(boolean contentIntentAvailableOffline) {
            setFlag(1, contentIntentAvailableOffline);
            return this;
        }

        public boolean getContentIntentAvailableOffline() {
            return (this.mFlags & 1) != 0;
        }

        public WearableExtender setHintHideIcon(boolean hintHideIcon) {
            setFlag(2, hintHideIcon);
            return this;
        }

        public boolean getHintHideIcon() {
            return (this.mFlags & 2) != 0;
        }

        public WearableExtender setHintShowBackgroundOnly(boolean hintShowBackgroundOnly) {
            setFlag(4, hintShowBackgroundOnly);
            return this;
        }

        public boolean getHintShowBackgroundOnly() {
            return (this.mFlags & 4) != 0;
        }

        private void setFlag(int mask, boolean value) {
            if (value) {
                this.mFlags |= mask;
            } else {
                this.mFlags &= mask ^ (-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Notification[] getNotificationArrayFromBundle(Bundle bundle, String key) {
        Parcelable[] array = bundle.getParcelableArray(key);
        if ((array instanceof Notification[]) || array == null) {
            return (Notification[]) array;
        }
        Notification[] typedArray = new Notification[array.length];
        for (int i = 0; i < array.length; i++) {
            typedArray[i] = (Notification) array[i];
        }
        bundle.putParcelableArray(key, typedArray);
        return typedArray;
    }

    public static Bundle getExtras(Notification notif) {
        return IMPL.getExtras(notif);
    }

    public static int getActionCount(Notification notif) {
        return IMPL.getActionCount(notif);
    }

    public static Action getAction(Notification notif, int actionIndex) {
        return IMPL.getAction(notif, actionIndex);
    }

    public static boolean getLocalOnly(Notification notif) {
        return IMPL.getLocalOnly(notif);
    }

    public static String getGroup(Notification notif) {
        return IMPL.getGroup(notif);
    }

    public static boolean isGroupSummary(Notification notif) {
        return IMPL.isGroupSummary(notif);
    }

    public static String getSortKey(Notification notif) {
        return IMPL.getSortKey(notif);
    }
}
