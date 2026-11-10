package com.syu.radio;

import com.syu.radio.database.RadioDatabase;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import syu.base.BaseApp;
import syu.utils.SharedPreferencesUtils;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/syu/radio/RadioBaseApp;", "Lsyu/base/BaseApp;", "Lsyu/utils/SharedPreferencesUtils;", "a", "Lkotlin/Lazy;", "getShareUtils", "()Lsyu/utils/SharedPreferencesUtils;", "shareUtils", "Lcom/syu/radio/database/RadioDatabase;", "b", "getDatabase", "()Lcom/syu/radio/database/RadioDatabase;", "database", "<init>", "()V", "radiolib_release"}, k = 1, mv = {1, 7, 1})
public class RadioBaseApp extends BaseApp {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final Lazy shareUtils = LazyKt.lazy(new Function0<SharedPreferencesUtils>() { // from class: com.syu.radio.RadioBaseApp$shareUtils$2
        {
            super(0);
        }

        public final SharedPreferencesUtils invoke() {
            return new SharedPreferencesUtils(this.a, 0, 2, (DefaultConstructorMarker) null);
        }
    });

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Lazy database = LazyKt.lazy(new Function0<RadioDatabase>() { // from class: com.syu.radio.RadioBaseApp$database$2
        {
            super(0);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final RadioDatabase m340invoke() {
            return RadioDatabase.INSTANCE.getDatabase(this.a);
        }
    });

    public final RadioDatabase getDatabase() {
        return (RadioDatabase) this.database.getValue();
    }

    public final SharedPreferencesUtils getShareUtils() {
        return (SharedPreferencesUtils) this.shareUtils.getValue();
    }
}
