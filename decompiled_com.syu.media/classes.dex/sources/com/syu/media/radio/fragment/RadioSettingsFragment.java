package com.syu.media.radio.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import chip.FinalChip;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.syu.manger.module.radio.RadioController;
import com.syu.manger.module.radio.RadioModel;
import com.syu.media.ConstantsKt;
import com.syu.media.R;
import com.syu.media.companion.ext.ViewExtKt;
import com.syu.media.companion.keyboard.SoftKeyBoardListener;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.companion.utils.SharedPrefUtils;
import com.syu.media.companion.view.fons.FaceMyingheiButton;
import com.syu.media.companion.view.fons.FaceMyingheiTextView;
import com.syu.media.databinding.RadioSettingsFragmentBinding;
import com.syu.media.online.viewmodel.OnlineViewModel;
import com.syu.media.radio.dialog.CitySelectorDialogFrag;
import com.syu.media.radio.dialog.EditorDialog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: RadioSettingsFragment.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0002J\b\u0010'\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020%H\u0016J\b\u0010)\u001a\u00020%H\u0016J\u0010\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020%H\u0016J\u000e\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u00020\rR?\u0010\u0004\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0012\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u00050\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u000b\u001a\u0004\b!\u0010\"¨\u00061"}, d2 = {"Lcom/syu/media/radio/fragment/RadioSettingsFragment;", "Lcom/syu/media/radio/fragment/RadioBaseFragment;", "Lcom/syu/media/databinding/RadioSettingsFragmentBinding;", "()V", "areaSelectArrays", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "kotlin.jvm.PlatformType", "getAreaSelectArrays", "()[Ljava/lang/String;", "areaSelectArrays$delegate", "Lkotlin/Lazy;", "bk", "Landroid/graphics/drawable/Drawable;", "cityName", "datas", FinalChip.BSP_PLATFORM_Null, "mAmSense", FinalChip.BSP_PLATFORM_Null, "getMAmSense", "()I", "setMAmSense", "(I)V", "mArea", "getMArea", "setMArea", "mFmSense", "getMFmSense", "setMFmSense", "onCheckedChanged", "Landroid/widget/RadioGroup$OnCheckedChangeListener;", "onlineModel", "Lcom/syu/media/online/viewmodel/OnlineViewModel;", "getOnlineModel", "()Lcom/syu/media/online/viewmodel/OnlineViewModel;", "onlineModel$delegate", "addClickListener", FinalChip.BSP_PLATFORM_Null, "channleEdit", "findFileName", "initData", "initObserve", "initView", "view", "Landroid/view/View;", "onResumed", "setBlurBk", "b", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RadioSettingsFragment extends RadioBaseFragment<RadioSettingsFragmentBinding> {
    public static final String TAG = "RadioSettingsFragment";

    /* JADX INFO: renamed from: areaSelectArrays$delegate, reason: from kotlin metadata */
    private final Lazy areaSelectArrays;
    private Drawable bk;
    private String cityName;
    private final List<String> datas;
    private int mAmSense;
    private int mArea;
    private int mFmSense;
    private final RadioGroup.OnCheckedChangeListener onCheckedChanged;

    /* JADX INFO: renamed from: onlineModel$delegate, reason: from kotlin metadata */
    private final Lazy onlineModel;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ RadioSettingsFragmentBinding access$getBinding(RadioSettingsFragment radioSettingsFragment) {
        return (RadioSettingsFragmentBinding) radioSettingsFragment.getBinding();
    }

    public RadioSettingsFragment() {
        super(R.layout.radio_settings_fragment);
        this.datas = new ArrayList();
        this.areaSelectArrays = LazyKt.lazy(new Function0<String[]>() { // from class: com.syu.media.radio.fragment.RadioSettingsFragment$areaSelectArrays$2
            {
                super(0);
            }

            public final String[] invoke() {
                return this.this$0.getResources().getStringArray(R.array.radio_area_select_arrays);
            }
        });
        this.mArea = -1;
        this.mAmSense = -1;
        this.mFmSense = -1;
        this.cityName = FinalChip.BSP_PLATFORM_Null;
        this.onlineModel = LazyKt.lazy(new Function0<OnlineViewModel>() { // from class: com.syu.media.radio.fragment.RadioSettingsFragment$onlineModel$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final OnlineViewModel m309invoke() {
                return this.this$0.getApp().getOnlineModel();
            }
        });
        this.onCheckedChanged = new RadioGroup.OnCheckedChangeListener() { // from class: com.syu.media.radio.fragment.RadioSettingsFragment$$ExternalSyntheticLambda0
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioSettingsFragment.m304onCheckedChanged$lambda0(this.f$0, radioGroup, i);
            }
        };
    }

    public final String[] getAreaSelectArrays() {
        return (String[]) this.areaSelectArrays.getValue();
    }

    public final int getMArea() {
        return this.mArea;
    }

    public final void setMArea(int i) {
        this.mArea = i;
    }

    public final int getMAmSense() {
        return this.mAmSense;
    }

    public final void setMAmSense(int i) {
        this.mAmSense = i;
    }

    public final int getMFmSense() {
        return this.mFmSense;
    }

    public final void setMFmSense(int i) {
        this.mFmSense = i;
    }

    public final OnlineViewModel getOnlineModel() {
        return (OnlineViewModel) this.onlineModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onCheckedChanged$lambda-0, reason: not valid java name */
    public static final void m304onCheckedChanged$lambda0(RadioSettingsFragment radioSettingsFragment, RadioGroup radioGroup, int i) {
        int i2;
        RadioController radioController;
        Intrinsics.checkNotNullParameter(radioSettingsFragment, "this$0");
        if (i == R.id.radio_area_usa) {
            i2 = 0;
        } else if (i == R.id.radio_area_japan) {
            i2 = 4;
        } else if (i == R.id.radio_area_latin) {
            i2 = 1;
        } else {
            i2 = i == R.id.radio_area_russia ? 3 : 2;
        }
        Integer value = radioSettingsFragment.getRadioModel().getMArea().getValue();
        if ((value == null || value.intValue() != i2) && (radioController = radioSettingsFragment.getRadioController()) != null) {
            radioController.selectArea(i2);
        }
        HiLog.INSTANCE.d(TAG, "1010 ---------------->>> area::   " + radioSettingsFragment.getRadioModel().getMArea().getValue() + " >>>> " + i2);
    }

    @Override // com.syu.media.base.DataBindBaseFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Drawable drawable = this.bk;
        if (drawable != null) {
            setBlurBk(drawable);
        }
        addClickListener();
    }

    @Override // com.syu.media.base.DataBindBaseFragment
    public void initData() {
        String string = getResources().getString(R.string.radio_city_name);
        SharedPrefUtils sharedPrefUtils = SharedPrefUtils.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        String str = (String) sharedPrefUtils.getParam(contextRequireContext, ConstantsKt.RADIO_CITY_NAME, string);
        HiLog.INSTANCE.d(TAG, "RADIO_CITY_NAME:" + str);
        getOnlineModel().getRadioCityName().setValue(str);
    }

    /* JADX INFO: renamed from: com.syu.media.radio.fragment.RadioSettingsFragment$onResumed$1, reason: invalid class name */
    /* JADX INFO: compiled from: RadioSettingsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.radio.fragment.RadioSettingsFragment$onResumed$1", f = "RadioSettingsFragment.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RadioSettingsFragment.this.new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                RadioSettingsFragment.this.findFileName();
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new C00251(RadioSettingsFragment.this, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.syu.media.radio.fragment.RadioSettingsFragment$onResumed$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: RadioSettingsFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.radio.fragment.RadioSettingsFragment$onResumed$1$1", f = "RadioSettingsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ RadioSettingsFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00251(RadioSettingsFragment radioSettingsFragment, Continuation<? super C00251> continuation) {
                super(2, continuation);
                this.this$0 = radioSettingsFragment;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00251(this.this$0, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ConstraintLayout constraintLayout = RadioSettingsFragment.access$getBinding(this.this$0).radioRadioCityLayout;
                if (constraintLayout != null) {
                    RadioSettingsFragment radioSettingsFragment = this.this$0;
                    constraintLayout.setVisibility(radioSettingsFragment.toVisible2(!radioSettingsFragment.datas.isEmpty()));
                }
                if (this.this$0.datas.isEmpty()) {
                    RadioSettingsFragment radioSettingsFragment2 = this.this$0;
                    String string = radioSettingsFragment2.getResources().getString(R.string.radio_city_name);
                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.radio_city_name)");
                    radioSettingsFragment2.saveData(ConstantsKt.RADIO_CITY_NAME, string);
                }
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.syu.media.base.BaseFragment
    public void onResumed() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(null), 2, (Object) null);
    }

    @Override // com.syu.media.base.DataBindBaseFragment
    public void initObserve() {
        RadioModel radioModel = getRadioModel();
        radioModel.getFmSens().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioSettingsFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioSettingsFragment.m298initObserve$lambda8$lambda3(this.f$0, (Integer) obj);
            }
        });
        radioModel.getAmSens().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioSettingsFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioSettingsFragment.m299initObserve$lambda8$lambda4(this.f$0, (Integer) obj);
            }
        });
        radioModel.getAutoSens().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioSettingsFragment$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioSettingsFragment.m300initObserve$lambda8$lambda5(this.f$0, (Boolean) obj);
            }
        });
        radioModel.getRdsEnable().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioSettingsFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioSettingsFragment.m301initObserve$lambda8$lambda6(this.f$0, (Boolean) obj);
            }
        });
        radioModel.getMArea().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioSettingsFragment$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioSettingsFragment.m302initObserve$lambda8$lambda7(this.f$0, (Integer) obj);
            }
        });
        getOnlineModel().getRadioCityName().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.fragment.RadioSettingsFragment$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioSettingsFragment.m303initObserve$lambda9(this.f$0, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: initObserve$lambda-8$lambda-3, reason: not valid java name */
    public static final void m298initObserve$lambda8$lambda3(RadioSettingsFragment radioSettingsFragment, Integer num) {
        Intrinsics.checkNotNullParameter(radioSettingsFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(num, "sens");
        radioSettingsFragment.mFmSense = num.intValue();
        ((RadioSettingsFragmentBinding) radioSettingsFragment.getBinding()).radioFmSensity.setText(String.valueOf(radioSettingsFragment.mFmSense));
        Log.d("LZP", "fm sens: " + num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: initObserve$lambda-8$lambda-4, reason: not valid java name */
    public static final void m299initObserve$lambda8$lambda4(RadioSettingsFragment radioSettingsFragment, Integer num) {
        Intrinsics.checkNotNullParameter(radioSettingsFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(num, "sens");
        radioSettingsFragment.mAmSense = num.intValue();
        ((RadioSettingsFragmentBinding) radioSettingsFragment.getBinding()).radioAmSensity.setText(String.valueOf(radioSettingsFragment.mAmSense));
        Log.d("LZP", "am sens: " + num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: initObserve$lambda-8$lambda-5, reason: not valid java name */
    public static final void m300initObserve$lambda8$lambda5(RadioSettingsFragment radioSettingsFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(radioSettingsFragment, "this$0");
        SwitchCompat switchCompat = ((RadioSettingsFragmentBinding) radioSettingsFragment.getBinding()).radioSettingsAutoStop;
        Intrinsics.checkNotNullExpressionValue(bool, "auto");
        switchCompat.setChecked(bool.booleanValue());
        ((RadioSettingsFragmentBinding) radioSettingsFragment.getBinding()).fmSensitivityLayout.setVisibility(radioSettingsFragment.toVisible2(!bool.booleanValue()));
        ((RadioSettingsFragmentBinding) radioSettingsFragment.getBinding()).amSensitivityLayout.setVisibility(radioSettingsFragment.toVisible2(!bool.booleanValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: initObserve$lambda-8$lambda-6, reason: not valid java name */
    public static final void m301initObserve$lambda8$lambda6(RadioSettingsFragment radioSettingsFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(radioSettingsFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "rdsEnable:" + bool);
        SwitchCompat switchCompat = ((RadioSettingsFragmentBinding) radioSettingsFragment.getBinding()).radioSettingsRdsEnable;
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        switchCompat.setChecked(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: initObserve$lambda-8$lambda-7, reason: not valid java name */
    public static final void m302initObserve$lambda8$lambda7(RadioSettingsFragment radioSettingsFragment, Integer num) {
        Intrinsics.checkNotNullParameter(radioSettingsFragment, "this$0");
        FaceMyingheiTextView faceMyingheiTextView = ((RadioSettingsFragmentBinding) radioSettingsFragment.getBinding()).radioSettingsAreaSelect;
        String[] areaSelectArrays = radioSettingsFragment.getAreaSelectArrays();
        Intrinsics.checkNotNullExpressionValue(num, "it");
        faceMyingheiTextView.setText(areaSelectArrays[num.intValue()]);
        HiLog.INSTANCE.d(TAG, "mArea observe:" + num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: initObserve$lambda-9, reason: not valid java name */
    public static final void m303initObserve$lambda9(RadioSettingsFragment radioSettingsFragment, String str) {
        Intrinsics.checkNotNullParameter(radioSettingsFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "onlineModel countryName:" + str);
        if (Intrinsics.areEqual(radioSettingsFragment.cityName, str)) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(str, "it");
        radioSettingsFragment.cityName = str;
        FaceMyingheiButton faceMyingheiButton = ((RadioSettingsFragmentBinding) radioSettingsFragment.getBinding()).radioSettingsCitySelect;
        if (faceMyingheiButton != null) {
            faceMyingheiButton.setText(str);
        }
        radioSettingsFragment.saveData(ConstantsKt.RADIO_CITY_NAME, str);
        radioSettingsFragment.getApp().getRadioIconCache().coverSave(str);
    }

    public final void setBlurBk(Drawable b) {
        Intrinsics.checkNotNullParameter(b, "b");
        if (isAdded()) {
            bkChanged(R.id.radio_settings_frag_blur_img, b);
        } else {
            this.bk = b;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void addClickListener() {
        ((RadioSettingsFragmentBinding) getBinding()).radioSettingsRdsEnable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.syu.media.radio.fragment.RadioSettingsFragment$$ExternalSyntheticLambda8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                RadioSettingsFragment.m294addClickListener$lambda10(this.f$0, compoundButton, z);
            }
        });
        ((RadioSettingsFragmentBinding) getBinding()).radioSettingsAutoStop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.syu.media.radio.fragment.RadioSettingsFragment$$ExternalSyntheticLambda9
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                RadioSettingsFragment.m295addClickListener$lambda11(this.f$0, compoundButton, z);
            }
        });
        FaceMyingheiButton faceMyingheiButton = ((RadioSettingsFragmentBinding) getBinding()).radioReset;
        Intrinsics.checkNotNullExpressionValue(faceMyingheiButton, "binding.radioReset");
        ViewExtKt.onClick$default(faceMyingheiButton, 0L, new Function1<View, Unit>() { // from class: com.syu.media.radio.fragment.RadioSettingsFragment.addClickListener.3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(View view) {
                Intrinsics.checkNotNullParameter(view, "it");
                RadioSettingsFragment.this.getApp().getMusicModel().getRadioReset().setValue(true);
                RadioController radioController = RadioSettingsFragment.this.getRadioController();
                if (radioController != null) {
                    radioController.mo73default();
                }
            }
        }, 1, null);
        SoftKeyBoardListener.setListener(requireMainAct(), new SoftKeyBoardListener.OnSoftKeyBoardChangeListener() { // from class: com.syu.media.radio.fragment.RadioSettingsFragment.addClickListener.4
            @Override // com.syu.media.companion.keyboard.SoftKeyBoardListener.OnSoftKeyBoardChangeListener
            public void keyBoardShow(int height) {
                Log.d(RadioSettingsFragment.TAG, "keyBoardShow..." + height);
            }

            @Override // com.syu.media.companion.keyboard.SoftKeyBoardListener.OnSoftKeyBoardChangeListener
            public void keyBoardHide(int height) {
                Log.d(RadioSettingsFragment.TAG, "keyBoardHide..." + height);
                RadioSettingsFragment.access$getBinding(RadioSettingsFragment.this).radioAmSensity.clearFocus();
                RadioSettingsFragment.access$getBinding(RadioSettingsFragment.this).radioFmSensity.clearFocus();
                RadioSettingsFragment.access$getBinding(RadioSettingsFragment.this).radioAmSensity.setText(String.valueOf(RadioSettingsFragment.this.getMAmSense()));
                RadioSettingsFragment.access$getBinding(RadioSettingsFragment.this).radioFmSensity.setText(String.valueOf(RadioSettingsFragment.this.getMFmSense()));
            }
        });
        ((RadioSettingsFragmentBinding) getBinding()).radioAmSensity.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.syu.media.radio.fragment.RadioSettingsFragment$$ExternalSyntheticLambda10
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return RadioSettingsFragment.m296addClickListener$lambda13(this.f$0, textView, Integer.valueOf(i), keyEvent);
            }
        });
        ((RadioSettingsFragmentBinding) getBinding()).radioFmSensity.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.syu.media.radio.fragment.RadioSettingsFragment$$ExternalSyntheticLambda1
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return RadioSettingsFragment.m297addClickListener$lambda15(this.f$0, textView, Integer.valueOf(i), keyEvent);
            }
        });
        Button button = ((RadioSettingsFragmentBinding) getBinding()).radioSettingsRadioEditor;
        Intrinsics.checkNotNullExpressionValue(button, "binding.radioSettingsRadioEditor");
        ViewExtKt.onClick$default(button, 0L, new Function1<View, Unit>() { // from class: com.syu.media.radio.fragment.RadioSettingsFragment.addClickListener.7
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(View view) {
                Intrinsics.checkNotNullParameter(view, "it");
                RadioSettingsFragment.this.channleEdit();
            }
        }, 1, null);
        FaceMyingheiButton faceMyingheiButton2 = ((RadioSettingsFragmentBinding) getBinding()).radioSettingsCitySelect;
        if (faceMyingheiButton2 != null) {
            ViewExtKt.onClick$default(faceMyingheiButton2, 0L, new Function1<View, Unit>() { // from class: com.syu.media.radio.fragment.RadioSettingsFragment.addClickListener.8
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((View) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(View view) {
                    Intrinsics.checkNotNullParameter(view, "it");
                    HiLog.INSTANCE.d(RadioSettingsFragment.TAG, "datas:" + RadioSettingsFragment.this.datas.size());
                    CitySelectorDialogFrag citySelectorDialogFrag = new CitySelectorDialogFrag(RadioSettingsFragment.this.datas);
                    FragmentManager parentFragmentManager = RadioSettingsFragment.this.getParentFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    citySelectorDialogFrag.show(parentFragmentManager);
                }
            }, 1, null);
        }
        FaceMyingheiTextView faceMyingheiTextView = ((RadioSettingsFragmentBinding) getBinding()).radioSettingsAreaSelect;
        Intrinsics.checkNotNullExpressionValue(faceMyingheiTextView, "binding.radioSettingsAreaSelect");
        ViewExtKt.onClick$default(faceMyingheiTextView, 0L, new AnonymousClass9(), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-10, reason: not valid java name */
    public static final void m294addClickListener$lambda10(RadioSettingsFragment radioSettingsFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(radioSettingsFragment, "this$0");
        HiLog.INSTANCE.d(TAG, "rdsSwitcher rdsEnable:" + z);
        RadioController radioController = radioSettingsFragment.getRadioController();
        if (radioController != null) {
            radioController.rdsEnable(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-11, reason: not valid java name */
    public static final void m295addClickListener$lambda11(RadioSettingsFragment radioSettingsFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(radioSettingsFragment, "this$0");
        RadioController radioController = radioSettingsFragment.getRadioController();
        if (radioController != null) {
            radioController.adaptiveSensitivity(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: addClickListener$lambda-13, reason: not valid java name */
    public static final boolean m296addClickListener$lambda13(RadioSettingsFragment radioSettingsFragment, TextView textView, Integer num, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(radioSettingsFragment, "this$0");
        Intrinsics.checkNotNullParameter(textView, "textView");
        HiLog.INSTANCE.d(TAG, "amSensitivityTv actionId: " + num);
        if (num != null && num.intValue() == 6) {
            String string = textView.getText().toString();
            if (string.length() > 0) {
                ((RadioSettingsFragmentBinding) radioSettingsFragment.getBinding()).radioAmSensity.clearFocus();
                RadioController radioController = radioSettingsFragment.getRadioController();
                if (radioController != null) {
                    radioController.configAmSensitivity(Integer.parseInt(string));
                }
                Log.d("LZP", "amSensitivityTv..." + string);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: addClickListener$lambda-15, reason: not valid java name */
    public static final boolean m297addClickListener$lambda15(RadioSettingsFragment radioSettingsFragment, TextView textView, Integer num, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(radioSettingsFragment, "this$0");
        Intrinsics.checkNotNullParameter(textView, "textView");
        HiLog.INSTANCE.d(TAG, "fmSensitivityTv actionId..." + num);
        if (num != null && num.intValue() == 6) {
            String string = textView.getText().toString();
            if (string.length() > 0) {
                ((RadioSettingsFragmentBinding) radioSettingsFragment.getBinding()).radioFmSensity.clearFocus();
                RadioController radioController = radioSettingsFragment.getRadioController();
                if (radioController != null) {
                    radioController.configFmSensitivity(Integer.parseInt(string));
                }
                Log.d("LZP", "fmSensitivityTv..." + string);
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: com.syu.media.radio.fragment.RadioSettingsFragment$addClickListener$9, reason: invalid class name */
    /* JADX INFO: compiled from: RadioSettingsFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class AnonymousClass9 extends Lambda implements Function1<View, Unit> {
        AnonymousClass9() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(View view) {
            Intrinsics.checkNotNullParameter(view, "it");
            final Ref.IntRef intRef = new Ref.IntRef();
            Integer value = RadioSettingsFragment.this.getRadioModel().getMArea().getValue();
            Intrinsics.checkNotNull(value);
            intRef.element = value.intValue();
            MaterialAlertDialogBuilder singleChoiceItems = new MaterialAlertDialogBuilder(RadioSettingsFragment.this.requireContext(), R.style.RadioAreaSelectDialog).setTitle(R.string.radio_area_title).setSingleChoiceItems((CharSequence[]) RadioSettingsFragment.this.getAreaSelectArrays(), intRef.element, new DialogInterface.OnClickListener() { // from class: com.syu.media.radio.fragment.RadioSettingsFragment$addClickListener$9$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    RadioSettingsFragment.AnonymousClass9.m306invoke$lambda0(intRef, dialogInterface, i);
                }
            });
            int i = R.string.radio_dialog_txt_editor_ok;
            final RadioSettingsFragment radioSettingsFragment = RadioSettingsFragment.this;
            Window window = singleChoiceItems.setPositiveButton(i, new DialogInterface.OnClickListener() { // from class: com.syu.media.radio.fragment.RadioSettingsFragment$addClickListener$9$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    RadioSettingsFragment.AnonymousClass9.m307invoke$lambda1(intRef, radioSettingsFragment, dialogInterface, i2);
                }
            }).show().getWindow();
            if (window != null) {
                window.setBackgroundDrawableResource(R.drawable.radio_dialog_bk);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invoke$lambda-0, reason: not valid java name */
        public static final void m306invoke$lambda0(Ref.IntRef intRef, DialogInterface dialogInterface, int i) {
            Intrinsics.checkNotNullParameter(intRef, "$select");
            intRef.element = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:13:0x0033 A[PHI: r4
  0x0033: PHI (r4v5 int) = (r4v4 int), (r4v6 int) binds: [B:9:0x002d, B:11:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX INFO: renamed from: invoke$lambda-1, reason: not valid java name */
        public static final void m307invoke$lambda1(Ref.IntRef intRef, RadioSettingsFragment radioSettingsFragment, DialogInterface dialogInterface, int i) {
            int i2;
            RadioController radioController;
            Intrinsics.checkNotNullParameter(intRef, "$select");
            Intrinsics.checkNotNullParameter(radioSettingsFragment, "this$0");
            HiLog.INSTANCE.d(RadioSettingsFragment.TAG, "select:" + intRef.element);
            int i3 = intRef.element;
            if (i3 != 0) {
                i2 = 1;
                if (i3 != 1) {
                    i2 = 2;
                    if (i3 != 2) {
                        int i4 = 3;
                        if (i3 != 3) {
                            i4 = 4;
                            if (i3 == 4) {
                                i2 = i4;
                            }
                        } else {
                            i2 = i4;
                        }
                    }
                }
            } else {
                i2 = 0;
            }
            Integer value = radioSettingsFragment.getRadioModel().getMArea().getValue();
            if ((value != null && value.intValue() == i2) || (radioController = radioSettingsFragment.getRadioController()) == null) {
                return;
            }
            radioController.selectArea(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void findFileName() {
        File[] fileArrListFiles;
        this.datas.clear();
        File file = new File(Environment.getExternalStorageDirectory().getPath(), "radio_logo");
        HiLog.INSTANCE.d(CitySelectorDialogFrag.TAG, "absolutePath:" + file.getAbsolutePath());
        if (!file.exists() || (fileArrListFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                HiLog.INSTANCE.d(CitySelectorDialogFrag.TAG, "fileName:" + file2.getName());
                List<String> list = this.datas;
                String name = file2.getName();
                Intrinsics.checkNotNullExpressionValue(name, "fileName.name");
                list.add(name);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void channleEdit() {
        EditorDialog me = EditorDialog.INSTANCE.getMe();
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        me.show(parentFragmentManager);
    }
}
