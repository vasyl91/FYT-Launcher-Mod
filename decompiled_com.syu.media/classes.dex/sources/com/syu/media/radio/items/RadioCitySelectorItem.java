package com.syu.media.radio.items;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import chip.FinalChip;
import com.syu.media.MediaApp;
import com.syu.media.R;
import com.syu.media.online.fragment.SelectorDialogFragment;
import com.syu.media.radio.dialog.CitySelectorDialogFrag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import syu.recyclerview.Node;
import syu.recyclerview.ViewHolder;

/* JADX INFO: compiled from: RadioCitySelectorItem.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/syu/media/radio/items/RadioCitySelectorItem;", "Lsyu/recyclerview/Node;", FinalChip.BSP_PLATFORM_Null, "()V", "getViewType", FinalChip.BSP_PLATFORM_Null, "onBindViewHolder", FinalChip.BSP_PLATFORM_Null, "holder", "Lsyu/recyclerview/ViewHolder;", "onClick", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "tag", FinalChip.BSP_PLATFORM_Null, "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class RadioCitySelectorItem extends Node<String> {
    public static final String TAG = "OnlineSelectorItem";

    public int getViewType() {
        return R.layout.radio_city_selector_dialog_item;
    }

    public void onBindViewHolder(ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder);
        String str = (String) getData();
        if (str != null) {
            String value = MediaApp.INSTANCE.getMe().getOnlineModel().getRadioCityName().getValue();
            View viewFindViewById = holder.findViewById(R.id.online_city_dialog_item);
            if (viewFindViewById != null) {
                viewFindViewById.setSelected(Intrinsics.areEqual(value, str));
            }
            holder.setTextView(R.id.online_city_dialog_item, str);
        }
    }

    public void onClick(RecyclerView.ViewHolder holder, int position, Object tag) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Log.d("OnlineSelectorItem", "onClick radio:" + position);
        String str = (String) getData();
        if (str != null) {
            if (tag instanceof SelectorDialogFragment) {
                MediaApp.INSTANCE.getMe().getOnlineModel().getCountryName().setValue(str);
                Log.d("OnlineSelectorItem", "onClick radio11:" + position);
                ((SelectorDialogFragment) tag).dismiss();
            } else if (tag instanceof CitySelectorDialogFrag) {
                MediaApp.INSTANCE.getMe().getOnlineModel().getRadioCityName().setValue(str);
                ((CitySelectorDialogFrag) tag).dismiss();
            }
        }
    }
}
