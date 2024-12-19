package com.syu.carinfo.rzc.xima;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0453_LZ_Nissan_Teana_08;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LZ_Nissan08TeanaScreenAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.xima.LZ_Nissan08TeanaScreenAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 108:
                    ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text1)).setText(Callback_0453_LZ_Nissan_Teana_08.Str_Line1);
                    break;
                case 109:
                    ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text2)).setText(Callback_0453_LZ_Nissan_Teana_08.Str_Line2);
                    break;
                case 110:
                    if (value == 1) {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text4)).setText("1");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text4)).setText(" ");
                        break;
                    }
                case 111:
                    if (value == 1) {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text3)).setText("ALL");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text3)).setText(" ");
                        break;
                    }
                case 112:
                    if (value == 1) {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text12)).setText("SCAN");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text12)).setText(" ");
                        break;
                    }
                case 113:
                    if (value == 1) {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text13)).setText("ST");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text13)).setText(" ");
                        break;
                    }
                case 114:
                    if (value == 1) {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text11)).setText("RDS");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text11)).setText(" ");
                        break;
                    }
                case 115:
                    if (value == 1) {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text10)).setText("MP3");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text10)).setText(" ");
                        break;
                    }
                case 116:
                    if (value == 1) {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text9)).setText("WMA");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text9)).setText(" ");
                        break;
                    }
                case 117:
                    if (value == 1) {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text8)).setText("RPT");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text8)).setText(" ");
                        break;
                    }
                case 118:
                    if (value == 1) {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text14)).setText("RDM");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text14)).setText(" ");
                        break;
                    }
                case 119:
                    if (value == 1) {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text7)).setText("TRACK");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text7)).setText(" ");
                        break;
                    }
                case 120:
                    if (value == 1) {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text6)).setText("FOLDER");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text6)).setText(" ");
                        break;
                    }
                case 121:
                    if (value == 1) {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text5)).setText("DISC");
                        break;
                    } else {
                        ((TextView) LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.tv_text5)).setText(" ");
                        break;
                    }
                case 122:
                    if (value == 1) {
                        LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.xuni_cd1_img).setBackgroundResource(R.drawable.ic_sbd_play1);
                        break;
                    } else {
                        LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.xuni_cd1_img).setBackgroundResource(R.drawable.ic_sbd_gray);
                        break;
                    }
                case 123:
                    if (value == 1) {
                        LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.xuni_cd2_img).setBackgroundResource(R.drawable.ic_sbd_play1);
                        break;
                    } else {
                        LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.xuni_cd2_img).setBackgroundResource(R.drawable.ic_sbd_gray);
                        break;
                    }
                case 124:
                    if (value == 1) {
                        LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.xuni_cd3_img).setBackgroundResource(R.drawable.ic_sbd_play1);
                        break;
                    } else {
                        LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.xuni_cd3_img).setBackgroundResource(R.drawable.ic_sbd_gray);
                        break;
                    }
                case 125:
                    if (value == 1) {
                        LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.xuni_cd4_img).setBackgroundResource(R.drawable.ic_sbd_play1);
                        break;
                    } else {
                        LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.xuni_cd4_img).setBackgroundResource(R.drawable.ic_sbd_gray);
                        break;
                    }
                case 126:
                    if (value == 1) {
                        LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.xuni_cd5_img).setBackgroundResource(R.drawable.ic_sbd_play1);
                        break;
                    } else {
                        LZ_Nissan08TeanaScreenAct.this.findViewById(R.id.xuni_cd5_img).setBackgroundResource(R.drawable.ic_sbd_gray);
                        break;
                    }
                case 127:
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_lz_nissan_teana_screen);
        init();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(3, new int[]{60}, null, null);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }
}
