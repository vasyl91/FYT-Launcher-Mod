package com.syu.carinfo.od.dongnanv5;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class OD_Zotye_T700_Pm25 extends BaseActivity {
    int[] ids = {110, 111, 112, 113};
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 110:
                    OD_Zotye_T700_Pm25.this.uCarIn(value);
                    break;
                case 111:
                    OD_Zotye_T700_Pm25.this.uCarOut(value);
                    break;
                case 112:
                    OD_Zotye_T700_Pm25.this.uLevelIn(value);
                    break;
                case 113:
                    OD_Zotye_T700_Pm25.this.uLevelOut(value);
                    break;
            }
        }
    };
    private int[] strIdPM = {R.string.str_265_2, R.string.str_265_3, R.string.str_265_4, R.string.str_265_5, R.string.str_265_6, R.string.str_265_7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_od_zotye_t700_pm25);
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{66}, null, null);
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }

    protected void uLevelIn(int value) {
        uPmValue((TextView) findViewById(R.id.id_pm_inside_type), value);
    }

    protected void uLevelOut(int value) {
        uPmValue((TextView) findViewById(R.id.id_pm_outside_type), value);
    }

    protected void uCarOut(int value) {
        if (((TextView) findViewById(R.id.id_pm_outside)) != null) {
            ((TextView) findViewById(R.id.id_pm_outside)).setText(String.valueOf(value) + "μg/m³");
        }
    }

    protected void uCarIn(int value) {
        if (((TextView) findViewById(R.id.id_pm_inside)) != null) {
            ((TextView) findViewById(R.id.id_pm_inside)).setText(String.valueOf(value) + "μg/m³");
        }
    }

    void setText(TextView v, String str) {
        if (v != null) {
            v.setText(str);
        }
    }

    private void uPmValue(TextView tv, int val) {
        int strid = -1;
        switch (val) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                strid = this.strIdPM[val - 1];
                break;
        }
        if (tv != null) {
            if (strid > -1) {
                tv.setVisibility(0);
                int txtClr = 0;
                int txtBackgroudClr = 0;
                switch (val) {
                    case 1:
                        txtClr = R.color.white;
                        txtBackgroudClr = R.color.green;
                        break;
                    case 2:
                        txtClr = R.color.black2;
                        txtBackgroudClr = R.color.yellow;
                        break;
                    case 3:
                        txtClr = R.color.black2;
                        txtBackgroudClr = R.color.orange;
                        break;
                    case 4:
                        txtClr = R.color.white;
                        txtBackgroudClr = R.color.red;
                        break;
                    case 5:
                        txtClr = R.color.white;
                        txtBackgroudClr = R.color.purple;
                        break;
                    case 6:
                        txtClr = R.color.white;
                        txtBackgroudClr = R.color.saddlebrown;
                        break;
                }
                tv.setTextColor(getResources().getColor(txtClr));
                tv.setBackgroundColor(getResources().getColor(txtBackgroudClr));
                tv.setText(strid);
                return;
            }
            tv.setVisibility(4);
        }
    }
}
