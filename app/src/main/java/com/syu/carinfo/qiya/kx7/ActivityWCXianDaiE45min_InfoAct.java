package com.syu.carinfo.qiya.kx7;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ActivityWCXianDaiE45min_InfoAct extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 132:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 133:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 134:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 135:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 136:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 137:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 138:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 139:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 140:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 141:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 142:
                    switch (value) {
                        case 2:
                            ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text41)).setText("Hybrid Fuel Economy (MPG US)");
                            break;
                        case 3:
                            ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text41)).setText("Hybrid Fuel Economy (MPG UK)");
                            break;
                        case 4:
                            ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text41)).setText("Hybrid Fuel Economy (km/L)");
                            break;
                        default:
                            ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text41)).setText("Hybrid Fuel Economy (L/100km)");
                            break;
                    }
                case 143:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text21)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 144:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text22)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 145:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text23)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 146:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text24)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 147:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text25)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 148:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text26)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 149:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text27)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 150:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text28)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 151:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text29)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 152:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text30)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 153:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 154:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 155:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text13)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 156:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text14)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 157:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text15)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 158:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text16)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 159:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text17)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 160:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text18)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 161:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text19)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 162:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text20)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 163:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text31)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 164:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text32)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 165:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text33)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 166:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text34)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 167:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text35)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 168:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text36)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 169:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text37)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 170:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text38)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 171:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text39)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 172:
                    ((TextView) ActivityWCXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text40)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0444_wc_xiandai_e45min_info);
        setListener();
    }

    void setListener() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                dialog(R.string.all_settings, 24);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(4, new int[]{i, 1, 255, 255}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(4, new int[]{i, 0, 255, 255}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
    }
}
