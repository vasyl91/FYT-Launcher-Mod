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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LZRam1500CarCDAct extends Activity implements View.OnTouchListener {
    public static LZRam1500CarCDAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ford.LZRam1500CarCDAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 162:
                    if (((TextView) LZRam1500CarCDAct.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) LZRam1500CarCDAct.this.findViewById(R.id.tv_text3)).setText("DISC");
                                break;
                            default:
                                ((TextView) LZRam1500CarCDAct.this.findViewById(R.id.tv_text3)).setText(R.string.jeep_playstate1);
                                break;
                        }
                    }
                    break;
                case 163:
                    if (((TextView) LZRam1500CarCDAct.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) LZRam1500CarCDAct.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_playstate6);
                                break;
                            case 2:
                                ((TextView) LZRam1500CarCDAct.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_playstate2);
                                break;
                            default:
                                ((TextView) LZRam1500CarCDAct.this.findViewById(R.id.tv_text5)).setText(R.string.str_status_idle);
                                break;
                        }
                    }
                    break;
                case 164:
                    LZRam1500CarCDAct.this.findViewById(R.id.lexus_cd_random).setBackgroundResource(value == 0 ? R.drawable.ic_lexus_cd_random_n : R.drawable.ic_lexus_cd_random_p);
                    break;
                case 165:
                    LZRam1500CarCDAct.this.findViewById(R.id.lexus_cd_rpt).setBackgroundResource(value == 0 ? R.drawable.ic_lexus_cd_rpt_n : R.drawable.ic_lexus_cd_rpt_p);
                    break;
                case 166:
                case 167:
                    LZRam1500CarCDAct.this.updaterTrackInfo();
                    break;
                case 168:
                case 169:
                    LZRam1500CarCDAct.this.updaterTimeInfo();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0455_lz_ram1500_carcd);
        mInstance = this;
        init();
    }

    public void init() {
        findViewById(R.id.lexus_cd_rpt).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_random).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_prev).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_play).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_pause).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_next).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_cd_rpt /* 2131427786 */:
                    DataCanbus.PROXY.cmd(0, new int[]{70, 4}, null, null);
                    break;
                case R.id.lexus_cd_random /* 2131427787 */:
                    DataCanbus.PROXY.cmd(0, new int[]{70, 3}, null, null);
                    break;
                case R.id.lexus_cd_prev /* 2131428049 */:
                    DataCanbus.PROXY.cmd(0, new int[]{70, 1}, null, null);
                    break;
                case R.id.lexus_cd_play /* 2131428051 */:
                    if (DataCanbus.DATA[163] != 2) {
                        DataCanbus.PROXY.cmd(0, new int[]{70, 2}, null, null);
                    }
                    break;
                case R.id.lexus_cd_pause /* 2131428052 */:
                    if (DataCanbus.DATA[163] == 2) {
                        DataCanbus.PROXY.cmd(0, new int[]{70, 2}, null, null);
                    }
                    break;
                case R.id.lexus_cd_next /* 2131428054 */:
                    DataCanbus.PROXY.cmd(0, new int[]{70, 0}, null, null);
                    break;
            }
        } else {
            event.getAction();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTimeInfo() {
        int Minute = (DataCanbus.DATA[168] >> 8) & 255;
        int Sec = DataCanbus.DATA[168] & 255;
        int Minute1 = (DataCanbus.DATA[169] >> 8) & 255;
        int Sec1 = DataCanbus.DATA[169] & 255;
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText((Minute / 10) + (Minute % 10) + ":" + (Sec / 10) + (Sec % 10) + " / " + (Minute1 / 10) + (Minute1 % 10) + ":" + (Sec1 / 10) + (Sec1 % 10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTrackInfo() {
        int value = DataCanbus.DATA[166];
        int value1 = DataCanbus.DATA[167];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText("Track:" + value + "/" + value1);
        }
    }
}
