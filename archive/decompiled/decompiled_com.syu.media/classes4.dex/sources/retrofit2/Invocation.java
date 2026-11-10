package retrofit2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public final class Invocation {
    private final List<?> arguments;
    private final Method method;

    public static Invocation of(Method method, List<?> list) {
        Objects.requireNonNull(method, "method == null");
        Objects.requireNonNull(list, "arguments == null");
        return new Invocation(method, new ArrayList(list));
    }

    Invocation(Method method, List<?> list) {
        this.method = method;
        this.arguments = Collections.unmodifiableList(list);
    }

    public Method method() {
        return this.method;
    }

    public List<?> arguments() {
        return this.arguments;
    }

    public String toString() {
        return String.format("%s.%s() %s", this.method.getDeclaringClass().getName(), this.method.getName(), this.arguments);
    }
}
