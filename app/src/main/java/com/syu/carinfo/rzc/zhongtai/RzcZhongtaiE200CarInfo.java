package com.syu.carinfo.rzc.zhongtai;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RzcZhongtaiE200CarInfo extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 171:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " V");
                    break;
                case 172:
                    int value2 = value - 6000;
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + " A");
                    break;
                case 173:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "%");
                    break;
                case 174:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value - 50) + " ℃");
                    break;
                case 175:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value - 50) + " ℃");
                    break;
                case 176:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value - 50) + " ℃");
                    break;
                case 177:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value - 50) + " ℃");
                    break;
                case 178:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value - 200) + " KW");
                    break;
                case 179:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value - 32000) + " RPM");
                    break;
                case 180:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text10)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 181:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value / 100) + "." + ((value / 100) / 10) + (value % 100) + " V");
                    break;
                case 182:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text12)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 183:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text13)).setText(String.valueOf(value / 100) + "." + ((value / 100) / 10) + (value % 100) + " V");
                    break;
                case 184:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text14)).setText(String.valueOf(value) + " ℃");
                    break;
                case 185:
                    ((TextView) RzcZhongtaiE200CarInfo.this.findViewById(R.id.tv_text15)).setText(String.valueOf(value) + " ℃");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_rzc_zhongtai_e200_carinfo);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
    }
}
