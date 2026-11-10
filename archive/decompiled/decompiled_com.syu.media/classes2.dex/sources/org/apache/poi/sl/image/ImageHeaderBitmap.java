package org.apache.poi.sl.image;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.poi.util.Internal;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.Units;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public class ImageHeaderBitmap {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) ImageHeaderBitmap.class);
    private final Dimension size;

    public ImageHeaderBitmap(byte[] bArr, int i) {
        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(new ByteArrayInputStream(bArr, i, bArr.length - i));
        } catch (IOException e) {
            LOG.log(5, "Can't determine image dimensions", e);
            bufferedImage = null;
        }
        this.size = bufferedImage == null ? new Dimension(200, 200) : new Dimension((int) Units.pixelToPoints(bufferedImage.getWidth()), (int) Units.pixelToPoints(bufferedImage.getHeight()));
    }

    public Dimension getSize() {
        return this.size;
    }
}
