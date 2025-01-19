package com.android.launcher66;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import com.android.gallery3d.glrenderer.BasicTexture;
import com.android.gallery3d.glrenderer.BitmapTexture;
import com.android.photos.views.TiledImageRenderer;

public class DrawableTileSource implements TiledImageRenderer.TileSource {
    private static final int GL_SIZE_LIMIT = 2048;
    // This must be no larger than half the size of the GL_SIZE_LIMIT
    // due to decodePreview being allowed to be up to 2x the size of the target
    public static final int MAX_PREVIEW_SIZE = GL_SIZE_LIMIT / 2;

    private int mTileSize;
    private int mPreviewSize;
    private Drawable mDrawable;
    private BitmapTexture mPreview;

    public DrawableTileSource(Context context, Drawable d, int previewSize) {
        mTileSize = TiledImageRenderer.suggestedTileSize(context);
        mDrawable = d;
        mPreviewSize = Math.min(previewSize, MAX_PREVIEW_SIZE);
    }

    @Override
    public int getTileSize() {
        return mTileSize;
    }

    @Override
    public int getImageWidth() {
        return mDrawable.getIntrinsicWidth();
    }

    @Override
    public int getImageHeight() {
        return mDrawable.getIntrinsicHeight();
    }

    @Override
    public int getRotation() {
        return 0;
    }

    @Override
    public BasicTexture getPreview() {
        if (mPreviewSize == 0) {
            return null;
        }
        if (mPreview == null){
            float width = getImageWidth();
            float height = getImageHeight();
            while (width > MAX_PREVIEW_SIZE || height > MAX_PREVIEW_SIZE) {
                width /= 2;
                height /= 2;
            }
            Bitmap b = Bitmap.createBitmap((int) width, (int) height, Bitmap.Config.ARGB_8888);
            Canvas c = new Canvas(b);
            mDrawable.setBounds(new Rect(0, 0, (int) width, (int) height));
            mDrawable.draw(c);
            c.setBitmap(null);
            mPreview = new BitmapTexture(b);
        }
        return mPreview;
    }

    @Override
    public Bitmap getTile(int level, int x, int y, Bitmap bitmap) {
        int tileSize = getTileSize();
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(tileSize, tileSize, Bitmap.Config.ARGB_8888);
        }
        Canvas c = new Canvas(bitmap);
        Rect bounds = new Rect(0, 0, getImageWidth(), getImageHeight());
        bounds.offset(-x, -y);
        mDrawable.setBounds(bounds);
        mDrawable.draw(c);
        c.setBitmap(null);
        return bitmap;
    }
}
