package com.lsec.core.frame.ninepatch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class NinePatchChunk implements Externalizable {
    public static final int DEFAULT_DENSITY = 160;
    public static final int NO_COLOR = 1;
    public static final int TRANSPARENT_COLOR = 0;
    public int[] colors;
    public ArrayList<Div> xDivs;
    public ArrayList<Div> yDivs;
    public boolean wasSerialized = true;
    public Rect padding = new Rect();

    public static NinePatchChunk parse(byte[] data) throws RuntimeException {
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.nativeOrder());
        NinePatchChunk chunk = new NinePatchChunk();
        chunk.wasSerialized = byteBuffer.get() != 0;
        if (!chunk.wasSerialized) {
            throw new RuntimeException();
        }
        byte divXCount = byteBuffer.get();
        checkDivCount(divXCount);
        byte divYCount = byteBuffer.get();
        checkDivCount(divYCount);
        chunk.colors = new int[byteBuffer.get()];
        byteBuffer.getInt();
        byteBuffer.getInt();
        chunk.padding.left = byteBuffer.getInt();
        chunk.padding.right = byteBuffer.getInt();
        chunk.padding.top = byteBuffer.getInt();
        chunk.padding.bottom = byteBuffer.getInt();
        byteBuffer.getInt();
        int xDivs = divXCount >> 1;
        chunk.xDivs = new ArrayList<>(xDivs);
        readDivs(xDivs, byteBuffer, chunk.xDivs);
        int yDivs = divYCount >> 1;
        chunk.yDivs = new ArrayList<>(yDivs);
        readDivs(yDivs, byteBuffer, chunk.yDivs);
        for (int i = 0; i < chunk.colors.length; i++) {
            chunk.colors[i] = byteBuffer.getInt();
        }
        return chunk;
    }

    public static NinePatchDrawable create9PatchDrawable(Context context, Bitmap bitmap, String srcName) {
        return BitmapType.getNinePatchDrawable(context.getResources(), bitmap, srcName);
    }

    public static NinePatchDrawable create9PatchDrawable(Context context, InputStream inputStream, String srcName) {
        return create9PatchDrawable(context, inputStream, 160, srcName);
    }

    public static NinePatchDrawable create9PatchDrawable(Context context, ByteArrayOutputStream byteArrayOutputStream, String srcName) {
        return create9PatchDrawable(context, byteArrayOutputStream, 160, srcName);
    }

    public static NinePatchDrawable create9PatchDrawable(Context context, InputStream inputStream, int imageDensity, String srcName) {
        ImageLoadingResult loadingResult = createChunkFromRawBitmap(context, inputStream, imageDensity);
        return loadingResult.getNinePatchDrawable(context.getResources(), srcName);
    }

    public static NinePatchDrawable create9PatchDrawable(Context context, ByteArrayOutputStream byteArrayOutputStream, int imageDensity, String srcName) {
        ImageLoadingResult loadingResult = createChunkFromRawBitmap(context, byteArrayOutputStream, imageDensity);
        return loadingResult.getNinePatchDrawable(context.getResources(), srcName);
    }

    public static NinePatchChunk createChunkFromRawBitmap(Bitmap bitmap) {
        try {
            return createChunkFromRawBitmap(bitmap, true);
        } catch (RuntimeException e) {
            return createEmptyChunk();
        }
    }

    public static ImageLoadingResult createChunkFromRawBitmap(Context context, InputStream inputStream) {
        return createChunkFromRawBitmap(context, inputStream, 160);
    }

    public static ImageLoadingResult createChunkFromRawBitmap(Context context, InputStream inputStream, int imageDensity) {
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inDensity = imageDensity;
        opts.inTargetDensity = imageDensity;
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream, new Rect(), opts);
        return createChunkFromRawBitmap(context, bitmap);
    }

    public static ImageLoadingResult createChunkFromRawBitmap(Context context, ByteArrayOutputStream byteArrayOutputStream, int imageDensity) {
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inDensity = imageDensity;
        opts.inTargetDensity = imageDensity;
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size(), opts);
        return createChunkFromRawBitmap(context, bitmap);
    }

    public static ImageLoadingResult createChunkFromRawBitmap(Context context, Bitmap bitmap) {
        BitmapType type = BitmapType.determineBitmapType(bitmap);
        NinePatchChunk chunk = type.createChunk(bitmap);
        return new ImageLoadingResult(type.modifyBitmap(context.getResources(), bitmap, chunk), chunk);
    }

    public static NinePatchChunk createEmptyChunk() {
        NinePatchChunk out = new NinePatchChunk();
        out.colors = new int[0];
        out.padding = new Rect();
        out.yDivs = new ArrayList<>();
        out.xDivs = new ArrayList<>();
        return out;
    }

    public byte[] toBytes() {
        int capacity = (this.xDivs.size() * 2 * 4) + 32 + (this.yDivs.size() * 2 * 4) + (this.colors.length * 4);
        ByteBuffer byteBuffer = ByteBuffer.allocate(capacity).order(ByteOrder.nativeOrder());
        Integer num = 1;
        byteBuffer.put(num.byteValue());
        byteBuffer.put(Integer.valueOf(this.xDivs.size() * 2).byteValue());
        byteBuffer.put(Integer.valueOf(this.yDivs.size() * 2).byteValue());
        byteBuffer.put(Integer.valueOf(this.colors.length).byteValue());
        byteBuffer.putInt(0);
        byteBuffer.putInt(0);
        if (this.padding == null) {
            this.padding = new Rect();
        }
        byteBuffer.putInt(this.padding.left);
        byteBuffer.putInt(this.padding.right);
        byteBuffer.putInt(this.padding.top);
        byteBuffer.putInt(this.padding.bottom);
        byteBuffer.putInt(0);
        for (Div div : this.xDivs) {
            byteBuffer.putInt(div.start);
            byteBuffer.putInt(div.stop);
        }
        for (Div div2 : this.yDivs) {
            byteBuffer.putInt(div2.start);
            byteBuffer.putInt(div2.stop);
        }
        for (int color : this.colors) {
            byteBuffer.putInt(color);
        }
        return byteBuffer.array();
    }

    public static void createColorsArrayAndSet(NinePatchChunk chunk, int bitmapWidth, int bitmapHeight) {
        int[] colorsArray = createColorsArray(chunk, bitmapWidth, bitmapHeight);
        if (chunk != null) {
            chunk.colors = colorsArray;
        }
    }

    public static int[] createColorsArray(NinePatchChunk chunk, int bitmapWidth, int bitmapHeight) {
        if (chunk == null) {
            return new int[0];
        }
        ArrayList<Div> xRegions = getRegions(chunk.xDivs, bitmapWidth);
        ArrayList<Div> yRegions = getRegions(chunk.yDivs, bitmapHeight);
        int[] out = new int[xRegions.size() * yRegions.size()];
        Arrays.fill(out, 1);
        return out;
    }

    public static boolean isRawNinePatchBitmap(Bitmap bitmap) {
        return bitmap != null && bitmap.getWidth() >= 3 && bitmap.getHeight() >= 3 && isCornerPixelsAreTrasperent(bitmap) && hasNinePatchBorder(bitmap);
    }

    private static boolean hasNinePatchBorder(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int lastXPixel = width - 1;
        int lastYPixel = height - 1;
        for (int i = 1; i < lastXPixel; i++) {
            if (!isBorderPixel(bitmap.getPixel(i, 0)) || !isBorderPixel(bitmap.getPixel(i, lastYPixel))) {
                return false;
            }
        }
        for (int i2 = 1; i2 < lastYPixel; i2++) {
            if (!isBorderPixel(bitmap.getPixel(0, i2)) || !isBorderPixel(bitmap.getPixel(lastXPixel, i2))) {
                return false;
            }
        }
        return getXDivs(bitmap, 0).size() != 0 && getXDivs(bitmap, lastYPixel).size() <= 1 && getYDivs(bitmap, 0).size() != 0 && getYDivs(bitmap, lastXPixel).size() <= 1;
    }

    private static boolean isBorderPixel(int tmpPixel1) {
        return isTransparent(tmpPixel1) || isBlack(tmpPixel1);
    }

    private static boolean isCornerPixelsAreTrasperent(Bitmap bitmap) {
        int lastYPixel = bitmap.getHeight() - 1;
        int lastXPixel = bitmap.getWidth() - 1;
        return isTransparent(bitmap.getPixel(0, 0)) && isTransparent(bitmap.getPixel(0, lastYPixel)) && isTransparent(bitmap.getPixel(lastXPixel, 0)) && isTransparent(bitmap.getPixel(lastXPixel, lastYPixel));
    }

    private static boolean isTransparent(int color) {
        return Color.alpha(color) == 0;
    }

    private static boolean isBlack(int pixel) {
        return pixel == -16777216;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput input) throws IOException, ClassNotFoundException {
        int length = input.readInt();
        byte[] bytes = new byte[length];
        input.read(bytes);
        try {
            NinePatchChunk patch = parse(bytes);
            this.wasSerialized = patch.wasSerialized;
            this.xDivs = patch.xDivs;
            this.yDivs = patch.yDivs;
            this.padding = patch.padding;
            this.colors = patch.colors;
        } catch (RuntimeException e) {
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput output) throws IOException {
        byte[] bytes = toBytes();
        output.writeInt(bytes.length);
        output.write(bytes);
    }

    protected static NinePatchChunk createChunkFromRawBitmap(Bitmap bitmap, boolean checkBitmap) throws RuntimeException {
        if (checkBitmap && !isRawNinePatchBitmap(bitmap)) {
            return createEmptyChunk();
        }
        NinePatchChunk out = new NinePatchChunk();
        setupStretchableRegions(bitmap, out);
        setupPadding(bitmap, out);
        setupColors(bitmap, out);
        return out;
    }

    private static void readDivs(int divs, ByteBuffer byteBuffer, ArrayList<Div> divArrayList) {
        for (int i = 0; i < divs; i++) {
            Div div = new Div();
            div.start = byteBuffer.getInt();
            div.stop = byteBuffer.getInt();
            divArrayList.add(div);
        }
    }

    private static void checkDivCount(byte divCount) throws RuntimeException {
        if (divCount == 0 || (divCount & 1) != 0) {
            throw new RuntimeException("Div count should be aliquot 2 and more then 0, but was: " + ((int) divCount));
        }
    }

    private static void setupColors(Bitmap bitmap, NinePatchChunk out) {
        int bitmapWidth = bitmap.getWidth() - 2;
        int bitmapHeight = bitmap.getHeight() - 2;
        ArrayList<Div> xRegions = getRegions(out.xDivs, bitmapWidth);
        ArrayList<Div> yRegions = getRegions(out.yDivs, bitmapHeight);
        out.colors = new int[xRegions.size() * yRegions.size()];
        int colorIndex = 0;
        for (Div yDiv : yRegions) {
            for (Div xDiv : xRegions) {
                int startX = xDiv.start + 1;
                int startY = yDiv.start + 1;
                if (hasSameColor(bitmap, startX, xDiv.stop + 1, startY, yDiv.stop + 1)) {
                    int pixel = bitmap.getPixel(startX, startY);
                    if (isTransparent(pixel)) {
                        pixel = 0;
                    }
                    out.colors[colorIndex] = pixel;
                } else {
                    out.colors[colorIndex] = 1;
                }
                colorIndex++;
            }
        }
    }

    private static boolean hasSameColor(Bitmap bitmap, int startX, int stopX, int startY, int stopY) {
        int color = bitmap.getPixel(startX, startY);
        for (int x = startX; x <= stopX; x++) {
            for (int y = startY; y <= stopY; y++) {
                if (color != bitmap.getPixel(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void setupPadding(Bitmap bitmap, NinePatchChunk out) throws RuntimeException {
        int maxXPixels = bitmap.getWidth() - 2;
        int maxYPixels = bitmap.getHeight() - 2;
        ArrayList<Div> xPaddings = getXDivs(bitmap, bitmap.getHeight() - 1);
        if (xPaddings.size() > 1) {
            throw new RuntimeException("Raw padding is wrong. Should be only one horizontal padding region");
        }
        ArrayList<Div> yPaddings = getYDivs(bitmap, bitmap.getWidth() - 1);
        if (yPaddings.size() > 1) {
            throw new RuntimeException("Column padding is wrong. Should be only one vertical padding region");
        }
        if (xPaddings.size() == 0) {
            xPaddings.add(out.xDivs.get(0));
        }
        if (yPaddings.size() == 0) {
            yPaddings.add(out.yDivs.get(0));
        }
        out.padding = new Rect();
        out.padding.left = xPaddings.get(0).start;
        out.padding.right = maxXPixels - xPaddings.get(0).stop;
        out.padding.top = yPaddings.get(0).start;
        out.padding.bottom = maxYPixels - yPaddings.get(0).stop;
    }

    private static void setupStretchableRegions(Bitmap bitmap, NinePatchChunk out) throws RuntimeException {
        out.xDivs = getXDivs(bitmap, 0);
        if (out.xDivs.size() == 0) {
            throw new RuntimeException("must be at least one horizontal stretchable region");
        }
        out.yDivs = getYDivs(bitmap, 0);
        if (out.yDivs.size() == 0) {
            throw new RuntimeException("must be at least one vertical stretchable region");
        }
    }

    private static ArrayList<Div> getRegions(ArrayList<Div> divs, int max) {
        ArrayList<Div> out = new ArrayList<>();
        if (divs != null && divs.size() != 0) {
            for (int i = 0; i < divs.size(); i++) {
                Div div = divs.get(i);
                if (i == 0 && div.start != 0) {
                    out.add(new Div(0, div.start - 1));
                }
                if (i > 0) {
                    out.add(new Div(divs.get(i - 1).stop, div.start - 1));
                }
                out.add(new Div(div.start, div.stop - 1));
                if (i == divs.size() - 1 && div.stop < max) {
                    out.add(new Div(div.stop, max - 1));
                }
            }
        }
        return out;
    }

    private static ArrayList<Div> getYDivs(Bitmap bitmap, int column) {
        ArrayList<Div> yDivs = new ArrayList<>();
        Div tmpDiv = null;
        for (int i = 1; i < bitmap.getHeight(); i++) {
            tmpDiv = processChunk(bitmap.getPixel(column, i), tmpDiv, i - 1, yDivs);
        }
        return yDivs;
    }

    private static ArrayList<Div> getXDivs(Bitmap bitmap, int raw) {
        ArrayList<Div> xDivs = new ArrayList<>();
        Div tmpDiv = null;
        for (int i = 1; i < bitmap.getWidth(); i++) {
            tmpDiv = processChunk(bitmap.getPixel(i, raw), tmpDiv, i - 1, xDivs);
        }
        return xDivs;
    }

    private static Div processChunk(int pixel, Div tmpDiv, int position, ArrayList<Div> divs) {
        if (isBlack(pixel) && tmpDiv == null) {
            tmpDiv = new Div();
            tmpDiv.start = position;
        }
        if (isTransparent(pixel) && tmpDiv != null) {
            tmpDiv.stop = position;
            divs.add(tmpDiv);
            return null;
        }
        return tmpDiv;
    }
}
