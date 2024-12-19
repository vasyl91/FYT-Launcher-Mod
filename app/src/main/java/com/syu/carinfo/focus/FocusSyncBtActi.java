package com.syu.carinfo.focus;

import android.content.Intent;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.text.format.DateFormat;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.carinfo.focus.yl.FFuncYLFocus;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.main.DataMain;
import com.syu.module.sound.DataSound;
import com.syu.module.sound.FFuncSound;
import com.syu.util.HandlerUI;
import java.util.Calendar;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class FocusSyncBtActi extends BaseActivity implements View.OnClickListener {
    public static final int U_HIDE_TIME = 1;
    public static final int U_SYSTEM_TIME = 0;
    private static FocusSyncBtActi mInst;
    private Calendar mCalendar;
    private String mFormat;
    private FormatChangeObserver mFormatChangeObserver;
    private ABC mRunLayout1;
    public static boolean isFront = false;
    public static int[] sLineGroup = new int[3];
    public static String sUnicode = "";
    public static int[] sLineIcon = new int[16];
    private boolean isCanTouch = true;
    Handler handler = new Handler() { // from class: com.syu.carinfo.focus.FocusSyncBtActi.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    removeMessages(0);
                    FocusSyncBtActi.this.mCalendar.setTimeInMillis(System.currentTimeMillis());
                    CharSequence text = DateFormat.format(FocusSyncBtActi.this.mFormat, FocusSyncBtActi.this.mCalendar);
                    String ampm = FocusSyncBtActi.this.mCalendar.get(9) == 0 ? "AM" : "PM";
                    if (((TextView) FocusSyncBtActi.this.findViewById(R.id.texttime)) != null) {
                        ((TextView) FocusSyncBtActi.this.findViewById(R.id.texttime)).setText(text);
                        ((TextView) FocusSyncBtActi.this.findViewById(R.id.textampm)).setText(ampm);
                    }
                    sendEmptyMessageDelayed(0, 1000L);
                    break;
                case 1:
                    removeMessages(1);
                    if (((TextView) FocusSyncBtActi.this.findViewById(R.id.sync_playinfo)) != null) {
                        ((TextView) FocusSyncBtActi.this.findViewById(R.id.sync_playinfo)).setText("");
                        break;
                    }
            }
        }
    };
    private IUiNotify mNotifySound = new IUiNotify() { // from class: com.syu.carinfo.focus.FocusSyncBtActi.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 2:
                    if (((TextView) FocusSyncBtActi.this.findViewById(R.id.textvol)) != null) {
                        ((TextView) FocusSyncBtActi.this.findViewById(R.id.textvol)).setText(new StringBuilder().append(DataSound.DATA[2]).toString());
                        break;
                    }
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.focus.FocusSyncBtActi.3
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (DataCanbus.DATA[1000] == 293 || DataCanbus.DATA[1000] == 319 || DataCanbus.DATA[1000] == 65855) {
                switch (updateCode) {
                    case 4:
                        if (ints != null && ints.length > 0) {
                            int value = ints[0];
                            if (value == 1 || value == 2) {
                                ((TextView) FocusSyncBtActi.this.findViewById(R.id.sync_tv_state)).setText("SYNC ON");
                                break;
                            } else {
                                ((TextView) FocusSyncBtActi.this.findViewById(R.id.sync_tv_state)).setText("SYNC OFF");
                                break;
                            }
                        }
                        break;
                    case 5:
                        if (ints != null && ints.length > 0) {
                            int value2 = ints[0];
                            if (value2 == 1 || value2 == 2) {
                                ((TextView) FocusSyncBtActi.this.findViewById(R.id.sync_tv_state)).setText("SYNC ON");
                                break;
                            } else {
                                ((TextView) FocusSyncBtActi.this.findViewById(R.id.sync_tv_state)).setText("SYNC OFF");
                                break;
                            }
                        }
                        break;
                    case 6:
                        FocusSyncBtActi.this.setTime(DataCanbus.DATA[6]);
                        break;
                    case 8:
                        FocusSyncBtActi.sLineIcon = ints;
                        if (FocusSyncBtActi.sLineIcon != null) {
                            FocusSyncBtActi.this.clearBack();
                            if (FocusSyncBtActi.sLineIcon.length >= 16) {
                                FocusSyncBtActi.this.setWCIcon();
                                break;
                            }
                        }
                        break;
                    case 9:
                    case 20:
                        FocusSyncBtActi.sLineGroup = ints;
                        if (strs != null && strs.length > 0) {
                            FocusSyncBtActi.sUnicode = strs[0];
                        }
                        if (FocusSyncBtActi.sLineGroup != null) {
                            FocusSyncBtActi.this.setWCGroupStr();
                            break;
                        }
                    case 43:
                        if (DataCanbus.DATA[43] == 1) {
                            FuncMain.setChannel(13);
                            break;
                        } else if (DataCanbus.DATA[43] == 2) {
                            FuncMain.setChannel(12);
                            break;
                        }
                }
            }
            switch (updateCode) {
                case 1:
                case 19:
                    FocusSyncBtActi.sLineIcon = ints;
                    if (FocusSyncBtActi.sLineIcon != null) {
                        if (!FocusSyncBtActi.this.isCanbusWC()) {
                            if (FocusSyncBtActi.sLineIcon.length >= 3) {
                                FocusSyncBtActi.this.setXPIcon();
                                break;
                            }
                        } else {
                            FocusSyncBtActi.this.clearBack();
                            if (FocusSyncBtActi.sLineIcon.length >= 16) {
                                FocusSyncBtActi.this.setWCIcon();
                                break;
                            }
                        }
                    }
                    break;
                case 2:
                case 20:
                    FocusSyncBtActi.sLineGroup = ints;
                    if (strs != null && strs.length > 0) {
                        FocusSyncBtActi.sUnicode = strs[0];
                    }
                    if (FocusSyncBtActi.sLineGroup != null) {
                        if (!FocusSyncBtActi.this.isCanbusWC()) {
                            FocusSyncBtActi.this.getXPGroupStr();
                            break;
                        } else {
                            FocusSyncBtActi.this.setWCGroupStr();
                            break;
                        }
                    }
                    break;
                case 3:
                    FocusSyncBtActi.this.setTime(DataCanbus.DATA[3]);
                    break;
                case 4:
                case 22:
                    if (ints != null && ints.length > 0) {
                        int value3 = ints[0];
                        if (value3 == 1 || value3 == 2) {
                            ((TextView) FocusSyncBtActi.this.findViewById(R.id.sync_tv_state)).setText("SYNC ON");
                            break;
                        } else {
                            ((TextView) FocusSyncBtActi.this.findViewById(R.id.sync_tv_state)).setText("SYNC OFF");
                            break;
                        }
                    }
                    break;
                case 5:
                case 23:
                    if (ints != null && ints.length > 0) {
                        int value4 = ints[0];
                        if (value4 == 1 || value4 == 2) {
                            ((TextView) FocusSyncBtActi.this.findViewById(R.id.sync_tv_state)).setText("SYNC ON");
                            break;
                        } else {
                            ((TextView) FocusSyncBtActi.this.findViewById(R.id.sync_tv_state)).setText("SYNC OFF");
                            break;
                        }
                    }
                    break;
                case 7:
                    if (ints != null && ints.length > 1) {
                        int value5 = ints[1];
                        if (value5 == 0) {
                            value5 = 2;
                        }
                        FocusSyncBtActi.this.clearBack();
                        switch (value5) {
                            case 1:
                                ((ViewGroup) FocusSyncBtActi.this.findViewById(R.id.sync_layout_line1)).setBackgroundResource(R.drawable.ic_sync_text_gray);
                                break;
                            case 2:
                                ((ViewGroup) FocusSyncBtActi.this.findViewById(R.id.sync_layout_line2)).setBackgroundResource(R.drawable.ic_sync_text_gray);
                                break;
                            case 3:
                                ((ViewGroup) FocusSyncBtActi.this.findViewById(R.id.sync_layout_line3)).setBackgroundResource(R.drawable.ic_sync_text_gray);
                                break;
                            case 4:
                                ((ViewGroup) FocusSyncBtActi.this.findViewById(R.id.sync_layout_line4)).setBackgroundResource(R.drawable.ic_sync_text_gray);
                                break;
                            case 5:
                                ((ViewGroup) FocusSyncBtActi.this.findViewById(R.id.sync_layout_line5)).setBackgroundResource(R.drawable.ic_sync_text_gray);
                                break;
                        }
                    }
                    break;
                case 8:
                    int value6 = DataCanbus.DATA[8];
                    ((TextView) FocusSyncBtActi.this.findViewById(R.id.sync_playinfo)).setText(String.format("%02d:%02d", Integer.valueOf(value6 / 60), Integer.valueOf(value6 % 60)));
                    FocusSyncBtActi.this.hideTimeShow();
                    break;
                case 9:
                case 12:
                    if (ints != null) {
                        HandlerUI.getInstance().removeCallbacks(FocusSyncBtActi.this.setAutoRequest);
                        HandlerUI.getInstance().postDelayed(FocusSyncBtActi.this.setAutoRequest, 1000L);
                        break;
                    }
                case 21:
                    FocusSyncBtActi.this.setTime(DataCanbus.DATA[21]);
                    break;
                case 46:
                    if (DataCanbus.DATA[46] == 1) {
                        FuncMain.setChannel(13);
                        break;
                    } else if (DataCanbus.DATA[46] == 2) {
                        FuncMain.setChannel(12);
                        break;
                    }
            }
        }
    };
    private IUiNotify mNotifyCanbusYL = new IUiNotify() { // from class: com.syu.carinfo.focus.FocusSyncBtActi.4
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 35:
                    if (ints != null && ints.length > 1) {
                        int value = ints[1];
                        if (value == 0) {
                            value = 2;
                        }
                        FocusSyncBtActi.this.clearBack();
                        switch (value) {
                            case 1:
                                ((ViewGroup) FocusSyncBtActi.this.findViewById(R.id.sync_layout_line1)).setBackgroundResource(R.drawable.ic_sync_text_gray);
                                break;
                            case 2:
                                ((ViewGroup) FocusSyncBtActi.this.findViewById(R.id.sync_layout_line2)).setBackgroundResource(R.drawable.ic_sync_text_gray);
                                break;
                            case 3:
                                ((ViewGroup) FocusSyncBtActi.this.findViewById(R.id.sync_layout_line3)).setBackgroundResource(R.drawable.ic_sync_text_gray);
                                break;
                            case 4:
                                ((ViewGroup) FocusSyncBtActi.this.findViewById(R.id.sync_layout_line4)).setBackgroundResource(R.drawable.ic_sync_text_gray);
                                break;
                            case 5:
                                ((ViewGroup) FocusSyncBtActi.this.findViewById(R.id.sync_layout_line5)).setBackgroundResource(R.drawable.ic_sync_text_gray);
                                break;
                        }
                    }
                    break;
                case 36:
                case 42:
                    if (ints != null && ints.length > 0) {
                        int value2 = ints[0];
                        ((TextView) FocusSyncBtActi.this.findViewById(R.id.sync_playinfo)).setText(String.format("%02d:%02d", Integer.valueOf(value2 / 60), Integer.valueOf(value2 % 60)));
                        FocusSyncBtActi.this.hideTimeShow();
                        break;
                    }
                case 37:
                    if (ints != null && ints.length > 0 && ints[0] == 0) {
                        FocusSyncBtActi.this.finish();
                        break;
                    }
                case 40:
                    FocusSyncBtActi.sLineIcon = ints;
                    if (FocusSyncBtActi.sLineIcon != null && FocusSyncBtActi.sLineIcon.length >= 3) {
                        FocusSyncBtActi.this.setXPIcon();
                        break;
                    }
                case 41:
                    FocusSyncBtActi.sLineGroup = ints;
                    if (strs != null && strs.length > 0) {
                        FocusSyncBtActi.sUnicode = strs[0];
                    }
                    if (FocusSyncBtActi.sLineGroup != null) {
                        FocusSyncBtActi.this.getXPGroupStr();
                        break;
                    }
            }
        }
    };
    Runnable setAutoRequest = new Runnable() { // from class: com.syu.carinfo.focus.FocusSyncBtActi.5
        @Override // java.lang.Runnable
        public void run() {
            int workState = DataCanbus.DATA[9];
            int value = DataCanbus.DATA[12];
            if (workState == 0 || workState == 1) {
                if (value == 0 || value == 2 || value == 5) {
                    FocusSyncBtActi.this.finish();
                }
            }
        }
    };

    public static FocusSyncBtActi getInstance() {
        return mInst;
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInst = this;
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.layout_focus_sync);
        setupView();
        setListener();
        this.mCalendar = Calendar.getInstance();
        this.mFormatChangeObserver = new FormatChangeObserver();
        getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.mFormatChangeObserver);
        setFormat();
    }

    private void setupView() {
        this.mRunLayout1 = new ABC((TextView) findViewById(R.id.sync_unicode1));
        if (isCanbusWC()) {
            ((TextView) findViewById(R.id.sync_tv_state)).setVisibility(0);
            ((Button) findViewById(R.id.sync_btn_open)).setVisibility(4);
            ((Button) findViewById(R.id.sync_btn_close)).setVisibility(4);
            ((Button) findViewById(R.id.sync_photo)).setVisibility(4);
            ((Button) findViewById(R.id.sync_speech)).setBackgroundResource(R.drawable.d_sync_photo);
            return;
        }
        ((TextView) findViewById(R.id.sync_tv_state)).setVisibility(4);
        ((Button) findViewById(R.id.sync_btn_open)).setVisibility(0);
        ((Button) findViewById(R.id.sync_btn_close)).setVisibility(0);
        ((Button) findViewById(R.id.sync_photo)).setVisibility(0);
        ((Button) findViewById(R.id.sync_speech)).setBackgroundResource(R.drawable.d_sync_speech);
    }

    private void setListener() {
        ((Button) findViewById(R.id.home)).setOnClickListener(this);
        ((TextView) findViewById(R.id.textvol)).setOnClickListener(this);
        ((Button) findViewById(R.id.back)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_usbIpod)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_photo)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_info)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_speech)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_btn_open)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_btn_close)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_ok)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_up)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_down)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_left)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_right)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_prev)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_btn0)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_btn1)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_btn2)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_btn3)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_btn4)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_btn5)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_btn6)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_btn7)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_btn8)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_btn9)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_btn_xing)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_btn_jing)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_bottom_btn1)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_bottom_btn2)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_bottom_btn3)).setOnClickListener(this);
        ((Button) findViewById(R.id.sync_bottom_btn4)).setOnClickListener(this);
        ((ViewGroup) findViewById(R.id.sync_layout_line1)).setOnClickListener(this);
        ((ViewGroup) findViewById(R.id.sync_layout_line2)).setOnClickListener(this);
        ((ViewGroup) findViewById(R.id.sync_layout_line3)).setOnClickListener(this);
        ((ViewGroup) findViewById(R.id.sync_layout_line4)).setOnClickListener(this);
        ((ViewGroup) findViewById(R.id.sync_layout_line5)).setOnClickListener(this);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdate();
        isFront = true;
        if (!isCanbusWC()) {
            int value = DataCanbus.DATA[12];
            if (value != 1 && value != 3 && value != 4) {
                FocusFun.C_CONTRAL(161, 129);
            }
            FuncMain.setChannel(12);
        } else if (DataCanbus.DATA[1000] == 293 || DataCanbus.DATA[1000] == 319 || DataCanbus.DATA[1000] == 65855) {
            if (DataCanbus.DATA[43] == 1) {
                FuncMain.setChannel(13);
            } else {
                FuncMain.setChannel(12);
            }
        } else if (DataCanbus.DATA[1000] == 14) {
            if (DataCanbus.DATA[46] == 1) {
                FuncMain.setChannel(13);
            } else {
                FuncMain.setChannel(12);
            }
        }
        updateSystemTime();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeUpdate();
        removeSystemTime();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        mInst = null;
    }

    private void updateSystemTime() {
        this.handler.sendEmptyMessage(0);
    }

    private void removeSystemTime() {
        this.handler.removeMessages(0);
        this.handler.removeMessages(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTimeShow() {
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, 2000L);
    }

    class FormatChangeObserver extends ContentObserver {
        public FormatChangeObserver() {
            super(FocusSyncBtActi.this.handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            FocusSyncBtActi.this.setFormat();
        }
    }

    public void setFormat() {
        if (DateFormat.is24HourFormat(this)) {
            this.mFormat = "k:mm";
            if (((TextView) findViewById(R.id.textampm)).getVisibility() == 0) {
                ((TextView) findViewById(R.id.textampm)).setVisibility(8);
                return;
            }
            return;
        }
        this.mFormat = "h:mm";
        if (((TextView) findViewById(R.id.textampm)).getVisibility() != 0) {
            ((TextView) findViewById(R.id.textampm)).setVisibility(0);
        }
    }

    private boolean isBtState() {
        if (DataCanbus.DATA[1000] == 293 || DataCanbus.DATA[1000] == 319 || DataCanbus.DATA[1000] == 65855) {
            return DataCanbus.DATA[5] == 2;
        }
        if (isCanbusWC()) {
            return DataCanbus.DATA[23] == 2;
        }
        return isSyncPhoto();
    }

    private boolean isSyncPhoto() {
        return DataCanbus.DATA[9] == 3;
    }

    private void addUpdate() {
        DataSound.NOTIFY_EVENTS[2].addNotify(this.mNotifySound, 1);
        if (DataCanbus.DATA[1000] == 293 || DataCanbus.DATA[1000] == 319 || DataCanbus.DATA[1000] == 65855) {
            DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        if (isCanbusWC()) {
            DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        if (DataCanbus.DATA[1000] == 347) {
            DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbusYL, 1);
            DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbusYL, 1);
            DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbusYL, 0);
            DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbusYL, 0);
            DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbusYL, 1);
            DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbusYL, 1);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 0);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 0);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 0);
    }

    private void removeUpdate() {
        DataSound.NOTIFY_EVENTS[2].removeNotify(this.mNotifySound);
        if (DataCanbus.DATA[1000] == 347) {
            DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbusYL, 1);
            DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbusYL, 1);
            DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbusYL, 0);
            DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbusYL, 1);
            DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbusYL, 1);
            DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbusYL, 1);
        }
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTime(int value) {
        int minute = value / 60;
        int second = value % 60;
        ((TextView) findViewById(R.id.sync_playinfo)).setText(String.format("%02d:%02d:%02d", Integer.valueOf(minute / 60), Integer.valueOf(minute % 60), Integer.valueOf(second)));
        hideTimeShow();
    }

    class ABC implements Runnable {
        boolean handleRun = true;
        int value;
        View view;

        public ABC(View v) {
            this.view = v;
        }

        public synchronized void setValue(int value) {
            this.value = value;
            if (this.handleRun) {
                this.handleRun = false;
                HandlerUI.getInstance().postDelayed(this, 300L);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.handleRun = true;
            if (this.value > 0) {
                this.view.setBackgroundResource(this.value);
            } else {
                this.view.setBackgroundColor(0);
            }
        }
    }

    private int getLayoutResId(int value1, int value2) {
        if (value1 > 0 && value1 <= 10) {
            int resId = getXPTextResId(value2);
            return resId;
        }
        if (value1 <= 10 || value1 > 18) {
            return -1;
        }
        int resId2 = getXPButtonResId(value2);
        return resId2;
    }

    private int getXPTextResId(int value) {
        switch (value) {
            case 0:
            default:
                return -1;
            case 1:
                return R.drawable.ic_sync_text_gray;
            case 2:
                return R.drawable.ic_sync_text_transparent;
            case 3:
                return R.drawable.ic_sync_text_gray_dark;
            case 4:
                return R.drawable.ic_sync_text_transparent;
        }
    }

    private int getXPButtonResId(int value) {
        if (value != 2) {
            return -1;
        }
        return R.drawable.ic_sync_key_p;
    }

    private void setViewTouchState(View view, boolean flage) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBack() {
        ((ViewGroup) findViewById(R.id.sync_layout_line1)).setBackgroundColor(0);
        ((ViewGroup) findViewById(R.id.sync_layout_line2)).setBackgroundColor(0);
        ((ViewGroup) findViewById(R.id.sync_layout_line3)).setBackgroundColor(0);
        ((ViewGroup) findViewById(R.id.sync_layout_line4)).setBackgroundColor(0);
        ((ViewGroup) findViewById(R.id.sync_layout_line5)).setBackgroundColor(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (isCanbusWC()) {
            onClickWCFocus(v);
        } else if (DataCanbus.DATA[1000] == 347) {
            onClickYLFocus(v);
        } else {
            onClickXPFocus(v);
        }
    }

    private void moveToHome(View v) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(131072);
            intent.addFlags(67108864);
            intent.addFlags(536870912);
            intent.addFlags(16777216);
            intent.addFlags(268435456);
            v.getContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getXPGroupStr() {
        if (sLineGroup[0] > 0 && sLineGroup[0] <= 18) {
            if (((sLineGroup[1] >> 4) & 1) == 0) {
                this.isCanTouch = false;
            } else {
                this.isCanTouch = true;
            }
            int resId = getLayoutResId(sLineGroup[0], sLineGroup[1] & 15);
            switch (sLineGroup[0]) {
                case 1:
                case 6:
                    ((TextView) findViewById(R.id.sync_unicode1)).setText(sUnicode);
                    setViewTouchState((ViewGroup) findViewById(R.id.sync_layout_line1), this.isCanTouch);
                    if (resId > 0) {
                        this.mRunLayout1.setValue(resId);
                        break;
                    }
                case 2:
                case 7:
                    ((TextView) findViewById(R.id.sync_unicode2)).setText(sUnicode);
                    setViewTouchState((ViewGroup) findViewById(R.id.sync_layout_line2), this.isCanTouch);
                    break;
                case 3:
                case 8:
                    ((TextView) findViewById(R.id.sync_unicode3)).setText(sUnicode);
                    setViewTouchState((ViewGroup) findViewById(R.id.sync_layout_line3), this.isCanTouch);
                    break;
                case 4:
                case 9:
                    ((TextView) findViewById(R.id.sync_unicode4)).setText(sUnicode);
                    setViewTouchState((ViewGroup) findViewById(R.id.sync_layout_line4), this.isCanTouch);
                    break;
                case 5:
                case 10:
                    ((TextView) findViewById(R.id.sync_unicode5)).setText(sUnicode);
                    setViewTouchState((ViewGroup) findViewById(R.id.sync_layout_line5), this.isCanTouch);
                    break;
                case 11:
                case 15:
                    if ((sLineGroup[1] & 15) == 2 || (sLineGroup[1] & 15) == 3) {
                        ((Button) findViewById(R.id.sync_bottom_btn1)).setText("");
                        int resId2 = getXPResId(sLineGroup[2]);
                        if (resId2 > 0) {
                            ((Button) findViewById(R.id.sync_bottom_btn1)).setBackgroundResource(resId2);
                            break;
                        }
                    } else {
                        ((Button) findViewById(R.id.sync_bottom_btn1)).setBackgroundColor(0);
                        if (sUnicode.equals("")) {
                            sUnicode = "--.--";
                        }
                        ((Button) findViewById(R.id.sync_bottom_btn1)).setText(sUnicode);
                        break;
                    }
                case 12:
                case 16:
                    if ((sLineGroup[1] & 15) == 2 || (sLineGroup[1] & 15) == 3) {
                        ((Button) findViewById(R.id.sync_bottom_btn2)).setText("");
                        int resId3 = getXPResId(sLineGroup[2]);
                        if (resId3 > 0) {
                            ((Button) findViewById(R.id.sync_bottom_btn2)).setBackgroundResource(resId3);
                            break;
                        }
                    } else {
                        ((Button) findViewById(R.id.sync_bottom_btn2)).setBackgroundColor(0);
                        if (sUnicode.equals("")) {
                            sUnicode = "--.--";
                        }
                        ((Button) findViewById(R.id.sync_bottom_btn2)).setText(sUnicode);
                        break;
                    }
                case 13:
                case 17:
                    if ((sLineGroup[1] & 15) == 2 || (sLineGroup[1] & 15) == 3) {
                        ((Button) findViewById(R.id.sync_bottom_btn3)).setText("");
                        int resId4 = getXPResId(sLineGroup[2]);
                        if (resId4 > 0) {
                            ((Button) findViewById(R.id.sync_bottom_btn3)).setBackgroundResource(resId4);
                            break;
                        }
                    } else {
                        ((Button) findViewById(R.id.sync_bottom_btn3)).setBackgroundColor(0);
                        if (sUnicode.equals("")) {
                            sUnicode = "--.--";
                        }
                        ((Button) findViewById(R.id.sync_bottom_btn3)).setText(sUnicode);
                        break;
                    }
                case 14:
                case 18:
                    if ((sLineGroup[1] & 15) == 2 || (sLineGroup[1] & 15) == 3) {
                        ((Button) findViewById(R.id.sync_bottom_btn4)).setText("");
                        int resId5 = getXPResId(sLineGroup[2]);
                        if (resId5 > 0) {
                            ((Button) findViewById(R.id.sync_bottom_btn4)).setBackgroundResource(resId5);
                            break;
                        }
                    } else {
                        ((Button) findViewById(R.id.sync_bottom_btn4)).setBackgroundColor(0);
                        if (sUnicode.equals("")) {
                            sUnicode = "--.--";
                        }
                        ((Button) findViewById(R.id.sync_bottom_btn4)).setText(sUnicode);
                        break;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setXPIcon() {
        int resLeft = getXPResId(sLineIcon[1]);
        int resRight = getXPResId(sLineIcon[2]);
        switch (sLineIcon[0]) {
            case 1:
            case 6:
                if (resLeft > 0) {
                    ((ImageView) findViewById(R.id.sync_line1_image1)).setBackgroundResource(resLeft);
                    ((ImageView) findViewById(R.id.sync_line1_image1)).setVisibility(0);
                } else {
                    invisibleImage11();
                }
                if (resRight > 0) {
                    ((ImageView) findViewById(R.id.sync_line1_image2)).setVisibility(0);
                    ((ImageView) findViewById(R.id.sync_line1_image2)).setBackgroundResource(resRight);
                    break;
                } else {
                    ((ImageView) findViewById(R.id.sync_line1_image2)).setVisibility(4);
                    break;
                }
            case 2:
            case 7:
                if (resLeft > 0) {
                    ((ImageView) findViewById(R.id.sync_line2_image1)).setVisibility(0);
                    ((ImageView) findViewById(R.id.sync_line2_image1)).setBackgroundResource(resLeft);
                } else {
                    ((ImageView) findViewById(R.id.sync_line2_image1)).setVisibility(4);
                }
                if (resRight > 0) {
                    ((ImageView) findViewById(R.id.sync_line2_image2)).setVisibility(0);
                    ((ImageView) findViewById(R.id.sync_line2_image2)).setBackgroundResource(resRight);
                    break;
                } else {
                    ((ImageView) findViewById(R.id.sync_line2_image2)).setVisibility(4);
                    break;
                }
            case 3:
            case 8:
                if (resLeft > 0) {
                    ((ImageView) findViewById(R.id.sync_line3_image1)).setVisibility(0);
                    ((ImageView) findViewById(R.id.sync_line3_image1)).setBackgroundResource(resLeft);
                } else {
                    ((ImageView) findViewById(R.id.sync_line3_image1)).setVisibility(4);
                }
                if (resRight > 0) {
                    ((ImageView) findViewById(R.id.sync_line3_image2)).setVisibility(0);
                    ((ImageView) findViewById(R.id.sync_line3_image2)).setBackgroundResource(resRight);
                    break;
                } else {
                    ((ImageView) findViewById(R.id.sync_line3_image2)).setVisibility(4);
                    break;
                }
            case 4:
            case 9:
                if (resLeft > 0) {
                    ((ImageView) findViewById(R.id.sync_line4_image1)).setVisibility(0);
                    ((ImageView) findViewById(R.id.sync_line4_image1)).setBackgroundResource(resLeft);
                } else {
                    ((ImageView) findViewById(R.id.sync_line4_image1)).setVisibility(4);
                }
                if (resRight > 0) {
                    ((ImageView) findViewById(R.id.sync_line4_image2)).setVisibility(0);
                    ((ImageView) findViewById(R.id.sync_line4_image2)).setBackgroundResource(resRight);
                    break;
                } else {
                    ((ImageView) findViewById(R.id.sync_line4_image2)).setVisibility(4);
                    break;
                }
            case 5:
            case 10:
                if (resLeft > 0) {
                    ((ImageView) findViewById(R.id.sync_line5_image1)).setVisibility(0);
                    ((ImageView) findViewById(R.id.sync_line5_image1)).setBackgroundResource(resLeft);
                } else {
                    ((ImageView) findViewById(R.id.sync_line5_image1)).setVisibility(4);
                }
                if (resRight > 0) {
                    ((ImageView) findViewById(R.id.sync_line5_image2)).setVisibility(0);
                    ((ImageView) findViewById(R.id.sync_line5_image2)).setBackgroundResource(resRight);
                    break;
                } else {
                    ((ImageView) findViewById(R.id.sync_line5_image2)).setVisibility(4);
                    break;
                }
        }
    }

    private void invisibleImage11() {
        ((ImageView) findViewById(R.id.sync_line1_image1)).setVisibility(4);
    }

    private int getXPResId(int value) {
        switch (value) {
            case 3:
                return R.drawable.ic_sync_0x03;
            case 4:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
            case 14:
            case 15:
            case 16:
            case 19:
            case 20:
            case 22:
            case 24:
            case 25:
            case 26:
            case 27:
            case 32:
            case 42:
            case 43:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 66:
            case 72:
            case 108:
            case 173:
            case 199:
            case 200:
            case 201:
            case 202:
            case 203:
            case 206:
            case 225:
            case 226:
            case 227:
            case 228:
            case 230:
            case 231:
            case 232:
            case 233:
            case 234:
            case 235:
            case 236:
            case 237:
            case 238:
            case 239:
            case 240:
            case 241:
            case 242:
            case 243:
            case 244:
            case 245:
            case 246:
            default:
                return -1;
            case 6:
                return R.drawable.ic_sync_0x06;
            case 9:
                return R.drawable.ic_sync_0x09;
            case 11:
                return R.drawable.ic_sync_0x0b;
            case 13:
                return R.drawable.ic_sync_0x0d;
            case 17:
                return R.drawable.ic_sync_0x11;
            case 18:
                return R.drawable.ic_sync_0x12;
            case 21:
                return R.drawable.ic_sync_0x15;
            case 23:
                return R.drawable.ic_sync_0x17;
            case 28:
                return R.drawable.ic_sync_0x1c;
            case 29:
                return R.drawable.ic_sync_0x1d;
            case 30:
                return R.drawable.ic_sync_0x1e;
            case 31:
                return R.drawable.ic_sync_0x1f;
            case 33:
                return R.drawable.ic_sync_0x21;
            case 34:
                return R.drawable.ic_sync_0x22;
            case 35:
                return R.drawable.ic_sync_0x23;
            case 36:
                return R.drawable.ic_sync_0x24;
            case 37:
                return R.drawable.ic_sync_0x25;
            case 38:
                return R.drawable.ic_sync_0x26;
            case 39:
                return R.drawable.ic_sync_0x27;
            case 40:
                return R.drawable.ic_sync_0x28;
            case 41:
                return R.drawable.ic_sync_0x29;
            case 44:
                return R.drawable.ic_sync_0x2c;
            case 64:
                return R.drawable.ic_sync_0x40;
            case 65:
                return R.drawable.ic_sync_0x41;
            case 67:
                return R.drawable.ic_sync_0x43;
            case 68:
                return R.drawable.ic_sync_0x44;
            case 69:
                return R.drawable.ic_sync_0x45;
            case 70:
                return R.drawable.ic_sync_0x46;
            case 71:
                return R.drawable.ic_sync_0x47;
            case 73:
                return R.drawable.ic_sync_0x49;
            case 74:
                return R.drawable.ic_sync_0x4a;
            case 75:
                return R.drawable.ic_sync_0x4b;
            case 76:
                return R.drawable.ic_sync_0x4c;
            case 77:
                return R.drawable.ic_sync_0x4d;
            case 78:
                return R.drawable.ic_sync_0x4e;
            case 79:
                return R.drawable.ic_sync_0x4f;
            case 80:
                return R.drawable.ic_sync_0x50;
            case 81:
                return R.drawable.ic_sync_0x51;
            case 82:
                return R.drawable.ic_sync_0x52;
            case 83:
                return R.drawable.ic_sync_0x53;
            case 84:
                return R.drawable.ic_sync_0x54;
            case 85:
                return R.drawable.ic_sync_0x55;
            case 86:
                return R.drawable.ic_sync_0x56;
            case 87:
                return R.drawable.ic_sync_0x57;
            case 88:
                return R.drawable.ic_sync_0x58;
            case 89:
                return R.drawable.ic_sync_0x59;
            case 90:
                return R.drawable.ic_sync_0x5a;
            case 91:
                return R.drawable.ic_sync_0x5b;
            case 92:
                return R.drawable.ic_sync_0x5c;
            case 93:
                return R.drawable.ic_sync_0x5d;
            case 94:
                return R.drawable.ic_sync_0x5e;
            case 95:
                return R.drawable.ic_sync_0x5f;
            case 96:
                return R.drawable.ic_sync_0x60;
            case 97:
                return R.drawable.ic_sync_0x61;
            case 98:
                return R.drawable.ic_sync_0x62;
            case 99:
                return R.drawable.ic_sync_0x63;
            case 100:
                return R.drawable.ic_sync_0x64;
            case 101:
                return R.drawable.ic_sync_0x65;
            case 102:
                return R.drawable.ic_sync_0x66;
            case 103:
                return R.drawable.ic_sync_0x67;
            case 104:
                return R.drawable.ic_sync_0x68;
            case 105:
                return R.drawable.ic_sync_0x69;
            case 106:
                return R.drawable.ic_sync_0x6a;
            case 107:
                return R.drawable.ic_sync_0x6b;
            case 109:
                return R.drawable.ic_sync_0x6d;
            case 110:
                return R.drawable.ic_sync_0x6e;
            case 111:
                return R.drawable.ic_sync_0x6f;
            case 112:
                return R.drawable.ic_sync_0x70;
            case 113:
                return R.drawable.ic_sync_0x71;
            case 114:
                return R.drawable.ic_sync_0x72;
            case 115:
                return R.drawable.ic_sync_0x73;
            case 116:
                return R.drawable.ic_sync_0x74;
            case 117:
                return R.drawable.ic_sync_0x75;
            case 118:
                return R.drawable.ic_sync_0x76;
            case 119:
                return R.drawable.ic_sync_0x77;
            case 120:
                return R.drawable.ic_sync_0x78;
            case 121:
                return R.drawable.ic_sync_0x79;
            case 122:
                return R.drawable.ic_sync_0x7a;
            case 123:
                return R.drawable.ic_sync_0x7b;
            case 124:
                return R.drawable.ic_sync_0x7c;
            case 125:
                return R.drawable.ic_sync_0x7d;
            case 126:
                return R.drawable.ic_sync_0x7e;
            case 127:
                return R.drawable.ic_sync_0x7f;
            case 128:
                return R.drawable.ic_sync_0x80;
            case 129:
                return R.drawable.ic_sync_0x81;
            case 130:
                return R.drawable.ic_sync_0x82;
            case 131:
                return R.drawable.ic_sync_0x83;
            case 132:
                return R.drawable.ic_sync_0x84;
            case 133:
                return R.drawable.ic_sync_0x85;
            case 134:
                return R.drawable.ic_sync_0x86;
            case 135:
                return R.drawable.ic_sync_0x87;
            case 136:
                return R.drawable.ic_sync_0x88;
            case 137:
                return R.drawable.ic_sync_0x89;
            case 138:
                return R.drawable.ic_sync_0x8a;
            case 139:
                return R.drawable.ic_sync_0x8b;
            case 140:
                return R.drawable.ic_sync_0x8c;
            case 141:
                return R.drawable.ic_sync_0x8d;
            case 142:
                return R.drawable.ic_sync_0x8e;
            case 143:
                return R.drawable.ic_sync_0x8f;
            case 144:
                return R.drawable.ic_sync_0x90;
            case 145:
                return R.drawable.ic_sync_0x91;
            case 146:
                return R.drawable.ic_sync_0x92;
            case 147:
                return R.drawable.ic_sync_0x93;
            case 148:
                return R.drawable.ic_sync_0x94;
            case 149:
                return R.drawable.ic_sync_0x95;
            case 150:
                return R.drawable.ic_sync_0x96;
            case 151:
                return R.drawable.ic_sync_0x97;
            case 152:
                return R.drawable.ic_sync_0x98;
            case 153:
                return R.drawable.ic_sync_0x99;
            case 154:
                return R.drawable.ic_sync_0x9a;
            case 155:
                return R.drawable.ic_sync_0x9b;
            case 156:
                return R.drawable.ic_sync_0x9c;
            case 157:
                return R.drawable.ic_sync_0x9d;
            case 158:
                return R.drawable.ic_sync_0x9e;
            case 159:
                return R.drawable.ic_sync_0x9f;
            case 160:
                return R.drawable.ic_sync_0xa0;
            case 161:
                return R.drawable.ic_sync_0xa1;
            case 162:
                return R.drawable.ic_sync_0xa2;
            case 163:
                return R.drawable.ic_sync_0xa3;
            case 164:
                return R.drawable.ic_sync_0xa4;
            case 165:
                return R.drawable.ic_sync_0xa5;
            case 166:
                return R.drawable.ic_sync_0xa6;
            case 167:
                return R.drawable.ic_sync_0xa7;
            case 168:
                return R.drawable.ic_sync_0xa8;
            case 169:
                return R.drawable.ic_sync_0xa9;
            case 170:
                return R.drawable.ic_sync_0xaa;
            case 171:
                return R.drawable.ic_sync_0xab;
            case 172:
                return R.drawable.ic_sync_0xac;
            case 174:
                return R.drawable.ic_sync_0xae;
            case 175:
                return R.drawable.ic_sync_0xaf;
            case 176:
                return R.drawable.ic_sync_0xb0;
            case 177:
                return R.drawable.ic_sync_0xb1;
            case 178:
                return R.drawable.ic_sync_0xb2;
            case 179:
                return R.drawable.ic_sync_0xb3;
            case 180:
                return R.drawable.ic_sync_0xb4;
            case 181:
                return R.drawable.ic_sync_0xb5;
            case 182:
                return R.drawable.ic_sync_0xb6;
            case 183:
                return R.drawable.ic_sync_0xb7;
            case 184:
                return R.drawable.ic_sync_0xb8;
            case 185:
                return R.drawable.ic_sync_0xb9;
            case 186:
                return R.drawable.ic_sync_0xba;
            case 187:
                return R.drawable.ic_sync_0xbb;
            case 188:
                return R.drawable.ic_sync_0xbc;
            case 189:
                return R.drawable.ic_sync_0xbd;
            case 190:
                return R.drawable.ic_sync_0xbe;
            case 191:
                return R.drawable.ic_sync_0xbf;
            case 192:
                return R.drawable.ic_sync_0xc0;
            case 193:
                return R.drawable.ic_sync_0xc1;
            case 194:
                return R.drawable.ic_sync_0xc2;
            case 195:
                return R.drawable.ic_sync_0xc3;
            case 196:
                return R.drawable.ic_sync_0xc4;
            case 197:
                return R.drawable.ic_sync_0xc5;
            case 198:
                return R.drawable.ic_sync_0xc6;
            case 204:
                return R.drawable.ic_sync_0xcc;
            case 205:
                return R.drawable.ic_sync_0xcd;
            case 207:
                return R.drawable.ic_sync_0xcf;
            case 208:
                return R.drawable.ic_sync_0xd0;
            case 209:
                return R.drawable.ic_sync_0xd1;
            case 210:
                return R.drawable.ic_sync_0xd2;
            case 211:
                return R.drawable.ic_sync_0xd3;
            case 212:
                return R.drawable.ic_sync_0xd4;
            case 213:
                return R.drawable.ic_sync_0xd5;
            case 214:
                return R.drawable.ic_sync_0xd6;
            case 215:
                return R.drawable.ic_sync_0xd7;
            case 216:
                return R.drawable.ic_sync_0xd8;
            case 217:
                return R.drawable.ic_sync_0xd9;
            case 218:
                return R.drawable.ic_sync_0xda;
            case 219:
                return R.drawable.ic_sync_0xdb;
            case 220:
                return R.drawable.ic_sync_0xdc;
            case 221:
                return R.drawable.ic_sync_0xdd;
            case 222:
                return R.drawable.ic_sync_0xde;
            case 223:
                return R.drawable.ic_sync_0xdf;
            case 224:
                return R.drawable.ic_sync_0xe0;
            case 229:
                return R.drawable.ic_sync_0xe5;
            case 247:
                return R.drawable.ic_sync_0xf7;
            case 248:
                return R.drawable.ic_sync_0xf8;
            case 249:
                return R.drawable.ic_sync_0xf9;
            case 250:
                return R.drawable.ic_sync_0xfa;
            case 251:
                return R.drawable.ic_sync_0xfb;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWCIcon() {
        for (int i = 0; i < 16; i++) {
            if (sLineIcon[i] == 1) {
                if (i == 0 || i == 6 || i == 7) {
                    ((ViewGroup) findViewById(R.id.sync_layout_line1)).setBackgroundResource(R.drawable.ic_sync_touch);
                } else if (i == 1 || i == 8 || i == 9) {
                    ((ViewGroup) findViewById(R.id.sync_layout_line2)).setBackgroundResource(R.drawable.ic_sync_touch);
                } else if (i == 2 || i == 10 || i == 11) {
                    ((ViewGroup) findViewById(R.id.sync_layout_line3)).setBackgroundResource(R.drawable.ic_sync_touch);
                } else if (i == 3 || i == 12 || i == 13) {
                    ((ViewGroup) findViewById(R.id.sync_layout_line4)).setBackgroundResource(R.drawable.ic_sync_touch);
                } else if (i == 4 || i == 14 || i == 15) {
                    ((ViewGroup) findViewById(R.id.sync_layout_line5)).setBackgroundResource(R.drawable.ic_sync_touch);
                }
            }
        }
        if (0 != 0) {
            Toast.makeText(mInst, "设置图标:" + sLineIcon[0] + " 值：" + sLineIcon[1], 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWCGroupStr() {
        switch (sLineGroup[0]) {
            case 1:
                ((TextView) findViewById(R.id.sync_unicode1)).setText(sUnicode);
                break;
            case 2:
                ((TextView) findViewById(R.id.sync_unicode2)).setText(sUnicode);
                break;
            case 3:
                ((TextView) findViewById(R.id.sync_unicode3)).setText(sUnicode);
                break;
            case 4:
                ((TextView) findViewById(R.id.sync_unicode4)).setText(sUnicode);
                break;
            case 5:
                ((TextView) findViewById(R.id.sync_unicode5)).setText(sUnicode);
                break;
            case 10:
                ((Button) findViewById(R.id.sync_bottom_btn1)).setText(sUnicode);
                break;
            case 11:
                ((Button) findViewById(R.id.sync_bottom_btn2)).setText(sUnicode);
                break;
            case 12:
                ((Button) findViewById(R.id.sync_bottom_btn3)).setText(sUnicode);
                break;
            case 13:
                ((Button) findViewById(R.id.sync_bottom_btn4)).setText(sUnicode);
                break;
        }
    }

    private void onClickWCFocus(View v) {
        switch (v.getId()) {
            case R.id.sync_speech /* 2131430958 */:
                FocusFun.C_SET_BUTTON_TOUCH(2, 18);
                break;
            case R.id.sync_usbIpod /* 2131430959 */:
                FocusFun.C_SET_BUTTON_TOUCH(2, 17);
                break;
            case R.id.sync_info /* 2131430960 */:
                FocusFun.C_SET_BUTTON_TOUCH(2, 19);
                break;
            case R.id.sync_ok /* 2131430961 */:
                FocusFun.C_SET_BUTTON_TOUCH(2, 16);
                break;
            case R.id.sync_up /* 2131430962 */:
                FocusFun.C_SET_BUTTON_TOUCH(2, 12);
                break;
            case R.id.sync_left /* 2131430963 */:
                FocusFun.C_SET_BUTTON_TOUCH(2, 14);
                break;
            case R.id.sync_right /* 2131430964 */:
                FocusFun.C_SET_BUTTON_TOUCH(2, 15);
                break;
            case R.id.sync_down /* 2131430965 */:
                FocusFun.C_SET_BUTTON_TOUCH(2, 13);
                break;
            case R.id.sync_prev /* 2131430966 */:
                FocusFun.C_SET_BUTTON_TOUCH(2, 10);
                break;
            case R.id.sync_next /* 2131430967 */:
                FocusFun.C_SET_BUTTON_TOUCH(2, 11);
                break;
            case R.id.sync_bottom_btn1 /* 2131430990 */:
                FocusFun.C_SET_BUTTON_TOUCH(1, 1);
                break;
            case R.id.sync_bottom_btn2 /* 2131430991 */:
                FocusFun.C_SET_BUTTON_TOUCH(1, 2);
                break;
            case R.id.sync_bottom_btn3 /* 2131430992 */:
                FocusFun.C_SET_BUTTON_TOUCH(1, 3);
                break;
            case R.id.sync_bottom_btn4 /* 2131430993 */:
                FocusFun.C_SET_BUTTON_TOUCH(1, 4);
                break;
            case R.id.sync_btn_open /* 2131430996 */:
                FocusFun.C_SET_BUTTON_TOUCH(2, 30);
                break;
            case R.id.sync_btn_close /* 2131430997 */:
                FocusFun.C_SET_BUTTON_TOUCH(2, 31);
                break;
            case R.id.sync_btn2 /* 2131430998 */:
                FocusFun.C_SET_BUTTON_TOUCH(2, 22);
                break;
            case R.id.sync_btn1 /* 2131430999 */:
                FocusFun.C_SET_BUTTON_TOUCH(2, 21);
                break;
            case R.id.sync_btn3 /* 2131431000 */:
                FocusFun.C_SET_BUTTON_TOUCH(2, 23);
                break;
            case R.id.sync_btn5 /* 2131431001 */:
                FocusFun.C_SET_BUTTON_TOUCH(2, 25);
                break;
            case R.id.sync_btn4 /* 2131431002 */:
                FocusFun.C_SET_BUTTON_TOUCH(2, 24);
                break;
            case R.id.sync_btn6 /* 2131431003 */:
                FocusFun.C_SET_BUTTON_TOUCH(2, 26);
                break;
            case R.id.sync_btn8 /* 2131431004 */:
                FocusFun.C_SET_BUTTON_TOUCH(2, 28);
                break;
            case R.id.sync_btn7 /* 2131431005 */:
                FocusFun.C_SET_BUTTON_TOUCH(2, 27);
                break;
            case R.id.sync_btn9 /* 2131431006 */:
                FocusFun.C_SET_BUTTON_TOUCH(2, 29);
                break;
            case R.id.sync_btn0 /* 2131431007 */:
                FocusFun.C_SET_BUTTON_TOUCH(2, 20);
                break;
            case R.id.sync_btn_xing /* 2131431008 */:
                FocusFun.C_SET_BUTTON_TOUCH(2, 32);
                break;
            case R.id.sync_btn_jing /* 2131431009 */:
                FocusFun.C_SET_BUTTON_TOUCH(2, 33);
                break;
            case R.id.back /* 2131433008 */:
                if (!isBtState()) {
                    moveTaskToBack(true);
                    break;
                }
            case R.id.home /* 2131433009 */:
                if (!isBtState()) {
                    moveToHome(v);
                    break;
                }
            case R.id.textvol /* 2131433010 */:
                FFuncSound.showVol();
                break;
        }
    }

    private void onClickXPFocus(View v) {
        switch (v.getId()) {
            case R.id.sync_speech /* 2131430958 */:
                FocusFun.C_CONTRAL(161, 1);
                break;
            case R.id.sync_usbIpod /* 2131430959 */:
                FocusFun.C_CONTRAL(161, 27);
                break;
            case R.id.sync_info /* 2131430960 */:
                FocusFun.C_CONTRAL(161, 6);
                break;
            case R.id.sync_ok /* 2131430961 */:
                FocusFun.C_CONTRAL(161, 12);
                break;
            case R.id.sync_up /* 2131430962 */:
                FocusFun.C_CONTRAL(161, 10);
                break;
            case R.id.sync_left /* 2131430963 */:
                FocusFun.C_CONTRAL(161, 25);
                break;
            case R.id.sync_right /* 2131430964 */:
                FocusFun.C_CONTRAL(161, 26);
                break;
            case R.id.sync_down /* 2131430965 */:
                FocusFun.C_CONTRAL(161, 11);
                break;
            case R.id.sync_prev /* 2131430966 */:
                FocusFun.C_CONTRAL(161, 8);
                break;
            case R.id.sync_next /* 2131430967 */:
                FocusFun.C_CONTRAL(161, 9);
                break;
            case R.id.sync_layout_line1 /* 2131430970 */:
                FocusFun.C_CONTRAL(161, 145);
                break;
            case R.id.sync_layout_line2 /* 2131430974 */:
                FocusFun.C_CONTRAL(161, 146);
                break;
            case R.id.sync_layout_line3 /* 2131430978 */:
                FocusFun.C_CONTRAL(161, 147);
                break;
            case R.id.sync_layout_line4 /* 2131430982 */:
                FocusFun.C_CONTRAL(161, 148);
                break;
            case R.id.sync_layout_line5 /* 2131430986 */:
                FocusFun.C_CONTRAL(161, 149);
                break;
            case R.id.sync_bottom_btn1 /* 2131430990 */:
                FocusFun.C_CONTRAL(161, 28);
                break;
            case R.id.sync_bottom_btn2 /* 2131430991 */:
                FocusFun.C_CONTRAL(161, 29);
                break;
            case R.id.sync_bottom_btn3 /* 2131430992 */:
                FocusFun.C_CONTRAL(161, 30);
                break;
            case R.id.sync_bottom_btn4 /* 2131430993 */:
                FocusFun.C_CONTRAL(161, 31);
                break;
            case R.id.sync_photo /* 2131430995 */:
                FocusFun.C_CONTRAL(161, 3);
                break;
            case R.id.sync_btn_open /* 2131430996 */:
                FocusFun.C_CONTRAL(161, 5);
                break;
            case R.id.sync_btn_close /* 2131430997 */:
                FocusFun.C_CONTRAL(161, 4);
                break;
            case R.id.sync_btn2 /* 2131430998 */:
                FocusFun.C_CONTRAL(161, 15);
                break;
            case R.id.sync_btn1 /* 2131430999 */:
                FocusFun.C_CONTRAL(161, 14);
                break;
            case R.id.sync_btn3 /* 2131431000 */:
                FocusFun.C_CONTRAL(161, 16);
                break;
            case R.id.sync_btn5 /* 2131431001 */:
                FocusFun.C_CONTRAL(161, 18);
                break;
            case R.id.sync_btn4 /* 2131431002 */:
                FocusFun.C_CONTRAL(161, 17);
                break;
            case R.id.sync_btn6 /* 2131431003 */:
                FocusFun.C_CONTRAL(161, 19);
                break;
            case R.id.sync_btn8 /* 2131431004 */:
                FocusFun.C_CONTRAL(161, 21);
                break;
            case R.id.sync_btn7 /* 2131431005 */:
                FocusFun.C_CONTRAL(161, 20);
                break;
            case R.id.sync_btn9 /* 2131431006 */:
                FocusFun.C_CONTRAL(161, 22);
                break;
            case R.id.sync_btn0 /* 2131431007 */:
                FocusFun.C_CONTRAL(161, 13);
                break;
            case R.id.sync_btn_xing /* 2131431008 */:
                FocusFun.C_CONTRAL(161, 23);
                break;
            case R.id.sync_btn_jing /* 2131431009 */:
                FocusFun.C_CONTRAL(161, 24);
                break;
            case R.id.back /* 2131433008 */:
                if (!isBtState()) {
                    moveTaskToBack(true);
                    break;
                }
            case R.id.home /* 2131433009 */:
                if (!isBtState()) {
                    moveToHome(v);
                    break;
                }
            case R.id.textvol /* 2131433010 */:
                FFuncSound.showVol();
                break;
        }
    }

    private void onClickYLFocus(View v) {
        switch (v.getId()) {
            case R.id.sync_speech /* 2131430958 */:
                FFuncYLFocus.C_SET_CONTROT(17, 1);
                break;
            case R.id.sync_usbIpod /* 2131430959 */:
                FFuncYLFocus.C_SET_CONTROT(17, 32);
                break;
            case R.id.sync_info /* 2131430960 */:
                FFuncYLFocus.C_SET_CONTROT(17, 2);
                break;
            case R.id.sync_ok /* 2131430961 */:
                FFuncYLFocus.C_SET_CONTROT(17, 42);
                break;
            case R.id.sync_up /* 2131430962 */:
                FFuncYLFocus.C_SET_CONTROT(17, 38);
                break;
            case R.id.sync_left /* 2131430963 */:
                FFuncYLFocus.C_SET_CONTROT(17, 40);
                break;
            case R.id.sync_right /* 2131430964 */:
                FFuncYLFocus.C_SET_CONTROT(17, 41);
                break;
            case R.id.sync_down /* 2131430965 */:
                FFuncYLFocus.C_SET_CONTROT(17, 39);
                break;
            case R.id.sync_prev /* 2131430966 */:
                FFuncYLFocus.C_SET_CONTROT(17, 6);
                break;
            case R.id.sync_next /* 2131430967 */:
                FFuncYLFocus.C_SET_CONTROT(17, 7);
                break;
            case R.id.sync_layout_line1 /* 2131430970 */:
                FFuncYLFocus.C_SET_CONTROT(17, 48);
                break;
            case R.id.sync_layout_line2 /* 2131430974 */:
                FFuncYLFocus.C_SET_CONTROT(17, 49);
                break;
            case R.id.sync_layout_line3 /* 2131430978 */:
                FFuncYLFocus.C_SET_CONTROT(17, 50);
                break;
            case R.id.sync_layout_line4 /* 2131430982 */:
                FFuncYLFocus.C_SET_CONTROT(17, 51);
                break;
            case R.id.sync_layout_line5 /* 2131430986 */:
                FFuncYLFocus.C_SET_CONTROT(17, 52);
                break;
            case R.id.sync_bottom_btn1 /* 2131430990 */:
                FFuncYLFocus.C_SET_CONTROT(17, 26);
                break;
            case R.id.sync_bottom_btn2 /* 2131430991 */:
                FFuncYLFocus.C_SET_CONTROT(17, 27);
                break;
            case R.id.sync_bottom_btn3 /* 2131430992 */:
                FFuncYLFocus.C_SET_CONTROT(17, 28);
                break;
            case R.id.sync_bottom_btn4 /* 2131430993 */:
                FFuncYLFocus.C_SET_CONTROT(17, 29);
                break;
            case R.id.sync_photo /* 2131430995 */:
                FFuncYLFocus.C_SET_CONTROT(17, 3);
                break;
            case R.id.sync_btn_open /* 2131430996 */:
                FFuncYLFocus.C_SET_CONTROT(17, 5);
                break;
            case R.id.sync_btn_close /* 2131430997 */:
                FFuncYLFocus.C_SET_CONTROT(17, 4);
                break;
            case R.id.sync_btn2 /* 2131430998 */:
                FFuncYLFocus.C_SET_CONTROT(17, 18);
                break;
            case R.id.sync_btn1 /* 2131430999 */:
                FFuncYLFocus.C_SET_CONTROT(17, 17);
                break;
            case R.id.sync_btn3 /* 2131431000 */:
                FFuncYLFocus.C_SET_CONTROT(17, 19);
                break;
            case R.id.sync_btn5 /* 2131431001 */:
                FFuncYLFocus.C_SET_CONTROT(17, 21);
                break;
            case R.id.sync_btn4 /* 2131431002 */:
                FFuncYLFocus.C_SET_CONTROT(17, 20);
                break;
            case R.id.sync_btn6 /* 2131431003 */:
                FFuncYLFocus.C_SET_CONTROT(17, 22);
                break;
            case R.id.sync_btn8 /* 2131431004 */:
                FFuncYLFocus.C_SET_CONTROT(17, 24);
                break;
            case R.id.sync_btn7 /* 2131431005 */:
                FFuncYLFocus.C_SET_CONTROT(17, 23);
                break;
            case R.id.sync_btn9 /* 2131431006 */:
                FFuncYLFocus.C_SET_CONTROT(17, 25);
                break;
            case R.id.sync_btn0 /* 2131431007 */:
                FFuncYLFocus.C_SET_CONTROT(17, 16);
                break;
            case R.id.sync_btn_xing /* 2131431008 */:
                FFuncYLFocus.C_SET_CONTROT(17, 30);
                break;
            case R.id.sync_btn_jing /* 2131431009 */:
                FFuncYLFocus.C_SET_CONTROT(17, 31);
                break;
            case R.id.back /* 2131433008 */:
                if (!isBtState()) {
                    moveTaskToBack(true);
                    break;
                }
            case R.id.home /* 2131433009 */:
                if (!isBtState()) {
                    moveToHome(v);
                    break;
                }
            case R.id.textvol /* 2131433010 */:
                FFuncSound.showVol();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCanbusWC() {
        int canbusType = DataCanbus.DATA[1000];
        return canbusType == 14 || canbusType == 115 || canbusType == 49 || canbusType == 293 || canbusType == 65855 || canbusType == 319;
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            if (isCanbusWC() && DataMain.DATA[0] == 13) {
                FuncMain.setChannel(0);
            }
            FuncMain.setChannel(0);
            finish();
            return true;
        }
        return true;
    }
}
