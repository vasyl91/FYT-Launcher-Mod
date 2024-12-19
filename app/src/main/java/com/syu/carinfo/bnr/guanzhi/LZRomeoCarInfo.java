package com.syu.carinfo.bnr.guanzhi;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LZRomeoCarInfo extends BaseActivity implements View.OnClickListener {
    int unit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bnr.guanzhi.LZRomeoCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 56:
                    if (LZRomeoCarInfo.this.unit == 1) {
                        ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " miles");
                        break;
                    } else {
                        ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " km");
                        break;
                    }
                case 57:
                    if (LZRomeoCarInfo.this.unit == 1) {
                        ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " miles");
                        break;
                    } else {
                        ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
                        break;
                    }
                case 59:
                    LZRomeoCarInfo.this.unit = value;
                    break;
                case 60:
                    switch (value) {
                        case 0:
                            ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text3)).setText("N");
                            break;
                        case 1:
                            ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text3)).setText("D");
                            break;
                        case 2:
                            ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text3)).setText("A");
                            break;
                        case 3:
                            ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text3)).setText("RACE");
                            break;
                    }
                case 61:
                    switch (value) {
                        case 6:
                            ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text4)).setText("LO");
                            ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text4)).setTextColor(-65536);
                            break;
                        case 7:
                            ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text4)).setText("HI");
                            ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text4)).setTextColor(-65536);
                            break;
                        case 8:
                            ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text4)).setText("Warn");
                            ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text4)).setTextColor(-256);
                            break;
                        default:
                            ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value + 1)).toString());
                            ((TextView) LZRomeoCarInfo.this.findViewById(R.id.tv_text4)).setTextColor(-16777216);
                            break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_lz_romeo_carinfo);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{53}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
    }
}
