package com.syu.carinfo.lz.lexusis;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class LuzLexusISAudio extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static LuzLexusISRadio mInit;
    private final IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 63:
                    LuzLexusISAudio.this.updateFadvalue(value);
                    break;
                case 64:
                    LuzLexusISAudio.this.updateBanvalue(value);
                    break;
                case 66:
                    LuzLexusISAudio.this.updateBassbvalue(value);
                    break;
                case 67:
                    LuzLexusISAudio.this.updateTrebvalue(value);
                    break;
                case 68:
                    LuzLexusISAudio.this.updateMidbvalue(value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ////setContentView(R.layout.layout_lz_lexus_caraudio);
        init();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.notifyCanbus);
    }

    public void updateBassbvalue(int value) {
        if (value >= 7) {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.format("%d", Integer.valueOf(value - 7)));
        } else if (value < 7) {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.format("-%d", Integer.valueOf(7 - value)));
        }
    }

    public void updateMidbvalue(int value) {
        if (value >= 7) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.format("%d", Integer.valueOf(value - 7)));
        } else if (value < 7) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.format("-%d", Integer.valueOf(7 - value)));
        }
    }

    public void updateTrebvalue(int value) {
        if (value >= 7) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.format("%d", Integer.valueOf(value - 7)));
        } else if (value < 7) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.format("-%d", Integer.valueOf(7 - value)));
        }
    }

    public void updateFadvalue(int value) {
        if (value == 7) {
            ((TextView) findViewById(R.id.tv_text5)).setText(String.format("%d", Integer.valueOf(value - 7)));
        } else if (value > 7) {
            ((TextView) findViewById(R.id.tv_text5)).setText(String.format("R%d", Integer.valueOf(value - 7)));
        } else if (value < 7) {
            ((TextView) findViewById(R.id.tv_text5)).setText(String.format("F%d", Integer.valueOf(7 - value)));
        }
    }

    public void updateBanvalue(int value) {
        if (value == 7) {
            ((TextView) findViewById(R.id.tv_text4)).setText(String.format("%d", Integer.valueOf(value - 7)));
        } else if (value > 7) {
            ((TextView) findViewById(R.id.tv_text4)).setText(String.format("R%d", Integer.valueOf(value - 7)));
        } else if (value < 7) {
            ((TextView) findViewById(R.id.tv_text4)).setText(String.format("L%d", Integer.valueOf(7 - value)));
        }
    }

    public void init() {
        findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[67];
                if (value < 12) {
                    value++;
                } else if (value < 2) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{5, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[67];
                if (value > 2) {
                    value--;
                } else if (value < 2) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{5, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[68];
                if (value < 12) {
                    value++;
                } else if (value < 2) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{6, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[68];
                if (value > 2) {
                    value--;
                } else if (value < 2) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{6, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus3).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[66];
                if (value < 12) {
                    value++;
                } else if (value < 2) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{4, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus3).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[66];
                if (value > 2) {
                    value--;
                } else if (value < 2) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{4, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus5).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[63];
                if (value < 14) {
                    value++;
                }
                DataCanbus.PROXY.cmd(2, new int[]{1, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus5).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[63];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(2, new int[]{1, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus4).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[64];
                if (value < 14) {
                    value++;
                }
                DataCanbus.PROXY.cmd(2, new int[]{2, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus4).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[64];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(2, new int[]{2, value}, null, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        isFront = true;
        DataCanbus.PROXY.cmd(3, new int[]{49}, null, null);
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
