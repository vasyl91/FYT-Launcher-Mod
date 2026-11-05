package com.syu.media.network.error;

import androidx.core.app.NotificationCompat;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiException.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\fR\u001a\u0010\r\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/syu/media/network/error/ApiException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "Lcom/syu/media/network/error/ERROR;", "e", FinalChip.BSP_PLATFORM_Null, "(Lcom/syu/media/network/error/ERROR;Ljava/lang/Throwable;)V", "code", FinalChip.BSP_PLATFORM_Null, NotificationCompat.CATEGORY_MESSAGE, FinalChip.BSP_PLATFORM_Null, "(ILjava/lang/String;Ljava/lang/Throwable;)V", "errorCode", "getErrorCode", "()I", "setErrorCode", "(I)V", "errorMsg", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ApiException extends Exception {
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
    public ApiException(ERROR error, Throwable th) {
        super(th);
        Intrinsics.checkNotNullParameter(error, "error");
        this.errorCode = error.getCode();
        this.errorMsg = error.getErrMsg();
    }

    public /* synthetic */ ApiException(ERROR error, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(error, (i & 2) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApiException(int i, String str, Throwable th) {
        super(th);
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        this.errorCode = i;
        this.errorMsg = str;
    }

    public /* synthetic */ ApiException(int i, String str, Throwable th, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? null : th);
    }
}
