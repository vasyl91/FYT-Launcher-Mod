package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class DaojunVinFastCarInfo extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.DaojunVinFastCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    ((TextView) DaojunVinFastCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(val) + "%");
                    break;
                case 99:
                    switch (val) {
                        case 0:
                            ((TextView) DaojunVinFastCarInfo.this.findViewById(R.id.tv_text2)).setText("ECO");
                            break;
                        case 1:
                            ((TextView) DaojunVinFastCarInfo.this.findViewById(R.id.tv_text2)).setText(R.string.normal);
                            break;
                    }
                    break;
                case 100:
                    switch (val) {
                        case 0:
                            ((TextView) DaojunVinFastCarInfo.this.findViewById(R.id.tv_text3)).setText(R.string.klc_Parking_with_trailer_Off);
                            break;
                        case 1:
                            ((TextView) DaojunVinFastCarInfo.this.findViewById(R.id.tv_text3)).setText(R.string.klc_Parking_with_trailer_ON);
                            break;
                    }
                    break;
                case 101:
                    switch (val) {
                        case 0:
                            ((TextView) DaojunVinFastCarInfo.this.findViewById(R.id.tv_text4)).setText(R.string.klc_Parking_with_trailer_Off);
                            break;
                        case 1:
                            ((TextView) DaojunVinFastCarInfo.this.findViewById(R.id.tv_text4)).setText(R.string.klc_Parking_with_trailer_ON);
                            break;
                    }
                    break;
                case 102:
                    ((TextView) DaojunVinFastCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(val) + "%");
                    break;
                case 103:
                    ((TextView) DaojunVinFastCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(val) + "km");
                    break;
                case 104:
                    ((TextView) DaojunVinFastCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(val) + "km");
                    break;
                case 105:
                    ((TextView) DaojunVinFastCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(val) + "%");
                    break;
                case 106:
                    ((TextView) DaojunVinFastCarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(val) + "km");
                    break;
                case 107:
                    ((TextView) DaojunVinFastCarInfo.this.findViewById(R.id.tv_text10)).setText(String.valueOf(val) + "km/h");
                    break;
                case 108:
                    switch (val) {
                        case 1:
                            ((TextView) DaojunVinFastCarInfo.this.findViewById(R.id.tv_text11)).setText("P");
                            break;
                        case 2:
                            ((TextView) DaojunVinFastCarInfo.this.findViewById(R.id.tv_text11)).setText("R");
                            break;
                        case 3:
                            ((TextView) DaojunVinFastCarInfo.this.findViewById(R.id.tv_text11)).setText("N");
                            break;
                        case 4:
                            ((TextView) DaojunVinFastCarInfo.this.findViewById(R.id.tv_text11)).setText("D");
                            break;
                        case 5:
                            ((TextView) DaojunVinFastCarInfo.this.findViewById(R.id.tv_text11)).setText("M");
                            break;
                        case 6:
                            ((TextView) DaojunVinFastCarInfo.this.findViewById(R.id.tv_text11)).setText("L");
                            break;
                        default:
                            ((TextView) DaojunVinFastCarInfo.this.findViewById(R.id.tv_text11)).setText("--");
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0456_daojun_vinfast_carinfo);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        v.getId();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{49}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{50}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
    }
}
