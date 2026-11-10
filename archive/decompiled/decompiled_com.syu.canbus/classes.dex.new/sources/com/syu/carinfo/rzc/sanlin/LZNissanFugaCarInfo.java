package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LZNissanFugaCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.LZNissanFugaCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    ((TextView) LZNissanFugaCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value - 40) + "℃");
                    break;
                case 101:
                    ((TextView) LZNissanFugaCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "km");
                    break;
                case 103:
                    ((TextView) LZNissanFugaCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "km");
                    break;
                case 106:
                    int value2 = value * 172;
                    ((TextView) LZNissanFugaCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value2 / 100) + "." + ((value2 % 100) / 10) + (value2 % 10) + "kPa");
                    break;
                case 107:
                    int value3 = value * 172;
                    ((TextView) LZNissanFugaCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value3 / 100) + "." + ((value3 % 100) / 10) + (value3 % 10) + "kPa");
                    break;
                case 108:
                    int value4 = value * 172;
                    ((TextView) LZNissanFugaCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value4 / 100) + "." + ((value4 % 100) / 10) + (value4 % 10) + "kPa");
                    break;
                case 109:
                    int value5 = value * 172;
                    ((TextView) LZNissanFugaCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value5 / 100) + "." + ((value5 % 100) / 10) + (value5 % 10) + "kPa");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_lz_nissan_fuga_carinfo);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(0, new int[]{54, 0}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{53, 0}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
    }
}
