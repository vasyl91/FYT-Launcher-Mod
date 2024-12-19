package com.syu.carinfo.hechi.fordexplorer;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class HcFordExplorerAudio extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static HcFordExplorerRadio mInit;
    int eqVol = 0;
    int eqBal = 0;
    int eqFad = 0;
    int eqBass = 0;
    int eqMid = 0;
    int eqTreb = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.hechi.fordexplorer.HcFordExplorerAudio.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 63:
                    HcFordExplorerAudio.this.updateVolvalue(value);
                    HcFordExplorerAudio.this.eqVol = value;
                    break;
                case 64:
                    HcFordExplorerAudio.this.updateBanvalue(value);
                    HcFordExplorerAudio.this.eqBal = value;
                    break;
                case 65:
                    HcFordExplorerAudio.this.updateFadvalue(value);
                    HcFordExplorerAudio.this.eqFad = value;
                    break;
                case 66:
                    HcFordExplorerAudio.this.updateBassbvalue(value);
                    HcFordExplorerAudio.this.eqBass = value;
                    break;
                case 67:
                    HcFordExplorerAudio.this.updateMidbvalue(value);
                    HcFordExplorerAudio.this.eqMid = value;
                    break;
                case 68:
                    HcFordExplorerAudio.this.updateTrebvalue(value);
                    HcFordExplorerAudio.this.eqTreb = value;
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_djlexus_caraudio);
        init();
    }

    public void init() {
        findViewById(R.id.btn_lexus_vol_plus).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hechi.fordexplorer.HcFordExplorerAudio.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[63];
                if (value < 30) {
                    value++;
                }
                DataCanbus.PROXY.cmd(6, new int[]{value, HcFordExplorerAudio.this.eqBal, HcFordExplorerAudio.this.eqFad, HcFordExplorerAudio.this.eqBass, HcFordExplorerAudio.this.eqMid, HcFordExplorerAudio.this.eqTreb}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_vol_munit).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hechi.fordexplorer.HcFordExplorerAudio.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[63];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(6, new int[]{value, HcFordExplorerAudio.this.eqBal, HcFordExplorerAudio.this.eqFad, HcFordExplorerAudio.this.eqBass, HcFordExplorerAudio.this.eqMid, HcFordExplorerAudio.this.eqTreb}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_treb_plus).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hechi.fordexplorer.HcFordExplorerAudio.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[68];
                if (value < 17) {
                    value++;
                }
                DataCanbus.PROXY.cmd(6, new int[]{HcFordExplorerAudio.this.eqVol, HcFordExplorerAudio.this.eqBal, HcFordExplorerAudio.this.eqFad, HcFordExplorerAudio.this.eqBass, HcFordExplorerAudio.this.eqMid, value}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_treb_munit).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hechi.fordexplorer.HcFordExplorerAudio.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[68];
                if (value > 3) {
                    value--;
                }
                DataCanbus.PROXY.cmd(6, new int[]{HcFordExplorerAudio.this.eqVol, HcFordExplorerAudio.this.eqBal, HcFordExplorerAudio.this.eqFad, HcFordExplorerAudio.this.eqBass, HcFordExplorerAudio.this.eqMid, value}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_mid_plus).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hechi.fordexplorer.HcFordExplorerAudio.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[67];
                if (value < 17) {
                    value++;
                }
                DataCanbus.PROXY.cmd(6, new int[]{HcFordExplorerAudio.this.eqVol, HcFordExplorerAudio.this.eqBal, HcFordExplorerAudio.this.eqFad, HcFordExplorerAudio.this.eqBass, value, HcFordExplorerAudio.this.eqTreb}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_mid_munit).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hechi.fordexplorer.HcFordExplorerAudio.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[67];
                if (value > 3) {
                    value--;
                }
                DataCanbus.PROXY.cmd(6, new int[]{HcFordExplorerAudio.this.eqVol, HcFordExplorerAudio.this.eqBal, HcFordExplorerAudio.this.eqFad, HcFordExplorerAudio.this.eqBass, value, HcFordExplorerAudio.this.eqTreb}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_bass_plus).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hechi.fordexplorer.HcFordExplorerAudio.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[66];
                if (value < 17) {
                    value++;
                }
                DataCanbus.PROXY.cmd(6, new int[]{HcFordExplorerAudio.this.eqVol, HcFordExplorerAudio.this.eqBal, HcFordExplorerAudio.this.eqFad, value, HcFordExplorerAudio.this.eqMid, HcFordExplorerAudio.this.eqTreb}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_bass_munit).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hechi.fordexplorer.HcFordExplorerAudio.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[66];
                if (value > 3) {
                    value--;
                }
                DataCanbus.PROXY.cmd(6, new int[]{HcFordExplorerAudio.this.eqVol, HcFordExplorerAudio.this.eqBal, HcFordExplorerAudio.this.eqFad, value, HcFordExplorerAudio.this.eqMid, HcFordExplorerAudio.this.eqTreb}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_fad_plus).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hechi.fordexplorer.HcFordExplorerAudio.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[65];
                if (value < 17) {
                    value++;
                }
                DataCanbus.PROXY.cmd(6, new int[]{HcFordExplorerAudio.this.eqVol, HcFordExplorerAudio.this.eqBal, value, HcFordExplorerAudio.this.eqBass, HcFordExplorerAudio.this.eqMid, HcFordExplorerAudio.this.eqTreb}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_fad_munit).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hechi.fordexplorer.HcFordExplorerAudio.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[65];
                if (value > 3) {
                    value--;
                }
                DataCanbus.PROXY.cmd(6, new int[]{HcFordExplorerAudio.this.eqVol, HcFordExplorerAudio.this.eqBal, value, HcFordExplorerAudio.this.eqBass, HcFordExplorerAudio.this.eqMid, HcFordExplorerAudio.this.eqTreb}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_ban_plus).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hechi.fordexplorer.HcFordExplorerAudio.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[64];
                if (value < 17) {
                    value++;
                }
                DataCanbus.PROXY.cmd(6, new int[]{HcFordExplorerAudio.this.eqVol, value, HcFordExplorerAudio.this.eqFad, HcFordExplorerAudio.this.eqBass, HcFordExplorerAudio.this.eqMid, HcFordExplorerAudio.this.eqTreb}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_ban_munit).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hechi.fordexplorer.HcFordExplorerAudio.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[64];
                if (value > 3) {
                    value--;
                }
                DataCanbus.PROXY.cmd(6, new int[]{HcFordExplorerAudio.this.eqVol, value, HcFordExplorerAudio.this.eqFad, HcFordExplorerAudio.this.eqBass, HcFordExplorerAudio.this.eqMid, HcFordExplorerAudio.this.eqTreb}, null, null);
            }
        });
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.notifyCanbus);
    }

    public void updateVolvalue(int value) {
        ((TextView) findViewById(R.id.dj_lexus_audio_vol)).setText(String.format("%d", Integer.valueOf(value)));
    }

    public void updateBassbvalue(int value) {
        if (value >= 10) {
            ((TextView) findViewById(R.id.dj_lexus_audio_bass)).setText(String.format("%d", Integer.valueOf(value - 10)));
        } else if (value < 10) {
            ((TextView) findViewById(R.id.dj_lexus_audio_bass)).setText(String.format("-%d", Integer.valueOf(10 - value)));
        }
    }

    public void updateMidbvalue(int value) {
        if (value >= 10) {
            ((TextView) findViewById(R.id.dj_lexus_audio_mid)).setText(String.format("%d", Integer.valueOf(value - 10)));
        } else if (value < 10) {
            ((TextView) findViewById(R.id.dj_lexus_audio_mid)).setText(String.format("-%d", Integer.valueOf(10 - value)));
        }
    }

    public void updateTrebvalue(int value) {
        if (value >= 10) {
            ((TextView) findViewById(R.id.dj_lexus_audio_treb)).setText(String.format("%d", Integer.valueOf(value - 10)));
        } else if (value < 10) {
            ((TextView) findViewById(R.id.dj_lexus_audio_treb)).setText(String.format("-%d", Integer.valueOf(10 - value)));
        }
    }

    public void updateFadvalue(int value) {
        if (value == 10) {
            ((TextView) findViewById(R.id.dj_lexus_audio_fad)).setText(String.format("%d", Integer.valueOf(value - 10)));
        } else if (value > 10) {
            ((TextView) findViewById(R.id.dj_lexus_audio_fad)).setText(String.format("R%d", Integer.valueOf(value - 10)));
        } else if (value < 10) {
            ((TextView) findViewById(R.id.dj_lexus_audio_fad)).setText(String.format("F%d", Integer.valueOf(10 - value)));
        }
    }

    public void updateBanvalue(int value) {
        if (value == 10) {
            ((TextView) findViewById(R.id.dj_lexus_audio_ban)).setText(String.format("%d", Integer.valueOf(value - 10)));
        } else if (value > 10) {
            ((TextView) findViewById(R.id.dj_lexus_audio_ban)).setText(String.format("R%d", Integer.valueOf(value - 10)));
        } else if (value < 10) {
            ((TextView) findViewById(R.id.dj_lexus_audio_ban)).setText(String.format("L%d", Integer.valueOf(10 - value)));
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        isFront = true;
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
