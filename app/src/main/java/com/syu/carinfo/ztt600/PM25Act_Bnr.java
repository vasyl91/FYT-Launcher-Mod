package com.syu.carinfo.ztt600;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class PM25Act_Bnr extends BaseActivity {
    private int[] ids = {148, 149};
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 148:
                    PM25Act_Bnr.this.uPmIn(val);
                    break;
                case 149:
                    PM25Act_Bnr.this.uPmOut(val);
                    break;
            }
        }
    };
    private int[] strIdPM = {R.string.str_265_2, R.string.str_265_3, R.string.str_265_4, R.string.str_265_5, R.string.str_265_6, R.string.str_265_7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_265_bnr_t600_pm25);
        init();
    }

    @Override
    public void addNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.notifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.notifyCanbus);
        }
    }

    @Override
    public void init() {
    }

    
    public void uPmOut(int val) {
        if (((TextView) findViewById(R.id.id_pm_outside)) != null) {
            ((TextView) findViewById(R.id.id_pm_outside)).setText(String.valueOf(val) + " μg/m³");
        }
        uPmValue((TextView) findViewById(R.id.id_pm_outside_type), val);
    }

    
    public void uPmIn(int val) {
        if (((TextView) findViewById(R.id.id_pm_inside)) != null) {
            ((TextView) findViewById(R.id.id_pm_inside)).setText(String.valueOf(val) + " μg/m³");
        }
        uPmValue((TextView) findViewById(R.id.id_pm_inside_type), val);
    }

    private int getPMLevel(int val) {
        if (val > 0 && val < 36) {
            return 1;
        }
        if (val >= 36 && val < 76) {
            return 2;
        }
        if (val >= 76 && val < 116) {
            return 3;
        }
        if (val >= 116 && val < 151) {
            return 4;
        }
        if (val >= 151 && val < 251) {
            return 5;
        }
        if (val <= 250) {
            return 0;
        }
        return 6;
    }

    private void uPmValue(TextView tv, int val) {
        int strid = -1;
        int val2 = getPMLevel(val);
        switch (val2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                strid = this.strIdPM[val2 - 1];
                break;
        }
        if (tv != null) {
            if (strid > -1) {
                tv.setVisibility(0);
                int txtClr = 0;
                int txtBackgroudClr = 0;
                switch (val2) {
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
