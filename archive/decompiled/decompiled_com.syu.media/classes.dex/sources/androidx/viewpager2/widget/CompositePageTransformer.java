package androidx.viewpager2.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class CompositePageTransformer implements ViewPager2.PageTransformer {
    private final List<ViewPager2.PageTransformer> mTransformers = new ArrayList();

    public void addTransformer(ViewPager2.PageTransformer pageTransformer) {
        this.mTransformers.add(pageTransformer);
    }

    public void removeTransformer(ViewPager2.PageTransformer pageTransformer) {
        this.mTransformers.remove(pageTransformer);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View view, float f) {
        Iterator<ViewPager2.PageTransformer> it = this.mTransformers.iterator();
        while (it.hasNext()) {
            it.next().transformPage(view, f);
        }
    }
}
