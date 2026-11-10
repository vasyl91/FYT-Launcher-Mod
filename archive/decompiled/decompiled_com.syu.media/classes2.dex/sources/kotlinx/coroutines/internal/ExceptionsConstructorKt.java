package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;

/* JADX INFO: compiled from: ExceptionsConstructor.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a2\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u0007\"\b\b\u0000\u0010\b*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0002\u001a*\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u00072\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rH\u0002\u001a1\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u00072\u0014\b\u0004\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0082\b\u001a!\u0010\u0010\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u00062\u0006\u0010\u0011\u001a\u0002H\bH\u0000¢\u0006\u0002\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\n2\b\b\u0002\u0010\u0014\u001a\u00020\u0003H\u0082\u0010\u001a\u0018\u0010\u0015\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000*(\b\u0002\u0010\u0017\"\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¨\u0006\u0018"}, d2 = {"ctorCache", "Lkotlinx/coroutines/internal/CtorCache;", "throwableFields", "", "createConstructor", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/Ctor;", "E", "clz", "Ljava/lang/Class;", "createSafeConstructor", "constructor", "Ljava/lang/reflect/Constructor;", "safeCtor", "block", "tryCopyException", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "fieldsCount", "accumulator", "fieldsCountOrDefault", "defaultValue", "Ctor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ExceptionsConstructorKt {
    private static final CtorCache ctorCache;
    private static final int throwableFields = fieldsCountOrDefault(Throwable.class, -1);

    static {
        WeakMapCtorCache weakMapCtorCache;
        try {
            weakMapCtorCache = FastServiceLoaderKt.getANDROID_DETECTED() ? WeakMapCtorCache.INSTANCE : ClassValueCtorCache.INSTANCE;
        } catch (Throwable unused) {
            weakMapCtorCache = WeakMapCtorCache.INSTANCE;
        }
        ctorCache = weakMapCtorCache;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E extends Throwable> E tryCopyException(E e) {
        Object objM56constructorimpl;
        if (e instanceof CopyableThrowable) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objM56constructorimpl = Result.m56constructorimpl(((CopyableThrowable) e).createCopy());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM56constructorimpl = Result.m56constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m62isFailureimpl(objM56constructorimpl)) {
                objM56constructorimpl = null;
            }
            return (E) objM56constructorimpl;
        }
        return (E) ctorCache.get(e.getClass()).invoke(e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E extends Throwable> Function1<Throwable, Throwable> createConstructor(Class<E> cls) {
        ExceptionsConstructorKt$createConstructor$nullResult$1 exceptionsConstructorKt$createConstructor$nullResult$1 = new Function1() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$nullResult$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Throwable th) {
                return null;
            }
        };
        if (throwableFields != fieldsCountOrDefault(cls, 0)) {
            return exceptionsConstructorKt$createConstructor$nullResult$1;
        }
        Iterator it = ArraysKt.sortedWith(cls.getConstructors(), new Comparator() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((Constructor) t2).getParameterTypes().length), Integer.valueOf(((Constructor) t).getParameterTypes().length));
            }
        }).iterator();
        while (it.hasNext()) {
            Function1<Throwable, Throwable> function1CreateSafeConstructor = createSafeConstructor((Constructor) it.next());
            if (function1CreateSafeConstructor != null) {
                return function1CreateSafeConstructor;
            }
        }
        return exceptionsConstructorKt$createConstructor$nullResult$1;
    }

    private static final Function1<Throwable, Throwable> createSafeConstructor(final Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length == 0) {
            return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Throwable invoke(Throwable th) {
                    Object objM56constructorimpl;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        Object objNewInstance = constructor.newInstance(new Object[0]);
                        if (objNewInstance != null) {
                            Throwable th2 = (Throwable) objNewInstance;
                            th2.initCause(th);
                            objM56constructorimpl = Result.m56constructorimpl(th2);
                            if (Result.m62isFailureimpl(objM56constructorimpl)) {
                                objM56constructorimpl = null;
                            }
                            return (Throwable) objM56constructorimpl;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                    } catch (Throwable th3) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM56constructorimpl = Result.m56constructorimpl(ResultKt.createFailure(th3));
                    }
                }
            };
        }
        if (length != 1) {
            if (length == 2 && Intrinsics.areEqual(parameterTypes[0], String.class) && Intrinsics.areEqual(parameterTypes[1], Throwable.class)) {
                return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Throwable invoke(Throwable th) {
                        Object objM56constructorimpl;
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            Object objNewInstance = constructor.newInstance(th.getMessage(), th);
                            if (objNewInstance != null) {
                                objM56constructorimpl = Result.m56constructorimpl((Throwable) objNewInstance);
                                if (Result.m62isFailureimpl(objM56constructorimpl)) {
                                    objM56constructorimpl = null;
                                }
                                return (Throwable) objM56constructorimpl;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                        } catch (Throwable th2) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objM56constructorimpl = Result.m56constructorimpl(ResultKt.createFailure(th2));
                        }
                    }
                };
            }
            return null;
        }
        Class<?> cls = parameterTypes[0];
        if (!Intrinsics.areEqual(cls, Throwable.class)) {
            if (Intrinsics.areEqual(cls, String.class)) {
                return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Throwable invoke(Throwable th) {
                        Object objM56constructorimpl;
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            Object objNewInstance = constructor.newInstance(th.getMessage());
                            if (objNewInstance != null) {
                                Throwable th2 = (Throwable) objNewInstance;
                                th2.initCause(th);
                                objM56constructorimpl = Result.m56constructorimpl(th2);
                                if (Result.m62isFailureimpl(objM56constructorimpl)) {
                                    objM56constructorimpl = null;
                                }
                                return (Throwable) objM56constructorimpl;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                        } catch (Throwable th3) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objM56constructorimpl = Result.m56constructorimpl(ResultKt.createFailure(th3));
                        }
                    }
                };
            }
            return null;
        }
        return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Throwable invoke(Throwable th) {
                Object objM56constructorimpl;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Object objNewInstance = constructor.newInstance(th);
                    if (objNewInstance != null) {
                        objM56constructorimpl = Result.m56constructorimpl((Throwable) objNewInstance);
                        if (Result.m62isFailureimpl(objM56constructorimpl)) {
                            objM56constructorimpl = null;
                        }
                        return (Throwable) objM56constructorimpl;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM56constructorimpl = Result.m56constructorimpl(ResultKt.createFailure(th2));
                }
            }
        };
    }

    private static final Function1<Throwable, Throwable> safeCtor(final Function1<? super Throwable, ? extends Throwable> function1) {
        return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt.safeCtor.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Throwable invoke(Throwable th) {
                Object objM56constructorimpl;
                Function1<Throwable, Throwable> function2 = function1;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM56constructorimpl = Result.m56constructorimpl(function2.invoke(th));
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM56constructorimpl = Result.m56constructorimpl(ResultKt.createFailure(th2));
                }
                if (Result.m62isFailureimpl(objM56constructorimpl)) {
                    objM56constructorimpl = null;
                }
                return (Throwable) objM56constructorimpl;
            }
        };
    }

    private static final int fieldsCountOrDefault(Class<?> cls, int i) {
        Object objM56constructorimpl;
        JvmClassMappingKt.getKotlinClass(cls);
        try {
            Result.Companion companion = Result.INSTANCE;
            objM56constructorimpl = Result.m56constructorimpl(Integer.valueOf(fieldsCount$default(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM56constructorimpl = Result.m56constructorimpl(ResultKt.createFailure(th));
        }
        Integer numValueOf = Integer.valueOf(i);
        if (Result.m62isFailureimpl(objM56constructorimpl)) {
            objM56constructorimpl = numValueOf;
        }
        return ((Number) objM56constructorimpl).intValue();
    }

    static /* synthetic */ int fieldsCount$default(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return fieldsCount(cls, i);
    }

    private static final int fieldsCount(Class<?> cls, int i) {
        do {
            int i2 = 0;
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    i2++;
                }
            }
            i += i2;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i;
    }
}
