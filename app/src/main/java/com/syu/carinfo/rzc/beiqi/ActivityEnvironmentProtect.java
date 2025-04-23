package com.syu.carinfo.rzc.beiqi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ActivityEnvironmentProtect extends Activity {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 103:
                    ActivityEnvironmentProtect.this.updateDriveMiles(DataCanbus.DATA[updateCode]);
                    break;
                case 111:
                    ActivityEnvironmentProtect.this.updateCO2Lev(DataCanbus.DATA[updateCode]);
                    break;
                case 112:
                    ActivityEnvironmentProtect.this.updateTreeLev(DataCanbus.DATA[updateCode]);
                    break;
                case 113:
                    ActivityEnvironmentProtect.this.updateTitleLevelMiles(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_227_environment_protect);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(6, new int[]{57}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateTreeLev(int value) {
        if (((TextView) findViewById(R.id.tv_277_equal_plant_tree)) != null) {
            ((TextView) findViewById(R.id.tv_277_equal_plant_tree)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    
    public void updateCO2Lev(int value) {
        if (((TextView) findViewById(R.id.tv_277_co2)) != null) {
            if (DataCanbus.DATA[1000] == 786659 || DataCanbus.DATA[1000] == 1376483) {
                ((TextView) findViewById(R.id.tv_277_co2)).setText(new StringBuilder(String.valueOf(value)).toString());
            } else {
                ((TextView) findViewById(R.id.tv_277_co2)).setText(new StringBuilder(String.valueOf(value / 10)).toString());
            }
        }
    }

    
    public void updateTitleLevelMiles(int value) {
        int titleLevelId;
        if (((TextView) findViewById(R.id.tv_227_level_title)) != null) {
            if (value == 0) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_0;
            } else if (value == 1) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_1;
            } else if (value == 2) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_2;
            } else if (value == 3) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_3;
            } else if (value == 4) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_4;
            } else if (value == 5) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_5;
            } else if (value == 6) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_6;
            } else if (value == 7) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_7;
            } else if (value == 8) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_8;
            } else if (value == 9) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_9;
            } else if (value == 10) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_10;
            } else if (value == 11) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_11;
            } else if (value == 12) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_12;
            } else if (value == 13) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_13;
            } else if (value == 14) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_14;
            } else if (value == 15) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_15;
            } else if (value == 16) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_16;
            } else if (value == 17) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_17;
            } else if (value == 18) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_18;
            } else if (value == 19) {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_19;
            } else {
                titleLevelId = R.string.str_227_ec180_environmental_level_title_20;
            }
            ((TextView) findViewById(R.id.tv_227_level_title)).setText(titleLevelId);
        }
    }

    
    public void updateDriveMiles(int value) {
        int titleLevelId;
        if (((TextView) findViewById(R.id.tv_277_drivered)) != null) {
            ((TextView) findViewById(R.id.tv_277_drivered)).setText(new StringBuilder().append(value).toString());
        }
        if (DataCanbus.DATA[1000] == 196835) {
            if (((TextView) findViewById(R.id.tv_277_co2)) != null) {
                ((TextView) findViewById(R.id.tv_277_co2)).setText(new StringBuilder(String.valueOf((value + 5) / 6)).toString());
            }
            if (((TextView) findViewById(R.id.tv_277_equal_plant_tree)) != null) {
                ((TextView) findViewById(R.id.tv_277_equal_plant_tree)).setText(new StringBuilder(String.valueOf((value + 51) / 102)).toString());
            }
            if (((TextView) findViewById(R.id.tv_227_level_title)) != null) {
                if (value < 100) {
                    titleLevelId = R.string.str_227_ec180_environmental_level_title_0;
                } else if (value < 200) {
                    titleLevelId = R.string.str_227_ec180_environmental_level_title_1;
                } else if (value < 400) {
                    titleLevelId = R.string.str_227_ec180_environmental_level_title_2;
                } else if (value < 800) {
                    titleLevelId = R.string.str_227_ec180_environmental_level_title_3;
                } else if (value < 1200) {
                    titleLevelId = R.string.str_227_ec180_environmental_level_title_4;
                } else if (value < 1800) {
                    titleLevelId = R.string.str_227_ec180_environmental_level_title_5;
                } else if (value < 2400) {
                    titleLevelId = R.string.str_227_ec180_environmental_level_title_6;
                } else if (value < 3000) {
                    titleLevelId = R.string.str_227_ec180_environmental_level_title_7;
                } else if (value < 3800) {
                    titleLevelId = R.string.str_227_ec180_environmental_level_title_8;
                } else if (value < 5000) {
                    titleLevelId = R.string.str_227_ec180_environmental_level_title_9;
                } else if (value < 6000) {
                    titleLevelId = R.string.str_227_ec180_environmental_level_title_10;
                } else if (value < 7000) {
                    titleLevelId = R.string.str_227_ec180_environmental_level_title_11;
                } else if (value < 8000) {
                    titleLevelId = R.string.str_227_ec180_environmental_level_title_12;
                } else if (value < 9000) {
                    titleLevelId = R.string.str_227_ec180_environmental_level_title_13;
                } else if (value < 10000) {
                    titleLevelId = R.string.str_227_ec180_environmental_level_title_14;
                } else if (value < 12000) {
                    titleLevelId = R.string.str_227_ec180_environmental_level_title_15;
                } else if (value < 15000) {
                    titleLevelId = R.string.str_227_ec180_environmental_level_title_16;
                } else if (value < 20000) {
                    titleLevelId = R.string.str_227_ec180_environmental_level_title_17;
                } else if (value < 30000) {
                    titleLevelId = R.string.str_227_ec180_environmental_level_title_18;
                } else if (value < 50000) {
                    titleLevelId = R.string.str_227_ec180_environmental_level_title_19;
                } else {
                    titleLevelId = R.string.str_227_ec180_environmental_level_title_20;
                }
                ((TextView) findViewById(R.id.tv_227_level_title)).setText(titleLevelId);
            }
        }
    }
}
