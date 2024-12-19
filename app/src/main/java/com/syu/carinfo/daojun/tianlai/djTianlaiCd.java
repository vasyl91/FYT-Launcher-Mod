package com.syu.carinfo.daojun.tianlai;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class djTianlaiCd extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static djTianlaiCd mInit;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.daojun.tianlai.djTianlaiCd.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 92:
                    djTianlaiCd.this.updateDiscNum(value);
                    break;
                case 93:
                    ((TextView) djTianlaiCd.this.findViewById(R.id.dj_lexus_cd_track)).setText(String.format("Track:%d", Integer.valueOf(value)));
                    break;
                case 94:
                    djTianlaiCd.this.mUpdateCdRpt();
                    break;
                case 95:
                    djTianlaiCd.this.mUpdateCdRandom();
                    break;
                case 96:
                case 97:
                    djTianlaiCd.this.updatecdTime();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_djtianlai_carcd);
        mInit = this;
        init();
    }

    public void init() {
        findViewById(R.id.lexus_cd_rpt).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_random).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_prev).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_skipb).setOnTouchListener(this);
        findViewById(R.id.prado_cd_power).setOnTouchListener(this);
        findViewById(R.id.prado_cd_disc).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_skipf).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_next).setOnTouchListener(this);
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCdRpt() {
        int On = DataCanbus.DATA[94];
        findViewById(R.id.lexus_cd_rpt).setBackgroundResource(On == 0 ? R.drawable.ic_lexus_cd_rpt_n : R.drawable.ic_lexus_cd_rpt_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCdRandom() {
        int On = DataCanbus.DATA[95];
        findViewById(R.id.lexus_cd_random).setBackgroundResource(On == 0 ? R.drawable.ic_lexus_cd_random_n : R.drawable.ic_lexus_cd_random_p);
    }

    public void updatecdTime() {
        int value = DataCanbus.DATA[96];
        int value1 = DataCanbus.DATA[97];
        ((TextView) findViewById(R.id.dj_lexus_cd_time)).setText(String.format("%d:%d", Integer.valueOf(value), Integer.valueOf(value1)));
    }

    public void updateDiscNum(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd_num)).setText("CD");
                break;
            default:
                ((TextView) findViewById(R.id.dj_lexus_cd_num)).setText("CD " + value);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(13);
        addNotify();
        if (DataCanbus.DATA[107] != 2) {
            DataCanbus.PROXY.cmd(0, new int[]{7, 1}, null, null);
            HandlerUI.getInstance().postDelayed(new Runnable() { // from class: com.syu.carinfo.daojun.tianlai.djTianlaiCd.2
                @Override // java.lang.Runnable
                public void run() {
                    DataCanbus.PROXY.cmd(0, new int[]{7}, null, null);
                }
            }, 100L);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_cd_rpt /* 2131427666 */:
                    DataCanbus.PROXY.cmd(0, new int[]{24, 1}, null, null);
                    break;
                case R.id.lexus_cd_random /* 2131427667 */:
                    DataCanbus.PROXY.cmd(0, new int[]{21, 1}, null, null);
                    break;
                case R.id.lexus_cd_prev /* 2131427843 */:
                    DataCanbus.PROXY.cmd(0, new int[]{19, 1}, null, null);
                    break;
                case R.id.lexus_cd_skipb /* 2131427844 */:
                    DataCanbus.PROXY.cmd(0, new int[]{20, 1}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131427847 */:
                    DataCanbus.PROXY.cmd(0, new int[]{23, 1}, null, null);
                    break;
                case R.id.lexus_cd_next /* 2131427848 */:
                    DataCanbus.PROXY.cmd(0, new int[]{22, 1}, null, null);
                    break;
                case R.id.prado_cd_power /* 2131428261 */:
                    DataCanbus.PROXY.cmd(0, new int[]{9, 1}, null, null);
                    break;
                case R.id.prado_cd_disc /* 2131428262 */:
                    DataCanbus.PROXY.cmd(0, new int[]{8, 1}, null, null);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.lexus_cd_rpt /* 2131427666 */:
                    DataCanbus.PROXY.cmd(0, new int[]{24}, null, null);
                    break;
                case R.id.lexus_cd_random /* 2131427667 */:
                    DataCanbus.PROXY.cmd(0, new int[]{21}, null, null);
                    break;
                case R.id.lexus_cd_prev /* 2131427843 */:
                    DataCanbus.PROXY.cmd(0, new int[]{19}, null, null);
                    break;
                case R.id.lexus_cd_skipb /* 2131427844 */:
                    DataCanbus.PROXY.cmd(0, new int[]{20}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131427847 */:
                    DataCanbus.PROXY.cmd(0, new int[]{23}, null, null);
                    break;
                case R.id.lexus_cd_next /* 2131427848 */:
                    DataCanbus.PROXY.cmd(0, new int[]{22}, null, null);
                    break;
                case R.id.prado_cd_power /* 2131428261 */:
                    DataCanbus.PROXY.cmd(0, new int[]{9}, null, null);
                    break;
                case R.id.prado_cd_disc /* 2131428262 */:
                    DataCanbus.PROXY.cmd(0, new int[]{8}, null, null);
                    break;
            }
        }
        return false;
    }
}
