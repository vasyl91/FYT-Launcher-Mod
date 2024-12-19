package com.syu.carinfo.rzc.klc;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZCKlcEVCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.klc.RZCKlcEVCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 72:
                    if (value == 0) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text1)).setText(R.string.crv_source_null);
                        break;
                    } else if (value == 1) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text1)).setText(R.string.str_have);
                        break;
                    }
                case 73:
                    if (value == 0) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text2)).setText(R.string.crv_source_null);
                        break;
                    } else if (value == 1) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text2)).setText(R.string.str_have);
                        break;
                    }
                case 74:
                    if (value == 0) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text3)).setText(R.string.crv_source_null);
                        break;
                    } else if (value == 1) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text3)).setText(R.string.str_have);
                        break;
                    }
                case 75:
                    if (value == 0) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text4)).setText(R.string.crv_source_null);
                        break;
                    } else if (value == 1) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text4)).setText(R.string.str_have);
                        break;
                    }
                case 76:
                    if (value == 0) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text5)).setText(R.string.crv_source_null);
                        break;
                    } else if (value == 1) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text5)).setText(R.string.str_have);
                        break;
                    }
                case 77:
                    if (value == 0) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text6)).setText(R.string.crv_source_null);
                        break;
                    } else if (value == 1) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text6)).setText(R.string.str_have);
                        break;
                    }
                case 78:
                    if (value == 0) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text7)).setText(R.string.crv_source_null);
                        break;
                    } else if (value == 1) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text7)).setText(R.string.str_have);
                        break;
                    }
                case 79:
                    if (value == 0) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text8)).setText(R.string.crv_source_null);
                        break;
                    } else if (value == 1) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text8)).setText(R.string.str_have);
                        break;
                    }
                case 80:
                    if (value == 0) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text9)).setText(R.string.crv_source_null);
                        break;
                    } else if (value == 1) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text9)).setText(R.string.str_have);
                        break;
                    }
                case 81:
                    if (value == 0) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text10)).setText(R.string.crv_source_null);
                        break;
                    } else if (value == 1) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text10)).setText(R.string.str_have);
                        break;
                    }
                case 82:
                    ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value) + "%");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0061_rzc_gm_ev_carinfo);
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
        v.getId();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[81].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[82].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.mNotifyCanbus);
    }
}
