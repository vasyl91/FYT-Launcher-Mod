package com.syu.media.radio.fragment;

import android.content.Context;
import androidx.viewbinding.ViewBinding;
import chip.FinalChip;
import com.syu.manger.AutoManager;
import com.syu.manger.module.radio.RadioController;
import com.syu.manger.module.radio.RadioModel;
import com.syu.media.base.DataBindBaseFragment;
import com.syu.media.radio.audio.RadioAudioFocusChange;
import com.syu.radio.dao.RadioDao;
import com.syu.radio.viewmodel.RadioDaoModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RadioBaseFragment.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0005¢\u0006\u0002\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/syu/media/radio/fragment/RadioBaseFragment;", "DB", "Landroidx/viewbinding/ViewBinding;", "Lcom/syu/media/base/DataBindBaseFragment;", "contentLayoutId", FinalChip.BSP_PLATFORM_Null, "(I)V", "()V", "radioAudio", "Lcom/syu/media/radio/audio/RadioAudioFocusChange;", "getRadioAudio", "()Lcom/syu/media/radio/audio/RadioAudioFocusChange;", "radioAudio$delegate", "Lkotlin/Lazy;", "radioController", "Lcom/syu/manger/module/radio/RadioController;", "getRadioController", "()Lcom/syu/manger/module/radio/RadioController;", "radioController$delegate", "radioDao", "Lcom/syu/radio/dao/RadioDao;", "getRadioDao", "()Lcom/syu/radio/dao/RadioDao;", "radioDao$delegate", "radioDaoModel", "Lcom/syu/radio/viewmodel/RadioDaoModel;", "getRadioDaoModel", "()Lcom/syu/radio/viewmodel/RadioDaoModel;", "radioDaoModel$delegate", "radioModel", "Lcom/syu/manger/module/radio/RadioModel;", "getRadioModel", "()Lcom/syu/manger/module/radio/RadioModel;", "radioModel$delegate", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class RadioBaseFragment<DB extends ViewBinding> extends DataBindBaseFragment<DB> {

    /* JADX INFO: renamed from: radioAudio$delegate, reason: from kotlin metadata */
    private final Lazy radioAudio;

    /* JADX INFO: renamed from: radioController$delegate, reason: from kotlin metadata */
    private final Lazy radioController;

    /* JADX INFO: renamed from: radioDao$delegate, reason: from kotlin metadata */
    private final Lazy radioDao;

    /* JADX INFO: renamed from: radioDaoModel$delegate, reason: from kotlin metadata */
    private final Lazy radioDaoModel;

    /* JADX INFO: renamed from: radioModel$delegate, reason: from kotlin metadata */
    private final Lazy radioModel;

    public RadioBaseFragment() {
        this.radioDaoModel = LazyKt.lazy(new Function0<RadioDaoModel>(this) { // from class: com.syu.media.radio.fragment.RadioBaseFragment$radioDaoModel$2
            final /* synthetic */ RadioBaseFragment<DB> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RadioDaoModel m238invoke() {
                return this.this$0.getApp().getRadioDaoModel();
            }
        });
        this.radioDao = LazyKt.lazy(new Function0<RadioDao>(this) { // from class: com.syu.media.radio.fragment.RadioBaseFragment$radioDao$2
            final /* synthetic */ RadioBaseFragment<DB> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RadioDao m237invoke() {
                return this.this$0.getRadioDaoModel().getRadioDao();
            }
        });
        this.radioModel = LazyKt.lazy(new Function0<RadioModel>(this) { // from class: com.syu.media.radio.fragment.RadioBaseFragment$radioModel$2
            final /* synthetic */ RadioBaseFragment<DB> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RadioModel m239invoke() {
                return this.this$0.getApp().getRadioModel();
            }
        });
        this.radioAudio = LazyKt.lazy(new Function0<RadioAudioFocusChange>(this) { // from class: com.syu.media.radio.fragment.RadioBaseFragment$radioAudio$2
            final /* synthetic */ RadioBaseFragment<DB> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RadioAudioFocusChange m235invoke() {
                Context contextRequireContext = this.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                return new RadioAudioFocusChange(contextRequireContext);
            }
        });
        this.radioController = LazyKt.lazy(new Function0<RadioController>() { // from class: com.syu.media.radio.fragment.RadioBaseFragment$radioController$2
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RadioController m236invoke() {
                return AutoManager.INSTANCE.requestInstance().getRadioController();
            }
        });
    }

    public final RadioDaoModel getRadioDaoModel() {
        return (RadioDaoModel) this.radioDaoModel.getValue();
    }

    public final RadioDao getRadioDao() {
        return (RadioDao) this.radioDao.getValue();
    }

    public final RadioModel getRadioModel() {
        return (RadioModel) this.radioModel.getValue();
    }

    public final RadioAudioFocusChange getRadioAudio() {
        return (RadioAudioFocusChange) this.radioAudio.getValue();
    }

    public final RadioController getRadioController() {
        return (RadioController) this.radioController.getValue();
    }

    public RadioBaseFragment(int i) {
        this();
    }
}
