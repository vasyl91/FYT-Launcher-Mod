package com.syu.carinfo.lz.jaguar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class TDLandRoverNewECOCarinfoAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverNewECOCarinfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 158:
                case 159:
                    int bit1 = DataCanbus.DATA[158];
                    int bit0 = DataCanbus.DATA[159];
                    if (bit1 == 1 && bit0 == 1) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image7)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_ac_p));
                        break;
                    } else if (bit1 == 1 && bit0 == 0) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image7)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_ac2));
                        break;
                    } else if (bit1 == 0 && bit0 == 1) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image7)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_ac1));
                        break;
                    } else {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image7)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_ac_n));
                        break;
                    }
                case 160:
                    if (value == 1) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image6)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_light_p));
                        break;
                    } else {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image6)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_light_n));
                        break;
                    }
                case 161:
                    if (value == 1) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_front_p));
                        break;
                    } else {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_front_n));
                        break;
                    }
                case 162:
                    if (value == 1) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image2)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_steer_p));
                        break;
                    } else {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image2)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_steer_n));
                        break;
                    }
                case 163:
                    if (value == 1) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image5)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_rear_p));
                        break;
                    } else {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image5)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_rear_n));
                        break;
                    }
                case 164:
                    if (value == 1) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image8)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_seat_p));
                        break;
                    } else {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image8)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_seat_n));
                        break;
                    }
                case 165:
                    if (value == 1) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image3)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_seat_p));
                        break;
                    } else {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image3)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_seat_n));
                        break;
                    }
                case 166:
                    if (value == 1) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image9)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_seat_p));
                        break;
                    } else {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image9)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_seat_n));
                        break;
                    }
                case 167:
                    if (value == 1) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image4)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_seat_p));
                        break;
                    } else {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image4)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_seat_n));
                        break;
                    }
                case 168:
                    ((ProgressBar) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.pa_jeep_seekbar1)).setProgress(value);
                    ((ProgressBar) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.pa_jeep_seekbar1)).invalidate();
                    break;
                case 169:
                    if (value >= 10 && value <= 50) {
                        ((TextView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10));
                        break;
                    } else {
                        ((TextView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.tv_text2)).setText("---");
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_td_landrover_neweco_info);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        v.getId();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(0, new int[]{101}, null, null);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
    }
}
