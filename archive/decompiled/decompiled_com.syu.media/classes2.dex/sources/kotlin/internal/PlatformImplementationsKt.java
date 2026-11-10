package kotlin.internal;

import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import module.canbus.FinalCanbus;

/* JADX INFO: compiled from: PlatformImplementations.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0001\u001a\"\u0010\b\u001a\u0002H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0083\b¢\u0006\u0002\u0010\f\u001a\b\u0010\r\u001a\u00020\u0005H\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "apiVersionIsAtLeast", "", "major", "", "minor", "patch", "castToBaseType", "T", "", "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "getJavaVersion", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PlatformImplementationsKt {
    public static final PlatformImplementations IMPLEMENTATIONS;

    /* JADX WARN: Code duplicated, block: B:34:0x00c5 A[Catch: ClassCastException -> 0x00ca, ClassNotFoundException -> 0x0104, TRY_ENTER, TryCatch #5 {ClassCastException -> 0x00ca, blocks: (B:34:0x00c5, B:37:0x00cc, B:38:0x00d1), top: B:66:0x00c3, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00cc A[Catch: ClassCastException -> 0x00ca, ClassNotFoundException -> 0x0104, TryCatch #5 {ClassCastException -> 0x00ca, blocks: (B:34:0x00c5, B:37:0x00cc, B:38:0x00d1), top: B:66:0x00c3, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x00b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        PlatformImplementations platformImplementations;
        Object objNewInstance;
        int javaVersion = getJavaVersion();
        if (javaVersion >= 65544 || javaVersion < 65536) {
            try {
                try {
                    Object objNewInstance2 = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
                    Intrinsics.checkNotNullExpressionValue(objNewInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
                    try {
                        if (objNewInstance2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        platformImplementations = (PlatformImplementations) objNewInstance2;
                    } catch (ClassCastException e) {
                        ClassLoader classLoader = objNewInstance2.getClass().getClassLoader();
                        ClassLoader classLoader2 = PlatformImplementations.class.getClassLoader();
                        if (!Intrinsics.areEqual(classLoader, classLoader2)) {
                            throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e);
                        }
                        throw e;
                    }
                } catch (ClassNotFoundException unused) {
                    Object objNewInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                    Intrinsics.checkNotNullExpressionValue(objNewInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
                    try {
                        if (objNewInstance3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        platformImplementations = (PlatformImplementations) objNewInstance3;
                    } catch (ClassCastException e2) {
                        ClassLoader classLoader3 = objNewInstance3.getClass().getClassLoader();
                        ClassLoader classLoader4 = PlatformImplementations.class.getClassLoader();
                        if (!Intrinsics.areEqual(classLoader3, classLoader4)) {
                            throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e2);
                        }
                        throw e2;
                    }
                }
            } catch (ClassNotFoundException unused2) {
                if (javaVersion < 65543) {
                    try {
                        try {
                            objNewInstance = Class.forName("kotlin.internal.jdk7.JDK7PlatformImplementations").newInstance();
                            Intrinsics.checkNotNullExpressionValue(objNewInstance, "forName(\"kotlin.internal…entations\").newInstance()");
                            try {
                                if (objNewInstance == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                                }
                                platformImplementations = (PlatformImplementations) objNewInstance;
                            } catch (ClassCastException e3) {
                                ClassLoader classLoader5 = objNewInstance.getClass().getClassLoader();
                                ClassLoader classLoader6 = PlatformImplementations.class.getClassLoader();
                                if (!Intrinsics.areEqual(classLoader5, classLoader6)) {
                                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e3);
                                }
                                throw e3;
                            }
                        } catch (ClassNotFoundException unused3) {
                            Object objNewInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                            Intrinsics.checkNotNullExpressionValue(objNewInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
                            try {
                                if (objNewInstance4 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                                }
                                platformImplementations = (PlatformImplementations) objNewInstance4;
                            } catch (ClassCastException e4) {
                                ClassLoader classLoader7 = objNewInstance4.getClass().getClassLoader();
                                ClassLoader classLoader8 = PlatformImplementations.class.getClassLoader();
                                if (!Intrinsics.areEqual(classLoader7, classLoader8)) {
                                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e4);
                                }
                                throw e4;
                            }
                        }
                    } catch (ClassNotFoundException unused4) {
                        platformImplementations = new PlatformImplementations();
                    }
                } else {
                    objNewInstance = Class.forName("kotlin.internal.jdk7.JDK7PlatformImplementations").newInstance();
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "forName(\"kotlin.internal…entations\").newInstance()");
                    if (objNewInstance == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    platformImplementations = (PlatformImplementations) objNewInstance;
                }
            }
        } else if (javaVersion < 65543 || javaVersion < 65536) {
            objNewInstance = Class.forName("kotlin.internal.jdk7.JDK7PlatformImplementations").newInstance();
            Intrinsics.checkNotNullExpressionValue(objNewInstance, "forName(\"kotlin.internal…entations\").newInstance()");
            if (objNewInstance == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            platformImplementations = (PlatformImplementations) objNewInstance;
        } else {
            platformImplementations = new PlatformImplementations();
        }
        IMPLEMENTATIONS = platformImplementations;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final /* synthetic */ <T> T castToBaseType(Object obj) throws ClassNotFoundException {
        try {
            Intrinsics.reifiedOperationMarker(1, "T");
            return obj;
        } catch (ClassCastException e) {
            ClassLoader classLoader = obj.getClass().getClassLoader();
            Intrinsics.reifiedOperationMarker(4, "T");
            ClassLoader classLoader2 = Object.class.getClassLoader();
            if (!Intrinsics.areEqual(classLoader, classLoader2)) {
                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e);
            }
            throw e;
        }
    }

    private static final int getJavaVersion() {
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return FinalCanbus.CAR_BYD_F3_ShuRui;
        }
        String str = property;
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, '.', 0, false, 6, (Object) null);
        if (iIndexOf$default < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return FinalCanbus.CAR_BYD_F3_ShuRui;
            }
        }
        int i = iIndexOf$default + 1;
        int iIndexOf$default2 = StringsKt.indexOf$default((CharSequence) str, '.', i, false, 4, (Object) null);
        if (iIndexOf$default2 < 0) {
            iIndexOf$default2 = property.length();
        }
        String strSubstring = property.substring(0, iIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        String strSubstring2 = property.substring(i, iIndexOf$default2);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
        try {
            return (Integer.parseInt(strSubstring) * 65536) + Integer.parseInt(strSubstring2);
        } catch (NumberFormatException unused2) {
            return FinalCanbus.CAR_BYD_F3_ShuRui;
        }
    }

    public static final boolean apiVersionIsAtLeast(int i, int i2, int i3) {
        return KotlinVersion.CURRENT.isAtLeast(i, i2, i3);
    }
}
