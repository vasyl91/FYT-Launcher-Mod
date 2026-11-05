package com.syu.media.radio.dialog;

import android.widget.TextView;
import bsp.FinalBsp;
import chip.FinalChip;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.radio.items.EditorStationItem;
import com.syu.radio.dao.RadioDao;
import com.syu.radio.entities.RadioStation;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import syu.recyclerview.Node;

/* JADX INFO: compiled from: EditorDialog.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.syu.media.radio.dialog.EditorDialog$addClickListener$6$1", f = "EditorDialog.kt", i = {}, l = {FinalBsp.KEY_CODE_NAVI}, m = "invokeSuspend", n = {}, s = {})
final class EditorDialog$addClickListener$6$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<RadioStation> $station;
    int label;
    final /* synthetic */ EditorDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EditorDialog$addClickListener$6$1(EditorDialog editorDialog, Ref.ObjectRef<RadioStation> objectRef, Continuation<? super EditorDialog$addClickListener$6$1> continuation) {
        super(2, continuation);
        this.this$0 = editorDialog;
        this.$station = objectRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EditorDialog$addClickListener$6$1(this.this$0, this.$station, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            int i2 = this.this$0.editState;
            if (i2 == 1 || i2 == 2) {
                EditorDialog editorDialog = this.this$0;
                TextView textView = editorDialog.freqTv;
                int iText2Freq = editorDialog.text2Freq(String.valueOf(textView != null ? textView.getText() : null));
                Ref.ObjectRef<RadioStation> objectRef = this.$station;
                RadioStation radioStationFindStationByFreqAndCity = this.this$0.getRadioDao().findStationByFreqAndCity(iText2Freq, this.this$0.iCity);
                if (radioStationFindStationByFreqAndCity == null) {
                    radioStationFindStationByFreqAndCity = this.this$0.objectStaion;
                }
                objectRef.element = radioStationFindStationByFreqAndCity;
                RadioStation radioStation = (RadioStation) this.$station.element;
                if (radioStation != null) {
                    TextView textView2 = this.this$0.nameTv;
                    radioStation.setTitle(String.valueOf(textView2 != null ? textView2.getText() : null));
                }
                RadioStation radioStation2 = (RadioStation) this.$station.element;
                if (radioStation2 != null) {
                    radioStation2.setFreq(Boxing.boxInt(iText2Freq));
                }
                RadioStation radioStation3 = (RadioStation) this.$station.element;
                if ((radioStation3 != null ? radioStation3.getId() : null) == null) {
                    HiLog.INSTANCE.d(EditorDialog.INSTANCE.getTAG(), "EditorDialog insert:" + this.this$0.objectStaion.getTitle());
                    RadioDao radioDao = this.this$0.getRadioDao();
                    Object obj2 = this.$station.element;
                    Intrinsics.checkNotNull(obj2);
                    radioDao.insert((RadioStation) obj2);
                } else {
                    HiLog hiLog = HiLog.INSTANCE;
                    String tag = EditorDialog.INSTANCE.getTAG();
                    StringBuilder sb = new StringBuilder("EditorDialog update:");
                    Object obj3 = this.$station.element;
                    Intrinsics.checkNotNull(obj3);
                    hiLog.d(tag, sb.append(((RadioStation) obj3).getTitle()).toString());
                    RadioDao radioDao2 = this.this$0.getRadioDao();
                    Object obj4 = this.$station.element;
                    Intrinsics.checkNotNull(obj4);
                    radioDao2.update((RadioStation) obj4);
                }
            } else if (i2 == 3) {
                this.this$0.getRadioDao().delete(this.this$0.objectStaion);
            } else if (i2 == 4) {
                String str = this.this$0.iCity;
                EditorDialog editorDialog2 = this.this$0;
                List<RadioStation> stationsByCity = editorDialog2.getRadioDao().getStationsByCity(str);
                if (stationsByCity != null) {
                    RadioDao radioDao3 = editorDialog2.getRadioDao();
                    Object[] array = stationsByCity.toArray(new RadioStation[0]);
                    if (array != null) {
                        RadioStation[] radioStationArr = (RadioStation[]) array;
                        radioDao3.delete((RadioStation[]) Arrays.copyOf(radioStationArr, radioStationArr.length));
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    }
                }
            }
            String str2 = this.this$0.iCity;
            EditorDialog editorDialog3 = this.this$0;
            Ref.ObjectRef<RadioStation> objectRef2 = this.$station;
            HiLog.INSTANCE.d(EditorDialog.INSTANCE.getTAG(), "items city:" + str2);
            List<RadioStation> stationsByCity2 = editorDialog3.getRadioDao().getStationsByCity(str2);
            if (stationsByCity2 != null) {
                List listCreateNodesWithAdapter = Node.Companion.createNodesWithAdapter(stationsByCity2, EditorStationItem.class, editorDialog3.mAdapter);
                CoroutineContext main = Dispatchers.getMain();
                EditorDialog$addClickListener$6$1$2$1$1 editorDialog$addClickListener$6$1$2$1$1 = new EditorDialog$addClickListener$6$1$2$1$1(listCreateNodesWithAdapter, editorDialog3, objectRef2, null);
                this.label = 1;
                if (BuildersKt.withContext(main, editorDialog$addClickListener$6$1$2$1$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
