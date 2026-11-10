package com.syu.media.online.item;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import chip.FinalChip;
import com.fasterxml.aalto.util.XmlConsts;
import com.google.android.material.timepicker.TimeModel;
import com.syu.media.MediaHelper;
import com.syu.media.MediaProxy;
import com.syu.media.R;
import com.syu.media.entities.RadioSource;
import com.syu.media.service.MediaPresenter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import syu.recyclerview.GroupNode;
import syu.recyclerview.Node;
import syu.recyclerview.ViewHolder;

/* JADX INFO: compiled from: OnlineDetailItem.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/syu/media/online/item/OnlineDetailItem;", "Lsyu/recyclerview/Node;", "Lcom/syu/media/entities/RadioSource;", "()V", "listener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "getViewType", FinalChip.BSP_PLATFORM_Null, "onBindViewHolder", FinalChip.BSP_PLATFORM_Null, "holder", "Lsyu/recyclerview/ViewHolder;", "onClick", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "tag", FinalChip.BSP_PLATFORM_Null, "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OnlineDetailItem extends Node<RadioSource> {
    public static final String TAG = "OnlineDetailItem";
    private final CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() { // from class: com.syu.media.online.item.OnlineDetailItem$$ExternalSyntheticLambda0
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            OnlineDetailItem.m214listener$lambda1(this.f$0, compoundButton, z);
        }
    };

    public int getViewType() {
        return R.layout.online_detail_item;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: listener$lambda-1, reason: not valid java name */
    public static final void m214listener$lambda1(OnlineDetailItem onlineDetailItem, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(onlineDetailItem, "this$0");
        RadioSource radioSource = (RadioSource) onlineDetailItem.getData();
        if (radioSource != null) {
            radioSource.setFavorite(z);
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new OnlineDetailItem$listener$1$1$1(radioSource, z, onlineDetailItem, null), 3, (Object) null);
        }
    }

    public void onBindViewHolder(ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder);
        CheckBox checkBox = (CheckBox) holder.findViewById(R.id.online_item_favorite);
        TextView textView = (TextView) holder.findViewById(R.id.online_item_index);
        RadioSource radioSource = (RadioSource) getData();
        if (radioSource != null) {
            if (checkBox != null) {
                checkBox.setOnCheckedChangeListener(null);
            }
            if (checkBox != null) {
                checkBox.setChecked(radioSource.getFavorite());
            }
            if (checkBox != null) {
                checkBox.setOnCheckedChangeListener(this.listener);
            }
            View view = holder.itemView;
            String path = radioSource.getCom.syu.media.provider.Media.PATH java.lang.String();
            MediaProxy audioProxy = MediaHelper.INSTANCE.getHelper().getAudioProxy();
            view.setSelected(Intrinsics.areEqual(path, audioProxy != null ? audioProxy.getOnlinePath() : null));
            StringBuilder sbAppend = new StringBuilder("onClick path:").append(radioSource.getCom.syu.media.provider.Media.PATH java.lang.String()).append(", onlinePath:");
            MediaProxy audioProxy2 = MediaHelper.INSTANCE.getHelper().getAudioProxy();
            Log.d(TAG, sbAppend.append(audioProxy2 != null ? audioProxy2.getOnlinePath() : null).toString());
            int i = R.id.online_item_title;
            String displayName = radioSource.getCom.syu.media.provider.Media.DISPLAY_NAME java.lang.String();
            if (displayName == null) {
                displayName = FinalChip.BSP_PLATFORM_Null;
            }
            holder.setTextView(i, displayName);
            holder.setTextView(R.id.online_item_info, radioSource.getCom.syu.media.provider.Media.LOCAL java.lang.String() + " / " + radioSource.getCom.syu.media.provider.Media.TYPE java.lang.String() + XmlConsts.CHAR_SPACE);
            int iIndex = index();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(iIndex + 1)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            if (textView != null) {
                textView.setText(str);
            }
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new OnlineDetailItem$onBindViewHolder$1$2(radioSource, holder, null), 3, (Object) null);
        }
    }

    public void onClick(RecyclerView.ViewHolder holder, int position, Object tag) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Log.d(TAG, "onClick radio:" + position);
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
                ((MediaPresenter) tag).playPlayList(TypeIntrinsics.asMutableList(arrayList2), radioSource);
            }
        }
    }
}
