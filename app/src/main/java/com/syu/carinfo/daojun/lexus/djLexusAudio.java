package com.syu.carinfo.daojun.lexus;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class djLexusAudio extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static djLexusRadio mInit;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 117:
                    djLexusAudio.this.updateBassbvalue(value);
                    break;
                case 118:
                    djLexusAudio.this.updateMidbvalue(value);
                    break;
                case 119:
                    djLexusAudio.this.updateTrebvalue(value);
                    break;
                case 120:
                    djLexusAudio.this.updateFadvalue(value);
                    break;
                case 121:
                    djLexusAudio.this.updateBanvalue(value);
                    break;
                case 122:
                    djLexusAudio.this.updateVolvalue(value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_djlexus_caraudio);
        init();
    }

    public void init() {
        findViewById(R.id.btn_lexus_vol_plus).setOnTouchListener(this);
        findViewById(R.id.btn_lexus_vol_munit).setOnTouchListener(this);
        findViewById(R.id.btn_lexus_treb_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{13, 1}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_treb_munit).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{13, 2}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_mid_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{16, 1}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_mid_munit).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{16, 2}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_bass_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{12, 1}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_bass_munit).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{12, 2}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_fad_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{14, 1}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_fad_munit).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{14, 2}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_ban_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{15, 1}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_ban_munit).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{15, 2}, null, null);
            }
        });
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.btn_lexus_vol_plus /* 2131430889 */:
                    DataCanbus.PROXY.cmd(1, new int[]{2, 1}, null, null);
                    break;
                case R.id.btn_lexus_vol_munit /* 2131430890 */:
                    DataCanbus.PROXY.cmd(1, new int[]{3, 1}, null, null);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.btn_lexus_vol_plus /* 2131430889 */:
                    DataCanbus.PROXY.cmd(1, new int[]{2}, null, null);
                    break;
                case R.id.btn_lexus_vol_munit /* 2131430890 */:
                    DataCanbus.PROXY.cmd(1, new int[]{3}, null, null);
                    break;
            }
        }
        return false;
    }
}
