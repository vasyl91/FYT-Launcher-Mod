package com.syu.media.online.item;

import android.graphics.Bitmap;
import android.widget.ImageView;
import chip.FinalChip;
import com.syu.media.MediaApp;
import com.syu.media.R;
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
import syu.recyclerview.ViewHolder;

/* JADX INFO: compiled from: OnlineDetailItem.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.syu.media.online.item.OnlineDetailItem$onBindViewHolder$1$2", f = "OnlineDetailItem.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
final class OnlineDetailItem$onBindViewHolder$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ViewHolder $holder;
    final /* synthetic */ RadioSource $it;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnlineDetailItem$onBindViewHolder$1$2(RadioSource radioSource, ViewHolder viewHolder, Continuation<? super OnlineDetailItem$onBindViewHolder$1$2> continuation) {
        super(2, continuation);
        this.$it = radioSource;
        this.$holder = viewHolder;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnlineDetailItem$onBindViewHolder$1$2(this.$it, this.$holder, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.$it.getCom.syu.media.provider.Media.ICON java.lang.String();
            RadioSource radioSource = this.$it;
            MediaApp me = MediaApp.INSTANCE.getMe();
            Bitmap bitmapDecodeBitmap = me.getResourcesLoader().decodeBitmap(str);
            if (bitmapDecodeBitmap == null) {
                bitmapDecodeBitmap = me.getIconCache().get(radioSource.getCom.syu.media.provider.Media.PATH java.lang.String());
            }
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$holder, this.$it, bitmapDecodeBitmap, null), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.syu.media.online.item.OnlineDetailItem$onBindViewHolder$1$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: OnlineDetailItem.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.online.item.OnlineDetailItem$onBindViewHolder$1$2$1", f = "OnlineDetailItem.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $cover;
        final /* synthetic */ ViewHolder $holder;
        final /* synthetic */ RadioSource $it;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ViewHolder viewHolder, RadioSource radioSource, Bitmap bitmap, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$holder = viewHolder;
            this.$it = radioSource;
            this.$cover = bitmap;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$holder, this.$it, this.$cover, continuation);
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
            ImageView imageView = (ImageView) this.$holder.findViewById(R.id.online_item_cover);
            if (imageView != null && imageView.getContext() != null && !Intrinsics.areEqual(this.$it.getId(), imageView.getTag())) {
                imageView.setTag(null);
                imageView.setImageBitmap(this.$cover);
                imageView.setTag(this.$it.getId());
            }
            return Unit.INSTANCE;
        }
    }
}
