package com.syu.carinfo.hechi.fordexplorer;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class HcFordExplorerSeatSet extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static HcFordExplorerSeatSet mInit;
    byte unit = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            HcFordExplorerSeatSet.this.updateSeatState();
        }
    };
    int state = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_xc_ford_seatset);
        init();
    }

    public void init() {
        mInit = this;
        findViewById(R.id.ford_seat_sub1).setOnTouchListener(this);
        findViewById(R.id.ford_seat_sub2).setOnTouchListener(this);
        findViewById(R.id.ford_seat_sub3).setOnTouchListener(this);
        findViewById(R.id.ford_seat_add1).setOnTouchListener(this);
        findViewById(R.id.ford_seat_add2).setOnTouchListener(this);
        findViewById(R.id.ford_seat_add3).setOnTouchListener(this);
        findViewById(R.id.ford_seat_sub_1).setOnTouchListener(this);
        findViewById(R.id.ford_seat_sub_2).setOnTouchListener(this);
        findViewById(R.id.ford_seat_add_1).setOnTouchListener(this);
        findViewById(R.id.ford_seat_add_2).setOnTouchListener(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.ford_seat_sub1 /* 2131427833 */:
                    if (this.state == 4) {
                        DataCanbus.PROXY.cmd(7, new int[]{1, 1}, null, null);
                        break;
                    } else if (this.state == 6) {
                        DataCanbus.PROXY.cmd(7, new int[]{4, 1}, null, null);
                        break;
                    }
                case R.id.ford_seat_sub2 /* 2131427834 */:
                    if (this.state == 4) {
                        DataCanbus.PROXY.cmd(7, new int[]{2, 1}, null, null);
                        break;
                    } else if (this.state == 6) {
                        DataCanbus.PROXY.cmd(7, new int[]{5, 1}, null, null);
                        break;
                    }
                case R.id.ford_seat_sub3 /* 2131427835 */:
                    if (this.state == 4) {
                        DataCanbus.PROXY.cmd(7, new int[]{3, 1}, null, null);
                        break;
                    } else if (this.state == 6) {
                        DataCanbus.PROXY.cmd(7, new int[]{6, 1}, null, null);
                        break;
                    }
                case R.id.ford_seat_add1 /* 2131427836 */:
                    if (this.state == 4) {
                        DataCanbus.PROXY.cmd(7, new int[]{1, 2}, null, null);
                        break;
                    } else if (this.state == 6) {
                        DataCanbus.PROXY.cmd(7, new int[]{4, 2}, null, null);
                        break;
                    }
                case R.id.ford_seat_add2 /* 2131427837 */:
                    if (this.state == 4) {
                        DataCanbus.PROXY.cmd(7, new int[]{2, 2}, null, null);
                        break;
                    } else if (this.state == 6) {
                        DataCanbus.PROXY.cmd(7, new int[]{5, 2}, null, null);
                        break;
                    }
                case R.id.ford_seat_add3 /* 2131427838 */:
                    if (this.state == 4) {
                        DataCanbus.PROXY.cmd(7, new int[]{3, 1}, null, null);
                        break;
                    } else if (this.state == 6) {
                        DataCanbus.PROXY.cmd(7, new int[]{6, 1}, null, null);
                        break;
                    }
                case R.id.ford_seat_sub_1 /* 2131427839 */:
                    if (this.state == 5) {
                        int value = DataCanbus.DATA[141] - 1;
                        if (value < 0) {
                            value = 2;
                        }
                        DataCanbus.PROXY.cmd(7, new int[]{7, value}, null, null);
                        break;
                    } else if (this.state == 7) {
                        int value2 = DataCanbus.DATA[144] - 1;
                        if (value2 < 0) {
                            value2 = 2;
                        }
                        DataCanbus.PROXY.cmd(7, new int[]{9, value2}, null, null);
                        break;
                    }
                case R.id.ford_seat_sub_2 /* 2131427840 */:
                    if (this.state == 5) {
                        int value3 = DataCanbus.DATA[142] - 1;
                        if (value3 < 0) {
                            value3 = 2;
                        }
                        DataCanbus.PROXY.cmd(7, new int[]{8, value3}, null, null);
                        break;
                    } else if (this.state == 7) {
                        int value4 = DataCanbus.DATA[145] - 1;
                        if (value4 < 0) {
                            value4 = 2;
                        }
                        DataCanbus.PROXY.cmd(7, new int[]{10, value4}, null, null);
                        break;
                    }
                case R.id.ford_seat_add_1 /* 2131427841 */:
                    if (this.state == 5) {
                        int value5 = DataCanbus.DATA[141] + 1;
                        if (value5 > 2) {
                            value5 = 0;
                        }
                        DataCanbus.PROXY.cmd(7, new int[]{7, value5}, null, null);
                        break;
                    } else if (this.state == 7) {
                        int value6 = DataCanbus.DATA[144] + 1;
                        if (value6 > 2) {
                            value6 = 0;
                        }
                        DataCanbus.PROXY.cmd(7, new int[]{9, value6}, null, null);
                        break;
                    }
                case R.id.ford_seat_add_2 /* 2131427842 */:
                    if (this.state == 5) {
                        int value7 = DataCanbus.DATA[142] + 1;
                        if (value7 > 2) {
                            value7 = 0;
                        }
                        DataCanbus.PROXY.cmd(7, new int[]{8, value7}, null, null);
                        break;
                    } else if (this.state == 7) {
                        int value8 = DataCanbus.DATA[145] + 1;
                        if (value8 > 2) {
                            value8 = 0;
                        }
                        DataCanbus.PROXY.cmd(7, new int[]{10, value8}, null, null);
                        break;
                    }
            }
        } else if (event.getAction() == 1) {
            v.getId();
        }
        return false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.notifyCanbus);
    }

    public void updateSeatState() {
        if (DataCanbus.DATA[146] != 0) {
            this.state = DataCanbus.DATA[146];
        }
        switch (this.state) {
            case 4:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(8);
                ((TextView) findViewById(R.id.tv_text1)).setText("驾驶侧靠背");
                switch (DataCanbus.DATA[131]) {
                    case 0:
                        ((TextView) findViewById(R.id.tv_text2)).setText("");
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_null);
                        break;
                    case 1:
                        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(DataCanbus.DATA[133]).toString());
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_waist1);
                        break;
                    case 2:
                        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(DataCanbus.DATA[134]).toString());
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_waist2);
                        break;
                    case 3:
                        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(DataCanbus.DATA[135]).toString());
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_waist3);
                        break;
                }
            case 5:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(0);
                ((TextView) findViewById(R.id.tv_text1)).setText("驾驶侧按摩");
                switch (DataCanbus.DATA[140]) {
                    case 0:
                        ((TextView) findViewById(R.id.tv_text2)).setText("");
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_null);
                        break;
                    case 1:
                        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(DataCanbus.DATA[141]).toString());
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_massage1);
                        break;
                    case 2:
                        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(DataCanbus.DATA[142]).toString());
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_massage2);
                        break;
                }
            case 6:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(8);
                ((TextView) findViewById(R.id.tv_text1)).setText("乘客侧靠背");
                switch (DataCanbus.DATA[132]) {
                    case 0:
                        ((TextView) findViewById(R.id.tv_text2)).setText("");
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_null);
                        break;
                    case 1:
                        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(DataCanbus.DATA[136]).toString());
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_waist1);
                        break;
                    case 2:
                        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(DataCanbus.DATA[137]).toString());
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_waist2);
                        break;
                    case 3:
                        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(DataCanbus.DATA[138]).toString());
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_waist3);
                        break;
                }
            case 7:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(0);
                ((TextView) findViewById(R.id.tv_text1)).setText("乘客侧按摩");
                switch (DataCanbus.DATA[143]) {
                    case 0:
                        ((TextView) findViewById(R.id.tv_text2)).setText("");
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_null);
                        break;
                    case 1:
                        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(DataCanbus.DATA[144]).toString());
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_massage1);
                        break;
                    case 2:
                        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(DataCanbus.DATA[145]).toString());
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_massage2);
                        break;
                }
            default:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(8);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        isFront = true;
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }
}
