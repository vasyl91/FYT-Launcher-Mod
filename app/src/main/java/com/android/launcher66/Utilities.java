package com.android.launcher66;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import androidx.core.internal.view.SupportMenu;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;
import com.fyt.skin.SkinUtils;
import com.syu.ipc.data.FinalCanbus;
import com.syu.util.Utils;
import java.util.ArrayList;

public final class Utilities {
    private static final String TAG = "Launcher.Utilities";
    private static int sIconSize = -1;
    private static int sIconWidth = -1;
    private static int sIconHeight = -1;
    public static int sIconTextureWidth = -1;
    public static int sIconTextureHeight = -1;
    public static int sIconCnt = 0;
    private static final Paint sBlurPaint = new Paint();
    private static final Paint sGlowColorPressedPaint = new Paint();
    private static final Paint sGlowColorFocusedPaint = new Paint();
    private static final Paint sDisabledPaint = new Paint();
    private static final Rect sOldBounds = new Rect();
    private static final Canvas sCanvas = new Canvas();

    static {
        sCanvas.setDrawFilter(new PaintFlagsDrawFilter(Paint.DITHER_FLAG,
                Paint.FILTER_BITMAP_FLAG));
    }
    static int sColors[] = { 0xffff0000, 0xff00ff00, 0xff0000ff };
    static int sColorIndex = 0;

    static Drawable createIconDrawable(Bitmap icon) {
        FastBitmapDrawable d = new FastBitmapDrawable(icon);
        d.setFilterBitmap(true);
        resizeIconDrawable(d);
        return d;
    }

    static void resizeIconDrawable(Drawable icon) {
        icon.setBounds(0, 0, sIconTextureWidth, sIconTextureHeight);
    }

    static void resizeHotseatIconDrawable(Drawable icon) {
        icon.setBounds(0, 0, icon.getIntrinsicWidth(), icon.getIntrinsicWidth());
    }

    static Bitmap createIconBitmap(Bitmap icon, Context context) {
        int textureWidth = sIconTextureWidth;
        int textureHeight = sIconTextureHeight;
        int sourceWidth = icon.getWidth();
        int sourceHeight = icon.getHeight();
        if (sourceWidth > textureWidth && sourceHeight > textureHeight) {
            return Bitmap.createBitmap(icon, (sourceWidth - textureWidth) / 2, (sourceHeight - textureHeight) / 2, textureWidth, textureHeight);
        }
        if (sourceWidth != textureWidth || sourceHeight != textureHeight) {
            Resources resources = context.getResources();
            return createIconBitmap(new BitmapDrawable(resources, icon), context);
        }
        return icon;
    }

    static Bitmap createIconBitmap(Drawable icon, Context context) {
        synchronized (sCanvas) { // we share the statics :-(
            if (sIconWidth == -1) {
                initStatics(context);
            }

            int width = sIconWidth;
            int height = sIconHeight;

            if (icon instanceof PaintDrawable) {
                PaintDrawable painter = (PaintDrawable) icon;
                painter.setIntrinsicWidth(width);
                painter.setIntrinsicHeight(height);
            } else if (icon instanceof BitmapDrawable) {
                // Ensure the bitmap has a density.
                BitmapDrawable bitmapDrawable = (BitmapDrawable) icon;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (bitmap.getDensity() == Bitmap.DENSITY_NONE) {
                    bitmapDrawable.setTargetDensity(context.getResources().getDisplayMetrics());
                }
            }
            int sourceWidth = icon.getIntrinsicWidth();
            int sourceHeight = icon.getIntrinsicHeight();
            if (sourceWidth > 0 && sourceHeight > 0) {
                // Scale the icon proportionally to the icon dimensions
                final float ratio = (float) sourceWidth / sourceHeight;
                if (sourceWidth > sourceHeight) {
                    height = (int) (width / ratio);
                } else if (sourceHeight > sourceWidth) {
                    width = (int) (height * ratio);
                }
            }

            // no intrinsic size --> use default size
            int textureWidth = sIconTextureWidth;
            int textureHeight = sIconTextureHeight;

            final Bitmap bitmap = Bitmap.createBitmap(textureWidth, textureHeight,
                    Bitmap.Config.ARGB_8888);
            final Canvas canvas = sCanvas;
            canvas.setBitmap(bitmap);

            final int left = (textureWidth-width) / 2;
            final int top = (textureHeight-height) / 2;

            @SuppressWarnings("all") // suppress dead code warning
            final boolean debug = false;
            if (debug) {
                // draw a big box for the icon for debugging
                canvas.drawColor(sColors[sColorIndex]);
                if (++sColorIndex >= sColors.length) sColorIndex = 0;
                Paint debugPaint = new Paint();
                debugPaint.setColor(Color.parseColor("#FFFF00"));
                canvas.drawRect(left, top, left+width, top+height, debugPaint);
            }

            sOldBounds.set(icon.getBounds());
            icon.setBounds(left, top, left+width, top+height);
            icon.draw(canvas);
            icon.setBounds(sOldBounds);
            canvas.setBitmap(null);

            return bitmap;
        }
    }

