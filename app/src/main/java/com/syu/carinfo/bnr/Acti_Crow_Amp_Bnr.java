package com.syu.carinfo.bnr;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class Acti_Crow_Amp_Bnr extends BaseActivity {
    private int val;
    private SeekBar.OnSeekBarChangeListener mseekbarClick = new SeekBar.OnSeekBarChangeListener() { 
        @Override
        public void onStopTrackingTouch(SeekBar v) {
            switch (v.getId()) {
                case R.id.bnr_crow_amp_carvol_seekview /* 2131428113 */:
                    Acti_Crow_Amp_Bnr.this.sendCMD(7, v.getProgress());
                    break;
                case R.id.bnr_crow_amp_treview /* 2131428116 */:
                    Acti_Crow_Amp_Bnr.this.sendCMD(5, v.getProgress() + 2);
                    break;
                case R.id.bnr_crow_amp_bassview /* 2131428119 */:
                    Acti_Crow_Amp_Bnr.this.sendCMD(4, v.getProgress() + 2);
                    break;
                case R.id.bnr_crow_amp_middleview /* 2131428122 */:
                    Acti_Crow_Amp_Bnr.this.sendCMD(6, v.getProgress() + 2);
                    break;
                case R.id.bnr_crow_amp_fadview /* 2131428125 */:
                    Acti_Crow_Amp_Bnr.this.sendCMD(1, v.getProgress());
                    break;
                case R.id.bnr_crow_amp_balview /* 2131428128 */:
                    Acti_Crow_Amp_Bnr.this.sendCMD(2, v.getProgress());
                    break;
            }
        }

        @Override
        public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
        }

        @Override
        public void onStartTrackingTouch(SeekBar arg0) {
        }
    };
    private View.OnClickListener mClick = new View.OnClickListener() { 
        @Override
        public void onClick(View v) {
            int value;
            int value2;
            int value3;
            int value4;
            int value5;
            int value6;
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427455 */:
                    int value7 = DataCanbus.DATA[162];
                    if (value7 > 0) {
                        value7--;
                    }
                    Acti_Crow_Amp_Bnr.this.sendCMD(7, value7);
                    break;
                case R.id.btn_plus1 /* 2131427457 */:
                    int value8 = DataCanbus.DATA[162];
                    if (value8 < 63) {
                        value8++;
                    }
                    Acti_Crow_Amp_Bnr.this.sendCMD(7, value8);
                    break;
                case R.id.bnr_crow_btn_amppsel_minus /* 2131428130 */:
                    int value9 = DataCanbus.DATA[172];
                    if (value9 > 0) {
                        value6 = value9 - 1;
                    } else {
                        value6 = 3;
                    }
                    Acti_Crow_Amp_Bnr.this.sendCMD(12, value6);
                    break;
                case R.id.bnr_crow_btn_amppsel_plus /* 2131428132 */:
                    int value10 = DataCanbus.DATA[172];
                    if (value10 < 3) {
                        value5 = value10 + 1;
                    } else {
                        value5 = 0;
                    }
                    Acti_Crow_Amp_Bnr.this.sendCMD(12, value5);
                    break;
                case R.id.bnr_crow_amp_poweronoff /* 2131428133 */:
                    int value11 = DataCanbus.DATA[170];
                    if (value11 == 1) {
                        value4 = 0;
                    } else {
                        value4 = 1;
                    }
                    Acti_Crow_Amp_Bnr.this.sendCMD(8, value4);
                    break;
                case R.id.bnr_crow_amp_arround /* 2131428134 */:
                    int value12 = DataCanbus.DATA[169];
                    if (value12 == 1) {
                        value3 = 0;
                    } else {
                        value3 = 1;
                    }
                    Acti_Crow_Amp_Bnr.this.sendCMD(9, value3);
                    break;
                case R.id.bnr_crow_amp_mute /* 2131428136 */:
                    int value13 = DataCanbus.DATA[171];
                    if (value13 == 1) {
                        value2 = 0;
                    } else {
                        value2 = 1;
                    }
                    Acti_Crow_Amp_Bnr.this.sendCMD(10, value2);
                    break;
                case R.id.bnr_crow_amp_asl /* 2131428137 */:
                    int value14 = DataCanbus.DATA[168];
                    if (value14 == 8) {
                        value = 1;
                    } else {
                        value = 8;
                    }
                    Acti_Crow_Amp_Bnr.this.sendCMD(3, value);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Acti_Crow_Amp_Bnr.this.val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 162:
                    Acti_Crow_Amp_Bnr.this.uCarSoundVol(Acti_Crow_Amp_Bnr.this.val);
                    break;
                case 164:
                    Acti_Crow_Amp_Bnr.this.uCarSoundFad(Acti_Crow_Amp_Bnr.this.val);
                    break;
                case 165:
                    Acti_Crow_Amp_Bnr.this.uCarSoundBal(Acti_Crow_Amp_Bnr.this.val);
                    break;
                case 166:
                    Acti_Crow_Amp_Bnr.this.uCarSoundBass(Acti_Crow_Amp_Bnr.this.val);
                    break;
                case 167:
                    Acti_Crow_Amp_Bnr.this.uCarSoundTre(Acti_Crow_Amp_Bnr.this.val);
                    break;
                case 168:
                    Acti_Crow_Amp_Bnr.this.uCarSoundAsl(Acti_Crow_Amp_Bnr.this.val);
                    break;
                case 169:
                    if (((CheckedTextView) Acti_Crow_Amp_Bnr.this.findViewById(R.id.bnr_crow_amp_arround)) != null) {
                        if (Acti_Crow_Amp_Bnr.this.val == 1) {
                            ((CheckedTextView) Acti_Crow_Amp_Bnr.this.findViewById(R.id.bnr_crow_amp_arround)).setChecked(true);
                            break;
                        } else {
                            ((CheckedTextView) Acti_Crow_Amp_Bnr.this.findViewById(R.id.bnr_crow_amp_arround)).setChecked(false);
                            break;
                        }
                    }
                    break;
                case 170:
                    Acti_Crow_Amp_Bnr.this.uCarSoundPowerOnOff(Acti_Crow_Amp_Bnr.this.val);
                    break;
                case 171:
                    Acti_Crow_Amp_Bnr.this.uCarSoundMute(Acti_Crow_Amp_Bnr.this.val);
                    break;
                case 172:
                    Acti_Crow_Amp_Bnr.this.uCarSoundpsel(Acti_Crow_Amp_Bnr.this.val);
                    break;
                case 173:
                    Acti_Crow_Amp_Bnr.this.uCarSoundMiddle(Acti_Crow_Amp_Bnr.this.val);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0438_crow_caramp);
        init();
    }

    @Override
    public void init() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_XP1_14Prado_H /* 3407892 */:
            case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
            case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_LS460_06 /* 6095245 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_GS_06 /* 6160781 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_IS_06 /* 6226317 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_ES_06 /* 6291853 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_GX460_10 /* 6357389 */:
            case FinalCanbus.CAR_BNR_Toyota_14Tundra_AMP /* 6422925 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AMP /* 6488461 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP /* 6553997 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP_19 /* 6619533 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10_AMP /* 6685069 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AMP /* 6750605 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_AMP /* 6816141 */:
                findViewById(R.id.bnr_crow_amp_carvol_view).setVisibility(8);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.bnr_crow_amp_mute_view).setVisibility(8);
                findViewById(R.id.prado_vol_speed_link_view).setVisibility(8);
                break;
            default:
                findViewById(R.id.layout_view8).setVisibility(8);
                findViewById(R.id.bnr_crow_amp_mute_view).setVisibility(8);
                findViewById(R.id.prado_vol_speed_link_view).setVisibility(8);
                break;
        }
        seekbaronClick((SeekBar) findViewById(R.id.bnr_crow_amp_carvol_seekview));
        seekbaronClick((SeekBar) findViewById(R.id.bnr_crow_amp_bassview));
        seekbaronClick((SeekBar) findViewById(R.id.bnr_crow_amp_middleview));
        seekbaronClick((SeekBar) findViewById(R.id.bnr_crow_amp_treview));
        seekbaronClick((SeekBar) findViewById(R.id.bnr_crow_amp_fadview));
        seekbaronClick((SeekBar) findViewById(R.id.bnr_crow_amp_balview));
        setonClick((Button) findViewById(R.id.bnr_crow_btn_amppsel_minus));
        setonClick((Button) findViewById(R.id.bnr_crow_btn_amppsel_plus));
        setonClick((Button) findViewById(R.id.btn_minus1));
        setonClick((Button) findViewById(R.id.btn_plus1));
        setonClick((CheckedTextView) findViewById(R.id.bnr_crow_amp_poweronoff));
        setonClick((CheckedTextView) findViewById(R.id.bnr_crow_amp_arround));
        setonClick((CheckedTextView) findViewById(R.id.bnr_crow_amp_asl));
        setonClick((CheckedTextView) findViewById(R.id.bnr_crow_amp_mute));
    }

    
    public void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(25, new int[]{cmd, val}, null, null);
    }

    private void seekbaronClick(SeekBar v) {
        if (v != null) {
            v.setOnSeekBarChangeListener(this.mseekbarClick);
        }
    }

    private void setonClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
    }

    protected void uCarSoundVol(int val) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
        if (((TextView) findViewById(R.id.bnr_crow_amp_carvol_text)) != null) {
            ((TextView) findViewById(R.id.bnr_crow_amp_carvol_text)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
        if (((SeekBar) findViewById(R.id.bnr_crow_amp_carvol_seekview)) != null) {
            ((SeekBar) findViewById(R.id.bnr_crow_amp_carvol_seekview)).setProgress(val);
        }
    }

    protected void uCarSoundBass(int val) {
        int val2 = val - 2;
        if (((SeekBar) findViewById(R.id.bnr_crow_amp_bassview)) != null) {
            ((SeekBar) findViewById(R.id.bnr_crow_amp_bassview)).setProgress(val2);
        }
        if (((TextView) findViewById(R.id.bnr_crow_amp_bassvalue)) != null) {
            if (val2 > 5) {
                ((TextView) findViewById(R.id.bnr_crow_amp_bassvalue)).setText("+" + (val2 - 5));
            } else {
                if (val2 < 5) {
                    ((TextView) findViewById(R.id.bnr_crow_amp_bassvalue)).setText("-" + (5 - val2));
                    return;
                }
                ((TextView) findViewById(R.id.bnr_crow_amp_bassvalue)).setText("0");
            }
        }
    }

    protected void uCarSoundMiddle(int val) {
        int val2 = val - 2;
        if (((SeekBar) findViewById(R.id.bnr_crow_amp_middleview)) != null) {
            ((SeekBar) findViewById(R.id.bnr_crow_amp_middleview)).setProgress(val2);
        }
        if (((TextView) findViewById(R.id.bnr_crow_amp_middlevalue)) != null) {
            if (val2 > 5) {
                ((TextView) findViewById(R.id.bnr_crow_amp_middlevalue)).setText("+" + (val2 - 5));
            } else {
                if (val2 < 5) {
                    ((TextView) findViewById(R.id.bnr_crow_amp_middlevalue)).setText("-" + (5 - val2));
                    return;
                }
                ((TextView) findViewById(R.id.bnr_crow_amp_middlevalue)).setText("0");
            }
        }
    }

    protected void uCarSoundTre(int val) {
        int val2 = val - 2;
        if (((SeekBar) findViewById(R.id.bnr_crow_amp_treview)) != null) {
            ((SeekBar) findViewById(R.id.bnr_crow_amp_treview)).setProgress(val2);
        }
        if (((TextView) findViewById(R.id.bnr_crow_amp_trevalue)) != null) {
            if (val2 > 5) {
                ((TextView) findViewById(R.id.bnr_crow_amp_trevalue)).setText("+" + (val2 - 5));
            } else {
                if (val2 < 5) {
                    ((TextView) findViewById(R.id.bnr_crow_amp_trevalue)).setText("-" + (5 - val2));
                    return;
                }
                ((TextView) findViewById(R.id.bnr_crow_amp_trevalue)).setText("0");
            }
        }
    }

    protected void uCarSoundFad(int val) {
        if (((SeekBar) findViewById(R.id.bnr_crow_amp_fadview)) != null) {
            ((SeekBar) findViewById(R.id.bnr_crow_amp_fadview)).setProgress(val);
        }
        if (((TextView) findViewById(R.id.bnr_crow_amp_fadvalue)) != null) {
            if (val > 7) {
                ((TextView) findViewById(R.id.bnr_crow_amp_fadvalue)).setText("R" + (val - 7));
            } else {
                if (val < 7) {
                    ((TextView) findViewById(R.id.bnr_crow_amp_fadvalue)).setText("F" + (7 - val));
                    return;
                }
                ((TextView) findViewById(R.id.bnr_crow_amp_fadvalue)).setText("0");
            }
        }
    }

    protected void uCarSoundBal(int val) {
        if (((SeekBar) findViewById(R.id.bnr_crow_amp_balview)) != null) {
            ((SeekBar) findViewById(R.id.bnr_crow_amp_balview)).setProgress(val);
        }
        if (((TextView) findViewById(R.id.bnr_crow_amp_balvalue)) != null) {
            if (val > 7) {
                ((TextView) findViewById(R.id.bnr_crow_amp_balvalue)).setText("R" + (val - 7));
            } else {
                if (val < 7) {
                    ((TextView) findViewById(R.id.bnr_crow_amp_balvalue)).setText("L" + (7 - val));
                    return;
                }
                ((TextView) findViewById(R.id.bnr_crow_amp_balvalue)).setText("0");
            }
        }
    }

    protected void uCarSoundPowerOnOff(int val) {
        if (((CheckedTextView) findViewById(R.id.bnr_crow_amp_poweronoff)) != null) {
            if (val == 1) {
                ((CheckedTextView) findViewById(R.id.bnr_crow_amp_poweronoff)).setChecked(true);
            } else {
                ((CheckedTextView) findViewById(R.id.bnr_crow_amp_poweronoff)).setChecked(false);
            }
        }
    }

    protected void uCarSoundpsel(int val) {
        if (((TextView) findViewById(R.id.bnr_crow_btn_amppsel_value)) != null) {
            if (val == 0) {
                ((TextView) findViewById(R.id.bnr_crow_btn_amppsel_value)).setText("POS ALL");
                return;
            }
            if (val == 1) {
                ((TextView) findViewById(R.id.bnr_crow_btn_amppsel_value)).setText("POS FRONT");
            } else if (val == 2) {
                ((TextView) findViewById(R.id.bnr_crow_btn_amppsel_value)).setText("POS REAR");
            } else if (val == 3) {
                ((TextView) findViewById(R.id.bnr_crow_btn_amppsel_value)).setText("POS DRIVER");
            }
        }
    }

    protected void uCarSoundMute(int val) {
        if (((CheckedTextView) findViewById(R.id.bnr_crow_amp_mute)) != null) {
            if (val == 1) {
                ((CheckedTextView) findViewById(R.id.bnr_crow_amp_mute)).setChecked(true);
            } else {
                ((CheckedTextView) findViewById(R.id.bnr_crow_amp_mute)).setChecked(false);
            }
        }
    }

    protected void uCarSoundAsl(int val) {
        if (((CheckedTextView) findViewById(R.id.bnr_crow_amp_asl)) != null) {
            if (val == 8) {
                ((CheckedTextView) findViewById(R.id.bnr_crow_amp_asl)).setChecked(true);
            } else if (val == 1) {
                ((CheckedTextView) findViewById(R.id.bnr_crow_amp_asl)).setChecked(false);
            }
        }
    }
}
