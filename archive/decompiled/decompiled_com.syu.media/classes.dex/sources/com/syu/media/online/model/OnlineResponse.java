package com.syu.media.online.model;

import chip.FinalChip;
import com.fasterxml.aalto.util.XmlConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OnlineJson.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/syu/media/online/model/OnlineResponse;", FinalChip.BSP_PLATFORM_Null, XmlConsts.XML_DECL_KW_VERSION, FinalChip.BSP_PLATFORM_Null, "result", "Lcom/syu/media/online/model/OnlineJson;", "(ILcom/syu/media/online/model/OnlineJson;)V", "getResult", "()Lcom/syu/media/online/model/OnlineJson;", "getVersion", "()I", "component1", "component2", "copy", "equals", FinalChip.BSP_PLATFORM_Null, "other", "hashCode", "toString", FinalChip.BSP_PLATFORM_Null, "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class OnlineResponse {
    private final OnlineJson result;
    private final int version;

    public static /* synthetic */ OnlineResponse copy$default(OnlineResponse onlineResponse, int i, OnlineJson onlineJson, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = onlineResponse.version;
        }
        if ((i2 & 2) != 0) {
            onlineJson = onlineResponse.result;
        }
        return onlineResponse.copy(i, onlineJson);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final OnlineJson getResult() {
        return this.result;
    }

    public final OnlineResponse copy(int version, OnlineJson result) {
        Intrinsics.checkNotNullParameter(result, "result");
        return new OnlineResponse(version, result);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnlineResponse)) {
            return false;
        }
        OnlineResponse onlineResponse = (OnlineResponse) other;
        return this.version == onlineResponse.version && Intrinsics.areEqual(this.result, onlineResponse.result);
    }

    public int hashCode() {
        return (Integer.hashCode(this.version) * 31) + this.result.hashCode();
    }

    public String toString() {
        return "OnlineResponse(version=" + this.version + ", result=" + this.result + ')';
    }

    public OnlineResponse(int i, OnlineJson onlineJson) {
        Intrinsics.checkNotNullParameter(onlineJson, "result");
        this.version = i;
        this.result = onlineJson;
    }

    public /* synthetic */ OnlineResponse(int i, OnlineJson onlineJson, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i, onlineJson);
    }

    public final OnlineJson getResult() {
        return this.result;
    }

    public final int getVersion() {
        return this.version;
    }
}
