package com.android.launcher66;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.fyt.widget.RadioRuler;
import com.syu.car.CarStates;
import com.syu.remote.Callback;
import com.syu.widget.DateRadioProvider;
import java.math.BigDecimal;
import share.Config;
import share.ResValue;

/**
 * The radio widget on the home screen: band and frequency from the MCU (refreshRadioBand,
 * refreshRadioFreq) and its prev / pause / next / band buttons. Split out of Launcher, which keeps
 * the entry points CellLayout calls.
 */
final class LauncherRadioWidget {

    // Not final: field initializers below use it in lambdas, which javac rejects for a blank final.
    private Launcher mLauncher;

    LauncherRadioWidget(Launcher launcher) {
        mLauncher = launcher;
    }

    RadioRuler img_freq_point;

    Button mRadioBandButton;

    Button mRadioNextButton;

    Button mRadioPauseButton;

    Button mRadioPrevButton;

    TextView tvBand;

    TextView tvCurFreq;

    TextView tvUnit;

    public String freq = "87.50";

    public int radioFreqState = 0;

    public String radioFreq = "87.50";

    /**
     * Checks whether the radio is the current MCU source. The previous process
     * scanning returned true as long as com.syu.radio was alive — which was almost
     * always — causing the widget buttons and refreshRadioFreq to react to a state
     * that had nothing to do with what was actually playing.
     */
    boolean isRadioPlaying() {
        return CarStates.mAppID == 1;
    }

    int radioBand = -1;

    Callback.OnRefreshLisenter refreshRadioBand = new Callback.OnRefreshLisenter() { 
        @Override
        public void onRefresh(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 0 && ints != null && ints.length > 0) {
                int band = ints[0];
                Log.d(Launcher.TAG, "-------->>> FinalRadio.U_BAND" + band);
                if (band == 65536 || band == 65537 || band == 65538) {
                    radioBand = 0;
                } else if (band == 0 || band == 1) {
                    radioBand = 1;
                }
            }
        }
    };

    Callback.OnRefreshLisenter refreshRadioFreq = new Callback.OnRefreshLisenter() { 
        @Override
        public void onRefresh(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 1 && ints != null && ints.length > 0) {
                radioFreqState = ints[0];
                if (ints[0] > 5000) {
                    int fmFreq = ints[0];
                    freq = freqToString(fmFreq);
                    String str = freqToString(ints[0]);
                    String freqs = String.valueOf(str.substring(0, str.length() - 2)) + "." + str.substring(str.length() - 2, str.length());
                    radioFreq = freqs;
                    if (tvCurFreq != null) {
                        tvCurFreq.setText(freqs);
                    }
                    if (tvBand != null) {
                        if (tvBand.getBackground() != null) {
                            tvBand.setBackgroundResource(ResValue.getInstance().fm);
                        } else {
                            tvBand.setText("FM");
                        }
                    }
                    if (tvUnit != null) {
                        tvUnit.setText("MHz");
                    }
                    if (img_freq_point != null) {
                        img_freq_point.setTargetMarkAnim(fmFreq, 8750, 10800);
                    }
                } else if (ints[0] < 5000 && ints[0] > 500) {
                    freq = freqToString(ints[0]);
                    radioFreq = freq;
                    if (tvCurFreq != null) {
                        tvCurFreq.setText(freq);
                    }
                    if (tvBand != null) {
                        if (tvBand.getBackground() != null) {
                            tvBand.setBackgroundResource(ResValue.getInstance().am);
                        } else {
                            tvBand.setText("AM");
                        }
                    }
                    if (tvUnit != null) {
                        tvUnit.setText("KHz");
                    }
                    if (img_freq_point != null) {
                        img_freq_point.setTargetMarkAnim(ints[0], 522, 1620);
                    }
                }
            }
            mLauncher.requestWidgetUpdate(DateRadioProvider.class);
        }
    };

    public void initRadioWidgetView(View radioWidgetView) {
        if (radioWidgetView != null) {
            mRadioPrevButton = radioWidgetView.findViewById(ResValue.getInstance().Radiobutton_prev);
            mRadioNextButton = radioWidgetView.findViewById(ResValue.getInstance().Radiobutton_next);
            mLauncher.mMusicWidget.setWidgetButtonsTint(mRadioPrevButton);
            mLauncher.mMusicWidget.setWidgetButtonsTint(mRadioNextButton);
            mRadioPauseButton = radioWidgetView.findViewById(ResValue.getInstance().Radiobutton_pause);
            mRadioBandButton = radioWidgetView.findViewById(ResValue.getInstance().radio_btn_band);
            mLauncher.mRadioIcon = radioWidgetView.findViewById(ResValue.getInstance().mRadioIcon);
            tvBand = radioWidgetView.findViewById(ResValue.getInstance().tv_band);
            tvUnit = radioWidgetView.findViewById(ResValue.getInstance().tv_unit);
            img_freq_point = radioWidgetView.findViewById(ResValue.getInstance().radio_point);
            tvCurFreq = radioWidgetView.findViewById(ResValue.getInstance().tv_freq);
            mLauncher.mTvRadio = radioWidgetView.findViewById(ResValue.getInstance().tv_radio);
            mLauncher.putCustomView(Config.WS_Radio, radioWidgetView.findViewById(ResValue.getInstance().rl_radio));
            if (mLauncher.getCustomView(Config.WS_Radio) != null) {
                mLauncher.getCustomView(Config.WS_Radio).setOnClickListener(mLauncher);
            }
        }
    }

    public void bindRadioWidgetOnclickListener() {
        if (mRadioPrevButton != null) {
            mRadioPrevButton.setOnClickListener(v -> {
                if (CarStates.mAppID == 1 && mLauncher.tools != null) {
                    mLauncher.tools.sendInt(1, 1, 0);
                }
            });
        }
        if (mRadioBandButton != null) {
            mRadioBandButton.setOnClickListener(v -> {
                if (CarStates.mAppID == 1 && mLauncher.tools != null) {
                    Log.d(Launcher.TAG, "---------------------->>> mRadioBandButton");
                    mLauncher.tools.sendInt(1, 11, -1);
                }
            });
        }
        if (mRadioPauseButton != null) {
            mRadioPauseButton.setOnClickListener(v -> {
                if (mLauncher.tools != null) {
                    if (CarStates.mAppID == 1) {
                        mLauncher.tools.sendInt(0, 0, 0);
                        this.mRadioPauseButton.setBackgroundResource(ResValue.getInstance().radio_pause_icon);
                    } else {
                        mLauncher.tools.sendInt(0, 0, 1);
                        this.mRadioPauseButton.setBackgroundResource(ResValue.getInstance().radio_playpause_icon);
                    }
                }
            });
        }
        if (mRadioNextButton != null) {
            mRadioNextButton.setOnClickListener(v -> {
                if (CarStates.mAppID == 1 && mLauncher.tools != null) {
                    mLauncher.tools.sendInt(1, 0, 0);
                }
            });
        }
    }

    String freqToString(String freq2) {
        float vals = Float.parseFloat(freq2);
        float val = vals / 1.0f;
        BigDecimal bd = new BigDecimal(val);
        return bd.setScale(0, 4).toString();
    }

    public String freqToString(int freq2) {
        float val = freq2 / 1.0f;
        BigDecimal bd = new BigDecimal(val);
        return bd.setScale(0, 4).toString();
    }
}
