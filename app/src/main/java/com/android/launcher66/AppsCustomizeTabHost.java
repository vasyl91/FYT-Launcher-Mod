package com.android.launcher66;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.syu.ipc.data.FinalCanbus;
import com.syu.util.JLog;
import java.util.ArrayList;

public class AppsCustomizeTabHost extends TabHost implements LauncherTransitionable, TabHost.OnTabChangeListener, Insettable {
    private static final String APPS_TAB_TAG = "APPS";
    static final String LOG_TAG = "AppsCustomizeTabHost";
    private static final String WIDGETS_TAB_TAG = "WIDGETS";
    private FrameLayout mAnimationBuffer;
    private AppsCustomizePagedView mAppsCustomizePane;
    private LinearLayout mContent;
    private boolean mInTransition;
    private final Rect mInsets;
    private final LayoutInflater mLayoutInflater;
    private Runnable mRelayoutAndMakeVisible;
    private boolean mResetAfterTransition;
    private ViewGroup mTabs;
    private ViewGroup mTabsContainer;
    private boolean mTransitioningToWorkspace;

    public AppsCustomizeTabHost(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mInsets = new Rect();
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mRelayoutAndMakeVisible = new Runnable() { 
            @Override
            public void run() {
                AppsCustomizeTabHost.this.mTabs.requestLayout();
                AppsCustomizeTabHost.this.mTabsContainer.setAlpha(1.0f);
            }
        };
    }

    void setContentTypeImmediate(AppsCustomizePagedView.ContentType type) {
        setOnTabChangedListener(null);
        onTabChangedStart();
        onTabChangedEnd(type);
        setCurrentTabByTag(getTabTagForContentType(type));
        setOnTabChangedListener(this);
    }

