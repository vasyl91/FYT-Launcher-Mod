package com.syu.carinfo.hc.chrysler;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ChryslerCarEqActi extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    int carvol = 0;
    int carbalance = 0;
    int carfader = 0;
    int carbass = 0;
    int carmiddle = 0;
    int cartreble = 0;
    private final IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 0:
                    ChryslerCarEqActi.this.updateBassbvalue(value);
                    break;
                case 1:
                    ChryslerCarEqActi.this.updateMidbvalue(value);
                    break;
                case 2:
                    ChryslerCarEqActi.this.updateTrebvalue(value);
                    break;
                case 3:
                    ChryslerCarEqActi.this.updateFadvalue(value);
                    break;
                case 4:
                    ChryslerCarEqActi.this.updateBanvalue(value);
                    break;
                case 5:
                    ChryslerCarEqActi.this.updateVolvalue(value);
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

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.notifyCanbus);
    }

    public void updateVolvalue(int value) {
        this.carvol = value;
        ((TextView) findViewById(R.id.dj_lexus_audio_vol)).setText(String.format("%d", Integer.valueOf(value)));
    }

    public void updateBassbvalue(int value) {
        this.carbass = value;
        if (value >= 10) {
            ((TextView) findViewById(R.id.dj_lexus_audio_bass)).setText(String.format("%d", Integer.valueOf(value - 10)));
        } else if (value < 10) {
            ((TextView) findViewById(R.id.dj_lexus_audio_bass)).setText(String.format("-%d", Integer.valueOf(10 - value)));
        }
    }

    public void updateMidbvalue(int value) {
        this.carmiddle = value;
        if (value >= 10) {
            ((TextView) findViewById(R.id.dj_lexus_audio_mid)).setText(String.format("%d", Integer.valueOf(value - 10)));
        } else if (value < 10) {
            ((TextView) findViewById(R.id.dj_lexus_audio_mid)).setText(String.format("-%d", Integer.valueOf(10 - value)));
        }
    }

    public void updateTrebvalue(int value) {
        this.cartreble = value;
        if (value >= 10) {
            ((TextView) findViewById(R.id.dj_lexus_audio_treb)).setText(String.format("%d", Integer.valueOf(value - 10)));
        } else if (value < 10) {
            ((TextView) findViewById(R.id.dj_lexus_audio_treb)).setText(String.format("-%d", Integer.valueOf(10 - value)));
        }
    }

    public void updateFadvalue(int value) {
        this.carfader = value;
        if (value == 10) {
            ((TextView) findViewById(R.id.dj_lexus_audio_fad)).setText(String.format("%d", Integer.valueOf(value - 10)));
        } else if (value > 10) {
            ((TextView) findViewById(R.id.dj_lexus_audio_fad)).setText(String.format("R%d", Integer.valueOf(value - 10)));
        } else if (value < 10) {
            ((TextView) findViewById(R.id.dj_lexus_audio_fad)).setText(String.format("F%d", Integer.valueOf(10 - value)));
        }
    }

    public void updateBanvalue(int value) {
        this.carbalance = value;
        if (value == 10) {
            ((TextView) findViewById(R.id.dj_lexus_audio_ban)).setText(String.format("%d", Integer.valueOf(value - 10)));
        } else if (value > 10) {
            ((TextView) findViewById(R.id.dj_lexus_audio_ban)).setText(String.format("R%d", Integer.valueOf(value - 10)));
        } else if (value < 10) {
            ((TextView) findViewById(R.id.dj_lexus_audio_ban)).setText(String.format("L%d", Integer.valueOf(10 - value)));
        }
    }

    public void SendEqCmd() {
        DataCanbus.PROXY.cmd(0, new int[]{this.carvol, this.carbalance, this.carfader, this.carbass, this.carmiddle, this.cartreble}, null, null);
    }

    public void init() {
        findViewById(R.id.btn_lexus_vol_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                ChryslerCarEqActi.this.carvol++;
                if (ChryslerCarEqActi.this.carvol > 38) {
                    ChryslerCarEqActi.this.carvol = 38;
                }
                ChryslerCarEqActi.this.SendEqCmd();
            }
        });
        findViewById(R.id.btn_lexus_vol_munit).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                ChryslerCarEqActi chryslerCarEqActi = ChryslerCarEqActi.this;
                chryslerCarEqActi.carvol--;
                if (ChryslerCarEqActi.this.carvol < 0) {
                    ChryslerCarEqActi.this.carvol = 0;
                }
                ChryslerCarEqActi.this.SendEqCmd();
            }
        });
        findViewById(R.id.btn_lexus_treb_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                ChryslerCarEqActi.this.cartreble++;
                if (ChryslerCarEqActi.this.cartreble > 19) {
                    ChryslerCarEqActi.this.cartreble = 19;
                }
                ChryslerCarEqActi.this.SendEqCmd();
            }
        });
        findViewById(R.id.btn_lexus_treb_munit).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                ChryslerCarEqActi chryslerCarEqActi = ChryslerCarEqActi.this;
                chryslerCarEqActi.cartreble--;
                if (ChryslerCarEqActi.this.cartreble < 1) {
                    ChryslerCarEqActi.this.cartreble = 1;
                }
                ChryslerCarEqActi.this.SendEqCmd();
            }
        });
        findViewById(R.id.btn_lexus_mid_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                ChryslerCarEqActi.this.carmiddle++;
                if (ChryslerCarEqActi.this.carmiddle > 19) {
                    ChryslerCarEqActi.this.carmiddle = 19;
                }
                ChryslerCarEqActi.this.SendEqCmd();
            }
        });
        findViewById(R.id.btn_lexus_mid_munit).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                ChryslerCarEqActi chryslerCarEqActi = ChryslerCarEqActi.this;
                chryslerCarEqActi.carmiddle--;
                if (ChryslerCarEqActi.this.carmiddle < 1) {
                    ChryslerCarEqActi.this.carmiddle = 1;
                }
                ChryslerCarEqActi.this.SendEqCmd();
            }
        });
        findViewById(R.id.btn_lexus_bass_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                ChryslerCarEqActi.this.carbass++;
                if (ChryslerCarEqActi.this.carbass > 19) {
                    ChryslerCarEqActi.this.carbass = 19;
                }
                ChryslerCarEqActi.this.SendEqCmd();
            }
        });
        findViewById(R.id.btn_lexus_bass_munit).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                ChryslerCarEqActi chryslerCarEqActi = ChryslerCarEqActi.this;
                chryslerCarEqActi.carbass--;
                if (ChryslerCarEqActi.this.carbass < 1) {
                    ChryslerCarEqActi.this.carbass = 1;
                }
                ChryslerCarEqActi.this.SendEqCmd();
            }
        });
        findViewById(R.id.btn_lexus_fad_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                ChryslerCarEqActi.this.carfader++;
                if (ChryslerCarEqActi.this.carfader > 19) {
                    ChryslerCarEqActi.this.carfader = 19;
                }
                ChryslerCarEqActi.this.SendEqCmd();
            }
        });
        findViewById(R.id.btn_lexus_fad_munit).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                ChryslerCarEqActi chryslerCarEqActi = ChryslerCarEqActi.this;
                chryslerCarEqActi.carfader--;
                if (ChryslerCarEqActi.this.carfader < 1) {
                    ChryslerCarEqActi.this.carfader = 1;
                }
                ChryslerCarEqActi.this.SendEqCmd();
            }
        });
        findViewById(R.id.btn_lexus_ban_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                ChryslerCarEqActi.this.carbalance++;
                if (ChryslerCarEqActi.this.carbalance > 19) {
                    ChryslerCarEqActi.this.carbalance = 19;
                }
                ChryslerCarEqActi.this.SendEqCmd();
            }
        });
        findViewById(R.id.btn_lexus_ban_munit).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                ChryslerCarEqActi chryslerCarEqActi = ChryslerCarEqActi.this;
                chryslerCarEqActi.carbalance--;
                if (ChryslerCarEqActi.this.carbalance < 1) {
                    ChryslerCarEqActi.this.carbalance = 1;
                }
                ChryslerCarEqActi.this.SendEqCmd();
            }
        });
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
        if (event.getAction() != 0) {
            event.getAction();
            return false;
        }
        return false;
    }
}
