package com.syu.carinfo.wc2.ford;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class WC2FordLincoinFactoryPwdAct extends BaseActivity implements View.OnClickListener {
    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 109:
                    WC2FordLincoinFactoryPwdAct.this.updateStatus(val);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc2_ford_lincoin_factory_pwd_act);
        init();
    }

    @Override
    public void init() {
        setSelfClick(findViewById(R.id.wc_ford_pwd_update), this);
        setSelfClick(findViewById(R.id.wc_ford_pwd_del), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.wc_ford_pwd_update /* 2131428537 */:
                showPwd(4, "工厂密码", "确认");
                break;
            case R.id.wc_ford_pwd_del /* 2131428539 */:
                showPwd(4, "工厂密码", "确认");
                break;
        }
    }

    
    public void sendCmd(int data0, int data1, int data2, int data3) {
        DataCanbus.PROXY.cmd(5, new int[]{data0, data1, data2, data3}, null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateStatus(int val) {
        switch (val) {
            case 1:
                OptionDialog("修改选项");
                break;
            case 2:
                showPwd(4, "工厂密码", "确认");
                Toast.makeText(this, "工厂密码错误", 0).show();
                break;
            case 3:
                Toast.makeText(this, "修改密码成功", 0).show();
                break;
            case 4:
                Toast.makeText(this, "清除密码成功", 0).show();
                break;
        }
    }

    
    public void showPwd(final int type, String s1, String s2) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setBackgroundColor(Color.parseColor("#44ffffff"));
        linearLayout.setGravity(1);
        linearLayout.setHorizontalGravity(1);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(this);
        textView.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(310, 50);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(-1);
        textView.setTextSize(20.0f);
        textView.setPadding(0, 10, 0, 10);
        textView.setText(s1);
        final EditText editText = new EditText(this);
        editText.setInputType(2);
        editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        editText.setBackgroundColor(-1);
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
        Button button = new Button(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-2, -2);
        params.topMargin = 12;
        button.setLayoutParams(params);
        button.setText(s2);
        textView.setGravity(17);
        button.setTextSize(20.0f);
        button.setTextColor(-16777216);
        button.setPadding(30, 10, 30, 10);
        button.setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int[] intArr = WC2FordLincoinFactoryPwdAct.this.strToIntArr(editText.getText().toString());
                if (intArr != null) {
                    int data0 = intArr[0];
                    int data1 = intArr[1];
                    int data2 = intArr[2];
                    int data3 = intArr[3];
                    int data4 = intArr[4];
                    int v1 = ((data0 << 4) & 255) | (data1 & 255);
                    int v2 = ((data2 << 4) & 255) | (data3 & 255);
                    int v3 = (data4 << 4) & 255;
                    WC2FordLincoinFactoryPwdAct.this.sendCmd(type, v1, v2, v3);
                    WC2FordLincoinFactoryPwdAct.this.dialog.dismiss();
                }
            }
        });
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        linearLayout.addView(button);
        this.builder = new AlertDialog.Builder(this).setView(linearLayout);
        this.dialog = this.builder.create();
        this.dialog.show();
    }

    private void OptionDialog(String s1) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setBackgroundColor(Color.parseColor("#44ffffff"));
        linearLayout.setGravity(1);
        linearLayout.setHorizontalGravity(1);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(this);
        textView.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(310, 80);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(-1);
        textView.setTextSize(20.0f);
        textView.setPadding(0, 10, 0, 10);
        textView.setText(s1);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(1);
        linearLayout2.setHorizontalGravity(1);
        Button button = new Button(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-2, -2);
        params.topMargin = 30;
        button.setLayoutParams(params);
        button.setText("修改");
        button.setGravity(17);
        button.setTextSize(20.0f);
        button.setTextColor(-16777216);
        button.setPadding(30, 10, 30, 10);
        button.setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                WC2FordLincoinFactoryPwdAct.this.dialog.dismiss();
                WC2FordLincoinFactoryPwdAct.this.showPwd(5, "密码修改", "确认");
            }
        });
        Button button2 = new Button(this);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(-2, -2);
        params2.topMargin = 30;
        params2.leftMargin = 30;
        button2.setLayoutParams(params2);
        button2.setText("删除");
        button2.setGravity(17);
        button2.setTextSize(20.0f);
        button2.setTextColor(-16777216);
        button2.setPadding(30, 10, 30, 10);
        button2.setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                WC2FordLincoinFactoryPwdAct.this.dialog.dismiss();
                WC2FordLincoinFactoryPwdAct.this.sendCmd(6, 0, 0, 0);
            }
        });
        linearLayout2.addView(button);
        linearLayout2.addView(button2);
        linearLayout.addView(textView);
        linearLayout.addView(linearLayout2);
        this.builder = new AlertDialog.Builder(this).setView(linearLayout);
        this.dialog = this.builder.create();
        this.dialog.show();
    }

    
    public int[] strToIntArr(String str) {
        int[] ints = new int[str.length()];
        if (TextUtils.isEmpty(str) || str.length() < 5) {
            Toast.makeText(this, "密码长度为五位", 0).show();
            return null;
        }
        for (int i = 0; i < ints.length; i++) {
            int temp = Integer.parseInt(str.substring(i, i + 1));
            if (temp == 1) {
                temp = 2;
            } else if (temp == 3) {
                temp = 4;
            } else if (temp == 5) {
                temp = 6;
            } else if (temp == 7) {
                temp = 8;
            } else if (temp == 9) {
                temp = 0;
            }
            ints[i] = temp;
        }
        return ints;
    }
}
