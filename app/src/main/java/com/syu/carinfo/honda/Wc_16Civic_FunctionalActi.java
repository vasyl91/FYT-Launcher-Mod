package com.syu.carinfo.honda;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

public class Wc_16Civic_FunctionalActi extends BaseActivity {
    int language_set = 255;
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_321_civic_functional_state);
        init();
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
                Wc_16Civic_FunctionalActi.this.language_set = position;
                if (Wc_16Civic_FunctionalActi.this.language_set >= 0 && Wc_16Civic_FunctionalActi.this.language_set <= Wc_16Civic_FunctionalActi.this.mLauStylelist.size() && Wc_16Civic_FunctionalActi.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(112, new int[]{1, Wc_16Civic_FunctionalActi.this.send_lang[Wc_16Civic_FunctionalActi.this.language_set]}, null, null);
                }
                Wc_16Civic_FunctionalActi.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_0));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_14));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.send_lang = new int[]{1, 2, 3, 5, 7};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (Wc_16Civic_FunctionalActi.this.mLauStyle == null) {
                    Wc_16Civic_FunctionalActi.this.initLauStyle();
                }
                if (Wc_16Civic_FunctionalActi.this.mLauStyle != null && Wc_16Civic_FunctionalActi.this.mPopShowView != null) {
                    Wc_16Civic_FunctionalActi.this.mLauStyle.showAtLocation(Wc_16Civic_FunctionalActi.this.mPopShowView, 17, 0, 0);
                    Wc_16Civic_FunctionalActi.this.updateLauguageSet();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Wc_16Civic_FunctionalActi.this, Wc_16Civic_LightActi.class);
                    Wc_16Civic_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Wc_16Civic_FunctionalActi.this, Wc_16Civic_RemoteActi.class);
                    Wc_16Civic_FunctionalActi.this.startActivity(intent);
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
                    intent.setClass(Wc_16Civic_FunctionalActi.this, Wc_16Civic_DoorActi.class);
                    Wc_16Civic_FunctionalActi.this.startActivity(intent);
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
                    intent.setClass(Wc_16Civic_FunctionalActi.this, Wc_16Civic_SaftyActi.class);
                    Wc_16Civic_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Wc_16Civic_FunctionalActi.this, Wc_16Civic_PersonalizedpostureActi.class);
                    Wc_16Civic_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (DataCanbus.DATA[1000] == 393537) {
            findViewById(R.id.layout_view12).setVisibility(0);
        } else {
            findViewById(R.id.layout_view12).setVisibility(8);
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Wc_16Civic_FunctionalActi.this, Wc_16Civic_AMPSetActi.class);
                    Wc_16Civic_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Wc_16Civic_FunctionalActi.this, Wc_16Civic_Pannel.class);
                    Wc_16Civic_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Wc_16Civic_FunctionalActi.this, Wc_16Civic_ElectricActi.class);
                    Wc_16Civic_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Wc_16Civic_FunctionalActi.this.dialog(R.string.str_321_tireclean, 108);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Wc_16Civic_FunctionalActi.this, Wc_16Civic_ResetActi.class);
                    Wc_16Civic_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Wc_16Civic_FunctionalActi.this.dialog(R.string.rzc_klc_default_set_str, 105);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Wc_16Civic_FunctionalActi.this, WCCommpassActi.class);
                    Wc_16Civic_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Wc_16Civic_FunctionalActi.this, ActivityBatteryDoor.class);
                    Wc_16Civic_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    protected void dialog(final int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(stringId));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = stringId;
                final int i2 = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        if (i == 2131298958) {
                            DataCanbus.PROXY.cmd(i2, new int[]{6, 1}, null, null);
                        } else if (i == 2131297448) {
                            DataCanbus.PROXY.cmd(i2, new int[]{5, 1}, null, null);
                        } else {
                            DataCanbus.PROXY.cmd(i2, new int[]{1}, null, null);
                        }
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (stringId == 2131298365) {
                    DataCanbus.PROXY.cmd(cmd, new int[1], null, null);
                }
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
