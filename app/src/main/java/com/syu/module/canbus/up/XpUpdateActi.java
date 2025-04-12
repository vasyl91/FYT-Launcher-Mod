package com.syu.module.canbus.up;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;

public class XpUpdateActi extends Activity {
    private Button mBtnSearch;
    private Button mBtnStart;
    private TextView mTvFilePath;
    private TextView mTvProgress;
    private TextView mTvResult;
    private final IUiNotify notifyFilePath = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (XpUpdateActi.this.mTvFilePath != null) {
                XpUpdateActi.this.mTvFilePath.setText(DataCanUp.mFileUpdatePath);
            }
        }
    };
    private final IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                case 1:
                    int curr = DataCanUp.DATA[0];
                    int total = DataCanUp.DATA[1];
                    if (XpUpdateActi.this.mTvProgress != null) {
                        XpUpdateActi.this.mTvProgress.setText(curr + "/" + total);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_canbus_update_xp);
        init();
    }

    public void init() {
        this.mTvFilePath = findViewById(R.id.update_file_path_xp);
        this.mTvProgress = findViewById(R.id.update_progress_xp);
        this.mTvResult = findViewById(R.id.update_result_xp);
        this.mBtnSearch = findViewById(R.id.update_file_path_search_xp);
        this.mBtnSearch.setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                LauncherApplication.getInstance().activityByIntentName("com.syu.filemanager");
            }
        });
        this.mBtnStart = findViewById(R.id.start_update_xp);
        this.mBtnStart.setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                if (DataCanUp.mFileUpdatePath != null && !DataCanUp.mFileUpdatePath.equals("")) {
                    XpUpdateActi.this.dialog();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
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
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanUp.PROXY.cmd(0, null, null, new String[]{DataCanUp.mFileUpdatePath});
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
