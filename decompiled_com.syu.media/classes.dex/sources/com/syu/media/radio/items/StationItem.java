package com.syu.media.radio.items;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import chip.FinalChip;
import com.google.android.material.timepicker.TimeModel;
import com.syu.manger.AutoManager;
import com.syu.manger.module.radio.RadioController;
import com.syu.manger.module.radio.RadioModel;
import com.syu.manger.module.radio.RadioUtils;
import com.syu.media.MediaApp;
import com.syu.media.R;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.companion.utils.StringUtils;
import com.syu.radio.Radio;
import com.syu.radio.entities.Station;
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

/* JADX INFO: compiled from: StationItem.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/syu/media/radio/items/StationItem;", "Lsyu/recyclerview/Node;", "Lcom/syu/radio/entities/Station;", "()V", "listener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "getViewType", FinalChip.BSP_PLATFORM_Null, "onBindViewHolder", FinalChip.BSP_PLATFORM_Null, "holder", "Lsyu/recyclerview/ViewHolder;", "onClick", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "onLongClick", FinalChip.BSP_PLATFORM_Null, "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StationItem extends Node<Station> {
    private final CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() { // from class: com.syu.media.radio.items.StationItem$$ExternalSyntheticLambda0
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            StationItem.m333listener$lambda1(this.f$0, compoundButton, z);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: listener$lambda-1, reason: not valid java name */
    public static final void m333listener$lambda1(StationItem stationItem, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(stationItem, "this$0");
        Station station = (Station) stationItem.getData();
        if (station != null) {
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new StationItem$listener$1$1$1(stationItem, z, station, null), 3, (Object) null);
        }
    }

    public int getViewType() {
        return R.layout.radio_station_item_layout;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x009e  */
    public void onBindViewHolder(ViewHolder holder) {
        boolean z;
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
        Station station = (Station) getData();
        if (station != null) {
            ImageView imageView = (ImageView) holder.findViewById(R.id.station_item_cover);
            View view = holder.itemView;
            RadioModel radioModel = MediaApp.INSTANCE.getMe().getRadioModel();
            Log.d("StationItem", "--------------- " + station);
            Integer value = radioModel.getMChannel().getValue();
            int id = station.getId();
            if (value != null && value.intValue() == id) {
                Integer value2 = radioModel.getMFreq().getValue();
                z = value2 != null && value2.intValue() == station.getFreq();
            }
            view.setSelected(Boolean.valueOf(z).booleanValue());
            holder.setTextView(R.id.station_item_freq, RadioUtils.INSTANCE.freq2Text(station.getFreq()));
            holder.setTextView(R.id.station_item_unit, RadioUtils.INSTANCE.unitOfFreq(station.getFreq()));
            String value3 = MediaApp.INSTANCE.getMe().getMainModel().getCity().getValue();
            if (value3 == null) {
                value3 = Radio.DEF_STR;
            }
            Intrinsics.checkNotNullExpressionValue(value3, "MediaApp.me.mainModel.city.value ?: Radio.DEF_STR");
            boolean propForBoolean = Utils.getPropForBoolean("ro.client.foreign", false);
            boolean zIsChineseByReg = StringUtils.INSTANCE.isChineseByReg(value3);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = Radio.DEF_STR;
            MediaApp me = MediaApp.INSTANCE.getMe();
            if (!propForBoolean || !zIsChineseByReg) {
                objectRef2.element = value3;
            }
            Log.e("StationItem", "-------city:" + ((String) objectRef2.element));
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new StationItem$onBindViewHolder$2$2(objectRef, me, station, objectRef2, holder, this, imageView, null), 3, (Object) null);
        }
    }

    public void onClick(RecyclerView.ViewHolder holder, int position) {
        RadioController radioController;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onClick(holder, position);
        Station station = (Station) getData();
        if (station == null || (radioController = AutoManager.INSTANCE.requestInstance().getRadioController()) == null) {
            return;
        }
        radioController.toChannel(station.getId());
    }

    public boolean onLongClick(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Station station = (Station) getData();
        if (station == null) {
            return true;
        }
        HiLog.INSTANCE.e("radio1", "--------------- item radioStation:" + station.getFreq());
        RadioController radioController = AutoManager.INSTANCE.requestInstance().getRadioController();
        if (radioController == null) {
            return true;
        }
        radioController.saveChannel(station.getId());
        return true;
    }
}
