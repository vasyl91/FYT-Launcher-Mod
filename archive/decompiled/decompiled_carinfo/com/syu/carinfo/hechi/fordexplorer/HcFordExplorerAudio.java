package com.syu.carinfo.hechi.fordexplorer;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class HcFordExplorerAudio extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static HcFordExplorerRadio mInit;
    int eqVol = 0;
    int eqBal = 0;
    int eqFad = 0;
    int eqBass = 0;
    int eqMid = 0;
    int eqTreb = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 123:
                    HcFordExplorerAudio.this.updateVolvalue(value);
                    HcFordExplorerAudio.this.eqVol = value;
                    break;
                case 124:
                    HcFordExplorerAudio.this.updateBanvalue(value);
                    HcFordExplorerAudio.this.eqBal = value;
                    break;
                case 125:
                    HcFordExplorerAudio.this.updateFadvalue(value);
                    HcFordExplorerAudio.this.eqFad = value;
                    break;
                case 126:
                    HcFordExplorerAudio.this.updateBassbvalue(value);
                    HcFordExplorerAudio.this.eqBass = value;
                    break;
                case 127:
                    HcFordExplorerAudio.this.updateMidbvalue(value);
                    HcFordExplorerAudio.this.eqMid = value;
                    break;
                case 128:
                    HcFordExplorerAudio.this.updateTrebvalue(value);
                    HcFordExplorerAudio.this.eqTreb = value;
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
        findViewById(R.id.btn_lexus_vol_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[123];
                if (value < 30) {
                    value++;
                }
                DataCanbus.PROXY.cmd(6, new int[]{value, HcFordExplorerAudio.this.eqBal, HcFordExplorerAudio.this.eqFad, HcFordExplorerAudio.this.eqBass, HcFordExplorerAudio.this.eqMid, HcFordExplorerAudio.this.eqTreb}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_vol_munit).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[123];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(6, new int[]{value, HcFordExplorerAudio.this.eqBal, HcFordExplorerAudio.this.eqFad, HcFordExplorerAudio.this.eqBass, HcFordExplorerAudio.this.eqMid, HcFordExplorerAudio.this.eqTreb}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_treb_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[128];
                if (value < 17) {
                    value++;
                }
                DataCanbus.PROXY.cmd(6, new int[]{HcFordExplorerAudio.this.eqVol, HcFordExplorerAudio.this.eqBal, HcFordExplorerAudio.this.eqFad, HcFordExplorerAudio.this.eqBass, HcFordExplorerAudio.this.eqMid, value}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_treb_munit).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[128];
                if (value > 3) {
                    value--;
                }
                DataCanbus.PROXY.cmd(6, new int[]{HcFordExplorerAudio.this.eqVol, HcFordExplorerAudio.this.eqBal, HcFordExplorerAudio.this.eqFad, HcFordExplorerAudio.this.eqBass, HcFordExplorerAudio.this.eqMid, value}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_mid_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[127];
                if (value < 17) {
                    value++;
                }
                DataCanbus.PROXY.cmd(6, new int[]{HcFordExplorerAudio.this.eqVol, HcFordExplorerAudio.this.eqBal, HcFordExplorerAudio.this.eqFad, HcFordExplorerAudio.this.eqBass, value, HcFordExplorerAudio.this.eqTreb}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_mid_munit).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[127];
                if (value > 3) {
                    value--;
                }
                DataCanbus.PROXY.cmd(6, new int[]{HcFordExplorerAudio.this.eqVol, HcFordExplorerAudio.this.eqBal, HcFordExplorerAudio.this.eqFad, HcFordExplorerAudio.this.eqBass, value, HcFordExplorerAudio.this.eqTreb}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_bass_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[126];
                if (value < 17) {
                    value++;
                }
                DataCanbus.PROXY.cmd(6, new int[]{HcFordExplorerAudio.this.eqVol, HcFordExplorerAudio.this.eqBal, HcFordExplorerAudio.this.eqFad, value, HcFordExplorerAudio.this.eqMid, HcFordExplorerAudio.this.eqTreb}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_bass_munit).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[126];
                if (value > 3) {
                    value--;
                }
                DataCanbus.PROXY.cmd(6, new int[]{HcFordExplorerAudio.this.eqVol, HcFordExplorerAudio.this.eqBal, HcFordExplorerAudio.this.eqFad, value, HcFordExplorerAudio.this.eqMid, HcFordExplorerAudio.this.eqTreb}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_fad_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[125];
                if (value < 17) {
                    value++;
                }
                DataCanbus.PROXY.cmd(6, new int[]{HcFordExplorerAudio.this.eqVol, HcFordExplorerAudio.this.eqBal, value, HcFordExplorerAudio.this.eqBass, HcFordExplorerAudio.this.eqMid, HcFordExplorerAudio.this.eqTreb}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_fad_munit).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[125];
                if (value > 3) {
                    value--;
                }
                DataCanbus.PROXY.cmd(6, new int[]{HcFordExplorerAudio.this.eqVol, HcFordExplorerAudio.this.eqBal, value, HcFordExplorerAudio.this.eqBass, HcFordExplorerAudio.this.eqMid, HcFordExplorerAudio.this.eqTreb}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_ban_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[124];
                if (value < 17) {
                    value++;
                }
                DataCanbus.PROXY.cmd(6, new int[]{HcFordExplorerAudio.this.eqVol, value, HcFordExplorerAudio.this.eqFad, HcFordExplorerAudio.this.eqBass, HcFordExplorerAudio.this.eqMid, HcFordExplorerAudio.this.eqTreb}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_ban_munit).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[124];
                if (value > 3) {
                    value--;
                }
                DataCanbus.PROXY.cmd(6, new int[]{HcFordExplorerAudio.this.eqVol, value, HcFordExplorerAudio.this.eqFad, HcFordExplorerAudio.this.eqBass, HcFordExplorerAudio.this.eqMid, HcFordExplorerAudio.this.eqTreb}, null, null);
            }
        });
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
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
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
