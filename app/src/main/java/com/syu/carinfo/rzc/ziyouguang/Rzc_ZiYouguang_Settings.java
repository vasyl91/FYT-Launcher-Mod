package com.syu.carinfo.rzc.ziyouguang;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

public class Rzc_ZiYouguang_Settings extends BaseActivity {
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
                case 122:
                    Rzc_ZiYouguang_Settings.this.updateLauguageSet();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_jeep_settings_rzc);
        init();
    }

    
    public void initLauStyle() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View layout = inflater.inflate(R.layout.layout_lauguage3, (ViewGroup) null);
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
                Rzc_ZiYouguang_Settings.this.language_set = position;
                if (Rzc_ZiYouguang_Settings.this.language_set >= 0 && Rzc_ZiYouguang_Settings.this.language_set <= Rzc_ZiYouguang_Settings.this.mLauStylelist.size() && Rzc_ZiYouguang_Settings.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(2, new int[]{6, Rzc_ZiYouguang_Settings.this.send_lang[Rzc_ZiYouguang_Settings.this.language_set] + 1}, null, null);
                }
                Rzc_ZiYouguang_Settings.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[122];
        int i = 0;
        while (i < this.mLauStylelist.size() && value != this.send_lang[i]) {
            i++;
        }
        if (i < this.mLauStylelist.size()) {
            if (((TextView) findViewById(R.id.lauguage_set_curr)) != null) {
                ((TextView) findViewById(R.id.lauguage_set_curr)).setText(this.mLauStylelist.get(i));
            }
            if (this.mLauStylelv != null) {
                this.mLauStylelv.setItemChecked(i, true);
            }
        }
    }

    @Override
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.off));
        this.mLauStylelist.add(getResources().getString(R.string.klc_Parking_with_trailer_ON));
        this.send_lang = new int[]{0, 1};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (Rzc_ZiYouguang_Settings.this.mLauStyle == null) {
                    Rzc_ZiYouguang_Settings.this.initLauStyle();
                }
                if (Rzc_ZiYouguang_Settings.this.mLauStyle != null && Rzc_ZiYouguang_Settings.this.mPopShowView != null) {
                    Rzc_ZiYouguang_Settings.this.mLauStyle.showAtLocation(Rzc_ZiYouguang_Settings.this.mPopShowView, 17, 0, 0);
                    Rzc_ZiYouguang_Settings.this.updateLauguageSet();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.zyg_271_Safety)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Rzc_ZiYouguang_Settings.this, Rzc_ZiYouguang_Safety.class);
                    Rzc_ZiYouguang_Settings.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.zyg_271_LightEngine)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Rzc_ZiYouguang_Settings.this, Rzc_ZiYouguang_Light.class);
                    Rzc_ZiYouguang_Settings.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.zyg_271_DoorLock)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Rzc_ZiYouguang_Settings.this, Rzc_ZiYouguang_DoorLock.class);
                    Rzc_ZiYouguang_Settings.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.zyg_271_suspension)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Rzc_ZiYouguang_Settings.this, Rzc_ZiYouguang_Suspension.class);
                    Rzc_ZiYouguang_Settings.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if ((DataCanbus.DATA[1000] == 196981 || DataCanbus.DATA[1000] == 459125) && LauncherApplication.getConfiguration() == 1) {
            findViewById(R.id.layout_373_shup_only).setVisibility(0);
        } else {
            findViewById(R.id.layout_373_shup_only).setVisibility(8);
        }
        ((CheckedTextView) findViewById(R.id.zyg_271_shup_only)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Rzc_ZiYouguang_Settings.this, Rzc_ZiYouguang_ShupOnly.class);
                    Rzc_ZiYouguang_Settings.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (DataCanbus.DATA[1000] == 590197 || DataCanbus.DATA[1000] == 721269) {
            findViewById(R.id.layout_373_tiaozhanzhe_only).setVisibility(0);
        } else {
            findViewById(R.id.layout_373_tiaozhanzhe_only).setVisibility(8);
        }
        ((CheckedTextView) findViewById(R.id.zyg_271_tiaozhanzhe_only)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Rzc_ZiYouguang_Settings.this, Rzc_ZiYouguang_TiaozhanzheOnly.class);
                    Rzc_ZiYouguang_Settings.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Rzc_ZiYouguang_Settings.this, RZC_JeepCarEQSet.class);
                    Rzc_ZiYouguang_Settings.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (DataCanbus.DATA[1000] == 1900917 || DataCanbus.DATA[1000] == 1966453 || DataCanbus.DATA[1000] == 2031989) {
            findViewById(R.id.layout_view2).setVisibility(0);
        } else {
            findViewById(R.id.layout_view2).setVisibility(8);
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Rzc_ZiYouguang_Settings.this, Rzc_RamHY_WindowButton.class);
                    Rzc_ZiYouguang_Settings.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Rzc_ZiYouguang_Settings.this, RZC_JeepCarAUXPowerSet.class);
                    Rzc_ZiYouguang_Settings.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Rzc_ZiYouguang_Settings.this, Rzc_ZiYouguang_AHDSet.class);
                    Rzc_ZiYouguang_Settings.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.zyg_271_other)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Rzc_ZiYouguang_Settings.this, Rzc_ZiYouguang_Other.class);
                    Rzc_ZiYouguang_Settings.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.zyg_271_factory_set)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Rzc_ZiYouguang_Settings.this, Rzc_ZiYouguang_FactorySetActivity.class);
                    Rzc_ZiYouguang_Settings.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
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
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
    }
}