    public static Bitmap createIconBitmap_enlarge(Drawable icon) {
        synchronized (sCanvas) {
            if (sIconWidth == -1) {
                initStatics(Utils.getCtx());
            }
            int width = sIconWidth;
            int height = sIconHeight;
            if (icon instanceof PaintDrawable) {
                PaintDrawable painter = (PaintDrawable) icon;
                painter.setIntrinsicWidth(width);
                painter.setIntrinsicHeight(height);
            } else if (icon instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) icon;
                if (bitmapDrawable.getBitmap().getDensity() == 0) {
                    bitmapDrawable.setTargetDensity(Utils.getCtx().getResources().getDisplayMetrics());
                }
            }
            int sourceWidth = icon.getIntrinsicWidth();
            icon.getIntrinsicHeight();
            if (sourceWidth > 0) {
            }
            int textureWidth = sIconTextureWidth;
            int textureHeight = sIconTextureHeight;
            final Bitmap bitmap = Bitmap.createBitmap(textureWidth, textureHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = sCanvas;
            canvas.setBitmap(bitmap);
            int left = (textureWidth - width) / 2;
            int top = (textureHeight - height) / 2;
            Drawable micon = SkinUtils.getDrawable(R.drawable.icon_bg);
            micon.getIntrinsicWidth();
            micon.getIntrinsicHeight();
            micon.draw(canvas);
            micon.setBounds(sOldBounds);
            sOldBounds.set(icon.getBounds());
            icon.setBounds(left + 0, top + 0, left + width, top + height);
            icon.draw(canvas);
            icon.setBounds(sOldBounds);

            return bitmap;
        }
    }

