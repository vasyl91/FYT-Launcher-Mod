package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: compiled from: WhileSelect.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\u00020\u00012\u001f\b\u0004\u0010\u0002\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0006H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"whileSelect", "", "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class WhileSelectKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.selects.WhileSelectKt$whileSelect$1, reason: invalid class name */
    /* JADX INFO: compiled from: WhileSelect.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
    @DebugMetadata(c = "kotlinx.coroutines.selects.WhileSelectKt", f = "WhileSelect.kt", i = {0}, l = {37}, m = "whileSelect", n = {"builder"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WhileSelectKt.whileSelect(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0057  */
    /* JADX WARN: Code duplicated, block: B:24:0x005c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x005d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0066  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x005d -> B:26:0x005e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:24:0x005c
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object whileSelect(kotlin.jvm.functions.Function1<? super kotlinx.coroutines.selects.SelectBuilder<? super java.lang.Boolean>, kotlin.Unit> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.selects.WhileSelectKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r6
            kotlinx.coroutines.selects.WhileSelectKt$whileSelect$1 r0 = (kotlinx.coroutines.selects.WhileSelectKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            kotlinx.coroutines.selects.WhileSelectKt$whileSelect$1 r0 = new kotlinx.coroutines.selects.WhileSelectKt$whileSelect$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L5e
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
        L39:
            r0.L$0 = r5
            r0.label = r3
            r6 = r0
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            kotlinx.coroutines.selects.SelectBuilderImpl r2 = new kotlinx.coroutines.selects.SelectBuilderImpl
            r2.<init>(r6)
            r5.invoke(r2)     // Catch: java.lang.Throwable -> L49
            goto L4d
        L49:
            r4 = move-exception
            r2.handleBuilderException(r4)
        L4d:
            java.lang.Object r2 = r2.getResult()
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r2 != r4) goto L5a
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r6)
        L5a:
            if (r2 != r1) goto L5d
            return r1
        L5d:
            r6 = r2
        L5e:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L39
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.WhileSelectKt.whileSelect(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object whileSelect$$forInline(Function1<? super SelectBuilder<? super Boolean>, Unit> function1, Continuation<? super Unit> continuation) {
        Object result;
        do {
            InlineMarker.mark(0);
            SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(continuation);
            try {
                function1.invoke(selectBuilderImpl);
            } catch (Throwable th) {
                selectBuilderImpl.handleBuilderException(th);
            }
            result = selectBuilderImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            InlineMarker.mark(1);
        } while (((Boolean) result).booleanValue());
        return Unit.INSTANCE;
    }
}
