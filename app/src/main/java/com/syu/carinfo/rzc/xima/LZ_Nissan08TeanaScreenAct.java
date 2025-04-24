package com.syu.carinfo.rzc.xima;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0453_LZ_Nissan_Teana_08;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class LZ_Nissan08TeanaScreenAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 120:
                    ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text1)).setText(Callback_0453_LZ_Nissan_Teana_08.Str_Line1);
                    break;
                case 121:
                    ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text2)).setText(Callback_0453_LZ_Nissan_Teana_08.Str_Line2);
                    break;
                case 122:
                    if (value == 1) {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text4)).setText("1");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text4)).setText(" ");
                        break;
                    }
                case 123:
                    if (value == 1) {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text3)).setText("ALL");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text3)).setText(" ");
                        break;
                    }
                case 124:
                    if (value == 1) {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text12)).setText("SCAN");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text12)).setText(" ");
                        break;
                    }
                case 125:
                    if (value == 1) {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text13)).setText("ST");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text13)).setText(" ");
                        break;
                    }
                case 126:
                    if (value == 1) {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text11)).setText("RDS");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text11)).setText(" ");
                        break;
                    }
                case 127:
                    if (value == 1) {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text10)).setText("MP3");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text10)).setText(" ");
                        break;
                    }
                case 128:
                    if (value == 1) {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text9)).setText("WMA");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text9)).setText(" ");
                        break;
                    }
                case 129:
                    if (value == 1) {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text8)).setText("RPT");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text8)).setText(" ");
                        break;
                    }
                case 130:
                    if (value == 1) {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text14)).setText("RDM");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text14)).setText(" ");
                        break;
                    }
                case 131:
                    if (value == 1) {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text7)).setText("TRACK");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text7)).setText(" ");
                        break;
                    }
                case 132:
                    if (value == 1) {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text6)).setText("FOLDER");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text6)).setText(" ");
                        break;
                    }
                case 133:
                    if (value == 1) {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text5)).setText("DISC");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text5)).setText(" ");
                        break;
                    }
                case 134:
                    if (value == 1) {
                        LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.xuni_cd1_img).setBackgroundResource(R.drawable.ic_sbd_play1);
                        break;
                    } else {
                        LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.xuni_cd1_img).setBackgroundResource(R.drawable.ic_sbd_gray);
                        break;
                    }
                case 135:
                    if (value == 1) {
                        LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.xuni_cd2_img).setBackgroundResource(R.drawable.ic_sbd_play1);
                        break;
                    } else {
                        LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.xuni_cd2_img).setBackgroundResource(R.drawable.ic_sbd_gray);
                        break;
                    }
                case 136:
                    if (value == 1) {
                        LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.xuni_cd3_img).setBackgroundResource(R.drawable.ic_sbd_play1);
                        break;
                    } else {
                        LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.xuni_cd3_img).setBackgroundResource(R.drawable.ic_sbd_gray);
                        break;
                    }
                case 137:
                    if (value == 1) {
                        LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.xuni_cd4_img).setBackgroundResource(R.drawable.ic_sbd_play1);
                        break;
                    } else {
                        LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.xuni_cd4_img).setBackgroundResource(R.drawable.ic_sbd_gray);
                        break;
                    }
                case 138:
                    if (value == 1) {
                        LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.xuni_cd5_img).setBackgroundResource(R.drawable.ic_sbd_play1);
                        break;
                    } else {
                        LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.xuni_cd5_img).setBackgroundResource(R.drawable.ic_sbd_gray);
                        break;
                    }
                case 139:
                    if (value == 1) {
                        LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.xuni_cd6_img).setBackgroundResource(R.drawable.ic_sbd_play1);
                        break;
                    } else {
                        LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.xuni_cd6_img).setBackgroundResource(R.drawable.ic_sbd_gray);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_lz_nissan_teana_screen);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(3, new int[]{60}, null, null);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }
}
