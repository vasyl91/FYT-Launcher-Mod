package com.syu.media.online.item;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import chip.FinalChip;
import com.syu.media.MediaHelper;
import com.syu.media.MediaProxy;
import com.syu.media.R;
import com.syu.media.entities.MediaSource;
import com.syu.media.entities.RadioSource;
import com.syu.media.service.MediaPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import syu.recyclerview.GroupNode;
import syu.recyclerview.Node;
import syu.recyclerview.ViewHolder;

/* JADX INFO: compiled from: OnlineSpinItem.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0017J \u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/syu/media/online/item/OnlineSpinItem;", "Lsyu/recyclerview/Node;", "Lcom/syu/media/entities/RadioSource;", "()V", "getViewType", FinalChip.BSP_PLATFORM_Null, "onBindViewHolder", FinalChip.BSP_PLATFORM_Null, "holder", "Lsyu/recyclerview/ViewHolder;", "onClick", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "tag", FinalChip.BSP_PLATFORM_Null, "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OnlineSpinItem extends Node<RadioSource> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "OnlineSpinItem";

    /* JADX INFO: compiled from: OnlineSpinItem.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/syu/media/online/item/OnlineSpinItem$Companion;", FinalChip.BSP_PLATFORM_Null, "()V", "TAG", FinalChip.BSP_PLATFORM_Null, "getTAG", "()Ljava/lang/String;", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return OnlineSpinItem.TAG;
        }
    }

    public int getViewType() {
        return R.layout.music_main_list_skid_item;
    }

    public void onBindViewHolder(ViewHolder holder) {
        MediaSource playingSource;
        Intrinsics.checkNotNullParameter(holder, "holder");
        ImageView imageView = (ImageView) holder.findViewById(R.id.music_item_skid_img);
        RadioSource radioSource = (RadioSource) getData();
        if (radioSource != null) {
            View view = holder.itemView;
            MediaProxy audioProxy = MediaHelper.INSTANCE.getHelper().getAudioProxy();
            view.setSelected((audioProxy == null || (playingSource = audioProxy.getPlayingSource()) == null) ? false : Boolean.valueOf(Intrinsics.areEqual(playingSource.getCom.syu.media.provider.Media.PATH java.lang.String(), radioSource.getCom.syu.media.provider.Media.PATH java.lang.String())).booleanValue());
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new OnlineSpinItem$onBindViewHolder$1$2(radioSource, imageView, null), 3, (Object) null);
        }
    }

    public void onClick(RecyclerView.ViewHolder holder, int position, Object tag) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Log.d(OnlineItem.TAG, "onClick radio:" + position);
        RadioSource radioSource = (RadioSource) getData();
        if (radioSource != null) {
            GroupNode parent = getParent();
            Intrinsics.checkNotNull(parent);
            List children = parent.getChildren();
            ArrayList arrayList = new ArrayList();
            Iterator it = children.iterator();
            while (it.hasNext()) {
                Object data = ((Node) it.next()).getData();
                if (data == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.syu.media.entities.RadioSource");
                }
                RadioSource radioSource2 = (RadioSource) data;
                if (radioSource2 != null) {
                    arrayList.add(radioSource2);
                }
            }
            ArrayList arrayList2 = arrayList;
            if (tag instanceof MediaPresenter) {
                Log.d(OnlineItem.TAG, "onClick radio:" + arrayList2);
                ((MediaPresenter) tag).playPlayList(TypeIntrinsics.asMutableList(arrayList2), radioSource);
            }
        }
    }
}
