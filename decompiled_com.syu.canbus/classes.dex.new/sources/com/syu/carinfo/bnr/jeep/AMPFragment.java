package com.syu.carinfo.bnr.jeep;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class AMPFragment extends BaseFragment {
    private CheckedTextView ckAmp;
    boolean ispressok = false;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bnr.jeep.AMPFragment.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 176:
                    AMPFragment.this.uAmpMode(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseFragment
    public void initView() {
        ((TextView) findView(R.id.title)).setText(R.string.str_guandao_amp);
        this.ckAmp = (CheckedTextView) bindViewOnClick(R.id.dj_airuize7_assi_lamp, new View.OnClickListener() { // from class: com.syu.carinfo.bnr.jeep.AMPFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (!AMPFragment.this.ispressok) {
                    AMPFragment.this.dialog();
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseFragment, android.app.Fragment
    public void onResume() {
        super.onResume();
        setViewVisible(findView(R.id.lay_backradar_view), false);
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(getResources().getString(R.string.str_117_bnr_zyg_9));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.bnr.jeep.AMPFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.bnr.jeep.AMPFragment.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                        int[] iArr = new int[2];
                        iArr[0] = 1;
                        iArr[1] = DataCanbus.DATA[176] != 1 ? 1 : 0;
                        remoteModuleProxy.cmd(3, iArr, null, null);
                        AMPFragment.this.ispressok = true;
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.bnr.jeep.AMPFragment.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // com.syu.canbus.BaseFragment
    public int getViewLayout() {
        return R.layout.layout_151_dj_bydg6;
    }

    @Override // com.syu.canbus.BaseFragment
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseFragment
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
    }

    protected void uAmpMode(int i) {
        setCheck(this.ckAmp, i == 1);
    }
}
