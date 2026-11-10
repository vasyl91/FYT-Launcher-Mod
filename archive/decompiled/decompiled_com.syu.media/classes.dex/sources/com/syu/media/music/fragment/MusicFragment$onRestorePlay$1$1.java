package com.syu.media.music.fragment;

import chip.FinalChip;
import com.syu.media.ConstraintList;
import com.syu.media.MediaProxy;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.entities.PlayListWithAudios;
import com.syu.media.service.MediaPresenter;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: MusicFragment.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.syu.media.music.fragment.MusicFragment$onRestorePlay$1$1", f = "MusicFragment.kt", i = {}, l = {671}, m = "invokeSuspend", n = {}, s = {})
final class MusicFragment$onRestorePlay$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $storagePaths;
    final /* synthetic */ MediaProxy $this_run;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MusicFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MusicFragment$onRestorePlay$1$1(MediaProxy mediaProxy, MusicFragment musicFragment, List<String> list, Continuation<? super MusicFragment$onRestorePlay$1$1> continuation) {
        super(2, continuation);
        this.$this_run = mediaProxy;
        this.this$0 = musicFragment;
        this.$storagePaths = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> musicFragment$onRestorePlay$1$1 = new MusicFragment$onRestorePlay$1$1(this.$this_run, this.this$0, this.$storagePaths, continuation);
        musicFragment$onRestorePlay$1$1.L$0 = obj;
        return musicFragment$onRestorePlay$1$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            MediaProxy mediaProxy = this.$this_run;
            ConstraintList constraintList = this.this$0.constr;
            Intrinsics.checkNotNull(constraintList);
            MediaProxy.setupPlayList$default(mediaProxy, constraintList, null, 2, null);
            HiLog.INSTANCE.d(MusicFragment.TAG, "setupPlayList");
            this.this$0.getApp().getMediaFiles().InsertIfExist(this.this$0.playPath);
            this.label = 1;
            if (FlowKt.collectLatest(this.this$0.getMediaModel().getPlayListById(1), new AnonymousClass1(this.this$0, this.$storagePaths, this.$this_run, coroutineScope, null), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicFragment$onRestorePlay$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: MusicFragment.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "it", "Lcom/syu/media/entities/PlayListWithAudios;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.music.fragment.MusicFragment$onRestorePlay$1$1$1", f = "MusicFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<PlayListWithAudios, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $$this$launch;
        final /* synthetic */ List<String> $storagePaths;
        final /* synthetic */ MediaProxy $this_run;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MusicFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MusicFragment musicFragment, List<String> list, MediaProxy mediaProxy, CoroutineScope coroutineScope, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = musicFragment;
            this.$storagePaths = list;
            this.$this_run = mediaProxy;
            this.$$this$launch = coroutineScope;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, this.$storagePaths, this.$this_run, this.$$this$launch, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(PlayListWithAudios playListWithAudios, Continuation<? super Unit> continuation) {
            return create(playListWithAudios, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PlayListWithAudios playListWithAudios = (PlayListWithAudios) this.L$0;
            if (playListWithAudios != null) {
                MusicFragment musicFragment = this.this$0;
                List<String> list = this.$storagePaths;
                MediaProxy mediaProxy = this.$this_run;
                CoroutineScope coroutineScope = this.$$this$launch;
                HiLog.INSTANCE.d(MusicFragment.TAG, "playListById size:" + playListWithAudios.getAudios().size() + ", empty:" + playListWithAudios.isEmpty());
                boolean z = false;
                boolean z2 = musicFragment.containPath(playListWithAudios.getAudios(), musicFragment.playPath) && musicFragment.startsWith(list, musicFragment.playPath);
                if (musicFragment.mAdapter.getItemCount() != 0 && !musicFragment.playing && musicFragment.playOn) {
                    z = true;
                }
                HiLog.INSTANCE.d(MusicFragment.TAG, "restore containPath:" + z2);
                if (z2 && z && Intrinsics.areEqual(musicFragment.playPath, mediaProxy.getPlayState().getPlayPath())) {
                    HiLog.INSTANCE.d(MusicFragment.TAG, "restore constraint:" + musicFragment.constr);
                    MediaPresenter mediaPresenter = musicFragment.mediaPresenter;
                    if (mediaPresenter != null) {
                        HiLog.INSTANCE.d(MusicFragment.TAG, "restore playWithPath:" + musicFragment.playPath);
                        mediaPresenter.playWithPath(musicFragment.playPath);
                        musicFragment.needSeek = true;
                        musicFragment.first = musicFragment.playing;
                        musicFragment.playOn = musicFragment.playing;
                    }
                    CoroutineScopeKt.cancel$default(coroutineScope, (CancellationException) null, 1, (Object) null);
                }
            }
            return Unit.INSTANCE;
        }
    }
}
