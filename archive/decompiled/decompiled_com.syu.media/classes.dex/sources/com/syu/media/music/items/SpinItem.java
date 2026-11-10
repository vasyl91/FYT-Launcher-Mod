package com.syu.media.music.items;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import chip.FinalChip;
import com.syu.media.MediaHelper;
import com.syu.media.MediaProxy;
import com.syu.media.R;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.entities.AudioSource;
import com.syu.media.entities.MediaSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import syu.recyclerview.GroupNode;
import syu.recyclerview.Node;
import syu.recyclerview.ViewHolder;

/* JADX INFO: compiled from: SpinItem.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0017J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\r"}, d2 = {"Lcom/syu/media/music/items/SpinItem;", "Lsyu/recyclerview/Node;", "Lcom/syu/media/entities/AudioSource;", "()V", "getViewType", FinalChip.BSP_PLATFORM_Null, "onBindViewHolder", FinalChip.BSP_PLATFORM_Null, "holder", "Lsyu/recyclerview/ViewHolder;", "onClick", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SpinItem extends Node<AudioSource> {
    public int getViewType() {
        return R.layout.music_main_list_skid_item;
    }

    public void onBindViewHolder(ViewHolder holder) {
        MediaSource playingSource;
        Intrinsics.checkNotNullParameter(holder, "holder");
        ImageView imageView = (ImageView) holder.findViewById(R.id.music_item_skid_img);
        AudioSource audioSource = (AudioSource) getData();
        if (audioSource != null) {
            View view = holder.itemView;
            MediaProxy audioProxy = MediaHelper.INSTANCE.getHelper().getAudioProxy();
            view.setSelected((audioProxy == null || (playingSource = audioProxy.getPlayingSource()) == null) ? false : Boolean.valueOf(Intrinsics.areEqual(playingSource.getCom.syu.media.provider.Media.PATH java.lang.String(), audioSource.getCom.syu.media.provider.Media.PATH java.lang.String())).booleanValue());
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new SpinItem$onBindViewHolder$1$2(audioSource, imageView, null), 3, (Object) null);
        }
    }

    public void onClick(RecyclerView.ViewHolder holder, int position) {
        ArrayList arrayList;
        List children;
        Intrinsics.checkNotNullParameter(holder, "holder");
        HiLog.INSTANCE.d("SpinItem", "01 ListItem onClick item music :: " + getData() + "  position :: " + position);
        MediaProxy audioProxy = MediaHelper.INSTANCE.getHelper().getAudioProxy();
        if (audioProxy != null) {
            GroupNode parent = getParent();
            if (parent == null || (children = parent.getChildren()) == null) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = new ArrayList();
                Iterator it = children.iterator();
                while (it.hasNext()) {
                    Object data = ((Node) it.next()).getData();
                    if (data != null) {
                        arrayList2.add(data);
                    }
                }
                arrayList = arrayList2;
            }
            HiLog.INSTANCE.d("SpinItem", "02 ListItem onClick item music :: " + getData() + "  position :: " + position + " musicPresenter :: " + audioProxy.getMPresenter());
            if (arrayList != null) {
                MediaSource playingSource = audioProxy.getPlayingSource();
                String str = playingSource != null ? playingSource.getCom.syu.media.provider.Media.PATH java.lang.String() : null;
                Object data2 = getData();
                Intrinsics.checkNotNull(data2);
                if (Intrinsics.areEqual(str, ((AudioSource) data2).getCom.syu.media.provider.Media.PATH java.lang.String())) {
                    return;
                }
                BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new SpinItem$onClick$1$2$1(audioProxy, arrayList, null), 3, (Object) null);
                audioProxy.getMPresenter().playPlayList(TypeIntrinsics.asMutableList(arrayList), position);
            }
        }
    }
}
