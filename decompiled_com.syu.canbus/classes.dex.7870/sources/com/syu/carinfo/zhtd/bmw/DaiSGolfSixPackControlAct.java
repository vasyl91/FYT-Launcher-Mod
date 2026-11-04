package com.syu.carinfo.zhtd.bmw;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class DaiSGolfSixPackControlAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private DSOutModeShowWindow mDsOutModeshowWindow;
    int pagenum = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.DaiSGolfSixPackControlAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 29:
                    DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus10).setBackgroundResource(R.drawable.ic_ds_golf_button_n);
                    DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus11).setBackgroundResource(R.drawable.ic_ds_golf_button_n);
                    DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus12).setBackgroundResource(R.drawable.ic_ds_golf_button_n);
                    DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus13).setBackgroundResource(R.drawable.ic_ds_golf_button_n);
                    switch (value) {
                        case 1:
                            DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus10).setBackgroundResource(R.drawable.ic_ds_golf_button_p);
                            break;
                        case 2:
                            DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus11).setBackgroundResource(R.drawable.ic_ds_golf_button_p);
                            break;
                        case 3:
                            DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus12).setBackgroundResource(R.drawable.ic_ds_golf_button_p);
                            break;
                        case 4:
                            DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus13).setBackgroundResource(R.drawable.ic_ds_golf_button_p);
                            break;
                    }
                    break;
                case 31:
                    DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus14).setBackgroundResource(R.drawable.ic_ds_golf_button_n);
                    DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus15).setBackgroundResource(R.drawable.ic_ds_golf_button_n);
                    DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus16).setBackgroundResource(R.drawable.ic_ds_golf_button_n);
                    DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus17).setBackgroundResource(R.drawable.ic_ds_golf_button_n);
                    switch (value) {
                        case 1:
                            DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus14).setBackgroundResource(R.drawable.ic_ds_golf_button_p);
                            break;
                        case 2:
                            DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus15).setBackgroundResource(R.drawable.ic_ds_golf_button_p);
                            break;
                        case 3:
                            DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus16).setBackgroundResource(R.drawable.ic_ds_golf_button_p);
                            break;
                        case 4:
                            DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus17).setBackgroundResource(R.drawable.ic_ds_golf_button_p);
                            break;
                    }
                    break;
                case 33:
                    DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus18).setBackgroundResource(R.drawable.ic_ds_golf_button_n);
                    DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus19).setBackgroundResource(R.drawable.ic_ds_golf_button_n);
                    DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus20).setBackgroundResource(R.drawable.ic_ds_golf_button_n);
                    DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus21).setBackgroundResource(R.drawable.ic_ds_golf_button_n);
                    switch (value) {
                        case 1:
                            DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus18).setBackgroundResource(R.drawable.ic_ds_golf_button_p);
                            break;
                        case 2:
                            DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus19).setBackgroundResource(R.drawable.ic_ds_golf_button_p);
                            break;
                        case 3:
                            DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus20).setBackgroundResource(R.drawable.ic_ds_golf_button_p);
                            break;
                        case 4:
                            DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus21).setBackgroundResource(R.drawable.ic_ds_golf_button_p);
                            break;
                    }
                    break;
                case 35:
                    DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus22).setBackgroundResource(R.drawable.ic_ds_golf_button_n);
                    DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus23).setBackgroundResource(R.drawable.ic_ds_golf_button_n);
                    DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus24).setBackgroundResource(R.drawable.ic_ds_golf_button_n);
                    DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus25).setBackgroundResource(R.drawable.ic_ds_golf_button_n);
                    switch (value) {
                        case 1:
                            DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus22).setBackgroundResource(R.drawable.ic_ds_golf_button_p);
                            break;
                        case 2:
                            DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus23).setBackgroundResource(R.drawable.ic_ds_golf_button_p);
                            break;
                        case 3:
                            DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus24).setBackgroundResource(R.drawable.ic_ds_golf_button_p);
                            break;
                        case 4:
                            DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus25).setBackgroundResource(R.drawable.ic_ds_golf_button_p);
                            break;
                    }
                    break;
                case 37:
                    DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus26).setBackgroundResource(R.drawable.ic_ds_golf_button_n);
                    DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus27).setBackgroundResource(R.drawable.ic_ds_golf_button_n);
                    DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus28).setBackgroundResource(R.drawable.ic_ds_golf_button_n);
                    DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus29).setBackgroundResource(R.drawable.ic_ds_golf_button_n);
                    switch (value) {
                        case 1:
                            DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus26).setBackgroundResource(R.drawable.ic_ds_golf_button_p);
                            break;
                        case 2:
                            DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus27).setBackgroundResource(R.drawable.ic_ds_golf_button_p);
                            break;
                        case 3:
                            DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus28).setBackgroundResource(R.drawable.ic_ds_golf_button_p);
                            break;
                        case 4:
                            DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus29).setBackgroundResource(R.drawable.ic_ds_golf_button_p);
                            break;
                    }
                    break;
                case 39:
                    DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus30).setBackgroundResource(R.drawable.ic_ds_golf_button_n);
                    DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus31).setBackgroundResource(R.drawable.ic_ds_golf_button_n);
                    DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus32).setBackgroundResource(R.drawable.ic_ds_golf_button_n);
                    DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus33).setBackgroundResource(R.drawable.ic_ds_golf_button_n);
                    switch (value) {
                        case 1:
                            DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus30).setBackgroundResource(R.drawable.ic_ds_golf_button_p);
                            break;
                        case 2:
                            DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus31).setBackgroundResource(R.drawable.ic_ds_golf_button_p);
                            break;
                        case 3:
                            DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus32).setBackgroundResource(R.drawable.ic_ds_golf_button_p);
                            break;
                        case 4:
                            DaiSGolfSixPackControlAct.this.findViewById(R.id.btn_plus33).setBackgroundResource(R.drawable.ic_ds_golf_button_p);
                            break;
                    }
                    break;
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                    DaiSGolfSixPackControlAct.this.UpdateOutPutSel();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0456_ds_golf_6packswitch);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick(findViewById(R.id.layout_text_view1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick(findViewById(R.id.layout_text_view2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick(findViewById(R.id.layout_text_view3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick(findViewById(R.id.layout_text_view4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick(findViewById(R.id.layout_text_view5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick(findViewById(R.id.layout_text_view6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick(findViewById(R.id.layout_text_view7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick(findViewById(R.id.layout_view3), this);
        setSelfClick(findViewById(R.id.layout_view4), this);
        setSelfClick(findViewById(R.id.layout_view5), this);
        setSelfClick(findViewById(R.id.layout_view6), this);
        setSelfClick(findViewById(R.id.layout_view7), this);
        setSelfClick(findViewById(R.id.layout_view8), this);
        setSelfClick(findViewById(R.id.layout_view9), this);
        setSelfClick(findViewById(R.id.layout_view10), this);
        setSelfClick(findViewById(R.id.layout_view11), this);
        setSelfClick(findViewById(R.id.layout_view12), this);
        setSelfClick(findViewById(R.id.layout_view13), this);
        setSelfClick(findViewById(R.id.layout_view14), this);
        setSelfClick(findViewById(R.id.layout_view15), this);
        setSelfClick(findViewById(R.id.layout_view16), this);
        setSelfClick(findViewById(R.id.layout_view17), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus13), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus15), this);
        setSelfClick((Button) findViewById(R.id.btn_plus16), this);
        setSelfClick((Button) findViewById(R.id.btn_plus17), this);
        setSelfClick((Button) findViewById(R.id.btn_plus18), this);
        setSelfClick((Button) findViewById(R.id.btn_plus19), this);
        setSelfClick((Button) findViewById(R.id.btn_plus20), this);
        setSelfClick((Button) findViewById(R.id.btn_plus21), this);
        setSelfClick((Button) findViewById(R.id.btn_plus22), this);
        setSelfClick((Button) findViewById(R.id.btn_plus23), this);
        setSelfClick((Button) findViewById(R.id.btn_plus24), this);
        setSelfClick((Button) findViewById(R.id.btn_plus25), this);
        setSelfClick((Button) findViewById(R.id.btn_plus26), this);
        setSelfClick((Button) findViewById(R.id.btn_plus27), this);
        setSelfClick((Button) findViewById(R.id.btn_plus28), this);
        setSelfClick((Button) findViewById(R.id.btn_plus29), this);
        setSelfClick((Button) findViewById(R.id.btn_plus30), this);
        setSelfClick((Button) findViewById(R.id.btn_plus31), this);
        setSelfClick((Button) findViewById(R.id.btn_plus32), this);
        setSelfClick((Button) findViewById(R.id.btn_plus33), this);
        setSelfClick((Button) findViewById(R.id.btn_plus34), this);
        this.mDsOutModeshowWindow = new DSOutModeShowWindow(this);
        ((Button) findViewById(R.id.btn_plus34)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.zhtd.bmw.DaiSGolfSixPackControlAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DaiSGolfSixPackControlAct.this.mDsOutModeshowWindow.showWindow(v);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_view3 /* 2131427406 */:
                DataCanbus.PROXY.cmd(99, new int[]{this.pagenum, 1}, null, null);
                break;
            case R.id.layout_view4 /* 2131427407 */:
                DataCanbus.PROXY.cmd(99, new int[]{this.pagenum, 2}, null, null);
                break;
            case R.id.layout_view5 /* 2131427408 */:
                DataCanbus.PROXY.cmd(99, new int[]{this.pagenum, 3}, null, null);
                break;
            case R.id.layout_view6 /* 2131427409 */:
                DataCanbus.PROXY.cmd(99, new int[]{this.pagenum, 4}, null, null);
                break;
            case R.id.layout_view7 /* 2131427410 */:
                DataCanbus.PROXY.cmd(99, new int[]{this.pagenum, 5}, null, null);
                break;
            case R.id.layout_view8 /* 2131427411 */:
                DataCanbus.PROXY.cmd(99, new int[]{this.pagenum, 6}, null, null);
                break;
            case R.id.layout_view9 /* 2131427412 */:
                DataCanbus.PROXY.cmd(99, new int[]{this.pagenum, 7}, null, null);
                break;
            case R.id.layout_view10 /* 2131427413 */:
                DataCanbus.PROXY.cmd(99, new int[]{this.pagenum, 8}, null, null);
                break;
            case R.id.layout_view11 /* 2131427414 */:
                DataCanbus.PROXY.cmd(99, new int[]{this.pagenum, 9}, null, null);
                break;
            case R.id.layout_view12 /* 2131427415 */:
                DataCanbus.PROXY.cmd(99, new int[]{this.pagenum, 10}, null, null);
                break;
            case R.id.layout_view13 /* 2131427416 */:
                DataCanbus.PROXY.cmd(99, new int[]{this.pagenum, 11}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
            case R.id.layout_text_view1 /* 2131427554 */:
                this.pagenum = 1;
                UpdatePagenum(this.pagenum);
                break;
            case R.id.layout_view14 /* 2131427420 */:
                DataCanbus.PROXY.cmd(99, new int[]{this.pagenum, 12}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
            case R.id.layout_text_view2 /* 2131427555 */:
                this.pagenum = 2;
                UpdatePagenum(this.pagenum);
                break;
            case R.id.layout_view15 /* 2131427424 */:
                DataCanbus.PROXY.cmd(99, new int[]{this.pagenum, 13}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
            case R.id.layout_text_view3 /* 2131427712 */:
                this.pagenum = 3;
                UpdatePagenum(this.pagenum);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
            case R.id.layout_text_view4 /* 2131427713 */:
                this.pagenum = 4;
                UpdatePagenum(this.pagenum);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
            case R.id.layout_text_view5 /* 2131427806 */:
                this.pagenum = 5;
                UpdatePagenum(this.pagenum);
                break;
            case R.id.btn_plus6 /* 2131427430 */:
            case R.id.layout_text_view6 /* 2131428015 */:
                this.pagenum = 6;
                UpdatePagenum(this.pagenum);
                break;
            case R.id.btn_plus7 /* 2131427431 */:
            case R.id.layout_text_view7 /* 2131428016 */:
                this.pagenum = 7;
                UpdatePagenum(this.pagenum);
                break;
            case R.id.btn_plus8 /* 2131427432 */:
                this.pagenum = 0;
                UpdatePagenum(this.pagenum);
                break;
            case R.id.btn_plus9 /* 2131427433 */:
                this.pagenum = 0;
                UpdatePagenum(this.pagenum);
                break;
            case R.id.btn_plus10 /* 2131427434 */:
                DataCanbus.PROXY.cmd(2, new int[]{1, 0, 1}, null, null);
                break;
            case R.id.btn_plus11 /* 2131427435 */:
                DataCanbus.PROXY.cmd(2, new int[]{1, 0, 2}, null, null);
                break;
            case R.id.btn_plus12 /* 2131427436 */:
                DataCanbus.PROXY.cmd(2, new int[]{1, 0, 3}, null, null);
                break;
            case R.id.btn_plus13 /* 2131427437 */:
                DataCanbus.PROXY.cmd(2, new int[]{1, 0, 4}, null, null);
                break;
            case R.id.btn_plus14 /* 2131427438 */:
                DataCanbus.PROXY.cmd(2, new int[]{2, 0, 1}, null, null);
                break;
            case R.id.btn_plus15 /* 2131427439 */:
                DataCanbus.PROXY.cmd(2, new int[]{2, 0, 2}, null, null);
                break;
            case R.id.btn_plus16 /* 2131427440 */:
                DataCanbus.PROXY.cmd(2, new int[]{2, 0, 3}, null, null);
                break;
            case R.id.btn_plus17 /* 2131427500 */:
                DataCanbus.PROXY.cmd(2, new int[]{2, 0, 4}, null, null);
                break;
            case R.id.btn_plus18 /* 2131427503 */:
                DataCanbus.PROXY.cmd(2, new int[]{3, 0, 1}, null, null);
                break;
            case R.id.btn_plus19 /* 2131427577 */:
                DataCanbus.PROXY.cmd(2, new int[]{3, 0, 2}, null, null);
                break;
            case R.id.btn_plus20 /* 2131427581 */:
                DataCanbus.PROXY.cmd(2, new int[]{3, 0, 3}, null, null);
                break;
            case R.id.btn_plus21 /* 2131427584 */:
                DataCanbus.PROXY.cmd(2, new int[]{3, 0, 4}, null, null);
                break;
            case R.id.btn_plus22 /* 2131427587 */:
                DataCanbus.PROXY.cmd(2, new int[]{4, 0, 1}, null, null);
                break;
            case R.id.btn_plus23 /* 2131427591 */:
                DataCanbus.PROXY.cmd(2, new int[]{4, 0, 2}, null, null);
                break;
            case R.id.btn_plus24 /* 2131427594 */:
                DataCanbus.PROXY.cmd(2, new int[]{4, 0, 3}, null, null);
                break;
            case R.id.btn_plus25 /* 2131427597 */:
                DataCanbus.PROXY.cmd(2, new int[]{4, 0, 4}, null, null);
                break;
            case R.id.btn_plus26 /* 2131427601 */:
                DataCanbus.PROXY.cmd(2, new int[]{5, 0, 1}, null, null);
                break;
            case R.id.btn_plus27 /* 2131427604 */:
                DataCanbus.PROXY.cmd(2, new int[]{5, 0, 2}, null, null);
                break;
            case R.id.btn_plus28 /* 2131427607 */:
                DataCanbus.PROXY.cmd(2, new int[]{5, 0, 3}, null, null);
                break;
            case R.id.btn_plus29 /* 2131427611 */:
                DataCanbus.PROXY.cmd(2, new int[]{5, 0, 4}, null, null);
                break;
            case R.id.btn_plus30 /* 2131427614 */:
                DataCanbus.PROXY.cmd(2, new int[]{6, 0, 1}, null, null);
                break;
            case R.id.layout_view16 /* 2131427717 */:
                DataCanbus.PROXY.cmd(99, new int[]{this.pagenum, 14}, null, null);
                break;
            case R.id.layout_view17 /* 2131427718 */:
                DataCanbus.PROXY.cmd(99, new int[]{this.pagenum, 15}, null, null);
                break;
            case R.id.btn_plus31 /* 2131427808 */:
                DataCanbus.PROXY.cmd(2, new int[]{6, 0, 2}, null, null);
                break;
            case R.id.btn_plus32 /* 2131427810 */:
                DataCanbus.PROXY.cmd(2, new int[]{6, 0, 3}, null, null);
                break;
            case R.id.btn_plus33 /* 2131427812 */:
                DataCanbus.PROXY.cmd(2, new int[]{6, 0, 4}, null, null);
                break;
        }
    }

    public void UpdatePagenum(int num) {
        switch (num) {
            case 1:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(8);
                ((TextView) findViewById(R.id.tv_text1)).setText("Output 1");
                break;
            case 2:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(8);
                ((TextView) findViewById(R.id.tv_text1)).setText("Output 2");
                break;
            case 3:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(8);
                ((TextView) findViewById(R.id.tv_text1)).setText("Output 3");
                break;
            case 4:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(8);
                ((TextView) findViewById(R.id.tv_text1)).setText("Output 4");
                break;
            case 5:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(8);
                ((TextView) findViewById(R.id.tv_text1)).setText("Output 5");
                break;
            case 6:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(8);
                ((TextView) findViewById(R.id.tv_text1)).setText("Output 6");
                break;
            case 7:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view19).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view19).setVisibility(8);
                break;
        }
        UpdateOutPutSel();
    }

    public void UpdateOutPutSel() {
        int value = 0;
        switch (this.pagenum) {
            case 1:
                value = DataCanbus.DATA[46];
                break;
            case 2:
                value = DataCanbus.DATA[47];
                break;
            case 3:
                value = DataCanbus.DATA[48];
                break;
            case 4:
                value = DataCanbus.DATA[49];
                break;
            case 5:
                value = DataCanbus.DATA[50];
                break;
            case 6:
                value = DataCanbus.DATA[51];
                break;
        }
        findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_ds_golf_out1_n);
        findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_ds_golf_out2_n);
        findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_ds_golf_out3_n);
        findViewById(R.id.layout_view6).setBackgroundResource(R.drawable.ic_ds_golf_out4_n);
        findViewById(R.id.layout_view7).setBackgroundResource(R.drawable.ic_ds_golf_out5_n);
        findViewById(R.id.layout_view8).setBackgroundResource(R.drawable.ic_ds_golf_out6_n);
        findViewById(R.id.layout_view9).setBackgroundResource(R.drawable.ic_ds_golf_out7_n);
        findViewById(R.id.layout_view10).setBackgroundResource(R.drawable.ic_ds_golf_out8_n);
        findViewById(R.id.layout_view11).setBackgroundResource(R.drawable.ic_ds_golf_out9_n);
        findViewById(R.id.layout_view12).setBackgroundResource(R.drawable.ic_ds_golf_out6_n);
        findViewById(R.id.layout_view13).setBackgroundResource(R.drawable.ic_ds_golf_out6_n);
        findViewById(R.id.layout_view14).setBackgroundResource(R.drawable.ic_ds_golf_out12_n);
        findViewById(R.id.layout_view15).setBackgroundResource(R.drawable.ic_ds_golf_out13_n);
        findViewById(R.id.layout_view16).setBackgroundResource(R.drawable.ic_ds_golf_out14_n);
        findViewById(R.id.layout_view17).setBackgroundResource(R.drawable.ic_ds_golf_out15_n);
        switch (value) {
            case 1:
                findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_ds_golf_out1_p);
                break;
            case 2:
                findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_ds_golf_out2_p);
                break;
            case 3:
                findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_ds_golf_out3_p);
                break;
            case 4:
                findViewById(R.id.layout_view6).setBackgroundResource(R.drawable.ic_ds_golf_out4_p);
                break;
            case 5:
                findViewById(R.id.layout_view7).setBackgroundResource(R.drawable.ic_ds_golf_out5_p);
                break;
            case 6:
                findViewById(R.id.layout_view8).setBackgroundResource(R.drawable.ic_ds_golf_out6_p);
                break;
            case 7:
                findViewById(R.id.layout_view9).setBackgroundResource(R.drawable.ic_ds_golf_out7_p);
                break;
            case 8:
                findViewById(R.id.layout_view10).setBackgroundResource(R.drawable.ic_ds_golf_out8_p);
                break;
            case 9:
                findViewById(R.id.layout_view11).setBackgroundResource(R.drawable.ic_ds_golf_out9_p);
                break;
            case 10:
                findViewById(R.id.layout_view12).setBackgroundResource(R.drawable.ic_ds_golf_out6_p);
                break;
            case 11:
                findViewById(R.id.layout_view13).setBackgroundResource(R.drawable.ic_ds_golf_out6_p);
                break;
            case 12:
                findViewById(R.id.layout_view14).setBackgroundResource(R.drawable.ic_ds_golf_out12_p);
                break;
            case 13:
                findViewById(R.id.layout_view15).setBackgroundResource(R.drawable.ic_ds_golf_out13_p);
                break;
            case 14:
                findViewById(R.id.layout_view16).setBackgroundResource(R.drawable.ic_ds_golf_out14_p);
                break;
            case 15:
                findViewById(R.id.layout_view17).setBackgroundResource(R.drawable.ic_ds_golf_out15_p);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.pagenum = 0;
        DataCanbus.PROXY.cmd(3, new int[]{58, 255}, null, null);
        addNotify();
        UpdatePagenum(this.pagenum);
        mIsFront = true;
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
    }
}
