package com.syu.launcher.media;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import chip.FinalChip;
import com.fasterxml.aalto.util.XmlConsts;
import com.syu.utils.BitmapUtils;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\"\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bQ\u0010RJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J \u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007J\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0007J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016R\u0017\u0010\"\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010)\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u00100\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00108\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010<\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010$\u001a\u0004\b:\u0010&\"\u0004\b;\u0010(R\"\u0010@\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010$\u001a\u0004\b>\u0010&\"\u0004\b?\u0010(R\"\u0010D\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010$\u001a\u0004\bB\u0010&\"\u0004\bC\u0010(R\"\u0010H\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010$\u001a\u0004\bF\u0010&\"\u0004\bG\u0010(R\"\u0010L\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010$\u001a\u0004\bJ\u0010&\"\u0004\bK\u0010(R\"\u0010P\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u00103\u001a\u0004\bN\u00105\"\u0004\bO\u00107¨\u0006S"}, d2 = {"Lcom/syu/launcher/media/NaviInfo;", FinalChip.BSP_PLATFORM_Null, "other", FinalChip.BSP_PLATFORM_Null, "equals", "Landroid/os/Bundle;", "extras", FinalChip.BSP_PLATFORM_Null, "key", "def", "charSequenceOf", "stringOf", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "drawableOf", "Landroid/view/ViewGroup;", "group", "findDrawable", "findString", "drawable", "filepath", FinalChip.BSP_PLATFORM_Null, "saveImage", "findMessage", "toString", "Landroid/app/Notification;", "notification", "parse", "Lcom/syu/launcher/media/MediaApp;", "a", "Lcom/syu/launcher/media/MediaApp;", "getNaviApp", "()Lcom/syu/launcher/media/MediaApp;", "naviApp", "b", "Ljava/lang/String;", "getCrossing", "()Ljava/lang/String;", "setCrossing", "(Ljava/lang/String;)V", "crossing", "c", "Landroid/graphics/drawable/Drawable;", "getRouteSign", "()Landroid/graphics/drawable/Drawable;", "setRouteSign", "(Landroid/graphics/drawable/Drawable;)V", "routeSign", FinalChip.BSP_PLATFORM_Null, "d", "I", "getRouteType", "()I", "setRouteType", "(I)V", "routeType", "e", "getLocation", "setLocation", "location", "f", "getMileage", "setMileage", "mileage", "g", "getTime", "setTime", "time", "h", "getArrival", "setArrival", "arrival", "i", "getMessage", "setMessage", "message", "j", "getIndex", "setIndex", "index", "<init>", "()V", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public class NaviInfo {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public Drawable routeSign;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public int index;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final MediaApp naviApp = new MediaApp(null, null, null, 7, null);

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public String crossing = FinalChip.BSP_PLATFORM_Null;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public int routeType = -1;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public String location = FinalChip.BSP_PLATFORM_Null;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public String mileage = FinalChip.BSP_PLATFORM_Null;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public String time = FinalChip.BSP_PLATFORM_Null;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public String arrival = FinalChip.BSP_PLATFORM_Null;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public String message = FinalChip.BSP_PLATFORM_Null;

    public static /* synthetic */ String charSequenceOf$default(NaviInfo naviInfo, Bundle bundle, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: charSequenceOf");
        }
        if ((i & 4) != 0) {
            str2 = FinalChip.BSP_PLATFORM_Null;
        }
        return naviInfo.charSequenceOf(bundle, str, str2);
    }

    public static /* synthetic */ Drawable drawableOf$default(NaviInfo naviInfo, Context context, Bundle bundle, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawableOf");
        }
        if ((i & 4) != 0) {
            str = NotificationCompat.EXTRA_LARGE_ICON;
        }
        return naviInfo.drawableOf(context, bundle, str);
    }

    public static /* synthetic */ String stringOf$default(NaviInfo naviInfo, Bundle bundle, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stringOf");
        }
        if ((i & 4) != 0) {
            str2 = FinalChip.BSP_PLATFORM_Null;
        }
        return naviInfo.stringOf(bundle, str, str2);
    }

    public final String charSequenceOf(Bundle extras, String key, String def) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(def, "def");
        return extras.keySet().contains(key) ? extras.getCharSequence(key, def).toString() : def;
    }

    public final Drawable drawableOf(Context context, Bundle extras, String key) {
        Icon icon;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(key, "key");
        if (!extras.containsKey(key) || (icon = (Icon) extras.getParcelable(NotificationCompat.EXTRA_LARGE_ICON)) == null) {
            return null;
        }
        return icon.loadDrawable(context);
    }

    public boolean equals(Object other) {
        if (!(other instanceof NaviInfo)) {
            return super.equals(other);
        }
        NaviInfo naviInfo = (NaviInfo) other;
        return Intrinsics.areEqual(this.naviApp, naviInfo.naviApp) && Intrinsics.areEqual(naviInfo.crossing, this.crossing) && Intrinsics.areEqual(naviInfo.location, this.location) && Intrinsics.areEqual(naviInfo.message, this.message);
    }

    public final Drawable findDrawable(ViewGroup group) throws IOException {
        Intrinsics.checkNotNullParameter(group, "group");
        int childCount = group.getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                return null;
            }
            View childAt = group.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                Drawable drawableFindDrawable = findDrawable((ViewGroup) childAt);
                if (drawableFindDrawable != null) {
                    return drawableFindDrawable;
                }
            } else if (childAt instanceof ImageView) {
                ImageView imageView = (ImageView) childAt;
                Drawable drawable = imageView.getDrawable();
                MediaManager.Companion companion = MediaManager.INSTANCE;
                if (companion.getDEBUG()) {
                    Log.e(companion.getTAG(), " ------  updateMediaInfo " + imageView.getId() + " -- drawable: " + drawable + " info: " + (drawable != null ? Integer.valueOf(drawable.getIntrinsicWidth()) : null) + " x " + (drawable != null ? Integer.valueOf(drawable.getIntrinsicHeight()) : null));
                }
                if (drawable != null) {
                    saveImage(drawable, "/storage/emulated/0/image-" + imageView.getId() + ".png");
                }
                if (drawable != null && drawable.getIntrinsicWidth() > 90 && drawable.getIntrinsicHeight() > 90) {
                    return drawable;
                }
            } else {
                continue;
            }
            i++;
        }
    }

    public void findMessage(ViewGroup group) throws IOException {
        Intrinsics.checkNotNullParameter(group, "group");
        int childCount = group.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = group.getChildAt(i);
            MediaManager.Companion companion = MediaManager.INSTANCE;
            Log.e(companion.getTAG(), " child id: " + childAt.getId() + "  " + childAt.getClass() + " -- " + childAt + XmlConsts.CHAR_SPACE);
            if (childAt instanceof ViewGroup) {
                findMessage((ViewGroup) childAt);
            } else if (childAt instanceof ImageView) {
                ImageView imageView = (ImageView) childAt;
                Drawable drawable = imageView.getDrawable();
                if (drawable != null) {
                    Log.e(companion.getTAG(), " ------  drawable: " + imageView.getId() + " -- " + drawable + " info: " + Integer.valueOf(drawable.getIntrinsicWidth()) + " x " + Integer.valueOf(drawable.getIntrinsicHeight()));
                    saveImage(drawable, "/storage/emulated/0/image-" + imageView.getId() + ".png");
                }
            } else if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                Log.e(companion.getTAG(), " TextView id: " + textView.getId() + "  text: " + ((Object) textView.getText()));
            }
        }
    }

    public final String findString(ViewGroup group) {
        Intrinsics.checkNotNullParameter(group, "group");
        int childCount = group.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = group.getChildAt(i);
            MediaManager.Companion companion = MediaManager.INSTANCE;
            Log.e(companion.getTAG(), " child id: " + childAt.getId() + "  text: " + childAt + XmlConsts.CHAR_SPACE + childAt.getClass());
            if (childAt instanceof ViewGroup) {
                String strFindString = findString((ViewGroup) childAt);
                if (strFindString != null) {
                    return strFindString;
                }
            } else if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                Log.e(companion.getTAG(), " TextView id: " + textView.getId() + "  text: " + ((Object) textView.getText()));
            }
        }
        return FinalChip.BSP_PLATFORM_Null;
    }

    public final String getArrival() {
        return this.arrival;
    }

    public final String getCrossing() {
        return this.crossing;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getMileage() {
        return this.mileage;
    }

    public final MediaApp getNaviApp() {
        return this.naviApp;
    }

    public final Drawable getRouteSign() {
        return this.routeSign;
    }

    public final int getRouteType() {
        return this.routeType;
    }

    public final String getTime() {
        return this.time;
    }

    public void parse(Context context, Notification notification) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notification, "notification");
    }

    public final void saveImage(Drawable drawable, String filepath) throws IOException {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(filepath, "filepath");
        FileOutputStream fileOutputStream = new FileOutputStream(filepath);
        try {
            Bitmap bitmapDrawable2Bitmap = BitmapUtils.INSTANCE.drawable2Bitmap(drawable);
            bitmapDrawable2Bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            bitmapDrawable2Bitmap.recycle();
            CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileOutputStream, th);
                throw th2;
            }
        }
    }

    public final void setArrival(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.arrival = str;
    }

    public final void setCrossing(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.crossing = str;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final void setLocation(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.location = str;
    }

    public final void setMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    public final void setMileage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mileage = str;
    }

    public final void setRouteSign(Drawable drawable) {
        this.routeSign = drawable;
    }

    public final void setRouteType(int i) {
        this.routeType = i;
    }

    public final void setTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.time = str;
    }

    public final String stringOf(Bundle extras, String key, String def) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(def, "def");
        if (!extras.keySet().contains(key)) {
            return def;
        }
        String string = extras.getString(key, def);
        Intrinsics.checkNotNullExpressionValue(string, "extras.getString(key, def)");
        return string;
    }

    public String toString() {
        return "NaviInfo : " + this.naviApp + " crossing: " + this.crossing + " location: " + this.location + " message: " + this.message + "  time: " + this.time + " mileage: " + this.mileage + " arrival: " + this.arrival;
    }
}
