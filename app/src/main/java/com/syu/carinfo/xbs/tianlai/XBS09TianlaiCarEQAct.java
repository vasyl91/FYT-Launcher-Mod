package com.syu.carinfo.xbs.tianlai;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class XBS09TianlaiCarEQAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (DataCanbus.DATA[1000] == 458942) {
                switch (updateCode) {
                    case 138:
                        XBS09TianlaiCarEQAct.this.mUpdaterEQBas();
                        break;
                    case 139:
                        XBS09TianlaiCarEQAct.this.mUpdaterEQTreb();
                        break;
                    case 140:
                        XBS09TianlaiCarEQAct.this.mUpdaterEQFad();
                        break;
                    case 141:
                        XBS09TianlaiCarEQAct.this.mUpdaterEQBal();
                        break;
                    case 143:
                        XBS09TianlaiCarEQAct.this.mUpdaterEQVol();
                        break;
                }
            }
            switch (updateCode) {
                case 138:
                    XBS09TianlaiCarEQAct.this.mUpdaterEQBas();
                    break;
                case 139:
                    XBS09TianlaiCarEQAct.this.mUpdaterEQTreb();
                    break;
                case 140:
                    XBS09TianlaiCarEQAct.this.mUpdaterEQFad();
                    break;
                case 141:
                    XBS09TianlaiCarEQAct.this.mUpdaterEQBal();
                    break;
                case 143:
                    XBS09TianlaiCarEQAct.this.mUpdaterEQVol();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (LauncherApplication.getConfiguration() == 1) {
            String platform = SystemProperties.get("ro.fyt.platform", "");
            if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform) || "6318".equals(platform)) {
                //setContentView(R.layout.layout_xbs_09tianlai_caraudio_9853);
            } else {
                //setContentView(R.layout.layout_xbs_09tianlai_caraudio);
            }
        } else {
            //setContentView(R.layout.layout_xbs_09tianlai_caraudio);
        }
        init();
    }

    @Override
    public void init() {
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
        if (DataCanbus.DATA[1000] == 458942) {
            DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        if (DataCanbus.DATA[1000] == 458942) {
            DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterEQVol() {
        int value = DataCanbus.DATA[143];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[143];
        }
        ((TextView) findViewById(R.id.dj_lexus_audio_vol)).setText(new StringBuilder().append(value).toString());
    }

    
    public void mUpdaterEQBal() {
        int value = DataCanbus.DATA[141];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[141];
        }
        if (value > 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_ban)).setText("R" + (value - 7));
        } else if (value == 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_ban)).setText("0");
        } else {
            ((TextView) findViewById(R.id.dj_lexus_audio_ban)).setText("L" + (7 - value));
        }
    }

    
    public void mUpdaterEQFad() {
        int value = DataCanbus.DATA[140];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[140];
        }
        if (value > 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_fad)).setText("F" + (value - 7));
        } else if (value == 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_fad)).setText("0");
        } else {
            ((TextView) findViewById(R.id.dj_lexus_audio_fad)).setText("R" + (7 - value));
        }
    }

    
    public void mUpdaterEQTreb() {
        int value = DataCanbus.DATA[139];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[139];
        }
        if (value >= 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_treb)).setText(new StringBuilder(String.valueOf(value - 7)).toString());
        } else {
            ((TextView) findViewById(R.id.dj_lexus_audio_treb)).setText("-" + (7 - value));
        }
    }

    
    public void mUpdaterEQBas() {
        int value = DataCanbus.DATA[138];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[138];
        }
        if (value >= 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_bass)).setText(new StringBuilder(String.valueOf(value - 7)).toString());
        } else {
            ((TextView) findViewById(R.id.dj_lexus_audio_bass)).setText("-" + (7 - value));
        }
    }
}
