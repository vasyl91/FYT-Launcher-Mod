package com.syu.media.radio.items;

import android.util.Log;
import chip.FinalChip;
import com.syu.media.MediaApp;
import com.syu.media.companion.utils.StringUtils;
import com.syu.media.music.MusicModel;
import com.syu.radio.Radio;
import com.syu.radio.dao.RadioDao;
import com.syu.radio.entities.RadioStation;
import com.syu.radio.entities.Station;
import com.syu.utils.Utils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: StationItem.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.syu.media.radio.items.StationItem$listener$1$1$1", f = "StationItem.kt", i = {}, l = {FinalChip.PLATFORM_855}, m = "invokeSuspend", n = {}, s = {})
final class StationItem$listener$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isChecked;
    final /* synthetic */ Station $it;
    int label;
    final /* synthetic */ StationItem this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StationItem$listener$1$1$1(StationItem stationItem, boolean z, Station station, Continuation<? super StationItem$listener$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = stationItem;
        this.$isChecked = z;
        this.$it = station;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StationItem$listener$1$1$1(this.this$0, this.$isChecked, this.$it, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Log.e("StationItem", "update item music:" + this.this$0.getData() + "   ,isChecked:" + this.$isChecked);
            String value = MediaApp.INSTANCE.getMe().getMainModel().getCity().getValue();
            if (value == null) {
                value = Radio.DEF_STR;
            }
            boolean propForBoolean = Utils.getPropForBoolean("ro.client.foreign", false);
            boolean zIsChineseByReg = StringUtils.INSTANCE.isChineseByReg(value);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = Radio.DEF_STR;
            if (!propForBoolean || !zIsChineseByReg) {
                objectRef.element = value;
            }
            RadioDao radioDao = MediaApp.INSTANCE.getMe().getRadioDaoModel().getRadioDao();
            RadioStation radioStationFindStationByFreqAndCity = radioDao.findStationByFreqAndCity(this.$it.getFreq(), (String) objectRef.element);
            if (radioStationFindStationByFreqAndCity == null) {
                radioStationFindStationByFreqAndCity = new RadioStation();
                Station station = this.$it;
                radioStationFindStationByFreqAndCity.setCity((String) objectRef.element);
                radioStationFindStationByFreqAndCity.setFreq(Boxing.boxInt(station.getFreq()));
            }
            radioStationFindStationByFreqAndCity.setFavorite(this.$isChecked);
            if (radioStationFindStationByFreqAndCity.getId() == null) {
                radioDao.insert(radioStationFindStationByFreqAndCity);
            } else {
                radioDao.update(radioStationFindStationByFreqAndCity);
            }
            radioStationFindStationByFreqAndCity.setFavorite(this.$isChecked);
            Log.d("StationItem", "StationItem:" + radioStationFindStationByFreqAndCity);
            MediaApp.INSTANCE.getMe().getRadioDaoModel().getRadioDao().update(radioStationFindStationByFreqAndCity);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(radioStationFindStationByFreqAndCity, this.$isChecked, null), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.syu.media.radio.items.StationItem$listener$1$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: StationItem.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.radio.items.StationItem$listener$1$1$1$2", f = "StationItem.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isChecked;
        final /* synthetic */ RadioStation $station;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(RadioStation radioStation, boolean z, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$station = radioStation;
            this.$isChecked = z;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$station, this.$isChecked, continuation);
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
            Integer freq = this.$station.getFreq();
            int freq2 = MediaApp.INSTANCE.getMe().getFreq();
            if (freq != null && freq.intValue() == freq2) {
                musicModel.getRadioFavorite().setValue(Boxing.boxBoolean(this.$isChecked));
            }
            return Unit.INSTANCE;
        }
    }
}
