package com.syu.carinfo.od.tusheng;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RZC_XiandaiE_InfoAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 153:
                    switch (value) {
                        case 0:
                            RZC_XiandaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_rzc_xiandai_lev0);
                            break;
                        case 1:
                            RZC_XiandaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_rzc_xiandai_lev1);
                            break;
                        case 2:
                            RZC_XiandaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_rzc_xiandai_lev2);
                            break;
                        case 3:
                            RZC_XiandaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_rzc_xiandai_lev3);
                            break;
                        case 4:
                            RZC_XiandaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_rzc_xiandai_lev4);
                            break;
                        case 5:
                            RZC_XiandaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_rzc_xiandai_lev5);
                            break;
                        case 6:
                            RZC_XiandaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_rzc_xiandai_lev6);
                            break;
                        case 7:
                            RZC_XiandaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_rzc_xiandai_lev7);
                            break;
                        case 8:
                            RZC_XiandaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_rzc_xiandai_lev8);
                            break;
                    }
                case 154:
                    switch (value) {
                        case 0:
                            ((TextView) RZC_XiandaiE_InfoAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_447_xiandai_str0);
                            RZC_XiandaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_rzc_xiandai_ui0);
                            break;
                        case 1:
                            ((TextView) RZC_XiandaiE_InfoAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_447_xiandai_str1);
                            RZC_XiandaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_rzc_xiandai_ui1);
                            break;
                        case 2:
                            ((TextView) RZC_XiandaiE_InfoAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_447_xiandai_str2);
                            RZC_XiandaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_rzc_xiandai_ui2);
                            break;
                        case 3:
                            ((TextView) RZC_XiandaiE_InfoAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_447_xiandai_str3);
                            RZC_XiandaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_rzc_xiandai_ui3);
                            break;
                        case 4:
                            ((TextView) RZC_XiandaiE_InfoAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_447_xiandai_str4);
                            RZC_XiandaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_rzc_xiandai_ui4);
                            break;
                        case 5:
                            ((TextView) RZC_XiandaiE_InfoAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_447_xiandai_str5);
                            RZC_XiandaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_rzc_xiandai_ui5);
                            break;
                        case 6:
                            ((TextView) RZC_XiandaiE_InfoAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_447_xiandai_str5);
                            RZC_XiandaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_rzc_xiandai_ui6);
                            break;
                        case 7:
                            ((TextView) RZC_XiandaiE_InfoAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_447_xiandai_str7);
                            RZC_XiandaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_rzc_xiandai_ui7);
                            break;
                        case 8:
                            ((TextView) RZC_XiandaiE_InfoAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_447_xiandai_str5);
                            RZC_XiandaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_rzc_xiandai_ui8);
                            break;
                        case 9:
                            ((TextView) RZC_XiandaiE_InfoAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_447_xiandai_str5);
                            RZC_XiandaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_rzc_xiandai_ui9);
                            break;
                        case 10:
                            ((TextView) RZC_XiandaiE_InfoAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_447_xiandai_str5);
                            RZC_XiandaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_rzc_xiandai_ui10);
                            break;
                        case 11:
                            ((TextView) RZC_XiandaiE_InfoAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_447_xiandai_str5);
                            RZC_XiandaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_rzc_xiandai_ui11);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0447_rzc_xiandai_e_info);
    }

    @Override
    public void onClick(View arg0) {
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{85}, null, null);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
    }
}
