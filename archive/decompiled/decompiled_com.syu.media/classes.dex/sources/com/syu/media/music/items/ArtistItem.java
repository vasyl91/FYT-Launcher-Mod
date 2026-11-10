package com.syu.media.music.items;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import chip.FinalChip;
import com.syu.media.MediaApp;
import com.syu.media.MediaFiles;
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

/* JADX INFO: compiled from: ArtistItem.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016¨\u0006\u0010"}, d2 = {"Lcom/syu/media/music/items/ArtistItem;", "Lsyu/recyclerview/GroupNode;", "Lcom/syu/media/music/items/ConstraintArtist;", "()V", "getViewType", FinalChip.BSP_PLATFORM_Null, "loadChildren", FinalChip.BSP_PLATFORM_Null, "Lsyu/recyclerview/Node;", "onBindViewHolder", FinalChip.BSP_PLATFORM_Null, "holder", "Lsyu/recyclerview/ViewHolder;", "onClick", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ArtistItem extends GroupNode<ConstraintArtist> {
    public int getViewType() {
        return R.layout.music_artist_layout;
    }

    public List<Node<?>> loadChildren() {
        List<AudioSource> audioSourcesOfArtist;
        ConstraintArtist constraintArtist = (ConstraintArtist) getData();
        if (constraintArtist != null) {
            if (constraintArtist.getFilterOfPath() != null && constraintArtist.getIsFavorite()) {
                MediaDao mediaDao = MediaApp.INSTANCE.getMe().getDatabase().mediaDao();
                String name = constraintArtist.getName();
                String filterOfPath = constraintArtist.getFilterOfPath();
                Intrinsics.checkNotNull(filterOfPath);
                audioSourcesOfArtist = mediaDao.getAudioSourcesByArtistAndPathAndFavorite(name, filterOfPath);
            } else if (constraintArtist.getFilterOfPath() != null) {
                MediaDao mediaDao2 = MediaApp.INSTANCE.getMe().getDatabase().mediaDao();
                String name2 = constraintArtist.getName();
                String filterOfPath2 = constraintArtist.getFilterOfPath();
                Intrinsics.checkNotNull(filterOfPath2);
                audioSourcesOfArtist = mediaDao2.getAudioSourcesByArtistAndPath(name2, filterOfPath2);
            } else {
                audioSourcesOfArtist = MediaApp.INSTANCE.getMe().getDatabase().mediaDao().getAudioSourcesOfArtist(constraintArtist.getName());
            }
            Log.e(AudioItem.TAG, "update item sources:" + audioSourcesOfArtist.size());
            List<Node<?>> listCreateNodes = Node.Companion.createNodes(audioSourcesOfArtist, AudioItem.class, this);
            if (listCreateNodes != null) {
                return listCreateNodes;
            }
        }
        return new ArrayList();
    }

    public void onBindViewHolder(ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ConstraintArtist constraintArtist = (ConstraintArtist) getData();
        if (constraintArtist != null) {
            holder.itemView.setSelected(isExpanded());
            int i = R.id.music_artist_name;
            String string = Intrinsics.areEqual(constraintArtist.getName(), MediaFiles.INSTANCE.getUNKNOWN()) ? holder.itemView.getContext().getString(R.string.artist_unknown) : constraintArtist.getName();
            Intrinsics.checkNotNullExpressionValue(string, "if (it.name == MediaFile…ist_unknown) else it.name");
            holder.setTextView(i, string);
            holder.setTextView(R.id.music_artist_audio_num, new StringBuilder().append(getChildren().size()).append((char) 39318).toString());
        }
    }

    public void onClick(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        setExpanded(!isExpanded());
        holder.itemView.setSelected(isExpanded());
    }
}
