package com.syu.carinfo.hechi.fordexplorer;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class HcFordExplorerCd extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static HcFordExplorerCd mInit;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 114:
                    HcFordExplorerCd.this.updateDiscState(value);
                    break;
                case 115:
                    HcFordExplorerCd.this.mUpdateCdRpt();
                    break;
                case 116:
                    HcFordExplorerCd.this.mUpdateCdRandom();
                    break;
                case 117:
                case 118:
                    HcFordExplorerCd.this.updatecdTime();
                    break;
                case 119:
                case 120:
                    HcFordExplorerCd.this.updatecdTrack();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String platform = SystemProperties.get("ro.fyt.platform", "");
        if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform) || "6318".equals(platform)) {
            //setContentView(R.layout.layout_djtianlai_carcd);
        } else if (LauncherApplication.getConfiguration() == 1) {
            //setContentView(R.layout.layout_djtianlai_carcd_7731);
        } else {
            //setContentView(R.layout.layout_djtianlai_carcd);
        }
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
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
    }

    public void updatecdTrack() {
        int value = DataCanbus.DATA[119];
        int value1 = DataCanbus.DATA[120];
        ((TextView) findViewById(R.id.dj_lexus_cd_track)).setText(String.format("Track:%d/%d", Integer.valueOf(value), Integer.valueOf(value1)));
    }

    
    public void mUpdateCdRpt() {
        int On = DataCanbus.DATA[115];
        findViewById(R.id.lexus_cd_rpt).setBackgroundResource(On == 0 ? R.drawable.ic_lexus_cd_rpt_n : R.drawable.ic_lexus_cd_rpt_p);
    }

    
    public void mUpdateCdRandom() {
        int On = DataCanbus.DATA[116];
        findViewById(R.id.lexus_cd_random).setBackgroundResource(On == 0 ? R.drawable.ic_lexus_cd_random_n : R.drawable.ic_lexus_cd_random_p);
    }

    public void updatecdTime() {
        int value = DataCanbus.DATA[118];
        int value1 = DataCanbus.DATA[117];
        ((TextView) findViewById(R.id.dj_lexus_cd_time)).setText(String.valueOf(value1 / 60) + ":" + (value1 % 60) + " / " + (value / 60) + ":" + (value % 60));
    }

    public void updateDiscState(int value) {
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd_num)).setText(R.string.crv_playstate_0);
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_cd_num)).setText(R.string.crv_state_pause);
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_cd_num)).setText(R.string.crv_state_stop);
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_lexus_cd_num)).setText(R.string.str_sbd_x80_scan);
                break;
            case 6:
                ((TextView) findViewById(R.id.dj_lexus_cd_num)).setText(R.string.crv_state_loading);
                break;
            case 7:
                ((TextView) findViewById(R.id.dj_lexus_cd_num)).setText(R.string.str_sbd_x80_media_state_10);
                break;
            case 8:
                ((TextView) findViewById(R.id.dj_lexus_cd_num)).setText(R.string.jeep_playstate5);
                break;
            case 9:
                ((TextView) findViewById(R.id.dj_lexus_cd_num)).setText(R.string.jeep_playstate9);
                break;
            case 128:
                ((TextView) findViewById(R.id.dj_lexus_cd_num)).setText(R.string.jeep_playstate1);
                break;
            default:
                ((TextView) findViewById(R.id.dj_lexus_cd_num)).setText(R.string.jeep_playstate1);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(13);
        addNotify();
        if (DataCanbus.DATA[121] != 2) {
            DataCanbus.PROXY.cmd(3, new int[]{3}, null, null);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_cd_rpt /* 2131427678 */:
                    if (DataCanbus.DATA[115] != 1) {
                        DataCanbus.PROXY.cmd(4, new int[]{6, 1}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(4, new int[]{8, 1}, null, null);
                        break;
                    }
                case R.id.lexus_cd_random /* 2131427679 */:
                    if (DataCanbus.DATA[116] != 1) {
                        DataCanbus.PROXY.cmd(4, new int[]{5, 1}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(4, new int[]{7, 1}, null, null);
                        break;
                    }
                case R.id.lexus_cd_prev /* 2131427859 */:
                    DataCanbus.PROXY.cmd(4, new int[]{1, 1}, null, null);
                    break;
                case R.id.lexus_cd_skipb /* 2131427860 */:
                    DataCanbus.PROXY.cmd(4, new int[]{10, 1}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131427863 */:
                    DataCanbus.PROXY.cmd(4, new int[]{9, 1}, null, null);
                    break;
                case R.id.lexus_cd_next /* 2131427864 */:
                    DataCanbus.PROXY.cmd(4, new int[]{2, 1}, null, null);
                    break;
                case R.id.prado_cd_power /* 2131428253 */:
                    DataCanbus.PROXY.cmd(4, new int[]{4, 1}, null, null);
                    break;
                case R.id.prado_cd_disc /* 2131428254 */:
                    DataCanbus.PROXY.cmd(4, new int[]{3, 1}, null, null);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.lexus_cd_skipb /* 2131427860 */:
                    DataCanbus.PROXY.cmd(4, new int[]{10}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131427863 */:
                    DataCanbus.PROXY.cmd(4, new int[]{9}, null, null);
                    break;
            }
        }
        return false;
    }
}
