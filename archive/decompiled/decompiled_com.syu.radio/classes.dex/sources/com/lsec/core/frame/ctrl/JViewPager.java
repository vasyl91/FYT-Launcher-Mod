package com.lsec.core.frame.ctrl;

import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.lsec.core.frame.page.IPageNotify;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JViewPager extends ViewPager {
    private static final int Direction_Left = 1;
    private static final int Direction_None = 0;
    private static final int Direction_Right = 2;
    boolean bActionDown;
    boolean bAttached;
    boolean bWillUpdateBackground;
    private int iDirection;
    boolean isCanScroll;
    private int itemCur;
    JPagerAdapter mAdapter;
    public int mArg2;
    public int[] mContents;
    public HashMap<String, Drawable> mDrawables;
    ViewPager mPager;
    String mStrDrawable;
    List<View> mViews;
    List<View> mViewsReal;
    private JPage page;

    public JViewPager(JPage page) {
        super(page.ui.mContext);
        this.bActionDown = false;
        this.mArg2 = 0;
        this.isCanScroll = true;
        this.itemCur = 0;
        this.iDirection = 0;
        this.bAttached = false;
        this.bWillUpdateBackground = false;
        this.mDrawables = new HashMap<>();
        this.mPager = this;
        this.iDirection = 0;
        this.page = page;
    }

    public void isCanScroll(boolean isCanScroll) {
        this.isCanScroll = isCanScroll;
    }

    public void setStrDrawable(String drawable, boolean bUpdateBk) {
        this.bWillUpdateBackground = true;
        this.mStrDrawable = drawable;
        if (bUpdateBk) {
            if (drawable == null) {
                setBackground(null);
            } else {
                updateBackground();
            }
        }
    }

    public void updateBackground() {
        if (!this.bAttached) {
            this.bWillUpdateBackground = true;
            return;
        }
        this.bWillUpdateBackground = false;
        if (this.page != null && this.mStrDrawable != null) {
            Drawable drawable = this.page.getDrawableFromPath(this.mStrDrawable, this.page.mDrawables, this.mDrawables);
            setBackground(drawable);
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        this.bAttached = true;
        if (this.bWillUpdateBackground) {
            this.bWillUpdateBackground = false;
            updateBackground();
        }
        super.onAttachedToWindow();
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.bAttached = false;
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int iAction = ev.getAction();
        switch (iAction) {
            case 0:
                this.bActionDown = true;
                break;
            case 1:
            case 3:
                this.bActionDown = false;
                break;
        }
        try {
            return super.dispatchTouchEvent(ev);
        } catch (Exception e) {
            return false;
        }
    }

    private View setLayoutParam(View v) {
        ViewGroup.LayoutParams lp = v.getLayoutParams();
        if (lp == null) {
            lp = new ViewGroup.LayoutParams(-1, -1);
        } else {
            lp.width = -1;
            lp.height = -1;
        }
        v.setLayoutParams(lp);
        return v;
    }

    public int getSize() {
        return this.mContents.length;
    }

    public void AddRealView2Dst(int indexSrc, int indexDst) {
        ViewGroup parent;
        if (indexDst >= 0 && indexDst <= this.mViews.size() - 1 && indexSrc >= 0 && indexSrc <= this.mViewsReal.size() - 1) {
            FrameLayout view = (FrameLayout) this.mViews.get(indexDst);
            View v = this.mViewsReal.get(indexSrc);
            if (v != null && (parent = (ViewGroup) v.getParent()) != view) {
                if (parent != null) {
                    parent.removeView(v);
                }
                view.addView(v);
                view.invalidate();
            }
        }
    }

    public void setUiLoader(int... content) {
        View vGroup;
        this.mContents = content;
        if (this.mContents != null) {
            this.mViews = new ArrayList();
            this.mViewsReal = new ArrayList();
            int count = this.mContents.length;
            if (count > 1) {
                int count2 = count + 2;
                for (int i = 0; i < count2; i++) {
                    FrameLayout view = new FrameLayout(this.page.ui.mContext);
                    view.setBackground(null);
                    this.mViews.add(setLayoutParam(view));
                    if (i != 0 && i != count2 - 1 && (vGroup = this.page.ui.loadPage(true, this.mContents[i - 1])) != null) {
                        this.mViewsReal.add((JPage) setLayoutParam(vGroup));
                        AddRealView2Dst(i - 1, i);
                    }
                }
                if (this.mViews.size() > 0) {
                    this.mAdapter = new JPagerAdapter(this.mViews);
                    setAdapter(this.mAdapter);
                    setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.lsec.core.frame.ctrl.JViewPager.1
                        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                        public void onPageSelected(int position) {
                            if (JViewPager.this.mArg2 == 0) {
                                JViewPager.this.AddRealView2Dst(0, 1);
                                JViewPager.this.AddRealView2Dst(JViewPager.this.mViewsReal.size() - 1, JViewPager.this.mViews.size() - 2);
                            }
                        }

                        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                        public void onPageScrolled(int arg0, float arg1, int arg2) {
                            JViewPager.this.mArg2 = arg2;
                            IPageNotify pageNotify = JViewPager.this.page.getNotify();
                            if (arg2 != 0 && JViewPager.this.bActionDown) {
                                if (JViewPager.this.iDirection == 0) {
                                    JViewPager.this.itemCur = JViewPager.this.mPager.getCurrentItem();
                                }
                                if (JViewPager.this.itemCur > arg0) {
                                    if (JViewPager.this.iDirection != 2) {
                                        JViewPager.this.iDirection = 2;
                                        if (pageNotify != null) {
                                            pageNotify.viewPagePrev(JViewPager.this.mPager);
                                        }
                                    }
                                } else if (JViewPager.this.iDirection != 1) {
                                    JViewPager.this.iDirection = 1;
                                    if (pageNotify != null) {
                                        pageNotify.viewPageNext(JViewPager.this.mPager);
                                    }
                                }
                                if (arg0 == JViewPager.this.mViews.size() - 2) {
                                    JViewPager.this.AddRealView2Dst(0, JViewPager.this.mViews.size() - 1);
                                } else if (arg0 == 0) {
                                    JViewPager.this.AddRealView2Dst(JViewPager.this.mViewsReal.size() - 1, 0);
                                } else {
                                    JViewPager.this.AddRealView2Dst(0, 1);
                                    JViewPager.this.AddRealView2Dst(JViewPager.this.mViewsReal.size() - 1, JViewPager.this.mViews.size() - 2);
                                }
                            }
                            if (arg2 == 0) {
                                int itemCur = JViewPager.this.mPager.getCurrentItem();
                                int itemShouldBe = itemCur;
                                if (arg0 == 0) {
                                    itemShouldBe = JViewPager.this.mViews.size() - 2;
                                } else if (arg0 == JViewPager.this.mViews.size() - 1) {
                                    itemShouldBe = 1;
                                }
                                if (JViewPager.this.iDirection != 0) {
                                    JViewPager.this.iDirection = 0;
                                    if (itemCur == itemShouldBe) {
                                        JViewPager.this.AddRealView2Dst(0, 1);
                                        JViewPager.this.AddRealView2Dst(JViewPager.this.mViewsReal.size() - 1, JViewPager.this.mViews.size() - 2);
                                        if (pageNotify != null) {
                                            pageNotify.viewPageScrolled(JViewPager.this.mPager);
                                        }
                                    }
                                }
                            }
                        }

                        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                        public void onPageScrollStateChanged(int state) {
                        }
                    });
                    setCurrentItem(1);
                }
            }
        }
    }

    public class JPagerAdapter extends PagerAdapter {
        List<View> mViews;

        public JPagerAdapter(List<View> list) {
            this.mViews = list;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (this.mViews == null) {
                return 0;
            }
            int ret = this.mViews.size();
            return ret;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void finishUpdate(ViewGroup container) {
            int itemCur = JViewPager.this.mPager.getCurrentItem();
            int itemShouldBe = itemCur;
            if (itemCur == 0) {
                itemShouldBe = this.mViews.size() - 2;
            } else if (itemCur == this.mViews.size() - 1) {
                itemShouldBe = 1;
            }
            if (itemCur != itemShouldBe) {
                JViewPager.this.mPager.setCurrentItem(itemShouldBe, false);
                JViewPager.this.AddRealView2Dst(0, 1);
                JViewPager.this.AddRealView2Dst(JViewPager.this.mViewsReal.size() - 1, this.mViews.size() - 2);
                IPageNotify pageNotify = JViewPager.this.page.getNotify();
                if (pageNotify != null) {
                    pageNotify.viewPageScrolled(JViewPager.this.mPager);
                }
            }
            super.finishUpdate(container);
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup container, int position) {
            if (position == 0) {
                JViewPager.this.AddRealView2Dst(JViewPager.this.mViewsReal.size() - 1, 0);
            } else if (position == this.mViews.size() - 1) {
                JViewPager.this.AddRealView2Dst(0, this.mViews.size() - 1);
            }
            View v = this.mViews.get(position);
            try {
                ViewParent viewParent = v.getParent();
                if (viewParent != null) {
                    ViewGroup viewGroup = (ViewGroup) viewParent;
                    viewGroup.removeView(v);
                }
                container.addView(v);
            } catch (Exception e) {
            }
            return v;
        }
    }

    @Override // android.support.v4.view.ViewPager
    public void setCurrentItem(int item) {
        if (this.mViewsReal == null || item <= this.mViewsReal.size()) {
            super.setCurrentItem(item);
        }
    }

    public int[] getContents() {
        return this.mContents;
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent arg0) {
        if (this.isCanScroll) {
            return super.onTouchEvent(arg0);
        }
        return false;
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (this.isCanScroll) {
            return super.onInterceptTouchEvent(arg0);
        }
        return false;
    }
}
