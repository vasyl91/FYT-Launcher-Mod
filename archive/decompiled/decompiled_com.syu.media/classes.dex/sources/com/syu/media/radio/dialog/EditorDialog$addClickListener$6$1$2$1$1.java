package com.syu.media.radio.dialog;

import androidx.lifecycle.MutableLiveData;
import chip.FinalChip;
import com.syu.media.companion.utils.HiLog;
import com.syu.radio.entities.RadioStation;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import syu.recyclerview.Node;

/* JADX INFO: compiled from: EditorDialog.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.syu.media.radio.dialog.EditorDialog$addClickListener$6$1$2$1$1", f = "EditorDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class EditorDialog$addClickListener$6$1$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Node<?>> $items;
    final /* synthetic */ Ref.ObjectRef<RadioStation> $station;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ EditorDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EditorDialog$addClickListener$6$1$2$1$1(List<Node<?>> list, EditorDialog editorDialog, Ref.ObjectRef<RadioStation> objectRef, Continuation<? super EditorDialog$addClickListener$6$1$2$1$1> continuation) {
        super(2, continuation);
        this.$items = list;
        this.this$0 = editorDialog;
        this.$station = objectRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> editorDialog$addClickListener$6$1$2$1$1 = new EditorDialog$addClickListener$6$1$2$1$1(this.$items, this.this$0, this.$station, continuation);
        editorDialog$addClickListener$6$1$2$1$1.L$0 = obj;
        return editorDialog$addClickListener$6$1$2$1$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String title;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        HiLog.INSTANCE.d(EditorDialog.INSTANCE.getTAG(), "items size:" + this.$items.size());
        this.this$0.mAdapter.getMData().replace(this.$items);
        MutableLiveData<String> radioName = this.this$0.getApp().getMusicModel().getRadioName();
        RadioStation radioStation = (RadioStation) this.$station.element;
        if (radioStation == null || (title = radioStation.getTitle()) == null) {
            title = ",";
        }
        radioName.setValue(title);
        return Unit.INSTANCE;
    }
}
