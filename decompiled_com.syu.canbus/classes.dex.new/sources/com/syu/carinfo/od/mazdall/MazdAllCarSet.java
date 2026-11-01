package com.syu.carinfo.od.mazdall;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class MazdAllCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.mazdall.MazdAllCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 65:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 66:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_418_relock1);
                                break;
                            case 2:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_418_relock2);
                                break;
                            case 3:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_418_relock3);
                                break;
                            case 4:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_418_relock4);
                                break;
                            case 5:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_418_relock5);
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 67:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 68:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text3)).setText("60s");
                                break;
                            case 2:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text3)).setText("90s");
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text3)).setText("30s");
                                break;
                        }
                    }
                    break;
                case 69:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_418_unlock2);
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_418_unlock1);
                                break;
                        }
                    }
                    break;
                case 70:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 71:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 72:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 73:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text5)).setText("30min");
                                break;
                            case 2:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text5)).setText("60min");
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text5)).setText("10min");
                                break;
                        }
                    }
                    break;
                case 74:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text6)).setText("15s");
                                break;
                            case 2:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text6)).setText("30s");
                                break;
                            case 3:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text6)).setText("60s");
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text6)).setText("7.5s");
                                break;
                        }
                    }
                    break;
                case 75:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 76:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.klc_air_Manual);
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.klc_air_auto);
                                break;
                        }
                    }
                    break;
                case 77:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 78:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 79:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 80:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 81:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.wc_372_low);
                                break;
                            case 2:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.wc_372_high);
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 82:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.wc_372_low);
                                break;
                            case 2:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.wc_372_high);
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 83:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text10)).setText("30s");
                                break;
                            case 2:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text10)).setText("60s");
                                break;
                            case 3:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text10)).setText("90s");
                                break;
                            case 4:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text10)).setText("120s");
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 84:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_3);
                                break;
                            case 2:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_2);
                                break;
                            case 3:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_1);
                                break;
                            case 4:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_0);
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_4);
                                break;
                        }
                    }
                    break;
                case 85:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        if (value >= 13) {
                            ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text12)).setText("+" + (value - 13));
                        } else if (value < 13) {
                            ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text12)).setText("-" + (13 - value));
                        } else {
                            ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text13)).setText("0");
                        }
                    }
                    break;
                case 86:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text13)) != null) {
                        if (value > 20) {
                            ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text13)).setText("+" + (value - 20));
                        } else if (value < 20) {
                            ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text13)).setText("-" + (20 - value));
                        } else {
                            ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text13)).setText("0");
                        }
                    }
                    break;
                case 87:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text14)) != null) {
                        if (value > 2) {
                            ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text14)).setText("+" + (value - 2));
                        } else if (value < 2) {
                            ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text14)).setText("-" + (2 - value));
                        } else {
                            ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text14)).setText("0");
                        }
                    }
                    break;
                case 88:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 89:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text15)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text15)).setText(R.string.jeep_forwardcollisionwarn_1);
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text15)).setText(R.string.jeep_forwardcollisionwarn_0);
                                break;
                        }
                    }
                    break;
                case 90:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text16)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text16)).setText(R.string.wc_372_low);
                                break;
                            case 2:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text16)).setText(R.string.wc_372_high);
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text16)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 91:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 92:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text17)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text17)).setText(R.string.jeep_forwardcollisionwarn_1);
                                break;
                            case 2:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text17)).setText(R.string.jeep_lanesensewarn_1);
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text17)).setText(R.string.jeep_forwardcollisionwarn_0);
                                break;
                        }
                    }
                    break;
                case 93:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 94:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 95:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text18)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text18)).setText("30s");
                                break;
                            case 2:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text18)).setText("60s");
                                break;
                            case 3:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text18)).setText("90s");
                                break;
                            case 4:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text18)).setText("120s");
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text18)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 96:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 97:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 98:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text19)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text19)).setText(R.string.switch_on_time_late);
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text19)).setText(R.string.switch_on_time_early);
                                break;
                        }
                    }
                    break;
                case 99:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text20)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text20)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text20)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text20)).setText(R.string.klc_air_low);
                                break;
                        }
                    }
                    break;
                case 100:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
                case 101:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text21)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text21)).setText(R.string.wc_volume_of_beeps);
                                break;
                            case 2:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text21)).setText(R.string.wc_rumble_volume);
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text21)).setText(R.string.str_vibration_reminder);
                                break;
                        }
                    }
                    break;
                case 102:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text22)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text22)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text22)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text22)).setText(R.string.klc_air_low);
                                break;
                        }
                    }
                    break;
                case 103:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 104:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text23)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text23)).setText(R.string.str_298_visual_warning_);
                                break;
                            case 2:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text23)).setText(R.string.jeep_parksense_1);
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text23)).setText(R.string.str_298_17crv_display);
                                break;
                        }
                    }
                    break;
                case 105:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text24)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text24)).setText("+5km/h");
                                break;
                            case 2:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text24)).setText("+10km/h");
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text24)).setText("+0km/h");
                                break;
                        }
                    }
                    break;
                case 106:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext18), value == 1);
                    break;
                case 107:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext19), value == 1);
                    break;
                case 108:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text25)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text25)).setText(R.string.jeep_lanesensewarn_1);
                                break;
                            case 2:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text25)).setText(R.string.jeep_lanesensewarn_0);
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text25)).setText(R.string.jeep_lanesensewarn_2);
                                break;
                        }
                    }
                    break;
                case 109:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text26)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text26)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text26)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text26)).setText(R.string.klc_air_low);
                                break;
                        }
                    }
                    break;
                case 110:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text27)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text27)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text27)).setText(R.string.klc_air_low);
                                break;
                        }
                    }
                    break;
                case 111:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext20), value == 1);
                    break;
                case 112:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext21), value == 1);
                    break;
                case 113:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext22), value == 1);
                    break;
                case 114:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext23), value == 1);
                    break;
                case 115:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text28)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text28)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_4);
                                break;
                            case 2:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text28)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_2);
                                break;
                            case 3:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text28)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_0);
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text28)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 116:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text29)) != null) {
                        if (value > 3) {
                            ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text29)).setText("+" + (value - 3));
                        } else if (value < 3) {
                            ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text29)).setText("-" + (3 - value));
                        } else {
                            ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text29)).setText("0");
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_mzdall_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext13), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext14), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext15), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext16), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext17), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext18), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext19), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext20), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext21), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext22), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext23), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext24), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus13), this);
        setSelfClick((Button) findViewById(R.id.btn_plus13), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
        setSelfClick((Button) findViewById(R.id.btn_minus15), this);
        setSelfClick((Button) findViewById(R.id.btn_plus15), this);
        setSelfClick((Button) findViewById(R.id.btn_minus16), this);
        setSelfClick((Button) findViewById(R.id.btn_plus16), this);
        setSelfClick((Button) findViewById(R.id.btn_minus17), this);
        setSelfClick((Button) findViewById(R.id.btn_plus17), this);
        setSelfClick((Button) findViewById(R.id.btn_minus18), this);
        setSelfClick((Button) findViewById(R.id.btn_plus18), this);
        setSelfClick((Button) findViewById(R.id.btn_minus19), this);
        setSelfClick((Button) findViewById(R.id.btn_plus19), this);
        setSelfClick((Button) findViewById(R.id.btn_minus20), this);
        setSelfClick((Button) findViewById(R.id.btn_plus20), this);
        setSelfClick((Button) findViewById(R.id.btn_minus21), this);
        setSelfClick((Button) findViewById(R.id.btn_plus21), this);
        setSelfClick((Button) findViewById(R.id.btn_minus22), this);
        setSelfClick((Button) findViewById(R.id.btn_plus22), this);
        setSelfClick((Button) findViewById(R.id.btn_minus23), this);
        setSelfClick((Button) findViewById(R.id.btn_plus23), this);
        setSelfClick((Button) findViewById(R.id.btn_minus24), this);
        setSelfClick((Button) findViewById(R.id.btn_plus24), this);
        setSelfClick((Button) findViewById(R.id.btn_minus25), this);
        setSelfClick((Button) findViewById(R.id.btn_plus25), this);
        setSelfClick((Button) findViewById(R.id.btn_minus26), this);
        setSelfClick((Button) findViewById(R.id.btn_plus26), this);
        setSelfClick((Button) findViewById(R.id.btn_minus27), this);
        setSelfClick((Button) findViewById(R.id.btn_plus27), this);
        setSelfClick((Button) findViewById(R.id.btn_minus28), this);
        setSelfClick((Button) findViewById(R.id.btn_plus28), this);
        setSelfClick((Button) findViewById(R.id.btn_minus29), this);
        setSelfClick((Button) findViewById(R.id.btn_plus29), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[66] - 1;
                if (value < 0) {
                    value = 5;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[66] + 1;
                if (value2 > 5) {
                    value2 = 0;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[67] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(1, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[67] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(1, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[68] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(3, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[68] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(3, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[69] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(4, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[69] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(4, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[73] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(8, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[73] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(8, value10);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[74] - 1;
                if (value11 < 0) {
                    value11 = 3;
                }
                setCarInfo(9, value11);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[74] + 1;
                if (value12 > 3) {
                    value12 = 0;
                }
                setCarInfo(9, value12);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = DataCanbus.DATA[76] - 1;
                if (value13 < 0) {
                    value13 = 1;
                }
                setCarInfo(15, value13);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = DataCanbus.DATA[76] + 1;
                if (value14 > 1) {
                    value14 = 0;
                }
                setCarInfo(15, value14);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value15 = DataCanbus.DATA[81] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCarInfo(21, value15);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value16 = DataCanbus.DATA[81] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setCarInfo(21, value16);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value17 = DataCanbus.DATA[82] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                setCarInfo(11, value17);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value18 = DataCanbus.DATA[82] + 1;
                if (value18 > 2) {
                    value18 = 0;
                }
                setCarInfo(11, value18);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value19 = DataCanbus.DATA[83] - 1;
                if (value19 < 0) {
                    value19 = 4;
                }
                setCarInfo(12, value19);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value20 = DataCanbus.DATA[83] + 1;
                if (value20 > 4) {
                    value20 = 0;
                }
                setCarInfo(12, value20);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value21 = DataCanbus.DATA[84] - 1;
                if (value21 < 0) {
                    value21 = 4;
                }
                setCarInfo(13, value21);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value22 = DataCanbus.DATA[84] + 1;
                if (value22 > 4) {
                    value22 = 0;
                }
                setCarInfo(13, value22);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value23 = DataCanbus.DATA[85];
                if (value23 > 0) {
                    value23--;
                }
                setCarInfo(14, value23);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value24 = DataCanbus.DATA[85];
                if (value24 < 26) {
                    value24++;
                }
                setCarInfo(14, value24);
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int value25 = DataCanbus.DATA[86];
                if (value25 > 0) {
                    value25--;
                }
                setCarInfo(16, value25);
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int value26 = DataCanbus.DATA[86];
                if (value26 < 40) {
                    value26++;
                }
                setCarInfo(16, value26);
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int value27 = DataCanbus.DATA[87];
                if (value27 > 0) {
                    value27--;
                }
                setCarInfo(19, value27);
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int value28 = DataCanbus.DATA[87];
                if (value28 < 4) {
                    value28++;
                }
                setCarInfo(19, value28);
                break;
            case R.id.btn_minus15 /* 2131427498 */:
                int value29 = DataCanbus.DATA[89] - 1;
                if (value29 < 0) {
                    value29 = 1;
                }
                setCarInfo(26, value29);
                break;
            case R.id.btn_plus15 /* 2131427500 */:
                int value30 = DataCanbus.DATA[89] + 1;
                if (value30 > 1) {
                    value30 = 0;
                }
                setCarInfo(26, value30);
                break;
            case R.id.btn_minus16 /* 2131427501 */:
                int value31 = DataCanbus.DATA[90] - 1;
                if (value31 < 0) {
                    value31 = 2;
                }
                setCarInfo(27, value31);
                break;
            case R.id.btn_plus16 /* 2131427503 */:
                int value32 = DataCanbus.DATA[90] + 1;
                if (value32 > 2) {
                    value32 = 0;
                }
                setCarInfo(27, value32);
                break;
            case R.id.btn_minus17 /* 2131427504 */:
                int value33 = DataCanbus.DATA[92] - 1;
                if (value33 < 0) {
                    value33 = 2;
                }
                setCarInfo(29, value33);
                break;
            case R.id.btn_plus17 /* 2131427506 */:
                int value34 = DataCanbus.DATA[92] + 1;
                if (value34 > 2) {
                    value34 = 0;
                }
                setCarInfo(29, value34);
                break;
            case R.id.btn_minus18 /* 2131427507 */:
                int value35 = DataCanbus.DATA[95] - 1;
                if (value35 < 0) {
                    value35 = 4;
                }
                setCarInfo(33, value35);
                break;
            case R.id.btn_plus18 /* 2131427509 */:
                int value36 = DataCanbus.DATA[95] + 1;
                if (value36 > 4) {
                    value36 = 0;
                }
                setCarInfo(33, value36);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value37 = DataCanbus.DATA[65];
                if (value37 == 1) {
                    value37 = 0;
                } else if (value37 == 0) {
                    value37 = 1;
                }
                setCarInfo(0, value37);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value38 = DataCanbus.DATA[72];
                if (value38 == 1) {
                    value38 = 0;
                } else if (value38 == 0) {
                    value38 = 1;
                }
                setCarInfo(7, value38);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value39 = DataCanbus.DATA[75];
                if (value39 == 1) {
                    value39 = 0;
                } else if (value39 == 0) {
                    value39 = 1;
                }
                setCarInfo(10, value39);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value40 = DataCanbus.DATA[70];
                if (value40 == 1) {
                    value40 = 0;
                } else if (value40 == 0) {
                    value40 = 1;
                }
                setCarInfo(5, value40);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value41 = DataCanbus.DATA[71];
                if (value41 == 1) {
                    value41 = 0;
                } else if (value41 == 0) {
                    value41 = 1;
                }
                setCarInfo(6, value41);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int value42 = DataCanbus.DATA[77];
                if (value42 == 1) {
                    value42 = 0;
                } else if (value42 == 0) {
                    value42 = 1;
                }
                setCarInfo(17, value42);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int value43 = DataCanbus.DATA[78];
                if (value43 == 1) {
                    value43 = 0;
                } else if (value43 == 0) {
                    value43 = 1;
                }
                setCarInfo(18, value43);
                break;
            case R.id.btn_minus19 /* 2131427593 */:
                int value44 = DataCanbus.DATA[98] - 1;
                if (value44 < 0) {
                    value44 = 1;
                }
                setCarInfo(49, value44);
                break;
            case R.id.btn_plus19 /* 2131427595 */:
                int value45 = DataCanbus.DATA[98] + 1;
                if (value45 > 1) {
                    value45 = 0;
                }
                setCarInfo(49, value45);
                break;
            case R.id.btn_minus20 /* 2131427597 */:
                int value46 = DataCanbus.DATA[99] - 1;
                if (value46 < 0) {
                    value46 = 2;
                }
                setCarInfo(50, value46);
                break;
            case R.id.btn_plus20 /* 2131427599 */:
                int value47 = DataCanbus.DATA[99] + 1;
                if (value47 > 2) {
                    value47 = 0;
                }
                setCarInfo(50, value47);
                break;
            case R.id.btn_minus21 /* 2131427600 */:
                int value48 = DataCanbus.DATA[101] - 1;
                if (value48 < 0) {
                    value48 = 2;
                }
                setCarInfo(52, value48);
                break;
            case R.id.btn_plus21 /* 2131427602 */:
                int value49 = DataCanbus.DATA[101] + 1;
                if (value49 > 2) {
                    value49 = 0;
                }
                setCarInfo(52, value49);
                break;
            case R.id.btn_minus22 /* 2131427603 */:
                int value50 = DataCanbus.DATA[102] - 1;
                if (value50 < 0) {
                    value50 = 2;
                }
                setCarInfo(53, value50);
                break;
            case R.id.btn_plus22 /* 2131427605 */:
                int value51 = DataCanbus.DATA[102] + 1;
                if (value51 > 2) {
                    value51 = 0;
                }
                setCarInfo(53, value51);
                break;
            case R.id.btn_minus23 /* 2131427607 */:
                int value52 = DataCanbus.DATA[104] - 1;
                if (value52 < 0) {
                    value52 = 2;
                }
                setCarInfo(65, value52);
                break;
            case R.id.btn_plus23 /* 2131427609 */:
                int value53 = DataCanbus.DATA[104] + 1;
                if (value53 > 2) {
                    value53 = 0;
                }
                setCarInfo(65, value53);
                break;
            case R.id.btn_minus24 /* 2131427610 */:
                int value54 = DataCanbus.DATA[105] - 1;
                if (value54 < 0) {
                    value54 = 2;
                }
                setCarInfo(66, value54);
                break;
            case R.id.btn_plus24 /* 2131427612 */:
                int value55 = DataCanbus.DATA[105] + 1;
                if (value55 > 2) {
                    value55 = 0;
                }
                setCarInfo(66, value55);
                break;
            case R.id.btn_minus25 /* 2131427613 */:
                int value56 = DataCanbus.DATA[108] - 1;
                if (value56 < 0) {
                    value56 = 2;
                }
                setCarInfo(56, value56);
                break;
            case R.id.btn_plus25 /* 2131427615 */:
                int value57 = DataCanbus.DATA[108] + 1;
                if (value57 > 2) {
                    value57 = 0;
                }
                setCarInfo(56, value57);
                break;
            case R.id.btn_minus26 /* 2131427617 */:
                int value58 = DataCanbus.DATA[109] - 1;
                if (value58 < 0) {
                    value58 = 2;
                }
                setCarInfo(57, value58);
                break;
            case R.id.btn_plus26 /* 2131427619 */:
                int value59 = DataCanbus.DATA[109] + 1;
                if (value59 > 2) {
                    value59 = 0;
                }
                setCarInfo(57, value59);
                break;
            case R.id.btn_minus27 /* 2131427620 */:
                int value60 = DataCanbus.DATA[110] - 1;
                if (value60 < 0) {
                    value60 = 1;
                }
                setCarInfo(58, value60);
                break;
            case R.id.btn_plus27 /* 2131427622 */:
                int value61 = DataCanbus.DATA[110] + 1;
                if (value61 > 1) {
                    value61 = 0;
                }
                setCarInfo(58, value61);
                break;
            case R.id.btn_minus28 /* 2131427623 */:
                int value62 = DataCanbus.DATA[115] - 1;
                if (value62 < 0) {
                    value62 = 3;
                }
                setCarInfo(35, value62);
                break;
            case R.id.btn_plus28 /* 2131427625 */:
                int value63 = DataCanbus.DATA[115] + 1;
                if (value63 > 3) {
                    value63 = 0;
                }
                setCarInfo(35, value63);
                break;
            case R.id.btn_minus29 /* 2131427627 */:
                int value64 = DataCanbus.DATA[116];
                if (value64 > 0) {
                    value64--;
                }
                setCarInfo(40, value64);
                break;
            case R.id.btn_plus29 /* 2131427629 */:
                int value65 = DataCanbus.DATA[116];
                if (value65 < 6) {
                    value65++;
                }
                setCarInfo(40, value65);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int value66 = DataCanbus.DATA[79];
                if (value66 == 1) {
                    value66 = 0;
                } else if (value66 == 0) {
                    value66 = 1;
                }
                setCarInfo(20, value66);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                int value67 = DataCanbus.DATA[80];
                if (value67 == 1) {
                    value67 = 0;
                } else if (value67 == 0) {
                    value67 = 1;
                }
                setCarInfo(22, value67);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                int value68 = DataCanbus.DATA[88];
                if (value68 == 1) {
                    value68 = 0;
                } else if (value68 == 0) {
                    value68 = 1;
                }
                setCarInfo(25, value68);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                int value69 = DataCanbus.DATA[91];
                if (value69 == 1) {
                    value69 = 0;
                } else if (value69 == 0) {
                    value69 = 1;
                }
                setCarInfo(28, value69);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                int value70 = DataCanbus.DATA[93];
                if (value70 == 1) {
                    value70 = 0;
                } else if (value70 == 0) {
                    value70 = 1;
                }
                setCarInfo(30, value70);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                int value71 = DataCanbus.DATA[94];
                if (value71 == 1) {
                    value71 = 0;
                } else if (value71 == 0) {
                    value71 = 1;
                }
                setCarInfo(32, value71);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                int value72 = DataCanbus.DATA[96];
                if (value72 == 1) {
                    value72 = 0;
                } else if (value72 == 0) {
                    value72 = 1;
                }
                setCarInfo(34, value72);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                int value73 = DataCanbus.DATA[97];
                if (value73 == 1) {
                    value73 = 0;
                } else if (value73 == 0) {
                    value73 = 1;
                }
                setCarInfo(48, value73);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                int value74 = DataCanbus.DATA[100];
                if (value74 == 1) {
                    value74 = 0;
                } else if (value74 == 0) {
                    value74 = 1;
                }
                setCarInfo(51, value74);
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                int value75 = DataCanbus.DATA[103];
                if (value75 == 1) {
                    value75 = 0;
                } else if (value75 == 0) {
                    value75 = 1;
                }
                setCarInfo(64, value75);
                break;
            case R.id.ctv_checkedtext18 /* 2131427764 */:
                int value76 = DataCanbus.DATA[106];
                if (value76 == 1) {
                    value76 = 0;
                } else if (value76 == 0) {
                    value76 = 1;
                }
                setCarInfo(80, value76);
                break;
            case R.id.ctv_checkedtext19 /* 2131427766 */:
                int value77 = DataCanbus.DATA[107];
                if (value77 == 1) {
                    value77 = 0;
                } else if (value77 == 0) {
                    value77 = 1;
                }
                setCarInfo(81, value77);
                break;
            case R.id.ctv_checkedtext20 /* 2131427768 */:
                int value78 = DataCanbus.DATA[111];
                if (value78 == 1) {
                    value78 = 0;
                } else if (value78 == 0) {
                    value78 = 1;
                }
                setCarInfo(72, value78);
                break;
            case R.id.ctv_checkedtext21 /* 2131427770 */:
                int value79 = DataCanbus.DATA[112];
                if (value79 == 1) {
                    value79 = 0;
                } else if (value79 == 0) {
                    value79 = 1;
                }
                setCarInfo(73, value79);
                break;
            case R.id.ctv_checkedtext22 /* 2131427772 */:
                int value80 = DataCanbus.DATA[113];
                if (value80 == 1) {
                    value80 = 0;
                } else if (value80 == 0) {
                    value80 = 1;
                }
                setCarInfo(74, value80);
                break;
            case R.id.ctv_checkedtext23 /* 2131427775 */:
                int value81 = DataCanbus.DATA[114];
                if (value81 == 1) {
                    value81 = 0;
                } else if (value81 == 0) {
                    value81 = 1;
                }
                setCarInfo(75, value81);
                break;
            case R.id.ctv_checkedtext24 /* 2131427780 */:
                dialog(R.string.all_settings, 24);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{9, 0}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{13, 0}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{14, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[81].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[82].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[83].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[84].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[85].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[83].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[84].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[85].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.od.mazdall.MazdAllCarSet.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.od.mazdall.MazdAllCarSet.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.od.mazdall.MazdAllCarSet.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
