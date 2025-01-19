package com.syu.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.WindowManager;

import java.util.Locale;

public class DebugView extends View {
    private final int CELL_HEIGHT;
    int[] COLOR;
    private final int MAX;
    private final int TEXT_SIZE;
    private final int[] mColors;
    private int mCount;
    private boolean mDbg;
    private int mLastIndex;
    private final WindowManager.LayoutParams mLp;
    private int mMsgCnt;
    private final String[] mMsgs;
    private final Paint mPaint;

    public DebugView(Context context) {
        super(context);
        this.mDbg = false;
        this.mLp = ToolkitApp.buildOverlayLayoutParams(-1, -1);
        this.MAX = 16;
        this.CELL_HEIGHT = 35;
        this.TEXT_SIZE = 23;
        this.mMsgs = new String[16];
        this.mColors = new int[16];
        this.mPaint = new Paint();
        this.COLOR = new int[]{-65536, -1, -16711936, -256, -16776961};
        init();
    }

    private void init() {
        this.mPaint.setAntiAlias(true);
        this.mPaint.setTextSize(23.0f);
        this.mPaint.setColor(-1);
    }

    public void setDbg(boolean flag) {
        this.mDbg = flag;
    }

    public boolean isDbg() {
        return this.mDbg;
    }

    public WindowManager.LayoutParams getWindowLayoutParams() {
        return this.mLp;
    }

    public void msg(String msg) {
        if (this.mDbg && msg != null) {
            HandlerUI.getInstance().post(new MessageHelper(msg));
        }
    }

    public void msg2(String msg) {
        if (this.mDbg && msg != null) {
            HandlerUI.getInstance().post(new MessageHelper(msg));
        }
    }

    public void msgHex(String str, byte[] data, int start, int length) {
        if (this.mDbg && data != null) {
            if (data.length - start < length) {
                length = data.length - start;
            }
            String msg = str + " * ";
            for (int i = 0; i < length; i++) {
                String c = Integer.toHexString(data[start + i] & 255).toUpperCase(Locale.CHINA);
                if (c.length() < 2) {
                    c = "0" + c;
                }
                msg = msg + c + " ";
            }
            HandlerUI.getInstance().post(new MessageHelper(msg));
        }
    }

    public void msgHex(String str, int[] data, int start, int length) {
        if (this.mDbg && data != null) {
            if (data.length - start < length) {
                length = data.length - start;
            }
            String msg = str + " * ";
            for (int i = 0; i < length; i++) {
                String c = Integer.toHexString(data[start + i] & 255).toUpperCase(Locale.CHINA);
                if (c.length() < 2) {
                    c = "0" + c;
                }
                msg = msg + c + " ";
            }
            HandlerUI.getInstance().post(new MessageHelper(msg));
        }
    }

    private class MessageHelper implements Runnable {
        private final String mMessage;

        public MessageHelper(String msg) {
            this.mMessage = msg;
        }

        @Override
        public void run() {
            DebugView.this.mLastIndex++;
            DebugView.this.mCount++;
            if (DebugView.this.mLastIndex > 15) {
                DebugView.this.mLastIndex = 0;
            }
            if (DebugView.this.mCount > 16) {
                DebugView.this.mCount = 16;
            }
            DebugView.this.mMsgCnt++;
            DebugView.this.mMsgs[DebugView.this.mLastIndex] = String.format("%06d @ %s", Integer.valueOf(DebugView.this.mMsgCnt), this.mMessage);
            DebugView.this.mColors[DebugView.this.mLastIndex] = DebugView.this.COLOR[DebugView.this.mLastIndex % DebugView.this.COLOR.length];
            DebugView.this.invalidate();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (this.mCount != 0) {
            int count = this.mCount;
            int firstIndex = (this.mLastIndex - count) + 1;
            if (firstIndex < 0) {
                firstIndex += 16;
            }
            if (firstIndex + count > 16) {
                int rightCount = 16 - firstIndex;
                int leftCount = count - rightCount;
                for (int i = 0; i < rightCount; i++) {
                    int index = firstIndex + i;
                    this.mPaint.setColor(this.mColors[index]);
                    canvas.drawText(this.mMsgs[index], 5, (i + 1) * this.CELL_HEIGHT, this.mPaint);
                }
                for (int i2 = 0; i2 < leftCount; i2++) {
                    this.mPaint.setColor(this.mColors[i2]);
                    canvas.drawText(this.mMsgs[i2], 5, (rightCount + i2 + 1) * this.CELL_HEIGHT, this.mPaint);
                }
                return;
            }
            for (int i3 = 0; i3 < count; i3++) {
                int index2 = firstIndex + i3;
                this.mPaint.setColor(this.mColors[index2]);
                canvas.drawText(this.mMsgs[index2], 5, (i3 + 1) * this.CELL_HEIGHT, this.mPaint);
            }
        }
    }
}
