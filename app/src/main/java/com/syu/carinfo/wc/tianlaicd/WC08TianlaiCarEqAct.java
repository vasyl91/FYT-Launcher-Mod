package com.syu.carinfo.wc.tianlaicd;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class WC08TianlaiCarEqAct extends BaseActivity {
    public static WC08TianlaiCarEqAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 144:
                    ((TextView) WC08TianlaiCarEqAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                    break;
                case 145:
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
                case 146:
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
                case 147:
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
                case 148:
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
                case 149:
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_08tianlai_carinfo);
        mInstance = this;
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
    }
}
