package com.syu.media.network.error;

import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiException.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/syu/media/network/error/NoNetWorkException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "Lcom/syu/media/network/error/ERROR;", "e", FinalChip.BSP_PLATFORM_Null, "(Lcom/syu/media/network/error/ERROR;Ljava/lang/Throwable;)V", "errorCode", FinalChip.BSP_PLATFORM_Null, "getErrorCode", "()I", "setErrorCode", "(I)V", "errorMsg", FinalChip.BSP_PLATFORM_Null, "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NoNetWorkException extends Exception {
    private int errorCode;
    private String errorMsg;

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(int i) {
        this.errorCode = i;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final void setErrorMsg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errorMsg = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoNetWorkException(ERROR error, Throwable th) {
        super(th);
        Intrinsics.checkNotNullParameter(error, "error");
        this.errorCode = error.getCode();
        this.errorMsg = error.getErrMsg();
    }

    public /* synthetic */ NoNetWorkException(ERROR error, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(error, (i & 2) != 0 ? null : th);
    }
}
