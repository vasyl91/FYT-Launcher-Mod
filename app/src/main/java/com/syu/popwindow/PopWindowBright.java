package com.syu.popwindow;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;

import com.android.launcher66.R;
import com.syu.car.CarStates;

public class PopWindowBright extends PopupWindow implements SeekBar.OnSeekBarChangeListener {
    private int mBrightLevel;
    private Context mContext;
    private SeekBar mSeekBar;
    private TextView mTextView;
    private View mView;
    private CountDownTimer timer = new CountDownTimer(5000, 1000) { 
        @Override
        public void onFinish() {
            PopWindowBright.this.dismiss();
        }

        @Override
        public void onTick(long arg0) {
        }
    };

    public PopWindowBright(Context context, int brightLevel) {
        this.mContext = context;
        this.mBrightLevel = brightLevel;
        initPopWindow();
    }

    private void initPopWindow() {
        this.mView = View.inflate(this.mContext, R.layout.popwindow_bright, null);
        setContentView(this.mView);
        setWidth(479);
        setHeight(80);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new BitmapDrawable());
        setTouchInterceptor(new View.OnTouchListener() { 
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() != 4) {
                    PopWindowBright.this.timer.start();
                    return false;
                }
                PopWindowBright.this.dismiss();
                return true;
            }
        });
        initView();
    }

    private void initView() {
        this.mSeekBar = (SeekBar) this.mView.findViewById(R.id.bright_seekbar);
        this.mSeekBar.setMax(100);
        this.mSeekBar.setOnSeekBarChangeListener(this);
        this.mTextView = (TextView) this.mView.findViewById(R.id.bright_text);
        this.mSeekBar.setProgress(this.mBrightLevel);
    }

    public void showPopupWindow(View view) {
        if (isShowing()) {
            dismiss();
        } else {
            showAtLocation(view, 17, 0, 0);
            this.timer.start();
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        this.mTextView.setText(new StringBuilder().append(progress).toString());
        CarStates.getCar(this.mContext).getTools().sendInt(0, 10, progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar arg0) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar arg0) {
    }
}
