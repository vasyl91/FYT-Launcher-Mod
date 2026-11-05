package com.syu.media.music.fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import androidx.lifecycle.LifecycleOwnerKt;
import chip.FinalChip;
import com.syu.media.ConstantsKt;
import com.syu.media.MainAct;
import com.syu.media.MediaApp;
import com.syu.media.base.BaseFragment;
import com.syu.media.entities.AudioSource;
import com.syu.media.entities.MediaSource;
import com.syu.media.service.MediaPresenter;
import com.syu.utils.BitmapUtils;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: MusicFragment.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.syu.media.music.fragment.MusicFragment$onChanged$1$2", f = "MusicFragment.kt", i = {}, l = {487}, m = "invokeSuspend", n = {}, s = {})
final class MusicFragment$onChanged$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isPlaying;
    final /* synthetic */ MediaSource $song;
    int label;
    final /* synthetic */ MusicFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MusicFragment$onChanged$1$2(MusicFragment musicFragment, MediaSource mediaSource, boolean z, Continuation<? super MusicFragment$onChanged$1$2> continuation) {
        super(2, continuation);
        this.this$0 = musicFragment;
        this.$song = mediaSource;
        this.$isPlaying = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MusicFragment$onChanged$1$2(this.this$0, this.$song, this.$isPlaying, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Bitmap bitmapScaleBitmap;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!Intrinsics.areEqual(this.this$0.lastSong.getCom.syu.media.provider.Media.PATH java.lang.String(), this.$song.getCom.syu.media.provider.Media.PATH java.lang.String())) {
                this.this$0.lastSong = this.$song;
            }
            MediaPresenter mediaPresenter = this.this$0.mediaPresenter;
            if (mediaPresenter != null) {
                mediaPresenter.enablePlayProgress(this.$isPlaying);
            }
            Bitmap bitmap = MediaApp.INSTANCE.getMe().getIconCache().get(this.$song.getCom.syu.media.provider.Media.PATH java.lang.String());
            if (bitmap != null) {
                DisplayMetrics displayMetrics = this.this$0.getResources().getDisplayMetrics();
                float fMax = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
                bitmapScaleBitmap = BitmapUtils.INSTANCE.scaleBitmap(bitmap, fMax, fMax, false);
            } else {
                bitmapScaleBitmap = null;
            }
            AudioSource existsAudioSource = this.this$0.getMediaDao().getExistsAudioSource(this.$song.getCom.syu.media.provider.Media.PATH java.lang.String());
            if (existsAudioSource != null) {
                this.$song.setFavorite(existsAudioSource.getFavorite());
            }
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this.this$0, this.$song, bitmapScaleBitmap, null), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicFragment$onChanged$1$2$2, reason: invalid class name */
    /* JADX INFO: compiled from: MusicFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.music.fragment.MusicFragment$onChanged$1$2$2", f = "MusicFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $cover;
        final /* synthetic */ MediaSource $song;
        int label;
        final /* synthetic */ MusicFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MusicFragment musicFragment, MediaSource mediaSource, Bitmap bitmap, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = musicFragment;
            this.$song = mediaSource;
            this.$cover = bitmap;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$song, this.$cover, continuation);
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
            MusicFragment.access$getBinding(this.this$0).musicFavorite.setChecked(this.$song.getFavorite());
            Job job = this.this$0.blurJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            MusicFragment musicFragment = this.this$0;
            musicFragment.blurJob = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(musicFragment), Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(this.this$0, this.$cover, null), 2, (Object) null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicFragment$onChanged$1$2$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: MusicFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.syu.media.music.fragment.MusicFragment$onChanged$1$2$2$1", f = "MusicFragment.kt", i = {}, l = {491}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Bitmap $cover;
            int label;
            final /* synthetic */ MusicFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MusicFragment musicFragment, Bitmap bitmap, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = musicFragment;
                this.$cover = bitmap;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$cover, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (DelayKt.delay(1000L, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                MusicFragment musicFragment = this.this$0;
                Bitmap bitmap = this.$cover;
                Intrinsics.checkNotNull(bitmap);
                final MusicFragment musicFragment2 = this.this$0;
                musicFragment.blurTransformation(bitmap, new Function1<Drawable, Unit>() { // from class: com.syu.media.music.fragment.MusicFragment.onChanged.1.2.2.1.1
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((Drawable) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Drawable drawable) {
                        BaseFragment baseFragmentFindFragmentByAction;
                        Intrinsics.checkNotNullParameter(drawable, "it");
                        MusicFragment musicFragment3 = musicFragment2;
                        musicFragment3.bkChanged(MusicFragment.access$getBinding(musicFragment3).musicFragBlurImg.getId(), drawable);
                        MainAct mainActRequireMainAct = musicFragment2.requireMainAct();
                        if (mainActRequireMainAct == null || (baseFragmentFindFragmentByAction = mainActRequireMainAct.findFragmentByAction(ConstantsKt.ACTION_PAGE_MUSIC_MAIN)) == null || !(baseFragmentFindFragmentByAction instanceof MusicMainFragment)) {
                            return;
                        }
                        ((MusicMainFragment) baseFragmentFindFragmentByAction).setBlurBk(drawable);
                    }
                });
                return Unit.INSTANCE;
            }
        }
    }
}
