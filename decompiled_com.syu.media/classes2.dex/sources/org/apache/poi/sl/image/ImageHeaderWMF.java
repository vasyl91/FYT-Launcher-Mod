package org.apache.poi.sl.image;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public class ImageHeaderWMF {
    public static final int APMHEADER_KEY = -1698247209;
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) ImageHeaderWMF.class);
    private final int bottom;
    private int checksum;
    private final int handle;
    private final int inch;
    private final int left;
    private final int reserved;
    private final int right;
    private final int top;

    public int getLength() {
        return 22;
    }

    public ImageHeaderWMF(Rectangle rectangle) {
        this.handle = 0;
        this.left = rectangle.x;
        this.top = rectangle.y;
        this.right = rectangle.x + rectangle.width;
        this.bottom = rectangle.y + rectangle.height;
        this.inch = 72;
        this.reserved = 0;
    }

    public ImageHeaderWMF(byte[] bArr, int i) {
        int i2 = LittleEndian.getInt(bArr, i);
        int i3 = i + 4;
        if (i2 != -1698247209) {
            LOG.log(5, "WMF file doesn't contain a placeable header - ignore parsing");
            this.handle = 0;
            this.left = 0;
            this.top = 0;
            this.right = 200;
            this.bottom = 200;
            this.inch = 72;
            this.reserved = 0;
            return;
        }
        this.handle = LittleEndian.getUShort(bArr, i3);
        int i4 = i3 + 2;
        this.left = LittleEndian.getShort(bArr, i4);
        int i5 = i4 + 2;
        this.top = LittleEndian.getShort(bArr, i5);
        int i6 = i5 + 2;
        this.right = LittleEndian.getShort(bArr, i6);
        int i7 = i6 + 2;
        this.bottom = LittleEndian.getShort(bArr, i7);
        int i8 = i7 + 2;
        this.inch = LittleEndian.getUShort(bArr, i8);
        int i9 = i8 + 2;
        this.reserved = LittleEndian.getInt(bArr, i9);
        short s = LittleEndian.getShort(bArr, i9 + 4);
        this.checksum = s;
        if (s != getChecksum()) {
            LOG.log(5, "WMF checksum does not match the header data");
        }
    }

    public int getChecksum() {
        return (((((-43247) ^ this.left) ^ this.top) ^ this.right) ^ this.bottom) ^ this.inch;
    }

    public void write(OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[22];
        LittleEndian.putInt(bArr, 0, APMHEADER_KEY);
        LittleEndian.putUShort(bArr, 4, 0);
        LittleEndian.putUShort(bArr, 6, this.left);
        LittleEndian.putUShort(bArr, 8, this.top);
        LittleEndian.putUShort(bArr, 10, this.right);
        LittleEndian.putUShort(bArr, 12, this.bottom);
        LittleEndian.putUShort(bArr, 14, this.inch);
        LittleEndian.putInt(bArr, 16, 0);
        int checksum = getChecksum();
        this.checksum = checksum;
        LittleEndian.putUShort(bArr, 20, checksum);
        outputStream.write(bArr);
    }

    public Dimension getSize() {
        double d = 72.0d / ((double) this.inch);
        return new Dimension((int) Math.round(((double) (this.right - this.left)) * d), (int) Math.round(((double) (this.bottom - this.top)) * d));
    }

    public Rectangle getBounds() {
        int i = this.left;
        int i2 = this.top;
        return new Rectangle(i, i2, this.right - i, this.bottom - i2);
    }
}
