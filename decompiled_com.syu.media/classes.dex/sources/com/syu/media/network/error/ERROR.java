package com.syu.media.network.error;

import androidx.core.view.PointerIconCompat;
import base.event.AutoKeyEvent;
import chip.FinalChip;
import kotlin.Metadata;

/* JADX INFO: compiled from: ERROR.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/syu/media/network/error/ERROR;", FinalChip.BSP_PLATFORM_Null, "code", FinalChip.BSP_PLATFORM_Null, "errMsg", FinalChip.BSP_PLATFORM_Null, "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getErrMsg", "()Ljava/lang/String;", "UNAUTHORIZED", "FORBIDDEN", "NOT_FOUND", "REQUEST_TIMEOUT", "INTERNAL_SERVER_ERROR", "BAD_GATEWAY", "SERVICE_UNAVAILABLE", "GATEWAY_TIMEOUT", "UNKNOWN", "PARSE_ERROR", "NETWORD_ERROR", "HTTP_ERROR", "SSL_ERROR", "TIMEOUT_ERROR", "UNLOGIN", "UNKNOW_HOST", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum ERROR {
    UNAUTHORIZED(AutoKeyEvent.KEYCODE_VOLUME_DOWN_STEP2, "当前请求需要用户验证"),
    FORBIDDEN(AutoKeyEvent.KEYCODE_VOLUME_DOWN_STEP3, "资源不可用"),
    NOT_FOUND(AutoKeyEvent.KEYCODE_VOLUME_UP_NOUI, "无法找到指定位置的资源"),
    REQUEST_TIMEOUT(408, "请求超时"),
    INTERNAL_SERVER_ERROR(500, "服务器错误"),
    BAD_GATEWAY(502, "非法应答"),
    SERVICE_UNAVAILABLE(503, "服务器未能应答"),
    GATEWAY_TIMEOUT(504, "服务器未能应答"),
    UNKNOWN(1000, "未知错误"),
    PARSE_ERROR(1001, "解析错误"),
    NETWORD_ERROR(1002, "网络异常，请尝试刷新"),
    HTTP_ERROR(1003, "404 Not Found"),
    SSL_ERROR(PointerIconCompat.TYPE_WAIT, "证书出错"),
    TIMEOUT_ERROR(PointerIconCompat.TYPE_CELL, "连接超时"),
    UNLOGIN(-1001, "未登录"),
    UNKNOW_HOST(PointerIconCompat.TYPE_CROSSHAIR, "未知Host");

    private final int code;
    private final String errMsg;

    ERROR(int i, String str) {
        this.code = i;
        this.errMsg = str;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getErrMsg() {
        return this.errMsg;
    }
}
