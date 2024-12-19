package com.syu.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class InfoView extends View {
    private boolean mAddToWindow;
    private ArrayList<Chunk> mInfos;
    private Paint mPaint;

    public InfoView(Context context) {
        super(context);
        this.mInfos = new ArrayList<>(10);
        this.mAddToWindow = false;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
    }

    public void pushInfo(int index, String text, Paint.Align textAlign, int textSize, int textColor, int bgHeight, int bgColor) {
        HandlerUI.getInstance().post(new Chunk(this, index, text, textAlign, textSize, textColor, bgHeight, bgColor, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSelfToWindow() {
        if (!this.mAddToWindow) {
            ObjApp.getWindowManager().addView(this, ToolkitApp.buildOverlayLayoutParams(-1, -1));
            this.mAddToWindow = true;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int top = 0;
        Iterator<Chunk> it = this.mInfos.iterator();
        while (it.hasNext()) {
            Chunk chunk = it.next();
            canvas.save(2);
            int bottom = top + chunk.mBgHeight;
            canvas.clipRect(0, top, width, bottom);
            this.mPaint.setColor(chunk.mBgColor);
            canvas.drawColor(chunk.mBgColor);
            if (chunk.mTextSize > 0 && ((chunk.mTextColor >> 24) & 255) != 0) {
                Paint.Align align = chunk.mTextAlign;
                this.mPaint.setTextAlign(align);
                this.mPaint.setTextSize(chunk.mTextSize);
                this.mPaint.setColor(chunk.mTextColor);
                int y = (chunk.mBgHeight >> 1) + top + (chunk.mTextSize >> 2);
                if (align != Paint.Align.LEFT) {
                    if (align == Paint.Align.CENTER) {
                        canvas.drawText(chunk.mText, width >> 1, y, this.mPaint);
                    } else {
                        canvas.drawText(chunk.mText, width - 10, y, this.mPaint);
                    }
                } else {
                    canvas.drawText(chunk.mText, 10.0f, y, this.mPaint);
                }
            }
            canvas.restore();
            top = bottom;
        }
    }

    private class Chunk implements Runnable {
        private int mBgColor;
        private int mBgHeight;
        private int mIndex;
        private String mText;
        Paint.Align mTextAlign;
        private int mTextColor;
        private int mTextSize;

        /* synthetic */ Chunk(InfoView infoView, int i, String str, Paint.Align align, int i2, int i3, int i4, int i5, Chunk chunk) {
            this(i, str, align, i2, i3, i4, i5);
        }

        private Chunk(int index, String text, Paint.Align textAlign, int textSize, int textColor, int bgHeight, int bgColor) {
            this.mIndex = index;
            this.mText = text;
            this.mTextAlign = textAlign;
            this.mTextSize = textSize;
            this.mTextColor = textColor;
            this.mBgHeight = bgHeight;
            this.mBgColor = bgColor;
        }

        private boolean textEquals(String text) {
            return text.equals(this.mText);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mText != null && !this.mText.isEmpty()) {
                if (this.mIndex < 0) {
                    this.mIndex = 0;
                } else if (this.mIndex > InfoView.this.mInfos.size()) {
                    this.mIndex = InfoView.this.mInfos.size();
                }
                Iterator it = InfoView.this.mInfos.iterator();
                while (it.hasNext()) {
                    Chunk chunk = (Chunk) it.next();
                    if (chunk.textEquals(this.mText)) {
                        return;
                    }
                }
                if (this.mTextSize > this.mBgHeight) {
                    this.mTextSize = this.mBgHeight;
                }
                InfoView.this.mInfos.add(this.mIndex, this);
                InfoView.this.addSelfToWindow();
            }
        }
    }
}
