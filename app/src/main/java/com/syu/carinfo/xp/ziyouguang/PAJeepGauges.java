package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class PAJeepGauges extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 234:
                    if (((TextView) PAJeepGauges.this.findViewById(R.id.tv_text1)) != null) {
                        int temp = (value & 32767) - 40;
                        if (((value >> 15) & 1) == 1) {
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text1)).setText(String.valueOf(temp) + "℉");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text6)).setText("0℉");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text7)).setText("450℉");
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar1)).setProgress(value & 32767);
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar1)).invalidate();
                            break;
                        } else {
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text1)).setText(String.valueOf(temp) + "℃");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text6)).setText("0℃");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text7)).setText("450℃");
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar1)).setProgress(value & 32767);
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar1)).invalidate();
                            break;
                        }
                    }
                    break;
                case 235:
                    if (((TextView) PAJeepGauges.this.findViewById(R.id.tv_text2)) != null) {
                        int temp2 = (value & 32767) - 40;
                        if (((value >> 15) & 1) == 1) {
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text2)).setText(String.valueOf(temp2) + "℉");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text8)).setText("0℉");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text9)).setText("450℉");
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar2)).setProgress(value & 32767);
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar2)).invalidate();
                            break;
                        } else {
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text2)).setText(String.valueOf(temp2) + "℃");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text8)).setText("0℃");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text9)).setText("450℃");
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar2)).setProgress(value & 32767);
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar2)).invalidate();
                            break;
                        }
                    }
                    break;
                case 236:
                    if (((TextView) PAJeepGauges.this.findViewById(R.id.tv_text3)) != null) {
                        int temp3 = (value & 32767) - 40;
                        if (((value >> 15) & 1) == 1) {
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text3)).setText(String.valueOf(temp3) + "℉");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text10)).setText("0℉");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text11)).setText("450℉");
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar3)).setProgress(value & 32767);
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar3)).invalidate();
                            break;
                        } else {
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text3)).setText(String.valueOf(temp3) + "℃");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text10)).setText("0℃");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text11)).setText("450℃");
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar3)).setProgress(value & 32767);
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar3)).invalidate();
                            break;
                        }
                    }
                    break;
                case 237:
                    if (((TextView) PAJeepGauges.this.findViewById(R.id.tv_text4)) != null) {
                        int unit = (value >> 14) & 3;
                        int temp4 = value & 16383;
                        if (unit == 1) {
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text4)).setText(String.valueOf(temp4 / 10.0f) + "Kpa");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text12)).setText("0Kpa");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text13)).setText("150Kpa");
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar4)).setMax(1500);
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar4)).setProgress(temp4);
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar4)).invalidate();
                            break;
                        } else if (unit == 2) {
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text4)).setText(String.valueOf(temp4 / 10.0f) + "bar");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text12)).setText("0bar");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text13)).setText("15bar");
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar4)).setMax(150);
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar4)).setProgress(temp4);
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar4)).invalidate();
                            break;
                        } else {
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text4)).setText(String.valueOf(temp4 / 10.0f) + "psi");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text12)).setText("0psi");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text13)).setText("80psi");
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar4)).setMax(800);
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar4)).setProgress(temp4);
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar4)).invalidate();
                            break;
                        }
                    }
                    break;
                case 238:
                    if (((TextView) PAJeepGauges.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10.0f) + "V");
                        ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text14)).setText("0V");
                        ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text15)).setText("28V");
                        ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar5)).setMax(280);
                        ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar5)).setProgress(value);
                        ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar5)).invalidate();
                        break;
                    }
                case 301:
                    if (((TextView) PAJeepGauges.this.findViewById(R.id.tv_text16)) != null) {
                        int temp5 = (value & 32767) - 40;
                        if (((value >> 15) & 1) == 1) {
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text16)).setText(String.valueOf(temp5) + "℉");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text17)).setText("0℉");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text18)).setText("450℉");
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar6)).setProgress(value & 32767);
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar6)).invalidate();
                            break;
                        } else {
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text16)).setText(String.valueOf(temp5) + "℃");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text17)).setText("0℃");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text18)).setText("450℃");
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar6)).setProgress(value & 32767);
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar6)).invalidate();
                            break;
                        }
                    }
                    break;
                case 372:
                    if (((TextView) PAJeepGauges.this.findViewById(R.id.tv_text19)) != null) {
                        int unit2 = (value >> 14) & 3;
                        int temp6 = (value & 16383) - 2000;
                        if (unit2 == 1) {
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text19)).setText(String.valueOf(temp6 / 10.0f) + "Kpa");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text20)).setText("-140");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text21)).setText("200");
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar7)).setMax(3400);
                            if (temp6 > -1400) {
                                ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar7)).setProgress(temp6 + 1400);
                            } else {
                                ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar7)).setProgress(0);
                            }
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar7)).invalidate();
                            break;
                        } else if (unit2 == 2) {
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text19)).setText(String.valueOf(temp6 / 10.0f) + "bar");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text20)).setText("-1.4");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text21)).setText("2.0");
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar7)).setMax(34);
                            if (temp6 > -14) {
                                ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar7)).setProgress(temp6 + 14);
                            } else {
                                ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar7)).setProgress(0);
                            }
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar7)).invalidate();
                            break;
                        } else {
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text19)).setText(String.valueOf(temp6 / 10.0f) + "inhg");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text20)).setText("-20");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text21)).setText("30");
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar7)).setMax(500);
                            if (temp6 > -200) {
                                ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar7)).setProgress(temp6 + 200);
                            } else {
                                ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar7)).setProgress(0);
                            }
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar7)).invalidate();
                            break;
                        }
                    }
                    break;
                case 373:
                    if (((TextView) PAJeepGauges.this.findViewById(R.id.tv_text22)) != null) {
                        int temp7 = (value & 32767) - 40;
                        if (((value >> 15) & 1) == 1) {
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text22)).setText(String.valueOf(temp7) + "℉");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text23)).setText("-40℉");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text24)).setText("450℉");
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar8)).setProgress(value & 32767);
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar8)).invalidate();
                            break;
                        } else {
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text22)).setText(String.valueOf(temp7) + "℃");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text23)).setText("-40℃");
                            ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text24)).setText("450℃");
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar8)).setProgress(value & 32767);
                            ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar8)).invalidate();
                            break;
                        }
                    }
                    break;
                case 374:
                    if (((TextView) PAJeepGauges.this.findViewById(R.id.tv_text25)) != null) {
                        ((TextView) PAJeepGauges.this.findViewById(R.id.tv_text25)).setText(new StringBuilder(String.valueOf(value * 0.1f)).toString());
                        ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar9)).setProgress(value);
                        ((ProgressBar) PAJeepGauges.this.findViewById(R.id.pa_jeep_seekbar9)).invalidate();
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0374_pa_jeep_gauges);
        init();
    }

    @Override
    public void init() {
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(4, new int[]{82}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[234].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[235].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[236].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[237].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[238].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[301].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[372].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[373].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[374].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[395].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[234].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[235].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[236].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[237].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[238].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[301].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[372].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[373].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[374].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[395].removeNotify(this.mNotifyCanbus);
    }
}
