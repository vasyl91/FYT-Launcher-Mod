package com.syu.carinfo.ford;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class MustangCarCDAct extends Activity implements View.OnTouchListener {
    public static MustangCarCDAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ford.MustangCarCDAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 122:
                case 123:
                    MustangCarCDAct.this.updaterTrackInfo();
                    break;
                case 124:
                case 125:
                    MustangCarCDAct.this.updaterTimeInfo();
                    break;
                case 126:
                    if (((TextView) MustangCarCDAct.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MustangCarCDAct.this.findViewById(R.id.tv_text6)).setText(R.string.jeep_playstate1);
                                break;
                            case 2:
                                ((TextView) MustangCarCDAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_sbd_x80_media_state_10);
                                break;
                            case 3:
                                ((TextView) MustangCarCDAct.this.findViewById(R.id.tv_text6)).setText(R.string.jeep_playstate5);
                                break;
                            case 255:
                                ((TextView) MustangCarCDAct.this.findViewById(R.id.tv_text6)).setText(R.string.jeep_playstate9);
                                break;
                            default:
                                ((TextView) MustangCarCDAct.this.findViewById(R.id.tv_text6)).setText("");
                                break;
                        }
                    }
                    break;
                case 127:
                    if (((TextView) MustangCarCDAct.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MustangCarCDAct.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_playstate2);
                                break;
                            default:
                                ((TextView) MustangCarCDAct.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_playstate6);
                                break;
                        }
                    }
                    break;
                case 128:
                    MustangCarCDAct.this.findViewById(R.id.lexus_cd_rpt).setBackgroundResource(value == 0 ? R.drawable.ic_lexus_cd_rpt_n : R.drawable.ic_lexus_cd_rpt_p);
                    break;
                case 129:
                    MustangCarCDAct.this.findViewById(R.id.lexus_cd_random).setBackgroundResource(value == 0 ? R.drawable.ic_lexus_cd_random_n : R.drawable.ic_lexus_cd_random_p);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0334_rzc_mustang_carcd);
        mInstance = this;
        init();
    }

    public void init() {
        findViewById(R.id.lexus_cd_rpt).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_random).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_prev).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_skipb).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_play).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_pause).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_skipf).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_next).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_eject).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(11);
        DataCanbus.PROXY.cmd(6, new int[1], null, null);
        DataCanbus.PROXY.cmd(9, new int[]{169, 32}, null, null);
        DataCanbus.PROXY.cmd(9, new int[]{169}, null, null);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_cd_rpt /* 2131427666 */:
                    if (DataCanbus.DATA[128] == 1) {
                        DataCanbus.PROXY.cmd(9, new int[]{169, 39}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(9, new int[]{169, 40}, null, null);
                        break;
                    }
                case R.id.lexus_cd_random /* 2131427667 */:
                    if (DataCanbus.DATA[129] == 1) {
                        DataCanbus.PROXY.cmd(9, new int[]{169, 37}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(9, new int[]{169, 38}, null, null);
                        break;
                    }
                case R.id.lexus_cd_prev /* 2131427843 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169, 33}, null, null);
                    break;
                case R.id.lexus_cd_skipb /* 2131427844 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169, 42}, null, null);
                    break;
                case R.id.lexus_cd_play /* 2131427845 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169, 36}, null, null);
                    break;
                case R.id.lexus_cd_pause /* 2131427846 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169, 35}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131427847 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169, 43}, null, null);
                    break;
                case R.id.lexus_cd_next /* 2131427848 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169, 34}, null, null);
                    break;
                case R.id.lexus_cd_eject /* 2131427849 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169, 44}, null, null);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.lexus_cd_skipb /* 2131427844 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169}, null, null);
                    break;
                case R.id.lexus_cd_play /* 2131427845 */:
                case R.id.lexus_cd_pause /* 2131427846 */:
                default:
                    DataCanbus.PROXY.cmd(9, new int[]{169}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131427847 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169}, null, null);
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTimeInfo() {
        int Hour = (DataCanbus.DATA[124] >> 16) & 255;
        int Minute = (DataCanbus.DATA[124] >> 8) & 255;
        int Sec = DataCanbus.DATA[124] & 255;
        int Hour1 = (DataCanbus.DATA[125] >> 16) & 255;
        int Minute1 = (DataCanbus.DATA[125] >> 8) & 255;
        int Sec1 = DataCanbus.DATA[125] & 255;
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText((Hour / 10) + (Hour % 10) + ":" + (Minute / 10) + (Minute % 10) + ":" + (Sec / 10) + (Sec % 10) + " / " + (Hour1 / 10) + (Hour1 % 10) + ":" + (Minute1 / 10) + (Minute1 % 10) + ":" + (Sec1 / 10) + (Sec1 % 10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTrackInfo() {
        int value = DataCanbus.DATA[122];
        int value1 = DataCanbus.DATA[123];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText("Track:" + value + "/" + value1);
        }
    }
}
