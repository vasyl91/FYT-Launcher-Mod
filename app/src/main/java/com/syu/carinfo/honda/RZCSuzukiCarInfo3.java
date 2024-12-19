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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZCSuzukiCarInfo3 extends BaseActivity implements View.OnClickListener {
    int fuelunit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.RZCSuzukiCarInfo3.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 93:
                    RZCSuzukiCarInfo3.this.fuelunit = value;
                    break;
                case 100:
                case 101:
                case 102:
                case 103:
                    int start_m = DataCanbus.DATA[100];
                    int start_d = DataCanbus.DATA[101];
                    int end_m = DataCanbus.DATA[102];
                    int end_d = DataCanbus.DATA[103];
                    ((TextView) RZCSuzukiCarInfo3.this.findViewById(R.id.tv_text1)).setText(String.valueOf(start_m) + "/" + start_d + " ~ " + end_m + "/" + end_d);
                    break;
                case 104:
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
                case 105:
                case 106:
                case 107:
                case 108:
                    int start_m2 = DataCanbus.DATA[105];
                    int start_d2 = DataCanbus.DATA[106];
                    int end_m2 = DataCanbus.DATA[107];
                    int end_d2 = DataCanbus.DATA[108];
                    ((TextView) RZCSuzukiCarInfo3.this.findViewById(R.id.tv_text3)).setText(String.valueOf(start_m2) + "/" + start_d2 + " ~ " + end_m2 + "/" + end_d2);
                    break;
                case 109:
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
                case 110:
                case 111:
                case 112:
                case 113:
                    int start_m3 = DataCanbus.DATA[110];
                    int start_d3 = DataCanbus.DATA[111];
                    int end_m3 = DataCanbus.DATA[112];
                    int end_d3 = DataCanbus.DATA[113];
                    ((TextView) RZCSuzukiCarInfo3.this.findViewById(R.id.tv_text5)).setText(String.valueOf(start_m3) + "/" + start_d3 + " ~ " + end_m3 + "/" + end_d3);
                    break;
                case 114:
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
                case 115:
                case 116:
                case 117:
                case 118:
                    int start_m4 = DataCanbus.DATA[115];
                    int start_d4 = DataCanbus.DATA[116];
                    int end_m4 = DataCanbus.DATA[117];
                    int end_d4 = DataCanbus.DATA[118];
                    ((TextView) RZCSuzukiCarInfo3.this.findViewById(R.id.tv_text7)).setText(String.valueOf(start_m4) + "/" + start_d4 + " ~ " + end_m4 + "/" + end_d4);
                    break;
                case 119:
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
                case 120:
                case 121:
                case 122:
                case 123:
                    int start_m5 = DataCanbus.DATA[120];
                    int start_d5 = DataCanbus.DATA[121];
                    int end_m5 = DataCanbus.DATA[122];
                    int end_d5 = DataCanbus.DATA[123];
                    ((TextView) RZCSuzukiCarInfo3.this.findViewById(R.id.tv_text9)).setText(String.valueOf(start_m5) + "/" + start_d5 + " ~ " + end_m5 + "/" + end_d5);
                    break;
                case 124:
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_rzc_suzuki_carinfo3);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{51, 3}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                dialog(R.string.str_refueling_period, 2);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.delete)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.honda.RZCSuzukiCarInfo3.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.honda.RZCSuzukiCarInfo3.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(1, new int[]{98, i}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.honda.RZCSuzukiCarInfo3.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
    }
}