    @Override
    public void setInsets(Rect insets) {
        this.mInsets.set(insets);
        FrameLayout.LayoutParams flp = (FrameLayout.LayoutParams) this.mContent.getLayoutParams();
        flp.topMargin = insets.top;
        flp.bottomMargin = insets.bottom;
        flp.leftMargin = insets.left;
        flp.rightMargin = insets.right;
        this.mContent.setLayoutParams(flp);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setup();
        ViewGroup tabsContainer = (ViewGroup) findViewById(R.id.tabs_container);
        TabWidget tabs = getTabWidget();
        final AppsCustomizePagedView appsCustomizePane = (AppsCustomizePagedView) findViewById(R.id.apps_customize_pane_content);
        this.mTabs = tabs;
        this.mTabsContainer = tabsContainer;
        this.mAppsCustomizePane = appsCustomizePane;
        this.mAnimationBuffer = (FrameLayout) findViewById(R.id.animation_buffer);
        this.mContent = (LinearLayout) findViewById(R.id.apps_customize_content);
        if (tabs == null || this.mAppsCustomizePane == null) {
            throw new Resources.NotFoundException();
        }
        TabContentFactory contentFactory = new TabContentFactory() { 
            @Override
            public View createTabContent(String tag) {
                return appsCustomizePane;
            }
        };
        String label = getContext().getString(R.string.all_apps_button_label);
        TextView tabView = (TextView) this.mLayoutInflater.inflate(R.layout.tab_widget_indicator, (ViewGroup) tabs, false);
        tabView.setText(label);
        tabView.setContentDescription(label);
        tabView.setWidth(FinalCanbus.CAR_WC1_MZD6);
        tabView.setTextSize(20.0f);
        addTab(newTabSpec(APPS_TAB_TAG).setIndicator(tabView).setContent(contentFactory));
        String label2 = getContext().getString(R.string.widgets_tab_label);
        TextView tabView2 = (TextView) this.mLayoutInflater.inflate(R.layout.tab_widget_indicator, (ViewGroup) tabs, false);
        tabView2.setWidth(FinalCanbus.CAR_WC1_MZD6);
        tabView2.setText(label2);
        tabView2.setTextSize(20.0f);
        tabView2.setContentDescription(label2);
        addTab(newTabSpec(WIDGETS_TAB_TAG).setIndicator(tabView2).setContent(contentFactory));
        setOnTabChangedListener(this);
        AppsCustomizeTabKeyEventListener keyListener = new AppsCustomizeTabKeyEventListener();
        View lastTab = tabs.getChildTabViewAt(tabs.getTabCount() - 1);
        lastTab.setOnKeyListener(keyListener);
        View shopButton = findViewById(R.id.market_button);
        shopButton.setOnKeyListener(keyListener);
        this.mTabsContainer.setAlpha(0.0f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        boolean remeasureTabWidth = this.mTabs.getLayoutParams().width <= 0;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (remeasureTabWidth) {
            int contentWidth = this.mAppsCustomizePane.getPageContentWidth();
            if (contentWidth > 0 && this.mTabs.getLayoutParams().width != contentWidth) {
                this.mTabs.getLayoutParams().width = contentWidth;
                this.mRelayoutAndMakeVisible.run();
            }
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (this.mInTransition && this.mTransitioningToWorkspace) {
            return true;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (this.mInTransition && this.mTransitioningToWorkspace) {
            return super.onTouchEvent(event);
        }
        if (event.getY() < this.mAppsCustomizePane.getBottom()) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    
    public void onTabChangedStart() {
    }

    
    public void reloadCurrentPage() {
        mAppsCustomizePane.loadAssociatedPages(mAppsCustomizePane.getCurrentPage());
        mAppsCustomizePane.requestFocus();
    }

    
    public void onTabChangedEnd(AppsCustomizePagedView.ContentType type) {
        JLog.getInstance().i("onTabChangedEnd");
        mAppsCustomizePane.setContentType(type);
    }

    @Override
    public void onTabChanged(String tabId) {
        JLog.getInstance().i("onTabChanged");
        final AppsCustomizePagedView.ContentType type = getContentTypeForTabTag(tabId);
        Resources res = getResources();
        final int duration = res.getInteger(R.integer.config_tabTransitionDuration);
        post(new Runnable() { 
            @Override
            public void run() {
                if (AppsCustomizeTabHost.this.mAppsCustomizePane.getMeasuredWidth() <= 0 || AppsCustomizeTabHost.this.mAppsCustomizePane.getMeasuredHeight() <= 0) {
                    AppsCustomizeTabHost.this.reloadCurrentPage();
                    return;
                }
                int[] visiblePageRange = new int[2];
                AppsCustomizeTabHost.this.mAppsCustomizePane.getVisiblePages(visiblePageRange);
                if (visiblePageRange[0] == -1 && visiblePageRange[1] == -1) {
                    AppsCustomizeTabHost.this.reloadCurrentPage();
                    return;
                }
                ArrayList<View> visiblePages = new ArrayList<>();
                for (int i = visiblePageRange[0]; i <= visiblePageRange[1]; i++) {
                    visiblePages.add(AppsCustomizeTabHost.this.mAppsCustomizePane.getPageAt(i));
                }
                AppsCustomizeTabHost.this.mAnimationBuffer.scrollTo(AppsCustomizeTabHost.this.mAppsCustomizePane.getScrollX(), 0);
                for (int i2 = visiblePages.size() - 1; i2 >= 0; i2--) {
                    View child = visiblePages.get(i2);
                    if (child instanceof AppsCustomizeCellLayout) {
                        ((AppsCustomizeCellLayout) child).resetChildrenOnKeyListeners();
                    } else if (child instanceof PagedViewGridLayout) {
                        ((PagedViewGridLayout) child).resetChildrenOnKeyListeners();
                    }
                    PagedViewWidget.setDeletePreviewsWhenDetachedFromWindow(false);
                    AppsCustomizeTabHost.this.mAppsCustomizePane.removeView(child);
                    PagedViewWidget.setDeletePreviewsWhenDetachedFromWindow(true);
                    AppsCustomizeTabHost.this.mAnimationBuffer.setAlpha(1.0f);
                    AppsCustomizeTabHost.this.mAnimationBuffer.setVisibility(View.VISIBLE);
                    FrameLayout.LayoutParams p = new FrameLayout.LayoutParams(child.getMeasuredWidth(), child.getMeasuredHeight());
                    p.setMargins(child.getLeft(), child.getTop(), 0, 0);
                    AppsCustomizeTabHost.this.mAnimationBuffer.addView(child, p);
                }
                AppsCustomizeTabHost.this.onTabChangedStart();
                AppsCustomizeTabHost.this.onTabChangedEnd(type);
                ObjectAnimator outAnim = LauncherAnimUtils.ofFloat(AppsCustomizeTabHost.this.mAnimationBuffer, "alpha", 0.0f);
                outAnim.addListener(new AnimatorListenerAdapter() { 
                    private void clearAnimationBuffer() {
                        AppsCustomizeTabHost.this.mAnimationBuffer.setVisibility(View.GONE);
                        PagedViewWidget.setRecyclePreviewsWhenDetachedFromWindow(false);
                        AppsCustomizeTabHost.this.mAnimationBuffer.removeAllViews();
                        PagedViewWidget.setRecyclePreviewsWhenDetachedFromWindow(true);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        clearAnimationBuffer();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        clearAnimationBuffer();
                    }
                });
                ObjectAnimator inAnim = LauncherAnimUtils.ofFloat(AppsCustomizeTabHost.this.mAppsCustomizePane, "alpha", 1.0f);
                inAnim.addListener(new AnimatorListenerAdapter() { 
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        AppsCustomizeTabHost.this.reloadCurrentPage();
                    }
                });
                AnimatorSet animSet = LauncherAnimUtils.createAnimatorSet();
                animSet.playTogether(outAnim, inAnim);
                animSet.setDuration(duration);
                animSet.start();
            }
        });
    }

    public void setCurrentTabFromContent(AppsCustomizePagedView.ContentType type) {
        setOnTabChangedListener(null);
        setCurrentTabByTag(getTabTagForContentType(type));
        setOnTabChangedListener(this);
    }

    public AppsCustomizePagedView.ContentType getContentTypeForTabTag(String tag) {
        if (tag.equals(APPS_TAB_TAG)) {
            return AppsCustomizePagedView.ContentType.Applications;
        }
        if (tag.equals(WIDGETS_TAB_TAG)) {
            return AppsCustomizePagedView.ContentType.Widgets;
        }
        return AppsCustomizePagedView.ContentType.Applications;
    }

    public String getTabTagForContentType(AppsCustomizePagedView.ContentType type) {
        if (type == AppsCustomizePagedView.ContentType.Applications) {
            return APPS_TAB_TAG;
        }
        if (type == AppsCustomizePagedView.ContentType.Widgets) {
            return WIDGETS_TAB_TAG;
        }
        return APPS_TAB_TAG;
    }

    @Override
    public int getDescendantFocusability() {
        if (getVisibility() != View.VISIBLE) {
            return 393216;
        }
        return super.getDescendantFocusability();
    }

    void reset() {
        if (!this.mInTransition) {
            this.mAppsCustomizePane.reset();
        }
    }

    private void enableAndBuildHardwareLayer() {
        if (isHardwareAccelerated()) {
            setLayerType(View.LAYER_TYPE_HARDWARE, null);
            buildLayer();
        }
    }

    @Override
    public View getContent() {
        return this.mContent;
    }

    @Override
    public void onLauncherTransitionPrepare(Launcher l, boolean animated, boolean toWorkspace) {
        this.mAppsCustomizePane.onLauncherTransitionPrepare(l, animated, toWorkspace);
        this.mInTransition = true;
        this.mTransitioningToWorkspace = toWorkspace;
        if (toWorkspace) {
            setVisibilityOfSiblingsWithLowerZOrder(0);
        } else {
            this.mContent.setVisibility(View.VISIBLE);
            this.mAppsCustomizePane.loadAssociatedPages(this.mAppsCustomizePane.getCurrentPage(), true);
        }
        if (this.mResetAfterTransition) {
            this.mAppsCustomizePane.reset();
            this.mResetAfterTransition = false;
        }
    }

    @Override
    public void onLauncherTransitionStart(Launcher l, boolean animated, boolean toWorkspace) {
        if (animated) {
            enableAndBuildHardwareLayer();
        }
        l.dismissWorkspaceCling(null);
    }

    @Override
    public void onLauncherTransitionStep(Launcher l, float t) {
    }

    @Override
    public void onLauncherTransitionEnd(Launcher l, boolean animated, boolean toWorkspace) {
        this.mAppsCustomizePane.onLauncherTransitionEnd(l, animated, toWorkspace);
        this.mInTransition = false;
        if (animated) {
            setLayerType(View.LAYER_TYPE_NONE, null);
        }
        if (!toWorkspace) {
            this.mAppsCustomizePane.showAllAppsCling();
            this.mAppsCustomizePane.loadAssociatedPages(this.mAppsCustomizePane.getCurrentPage());
            setVisibilityOfSiblingsWithLowerZOrder(4);
        }
    }

    private void setVisibilityOfSiblingsWithLowerZOrder(int visibility) {
        ViewGroup parent = (ViewGroup) getParent();
        if (parent != null) {
            View overviewPanel = ((Launcher) getContext()).getOverviewPanel();
            int count = parent.getChildCount();
            if (!isChildrenDrawingOrderEnabled()) {
                for (int i = 0; i < count; i++) {
                    View child = parent.getChildAt(i);
                    if (child != this) {
                        if (Launcher.getLauncher().mHotseat != child || LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_hotseat_hide)) {
                            if (child.getVisibility() != View.GONE && child != overviewPanel) {
                                child.setVisibility(visibility);
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                return;
            }
            throw new RuntimeException("Failed; can't get z-order of views");
        }
    }

    public void onWindowVisible() {
        if (getVisibility() == View.VISIBLE) {
            this.mContent.setVisibility(View.VISIBLE);
            this.mAppsCustomizePane.loadAssociatedPages(this.mAppsCustomizePane.getCurrentPage(), true);
            this.mAppsCustomizePane.loadAssociatedPages(this.mAppsCustomizePane.getCurrentPage());
        }
    }

    public void onTrimMemory() {
        this.mContent.setVisibility(View.GONE);
        this.mAppsCustomizePane.clearAllWidgetPages();
    }

    boolean isTransitioning() {
        return this.mInTransition;
    }

    void alphaAnmi() {
        setBackgroundColor(Color.argb(0, 0, 0, 0));
        float finalAlpha = getResources().getInteger(R.integer.config_appsCustomizeSpringLoadedBgAlpha) / 100.0f;
        ValueAnimator bgAnimator = ValueAnimator.ofObject(new FloatEvaluator(), Float.valueOf(0.0f), Float.valueOf(finalAlpha));
        bgAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { 
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int alpha = (int) (((Float) animation.getAnimatedValue()).floatValue() * 255.0f);
                AppsCustomizeTabHost.this.setBackgroundColor(Color.argb(alpha, 0, 0, 0));
            }
        });
        bgAnimator.setStartDelay(300L);
        bgAnimator.setDuration(1000L);
        bgAnimator.start();
    }
}
