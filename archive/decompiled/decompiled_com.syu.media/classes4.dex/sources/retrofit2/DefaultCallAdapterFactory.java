package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Request;
import okio.Timeout;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
final class DefaultCallAdapterFactory extends CallAdapter.Factory {

    @Nullable
    private final Executor callbackExecutor;

    DefaultCallAdapterFactory(@Nullable Executor executor) {
        this.callbackExecutor = executor;
    }

    @Override // retrofit2.CallAdapter.Factory
    @Nullable
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (getRawType(type) != Call.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
        }
        final Type parameterUpperBound = Utils.getParameterUpperBound(0, (ParameterizedType) type);
        final Executor executor = Utils.isAnnotationPresent(annotationArr, SkipCallbackExecutor.class) ? null : this.callbackExecutor;
        return new CallAdapter<Object, Call<?>>() { // from class: retrofit2.DefaultCallAdapterFactory.1
            @Override // retrofit2.CallAdapter
            public Type responseType() {
                return parameterUpperBound;
            }

            @Override // retrofit2.CallAdapter
            public Call<?> adapt(Call<Object> call) {
                return executor == null ? call : new ExecutorCallbackCall(executor, call);
            }
        };
    }

    static final class ExecutorCallbackCall<T> implements Call<T> {
        final Executor callbackExecutor;
        final Call<T> delegate;

        ExecutorCallbackCall(Executor executor, Call<T> call) {
            this.callbackExecutor = executor;
            this.delegate = call;
        }

        @Override // retrofit2.Call
        public void enqueue(Callback<T> callback) {
            Objects.requireNonNull(callback, "callback == null");
            this.delegate.enqueue(new AnonymousClass1(callback));
        }

        /* JADX INFO: renamed from: retrofit2.DefaultCallAdapterFactory$ExecutorCallbackCall$1, reason: invalid class name */
        class AnonymousClass1 implements Callback<T> {
            final /* synthetic */ Callback val$callback;

            AnonymousClass1(Callback callback) {
                this.val$callback = callback;
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call, final Response<T> response) {
                Executor executor = ExecutorCallbackCall.this.callbackExecutor;
                final Callback callback = this.val$callback;
                executor.execute(new Runnable() { // from class: retrofit2.DefaultCallAdapterFactory$ExecutorCallbackCall$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m5lambda$onResponse$0$retrofit2DefaultCallAdapterFactory$ExecutorCallbackCall$1(callback, response);
                    }
                });
            }

            /* JADX INFO: renamed from: lambda$onResponse$0$retrofit2-DefaultCallAdapterFactory$ExecutorCallbackCall$1, reason: not valid java name */
            /* synthetic */ void m5lambda$onResponse$0$retrofit2DefaultCallAdapterFactory$ExecutorCallbackCall$1(Callback callback, Response response) {
                if (ExecutorCallbackCall.this.delegate.isCanceled()) {
                    callback.onFailure(ExecutorCallbackCall.this, new IOException("Canceled"));
                } else {
                    callback.onResponse(ExecutorCallbackCall.this, response);
                }
            }

            /* JADX INFO: renamed from: lambda$onFailure$1$retrofit2-DefaultCallAdapterFactory$ExecutorCallbackCall$1, reason: not valid java name */
            /* synthetic */ void m4lambda$onFailure$1$retrofit2DefaultCallAdapterFactory$ExecutorCallbackCall$1(Callback callback, Throwable th) {
                callback.onFailure(ExecutorCallbackCall.this, th);
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<T> call, final Throwable th) {
                Executor executor = ExecutorCallbackCall.this.callbackExecutor;
                final Callback callback = this.val$callback;
                executor.execute(new Runnable() { // from class: retrofit2.DefaultCallAdapterFactory$ExecutorCallbackCall$1$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m4lambda$onFailure$1$retrofit2DefaultCallAdapterFactory$ExecutorCallbackCall$1(callback, th);
                    }
                });
            }
        }

        @Override // retrofit2.Call
        public boolean isExecuted() {
            return this.delegate.isExecuted();
        }

        @Override // retrofit2.Call
        public Response<T> execute() throws IOException {
            return this.delegate.execute();
        }

        @Override // retrofit2.Call
        public void cancel() {
            this.delegate.cancel();
        }

        @Override // retrofit2.Call
        public boolean isCanceled() {
            return this.delegate.isCanceled();
        }

        @Override // retrofit2.Call
        public Call<T> clone() {
            return new ExecutorCallbackCall(this.callbackExecutor, this.delegate.clone());
        }

        @Override // retrofit2.Call
        public Request request() {
            return this.delegate.request();
        }

        @Override // retrofit2.Call
        public Timeout timeout() {
            return this.delegate.timeout();
        }
    }
}
