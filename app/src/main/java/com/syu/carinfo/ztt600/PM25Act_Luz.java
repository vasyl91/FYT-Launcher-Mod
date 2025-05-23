package com.syu.carinfo.ztt600;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class PM25Act_Luz extends BaseActivity {
    private int[] ids = {147, 148, 149};
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 147:
                    PM25Act_Luz.this.uPmValue(val);
                    break;
                case 148:
                    PM25Act_Luz.this.uPmIn(val);
                    break;
                case 149:
                    PM25Act_Luz.this.uPmOut(val);
                    break;
            }
        }
    };
    private int[] strIdPM = {R.string.str_265_2, R.string.str_265_3, R.string.str_265_4, R.string.str_265_5, R.string.str_265_6, R.string.str_265_7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_265_luz_t600_pm25);
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
        if (((TextView) findViewById(R.id.id_pm_inside)) != null) {
            if (val >= 0 && val <= 1022) {
                ((TextView) findViewById(R.id.id_pm_inside)).setText(String.valueOf(val) + " μg/m³");
            } else {
                ((TextView) findViewById(R.id.id_pm_inside)).setText(" -- ");
            }
        }
    }

    
    public void uPmIn(int val) {
        if (((TextView) findViewById(R.id.id_pm_outside)) != null) {
            if (val >= 0 && val <= 1022) {
                ((TextView) findViewById(R.id.id_pm_outside)).setText(String.valueOf(val) + " μg/m³");
            } else {
                ((TextView) findViewById(R.id.id_pm_outside)).setText(" -- ");
            }
        }
    }

    
    public void uPmValue(int val) {
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
        if (((TextView) findViewById(R.id.zt_pm)) != null) {
            TextView v = (TextView) findViewById(R.id.zt_pm);
            if (strid > -1) {
                v.setVisibility(0);
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
                v.setTextColor(getResources().getColor(txtClr));
                v.setBackgroundColor(getResources().getColor(txtBackgroudClr));
                v.setText(strid);
                return;
            }
            v.setVisibility(4);
        }
    }
}
