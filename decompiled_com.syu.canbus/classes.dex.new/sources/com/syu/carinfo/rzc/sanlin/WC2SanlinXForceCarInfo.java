package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WC2SanlinXForceCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.WC2SanlinXForceCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 122:
                    ((TextView) WC2SanlinXForceCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf((value - 400) / 10.0f) + " ℃");
                    break;
                case 123:
                    ((TextView) WC2SanlinXForceCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " hPa");
                    break;
                case 124:
                    ((TextView) WC2SanlinXForceCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "%");
                    break;
                case 125:
                    ((TextView) WC2SanlinXForceCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "%");
                    break;
                case 126:
                    ((TextView) WC2SanlinXForceCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value - 14) + " PSI");
                    break;
                case 127:
                    ((TextView) WC2SanlinXForceCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " NM");
                    break;
                case 128:
                    ((TextView) WC2SanlinXForceCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf((value - 10) / 10.0f) + " G");
                    break;
                case 129:
                    switch (value) {
                        case 1:
                            ((TextView) WC2SanlinXForceCarInfo.this.findViewById(R.id.tv_text8)).setText("Normal");
                            break;
                        case 2:
                            ((TextView) WC2SanlinXForceCarInfo.this.findViewById(R.id.tv_text8)).setText("WET");
                            break;
                        case 3:
                            ((TextView) WC2SanlinXForceCarInfo.this.findViewById(R.id.tv_text8)).setText("GRAVEL");
                            break;
                        case 4:
                            ((TextView) WC2SanlinXForceCarInfo.this.findViewById(R.id.tv_text8)).setText("MUD");
                            break;
                        case 5:
                            ((TextView) WC2SanlinXForceCarInfo.this.findViewById(R.id.tv_text8)).setText("Charge");
                            break;
                        case 6:
                            ((TextView) WC2SanlinXForceCarInfo.this.findViewById(R.id.tv_text8)).setText("EV");
                            break;
                        case 7:
                            ((TextView) WC2SanlinXForceCarInfo.this.findViewById(R.id.tv_text8)).setText("Tarmac ");
                            break;
                        default:
                            ((TextView) WC2SanlinXForceCarInfo.this.findViewById(R.id.tv_text8)).setText("----");
                            break;
                    }
                    break;
                case 130:
                    ((TextView) WC2SanlinXForceCarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10.0f) + " L/100km");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0444_wc_sanlin_xforce_carinfo);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
    }
}
