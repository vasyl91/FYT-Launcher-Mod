package com.syu.carinfo.xbs.tianlai;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XBS09TianlaiCarEQAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.tianlai.XBS09TianlaiCarEQAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (DataCanbus.DATA[1000] == 458942) {
                switch (updateCode) {
                    case 65:
                        XBS09TianlaiCarEQAct.this.mUpdaterEQBas();
                        break;
                    case 66:
                        XBS09TianlaiCarEQAct.this.mUpdaterEQTreb();
                        break;
                    case 67:
                        XBS09TianlaiCarEQAct.this.mUpdaterEQFad();
                        break;
                    case 68:
                        XBS09TianlaiCarEQAct.this.mUpdaterEQBal();
                        break;
                    case 70:
                        XBS09TianlaiCarEQAct.this.mUpdaterEQVol();
                        break;
                }
            }
            switch (updateCode) {
                case 55:
                    XBS09TianlaiCarEQAct.this.mUpdaterEQBas();
                    break;
                case 56:
                    XBS09TianlaiCarEQAct.this.mUpdaterEQTreb();
                    break;
                case 57:
                    XBS09TianlaiCarEQAct.this.mUpdaterEQFad();
                    break;
                case 58:
                    XBS09TianlaiCarEQAct.this.mUpdaterEQBal();
                    break;
                case 60:
                    XBS09TianlaiCarEQAct.this.mUpdaterEQVol();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (LauncherApplication.getConfiguration() == 1) {
            String platform = SystemProperties.get("ro.fyt.platform", "");
            if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform)) {
                setContentView(R.layout.layout_xbs_09tianlai_caraudio_9853);
            } else {
                setContentView(R.layout.layout_xbs_09tianlai_caraudio);
            }
        } else {
            setContentView(R.layout.layout_xbs_09tianlai_caraudio);
        }
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        if (DataCanbus.DATA[1000] == 458942) {
            DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        if (DataCanbus.DATA[1000] == 458942) {
            DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterEQVol() {
        int value = DataCanbus.DATA[60];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[70];
        }
        ((TextView) findViewById(R.id.dj_lexus_audio_vol)).setText(new StringBuilder().append(value).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterEQBal() {
        int value = DataCanbus.DATA[58];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[68];
        }
        if (value > 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_ban)).setText("R" + (value - 7));
        } else if (value == 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_ban)).setText("0");
        } else {
            ((TextView) findViewById(R.id.dj_lexus_audio_ban)).setText("L" + (7 - value));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterEQFad() {
        int value = DataCanbus.DATA[57];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[67];
        }
        if (value > 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_fad)).setText("F" + (value - 7));
        } else if (value == 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_fad)).setText("0");
        } else {
            ((TextView) findViewById(R.id.dj_lexus_audio_fad)).setText("R" + (7 - value));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterEQTreb() {
        int value = DataCanbus.DATA[56];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[66];
        }
        if (value >= 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_treb)).setText(new StringBuilder(String.valueOf(value - 7)).toString());
        } else {
            ((TextView) findViewById(R.id.dj_lexus_audio_treb)).setText("-" + (7 - value));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterEQBas() {
        int value = DataCanbus.DATA[55];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[65];
        }
        if (value >= 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_bass)).setText(new StringBuilder(String.valueOf(value - 7)).toString());
        } else {
            ((TextView) findViewById(R.id.dj_lexus_audio_bass)).setText("-" + (7 - value));
        }
    }
}
