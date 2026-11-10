package com.syu.carinfo.lz.nissan.gtr;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZCMahindraCarInfo extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.nissan.gtr.RZCMahindraCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 114:
                    ((TextView) RZCMahindraCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "%");
                    break;
                case 115:
                    ((TextView) RZCMahindraCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "%");
                    break;
                case 116:
                    ((TextView) RZCMahindraCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "%");
                    break;
                case 117:
                    if (value > 180) {
                        ((TextView) RZCMahindraCarInfo.this.findViewById(R.id.tv_text4)).setText("+" + (value - 180));
                    } else if (value < 180) {
                        ((TextView) RZCMahindraCarInfo.this.findViewById(R.id.tv_text4)).setText("-" + (180 - value));
                    } else {
                        ((TextView) RZCMahindraCarInfo.this.findViewById(R.id.tv_text4)).setText("0");
                    }
                    break;
                case 118:
                    if (value > 180) {
                        ((TextView) RZCMahindraCarInfo.this.findViewById(R.id.tv_text5)).setText("+" + (value - 180));
                    } else if (value < 180) {
                        ((TextView) RZCMahindraCarInfo.this.findViewById(R.id.tv_text5)).setText("-" + (180 - value));
                    } else {
                        ((TextView) RZCMahindraCarInfo.this.findViewById(R.id.tv_text5)).setText("0");
                    }
                    break;
                case 119:
                    ((TextView) RZCMahindraCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "℃");
                    break;
                case 120:
                    ((TextView) RZCMahindraCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + "km/l");
                    break;
                case 121:
                    ((TextView) RZCMahindraCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + "km");
                    break;
                case 122:
                    ((TextView) RZCMahindraCarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value) + "km/h");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0454_rzc_mahindra_carinfo);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(1, new int[]{96, 0}, null, null);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
    }
}
