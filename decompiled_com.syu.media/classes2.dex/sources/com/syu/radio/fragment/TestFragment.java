package com.syu.radio.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.syu.manger.AutoManager;
import com.syu.manger.module.radio.RadioController;
import com.syu.manger.module.radio.RadioModel;
import com.syu.manger.module.radio.RadioUtils;
import com.syu.media.MediaApp;
import com.syu.media.R;
import com.syu.media.companion.decoration.SimpleItemDecoration;
import com.syu.media.radio.fragment.PtySelectFragment;
import com.syu.media.radio.items.StationItem;
import com.syu.radio.entities.Station;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import syu.base.BaseFragment;
import syu.recyclerview.Node;
import syu.recyclerview.NodeAdapter;

/* JADX INFO: compiled from: TestFragment.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u00020}H\u0002J\u0010\u0010~\u001a\u00020{2\u0006\u0010|\u001a\u00020}H\u0002J\u000e\u0010\u007f\u001a\u00020{2\u0006\u0010|\u001a\u00020}J\u0011\u0010\u0080\u0001\u001a\u00020{2\u0006\u0010|\u001a\u00020}H\u0002J\t\u0010\u0081\u0001\u001a\u00020{H\u0016J\u001d\u0010\u0082\u0001\u001a\u00020{2\u0006\u0010|\u001a\u00020}2\n\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001H\u0016J\u0011\u0010\u0085\u0001\u001a\u00020{2\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\u001c\u0010,\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\u001c\u0010/\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\f\"\u0004\b1\u0010\u000eR\u001c\u00102\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\f\"\u0004\b4\u0010\u000eR\u001c\u00105\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\f\"\u0004\b7\u0010\u000eR\u001a\u00108\u001a\u000209X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010:\"\u0004\b;\u0010<R\u001c\u0010=\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\f\"\u0004\b?\u0010\u000eR\u001a\u0010@\u001a\u00020AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0014\u0010F\u001a\b\u0012\u0004\u0012\u00020H0GX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010I\u001a\u00020J8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bK\u0010LR\u001c\u0010O\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0006\"\u0004\bQ\u0010\bR\u001c\u0010R\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0006\"\u0004\bT\u0010\bR\u001c\u0010U\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\f\"\u0004\bW\u0010\u000eR\u001c\u0010X\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0006\"\u0004\bZ\u0010\bR\u001d\u0010[\u001a\u0004\u0018\u00010\\8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b_\u0010N\u001a\u0004\b]\u0010^R\u001b\u0010`\u001a\u00020a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bd\u0010N\u001a\u0004\bb\u0010cR\u001c\u0010e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010!\"\u0004\bg\u0010#R\u001c\u0010h\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\f\"\u0004\bj\u0010\u000eR\u001c\u0010k\u001a\u0004\u0018\u00010lX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001c\u0010q\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010\u0006\"\u0004\bs\u0010\bR\u001c\u0010t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\f\"\u0004\bv\u0010\u000eR\u001c\u0010w\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\f\"\u0004\by\u0010\u000e¨\u0006\u0088\u0001"}, d2 = {"Lcom/syu/radio/fragment/TestFragment;", "Lsyu/base/BaseFragment;", "()V", "afCtrl", "Landroid/widget/Button;", "getAfCtrl", "()Landroid/widget/Button;", "setAfCtrl", "(Landroid/widget/Button;)V", "afTv", "Landroid/widget/TextView;", "getAfTv", "()Landroid/widget/TextView;", "setAfTv", "(Landroid/widget/TextView;)V", "amSensAddCtrl", "getAmSensAddCtrl", "setAmSensAddCtrl", "amSensRedCtrl", "getAmSensRedCtrl", "setAmSensRedCtrl", "amSensitivityTv", "getAmSensitivityTv", "setAmSensitivityTv", "areaGroup", "Landroid/widget/RadioGroup;", "getAreaGroup", "()Landroid/widget/RadioGroup;", "setAreaGroup", "(Landroid/widget/RadioGroup;)V", "autoStopSwitcher", "Landroid/widget/Switch;", "getAutoStopSwitcher", "()Landroid/widget/Switch;", "setAutoStopSwitcher", "(Landroid/widget/Switch;)V", "bandNameTv", "getBandNameTv", "setBandNameTv", "channelsChanged", "Ljava/lang/Runnable;", "fmSensAddCtrl", "getFmSensAddCtrl", "setFmSensAddCtrl", "fmSensRedCtrl", "getFmSensRedCtrl", "setFmSensRedCtrl", "fmSensitivityTv", "getFmSensitivityTv", "setFmSensitivityTv", "freqTv", "getFreqTv", "setFreqTv", "freqUnitTv", "getFreqUnitTv", "setFreqUnitTv", "isFmBand", "", "()Z", "setFmBand", "(Z)V", "locTv", "getLocTv", "setLocTv", "mAdapter", "Lsyu/recyclerview/NodeAdapter;", "getMAdapter", "()Lsyu/recyclerview/NodeAdapter;", "setMAdapter", "(Lsyu/recyclerview/NodeAdapter;)V", "mChannels", "", "Lcom/syu/radio/entities/Station;", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mHandler$delegate", "Lkotlin/Lazy;", "nextCtrl", "getNextCtrl", "setNextCtrl", "prevCtrl", "getPrevCtrl", "setPrevCtrl", "psTv", "getPsTv", "setPsTv", "ptyCtrl", "getPtyCtrl", "setPtyCtrl", "radioController", "Lcom/syu/manger/module/radio/RadioController;", "getRadioController", "()Lcom/syu/manger/module/radio/RadioController;", "radioController$delegate", "radioModel", "Lcom/syu/manger/module/radio/RadioModel;", "getRadioModel", "()Lcom/syu/manger/module/radio/RadioModel;", "radioModel$delegate", "rdsSwitcher", "getRdsSwitcher", "setRdsSwitcher", "rdsTv", "getRdsTv", "setRdsTv", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "taCtrl", "getTaCtrl", "setTaCtrl", "taTv", "getTaTv", "setTaTv", "tpTv", "getTpTv", "setTpTv", "addClickListener", "", "view", "Landroid/view/View;", "addObserver", "initStationList", "initViews", "onResume", "onViewCreated", "savedInstanceState", "Landroid/os/Bundle;", "updateChannels", "array", "Landroid/util/SparseIntArray;", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TestFragment extends BaseFragment {
    private Button afCtrl;
    private TextView afTv;
    private Button amSensAddCtrl;
    private Button amSensRedCtrl;
    private TextView amSensitivityTv;
    private RadioGroup areaGroup;
    private Switch autoStopSwitcher;
    private TextView bandNameTv;
    private final Runnable channelsChanged;
    private Button fmSensAddCtrl;
    private Button fmSensRedCtrl;
    private TextView fmSensitivityTv;
    private TextView freqTv;
    private TextView freqUnitTv;
    private boolean isFmBand;
    private TextView locTv;
    private NodeAdapter mAdapter;
    private final List<Station> mChannels;

    /* JADX INFO: renamed from: mHandler$delegate, reason: from kotlin metadata */
    private final Lazy mHandler;
    private Button nextCtrl;
    private Button prevCtrl;
    private TextView psTv;
    private Button ptyCtrl;

    /* JADX INFO: renamed from: radioController$delegate, reason: from kotlin metadata */
    private final Lazy radioController;

    /* JADX INFO: renamed from: radioModel$delegate, reason: from kotlin metadata */
    private final Lazy radioModel;
    private Switch rdsSwitcher;
    private TextView rdsTv;
    private RecyclerView recyclerView;
    private Button taCtrl;
    private TextView taTv;
    private TextView tpTv;

    public TestFragment() {
        super(R.layout.radio_test_layout);
        this.radioModel = LazyKt.lazy(new Function0<RadioModel>() { // from class: com.syu.radio.fragment.TestFragment$radioModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RadioModel invoke() {
                RadioModel radioModel = MediaApp.Companion.getMe().getViewModelProvider().get(RadioModel.class);
                Intrinsics.checkNotNullExpressionValue(radioModel, "viewModelProvider.get(VM::class.java)");
                return radioModel;
            }
        });
        this.radioController = LazyKt.lazy(new Function0<RadioController>() { // from class: com.syu.radio.fragment.TestFragment$radioController$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RadioController invoke() {
                return AutoManager.Companion.requestInstance().getRadioController();
            }
        });
        this.mAdapter = new NodeAdapter(false, 1, (DefaultConstructorMarker) null);
        this.mHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.syu.radio.fragment.TestFragment$mHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        this.mChannels = new ArrayList();
        this.channelsChanged = new Runnable() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                TestFragment.m47channelsChanged$lambda2(this.f$0);
            }
        };
    }

    public final RadioModel getRadioModel() {
        return (RadioModel) this.radioModel.getValue();
    }

    public final RadioController getRadioController() {
        return (RadioController) this.radioController.getValue();
    }

    public final Button getTaCtrl() {
        return this.taCtrl;
    }

    public final void setTaCtrl(Button button) {
        this.taCtrl = button;
    }

    public final Button getPtyCtrl() {
        return this.ptyCtrl;
    }

    public final void setPtyCtrl(Button button) {
        this.ptyCtrl = button;
    }

    public final Button getAfCtrl() {
        return this.afCtrl;
    }

    public final void setAfCtrl(Button button) {
        this.afCtrl = button;
    }

    public final Button getPrevCtrl() {
        return this.prevCtrl;
    }

    public final void setPrevCtrl(Button button) {
        this.prevCtrl = button;
    }

    public final Button getNextCtrl() {
        return this.nextCtrl;
    }

    public final void setNextCtrl(Button button) {
        this.nextCtrl = button;
    }

    public final Button getFmSensAddCtrl() {
        return this.fmSensAddCtrl;
    }

    public final void setFmSensAddCtrl(Button button) {
        this.fmSensAddCtrl = button;
    }

    public final Button getFmSensRedCtrl() {
        return this.fmSensRedCtrl;
    }

    public final void setFmSensRedCtrl(Button button) {
        this.fmSensRedCtrl = button;
    }

    public final Button getAmSensAddCtrl() {
        return this.amSensAddCtrl;
    }

    public final void setAmSensAddCtrl(Button button) {
        this.amSensAddCtrl = button;
    }

    public final Button getAmSensRedCtrl() {
        return this.amSensRedCtrl;
    }

    public final void setAmSensRedCtrl(Button button) {
        this.amSensRedCtrl = button;
    }

    public final TextView getPsTv() {
        return this.psTv;
    }

    public final void setPsTv(TextView textView) {
        this.psTv = textView;
    }

    public final TextView getTpTv() {
        return this.tpTv;
    }

    public final void setTpTv(TextView textView) {
        this.tpTv = textView;
    }

    public final TextView getTaTv() {
        return this.taTv;
    }

    public final void setTaTv(TextView textView) {
        this.taTv = textView;
    }

    public final TextView getAfTv() {
        return this.afTv;
    }

    public final void setAfTv(TextView textView) {
        this.afTv = textView;
    }

    public final TextView getRdsTv() {
        return this.rdsTv;
    }

    public final void setRdsTv(TextView textView) {
        this.rdsTv = textView;
    }

    public final TextView getLocTv() {
        return this.locTv;
    }

    public final void setLocTv(TextView textView) {
        this.locTv = textView;
    }

    public final TextView getFreqTv() {
        return this.freqTv;
    }

    public final void setFreqTv(TextView textView) {
        this.freqTv = textView;
    }

    public final TextView getBandNameTv() {
        return this.bandNameTv;
    }

    public final void setBandNameTv(TextView textView) {
        this.bandNameTv = textView;
    }

    public final TextView getFreqUnitTv() {
        return this.freqUnitTv;
    }

    public final void setFreqUnitTv(TextView textView) {
        this.freqUnitTv = textView;
    }

    public final TextView getFmSensitivityTv() {
        return this.fmSensitivityTv;
    }

    public final void setFmSensitivityTv(TextView textView) {
        this.fmSensitivityTv = textView;
    }

    public final TextView getAmSensitivityTv() {
        return this.amSensitivityTv;
    }

    public final void setAmSensitivityTv(TextView textView) {
        this.amSensitivityTv = textView;
    }

    public final Switch getAutoStopSwitcher() {
        return this.autoStopSwitcher;
    }

    public final void setAutoStopSwitcher(Switch r1) {
        this.autoStopSwitcher = r1;
    }

    public final Switch getRdsSwitcher() {
        return this.rdsSwitcher;
    }

    public final void setRdsSwitcher(Switch r1) {
        this.rdsSwitcher = r1;
    }

    public final RadioGroup getAreaGroup() {
        return this.areaGroup;
    }

    public final void setAreaGroup(RadioGroup radioGroup) {
        this.areaGroup = radioGroup;
    }

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public final void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public final NodeAdapter getMAdapter() {
        return this.mAdapter;
    }

    public final void setMAdapter(NodeAdapter nodeAdapter) {
        Intrinsics.checkNotNullParameter(nodeAdapter, "<set-?>");
        this.mAdapter = nodeAdapter;
    }

    /* JADX INFO: renamed from: isFmBand, reason: from getter */
    public final boolean getIsFmBand() {
        return this.isFmBand;
    }

    public final void setFmBand(boolean z) {
        this.isFmBand = z;
    }

    public final Handler getMHandler() {
        return (Handler) this.mHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: channelsChanged$lambda-2, reason: not valid java name */
    public static final void m47channelsChanged$lambda2(TestFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isFmBand) {
            SparseIntArray sparseIntArray = (SparseIntArray) this$0.getRadioModel().getMFmChannels().getValue();
            if (sparseIntArray != null) {
                this$0.updateChannels(sparseIntArray);
            }
        } else {
            SparseIntArray sparseIntArray2 = (SparseIntArray) this$0.getRadioModel().getMAmChannels().getValue();
            if (sparseIntArray2 != null) {
                this$0.updateChannels(sparseIntArray2);
            }
        }
        if (Intrinsics.areEqual(this$0.getRadioModel().getFmChannelsChanged().getValue(), (Object) true)) {
            this$0.getRadioModel().getFmChannelsChanged().postValue(false);
        } else if (Intrinsics.areEqual(this$0.getRadioModel().getAmChannelsChanged().getValue(), (Object) true)) {
            this$0.getRadioModel().getAmChannelsChanged().postValue(false);
        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        addObserver(view);
        addClickListener(view);
        initStationList(view);
    }

    public void onResume() {
        super.onResume();
        AutoManager.Companion.requestInstance().openAppId(1);
    }

    private final void initViews(View view) {
        this.taCtrl = (Button) view.findViewById(R.id.radio_ctr_ta);
        this.ptyCtrl = (Button) view.findViewById(R.id.radio_ctr_pty);
        this.afCtrl = (Button) view.findViewById(R.id.radio_ctr_af);
        this.prevCtrl = (Button) view.findViewById(R.id.radio_ctr_prev);
        this.nextCtrl = (Button) view.findViewById(R.id.radio_ctr_next);
        this.fmSensAddCtrl = (Button) view.findViewById(R.id.radio_fm_sensity_add);
        this.fmSensRedCtrl = (Button) view.findViewById(R.id.radio_fm_sensity_red);
        this.amSensAddCtrl = (Button) view.findViewById(R.id.radio_am_sensity_add);
        this.amSensRedCtrl = (Button) view.findViewById(R.id.radio_am_sensity_red);
        this.areaGroup = (RadioGroup) view.findViewById(R.id.radio_area_group);
        this.tpTv = (TextView) view.findViewById(R.id.radio_curr_tp);
        this.psTv = (TextView) view.findViewById(R.id.radio_curr_ps);
        this.taTv = (TextView) view.findViewById(R.id.radio_curr_ta);
        this.afTv = (TextView) view.findViewById(R.id.radio_curr_af);
        this.rdsTv = (TextView) view.findViewById(R.id.radio_curr_rds);
        this.locTv = (TextView) view.findViewById(R.id.radio_curr_loc);
        this.freqTv = (TextView) view.findViewById(R.id.radio_curr_freq);
        this.bandNameTv = (TextView) view.findViewById(R.id.radio_curr_band);
        this.freqUnitTv = (TextView) view.findViewById(R.id.radio_curr_unit);
        this.fmSensitivityTv = (TextView) view.findViewById(R.id.radio_fm_sensity);
        this.amSensitivityTv = (TextView) view.findViewById(R.id.radio_am_sensity);
        this.autoStopSwitcher = (Switch) view.findViewById(R.id.radio_ctr_auto_stop);
        this.rdsSwitcher = (Switch) view.findViewById(R.id.radio_ctr_rds_enable);
    }

    private final void addObserver(View view) {
        RadioModel radioModel = getRadioModel();
        radioModel.getMFreq().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda13
            public final void onChanged(Object obj) {
                TestFragment.m41addObserver$lambda21$lambda4(this.f$0, (Integer) obj);
            }
        });
        radioModel.getMBand().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda21
            public final void onChanged(Object obj) {
                TestFragment.m42addObserver$lambda21$lambda5(this.f$0, (Integer) obj);
            }
        });
        radioModel.getFmSens().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda23
            public final void onChanged(Object obj) {
                TestFragment.m43addObserver$lambda21$lambda6(this.f$0, (Integer) obj);
            }
        });
        radioModel.getAmSens().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda24
            public final void onChanged(Object obj) {
                TestFragment.m44addObserver$lambda21$lambda7(this.f$0, (Integer) obj);
            }
        });
        radioModel.getAutoSens().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda25
            public final void onChanged(Object obj) {
                TestFragment.m45addObserver$lambda21$lambda8(this.f$0, (Boolean) obj);
            }
        });
        radioModel.getRdsEnable().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda26
            public final void onChanged(Object obj) {
                TestFragment.m46addObserver$lambda21$lambda9(this.f$0, (Boolean) obj);
            }
        });
        radioModel.getTaShowing().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda27
            public final void onChanged(Object obj) {
                TestFragment.m30addObserver$lambda21$lambda10(this.f$0, (Boolean) obj);
            }
        });
        radioModel.getAfShowing().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda28
            public final void onChanged(Object obj) {
                TestFragment.m31addObserver$lambda21$lambda11(this.f$0, (Boolean) obj);
            }
        });
        radioModel.getTpShowing().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda29
            public final void onChanged(Object obj) {
                TestFragment.m32addObserver$lambda21$lambda12(this.f$0, (Boolean) obj);
            }
        });
        radioModel.getPsShowing().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda30
            public final void onChanged(Object obj) {
                TestFragment.m33addObserver$lambda21$lambda13(this.f$0, (Boolean) obj);
            }
        });
        radioModel.getPsMsg().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda14
            public final void onChanged(Object obj) {
                TestFragment.m34addObserver$lambda21$lambda14(this.f$0, (String) obj);
            }
        });
        radioModel.getPtyShowing().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda15
            public final void onChanged(Object obj) {
                TestFragment.m35addObserver$lambda21$lambda15(this.f$0, (Boolean) obj);
            }
        });
        radioModel.getPtyMsg().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda16
            public final void onChanged(Object obj) {
                TestFragment.m36addObserver$lambda21$lambda16(this.f$0, (String) obj);
            }
        });
        radioModel.getRdsShowing().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda17
            public final void onChanged(Object obj) {
                TestFragment.m37addObserver$lambda21$lambda17(this.f$0, (Boolean) obj);
            }
        });
        radioModel.getAfShowing().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda18
            public final void onChanged(Object obj) {
                TestFragment.m38addObserver$lambda21$lambda18(this.f$0, (Boolean) obj);
            }
        });
        radioModel.getMLoc().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda19
            public final void onChanged(Object obj) {
                TestFragment.m39addObserver$lambda21$lambda19(this.f$0, (Boolean) obj);
            }
        });
        radioModel.getMArea().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda20
            public final void onChanged(Object obj) {
                TestFragment.m40addObserver$lambda21$lambda20(this.f$0, (Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addObserver$lambda-21$lambda-4, reason: not valid java name */
    public static final void m41addObserver$lambda21$lambda4(TestFragment this$0, Integer freq) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Log.e("Radio", "------------ >> freq : " + freq);
        TextView textView = this$0.freqTv;
        if (textView != null) {
            RadioUtils radioUtils = RadioUtils.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(freq, "freq");
            textView.setText(radioUtils.freq2Text(freq.intValue()));
        }
        TextView textView2 = this$0.bandNameTv;
        if (textView2 != null) {
            RadioUtils radioUtils2 = RadioUtils.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(freq, "freq");
            textView2.setText(radioUtils2.isFmFreq(freq.intValue()) ? "FM" : "AM");
        }
        TextView textView3 = this$0.freqUnitTv;
        if (textView3 == null) {
            return;
        }
        RadioUtils radioUtils3 = RadioUtils.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(freq, "freq");
        textView3.setText(radioUtils3.unitOfFreq(freq.intValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addObserver$lambda-21$lambda-5, reason: not valid java name */
    public static final void m42addObserver$lambda21$lambda5(TestFragment this$0, Integer band) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RadioUtils radioUtils = RadioUtils.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(band, "band");
        this$0.isFmBand = radioUtils.isFm(band.intValue());
        this$0.getMHandler().removeCallbacks(this$0.channelsChanged);
        this$0.getMHandler().postDelayed(this$0.channelsChanged, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addObserver$lambda-21$lambda-6, reason: not valid java name */
    public static final void m43addObserver$lambda21$lambda6(TestFragment this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.fmSensitivityTv;
        if (textView == null) {
            return;
        }
        textView.setText(String.valueOf(num));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addObserver$lambda-21$lambda-7, reason: not valid java name */
    public static final void m44addObserver$lambda21$lambda7(TestFragment this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.amSensitivityTv;
        if (textView == null) {
            return;
        }
        textView.setText(String.valueOf(num));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addObserver$lambda-21$lambda-8, reason: not valid java name */
    public static final void m45addObserver$lambda21$lambda8(TestFragment this$0, Boolean auto) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Switch r0 = this$0.autoStopSwitcher;
        if (r0 != null) {
            Intrinsics.checkNotNullExpressionValue(auto, "auto");
            r0.setChecked(auto.booleanValue());
        }
        Button button = this$0.fmSensAddCtrl;
        if (button != null) {
            button.setEnabled(!auto.booleanValue());
        }
        Button button2 = this$0.fmSensRedCtrl;
        if (button2 != null) {
            button2.setEnabled(!auto.booleanValue());
        }
        Button button3 = this$0.amSensAddCtrl;
        if (button3 != null) {
            button3.setEnabled(!auto.booleanValue());
        }
        Button button4 = this$0.amSensRedCtrl;
        if (button4 == null) {
            return;
        }
        button4.setEnabled(!auto.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addObserver$lambda-21$lambda-9, reason: not valid java name */
    public static final void m46addObserver$lambda21$lambda9(TestFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Switch r1 = this$0.rdsSwitcher;
        if (r1 == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        r1.setChecked(it.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addObserver$lambda-21$lambda-10, reason: not valid java name */
    public static final void m30addObserver$lambda21$lambda10(TestFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.taTv;
        if (textView == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        textView.setEnabled(it.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addObserver$lambda-21$lambda-11, reason: not valid java name */
    public static final void m31addObserver$lambda21$lambda11(TestFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.afTv;
        if (textView == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        textView.setEnabled(it.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addObserver$lambda-21$lambda-12, reason: not valid java name */
    public static final void m32addObserver$lambda21$lambda12(TestFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.tpTv;
        if (textView == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        textView.setEnabled(it.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addObserver$lambda-21$lambda-13, reason: not valid java name */
    public static final void m33addObserver$lambda21$lambda13(TestFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.psTv;
        if (textView == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        textView.setEnabled(it.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addObserver$lambda-21$lambda-14, reason: not valid java name */
    public static final void m34addObserver$lambda21$lambda14(TestFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.psTv;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addObserver$lambda-21$lambda-15, reason: not valid java name */
    public static final void m35addObserver$lambda21$lambda15(TestFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Button button = this$0.ptyCtrl;
        if (button != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            button.setEnabled(it.booleanValue());
        }
        Button button2 = this$0.afCtrl;
        if (button2 == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        button2.setEnabled(it.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addObserver$lambda-21$lambda-16, reason: not valid java name */
    public static final void m36addObserver$lambda21$lambda16(TestFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Button button = this$0.ptyCtrl;
        if (button == null) {
            return;
        }
        button.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addObserver$lambda-21$lambda-17, reason: not valid java name */
    public static final void m37addObserver$lambda21$lambda17(TestFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.rdsTv;
        if (textView != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            textView.setEnabled(it.booleanValue());
        }
        Button button = this$0.taCtrl;
        if (button == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        button.setEnabled(it.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addObserver$lambda-21$lambda-18, reason: not valid java name */
    public static final void m38addObserver$lambda21$lambda18(TestFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.afTv;
        if (textView == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        textView.setEnabled(it.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addObserver$lambda-21$lambda-19, reason: not valid java name */
    public static final void m39addObserver$lambda21$lambda19(TestFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.locTv;
        if (textView == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        textView.setEnabled(it.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addObserver$lambda-21$lambda-20, reason: not valid java name */
    public static final void m40addObserver$lambda21$lambda20(TestFragment this$0, Integer num) {
        int i;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Log.e("radio", "010101 ---------------->>> area:: " + num);
        if (num != null && num.intValue() == 0) {
            i = R.id.radio_area_usa;
        } else if (num != null && num.intValue() == 4) {
            i = R.id.radio_area_japan;
        } else if (num != null && num.intValue() == 1) {
            i = R.id.radio_area_latin;
        } else {
            i = (num != null && num.intValue() == 3) ? R.id.radio_area_russia : R.id.radio_area_china;
        }
        RadioGroup radioGroup = this$0.areaGroup;
        if (radioGroup != null) {
            radioGroup.check(i);
        }
    }

    private final void addClickListener(View view) {
        ((Button) view.findViewById(R.id.radio_ctr_scan)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda31
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TestFragment.m12addClickListener$lambda22(this.f$0, view2);
            }
        });
        ((Button) view.findViewById(R.id.radio_ctr_band)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TestFragment.m13addClickListener$lambda23(this.f$0, view2);
            }
        });
        ((Button) view.findViewById(R.id.radio_ctr_loc)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TestFragment.m14addClickListener$lambda24(this.f$0, view2);
            }
        });
        ((Button) view.findViewById(R.id.radio_ctr_st)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TestFragment.m15addClickListener$lambda25(this.f$0, view2);
            }
        });
        Button button = this.taCtrl;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TestFragment.m16addClickListener$lambda26(this.f$0, view2);
                }
            });
        }
        ((Button) view.findViewById(R.id.radio_ctr_save)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TestFragment.m17addClickListener$lambda27(this.f$0, view2);
            }
        });
        Button button2 = this.prevCtrl;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TestFragment.m18addClickListener$lambda28(this.f$0, view2);
                }
            });
        }
        Button button3 = this.prevCtrl;
        if (button3 != null) {
            button3.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda9
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    return TestFragment.m19addClickListener$lambda29(this.f$0, view2);
                }
            });
        }
        Button button4 = this.nextCtrl;
        if (button4 != null) {
            button4.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda10
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    return TestFragment.m20addClickListener$lambda30(this.f$0, view2);
                }
            });
        }
        Button button5 = this.nextCtrl;
        if (button5 != null) {
            button5.setOnClickListener(new View.OnClickListener() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TestFragment.m21addClickListener$lambda31(this.f$0, view2);
                }
            });
        }
        Switch r3 = this.rdsSwitcher;
        if (r3 != null) {
            r3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda32
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    TestFragment.m22addClickListener$lambda32(this.f$0, compoundButton, z);
                }
            });
        }
        Switch r4 = this.autoStopSwitcher;
        if (r4 != null) {
            r4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda33
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    TestFragment.m23addClickListener$lambda33(this.f$0, compoundButton, z);
                }
            });
        }
        Button button6 = this.fmSensAddCtrl;
        if (button6 != null) {
            button6.setOnClickListener(new View.OnClickListener() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda34
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TestFragment.m24addClickListener$lambda34(this.f$0, view2);
                }
            });
        }
        Button button7 = this.fmSensRedCtrl;
        if (button7 != null) {
            button7.setOnClickListener(new View.OnClickListener() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda35
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TestFragment.m25addClickListener$lambda35(this.f$0, view2);
                }
            });
        }
        Button button8 = this.amSensAddCtrl;
        if (button8 != null) {
            button8.setOnClickListener(new View.OnClickListener() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda36
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TestFragment.m26addClickListener$lambda36(this.f$0, view2);
                }
            });
        }
        Button button9 = this.amSensRedCtrl;
        if (button9 != null) {
            button9.setOnClickListener(new View.OnClickListener() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda37
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TestFragment.m27addClickListener$lambda37(this.f$0, view2);
                }
            });
        }
        RadioGroup radioGroup = this.areaGroup;
        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda1
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup2, int i) {
                    TestFragment.m28addClickListener$lambda38(this.f$0, radioGroup2, i);
                }
            });
        }
        Button button10 = this.ptyCtrl;
        if (button10 != null) {
            button10.setOnClickListener(new View.OnClickListener() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TestFragment.m29addClickListener$lambda39(this.f$0, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-22, reason: not valid java name */
    public static final void m12addClickListener$lambda22(TestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RadioController radioController = this$0.getRadioController();
        if (radioController != null) {
            radioController.scanStation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-23, reason: not valid java name */
    public static final void m13addClickListener$lambda23(TestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RadioController radioController = this$0.getRadioController();
        if (radioController != null) {
            radioController.band();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-24, reason: not valid java name */
    public static final void m14addClickListener$lambda24(TestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RadioController radioController = this$0.getRadioController();
        if (radioController != null) {
            radioController.local(!Intrinsics.areEqual(this$0.getRadioModel().getMLoc().getValue(), (Object) true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-25, reason: not valid java name */
    public static final void m15addClickListener$lambda25(TestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RadioController radioController = this$0.getRadioController();
        if (radioController != null) {
            Integer num = (Integer) this$0.getRadioModel().getMStereo().getValue();
            radioController.stereo(num == null || num.intValue() != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-26, reason: not valid java name */
    public static final void m16addClickListener$lambda26(TestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RadioController radioController = this$0.getRadioController();
        if (radioController != null) {
            radioController.rdsTaEanble(!Intrinsics.areEqual(this$0.getRadioModel().getRdsTaEnable().getValue(), (Object) true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-27, reason: not valid java name */
    public static final void m17addClickListener$lambda27(TestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RadioController radioController = this$0.getRadioController();
        if (radioController != null) {
            radioController.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-28, reason: not valid java name */
    public static final void m18addClickListener$lambda28(TestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RadioController radioController = this$0.getRadioController();
        if (radioController != null) {
            radioController.prevStation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-29, reason: not valid java name */
    public static final boolean m19addClickListener$lambda29(TestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RadioController radioController = this$0.getRadioController();
        if (radioController == null) {
            return true;
        }
        radioController.seekPrevStation();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-30, reason: not valid java name */
    public static final boolean m20addClickListener$lambda30(TestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RadioController radioController = this$0.getRadioController();
        if (radioController == null) {
            return true;
        }
        radioController.seekNextStation();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-31, reason: not valid java name */
    public static final void m21addClickListener$lambda31(TestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RadioController radioController = this$0.getRadioController();
        if (radioController != null) {
            radioController.nextStation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-32, reason: not valid java name */
    public static final void m22addClickListener$lambda32(TestFragment this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RadioController radioController = this$0.getRadioController();
        if (radioController != null) {
            radioController.rdsEnable(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-33, reason: not valid java name */
    public static final void m23addClickListener$lambda33(TestFragment this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RadioController radioController = this$0.getRadioController();
        if (radioController != null) {
            radioController.adaptiveSensitivity(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-34, reason: not valid java name */
    public static final void m24addClickListener$lambda34(TestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RadioController radioController = this$0.getRadioController();
        if (radioController != null) {
            radioController.configFmSensitivity(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-35, reason: not valid java name */
    public static final void m25addClickListener$lambda35(TestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RadioController radioController = this$0.getRadioController();
        if (radioController != null) {
            radioController.configFmSensitivity(-2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-36, reason: not valid java name */
    public static final void m26addClickListener$lambda36(TestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RadioController radioController = this$0.getRadioController();
        if (radioController != null) {
            radioController.configAmSensitivity(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-37, reason: not valid java name */
    public static final void m27addClickListener$lambda37(TestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RadioController radioController = this$0.getRadioController();
        if (radioController != null) {
            radioController.configAmSensitivity(-2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-38, reason: not valid java name */
    public static final void m28addClickListener$lambda38(TestFragment this$0, RadioGroup radioGroup, int i) {
        int i2;
        RadioController radioController;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i == R.id.radio_area_usa) {
            i2 = 0;
        } else if (i == R.id.radio_area_japan) {
            i2 = 4;
        } else if (i == R.id.radio_area_latin) {
            i2 = 1;
        } else {
            i2 = i == R.id.radio_area_russia ? 3 : 2;
        }
        Log.e("radio", "1010 ---------------->>> area:: " + i2 + "   " + this$0.getRadioModel().getMArea().getValue());
        Integer num = (Integer) this$0.getRadioModel().getMArea().getValue();
        if ((num != null && num.intValue() == i2) || (radioController = this$0.getRadioController()) == null) {
            return;
        }
        radioController.selectArea(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-39, reason: not valid java name */
    public static final void m29addClickListener$lambda39(TestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PtySelectFragment.Companion.getMe().show(this$0.getParentFragmentManager(), "pty_dialog");
    }

    public final void initStationList(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        RecyclerView recyclerViewFindViewById = view.findViewById(R.id.radio_station_list);
        this.recyclerView = recyclerViewFindViewById;
        if (recyclerViewFindViewById != null) {
            recyclerViewFindViewById.setLayoutManager(new GridLayoutManager(view.getContext(), 3));
            recyclerViewFindViewById.setAdapter(this.mAdapter);
            recyclerViewFindViewById.addItemDecoration(new SimpleItemDecoration(4, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 30, (DefaultConstructorMarker) null));
            recyclerViewFindViewById.setItemAnimator(new DefaultItemAnimator());
            recyclerViewFindViewById.setTag(this);
        }
        RadioModel radioModel = getRadioModel();
        radioModel.getFmChannelsChanged().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda11
            public final void onChanged(Object obj) {
                TestFragment.m48initStationList$lambda43$lambda41(this.f$0, (Boolean) obj);
            }
        });
        radioModel.getAmChannelsChanged().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.radio.fragment.TestFragment$$ExternalSyntheticLambda22
            public final void onChanged(Object obj) {
                TestFragment.m49initStationList$lambda43$lambda42(this.f$0, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initStationList$lambda-43$lambda-41, reason: not valid java name */
    public static final void m48initStationList$lambda43$lambda41(TestFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.booleanValue()) {
            this$0.getMHandler().removeCallbacks(this$0.channelsChanged);
            this$0.getMHandler().postDelayed(this$0.channelsChanged, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initStationList$lambda-43$lambda-42, reason: not valid java name */
    public static final void m49initStationList$lambda43$lambda42(TestFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.booleanValue()) {
            this$0.getMHandler().removeCallbacks(this$0.channelsChanged);
            this$0.getMHandler().postDelayed(this$0.channelsChanged, 300L);
        }
    }

    public final void updateChannels(SparseIntArray array) {
        Intrinsics.checkNotNullParameter(array, "array");
        int size = array.size();
        for (int i = 0; i < size; i++) {
            int iKeyAt = array.keyAt(i);
            int iValueAt = array.valueAt(i);
            if (iValueAt > 0) {
                int iIndexUi2Local = RadioUtils.INSTANCE.indexUi2Local(iKeyAt);
                int i2 = 65536;
                if (iKeyAt >= 65536 && iKeyAt <= 131072) {
                    i2 = 65536 + (iIndexUi2Local / 6);
                } else if (iKeyAt >= 0 && iKeyAt <= 65536) {
                    i2 = (iIndexUi2Local / 6) + 0;
                }
                Station station = new Station(iIndexUi2Local, iKeyAt, iValueAt, i2);
                Log.e("radio", "----------------------------------->> index: " + iIndexUi2Local + "  freq: " + iValueAt + "  ---- " + station);
                if (this.mChannels.contains(station)) {
                    int iIndexOf = this.mChannels.indexOf(station);
                    this.mChannels.remove(iIndexOf);
                    this.mChannels.add(iIndexOf, station);
                } else {
                    this.mChannels.add(station);
                }
            }
            this.mAdapter.getMData().replaceWithoutNotify(Node.Companion.createNodesWithAdapter(this.mChannels, StationItem.class, this.mAdapter));
            Log.e("radio", "------------->>>  mChannels size: " + this.mChannels.size() + "   array size: " + array.size());
        }
    }
}
