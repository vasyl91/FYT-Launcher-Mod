package com.syu.media.music.items;

import androidx.recyclerview.widget.RecyclerView;
import chip.FinalChip;
import com.syu.media.MediaApp;
import com.syu.media.R;
import com.syu.media.dao.MediaDao;
import com.syu.media.entities.AudioSource;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import syu.recyclerview.GroupNode;
import syu.recyclerview.Node;
import syu.recyclerview.ViewHolder;

/* JADX INFO: compiled from: FolderItem.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016¨\u0006\u0010"}, d2 = {"Lcom/syu/media/music/items/FolderItem;", "Lsyu/recyclerview/GroupNode;", "Lcom/syu/media/music/items/ConstraintFolder;", "()V", "getViewType", FinalChip.BSP_PLATFORM_Null, "loadChildren", FinalChip.BSP_PLATFORM_Null, "Lsyu/recyclerview/Node;", "onBindViewHolder", FinalChip.BSP_PLATFORM_Null, "holder", "Lsyu/recyclerview/ViewHolder;", "onClick", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FolderItem extends GroupNode<ConstraintFolder> {
    public int getViewType() {
        return R.layout.music_folder_layout;
    }

    public List<Node<?>> loadChildren() {
        List<AudioSource> audioSourcesWithFolder;
        ConstraintFolder constraintFolder = (ConstraintFolder) getData();
        if (constraintFolder != null) {
            if (constraintFolder.getFilterOfPath() != null && constraintFolder.getIsFavorite()) {
                MediaDao mediaDao = MediaApp.INSTANCE.getMe().getDatabase().mediaDao();
                String path = constraintFolder.getPath();
                String filterOfPath = constraintFolder.getFilterOfPath();
                Intrinsics.checkNotNull(filterOfPath);
                audioSourcesWithFolder = mediaDao.getAudioSourcesWithFolderAndFavorite(path, filterOfPath);
            } else if (constraintFolder.getFilterOfPath() != null) {
                MediaDao mediaDao2 = MediaApp.INSTANCE.getMe().getDatabase().mediaDao();
                String path2 = constraintFolder.getPath();
                String filterOfPath2 = constraintFolder.getFilterOfPath();
                Intrinsics.checkNotNull(filterOfPath2);
                audioSourcesWithFolder = mediaDao2.getAudioSourcesWithFolderAndParent(path2, filterOfPath2);
            } else {
                audioSourcesWithFolder = MediaApp.INSTANCE.getMe().getDatabase().mediaDao().getAudioSourcesWithFolder(constraintFolder.getPath());
            }
            List<Node<?>> listCreateNodes = Node.Companion.createNodes(audioSourcesWithFolder, AudioItem.class, this);
            if (listCreateNodes != null) {
                return listCreateNodes;
            }
        }
        return new ArrayList();
    }

    public void onBindViewHolder(ViewHolder holder) {
        String title;
        String path;
        Intrinsics.checkNotNullParameter(holder, "holder");
        int i = R.id.music_folder_title;
        ConstraintFolder constraintFolder = (ConstraintFolder) getData();
        String str = FinalChip.BSP_PLATFORM_Null;
        if (constraintFolder == null || (title = constraintFolder.getTitle()) == null) {
            title = FinalChip.BSP_PLATFORM_Null;
        }
        holder.setTextView(i, title);
        int i2 = R.id.music_folder_path;
        ConstraintFolder constraintFolder2 = (ConstraintFolder) getData();
        if (constraintFolder2 != null && (path = constraintFolder2.getPath()) != null) {
            str = path;
        }
        holder.setTextView(i2, str);
    }

    public void onClick(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        setExpanded(!isExpanded());
        holder.itemView.setSelected(isExpanded());
    }
}
