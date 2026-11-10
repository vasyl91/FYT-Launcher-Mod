package com.syu.radio.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.syu.radio.dao.RadioDao;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/syu/radio/viewmodel/RadioDaoModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/syu/radio/dao/RadioDao;", "radioDao", "<init>", "(Lcom/syu/radio/dao/RadioDao;)V", "radiolib_release"}, k = 1, mv = {1, 7, 1})
public final class RadioDaoModelFactory implements ViewModelProvider.Factory {
    public final RadioDao a;

    public RadioDaoModelFactory(RadioDao radioDao) {
        Intrinsics.checkNotNullParameter(radioDao, "radioDao");
        this.a = radioDao;
    }

    public <T extends ViewModel> T create(Class<T> modelClass) throws IllegalAccessException {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        if (modelClass.isAssignableFrom(RadioDaoModel.class)) {
            return new RadioDaoModel(this.a);
        }
        throw new IllegalAccessException("RadioDaoModelFactory Unknown ViewModel class");
    }
}
