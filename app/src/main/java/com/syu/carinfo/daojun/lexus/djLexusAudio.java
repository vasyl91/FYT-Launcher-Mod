package com.syu.carinfo.daojun.lexus;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class djLexusAudio extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static djLexusRadio mInit;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.daojun.lexus.djLexusAudio.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 38:
                    djLexusAudio.this.updateBassbvalue(value);
                    break;
                case 39:
                    djLexusAudio.this.updateMidbvalue(value);
                    break;
                case 40:
                    djLexusAudio.this.updateTrebvalue(value);
                    break;
                case 41:
                    djLexusAudio.this.updateFadvalue(value);
                    break;
                case 42:
                    djLexusAudio.this.updateBanvalue(value);
                    break;
                case 43:
                    djLexusAudio.this.updateVolvalue(value);
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
        findViewById(R.id.btn_lexus_vol_plus).setOnTouchListener(this);
        findViewById(R.id.btn_lexus_vol_munit).setOnTouchListener(this);
        findViewById(R.id.btn_lexus_treb_plus).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusAudio.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{13, 1}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_treb_munit).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusAudio.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{13, 2}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_mid_plus).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusAudio.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{16, 1}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_mid_munit).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusAudio.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{16, 2}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_bass_plus).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusAudio.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{12, 1}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_bass_munit).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusAudio.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{12, 2}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_fad_plus).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusAudio.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{14, 1}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_fad_munit).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusAudio.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{14, 2}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_ban_plus).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusAudio.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{15, 1}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_ban_munit).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusAudio.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{15, 2}, null, null);
            }
        });
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.notifyCanbus);
    }

    public void updateVolvalue(int value) {
        ((TextView) findViewById(R.id.dj_lexus_audio_vol)).setText(String.format("%d", Integer.valueOf(value)));
    }

    public void updateBassbvalue(int value) {
        if (value >= 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_bass)).setText(String.format("%d", Integer.valueOf(value - 7)));
        } else if (value < 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_bass)).setText(String.format("-%d", Integer.valueOf(7 - value)));
        }
    }

    public void updateMidbvalue(int value) {
        if (value >= 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_mid)).setText(String.format("%d", Integer.valueOf(value - 7)));
        } else if (value < 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_mid)).setText(String.format("-%d", Integer.valueOf(7 - value)));
        }
    }

    public void updateTrebvalue(int value) {
        if (value >= 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_treb)).setText(String.format("%d", Integer.valueOf(value - 7)));
        } else if (value < 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_treb)).setText(String.format("-%d", Integer.valueOf(7 - value)));
        }
    }

    public void updateFadvalue(int value) {
        if (value == 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_fad)).setText(String.format("%d", Integer.valueOf(value - 7)));
        } else if (value > 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_fad)).setText(String.format("R%d", Integer.valueOf(value - 7)));
        } else if (value < 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_fad)).setText(String.format("F%d", Integer.valueOf(7 - value)));
        }
    }

    public void updateBanvalue(int value) {
        if (value == 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_ban)).setText(String.format("%d", Integer.valueOf(value - 7)));
        } else if (value > 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_ban)).setText(String.format("R%d", Integer.valueOf(value - 7)));
        } else if (value < 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_ban)).setText(String.format("L%d", Integer.valueOf(7 - value)));
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.btn_lexus_vol_plus /* 2131430913 */:
                    DataCanbus.PROXY.cmd(1, new int[]{2, 1}, null, null);
                    break;
                case R.id.btn_lexus_vol_munit /* 2131430914 */:
                    DataCanbus.PROXY.cmd(1, new int[]{3, 1}, null, null);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.btn_lexus_vol_plus /* 2131430913 */:
                    DataCanbus.PROXY.cmd(1, new int[]{2}, null, null);
                    break;
                case R.id.btn_lexus_vol_munit /* 2131430914 */:
                    DataCanbus.PROXY.cmd(1, new int[]{3}, null, null);
                    break;
            }
        }
        return false;
    }
}
