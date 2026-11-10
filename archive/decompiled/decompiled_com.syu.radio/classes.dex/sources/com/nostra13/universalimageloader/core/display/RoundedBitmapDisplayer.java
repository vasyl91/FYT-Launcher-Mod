package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.nostra13.universalimageloader.utils.L;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class RoundedBitmapDisplayer implements BitmapDisplayer {
    private final int roundPixels;

    public RoundedBitmapDisplayer(int roundPixels) {
        this.roundPixels = roundPixels;
    }

    @Override // com.nostra13.universalimageloader.core.display.BitmapDisplayer
    public Bitmap display(Bitmap bitmap, ImageAware imageAware, LoadedFrom loadedFrom) {
        if (!(imageAware instanceof ImageViewAware)) {
            throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
        }
        Bitmap roundedBitmap = roundCorners(bitmap, (ImageViewAware) imageAware, this.roundPixels);
        imageAware.setImageBitmap(roundedBitmap);
        return roundedBitmap;
    }

    public static Bitmap roundCorners(Bitmap bitmap, ImageViewAware imageAware, int roundPixels) {
        int width;
        int height;
        Rect srcRect;
        Rect destRect;
        int srcWidth;
        int srcHeight;
        int x;
        int y;
        int destWidth;
        int destHeight;
        Bitmap roundBitmap;
        ImageView imageView = imageAware.getWrappedView();
        if (imageView == null) {
            L.w("View is collected probably. Can't round bitmap corners without view properties.", new Object[0]);
            return bitmap;
        }
        int bw = bitmap.getWidth();
        int bh = bitmap.getHeight();
        int vw = imageAware.getWidth();
        int vh = imageAware.getHeight();
        if (vw <= 0) {
            vw = bw;
        }
        if (vh <= 0) {
            vh = bh;
        }
        ImageView.ScaleType scaleType = imageView.getScaleType();
        if (scaleType != null) {
            switch (AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType[scaleType.ordinal()]) {
                case 1:
                    float vRation = vw / vh;
                    float bRation = bw / bh;
                    if (vRation > bRation) {
                        destHeight = Math.min(vh, bh);
                        destWidth = (int) (bw / (bh / destHeight));
                    } else {
                        destWidth = Math.min(vw, bw);
                        destHeight = (int) (bh / (bw / destWidth));
                    }
                    int x2 = (vw - destWidth) / 2;
                    int y2 = (vh - destHeight) / 2;
                    srcRect = new Rect(0, 0, bw, bh);
                    destRect = new Rect(x2, y2, x2 + destWidth, y2 + destHeight);
                    width = vw;
                    height = vh;
                    break;
                case 2:
                case 3:
                case 4:
                default:
                    float vRation2 = vw / vh;
                    float bRation2 = bw / bh;
                    if (vRation2 > bRation2) {
                        width = (int) (bw / (bh / vh));
                        height = vh;
                    } else {
                        width = vw;
                        height = (int) (bh / (bw / vw));
                    }
                    srcRect = new Rect(0, 0, bw, bh);
                    destRect = new Rect(0, 0, width, height);
                    break;
                case 5:
                    float vRation3 = vw / vh;
                    float bRation3 = bw / bh;
                    if (vRation3 > bRation3) {
                        srcWidth = bw;
                        srcHeight = (int) (vh * (bw / vw));
                        x = 0;
                        y = (bh - srcHeight) / 2;
                    } else {
                        srcWidth = (int) (vw * (bh / vh));
                        srcHeight = bh;
                        x = (bw - srcWidth) / 2;
                        y = 0;
                    }
                    width = srcWidth;
                    height = srcHeight;
                    srcRect = new Rect(x, y, x + srcWidth, y + srcHeight);
                    destRect = new Rect(0, 0, width, height);
                    break;
                case 6:
                    width = vw;
                    height = vh;
                    srcRect = new Rect(0, 0, bw, bh);
                    destRect = new Rect(0, 0, width, height);
                    break;
                case 7:
                case 8:
                    width = Math.min(vw, bw);
                    height = Math.min(vh, bh);
                    int x3 = (bw - width) / 2;
                    int y3 = (bh - height) / 2;
                    srcRect = new Rect(x3, y3, x3 + width, y3 + height);
                    destRect = new Rect(0, 0, width, height);
                    break;
            }
            try {
                roundBitmap = getRoundedCornerBitmap(bitmap, roundPixels, srcRect, destRect, width, height);
            } catch (OutOfMemoryError e) {
                L.e(e, "Can't create bitmap with rounded corners. Not enough memory.", new Object[0]);
                roundBitmap = bitmap;
            }
            return roundBitmap;
        }
        return bitmap;
    }

    /* JADX INFO: renamed from: com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType = new int[ImageView.ScaleType.values().length];

        static {
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_CROP.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    private static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int roundPixels, Rect srcRect, Rect destRect, int width, int height) {
        Bitmap output = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        RectF destRectF = new RectF(destRect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawRoundRect(destRectF, roundPixels, roundPixels, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, srcRect, destRectF, paint);
        return output;
    }
}
