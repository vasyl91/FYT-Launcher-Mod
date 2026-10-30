package com.syu.carinfo.guochan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ActivityHuanSuAirSet extends Activity implements View.OnClickListener {
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.guochan.ActivityHuanSuAirSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 109:
                    ActivityHuanSuAirSet.this.updateRemoteOpenAir(value);
                    break;
                case 110:
                    ActivityHuanSuAirSet.this.updatePhoneDownWind(value);
                    break;
                case 111:
                    ActivityHuanSuAirSet.this.updateHighTempInterCycle(value);
                    break;
                case 112:
                    ActivityHuanSuAirSet.this.updateAutoWind(value);
                    break;
                case 113:
                    ActivityHuanSuAirSet.this.updateAutoAC(value);
                    break;
                case 114:
                    ActivityHuanSuAirSet.this.updateParkInterCycle(value);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_419_huansu_s6_air_set);
        setListener();
    }

    private void setListener() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mCanbusNotify);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = (DataCanbus.DATA[110] & 255) - 1;
                if (value < 0) {
                    value = 0;
                }
                setCmd(5, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = (DataCanbus.DATA[110] & 255) + 1;
                if (value2 > 7) {
                    value2 = 7;
                }
                setCmd(5, value2);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCmd(6, (DataCanbus.DATA[109] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCmd(2, (DataCanbus.DATA[113] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCmd(1, (DataCanbus.DATA[114] & 255) == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCmd(4, (DataCanbus.DATA[111] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCmd(3, (DataCanbus.DATA[112] & 255) != 0 ? 0 : 1);
                break;
        }
    }

    private void setCmd(int cmd, int value) {
        DataCanbus.PROXY.cmd(0, cmd, value);
    }

    protected void updateParkInterCycle(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_view6).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_view6).setVisibility(8);
        }
    }

    protected void updateAutoAC(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_view5).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_view5).setVisibility(8);
        }
    }

    protected void updateAutoWind(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_view4).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_view4).setVisibility(8);
        }
    }

    protected void updateHighTempInterCycle(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_view3).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_view3).setVisibility(8);
        }
    }

    protected void updatePhoneDownWind(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_view2).setVisibility(0);
            if ((value & 255) == 0) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.off);
                return;
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value & 255).toString());
                return;
            }
        }
        findViewById(R.id.layout_view2).setVisibility(8);
    }

    protected void updateRemoteOpenAir(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_view1).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
        }
    }
}
