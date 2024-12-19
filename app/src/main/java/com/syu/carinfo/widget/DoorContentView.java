package com.syu.carinfo.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.main.FinalShare;
import com.syu.ui.door.DoorHelper;
import java.lang.ref.WeakReference;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class DoorContentView extends View {
    private final Rect RECT_BACK;
    protected final Rect RECT_DRAWABLE;
    protected final Rect RECT_EMPTY;
    private final Rect RECT_ENGINE;
    private final Rect RECT_FL;
    private final Rect RECT_FR;
    private final Rect RECT_RL;
    private final Rect RECT_RR;
    protected WeakReference<Drawable> mBackDrawable;
    protected WeakReference<Content> mContent;
    protected WeakReference<Bitmap> mContentBitmap;
    protected WeakReference<Canvas> mContentCanvas;
    protected WeakReference<Drawable> mForeDrawable;
    protected int mHeight;
    protected int mId;
    protected int mId2;
    protected int mIdFocus;
    protected int mIdFocus2;
    protected Paint mPaint;
    protected int mWidth;

    public DoorContentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mBackDrawable = new WeakReference<>(null);
        this.mForeDrawable = new WeakReference<>(null);
        this.mContentBitmap = new WeakReference<>(null);
        this.mContentCanvas = new WeakReference<>(null);
        this.mContent = new WeakReference<>(null);
        this.mPaint = new Paint();
        this.RECT_DRAWABLE = new Rect(0, 0, 0, 0);
        this.RECT_EMPTY = new Rect(0, 0, 0, 0);
        this.mWidth = 275;
        this.mHeight = 374;
        this.mId = R.drawable.door1;
        this.mIdFocus = R.drawable.door1_p;
        this.mId2 = R.drawable.door2;
        this.mIdFocus2 = R.drawable.door2_p;
        this.RECT_ENGINE = new Rect(31, 6, 197, 58);
        this.RECT_FL = new Rect(7, 116, 79, 203);
        this.RECT_FR = new Rect(179, 114, 253, 202);
        this.RECT_RL = new Rect(9, 205, 77, 283);
        this.RECT_RR = new Rect(180, 202, 254, 279);
        this.RECT_BACK = new Rect(59, 260, 159, 307);
        init();
    }

    public DoorContentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mBackDrawable = new WeakReference<>(null);
        this.mForeDrawable = new WeakReference<>(null);
        this.mContentBitmap = new WeakReference<>(null);
        this.mContentCanvas = new WeakReference<>(null);
        this.mContent = new WeakReference<>(null);
        this.mPaint = new Paint();
        this.RECT_DRAWABLE = new Rect(0, 0, 0, 0);
        this.RECT_EMPTY = new Rect(0, 0, 0, 0);
        this.mWidth = 275;
        this.mHeight = 374;
        this.mId = R.drawable.door1;
        this.mIdFocus = R.drawable.door1_p;
        this.mId2 = R.drawable.door2;
        this.mIdFocus2 = R.drawable.door2_p;
        this.RECT_ENGINE = new Rect(31, 6, 197, 58);
        this.RECT_FL = new Rect(7, 116, 79, 203);
        this.RECT_FR = new Rect(179, 114, 253, 202);
        this.RECT_RL = new Rect(9, 205, 77, 283);
        this.RECT_RR = new Rect(180, 202, 254, 279);
        this.RECT_BACK = new Rect(59, 260, 159, 307);
        init();
    }

    public DoorContentView(Context context) {
        super(context);
        this.mBackDrawable = new WeakReference<>(null);
        this.mForeDrawable = new WeakReference<>(null);
        this.mContentBitmap = new WeakReference<>(null);
        this.mContentCanvas = new WeakReference<>(null);
        this.mContent = new WeakReference<>(null);
        this.mPaint = new Paint();
        this.RECT_DRAWABLE = new Rect(0, 0, 0, 0);
        this.RECT_EMPTY = new Rect(0, 0, 0, 0);
        this.mWidth = 275;
        this.mHeight = 374;
        this.mId = R.drawable.door1;
        this.mIdFocus = R.drawable.door1_p;
        this.mId2 = R.drawable.door2;
        this.mIdFocus2 = R.drawable.door2_p;
        this.RECT_ENGINE = new Rect(31, 6, 197, 58);
        this.RECT_FL = new Rect(7, 116, 79, 203);
        this.RECT_FR = new Rect(179, 114, 253, 202);
        this.RECT_RL = new Rect(9, 205, 77, 283);
        this.RECT_RR = new Rect(180, 202, 254, 279);
        this.RECT_BACK = new Rect(59, 260, 159, 307);
        init();
    }

    protected void init() {
        this.mPaint.setAntiAlias(true);
        this.mPaint.setFilterBitmap(true);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setTextSize(30.0f);
        this.mPaint.setColor(-1);
    }

    protected final Drawable getBackDrawable() {
        Drawable d = this.mBackDrawable.get();
        if (d == null) {
            if (FinalShare.CUSTOMER_ID == 63 || FinalShare.CUSTOMER_ID == 94) {
                d = getResources().getDrawable(this.mId2);
            } else {
                d = getResources().getDrawable(this.mId);
            }
            this.mBackDrawable = new WeakReference<>(d);
            this.RECT_DRAWABLE.set(0, 0, this.mWidth, this.mHeight);
            d.setBounds(this.RECT_DRAWABLE);
        }
        return d;
    }

    protected final Drawable getForeDrawable() {
        Drawable d = this.mForeDrawable.get();
        if (d == null) {
            if (FinalShare.CUSTOMER_ID == 63 || FinalShare.CUSTOMER_ID == 94) {
                d = getResources().getDrawable(this.mIdFocus2);
            } else {
                d = getResources().getDrawable(this.mIdFocus);
            }
            this.mForeDrawable = new WeakReference<>(d);
            d.setBounds(0, 0, this.mWidth, this.mHeight);
        }
        return d;
    }

    protected final Content getContent() {
        Content content = this.mContent.get();
        if (content == null) {
            content = new Content();
        }
        Canvas c = this.mContentCanvas.get();
        Bitmap b = this.mContentBitmap.get();
        if (b == null) {
            b = Bitmap.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.ARGB_8888);
            this.mContentBitmap = new WeakReference<>(b);
            c = new Canvas(b);
            this.mContentCanvas = new WeakReference<>(c);
        }
        if (c == null) {
            c = new Canvas(b);
            this.mContentCanvas = new WeakReference<>(c);
        }
        content.mBitmap = b;
        content.mCanvas = c;
        return content;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Content content = getContent();
        Canvas c = content.mCanvas;
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.save();
        c.clipRect(this.RECT_EMPTY);
        if (DoorHelper.sUcDoorEngine >= 0 && DataCanbus.DATA[DoorHelper.sUcDoorEngine] != 0) {
            c.clipRect(this.RECT_ENGINE, Region.Op.UNION);
        }
        if (DoorHelper.sUcDoorFl >= 0 && DataCanbus.DATA[DoorHelper.sUcDoorFl] != 0) {
            c.clipRect(this.RECT_FL, Region.Op.UNION);
        }
        if (DoorHelper.sUcDoorFr >= 0 && DataCanbus.DATA[DoorHelper.sUcDoorFr] != 0) {
            c.clipRect(this.RECT_FR, Region.Op.UNION);
        }
        if (DoorHelper.sUcDoorRl >= 0 && DataCanbus.DATA[DoorHelper.sUcDoorRl] != 0) {
            c.clipRect(this.RECT_RL, Region.Op.UNION);
        }
        if (DoorHelper.sUcDoorRr >= 0 && DataCanbus.DATA[DoorHelper.sUcDoorRr] != 0) {
            c.clipRect(this.RECT_RR, Region.Op.UNION);
        }
        if (DoorHelper.sUcDoorBack >= 0 && DataCanbus.DATA[DoorHelper.sUcDoorBack] != 0) {
            c.clipRect(this.RECT_BACK, Region.Op.UNION);
        }
        Drawable d = getForeDrawable();
        d.draw(c);
        Drawable d2 = getBackDrawable();
        c.clipRect(this.RECT_DRAWABLE, Region.Op.XOR);
        d2.draw(c);
        c.restore();
        canvas.drawBitmap(content.mBitmap, 0.0f, 0.0f, this.mPaint);
    }

    protected final class Content {
        protected Bitmap mBitmap;
        protected Canvas mCanvas;

        protected Content() {
        }
    }
}
