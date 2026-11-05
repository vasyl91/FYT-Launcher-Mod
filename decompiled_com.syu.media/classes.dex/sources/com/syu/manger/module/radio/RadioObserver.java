package com.syu.manger.module.radio;

import android.util.Log;
import android.util.SparseIntArray;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import chip.FinalChip;
import com.fasterxml.aalto.util.XmlConsts;
import com.syu.manger.module.BaseModuleObserver;
import com.syu.media.provider.Media;
import com.syu.remote.Message;
import com.syu.remote.ModuleManager;
import com.syu.utils.Utils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/syu/manger/module/radio/RadioObserver;", "Lcom/syu/manger/module/BaseModuleObserver;", "Lcom/syu/manger/module/radio/RadioModel;", "manager", "Lcom/syu/remote/ModuleManager;", "model", "(Lcom/syu/remote/ModuleManager;Lcom/syu/manger/module/radio/RadioModel;)V", "onReceiver", FinalChip.BSP_PLATFORM_Null, NotificationCompat.CATEGORY_MESSAGE, "Lcom/syu/remote/Message;", "AutoManger_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RadioObserver extends BaseModuleObserver<RadioModel> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadioObserver(ModuleManager moduleManager, final RadioModel radioModel) {
        super(moduleManager, radioModel, 1, 2, 19, 0, 3, 4, 100, 16, 1, 23, 5, 6, 15, 7, 9, 13, 8, 20, 22, 17, 18, 21, 26, 27, 24);
        Intrinsics.checkNotNullParameter(moduleManager, "manager");
        Intrinsics.checkNotNullParameter(radioModel, "model");
        MutableLiveData<Boolean> rdsEnable = radioModel.getRdsEnable();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.syu.manger.module.radio.RadioObserver$1$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code duplicated, block: B:17:0x006f  */
            /* JADX WARN: Code duplicated, block: B:25:0x00a7  */
            /* JADX WARN: Code duplicated, block: B:33:0x00df  */
            /* JADX WARN: Code duplicated, block: B:9:0x0037  */
            public final void invoke(Boolean bool) {
                boolean z;
                boolean z2;
                boolean z3;
                boolean z4;
                MutableLiveData<Boolean> taShowing = radioModel.getTaShowing();
                Intrinsics.checkNotNullExpressionValue(bool, "it");
                if (bool.booleanValue()) {
                    Boolean value = radioModel.getRdsTaEnable().getValue();
                    Boolean bool2 = Boolean.TRUE;
                    if (Intrinsics.areEqual(value, bool2) && Intrinsics.areEqual(radioModel.getCurrentIsFm().getValue(), bool2)) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                taShowing.postValue(Boolean.valueOf(z));
                MutableLiveData<Boolean> afShowing = radioModel.getAfShowing();
                if (bool.booleanValue()) {
                    Boolean value2 = radioModel.getRdsAfEnable().getValue();
                    Boolean bool3 = Boolean.TRUE;
                    if (Intrinsics.areEqual(value2, bool3) && Intrinsics.areEqual(radioModel.getCurrentIsFm().getValue(), bool3)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
                afShowing.postValue(Boolean.valueOf(z2));
                MutableLiveData<Boolean> psShowing = radioModel.getPsShowing();
                if (bool.booleanValue()) {
                    Boolean value3 = radioModel.getRdsPsEnable().getValue();
                    Boolean bool4 = Boolean.TRUE;
                    if (Intrinsics.areEqual(value3, bool4) && Intrinsics.areEqual(radioModel.getCurrentIsFm().getValue(), bool4)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                } else {
                    z3 = false;
                }
                psShowing.postValue(Boolean.valueOf(z3));
                MutableLiveData<Boolean> tpShowing = radioModel.getTpShowing();
                if (bool.booleanValue()) {
                    Boolean value4 = radioModel.getRdsTpEnable().getValue();
                    Boolean bool5 = Boolean.TRUE;
                    if (Intrinsics.areEqual(value4, bool5) && Intrinsics.areEqual(radioModel.getCurrentIsFm().getValue(), bool5)) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                } else {
                    z4 = false;
                }
                tpShowing.postValue(Boolean.valueOf(z4));
                radioModel.getPtyShowing().postValue(Boolean.valueOf(bool.booleanValue() && Intrinsics.areEqual(radioModel.getCurrentIsFm().getValue(), Boolean.TRUE)));
                radioModel.getRdsShowing().postValue(Boolean.valueOf(bool.booleanValue() && Intrinsics.areEqual(radioModel.getCurrentIsFm().getValue(), Boolean.TRUE)));
            }
        };
        rdsEnable.observeForever(new Observer() { // from class: com.syu.manger.module.radio.RadioObserver$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioObserver.a(function1, obj);
            }
        });
        MutableLiveData<Boolean> currentIsFm = radioModel.getCurrentIsFm();
        final Function1<Boolean, Unit> function2 = new Function1<Boolean, Unit>() { // from class: com.syu.manger.module.radio.RadioObserver$1$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code duplicated, block: B:17:0x006f  */
            /* JADX WARN: Code duplicated, block: B:25:0x00a7  */
            /* JADX WARN: Code duplicated, block: B:33:0x00df  */
            /* JADX WARN: Code duplicated, block: B:9:0x0037  */
            public final void invoke(Boolean bool) {
                boolean z;
                boolean z2;
                boolean z3;
                boolean z4;
                MutableLiveData<Boolean> taShowing = radioModel.getTaShowing();
                Intrinsics.checkNotNullExpressionValue(bool, "it");
                if (bool.booleanValue()) {
                    Boolean value = radioModel.getRdsTaEnable().getValue();
                    Boolean bool2 = Boolean.TRUE;
                    if (Intrinsics.areEqual(value, bool2) && Intrinsics.areEqual(radioModel.getRdsEnable().getValue(), bool2)) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                taShowing.postValue(Boolean.valueOf(z));
                MutableLiveData<Boolean> afShowing = radioModel.getAfShowing();
                if (bool.booleanValue()) {
                    Boolean value2 = radioModel.getRdsAfEnable().getValue();
                    Boolean bool3 = Boolean.TRUE;
                    if (Intrinsics.areEqual(value2, bool3) && Intrinsics.areEqual(radioModel.getRdsEnable().getValue(), bool3)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
                afShowing.postValue(Boolean.valueOf(z2));
                MutableLiveData<Boolean> psShowing = radioModel.getPsShowing();
                if (bool.booleanValue()) {
                    Boolean value3 = radioModel.getRdsPsEnable().getValue();
                    Boolean bool4 = Boolean.TRUE;
                    if (Intrinsics.areEqual(value3, bool4) && Intrinsics.areEqual(radioModel.getRdsEnable().getValue(), bool4)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                } else {
                    z3 = false;
                }
                psShowing.postValue(Boolean.valueOf(z3));
                MutableLiveData<Boolean> tpShowing = radioModel.getTpShowing();
                if (bool.booleanValue()) {
                    Boolean value4 = radioModel.getRdsTpEnable().getValue();
                    Boolean bool5 = Boolean.TRUE;
                    if (Intrinsics.areEqual(value4, bool5) && Intrinsics.areEqual(radioModel.getRdsEnable().getValue(), bool5)) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                } else {
                    z4 = false;
                }
                tpShowing.postValue(Boolean.valueOf(z4));
                radioModel.getPtyShowing().postValue(Boolean.valueOf(bool.booleanValue() && Intrinsics.areEqual(radioModel.getRdsEnable().getValue(), Boolean.TRUE)));
                radioModel.getRdsShowing().postValue(Boolean.valueOf(bool.booleanValue() && Intrinsics.areEqual(radioModel.getRdsEnable().getValue(), Boolean.TRUE)));
            }
        };
        currentIsFm.observeForever(new Observer() { // from class: com.syu.manger.module.radio.RadioObserver$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioObserver.b(function2, obj);
            }
        });
        MutableLiveData<Boolean> rdsTaEnable = radioModel.getRdsTaEnable();
        final Function1<Boolean, Unit> function3 = new Function1<Boolean, Unit>() { // from class: com.syu.manger.module.radio.RadioObserver$1$3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code duplicated, block: B:9:0x0035  */
            public final void invoke(Boolean bool) {
                boolean z;
                MutableLiveData<Boolean> taShowing = radioModel.getTaShowing();
                Intrinsics.checkNotNullExpressionValue(bool, "it");
                if (bool.booleanValue()) {
                    Boolean value = radioModel.getRdsEnable().getValue();
                    Boolean bool2 = Boolean.TRUE;
                    if (Intrinsics.areEqual(value, bool2) && Intrinsics.areEqual(radioModel.getCurrentIsFm().getValue(), bool2)) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                taShowing.postValue(Boolean.valueOf(z));
            }
        };
        rdsTaEnable.observeForever(new Observer() { // from class: com.syu.manger.module.radio.RadioObserver$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioObserver.c(function3, obj);
            }
        });
        MutableLiveData<Boolean> rdsPsEnable = radioModel.getRdsPsEnable();
        final Function1<Boolean, Unit> function4 = new Function1<Boolean, Unit>() { // from class: com.syu.manger.module.radio.RadioObserver$1$4
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code duplicated, block: B:9:0x0035  */
            public final void invoke(Boolean bool) {
                boolean z;
                MutableLiveData<Boolean> psShowing = radioModel.getPsShowing();
                Intrinsics.checkNotNullExpressionValue(bool, "it");
                if (bool.booleanValue()) {
                    Boolean value = radioModel.getRdsEnable().getValue();
                    Boolean bool2 = Boolean.TRUE;
                    if (Intrinsics.areEqual(value, bool2) && Intrinsics.areEqual(radioModel.getCurrentIsFm().getValue(), bool2)) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                psShowing.postValue(Boolean.valueOf(z));
            }
        };
        rdsPsEnable.observeForever(new Observer() { // from class: com.syu.manger.module.radio.RadioObserver$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioObserver.d(function4, obj);
            }
        });
        MutableLiveData<Boolean> rdsAfEnable = radioModel.getRdsAfEnable();
        final Function1<Boolean, Unit> function5 = new Function1<Boolean, Unit>() { // from class: com.syu.manger.module.radio.RadioObserver$1$5
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code duplicated, block: B:9:0x0035  */
            public final void invoke(Boolean bool) {
                boolean z;
                MutableLiveData<Boolean> afShowing = radioModel.getAfShowing();
                Intrinsics.checkNotNullExpressionValue(bool, "it");
                if (bool.booleanValue()) {
                    Boolean value = radioModel.getRdsEnable().getValue();
                    Boolean bool2 = Boolean.TRUE;
                    if (Intrinsics.areEqual(value, bool2) && Intrinsics.areEqual(radioModel.getCurrentIsFm().getValue(), bool2)) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                afShowing.postValue(Boolean.valueOf(z));
            }
        };
        rdsAfEnable.observeForever(new Observer() { // from class: com.syu.manger.module.radio.RadioObserver$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioObserver.e(function5, obj);
            }
        });
        MutableLiveData<Boolean> rdsTpEnable = radioModel.getRdsTpEnable();
        final Function1<Boolean, Unit> function6 = new Function1<Boolean, Unit>() { // from class: com.syu.manger.module.radio.RadioObserver$1$6
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code duplicated, block: B:9:0x0035  */
            public final void invoke(Boolean bool) {
                boolean z;
                MutableLiveData<Boolean> tpShowing = radioModel.getTpShowing();
                Intrinsics.checkNotNullExpressionValue(bool, "it");
                if (bool.booleanValue()) {
                    Boolean value = radioModel.getRdsEnable().getValue();
                    Boolean bool2 = Boolean.TRUE;
                    if (Intrinsics.areEqual(value, bool2) && Intrinsics.areEqual(radioModel.getCurrentIsFm().getValue(), bool2)) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                tpShowing.postValue(Boolean.valueOf(z));
            }
        };
        rdsTpEnable.observeForever(new Observer() { // from class: com.syu.manger.module.radio.RadioObserver$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RadioObserver.f(function6, obj);
            }
        });
    }

    public static final void a(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void b(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void c(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void d(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void e(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void f(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* JADX WARN: Code duplicated, block: B:83:0x01d6 A[PHI: r0
  0x01d6: PHI (r0v116 androidx.lifecycle.LiveData) = 
  (r0v43 androidx.lifecycle.LiveData)
  (r0v48 androidx.lifecycle.LiveData)
  (r0v53 androidx.lifecycle.LiveData)
  (r0v63 androidx.lifecycle.LiveData)
  (r0v83 androidx.lifecycle.LiveData)
  (r0v88 androidx.lifecycle.LiveData)
  (r0v99 androidx.lifecycle.LiveData)
  (r0v104 androidx.lifecycle.LiveData)
  (r0v121 androidx.lifecycle.LiveData)
 binds: [B:81:0x01d3, B:76:0x01ba, B:71:0x01a1, B:53:0x014f, B:39:0x00da, B:34:0x00c0, B:26:0x008e, B:21:0x0074, B:8:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v32, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r12v33 */
    /* JADX WARN: Type inference failed for: r12v36 */
    /* JADX WARN: Type inference failed for: r12v46, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r12v48, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r12v49 */
    /* JADX WARN: Type inference failed for: r12v64, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r12v72, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r12v77, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v78, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r12v81 */
    /* JADX WARN: Type inference failed for: r12v82 */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.lang.String[]] */
    public void onReceiver(Message msg) {
        LiveData mBand;
        int i;
        boolean zIsFmFreq;
        MutableLiveData<Boolean> amChannelsChanged;
        ?? ValueOf;
        String string;
        Intrinsics.checkNotNullParameter(msg, NotificationCompat.CATEGORY_MESSAGE);
        boolean z = true;
        switch (msg.code) {
            case 0:
                if (Utils.checkIndex(msg.ints, 0)) {
                    mBand = getModel().getMBand();
                    i = msg.ints[0];
                    ValueOf = Integer.valueOf(i);
                    mBand.postValue(ValueOf);
                }
                break;
            case 1:
                if (Utils.checkIndex(msg.ints, 0)) {
                    getModel().getMFreq().postValue(Integer.valueOf(msg.ints[0]));
                    mBand = getModel().getCurrentIsFm();
                    zIsFmFreq = RadioUtils.INSTANCE.isFmFreq(msg.ints[0]);
                    ValueOf = Boolean.valueOf(zIsFmFreq);
                    mBand.postValue(ValueOf);
                }
                break;
            case 2:
                if (Utils.checkIndex(msg.ints, 0)) {
                    getModel().getMArea().postValue(Integer.valueOf(msg.ints[0]));
                }
                Log.e(Media.ONLINE_TABLE, "----------------------->>> area::" + msg.ints[0] + " FinalRadio.U_AREA");
                break;
            case 3:
                if (Utils.checkIndex(msg.ints, 0)) {
                    mBand = getModel().getMChannel();
                    i = msg.ints[0];
                    ValueOf = Integer.valueOf(i);
                    mBand.postValue(ValueOf);
                }
                break;
            case 4:
                if (Utils.checkIndex(msg.ints, 1)) {
                    int[] iArr = msg.ints;
                    int i2 = iArr[0];
                    int i3 = iArr[1];
                    if (i3 > 0) {
                        Log.e(Media.ONLINE_TABLE, "------------->>>index: " + i2 + "  freq: " + i3 + XmlConsts.CHAR_SPACE);
                        if (65536 <= i2) {
                            SparseIntArray value = getModel().getMFmChannels().getValue();
                            if (value != null) {
                                value.put(i2, i3);
                            }
                            amChannelsChanged = getModel().getFmChannelsChanged();
                        } else {
                            SparseIntArray value2 = getModel().getMAmChannels().getValue();
                            if (value2 != null) {
                                value2.put(i2, i3);
                            }
                            amChannelsChanged = getModel().getAmChannelsChanged();
                        }
                        amChannelsChanged.postValue(Boolean.TRUE);
                    } else if (i2 < 0) {
                        SparseIntArray value3 = getModel().getMFmChannels().getValue();
                        if (value3 != null) {
                            value3.clear();
                        }
                        SparseIntArray value4 = getModel().getMAmChannels().getValue();
                        if (value4 != null) {
                            value4.clear();
                        }
                    }
                }
                break;
            case 5:
                if (Utils.checkIndex(msg.ints, 0)) {
                    getModel().getPtyId().postValue(Integer.valueOf(msg.ints[0]));
                    mBand = getModel().getPtyMsg();
                    RadioConstants radioConstants = RadioConstants.INSTANCE;
                    int length = radioConstants.getPTY_DISPLAY().length;
                    int i4 = msg.ints[0];
                    ValueOf = i4 >= 0 && i4 < length ? radioConstants.getPTY_DISPLAY()[msg.ints[0]] : radioConstants.getPTY_DISPLAY()[0];
                    mBand.postValue(ValueOf);
                }
                break;
            case 6:
                if (Utils.checkIndex(msg.ints, 0)) {
                    mBand = getModel().getRdsAfEnable();
                    if (msg.ints[0] != 1) {
                        z = false;
                    }
                    ValueOf = Boolean.valueOf(z);
                    mBand.postValue(ValueOf);
                }
                break;
            case 8:
                if (Utils.checkIndex(msg.ints, 0)) {
                    mBand = getModel().getRdsTpEnable();
                    if (msg.ints[0] != 1) {
                        z = false;
                    }
                    ValueOf = Boolean.valueOf(z);
                    mBand.postValue(ValueOf);
                }
                break;
            case 9:
                if (Utils.checkIndex(msg.ints, 0)) {
                    mBand = getModel().getRdsTaEnable();
                    if (msg.ints[0] != 1) {
                        z = false;
                    }
                    ValueOf = Boolean.valueOf(z);
                    mBand.postValue(ValueOf);
                }
                break;
            case 13:
                if (Utils.checkIndex(msg.strs, 0)) {
                    String str = msg.strs[0];
                    if (str == null || (string = StringsKt.trim(str).toString()) == null) {
                        ValueOf = string;
                        ValueOf = FinalChip.BSP_PLATFORM_Null;
                    }
                    ValueOf = string;
                    mBand = getModel().getPtyMsg();
                    if (ValueOf.length() == 0) {
                        ValueOf = RadioConstants.INSTANCE.getPTY_DISPLAY()[0];
                    }
                    mBand.postValue(ValueOf);
                }
                break;
            case 15:
                if (Utils.checkIndex(msg.ints, 0)) {
                    mBand = getModel().getRdsEnable();
                    if (msg.ints[0] != 1) {
                        z = false;
                    }
                    ValueOf = Boolean.valueOf(z);
                    mBand.postValue(ValueOf);
                }
                break;
            case 16:
                if (Utils.checkIndex(msg.ints, 3)) {
                    MutableLiveData<Rang> mRange = getModel().getMRange();
                    int[] iArr2 = msg.ints;
                    mRange.postValue(new Rang(iArr2[0], iArr2[1], iArr2[2], 0, 8, null));
                }
                break;
            case 17:
                if (Utils.checkIndex(msg.ints, 0)) {
                    mBand = getModel().getAmSens();
                    i = msg.ints[0];
                    ValueOf = Integer.valueOf(i);
                    mBand.postValue(ValueOf);
                }
                break;
            case 18:
                if (Utils.checkIndex(msg.ints, 0)) {
                    mBand = getModel().getFmSens();
                    i = msg.ints[0];
                    ValueOf = Integer.valueOf(i);
                    mBand.postValue(ValueOf);
                }
                break;
            case 19:
                if (Utils.checkIndex(msg.ints, 0)) {
                    mBand = getModel().getAutoSens();
                    if (msg.ints[0] != 1) {
                        z = false;
                    }
                    ValueOf = Boolean.valueOf(z);
                    mBand.postValue(ValueOf);
                }
                break;
            case 20:
                if (Utils.checkIndex(msg.ints, 0)) {
                    mBand = getModel().isScanning();
                    if (msg.ints[0] != 1) {
                        z = false;
                    }
                    ValueOf = Boolean.valueOf(z);
                    mBand.postValue(ValueOf);
                }
                break;
            case 21:
                if (Utils.checkIndex(msg.ints, 0)) {
                    mBand = getModel().getMStereo();
                    i = msg.ints[0];
                    ValueOf = Integer.valueOf(i);
                    mBand.postValue(ValueOf);
                }
                break;
            case 22:
                if (Utils.checkIndex(msg.ints, 0)) {
                    mBand = getModel().isSearching();
                    if (msg.ints[0] != 1) {
                        z = false;
                    }
                    ValueOf = Boolean.valueOf(z);
                    mBand.postValue(ValueOf);
                }
                break;
            case 23:
                if (Utils.checkIndex(msg.ints, 0)) {
                    mBand = getModel().getMLoc();
                    if (msg.ints[0] != 1) {
                        z = false;
                    }
                    ValueOf = Boolean.valueOf(z);
                    mBand.postValue(ValueOf);
                }
                break;
            case 26:
                if (Utils.checkIndex(msg.strs, 0)) {
                    getModel().getPsMsg().postValue(msg.strs[0]);
                    mBand = getModel().getRdsPsEnable();
                    String str2 = msg.strs[0];
                    zIsFmFreq = !(str2 == null || str2.length() == 0);
                    ValueOf = Boolean.valueOf(zIsFmFreq);
                    mBand.postValue(ValueOf);
                }
                break;
            case 27:
                if (Utils.checkIndex(msg.ints, 0)) {
                    mBand = getModel().isPowerOn();
                    if (msg.ints[0] != 1) {
                        z = false;
                    }
                    ValueOf = Boolean.valueOf(z);
                    mBand.postValue(ValueOf);
                }
                break;
        }
    }
}
