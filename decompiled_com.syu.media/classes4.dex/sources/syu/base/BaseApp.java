package syu.base;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\t\u001a\u00020\u0005J\u001c\u0010\f\u001a\u00028\u0000\"\n\b\u0000\u0010\u000b\u0018\u0001*\u00020\nH\u0086\b¢\u0006\u0004\b\f\u0010\rJ(\u0010\f\u001a\u00028\u0000\"\n\b\u0000\u0010\u000b\u0018\u0001*\u00020\n2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0086\b¢\u0006\u0004\b\f\u0010\u000eJ\u001c\u0010\u000f\u001a\u00028\u0000\"\n\b\u0000\u0010\u000b\u0018\u0001*\u00020\nH\u0086\b¢\u0006\u0004\b\u000f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\b\u0010\u0012¨\u0006\u0016"}, d2 = {"Lsyu/base/BaseApp;", "Landroid/app/Application;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", "Landroidx/lifecycle/ViewModelProvider;", "getViewModelProvider", "androidViewModelFactory", "Landroidx/lifecycle/ViewModel;", "VM", "viewModel", "()Landroidx/lifecycle/ViewModel;", "(Landroidx/lifecycle/ViewModelProvider$Factory;)Landroidx/lifecycle/ViewModel;", "viewModels", "b", "Lkotlin/Lazy;", "()Landroidx/lifecycle/ViewModelProvider;", "viewModelProvider", "<init>", "()V", "Library_release"}, k = 1, mv = {1, 7, 1})
public class BaseApp extends Application implements ViewModelStoreOwner {
    public final ViewModelStore a = new ViewModelStore();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Lazy viewModelProvider = LazyKt.lazy(new Function0<ViewModelProvider>() { // from class: syu.base.BaseApp$viewModelProvider$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ViewModelProvider m7invoke() {
            BaseApp baseApp = this.a;
            return new ViewModelProvider(baseApp, BaseApp.access$getMFactory(baseApp));
        }
    });
    public final Lazy c = LazyKt.lazy(new Function0<ViewModelProvider.AndroidViewModelFactory>() { // from class: syu.base.BaseApp$mFactory$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ViewModelProvider.AndroidViewModelFactory m6invoke() {
            return ViewModelProvider.AndroidViewModelFactory.getInstance(this.a);
        }
    });

    public static final ViewModelProvider.AndroidViewModelFactory access$getMFactory(BaseApp baseApp) {
        return (ViewModelProvider.AndroidViewModelFactory) baseApp.c.getValue();
    }

    public static ViewModelProvider getViewModelProvider$default(BaseApp baseApp, ViewModelProvider.Factory factory, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getViewModelProvider");
        }
        if ((i & 1) != 0) {
            factory = (ViewModelProvider.AndroidViewModelFactory) baseApp.c.getValue();
        }
        return baseApp.getViewModelProvider(factory);
    }

    public static /* synthetic */ ViewModel viewModel$default(BaseApp baseApp, ViewModelProvider.Factory factory, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: viewModel");
        }
        if ((i & 1) != 0) {
            factory = null;
        }
        ViewModelProvider viewModelProvider = baseApp.getViewModelProvider(factory);
        Intrinsics.reifiedOperationMarker(4, "VM");
        ViewModel viewModel = viewModelProvider.get(ViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModelProvider(factory).get(VM::class.java)");
        return viewModel;
    }

    public final ViewModelProvider.Factory androidViewModelFactory() {
        ViewModelProvider.AndroidViewModelFactory androidViewModelFactory = (ViewModelProvider.AndroidViewModelFactory) this.c.getValue();
        Intrinsics.checkNotNullExpressionValue(androidViewModelFactory, "mFactory");
        return androidViewModelFactory;
    }

    public final ViewModelProvider getViewModelProvider() {
        return (ViewModelProvider) this.viewModelProvider.getValue();
    }

    /* JADX INFO: renamed from: getViewModelStore, reason: from getter */
    public ViewModelStore getA() {
        return this.a;
    }

    public final /* synthetic */ <VM extends ViewModel> VM viewModel() {
        ViewModelProvider viewModelProvider$default = getViewModelProvider$default(this, null, 1, null);
        Intrinsics.reifiedOperationMarker(4, "VM");
        VM vm = (VM) viewModelProvider$default.get(ViewModel.class);
        Intrinsics.checkNotNullExpressionValue(vm, "getViewModelProvider().get(VM::class.java)");
        return vm;
    }

    public final /* synthetic */ <VM extends ViewModel> VM viewModel(ViewModelProvider.Factory factory) {
        ViewModelProvider viewModelProvider = getViewModelProvider(factory);
        Intrinsics.reifiedOperationMarker(4, "VM");
        VM vm = (VM) viewModelProvider.get(ViewModel.class);
        Intrinsics.checkNotNullExpressionValue(vm, "getViewModelProvider(factory).get(VM::class.java)");
        return vm;
    }

    public final /* synthetic */ <VM extends ViewModel> VM viewModels() {
        ViewModelProvider viewModelProvider = getViewModelProvider();
        Intrinsics.reifiedOperationMarker(4, "VM");
        VM vm = (VM) viewModelProvider.get(ViewModel.class);
        Intrinsics.checkNotNullExpressionValue(vm, "viewModelProvider.get(VM::class.java)");
        return vm;
    }

    public final ViewModelProvider getViewModelProvider(ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNull(factory);
        return new ViewModelProvider(this, factory);
    }
}
