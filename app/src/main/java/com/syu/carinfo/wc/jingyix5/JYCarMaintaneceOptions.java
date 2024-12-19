package com.syu.carinfo.wc.jingyix5;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class JYCarMaintaneceOptions extends BaseActivity implements View.OnClickListener {
    private Date dsetDate;
    private int iChecked;
    private int isetMiles;
    private int mCurrentMiles;
    CheckedTextView mDateSet;
    EditText mEtMiles;
    View mLayDateSetView;
    View mLayMilesSetView;
    CheckedTextView mMilesSet;
    CheckedTextView mReminder;
    TextView mTitle;
    TextView mTvDate;
    String strFlag = "";
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.jingyix5.JYCarMaintaneceOptions.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 91:
                    JYCarMaintaneceOptions.this.mCurrentMiles = DataCanbus.DATA[91];
                    JYCarMaintaneceOptions.this.checkWarning();
                    break;
            }
        }
    };
    private Calendar calendar = Calendar.getInstance(Locale.CHINA);

    @SuppressLint({"SimpleDateFormat"})
    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        getWindow().setSoftInputMode(3);
        super.onCreate(arg0);
        setContentView(R.layout.layout_wc_jyx5_maintain_options);
        setUI();
        iniData(getIntent());
    }

    private void setUI() {
        this.mReminder = (CheckedTextView) findViewById(R.id.jy_maintain_1);
        this.mMilesSet = (CheckedTextView) findViewById(R.id.jy_maintain_2);
        this.mDateSet = (CheckedTextView) findViewById(R.id.jy_maintain_3);
        this.mLayMilesSetView = findViewById(R.id.jy_maintain_2_view);
        this.mLayDateSetView = findViewById(R.id.jy_maintain_3_view);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.mEtMiles = (EditText) findViewById(R.id.et_miles_set);
        this.mTvDate = (TextView) findViewById(R.id.tv_date_set);
        this.mReminder.setOnClickListener(this);
        this.mMilesSet.setOnClickListener(this);
        this.mDateSet.setOnClickListener(this);
        this.mEtMiles.addTextChangedListener(new TextWatcher() { // from class: com.syu.carinfo.wc.jingyix5.JYCarMaintaneceOptions.2
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                String string = s.toString();
                if (!TextUtils.isEmpty(string) && TextUtils.isDigitsOnly(string) && !string.equals(new StringBuilder(String.valueOf(JYCarMaintaneceOptions.this.isetMiles)).toString())) {
                    Integer value = Integer.valueOf(string);
                    if (JYCarMaintaneceOptions.this.isValidateMiles(value.intValue())) {
                        JYCarMaintaneceOptions.this.isetMiles = value.intValue();
                    }
                }
            }
        });
    }

    private void iniData(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String data = (String) extras.get("ID");
            int strid = -1;
            if ("Maintenance".equals(data)) {
                if (this.mLayDateSetView != null) {
                    this.mLayDateSetView.setVisibility(8);
                }
                strid = R.string.str_rzc_xp_cs75_maintain_reminders;
            } else if ("tire".equals(data)) {
                strid = R.string.str_wc_jy_str4;
            } else if ("oil".equals(data)) {
                strid = R.string.str_wc_jy_str5;
            }
            this.strFlag = data;
            if (this.mTitle != null) {
                this.mTitle.setText(strid);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkWarning() {
        String tag = SPreUtils.get(getApplicationContext(), String.valueOf(this.strFlag) + "_miles", "0");
        int miles = Integer.valueOf(tag).intValue();
        if (miles < this.mCurrentMiles) {
            this.mMilesSet.setSelected(true);
            int id = -1;
            if ("Maintenance".equals(this.strFlag)) {
                id = R.string.str_wc_jy_str14;
            } else if ("tire".equals(this.strFlag)) {
                id = R.string.str_wc_jy_str15;
            } else if ("oil".equals(this.strFlag)) {
                id = R.string.str_wc_jy_str17;
            }
            if (id > 0) {
                FuncMain.tips(LauncherApplication.getInstance().getString(id));
            }
        } else {
            this.mMilesSet.setSelected(false);
        }
        String tag2 = SPreUtils.get(getApplicationContext(), String.valueOf(this.strFlag) + "_date", "0");
        Date parse = null;
        try {
            parse = this.format.parse(tag2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (parse != null) {
            this.calendar.clear();
            this.calendar.setTime(parse);
        }
        if (this.calendar.getTimeInMillis() < System.currentTimeMillis()) {
            this.mDateSet.setSelected(true);
            int id2 = -1;
            if ("tire".equals(this.strFlag)) {
                id2 = R.string.str_wc_jy_str16;
            } else if ("oil".equals(this.strFlag)) {
                id2 = R.string.str_wc_jy_str18;
            }
            if (id2 > 0) {
                FuncMain.tips(LauncherApplication.getInstance().getString(id2));
                return;
            }
            return;
        }
        this.mDateSet.setSelected(false);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        super.addNotify();
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        readConfig();
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        super.removeNotify();
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        saveConfig();
    }

    private void readConfig() {
        this.iChecked = Integer.valueOf(SPreUtils.get(getApplicationContext(), String.valueOf(this.strFlag) + "_checked", "0")).intValue();
        this.mReminder.setChecked(this.iChecked != 0);
        String tag = SPreUtils.get(getApplicationContext(), String.valueOf(this.strFlag) + "_miles", "0");
        this.isetMiles = Integer.valueOf(tag).intValue();
        this.mEtMiles.setText(tag);
        String tag2 = SPreUtils.get(getApplicationContext(), String.valueOf(this.strFlag) + "_date", "");
        if (TextUtils.isEmpty(tag2)) {
            tag2 = android.text.format.DateFormat.format("yyyy-MM-dd", this.calendar).toString();
            SPreUtils.set(getApplicationContext(), String.valueOf(this.strFlag) + "_date", tag2);
        }
        try {
            this.dsetDate = this.format.parse(tag2);
            this.calendar.setTime(this.dsetDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (this.mTvDate != null) {
            this.mTvDate.setText(tag2);
        }
    }

    private void saveConfig() {
        SPreUtils.set(getApplicationContext(), String.valueOf(this.strFlag) + "_checked", new StringBuilder(String.valueOf(this.iChecked)).toString());
        SPreUtils.set(getApplicationContext(), String.valueOf(this.strFlag) + "_miles", new StringBuilder(String.valueOf(this.isetMiles)).toString());
        SPreUtils.set(getApplicationContext(), String.valueOf(this.strFlag) + "_date", android.text.format.DateFormat.format("yyyy-MM-dd", this.calendar.getTime()).toString());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.jy_maintain_1 /* 2131433095 */:
                setChecked();
                break;
            case R.id.jy_maintain_3 /* 2131433097 */:
                showDatePickDialog();
                break;
        }
    }

    private void setChecked() {
        this.iChecked++;
        this.iChecked %= 2;
        SPreUtils.set(getApplicationContext(), String.valueOf(this.strFlag) + "_checked", new StringBuilder(String.valueOf(this.iChecked)).toString());
        this.mReminder.setChecked(this.iChecked != 0);
    }

    private void showDatePickDialog() {
        String dateStr = this.mTvDate.getText().toString();
        Date parseDate = null;
        try {
            if (!TextUtils.isEmpty(dateStr)) {
                parseDate = this.format.parse(dateStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (parseDate != null) {
            this.calendar.clear();
            this.calendar.setTime(parseDate);
            final DatePickerDialog pickerDlg = new DatePickerDialog(this, null, this.calendar.get(1), this.calendar.get(2), this.calendar.get(5));
            pickerDlg.setButton(-1, "OK", new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.jingyix5.JYCarMaintaneceOptions.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    DatePicker datepick = pickerDlg.getDatePicker();
                    Calendar c = Calendar.getInstance(Locale.CHINA);
                    c.clear();
                    c.set(datepick.getYear(), datepick.getMonth(), datepick.getDayOfMonth());
                    JYCarMaintaneceOptions.this.isValidateDate(c);
                    if (JYCarMaintaneceOptions.this.isValidateDate(c)) {
                        String vals = android.text.format.DateFormat.format("yyyy-MM-dd", c.getTime()).toString();
                        JYCarMaintaneceOptions.this.mTvDate.setText(vals);
                        JYCarMaintaneceOptions.this.calendar = c;
                        SPreUtils.set(JYCarMaintaneceOptions.this.getApplicationContext(), String.valueOf(JYCarMaintaneceOptions.this.strFlag) + "_date", vals);
                    }
                }
            });
            pickerDlg.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValidateDate(Calendar c) {
        return c.getTimeInMillis() > System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValidateMiles(int miles) {
        return miles > this.mCurrentMiles;
    }

    public static class SPreUtils {
        private static SharedPreferences mSp;

        public SPreUtils(Context context) {
            checkmSp(context);
        }

        private static void checkmSp(Context context) {
            if (mSp == null) {
                mSp = context.getSharedPreferences("wc_jingyix5", 0);
            }
        }

        public static String get(Context context, String flag, String defVal) {
            checkmSp(context);
            String val = mSp.getString(flag, defVal);
            return val;
        }

        public static void set(Context context, String flag, String val) {
            checkmSp(context);
            mSp.edit().putString(flag, val).commit();
        }
    }
}
