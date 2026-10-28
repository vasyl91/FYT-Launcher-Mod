package com.syu.carinfo.lz.lexusis;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryicPetrolElectricActi_XP;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

import java.util.ArrayList;

@SuppressWarnings({"deprecation", "unchecked"})
public class LZLexusISCarSet extends BaseActivity implements View.OnClickListener {
    public static boolean isFront = false;
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private final IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 136:
                    LZLexusISCarSet.this.updateFadvalue(value);
                    break;
                case 137:
                    LZLexusISCarSet.this.updateBanvalue(value);
                    break;
                case 138:
                    LZLexusISCarSet.this.setCheck(LZLexusISCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 8);
                    break;
                case 139:
                    LZLexusISCarSet.this.updateBassbvalue(value);
                    break;
                case 140:
                    LZLexusISCarSet.this.updateTrebvalue(value);
                    break;
                case 141:
                    LZLexusISCarSet.this.updateMidbvalue(value);
                    break;
                case 142:
                    ((TextView) LZLexusISCarSet.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value));
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_lz_lexuse_settings);
        init();
    }

    
    public void initLauStyle() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View layout = inflater.inflate(R.layout.layout_lauguage, null);
        this.mLauStyle = new PopupWindow(layout, 548, 408);
        this.mLauStyle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bk_models_pop));
        this.mLauStyle.setFocusable(true);
        this.mLauStyle.setTouchable(true);
        this.mLauStyle.setOutsideTouchable(true);
        this.mLauStyle.setAnimationStyle(R.style.popAnimationFade);
        this.mLauStylelv = layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter(new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                LZLexusISCarSet.this.language_set = position;
                if (LZLexusISCarSet.this.language_set >= 0 && LZLexusISCarSet.this.language_set <= LZLexusISCarSet.this.mLauStylelist.size() && LZLexusISCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(2, new int[]{80, LZLexusISCarSet.this.send_lang[LZLexusISCarSet.this.language_set]}, null, null);
                }
                LZLexusISCarSet.this.mLauStyle.dismiss();
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
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_LZ_Toyota_Prius_03_L /* 3539398 */:
            case FinalCanbus.CAR_454_LZ_Toyota_Prius_03_H /* 3604934 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                break;
        }
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add("Type1");
        this.mLauStylelist.add("Type2");
        this.mLauStylelist.add("Type3");
        this.mLauStylelist.add("Type4");
        this.send_lang = new int[]{0, 1, 2, 3};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        findViewById(R.id.all_func_btn_lauguage_set).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (LZLexusISCarSet.this.mLauStyle == null) {
                    LZLexusISCarSet.this.initLauStyle();
                }
                if (LZLexusISCarSet.this.mLauStyle != null && LZLexusISCarSet.this.mPopShowView != null) {
                    LZLexusISCarSet.this.mLauStyle.showAtLocation(LZLexusISCarSet.this.mPopShowView, 17, 0, 0);
                    LZLexusISCarSet.this.updateLauguageSet();
                }
            }
        });
        findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[140];
                if (value < 12) {
                    value++;
                } else if (value < 2) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{5, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[140];
                if (value > 2) {
                    value--;
                } else if (value < 2) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{5, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[141];
                if (value < 12) {
                    value++;
                } else if (value < 2) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{6, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[141];
                if (value > 2) {
                    value--;
                } else if (value < 2) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{6, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus3).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[139];
                if (value < 12) {
                    value++;
                } else if (value < 2) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{4, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus3).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[139];
                if (value > 2) {
                    value--;
                } else if (value < 2) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{4, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus4).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[137];
                if (value < 14) {
                    value++;
                }
                DataCanbus.PROXY.cmd(2, new int[]{2, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus4).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[137];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(2, new int[]{2, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus5).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[136];
                if (value < 14) {
                    value++;
                }
                DataCanbus.PROXY.cmd(2, new int[]{1, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus5).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[136];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(2, new int[]{1, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus6).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[142];
                if (value < 63) {
                    value++;
                }
                DataCanbus.PROXY.cmd(2, new int[]{7, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus6).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[142];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(2, new int[]{7, value}, null, null);
            }
        });
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[138];
                if (value2 == 8) {
                    value = 1;
                } else {
                    value = 8;
                }
                DataCanbus.PROXY.cmd(2, new int[]{3, value}, null, null);
            }
        });
        findViewById(R.id.ctv_checkedtext2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(LZLexusISCarSet.this, CamryicPetrolElectricActi_XP.class);
                    LZLexusISCarSet.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        v.getId();
    }

    @Override
    protected void onResume() {
        super.onResume();
        isFront = true;
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.notifyCanbus);
    }

    public void updateBassbvalue(int value) {
        if (value >= 7) {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.format("%d", Integer.valueOf(value - 7)));
        } else if (value < 7) {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.format("-%d", Integer.valueOf(7 - value)));
        }
    }

    public void updateMidbvalue(int value) {
        if (value >= 7) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.format("%d", Integer.valueOf(value - 7)));
        } else if (value < 7) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.format("-%d", Integer.valueOf(7 - value)));
        }
    }

    public void updateTrebvalue(int value) {
        if (value >= 7) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.format("%d", Integer.valueOf(value - 7)));
        } else if (value < 7) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.format("-%d", Integer.valueOf(7 - value)));
        }
    }

    public void updateFadvalue(int value) {
        if (value == 7) {
            ((TextView) findViewById(R.id.tv_text5)).setText(String.format("%d", Integer.valueOf(value - 7)));
        } else if (value > 7) {
            ((TextView) findViewById(R.id.tv_text5)).setText(String.format("R%d", Integer.valueOf(value - 7)));
        } else if (value < 7) {
            ((TextView) findViewById(R.id.tv_text5)).setText(String.format("F%d", Integer.valueOf(7 - value)));
        }
    }

    public void updateBanvalue(int value) {
        if (value == 7) {
            ((TextView) findViewById(R.id.tv_text4)).setText(String.format("%d", Integer.valueOf(value - 7)));
        } else if (value > 7) {
            ((TextView) findViewById(R.id.tv_text4)).setText(String.format("R%d", Integer.valueOf(value - 7)));
        } else if (value < 7) {
            ((TextView) findViewById(R.id.tv_text4)).setText(String.format("L%d", Integer.valueOf(7 - value)));
        }
    }
}
