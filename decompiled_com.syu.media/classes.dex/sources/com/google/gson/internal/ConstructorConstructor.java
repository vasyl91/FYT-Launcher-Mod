package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class ConstructorConstructor {
    private final Map<Type, InstanceCreator<?>> instanceCreators;
    private final boolean useJdkUnsafe;

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map, boolean z) {
        this.instanceCreators = map;
        this.useJdkUnsafe = z;
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> typeToken) {
        final Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        final InstanceCreator<?> instanceCreator = this.instanceCreators.get(type);
        if (instanceCreator != null) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.1
                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) instanceCreator.createInstance(type);
                }
            };
        }
        final InstanceCreator<?> instanceCreator2 = this.instanceCreators.get(rawType);
        if (instanceCreator2 != null) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.2
                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) instanceCreator2.createInstance(type);
                }
            };
        }
        ObjectConstructor<T> objectConstructorNewDefaultConstructor = newDefaultConstructor(rawType);
        if (objectConstructorNewDefaultConstructor != null) {
            return objectConstructorNewDefaultConstructor;
        }
        ObjectConstructor<T> objectConstructorNewDefaultImplementationConstructor = newDefaultImplementationConstructor(type, rawType);
        return objectConstructorNewDefaultImplementationConstructor != null ? objectConstructorNewDefaultImplementationConstructor : newUnsafeAllocator(rawType);
    }

    private <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> cls) {
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            final String strTryMakeAccessible = ReflectionHelper.tryMakeAccessible(declaredConstructor);
            if (strTryMakeAccessible != null) {
                return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.3
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        throw new JsonIOException(strTryMakeAccessible);
                    }
                };
            }
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.4
                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    try {
                        return (T) declaredConstructor.newInstance(new Object[0]);
                    } catch (IllegalAccessException e) {
                        throw new AssertionError(e);
                    } catch (InstantiationException e2) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e2);
                    } catch (InvocationTargetException e3) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e3.getTargetException());
                    }
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> ObjectConstructor<T> newDefaultImplementationConstructor(final Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.5
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new TreeSet();
                    }
                };
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.6
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        Type type2 = type;
                        if (type2 instanceof ParameterizedType) {
                            Type type3 = ((ParameterizedType) type2).getActualTypeArguments()[0];
                            if (type3 instanceof Class) {
                                return (T) EnumSet.noneOf((Class) type3);
                            }
                            throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                        }
                        throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                    }
                };
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.7
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new LinkedHashSet();
                    }
                };
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.8
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new ArrayDeque();
                    }
                };
            }
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.9
                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new ArrayList();
                }
            };
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (cls == EnumMap.class) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.10
                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    Type type2 = type;
                    if (type2 instanceof ParameterizedType) {
                        Type type3 = ((ParameterizedType) type2).getActualTypeArguments()[0];
                        if (type3 instanceof Class) {
                            return (T) new EnumMap((Class) type3);
                        }
                        throw new JsonIOException("Invalid EnumMap type: " + type.toString());
                    }
                    throw new JsonIOException("Invalid EnumMap type: " + type.toString());
                }
            };
        }
        if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.11
                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new ConcurrentSkipListMap();
                }
            };
        }
        if (ConcurrentMap.class.isAssignableFrom(cls)) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.12
                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new ConcurrentHashMap();
                }
            };
        }
        if (SortedMap.class.isAssignableFrom(cls)) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.13
                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new TreeMap();
                }
            };
        }
        if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.14
                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new LinkedHashMap();
                }
            };
        }
        return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.15
            @Override // com.google.gson.internal.ObjectConstructor
            public T construct() {
                return (T) new LinkedTreeMap();
            }
        };
    }

    private <T> ObjectConstructor<T> newUnsafeAllocator(final Class<? super T> cls) {
        if (this.useJdkUnsafe) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.16
                private final UnsafeAllocator unsafeAllocator = UnsafeAllocator.create();

                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    try {
                        return (T) this.unsafeAllocator.newInstance(cls);
                    } catch (Exception e) {
                        throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e);
                    }
                }
            };
        }
        final String str = "Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.";
        return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.17
            @Override // com.google.gson.internal.ObjectConstructor
            public T construct() {
                throw new JsonIOException(str);
            }
        };
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}
