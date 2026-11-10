package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.RemoteViews;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
class NotificationCompatApi20 {
    NotificationCompatApi20() {
    }

    public static class Builder implements NotificationBuilderWithBuilderAccessor, NotificationBuilderWithActions {
        private Notification.Builder b;

        public Builder(Context context, Notification n, CharSequence contentTitle, CharSequence contentText, CharSequence contentInfo, RemoteViews tickerView, int number, PendingIntent contentIntent, PendingIntent fullScreenIntent, Bitmap largeIcon, int mProgressMax, int mProgress, boolean mProgressIndeterminate, boolean useChronometer, int priority, CharSequence subText, boolean localOnly, Bundle extras, String groupKey, boolean groupSummary, String sortKey) {
            this.b = new Notification.Builder(context).setWhen(n.when).setSmallIcon(n.icon, n.iconLevel).setContent(n.contentView).setTicker(n.tickerText, tickerView).setSound(n.sound, n.audioStreamType).setVibrate(n.vibrate).setLights(n.ledARGB, n.ledOnMS, n.ledOffMS).setOngoing((n.flags & 2) != 0).setOnlyAlertOnce((n.flags & 8) != 0).setAutoCancel((n.flags & 16) != 0).setDefaults(n.defaults).setContentTitle(contentTitle).setContentText(contentText).setSubText(subText).setContentInfo(contentInfo).setContentIntent(contentIntent).setDeleteIntent(n.deleteIntent).setFullScreenIntent(fullScreenIntent, (n.flags & 128) != 0).setLargeIcon(largeIcon).setNumber(number).setUsesChronometer(useChronometer).setPriority(priority).setProgress(mProgressMax, mProgress, mProgressIndeterminate).setLocalOnly(localOnly).setExtras(extras).setGroup(groupKey).setGroupSummary(groupSummary).setSortKey(sortKey);
        }

        @Override // android.support.v4.app.NotificationBuilderWithActions
        public void addAction(NotificationCompatBase.Action action) {
            Notification.Action.Builder actionBuilder = new Notification.Action.Builder(action.getIcon(), action.getTitle(), action.getActionIntent());
            if (action.getRemoteInputs() != null) {
                android.app.RemoteInput[] arr$ = RemoteInputCompatApi20.fromCompat(action.getRemoteInputs());
                for (android.app.RemoteInput remoteInput : arr$) {
                    actionBuilder.addRemoteInput(remoteInput);
                }
            }
            if (action.getExtras() != null) {
                actionBuilder.addExtras(action.getExtras());
            }
            this.b.addAction(actionBuilder.build());
        }

        @Override // android.support.v4.app.NotificationBuilderWithBuilderAccessor
        public Notification.Builder getBuilder() {
            return this.b;
        }

        public Notification build() {
            return this.b.build();
        }
    }

    public static NotificationCompatBase.Action getAction(Notification notif, int actionIndex, NotificationCompatBase.Action.Factory actionFactory, RemoteInputCompatBase.RemoteInput.Factory remoteInputFactory) {
        return getActionCompatFromAction(notif.actions[actionIndex], actionFactory, remoteInputFactory);
    }

    private static NotificationCompatBase.Action getActionCompatFromAction(Notification.Action action, NotificationCompatBase.Action.Factory actionFactory, RemoteInputCompatBase.RemoteInput.Factory remoteInputFactory) {
        RemoteInputCompatBase.RemoteInput[] remoteInputs = RemoteInputCompatApi20.toCompat(action.getRemoteInputs(), remoteInputFactory);
        return actionFactory.build(action.icon, action.title, action.actionIntent, action.getExtras(), remoteInputs);
    }

    private static Notification.Action getActionFromActionCompat(NotificationCompatBase.Action actionCompat) {
        Notification.Action.Builder actionBuilder = new Notification.Action.Builder(actionCompat.getIcon(), actionCompat.getTitle(), actionCompat.getActionIntent()).addExtras(actionCompat.getExtras());
        RemoteInputCompatBase.RemoteInput[] remoteInputCompats = actionCompat.getRemoteInputs();
        if (remoteInputCompats != null) {
            android.app.RemoteInput[] remoteInputs = RemoteInputCompatApi20.fromCompat(remoteInputCompats);
            for (android.app.RemoteInput remoteInput : remoteInputs) {
                actionBuilder.addRemoteInput(remoteInput);
            }
        }
        return actionBuilder.build();
    }

    public static NotificationCompatBase.Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> parcelables, NotificationCompatBase.Action.Factory actionFactory, RemoteInputCompatBase.RemoteInput.Factory remoteInputFactory) {
        if (parcelables == null) {
            return null;
        }
        NotificationCompatBase.Action[] actions = actionFactory.newArray(parcelables.size());
        for (int i = 0; i < actions.length; i++) {
            Notification.Action action = (Notification.Action) parcelables.get(i);
            actions[i] = getActionCompatFromAction(action, actionFactory, remoteInputFactory);
        }
        return actions;
    }

    public static ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompatBase.Action[] actions) {
        if (actions == null) {
            return null;
        }
        ArrayList<Parcelable> parcelables = new ArrayList<>(actions.length);
        for (NotificationCompatBase.Action action : actions) {
            parcelables.add(getActionFromActionCompat(action));
        }
        return parcelables;
    }

    public static boolean getLocalOnly(Notification notif) {
        return (notif.flags & 256) != 0;
    }

    public static String getGroup(Notification notif) {
        return notif.getGroup();
    }

    public static boolean isGroupSummary(Notification notif) {
        return (notif.flags & 512) != 0;
    }

    public static String getSortKey(Notification notif) {
        return notif.getSortKey();
    }
}
