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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text1)).setText("锁定：行车时  解锁：进入驻车");
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
                            break;
                        } else if (value < 13) {
                            ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text12)).setText("-" + (13 - value));
                            break;
                        } else {
                            ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text13)).setText("0");
                            break;
                        }
                    }
                    break;
                case 86:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text13)) != null) {
                        if (value > 20) {
                            ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text13)).setText("+" + (value - 20));
                            break;
                        } else if (value < 20) {
                            ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text13)).setText("-" + (20 - value));
                            break;
                        } else {
                            ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text13)).setText("0");
                            break;
                        }
                    }
                    break;
                case 87:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text14)) != null) {
                        if (value > 2) {
                            ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text14)).setText("+" + (value - 2));
                            break;
                        } else if (value < 2) {
                            ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text14)).setText("-" + (2 - value));
                            break;
                        } else {
                            ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text14)).setText("0");
                            break;
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
                case 110:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 111:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 112:
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
                case 113:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 114:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 115:
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
                case 116:
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
                case 117:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
                case 118:
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
                case 119:
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
                case 120:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 121:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text23)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text23)).setText(R.string.str_298_visual_warning_);
                                break;
                            case 2:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text23)).setText("音讯与视觉");
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text23)).setText("显示");
                                break;
                        }
                    }
                    break;
                case 122:
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
                case 123:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext18), value == 1);
                    break;
                case 124:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext19), value == 1);
                    break;
                case 125:
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
                case 126:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text26)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text26)).setText(R.string.distance_medium);
                                break;
                            case 2:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text26)).setText("经常");
                                break;
                            default:
                                ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text26)).setText("很少");
                                break;
                        }
                    }
                    break;
                case 127:
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
                case 128:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext20), value == 1);
                    break;
                case 129:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext21), value == 1);
                    break;
                case 130:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext22), value == 1);
                    break;
                case 131:
                    MazdAllCarSet.this.setCheck((CheckedTextView) MazdAllCarSet.this.findViewById(R.id.ctv_checkedtext23), value == 1);
                    break;
                case 132:
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
                case 133:
                    if (((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text29)) != null) {
                        if (value > 3) {
                            ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text29)).setText("+" + (value - 3));
                            break;
                        } else if (value < 3) {
                            ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text29)).setText("-" + (3 - value));
                            break;
                        } else {
                            ((TextView) MazdAllCarSet.this.findViewById(R.id.tv_text29)).setText("0");
                            break;
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
            case R.id.btn_minus13 /* 2131427468 */:
                int value = DataCanbus.DATA[86];
                if (value > 0) {
                    value--;
                }
                setCarInfo(16, value);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value2 = DataCanbus.DATA[86];
                if (value2 < 40) {
                    value2++;
                }
                setCarInfo(16, value2);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int value3 = DataCanbus.DATA[87];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(19, value3);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int value4 = DataCanbus.DATA[87];
                if (value4 < 4) {
                    value4++;
                }
                setCarInfo(19, value4);
                break;
            case R.id.btn_minus15 /* 2131427474 */:
                int value5 = DataCanbus.DATA[89] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(26, value5);
                break;
            case R.id.btn_plus15 /* 2131427476 */:
                int value6 = DataCanbus.DATA[89] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(26, value6);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value7 = DataCanbus.DATA[65];
                if (value7 == 1) {
                    value7 = 0;
                } else if (value7 == 0) {
                    value7 = 1;
                }
                setCarInfo(0, value7);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value8 = DataCanbus.DATA[66] - 1;
                if (value8 < 0) {
                    value8 = 5;
                }
                setCarInfo(2, value8);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value9 = DataCanbus.DATA[66] + 1;
                if (value9 > 5) {
                    value9 = 0;
                }
                setCarInfo(2, value9);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value10 = DataCanbus.DATA[67] - 1;
                if (value10 < 0) {
                    value10 = 3;
                }
                setCarInfo(1, value10);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value11 = DataCanbus.DATA[67] + 1;
                if (value11 > 3) {
                    value11 = 0;
                }
                setCarInfo(1, value11);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value12 = DataCanbus.DATA[68] - 1;
                if (value12 < 0) {
                    value12 = 2;
                }
                setCarInfo(3, value12);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value13 = DataCanbus.DATA[68] + 1;
                if (value13 > 2) {
                    value13 = 0;
                }
                setCarInfo(3, value13);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value14 = DataCanbus.DATA[69] - 1;
                if (value14 < 0) {
                    value14 = 1;
                }
                setCarInfo(4, value14);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value15 = DataCanbus.DATA[69] + 1;
                if (value15 > 1) {
                    value15 = 0;
                }
                setCarInfo(4, value15);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value16 = DataCanbus.DATA[73] - 1;
                if (value16 < 0) {
                    value16 = 2;
                }
                setCarInfo(8, value16);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value17 = DataCanbus.DATA[73] + 1;
                if (value17 > 2) {
                    value17 = 0;
                }
                setCarInfo(8, value17);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value18 = DataCanbus.DATA[74] - 1;
                if (value18 < 0) {
                    value18 = 3;
                }
                setCarInfo(9, value18);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value19 = DataCanbus.DATA[74] + 1;
                if (value19 > 3) {
                    value19 = 0;
                }
                setCarInfo(9, value19);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value20 = DataCanbus.DATA[76] - 1;
                if (value20 < 0) {
                    value20 = 1;
                }
                setCarInfo(15, value20);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value21 = DataCanbus.DATA[76] + 1;
                if (value21 > 1) {
                    value21 = 0;
                }
                setCarInfo(15, value21);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value22 = DataCanbus.DATA[81] - 1;
                if (value22 < 0) {
                    value22 = 2;
                }
                setCarInfo(21, value22);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value23 = DataCanbus.DATA[81] + 1;
                if (value23 > 2) {
                    value23 = 0;
                }
                setCarInfo(21, value23);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value24 = DataCanbus.DATA[82] - 1;
                if (value24 < 0) {
                    value24 = 2;
                }
                setCarInfo(11, value24);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value25 = DataCanbus.DATA[82] + 1;
                if (value25 > 2) {
                    value25 = 0;
                }
                setCarInfo(11, value25);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value26 = DataCanbus.DATA[83] - 1;
                if (value26 < 0) {
                    value26 = 4;
                }
                setCarInfo(12, value26);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value27 = DataCanbus.DATA[83] + 1;
                if (value27 > 4) {
                    value27 = 0;
                }
                setCarInfo(12, value27);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value28 = DataCanbus.DATA[84] - 1;
                if (value28 < 0) {
                    value28 = 4;
                }
                setCarInfo(13, value28);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value29 = DataCanbus.DATA[84] + 1;
                if (value29 > 4) {
                    value29 = 0;
                }
                setCarInfo(13, value29);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value30 = DataCanbus.DATA[85];
                if (value30 > 0) {
                    value30--;
                }
                setCarInfo(14, value30);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value31 = DataCanbus.DATA[85];
                if (value31 < 26) {
                    value31++;
                }
                setCarInfo(14, value31);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value32 = DataCanbus.DATA[70];
                if (value32 == 1) {
                    value32 = 0;
                } else if (value32 == 0) {
                    value32 = 1;
                }
                setCarInfo(5, value32);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value33 = DataCanbus.DATA[71];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setCarInfo(6, value33);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value34 = DataCanbus.DATA[72];
                if (value34 == 1) {
                    value34 = 0;
                } else if (value34 == 0) {
                    value34 = 1;
                }
                setCarInfo(7, value34);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value35 = DataCanbus.DATA[75];
                if (value35 == 1) {
                    value35 = 0;
                } else if (value35 == 0) {
                    value35 = 1;
                }
                setCarInfo(10, value35);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value36 = DataCanbus.DATA[77];
                if (value36 == 1) {
                    value36 = 0;
                } else if (value36 == 0) {
                    value36 = 1;
                }
                setCarInfo(17, value36);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value37 = DataCanbus.DATA[78];
                if (value37 == 1) {
                    value37 = 0;
                } else if (value37 == 0) {
                    value37 = 1;
                }
                setCarInfo(18, value37);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value38 = DataCanbus.DATA[79];
                if (value38 == 1) {
                    value38 = 0;
                } else if (value38 == 0) {
                    value38 = 1;
                }
                setCarInfo(20, value38);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value39 = DataCanbus.DATA[80];
                if (value39 == 1) {
                    value39 = 0;
                } else if (value39 == 0) {
                    value39 = 1;
                }
                setCarInfo(22, value39);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value40 = DataCanbus.DATA[88];
                if (value40 == 1) {
                    value40 = 0;
                } else if (value40 == 0) {
                    value40 = 1;
                }
                setCarInfo(25, value40);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value41 = DataCanbus.DATA[91];
                if (value41 == 1) {
                    value41 = 0;
                } else if (value41 == 0) {
                    value41 = 1;
                }
                setCarInfo(28, value41);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int value42 = DataCanbus.DATA[110];
                if (value42 == 1) {
                    value42 = 0;
                } else if (value42 == 0) {
                    value42 = 1;
                }
                setCarInfo(30, value42);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                int value43 = DataCanbus.DATA[111];
                if (value43 == 1) {
                    value43 = 0;
                } else if (value43 == 0) {
                    value43 = 1;
                }
                setCarInfo(32, value43);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                int value44 = DataCanbus.DATA[113];
                if (value44 == 1) {
                    value44 = 0;
                } else if (value44 == 0) {
                    value44 = 1;
                }
                setCarInfo(34, value44);
                break;
            case R.id.ctv_checkedtext15 /* 2131427547 */:
                int value45 = DataCanbus.DATA[114];
                if (value45 == 1) {
                    value45 = 0;
                } else if (value45 == 0) {
                    value45 = 1;
                }
                setCarInfo(48, value45);
                break;
            case R.id.ctv_checkedtext16 /* 2131427548 */:
                int value46 = DataCanbus.DATA[117];
                if (value46 == 1) {
                    value46 = 0;
                } else if (value46 == 0) {
                    value46 = 1;
                }
                setCarInfo(51, value46);
                break;
            case R.id.ctv_checkedtext17 /* 2131427647 */:
                int value47 = DataCanbus.DATA[120];
                if (value47 == 1) {
                    value47 = 0;
                } else if (value47 == 0) {
                    value47 = 1;
                }
                setCarInfo(64, value47);
                break;
            case R.id.ctv_checkedtext18 /* 2131427649 */:
                int value48 = DataCanbus.DATA[123];
                if (value48 == 1) {
                    value48 = 0;
                } else if (value48 == 0) {
                    value48 = 1;
                }
                setCarInfo(80, value48);
                break;
            case R.id.ctv_checkedtext19 /* 2131427651 */:
                int value49 = DataCanbus.DATA[124];
                if (value49 == 1) {
                    value49 = 0;
                } else if (value49 == 0) {
                    value49 = 1;
                }
                setCarInfo(81, value49);
                break;
            case R.id.ctv_checkedtext20 /* 2131427653 */:
                int value50 = DataCanbus.DATA[128];
                if (value50 == 1) {
                    value50 = 0;
                } else if (value50 == 0) {
                    value50 = 1;
                }
                setCarInfo(72, value50);
                break;
            case R.id.ctv_checkedtext21 /* 2131427655 */:
                int value51 = DataCanbus.DATA[129];
                if (value51 == 1) {
                    value51 = 0;
                } else if (value51 == 0) {
                    value51 = 1;
                }
                setCarInfo(73, value51);
                break;
            case R.id.ctv_checkedtext22 /* 2131427657 */:
                int value52 = DataCanbus.DATA[130];
                if (value52 == 1) {
                    value52 = 0;
                } else if (value52 == 0) {
                    value52 = 1;
                }
                setCarInfo(74, value52);
                break;
            case R.id.ctv_checkedtext23 /* 2131427660 */:
                int value53 = DataCanbus.DATA[131];
                if (value53 == 1) {
                    value53 = 0;
                } else if (value53 == 0) {
                    value53 = 1;
                }
                setCarInfo(75, value53);
                break;
            case R.id.ctv_checkedtext24 /* 2131427832 */:
                dialog(R.string.all_settings, 24);
                break;
            case R.id.btn_minus18 /* 2131427878 */:
                int value54 = DataCanbus.DATA[112] - 1;
                if (value54 < 0) {
                    value54 = 4;
                }
                setCarInfo(33, value54);
                break;
            case R.id.btn_plus18 /* 2131427879 */:
                int value55 = DataCanbus.DATA[112] + 1;
                if (value55 > 4) {
                    value55 = 0;
                }
                setCarInfo(33, value55);
                break;
            case R.id.btn_minus19 /* 2131427880 */:
                int value56 = DataCanbus.DATA[115] - 1;
                if (value56 < 0) {
                    value56 = 1;
                }
                setCarInfo(49, value56);
                break;
            case R.id.btn_plus19 /* 2131427881 */:
                int value57 = DataCanbus.DATA[115] + 1;
                if (value57 > 1) {
                    value57 = 0;
                }
                setCarInfo(49, value57);
                break;
            case R.id.btn_minus21 /* 2131427882 */:
                int value58 = DataCanbus.DATA[118] - 1;
                if (value58 < 0) {
                    value58 = 2;
                }
                setCarInfo(52, value58);
                break;
            case R.id.btn_plus21 /* 2131427883 */:
                int value59 = DataCanbus.DATA[118] + 1;
                if (value59 > 2) {
                    value59 = 0;
                }
                setCarInfo(52, value59);
                break;
            case R.id.btn_minus22 /* 2131427884 */:
                int value60 = DataCanbus.DATA[119] - 1;
                if (value60 < 0) {
                    value60 = 2;
                }
                setCarInfo(53, value60);
                break;
            case R.id.btn_plus22 /* 2131427885 */:
                int value61 = DataCanbus.DATA[119] + 1;
                if (value61 > 2) {
                    value61 = 0;
                }
                setCarInfo(53, value61);
                break;
            case R.id.btn_minus16 /* 2131427888 */:
                int value62 = DataCanbus.DATA[90] - 1;
                if (value62 < 0) {
                    value62 = 2;
                }
                setCarInfo(27, value62);
                break;
            case R.id.btn_plus16 /* 2131427889 */:
                int value63 = DataCanbus.DATA[90] + 1;
                if (value63 > 2) {
                    value63 = 0;
                }
                setCarInfo(27, value63);
                break;
            case R.id.btn_minus17 /* 2131427890 */:
                int value64 = DataCanbus.DATA[92] - 1;
                if (value64 < 0) {
                    value64 = 2;
                }
                setCarInfo(29, value64);
                break;
            case R.id.btn_plus17 /* 2131427891 */:
                int value65 = DataCanbus.DATA[92] + 1;
                if (value65 > 2) {
                    value65 = 0;
                }
                setCarInfo(29, value65);
                break;
            case R.id.btn_minus20 /* 2131427893 */:
                int value66 = DataCanbus.DATA[116] - 1;
                if (value66 < 0) {
                    value66 = 2;
                }
                setCarInfo(50, value66);
                break;
            case R.id.btn_plus20 /* 2131427894 */:
                int value67 = DataCanbus.DATA[116] + 1;
                if (value67 > 2) {
                    value67 = 0;
                }
                setCarInfo(50, value67);
                break;
            case R.id.btn_plus25 /* 2131427923 */:
                int value68 = DataCanbus.DATA[125] + 1;
                if (value68 > 2) {
                    value68 = 0;
                }
                setCarInfo(56, value68);
                break;
            case R.id.btn_plus24 /* 2131427924 */:
                int value69 = DataCanbus.DATA[122] + 1;
                if (value69 > 2) {
                    value69 = 0;
                }
                setCarInfo(66, value69);
                break;
            case R.id.btn_plus26 /* 2131427925 */:
                int value70 = DataCanbus.DATA[126] + 1;
                if (value70 > 2) {
                    value70 = 0;
                }
                setCarInfo(57, value70);
                break;
            case R.id.btn_plus27 /* 2131427926 */:
                int value71 = DataCanbus.DATA[127] + 1;
                if (value71 > 1) {
                    value71 = 0;
                }
                setCarInfo(58, value71);
                break;
            case R.id.btn_plus28 /* 2131427927 */:
                int value72 = DataCanbus.DATA[132] + 1;
                if (value72 > 3) {
                    value72 = 0;
                }
                setCarInfo(35, value72);
                break;
            case R.id.btn_plus23 /* 2131427928 */:
                int value73 = DataCanbus.DATA[121] + 1;
                if (value73 > 2) {
                    value73 = 0;
                }
                setCarInfo(65, value73);
                break;
            case R.id.btn_minus28 /* 2131428312 */:
                int value74 = DataCanbus.DATA[132] - 1;
                if (value74 < 0) {
                    value74 = 3;
                }
                setCarInfo(35, value74);
                break;
            case R.id.btn_minus29 /* 2131428313 */:
                int value75 = DataCanbus.DATA[133];
                if (value75 > 0) {
                    value75--;
                }
                setCarInfo(40, value75);
                break;
            case R.id.btn_plus29 /* 2131428314 */:
                int value76 = DataCanbus.DATA[133];
                if (value76 < 6) {
                    value76++;
                }
                setCarInfo(40, value76);
                break;
            case R.id.btn_minus25 /* 2131428315 */:
                int value77 = DataCanbus.DATA[125] - 1;
                if (value77 < 0) {
                    value77 = 2;
                }
                setCarInfo(56, value77);
                break;
            case R.id.btn_minus26 /* 2131428316 */:
                int value78 = DataCanbus.DATA[126] - 1;
                if (value78 < 0) {
                    value78 = 2;
                }
                setCarInfo(57, value78);
                break;
            case R.id.btn_minus27 /* 2131428317 */:
                int value79 = DataCanbus.DATA[127] - 1;
                if (value79 < 0) {
                    value79 = 1;
                }
                setCarInfo(58, value79);
                break;
            case R.id.btn_minus23 /* 2131428318 */:
                int value80 = DataCanbus.DATA[121] - 1;
                if (value80 < 0) {
                    value80 = 2;
                }
                setCarInfo(65, value80);
                break;
            case R.id.btn_minus24 /* 2131428319 */:
                int value81 = DataCanbus.DATA[122] - 1;
                if (value81 < 0) {
                    value81 = 2;
                }
                setCarInfo(66, value81);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{9}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{13}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{14}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
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
