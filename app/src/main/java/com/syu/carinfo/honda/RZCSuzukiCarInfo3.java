package com.syu.carinfo.honda;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RZCSuzukiCarInfo3 extends BaseActivity implements View.OnClickListener {
    int fuelunit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 105:
                    RZCSuzukiCarInfo3.this.fuelunit = value;
                    break;
                case 112:
                case 113:
                case 114:
                case 115:
                    int start_m = DataCanbus.DATA[112];
                    int start_d = DataCanbus.DATA[113];
                    int end_m = DataCanbus.DATA[114];
                    int end_d = DataCanbus.DATA[115];
                    ((TextView) RZCSuzukiCarInfo3.this.findViewById(R.id.tv_text1)).setText(String.valueOf(start_m) + "/" + start_d + " ~ " + end_m + "/" + end_d);
                    break;
                case 116:
                    switch (RZCSuzukiCarInfo3.this.fuelunit) {
                        case 0:
                            ((TextView) RZCSuzukiCarInfo3.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg");
                            break;
                        case 1:
                            ((TextView) RZCSuzukiCarInfo3.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/l");
                            break;
                        case 2:
                            ((TextView) RZCSuzukiCarInfo3.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " l/100km");
                            break;
                    }
                case 117:
                case 118:
                case 119:
                case 120:
                    int start_m2 = DataCanbus.DATA[117];
                    int start_d2 = DataCanbus.DATA[118];
                    int end_m2 = DataCanbus.DATA[119];
                    int end_d2 = DataCanbus.DATA[120];
                    ((TextView) RZCSuzukiCarInfo3.this.findViewById(R.id.tv_text3)).setText(String.valueOf(start_m2) + "/" + start_d2 + " ~ " + end_m2 + "/" + end_d2);
                    break;
                case 121:
                    switch (RZCSuzukiCarInfo3.this.fuelunit) {
                        case 0:
                            ((TextView) RZCSuzukiCarInfo3.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg");
                            break;
                        case 1:
                            ((TextView) RZCSuzukiCarInfo3.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/l");
                            break;
                        case 2:
                            ((TextView) RZCSuzukiCarInfo3.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " l/100km");
                            break;
                    }
                case 122:
                case 123:
                case 124:
                case 125:
                    int start_m3 = DataCanbus.DATA[122];
                    int start_d3 = DataCanbus.DATA[123];
                    int end_m3 = DataCanbus.DATA[124];
                    int end_d3 = DataCanbus.DATA[125];
                    ((TextView) RZCSuzukiCarInfo3.this.findViewById(R.id.tv_text5)).setText(String.valueOf(start_m3) + "/" + start_d3 + " ~ " + end_m3 + "/" + end_d3);
                    break;
                case 126:
                    switch (RZCSuzukiCarInfo3.this.fuelunit) {
                        case 0:
                            ((TextView) RZCSuzukiCarInfo3.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg");
                            break;
                        case 1:
                            ((TextView) RZCSuzukiCarInfo3.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/l");
                            break;
                        case 2:
                            ((TextView) RZCSuzukiCarInfo3.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + " l/100km");
                            break;
                    }
                case 127:
                case 128:
                case 129:
                case 130:
                    int start_m4 = DataCanbus.DATA[127];
                    int start_d4 = DataCanbus.DATA[128];
                    int end_m4 = DataCanbus.DATA[129];
                    int end_d4 = DataCanbus.DATA[130];
                    ((TextView) RZCSuzukiCarInfo3.this.findViewById(R.id.tv_text7)).setText(String.valueOf(start_m4) + "/" + start_d4 + " ~ " + end_m4 + "/" + end_d4);
                    break;
                case 131:
                    switch (RZCSuzukiCarInfo3.this.fuelunit) {
                        case 0:
                            ((TextView) RZCSuzukiCarInfo3.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg");
                            break;
                        case 1:
                            ((TextView) RZCSuzukiCarInfo3.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/l");
                            break;
                        case 2:
                            ((TextView) RZCSuzukiCarInfo3.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + " l/100km");
                            break;
                    }
                case 132:
                case 133:
                case 134:
                case 135:
                    int start_m5 = DataCanbus.DATA[132];
                    int start_d5 = DataCanbus.DATA[133];
                    int end_m5 = DataCanbus.DATA[134];
                    int end_d5 = DataCanbus.DATA[135];
                    ((TextView) RZCSuzukiCarInfo3.this.findViewById(R.id.tv_text9)).setText(String.valueOf(start_m5) + "/" + start_d5 + " ~ " + end_m5 + "/" + end_d5);
                    break;
                case 136:
                    switch (RZCSuzukiCarInfo3.this.fuelunit) {
                        case 0:
                            ((TextView) RZCSuzukiCarInfo3.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg");
                            break;
                        case 1:
                            ((TextView) RZCSuzukiCarInfo3.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/l");
                            break;
                        case 2:
                            ((TextView) RZCSuzukiCarInfo3.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value / 10) + "." + (value % 10) + " l/100km");
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_rzc_suzuki_carinfo3);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{51, 3}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                dialog(R.string.str_refueling_period, 2);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.delete)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(1, new int[]{98, i}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
    }
}
