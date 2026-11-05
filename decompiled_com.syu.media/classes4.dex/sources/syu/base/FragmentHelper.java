package syu.base;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R#\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lsyu/base/FragmentHelper;", "", "Lsyu/base/FragmentHelper$MessageHandler;", "handler", "", "addHandler", "removeHandler", "", "", "a", "Ljava/util/Map;", "getMHandlers", "()Ljava/util/Map;", "mHandlers", "<init>", "()V", "MessageHandler", "Library_release"}, k = 1, mv = {1, 7, 1})
public final class FragmentHelper {
    public final LinkedHashMap a = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0006H&R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lsyu/base/FragmentHelper$MessageHandler;", "", "", "msg", "", "isMe", "", "onHandle", "a", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Library_release"}, k = 1, mv = {1, 7, 1})
    public static abstract class MessageHandler {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        public final String msg;

        public MessageHandler(String str) {
            Intrinsics.checkNotNullParameter(str, "msg");
            this.msg = str;
        }

        public final String getMsg() {
            return this.msg;
        }

        public final boolean isMe(String msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            return Intrinsics.areEqual(this.msg, msg);
        }

        public abstract void onHandle();
    }

    public final void addHandler(MessageHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        synchronized (this.a) {
            this.a.put(handler.getMsg(), handler);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final Map<String, MessageHandler> getMHandlers() {
        return this.a;
    }

    public final void removeHandler(MessageHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        synchronized (this.a) {
        }
    }
}
