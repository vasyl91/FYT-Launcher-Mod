package com.syu.carinfo.wc.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Wc_372_SRTInfoActi extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 172:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " V");
                    break;
                case 173:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value - 40) + " ℃");
                    break;
                case 174:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value - 40) + " ℃");
                    break;
                case 175:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " bar");
                    break;
                case 176:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value - 40) + " ℃");
                    break;
                case 177:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value - 40) + " ℃");
                    break;
                case 180:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text7)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 181:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text8)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 182:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 183:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 184:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 185:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 186:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text13)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 187:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text14)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 188:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text15)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 189:
                    ((TextView) Wc_372_SRTInfoActi.this.findViewById(R.id.tv_text16)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_372_wc_srt_carinfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(10, new int[]{50}, null, null);
        DataCanbus.PROXY.cmd(10, new int[]{52}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
    }
}
