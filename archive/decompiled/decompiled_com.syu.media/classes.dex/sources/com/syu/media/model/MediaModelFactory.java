package com.syu.media.model;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.syu.media.dao.MediaDao;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/syu/media/model/MediaModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/syu/media/dao/MediaDao;", "musicDao", "<init>", "(Lcom/syu/media/dao/MediaDao;)V", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
public final class MediaModelFactory implements ViewModelProvider.Factory {
    public final MediaDao a;

    public MediaModelFactory(MediaDao mediaDao) {
        Intrinsics.checkNotNullParameter(mediaDao, "musicDao");
        this.a = mediaDao;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) throws IllegalAccessException {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        if (modelClass.isAssignableFrom(MediaModel.class)) {
            return new MediaModel(this.a);
        }
        throw new IllegalAccessException("MediaModelFactory Unknown ViewModel class");
    }
}
