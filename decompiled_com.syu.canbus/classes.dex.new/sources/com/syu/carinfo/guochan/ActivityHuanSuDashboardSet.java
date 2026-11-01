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
public class ActivityHuanSuDashboardSet extends Activity implements View.OnClickListener {
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.guochan.ActivityHuanSuDashboardSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 129:
                    ActivityHuanSuDashboardSet.this.updateLdwWarn(value);
                    break;
                case 130:
                    ActivityHuanSuDashboardSet.this.updateBsdWarn(value);
                    break;
                case 131:
                    ActivityHuanSuDashboardSet.this.updateWinterSpeedWarn(value);
                    break;
                case 132:
                    ActivityHuanSuDashboardSet.this.updateSpeedSpeedWarn(value);
                    break;
                case 133:
                    ActivityHuanSuDashboardSet.this.updateTpmsUint(value);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_419_huansu_s6_dashboard_set);
        setListener();
    }

    private void setListener() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
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
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mCanbusNotify);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = (DataCanbus.DATA[133] & 255) - 1;
                if (value < 0) {
                    value = 0;
                }
                setCmd(1, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = (DataCanbus.DATA[133] & 255) + 1;
                if (value2 > 2) {
                    value2 = 2;
                }
                setCmd(1, value2);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCmd(5, (DataCanbus.DATA[129] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCmd(2, (DataCanbus.DATA[132] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCmd(4, (DataCanbus.DATA[130] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCmd(3, (DataCanbus.DATA[131] & 255) != 0 ? 0 : 1);
                break;
        }
    }

    private void setCmd(int cmd, int value) {
        DataCanbus.PROXY.cmd(2, cmd, value);
    }

    protected void updateTpmsUint(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_view5).setVisibility(0);
            switch (value & 255) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText("bar");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text1)).setText("psi");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text1)).setText("kpa");
                    break;
            }
            return;
        }
        findViewById(R.id.layout_view5).setVisibility(8);
    }

    protected void updateSpeedSpeedWarn(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_view4).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_view4).setVisibility(8);
        }
    }

    protected void updateWinterSpeedWarn(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_view3).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_view3).setVisibility(8);
        }
    }

    protected void updateBsdWarn(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_view2).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_view2).setVisibility(8);
        }
    }

    protected void updateLdwWarn(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_view1).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
        }
    }
}
