package com.syu.carinfo.guochan;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityBaoJun extends Activity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.guochan.ActivityBaoJun.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 50:
                    int value = DataCanbus.DATA[50];
                    ((TextView) ActivityBaoJun.this.findViewById(R.id.tv_wc2_baojun_engine_speed)).setText(String.valueOf(String.valueOf(value)) + " r/min");
                    break;
                case 51:
                    int value2 = DataCanbus.DATA[51];
                    if (value2 == -1) {
                        ((TextView) ActivityBaoJun.this.findViewById(R.id.tv_wc2_baojun_throttle_position)).setText("-");
                        break;
                    } else {
                        ((TextView) ActivityBaoJun.this.findViewById(R.id.tv_wc2_baojun_throttle_position)).setText(String.valueOf(value2) + " %");
                        break;
                    }
                case 52:
                    int value3 = DataCanbus.DATA[52];
                    ActivityBaoJun.this.setText((TextView) ActivityBaoJun.this.findViewById(R.id.tv_wc2_baojun_dipped), value3);
                    break;
                case 53:
                    int value4 = DataCanbus.DATA[53];
                    ActivityBaoJun.this.setText((TextView) ActivityBaoJun.this.findViewById(R.id.tv_wc2_baojun_higbean), value4);
                    break;
                case 54:
                    int value5 = DataCanbus.DATA[54];
                    ActivityBaoJun.this.setText((TextView) ActivityBaoJun.this.findViewById(R.id.tv_wc2_baojun_lamp), value5);
                    break;
                case 55:
                    int value6 = DataCanbus.DATA[55];
                    ActivityBaoJun.this.setText((TextView) ActivityBaoJun.this.findViewById(R.id.tv_wc2_baojun_ffog), value6);
                    break;
                case 56:
                    int value7 = DataCanbus.DATA[56];
                    ActivityBaoJun.this.setText((TextView) ActivityBaoJun.this.findViewById(R.id.tv_wc2_baojun_turnleft), value7);
                    break;
                case 57:
                    int value8 = DataCanbus.DATA[57];
                    ActivityBaoJun.this.setText((TextView) ActivityBaoJun.this.findViewById(R.id.tv_wc2_baojun_turnright), value8);
                    break;
                case 58:
                    int value9 = DataCanbus.DATA[58];
                    ActivityBaoJun.this.setText((TextView) ActivityBaoJun.this.findViewById(R.id.tv_wc2_baojun_doubleflash), value9);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_395_wc2_baojun);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.notifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setText(TextView textview, int value) {
        if (value == 1) {
            textview.setText(R.string.rzc_c4l_open);
        } else {
            textview.setText(R.string.rzc_c4l_close);
        }
    }
}
