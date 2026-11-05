package com.syu.media.btmusic.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import chip.FinalChip;
import com.syu.media.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlurImgFragment.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/syu/media/btmusic/fragment/BlurImgFragment;", "Landroidx/fragment/app/Fragment;", "blurDrawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "blurImgFrag", "Landroid/widget/ImageView;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", FinalChip.BSP_PLATFORM_Null, "onDestroyView", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BlurImgFragment extends Fragment {
    private Drawable blurDrawable;
    private ImageView blurImgFrag;

    /* JADX WARN: Illegal instructions before constructor call */
    public BlurImgFragment() {
        Drawable drawable = null;
        this(drawable, 1, drawable);
    }

    public /* synthetic */ BlurImgFragment(Drawable drawable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : drawable);
    }

    public BlurImgFragment(Drawable drawable) {
        this.blurDrawable = drawable;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.blur_img_fragment, container, false);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.blur_img_frag);
        this.blurImgFrag = imageView;
        Drawable drawable = this.blurDrawable;
        if (drawable != null && imageView != null) {
            imageView.setImageDrawable(drawable);
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ImageView imageView = this.blurImgFrag;
        if (imageView != null) {
            imageView.setImageResource(0);
        }
        this.blurDrawable = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        System.gc();
        super.onDestroy();
    }
}
