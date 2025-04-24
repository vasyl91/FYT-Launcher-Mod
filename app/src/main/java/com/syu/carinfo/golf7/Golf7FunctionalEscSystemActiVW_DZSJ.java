package com.syu.carinfo.golf7;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7FunctionalEscSystemActiVW_DZSJ extends BaseActivity {
    public static Golf7FunctionalEscSystemActiVW_DZSJ mInstance;
    public static boolean mIsFront = false;
    private int DriveMode = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode] & 255;
            Golf7FunctionalEscSystemActiVW_DZSJ.this.DriveMode = 0;
            switch (updateCode) {
                case 190:
                    ((Button) Golf7FunctionalEscSystemActiVW_DZSJ.this.findViewById(R.id.glf7_btn_esc_system_ss)).setBackgroundResource(value == 1 ? R.drawable.ic_esc_ss_p : R.drawable.ic_esc_ss);
                    break;
                case 191:
                    ((Button) Golf7FunctionalEscSystemActiVW_DZSJ.this.findViewById(R.id.glf7_btn_esc_system_bz)).setBackgroundResource(value == 1 ? R.drawable.ic_esc_bz_p : R.drawable.ic_esc_bz);
                    break;
                case 192:
                    ((Button) Golf7FunctionalEscSystemActiVW_DZSJ.this.findViewById(R.id.glf7_btn_esc_system_yd)).setBackgroundResource(value == 1 ? R.drawable.ic_esc_yd_p : R.drawable.ic_esc_yd);
                    break;
                case 193:
                    ((Button) Golf7FunctionalEscSystemActiVW_DZSJ.this.findViewById(R.id.glf7_btn_esc_system_jj)).setBackgroundResource(value == 1 ? R.drawable.ic_esc_jj_p : R.drawable.ic_esc_jj);
                    break;
                case 194:
                    ((Button) Golf7FunctionalEscSystemActiVW_DZSJ.this.findViewById(R.id.glf7_btn_esc_system_diy)).setBackgroundResource(value == 1 ? R.drawable.ic_esc_diy_p : R.drawable.ic_esc_diy);
                    if (((Button) Golf7FunctionalEscSystemActiVW_DZSJ.this.findViewById(R.id.glf7_btn_esc_system_xd_set)) != null && value == 1) {
                        Golf7FunctionalEscSystemActiVW_DZSJ.this.DriveMode = 1;
                        break;
                    }
                case 246:
                    ((Button) Golf7FunctionalEscSystemActiVW_DZSJ.this.findViewById(R.id.glf7_btn_esc_system_xd)).setBackgroundResource(value == 1 ? R.drawable.ic_esc_xd_p : R.drawable.ic_esc_xd);
                    break;
                case 247:
                    ((Button) Golf7FunctionalEscSystemActiVW_DZSJ.this.findViewById(R.id.glf7_btn_esc_system_yy)).setBackgroundResource(value == 1 ? R.drawable.ic_esc_yy_p : R.drawable.ic_esc_yy);
                    if (((Button) Golf7FunctionalEscSystemActiVW_DZSJ.this.findViewById(R.id.glf7_btn_esc_system_xd_set)) != null && value == 1) {
                        Golf7FunctionalEscSystemActiVW_DZSJ.this.DriveMode = 2;
                        break;
                    }
            }
            Golf7FunctionalEscSystemActiVW_DZSJ.this.setViewVisible((Button) Golf7FunctionalEscSystemActiVW_DZSJ.this.findViewById(R.id.glf7_btn_esc_system_xd_set), Golf7FunctionalEscSystemActiVW_DZSJ.this.DriveMode != 0);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_functional_state_esc_system_od);
        init();
        mInstance = this;
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.glf7_btn_esc_system_jj)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{4}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_esc_system_bz)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{2}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_esc_system_yd)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{3}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_esc_system_ss)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{1}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_esc_system_diy)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{5}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_esc_system_yy)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{8}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_esc_system_xd)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{6}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_esc_system_xd_set)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    if (Golf7FunctionalEscSystemActiVW_DZSJ.this.DriveMode != 2) {
                        if (Golf7FunctionalEscSystemActiVW_DZSJ.this.DriveMode == 1) {
                            intent.setClass(Golf7FunctionalEscSystemActiVW_DZSJ.this, Golf7FunctionalDrivingInfo2Acti.class);
                        }
                    } else {
                        intent.setClass(Golf7FunctionalEscSystemActiVW_DZSJ.this, Golf7Functional_OffRoadCustom_Wc_Acti.class);
                    }
                    Golf7FunctionalEscSystemActiVW_DZSJ.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (DataCanbus.DATA[1000] != 393233 || DataCanbus.DATA[1000] == 458769) {
            setViewVisible(findViewById(R.id.view_esc_system_xd), false);
            setViewVisible(findViewById(R.id.view_esc_system_yy), false);
        } else {
            setViewVisible(findViewById(R.id.view_esc_system_xd), true);
            setViewVisible(findViewById(R.id.view_esc_system_yy), true);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[246].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[247].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[248].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[246].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[247].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[248].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setFlags(268435456);
            intent.addCategory("android.intent.category.HOME");
            startActivity(intent);
        }
        return true;
    }
}
