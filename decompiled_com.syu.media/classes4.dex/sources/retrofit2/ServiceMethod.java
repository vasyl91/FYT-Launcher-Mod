package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
abstract class ServiceMethod<T> {
    @Nullable
    abstract T invoke(Object[] objArr);

    ServiceMethod() {
    }

    static <T> ServiceMethod<T> parseAnnotations(Retrofit retrofit, Method method) {
        RequestFactory annotations = RequestFactory.parseAnnotations(retrofit, method);
        Type genericReturnType = method.getGenericReturnType();
        if (Utils.hasUnresolvableType(genericReturnType)) {
            throw Utils.methodError(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
        }
        if (genericReturnType == Void.TYPE) {
            throw Utils.methodError(method, "Service methods cannot return void.", new Object[0]);
        }
        return HttpServiceMethod.parseAnnotations(retrofit, method, annotations);
    }
}
