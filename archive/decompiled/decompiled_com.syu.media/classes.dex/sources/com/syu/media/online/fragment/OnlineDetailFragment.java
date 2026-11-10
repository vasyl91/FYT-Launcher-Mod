package com.syu.media.online.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import chip.FinalChip;
import com.google.android.material.tabs.TabLayout;
import com.syu.media.ConstantsKt;
import com.syu.media.R;
import com.syu.media.companion.ext.ViewExtKt;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.databinding.OnlineDetailFragmentBinding;
import com.syu.media.entities.MediaSource;
import com.syu.media.entities.RadioSource;
import com.syu.media.music.fragment.MediaBaseFragment;
import com.syu.media.online.OnlineRadioService;
import com.syu.media.online.adapter.ViewPager2FragmentAdapter;
import com.syu.media.online.fragment.tab.TabHost;
import com.syu.media.online.fragment.tab.TabLayoutMediators;
import com.syu.media.online.fragment.tab.TabType;
import com.syu.media.service.MediaPresenter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import syu.reflex.ReflexField;

/* JADX INFO: compiled from: OnlineDetailFragment.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001'B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\b\u0010#\u001a\u00020\u0017H\u0016J\b\u0010$\u001a\u00020\u0017H\u0016J\u000e\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006("}, d2 = {"Lcom/syu/media/online/fragment/OnlineDetailFragment;", "Lcom/syu/media/music/fragment/MediaBaseFragment;", "Lcom/syu/media/databinding/OnlineDetailFragmentBinding;", "Lcom/syu/media/service/MediaPresenter$OnPlayStateChangedListener;", "()V", "arrayTabFragments", FinalChip.BSP_PLATFORM_Null, "Landroidx/fragment/app/Fragment;", "bk", "Landroid/graphics/drawable/Drawable;", "fragmentAdapter", "Lcom/syu/media/online/adapter/ViewPager2FragmentAdapter;", "onlinePresenter", "Lcom/syu/media/service/MediaPresenter;", "playStateHandler", "Ljava/lang/Runnable;", "tabLayoutMediator", "Lcom/syu/media/online/fragment/tab/TabLayoutMediators;", "tabs", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "[Ljava/lang/Integer;", "backPressed", FinalChip.BSP_PLATFORM_Null, "initData", "initObserve", "initView", "view", "Landroid/view/View;", "onChanged", "isPlaying", FinalChip.BSP_PLATFORM_Null, "source", "Lcom/syu/media/entities/MediaSource;", "onDestroy", "onPaused", "onResumed", "setBlurBk", "d", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OnlineDetailFragment extends MediaBaseFragment<OnlineDetailFragmentBinding> implements MediaPresenter.OnPlayStateChangedListener {
    public static final String TAG = "OnlineDetailFragment";
    private final List<Fragment> arrayTabFragments;
    private Drawable bk;
    private ViewPager2FragmentAdapter fragmentAdapter;
    private MediaPresenter onlinePresenter;
    private final Runnable playStateHandler;
    private TabLayoutMediators tabLayoutMediator;
    private final Integer[] tabs;

    @Override // com.syu.media.base.DataBindBaseFragment
    public void initData() {
    }

    public OnlineDetailFragment() {
        super(R.layout.online_detail_fragment);
        this.tabs = new Integer[]{Integer.valueOf(R.string.online_list_style_all), Integer.valueOf(R.string.online_list_style_area), Integer.valueOf(R.string.online_list_style_type), Integer.valueOf(R.string.online_list_style_favorite)};
        this.arrayTabFragments = new ArrayList();
        this.playStateHandler = new Runnable() { // from class: com.syu.media.online.fragment.OnlineDetailFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                OnlineDetailFragment.m203playStateHandler$lambda0(this.f$0);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: playStateHandler$lambda-0, reason: not valid java name */
    public static final void m203playStateHandler$lambda0(OnlineDetailFragment onlineDetailFragment) {
        Intrinsics.checkNotNullParameter(onlineDetailFragment, "this$0");
        MediaPresenter mediaPresenter = onlineDetailFragment.onlinePresenter;
        if (mediaPresenter != null) {
            mediaPresenter.registerOnPlayStateChangedListener(onlineDetailFragment);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.syu.media.base.DataBindBaseFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        HiLog.INSTANCE.d(TAG, "onViewCreated");
        Drawable drawable = this.bk;
        if (drawable != null) {
            setBlurBk(drawable);
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        String name = OnlineRadioService.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "OnlineRadioService::class.java.name");
        this.onlinePresenter = new MediaPresenter(contextRequireContext, name, ((OnlineDetailFragmentBinding) getBinding()).onlineCtrPlay, ((OnlineDetailFragmentBinding) getBinding()).onlineCtrNext, ((OnlineDetailFragmentBinding) getBinding()).onlineCtrPrev);
        ViewPager2 viewPager2 = ((OnlineDetailFragmentBinding) getBinding()).onlineDetailViewpager2;
        this.arrayTabFragments.clear();
        List<Fragment> list = this.arrayTabFragments;
        TabType tabType = TabType.TAB_LIST_ALL;
        MediaPresenter mediaPresenter = this.onlinePresenter;
        Intrinsics.checkNotNull(mediaPresenter);
        list.add(new TabHost(tabType, mediaPresenter));
        List<Fragment> list2 = this.arrayTabFragments;
        TabType tabType2 = TabType.TAB_LIST_LOCAL;
        MediaPresenter mediaPresenter2 = this.onlinePresenter;
        Intrinsics.checkNotNull(mediaPresenter2);
        list2.add(new TabHost(tabType2, mediaPresenter2));
        List<Fragment> list3 = this.arrayTabFragments;
        TabType tabType3 = TabType.TAB_LIST_TYPE;
        MediaPresenter mediaPresenter3 = this.onlinePresenter;
        Intrinsics.checkNotNull(mediaPresenter3);
        list3.add(new TabHost(tabType3, mediaPresenter3));
        List<Fragment> list4 = this.arrayTabFragments;
        TabType tabType4 = TabType.TAB_LIST_FAVORITE;
        MediaPresenter mediaPresenter4 = this.onlinePresenter;
        Intrinsics.checkNotNull(mediaPresenter4);
        list4.add(new TabHost(tabType4, mediaPresenter4));
        ViewPager2FragmentAdapter viewPager2FragmentAdapter = new ViewPager2FragmentAdapter(this, this.arrayTabFragments);
        this.fragmentAdapter = viewPager2FragmentAdapter;
        viewPager2.setAdapter(viewPager2FragmentAdapter);
        viewPager2.setUserInputEnabled(true);
        viewPager2.setOffscreenPageLimit(-1);
        RecyclerView recyclerView = (RecyclerView) new ReflexField(ViewPager2.class, "mRecyclerView").getFieldValue(viewPager2);
        ReflexField reflexField = new ReflexField(RecyclerView.class, "mTouchSlop");
        Integer num = (Integer) reflexField.getFieldValue(recyclerView);
        Intrinsics.checkNotNull(num);
        reflexField.setField(recyclerView, Integer.valueOf(num.intValue() * 6));
        TabLayoutMediators tabLayoutMediators = new TabLayoutMediators(((OnlineDetailFragmentBinding) getBinding()).onlineDetailTablayout, viewPager2, new TabLayoutMediators.TabConfigurationStrategy() { // from class: com.syu.media.online.fragment.OnlineDetailFragment$$ExternalSyntheticLambda1
            @Override // com.syu.media.online.fragment.tab.TabLayoutMediators.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                OnlineDetailFragment.m202initView$lambda4$lambda3(this.f$0, tab, i);
            }
        });
        this.tabLayoutMediator = tabLayoutMediators;
        tabLayoutMediators.attach();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initView$lambda-4$lambda-3, reason: not valid java name */
    public static final void m202initView$lambda4$lambda3(OnlineDetailFragment onlineDetailFragment, TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(onlineDetailFragment, "this$0");
        Intrinsics.checkNotNullParameter(tab, "tab");
        tab.setCustomView(R.layout.online_tab_style);
        View customView = tab.getCustomView();
        if (customView != null && (customView instanceof TextView)) {
            Integer[] numArr = onlineDetailFragment.tabs;
            if (i < numArr.length) {
                ((TextView) customView).setText(numArr[i].intValue());
            }
        }
        HiLog.INSTANCE.d(TAG, "text:" + onlineDetailFragment.tabs[i].intValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.syu.media.base.DataBindBaseFragment
    public void initObserve() {
        ConstraintLayout constraintLayout = ((OnlineDetailFragmentBinding) getBinding()).fragmentContainerView2;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.fragmentContainerView2");
        ViewExtKt.onClick$default(constraintLayout, 0L, new Function1<View, Unit>() { // from class: com.syu.media.online.fragment.OnlineDetailFragment.initObserve.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(View view) {
                Intrinsics.checkNotNullParameter(view, "it");
                OnlineDetailFragment.this.backPressed();
            }
        }, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.syu.media.service.MediaPresenter.OnPlayStateChangedListener
    public void onChanged(boolean isPlaying, MediaSource source) {
        HiLog.INSTANCE.d(TAG, "onChanged isPlaying: " + isPlaying);
        if (isAdded() && source != null && (source instanceof RadioSource)) {
            ((OnlineDetailFragmentBinding) getBinding()).onlineDetailName.setText(source.getCom.syu.media.provider.Media.DISPLAY_NAME java.lang.String());
            ((OnlineDetailFragmentBinding) getBinding()).onlineCtrPlay.setImageResource(isPlaying ? R.drawable.music_player_pause_swi : R.drawable.music_player_play_swi);
            String str = ((RadioSource) source).getCom.syu.media.provider.Media.ICON java.lang.String();
            HiLog.INSTANCE.e(TAG, "data cover: " + str + ", " + new File(str).exists());
            Bitmap bitmapDecodeBitmap = getApp().getResourcesLoader().decodeBitmap(str);
            if (bitmapDecodeBitmap == null) {
                bitmapDecodeBitmap = getApp().getIconCache().get(source.getCom.syu.media.provider.Media.PATH java.lang.String());
            }
            ((OnlineDetailFragmentBinding) getBinding()).onlineCtrAlbum.setImageBitmap(bitmapDecodeBitmap);
        }
    }

    @Override // com.syu.media.base.BaseFragment
    public void onResumed() {
        HiLog.INSTANCE.d(TAG, "onResumed");
        getMH().postDelayed(this.playStateHandler, 350L);
        HiLog.INSTANCE.d(TAG, "onResumed end");
    }

    @Override // com.syu.media.base.BaseFragment
    public void onPaused() {
        HiLog.INSTANCE.d(TAG, "onPaused");
        getMH().removeCallbacks(this.playStateHandler);
        MediaPresenter mediaPresenter = this.onlinePresenter;
        if (mediaPresenter != null) {
            mediaPresenter.unregisterOnPlayStateChangedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void backPressed() {
        HiLog.INSTANCE.d(TAG, "backPressed");
        onStartPage(ConstantsKt.ACTION_PAGE_ONLINE);
    }

    @Override // com.syu.media.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        TabLayoutMediators tabLayoutMediators = this.tabLayoutMediator;
        if (tabLayoutMediators != null) {
            tabLayoutMediators.detach();
        }
        HiLog.INSTANCE.d(TAG, "onDestroy");
    }

    public final void setBlurBk(Drawable d) {
        Intrinsics.checkNotNullParameter(d, "d");
        if (isAdded()) {
            bkChanged(R.id.online_detail_frag_blur_img, d);
        } else {
            this.bk = d;
        }
    }
}
