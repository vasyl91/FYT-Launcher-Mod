package com.syu.carinfo.wc.tianlaicd;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WC08TianlaiCarEqAct extends BaseActivity {
    public static WC08TianlaiCarEqAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.tianlaicd.WC08TianlaiCarEqAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 132:
                    ((TextView) WC08TianlaiCarEqAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                    break;
                case 133:
                    if (value < 5) {
                        ((TextView) WC08TianlaiCarEqAct.this.findViewById(R.id.tv_text2)).setText("L" + (5 - value));
                        break;
                    } else if (value == 5) {
                        ((TextView) WC08TianlaiCarEqAct.this.findViewById(R.id.tv_text2)).setText("0");
                        break;
                    } else if (value > 5) {
                        ((TextView) WC08TianlaiCarEqAct.this.findViewById(R.id.tv_text2)).setText("R" + (value - 5));
                        break;
                    }
                case 134:
                    if (value < 5) {
                        ((TextView) WC08TianlaiCarEqAct.this.findViewById(R.id.tv_text3)).setText("F" + (5 - value));
                        break;
                    } else if (value == 5) {
                        ((TextView) WC08TianlaiCarEqAct.this.findViewById(R.id.tv_text3)).setText("0");
                        break;
                    } else if (value > 5) {
                        ((TextView) WC08TianlaiCarEqAct.this.findViewById(R.id.tv_text3)).setText("R" + (value - 5));
                        break;
                    }
                case 135:
                    if (value < 5) {
                        ((TextView) WC08TianlaiCarEqAct.this.findViewById(R.id.tv_text4)).setText("-" + (5 - value));
                        break;
                    } else if (value == 5) {
                        ((TextView) WC08TianlaiCarEqAct.this.findViewById(R.id.tv_text4)).setText("0");
                        break;
                    } else if (value > 5) {
                        ((TextView) WC08TianlaiCarEqAct.this.findViewById(R.id.tv_text4)).setText("+" + (value - 5));
                        break;
                    }
                case 136:
                    if (value < 5) {
                        ((TextView) WC08TianlaiCarEqAct.this.findViewById(R.id.tv_text5)).setText("-" + (5 - value));
                        break;
                    } else if (value == 5) {
                        ((TextView) WC08TianlaiCarEqAct.this.findViewById(R.id.tv_text5)).setText("0");
                        break;
                    } else if (value > 5) {
                        ((TextView) WC08TianlaiCarEqAct.this.findViewById(R.id.tv_text5)).setText("+" + (value - 5));
                        break;
                    }
                case 137:
                    if (value == 0) {
                        ((TextView) WC08TianlaiCarEqAct.this.findViewById(R.id.tv_text6)).setText(R.string.rzc_c4l_close);
                        break;
                    } else {
                        ((TextView) WC08TianlaiCarEqAct.this.findViewById(R.id.tv_text6)).setText(R.string.rzc_c4l_open);
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_08tianlai_carinfo);
        mInstance = this;
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
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
    }
}
