package com.syu.media.radio.items;

import android.util.Log;
import chip.FinalChip;
import com.syu.media.MediaApp;
import com.syu.media.music.MusicModel;
import com.syu.radio.entities.RadioStation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: RadioStationItem.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.syu.media.radio.items.RadioStationItem$listener$1$1$1", f = "RadioStationItem.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
final class RadioStationItem$listener$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isChecked;
    final /* synthetic */ RadioStation $it;
    int label;
    final /* synthetic */ RadioStationItem this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RadioStationItem$listener$1$1$1(RadioStationItem radioStationItem, RadioStation radioStation, boolean z, Continuation<? super RadioStationItem$listener$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = radioStationItem;
        this.$it = radioStation;
        this.$isChecked = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RadioStationItem$listener$1$1$1(this.this$0, this.$it, this.$isChecked, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Log.e("RadioStationItem", "update item listener :: " + this.this$0.getData());
            MediaApp.INSTANCE.getMe().getRadioDaoModel().getRadioDao().update(this.$it);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$it, this.$isChecked, null), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.syu.media.radio.items.RadioStationItem$listener$1$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: RadioStationItem.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.radio.items.RadioStationItem$listener$1$1$1$1", f = "RadioStationItem.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isChecked;
        final /* synthetic */ RadioStation $it;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RadioStation radioStation, boolean z, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$it = radioStation;
            this.$isChecked = z;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$it, this.$isChecked, continuation);
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
            MusicModel musicModel = MediaApp.INSTANCE.getMe().getMusicModel();
            Integer freq = this.$it.getFreq();
            int freq2 = MediaApp.INSTANCE.getMe().getFreq();
            if (freq != null && freq.intValue() == freq2) {
                musicModel.getRadioFavorite().setValue(Boxing.boxBoolean(this.$isChecked));
            }
            return Unit.INSTANCE;
        }
    }
}
