package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0452_PA_Ford_F150;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class PAFordCarSyncActi extends BaseActivity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    int totaltrack = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAFordCarSyncActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = R.drawable.icon_car_null;
            int i2 = R.drawable.ic_pa_ford_car_cd_n;
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 131:
                    if (((TextView) PAFordCarSyncActi.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) PAFordCarSyncActi.this.findViewById(R.id.tv_text4)).setText("Vol: " + value);
                    }
                    break;
                case 133:
                    if (((TextView) PAFordCarSyncActi.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) PAFordCarSyncActi.this.findViewById(R.id.tv_text1)).setText(Callback_0452_PA_Ford_F150.Str_Line1);
                    }
                    break;
                case 134:
                    View viewFindViewById = PAFordCarSyncActi.this.findViewById(R.id.id_image7);
                    if (value != 0) {
                        i2 = 2130841480;
                    }
                    viewFindViewById.setBackgroundResource(i2);
                    break;
                case 135:
                    View viewFindViewById2 = PAFordCarSyncActi.this.findViewById(R.id.id_image8);
                    if (value != 0) {
                        i2 = 2130841480;
                    }
                    viewFindViewById2.setBackgroundResource(i2);
                    break;
                case 136:
                    View viewFindViewById3 = PAFordCarSyncActi.this.findViewById(R.id.id_image9);
                    if (value != 0) {
                        i2 = 2130841480;
                    }
                    viewFindViewById3.setBackgroundResource(i2);
                    break;
                case 137:
                    View viewFindViewById4 = PAFordCarSyncActi.this.findViewById(R.id.id_image10);
                    if (value != 0) {
                        i2 = 2130841480;
                    }
                    viewFindViewById4.setBackgroundResource(i2);
                    break;
                case 138:
                    View viewFindViewById5 = PAFordCarSyncActi.this.findViewById(R.id.id_image11);
                    if (value != 0) {
                        i2 = 2130841480;
                    }
                    viewFindViewById5.setBackgroundResource(i2);
                    break;
                case 139:
                    PAFordCarSyncActi.this.findViewById(R.id.id_image12).setBackgroundResource(value == 0 ? 2130841479 : 2130841480);
                    break;
                case 140:
                    View viewFindViewById6 = PAFordCarSyncActi.this.findViewById(R.id.id_image1);
                    if (value != 0) {
                        i = R.drawable.ic_pa_ford_car_text_p;
                    }
                    viewFindViewById6.setBackgroundResource(i);
                    break;
                case 141:
                    View viewFindViewById7 = PAFordCarSyncActi.this.findViewById(R.id.id_image2);
                    if (value != 0) {
                        i = R.drawable.ic_pa_ford_car_rds_p;
                    }
                    viewFindViewById7.setBackgroundResource(i);
                    break;
                case 142:
                    View viewFindViewById8 = PAFordCarSyncActi.this.findViewById(R.id.id_image3);
                    if (value != 0) {
                        i = R.drawable.ic_pa_ford_car_st_p;
                    }
                    viewFindViewById8.setBackgroundResource(i);
                    break;
                case 143:
                    View viewFindViewById9 = PAFordCarSyncActi.this.findViewById(R.id.id_image4);
                    if (value != 0) {
                        i = R.drawable.ic_pa_ford_car_cat_p;
                    }
                    viewFindViewById9.setBackgroundResource(i);
                    break;
                case 144:
                    View viewFindViewById10 = PAFordCarSyncActi.this.findViewById(R.id.id_image5);
                    if (value != 0) {
                        i = R.drawable.ic_pa_ford_car_fold_p;
                    }
                    viewFindViewById10.setBackgroundResource(i);
                    break;
                case 145:
                    View viewFindViewById11 = PAFordCarSyncActi.this.findViewById(R.id.id_image6);
                    if (value != 0) {
                        i = R.drawable.ic_pa_ford_car_bt_p;
                    }
                    viewFindViewById11.setBackgroundResource(i);
                    break;
                case 146:
                    if (((TextView) PAFordCarSyncActi.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) PAFordCarSyncActi.this.findViewById(R.id.tv_text2)).setText(Callback_0452_PA_Ford_F150.Str_Line2);
                    }
                    break;
                case 147:
                    if (((TextView) PAFordCarSyncActi.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) PAFordCarSyncActi.this.findViewById(R.id.tv_text3)).setText(Callback_0452_PA_Ford_F150.Str_Line3);
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_pa_ford_car_sync);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.btn_plus1)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus6)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus7)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus8)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus9)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus10)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus11)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus12)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus13)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus14)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus15)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus16)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus17)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus18)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus19)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus20)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus21)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus22)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus23)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus24)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus25)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus26)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus27)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus28)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus29)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus30)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus31)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus32)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus33)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus34)).setOnTouchListener(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        switch (id) {
            case R.id.btn_plus1 /* 2131427458 */:
                data0 = 12;
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                data0 = 10;
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                data0 = 11;
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                data0 = 3;
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                data0 = 9;
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                data0 = 13;
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                data0 = 15;
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                data0 = 49;
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                data0 = 50;
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                data0 = 51;
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                data0 = 52;
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                data0 = 53;
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                data0 = 54;
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                data0 = 55;
                break;
            case R.id.btn_plus15 /* 2131427500 */:
                data0 = 56;
                break;
            case R.id.btn_plus16 /* 2131427503 */:
                data0 = 57;
                break;
            case R.id.btn_plus17 /* 2131427506 */:
                data0 = 48;
                break;
            case R.id.btn_plus18 /* 2131427509 */:
                data0 = 16;
                break;
            case R.id.btn_plus19 /* 2131427595 */:
                data0 = 17;
                break;
            case R.id.btn_plus20 /* 2131427599 */:
                data0 = 24;
                break;
            case R.id.btn_plus21 /* 2131427602 */:
                data0 = 25;
                break;
            case R.id.btn_plus22 /* 2131427605 */:
                data0 = 18;
                break;
            case R.id.btn_plus23 /* 2131427609 */:
                data0 = 19;
                break;
            case R.id.btn_plus24 /* 2131427612 */:
                data0 = 20;
                break;
            case R.id.btn_plus25 /* 2131427615 */:
                data0 = 21;
                break;
            case R.id.btn_plus26 /* 2131427619 */:
                data0 = 5;
                break;
            case R.id.btn_plus27 /* 2131427622 */:
                data0 = 6;
                break;
            case R.id.btn_plus28 /* 2131427625 */:
                data0 = 4;
                break;
            case R.id.btn_plus29 /* 2131427629 */:
                data0 = 22;
                break;
            case R.id.btn_plus30 /* 2131427632 */:
                data0 = 2;
                break;
            case R.id.btn_plus31 /* 2131427829 */:
                data0 = 1;
                break;
            case R.id.btn_plus32 /* 2131427831 */:
                data0 = 23;
                break;
            case R.id.btn_plus33 /* 2131427833 */:
                data0 = 7;
                break;
            case R.id.btn_plus34 /* 2131427835 */:
                data0 = 8;
                break;
        }
        if (data0 != 0) {
            if (event.getAction() == 0) {
                sendCmd(data0, 1);
            } else if (event.getAction() == 1) {
                sendCmd(data0, 0);
            }
        }
        return false;
    }

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(2, new int[]{data0, data1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        FuncMain.setChannel(13);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
    }
}
