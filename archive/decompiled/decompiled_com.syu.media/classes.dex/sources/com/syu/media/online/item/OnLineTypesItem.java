package com.syu.media.online.item;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import chip.FinalChip;
import com.syu.media.MediaApp;
import com.syu.media.R;
import com.syu.media.entities.RadioSource;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import syu.recyclerview.GroupNode;
import syu.recyclerview.Node;
import syu.recyclerview.ViewHolder;

/* JADX INFO: compiled from: OnLineTypesItem.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/syu/media/online/item/OnLineTypesItem;", "Lsyu/recyclerview/GroupNode;", "Lcom/syu/media/online/item/OnlineTypeOrLocal;", "()V", "getViewType", FinalChip.BSP_PLATFORM_Null, "loadChildren", FinalChip.BSP_PLATFORM_Null, "Lsyu/recyclerview/Node;", "onBindViewHolder", FinalChip.BSP_PLATFORM_Null, "holder", "Lsyu/recyclerview/ViewHolder;", "onClick", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "tag", FinalChip.BSP_PLATFORM_Null, "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OnLineTypesItem extends GroupNode<OnlineTypeOrLocal> {
    public int getViewType() {
        return R.layout.online_menu_group_item;
    }

    public List<Node<?>> loadChildren() {
        List<RadioSource> radiosByLocal;
        OnlineTypeOrLocal onlineTypeOrLocal = (OnlineTypeOrLocal) getData();
        if (onlineTypeOrLocal != null) {
            if (onlineTypeOrLocal.getItemType() == 1) {
                radiosByLocal = MediaApp.INSTANCE.getMe().getDatabase().mediaDao().getRadiosByType(onlineTypeOrLocal.getTitle());
            } else {
                radiosByLocal = MediaApp.INSTANCE.getMe().getDatabase().mediaDao().getRadiosByLocal(onlineTypeOrLocal.getTitle());
            }
            Log.d("LZP", "loadChildren:+" + radiosByLocal.size());
            List<Node<?>> listCreateNodes = Node.Companion.createNodes(radiosByLocal, OnlineDetailItem.class, this);
            if (listCreateNodes != null) {
                return listCreateNodes;
            }
        }
        return new ArrayList();
    }

    public void onBindViewHolder(ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder);
        holder.itemView.setSelected(isExpanded());
        OnlineTypeOrLocal onlineTypeOrLocal = (OnlineTypeOrLocal) getData();
        if (onlineTypeOrLocal != null) {
            holder.setTextView(R.id.music_album_title, onlineTypeOrLocal.getTitle());
        }
    }

    public void onClick(RecyclerView.ViewHolder holder, int position, Object tag) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Log.d("OnLineTypesItem", "onClick radio:" + position);
        setExpanded(!isExpanded());
        holder.itemView.setSelected(isExpanded());
        super.onClick(holder, position, tag);
    }
}
