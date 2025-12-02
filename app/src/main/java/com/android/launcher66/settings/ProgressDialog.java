package com.android.launcher66.settings;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;

public class ProgressDialog {
    private Dialog dialog;
    private ProgressBar progressBar;
    private TextView progressText;
    private Button cancelButton;
    private OnCancelListener cancelListener;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    public interface OnCancelListener {
        void onCancel();
    }

    public void show(@NonNull Context context, String fileName) {
        mainHandler.post(() -> {
            try {
                FragmentActivity activity = (FragmentActivity) context;
                if (activity.isFinishing() || activity.isDestroyed()) return;

                if (dialog == null) {
                    dialog = new Dialog(activity, androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
                    dialog.setContentView(R.layout.progress_dialog);
                    dialog.setCancelable(false);
                    
                    Window window = dialog.getWindow();
                    if (window != null) {
                        window.setLayout(
                            SettingsActivity.progressWidth,
                            SettingsActivity.progressHeight
                        );
                        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                        window.setDimAmount(0.5f);
                    }
                    TextView progressTitle = dialog.findViewById(R.id.progress_dialog_title);
                    progressTitle.setText(LauncherApplication.sApp.getString(R.string.progress_dialog_str, fileName));
                    progressBar = dialog.findViewById(R.id.progress_dialog_bar);
                    progressText = dialog.findViewById(R.id.progress_dialog_text);
                }

                cancelButton = dialog.findViewById(R.id.progress_dialog_cancel);
                cancelButton.setOnClickListener(v -> {
                    if (cancelListener != null) {
                        cancelListener.onCancel();
                    }
                    dismiss();
                });
                
                if (!dialog.isShowing() && !activity.isFinishing() && !activity.isDestroyed()) {
                    dialog.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void setOnCancelListener(OnCancelListener listener) {
        this.cancelListener = listener;
    }

    public void updateProgress(int progress) {
        mainHandler.post(() -> {
            if (dialog != null && dialog.isShowing()) {
                progressBar.setProgress(progress);
                progressText.setText(progress + "%");
                
                if (progress == 100) {
                    TextView message = dialog.findViewById(R.id.progress_dialog_message);
                    message.setText("Download complete!");
                }
            }
        });
    }

    public void dismiss() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            dismissInternal();
        } else {
            mainHandler.post(this::dismissInternal);
        }
    }

    private void dismissInternal() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            dialog = null;
        }
    }
}