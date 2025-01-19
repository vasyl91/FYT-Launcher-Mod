package com.syu.carinfo.bnr.ford;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class fragment_ford_carset extends BaseFragment implements View.OnClickListener {
    int[] callids = {115, 116, 117, 118, 119, 120, 121, 129, 130, 37};
    int[] warnSoundCtrl = {R.string.klc_onstar_close, R.string.klc_onstar_close, R.string.xp_ylford_set_voice_mode1, R.string.xp_ylford_set_voice_mode2, R.string.xp_ylford_set_voice_mode3, R.string.klc_air_auto};
    int[] ambientColor = {R.string.klc_onstar_close, R.string.str_403_ambient_0, R.string.str_403_ambient_1, R.string.str_403_ambient_2, R.string.str_403_ambient_3, R.string.str_403_ambient_4, R.string.str_403_ambient_5, R.string.str_403_ambient_6};
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 37:
                    fragment_ford_carset.this.uTempUnit(val);
                    break;
                case 115:
                    fragment_ford_carset.this.uTow(val);
                    break;
                case 116:
                    fragment_ford_carset.this.uInfo(val);
                    break;
                case 117:
                    fragment_ford_carset.this.uWarn(val);
                    break;
                case 118:
                    fragment_ford_carset.this.uBright(val);
                    break;
                case 119:
                    fragment_ford_carset.this.uMilesUnit(val);
                    break;
                case 120:
                    fragment_ford_carset.this.uWarnVoice(val);
                    break;
                case 121:
                    fragment_ford_carset.this.uTurn(val);
                    break;
                case 129:
                    fragment_ford_carset.this.uAmbientBright(val);
                    break;
                case 130:
                    fragment_ford_carset.this.uAmbientColor(val);
                    break;
            }
        }
    };

    @Override
    public void initView() {
        setSelfClick(this.mView.findViewById(R.id.xp_ylford_tempunit_set_minus), this);
        setSelfClick(this.mView.findViewById(R.id.xp_ylford_tempunit_set_plus), this);
        setSelfClick(this.mView.findViewById(R.id.xp_ylford_turnlight_set_minus), this);
        setSelfClick(this.mView.findViewById(R.id.xp_ylford_turnlight_set_plus), this);
        setSelfClick(this.mView.findViewById(R.id.xp_ylford_unit_set_minus), this);
        setSelfClick(this.mView.findViewById(R.id.xp_ylford_unit_set_plus), this);
        setSelfClick(this.mView.findViewById(R.id.xp_ylford_brightness_set_minus), this);
        setSelfClick(this.mView.findViewById(R.id.xp_ylford_brightness_set_plus), this);
        setSelfClick(this.mView.findViewById(R.id.xp_ylford_warnsound_set_minus), this);
        setSelfClick(this.mView.findViewById(R.id.xp_ylford_warnsound_set_plus), this);
        setSelfClick(this.mView.findViewById(R.id.xp_ylford_ambient_bright_set_minus), this);
        setSelfClick(this.mView.findViewById(R.id.xp_ylford_ambient_bright_set_plus), this);
        setSelfClick(this.mView.findViewById(R.id.xp_ylford_ambient_color_set_minus), this);
        setSelfClick(this.mView.findViewById(R.id.xp_ylford_ambient_color_set_plus), this);
        setSelfClick((CheckedTextView) this.mView.findViewById(R.id.xp_ylford_set_tow_system_switch), this);
        setSelfClick((CheckedTextView) this.mView.findViewById(R.id.xp_ylford_warning_point_state), this);
        setSelfClick((CheckedTextView) this.mView.findViewById(R.id.xp_ylford_information_point_state), this);
    }

    @Override
    public void initListener() {
    }

    @Override
    public int getViewLayout() {
        return R.layout.layout_0403_bnr_ford_carset;
    }

    @Override
    public void addNotify() {
        for (int i : this.callids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        for (int i : this.callids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }

    private void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(1, new int[]{cmd, val}, null, null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xp_ylford_turnlight_set_minus /* 2131427776 */:
            case R.id.xp_ylford_turnlight_set_plus /* 2131427778 */:
                sendCMD(163, DataCanbus.DATA[121] == 1 ? 3 : 4);
                break;
            case R.id.xp_ylford_unit_set_minus /* 2131427779 */:
            case R.id.xp_ylford_unit_set_plus /* 2131427781 */:
                sendCMD(163, DataCanbus.DATA[119] == 1 ? 14 : 15);
                break;
            case R.id.xp_ylford_brightness_set_minus /* 2131427785 */:
            case R.id.xp_ylford_brightness_set_plus /* 2131427787 */:
                sendCMD(163, DataCanbus.DATA[118] == 1 ? 16 : 17);
                break;
            case R.id.xp_ylford_set_tow_system_switch /* 2131427793 */:
                sendCMD(163, DataCanbus.DATA[115] == 1 ? 2 : 1);
                break;
            case R.id.xp_ylford_information_point_state /* 2131427794 */:
                sendCMD(163, DataCanbus.DATA[116] == 1 ? 5 : 6);
                break;
            case R.id.xp_ylford_warning_point_state /* 2131427795 */:
                sendCMD(163, DataCanbus.DATA[117] != 1 ? 8 : 7);
                break;
            case R.id.xp_ylford_tempunit_set_minus /* 2131428034 */:
                sendCMD(160, 0);
                break;
            case R.id.xp_ylford_tempunit_set_plus /* 2131428036 */:
                sendCMD(160, 1);
                break;
            case R.id.xp_ylford_warnsound_set_minus /* 2131428037 */:
                int iwarnctrl = DataCanbus.DATA[120] - 1;
                if (iwarnctrl < 0) {
                    iwarnctrl = this.warnSoundCtrl.length - 1;
                }
                sendCMD(163, iwarnctrl + 9);
                break;
            case R.id.xp_ylford_warnsound_set_plus /* 2131428039 */:
                int iwarnctrl2 = DataCanbus.DATA[120] + 1;
                if (iwarnctrl2 >= this.warnSoundCtrl.length) {
                    iwarnctrl2 = 0;
                }
                sendCMD(163, iwarnctrl2 + 9);
                break;
            case R.id.xp_ylford_ambient_bright_set_minus /* 2131428040 */:
                int iambientbright = DataCanbus.DATA[129] - 1;
                if (iambientbright < 0) {
                    iambientbright = 0;
                }
                sendCMD(176, iambientbright);
                break;
            case R.id.xp_ylford_ambient_bright_set_plus /* 2131428042 */:
                int iambientbright2 = DataCanbus.DATA[129] + 1;
                if (iambientbright2 > 100) {
                    iambientbright2 = 100;
                }
                sendCMD(176, iambientbright2);
                break;
            case R.id.xp_ylford_ambient_color_set_minus /* 2131428043 */:
                int iambientcolor = DataCanbus.DATA[130] - 1;
                if (iambientcolor < 1) {
                    iambientcolor = 7;
                }
                sendCMD(177, iambientcolor);
                break;
            case R.id.xp_ylford_ambient_color_set_plus /* 2131428045 */:
                int iambientcolor2 = DataCanbus.DATA[130] + 1;
                if (iambientcolor2 > 7) {
                    iambientcolor2 = 1;
                }
                sendCMD(177, iambientcolor2);
                break;
        }
    }

    protected void uTow(int val) {
        setCheck((CheckedTextView) this.mView.findViewById(R.id.xp_ylford_set_tow_system_switch), val == 1);
    }

    protected void uTempUnit(int val) {
        if (((TextView) this.mView.findViewById(R.id.xp_ylford_tempunit_set_show)) != null) {
            ((TextView) this.mView.findViewById(R.id.xp_ylford_tempunit_set_show)).setText(val == 1 ? "℉" : "℃");
        }
    }

    protected void uAmbientColor(int val) {
        if (((TextView) this.mView.findViewById(R.id.xp_ylford_ambient_color_set_show)) != null && val < 8) {
            ((TextView) this.mView.findViewById(R.id.xp_ylford_ambient_color_set_show)).setText(this.ambientColor[val]);
        }
    }

    protected void uAmbientBright(int val) {
        if (((TextView) this.mView.findViewById(R.id.xp_ylford_ambient_bright_set_show)) != null) {
            ((TextView) this.mView.findViewById(R.id.xp_ylford_ambient_bright_set_show)).setText(new StringBuilder().append(val).toString());
        }
    }

    protected void uTurn(int val) {
        if (((TextView) this.mView.findViewById(R.id.xp_ylford_turnlight_set_show)) != null) {
            ((TextView) this.mView.findViewById(R.id.xp_ylford_turnlight_set_show)).setText(val == 1 ? R.string.wc_jianianhua_show_turnlights_point_1 : R.string.wc_jianianhua_show_turnlights_point_0);
        }
    }

    protected void uWarnVoice(int val) {
        if (((TextView) this.mView.findViewById(R.id.xp_ylford_warnsound_set_show)) != null && val < this.warnSoundCtrl.length) {
            ((TextView) this.mView.findViewById(R.id.xp_ylford_warnsound_set_show)).setText(this.warnSoundCtrl[val]);
        }
    }

    protected void uMilesUnit(int val) {
        if (((TextView) this.mView.findViewById(R.id.xp_ylford_unit_set_show)) != null) {
            ((TextView) this.mView.findViewById(R.id.xp_ylford_unit_set_show)).setText(val == 0 ? "Km" : "Miles");
        }
    }

    protected void uBright(int val) {
        if (((TextView) this.mView.findViewById(R.id.xp_ylford_brightness_set_show)) != null) {
            ((TextView) this.mView.findViewById(R.id.xp_ylford_brightness_set_show)).setText(val == 1 ? R.string.klc_air_auto : R.string.klc_air_Manual);
        }
    }

    protected void uWarn(int val) {
        setCheck((CheckedTextView) this.mView.findViewById(R.id.xp_ylford_warning_point_state), val == 1);
    }

    protected void uInfo(int val) {
        setCheck((CheckedTextView) this.mView.findViewById(R.id.xp_ylford_information_point_state), val == 1);
    }
}
