package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public final class Retrofit {
    final HttpUrl baseUrl;
    final List<CallAdapter.Factory> callAdapterFactories;
    final okhttp3.Call.Factory callFactory;

    @Nullable
    final Executor callbackExecutor;
    final List<Converter.Factory> converterFactories;
    private final Map<Method, ServiceMethod<?>> serviceMethodCache = new ConcurrentHashMap();
    final boolean validateEagerly;

    Retrofit(okhttp3.Call.Factory factory, HttpUrl httpUrl, List<Converter.Factory> list, List<CallAdapter.Factory> list2, @Nullable Executor executor, boolean z) {
        this.callFactory = factory;
        this.baseUrl = httpUrl;
        this.converterFactories = list;
        this.callAdapterFactories = list2;
        this.callbackExecutor = executor;
        this.validateEagerly = z;
    }

    public <T> T create(final Class<T> cls) {
        validateServiceInterface(cls);
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: retrofit2.Retrofit.1
            private final Platform platform = Platform.get();
            private final Object[] emptyArgs = new Object[0];

            @Override // java.lang.reflect.InvocationHandler
            @Nullable
            public Object invoke(Object obj, Method method, @Nullable Object[] objArr) throws Throwable {
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, objArr);
                }
                if (objArr == null) {
                    objArr = this.emptyArgs;
                }
                if (this.platform.isDefaultMethod(method)) {
                    return this.platform.invokeDefaultMethod(method, cls, obj, objArr);
                }
                return Retrofit.this.loadServiceMethod(method).invoke(objArr);
            }
        });
    }

    private void validateServiceInterface(Class<?> cls) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        ArrayDeque arrayDeque = new ArrayDeque(1);
        arrayDeque.add(cls);
        while (!arrayDeque.isEmpty()) {
            Class<?> cls2 = (Class) arrayDeque.removeFirst();
            if (cls2.getTypeParameters().length != 0) {
                StringBuilder sbAppend = new StringBuilder("Type parameters are unsupported on ").append(cls2.getName());
                if (cls2 != cls) {
                    sbAppend.append(" which is an interface of ").append(cls.getName());
                }
                throw new IllegalArgumentException(sbAppend.toString());
            }
            Collections.addAll(arrayDeque, cls2.getInterfaces());
        }
        if (this.validateEagerly) {
            Platform platform = Platform.get();
            for (Method method : cls.getDeclaredMethods()) {
                if (!platform.isDefaultMethod(method) && !Modifier.isStatic(method.getModifiers())) {
                    loadServiceMethod(method);
                }
            }
        }
    }

    ServiceMethod<?> loadServiceMethod(Method method) {
        ServiceMethod<?> annotations;
        ServiceMethod<?> serviceMethod = this.serviceMethodCache.get(method);
        if (serviceMethod != null) {
            return serviceMethod;
        }
        synchronized (this.serviceMethodCache) {
            annotations = this.serviceMethodCache.get(method);
            if (annotations == null) {
                annotations = ServiceMethod.parseAnnotations(this, method);
                this.serviceMethodCache.put(method, annotations);
            }
        }
        return annotations;
    }

    public okhttp3.Call.Factory callFactory() {
        return this.callFactory;
    }

    public HttpUrl baseUrl() {
        return this.baseUrl;
    }

    public List<CallAdapter.Factory> callAdapterFactories() {
        return this.callAdapterFactories;
    }

    public CallAdapter<?, ?> callAdapter(Type type, Annotation[] annotationArr) {
        return nextCallAdapter(null, type, annotationArr);
    }

    public CallAdapter<?, ?> nextCallAdapter(@Nullable CallAdapter.Factory factory, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.callAdapterFactories.indexOf(factory) + 1;
        int size = this.callAdapterFactories.size();
        for (int i = iIndexOf; i < size; i++) {
            CallAdapter<?, ?> callAdapter = this.callAdapterFactories.get(i).get(type, annotationArr, this);
            if (callAdapter != null) {
                return callAdapter;
            }
        }
        StringBuilder sbAppend = new StringBuilder("Could not locate call adapter for ").append(type).append(".\n");
        if (factory != null) {
            sbAppend.append("  Skipped:");
            for (int i2 = 0; i2 < iIndexOf; i2++) {
                sbAppend.append("\n   * ").append(this.callAdapterFactories.get(i2).getClass().getName());
            }
            sbAppend.append('\n');
        }
        sbAppend.append("  Tried:");
        int size2 = this.callAdapterFactories.size();
        while (iIndexOf < size2) {
            sbAppend.append("\n   * ").append(this.callAdapterFactories.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sbAppend.toString());
    }

    public List<Converter.Factory> converterFactories() {
        return this.converterFactories;
    }

    public <T> Converter<T, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return nextRequestBodyConverter(null, type, annotationArr, annotationArr2);
    }

    public <T> Converter<T, RequestBody> nextRequestBodyConverter(@Nullable Converter.Factory factory, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "parameterAnnotations == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        int iIndexOf = this.converterFactories.indexOf(factory) + 1;
        int size = this.converterFactories.size();
        for (int i = iIndexOf; i < size; i++) {
            Converter<T, RequestBody> converter = (Converter<T, RequestBody>) this.converterFactories.get(i).requestBodyConverter(type, annotationArr, annotationArr2, this);
            if (converter != null) {
                return converter;
            }
        }
        StringBuilder sbAppend = new StringBuilder("Could not locate RequestBody converter for ").append(type).append(".\n");
        if (factory != null) {
            sbAppend.append("  Skipped:");
            for (int i2 = 0; i2 < iIndexOf; i2++) {
                sbAppend.append("\n   * ").append(this.converterFactories.get(i2).getClass().getName());
            }
            sbAppend.append('\n');
        }
        sbAppend.append("  Tried:");
        int size2 = this.converterFactories.size();
        while (iIndexOf < size2) {
            sbAppend.append("\n   * ").append(this.converterFactories.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sbAppend.toString());
    }

    public <T> Converter<ResponseBody, T> responseBodyConverter(Type type, Annotation[] annotationArr) {
        return nextResponseBodyConverter(null, type, annotationArr);
    }

    public <T> Converter<ResponseBody, T> nextResponseBodyConverter(@Nullable Converter.Factory factory, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.converterFactories.indexOf(factory) + 1;
        int size = this.converterFactories.size();
        for (int i = iIndexOf; i < size; i++) {
            Converter<ResponseBody, T> converter = (Converter<ResponseBody, T>) this.converterFactories.get(i).responseBodyConverter(type, annotationArr, this);
            if (converter != null) {
                return converter;
            }
        }
        StringBuilder sbAppend = new StringBuilder("Could not locate ResponseBody converter for ").append(type).append(".\n");
        if (factory != null) {
            sbAppend.append("  Skipped:");
            for (int i2 = 0; i2 < iIndexOf; i2++) {
                sbAppend.append("\n   * ").append(this.converterFactories.get(i2).getClass().getName());
            }
            sbAppend.append('\n');
        }
        sbAppend.append("  Tried:");
        int size2 = this.converterFactories.size();
        while (iIndexOf < size2) {
            sbAppend.append("\n   * ").append(this.converterFactories.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sbAppend.toString());
    }

    public <T> Converter<T, String> stringConverter(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int size = this.converterFactories.size();
        for (int i = 0; i < size; i++) {
            Converter<T, String> converter = (Converter<T, String>) this.converterFactories.get(i).stringConverter(type, annotationArr, this);
            if (converter != null) {
                return converter;
            }
        }
        return BuiltInConverters.ToStringConverter.INSTANCE;
    }

    @Nullable
    public Executor callbackExecutor() {
        return this.callbackExecutor;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public static final class Builder {

        @Nullable
        private HttpUrl baseUrl;
        private final List<CallAdapter.Factory> callAdapterFactories;

        @Nullable
        private okhttp3.Call.Factory callFactory;

        @Nullable
        private Executor callbackExecutor;
        private final List<Converter.Factory> converterFactories;
        private final Platform platform;
        private boolean validateEagerly;

        Builder(Platform platform) {
            this.converterFactories = new ArrayList();
            this.callAdapterFactories = new ArrayList();
            this.platform = platform;
        }

        public Builder() {
            this(Platform.get());
        }

        Builder(Retrofit retrofit) {
            this.converterFactories = new ArrayList();
            this.callAdapterFactories = new ArrayList();
            Platform platform = Platform.get();
            this.platform = platform;
            this.callFactory = retrofit.callFactory;
            this.baseUrl = retrofit.baseUrl;
            int size = retrofit.converterFactories.size() - platform.defaultConverterFactoriesSize();
            for (int i = 1; i < size; i++) {
                this.converterFactories.add(retrofit.converterFactories.get(i));
            }
            int size2 = retrofit.callAdapterFactories.size() - this.platform.defaultCallAdapterFactoriesSize();
            for (int i2 = 0; i2 < size2; i2++) {
                this.callAdapterFactories.add(retrofit.callAdapterFactories.get(i2));
            }
            this.callbackExecutor = retrofit.callbackExecutor;
            this.validateEagerly = retrofit.validateEagerly;
        }

        public Builder client(OkHttpClient okHttpClient) {
            return callFactory((okhttp3.Call.Factory) Objects.requireNonNull(okHttpClient, "client == null"));
        }

        public Builder callFactory(okhttp3.Call.Factory factory) {
            this.callFactory = (okhttp3.Call.Factory) Objects.requireNonNull(factory, "factory == null");
            return this;
        }

        public Builder baseUrl(URL url) {
            Objects.requireNonNull(url, "baseUrl == null");
            return baseUrl(HttpUrl.get(url.toString()));
        }

        public Builder baseUrl(String str) {
            Objects.requireNonNull(str, "baseUrl == null");
            return baseUrl(HttpUrl.get(str));
        }

        public Builder baseUrl(HttpUrl httpUrl) {
            Objects.requireNonNull(httpUrl, "baseUrl == null");
            List listPathSegments = httpUrl.pathSegments();
            if (!"".equals(listPathSegments.get(listPathSegments.size() - 1))) {
                throw new IllegalArgumentException("baseUrl must end in /: " + httpUrl);
            }
            this.baseUrl = httpUrl;
            return this;
        }

        public Builder addConverterFactory(Converter.Factory factory) {
            this.converterFactories.add((Converter.Factory) Objects.requireNonNull(factory, "factory == null"));
            return this;
        }

        public Builder addCallAdapterFactory(CallAdapter.Factory factory) {
            this.callAdapterFactories.add((CallAdapter.Factory) Objects.requireNonNull(factory, "factory == null"));
            return this;
        }

        public Builder callbackExecutor(Executor executor) {
            this.callbackExecutor = (Executor) Objects.requireNonNull(executor, "executor == null");
            return this;
        }

        public List<CallAdapter.Factory> callAdapterFactories() {
            return this.callAdapterFactories;
        }

        public List<Converter.Factory> converterFactories() {
            return this.converterFactories;
        }

        public Builder validateEagerly(boolean z) {
            this.validateEagerly = z;
            return this;
        }

        public Retrofit build() {
            if (this.baseUrl == null) {
                throw new IllegalStateException("Base URL required.");
            }
            OkHttpClient okHttpClient = this.callFactory;
            if (okHttpClient == null) {
                okHttpClient = new OkHttpClient();
            }
            OkHttpClient okHttpClient2 = okHttpClient;
            Executor executorDefaultCallbackExecutor = this.callbackExecutor;
            if (executorDefaultCallbackExecutor == null) {
                executorDefaultCallbackExecutor = this.platform.defaultCallbackExecutor();
            }
            Executor executor = executorDefaultCallbackExecutor;
            ArrayList arrayList = new ArrayList(this.callAdapterFactories);
            arrayList.addAll(this.platform.defaultCallAdapterFactories(executor));
            ArrayList arrayList2 = new ArrayList(this.converterFactories.size() + 1 + this.platform.defaultConverterFactoriesSize());
            arrayList2.add(new BuiltInConverters());
            arrayList2.addAll(this.converterFactories);
            arrayList2.addAll(this.platform.defaultConverterFactories());
            return new Retrofit(okHttpClient2, this.baseUrl, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor, this.validateEagerly);
        }
    }
}
