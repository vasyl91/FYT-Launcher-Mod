package com.syu.carinfo.rzc.changan_cx70;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RzcChanganCX70SetFunc extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 37:
                    RzcChanganCX70SetFunc.this.mUpdaterValue8();
                    break;
                case 38:
                    RzcChanganCX70SetFunc.this.uFoldRearMirror(DataCanbus.DATA[updateCode]);
                    break;
                case 40:
                    RzcChanganCX70SetFunc.this.uBackRainAssist(DataCanbus.DATA[updateCode]);
                    break;
                case 41:
                    RzcChanganCX70SetFunc.this.uRemoteUnlock(DataCanbus.DATA[updateCode]);
                    break;
                case 42:
                    RzcChanganCX70SetFunc.this.uDriveLock(DataCanbus.DATA[updateCode]);
                    break;
                case 43:
                    RzcChanganCX70SetFunc.this.uAccOffLock(DataCanbus.DATA[updateCode]);
                    break;
                case 44:
                    RzcChanganCX70SetFunc.this.uCloseTopWindow(DataCanbus.DATA[updateCode]);
                    break;
                case 45:
                    RzcChanganCX70SetFunc.this.uAutoAir(DataCanbus.DATA[updateCode]);
                    break;
                case 46:
                    RzcChanganCX70SetFunc.this.uOpenWindowToWind(DataCanbus.DATA[updateCode]);
                    break;
                case 47:
                    RzcChanganCX70SetFunc.this.uAirAutoDry(DataCanbus.DATA[updateCode]);
                    break;
                case 48:
                    RzcChanganCX70SetFunc.this.uLightFrontDelay(DataCanbus.DATA[updateCode]);
                    break;
                case 49:
                    RzcChanganCX70SetFunc.this.uLightOnKeyTurn(DataCanbus.DATA[updateCode]);
                    break;
                case 51:
                    RzcChanganCX70SetFunc.this.uYingBingVolset(DataCanbus.DATA[updateCode]);
                    break;
                case 52:
                    RzcChanganCX70SetFunc.this.uTishiVolset(DataCanbus.DATA[updateCode]);
                    break;
                case 53:
                    RzcChanganCX70SetFunc.this.uBaojingVolset(DataCanbus.DATA[updateCode]);
                    break;
                case 54:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext13)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 55:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext19)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 56:
                    RzcChanganCX70SetFunc.this.uWinDelayTimeset(DataCanbus.DATA[updateCode]);
                    break;
                case 57:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext14)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 58:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext15)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 59:
                    RzcChanganCX70SetFunc.this.uDianlabaVolset(DataCanbus.DATA[updateCode]);
                    break;
                case 60:
                    RzcChanganCX70SetFunc.this.uUnlockrecvset(DataCanbus.DATA[updateCode]);
                    break;
                case 61:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext20)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 62:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext21)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 63:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext23)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 64:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext22)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 65:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext25)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 66:
                    RzcChanganCX70SetFunc.this.uAimsBeep(DataCanbus.DATA[updateCode]);
                    break;
                case 67:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext26)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 68:
                    RzcChanganCX70SetFunc.this.uAnticollisionWarnSensor(DataCanbus.DATA[updateCode]);
                    break;
                case 69:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext27)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 70:
                    RzcChanganCX70SetFunc.this.uLaneAssistSensor(DataCanbus.DATA[updateCode]);
                    break;
                case 71:
                    RzcChanganCX70SetFunc.this.uLaneFunctionSel(DataCanbus.DATA[updateCode]);
                    break;
                case 72:
                    RzcChanganCX70SetFunc.this.uLaneAssistWarnType(DataCanbus.DATA[updateCode]);
                    break;
                case 73:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext28)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 74:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext29)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 75:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext31)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 76:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext32)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 77:
                    RzcChanganCX70SetFunc.this.uLightAtmosphereLev(DataCanbus.DATA[updateCode]);
                    break;
                case 78:
                    RzcChanganCX70SetFunc.this.uLaneAssistVibration(DataCanbus.DATA[updateCode]);
                    break;
                case 79:
                    RzcChanganCX70SetFunc.this.uLaneAssistSpeedWarnDeviation(DataCanbus.DATA[updateCode]);
                    break;
                case 80:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext30)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 81:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext33)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 82:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext34)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 83:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext35)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 84:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext36)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 85:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext37)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 86:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext38)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 87:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext39)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 88:
                    RzcChanganCX70SetFunc.this.uLaneAtmosphere(DataCanbus.DATA[updateCode]);
                    break;
                case 89:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext42)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 90:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext43)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 91:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext46)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 92:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext24)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 93:
                    RzcChanganCX70SetFunc.this.uLaneAtmosphereAutoType(DataCanbus.DATA[updateCode]);
                    break;
                case 94:
                    RzcChanganCX70SetFunc.this.uLaneMeterVolume(DataCanbus.DATA[updateCode]);
                    break;
                case 95:
                    RzcChanganCX70SetFunc.this.uLaneMeterTheme(DataCanbus.DATA[updateCode]);
                    break;
                case 96:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext1)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 97:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext3)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 98:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext4)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 99:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext5)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 100:
                    switch (DataCanbus.DATA[updateCode]) {
                        case 1:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.str_driving_comfort);
                            break;
                        case 2:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.str_driving_sport);
                            break;
                        case 3:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.str_driving_eco);
                            break;
                    }
                case 101:
                    switch (DataCanbus.DATA[updateCode]) {
                        case 1:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.str_driving_comfort);
                            break;
                        case 2:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.str_driving_sport);
                            break;
                        case 3:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.str_light_state);
                            break;
                    }
                case 102:
                    switch (DataCanbus.DATA[updateCode]) {
                        case 1:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.rzc_c4l_close);
                            break;
                        case 2:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.str_breathable_state);
                            break;
                        case 3:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.rzc_c4l_open);
                            break;
                    }
                case 103:
                    switch (DataCanbus.DATA[updateCode]) {
                        case 1:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.str_driving_comfort);
                            break;
                        case 2:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.str_driving_sport);
                            break;
                        case 3:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.str_driving_eco);
                            break;
                        case 4:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.wc_17zhinanzhe_str1);
                            break;
                    }
                case 104:
                    switch (DataCanbus.DATA[updateCode]) {
                        case 1:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                            break;
                        case 2:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.driver_system_standard);
                            break;
                        case 3:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.wc_17zhinanzhe_str1);
                            break;
                    }
                case 105:
                    switch (DataCanbus.DATA[updateCode]) {
                        case 1:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text6)).setText("6:30");
                            break;
                        case 2:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text6)).setText("7:00");
                            break;
                        case 3:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text6)).setText("7:30");
                            break;
                        case 4:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text6)).setText("8:00");
                            break;
                        case 5:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text6)).setText("8:30");
                            break;
                        case 6:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text6)).setText("9:00");
                            break;
                        case 7:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text6)).setText("9:30");
                            break;
                        case 8:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text6)).setText("10:00");
                            break;
                        case 9:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text6)).setText("10:30");
                            break;
                        case 10:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text6)).setText("11:00");
                            break;
                        case 11:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text6)).setText("11:30");
                            break;
                        case 12:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text6)).setText("12:00");
                            break;
                    }
                case 106:
                    switch (DataCanbus.DATA[updateCode]) {
                        case 1:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text7)).setText("12:30");
                            break;
                        case 2:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text7)).setText("13:00");
                            break;
                        case 3:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text7)).setText("13:30");
                            break;
                        case 4:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text7)).setText("14:00");
                            break;
                        case 5:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text7)).setText("14:30");
                            break;
                        case 6:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text7)).setText("15:00");
                            break;
                        case 7:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text7)).setText("15:30");
                            break;
                        case 8:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text7)).setText("16:00");
                            break;
                        case 9:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text7)).setText("16:30");
                            break;
                        case 10:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text7)).setText("17:00");
                            break;
                        case 11:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text7)).setText("17:30");
                            break;
                        case 12:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text7)).setText("18:00");
                            break;
                        case 13:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text7)).setText("18:30");
                            break;
                    }
                case 107:
                    switch (DataCanbus.DATA[updateCode]) {
                        case 1:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text8)).setText("19:00");
                            break;
                        case 2:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text8)).setText("19:30");
                            break;
                        case 3:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text8)).setText("20:00");
                            break;
                        case 4:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text8)).setText("20:30");
                            break;
                        case 5:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text8)).setText("21:00");
                            break;
                        case 6:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text8)).setText("21:30");
                            break;
                        case 7:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text8)).setText("22:00");
                            break;
                        case 8:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text8)).setText("22:30");
                            break;
                    }
                case 108:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext6)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 109:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext7)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 110:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext8)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 111:
                    switch (DataCanbus.DATA[updateCode]) {
                        case 1:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text29)).setText(R.string.str_airmanual);
                            break;
                        default:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text29)).setText(R.string.str_airauto);
                            break;
                    }
                case 112:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext51)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 113:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext47)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 114:
                    switch (DataCanbus.DATA[updateCode]) {
                        case 1:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text30)).setText("30s");
                            break;
                        case 2:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text30)).setText("60s");
                            break;
                        case 3:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text30)).setText("120s");
                            break;
                        default:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text30)).setText(R.string.off);
                            break;
                    }
                case 115:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext48)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 116:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext49)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 117:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext50)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 125:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext52)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 126:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext53)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_0439_rzc_changan_cx70);
        initView();
        setupView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initLauStyle() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View layout = inflater.inflate(R.layout.layout_lauguage, (ViewGroup) null);
        this.mLauStyle = new PopupWindow(layout, 548, 408);
        this.mLauStyle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bk_models_pop));
        this.mLauStyle.setFocusable(true);
        this.mLauStyle.setTouchable(true);
        this.mLauStyle.setOutsideTouchable(true);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                RzcChanganCX70SetFunc.this.language_set = position;
                if (RzcChanganCX70SetFunc.this.language_set >= 0 && RzcChanganCX70SetFunc.this.language_set <= RzcChanganCX70SetFunc.this.mLauStylelist.size() && RzcChanganCX70SetFunc.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(0, new int[]{131, 57, RzcChanganCX70SetFunc.this.send_lang[RzcChanganCX70SetFunc.this.language_set]}, null, null);
                }
                RzcChanganCX70SetFunc.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(this.language_set, true);
        }
    }

    public void initView() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.send_lang = new int[]{1, 2};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RzcChanganCX70SetFunc.this.mLauStyle == null) {
                    RzcChanganCX70SetFunc.this.initLauStyle();
                }
                if (RzcChanganCX70SetFunc.this.mLauStyle != null && RzcChanganCX70SetFunc.this.mPopShowView != null) {
                    RzcChanganCX70SetFunc.this.mLauStyle.showAtLocation(RzcChanganCX70SetFunc.this.mPopShowView, 17, 0, 0);
                    RzcChanganCX70SetFunc.this.updateLauguageSet();
                }
            }
        });
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view60).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
        findViewById(R.id.layout_view5).setVisibility(8);
        findViewById(R.id.layout_view81).setVisibility(8);
        findViewById(R.id.layout_view82).setVisibility(8);
        findViewById(R.id.layout_text_view2).setVisibility(8);
        findViewById(R.id.layout_view6).setVisibility(8);
        findViewById(R.id.layout_view7).setVisibility(8);
        findViewById(R.id.layout_view8).setVisibility(8);
        findViewById(R.id.layout_view74).setVisibility(8);
        findViewById(R.id.layout_text_view3).setVisibility(8);
        findViewById(R.id.layout_view9).setVisibility(8);
        findViewById(R.id.layout_view10).setVisibility(8);
        findViewById(R.id.layout_view11).setVisibility(8);
        findViewById(R.id.layout_view12).setVisibility(8);
        findViewById(R.id.layout_view13).setVisibility(8);
        findViewById(R.id.layout_view14).setVisibility(8);
        findViewById(R.id.layout_view15).setVisibility(8);
        findViewById(R.id.layout_view16).setVisibility(8);
        findViewById(R.id.layout_view17).setVisibility(8);
        findViewById(R.id.layout_view59).setVisibility(8);
        findViewById(R.id.layout_text_view4).setVisibility(8);
        findViewById(R.id.layout_view18).setVisibility(8);
        findViewById(R.id.layout_view19).setVisibility(8);
        findViewById(R.id.layout_view20).setVisibility(8);
        findViewById(R.id.layout_view21).setVisibility(8);
        findViewById(R.id.layout_view22).setVisibility(8);
        findViewById(R.id.layout_view68).setVisibility(8);
        findViewById(R.id.layout_view69).setVisibility(8);
        findViewById(R.id.layout_view70).setVisibility(8);
        findViewById(R.id.layout_view71).setVisibility(8);
        findViewById(R.id.layout_view79).setVisibility(8);
        findViewById(R.id.layout_text_view5).setVisibility(8);
        findViewById(R.id.layout_view23).setVisibility(8);
        findViewById(R.id.layout_view24).setVisibility(8);
        findViewById(R.id.layout_view25).setVisibility(8);
        findViewById(R.id.layout_view26).setVisibility(8);
        findViewById(R.id.layout_view27).setVisibility(8);
        findViewById(R.id.layout_view28).setVisibility(8);
        findViewById(R.id.layout_view29).setVisibility(8);
        findViewById(R.id.layout_view30).setVisibility(8);
        findViewById(R.id.layout_view31).setVisibility(8);
        findViewById(R.id.layout_view72).setVisibility(8);
        findViewById(R.id.layout_view73).setVisibility(8);
        findViewById(R.id.layout_view75).setVisibility(8);
        findViewById(R.id.layout_view76).setVisibility(8);
        findViewById(R.id.layout_view80).setVisibility(8);
        findViewById(R.id.layout_text_view6).setVisibility(8);
        findViewById(R.id.layout_view32).setVisibility(8);
        findViewById(R.id.layout_view33).setVisibility(8);
        findViewById(R.id.layout_view34).setVisibility(8);
        findViewById(R.id.layout_view35).setVisibility(8);
        findViewById(R.id.layout_view36).setVisibility(8);
        findViewById(R.id.layout_text_view7).setVisibility(8);
        findViewById(R.id.layout_view37).setVisibility(8);
        findViewById(R.id.layout_view38).setVisibility(8);
        findViewById(R.id.layout_text_view8).setVisibility(8);
        findViewById(R.id.layout_view39).setVisibility(8);
        findViewById(R.id.layout_view40).setVisibility(8);
        findViewById(R.id.layout_view41).setVisibility(8);
        findViewById(R.id.layout_text_view9).setVisibility(8);
        findViewById(R.id.layout_view42).setVisibility(8);
        findViewById(R.id.layout_view43).setVisibility(8);
        findViewById(R.id.layout_view44).setVisibility(8);
        findViewById(R.id.layout_view45).setVisibility(8);
        findViewById(R.id.layout_view46).setVisibility(8);
        findViewById(R.id.layout_view47).setVisibility(8);
        findViewById(R.id.layout_view48).setVisibility(8);
        findViewById(R.id.layout_view49).setVisibility(8);
        findViewById(R.id.layout_text_view10).setVisibility(8);
        findViewById(R.id.layout_view50).setVisibility(8);
        findViewById(R.id.layout_view51).setVisibility(8);
        findViewById(R.id.layout_text_view11).setVisibility(8);
        findViewById(R.id.layout_view52).setVisibility(8);
        findViewById(R.id.layout_view53).setVisibility(8);
        findViewById(R.id.layout_view54).setVisibility(8);
        findViewById(R.id.layout_view55).setVisibility(8);
        findViewById(R.id.layout_text_view12).setVisibility(8);
        findViewById(R.id.layout_view56).setVisibility(8);
        findViewById(R.id.layout_view57).setVisibility(8);
        findViewById(R.id.layout_view58).setVisibility(8);
        findViewById(R.id.layout_text_view13).setVisibility(8);
        findViewById(R.id.layout_view61).setVisibility(8);
        findViewById(R.id.layout_view62).setVisibility(8);
        findViewById(R.id.layout_view63).setVisibility(8);
        findViewById(R.id.layout_text_view14).setVisibility(8);
        findViewById(R.id.layout_view64).setVisibility(8);
        findViewById(R.id.layout_view65).setVisibility(8);
        findViewById(R.id.layout_text_view15).setVisibility(8);
        findViewById(R.id.layout_view66).setVisibility(8);
        findViewById(R.id.layout_view67).setVisibility(8);
        findViewById(R.id.layout_text_view16).setVisibility(8);
        findViewById(R.id.layout_view77).setVisibility(8);
        findViewById(R.id.layout_view78).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_452_RZC_ChangAn_CS15_19 /* 262596 */:
                findViewById(R.id.layout_view60).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view59).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                return;
            case FinalCanbus.CAR_452_RZC_ChangAn_Oushangx7_20 /* 328132 */:
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_text_view9).setVisibility(0);
                findViewById(R.id.layout_view43).setVisibility(0);
                findViewById(R.id.layout_view44).setVisibility(0);
                findViewById(R.id.layout_view49).setVisibility(0);
                findViewById(R.id.layout_text_view13).setVisibility(0);
                findViewById(R.id.layout_view61).setVisibility(0);
                findViewById(R.id.layout_view62).setVisibility(0);
                findViewById(R.id.layout_view63).setVisibility(0);
                findViewById(R.id.layout_text_view14).setVisibility(0);
                findViewById(R.id.layout_view64).setVisibility(0);
                findViewById(R.id.layout_view65).setVisibility(0);
                findViewById(R.id.layout_text_view15).setVisibility(0);
                findViewById(R.id.layout_view66).setVisibility(0);
                findViewById(R.id.layout_view67).setVisibility(0);
                return;
            case FinalCanbus.CAR_452_RZC_ChangAn_Yidong_19 /* 393668 */:
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                return;
            case FinalCanbus.CAR_452_RZC_ChangAn_CS35_19PLUS /* 1376708 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view68).setVisibility(0);
                findViewById(R.id.layout_view69).setVisibility(0);
                findViewById(R.id.layout_view70).setVisibility(0);
                findViewById(R.id.layout_view71).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                return;
            case FinalCanbus.CAR_453_RZC_Changan_Lumin_22 /* 3408325 */:
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view79).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view75).setVisibility(0);
                findViewById(R.id.layout_view76).setVisibility(0);
                findViewById(R.id.layout_text_view16).setVisibility(0);
                findViewById(R.id.layout_view77).setVisibility(0);
                findViewById(R.id.layout_view78).setVisibility(0);
                return;
            case FinalCanbus.CAR_453_RZC_Changan_CS15_EPro_21 /* 3473861 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view59).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view80).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view34).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view36).setVisibility(0);
                return;
            case FinalCanbus.CAR_453_RZC_Changan_RAETON_CC_21 /* 3539397 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view81).setVisibility(0);
                findViewById(R.id.layout_view82).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                return;
            case FinalCanbus.CAR_452_RZC_ChangAn_19OuShang /* 4719044 */:
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view74).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view29).setVisibility(0);
                findViewById(R.id.layout_view72).setVisibility(0);
                findViewById(R.id.layout_view73).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_text_view12).setVisibility(0);
                findViewById(R.id.layout_view56).setVisibility(0);
                findViewById(R.id.layout_view57).setVisibility(0);
                findViewById(R.id.layout_view58).setVisibility(0);
                return;
            case FinalCanbus.CAR_439_RZC_Changan_19Yuexiang /* 11469239 */:
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view59).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                return;
            case FinalCanbus.CAR_452_RZC_ChangAn_Oushang_Changxing /* 11469252 */:
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                return;
            default:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view29).setVisibility(0);
                findViewById(R.id.layout_view30).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view34).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view36).setVisibility(0);
                findViewById(R.id.layout_text_view7).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_text_view8).setVisibility(0);
                findViewById(R.id.layout_view39).setVisibility(0);
                findViewById(R.id.layout_view40).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_text_view9).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                findViewById(R.id.layout_view43).setVisibility(0);
                findViewById(R.id.layout_view44).setVisibility(0);
                findViewById(R.id.layout_view45).setVisibility(0);
                findViewById(R.id.layout_view46).setVisibility(0);
                findViewById(R.id.layout_view47).setVisibility(0);
                findViewById(R.id.layout_view48).setVisibility(0);
                findViewById(R.id.layout_view49).setVisibility(0);
                findViewById(R.id.layout_text_view10).setVisibility(0);
                findViewById(R.id.layout_view50).setVisibility(0);
                findViewById(R.id.layout_view51).setVisibility(0);
                findViewById(R.id.layout_text_view11).setVisibility(0);
                findViewById(R.id.layout_view52).setVisibility(0);
                findViewById(R.id.layout_view53).setVisibility(0);
                findViewById(R.id.layout_view54).setVisibility(0);
                findViewById(R.id.layout_view55).setVisibility(0);
                findViewById(R.id.layout_text_view12).setVisibility(0);
                findViewById(R.id.layout_view56).setVisibility(0);
                findViewById(R.id.layout_view57).setVisibility(0);
                findViewById(R.id.layout_view58).setVisibility(0);
                return;
        }
    }

    private void setupView() {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.4
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int i = DataCanbus.DATA[96];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 59, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.5
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    RzcChanganCX70SetFunc.this.ShoeRestoreTireSetDialog();
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.6
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int i = DataCanbus.DATA[97];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 60, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.7
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int i = DataCanbus.DATA[98];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 61, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.8
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int i = DataCanbus.DATA[99];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 62, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.9
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int i = DataCanbus.DATA[108];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 71, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.10
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int i = DataCanbus.DATA[109];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 72, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.11
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int i = DataCanbus.DATA[110];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 73, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.12
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[41];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 3, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext10)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.13
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[42];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 4, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext11)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.14
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[43];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 5, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext12)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.15
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[44];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 6, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext13)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.16
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[54];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 16, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext14)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.17
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[57];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 19, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext15)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.18
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[58];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 20, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext16)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.19
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[45];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 7, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext17)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext17)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.20
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[46];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 8, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext18)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext18)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.21
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[47];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 9, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext19)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext19)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.22
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[55];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 17, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext20)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext20)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.23
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[61];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 23, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext21)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext21)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.24
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[62];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 24, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext22)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext22)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.25
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[64];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 26, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext23)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext23)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.26
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[63];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 25, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext24)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext24)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.27
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[92];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 54, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext25)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext25)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.28
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[65];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 27, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext26)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext26)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.29
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[67];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 29, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext27)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext27)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.30
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[69];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 31, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext28)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext28)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.31
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[73];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 35, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext29)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext29)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.32
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[74];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 36, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext30)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext30)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.33
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[80];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 42, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext31)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext31)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.34
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[75];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 37, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext32)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext32)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.35
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[76];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 38, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext33)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext33)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.36
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[81];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 43, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext34)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext34)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.37
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[82];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 44, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext35)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext35)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.38
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[83];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 45, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext36)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext36)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.39
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[84];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 46, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext37)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext37)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.40
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[85];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 47, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext38)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext38)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.41
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[86];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 48, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext39)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext39)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.42
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[87];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 49, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext40)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext40)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.43
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    RzcChanganCX70SetFunc.this.ShoeRestoreCarSetDialog();
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext41)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext41)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.44
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[37] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext42)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext42)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.45
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[89];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 51, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext43)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext43)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.46
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[90];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 52, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext44)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext44)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.47
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[38];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 1, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext45)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext45)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.48
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[40];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 2, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext46)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext46)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.49
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[91];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 53, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext47)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext47)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.50
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[113];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 75, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext48)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext48)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.51
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[115];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 77, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext49)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext49)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.52
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[116];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 78, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext50)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext50)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.53
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[117];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 79, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext51)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext51)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.54
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[112];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 74, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext52)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext52)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.55
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[125];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 80, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext53)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext53)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.56
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[126];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 81, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus1)) != null) {
            ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.57
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[100] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 63, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus1)) != null) {
            ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.58
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[100] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 63, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus2)) != null) {
            ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.59
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[101] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 64, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus2)) != null) {
            ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.60
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[101] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 64, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus3)) != null) {
            ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.61
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[102] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 65, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus3)) != null) {
            ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.62
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[102] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 65, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus4)) != null) {
            ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.63
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[103] - 1;
                    if (temp < 1) {
                        temp = 4;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 66, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus4)) != null) {
            ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.64
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[103] + 1;
                    if (temp > 4) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 66, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus5)) != null) {
            ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.65
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[104] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 67, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus5)) != null) {
            ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.66
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[104] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 67, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus6)) != null) {
            ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.67
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[105] - 1;
                    if (temp < 1) {
                        temp = 12;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 68, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus6)) != null) {
            ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.68
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[105] + 1;
                    if (temp > 12) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 68, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus7)) != null) {
            ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.69
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[106] - 1;
                    if (temp < 1) {
                        temp = 13;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 69, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus7)) != null) {
            ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.70
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[106] + 1;
                    if (temp > 13) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 69, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus8)) != null) {
            ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.71
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[107] - 1;
                    if (temp < 1) {
                        temp = 8;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 70, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus8)) != null) {
            ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.72
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[107] + 1;
                    if (temp > 8) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 70, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus9)) != null) {
            ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.73
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[56] - 1;
                    if (temp < 0) {
                        temp = 4;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 18, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus9)) != null) {
            ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.74
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[56] + 1;
                    if (temp > 4) {
                        temp = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 18, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus10)) != null) {
            ((Button) findViewById(R.id.btn_minus10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.75
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[60] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 22, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus10)) != null) {
            ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.76
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[60] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 22, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus11)) != null) {
            ((Button) findViewById(R.id.btn_minus11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.77
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    RzcChanganCX70SetFunc.this.FrontLightDelayMode(-1);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus11)) != null) {
            ((Button) findViewById(R.id.btn_plus11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.78
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    RzcChanganCX70SetFunc.this.FrontLightDelayMode(1);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus12)) != null) {
            ((Button) findViewById(R.id.btn_minus12)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.79
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    RzcChanganCX70SetFunc.this.OnekeyturnMode(-1);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus12)) != null) {
            ((Button) findViewById(R.id.btn_plus12)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.80
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    RzcChanganCX70SetFunc.this.OnekeyturnMode(1);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus13)) != null) {
            ((Button) findViewById(R.id.btn_minus13)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.81
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[77] - 1;
                    if (temp < 0) {
                        temp = 6;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 39, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus13)) != null) {
            ((Button) findViewById(R.id.btn_plus13)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.82
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[77] + 1;
                    if (temp > 6) {
                        temp = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 39, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus14)) != null) {
            ((Button) findViewById(R.id.btn_minus14)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.83
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[88];
                    if (temp > 1) {
                        temp--;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 50, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus14)) != null) {
            ((Button) findViewById(R.id.btn_plus14)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.84
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[88];
                    if (temp < 7) {
                        temp++;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 50, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus15)) != null) {
            ((Button) findViewById(R.id.btn_minus15)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.85
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[93];
                    if (temp > 1) {
                        temp--;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 55, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus15)) != null) {
            ((Button) findViewById(R.id.btn_plus15)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.86
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[93];
                    if (temp < 2) {
                        temp++;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 55, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus16)) != null) {
            ((Button) findViewById(R.id.btn_minus16)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.87
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[51] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 13, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus16)) != null) {
            ((Button) findViewById(R.id.btn_plus16)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.88
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[51] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 13, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus17)) != null) {
            ((Button) findViewById(R.id.btn_minus17)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.89
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[52] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 14, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus17)) != null) {
            ((Button) findViewById(R.id.btn_plus17)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.90
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[52] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 14, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus18)) != null) {
            ((Button) findViewById(R.id.btn_minus18)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.91
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[53] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 15, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus18)) != null) {
            ((Button) findViewById(R.id.btn_plus18)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.92
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[53] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 15, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus19)) != null) {
            ((Button) findViewById(R.id.btn_minus19)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.93
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[59] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 21, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus19)) != null) {
            ((Button) findViewById(R.id.btn_plus19)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.94
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[59] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 21, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus20)) != null) {
            ((Button) findViewById(R.id.btn_minus20)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.95
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[94];
                    if (temp > 1) {
                        temp--;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 56, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus20)) != null) {
            ((Button) findViewById(R.id.btn_plus20)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.96
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[94];
                    if (temp < 3) {
                        temp++;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 56, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus21)) != null) {
            ((Button) findViewById(R.id.btn_minus21)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.97
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[66] - 1;
                    if (temp < 0) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 28, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus21)) != null) {
            ((Button) findViewById(R.id.btn_plus21)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.98
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[66] + 1;
                    if (temp > 3) {
                        temp = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 28, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus22)) != null) {
            ((Button) findViewById(R.id.btn_minus22)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.99
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[68] - 1;
                    if (temp < 0) {
                        temp = 2;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 30, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus22)) != null) {
            ((Button) findViewById(R.id.btn_plus22)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.100
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[68] + 1;
                    if (temp > 2) {
                        temp = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 30, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus23)) != null) {
            ((Button) findViewById(R.id.btn_minus23)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.101
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[70] - 1;
                    if (temp < 0) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 32, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus23)) != null) {
            ((Button) findViewById(R.id.btn_plus23)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.102
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[70] + 1;
                    if (temp > 1) {
                        temp = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 32, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus24)) != null) {
            ((Button) findViewById(R.id.btn_minus24)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.103
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[71] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 33, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus24)) != null) {
            ((Button) findViewById(R.id.btn_plus24)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.104
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[71] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 33, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus25)) != null) {
            ((Button) findViewById(R.id.btn_minus25)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.105
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[72] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 34, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus25)) != null) {
            ((Button) findViewById(R.id.btn_plus25)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.106
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[72] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 34, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus26)) != null) {
            ((Button) findViewById(R.id.btn_minus26)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.107
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[79];
                    if (temp > 0) {
                        temp--;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 41, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus26)) != null) {
            ((Button) findViewById(R.id.btn_plus26)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.108
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[79];
                    if (temp < 20) {
                        temp++;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 41, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus27)) != null) {
            ((Button) findViewById(R.id.btn_minus27)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.109
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[78] - 1;
                    if (temp < 0) {
                        temp = 2;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 40, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus27)) != null) {
            ((Button) findViewById(R.id.btn_plus27)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.110
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[78] + 1;
                    if (temp > 2) {
                        temp = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 40, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus28)) != null) {
            ((Button) findViewById(R.id.btn_minus28)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.111
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[95];
                    if (temp > 1) {
                        temp--;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 58, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus28)) != null) {
            ((Button) findViewById(R.id.btn_plus28)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.112
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[95];
                    if (temp < 4) {
                        temp++;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 58, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus29)) != null) {
            ((Button) findViewById(R.id.btn_minus29)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.113
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[111];
                    if (temp > 1) {
                        temp--;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 128, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus29)) != null) {
            ((Button) findViewById(R.id.btn_plus29)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.114
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[111];
                    if (temp < 2) {
                        temp++;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 128, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus30)) != null) {
            ((Button) findViewById(R.id.btn_minus30)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.115
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[114];
                    if (temp > 0) {
                        temp--;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 76, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus30)) != null) {
            ((Button) findViewById(R.id.btn_plus30)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.116
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[114];
                    if (temp < 3) {
                        temp++;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 76, temp}, null, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[37] & 255;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext41)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext41)).setChecked(value == 1);
        }
    }

    protected void OnekeyturnMode(int i) {
        int temp = DataCanbus.DATA[49];
        if (i < 0) {
            if (temp > 0) {
                temp--;
            }
        } else if (i > 0 && temp < 3) {
            temp++;
        }
        DataCanbus.PROXY.cmd(0, new int[]{131, 11, temp}, null, null);
    }

    protected void FrontLightDelayMode(int i) {
        int temp = DataCanbus.DATA[48];
        if (i < 0) {
            if (temp > 0) {
                temp--;
            }
        } else if (i > 0 && temp < 4) {
            temp++;
        }
        DataCanbus.PROXY.cmd(0, new int[]{131, 10, temp}, null, null);
    }

    protected void ShoeRestoreCarSetDialog() {
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(this);
        normalDialog.setTitle(R.string.str_gs4_setting0);
        normalDialog.setMessage(R.string.str_gs4_setting0);
        normalDialog.setPositiveButton(R.string.wc_psa_all_confirm, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.117
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                DataCanbus.PROXY.cmd(0, new int[]{131, 0, 1}, null, null);
            }
        });
        normalDialog.setNegativeButton(R.string.wc_psa_all_cancel, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.118
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        normalDialog.show();
    }

    protected void ShoeRestoreTireSetDialog() {
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(this);
        normalDialog.setTitle(R.string.bsd_klj_str15);
        normalDialog.setMessage(R.string.bsd_klj_str15);
        normalDialog.setPositiveButton(R.string.wc_psa_all_confirm, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.119
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                DataCanbus.PROXY.cmd(0, new int[]{131, 12, 1}, null, null);
            }
        });
        normalDialog.setNegativeButton(R.string.wc_psa_all_cancel, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc.120
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        normalDialog.show();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCheckedValue(int i) {
        return i == 1 ? 2 : 1;
    }

    protected void uLaneMeterTheme(int i) {
        switch (i) {
            case 1:
                ((TextView) findViewById(R.id.tv_text28)).setText(R.string.klc_air_auto);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text28)).setText(R.string.str_252_sound_selection1);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text28)).setText(R.string.driver_system_sports);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text28)).setText(R.string.str_science);
                break;
        }
    }

    protected void uLaneMeterVolume(int i) {
        switch (i) {
            case 1:
                ((TextView) findViewById(R.id.tv_text20)).setText(R.string.klc_air_low);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text20)).setText(R.string.klc_air_middle);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text20)).setText(R.string.klc_air_high);
                break;
        }
    }

    protected void uLaneAtmosphereAutoType(int i) {
        switch (i) {
            case 1:
                ((TextView) findViewById(R.id.tv_text15)).setText(R.string.str_dim_during_driving);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text15)).setText(R.string.str_off_during_driving);
                break;
        }
    }

    protected void uLaneAtmosphere(int i) {
        switch (i) {
            case 1:
                ((TextView) findViewById(R.id.tv_text14)).setText(R.string.str_403_ambient_3);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text14)).setText(R.string.str_403_ambient_6);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text14)).setText(R.string.str_background_blue);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text14)).setText(R.string.color_white_str);
                break;
            case 5:
                ((TextView) findViewById(R.id.tv_text14)).setText(R.string.color_orange_str);
                break;
            case 6:
                ((TextView) findViewById(R.id.tv_text14)).setText(R.string.color_mediumblue_str);
                break;
            case 7:
                ((TextView) findViewById(R.id.tv_text14)).setText(R.string.str_background_green);
                break;
        }
    }

    protected void uLaneAssistSpeedWarnDeviation(int i) {
        if (i >= 10) {
            ((TextView) findViewById(R.id.tv_text26)).setText(String.valueOf(i - 10) + "km/h");
        } else {
            ((TextView) findViewById(R.id.tv_text26)).setText("-" + (10 - i) + "km/h");
        }
    }

    protected void uLaneAssistVibration(int i) {
        switch (i) {
            case 0:
                ((TextView) findViewById(R.id.tv_text27)).setText("高");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text27)).setText("标准");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text27)).setText("低");
                break;
        }
    }

    protected void uLightAtmosphereLev(int i) {
        ((TextView) findViewById(R.id.tv_text13)).setText(new StringBuilder().append(i).toString());
    }

    protected void uLaneAssistWarnType(int i) {
        switch (i) {
            case 1:
                ((TextView) findViewById(R.id.tv_text25)).setText("声音");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text25)).setText("振动");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text25)).setText("声音+振动");
                break;
        }
    }

    protected void uLaneFunctionSel(int i) {
        switch (i) {
            case 1:
                ((TextView) findViewById(R.id.tv_text24)).setText("仅预警");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text24)).setText("仅纠偏");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text24)).setText("预警+纠偏");
                break;
        }
    }

    protected void uLaneAssistSensor(int i) {
        switch (i) {
            case 0:
                ((TextView) findViewById(R.id.tv_text23)).setText("高");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text23)).setText("标准");
                break;
        }
    }

    protected void uAnticollisionWarnSensor(int i) {
        switch (i) {
            case 0:
                ((TextView) findViewById(R.id.tv_text22)).setText("高");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text22)).setText("标准");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text22)).setText("低");
                break;
        }
    }

    protected void uAimsBeep(int i) {
        switch (i) {
            case 0:
                ((TextView) findViewById(R.id.tv_text21)).setText("关闭");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text21)).setText("仅识别提示");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text21)).setText("仅消失提示");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text21)).setText("识别和消失均提示");
                break;
        }
    }

    protected void uYingBingVolset(int i) {
        ((TextView) findViewById(R.id.tv_text16)).setText("声音" + i);
    }

    protected void uTishiVolset(int i) {
        ((TextView) findViewById(R.id.tv_text17)).setText("声音" + i);
    }

    protected void uBaojingVolset(int i) {
        ((TextView) findViewById(R.id.tv_text18)).setText("声音" + i);
    }

    protected void uWinDelayTimeset(int i) {
        switch (i) {
            case 0:
                ((TextView) findViewById(R.id.tv_text9)).setText("关闭");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text9)).setText("30秒");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text9)).setText("60秒");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text9)).setText("90秒");
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text9)).setText("120秒");
                break;
        }
    }

    protected void uDianlabaVolset(int i) {
        switch (i) {
            case 1:
                ((TextView) findViewById(R.id.tv_text19)).setText("寻车和门未关闭锁");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text19)).setText("寻车");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text19)).setText("门未关闭锁");
                break;
        }
    }

    protected void uUnlockrecvset(int i) {
        switch (i) {
            case 1:
                ((TextView) findViewById(R.id.tv_text10)).setText("灯光+声音");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text10)).setText("灯光");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text10)).setText("声音");
                break;
        }
    }

    protected void uLightOnKeyTurn(int i) {
        switch (i) {
            case 1:
                ((TextView) findViewById(R.id.tv_text12)).setText("3 times");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text12)).setText("5 times");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text12)).setText("7 times");
                break;
            default:
                ((TextView) findViewById(R.id.tv_text12)).setText(R.string.jeep_comfortsystems_0);
                break;
        }
    }

    protected void uLightFrontDelay(int i) {
        switch (i) {
            case 1:
                ((TextView) findViewById(R.id.tv_text11)).setText("10s");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text11)).setText("30s");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text11)).setText("60s");
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text11)).setText("120s");
                break;
            default:
                ((TextView) findViewById(R.id.tv_text11)).setText(R.string.jeep_comfortsystems_0);
                break;
        }
    }

    protected void uAirAutoDry(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext18)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext18)).setChecked(i == 1);
        }
    }

    protected void uOpenWindowToWind(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext17)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext17)).setChecked(i == 1);
        }
    }

    protected void uAutoAir(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext16)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setChecked(i == 1);
        }
    }

    protected void uCloseTopWindow(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext12)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setChecked(i == 1);
        }
    }

    protected void uAccOffLock(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext11)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked(i == 1);
        }
    }

    protected void uDriveLock(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext10)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(i == 1);
        }
    }

    protected void uRemoteUnlock(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(i == 1);
        }
    }

    protected void uBackRainAssist(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext45)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext45)).setChecked(i == 1);
        }
    }

    protected void uFoldRearMirror(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext44)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext44)).setChecked(i == 1);
        }
    }
}
