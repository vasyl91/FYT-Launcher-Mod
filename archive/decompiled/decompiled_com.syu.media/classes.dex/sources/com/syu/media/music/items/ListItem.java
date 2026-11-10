package com.syu.media.music.items;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import chip.FinalChip;
import com.syu.media.MediaHelper;
import com.syu.media.MediaProxy;
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

/* JADX INFO: compiled from: ListItem.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/syu/media/music/items/ListItem;", "Lcom/syu/media/music/items/AudioItem;", "()V", "onClick", FinalChip.BSP_PLATFORM_Null, "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", FinalChip.BSP_PLATFORM_Null, "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ListItem extends AudioItem {
    @Override // com.syu.media.music.items.AudioItem
    public void onClick(RecyclerView.ViewHolder holder, int position) {
        ArrayList arrayList;
        List children;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Log.e("music", "01 ListItem onClick item music :: " + getData() + "  position :: " + position);
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
            Log.e("music", "02 ListItem onClick item music :: " + getData() + "  position :: " + position + " musicPresenter :: " + audioProxy.getMPresenter());
            if (arrayList != null) {
                BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new ListItem$onClick$1$2$1(audioProxy, arrayList, null), 3, (Object) null);
                audioProxy.getMPresenter().playPlayList(TypeIntrinsics.asMutableList(arrayList), position);
            }
        }
    }
}
