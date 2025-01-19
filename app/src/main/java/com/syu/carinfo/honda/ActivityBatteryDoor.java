package com.syu.carinfo.honda;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ActivityBatteryDoor extends Activity {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = R.string.off;
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 150:
                    if (((CheckedTextView) ActivityBatteryDoor.this.findViewById(R.id.ctv_checkedtext2)) != null) {
                        ((CheckedTextView) ActivityBatteryDoor.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
                        ((TextView) ActivityBatteryDoor.this.findViewById(R.id.tv_text2)).setText(value == 0 ? R.string.str_guandao_remote_open1 : R.string.str_guandao_remote_open2);
                        break;
                    }
                case 151:
                    if (((CheckedTextView) ActivityBatteryDoor.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) ActivityBatteryDoor.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                        TextView textView = (TextView) ActivityBatteryDoor.this.findViewById(R.id.tv_text1);
                        if (value != 0) {
                            i = 2131296935;
                        }
                        textView.setText(i);
                        break;
                    }
                case 198:
                    if (((CheckedTextView) ActivityBatteryDoor.this.findViewById(R.id.ctv_checkedtext3)) != null) {
                        ((CheckedTextView) ActivityBatteryDoor.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
                        TextView textView2 = (TextView) ActivityBatteryDoor.this.findViewById(R.id.tv_text3);
                        if (value != 0) {
                            i = 2131296935;
                        }
                        textView2.setText(i);
                        break;
                    }
                case 199:
                    if (((CheckedTextView) ActivityBatteryDoor.this.findViewById(R.id.ctv_checkedtext4)) != null) {
                        ((CheckedTextView) ActivityBatteryDoor.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
                        ((TextView) ActivityBatteryDoor.this.findViewById(R.id.tv_text4)).setText(value == 0 ? 2131296462 : 2131296935);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_321_battery_door_state);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[151] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 2;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[150] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 1;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[198] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 4;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[199] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 3;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
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
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.mNotifyCanbus);
    }
}
