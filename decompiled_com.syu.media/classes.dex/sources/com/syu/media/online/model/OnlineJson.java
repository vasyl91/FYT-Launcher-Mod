package com.syu.media.online.model;

import chip.FinalChip;
import com.fasterxml.aalto.util.XmlConsts;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OnlineJson.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/syu/media/online/model/OnlineJson;", FinalChip.BSP_PLATFORM_Null, "dataUrl", FinalChip.BSP_PLATFORM_Null, XmlConsts.XML_DECL_KW_VERSION, FinalChip.BSP_PLATFORM_Null, "radioList", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/media/online/model/OnlineRadio;", "(Ljava/lang/String;ILjava/util/List;)V", "getDataUrl", "()Ljava/lang/String;", "getRadioList", "()Ljava/util/List;", "getVersion", "()I", "component1", "component2", "component3", "copy", "equals", FinalChip.BSP_PLATFORM_Null, "other", "hashCode", "toString", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class OnlineJson {
    private final String dataUrl;
    private final List<OnlineRadio> radioList;
    private final int version;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OnlineJson copy$default(OnlineJson onlineJson, String str, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = onlineJson.dataUrl;
        }
        if ((i2 & 2) != 0) {
            i = onlineJson.version;
        }
        if ((i2 & 4) != 0) {
            list = onlineJson.radioList;
        }
        return onlineJson.copy(str, i, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDataUrl() {
        return this.dataUrl;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    public final List<OnlineRadio> component3() {
        return this.radioList;
    }

    public final OnlineJson copy(String dataUrl, int version, List<OnlineRadio> radioList) {
        Intrinsics.checkNotNullParameter(dataUrl, "dataUrl");
        Intrinsics.checkNotNullParameter(radioList, "radioList");
        return new OnlineJson(dataUrl, version, radioList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnlineJson)) {
            return false;
        }
        OnlineJson onlineJson = (OnlineJson) other;
        return Intrinsics.areEqual(this.dataUrl, onlineJson.dataUrl) && this.version == onlineJson.version && Intrinsics.areEqual(this.radioList, onlineJson.radioList);
    }

    public int hashCode() {
        return (((this.dataUrl.hashCode() * 31) + Integer.hashCode(this.version)) * 31) + this.radioList.hashCode();
    }

    public String toString() {
        return "OnlineJson(dataUrl=" + this.dataUrl + ", version=" + this.version + ", radioList=" + this.radioList + ')';
    }

    public OnlineJson(String str, int i, List<OnlineRadio> list) {
        Intrinsics.checkNotNullParameter(str, "dataUrl");
        Intrinsics.checkNotNullParameter(list, "radioList");
        this.dataUrl = str;
        this.version = i;
        this.radioList = list;
    }

    public final String getDataUrl() {
        return this.dataUrl;
    }

    public final int getVersion() {
        return this.version;
    }

    public final List<OnlineRadio> getRadioList() {
        return this.radioList;
    }
}
