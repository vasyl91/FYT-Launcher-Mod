package com.syu.media.radio.items;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import chip.FinalChip;
import com.google.android.material.timepicker.TimeModel;
import com.syu.manger.AutoManager;
import com.syu.manger.module.radio.RadioController;
import com.syu.manger.module.radio.RadioUtils;
import com.syu.media.R;
import com.syu.media.radio.dialog.EditorDialog;
import com.syu.radio.entities.RadioStation;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import syu.recyclerview.Node;
import syu.recyclerview.ViewHolder;

/* JADX INFO: compiled from: EditorStationItem.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"Lcom/syu/media/radio/items/EditorStationItem;", "Lsyu/recyclerview/Node;", "Lcom/syu/radio/entities/RadioStation;", "()V", "getViewType", FinalChip.BSP_PLATFORM_Null, "onBindViewHolder", FinalChip.BSP_PLATFORM_Null, "holder", "Lsyu/recyclerview/ViewHolder;", "onClick", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "onLongClick", FinalChip.BSP_PLATFORM_Null, "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EditorStationItem extends Node<RadioStation> {
    public int getViewType() {
        return R.layout.radio_editor_station_item_layout;
    }

    public void onBindViewHolder(ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        int iIndex = index();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(iIndex + 1)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        holder.setTextView(R.id.radio_edit_station_item_number, str);
        final RadioStation radioStation = (RadioStation) getData();
        if (radioStation != null) {
            Integer freq = radioStation.getFreq();
            if (freq != null) {
                int iIntValue = freq.intValue();
                holder.setTextView(R.id.radio_edit_station_item_freq, RadioUtils.INSTANCE.freq2Text(iIntValue));
                holder.setTextView(R.id.radio_edit_station_item_unit, RadioUtils.INSTANCE.unitOfFreq(iIntValue));
            }
            int i = R.id.radio_edit_station_item_name;
            String title = radioStation.getTitle();
            if (title == null) {
                title = FinalChip.BSP_PLATFORM_Null;
            }
            holder.setTextView(i, title);
            ImageView imageView = (ImageView) holder.findViewById(R.id.radio_edit__station_item_edit);
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.radio.items.EditorStationItem$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        EditorStationItem.m329onBindViewHolder$lambda4$lambda2(radioStation, view);
                    }
                });
            }
            ImageView imageView2 = (ImageView) holder.findViewById(R.id.radio_edit__station_item_remove);
            if (imageView2 != null) {
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.radio.items.EditorStationItem$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        EditorStationItem.m330onBindViewHolder$lambda4$lambda3(radioStation, view);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onBindViewHolder$lambda-4$lambda-2, reason: not valid java name */
    public static final void m329onBindViewHolder$lambda4$lambda2(RadioStation radioStation, View view) {
        Intrinsics.checkNotNullParameter(radioStation, "$this_apply");
        EditorDialog.INSTANCE.getMe().editChannel(radioStation, R.string.radio_dialog_editor_edit, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onBindViewHolder$lambda-4$lambda-3, reason: not valid java name */
    public static final void m330onBindViewHolder$lambda4$lambda3(RadioStation radioStation, View view) {
        Intrinsics.checkNotNullParameter(radioStation, "$this_apply");
        if (radioStation.getFreq() != null) {
            EditorDialog.INSTANCE.getMe().editChannel(radioStation, R.string.radio_dialog_editor_remove, 3);
        }
    }

    public void onClick(RecyclerView.ViewHolder holder, int position) {
        Integer id;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onClick(holder, position);
        RadioStation radioStation = (RadioStation) getData();
        if (radioStation == null || (id = radioStation.getId()) == null) {
            return;
        }
        int iIntValue = id.intValue();
        RadioController radioController = AutoManager.INSTANCE.requestInstance().getRadioController();
        if (radioController != null) {
            radioController.toChannel(iIntValue);
        }
    }

    public boolean onLongClick(RecyclerView.ViewHolder holder, int position) {
        Integer id;
        Intrinsics.checkNotNullParameter(holder, "holder");
        RadioStation radioStation = (RadioStation) getData();
        if (radioStation == null || (id = radioStation.getId()) == null) {
            return true;
        }
        int iIntValue = id.intValue();
        RadioController radioController = AutoManager.INSTANCE.requestInstance().getRadioController();
        if (radioController == null) {
            return true;
        }
        radioController.saveChannel(iIntValue);
        return true;
    }
}
