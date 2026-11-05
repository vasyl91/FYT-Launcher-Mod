package androidx.room;

import chip.FinalChip;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: CoroutinesRoom.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u0001H\u0002H\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1", f = "CoroutinesRoom.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
final class CoroutinesRoom$Companion$createFlow$1<R> extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Callable $callable;
    final /* synthetic */ RoomDatabase $db;
    final /* synthetic */ boolean $inTransaction;
    final /* synthetic */ String[] $tableNames;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoroutinesRoom$Companion$createFlow$1(String[] strArr, boolean z, RoomDatabase roomDatabase, Callable callable, Continuation continuation) {
        super(2, continuation);
        this.$tableNames = strArr;
        this.$inTransaction = z;
        this.$db = roomDatabase;
        this.$callable = callable;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        CoroutinesRoom$Companion$createFlow$1 coroutinesRoom$Companion$createFlow$1 = new CoroutinesRoom$Companion$createFlow$1(this.$tableNames, this.$inTransaction, this.$db, this.$callable, continuation);
        coroutinesRoom$Companion$createFlow$1.L$0 = obj;
        return coroutinesRoom$Companion$createFlow$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return create(obj, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ContinuationInterceptor transactionDispatcher;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            final Channel channelChannel$default = ChannelKt.Channel$default(-1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final String[] strArr = this.$tableNames;
            objectRef.element = new InvalidationTracker.Observer(strArr) { // from class: androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1
                @Override // androidx.room.InvalidationTracker.Observer
                public void onInvalidated(Set<String> tables) {
                    Intrinsics.checkNotNullParameter(tables, "tables");
                    channelChannel$default.offer(Unit.INSTANCE);
                }
            };
            channelChannel$default.offer(Unit.INSTANCE);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = getContext();
            TransactionElement transactionElement = (TransactionElement) getContext().get(TransactionElement.INSTANCE);
            if (transactionElement == null || (transactionDispatcher = transactionElement.getTransactionDispatcher()) == null) {
                transactionDispatcher = this.$inTransaction ? CoroutinesRoomKt.getTransactionDispatcher(this.$db) : CoroutinesRoomKt.getQueryDispatcher(this.$db);
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(flowCollector, objectRef, channelChannel$default, objectRef2, null);
            this.label = 1;
            if (BuildersKt.withContext((CoroutineContext) transactionDispatcher, anonymousClass1, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: CoroutinesRoom.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "R", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
    @DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1", f = "CoroutinesRoom.kt", i = {}, l = {121, 123}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef $flowContext;
        final /* synthetic */ Ref.ObjectRef $observer;
        final /* synthetic */ Channel $observerChannel;
        final /* synthetic */ FlowCollector $this_flow;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FlowCollector flowCollector, Ref.ObjectRef objectRef, Channel channel, Ref.ObjectRef objectRef2, Continuation continuation) {
            super(2, continuation);
            this.$this_flow = flowCollector;
            this.$observer = objectRef;
            this.$observerChannel = channel;
            this.$flowContext = objectRef2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass1(this.$this_flow, this.$observer, this.$observerChannel, this.$flowContext, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return create(obj, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x0050 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:20:0x0051  */
        /* JADX WARN: Code duplicated, block: B:23:0x005c A[Catch: all -> 0x00a2, TRY_LEAVE, TryCatch #0 {all -> 0x00a2, blocks: (B:17:0x0046, B:21:0x0054, B:23:0x005c), top: B:35:0x0046 }] */
        /* JADX WARN: Code duplicated, block: B:25:0x0089 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:26:0x008a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x008a -> B:35:0x0046). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L29
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r1 = r9.L$0
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> La4
                r10 = r1
                goto L45
            L17:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L1f:
                java.lang.Object r1 = r9.L$0
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> La4
                r4 = r1
                r1 = r9
                goto L54
            L29:
                kotlin.ResultKt.throwOnFailure(r10)
                androidx.room.CoroutinesRoom$Companion$createFlow$1 r10 = androidx.room.CoroutinesRoom$Companion$createFlow$1.this
                androidx.room.RoomDatabase r10 = r10.$db
                androidx.room.InvalidationTracker r10 = r10.getInvalidationTracker()
                kotlin.jvm.internal.Ref$ObjectRef r1 = r9.$observer
                java.lang.Object r1 = r1.element
                androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1 r1 = (androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1) r1
                androidx.room.InvalidationTracker$Observer r1 = (androidx.room.InvalidationTracker.Observer) r1
                r10.addObserver(r1)
                kotlinx.coroutines.channels.Channel r10 = r9.$observerChannel     // Catch: java.lang.Throwable -> La4
                kotlinx.coroutines.channels.ChannelIterator r10 = r10.iterator()     // Catch: java.lang.Throwable -> La4
            L45:
                r1 = r9
            L46:
                r1.L$0 = r10     // Catch: java.lang.Throwable -> La2
                r1.label = r3     // Catch: java.lang.Throwable -> La2
                java.lang.Object r4 = r10.hasNext(r1)     // Catch: java.lang.Throwable -> La2
                if (r4 != r0) goto L51
                return r0
            L51:
                r8 = r4
                r4 = r10
                r10 = r8
            L54:
                java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> La2
                boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> La2
                if (r10 == 0) goto L8c
                java.lang.Object r10 = r4.next()     // Catch: java.lang.Throwable -> La2
                kotlin.Unit r10 = (kotlin.Unit) r10     // Catch: java.lang.Throwable -> La2
                kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch: java.lang.Throwable -> La2
                r10.<init>()     // Catch: java.lang.Throwable -> La2
                androidx.room.CoroutinesRoom$Companion$createFlow$1 r5 = androidx.room.CoroutinesRoom$Companion$createFlow$1.this     // Catch: java.lang.Throwable -> La2
                java.util.concurrent.Callable r5 = r5.$callable     // Catch: java.lang.Throwable -> La2
                java.lang.Object r5 = r5.call()     // Catch: java.lang.Throwable -> La2
                r10.element = r5     // Catch: java.lang.Throwable -> La2
                kotlin.jvm.internal.Ref$ObjectRef r5 = r1.$flowContext     // Catch: java.lang.Throwable -> La2
                java.lang.Object r5 = r5.element     // Catch: java.lang.Throwable -> La2
                kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5     // Catch: java.lang.Throwable -> La2
                androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1 r6 = new androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1     // Catch: java.lang.Throwable -> La2
                r7 = 0
                r6.<init>(r10, r7)     // Catch: java.lang.Throwable -> La2
                kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch: java.lang.Throwable -> La2
                r1.L$0 = r4     // Catch: java.lang.Throwable -> La2
                r1.label = r2     // Catch: java.lang.Throwable -> La2
                java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r5, r6, r1)     // Catch: java.lang.Throwable -> La2
                if (r10 != r0) goto L8a
                return r0
            L8a:
                r10 = r4
                goto L46
            L8c:
                androidx.room.CoroutinesRoom$Companion$createFlow$1 r10 = androidx.room.CoroutinesRoom$Companion$createFlow$1.this
                androidx.room.RoomDatabase r10 = r10.$db
                androidx.room.InvalidationTracker r10 = r10.getInvalidationTracker()
                kotlin.jvm.internal.Ref$ObjectRef r0 = r1.$observer
                java.lang.Object r0 = r0.element
                androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1 r0 = (androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1) r0
                androidx.room.InvalidationTracker$Observer r0 = (androidx.room.InvalidationTracker.Observer) r0
                r10.removeObserver(r0)
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            La2:
                r10 = move-exception
                goto La6
            La4:
                r10 = move-exception
                r1 = r9
            La6:
                androidx.room.CoroutinesRoom$Companion$createFlow$1 r0 = androidx.room.CoroutinesRoom$Companion$createFlow$1.this
                androidx.room.RoomDatabase r0 = r0.$db
                androidx.room.InvalidationTracker r0 = r0.getInvalidationTracker()
                kotlin.jvm.internal.Ref$ObjectRef r1 = r1.$observer
                java.lang.Object r1 = r1.element
                androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1 r1 = (androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1) r1
                androidx.room.InvalidationTracker$Observer r1 = (androidx.room.InvalidationTracker.Observer) r1
                r0.removeObserver(r1)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.CoroutinesRoom$Companion$createFlow$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: CoroutinesRoom.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "R", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
        @DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1", f = "CoroutinesRoom.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
        static final class C00051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef $result;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00051(Ref.ObjectRef objectRef, Continuation continuation) {
                super(2, continuation);
                this.$result = objectRef;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Intrinsics.checkNotNullParameter(continuation, "completion");
                return AnonymousClass1.this.new C00051(this.$result, continuation);
            }

            public final Object invoke(Object obj, Object obj2) {
                return create(obj, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    FlowCollector flowCollector = AnonymousClass1.this.$this_flow;
                    Object obj2 = this.$result.element;
                    this.label = 1;
                    if (flowCollector.emit(obj2, this) == coroutine_suspended) {
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
        }
    }
}
