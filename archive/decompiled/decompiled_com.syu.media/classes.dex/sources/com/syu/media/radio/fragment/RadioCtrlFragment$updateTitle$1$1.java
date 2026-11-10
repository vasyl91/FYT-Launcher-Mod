package com.syu.media.radio.fragment;

import android.graphics.Bitmap;
import android.util.Log;
import chip.FinalChip;
import com.syu.media.MediaApp;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.companion.view.fons.FaceMyingheiTextView;
import com.syu.radio.entities.RadioStation;
import java.io.File;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: RadioCtrlFragment.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.syu.media.radio.fragment.RadioCtrlFragment$updateTitle$1$1", f = "RadioCtrlFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RadioCtrlFragment$updateTitle$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $city;
    final /* synthetic */ int $freq;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RadioCtrlFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RadioCtrlFragment$updateTitle$1$1(RadioCtrlFragment radioCtrlFragment, int i, String str, Continuation<? super RadioCtrlFragment$updateTitle$1$1> continuation) {
        super(2, continuation);
        this.this$0 = radioCtrlFragment;
        this.$freq = i;
        this.$city = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> radioCtrlFragment$updateTitle$1$1 = new RadioCtrlFragment$updateTitle$1$1(this.this$0, this.$freq, this.$city, continuation);
        radioCtrlFragment$updateTitle$1$1.L$0 = obj;
        return radioCtrlFragment$updateTitle$1$1;
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
        RadioStation radioStationFindStationByFreqAndCity = this.this$0.getRadioDaoModel().findStationByFreqAndCity(this.$freq, this.$city);
        String cover = radioStationFindStationByFreqAndCity != null ? radioStationFindStationByFreqAndCity.getCover() : null;
        RadioCtrlFragment radioCtrlFragment = this.this$0;
        HiLog.INSTANCE.e(RadioCtrlFragment.INSTANCE.getTAG(), "data cover:  " + cover + ".png, " + new File(cover + ".png").exists());
        Bitmap bitmapDecodeBitmap = radioCtrlFragment.getApp().getResourcesLoader().decodeBitmap(String.valueOf(cover));
        if (bitmapDecodeBitmap == null) {
            bitmapDecodeBitmap = this.this$0.getApp().getRadioIconCache().get(this.$freq);
        }
        Bitmap bitmap = bitmapDecodeBitmap;
        HiLog.INSTANCE.e(RadioCtrlFragment.INSTANCE.getTAG(), "cover bitmap: " + bitmap);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.this$0, radioStationFindStationByFreqAndCity, this.$freq, bitmap, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.syu.media.radio.fragment.RadioCtrlFragment$updateTitle$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: RadioCtrlFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.radio.fragment.RadioCtrlFragment$updateTitle$1$1$1", f = "RadioCtrlFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ int $freq;
        final /* synthetic */ RadioStation $radioStation;
        int label;
        final /* synthetic */ RadioCtrlFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RadioCtrlFragment radioCtrlFragment, RadioStation radioStation, int i, Bitmap bitmap, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = radioCtrlFragment;
            this.$radioStation = radioStation;
            this.$freq = i;
            this.$bitmap = bitmap;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$radioStation, this.$freq, this.$bitmap, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            String name;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FaceMyingheiTextView faceMyingheiTextView = RadioCtrlFragment.access$getBinding(this.this$0).radioCtrTitle;
            RadioStation radioStation = this.$radioStation;
            if (radioStation == null || (name = radioStation.getTitle()) == null) {
                name = MediaApp.INSTANCE.getMe().getRadioIconCache().getName(this.$freq);
            }
            faceMyingheiTextView.setText(name);
            StringBuilder sb = new StringBuilder("updateTitle favorite: ");
            RadioStation radioStation2 = this.$radioStation;
            Log.d("radio1", sb.append(radioStation2 != null ? Boxing.boxBoolean(radioStation2.getFavorite()) : null).toString());
            RadioCtrlFragment radioCtrlFragment = this.this$0;
            RadioStation radioStation3 = this.$radioStation;
            boolean z = false;
            if (radioStation3 != null && radioStation3.getFavorite()) {
                z = true;
            }
            radioCtrlFragment.updateFavorite(z, true);
            this.this$0.albumChange(this.$bitmap);
            return Unit.INSTANCE;
        }
    }
}
