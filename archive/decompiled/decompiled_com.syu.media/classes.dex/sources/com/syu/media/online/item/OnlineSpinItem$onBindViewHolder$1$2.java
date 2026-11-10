package com.syu.media.online.item;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;
import chip.FinalChip;
import com.bumptech.glide.Glide;
import com.syu.media.MediaApp;
import com.syu.media.entities.RadioSource;
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

/* JADX INFO: compiled from: OnlineSpinItem.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.syu.media.online.item.OnlineSpinItem$onBindViewHolder$1$2", f = "OnlineSpinItem.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
final class OnlineSpinItem$onBindViewHolder$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImageView $img;
    final /* synthetic */ RadioSource $song;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnlineSpinItem$onBindViewHolder$1$2(RadioSource radioSource, ImageView imageView, Continuation<? super OnlineSpinItem$onBindViewHolder$1$2> continuation) {
        super(2, continuation);
        this.$song = radioSource;
        this.$img = imageView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnlineSpinItem$onBindViewHolder$1$2(this.$song, this.$img, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.syu.media.online.item.OnlineSpinItem$onBindViewHolder$1$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: OnlineSpinItem.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.online.item.OnlineSpinItem$onBindViewHolder$1$2$1", f = "OnlineSpinItem.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ImageView $img;
        final /* synthetic */ RadioSource $song;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RadioSource radioSource, ImageView imageView, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$song = radioSource;
            this.$img = imageView;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$song, this.$img, continuation);
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
            String str = this.$song.getCom.syu.media.provider.Media.ICON java.lang.String();
            RadioSource radioSource = this.$song;
            MediaApp me = MediaApp.INSTANCE.getMe();
            Bitmap bitmapDecodeBitmap = me.getResourcesLoader().decodeBitmap(str);
            if (bitmapDecodeBitmap == null) {
                bitmapDecodeBitmap = me.getIconCache().get(radioSource.getCom.syu.media.provider.Media.PATH java.lang.String());
            }
            Log.d(OnlineSpinItem.INSTANCE.getTAG(), " itemView:" + this.$img + " ,img:" + bitmapDecodeBitmap + " ,name:" + this.$song + ".displayName");
            ImageView imageView = this.$img;
            if (imageView != null && imageView.getContext() != null && !Intrinsics.areEqual(this.$song.getId(), this.$img.getTag())) {
                this.$img.setTag(null);
                Glide.with(this.$img).load(bitmapDecodeBitmap).into(this.$img);
                this.$img.setTag(this.$song.getId());
            }
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$song, this.$img, null), (Continuation) this) == coroutine_suspended) {
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
}
