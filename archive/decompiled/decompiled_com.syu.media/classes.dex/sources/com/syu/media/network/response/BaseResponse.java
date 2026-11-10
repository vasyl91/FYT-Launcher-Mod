package com.syu.media.network.response;

import androidx.exifinterface.media.ExifInterface;
import chip.FinalChip;
import com.fasterxml.aalto.util.XmlConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseResponse.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B9\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u0006\u0010\u001a\u001a\u00020\u001bR\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/syu/media/network/response/BaseResponse;", ExifInterface.GPS_DIRECTION_TRUE, FinalChip.BSP_PLATFORM_Null, "result", "resultcode", FinalChip.BSP_PLATFORM_Null, XmlConsts.XML_DECL_KW_VERSION, "reason", FinalChip.BSP_PLATFORM_Null, "dataUrl", "(Ljava/lang/Object;IILjava/lang/String;Ljava/lang/String;)V", "getDataUrl", "()Ljava/lang/String;", "setDataUrl", "(Ljava/lang/String;)V", "getReason", "setReason", "getResult", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getResultcode", "()I", "setResultcode", "(I)V", "getVersion", "setVersion", "isFail", FinalChip.BSP_PLATFORM_Null, "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class BaseResponse<T> {
    private String dataUrl;
    private String reason;
    private final T result;
    private int resultcode;
    private int version;

    public BaseResponse() {
        this(null, 0, 0, null, null, 31, null);
    }

    public BaseResponse(T t, int i, int i2, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "reason");
        Intrinsics.checkNotNullParameter(str2, "dataUrl");
        this.result = t;
        this.resultcode = i;
        this.version = i2;
        this.reason = str;
        this.dataUrl = str2;
    }

    public /* synthetic */ BaseResponse(Object obj, int i, int i2, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : obj, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? -1 : i2, (i3 & 8) != 0 ? FinalChip.BSP_PLATFORM_Null : str, (i3 & 16) != 0 ? FinalChip.BSP_PLATFORM_Null : str2);
    }

    public final T getResult() {
        return this.result;
    }

    public final int getResultcode() {
        return this.resultcode;
    }

    public final void setResultcode(int i) {
        this.resultcode = i;
    }

    public final int getVersion() {
        return this.version;
    }

    public final void setVersion(int i) {
        this.version = i;
    }

    public final String getReason() {
        return this.reason;
    }

    public final void setReason(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.reason = str;
    }

    public final String getDataUrl() {
        return this.dataUrl;
    }

    public final void setDataUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dataUrl = str;
    }

    public final boolean isFail() {
        return this.resultcode != 0;
    }
}
