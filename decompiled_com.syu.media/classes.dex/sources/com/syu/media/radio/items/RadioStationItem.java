package com.syu.media.radio.items;

import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.RecyclerView;
import chip.FinalChip;
import com.google.android.material.timepicker.TimeModel;
import com.syu.manger.AutoManager;
import com.syu.manger.module.radio.RadioController;
import com.syu.manger.module.radio.RadioUtils;
import com.syu.media.MediaApp;
import com.syu.media.R;
import com.syu.media.companion.utils.StringUtils;
import com.syu.radio.Radio;
import com.syu.radio.entities.RadioStation;
import com.syu.utils.Utils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import syu.recyclerview.Node;
import syu.recyclerview.ViewHolder;

/* JADX INFO: compiled from: RadioStationItem.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/syu/media/radio/items/RadioStationItem;", "Lsyu/recyclerview/Node;", "Lcom/syu/radio/entities/RadioStation;", "()V", "listener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "getViewType", FinalChip.BSP_PLATFORM_Null, "onBindViewHolder", FinalChip.BSP_PLATFORM_Null, "holder", "Lsyu/recyclerview/ViewHolder;", "onClick", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RadioStationItem extends Node<RadioStation> {
    private final CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() { // from class: com.syu.media.radio.items.RadioStationItem$$ExternalSyntheticLambda0
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            RadioStationItem.m331listener$lambda1(this.f$0, compoundButton, z);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: listener$lambda-1, reason: not valid java name */
    public static final void m331listener$lambda1(RadioStationItem radioStationItem, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(radioStationItem, "this$0");
        RadioStation radioStation = (RadioStation) radioStationItem.getData();
        if (radioStation != null) {
            radioStation.setFavorite(z);
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new RadioStationItem$listener$1$1$1(radioStationItem, radioStation, z, null), 3, (Object) null);
        }
    }

    public int getViewType() {
        return R.layout.radio_station_item_layout;
    }

    public void onBindViewHolder(ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        CheckBox checkBox = (CheckBox) holder.findViewById(R.id.station_item_favorite);
        if (checkBox != null) {
            checkBox.setOnCheckedChangeListener(null);
        }
        index();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(index() + 1)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        holder.setTextView(R.id.station_item_number, str);
        String value = MediaApp.INSTANCE.getMe().getMainModel().getCity().getValue();
        if (value == null) {
            value = Radio.DEF_STR;
        }
        boolean propForBoolean = Utils.getPropForBoolean("ro.client.foreign", false);
        boolean zIsChineseByReg = StringUtils.INSTANCE.isChineseByReg(value);
        RadioStation radioStation = (RadioStation) getData();
        if (radioStation != null) {
            holder.itemView.setSelected(Boolean.valueOf(Intrinsics.areEqual(MediaApp.INSTANCE.getMe().getRadioModel().getMFreq().getValue(), radioStation.getFreq())).booleanValue());
            Log.e("RadioStationItem", "station:" + radioStation);
            holder.setChecked(R.id.station_item_favorite, radioStation.getFavorite());
            CheckBox checkBox2 = (CheckBox) holder.findViewById(R.id.station_item_favorite);
            if (checkBox2 != null) {
                checkBox2.setOnCheckedChangeListener(this.listener);
            }
            Integer freq = radioStation.getFreq();
            if (freq != null) {
                int iIntValue = freq.intValue();
                holder.setTextView(R.id.station_item_freq, RadioUtils.INSTANCE.freq2Text(iIntValue));
                holder.setTextView(R.id.station_item_unit, RadioUtils.INSTANCE.unitOfFreq(iIntValue));
            }
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new RadioStationItem$onBindViewHolder$2$3(new Ref.ObjectRef(), radioStation, propForBoolean, zIsChineseByReg, holder, null), 3, (Object) null);
        }
    }

    public void onClick(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        RadioStation radioStation = (RadioStation) getData();
        if (radioStation != null) {
            RadioController radioController = AutoManager.INSTANCE.requestInstance().getRadioController();
            if (radioController != null) {
                RadioUtils radioUtils = RadioUtils.INSTANCE;
                Integer freq = radioStation.getFreq();
                Intrinsics.checkNotNull(freq);
                radioController.toBand(radioUtils.isFmFreq(freq.intValue()) ? 65536 : 0);
            }
            Utils.sleep(200L);
            RadioController radioController2 = AutoManager.INSTANCE.requestInstance().getRadioController();
            if (radioController2 != null) {
                Integer freq2 = radioStation.getFreq();
                Intrinsics.checkNotNull(freq2);
                radioController2.toFreq(freq2.intValue());
            }
        }
    }
}
