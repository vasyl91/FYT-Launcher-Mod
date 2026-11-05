package android.support.v4.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class TaskStackBuilder implements Iterable<Intent> {
    private static final TaskStackBuilderImpl IMPL;
    private static final String TAG = "TaskStackBuilder";
    private final ArrayList<Intent> mIntents = new ArrayList<>();
    private final Context mSourceContext;

    public interface SupportParentable {
        Intent getSupportParentActivityIntent();
    }

    interface TaskStackBuilderImpl {
        PendingIntent getPendingIntent(Context context, Intent[] intentArr, int i, int i2, Bundle bundle);
    }

    static class TaskStackBuilderImplBase implements TaskStackBuilderImpl {
        TaskStackBuilderImplBase() {
        }

        @Override // android.support.v4.app.TaskStackBuilder.TaskStackBuilderImpl
        public PendingIntent getPendingIntent(Context context, Intent[] intents, int requestCode, int flags, Bundle options) {
            Intent topIntent = new Intent(intents[intents.length - 1]);
            topIntent.addFlags(268435456);
            return PendingIntent.getActivity(context, requestCode, topIntent, flags);
        }
    }

    static class TaskStackBuilderImplHoneycomb implements TaskStackBuilderImpl {
        TaskStackBuilderImplHoneycomb() {
        }

        @Override // android.support.v4.app.TaskStackBuilder.TaskStackBuilderImpl
        public PendingIntent getPendingIntent(Context context, Intent[] intents, int requestCode, int flags, Bundle options) {
            intents[0] = new Intent(intents[0]).addFlags(268484608);
            return TaskStackBuilderHoneycomb.getActivitiesPendingIntent(context, requestCode, intents, flags);
        }
    }

    static class TaskStackBuilderImplJellybean implements TaskStackBuilderImpl {
        TaskStackBuilderImplJellybean() {
        }

        @Override // android.support.v4.app.TaskStackBuilder.TaskStackBuilderImpl
        public PendingIntent getPendingIntent(Context context, Intent[] intents, int requestCode, int flags, Bundle options) {
            intents[0] = new Intent(intents[0]).addFlags(268484608);
            return TaskStackBuilderJellybean.getActivitiesPendingIntent(context, requestCode, intents, flags, options);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new TaskStackBuilderImplHoneycomb();
        } else {
            IMPL = new TaskStackBuilderImplBase();
        }
    }

    private TaskStackBuilder(Context a) {
        this.mSourceContext = a;
    }

    public static TaskStackBuilder create(Context context) {
        return new TaskStackBuilder(context);
    }

    public static TaskStackBuilder from(Context context) {
        return create(context);
    }

    public TaskStackBuilder addNextIntent(Intent nextIntent) {
        this.mIntents.add(nextIntent);
        return this;
    }

    public TaskStackBuilder addNextIntentWithParentStack(Intent nextIntent) {
        ComponentName target = nextIntent.getComponent();
        if (target == null) {
            target = nextIntent.resolveActivity(this.mSourceContext.getPackageManager());
        }
        if (target != null) {
            addParentStack(target);
        }
        addNextIntent(nextIntent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TaskStackBuilder addParentStack(Activity activity) {
        Intent parent = null;
        if (activity instanceof SupportParentable) {
            parent = ((SupportParentable) activity).getSupportParentActivityIntent();
        }
        if (parent == null) {
            parent = NavUtils.getParentActivityIntent(activity);
        }
        if (parent != null) {
            ComponentName target = parent.getComponent();
            if (target == null) {
                target = parent.resolveActivity(this.mSourceContext.getPackageManager());
            }
            addParentStack(target);
            addNextIntent(parent);
        }
        return this;
    }

    public TaskStackBuilder addParentStack(Class<?> sourceActivityClass) {
        return addParentStack(new ComponentName(this.mSourceContext, sourceActivityClass));
    }

    public TaskStackBuilder addParentStack(ComponentName sourceActivityName) {
        int insertAt = this.mIntents.size();
        try {
            Intent parent = NavUtils.getParentActivityIntent(this.mSourceContext, sourceActivityName);
            while (parent != null) {
                this.mIntents.add(insertAt, parent);
                parent = NavUtils.getParentActivityIntent(this.mSourceContext, parent.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public int getIntentCount() {
        return this.mIntents.size();
    }

    public Intent getIntent(int index) {
        return editIntentAt(index);
    }

    public Intent editIntentAt(int index) {
        return this.mIntents.get(index);
    }

    @Override // java.lang.Iterable
    public Iterator<Intent> iterator() {
        return this.mIntents.iterator();
    }

    public void startActivities() {
        startActivities(null);
    }

    public void startActivities(Bundle options) {
        if (this.mIntents.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intents = (Intent[]) this.mIntents.toArray(new Intent[this.mIntents.size()]);
        intents[0] = new Intent(intents[0]).addFlags(268484608);
        if (!ContextCompat.startActivities(this.mSourceContext, intents, options)) {
            Intent topIntent = new Intent(intents[intents.length - 1]);
            topIntent.addFlags(268435456);
            this.mSourceContext.startActivity(topIntent);
        }
    }

    public PendingIntent getPendingIntent(int requestCode, int flags) {
        return getPendingIntent(requestCode, flags, null);
    }

    public PendingIntent getPendingIntent(int requestCode, int flags, Bundle options) {
        if (this.mIntents.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        }
        Intent[] intents = (Intent[]) this.mIntents.toArray(new Intent[this.mIntents.size()]);
        intents[0] = new Intent(intents[0]).addFlags(268484608);
        return IMPL.getPendingIntent(this.mSourceContext, intents, requestCode, flags, options);
    }

    public Intent[] getIntents() {
        Intent[] intents = new Intent[this.mIntents.size()];
        if (intents.length != 0) {
            intents[0] = new Intent(this.mIntents.get(0)).addFlags(268484608);
            for (int i = 1; i < intents.length; i++) {
                intents[i] = new Intent(this.mIntents.get(i));
            }
        }
        return intents;
    }
}
