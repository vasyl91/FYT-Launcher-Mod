package com.syu.media.network.response;

import androidx.exifinterface.media.ExifInterface;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseResponse.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0006J \u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/syu/media/network/response/BasicResponse;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/syu/media/network/response/BaseResponse;", "radioList", "(Ljava/lang/Object;)V", "getRadioList", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/syu/media/network/response/BasicResponse;", "equals", FinalChip.BSP_PLATFORM_Null, "other", FinalChip.BSP_PLATFORM_Null, "hashCode", FinalChip.BSP_PLATFORM_Null, "toString", FinalChip.BSP_PLATFORM_Null, "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class BasicResponse<T> extends BaseResponse<T> {
    private final T radioList;

    /* JADX WARN: Illegal instructions before constructor call */
    public BasicResponse() {
        DefaultConstructorMarker defaultConstructorMarker = null;
        this(defaultConstructorMarker, 1, defaultConstructorMarker);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BasicResponse copy$default(BasicResponse basicResponse, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = basicResponse.radioList;
        }
        return basicResponse.copy(obj);
    }

    public final T component1() {
        return this.radioList;
    }

    public final BasicResponse<T> copy(T radioList) {
        return new BasicResponse<>(radioList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof BasicResponse) && Intrinsics.areEqual(this.radioList, ((BasicResponse) other).radioList);
    }

    public int hashCode() {
        T t = this.radioList;
        if (t == null) {
            return 0;
        }
        return t.hashCode();
    }

    public String toString() {
        return "BasicResponse(radioList=" + this.radioList + ')';
    }

    public BasicResponse(T t) {
        super(null, 0, 0, null, null, 31, null);
        this.radioList = t;
    }

    public /* synthetic */ BasicResponse(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : obj);
    }

    public final T getRadioList() {
        return this.radioList;
    }
}
