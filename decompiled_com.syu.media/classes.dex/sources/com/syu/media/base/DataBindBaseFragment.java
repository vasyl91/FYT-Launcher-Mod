package com.syu.media.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import chip.FinalChip;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qin.reflex.ReflexMethod;

/* JADX INFO: compiled from: DataBindBaseFragment.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u0018*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH&J&\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016R\u0012\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00028\u00008DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/syu/media/base/DataBindBaseFragment;", "DB", "Landroidx/viewbinding/ViewBinding;", "Lcom/syu/media/base/BaseFragment;", "()V", "_binding", "Landroidx/viewbinding/ViewBinding;", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "initData", FinalChip.BSP_PLATFORM_Null, "initObserve", "initView", "view", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class DataBindBaseFragment<DB extends ViewBinding> extends BaseFragment {
    public static final String TAG = "DataBindBaseFragment";
    private DB _binding;

    public void initData() {
    }

    public abstract void initObserve();

    public abstract void initView(View view);

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

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }
}
