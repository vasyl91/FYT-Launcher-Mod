package syu.recyclerview;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "syu.recyclerview.GroupNode$data$1", f = "GroupNode.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GroupNode$data$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ GroupNode a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupNode$data$1(GroupNode groupNode, Continuation continuation) {
        super(2, continuation);
        this.a = groupNode;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GroupNode$data$1(this.a, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        GroupNode groupNode = this.a;
        groupNode.addAll(groupNode.loadChildren());
        return Unit.INSTANCE;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
