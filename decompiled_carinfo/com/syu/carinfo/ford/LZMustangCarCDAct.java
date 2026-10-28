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

@SuppressWarnings({"deprecation", "unchecked"})
public class LZMustangCarCDAct extends Activity implements View.OnTouchListener {
    public static LZMustangCarCDAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 129:
                    if (((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text6)).setText(R.string.jeep_playstate1);
                                break;
                            case 2:
                                ((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_167_playstate2);
                                break;
                            case 3:
                                ((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text6)).setText(R.string.jeep_playstate5);
                                break;
                            case 4:
                                ((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_167_playstate3);
                                break;
                            case 5:
                                ((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text6)).setText("Reading OK");
                                break;
                            case 6:
                                ((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text6)).setText("Reading error");
                                break;
                            default:
                                ((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text6)).setText("");
                                break;
                        }
                    }
                    break;
                case 130:
                    if (((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text5)).setText(R.string.str_car_cd_ff);
                                break;
                            case 2:
                                ((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text5)).setText(R.string.str_car_cd_fb);
                                break;
                            case 3:
                                ((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text5)).setText(R.string.crv_state_pause);
                                break;
                            case 4:
                                ((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text5)).setText(R.string.crv_state_stop);
                                break;
                            case 5:
                                ((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text5)).setText(R.string.str_sbd_x80_media_state_10);
                                break;
                            default:
                                ((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_playstate2);
                                break;
                        }
                    }
                    break;
                case 131:
                    LZMustangCarCDAct.this.findViewById(R.id.lexus_cd_rpt).setBackgroundResource(value == 0 ? R.drawable.ic_lexus_cd_rpt_n : R.drawable.ic_lexus_cd_rpt_p);
                    break;
                case 132:
                    LZMustangCarCDAct.this.findViewById(R.id.lexus_cd_random).setBackgroundResource(value == 0 ? R.drawable.ic_lexus_cd_random_n : R.drawable.ic_lexus_cd_random_p);
                    break;
                case 134:
                case 135:
                    LZMustangCarCDAct.this.updaterTrackInfo();
                    break;
                case 136:
                case 137:
                    LZMustangCarCDAct.this.updaterTimeInfo();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_lz_mustang_carcd);
        mInstance = this;
        init();
    }

    public void init() {
        findViewById(R.id.lexus_cd_rpt).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_random).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_prev).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_skipb).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_skipf).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_next).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_eject).setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
        if (DataCanbus.DATA[138] != 2) {
            DataCanbus.PROXY.cmd(1, new int[]{176, 2}, null, null);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_cd_rpt /* 2131427678 */:
                    if (DataCanbus.DATA[131] == 1) {
                        DataCanbus.PROXY.cmd(2, new int[]{14, 1}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(2, new int[]{14}, null, null);
                        break;
                    }
                case R.id.lexus_cd_random /* 2131427679 */:
                    if (DataCanbus.DATA[132] == 1) {
                        DataCanbus.PROXY.cmd(2, new int[]{14, 3}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(2, new int[]{14, 2}, null, null);
                        break;
                    }
                case R.id.lexus_cd_prev /* 2131427859 */:
                    DataCanbus.PROXY.cmd(2, new int[]{14, 7}, null, null);
                    break;
                case R.id.lexus_cd_skipb /* 2131427860 */:
                    DataCanbus.PROXY.cmd(2, new int[]{14, 9}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131427863 */:
                    DataCanbus.PROXY.cmd(2, new int[]{14, 8}, null, null);
                    break;
                case R.id.lexus_cd_next /* 2131427864 */:
                    DataCanbus.PROXY.cmd(2, new int[]{14, 6}, null, null);
                    break;
                case R.id.lexus_cd_eject /* 2131427865 */:
                    DataCanbus.PROXY.cmd(2, new int[]{14, 11}, null, null);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.lexus_cd_skipb /* 2131427860 */:
                    DataCanbus.PROXY.cmd(2, new int[]{14, 10}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131427863 */:
                    DataCanbus.PROXY.cmd(2, new int[]{14, 10}, null, null);
                    break;
            }
        }
        return false;
    }

    
    public void updaterTimeInfo() {
        int Minute = DataCanbus.DATA[136] & 255;
        int Sec = DataCanbus.DATA[137] & 255;
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(Minute / 10) + (Minute % 10) + ":" + (Sec / 10) + (Sec % 10));
        }
    }

    
    public void updaterTrackInfo() {
        int value = DataCanbus.DATA[134];
        int value1 = DataCanbus.DATA[135];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText("Track: " + value + "/" + value1);
        }
    }
}
