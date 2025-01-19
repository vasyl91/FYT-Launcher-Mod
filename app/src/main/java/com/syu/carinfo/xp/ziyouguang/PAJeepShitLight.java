package com.syu.carinfo.xp.ziyouguang;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class PAJeepShitLight extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 335:
                    if (value == 1) {
                        PAJeepShitLight.this.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                        ((Button) PAJeepShitLight.this.findViewById(R.id.btn_plus6)).setText(R.string.str_deactivate_shift_light);
                        ((Button) PAJeepShitLight.this.findViewById(R.id.btn_plus6)).setTextColor(Color.parseColor("#666666"));
                        ((TextView) PAJeepShitLight.this.findViewById(R.id.tv_text6)).setText(R.string.str_activate);
                        break;
                    } else {
                        PAJeepShitLight.this.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                        ((Button) PAJeepShitLight.this.findViewById(R.id.btn_plus6)).setText(R.string.str_activate_shift_light);
                        ((Button) PAJeepShitLight.this.findViewById(R.id.btn_plus6)).setTextColor(Color.parseColor("#ffffff"));
                        ((TextView) PAJeepShitLight.this.findViewById(R.id.tv_text6)).setText(R.string.str_inactive);
                        break;
                    }
                case 336:
                    if (((TextView) PAJeepShitLight.this.findViewById(R.id.tv_text1)) != null) {
                        if (value == 255) {
                            ((TextView) PAJeepShitLight.this.findViewById(R.id.tv_text1)).setText("----");
                            ((ProgressBar) PAJeepShitLight.this.findViewById(R.id.pa_jeep_seekbar1)).setProgress(0);
                            ((ProgressBar) PAJeepShitLight.this.findViewById(R.id.pa_jeep_seekbar1)).invalidate();
                            break;
                        } else {
                            int temp = value * 50;
                            ((TextView) PAJeepShitLight.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(temp)).toString());
                            ((ProgressBar) PAJeepShitLight.this.findViewById(R.id.pa_jeep_seekbar1)).setProgress(value);
                            ((ProgressBar) PAJeepShitLight.this.findViewById(R.id.pa_jeep_seekbar1)).invalidate();
                            break;
                        }
                    }
                    break;
                case 337:
                    if (((TextView) PAJeepShitLight.this.findViewById(R.id.tv_text2)) != null) {
                        if (value == 255) {
                            ((TextView) PAJeepShitLight.this.findViewById(R.id.tv_text2)).setText("----");
                            ((ProgressBar) PAJeepShitLight.this.findViewById(R.id.pa_jeep_seekbar2)).setProgress(0);
                            ((ProgressBar) PAJeepShitLight.this.findViewById(R.id.pa_jeep_seekbar2)).invalidate();
                            break;
                        } else {
                            int temp2 = value * 50;
                            ((TextView) PAJeepShitLight.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(temp2)).toString());
                            ((ProgressBar) PAJeepShitLight.this.findViewById(R.id.pa_jeep_seekbar2)).setProgress(value);
                            ((ProgressBar) PAJeepShitLight.this.findViewById(R.id.pa_jeep_seekbar2)).invalidate();
                            break;
                        }
                    }
                    break;
                case 338:
                    if (((TextView) PAJeepShitLight.this.findViewById(R.id.tv_text3)) != null) {
                        if (value == 255) {
                            ((TextView) PAJeepShitLight.this.findViewById(R.id.tv_text3)).setText("----");
                            ((ProgressBar) PAJeepShitLight.this.findViewById(R.id.pa_jeep_seekbar3)).setProgress(0);
                            ((ProgressBar) PAJeepShitLight.this.findViewById(R.id.pa_jeep_seekbar3)).invalidate();
                            break;
                        } else {
                            int temp3 = value * 50;
                            ((TextView) PAJeepShitLight.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(temp3)).toString());
                            ((ProgressBar) PAJeepShitLight.this.findViewById(R.id.pa_jeep_seekbar3)).setProgress(value);
                            ((ProgressBar) PAJeepShitLight.this.findViewById(R.id.pa_jeep_seekbar3)).invalidate();
                            break;
                        }
                    }
                    break;
                case 339:
                    if (((TextView) PAJeepShitLight.this.findViewById(R.id.tv_text4)) != null) {
                        if (value == 255) {
                            ((TextView) PAJeepShitLight.this.findViewById(R.id.tv_text4)).setText("----");
                            ((ProgressBar) PAJeepShitLight.this.findViewById(R.id.pa_jeep_seekbar4)).setProgress(0);
                            ((ProgressBar) PAJeepShitLight.this.findViewById(R.id.pa_jeep_seekbar4)).invalidate();
                            break;
                        } else {
                            int temp4 = value * 50;
                            ((TextView) PAJeepShitLight.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(temp4)).toString());
                            ((ProgressBar) PAJeepShitLight.this.findViewById(R.id.pa_jeep_seekbar4)).setProgress(value);
                            ((ProgressBar) PAJeepShitLight.this.findViewById(R.id.pa_jeep_seekbar4)).invalidate();
                            break;
                        }
                    }
                    break;
                case 340:
                    if (((TextView) PAJeepShitLight.this.findViewById(R.id.tv_text5)) != null) {
                        if (value == 255) {
                            ((TextView) PAJeepShitLight.this.findViewById(R.id.tv_text5)).setText("----");
                            ((ProgressBar) PAJeepShitLight.this.findViewById(R.id.pa_jeep_seekbar5)).setProgress(0);
                            ((ProgressBar) PAJeepShitLight.this.findViewById(R.id.pa_jeep_seekbar5)).invalidate();
                            break;
                        } else {
                            int temp5 = value * 50;
                            ((TextView) PAJeepShitLight.this.findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(temp5)).toString());
                            ((ProgressBar) PAJeepShitLight.this.findViewById(R.id.pa_jeep_seekbar5)).setProgress(value);
                            ((ProgressBar) PAJeepShitLight.this.findViewById(R.id.pa_jeep_seekbar5)).invalidate();
                            break;
                        }
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0374_pa_jeep_shitlight);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(15, new int[]{3, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(15, new int[]{3}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(15, new int[]{4, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(15, new int[]{4}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(15, new int[]{5, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(15, new int[]{5}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(15, new int[]{6, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(15, new int[]{6}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(15, new int[]{7, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(15, new int[]{7}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[335];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(15, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(15, new int[]{1, 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(15, new int[]{2}, null, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(4, new int[]{88}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[335].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[336].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[337].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[338].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[339].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[340].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[335].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[336].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[337].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[338].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[339].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[340].removeNotify(this.mNotifyCanbus);
    }
}
