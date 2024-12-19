package com.syu.carinfo.golf7;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Golf7FunctionalTireActiVW_DZSJ extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7FunctionalTireActiVW_DZSJ.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 116:
                    ((TextView) Golf7FunctionalTireActiVW_DZSJ.this.findViewById(R.id.tv_tire_fl)).setText(Golf7FunctionalTireActiVW_DZSJ.this.getPressureStr(DataCanbus.DATA[updateCode] & 65535));
                    ((TextView) Golf7FunctionalTireActiVW_DZSJ.this.findViewById(R.id.tv_tire_ck_fl)).setText("(" + Golf7FunctionalTireActiVW_DZSJ.this.getPressureStr((DataCanbus.DATA[updateCode] >> 16) & 65535) + ")");
                    break;
                case 117:
                    ((TextView) Golf7FunctionalTireActiVW_DZSJ.this.findViewById(R.id.tv_tire_fr)).setText(Golf7FunctionalTireActiVW_DZSJ.this.getPressureStr(DataCanbus.DATA[updateCode] & 65535));
                    ((TextView) Golf7FunctionalTireActiVW_DZSJ.this.findViewById(R.id.tv_tire_ck_fr)).setText("(" + Golf7FunctionalTireActiVW_DZSJ.this.getPressureStr((DataCanbus.DATA[updateCode] >> 16) & 65535) + ")");
                    break;
                case 118:
                    ((TextView) Golf7FunctionalTireActiVW_DZSJ.this.findViewById(R.id.tv_tire_rl)).setText(Golf7FunctionalTireActiVW_DZSJ.this.getPressureStr(DataCanbus.DATA[updateCode] & 65535));
                    ((TextView) Golf7FunctionalTireActiVW_DZSJ.this.findViewById(R.id.tv_tire_ck_rl)).setText("(" + Golf7FunctionalTireActiVW_DZSJ.this.getPressureStr((DataCanbus.DATA[updateCode] >> 16) & 65535) + ")");
                    break;
                case 119:
                    ((TextView) Golf7FunctionalTireActiVW_DZSJ.this.findViewById(R.id.tv_tire_rr)).setText(Golf7FunctionalTireActiVW_DZSJ.this.getPressureStr(DataCanbus.DATA[updateCode] & 65535));
                    ((TextView) Golf7FunctionalTireActiVW_DZSJ.this.findViewById(R.id.tv_tire_ck_rr)).setText("(" + Golf7FunctionalTireActiVW_DZSJ.this.getPressureStr((DataCanbus.DATA[updateCode] >> 16) & 65535) + ")");
                    break;
                case 202:
                    if (DataCanbus.DATA[updateCode] == 0) {
                        ((TextView) Golf7FunctionalTireActiVW_DZSJ.this.findViewById(R.id.tv_tire_unit)).setText("kPa");
                        break;
                    } else if (DataCanbus.DATA[updateCode] == 2) {
                        ((TextView) Golf7FunctionalTireActiVW_DZSJ.this.findViewById(R.id.tv_tire_unit)).setText("psi");
                        break;
                    } else {
                        ((TextView) Golf7FunctionalTireActiVW_DZSJ.this.findViewById(R.id.tv_tire_unit)).setText("bar");
                        break;
                    }
                case 203:
                    Golf7FunctionalTireActiVW_DZSJ.this.Show_TireMode(DataCanbus.DATA[updateCode]);
                    break;
                case 250:
                    int alarm0 = (DataCanbus.DATA[updateCode] >> 8) & 255;
                    int alarm1 = DataCanbus.DATA[updateCode] & 255;
                    String str = null;
                    if (alarm1 > 1 && alarm1 <= 4) {
                        if ((alarm0 & 1) == 1) {
                            str = Golf7FunctionalTireActiVW_DZSJ.this.getString(R.string.str_wc_rfs2_12);
                            ((TextView) Golf7FunctionalTireActiVW_DZSJ.this.findViewById(R.id.tv_tire_fl)).setTextColor(-65536);
                        } else if (((alarm0 >> 1) & 1) == 1) {
                            str = Golf7FunctionalTireActiVW_DZSJ.this.getString(R.string.str_wc_rfs2_13);
                            ((TextView) Golf7FunctionalTireActiVW_DZSJ.this.findViewById(R.id.tv_tire_fr)).setTextColor(-65536);
                        } else if (((alarm0 >> 2) & 1) == 1) {
                            str = Golf7FunctionalTireActiVW_DZSJ.this.getString(R.string.str_wc_rfs2_14);
                            ((TextView) Golf7FunctionalTireActiVW_DZSJ.this.findViewById(R.id.tv_tire_rl)).setTextColor(-65536);
                        } else if (((alarm0 >> 3) & 1) == 1) {
                            str = Golf7FunctionalTireActiVW_DZSJ.this.getString(R.string.str_wc_rfs2_15);
                            ((TextView) Golf7FunctionalTireActiVW_DZSJ.this.findViewById(R.id.tv_tire_rr)).setTextColor(-65536);
                        }
                        if (alarm1 == 2 && str != null) {
                            ((TextView) Golf7FunctionalTireActiVW_DZSJ.this.findViewById(R.id.tv_tire_alarm)).setText(String.valueOf(str) + " " + Golf7FunctionalTireActiVW_DZSJ.this.getString(R.string.str_40_od_tire_2));
                            break;
                        } else if (alarm1 == 3 && str != null) {
                            ((TextView) Golf7FunctionalTireActiVW_DZSJ.this.findViewById(R.id.tv_tire_alarm)).setText(String.valueOf(str) + " " + Golf7FunctionalTireActiVW_DZSJ.this.getString(R.string.str_40_od_tire_3));
                            break;
                        } else if (alarm1 == 4 && str != null) {
                            ((TextView) Golf7FunctionalTireActiVW_DZSJ.this.findViewById(R.id.tv_tire_alarm)).setText(String.valueOf(str) + " " + Golf7FunctionalTireActiVW_DZSJ.this.getString(R.string.str_40_od_tire_4));
                            break;
                        } else {
                            ((TextView) Golf7FunctionalTireActiVW_DZSJ.this.findViewById(R.id.tv_tire_alarm)).setText(" ");
                            break;
                        }
                    } else {
                        ((TextView) Golf7FunctionalTireActiVW_DZSJ.this.findViewById(R.id.tv_tire_alarm)).setText(Golf7FunctionalTireActiVW_DZSJ.this.getString(R.string.tireflnormal));
                        ((TextView) Golf7FunctionalTireActiVW_DZSJ.this.findViewById(R.id.tv_tire_fl)).setTextColor(-1);
                        ((TextView) Golf7FunctionalTireActiVW_DZSJ.this.findViewById(R.id.tv_tire_fr)).setTextColor(-1);
                        ((TextView) Golf7FunctionalTireActiVW_DZSJ.this.findViewById(R.id.tv_tire_rl)).setTextColor(-1);
                        ((TextView) Golf7FunctionalTireActiVW_DZSJ.this.findViewById(R.id.tv_tire_rr)).setTextColor(-1);
                        break;
                    }
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_functional_state_tire_od);
        init();
    }

    public void init() {
        findViewById(R.id.view_tire_show).setOnClickListener(this);
        findViewById(R.id.view_dzsj_tire_list).setOnClickListener(this);
        findViewById(R.id.view_tire_set0).setOnClickListener(this);
        findViewById(R.id.view_tire_set1).setOnClickListener(this);
        findViewById(R.id.view_tire_set2).setOnClickListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPressureStr(int value) {
        if (value % 10 == 0) {
            String str = new StringBuilder().append(value / 10).toString();
            return str;
        }
        String str2 = String.valueOf(value / 10) + "." + (value % 10);
        return str2;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setFlags(268435456);
            intent.addCategory("android.intent.category.HOME");
            startActivity(intent);
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.view_tire_show /* 2131431517 */:
                if (findViewById(R.id.view_dzsj_tire_list).getVisibility() == 8) {
                    findViewById(R.id.view_dzsj_tire_list).setVisibility(0);
                    findViewById(R.id.view_tire_show).setVisibility(8);
                    break;
                }
            case R.id.view_tire_set0 /* 2131431530 */:
                if (findViewById(R.id.view_dzsj_tire_list).getVisibility() == 0) {
                    Set_TireMode(0);
                    findViewById(R.id.view_dzsj_tire_list).setVisibility(8);
                    findViewById(R.id.view_tire_show).setVisibility(0);
                    break;
                }
            case R.id.view_tire_set1 /* 2131431532 */:
                if (findViewById(R.id.view_dzsj_tire_list).getVisibility() == 0) {
                    Set_TireMode(1);
                    findViewById(R.id.view_dzsj_tire_list).setVisibility(8);
                    findViewById(R.id.view_tire_show).setVisibility(0);
                    break;
                }
            case R.id.view_tire_set2 /* 2131431534 */:
                if (findViewById(R.id.view_dzsj_tire_list).getVisibility() == 0) {
                    Set_TireMode(2);
                    findViewById(R.id.view_dzsj_tire_list).setVisibility(8);
                    findViewById(R.id.view_tire_show).setVisibility(0);
                    break;
                }
        }
    }

    public void Set_TireMode(int i) {
        DataCanbus.PROXY.cmd(114, new int[]{i}, null, null);
    }

    public void Show_TireMode(int i) {
        int i2 = R.drawable.ic_dzsj_dz_list_bingo_p;
        int i3 = i & 3;
        switch (i3) {
            case 0:
                ((TextView) findViewById(R.id.text_tire_show)).setText(R.string.driver_system_standard);
                ((ImageView) findViewById(R.id.image_tire_show)).setBackground(getResources().getDrawable(R.drawable.tire_set_mark1));
                break;
            case 1:
                ((TextView) findViewById(R.id.text_tire_show)).setText(R.string.str_driving_comfort);
                ((ImageView) findViewById(R.id.image_tire_show)).setBackground(getResources().getDrawable(R.drawable.tire_set_mark1));
                break;
            case 2:
                ((TextView) findViewById(R.id.text_tire_show)).setText(R.string.str_full);
                ((ImageView) findViewById(R.id.image_tire_show)).setBackground(getResources().getDrawable(R.drawable.tire_set_mark2));
                break;
        }
        ((ImageView) findViewById(R.id.iv_tire_set0)).setBackground(getResources().getDrawable(i3 == 0 ? 2130839578 : 2130839577));
        ((ImageView) findViewById(R.id.iv_tire_set1)).setBackground(getResources().getDrawable(i3 == 1 ? 2130839578 : 2130839577));
        ImageView imageView = (ImageView) findViewById(R.id.iv_tire_set2);
        Resources resources = getResources();
        if (i3 != 2) {
            i2 = 2130839577;
        }
        imageView.setBackground(resources.getDrawable(i2));
    }
}
