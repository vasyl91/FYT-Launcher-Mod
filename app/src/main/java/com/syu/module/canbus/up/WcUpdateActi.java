package com.syu.module.canbus.up;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WcUpdateActi extends Activity {
    private Button mBtnSearch;
    private Button mBtnStart;
    private TextView mTvFilePath;
    private TextView mTvProgress;
    private TextView mTvResult;
    private IUiNotify notifyFilePath = new IUiNotify() { // from class: com.syu.module.canbus.up.WcUpdateActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (WcUpdateActi.this.mTvFilePath != null) {
                WcUpdateActi.this.mTvFilePath.setText(DataCanUp.mFileUpdatePath);
            }
        }
    };
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.module.canbus.up.WcUpdateActi.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                case 1:
                    int curr = DataCanUp.DATA[0];
                    int total = DataCanUp.DATA[1];
                    if (WcUpdateActi.this.mTvProgress != null) {
                        WcUpdateActi.this.mTvProgress.setText(String.valueOf(curr) + "/" + total);
                        break;
                    }
                case 2:
                    int result = DataCanUp.DATA[2];
                    if (WcUpdateActi.this.mTvResult != null) {
                        switch (result) {
                            case 1:
                                WcUpdateActi.this.mTvResult.setText(R.string.canbus_update_start);
                                break;
                            case 2:
                                WcUpdateActi.this.mTvResult.setText(R.string.canbus_update_ing);
                                break;
                            case 3:
                                WcUpdateActi.this.mTvResult.setText(R.string.canbus_update_success);
                                break;
                            case 4:
                                WcUpdateActi.this.mTvResult.setText(R.string.canbus_update_failed);
                                break;
                            case 5:
                                WcUpdateActi.this.mTvResult.setText(R.string.canbus_update_nomate);
                                break;
                            case 6:
                                WcUpdateActi.this.mTvResult.setText(R.string.canbus_update_large);
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_canbus_update_wc);
        init();
    }

    public void init() {
        this.mTvFilePath = (TextView) findViewById(R.id.update_file_path_wc);
        this.mTvProgress = (TextView) findViewById(R.id.update_progress_wc);
        this.mTvResult = (TextView) findViewById(R.id.update_result_wc);
        this.mBtnSearch = (Button) findViewById(R.id.update_file_path_search_wc);
        this.mBtnSearch.setOnClickListener(new View.OnClickListener() { // from class: com.syu.module.canbus.up.WcUpdateActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                LauncherApplication.getInstance().activityByIntentName("com.syu.filemanager");
            }
        });
        this.mBtnStart = (Button) findViewById(R.id.start_update_wc);
        this.mBtnStart.setOnClickListener(new View.OnClickListener() { // from class: com.syu.module.canbus.up.WcUpdateActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                if (DataCanUp.mFileUpdatePath != null && !DataCanUp.mFileUpdatePath.equals("")) {
                    WcUpdateActi.this.dialog();
                }
            }
        });
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

    public void addNotify() {
        DataCanUp.NOTIFY_EVENTS[0].addNotify(this.notifyCanbus, 1);
        DataCanUp.NOTIFY_EVENTS[1].addNotify(this.notifyCanbus, 1);
        DataCanUp.NOTIFY_EVENTS[2].addNotify(this.notifyCanbus, 1);
        DataCanUp.NOTIFY_EVENTS_FILEPATH.addNotify(this.notifyFilePath);
    }

    public void removeNotify() {
        DataCanUp.NOTIFY_EVENTS[0].removeNotify(this.notifyCanbus);
        DataCanUp.NOTIFY_EVENTS[1].removeNotify(this.notifyCanbus);
        DataCanUp.NOTIFY_EVENTS[2].removeNotify(this.notifyCanbus);
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.canbus_update_warnning));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.module.canbus.up.WcUpdateActi.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.module.canbus.up.WcUpdateActi.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanUp.PROXY.cmd(0, null, null, new String[]{DataCanUp.mFileUpdatePath});
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.module.canbus.up.WcUpdateActi.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
