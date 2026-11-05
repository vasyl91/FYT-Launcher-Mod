package com.syu.media.radio.fragment;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import chip.FinalChip;
import com.syu.manger.module.radio.RadioController;
import com.syu.manger.module.radio.RadioModel;
import com.syu.manger.module.radio.RadioUtils;
import com.syu.media.R;
import com.syu.media.companion.decoration.SimpleItemDecoration;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.companion.utils.StringUtils;
import com.syu.media.databinding.RadioListFragmentBinding;
import com.syu.media.music.MusicModel;
import com.syu.media.music.widget.items.XGridLayoutManager;
import com.syu.media.radio.diff.DiffCallBack;
import com.syu.media.radio.items.StationItem;
import com.syu.radio.Radio;
import com.syu.radio.entities.RadioStation;
import com.syu.radio.entities.Station;
import com.syu.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import qin.widgets.JRecyclerView;
import syu.recyclerview.Node;
import syu.recyclerview.NodeAdapter;

/* JADX INFO: compiled from: RadioStationsFragment.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000278B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0007H\u0002J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000eH\u0002J \u0010\"\u001a\u0004\u0018\u00010#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\t2\u0006\u0010%\u001a\u00020\u0007H\u0002J\b\u0010&\u001a\u00020\u0005H\u0002J\b\u0010'\u001a\u00020\u001eH\u0016J\b\u0010(\u001a\u00020\u001eH\u0002J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u001eH\u0002J\u001a\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u00072\b\b\u0002\u0010/\u001a\u00020\u0005H\u0002J\u001a\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u00072\b\b\u0002\u00102\u001a\u00020\u0005H\u0002J\u0010\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u00020\u001eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0018\u00010\u001cR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/syu/media/radio/fragment/RadioStationsFragment;", "Lcom/syu/media/radio/fragment/RadioBaseFragment;", "Lcom/syu/media/databinding/RadioListFragmentBinding;", "()V", "amChannels", FinalChip.BSP_PLATFORM_Null, "checkedId", FinalChip.BSP_PLATFORM_Null, "favData", FinalChip.BSP_PLATFORM_Null, "Lsyu/recyclerview/Node;", "fmChannels", "iChannel", "iCity", FinalChip.BSP_PLATFORM_Null, "iFreq", "isFm", "job", "Lkotlinx/coroutines/Job;", "lastData", "lastPosition", "mAdapter", "Lsyu/recyclerview/NodeAdapter;", "mChannels", "Lcom/syu/radio/entities/Station;", "radioFragment", "Lcom/syu/media/radio/fragment/RadioFragment;", "updateListForIndex", "Lcom/syu/media/radio/fragment/RadioStationsFragment$UpdateListForIndex;", "check", FinalChip.BSP_PLATFORM_Null, "checkId", "citySuffix", "str", "containField", "Lcom/syu/radio/entities/RadioStation;", "radios", "freq", "freqIsNotEmpty", "initObserve", "initStationList", "initView", "view", "Landroid/view/View;", "initViews", "postUpdateList", "changedIndex", "force", "radioCheck", "id", "toBand", "updateChannels", "array", "Landroid/util/SparseIntArray;", "updateFavoriteChannels", "Companion", "UpdateListForIndex", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RadioStationsFragment extends RadioBaseFragment<RadioListFragmentBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int STATION_LIST_AM = 1001;
    public static final int STATION_LIST_FAVORITE = 1003;
    public static final int STATION_LIST_FM = 1002;
    private static final String TAG;
    private boolean amChannels;
    private int checkedId;
    private List<Node<?>> favData;
    private boolean fmChannels;
    private int iChannel;
    private String iCity;
    private int iFreq;
    private boolean isFm;
    private Job job;
    private List<Node<?>> lastData;
    private int lastPosition;
    private NodeAdapter mAdapter;
    private final List<Station> mChannels;
    private RadioFragment radioFragment;
    private UpdateListForIndex updateListForIndex;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-12$lambda-7, reason: not valid java name */
    public static final void m319initObserve$lambda12$lambda7(Integer num) {
    }

    private final void initViews() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ RadioListFragmentBinding access$getBinding(RadioStationsFragment radioStationsFragment) {
        return (RadioListFragmentBinding) radioStationsFragment.getBinding();
    }

    /* JADX INFO: compiled from: RadioStationsFragment.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/syu/media/radio/fragment/RadioStationsFragment$Companion;", FinalChip.BSP_PLATFORM_Null, "()V", "STATION_LIST_AM", FinalChip.BSP_PLATFORM_Null, "STATION_LIST_FAVORITE", "STATION_LIST_FM", "TAG", FinalChip.BSP_PLATFORM_Null, "getTAG", "()Ljava/lang/String;", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return RadioStationsFragment.TAG;
        }
    }

    public RadioStationsFragment() {
        super(R.layout.radio_list_fragment);
        this.mAdapter = new NodeAdapter(false, 1, (DefaultConstructorMarker) null);
        this.iChannel = -1;
        this.checkedId = -1;
        this.mChannels = new ArrayList();
        this.lastData = new ArrayList();
        this.favData = new ArrayList();
        this.iCity = Radio.DEF_STR;
    }

    static {
        String simpleName = Reflection.getOrCreateKotlinClass(RadioStationsFragment.class).getSimpleName();
        Intrinsics.checkNotNull(simpleName);
        TAG = simpleName;
    }

    /* JADX INFO: compiled from: RadioStationsFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/syu/media/radio/fragment/RadioStationsFragment$UpdateListForIndex;", "Ljava/lang/Runnable;", "changedIndex", FinalChip.BSP_PLATFORM_Null, "force", FinalChip.BSP_PLATFORM_Null, "(Lcom/syu/media/radio/fragment/RadioStationsFragment;IZ)V", "run", FinalChip.BSP_PLATFORM_Null, "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class UpdateListForIndex implements Runnable {
        private final int changedIndex;
        private final boolean force;

        public UpdateListForIndex(int i, boolean z) {
            this.changedIndex = i;
            this.force = z;
        }

        public /* synthetic */ UpdateListForIndex(RadioStationsFragment radioStationsFragment, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? false : z);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.force || (this.changedIndex >= 0 && RadioStationsFragment.this.lastPosition != this.changedIndex)) {
                HiLog.INSTANCE.d(RadioStationsFragment.INSTANCE.getTAG(), "UpdateListForIndex:" + this.changedIndex + ",lastPosition:" + RadioStationsFragment.this.lastPosition);
                RadioStationsFragment.this.mAdapter.notifyItemChanged(this.changedIndex);
            }
            RadioStationsFragment.this.mAdapter.notifyItemChanged(RadioStationsFragment.this.lastPosition);
            RadioStationsFragment.this.lastPosition = this.changedIndex;
            RadioStationsFragment.access$getBinding(RadioStationsFragment.this).radioStationList.scrollToPosition(RadioStationsFragment.this.lastPosition);
        }
    }

    static /* synthetic */ void postUpdateList$default(RadioStationsFragment radioStationsFragment, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        radioStationsFragment.postUpdateList(i, z);
    }

    private final void postUpdateList(int changedIndex, boolean force) {
        HiLog.INSTANCE.d(TAG, "postUpdateList:" + changedIndex + ",lastPosition:" + this.lastPosition);
        UpdateListForIndex updateListForIndex = this.updateListForIndex;
        if (updateListForIndex != null) {
            getMH().removeCallbacks(updateListForIndex);
        }
        this.updateListForIndex = null;
        if (force || changedIndex >= 0) {
            UpdateListForIndex updateListForIndex2 = new UpdateListForIndex(this, changedIndex, false, 2, null);
            this.updateListForIndex = updateListForIndex2;
            getMH().postDelayed(updateListForIndex2, 300L);
        }
    }

    private final void updateChannels(SparseIntArray array) {
        HiLog hiLog = HiLog.INSTANCE;
        String str = TAG;
        hiLog.d(str, "updateChannels city:" + this.iCity);
        HiLog.INSTANCE.d(str, "updateChannels mChannels:" + this.mChannels.size());
        HiLog.INSTANCE.d(str, "updateChannels array:" + array.size());
        this.mChannels.clear();
        int size = array.size();
        for (int i = 0; i < size; i++) {
            int iKeyAt = array.keyAt(i);
            int iValueAt = array.valueAt(i);
            if (iValueAt > 0) {
                int iIndexUi2Local = RadioUtils.INSTANCE.indexUi2Local(iKeyAt) - (RadioUtils.INSTANCE.isFmFreq(iValueAt) ? 0 : 18);
                int i2 = 65536;
                if (iKeyAt >= 65536 && iKeyAt <= 131072) {
                    i2 = 65536 + (iIndexUi2Local / 6);
                } else if (iKeyAt >= 0 && iKeyAt <= 65536) {
                    i2 = (iIndexUi2Local / 6) + 0;
                }
                this.mChannels.add(new Station(iIndexUi2Local, iKeyAt, iValueAt, i2));
            }
        }
        int size2 = this.mChannels.size();
        for (int i3 = 0; i3 < size2; i3++) {
            int id = this.mChannels.get(i3).getId();
            Integer value = getRadioModel().getMChannel().getValue();
            if (value != null && id == value.intValue()) {
                int freq = this.mChannels.get(i3).getFreq();
                Integer value2 = getRadioModel().getMFreq().getValue();
                if (value2 != null && freq == value2.intValue()) {
                    this.lastPosition = i3;
                    break;
                }
            }
        }
        List<Node<?>> listCreateNodesWithAdapter = Node.Companion.createNodesWithAdapter(this.mChannels, StationItem.class, this.mAdapter);
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new DiffCallBack(this.lastData, listCreateNodesWithAdapter), false);
        Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(DiffCallBa…astData, newData), false)");
        this.lastData = listCreateNodesWithAdapter;
        this.mAdapter.replaceWithoutNotify(listCreateNodesWithAdapter);
        diffResultCalculateDiff.dispatchUpdatesTo((RecyclerView.Adapter) this.mAdapter);
        HiLog.INSTANCE.d(TAG, "mChannels size:" + this.mChannels.size() + " array size:" + array.size());
    }

    private final void updateFavoriteChannels() {
        HiLog.INSTANCE.d(TAG, "updateFavoriteChannels city:" + this.iCity);
        this.job = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), (CoroutineStart) null, new RadioStationsFragment$updateFavoriteChannels$1$1(this, this.iCity, null), 2, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.syu.media.base.DataBindBaseFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        initStationList();
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            HiLog.INSTANCE.d(RadioCtrlFragment.INSTANCE.getTAG(), "parentFragment:" + parentFragment);
            if (parentFragment instanceof RadioFragment) {
                this.radioFragment = (RadioFragment) parentFragment;
            }
        }
        ((RadioListFragmentBinding) getBinding()).radioListGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.syu.media.radio.fragment.RadioStationsFragment$$ExternalSyntheticLambda0
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioStationsFragment.m327initView$lambda5(this.f$0, radioGroup, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initView$lambda-5, reason: not valid java name */
    public static final void m327initView$lambda5(RadioStationsFragment radioStationsFragment, RadioGroup radioGroup, int i) {
        RadioFragment radioFragment;
        Intrinsics.checkNotNullParameter(radioStationsFragment, "this$0");
        HiLog hiLog = HiLog.INSTANCE;
        String str = TAG;
        hiLog.d(str, "checkChange:" + i);
        if (i != -1) {
            HiLog.INSTANCE.d(str, "checkChange:" + radioStationsFragment.getResources().getResourceEntryName(i));
            radioStationsFragment.checkedId = i;
            if (i == R.id.radio_list_fm || i == R.id.radio_list_am) {
                RadioFragment radioFragment2 = radioStationsFragment.radioFragment;
                if (radioFragment2 != null) {
                    radioFragment2.setAllowScan(true);
                }
            } else if (i == R.id.radio_list_favorite && (radioFragment = radioStationsFragment.radioFragment) != null) {
                radioFragment.setAllowScan(false);
            }
            radioCheck$default(radioStationsFragment, i, false, 2, null);
        }
    }

    @Override // com.syu.media.base.DataBindBaseFragment
    public void initObserve() {
        RadioModel radioModel = getRadioModel();
        radioModel.getMChannel().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioStationsFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioStationsFragment.m318initObserve$lambda12$lambda6(this.f$0, (Integer) obj);
            }
        });
        radioModel.getMArea().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioStationsFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioStationsFragment.m319initObserve$lambda12$lambda7((Integer) obj);
            }
        });
        radioModel.getMFreq().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioStationsFragment$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioStationsFragment.m320initObserve$lambda12$lambda8(this.f$0, (Integer) obj);
            }
        });
        radioModel.getMBand().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioStationsFragment$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioStationsFragment.m321initObserve$lambda12$lambda9(this.f$0, (Integer) obj);
            }
        });
        radioModel.getFmChannelsChanged().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioStationsFragment$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioStationsFragment.m316initObserve$lambda12$lambda10(this.f$0, (Boolean) obj);
            }
        });
        radioModel.getAmChannelsChanged().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioStationsFragment$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioStationsFragment.m317initObserve$lambda12$lambda11(this.f$0, (Boolean) obj);
            }
        });
        getMainModel().getCity().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioStationsFragment$$ExternalSyntheticLambda10
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioStationsFragment.m322initObserve$lambda13(this.f$0, (String) obj);
            }
        });
        MusicModel musicModel = getApp().getMusicModel();
        musicModel.getRadioReset().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioStationsFragment$$ExternalSyntheticLambda11
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioStationsFragment.m323initObserve$lambda17$lambda14(this.f$0, (Boolean) obj);
            }
        });
        musicModel.getRadioName().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioStationsFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioStationsFragment.m324initObserve$lambda17$lambda15(this.f$0, (String) obj);
            }
        });
        musicModel.getRadioFavoriteStation().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioStationsFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioStationsFragment.m325initObserve$lambda17$lambda16(this.f$0, (Boolean) obj);
            }
        });
        getApp().getOnlineModel().getRadioCityName().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioStationsFragment$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioStationsFragment.m326initObserve$lambda18(this.f$0, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-12$lambda-6, reason: not valid java name */
    public static final void m318initObserve$lambda12$lambda6(RadioStationsFragment radioStationsFragment, Integer num) {
        Intrinsics.checkNotNullParameter(radioStationsFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "----------->>> mChannel:" + num);
        int size = radioStationsFragment.mChannels.size();
        int i = 0;
        while (i < size) {
            int id = radioStationsFragment.mChannels.get(i).getId();
            if (num != null && id == num.intValue()) {
                int freq = radioStationsFragment.mChannels.get(i).getFreq();
                Integer value = radioStationsFragment.getRadioModel().getMFreq().getValue();
                if (value != null && freq == value.intValue()) {
                    postUpdateList$default(radioStationsFragment, i, false, 2, null);
                }
            }
            i++;
        }
        i = -1;
        postUpdateList$default(radioStationsFragment, i, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: initObserve$lambda-12$lambda-8, reason: not valid java name */
    public static final void m320initObserve$lambda12$lambda8(RadioStationsFragment radioStationsFragment, Integer num) {
        int i;
        Intrinsics.checkNotNullParameter(radioStationsFragment, "this$0");
        HiLog hiLog = HiLog.INSTANCE;
        String str = TAG;
        hiLog.d(str, "----------->>> mFreq:" + num + " ,mChannel:" + radioStationsFragment.getRadioModel().getMChannel().getValue());
        RadioUtils radioUtils = RadioUtils.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(num, "it");
        boolean zIsFmFreq = radioUtils.isFmFreq(num.intValue());
        if (num.intValue() > 0 && radioStationsFragment.iFreq <= 0) {
            HiLog.INSTANCE.d(str, "initStationList freq:" + num + "  ,FmFreq:" + zIsFmFreq);
            radioStationsFragment.check(zIsFmFreq ? R.id.radio_list_fm : R.id.radio_list_am);
        }
        radioStationsFragment.iFreq = num.intValue();
        if (radioStationsFragment.checkedId == ((RadioListFragmentBinding) radioStationsFragment.getBinding()).radioListFavorite.getId()) {
            HiLog.INSTANCE.d(str, "initStationList favData.indices:" + CollectionsKt.getIndices(radioStationsFragment.favData));
            int size = radioStationsFragment.favData.size();
            i = 0;
            while (i < size) {
                Object data = radioStationsFragment.favData.get(i).getData();
                if (data == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.syu.radio.entities.RadioStation");
                }
                RadioStation radioStation = (RadioStation) data;
                HiLog hiLog2 = HiLog.INSTANCE;
                String str2 = TAG;
                hiLog2.d(str2, "initStationList station.freq:" + radioStation.getFreq() + ",it:" + num);
                if (Intrinsics.areEqual(radioStation.getFreq(), num)) {
                    HiLog.INSTANCE.d(str2, "initStationList station.freq11:" + radioStation.getFreq() + ",it:" + num);
                } else {
                    i++;
                }
            }
            i = -1;
        } else {
            int size2 = radioStationsFragment.mChannels.size();
            i = 0;
            while (i < size2) {
                int freq = radioStationsFragment.mChannels.get(i).getFreq();
                if (num != null && freq == num.intValue()) {
                    int id = radioStationsFragment.mChannels.get(i).getId();
                    Integer value = radioStationsFragment.getRadioModel().getMChannel().getValue();
                    if (value != null && id == value.intValue()) {
                    }
                }
                i++;
            }
            i = -1;
        }
        postUpdateList$default(radioStationsFragment, i, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-12$lambda-9, reason: not valid java name */
    public static final void m321initObserve$lambda12$lambda9(RadioStationsFragment radioStationsFragment, Integer num) {
        Intrinsics.checkNotNullParameter(radioStationsFragment, "this$0");
        HiLog hiLog = HiLog.INSTANCE;
        String str = TAG;
        hiLog.d(str, "mBand:  " + num);
        RadioUtils radioUtils = RadioUtils.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(num, "band");
        boolean zIsFm = radioUtils.isFm(num.intValue());
        HiLog.INSTANCE.d(str, "fmBand:" + zIsFm + " ,isFm:" + radioStationsFragment.isFm);
        if (radioStationsFragment.isFm != zIsFm) {
            radioStationsFragment.isFm = zIsFm;
            radioStationsFragment.check(zIsFm ? R.id.radio_list_fm : R.id.radio_list_am);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-12$lambda-10, reason: not valid java name */
    public static final void m316initObserve$lambda12$lambda10(RadioStationsFragment radioStationsFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(radioStationsFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "fmChannelsChanged:  " + bool);
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        if (bool.booleanValue() && radioStationsFragment.freqIsNotEmpty() && RadioUtils.INSTANCE.isFmFreq(radioStationsFragment.iFreq)) {
            radioStationsFragment.radioCheck(radioStationsFragment.checkedId, false);
        }
        radioStationsFragment.fmChannels = bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-12$lambda-11, reason: not valid java name */
    public static final void m317initObserve$lambda12$lambda11(RadioStationsFragment radioStationsFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(radioStationsFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "amChannelsChanged:  " + bool);
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        if (bool.booleanValue() && radioStationsFragment.freqIsNotEmpty() && !RadioUtils.INSTANCE.isFmFreq(radioStationsFragment.iFreq)) {
            radioStationsFragment.radioCheck(radioStationsFragment.checkedId, false);
        }
        radioStationsFragment.amChannels = bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: initObserve$lambda-13, reason: not valid java name */
    public static final void m322initObserve$lambda13(RadioStationsFragment radioStationsFragment, String str) {
        int i;
        Intrinsics.checkNotNullParameter(radioStationsFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "mainModel.city.observe:  " + str);
        boolean propForBoolean = Utils.getPropForBoolean("ro.client.foreign", false);
        boolean zIsChineseByReg = StringUtils.INSTANCE.isChineseByReg(radioStationsFragment.iCity);
        if (!propForBoolean || !zIsChineseByReg) {
            Intrinsics.checkNotNullExpressionValue(str, "it");
            radioStationsFragment.iCity = str;
        }
        if (((RadioListFragmentBinding) radioStationsFragment.getBinding()).radioListFm.isChecked()) {
            i = R.id.radio_list_fm;
        } else if (((RadioListFragmentBinding) radioStationsFragment.getBinding()).radioListAm.isChecked()) {
            i = R.id.radio_list_am;
        } else {
            i = ((RadioListFragmentBinding) radioStationsFragment.getBinding()).radioListFavorite.isChecked() ? R.id.radio_list_favorite : R.id.radio_list_fm;
        }
        if (radioStationsFragment.freqIsNotEmpty()) {
            radioStationsFragment.check(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-17$lambda-14, reason: not valid java name */
    public static final void m323initObserve$lambda17$lambda14(RadioStationsFragment radioStationsFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(radioStationsFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        if (bool.booleanValue()) {
            radioStationsFragment.iFreq = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-17$lambda-15, reason: not valid java name */
    public static final void m324initObserve$lambda17$lambda15(RadioStationsFragment radioStationsFragment, String str) {
        Intrinsics.checkNotNullParameter(radioStationsFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "--radioName:  " + str);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        radioStationsFragment.radioCheck(radioStationsFragment.checkedId, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: initObserve$lambda-17$lambda-16, reason: not valid java name */
    public static final void m325initObserve$lambda17$lambda16(RadioStationsFragment radioStationsFragment, Boolean bool) {
        int i;
        Intrinsics.checkNotNullParameter(radioStationsFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "radioFavoriteStation:  " + bool);
        if (radioStationsFragment.freqIsNotEmpty()) {
            if (((RadioListFragmentBinding) radioStationsFragment.getBinding()).radioListFm.isChecked()) {
                i = R.id.radio_list_fm;
            } else if (((RadioListFragmentBinding) radioStationsFragment.getBinding()).radioListAm.isChecked()) {
                i = R.id.radio_list_am;
            } else {
                i = ((RadioListFragmentBinding) radioStationsFragment.getBinding()).radioListFavorite.isChecked() ? R.id.radio_list_favorite : R.id.radio_list_fm;
            }
            radioCheck$default(radioStationsFragment, i, false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initObserve$lambda-18, reason: not valid java name */
    public static final void m326initObserve$lambda18(RadioStationsFragment radioStationsFragment, String str) {
        Intrinsics.checkNotNullParameter(radioStationsFragment, "this$0");
        radioStationsFragment.mAdapter.notifyDataSetChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initStationList() {
        JRecyclerView jRecyclerView = ((RadioListFragmentBinding) getBinding()).radioStationList;
        jRecyclerView.setLayoutManager(new XGridLayoutManager(requireContext(), 3));
        jRecyclerView.setAdapter(this.mAdapter);
        jRecyclerView.addItemDecoration(new SimpleItemDecoration(Integer.valueOf((int) jRecyclerView.getResources().getDimension(R.dimen.radio_item_space)), null, null, null, null, 30, null));
        RecyclerView.ItemAnimator itemAnimator = jRecyclerView.getItemAnimator();
        if (itemAnimator == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        }
        ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        jRecyclerView.setTag(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void check(int checkId) {
        HiLog.INSTANCE.d(TAG, "check checkName:" + getResources().getResourceEntryName(checkId));
        if (checkId == ((RadioListFragmentBinding) getBinding()).radioListGroup.getCheckedRadioButtonId()) {
            ((RadioListFragmentBinding) getBinding()).radioListGroup.clearCheck();
        }
        if (checkId == R.id.radio_list_fm) {
            ((RadioListFragmentBinding) getBinding()).radioListFm.setChecked(true);
            return;
        }
        if (checkId == R.id.radio_list_am) {
            ((RadioListFragmentBinding) getBinding()).radioListAm.setChecked(true);
        } else if (checkId == R.id.radio_list_favorite) {
            ((RadioListFragmentBinding) getBinding()).radioListFavorite.setChecked(true);
        } else {
            ((RadioListFragmentBinding) getBinding()).radioListFm.setChecked(true);
        }
    }

    static /* synthetic */ void radioCheck$default(RadioStationsFragment radioStationsFragment, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        radioStationsFragment.radioCheck(i, z);
    }

    private final void radioCheck(int id, boolean toBand) {
        RadioController radioController;
        RadioController radioController2;
        HiLog.INSTANCE.d(TAG, "radioCheck viewName:" + getResources().getResourceEntryName(id) + "  isFmBand:" + this.isFm);
        if (id == R.id.radio_list_am) {
            SparseIntArray value = getRadioModel().getMAmChannels().getValue();
            if (value != null) {
                if (toBand && (radioController2 = getRadioController()) != null) {
                    radioController2.toBand(0);
                }
                this.isFm = RadioUtils.INSTANCE.isFm(0);
                updateChannels(value);
                return;
            }
            return;
        }
        if (id == R.id.radio_list_fm) {
            SparseIntArray value2 = getRadioModel().getMFmChannels().getValue();
            if (value2 != null) {
                if (toBand && (radioController = getRadioController()) != null) {
                    radioController.toBand(65536);
                }
                this.isFm = RadioUtils.INSTANCE.isFm(65536);
                updateChannels(value2);
                return;
            }
            return;
        }
        if (id != R.id.radio_list_favorite || getRadioModel().getMFmChannels().getValue() == null) {
            return;
        }
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        updateFavoriteChannels();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String citySuffix(String str) {
        return str + getResources().getString(R.string.radio_city_suffix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RadioStation containField(List<RadioStation> radios, int freq) {
        int size = radios.size();
        for (int i = 0; i < size; i++) {
            Integer freq2 = radios.get(i).getFreq();
            if (freq2 != null && freq2.intValue() == freq) {
                return radios.get(i);
            }
        }
        return null;
    }

    private final boolean freqIsNotEmpty() {
        return this.iFreq > 0;
    }
}
