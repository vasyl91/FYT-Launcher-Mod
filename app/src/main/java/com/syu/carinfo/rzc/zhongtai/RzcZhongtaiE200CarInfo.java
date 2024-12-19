package com.syu.carinfo.rzc.zhongtai;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RzcZhongtaiE200CarInfo extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.zhongtai.RzcZhongtaiE200CarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 105:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " V");
                    break;
                case 106:
                    int value2 = value - 6000;
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + " A");
                    break;
                case 107:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "%");
                    break;
                case 108:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value - 50) + " ℃");
                    break;
                case 109:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value - 50) + " ℃");
                    break;
                case 110:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value - 50) + " ℃");
                    break;
                case 111:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value - 50) + " ℃");
                    break;
                case 112:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value - 200) + " KW");
                    break;
                case 113:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value - 32000) + " RPM");
                    break;
                case 114:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text10)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 115:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value / 100) + "." + ((value / 100) / 10) + (value % 100) + " V");
                    break;
                case 116:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text12)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 117:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text13)).setText(String.valueOf(value / 100) + "." + ((value / 100) / 10) + (value % 100) + " V");
                    break;
                case 118:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text14)).setText(String.valueOf(value) + " ℃");
                    break;
                case 119:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text15)).setText(String.valueOf(value) + " ℃");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_rzc_zhongtai_e200_carinfo);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
    }
}
