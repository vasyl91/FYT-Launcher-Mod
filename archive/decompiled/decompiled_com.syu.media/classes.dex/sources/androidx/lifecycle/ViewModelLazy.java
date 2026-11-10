package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import chip.FinalChip;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: ViewModelProvider.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B/\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\u0010\u000bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0012\u0010\f\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/lifecycle/ViewModelLazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Lkotlin/Lazy;", "viewModelClass", "Lkotlin/reflect/KClass;", "storeProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelStore;", "factoryProducer", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "cached", "Landroidx/lifecycle/ViewModel;", "value", "getValue", "()Landroidx/lifecycle/ViewModel;", "isInitialized", FinalChip.BSP_PLATFORM_Null, "lifecycle-viewmodel-ktx_release"}, k = 1, mv = {1, 4, 1})
public final class ViewModelLazy<VM extends ViewModel> implements Lazy<VM> {
    private VM cached;
    private final Function0<ViewModelProvider.Factory> factoryProducer;
    private final Function0<ViewModelStore> storeProducer;
    private final KClass<VM> viewModelClass;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelLazy(KClass<VM> kClass, Function0<? extends ViewModelStore> function0, Function0<? extends ViewModelProvider.Factory> function1) {
        Intrinsics.checkNotNullParameter(kClass, "viewModelClass");
        Intrinsics.checkNotNullParameter(function0, "storeProducer");
        Intrinsics.checkNotNullParameter(function1, "factoryProducer");
        this.viewModelClass = kClass;
        this.storeProducer = function0;
        this.factoryProducer = function1;
    }

    /* JADX INFO: renamed from: getValue, reason: merged with bridge method [inline-methods] */
    public VM m36getValue() {
        VM vm = this.cached;
        if (vm != null) {
            return vm;
        }
        VM vm2 = (VM) new ViewModelProvider((ViewModelStore) this.storeProducer.invoke(), (ViewModelProvider.Factory) this.factoryProducer.invoke()).get(JvmClassMappingKt.getJavaClass(this.viewModelClass));
        this.cached = vm2;
        Intrinsics.checkNotNullExpressionValue(vm2, "ViewModelProvider(store,…ed = it\n                }");
        return vm2;
    }

    public boolean isInitialized() {
        return this.cached != null;
    }
}
