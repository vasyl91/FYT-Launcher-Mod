package com.syu.media.base;

import android.app.ActivityOptions;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import chip.FinalChip;
import com.syu.media.ConstantsKt;
import com.syu.media.MediaApp;
import com.syu.media.R;
import com.syu.media.companion.utils.HiLog;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import syu.reflex.ReflexField;

/* JADX INFO: compiled from: BaseAct.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\nH\u0014J-\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\r2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\nH\u0014J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J.\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020 \u0018\u00010\u001fJ\u0016\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010!\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010#\u001a\u00020\nH\u0002¨\u0006$"}, d2 = {"Lcom/syu/media/base/BaseAct;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "getIntent", "Landroid/content/Intent;", "pkg", FinalChip.BSP_PLATFORM_Null, "getResources", "Landroid/content/res/Resources;", "gotoPlayFragment", FinalChip.BSP_PLATFORM_Null, "hideStatusNavigationBar", "mediaPriority", FinalChip.BSP_PLATFORM_Null, "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onRequestPermissionsResult", "requestCode", "permissions", FinalChip.BSP_PLATFORM_Null, "grantResults", FinalChip.BSP_PLATFORM_Null, "(I[Ljava/lang/String;[I)V", "onResume", "replaceFragment", "fragment", "Landroidx/fragment/app/Fragment;", "id", "map", FinalChip.BSP_PLATFORM_Null, "Landroid/view/View;", "start", "source", "translucentStatusBar", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class BaseAct extends AppCompatActivity {
    public void gotoPlayFragment() {
    }

    public int mediaPriority() {
        return 0;
    }

    public void replaceFragment(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        translucentStatusBar();
        super.onCreate(savedInstanceState);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0029  */
    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = super.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (displayMetrics.densityDpi == 160) {
            if (displayMetrics.density == 1.0f) {
                if (!(displayMetrics.scaledDensity == 1.25f)) {
                    displayMetrics.densityDpi = 160;
                    displayMetrics.density = 1.0f;
                    displayMetrics.scaledDensity = displayMetrics.density + 0.25f;
                }
            } else {
                displayMetrics.densityDpi = 160;
                displayMetrics.density = 1.0f;
                displayMetrics.scaledDensity = displayMetrics.density + 0.25f;
            }
        } else {
            displayMetrics.densityDpi = 160;
            displayMetrics.density = 1.0f;
            displayMetrics.scaledDensity = displayMetrics.density + 0.25f;
        }
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return resources;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.e("music", "onRequestPermissionsResult 00 - requestCode : " + requestCode + " permissions: " + permissions);
        if (requestCode != 200) {
            return;
        }
        StringBuilder sbAppend = new StringBuilder("onRequestPermissionsResult 02 - requestCode : ").append(requestCode).append(" permissions: ");
        String string = Arrays.toString(permissions);
        Intrinsics.checkNotNullExpressionValue(string, "toString(this)");
        StringBuilder sbAppend2 = sbAppend.append(string).append("  grantResults: ");
        String string2 = Arrays.toString(grantResults);
        Intrinsics.checkNotNullExpressionValue(string2, "toString(this)");
        Log.e("music", sbAppend2.append(string2).toString());
        int length = permissions.length;
        for (int i = 0; i < length; i++) {
            String str = permissions[i];
            if (grantResults[i] == 0 && !Intrinsics.areEqual(str, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                Intrinsics.areEqual(str, "android.permission.READ_EXTERNAL_STORAGE");
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        MediaApp.INSTANCE.getMe().getMediaFiles().setScanPriority(mediaPriority());
        for (String str : ConstantsKt.getRequiredPermissions()) {
            if (ContextCompat.checkSelfPermission(this, str) != 0) {
                ActivityCompat.requestPermissions(this, new String[]{str}, 200);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        MediaApp.INSTANCE.getMe().getMediaFiles().setScanPriority(mediaPriority());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void replaceFragment$default(BaseAct baseAct, int i, Fragment fragment, Map map, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: replaceFragment");
        }
        if ((i2 & 4) != 0) {
            map = null;
        }
        baseAct.replaceFragment(i, fragment, map);
    }

    public final void replaceFragment(int id, Fragment fragment, Map<String, View> map) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransactionBeginTransaction.setCustomAnimations(R.anim.frag_fade_blur_enter, R.anim.frag_fade_blur_exit);
        fragmentTransactionBeginTransaction.replace(id, fragment);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    private final void hideStatusNavigationBar() {
        getWindow().getDecorView().setSystemUiVisibility(5380);
    }

    private final void translucentStatusBar() {
        getWindow().clearFlags(201326592);
        getWindow().getDecorView().setSystemUiVisibility(1792);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
    }

    public final void start(View source, String pkg) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        try {
            startActivity(getIntent(pkg), ActivityOptions.makeScaleUpAnimation(source, source.getMeasuredWidth() / 2, source.getMeasuredHeight() / 2, 0, 0).toBundle());
        } catch (ActivityNotFoundException unused) {
        }
    }

    public final void start(String pkg) {
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        try {
            ActivityOptions activityOptionsMakeCustomAnimation = ActivityOptions.makeCustomAnimation(this, 0, 0);
            new ReflexField(ActivityOptions.class, "mAnimationType").setField(activityOptionsMakeCustomAnimation, 0);
            startActivity(getIntent(pkg), activityOptionsMakeCustomAnimation.toBundle());
        } catch (ActivityNotFoundException unused) {
        }
    }

    public final Intent getIntent(String pkg) {
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(pkg);
        getIntent().setFlags(270532608);
        HiLog.INSTANCE.d("music", "intent : " + getIntent());
        return launchIntentForPackage;
    }
}
