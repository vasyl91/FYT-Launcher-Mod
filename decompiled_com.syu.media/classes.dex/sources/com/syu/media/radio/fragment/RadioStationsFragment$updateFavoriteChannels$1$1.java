package com.syu.media.radio.fragment;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import chip.FinalChip;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.radio.diff.DiffCallBack;
import com.syu.media.radio.items.RadioStationItem;
import com.syu.radio.Radio;
import com.syu.radio.entities.RadioStation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import syu.recyclerview.Node;

/* JADX INFO: compiled from: RadioStationsFragment.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.syu.media.radio.fragment.RadioStationsFragment$updateFavoriteChannels$1$1", f = "RadioStationsFragment.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
final class RadioStationsFragment$updateFavoriteChannels$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $it;
    int label;
    final /* synthetic */ RadioStationsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RadioStationsFragment$updateFavoriteChannels$1$1(RadioStationsFragment radioStationsFragment, String str, Continuation<? super RadioStationsFragment$updateFavoriteChannels$1$1> continuation) {
        super(2, continuation);
        this.this$0 = radioStationsFragment;
        this.$it = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RadioStationsFragment$updateFavoriteChannels$1$1(this.this$0, this.$it, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.syu.media.radio.fragment.RadioStationsFragment$updateFavoriteChannels$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: RadioStationsFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "channels", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/radio/entities/RadioStation;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.radio.fragment.RadioStationsFragment$updateFavoriteChannels$1$1$1", f = "RadioStationsFragment.kt", i = {}, l = {198}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<List<RadioStation>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RadioStationsFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RadioStationsFragment radioStationsFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = radioStationsFragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(List<RadioStation> list, Continuation<? super Unit> continuation) {
            return create(list, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List list = (List) this.L$0;
                if (this.this$0.checkedId == RadioStationsFragment.access$getBinding(this.this$0).radioListFavorite.getId()) {
                    HiLog.INSTANCE.d(RadioStationsFragment.INSTANCE.getTAG(), "updateFavoriteChannels channels:" + list.size());
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        RadioStation radioStation = (RadioStation) list.get(i2);
                        HiLog.INSTANCE.e(RadioStationsFragment.INSTANCE.getTAG(), "ufc station:" + radioStation);
                        Integer freq = radioStation.getFreq();
                        if (freq != null) {
                            RadioStationsFragment radioStationsFragment = this.this$0;
                            int iIntValue = freq.intValue();
                            if (Intrinsics.areEqual(radioStation.getCity(), radioStationsFragment.citySuffix(radioStationsFragment.iCity))) {
                                RadioStation radioStationContainField = radioStationsFragment.containField(arrayList, iIntValue);
                                if (radioStationContainField != null) {
                                    Boxing.boxBoolean(arrayList.remove(radioStationContainField));
                                }
                                arrayList.add(radioStation);
                            } else if (!Intrinsics.areEqual(radioStation.getCity(), radioStationsFragment.iCity) || radioStationsFragment.containField(arrayList, iIntValue) != null) {
                                if (radioStationsFragment.containField(arrayList, iIntValue) == null) {
                                    arrayList2.add(radioStation);
                                }
                            } else {
                                arrayList.add(radioStation);
                            }
                        }
                    }
                    if (!Intrinsics.areEqual(this.this$0.iCity, Radio.DEF_STR)) {
                        HiLog.INSTANCE.d(RadioStationsFragment.INSTANCE.getTAG(), "unknown:" + arrayList2);
                        arrayList.addAll(arrayList2);
                    }
                    int size2 = arrayList.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        Integer freq2 = ((RadioStation) arrayList.get(i3)).getFreq();
                        int i4 = this.this$0.iFreq;
                        if (freq2 != null && freq2.intValue() == i4) {
                            HiLog.INSTANCE.d(RadioStationsFragment.INSTANCE.getTAG(), "check freq:" + i3);
                            this.this$0.lastPosition = i3;
                        }
                    }
                    this.this$0.favData = Node.Companion.createNodesWithAdapter(arrayList, RadioStationItem.class, this.this$0.mAdapter);
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this.this$0, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.syu.media.radio.fragment.RadioStationsFragment$updateFavoriteChannels$1$1$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: RadioStationsFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.radio.fragment.RadioStationsFragment$updateFavoriteChannels$1$1$1$2", f = "RadioStationsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ RadioStationsFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(RadioStationsFragment radioStationsFragment, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = radioStationsFragment;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
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
                DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new DiffCallBack(this.this$0.lastData, this.this$0.favData), false);
                Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(DiffCallBa…astData, favData), false)");
                RadioStationsFragment radioStationsFragment = this.this$0;
                radioStationsFragment.lastData = radioStationsFragment.favData;
                this.this$0.mAdapter.replaceWithoutNotify(this.this$0.lastData);
                diffResultCalculateDiff.dispatchUpdatesTo((RecyclerView.Adapter) this.this$0.mAdapter);
                HiLog.INSTANCE.d(RadioStationsFragment.INSTANCE.getTAG(), "listCheck favData.indices:" + this.this$0.favData.size());
                return Unit.INSTANCE;
            }
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<List<RadioStation>> favoritesWithCity = this.this$0.getRadioDao().getFavoritesWithCity(this.$it);
            if (favoritesWithCity != null) {
                this.label = 1;
                if (FlowKt.collectLatest(favoritesWithCity, new AnonymousClass1(this.this$0, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
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
