package com.syu.carinfo.psa_all;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class PSAFuncLockActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 114:
                    PSAFuncLockActi.this.mUpdaterValue46();
                    break;
                case 115:
                    PSAFuncLockActi.this.mUpdaterValue47();
                    break;
                case 118:
                    PSAFuncLockActi.this.mUpdaterValue48();
                    break;
                case 129:
                    PSAFuncLockActi.this.mUpdaterValue41();
                    break;
                case 130:
                    PSAFuncLockActi.this.mUpdaterValue42();
                    break;
                case 131:
                    PSAFuncLockActi.this.mUpdaterValue43();
                    break;
                case 134:
                    PSAFuncLockActi.this.mUpdaterValue44();
                    break;
                case 175:
                    PSAFuncLockActi.this.mUpdaterValue45();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_psa_all_func_lock);
        registerListener();
    }

    public void registerListener() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[129];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(19, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[130];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(20, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[131];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(12, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[134];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(21, iArr, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue41() {
        int value = DataCanbus.DATA[129];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue42() {
        int value = DataCanbus.DATA[130];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue43() {
        int value = DataCanbus.DATA[131];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(getResources().getString(R.string.wc_psa_all_unlock_1));
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText(getResources().getString(R.string.wc_psa_all_unlock_0));
            }
        }
    }

    
    public void mUpdaterValue44() {
        int value = DataCanbus.DATA[134];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue45() {
        int value = DataCanbus.DATA[175];
        if (findViewById(R.id.layout_view1) != null) {
            if (value == 1) {
                findViewById(R.id.layout_view1).setVisibility(0);
            } else {
                findViewById(R.id.layout_view1).setVisibility(8);
            }
        }
    }

    
    public void mUpdaterValue46() {
        int value = DataCanbus.DATA[114];
        if (findViewById(R.id.layout_view2) != null) {
            if (value == 1) {
                findViewById(R.id.layout_view2).setVisibility(0);
            } else {
                findViewById(R.id.layout_view2).setVisibility(8);
            }
        }
    }

    
    public void mUpdaterValue47() {
        int value = DataCanbus.DATA[115];
        if (findViewById(R.id.layout_view3) != null) {
            if (value == 1) {
                findViewById(R.id.layout_view3).setVisibility(0);
            } else {
                findViewById(R.id.layout_view3).setVisibility(8);
            }
        }
    }

    
    public void mUpdaterValue48() {
        int value = DataCanbus.DATA[118];
        if (findViewById(R.id.layout_view4) != null) {
            if (value == 1) {
                findViewById(R.id.layout_view4).setVisibility(0);
            } else {
                findViewById(R.id.layout_view4).setVisibility(8);
            }
        }
    }
}
