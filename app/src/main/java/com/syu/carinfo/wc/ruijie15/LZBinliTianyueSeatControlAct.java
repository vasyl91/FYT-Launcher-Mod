package com.syu.carinfo.wc.ruijie15;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class LZBinliTianyueSeatControlAct extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = R.drawable.ic_xts_auto_n;
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 29:
                    switch (value) {
                        case 0:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level0);
                            break;
                        case 1:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level1);
                            break;
                        case 2:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level2);
                            break;
                        case 3:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level3);
                            break;
                    }
                case 30:
                    switch (value) {
                        case 0:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level0);
                            break;
                        case 1:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level1);
                            break;
                        case 2:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level2);
                            break;
                        case 3:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level3);
                            break;
                    }
                case 31:
                    switch (value) {
                        case 0:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level0);
                            break;
                        case 1:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level1);
                            break;
                        case 2:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level2);
                            break;
                        case 3:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level3);
                            break;
                    }
                case 32:
                    switch (value) {
                        case 0:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level0);
                            break;
                        case 1:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level1);
                            break;
                        case 2:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level2);
                            break;
                        case 3:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level3);
                            break;
                    }
                case 98:
                    View findViewById = LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seatcold_auto_left);
                    if (value != 0) {
                        i = 2130842686;
                    }
                    findViewById.setBackgroundResource(i);
                    break;
                case 99:
                    View findViewById2 = LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seatcold_auto_right);
                    if (value != 0) {
                        i = 2130842686;
                    }
                    findViewById2.setBackgroundResource(i);
                    break;
                case 100:
                    View findViewById3 = LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seathot_auto_left);
                    if (value != 0) {
                        i = 2130842686;
                    }
                    findViewById3.setBackgroundResource(i);
                    break;
                case 101:
                    View findViewById4 = LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seathot_auto_right);
                    if (value != 0) {
                        i = 2130842686;
                    }
                    findViewById4.setBackgroundResource(i);
                    break;
                case 102:
                case 103:
                    int waist = DataCanbus.DATA[102];
                    int bottom = DataCanbus.DATA[103];
                    int data = ((waist << 1) & 2) | (bottom & 1);
                    switch (data) {
                        case 0:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_hotleft).setBackgroundResource(R.drawable.ic_seathot_left_0);
                            break;
                        case 1:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_hotleft).setBackgroundResource(R.drawable.ic_seathot_left_1);
                            break;
                        case 2:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_hotleft).setBackgroundResource(R.drawable.ic_seathot_left_2);
                            break;
                        case 3:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_hotleft).setBackgroundResource(R.drawable.ic_seathot_left_3);
                            break;
                    }
                case 104:
                case 105:
                    int waist2 = DataCanbus.DATA[104];
                    int bottom2 = DataCanbus.DATA[105];
                    int data2 = ((waist2 << 1) & 2) | (bottom2 & 1);
                    switch (data2) {
                        case 0:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_hotright).setBackgroundResource(R.drawable.ic_seathot_right_0);
                            break;
                        case 1:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_hotright).setBackgroundResource(R.drawable.ic_seathot_right_1);
                            break;
                        case 2:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_hotright).setBackgroundResource(R.drawable.ic_seathot_right_2);
                            break;
                        case 3:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_hotright).setBackgroundResource(R.drawable.ic_seathot_right_3);
                            break;
                    }
                case 106:
                case 107:
                    int waist3 = DataCanbus.DATA[106];
                    int bottom3 = DataCanbus.DATA[107];
                    int data3 = ((waist3 << 1) & 2) | (bottom3 & 1);
                    switch (data3) {
                        case 0:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_coldleft).setBackgroundResource(R.drawable.ic_seatcold_left_0);
                            break;
                        case 1:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_coldleft).setBackgroundResource(R.drawable.ic_seatcold_left_1);
                            break;
                        case 2:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_coldleft).setBackgroundResource(R.drawable.ic_seatcold_left_2);
                            break;
                        case 3:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_coldleft).setBackgroundResource(R.drawable.ic_seatcold_left_3);
                            break;
                    }
                case 108:
                case 109:
                    int waist4 = DataCanbus.DATA[108];
                    int bottom4 = DataCanbus.DATA[109];
                    int data4 = ((waist4 << 1) & 2) | (bottom4 & 1);
                    switch (data4) {
                        case 0:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_coldright).setBackgroundResource(R.drawable.ic_seatcold_right_0);
                            break;
                        case 1:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_coldright).setBackgroundResource(R.drawable.ic_seatcold_right_1);
                            break;
                        case 2:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_coldright).setBackgroundResource(R.drawable.ic_seatcold_right_2);
                            break;
                        case 3:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_coldright).setBackgroundResource(R.drawable.ic_seatcold_right_3);
                            break;
                    }
            }
        }
    };

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(0, new int[]{data0, data1}, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_lz_binli_tianyue_airseat_control);
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_seat_hotleft).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_auto_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_seat_hotright).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_auto_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_seat_coldleft).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatcold_auto_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_seat_coldright).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatcold_auto_right).setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        DataCanbus.PROXY.cmd(1, new int[]{3}, null, null);
        addUpdater();
        AirHelper.disableAirWindowLocal(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeUpdater();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        switch (id) {
            case R.id.air_xts_seathot_left /* 2131427433 */:
                data0 = 27;
                break;
            case R.id.air_xts_seathot_right /* 2131427435 */:
                data0 = 28;
                break;
            case R.id.air_xts_seatwin_left /* 2131427452 */:
                data0 = 29;
                break;
            case R.id.air_xts_seatwin_right /* 2131427454 */:
                data0 = 30;
                break;
            case R.id.air_xts_seat_coldleft /* 2131428620 */:
                data0 = 37;
                break;
            case R.id.air_xts_seatcold_auto_left /* 2131428621 */:
                data0 = 39;
                break;
            case R.id.air_xts_seat_coldright /* 2131428622 */:
                data0 = 40;
                break;
            case R.id.air_xts_seatcold_auto_right /* 2131428623 */:
                data0 = 42;
                break;
            case R.id.air_xts_seat_hotleft /* 2131428624 */:
                data0 = 31;
                break;
            case R.id.air_xts_seathot_auto_left /* 2131428625 */:
                data0 = 33;
                break;
            case R.id.air_xts_seat_hotright /* 2131428626 */:
                data0 = 34;
                break;
            case R.id.air_xts_seathot_auto_right /* 2131428627 */:
                data0 = 36;
                break;
        }
        if (event.getAction() == 0) {
            sendCmd(20, data0);
            return false;
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
    }
}
