package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

public class WarnLuzHpAudiAir {
    private static WarnLuzHpAudiAir mInstance;
    private int ShowLeftTempTime = 0;
    private int ShowRightTempTime = 0;
    Context context;
    private ImageView mImageAirLeft;
    private ImageView mImageAirRight;
    private TextView mTextTempLeft;
    private TextView mTextTempRight;
    private View sWarnContent;

    public static WarnLuzHpAudiAir getInstance() {
        if (mInstance == null) {
            mInstance = new WarnLuzHpAudiAir();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null && DataCanbus.DATA[153] != 0) {
            WarnUtils.showWindow();
        } else if (window.isShowing()) {
            window.dismiss();
        }
    }

    public static void postDelayedShow(Runnable runnable, int delay) {
        if (runnable != null) {
            HandlerUI.getInstance().removeCallbacks(runnable);
            HandlerUI.getInstance().postDelayed(runnable, delay);
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_450_audi_air, null, false);
            this.mImageAirLeft = this.sWarnContent.findViewById(R.id.iv_air_left);
            this.mImageAirRight = this.sWarnContent.findViewById(R.id.iv_air_right);
            this.mTextTempLeft = this.sWarnContent.findViewById(R.id.tv_airtemp_left);
            this.mTextTempRight = this.sWarnContent.findViewById(R.id.tv_airtemp_right);
        }
        this.mTextTempLeft.setVisibility(0);
        this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit).setVisibility(0);
        int showvalue = DataCanbus.DATA[153];
        if (((showvalue >> 3) & 1) == 1) {
            this.ShowLeftTempTime = 0;
            this.ShowRightTempTime = 0;
            ClearTextLeftShow();
            ClearTextRightShow();
            ShowAirLeftWinlev();
            ShowAirRightWinlev();
        } else if (((showvalue >> 2) & 1) == 1) {
            this.ShowLeftTempTime = 0;
            this.ShowRightTempTime = 0;
            ClearTextLeftShow();
            ClearTextRightShow();
            ShowAirLeftWinMode();
            ShowAirRightWinMode();
        } else if (((showvalue >> 5) & 1) == 1) {
            this.ShowLeftTempTime = 1;
            ShowAirLeftTemp();
            if (this.ShowRightTempTime > 0) {
                ShowAirRightTemp();
            } else {
                ClearTextRightShow();
                this.mImageAirRight.setBackgroundResource(R.drawable.bk_450_air);
            }
        } else if (((showvalue >> 4) & 1) == 1) {
            this.ShowRightTempTime = 1;
            ShowAirRightTemp();
            if (this.ShowLeftTempTime > 0) {
                ShowAirLeftTemp();
            } else {
                ClearTextLeftShow();
                this.mImageAirLeft.setBackgroundResource(R.drawable.bk_450_air);
            }
        } else if (((showvalue >> 1) & 1) == 1) {
            this.ShowLeftTempTime = 0;
            this.ShowRightTempTime = 0;
            ClearTextLeftShow();
            ClearTextRightShow();
            ShowAirLeftSeatHot();
        } else if (((showvalue >> 0) & 1) == 1) {
            this.ShowLeftTempTime = 0;
            this.ShowRightTempTime = 0;
            ClearTextLeftShow();
            ClearTextRightShow();
            ShowAirRightSeatHot();
        } else {
            this.ShowLeftTempTime = 0;
            this.ShowRightTempTime = 0;
            ClearTextLeftShow();
            ClearTextRightShow();
            this.mImageAirLeft.setBackgroundResource(R.drawable.bk_450_air);
            this.mImageAirRight.setBackgroundResource(R.drawable.bk_450_air);
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }

    private void ShowAirLeftTemp() {
        switch (DataCanbus.DATA[27]) {
            case -3:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left26);
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_pic)).setText("HI");
                break;
            case -2:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left0);
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_pic)).setText("LO");
                break;
            case 1:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left1);
                this.mTextTempLeft.setText("16.0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 2:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left2);
                this.mTextTempLeft.setText("16.5");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 3:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left3);
                this.mTextTempLeft.setText("17.0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 4:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left4);
                this.mTextTempLeft.setText("17.5");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 5:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left5);
                this.mTextTempLeft.setText("18.0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 6:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left6);
                this.mTextTempLeft.setText("18.5");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 7:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left7);
                this.mTextTempLeft.setText("19.0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 8:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left8);
                this.mTextTempLeft.setText("19.5");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 9:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left9);
                this.mTextTempLeft.setText("20.0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 10:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left10);
                this.mTextTempLeft.setText("20.5");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 11:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left11);
                this.mTextTempLeft.setText("21.0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 12:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left12);
                this.mTextTempLeft.setText("21.5");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 13:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left13);
                this.mTextTempLeft.setText("22.0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 14:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left14);
                this.mTextTempLeft.setText("22.5");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 15:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left15);
                this.mTextTempLeft.setText("23.0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 16:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left16);
                this.mTextTempLeft.setText("23.5");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 17:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left17);
                this.mTextTempLeft.setText("24.0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 18:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left18);
                this.mTextTempLeft.setText("24.5");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 19:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left19);
                this.mTextTempLeft.setText("25.0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 20:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left20);
                this.mTextTempLeft.setText("25.5");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 21:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left21);
                this.mTextTempLeft.setText("26.0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 22:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left22);
                this.mTextTempLeft.setText("26.5");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 23:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left23);
                this.mTextTempLeft.setText("27.0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 24:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left24);
                this.mTextTempLeft.setText("27.5");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 25:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left25);
                this.mTextTempLeft.setText("28.0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
        }
        if (DataCanbus.DATA[27] >= 0) {
            this.mTextTempLeft.setVisibility(0);
            this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit).setVisibility(0);
            this.sWarnContent.findViewById(R.id.tv_airtemp_left_pic).setVisibility(8);
        } else {
            this.mTextTempLeft.setVisibility(8);
            this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit).setVisibility(8);
            this.sWarnContent.findViewById(R.id.tv_airtemp_left_pic).setVisibility(0);
        }
    }

    private void ShowAirRightTemp() {
        switch (DataCanbus.DATA[28]) {
            case -3:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right26);
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_pic)).setText("HI");
                break;
            case -2:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right0);
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_pic)).setText("LO");
                break;
            case 1:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right1);
                this.mTextTempRight.setText("16.0 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 2:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right2);
                this.mTextTempRight.setText("16.5 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 3:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right3);
                this.mTextTempRight.setText("17.0 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 4:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right4);
                this.mTextTempRight.setText("17.5 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 5:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right5);
                this.mTextTempRight.setText("18.0 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 6:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right6);
                this.mTextTempRight.setText("18.5 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 7:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right7);
                this.mTextTempRight.setText("19.0 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 8:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right8);
                this.mTextTempRight.setText("19.5 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 9:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right9);
                this.mTextTempRight.setText("20.0 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 10:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right10);
                this.mTextTempRight.setText("20.5 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 11:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right11);
                this.mTextTempRight.setText("21.0 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 12:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right12);
                this.mTextTempRight.setText("21.5 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 13:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right13);
                this.mTextTempRight.setText("22.0 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 14:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right14);
                this.mTextTempRight.setText("22.5 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 15:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right15);
                this.mTextTempRight.setText("23.0 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 16:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right16);
                this.mTextTempRight.setText("23.5 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 17:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right17);
                this.mTextTempRight.setText("24.0 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 18:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right18);
                this.mTextTempRight.setText("24.5 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 19:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right19);
                this.mTextTempRight.setText("25.0 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 20:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right20);
                this.mTextTempRight.setText("25.5 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 21:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right21);
                this.mTextTempRight.setText("26.0 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 22:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right22);
                this.mTextTempRight.setText("26.5 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 23:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right23);
                this.mTextTempRight.setText("27.0 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 24:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right24);
                this.mTextTempRight.setText("27.5 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 25:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right25);
                this.mTextTempRight.setText("28.0 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
        }
        if (DataCanbus.DATA[28] >= 0) {
            this.mTextTempRight.setVisibility(0);
            this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit).setVisibility(0);
            this.sWarnContent.findViewById(R.id.tv_airtemp_right_pic).setVisibility(8);
        } else {
            this.mTextTempRight.setVisibility(8);
            this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit).setVisibility(8);
            this.sWarnContent.findViewById(R.id.tv_airtemp_right_pic).setVisibility(0);
        }
    }

    private void ShowAirLeftWinlev() {
        switch (DataCanbus.DATA[21]) {
            case 1:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winlev_left1);
                break;
            case 2:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winlev_left2);
                break;
            case 3:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winlev_left3);
                break;
            case 4:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winlev_left4);
                break;
            case 5:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winlev_left5);
                break;
            case 6:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winlev_left6);
                break;
            case 7:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winlev_left7);
                break;
            case 8:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winlev_left8);
                break;
            case 9:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winlev_left9);
                break;
            case 10:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winlev_left10);
                break;
            case 11:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winlev_left11);
                break;
            case 12:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winlev_left12);
                break;
        }
    }

    private void ShowAirRightWinlev() {
        switch (DataCanbus.DATA[25]) {
            case 1:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winlev_right1);
                break;
            case 2:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winlev_right2);
                break;
            case 3:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winlev_right3);
                break;
            case 4:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winlev_right4);
                break;
            case 5:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winlev_right5);
                break;
            case 6:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winlev_right6);
                break;
            case 7:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winlev_right7);
                break;
            case 8:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winlev_right8);
                break;
            case 9:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winlev_right9);
                break;
            case 10:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winlev_right10);
                break;
            case 11:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winlev_right11);
                break;
            case 12:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winlev_right12);
                break;
        }
    }

    private void ShowAirLeftSeatHot() {
        switch (DataCanbus.DATA[29]) {
            case 0:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_seathot_left0);
                break;
            case 1:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_seathot_left1);
                break;
            case 2:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_seathot_left2);
                break;
            case 3:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_seathot_left3);
                break;
            case 4:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_seathot_left4);
                break;
            case 5:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_seathot_left5);
                break;
            case 6:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_seathot_left6);
                break;
        }
    }

    private void ShowAirRightSeatHot() {
        switch (DataCanbus.DATA[30]) {
            case 0:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_seathot_right0);
                break;
            case 1:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_seathot_right1);
                break;
            case 2:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_seathot_right2);
                break;
            case 3:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_seathot_right3);
                break;
            case 4:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_seathot_right4);
                break;
            case 5:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_seathot_right5);
                break;
            case 6:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_seathot_right6);
                break;
        }
    }

    private void ShowAirLeftWinMode() {
        switch (DataCanbus.DATA[77]) {
            case 0:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winmode_left0);
                break;
            case 1:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winmode_left1);
                break;
            case 2:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winmode_left2);
                break;
            case 3:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winmode_left3);
                break;
            case 4:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winmode_left4);
                break;
            case 5:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winmode_left5);
                break;
            case 6:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winmode_left6);
                break;
            case 7:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winmode_left7);
                break;
            case 8:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winmode_left8);
                break;
        }
    }

    private void ShowAirRightWinMode() {
        switch (DataCanbus.DATA[87]) {
            case 0:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winmode_right0);
                break;
            case 1:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winmode_right1);
                break;
            case 2:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winmode_right2);
                break;
            case 3:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winmode_right3);
                break;
            case 4:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winmode_right4);
                break;
            case 5:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winmode_right5);
                break;
            case 6:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winmode_right6);
                break;
            case 7:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winmode_right7);
                break;
            case 8:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winmode_right8);
                break;
        }
    }

    private void ClearTextLeftShow() {
        this.mTextTempLeft.setText("");
        ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("");
        ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_pic)).setText("");
    }

    private void ClearTextRightShow() {
        this.mTextTempRight.setText("");
        ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("");
        ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_pic)).setText("");
    }
}
