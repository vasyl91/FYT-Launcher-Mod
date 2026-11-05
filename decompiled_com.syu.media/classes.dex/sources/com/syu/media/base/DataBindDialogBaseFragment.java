package com.syu.media.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBinding;
import chip.FinalChip;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qin.reflex.ReflexMethod;

/* JADX INFO: compiled from: DataBindDialogBaseFragment.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H&J&\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016R\u0012\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\t\u001a\u00028\u00008DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/syu/media/base/DataBindDialogBaseFragment;", "DB", "Landroidx/viewbinding/ViewBinding;", "Landroidx/fragment/app/DialogFragment;", "res", FinalChip.BSP_PLATFORM_Null, "(I)V", "_binding", "Landroidx/viewbinding/ViewBinding;", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "getRes", "()I", "initData", FinalChip.BSP_PLATFORM_Null, "initObserve", "initView", "view", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class DataBindDialogBaseFragment<DB extends ViewBinding> extends DialogFragment {
    private DB _binding;
    private final int res;

    public DataBindDialogBaseFragment() {
        this(0, 1, null);
    }

    public void initData() {
    }

    public abstract void initObserve();

    public abstract void initView(View view);

    public DataBindDialogBaseFragment(int i) {
        this.res = i;
    }

    public /* synthetic */ DataBindDialogBaseFragment(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public final int getRes() {
        return this.res;
    }

    protected final DB getBinding() {
        DB db = this._binding;
        Intrinsics.checkNotNull(db);
        return db;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Type genericSuperclass = getClass().getGenericSuperclass();
        Intrinsics.checkNotNull(genericSuperclass);
        if (genericSuperclass != null) {
            Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            Intrinsics.checkNotNullExpressionValue(type, "type!!.saveAs<Parameteri…().actualTypeArguments[0]");
            DB db = (DB) new ReflexMethod("inflate").setupClass((Class) type).paramClasses(new Class[]{LayoutInflater.class, ViewGroup.class, Boolean.TYPE}).params(new Object[]{inflater, container, false}).call();
            this._binding = db;
            Intrinsics.checkNotNull(db);
            View root = db.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "_binding!!.root");
            initView(root);
            initObserve();
            initData();
            DB db2 = this._binding;
            Intrinsics.checkNotNull(db2);
            return db2.getRoot();
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }
}