    public static Bitmap createIconBitmap_minify(Drawable icon) {
        synchronized (sCanvas) {
            if (sIconWidth == -1) {
                initStatics(Utils.getCtx());
            }
            int width = sIconWidth;
            int height = sIconHeight;
            if (icon instanceof PaintDrawable) {
                PaintDrawable painter = (PaintDrawable) icon;
                painter.setIntrinsicWidth(width);
                painter.setIntrinsicHeight(height);
            } else if (icon instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) icon;
                if (bitmapDrawable.getBitmap().getDensity() == 0) {
                    bitmapDrawable.setTargetDensity(SkinUtils.getResources().getDisplayMetrics());
                }
            }
            int sourceWidth = icon.getIntrinsicWidth();
            int sourceHeight = icon.getIntrinsicHeight();
            if (sourceWidth > 0 && sourceHeight > 0) {
                float ratio = sourceWidth / sourceHeight;
                if (sourceWidth > sourceHeight) {
                    height = (int) (width / ratio);
                } else if (sourceHeight > sourceWidth) {
                    width = (int) (height * ratio);
                }
            }
            int textureWidth = sIconTextureWidth;
            int textureHeight = sIconTextureHeight;
            final Bitmap bitmap = Bitmap.createBitmap(textureWidth, textureHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = sCanvas;
            canvas.setBitmap(bitmap);
            int i = (textureWidth - width) / 2;
            int i2 = (textureHeight - height) / 2;
            double scale_w = width / sIconSize;
            double scale_h = height / sIconSize;
            int width2 = (int) (width / scale_w);
            int height2 = (int) (height / scale_h);
            int left = (textureWidth - width2) / 2;
            int top = ((textureHeight - height2) / 2) - 2;
            Drawable micon = SkinUtils.getDrawable(R.drawable.icon_bg + sIconCnt);
            if (LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_thrid_icon)) {
                sIconCnt++;
                if (sIconCnt >= LauncherApplication.sApp.getResources().getInteger(R.integer.utility_minfiy_icon_count)) {
                    sIconCnt = 0;
                }
            }
            int mwidth = micon.getIntrinsicWidth();
            int mheight = micon.getIntrinsicHeight();
            micon.setBounds((textureWidth - mwidth) / 2, (textureHeight - mheight) / 2, ((textureWidth - mwidth) / 2) + mwidth, ((textureHeight - mheight) / 2) + mheight);
            micon.draw(canvas);
            micon.setBounds(sOldBounds);
            int gap = LauncherApplication.sApp.getResources().getInteger(R.integer.utility_minfiy_gap);
            int offest = LauncherApplication.sApp.getResources().getInteger(R.integer.utility_minfiy_top_offest);
            int LeftOffest = LauncherApplication.sApp.getResources().getInteger(R.integer.utility_minfiy_left_offest);
            sOldBounds.set(icon.getBounds());
            icon.setBounds((left + gap) - LeftOffest, (top + gap) - offest, ((left + width2) - gap) - LeftOffest, ((top + height2) - gap) - offest);
            icon.draw(canvas);
            icon.setBounds(sOldBounds);

            return bitmap;
        }
    }

    static Bitmap resampleIconBitmap(Bitmap bitmap, Context context) {
        synchronized (sCanvas) {
            if (sIconWidth == -1) {
                initStatics(context);
            }
            if (bitmap.getWidth() != sIconWidth || bitmap.getHeight() != sIconHeight) {
                Resources resources = context.getResources();
                bitmap = createIconBitmap(new BitmapDrawable(resources, bitmap), context);
            }
        }
        return bitmap;
    }

    public static float getDescendantCoordRelativeToParent(View descendant, View root, int[] coord, boolean includeRootScroll) {
        ArrayList<View> ancestorChain = new ArrayList<>();
        float[] pt = {coord[0], coord[1]};
        for (View v = descendant; v != root && v != null; v = (View) v.getParent()) {
            ancestorChain.add(v);
        }
        ancestorChain.add(root);
        float scale = 1.0f;
        int count = ancestorChain.size();
        for (int i = 0; i < count; i++) {
            View v0 = ancestorChain.get(i);
            if (v0 != descendant || includeRootScroll) {
                pt[0] = pt[0] - v0.getScrollX();
                pt[1] = pt[1] - v0.getScrollY();
            }
            v0.getMatrix().mapPoints(pt);
            pt[0] = pt[0] + v0.getLeft();
            pt[1] = pt[1] + v0.getTop();
            scale *= v0.getScaleX();
        }
        coord[0] = Math.round(pt[0]);
        coord[1] = Math.round(pt[1]);
        return scale;
    }

    public static float mapCoordInSelfToDescendent(View descendant, View root, int[] coord) {
        ArrayList<View> ancestorChain = new ArrayList<>();
        float[] pt = {coord[0], coord[1]};
        for (View v = descendant; v != root; v = (View) v.getParent()) {
            ancestorChain.add(v);
        }
        ancestorChain.add(root);
        float scale = 1.0f;
        Matrix inverse = new Matrix();
        int count = ancestorChain.size();
        int i = count - 1;
        while (i >= 0) {
            View ancestor = ancestorChain.get(i);
            View next = i > 0 ? ancestorChain.get(i - 1) : null;
            pt[0] = pt[0] + ancestor.getScrollX();
            pt[1] = pt[1] + ancestor.getScrollY();
            if (next != null) {
                pt[0] = pt[0] - next.getLeft();
                pt[1] = pt[1] - next.getTop();
                next.getMatrix().invert(inverse);
                inverse.mapPoints(pt);
                scale *= next.getScaleX();
            }
            i--;
        }
        coord[0] = Math.round(pt[0]);
        coord[1] = Math.round(pt[1]);
        return scale;
    }

    private static void initStatics(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float density = metrics.density;
        sIconSize = (int) resources.getDimension(R.dimen.icon_size);
        sIconWidth = (int) resources.getDimension(R.dimen.app_icon_size);
        sIconHeight = sIconWidth - LauncherApplication.sApp.getResources().getInteger(R.integer.utility_icon_height);
        sIconTextureWidth = sIconWidth;
        sIconTextureHeight = sIconHeight;
        sBlurPaint.setMaskFilter(new BlurMaskFilter(5.0f * density, BlurMaskFilter.Blur.NORMAL));
        sGlowColorPressedPaint.setColor(Color.parseColor("#003D00"));
        sGlowColorFocusedPaint.setColor(Color.parseColor("#007200"));
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0.2f);
        sDisabledPaint.setColorFilter(new ColorMatrixColorFilter(cm));
        sDisabledPaint.setAlpha(FinalCanbus.CAR_WC1_MZD_CX7);
    }

    public static void setIconSize(int widthPx) {
        sIconWidth = widthPx;
        sIconHeight = sIconWidth - LauncherApplication.sApp.getResources().getInteger(R.integer.utility_icon_height);
        sIconTextureWidth = sIconWidth;
        sIconTextureHeight = sIconHeight;
    }

    public static void scaleRect(Rect r, float scale) {
        if (scale != 1.0f) {
            r.left = (int) ((r.left * scale) + 0.5f);
            r.top = (int) ((r.top * scale) + 0.5f);
            r.right = (int) ((r.right * scale) + 0.5f);
            r.bottom = (int) ((r.bottom * scale) + 0.5f);
        }
    }

    public static void scaleRectAboutCenter(Rect r, float scale) {
        int cx = r.centerX();
        int cy = r.centerY();
        r.offset(-cx, -cy);
        scaleRect(r, scale);
        r.offset(cx, cy);
    }

    public static void startActivityForResultSafely(Activity activity, Intent intent, int requestCode) {
        try {
            activity.startActivityForResult(intent, requestCode);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(activity, R.string.activity_not_found, Toast.LENGTH_SHORT).show();
        } catch (SecurityException e2) {
            Toast.makeText(activity, R.string.activity_not_found, Toast.LENGTH_SHORT).show();
            Log.e(TAG, "Launcher does not have the permission to launch " + intent + ". Make sure to create a MAIN intent-filter for the corresponding activity or use the exported attribute for this activity.", e2);
        }
    }    

    /*
     * Finds a system apk which had a broadcast receiver listening to a particular action.
     * @param action intent action used to find the apk
     * @return a pair of apk package name and the resources.
     */
    static Pair<String, Resources> findSystemApk(String action, PackageManager pm) {
        final Intent intent = new Intent(action);
        for (ResolveInfo info : pm.queryBroadcastReceivers(intent, 0)) {
            if (info.activityInfo != null &&
                    (info.activityInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
                final String packageName = info.activityInfo.packageName;
                try {
                    final Resources res = pm.getResourcesForApplication(packageName);
                    return Pair.create(packageName, res);
                } catch (PackageManager.NameNotFoundException e) {
                    Log.w(TAG, "Failed to find resources for " + packageName);
                }
            }
        }
        return null;
    }
}
