package com.syu.carinfo.leinuo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Act_Keleijia_set extends BaseActivity implements View.OnClickListener {
    private int[] eventIds = {153, 195, 196, 197, 348};
    IUiNotify mCanbusNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 153:
                    Act_Keleijia_set.this.uTempMode(value);
                    break;
                case 195:
                    if (value == 65535) {
                        ((TextView) Act_Keleijia_set.this.findViewById(R.id.tv_text1)).setText("----");
                        break;
                    } else {
                        ((TextView) Act_Keleijia_set.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100Km");
                        break;
                    }
                case 196:
                    if (value == 65535) {
                        ((TextView) Act_Keleijia_set.this.findViewById(R.id.tv_text2)).setText("----");
                        break;
                    } else {
                        ((TextView) Act_Keleijia_set.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " Km/h");
                        break;
                    }
                case 197:
                    if (value == 16777215) {
                        ((TextView) Act_Keleijia_set.this.findViewById(R.id.tv_text3)).setText("----");
                        break;
                    } else {
                        ((TextView) Act_Keleijia_set.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " Km");
                        break;
                    }
                case 348:
                    Act_Keleijia_set.this.setCheck((CheckedTextView) Act_Keleijia_set.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_keleiao_set);
        initUI();
    }

    private void initUI() {
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
    }

    protected void cmd(int cmd) {
        DataCanbus.PROXY.cmd(1, cmd);
    }

    @Override
    public void onClick(View v) {
        int iTempMode;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int iTempMode2 = DataCanbus.DATA[153];
                if (iTempMode2 == 0) {
                    iTempMode = 2;
                } else {
                    iTempMode = iTempMode2 - 1;
                }
                int c = iTempMode + 64;
                cmd(c);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int c2 = ((DataCanbus.DATA[153] + 1) % 3) + 64;
                cmd(c2);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value = DataCanbus.DATA[348];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                setCarInfo(50, value);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(17, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        if (DataCanbus.DATA[1000] == 1245558 || DataCanbus.DATA[1000] == 1311094 || DataCanbus.DATA[1000] == 1769846) {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
            findViewById(R.id.layout_view3).setVisibility(8);
            findViewById(R.id.layout_view4).setVisibility(8);
            DataCanbus.PROXY.cmd(4, new int[]{51}, null, null);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].addNotify(this.mCanbusNotify, 1);
        }
    }

    @Override
    public void removeNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].removeNotify(this.mCanbusNotify);
        }
    }

    protected void uTempMode(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            int id = R.string.bsd_klj_str20;
            if (value == 1) {
                id = R.string.bsd_klj_str21;
            } else if (value == 2) {
                id = R.string.bsd_klj_str22;
            }
            ((TextView) findViewById(R.id.tv_text4)).setText(id);
        }
    }
}
