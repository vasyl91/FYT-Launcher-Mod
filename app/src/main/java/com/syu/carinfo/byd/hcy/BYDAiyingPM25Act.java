package com.syu.carinfo.byd.hcy;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class BYDAiyingPM25Act extends Activity implements View.OnTouchListener {
    public static BYDAiyingPM25Act mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 101:
                    if (((TextView) BYDAiyingPM25Act.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) BYDAiyingPM25Act.this.findViewById(R.id.tv_text2)).setText(String.valueOf(BYDAiyingPM25Act.this.getResources().getString(R.string.str_car_inside)) + " " + value);
                        break;
                    }
                case 102:
                    if (((TextView) BYDAiyingPM25Act.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) BYDAiyingPM25Act.this.findViewById(R.id.tv_text4)).setText(String.valueOf(BYDAiyingPM25Act.this.getResources().getString(R.string.str_car_outside)) + " " + value);
                        break;
                    }
                case 103:
                    switch (value) {
                        case 0:
                        case 1:
                            BYDAiyingPM25Act.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_ay_byd_pm25_quan0);
                            ((TextView) BYDAiyingPM25Act.this.findViewById(R.id.tv_text1)).setText(R.string.str_265_2);
                            break;
                        case 2:
                            ((TextView) BYDAiyingPM25Act.this.findViewById(R.id.tv_text1)).setText(R.string.str_265_3);
                            BYDAiyingPM25Act.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_ay_byd_pm25_quan1);
                            break;
                        case 3:
                            ((TextView) BYDAiyingPM25Act.this.findViewById(R.id.tv_text1)).setText(R.string.str_265_4);
                            BYDAiyingPM25Act.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_ay_byd_pm25_quan2);
                            break;
                        case 4:
                            ((TextView) BYDAiyingPM25Act.this.findViewById(R.id.tv_text1)).setText(R.string.str_265_5);
                            BYDAiyingPM25Act.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_ay_byd_pm25_quan3);
                            break;
                        case 5:
                            ((TextView) BYDAiyingPM25Act.this.findViewById(R.id.tv_text1)).setText(R.string.str_265_6);
                            BYDAiyingPM25Act.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_ay_byd_pm25_quan4);
                            break;
                        case 6:
                            ((TextView) BYDAiyingPM25Act.this.findViewById(R.id.tv_text1)).setText(R.string.str_265_7);
                            BYDAiyingPM25Act.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_ay_byd_pm25_quan5);
                            break;
                    }
                case 104:
                    switch (value) {
                        case 0:
                        case 1:
                            BYDAiyingPM25Act.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_ay_byd_pm25_quan0);
                            ((TextView) BYDAiyingPM25Act.this.findViewById(R.id.tv_text3)).setText(R.string.str_265_2);
                            break;
                        case 2:
                            ((TextView) BYDAiyingPM25Act.this.findViewById(R.id.tv_text3)).setText(R.string.str_265_3);
                            BYDAiyingPM25Act.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_ay_byd_pm25_quan1);
                            break;
                        case 3:
                            ((TextView) BYDAiyingPM25Act.this.findViewById(R.id.tv_text3)).setText(R.string.str_265_4);
                            BYDAiyingPM25Act.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_ay_byd_pm25_quan2);
                            break;
                        case 4:
                            ((TextView) BYDAiyingPM25Act.this.findViewById(R.id.tv_text3)).setText(R.string.str_265_5);
                            BYDAiyingPM25Act.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_ay_byd_pm25_quan3);
                            break;
                        case 5:
                            ((TextView) BYDAiyingPM25Act.this.findViewById(R.id.tv_text3)).setText(R.string.str_265_6);
                            BYDAiyingPM25Act.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_ay_byd_pm25_quan4);
                            break;
                        case 6:
                            ((TextView) BYDAiyingPM25Act.this.findViewById(R.id.tv_text3)).setText(R.string.str_265_7);
                            BYDAiyingPM25Act.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_ay_byd_pm25_quan5);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0455_aiying_byd_pm25_info);
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.btn_plus1).setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addUpdater();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeUpdater();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_plus1 /* 2131427457 */:
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(7, new int[]{1}, null, null);
                }
            default:
                return false;
        }
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
    }
}
