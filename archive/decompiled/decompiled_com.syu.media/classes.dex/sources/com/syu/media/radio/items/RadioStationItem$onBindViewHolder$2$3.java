package com.syu.media.radio.items;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import base.event.AutoKeyEvent;
import chip.FinalChip;
import com.syu.media.MediaApp;
import com.syu.media.R;
import com.syu.radio.entities.RadioStation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import syu.recyclerview.ViewHolder;

/* JADX INFO: compiled from: RadioStationItem.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.syu.media.radio.items.RadioStationItem$onBindViewHolder$2$3", f = "RadioStationItem.kt", i = {}, l = {AutoKeyEvent.KEYCODE_SEARCH}, m = "invokeSuspend", n = {}, s = {})
final class RadioStationItem$onBindViewHolder$2$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Bitmap> $bitmap;
    final /* synthetic */ boolean $contain;
    final /* synthetic */ boolean $foreign;
    final /* synthetic */ ViewHolder $holder;
    final /* synthetic */ RadioStation $station;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RadioStationItem$onBindViewHolder$2$3(Ref.ObjectRef<Bitmap> objectRef, RadioStation radioStation, boolean z, boolean z2, ViewHolder viewHolder, Continuation<? super RadioStationItem$onBindViewHolder$2$3> continuation) {
        super(2, continuation);
        this.$bitmap = objectRef;
        this.$station = radioStation;
        this.$foreign = z;
        this.$contain = z2;
        this.$holder = viewHolder;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RadioStationItem$onBindViewHolder$2$3(this.$bitmap, this.$station, this.$foreign, this.$contain, this.$holder, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x007f  */
    public final Object invokeSuspend(Object obj) {
        Bitmap bitmap;
        Bitmap bitmapDecodeBitmap;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef<Bitmap> objectRef = this.$bitmap;
            Integer freq = this.$station.getFreq();
            if (freq != null) {
                bitmap = MediaApp.INSTANCE.getMe().getRadioIconCache().get(freq.intValue());
            } else {
                bitmap = null;
            }
            objectRef.element = bitmap;
            if (!this.$foreign || !this.$contain) {
                Ref.ObjectRef<Bitmap> objectRef2 = this.$bitmap;
                String cover = this.$station.getCover();
                if (cover != null) {
                    RadioStation radioStation = this.$station;
                    bitmapDecodeBitmap = MediaApp.INSTANCE.getMe().getResourcesLoader().decodeBitmap(cover);
                    Log.e("RadioStationItem", "station:" + radioStation + " ,bitmap:" + bitmapDecodeBitmap);
                    if (bitmapDecodeBitmap == null) {
                        bitmapDecodeBitmap = (Bitmap) this.$bitmap.element;
                    }
                } else {
                    bitmapDecodeBitmap = (Bitmap) this.$bitmap.element;
                }
                objectRef2.element = bitmapDecodeBitmap;
            }
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass3(this.$holder, this.$bitmap, this.$foreign, this.$contain, this.$station, null), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.syu.media.radio.items.RadioStationItem$onBindViewHolder$2$3$3, reason: invalid class name */
    /* JADX INFO: compiled from: RadioStationItem.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.radio.items.RadioStationItem$onBindViewHolder$2$3$3", f = "RadioStationItem.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Bitmap> $bitmap;
        final /* synthetic */ boolean $contain;
        final /* synthetic */ boolean $foreign;
        final /* synthetic */ ViewHolder $holder;
        final /* synthetic */ RadioStation $station;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(ViewHolder viewHolder, Ref.ObjectRef<Bitmap> objectRef, boolean z, boolean z2, RadioStation radioStation, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$holder = viewHolder;
            this.$bitmap = objectRef;
            this.$foreign = z;
            this.$contain = z2;
            this.$station = radioStation;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$holder, this.$bitmap, this.$foreign, this.$contain, this.$station, continuation);
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
            TextView textView = (TextView) this.$holder.findViewById(R.id.station_item_name);
            if (textView != null) {
                boolean z = this.$foreign;
                boolean z2 = this.$contain;
                RadioStation radioStation = this.$station;
                if (!z || !z2) {
                    Log.e("RadioStationItem", "station:" + radioStation);
                    String title = radioStation.getTitle();
                    if (title == null) {
                        Integer freq = radioStation.getFreq();
                        if (freq != null) {
                            int iIntValue = freq.intValue();
                            Log.e("RadioStationItem", "getName:" + iIntValue);
                            title = MediaApp.INSTANCE.getMe().getRadioIconCache().getName(iIntValue);
                        } else {
                            title = null;
                        }
                    }
                    textView.setText(title);
                }
                textView.setVisibility(TextUtils.isEmpty(textView.getText()) ? 8 : 0);
            }
            this.$holder.setImageViewWithBimap(R.id.station_item_cover, (Bitmap) this.$bitmap.element);
            return Unit.INSTANCE;
        }
    }
}
