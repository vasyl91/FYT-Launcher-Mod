package com.syu.media.radio.dialog;

import chip.FinalChip;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.radio.items.EditorStationItem;
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
import kotlinx.coroutines.CoroutineScope;
import syu.recyclerview.Node;

/* JADX INFO: compiled from: EditorDialog.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.syu.media.radio.dialog.EditorDialog$doSomething$1$1$1$1", f = "EditorDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class EditorDialog$doSomething$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<RadioStation> $station;
    int label;
    final /* synthetic */ EditorDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EditorDialog$doSomething$1$1$1$1(List<RadioStation> list, EditorDialog editorDialog, Continuation<? super EditorDialog$doSomething$1$1$1$1> continuation) {
        super(2, continuation);
        this.$station = list;
        this.this$0 = editorDialog;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EditorDialog$doSomething$1$1$1$1(this.$station, this.this$0, continuation);
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
        List listCreateNodesWithAdapter = Node.Companion.createNodesWithAdapter(this.$station, EditorStationItem.class, this.this$0.mAdapter);
        HiLog.INSTANCE.d(EditorDialog.INSTANCE.getTAG(), "doSomething items size:" + listCreateNodesWithAdapter.size());
        HiLog.INSTANCE.d(EditorDialog.INSTANCE.getTAG(), "doSomething station:" + this.$station.size());
        this.this$0.mAdapter.getMData().replace(listCreateNodesWithAdapter);
        return Unit.INSTANCE;
    }
}
