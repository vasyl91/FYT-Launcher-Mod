package com.syu.carinfo.qiya.kx7;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class ActivityWCXianDaiAllSet2 extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.qiya.kx7.ActivityWCXianDaiAllSet2.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 205:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                    }
                    break;
                case 206:
                    if (((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text1)).setText("OFF");
                                break;
                            case 1:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text1)).setText("Warning");
                                break;
                            case 2:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text1)).setText("Assist");
                                break;
                        }
                    }
                    break;
                case 207:
                    if (((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text2)).setText("-10km/h");
                                break;
                            case 1:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text2)).setText("-5km/h");
                                break;
                            case 2:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text2)).setText("0km/h");
                                break;
                            case 3:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text2)).setText("+5km/h");
                                break;
                            case 4:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text2)).setText("+10km/h");
                                break;
                        }
                    }
                    break;
                case 208:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext2)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
                    }
                    break;
                case 209:
                    if (((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text3)).setText("Standard");
                                break;
                            case 1:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text3)).setText("Late");
                                break;
                        }
                    }
                    break;
                case 210:
                    if (((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 211:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext3)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
                    }
                    break;
                case 212:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext4)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
                    }
                    break;
                case 213:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext5)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
                    }
                    break;
                case 214:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext6)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
                    }
                    break;
                case 215:
                    if (((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text5)).setText("OFF");
                                break;
                            case 1:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text5)).setText("Warning Only");
                                break;
                            case 2:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text5)).setText("Active Assist");
                                break;
                        }
                    }
                    break;
                case 216:
                    if (((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text6)).setText("OFF");
                                break;
                            case 1:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text6)).setText("Warning Only");
                                break;
                            case 2:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text6)).setText("Active Assist");
                                break;
                        }
                    }
                    break;
                case 217:
                    if (((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text7)).setText("Warning Only");
                                break;
                            case 1:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text7)).setText("Active Assist");
                                break;
                        }
                    }
                    break;
                case 218:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext7)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
                    }
                    break;
                case 219:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext8)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
                    }
                    break;
                case 220:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext9)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
                    }
                    break;
                case 221:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext10)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value != 0);
                    }
                    break;
                case 222:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext11)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value != 0);
                    }
                    break;
                case 223:
                    if (((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text8)).setText("----");
                                break;
                            case 1:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text8)).setText("COMFORT");
                                break;
                            case 3:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text8)).setText("SPORT");
                                break;
                        }
                    }
                    break;
                case 224:
                    if (((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text9)).setText("----");
                                break;
                            case 1:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text9)).setText("COMFORT");
                                break;
                            case 2:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text9)).setText("ECO");
                                break;
                            case 3:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text9)).setText("SPORT");
                                break;
                        }
                    }
                    break;
                case 225:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext12)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext12)).setChecked(value != 0);
                    }
                    break;
                case 226:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext13)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext13)).setChecked(value != 0);
                    }
                    break;
                case 227:
                    if (((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text10)).setText("----");
                                break;
                            case 1:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text10)).setText("RESET");
                                break;
                            case 2:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text10)).setText("Casual");
                                break;
                            case 3:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text10)).setText("Sleeping");
                                break;
                        }
                    }
                    break;
                case 228:
                    if (((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text11)).setText("----");
                                break;
                            case 1:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text11)).setText("RESET");
                                break;
                            case 2:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text11)).setText("Casual");
                                break;
                            case 3:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text11)).setText("Sleeping");
                                break;
                        }
                    }
                    break;
                case 229:
                    if (((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text12)).setText("----");
                                break;
                            case 1:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text12)).setText("RESET");
                                break;
                            case 2:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text12)).setText("Rear entry");
                                break;
                        }
                    }
                    break;
                case 230:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext14)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext14)).setChecked(value != 0);
                    }
                    break;
                case 231:
                    if (((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text13)).setText(String.valueOf((value * 5) + 30) + "km/h");
                    }
                    break;
                case 232:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext15)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext15)).setChecked(value != 0);
                    }
                    break;
                case 233:
                    if (((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text14)) != null) {
                        ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text14)).setText(String.valueOf((value * 10) + 10) + "km/h");
                    }
                    break;
                case 234:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext16)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext16)).setChecked(value != 0);
                    }
                    break;
                case 235:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext17)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext17)).setChecked(value != 0);
                    }
                    break;
                case 236:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext18)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext18)).setChecked(value != 0);
                    }
                    break;
                case 237:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext19)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext19)).setChecked(value != 0);
                    }
                    break;
                case 238:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext20)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext20)).setChecked(value != 0);
                    }
                    break;
                case 239:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext21)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext21)).setChecked(value != 0);
                    }
                    break;
                case 240:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext22)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext22)).setChecked(value != 0);
                    }
                    break;
                case 241:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext23)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext23)).setChecked(value != 0);
                    }
                    break;
                case 242:
                    if (((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text15)) != null) {
                        ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text15)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
                case 243:
                    if (((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text16)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text16)).setText("OFF");
                                break;
                            case 1:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text16)).setText(R.string.vehicle_detail_status_since_refuelling1);
                                break;
                            case 2:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text16)).setText(R.string.vehicle_detail_status_since_start1);
                                break;
                        }
                    }
                    break;
                case 244:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext24)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext24)).setChecked(value != 0);
                    }
                    break;
                case 245:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext25)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext25)).setChecked(value != 0);
                    }
                    break;
                case 246:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext26)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext26)).setChecked(value != 0);
                    }
                    break;
                case 247:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext27)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext27)).setChecked(value != 0);
                    }
                    break;
                case 248:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext28)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.ctv_checkedtext28)).setChecked(value != 0);
                    }
                    break;
                case 249:
                    if (((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text17)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text17)).setText("OFF");
                                break;
                            case 1:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text17)).setText(R.string.distance_close);
                                break;
                            case 2:
                                ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text17)).setText(R.string.distance_far);
                                break;
                        }
                    }
                    break;
                case 250:
                    if (((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text18)) != null) {
                        ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text18)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
                case 251:
                    if (((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text19)) != null) {
                        ((TextView) ActivityWCXianDaiAllSet2.this.findViewById(R.id.tv_text19)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_xiandai_all_set2);
        setListener();
    }

    void setListener() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext17)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext18)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext19)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext20)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext21)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext22)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext23)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext24)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext25)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext26)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext27)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext28)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus10)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus11)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus11)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus12)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus12)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus13)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus13)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus14)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus14)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus15)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus15)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus16)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus16)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus17)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus17)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus18)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus18)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus19)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus19)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
                int value3 = DataCanbus.DATA[206] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                DataCanbus.PROXY.cmd(4, new int[]{81, value3, 255, 255}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value4 = DataCanbus.DATA[206] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{81, value4, 255, 255}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value5 = DataCanbus.DATA[207] - 1;
                if (value5 < 0) {
                    value5 = 4;
                }
                DataCanbus.PROXY.cmd(4, new int[]{82, value5, 255, 255}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value6 = DataCanbus.DATA[207] + 1;
                if (value6 > 4) {
                    value6 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{82, value6, 255, 255}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value7 = DataCanbus.DATA[209] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{84, value7, 255, 255}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value8 = DataCanbus.DATA[209] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{84, value8, 255, 255}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int value9 = DataCanbus.DATA[210] + 1;
                if (value9 > 3) {
                    value9 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{85, value9, 255, 255}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                int value10 = DataCanbus.DATA[215] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{90, value10, 255, 255}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427430 */:
                int value11 = DataCanbus.DATA[216] + 1;
                if (value11 > 2) {
                    value11 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{91, value11, 255, 255}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427431 */:
                int value12 = DataCanbus.DATA[217] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{92, value12, 255, 255}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427432 */:
                if (DataCanbus.DATA[223] == 1) {
                    value = 3;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{98, value, 255, 255}, null, null);
                break;
            case R.id.btn_plus9 /* 2131427433 */:
                int value13 = DataCanbus.DATA[224] + 1;
                if (value13 > 3) {
                    value13 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{97, value13, 255, 255}, null, null);
                break;
            case R.id.btn_plus10 /* 2131427434 */:
                int value14 = DataCanbus.DATA[227] + 1;
                if (value14 > 3) {
                    value14 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{130, value14, 255, 255}, null, null);
                break;
            case R.id.btn_plus11 /* 2131427435 */:
                int value15 = DataCanbus.DATA[228] + 1;
                if (value15 > 3) {
                    value15 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{129, value15, 255, 255}, null, null);
                break;
            case R.id.btn_plus12 /* 2131427436 */:
                int value16 = DataCanbus.DATA[229] + 1;
                if (value16 > 2) {
                    value16 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{128, value16, 255, 255}, null, null);
                break;
            case R.id.btn_plus13 /* 2131427437 */:
                int value17 = DataCanbus.DATA[231] + 1;
                if (value17 > 34) {
                    value17 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{100, value17, 255, 255}, null, null);
                break;
            case R.id.btn_plus14 /* 2131427438 */:
                int value18 = DataCanbus.DATA[233] + 1;
                if (value18 > 4) {
                    value18 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{102, value18, 255, 255}, null, null);
                break;
            case R.id.btn_plus15 /* 2131427439 */:
                int value19 = DataCanbus.DATA[242] + 1;
                if (value19 > 3) {
                    value19 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{119, value19, 255, 255}, null, null);
                break;
            case R.id.btn_plus16 /* 2131427440 */:
                int value20 = DataCanbus.DATA[243] + 1;
                if (value20 > 2) {
                    value20 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{118, value20, 255, 255}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                int value21 = DataCanbus.DATA[210] - 1;
                if (value21 < 1) {
                    value21 = 3;
                }
                DataCanbus.PROXY.cmd(4, new int[]{85, value21, 255, 255}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427474 */:
                int value22 = DataCanbus.DATA[215] - 1;
                if (value22 < 0) {
                    value22 = 2;
                }
                DataCanbus.PROXY.cmd(4, new int[]{90, value22, 255, 255}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427476 */:
                int value23 = DataCanbus.DATA[216] - 1;
                if (value23 < 0) {
                    value23 = 2;
                }
                DataCanbus.PROXY.cmd(4, new int[]{91, value23, 255, 255}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427478 */:
                int value24 = DataCanbus.DATA[217] - 1;
                if (value24 < 0) {
                    value24 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{92, value24, 255, 255}, null, null);
                break;
            case R.id.btn_minus8 /* 2131427480 */:
                if (DataCanbus.DATA[223] == 1) {
                    value2 = 3;
                } else {
                    value2 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{98, value2, 255, 255}, null, null);
                break;
            case R.id.btn_minus9 /* 2131427482 */:
                int value25 = DataCanbus.DATA[224] - 1;
                if (value25 < 1) {
                    value25 = 3;
                }
                DataCanbus.PROXY.cmd(4, new int[]{97, value25, 255, 255}, null, null);
                break;
            case R.id.btn_minus10 /* 2131427484 */:
                int value26 = DataCanbus.DATA[227] - 1;
                if (value26 < 1) {
                    value26 = 3;
                }
                DataCanbus.PROXY.cmd(4, new int[]{130, value26, 255, 255}, null, null);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value27 = DataCanbus.DATA[228] - 1;
                if (value27 < 1) {
                    value27 = 3;
                }
                DataCanbus.PROXY.cmd(4, new int[]{129, value27, 255, 255}, null, null);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value28 = DataCanbus.DATA[229] - 1;
                if (value28 < 1) {
                    value28 = 2;
                }
                DataCanbus.PROXY.cmd(4, new int[]{128, value28, 255, 255}, null, null);
                break;
            case R.id.btn_minus13 /* 2131427490 */:
                int value29 = DataCanbus.DATA[231] - 1;
                if (value29 < 0) {
                    value29 = 34;
                }
                DataCanbus.PROXY.cmd(4, new int[]{100, value29, 255, 255}, null, null);
                break;
            case R.id.btn_minus14 /* 2131427492 */:
                int value30 = DataCanbus.DATA[233] - 1;
                if (value30 < 0) {
                    value30 = 4;
                }
                DataCanbus.PROXY.cmd(4, new int[]{102, value30, 255, 255}, null, null);
                break;
            case R.id.btn_minus15 /* 2131427494 */:
                int value31 = DataCanbus.DATA[242] - 1;
                if (value31 < 0) {
                    value31 = 3;
                }
                DataCanbus.PROXY.cmd(4, new int[]{119, value31, 255, 255}, null, null);
                break;
            case R.id.btn_minus16 /* 2131427496 */:
                int value32 = DataCanbus.DATA[243] - 1;
                if (value32 < 0) {
                    value32 = 2;
                }
                DataCanbus.PROXY.cmd(4, new int[]{118, value32, 255, 255}, null, null);
                break;
            case R.id.btn_minus17 /* 2131427498 */:
                int value33 = DataCanbus.DATA[249] - 1;
                if (value33 < 0) {
                    value33 = 2;
                }
                DataCanbus.PROXY.cmd(4, new int[]{71, value33, 255, 255}, null, null);
                break;
            case R.id.btn_plus17 /* 2131427500 */:
                int value34 = DataCanbus.DATA[249] + 1;
                if (value34 > 2) {
                    value34 = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{71, value34, 255, 255}, null, null);
                break;
            case R.id.btn_minus18 /* 2131427501 */:
                int value35 = DataCanbus.DATA[250] / 30;
                if (value35 < 1) {
                    value35 = 99;
                }
                DataCanbus.PROXY.cmd(4, new int[]{66, value35, 255, 255}, null, null);
                break;
            case R.id.btn_plus18 /* 2131427503 */:
                int value36 = (DataCanbus.DATA[250] / 30) + 1;
                if (value36 > 99) {
                    value36 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{66, value36, 255, 255}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                int value37 = DataCanbus.DATA[205];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[4];
                iArr[0] = 80;
                iArr[1] = value37 != 1 ? 1 : 0;
                iArr[2] = 255;
                iArr[3] = 255;
                remoteModuleProxy.cmd(4, iArr, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427552 */:
                int value38 = DataCanbus.DATA[212];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[4];
                iArr2[0] = 87;
                iArr2[1] = value38 != 1 ? 1 : 0;
                iArr2[2] = 255;
                iArr2[3] = 255;
                remoteModuleProxy2.cmd(4, iArr2, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427553 */:
                int value39 = DataCanbus.DATA[213];
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[4];
                iArr3[0] = 88;
                iArr3[1] = value39 != 1 ? 1 : 0;
                iArr3[2] = 255;
                iArr3[3] = 255;
                remoteModuleProxy3.cmd(4, iArr3, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                int value40 = DataCanbus.DATA[208];
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[4];
                iArr4[0] = 83;
                iArr4[1] = value40 != 1 ? 1 : 0;
                iArr4[2] = 255;
                iArr4[3] = 255;
                remoteModuleProxy4.cmd(4, iArr4, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                int value41 = DataCanbus.DATA[211];
                RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                int[] iArr5 = new int[4];
                iArr5[0] = 86;
                iArr5[1] = value41 != 1 ? 1 : 0;
                iArr5[2] = 255;
                iArr5[3] = 255;
                remoteModuleProxy5.cmd(4, iArr5, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427563 */:
                int value42 = DataCanbus.DATA[214];
                RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                int[] iArr6 = new int[4];
                iArr6[0] = 89;
                iArr6[1] = value42 != 1 ? 1 : 0;
                iArr6[2] = 255;
                iArr6[3] = 255;
                remoteModuleProxy6.cmd(4, iArr6, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427564 */:
                int value43 = DataCanbus.DATA[218];
                RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                int[] iArr7 = new int[4];
                iArr7[0] = 93;
                iArr7[1] = value43 != 1 ? 1 : 0;
                iArr7[2] = 255;
                iArr7[3] = 255;
                remoteModuleProxy7.cmd(4, iArr7, null, null);
                break;
            case R.id.btn_minus19 /* 2131427575 */:
                int value44 = DataCanbus.DATA[251] / 100;
                if (value44 < 1) {
                    value44 = 999;
                }
                DataCanbus.PROXY.cmd(4, new int[]{65, (value44 >> 8) & 255, value44 & 255, 255}, null, null);
                break;
            case R.id.btn_plus19 /* 2131427577 */:
                int value45 = (DataCanbus.DATA[251] / 100) + 1;
                if (value45 > 999) {
                    value45 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{65, (value45 >> 8) & 255, value45 & 255, 255}, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427615 */:
                int value46 = DataCanbus.DATA[219];
                RemoteModuleProxy remoteModuleProxy8 = DataCanbus.PROXY;
                int[] iArr8 = new int[4];
                iArr8[0] = 94;
                iArr8[1] = value46 != 1 ? 1 : 0;
                iArr8[2] = 255;
                iArr8[3] = 255;
                remoteModuleProxy8.cmd(4, iArr8, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427616 */:
                int value47 = DataCanbus.DATA[220];
                RemoteModuleProxy remoteModuleProxy9 = DataCanbus.PROXY;
                int[] iArr9 = new int[4];
                iArr9[0] = 95;
                iArr9[1] = value47 != 1 ? 1 : 0;
                iArr9[2] = 255;
                iArr9[3] = 255;
                remoteModuleProxy9.cmd(4, iArr9, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427617 */:
                int value48 = DataCanbus.DATA[221];
                RemoteModuleProxy remoteModuleProxy10 = DataCanbus.PROXY;
                int[] iArr10 = new int[4];
                iArr10[0] = 96;
                iArr10[1] = value48 != 1 ? 1 : 0;
                iArr10[2] = 255;
                iArr10[3] = 255;
                remoteModuleProxy10.cmd(4, iArr10, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427618 */:
                int value49 = DataCanbus.DATA[222];
                RemoteModuleProxy remoteModuleProxy11 = DataCanbus.PROXY;
                int[] iArr11 = new int[4];
                iArr11[0] = 103;
                iArr11[1] = value49 != 1 ? 1 : 0;
                iArr11[2] = 255;
                iArr11[3] = 255;
                remoteModuleProxy11.cmd(4, iArr11, null, null);
                break;
            case R.id.ctv_checkedtext12 /* 2131427619 */:
                int value50 = DataCanbus.DATA[225];
                RemoteModuleProxy remoteModuleProxy12 = DataCanbus.PROXY;
                int[] iArr12 = new int[4];
                iArr12[0] = 60;
                iArr12[1] = value50 != 1 ? 1 : 0;
                iArr12[2] = 255;
                iArr12[3] = 255;
                remoteModuleProxy12.cmd(4, iArr12, null, null);
                break;
            case R.id.ctv_checkedtext13 /* 2131427620 */:
                int value51 = DataCanbus.DATA[226];
                RemoteModuleProxy remoteModuleProxy13 = DataCanbus.PROXY;
                int[] iArr13 = new int[4];
                iArr13[0] = 61;
                iArr13[1] = value51 != 1 ? 1 : 0;
                iArr13[2] = 255;
                iArr13[3] = 255;
                remoteModuleProxy13.cmd(4, iArr13, null, null);
                break;
            case R.id.ctv_checkedtext14 /* 2131427621 */:
                int value52 = DataCanbus.DATA[230];
                RemoteModuleProxy remoteModuleProxy14 = DataCanbus.PROXY;
                int[] iArr14 = new int[4];
                iArr14[0] = 99;
                iArr14[1] = value52 != 1 ? 1 : 0;
                iArr14[2] = 255;
                iArr14[3] = 255;
                remoteModuleProxy14.cmd(4, iArr14, null, null);
                break;
            case R.id.ctv_checkedtext15 /* 2131427622 */:
                int value53 = DataCanbus.DATA[232];
                RemoteModuleProxy remoteModuleProxy15 = DataCanbus.PROXY;
                int[] iArr15 = new int[4];
                iArr15[0] = 101;
                iArr15[1] = value53 != 1 ? 1 : 0;
                iArr15[2] = 255;
                iArr15[3] = 255;
                remoteModuleProxy15.cmd(4, iArr15, null, null);
                break;
            case R.id.ctv_checkedtext16 /* 2131427623 */:
                int value54 = DataCanbus.DATA[234];
                RemoteModuleProxy remoteModuleProxy16 = DataCanbus.PROXY;
                int[] iArr16 = new int[4];
                iArr16[0] = 58;
                iArr16[1] = value54 != 1 ? 1 : 0;
                iArr16[2] = 255;
                iArr16[3] = 255;
                remoteModuleProxy16.cmd(4, iArr16, null, null);
                break;
            case R.id.ctv_checkedtext17 /* 2131427624 */:
                int value55 = DataCanbus.DATA[235];
                RemoteModuleProxy remoteModuleProxy17 = DataCanbus.PROXY;
                int[] iArr17 = new int[4];
                iArr17[0] = 57;
                iArr17[1] = value55 != 1 ? 1 : 0;
                iArr17[2] = 255;
                iArr17[3] = 255;
                remoteModuleProxy17.cmd(4, iArr17, null, null);
                break;
            case R.id.ctv_checkedtext26 /* 2131427715 */:
                int value56 = DataCanbus.DATA[246];
                RemoteModuleProxy remoteModuleProxy18 = DataCanbus.PROXY;
                int[] iArr18 = new int[4];
                iArr18[0] = 68;
                iArr18[1] = value56 != 1 ? 1 : 0;
                iArr18[2] = 255;
                iArr18[3] = 255;
                remoteModuleProxy18.cmd(4, iArr18, null, null);
                break;
            case R.id.ctv_checkedtext18 /* 2131427728 */:
                int value57 = DataCanbus.DATA[236];
                RemoteModuleProxy remoteModuleProxy19 = DataCanbus.PROXY;
                int[] iArr19 = new int[4];
                iArr19[0] = 56;
                iArr19[1] = value57 != 1 ? 1 : 0;
                iArr19[2] = 255;
                iArr19[3] = 255;
                remoteModuleProxy19.cmd(4, iArr19, null, null);
                break;
            case R.id.ctv_checkedtext19 /* 2131427730 */:
                int value58 = DataCanbus.DATA[237];
                RemoteModuleProxy remoteModuleProxy20 = DataCanbus.PROXY;
                int[] iArr20 = new int[4];
                iArr20[0] = 55;
                iArr20[1] = value58 != 1 ? 1 : 0;
                iArr20[2] = 255;
                iArr20[3] = 255;
                remoteModuleProxy20.cmd(4, iArr20, null, null);
                break;
            case R.id.ctv_checkedtext20 /* 2131427732 */:
                int value59 = DataCanbus.DATA[238];
                RemoteModuleProxy remoteModuleProxy21 = DataCanbus.PROXY;
                int[] iArr21 = new int[4];
                iArr21[0] = 54;
                iArr21[1] = value59 != 1 ? 1 : 0;
                iArr21[2] = 255;
                iArr21[3] = 255;
                remoteModuleProxy21.cmd(4, iArr21, null, null);
                break;
            case R.id.ctv_checkedtext21 /* 2131427734 */:
                int value60 = DataCanbus.DATA[239];
                RemoteModuleProxy remoteModuleProxy22 = DataCanbus.PROXY;
                int[] iArr22 = new int[4];
                iArr22[0] = 53;
                iArr22[1] = value60 != 1 ? 1 : 0;
                iArr22[2] = 255;
                iArr22[3] = 255;
                remoteModuleProxy22.cmd(4, iArr22, null, null);
                break;
            case R.id.ctv_checkedtext22 /* 2131427736 */:
                int value61 = DataCanbus.DATA[240];
                RemoteModuleProxy remoteModuleProxy23 = DataCanbus.PROXY;
                int[] iArr23 = new int[4];
                iArr23[0] = 52;
                iArr23[1] = value61 != 1 ? 1 : 0;
                iArr23[2] = 255;
                iArr23[3] = 255;
                remoteModuleProxy23.cmd(4, iArr23, null, null);
                break;
            case R.id.ctv_checkedtext23 /* 2131427739 */:
                int value62 = DataCanbus.DATA[241];
                RemoteModuleProxy remoteModuleProxy24 = DataCanbus.PROXY;
                int[] iArr24 = new int[4];
                iArr24[0] = 59;
                iArr24[1] = value62 != 1 ? 1 : 0;
                iArr24[2] = 255;
                iArr24[3] = 255;
                remoteModuleProxy24.cmd(4, iArr24, null, null);
                break;
            case R.id.ctv_checkedtext24 /* 2131427744 */:
                int value63 = DataCanbus.DATA[244];
                RemoteModuleProxy remoteModuleProxy25 = DataCanbus.PROXY;
                int[] iArr25 = new int[4];
                iArr25[0] = 64;
                iArr25[1] = value63 != 1 ? 1 : 0;
                iArr25[2] = 255;
                iArr25[3] = 255;
                remoteModuleProxy25.cmd(4, iArr25, null, null);
                break;
            case R.id.ctv_checkedtext25 /* 2131427746 */:
                int value64 = DataCanbus.DATA[245];
                RemoteModuleProxy remoteModuleProxy26 = DataCanbus.PROXY;
                int[] iArr26 = new int[4];
                iArr26[0] = 67;
                iArr26[1] = value64 != 1 ? 1 : 0;
                iArr26[2] = 255;
                iArr26[3] = 255;
                remoteModuleProxy26.cmd(4, iArr26, null, null);
                break;
            case R.id.ctv_checkedtext27 /* 2131427748 */:
                int value65 = DataCanbus.DATA[247];
                RemoteModuleProxy remoteModuleProxy27 = DataCanbus.PROXY;
                int[] iArr27 = new int[4];
                iArr27[0] = 69;
                iArr27[1] = value65 != 1 ? 1 : 0;
                iArr27[2] = 255;
                iArr27[3] = 255;
                remoteModuleProxy27.cmd(4, iArr27, null, null);
                break;
            case R.id.ctv_checkedtext28 /* 2131427750 */:
                int value66 = DataCanbus.DATA[248];
                RemoteModuleProxy remoteModuleProxy28 = DataCanbus.PROXY;
                int[] iArr28 = new int[4];
                iArr28[0] = 70;
                iArr28[1] = value66 != 1 ? 1 : 0;
                iArr28[2] = 255;
                iArr28[3] = 255;
                remoteModuleProxy28.cmd(4, iArr28, null, null);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[207].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[208].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[209].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[210].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[211].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[212].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[213].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[214].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[216].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[217].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[218].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[219].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[220].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[221].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[222].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[223].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[224].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[225].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[226].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[227].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[228].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[229].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[230].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[231].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[232].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[233].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[234].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[235].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[236].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[237].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[238].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[239].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[240].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[241].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[242].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[243].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[244].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[245].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[246].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[247].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[248].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[249].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[250].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[251].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[207].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[208].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[209].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[210].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[211].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[212].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[213].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[214].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[217].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[218].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[219].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[220].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[221].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[222].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[223].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[224].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[225].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[226].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[227].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[228].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[229].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[230].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[231].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[232].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[233].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[234].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[235].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[236].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[237].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[238].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[239].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[240].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[241].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[242].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[243].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[244].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[245].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[246].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[247].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[248].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[249].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[250].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[251].removeNotify(this.mNotifyCanbus);
    }
}
