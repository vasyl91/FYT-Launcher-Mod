package com.syu.media.online;

import android.content.Context;
import chip.FinalChip;
import com.google.gson.Gson;
import com.syu.media.ConstantsKt;
import com.syu.media.companion.utils.FileUtils;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.companion.utils.SharedPrefUtils;
import com.syu.media.dao.MediaDao;
import com.syu.media.entities.RadioSource;
import com.syu.media.online.model.OnlineJson;
import com.syu.media.online.model.OnlineRadio;
import com.syu.media.online.model.OnlineResponse;
import com.syu.media.online.net.NetUpdateRepository;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: OnlineLoader.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J2\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0004\u0012\u00020\b0\u000eH\u0002J\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013J-\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u000eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/syu/media/online/OnlineLoader;", FinalChip.BSP_PLATFORM_Null, "mediaDao", "Lcom/syu/media/dao/MediaDao;", "(Lcom/syu/media/dao/MediaDao;)V", "getMediaDao", "()Lcom/syu/media/dao/MediaDao;", "jsonTransformRadioSrource", FinalChip.BSP_PLATFORM_Null, "context", "Landroid/content/Context;", "jsons", "Lcom/syu/media/online/model/OnlineJson;", "radios", "Lkotlin/Function1;", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/media/entities/RadioSource;", "loadOnline", "resId", FinalChip.BSP_PLATFORM_Null, "reloadJsonFromUrl", "dataUrl", FinalChip.BSP_PLATFORM_Null, "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OnlineLoader {
    public static final String TAG = "OnlineLoader";
    private final MediaDao mediaDao;

    /* JADX INFO: renamed from: com.syu.media.online.OnlineLoader$reloadJsonFromUrl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OnlineLoader.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.online.OnlineLoader", f = "OnlineLoader.kt", i = {0}, l = {64}, m = "reloadJsonFromUrl", n = {"jsons"}, s = {"L$0"})
    static final class C00621 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00621(Continuation<? super C00621> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OnlineLoader.this.reloadJsonFromUrl(null, null, (Continuation) this);
        }
    }

    public OnlineLoader(MediaDao mediaDao) {
        Intrinsics.checkNotNullParameter(mediaDao, "mediaDao");
        this.mediaDao = mediaDao;
    }

    public final MediaDao getMediaDao() {
        return this.mediaDao;
    }

    /* JADX INFO: renamed from: com.syu.media.online.OnlineLoader$loadOnline$1, reason: invalid class name */
    /* JADX INFO: compiled from: OnlineLoader.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.online.OnlineLoader$loadOnline$1", f = "OnlineLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ int $resId;
        int label;
        final /* synthetic */ OnlineLoader this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, int i, OnlineLoader onlineLoader, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$resId = i;
            this.this$0 = onlineLoader;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$context, this.$resId, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            final int iIntValue = ((Number) SharedPrefUtils.INSTANCE.getParam(this.$context, ConstantsKt.ONLINE_VERSION, Boxing.boxInt(-1))).intValue();
            HiLog.INSTANCE.e(OnlineLoader.TAG, "SharedPref version:" + iIntValue);
            InputStream inputStreamOpenRawResource = this.$context.getResources().openRawResource(this.$resId);
            Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "context.resources.openRawResource(resId)");
            FileUtils fileUtils = FileUtils.INSTANCE;
            final OnlineLoader onlineLoader = this.this$0;
            final Context context = this.$context;
            fileUtils.bufferedReader(inputStreamOpenRawResource, new Function1<BufferedReader, Unit>() { // from class: com.syu.media.online.OnlineLoader.loadOnline.1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((BufferedReader) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(BufferedReader bufferedReader) {
                    Intrinsics.checkNotNullParameter(bufferedReader, "buff");
                    Object objFromJson = new Gson().fromJson((Reader) bufferedReader, (Class<Object>) OnlineResponse.class);
                    int i = iIntValue;
                    final OnlineLoader onlineLoader2 = onlineLoader;
                    Context context2 = context;
                    OnlineResponse onlineResponse = (OnlineResponse) objFromJson;
                    HiLog.INSTANCE.e(OnlineLoader.TAG, "fromJson size " + onlineResponse.getResult().getRadioList().size());
                    if (onlineResponse.getVersion() > i) {
                        onlineLoader2.jsonTransformRadioSrource(context2, onlineResponse.getResult(), new Function1<List<RadioSource>, Unit>() { // from class: com.syu.media.online.OnlineLoader$loadOnline$1$1$1$1
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                invoke((List<RadioSource>) obj2);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(List<RadioSource> list) {
                                Intrinsics.checkNotNullParameter(list, "it");
                                HiLog.INSTANCE.e(OnlineLoader.TAG, "oj.version > version " + list.size());
                                MediaDao mediaDao = onlineLoader2.getMediaDao();
                                Object[] array = list.toArray(new RadioSource[0]);
                                if (array != null) {
                                    RadioSource[] radioSourceArr = (RadioSource[]) array;
                                    mediaDao.insert((RadioSource[]) Arrays.copyOf(radioSourceArr, radioSourceArr.length));
                                    return;
                                }
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                            }
                        });
                    }
                }
            });
            return Unit.INSTANCE;
        }
    }

    public final void loadOnline(Context context, int resId) {
        Intrinsics.checkNotNullParameter(context, "context");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(context, resId, this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object reloadJsonFromUrl(String str, Function1<? super OnlineJson, Unit> function1, Continuation<? super Unit> continuation) {
        C00621 c00621;
        if (continuation instanceof C00621) {
            c00621 = (C00621) continuation;
            if ((c00621.label & Integer.MIN_VALUE) != 0) {
                c00621.label -= Integer.MIN_VALUE;
            } else {
                c00621 = new C00621(continuation);
            }
        } else {
            c00621 = new C00621(continuation);
        }
        Object objDownloadOnlineData = c00621.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c00621.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objDownloadOnlineData);
            NetUpdateRepository netUpdateRepository = new NetUpdateRepository();
            c00621.L$0 = function1;
            c00621.label = 1;
            objDownloadOnlineData = netUpdateRepository.downloadOnlineData(str, c00621);
            if (objDownloadOnlineData == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function1 = (Function1) c00621.L$0;
            ResultKt.throwOnFailure(objDownloadOnlineData);
        }
        OnlineJson onlineJson = (OnlineJson) objDownloadOnlineData;
        if (onlineJson != null) {
            function1.invoke(onlineJson);
            HiLog.INSTANCE.d(TAG, "downloadOnlineData:" + onlineJson.getRadioList().size());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void jsonTransformRadioSrource(Context context, OnlineJson jsons, Function1<? super List<RadioSource>, Unit> radios) {
        ArrayList arrayList = new ArrayList();
        SharedPrefUtils.INSTANCE.setParam(context, ConstantsKt.ONLINE_VERSION, Integer.valueOf(jsons.getVersion()));
        for (OnlineRadio onlineRadio : jsons.getRadioList()) {
            RadioSource radioSource = new RadioSource();
            radioSource.setType(onlineRadio.getRadioType());
            radioSource.setCountry(onlineRadio.getCountryName());
            radioSource.setLocal(onlineRadio.getRadioARea());
            radioSource.setFreqTitle(onlineRadio.getRadioFRequency());
            radioSource.setIcon(onlineRadio.getRadioIcon());
            radioSource.setTitle(onlineRadio.getRadioName());
            radioSource.setDisplayName(onlineRadio.getRadioName());
            radioSource.setPath(onlineRadio.getRadioURI());
            radioSource.setFolder("/");
            radioSource.setFavorite(false);
            arrayList.add(radioSource);
        }
        radios.invoke(arrayList);
    }
}
