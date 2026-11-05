package com.syu.manger.module;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/syu/manger/module/JMutableLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MutableLiveData;", "value", FinalChip.BSP_PLATFORM_Null, "postValue", "(Ljava/lang/Object;)V", "setValue", "<init>", "()V", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public final class JMutableLiveData<T> extends MutableLiveData<T> {
    public Object a;

    public JMutableLiveData() {
    }

    public JMutableLiveData(T t) {
        super(t);
        this.a = t;
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void postValue(T value) {
        if (Intrinsics.areEqual(this.a, value)) {
            return;
        }
        super.postValue(value);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void setValue(T value) {
        this.a = value;
        super.setValue(value);
    }
}
