package com.syu.media.radio.items;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import chip.FinalChip;
import com.syu.media.MediaApp;
import com.syu.media.R;
import com.syu.radio.entities.RadioStation;
import com.syu.radio.entities.Station;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import syu.recyclerview.ViewHolder;

/* JADX INFO: compiled from: StationItem.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.syu.media.radio.items.StationItem$onBindViewHolder$2$2", f = "StationItem.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class StationItem$onBindViewHolder$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MediaApp $app;
    final /* synthetic */ Ref.ObjectRef<String> $city;
    final /* synthetic */ ViewHolder $holder;
    final /* synthetic */ ImageView $itemCover;
    final /* synthetic */ Ref.ObjectRef<RadioStation> $radioStation;
    final /* synthetic */ Station $station;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StationItem this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StationItem$onBindViewHolder$2$2(Ref.ObjectRef<RadioStation> objectRef, MediaApp mediaApp, Station station, Ref.ObjectRef<String> objectRef2, ViewHolder viewHolder, StationItem stationItem, ImageView imageView, Continuation<? super StationItem$onBindViewHolder$2$2> continuation) {
        super(2, continuation);
        this.$radioStation = objectRef;
        this.$app = mediaApp;
        this.$station = station;
        this.$city = objectRef2;
        this.$holder = viewHolder;
        this.this$0 = stationItem;
        this.$itemCover = imageView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> stationItem$onBindViewHolder$2$2 = new StationItem$onBindViewHolder$2$2(this.$radioStation, this.$app, this.$station, this.$city, this.$holder, this.this$0, this.$itemCover, continuation);
        stationItem$onBindViewHolder$2$2.L$0 = obj;
        return stationItem$onBindViewHolder$2$2;
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
        this.$radioStation.element = this.$app.getRadioDaoModel().findStationByFreqAndCity(this.$station.getFreq(), (String) this.$city.element);
        Log.e("StationItem", "--------------- item radioStation:" + this.$radioStation.element);
        RadioStation radioStation = (RadioStation) this.$radioStation.element;
        Bitmap bitmapDecodeBitmap = this.$app.getResourcesLoader().decodeBitmap(String.valueOf(radioStation != null ? radioStation.getCover() : null));
        if (bitmapDecodeBitmap == null) {
            bitmapDecodeBitmap = this.$app.getRadioIconCache().get(this.$station.getFreq());
        }
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.$radioStation, this.$holder, this.this$0, this.$itemCover, this.$station, bitmapDecodeBitmap, this.$app, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.syu.media.radio.items.StationItem$onBindViewHolder$2$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: StationItem.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.radio.items.StationItem$onBindViewHolder$2$2$1", f = "StationItem.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MediaApp $app;
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ ViewHolder $holder;
        final /* synthetic */ ImageView $itemCover;
        final /* synthetic */ Ref.ObjectRef<RadioStation> $radioStation;
        final /* synthetic */ Station $station;
        int label;
        final /* synthetic */ StationItem this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.ObjectRef<RadioStation> objectRef, ViewHolder viewHolder, StationItem stationItem, ImageView imageView, Station station, Bitmap bitmap, MediaApp mediaApp, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$radioStation = objectRef;
            this.$holder = viewHolder;
            this.this$0 = stationItem;
            this.$itemCover = imageView;
            this.$station = station;
            this.$bitmap = bitmap;
            this.$app = mediaApp;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$radioStation, this.$holder, this.this$0, this.$itemCover, this.$station, this.$bitmap, this.$app, continuation);
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
            Log.e("StationItem", "item radioStation111:" + this.$radioStation.element);
            ViewHolder viewHolder = this.$holder;
            int i = R.id.station_item_favorite;
            RadioStation radioStation = (RadioStation) this.$radioStation.element;
            viewHolder.setChecked(i, radioStation != null ? radioStation.getFavorite() : false);
            CheckBox checkBox = (CheckBox) this.$holder.findViewById(R.id.station_item_favorite);
            if (checkBox != null) {
                checkBox.setOnCheckedChangeListener(this.this$0.listener);
            }
            TextView textView = (TextView) this.$holder.findViewById(R.id.station_item_name);
            if (textView != null) {
                Ref.ObjectRef<RadioStation> objectRef = this.$radioStation;
                MediaApp mediaApp = this.$app;
                Station station = this.$station;
                RadioStation radioStation2 = (RadioStation) objectRef.element;
                if (radioStation2 == null || (name = radioStation2.getTitle()) == null) {
                    name = mediaApp.getRadioIconCache().getName(station.getFreq());
                }
                textView.setText(name);
                textView.setVisibility(TextUtils.isEmpty(textView.getText()) ? 8 : 0);
            }
            ImageView imageView = this.$itemCover;
            if ((imageView != null ? imageView.getTag() : null) == null || !Intrinsics.areEqual(this.$itemCover.getTag(), String.valueOf(this.$station.getFreq()))) {
                ImageView imageView2 = this.$itemCover;
                if (imageView2 != null) {
                    imageView2.setTag(String.valueOf(this.$station.getFreq()));
                }
                ImageView imageView3 = this.$itemCover;
                if (imageView3 != null) {
                    imageView3.setImageBitmap(this.$bitmap);
                }
            }
            return Unit.INSTANCE;
        }
    }
}
