package com.syu.carinfo.honda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Wc_16Civic_AirSetActi extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.Wc_16Civic_AirSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 222:
                    ((CheckedTextView) Wc_16Civic_AirSetActi.this.findViewById(R.id.ctv_checkedtext11)).setChecked(val == 1);
                    break;
                case 223:
                    ((CheckedTextView) Wc_16Civic_AirSetActi.this.findViewById(R.id.ctv_checkedtext12)).setChecked(val == 1);
                    break;
                case 245:
                    if (((TextView) Wc_16Civic_AirSetActi.this.findViewById(R.id.tv_text2)) != null) {
                        if (val == 65535) {
                            ((TextView) Wc_16Civic_AirSetActi.this.findViewById(R.id.tv_text2)).setTextColor(Wc_16Civic_AirSetActi.this.getResources().getColor(R.color.white));
                            ((TextView) Wc_16Civic_AirSetActi.this.findViewById(R.id.tv_text2)).setText("-----");
                        } else if (val <= 35) {
                            ((TextView) Wc_16Civic_AirSetActi.this.findViewById(R.id.tv_text2)).setTextColor(-16711936);
                            ((TextView) Wc_16Civic_AirSetActi.this.findViewById(R.id.tv_text2)).setText(String.valueOf(Wc_16Civic_AirSetActi.this.getResources().getString(R.string.str_265_2)) + ": " + val);
                        } else if (val <= 75) {
                            ((TextView) Wc_16Civic_AirSetActi.this.findViewById(R.id.tv_text2)).setTextColor(-256);
                            ((TextView) Wc_16Civic_AirSetActi.this.findViewById(R.id.tv_text2)).setText(String.valueOf(Wc_16Civic_AirSetActi.this.getResources().getString(R.string.str_265_3)) + ": " + val);
                        } else if (val <= 115) {
                            ((TextView) Wc_16Civic_AirSetActi.this.findViewById(R.id.tv_text2)).setTextColor(Wc_16Civic_AirSetActi.this.getResources().getColor(R.color.orange));
                            ((TextView) Wc_16Civic_AirSetActi.this.findViewById(R.id.tv_text2)).setText(String.valueOf(Wc_16Civic_AirSetActi.this.getResources().getString(R.string.str_265_4)) + ": " + val);
                        } else if (val <= 150) {
                            ((TextView) Wc_16Civic_AirSetActi.this.findViewById(R.id.tv_text2)).setTextColor(Wc_16Civic_AirSetActi.this.getResources().getColor(R.color.red));
                            ((TextView) Wc_16Civic_AirSetActi.this.findViewById(R.id.tv_text2)).setText(String.valueOf(Wc_16Civic_AirSetActi.this.getResources().getString(R.string.str_265_5)) + ": " + val);
                        } else if (val <= 250) {
                            ((TextView) Wc_16Civic_AirSetActi.this.findViewById(R.id.tv_text2)).setTextColor(Wc_16Civic_AirSetActi.this.getResources().getColor(R.color.purple));
                            ((TextView) Wc_16Civic_AirSetActi.this.findViewById(R.id.tv_text2)).setText(String.valueOf(Wc_16Civic_AirSetActi.this.getResources().getString(R.string.str_265_6)) + ": " + val);
                        } else if (val > 250) {
                            ((TextView) Wc_16Civic_AirSetActi.this.findViewById(R.id.tv_text2)).setTextColor(Wc_16Civic_AirSetActi.this.getResources().getColor(R.color.saddlebrown));
                            ((TextView) Wc_16Civic_AirSetActi.this.findViewById(R.id.tv_text2)).setText(String.valueOf(Wc_16Civic_AirSetActi.this.getResources().getString(R.string.str_265_7)) + ": " + val);
                        }
                    }
                    break;
                case 246:
                    if (((TextView) Wc_16Civic_AirSetActi.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Wc_16Civic_AirSetActi.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) Wc_16Civic_AirSetActi.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(val).toString());
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_321_civic_air_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
                int value = DataCanbus.DATA[246] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(106, new int[]{42, value}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value2 = DataCanbus.DATA[246] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(106, new int[]{42, value2}, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427618 */:
                int value3 = DataCanbus.DATA[222] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 36;
                iArr[1] = value3 == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
                break;
            case R.id.ctv_checkedtext12 /* 2131427619 */:
                int value4 = DataCanbus.DATA[223] & 255;
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 37;
                iArr2[1] = value4 == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(106, iArr2, null, null);
                break;
        }
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

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[222].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[223].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[245].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[246].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[222].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[223].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[245].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[246].removeNotify(this.mNotifyCanbus);
    }
}
