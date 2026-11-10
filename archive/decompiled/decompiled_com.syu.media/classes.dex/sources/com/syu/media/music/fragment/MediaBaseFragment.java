package com.syu.media.music.fragment;

import androidx.viewbinding.ViewBinding;
import chip.FinalChip;
import com.syu.media.MediaHelper;
import com.syu.media.MediaProxy;
import com.syu.media.base.DataBindBaseFragment;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.dao.MediaDao;
import com.syu.media.entities.AudioSource;
import com.syu.media.entities.MediaSource;
import com.syu.media.entities.RadioSource;
import com.syu.media.model.MediaModel;
import com.syu.media.music.MusicModel;
import com.syu.media.online.viewmodel.OnlineViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import syu.recyclerview.Node;
import syu.recyclerview.NodeAdapter;

/* JADX INFO: compiled from: MediaBaseFragment.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 )*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001)B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0005¢\u0006\u0002\u0010\u0007J!\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010(R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b\u001f\u0010 \u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lcom/syu/media/music/fragment/MediaBaseFragment;", "DB", "Landroidx/viewbinding/ViewBinding;", "Lcom/syu/media/base/DataBindBaseFragment;", "contentLayoutId", FinalChip.BSP_PLATFORM_Null, "(I)V", "()V", "audioProxy", "Lcom/syu/media/MediaProxy;", "getAudioProxy", "()Lcom/syu/media/MediaProxy;", "audioProxy$delegate", "Lkotlin/Lazy;", "mediaDao", "Lcom/syu/media/dao/MediaDao;", "getMediaDao", "()Lcom/syu/media/dao/MediaDao;", "mediaDao$delegate", "mediaModel", "Lcom/syu/media/model/MediaModel;", "getMediaModel", "()Lcom/syu/media/model/MediaModel;", "mediaModel$delegate", "musicModel", "Lcom/syu/media/music/MusicModel;", "getMusicModel", "()Lcom/syu/media/music/MusicModel;", "musicModel$delegate", "onlineModel", "Lcom/syu/media/online/viewmodel/OnlineViewModel;", "getOnlineModel", "()Lcom/syu/media/online/viewmodel/OnlineViewModel;", "onlineModel$delegate", "notifyItemChanged", FinalChip.BSP_PLATFORM_Null, "adapter", "Lsyu/recyclerview/NodeAdapter;", "source", "Lcom/syu/media/entities/MediaSource;", "(Lsyu/recyclerview/NodeAdapter;Lcom/syu/media/entities/MediaSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class MediaBaseFragment<DB extends ViewBinding> extends DataBindBaseFragment<DB> {
    public static final String TAG = "MediaBaseFragment";

    /* JADX INFO: renamed from: audioProxy$delegate, reason: from kotlin metadata */
    private final Lazy audioProxy;

    /* JADX INFO: renamed from: mediaDao$delegate, reason: from kotlin metadata */
    private final Lazy mediaDao;

    /* JADX INFO: renamed from: mediaModel$delegate, reason: from kotlin metadata */
    private final Lazy mediaModel;

    /* JADX INFO: renamed from: musicModel$delegate, reason: from kotlin metadata */
    private final Lazy musicModel;

    /* JADX INFO: renamed from: onlineModel$delegate, reason: from kotlin metadata */
    private final Lazy onlineModel;

    public MediaBaseFragment() {
        this.mediaModel = LazyKt.lazy(new Function0<MediaModel>(this) { // from class: com.syu.media.music.fragment.MediaBaseFragment$mediaModel$2
            final /* synthetic */ MediaBaseFragment<DB> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final MediaModel m159invoke() {
                return this.this$0.getApp().getMediaModel();
            }
        });
        this.musicModel = LazyKt.lazy(new Function0<MusicModel>(this) { // from class: com.syu.media.music.fragment.MediaBaseFragment$musicModel$2
            final /* synthetic */ MediaBaseFragment<DB> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final MusicModel m160invoke() {
                return this.this$0.getApp().getMusicModel();
            }
        });
        this.onlineModel = LazyKt.lazy(new Function0<OnlineViewModel>(this) { // from class: com.syu.media.music.fragment.MediaBaseFragment$onlineModel$2
            final /* synthetic */ MediaBaseFragment<DB> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final OnlineViewModel m161invoke() {
                return this.this$0.getApp().getOnlineModel();
            }
        });
        this.mediaDao = LazyKt.lazy(new Function0<MediaDao>(this) { // from class: com.syu.media.music.fragment.MediaBaseFragment$mediaDao$2
            final /* synthetic */ MediaBaseFragment<DB> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final MediaDao m158invoke() {
                return this.this$0.getMediaModel().getMediaDao();
            }
        });
        this.audioProxy = LazyKt.lazy(new Function0<MediaProxy>() { // from class: com.syu.media.music.fragment.MediaBaseFragment$audioProxy$2
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final MediaProxy m157invoke() {
                return MediaHelper.INSTANCE.getHelper().getAudioProxy();
            }
        });
    }

    public MediaBaseFragment(int i) {
        this();
    }

    public final MediaModel getMediaModel() {
        return (MediaModel) this.mediaModel.getValue();
    }

    public final MusicModel getMusicModel() {
        return (MusicModel) this.musicModel.getValue();
    }

    public final OnlineViewModel getOnlineModel() {
        return (OnlineViewModel) this.onlineModel.getValue();
    }

    public final MediaDao getMediaDao() {
        return (MediaDao) this.mediaDao.getValue();
    }

    public final MediaProxy getAudioProxy() {
        return (MediaProxy) this.audioProxy.getValue();
    }

    public final Object notifyItemChanged(NodeAdapter nodeAdapter, MediaSource mediaSource, Continuation<? super Unit> continuation) {
        if (mediaSource instanceof RadioSource) {
            getMediaModel().getMediaDao().update((RadioSource) mediaSource);
        } else if (mediaSource instanceof AudioSource) {
            getMediaModel().getMediaDao().update((AudioSource) mediaSource);
        }
        return BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(nodeAdapter, mediaSource, null), continuation);
    }

    /* JADX INFO: renamed from: com.syu.media.music.fragment.MediaBaseFragment$notifyItemChanged$2, reason: invalid class name */
    /* JADX INFO: compiled from: MediaBaseFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "DB", "Landroidx/viewbinding/ViewBinding;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.music.fragment.MediaBaseFragment$notifyItemChanged$2", f = "MediaBaseFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ NodeAdapter $adapter;
        final /* synthetic */ MediaSource $source;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(NodeAdapter nodeAdapter, MediaSource mediaSource, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$adapter = nodeAdapter;
            this.$source = mediaSource;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$adapter, this.$source, continuation);
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
            Node nodeFindNode = this.$adapter.getMData().findNode(this.$source);
            if (nodeFindNode == null) {
                return null;
            }
            MediaSource mediaSource = this.$source;
            NodeAdapter nodeAdapter = this.$adapter;
            HiLog.INSTANCE.d("MediaBaseFragment", "notifyItemChanged index:" + nodeFindNode.index());
            Object data = nodeFindNode.getData();
            MediaSource mediaSource2 = data instanceof MediaSource ? (MediaSource) data : null;
            if (mediaSource2 != null) {
                mediaSource2.setFavorite(mediaSource.getFavorite());
            }
            nodeAdapter.notifyItemChanged(nodeAdapter.getMData().positionOf(mediaSource));
            return Unit.INSTANCE;
        }
    }
}
