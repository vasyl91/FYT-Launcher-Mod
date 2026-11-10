package com.syu.carinfo.bg.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Bg_ZiYouguang_DoorLock extends BaseActivity {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 102:
                    Bg_ZiYouguang_DoorLock.this.mAuto_lock();
                    break;
                case 103:
                    Bg_ZiYouguang_DoorLock.this.mGetoff_autolock();
                    break;
                case 104:
                    Bg_ZiYouguang_DoorLock.this.mKeyless_entry();
                    break;
                case 112:
                    Bg_ZiYouguang_DoorLock.this.mPressKeyUnlock();
                    break;
                case 127:
                    Bg_ZiYouguang_DoorLock.this.mDoorWarring();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_jeep_doorlock);
        init();
    }

    @Override
    public void init() {
        if (DataCanbus.DATA[1000] == 371) {
            findViewById(R.id.layout_view6).setVisibility(8);
        }
        findViewById(R.id.btn_minus1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[112];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{36, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[112];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{36, value}, null, null);
            }
        });
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[102];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{33, value}, null, null);
            }
        });
        findViewById(R.id.ctv_checkedtext2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[103];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{34, value}, null, null);
            }
        });
        findViewById(R.id.ctv_checkedtext3).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[104];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{37, value}, null, null);
            }
        });
        findViewById(R.id.ctv_checkedtext4).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[127];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{33, value}, null, null);
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

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
    }

    
    public void mAuto_lock() {
        int value = DataCanbus.DATA[102];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn == 1);
    }

    
    public void mGetoff_autolock() {
        int value = DataCanbus.DATA[103];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn == 1);
    }

    
    public void mKeyless_entry() {
        int value = DataCanbus.DATA[104];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn == 1);
    }

    
    public void mPressKeyUnlock() {
        int value = DataCanbus.DATA[112];
        if (findViewById(R.id.tv_text1) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.jeep_presskeyunlock_0);
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.jeep_presskeyunlock_1);
            }
        }
    }

    
    public void mDoorWarring() {
        int value = DataCanbus.DATA[127];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn == 1);
    }
}
