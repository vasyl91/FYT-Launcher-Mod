package com.lsec.core.frame.ctrl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.lsec.core.util.FuncUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JIndicator extends View {
    boolean bAttached;
    boolean bWillSetIconName;
    boolean bWillUpdateBackground;
    private int current;
    Drawable drawable_focus;
    Drawable drawable_normal;
    private ViewGroup group;
    private int height;
    String[] iconNames;
    private Bitmap mBitmap;
    private Bitmap mBitmap_Focus;
    private Bitmap mBitmap_Normal;
    private Canvas mCanvas;
    public HashMap<String, Drawable> mDrawables;
    private int mHeight;
    private float mLastX;
    private float mLastY;
    String mStrDrawable;
    private int mWidth;
    private JPage page;
    private int space;
    private int total;
    private int width;
    private int xindex;
    private int yindex;

    public JIndicator(JPage page) {
        super(page.ui.mContext);
        this.bAttached = false;
        this.bWillUpdateBackground = false;
        this.bWillSetIconName = false;
        this.mBitmap = null;
        this.mBitmap_Normal = null;
        this.mBitmap_Focus = null;
        this.mCanvas = null;
        this.total = 3;
        this.current = 0;
        this.space = 5;
        this.xindex = 0;
        this.yindex = 0;
        this.mDrawables = new HashMap<>();
        this.page = page;
    }

    public void setIconName(String[] iconNames) {
        this.iconNames = iconNames;
        if (iconNames != null) {
            if (this.bAttached) {
                this.drawable_normal = this.page.getDrawableFromPath(iconNames[0], this.page.mDrawables, null);
                this.drawable_focus = this.page.getDrawableFromPath(iconNames[1], this.page.mDrawables, null);
            } else {
                this.bWillSetIconName = true;
            }
        }
    }

    public Bitmap getBitmapFromDrawable(Drawable drawable) {
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();
        return FuncUtils.getBitmapFromDrawable(drawable, w, h);
    }

    public void InitIndicator() {
        if (this.drawable_normal != null) {
            this.mBitmap_Normal = getBitmapFromDrawable(this.drawable_normal);
            this.mBitmap_Focus = getBitmapFromDrawable(this.drawable_focus);
            this.width = this.mBitmap_Normal.getWidth();
            this.height = this.mBitmap_Normal.getHeight();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (w > 0 && h > 0) {
            super.onSizeChanged(w, h, oldw, oldh);
            InitIndicator();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mBitmap == null) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.xindex = this.mWidth - (this.width * this.total);
            this.yindex = this.mHeight - this.height;
            if (this.xindex < 0 || this.yindex < 0) {
                throw new IllegalStateException("mWidth is not enough! mWidth must be more than " + (this.width * this.total) + "or mHeight is not enough! mHeight must be more than " + this.height);
            }
            this.xindex /= 2;
            this.yindex /= 2;
            this.mBitmap = Bitmap.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.ARGB_8888);
            this.mCanvas = new Canvas(this.mBitmap);
        }
        Drawing(canvas);
        super.onDraw(canvas);
    }

    protected void Drawing(Canvas canvas) {
        if (this.total > 0) {
            this.mCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            int left = this.xindex;
            int per = this.width + this.space;
            for (int index = 0; index < this.total; index++) {
                if (index == this.current) {
                    this.mCanvas.drawBitmap(this.mBitmap_Focus, left, this.yindex, (Paint) null);
                } else {
                    this.mCanvas.drawBitmap(this.mBitmap_Normal, left, this.yindex, (Paint) null);
                }
                left += per;
            }
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = (int) event.getX();
        float touchY = (int) event.getY();
        if (touchX < this.xindex || touchX > this.mWidth - this.xindex || touchY < 0.0f || touchY > this.mHeight) {
            return false;
        }
        int action = event.getAction();
        switch (action) {
            case 0:
                this.mLastX = touchX;
                this.mLastY = touchY;
                return true;
            case 1:
                if (isCilck(this.mLastX, this.mLastY, touchX, touchY, event.getDownTime(), event.getEventTime(), 500L)) {
                    onClick();
                }
                return true;
            case 2:
            default:
                return true;
        }
    }

    public void setTarget(ViewGroup pageView) {
        this.group = pageView;
    }

    public void setCurrent(int current) {
        this.current = current;
        invalidate();
    }

    public void setTotal(int count) {
        this.total = count;
        this.current = Math.min(Math.max(0, this.current), this.total);
        invalidate();
    }

    public boolean isCilck(float mlastX, float mlastY, float thisX, float thisY, long DownTime, long thiseventtime, long longPresstime) {
        float offsetx = Math.abs(mlastX - thisX);
        float offsety = Math.abs(mlastY - thisY);
        float validtime = thiseventtime - DownTime;
        return offsetx <= 10.0f && offsety <= 10.0f && validtime < ((float) longPresstime);
    }

    public void onClick() {
        Findindex(this.mLastX, this.mLastY);
        if (this.group instanceof JListApp) {
            ((JListApp) this.group).snapToScreen(this.current);
        }
    }

    public void Findindex(float x, float y) {
        for (int index = 0; index < this.total; index++) {
            Rect mRect = new Rect(this.xindex + ((this.width + this.space) * index), 0, this.xindex + ((this.width + this.space) * index) + this.width, this.mHeight);
            if (mRect.contains((int) x, (int) y)) {
                if (this.current != index) {
                    this.current = index;
                    return;
                }
                return;
            }
        }
    }

    public void setStrDrawable(String drawable, boolean bUpdateBk) {
        this.bWillUpdateBackground = true;
        this.mStrDrawable = drawable;
        if (bUpdateBk) {
            if (drawable == null) {
                setBackground(null);
            } else {
                updateBackground();
            }
        }
    }

    public void updateBackground() {
        if (!this.bAttached) {
            this.bWillUpdateBackground = true;
            return;
        }
        this.bWillUpdateBackground = false;
        if (this.page != null && this.mStrDrawable != null) {
            Drawable drawable = this.page.getDrawableFromPath(this.mStrDrawable, this.page.mDrawables, this.mDrawables);
            setBackground(drawable);
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.bAttached = true;
        if (this.bWillUpdateBackground) {
            this.bWillUpdateBackground = false;
            updateBackground();
        }
        if (this.bWillSetIconName) {
            this.bWillSetIconName = false;
            setIconName(this.iconNames);
        }
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.bAttached = false;
        super.onDetachedFromWindow();
    }
}
