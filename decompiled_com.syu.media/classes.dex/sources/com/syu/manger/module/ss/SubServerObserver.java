package com.syu.manger.module.ss;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import chip.FinalChip;
import com.syu.manger.module.BaseModuleObserver;
import com.syu.manger.module.main.MainModel;
import com.syu.media.provider.Media;
import com.syu.remote.Message;
import com.syu.remote.ModuleManager;
import com.syu.utils.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/syu/manger/module/ss/SubServerObserver;", "Lcom/syu/manger/module/BaseModuleObserver;", "Lcom/syu/manger/module/main/MainModel;", "manager", "Lcom/syu/remote/ModuleManager;", "model", "(Lcom/syu/remote/ModuleManager;Lcom/syu/manger/module/main/MainModel;)V", "onReceiver", FinalChip.BSP_PLATFORM_Null, NotificationCompat.CATEGORY_MESSAGE, "Lcom/syu/remote/Message;", "AutoManger_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SubServerObserver extends BaseModuleObserver<MainModel> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubServerObserver(ModuleManager moduleManager, MainModel mainModel) {
        super(moduleManager, mainModel, 1, 0);
        Intrinsics.checkNotNullParameter(moduleManager, "manager");
        Intrinsics.checkNotNullParameter(mainModel, "model");
    }

    public void onReceiver(Message msg) {
        Intrinsics.checkNotNullParameter(msg, NotificationCompat.CATEGORY_MESSAGE);
        Log.e(Media.ONLINE_TABLE, " xxx ==========    " + msg + "   old city : " + getModel().getCity().getValue());
        if (msg.code == 0 && Utils.checkIndex(msg.strs, 0) && !Intrinsics.areEqual(getModel().getCity().getValue(), msg.strs[0])) {
            getModel().getCity().postValue(msg.strs[0]);
        }
    }
}
