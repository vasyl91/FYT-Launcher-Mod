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

@SuppressWarnings({"deprecation", "unchecked"})
public class RzcChanganCX70SetFunc extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 114:
                    RzcChanganCX70SetFunc.this.mUpdaterValue8();
                    break;
                case 115:
                    RzcChanganCX70SetFunc.this.uFoldRearMirror(DataCanbus.DATA[updateCode]);
                    break;
                case 117:
                    RzcChanganCX70SetFunc.this.uBackRainAssist(DataCanbus.DATA[updateCode]);
                    break;
                case 118:
                    RzcChanganCX70SetFunc.this.uRemoteUnlock(DataCanbus.DATA[updateCode]);
                    break;
                case 119:
                    RzcChanganCX70SetFunc.this.uDriveLock(DataCanbus.DATA[updateCode]);
                    break;
                case 120:
                    RzcChanganCX70SetFunc.this.uAccOffLock(DataCanbus.DATA[updateCode]);
                    break;
                case 121:
                    RzcChanganCX70SetFunc.this.uCloseTopWindow(DataCanbus.DATA[updateCode]);
                    break;
                case 122:
                    RzcChanganCX70SetFunc.this.uAutoAir(DataCanbus.DATA[updateCode]);
                    break;
                case 123:
                    RzcChanganCX70SetFunc.this.uOpenWindowToWind(DataCanbus.DATA[updateCode]);
                    break;
                case 124:
                    RzcChanganCX70SetFunc.this.uAirAutoDry(DataCanbus.DATA[updateCode]);
                    break;
                case 125:
                    RzcChanganCX70SetFunc.this.uLightFrontDelay(DataCanbus.DATA[updateCode]);
                    break;
                case 126:
                    RzcChanganCX70SetFunc.this.uLightOnKeyTurn(DataCanbus.DATA[updateCode]);
                    break;
                case 128:
                    RzcChanganCX70SetFunc.this.uYingBingVolset(DataCanbus.DATA[updateCode]);
                    break;
                case 129:
                    RzcChanganCX70SetFunc.this.uTishiVolset(DataCanbus.DATA[updateCode]);
                    break;
                case 130:
                    RzcChanganCX70SetFunc.this.uBaojingVolset(DataCanbus.DATA[updateCode]);
                    break;
                case 131:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext13)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 132:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext19)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 133:
                    RzcChanganCX70SetFunc.this.uWinDelayTimeset(DataCanbus.DATA[updateCode]);
                    break;
                case 134:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext14)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 135:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext15)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 136:
                    RzcChanganCX70SetFunc.this.uDianlabaVolset(DataCanbus.DATA[updateCode]);
                    break;
                case 137:
                    RzcChanganCX70SetFunc.this.uUnlockrecvset(DataCanbus.DATA[updateCode]);
                    break;
                case 138:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext20)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 139:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext21)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 140:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext23)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 141:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext22)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 142:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext25)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 143:
                    RzcChanganCX70SetFunc.this.uAimsBeep(DataCanbus.DATA[updateCode]);
                    break;
                case 144:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext26)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 145:
                    RzcChanganCX70SetFunc.this.uAnticollisionWarnSensor(DataCanbus.DATA[updateCode]);
                    break;
                case 146:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext27)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 147:
                    RzcChanganCX70SetFunc.this.uLaneAssistSensor(DataCanbus.DATA[updateCode]);
                    break;
                case 148:
                    RzcChanganCX70SetFunc.this.uLaneFunctionSel(DataCanbus.DATA[updateCode]);
                    break;
                case 149:
                    RzcChanganCX70SetFunc.this.uLaneAssistWarnType(DataCanbus.DATA[updateCode]);
                    break;
                case 150:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext28)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 151:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext29)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 152:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext31)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 153:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext32)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 154:
                    RzcChanganCX70SetFunc.this.uLightAtmosphereLev(DataCanbus.DATA[updateCode]);
                    break;
                case 155:
                    RzcChanganCX70SetFunc.this.uLaneAssistVibration(DataCanbus.DATA[updateCode]);
                    break;
                case 156:
                    RzcChanganCX70SetFunc.this.uLaneAssistSpeedWarnDeviation(DataCanbus.DATA[updateCode]);
                    break;
                case 157:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext30)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 158:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext33)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 159:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext34)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 160:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext35)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 161:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext36)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 162:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext37)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 163:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext38)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 164:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext39)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 165:
                    RzcChanganCX70SetFunc.this.uLaneAtmosphere(DataCanbus.DATA[updateCode]);
                    break;
                case 166:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext42)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 167:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext43)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 168:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext46)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 169:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext24)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 170:
                    RzcChanganCX70SetFunc.this.uLaneAtmosphereAutoType(DataCanbus.DATA[updateCode]);
                    break;
                case 171:
                    RzcChanganCX70SetFunc.this.uLaneMeterVolume(DataCanbus.DATA[updateCode]);
                    break;
                case 172:
                    RzcChanganCX70SetFunc.this.uLaneMeterTheme(DataCanbus.DATA[updateCode]);
                    break;
                case 173:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext1)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 174:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext3)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 175:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext4)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 176:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext5)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 177:
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
                case 178:
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
                case 179:
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
                case 180:
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
                case 181:
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
                case 182:
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
                case 183:
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
                case 184:
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
                case 185:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext6)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 186:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext7)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 187:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext8)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 188:
                    switch (DataCanbus.DATA[updateCode]) {
                        case 1:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text29)).setText(R.string.str_airmanual);
                            break;
                        default:
                            ((TextView) RzcChanganCX70SetFunc.this.findViewById(R.id.tv_text29)).setText(R.string.str_airauto);
                            break;
                    }
                case 189:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext51)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 190:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext47)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 191:
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
                case 192:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext48)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 193:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext49)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 194:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext50)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 202:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext52)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 203:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext53)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 204:
                    ((CheckedTextView) RzcChanganCX70SetFunc.this.findViewById(R.id.ctv_checkedtext54)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_0439_rzc_changan_cx70);
        initView();
        setupView();
    }

    
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
            @Override
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
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
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
            case FinalCanbus.CAR_454_RZC_Changan_Hunter_22_H /* 10092998 */:
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view59).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                return;
            case FinalCanbus.CAR_454_RZC_Changan_BenBen_22 /* 10158534 */:
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
                findViewById(R.id.layout_view15).setVisibility(0);
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
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int i = DataCanbus.DATA[173];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 59, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    RzcChanganCX70SetFunc.this.ShoeRestoreTireSetDialog();
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int i = DataCanbus.DATA[174];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 60, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int i = DataCanbus.DATA[175];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 61, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int i = DataCanbus.DATA[176];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 62, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int i = DataCanbus.DATA[185];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 71, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int i = DataCanbus.DATA[186];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 72, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int i = DataCanbus.DATA[187];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 73, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[118];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 3, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext10)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[119];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 4, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext11)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[120];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 5, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext12)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[121];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 6, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext13)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[131];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 16, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext14)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[134];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 19, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext15)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[135];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 20, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext16)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[122];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 7, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext17)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext17)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[123];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 8, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext18)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext18)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[124];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 9, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext19)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext19)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[132];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 17, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext20)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext20)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[138];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 23, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext21)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext21)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[139];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 24, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext22)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext22)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[141];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 26, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext23)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext23)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[140];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 25, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext24)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext24)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[169];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 54, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext25)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext25)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[142];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 27, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext26)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext26)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[144];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 29, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext27)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext27)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[146];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 31, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext28)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext28)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[150];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 35, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext29)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext29)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[151];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 36, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext30)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext30)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[157];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 42, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext31)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext31)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[152];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 37, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext32)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext32)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[153];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 38, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext33)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext33)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[158];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 43, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext34)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext34)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[159];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 44, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext35)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext35)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[160];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 45, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext36)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext36)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[161];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 46, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext37)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext37)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[162];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 47, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext38)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext38)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[163];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 48, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext39)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext39)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[164];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 49, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext40)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext40)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    RzcChanganCX70SetFunc.this.ShoeRestoreCarSetDialog();
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext41)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext41)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[114] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext42)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext42)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[166];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 51, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext43)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext43)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[167];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 52, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext44)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext44)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[115];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 1, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext45)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext45)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[117];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 2, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext46)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext46)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[168];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 53, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext47)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext47)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[190];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 75, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext48)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext48)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[192];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 77, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext49)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext49)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[193];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 78, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext50)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext50)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[194];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 79, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext51)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext51)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[189];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 74, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext52)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext52)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[202];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 80, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext53)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext53)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[203];
                    DataCanbus.PROXY.cmd(0, new int[]{131, 81, RzcChanganCX70SetFunc.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext54)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext54)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int value = DataCanbus.DATA[204];
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value != 0 ? 0 : 1;
                    remoteModuleProxy.cmd(6, iArr, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus1)) != null) {
            ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[177] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 63, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus1)) != null) {
            ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[177] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 63, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus2)) != null) {
            ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[178] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 64, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus2)) != null) {
            ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[178] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 64, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus3)) != null) {
            ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[179] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 65, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus3)) != null) {
            ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[179] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 65, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus4)) != null) {
            ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[180] - 1;
                    if (temp < 1) {
                        temp = 4;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 66, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus4)) != null) {
            ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[180] + 1;
                    if (temp > 4) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 66, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus5)) != null) {
            ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[181] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 67, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus5)) != null) {
            ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[181] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 67, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus6)) != null) {
            ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[182] - 1;
                    if (temp < 1) {
                        temp = 12;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 68, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus6)) != null) {
            ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[182] + 1;
                    if (temp > 12) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 68, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus7)) != null) {
            ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[183] - 1;
                    if (temp < 1) {
                        temp = 13;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 69, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus7)) != null) {
            ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[183] + 1;
                    if (temp > 13) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 69, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus8)) != null) {
            ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[184] - 1;
                    if (temp < 1) {
                        temp = 8;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 70, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus8)) != null) {
            ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[184] + 1;
                    if (temp > 8) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 70, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus9)) != null) {
            ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[133] - 1;
                    if (temp < 0) {
                        temp = 4;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 18, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus9)) != null) {
            ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[133] + 1;
                    if (temp > 4) {
                        temp = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 18, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus10)) != null) {
            ((Button) findViewById(R.id.btn_minus10)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[137] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 22, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus10)) != null) {
            ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[137] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 22, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus11)) != null) {
            ((Button) findViewById(R.id.btn_minus11)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    RzcChanganCX70SetFunc.this.FrontLightDelayMode(-1);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus11)) != null) {
            ((Button) findViewById(R.id.btn_plus11)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    RzcChanganCX70SetFunc.this.FrontLightDelayMode(1);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus12)) != null) {
            ((Button) findViewById(R.id.btn_minus12)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    RzcChanganCX70SetFunc.this.OnekeyturnMode(-1);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus12)) != null) {
            ((Button) findViewById(R.id.btn_plus12)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    RzcChanganCX70SetFunc.this.OnekeyturnMode(1);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus13)) != null) {
            ((Button) findViewById(R.id.btn_minus13)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[154] - 1;
                    if (temp < 0) {
                        temp = 6;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 39, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus13)) != null) {
            ((Button) findViewById(R.id.btn_plus13)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[154] + 1;
                    if (temp > 6) {
                        temp = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 39, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus14)) != null) {
            ((Button) findViewById(R.id.btn_minus14)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[165];
                    if (temp > 1) {
                        temp--;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 50, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus14)) != null) {
            ((Button) findViewById(R.id.btn_plus14)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[165];
                    if (temp < 7) {
                        temp++;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 50, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus15)) != null) {
            ((Button) findViewById(R.id.btn_minus15)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[170];
                    if (temp > 1) {
                        temp--;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 55, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus15)) != null) {
            ((Button) findViewById(R.id.btn_plus15)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[170];
                    if (temp < 2) {
                        temp++;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 55, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus16)) != null) {
            ((Button) findViewById(R.id.btn_minus16)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[128] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 13, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus16)) != null) {
            ((Button) findViewById(R.id.btn_plus16)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[128] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 13, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus17)) != null) {
            ((Button) findViewById(R.id.btn_minus17)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[129] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 14, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus17)) != null) {
            ((Button) findViewById(R.id.btn_plus17)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[129] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 14, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus18)) != null) {
            ((Button) findViewById(R.id.btn_minus18)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[130] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 15, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus18)) != null) {
            ((Button) findViewById(R.id.btn_plus18)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[130] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 15, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus19)) != null) {
            ((Button) findViewById(R.id.btn_minus19)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[136] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 21, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus19)) != null) {
            ((Button) findViewById(R.id.btn_plus19)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[136] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 21, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus20)) != null) {
            ((Button) findViewById(R.id.btn_minus20)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[171];
                    if (temp > 1) {
                        temp--;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 56, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus20)) != null) {
            ((Button) findViewById(R.id.btn_plus20)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[171];
                    if (temp < 3) {
                        temp++;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 56, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus21)) != null) {
            ((Button) findViewById(R.id.btn_minus21)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[143] - 1;
                    if (temp < 0) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 28, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus21)) != null) {
            ((Button) findViewById(R.id.btn_plus21)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[143] + 1;
                    if (temp > 3) {
                        temp = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 28, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus22)) != null) {
            ((Button) findViewById(R.id.btn_minus22)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[145] - 1;
                    if (temp < 0) {
                        temp = 2;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 30, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus22)) != null) {
            ((Button) findViewById(R.id.btn_plus22)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[145] + 1;
                    if (temp > 2) {
                        temp = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 30, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus23)) != null) {
            ((Button) findViewById(R.id.btn_minus23)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[147] - 1;
                    if (temp < 0) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 32, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus23)) != null) {
            ((Button) findViewById(R.id.btn_plus23)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[147] + 1;
                    if (temp > 1) {
                        temp = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 32, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus24)) != null) {
            ((Button) findViewById(R.id.btn_minus24)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[148] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 33, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus24)) != null) {
            ((Button) findViewById(R.id.btn_plus24)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[148] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 33, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus25)) != null) {
            ((Button) findViewById(R.id.btn_minus25)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[149] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 34, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus25)) != null) {
            ((Button) findViewById(R.id.btn_plus25)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[149] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 34, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus26)) != null) {
            ((Button) findViewById(R.id.btn_minus26)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[156];
                    if (temp > 0) {
                        temp--;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 41, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus26)) != null) {
            ((Button) findViewById(R.id.btn_plus26)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[156];
                    if (temp < 20) {
                        temp++;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 41, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus27)) != null) {
            ((Button) findViewById(R.id.btn_minus27)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[155] - 1;
                    if (temp < 0) {
                        temp = 2;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 40, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus27)) != null) {
            ((Button) findViewById(R.id.btn_plus27)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[155] + 1;
                    if (temp > 2) {
                        temp = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 40, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus28)) != null) {
            ((Button) findViewById(R.id.btn_minus28)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[172];
                    if (temp > 1) {
                        temp--;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 58, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus28)) != null) {
            ((Button) findViewById(R.id.btn_plus28)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[172];
                    if (temp < 4) {
                        temp++;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 58, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus29)) != null) {
            ((Button) findViewById(R.id.btn_minus29)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[188];
                    if (temp > 1) {
                        temp--;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 128, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus29)) != null) {
            ((Button) findViewById(R.id.btn_plus29)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[188];
                    if (temp < 2) {
                        temp++;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 128, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus30)) != null) {
            ((Button) findViewById(R.id.btn_minus30)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[191];
                    if (temp > 0) {
                        temp--;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 76, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus30)) != null) {
            ((Button) findViewById(R.id.btn_plus30)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[191];
                    if (temp < 3) {
                        temp++;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{131, 76, temp}, null, null);
                }
            });
        }
    }

    
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[114] & 255;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext41)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext41)).setChecked(value == 1);
        }
    }

    protected void OnekeyturnMode(int i) {
        int temp = DataCanbus.DATA[126];
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
        int temp = DataCanbus.DATA[125];
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
        normalDialog.setPositiveButton(R.string.wc_psa_all_confirm, new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DataCanbus.PROXY.cmd(0, new int[]{131, 0, 1}, null, null);
            }
        });
        normalDialog.setNegativeButton(R.string.wc_psa_all_cancel, new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        normalDialog.show();
    }

    protected void ShoeRestoreTireSetDialog() {
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(this);
        normalDialog.setTitle(R.string.bsd_klj_str15);
        normalDialog.setMessage(R.string.bsd_klj_str15);
        normalDialog.setPositiveButton(R.string.wc_psa_all_confirm, new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DataCanbus.PROXY.cmd(0, new int[]{131, 12, 1}, null, null);
            }
        });
        normalDialog.setNegativeButton(R.string.wc_psa_all_cancel, new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        normalDialog.show();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.mNotifyCanbus);
    }

    
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
