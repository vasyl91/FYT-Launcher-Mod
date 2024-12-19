package com.syu.carinfo.bnr.ford;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class fragment_ford_carset extends BaseFragment implements View.OnClickListener {
    int[] callids = {38, 39, 40, 41, 42, 43, 44, 54, 55, 28};
    int[] warnSoundCtrl = {R.string.klc_onstar_close, R.string.klc_onstar_close, R.string.xp_ylford_set_voice_mode1, R.string.xp_ylford_set_voice_mode2, R.string.xp_ylford_set_voice_mode3, R.string.klc_air_auto};
    int[] ambientColor = {R.string.klc_onstar_close, R.string.str_403_ambient_0, R.string.str_403_ambient_1, R.string.str_403_ambient_2, R.string.str_403_ambient_3, R.string.str_403_ambient_4, R.string.str_403_ambient_5, R.string.str_403_ambient_6};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bnr.ford.fragment_ford_carset.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 28:
                    fragment_ford_carset.this.uTempUnit(val);
                    break;
                case 38:
                    fragment_ford_carset.this.uTow(val);
                    break;
                case 39:
                    fragment_ford_carset.this.uInfo(val);
                    break;
                case 40:
                    fragment_ford_carset.this.uWarn(val);
                    break;
                case 41:
                    fragment_ford_carset.this.uBright(val);
                    break;
                case 42:
                    fragment_ford_carset.this.uMilesUnit(val);
                    break;
                case 43:
                    fragment_ford_carset.this.uWarnVoice(val);
                    break;
                case 44:
                    fragment_ford_carset.this.uTurn(val);
                    break;
                case 54:
                    fragment_ford_carset.this.uAmbientBright(val);
                    break;
                case 55:
                    fragment_ford_carset.this.uAmbientColor(val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseFragment
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

    @Override // com.syu.canbus.BaseFragment
    public void initListener() {
    }

    @Override // com.syu.canbus.BaseFragment
    public int getViewLayout() {
        return R.layout.layout_0403_bnr_ford_carset;
    }

    @Override // com.syu.canbus.BaseFragment
    public void addNotify() {
        for (int i : this.callids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseFragment
    public void removeNotify() {
        for (int i : this.callids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }

    private void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(1, new int[]{cmd, val}, null, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xp_ylford_turnlight_set_minus /* 2131427760 */:
            case R.id.xp_ylford_turnlight_set_plus /* 2131427762 */:
                sendCMD(163, DataCanbus.DATA[44] == 1 ? 3 : 4);
                break;
            case R.id.xp_ylford_unit_set_minus /* 2131427763 */:
            case R.id.xp_ylford_unit_set_plus /* 2131427765 */:
                sendCMD(163, DataCanbus.DATA[42] == 1 ? 14 : 15);
                break;
            case R.id.xp_ylford_brightness_set_minus /* 2131427769 */:
            case R.id.xp_ylford_brightness_set_plus /* 2131427771 */:
                sendCMD(163, DataCanbus.DATA[41] == 1 ? 16 : 17);
                break;
            case R.id.xp_ylford_set_tow_system_switch /* 2131427777 */:
                sendCMD(163, DataCanbus.DATA[38] == 1 ? 2 : 1);
                break;
            case R.id.xp_ylford_information_point_state /* 2131427778 */:
                sendCMD(163, DataCanbus.DATA[39] == 1 ? 5 : 6);
                break;
            case R.id.xp_ylford_warning_point_state /* 2131427779 */:
                sendCMD(163, DataCanbus.DATA[40] != 1 ? 8 : 7);
                break;
            case R.id.xp_ylford_tempunit_set_minus /* 2131428033 */:
                sendCMD(160, 0);
                break;
            case R.id.xp_ylford_tempunit_set_plus /* 2131428035 */:
                sendCMD(160, 1);
                break;
            case R.id.xp_ylford_warnsound_set_minus /* 2131428036 */:
                int iwarnctrl = DataCanbus.DATA[43] - 1;
                if (iwarnctrl < 0) {
                    iwarnctrl = this.warnSoundCtrl.length - 1;
                }
                sendCMD(163, iwarnctrl + 9);
                break;
            case R.id.xp_ylford_warnsound_set_plus /* 2131428038 */:
                int iwarnctrl2 = DataCanbus.DATA[43] + 1;
                if (iwarnctrl2 >= this.warnSoundCtrl.length) {
                    iwarnctrl2 = 0;
                }
                sendCMD(163, iwarnctrl2 + 9);
                break;
            case R.id.xp_ylford_ambient_bright_set_minus /* 2131428039 */:
                int iambientbright = DataCanbus.DATA[54] - 1;
                if (iambientbright < 0) {
                    iambientbright = 0;
                }
                sendCMD(176, iambientbright);
                break;
            case R.id.xp_ylford_ambient_bright_set_plus /* 2131428041 */:
                int iambientbright2 = DataCanbus.DATA[54] + 1;
                if (iambientbright2 > 100) {
                    iambientbright2 = 100;
                }
                sendCMD(176, iambientbright2);
                break;
            case R.id.xp_ylford_ambient_color_set_minus /* 2131428042 */:
                int iambientcolor = DataCanbus.DATA[55] - 1;
                if (iambientcolor < 1) {
                    iambientcolor = 7;
                }
                sendCMD(177, iambientcolor);
                break;
            case R.id.xp_ylford_ambient_color_set_plus /* 2131428044 */:
                int iambientcolor2 = DataCanbus.DATA[55] + 1;
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
