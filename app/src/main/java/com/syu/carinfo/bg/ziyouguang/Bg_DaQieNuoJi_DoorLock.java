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
public class Bg_DaQieNuoJi_DoorLock extends BaseActivity {
    int[] ids = {147, 148, 149, 151, 150, 152, 153};
    int val = 0;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Bg_DaQieNuoJi_DoorLock.this.val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 147:
                    Bg_DaQieNuoJi_DoorLock.this.u7(Bg_DaQieNuoJi_DoorLock.this.val);
                    break;
                case 148:
                    Bg_DaQieNuoJi_DoorLock.this.u6(Bg_DaQieNuoJi_DoorLock.this.val);
                    break;
                case 149:
                    Bg_DaQieNuoJi_DoorLock.this.u4(Bg_DaQieNuoJi_DoorLock.this.val);
                    break;
                case 150:
                    Bg_DaQieNuoJi_DoorLock.this.u2(Bg_DaQieNuoJi_DoorLock.this.val);
                    break;
                case 151:
                    Bg_DaQieNuoJi_DoorLock.this.u3(Bg_DaQieNuoJi_DoorLock.this.val);
                    break;
                case 152:
                    Bg_DaQieNuoJi_DoorLock.this.u1(Bg_DaQieNuoJi_DoorLock.this.val);
                    break;
                case 153:
                    Bg_DaQieNuoJi_DoorLock.this.u0(Bg_DaQieNuoJi_DoorLock.this.val);
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
        View v = findViewById(R.id.layout_view3);
        setGone(v, true);
        View v2 = findViewById(R.id.layout_view6);
        setGone(v2, true);
        View v3 = findViewById(R.id.layout_view7);
        setGone(v3, true);
        View v4 = findViewById(R.id.layout_view9);
        setGone(v4, true);
        View v5 = findViewById(R.id.layout_view4);
        setGone(v5, false);
        setCmdClick(findViewById(R.id.ctv_checkedtext1), 33, 147);
        setCmdClick(findViewById(R.id.ctv_checkedtext2), 34, 148);
        setCmdClick(findViewById(R.id.ctv_checkedtext6), 35, 149);
        setCmdClick(findViewById(R.id.btn_minus2), 36, 151);
        setCmdClick(findViewById(R.id.btn_plus2), 36, 151);
        setCmdClick(findViewById(R.id.ctv_checkedtext3), 37, 150);
        setCmdClick(findViewById(R.id.ctv_checkedtext8), 38, 152);
        setCmdClick(findViewById(R.id.ctv_checkedtext7), 39, 153);
    }

    private void setCmdClick(View v, final int cmd, final int id) {
        if (v != null) {
            v.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v2) {
                    int val = DataCanbus.DATA[id];
                    Bg_DaQieNuoJi_DoorLock.this.setCmd(cmd, val == 0 ? 2 : 1);
                }
            });
        }
    }

    
    public void setCmd(int cmd, int val) {
        DataCanbus.PROXY.cmd(1, new int[]{cmd, val}, null, null);
    }

    private void setGone(View v, boolean on) {
        if (v != null) {
            v.setVisibility(on ? 8 : 0);
        }
    }

    private void setChecked(CheckedTextView btn, boolean on) {
        if (btn != null) {
            btn.setChecked(on);
        }
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

    
    public void u7(int val) {
        setChecked(findViewById(R.id.ctv_checkedtext1), val != 0);
    }

    
    public void u6(int val) {
        setChecked(findViewById(R.id.ctv_checkedtext2), val != 0);
    }

    
    public void u4(int val) {
        setChecked(findViewById(R.id.ctv_checkedtext6), val != 0);
    }

    
    public void u3(int val) {
        TextView v = findViewById(R.id.tv_text2);
        if (v != null) {
            int id = R.string.jeep_presskeyunlock_1;
            if (val == 1) {
                id = R.string.jeep_presskeyunlock_0;
            }
            v.setText(id);
        }
    }

    
    public void u2(int val) {
        setChecked(findViewById(R.id.ctv_checkedtext3), val != 0);
    }

    
    public void u1(int val) {
        setChecked(findViewById(R.id.ctv_checkedtext8), val != 0);
    }

    
    public void u0(int val) {
        setChecked(findViewById(R.id.ctv_checkedtext7), val != 0);
    }
}
