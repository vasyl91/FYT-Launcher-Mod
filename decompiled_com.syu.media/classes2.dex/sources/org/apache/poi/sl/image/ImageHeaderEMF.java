package org.apache.poi.sl.image;

import java.awt.Dimension;
import java.awt.Rectangle;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public class ImageHeaderEMF {
    private static final String EMF_SIGNATURE = " EMF";
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) ImageHeaderEMF.class);
    private final Rectangle deviceBounds;

    public ImageHeaderEMF(byte[] bArr, int i) {
        int uInt = (int) LittleEndian.getUInt(bArr, i);
        int i2 = i + 4;
        if (uInt != 1) {
            LOG.log(5, "Invalid EMF picture - invalid type");
            this.deviceBounds = new Rectangle(0, 0, 200, 200);
            return;
        }
        int i3 = i2 + 4;
        int i4 = LittleEndian.getInt(bArr, i3);
        int i5 = i3 + 4;
        int i6 = LittleEndian.getInt(bArr, i5);
        int i7 = i5 + 4;
        int i8 = LittleEndian.getInt(bArr, i7);
        int i9 = i7 + 4;
        this.deviceBounds = new Rectangle(i4, i6, i8 - i4, LittleEndian.getInt(bArr, i9) - i6);
        if (EMF_SIGNATURE.equals(new String(bArr, i9 + 4 + 16, 4, LocaleUtil.CHARSET_1252))) {
            return;
        }
        LOG.log(5, "Invalid EMF picture - invalid signature");
    }

    public Dimension getSize() {
        return this.deviceBounds.getSize();
    }

    public Rectangle getBounds() {
        return this.deviceBounds;
    }
}
