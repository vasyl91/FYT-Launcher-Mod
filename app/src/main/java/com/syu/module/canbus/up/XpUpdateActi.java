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
public class XpUpdateActi extends Activity {
    private Button mBtnSearch;
    private Button mBtnStart;
    private TextView mTvFilePath;
    private TextView mTvProgress;
    private TextView mTvResult;
    private IUiNotify notifyFilePath = new IUiNotify() { // from class: com.syu.module.canbus.up.XpUpdateActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (XpUpdateActi.this.mTvFilePath != null) {
                XpUpdateActi.this.mTvFilePath.setText(DataCanUp.mFileUpdatePath);
            }
        }
    };
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.module.canbus.up.XpUpdateActi.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                case 1:
                    int curr = DataCanUp.DATA[0];
                    int total = DataCanUp.DATA[1];
                    if (XpUpdateActi.this.mTvProgress != null) {
                        XpUpdateActi.this.mTvProgress.setText(String.valueOf(curr) + "/" + total);
                        break;
                    }
                case 2:
                    int result = DataCanUp.DATA[2];
                    if (XpUpdateActi.this.mTvResult != null) {
                        switch (result) {
                            case 1:
                                XpUpdateActi.this.mTvResult.setText(R.string.canbus_update_start);
                                break;
                            case 2:
                                XpUpdateActi.this.mTvResult.setText(R.string.canbus_update_ing);
                                break;
                            case 3:
                                XpUpdateActi.this.mTvResult.setText(R.string.canbus_update_success);
                                break;
                            case 4:
                                XpUpdateActi.this.mTvResult.setText(R.string.canbus_update_failed);
                                break;
                            case 5:
                                XpUpdateActi.this.mTvResult.setText(R.string.canbus_update_nomate);
                                break;
                            case 6:
                                XpUpdateActi.this.mTvResult.setText(R.string.canbus_update_large);
                                break;
                            case 7:
                                XpUpdateActi.this.mTvResult.setText(R.string.canbus_update_crc_error);
                                break;
                            case 8:
                                XpUpdateActi.this.mTvResult.setText(R.string.canbus_file_error);
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
        setContentView(R.layout.layout_canbus_update_xp);
        init();
    }

    public void init() {
        this.mTvFilePath = (TextView) findViewById(R.id.update_file_path_xp);
        this.mTvProgress = (TextView) findViewById(R.id.update_progress_xp);
        this.mTvResult = (TextView) findViewById(R.id.update_result_xp);
        this.mBtnSearch = (Button) findViewById(R.id.update_file_path_search_xp);
        this.mBtnSearch.setOnClickListener(new View.OnClickListener() { // from class: com.syu.module.canbus.up.XpUpdateActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                LauncherApplication.getInstance().activityByIntentName("com.syu.filemanager");
            }
        });
        this.mBtnStart = (Button) findViewById(R.id.start_update_xp);
        this.mBtnStart.setOnClickListener(new View.OnClickListener() { // from class: com.syu.module.canbus.up.XpUpdateActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                if (DataCanUp.mFileUpdatePath != null && !DataCanUp.mFileUpdatePath.equals("")) {
                    XpUpdateActi.this.dialog();
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
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.module.canbus.up.XpUpdateActi.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.module.canbus.up.XpUpdateActi.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanUp.PROXY.cmd(0, null, null, new String[]{DataCanUp.mFileUpdatePath});
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.module.canbus.up.XpUpdateActi.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
