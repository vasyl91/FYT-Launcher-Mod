package org.apache.poi.sl.usermodel;

import java.awt.Dimension;
import java.io.IOException;
import org.apache.poi.openxml4j.opc.ContentTypes;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface PictureData {
    byte[] getChecksum();

    String getContentType();

    byte[] getData();

    Dimension getImageDimension();

    Dimension getImageDimensionInPixels();

    PictureType getType();

    void setData(byte[] bArr) throws IOException;

    public enum PictureType {
        EMF(2, 2, "image/x-emf", ".emf"),
        WMF(3, 3, "image/x-wmf", ".wmf"),
        PICT(4, 4, ContentTypes.IMAGE_PICT, ".pict"),
        JPEG(5, 5, ContentTypes.IMAGE_JPEG, ".jpg"),
        PNG(6, 6, ContentTypes.IMAGE_PNG, ".png"),
        DIB(7, 7, "image/dib", ".dib"),
        GIF(-1, 8, ContentTypes.IMAGE_GIF, ".gif"),
        TIFF(-1, 9, ContentTypes.IMAGE_TIFF, ".tif"),
        EPS(-1, 10, "image/x-eps", ".eps"),
        BMP(-1, 11, "image/x-ms-bmp", ".bmp"),
        WPG(-1, 12, "image/x-wpg", ".wpg"),
        WDP(-1, 13, "image/vnd.ms-photo", ".wdp");

        public final String contentType;
        public final String extension;
        public final int nativeId;
        public final int ooxmlId;

        PictureType(int i, int i2, String str, String str2) {
            this.nativeId = i;
            this.ooxmlId = i2;
            this.contentType = str;
            this.extension = str2;
        }

        public static PictureType forNativeID(int i) {
            for (PictureType pictureType : values()) {
                if (pictureType.nativeId == i) {
                    return pictureType;
                }
            }
            return null;
        }

        public static PictureType forOoxmlID(int i) {
            for (PictureType pictureType : values()) {
                if (pictureType.ooxmlId == i) {
                    return pictureType;
                }
            }
            return null;
        }
    }
}
