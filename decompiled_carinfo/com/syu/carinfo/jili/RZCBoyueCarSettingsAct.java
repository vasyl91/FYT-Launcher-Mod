package com.syu.carinfo.jili;

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

import java.util.ArrayList;

@SuppressWarnings({"deprecation", "unchecked"})
public class RZCBoyueCarSettingsAct extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    private int[] eventIds = {112, 113, 114, 115, 116, 137, 138, 139, 140, 141, 142, 143, 144, 130, 214, 145, 146, 147, 148, 149, 150};
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 112:
                    if (((TextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.tv_text1)).setText(value == 1 ? R.string.driver_system_sports : R.string.wc_gs4_driver_help_turn_mode_comfort);
                    }
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 113:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 114:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 115:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 116:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 130:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext18), value == 1);
                    break;
                case 138:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 139:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 140:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 141:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 142:
                    switch (value) {
                        case 0:
                            ((TextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.jeep_forwardcollisionwarn_0);
                            break;
                        case 1:
                            ((TextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.jeep_lanesensewarn_1);
                            break;
                        case 2:
                            ((TextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.jeep_forwardcollisionwarn_1);
                            break;
                    }
                case 143:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 144:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 145:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 146:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 147:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 148:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 149:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
                case 150:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 214:
                    RZCBoyueCarSettingsAct.this.setCheckView((CheckedTextView) RZCBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext19), value == 1);
                    break;
            }
        }
    };

    @Override
    public void onClick(View v) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_139_rzc_boyue);
        init();
    }

    @Override
    public void addNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].removeNotify(this.mNotifyCanbus);
        }
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
                RZCBoyueCarSettingsAct.this.language_set = position;
                if (RZCBoyueCarSettingsAct.this.language_set >= 0 && RZCBoyueCarSettingsAct.this.language_set <= RZCBoyueCarSettingsAct.this.mLauStylelist.size() && RZCBoyueCarSettingsAct.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(1, new int[]{26, RZCBoyueCarSettingsAct.this.send_lang[RZCBoyueCarSettingsAct.this.language_set]}, null, null);
                }
                RZCBoyueCarSettingsAct.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(this.language_set, true);
        }
    }

    @Override
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.send_lang = new int[]{0, 1};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (RZCBoyueCarSettingsAct.this.mLauStyle == null) {
                    RZCBoyueCarSettingsAct.this.initLauStyle();
                }
                if (RZCBoyueCarSettingsAct.this.mLauStyle != null && RZCBoyueCarSettingsAct.this.mPopShowView != null) {
                    RZCBoyueCarSettingsAct.this.mLauStyle.showAtLocation(RZCBoyueCarSettingsAct.this.mPopShowView, 17, 0, 0);
                    RZCBoyueCarSettingsAct.this.updateLauguageSet();
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[142] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{25, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[142] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{25, value}, null, null);
            }
        });
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), 6, 112);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), 21, 138);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), 22, 139);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), 23, 140);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), 24, 141);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), 10, 116);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), 9, 115);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), 7, 113);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), 8, 114);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), 4, 144);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), 1, 143);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext18), 20, 130);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext19), 18, 214);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[145];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{13}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[]{12}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[146];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{15}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[]{14}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[147];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{17}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[]{16}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[148];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{19}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[]{18}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[149];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{21}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[]{20}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext17)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[150];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{23}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[]{22}, null, null);
                }
            }
        });
    }

    private void sendClick(View v, final int cmd, final int id) {
        if (v != null) {
            v.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v2) {
                    int value = DataCanbus.DATA[id];
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = cmd;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
    }

    
    public void setCheckView(CheckedTextView v, boolean b) {
        if (v != null) {
            v.setChecked(b);
        }
    }
}
