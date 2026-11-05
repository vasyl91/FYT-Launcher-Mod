package com.lsec.core.frame.ctrl;

import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JViewPagerVertical extends JViewPager {

    public class DefaultTransformer implements ViewPager.PageTransformer {
        public DefaultTransformer() {
        }

        @Override // android.support.v4.view.ViewPager.PageTransformer
        public void transformPage(View view, float position) {
            view.setTranslationX((-position) * view.getWidth());
            view.setTranslationY(view.getHeight() * position);
        }
    }

    public JViewPagerVertical(JPage page) {
        super(page);
        setPageTransformer(false, new DefaultTransformer());
    }

    private MotionEvent swapTouchEvent(MotionEvent event) {
        float width = getWidth();
        float height = getHeight();
        float swappedX = (event.getY() / height) * width;
        float swappedY = (event.getX() / width) * height;
        event.setLocation(swappedX, swappedY);
        return event;
    }

    @Override // com.lsec.core.frame.ctrl.JViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        boolean intercept = super.onInterceptTouchEvent(swapTouchEvent(event));
        swapTouchEvent(event);
        return intercept;
    }

    @Override // com.lsec.core.frame.ctrl.JViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(swapTouchEvent(ev));
    }
}
