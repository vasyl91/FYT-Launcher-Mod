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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class TDLandRoverNewECOCarinfoAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverNewECOCarinfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 170:
                case 171:
                    int bit1 = DataCanbus.DATA[170];
                    int bit0 = DataCanbus.DATA[171];
                    if (bit1 == 1 && bit0 == 1) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image7)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_ac_p));
                    } else if (bit1 == 1 && bit0 == 0) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image7)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_ac2));
                    } else if (bit1 == 0 && bit0 == 1) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image7)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_ac1));
                    } else {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image7)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_ac_n));
                    }
                    break;
                case 172:
                    if (value == 1) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image6)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_light_p));
                    } else {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image6)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_light_n));
                    }
                    break;
                case 173:
                    if (value == 1) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_front_p));
                    } else {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_front_n));
                    }
                    break;
                case 174:
                    if (value == 1) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image2)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_steer_p));
                    } else {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image2)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_steer_n));
                    }
                    break;
                case 175:
                    if (value == 1) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image5)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_rear_p));
                    } else {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image5)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_rear_n));
                    }
                    break;
                case 176:
                    if (value == 1) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image8)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_seat_p));
                    } else {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image8)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_seat_n));
                    }
                    break;
                case 177:
                    if (value == 1) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image3)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_seat_p));
                    } else {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image3)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_seat_n));
                    }
                    break;
                case 178:
                    if (value == 1) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image9)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_seat_p));
                    } else {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image9)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_seat_n));
                    }
                    break;
                case 179:
                    if (value == 1) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image4)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_seat_p));
                    } else {
                        ((ImageView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.id_image4)).setImageDrawable(TDLandRoverNewECOCarinfoAct.this.getResources().getDrawable(R.drawable.ic_ta_landrover_seat_n));
                    }
                    break;
                case 180:
                    ((ProgressBar) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.pa_jeep_seekbar1)).setProgress(value);
                    ((ProgressBar) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.pa_jeep_seekbar1)).invalidate();
                    break;
                case 181:
                    if (value >= 10 && value <= 50) {
                        ((TextView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    } else {
                        ((TextView) TDLandRoverNewECOCarinfoAct.this.findViewById(R.id.tv_text2)).setText("---");
                    }
                    break;
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
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
    }
}
