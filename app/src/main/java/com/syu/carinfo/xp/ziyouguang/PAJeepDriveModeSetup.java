package com.syu.carinfo.xp.ziyouguang;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PAJeepDriveModeSetup extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveModeSetup.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 315:
                    switch (value) {
                        case 1:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.tv_text1)).setText("Sport Setup");
                            break;
                        case 2:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.tv_text1)).setText("Tow Setup");
                            break;
                        case 3:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.tv_text1)).setText("Snow Setup");
                            break;
                        case 4:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.tv_text1)).setText("Auto Setup");
                            break;
                        case 5:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.tv_text1)).setText("Custom Setup");
                            break;
                        case 6:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.tv_text1)).setText("Mud/Sand Setup");
                            break;
                        case 7:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.tv_text1)).setText("Rock Setup");
                            break;
                        case 8:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.tv_text1)).setText("Baja Setup");
                            break;
                        case 9:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.tv_text1)).setText("Track Setup");
                            break;
                    }
                case 316:
                    PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                    PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                    PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                    PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                    PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus24).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                    ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus4)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus24)).setTextColor(Color.parseColor("#ffffff"));
                    switch (value) {
                        case 1:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#666666"));
                            PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p4);
                            break;
                        case 2:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus24)).setTextColor(Color.parseColor("#666666"));
                            PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus24).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p4);
                            break;
                        case 9:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#666666"));
                            PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p2);
                            break;
                        case 11:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#666666"));
                            PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p5);
                            break;
                        default:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus4)).setTextColor(Color.parseColor("#666666"));
                            PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p6);
                            break;
                    }
                case 317:
                    PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus13).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                    PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus14).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                    ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus13)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus14)).setTextColor(Color.parseColor("#ffffff"));
                    switch (value) {
                        case 1:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus13)).setTextColor(Color.parseColor("#666666"));
                            PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus13).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p2);
                            break;
                        default:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus14)).setTextColor(Color.parseColor("#666666"));
                            PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus14).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p6);
                            break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D57_D1_B30 /* 318 */:
                    PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                    PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                    PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus7).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                    PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                    ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus5)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus6)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus7)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus8)).setTextColor(Color.parseColor("#ffffff"));
                    switch (value) {
                        case 1:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus5)).setTextColor(Color.parseColor("#666666"));
                            PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p2);
                            break;
                        case 2:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus6)).setTextColor(Color.parseColor("#666666"));
                            PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p4);
                            break;
                        case 3:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus7)).setTextColor(Color.parseColor("#666666"));
                            PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus7).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p5);
                            break;
                        case 4:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus8)).setTextColor(Color.parseColor("#666666"));
                            PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p6);
                            break;
                    }
                case 319:
                    PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus9).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                    PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus10).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                    PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus11).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                    PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus12).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                    PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus21).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                    PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus25).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                    ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus9)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus10)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus11)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus12)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus21)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus25)).setTextColor(Color.parseColor("#ffffff"));
                    switch (value) {
                        case 1:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus9)).setTextColor(Color.parseColor("#666666"));
                            PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus9).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p2);
                            break;
                        case 2:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus10)).setTextColor(Color.parseColor("#666666"));
                            PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus10).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p4);
                            break;
                        case 3:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus11)).setTextColor(Color.parseColor("#666666"));
                            PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus11).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p5);
                            break;
                        case 4:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus12)).setTextColor(Color.parseColor("#666666"));
                            PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus12).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p6);
                            break;
                        case 5:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus21)).setTextColor(Color.parseColor("#666666"));
                            PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus21).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p3);
                            break;
                        case 6:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus25)).setTextColor(Color.parseColor("#666666"));
                            PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus25).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p1);
                            break;
                    }
                case 320:
                    PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus15).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                    PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus16).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                    PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus17).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                    PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus22).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                    ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus15)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus16)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus17)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus22)).setTextColor(Color.parseColor("#ffffff"));
                    switch (value) {
                        case 1:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus15)).setTextColor(Color.parseColor("#666666"));
                            PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus15).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p2);
                            break;
                        case 2:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus16)).setTextColor(Color.parseColor("#666666"));
                            PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus16).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p4);
                            break;
                        case 3:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus17)).setTextColor(Color.parseColor("#666666"));
                            PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus17).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p5);
                            break;
                        case 4:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus22)).setTextColor(Color.parseColor("#666666"));
                            PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus22).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p1);
                            break;
                    }
                case 321:
                    PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus18).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                    PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus19).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                    PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus20).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                    PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus23).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button);
                    ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus18)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus19)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus20)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus23)).setTextColor(Color.parseColor("#ffffff"));
                    switch (value) {
                        case 1:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus18)).setTextColor(Color.parseColor("#666666"));
                            PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus18).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p2);
                            break;
                        case 2:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus19)).setTextColor(Color.parseColor("#666666"));
                            PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus19).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p4);
                            break;
                        case 3:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus20)).setTextColor(Color.parseColor("#666666"));
                            PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus20).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p5);
                            break;
                        case 4:
                            ((TextView) PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus23)).setTextColor(Color.parseColor("#666666"));
                            PAJeepDriveModeSetup.this.findViewById(R.id.btn_plus23).setBackgroundResource(R.drawable.ic_pa_jeep_mode_setup_button_p3);
                            break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_pa_jeep_drive_mode_setup);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveModeSetup.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{2, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveModeSetup.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{2, 2}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveModeSetup.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{2, 3}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveModeSetup.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{2, 4}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus24)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveModeSetup.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{2, 5}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveModeSetup.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{4, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveModeSetup.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{4, 2}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveModeSetup.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{4, 3}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveModeSetup.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{4, 4}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveModeSetup.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{5, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveModeSetup.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{5, 2}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveModeSetup.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{5, 3}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus12)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveModeSetup.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{5, 4}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus21)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveModeSetup.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{5, 5}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus25)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveModeSetup.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{5, 6}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus13)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveModeSetup.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{3, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus14)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveModeSetup.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{3}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus15)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveModeSetup.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{6, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus16)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveModeSetup.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{6, 2}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus17)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveModeSetup.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{6, 3}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus22)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveModeSetup.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{6, 4}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus18)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveModeSetup.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{7, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus19)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveModeSetup.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{7, 2}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus20)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveModeSetup.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{7, 3}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus23)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveModeSetup.26
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{7, 4}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(4, new int[]{87}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[315].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[316].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[317].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[318].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[319].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[320].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[321].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[322].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[315].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[316].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[317].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[318].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[319].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[320].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[321].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[322].removeNotify(this.mNotifyCanbus);
    }
}
