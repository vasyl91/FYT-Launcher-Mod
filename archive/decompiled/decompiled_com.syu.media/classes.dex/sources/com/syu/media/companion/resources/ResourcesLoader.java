package com.syu.media.companion.resources;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import androidx.core.content.res.ResourcesCompat;
import chip.FinalChip;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.provider.Media;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ResourcesLoader.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u0010\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u0005J\n\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/syu/media/companion/resources/ResourcesLoader;", FinalChip.BSP_PLATFORM_Null, "ctx", "Landroid/content/Context;", Media.PATH, FinalChip.BSP_PLATFORM_Null, "(Landroid/content/Context;Ljava/lang/String;)V", "resources", "Landroid/content/res/Resources;", "resourcesPackName", "decodeBitmap", "Landroid/graphics/Bitmap;", "name", "decodeDrawable", "Landroid/graphics/drawable/Drawable;", "loadResources", "packNameByPath", "removeSuffix", "str", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ResourcesLoader {
    public static final String TAG = "ResourcesLoader";
    private final Context ctx;
    private final String path;
    private Resources resources;
    private String resourcesPackName;

    public ResourcesLoader(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        Intrinsics.checkNotNullParameter(str, Media.PATH);
        this.ctx = context;
        this.path = str;
        this.resourcesPackName = FinalChip.BSP_PLATFORM_Null;
    }

    private final Resources loadResources() {
        try {
            HiLog.INSTANCE.d(TAG, "path:" + this.path);
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", String.class).invoke(assetManager, this.path);
            return new Resources(assetManager, this.ctx.getResources().getDisplayMetrics(), this.ctx.getResources().getConfiguration());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private final String packNameByPath() {
        PackageInfo packageArchiveInfo = this.ctx.getPackageManager().getPackageArchiveInfo(this.path, 1);
        String str = packageArchiveInfo != null ? packageArchiveInfo.packageName : null;
        return str == null ? FinalChip.BSP_PLATFORM_Null : str;
    }

    public final Bitmap decodeBitmap(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.resources == null) {
            this.resources = loadResources();
        }
        if (this.resourcesPackName.length() == 0) {
            this.resourcesPackName = packNameByPath();
        }
        String strRemoveSuffix = removeSuffix(name);
        Resources resources = this.resources;
        Integer numValueOf = resources != null ? Integer.valueOf(resources.getIdentifier(strRemoveSuffix, "drawable", this.resourcesPackName)) : null;
        Resources resources2 = this.resources;
        Intrinsics.checkNotNull(numValueOf);
        return BitmapFactory.decodeResource(resources2, numValueOf.intValue());
    }

    private final String removeSuffix(String str) {
        int iLastIndexOf$default = StringsKt.lastIndexOf$default(str, ".", 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return str;
        }
        String strSubstring = str.substring(0, iLastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final Drawable decodeDrawable(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        int identifier = 0;
        try {
            Resources resources = this.resources;
            Intrinsics.checkNotNull(resources);
            identifier = resources.getIdentifier(name, "drawable", this.resourcesPackName);
            Resources resources2 = this.resources;
            Intrinsics.checkNotNull(resources2);
            return ResourcesCompat.getDrawable(resources2, identifier, null);
        } catch (Resources.NotFoundException unused) {
            HiLog.INSTANCE.d(TAG, "decodeDrawable packageName:" + this.resourcesPackName + " ,id:" + identifier);
            return null;
        }
    }
}
