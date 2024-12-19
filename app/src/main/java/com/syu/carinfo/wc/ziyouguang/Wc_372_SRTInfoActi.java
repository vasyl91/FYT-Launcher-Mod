package com.syu.carinfo.wc.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Wc_372_SRTInfoActi extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SRTInfoActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 104:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " V");
                    break;
                case 105:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value - 40) + " ℃");
                    break;
                case 106:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value - 40) + " ℃");
                    break;
                case 107:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " bar");
                    break;
                case 108:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value - 40) + " ℃");
                    break;
                case 109:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value - 40) + " ℃");
                    break;
                case 121:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text7)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 122:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text8)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 123:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 124:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 125:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 126:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 127:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text13)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 128:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text14)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 129:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text15)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 130:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text16)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_372_wc_srt_carinfo);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(10, new int[]{50}, null, null);
        DataCanbus.PROXY.cmd(10, new int[]{52}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
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
