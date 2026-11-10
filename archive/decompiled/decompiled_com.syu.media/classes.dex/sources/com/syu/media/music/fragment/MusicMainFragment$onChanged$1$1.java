package com.syu.media.music.fragment;

import android.graphics.Bitmap;
import android.widget.ImageView;
import chip.FinalChip;
import com.syu.media.entities.MediaSource;
import com.syu.media.service.MediaPresenter;
import com.syu.utils.BitmapUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: MusicMainFragment.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$onChanged$1$1", f = "MusicMainFragment.kt", i = {}, l = {317}, m = "invokeSuspend", n = {}, s = {})
final class MusicMainFragment$onChanged$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isPlaying;
    final /* synthetic */ MediaSource $song;
    int label;
    final /* synthetic */ MusicMainFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MusicMainFragment$onChanged$1$1(MusicMainFragment musicMainFragment, MediaSource mediaSource, boolean z, Continuation<? super MusicMainFragment$onChanged$1$1> continuation) {
        super(2, continuation);
        this.this$0 = musicMainFragment;
        this.$song = mediaSource;
        this.$isPlaying = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MusicMainFragment$onChanged$1$1(this.this$0, this.$song, this.$isPlaying, continuation);
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
            Bitmap bitmap = this.this$0.getApp().getIconCache().get(this.$song.getCom.syu.media.provider.Media.PATH java.lang.String());
            if (bitmap != null) {
                MusicMainFragment musicMainFragment = this.this$0;
                float fMax = Math.max(musicMainFragment.displayWidth(), musicMainFragment.displayHeight());
                bitmapScaleBitmap = BitmapUtils.INSTANCE.scaleBitmap(bitmap, fMax, fMax, false);
            } else {
                bitmapScaleBitmap = null;
            }
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, bitmapScaleBitmap, null), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.syu.media.music.fragment.MusicMainFragment$onChanged$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: MusicMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.music.fragment.MusicMainFragment$onChanged$1$1$1", f = "MusicMainFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $cover;
        int label;
        final /* synthetic */ MusicMainFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MusicMainFragment musicMainFragment, Bitmap bitmap, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = musicMainFragment;
            this.$cover = bitmap;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$cover, continuation);
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
            ImageView albumView = this.this$0.getAlbumView();
            if (albumView != null) {
                albumView.setImageBitmap(this.$cover);
            }
            return Unit.INSTANCE;
        }
    }
}
