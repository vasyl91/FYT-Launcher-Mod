package com.syu.carinfo.dj.huangguan;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class XC_429_ToyotaCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dj.huangguan.XC_429_ToyotaCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 160:
                case 165:
                    XC_429_ToyotaCarInfo.this.updateCarinfo1();
                    break;
                case 161:
                case 166:
                    XC_429_ToyotaCarInfo.this.updateCarinfo2();
                    break;
                case 162:
                case 167:
                    XC_429_ToyotaCarInfo.this.updateCarinfo3();
                    break;
                case 163:
                case 168:
                    XC_429_ToyotaCarInfo.this.updateCarinfo4();
                    break;
                case 164:
                case 169:
                    XC_429_ToyotaCarInfo.this.updateCarinfo5();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0429_xc_toyota_carinfo);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{90}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        v.getId();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo5() {
        int value = DataCanbus.DATA[164];
        int unit = DataCanbus.DATA[169];
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text5)).setText("----");
        } else if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " miles");
        } else {
            ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo4() {
        int value = DataCanbus.DATA[163];
        int unit = DataCanbus.DATA[168];
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text4)).setText("----");
        } else if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mph");
        } else {
            ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/h");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo3() {
        int value = DataCanbus.DATA[162];
        int unit = DataCanbus.DATA[167];
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text3)).setText("----");
        } else if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " miles");
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo2() {
        int value = DataCanbus.DATA[161];
        int unit = DataCanbus.DATA[166];
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text2)).setText("----");
            return;
        }
        if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/l");
        } else if (unit == 2) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg");
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " l/100km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo1() {
        int value = DataCanbus.DATA[160];
        int unit = DataCanbus.DATA[165];
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text1)).setText("----");
            return;
        }
        if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/l");
        } else if (unit == 2) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg");
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " l/100km");
        }
    }
}
