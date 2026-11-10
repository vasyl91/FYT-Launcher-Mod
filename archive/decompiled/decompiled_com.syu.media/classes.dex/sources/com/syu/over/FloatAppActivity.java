package com.syu.over;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import chip.FinalChip;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0014J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014R\u001b\u0010\u0012\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/syu/over/FloatAppActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/os/Bundle;", "savedInstanceState", FinalChip.BSP_PLATFORM_Null, "onCreate", "onDestroy", FinalChip.BSP_PLATFORM_Null, "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/syu/over/FloatManager;", "a", "Lkotlin/Lazy;", "getFloatManger", "()Lcom/syu/over/FloatManager;", "floatManger", "<init>", "()V", "Library_release"}, k = 1, mv = {1, 7, 1})
public class FloatAppActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final Lazy floatManger = LazyKt.lazy(new Function0<FloatManager>() { // from class: com.syu.over.FloatAppActivity$floatManger$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final FloatManager m334invoke() {
            return new FloatManager(this.a);
        }
    });

    public final FloatManager getFloatManger() {
        return (FloatManager) this.floatManger.getValue();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && Settings.canDrawOverlays(this)) {
            getFloatManger().startBind();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("float", "-----------  " + Settings.canDrawOverlays(this));
        if (Settings.canDrawOverlays(this)) {
            getFloatManger().startBind();
        } else {
            startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), 100);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        getFloatManger().unbind();
        super.onDestroy();
    }
}
