package org.apache.poi.ss.util;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.Units;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ImageUtils {
    public static final int PIXEL_DPI = 96;
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) ImageUtils.class);

    public static Dimension getImageDimension(InputStream inputStream, int i) {
        Dimension dimension = new Dimension();
        if (i == 5 || i == 6 || i == 7) {
            try {
                ImageInputStream imageInputStreamCreateImageInputStream = ImageIO.createImageInputStream(inputStream);
                try {
                    ImageReader imageReader = (ImageReader) ImageIO.getImageReaders(imageInputStreamCreateImageInputStream).next();
                    try {
                        imageReader.setInput(imageInputStreamCreateImageInputStream);
                        BufferedImage bufferedImage = imageReader.read(0);
                        int[] resolution = getResolution(imageReader);
                        if (resolution[0] == 0) {
                            resolution[0] = 96;
                        }
                        if (resolution[1] == 0) {
                            resolution[1] = 96;
                        }
                        dimension.width = (bufferedImage.getWidth() * 96) / resolution[0];
                        dimension.height = (bufferedImage.getHeight() * 96) / resolution[1];
                        imageReader.dispose();
                        imageInputStreamCreateImageInputStream.close();
                    } catch (Throwable th) {
                        imageReader.dispose();
                        throw th;
                    }
                } catch (Throwable th2) {
                    imageInputStreamCreateImageInputStream.close();
                    throw th2;
                }
            } catch (IOException e) {
                logger.log(5, e);
            }
        } else {
            logger.log(5, "Only JPEG, PNG and DIB pictures can be automatically sized");
        }
        return dimension;
    }

    public static int[] getResolution(ImageReader imageReader) throws IOException {
        Element element = (Element) imageReader.getImageMetadata(0).getAsTree("javax_imageio_1.0");
        NodeList elementsByTagName = element.getElementsByTagName("HorizontalPixelSize");
        int i = 96;
        int i2 = (elementsByTagName == null || elementsByTagName.getLength() != 1) ? 96 : (int) (25.4d / ((double) Float.parseFloat(((Element) elementsByTagName.item(0)).getAttribute("value"))));
        NodeList elementsByTagName2 = element.getElementsByTagName("VerticalPixelSize");
        if (elementsByTagName2 != null && elementsByTagName2.getLength() == 1) {
            i = (int) (25.4d / ((double) Float.parseFloat(((Element) elementsByTagName2.item(0)).getAttribute("value"))));
        }
        return new int[]{i2, i};
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00a2 A[PHI: r6
  0x00a2: PHI (r6v2 int) = (r6v1 int), (r6v9 int) binds: [B:18:0x0086, B:23:0x00a0] A[DONT_GENERATE, DONT_INLINE]] */
    public static Dimension setPreferredSize(Picture picture, double d, double d2) {
        double dx1;
        int i;
        double dy1;
        double d3;
        int i2;
        ClientAnchor clientAnchor = picture.getClientAnchor();
        boolean z = clientAnchor instanceof HSSFClientAnchor;
        PictureData pictureData = picture.getPictureData();
        Sheet sheet = picture.getSheet();
        Dimension imageDimension = getImageDimension(new ByteArrayInputStream(pictureData.getData()), pictureData.getPictureType());
        Dimension dimensionFromAnchor = getDimensionFromAnchor(picture);
        double width = d == Double.MAX_VALUE ? imageDimension.getWidth() : (dimensionFromAnchor.getWidth() / 9525.0d) * d;
        double height = d2 == Double.MAX_VALUE ? imageDimension.getHeight() : (dimensionFromAnchor.getHeight() / 9525.0d) * d2;
        short col1 = clientAnchor.getCol1();
        int i3 = col1 + 1;
        double columnWidthInPixels = sheet.getColumnWidthInPixels(col1);
        if (z) {
            dx1 = columnWidthInPixels * (1.0d - (((double) clientAnchor.getDx1()) / 1024.0d));
        } else {
            dx1 = columnWidthInPixels - (((double) clientAnchor.getDx1()) / 9525.0d);
        }
        while (dx1 < width) {
            dx1 += (double) sheet.getColumnWidthInPixels(i3);
            i3++;
        }
        int i4 = 0;
        if (dx1 > width) {
            i3--;
            double columnWidthInPixels2 = sheet.getColumnWidthInPixels(i3);
            double d4 = dx1 - width;
            i = z ? (int) (((columnWidthInPixels2 - d4) / columnWidthInPixels2) * 1024.0d) : (int) ((columnWidthInPixels2 - d4) * 9525.0d);
            if (i < 0) {
                i = 0;
            }
        } else {
            i = 0;
        }
        clientAnchor.setCol2(i3);
        clientAnchor.setDx2(i);
        int row1 = clientAnchor.getRow1();
        int i5 = row1 + 1;
        double rowHeightInPixels = getRowHeightInPixels(sheet, row1);
        if (z) {
            dy1 = rowHeightInPixels * (1.0d - (((double) clientAnchor.getDy1()) / 256.0d));
        } else {
            dy1 = rowHeightInPixels - (((double) clientAnchor.getDy1()) / 9525.0d);
        }
        while (dy1 < height) {
            dy1 += getRowHeightInPixels(sheet, i5);
            i5++;
        }
        if (dy1 > height) {
            i5--;
            double rowHeightInPixels2 = getRowHeightInPixels(sheet, i5);
            double d5 = dy1 - height;
            if (z) {
                i2 = (int) (((rowHeightInPixels2 - d5) / rowHeightInPixels2) * 256.0d);
                d3 = 9525.0d;
            } else {
                double d6 = rowHeightInPixels2 - d5;
                d3 = 9525.0d;
                i2 = (int) (d6 * 9525.0d);
            }
            if (i2 >= 0) {
                i4 = i2;
            }
        } else {
            d3 = 9525.0d;
        }
        clientAnchor.setRow2(i5);
        clientAnchor.setDy2(i4);
        return new Dimension((int) Math.round(width * d3), (int) Math.round(height * d3));
    }

    public static Dimension getDimensionFromAnchor(Picture picture) {
        double dx1;
        double dx2;
        double dy1;
        double d;
        double dy2;
        ClientAnchor clientAnchor = picture.getClientAnchor();
        boolean z = clientAnchor instanceof HSSFClientAnchor;
        Sheet sheet = picture.getSheet();
        short col1 = clientAnchor.getCol1();
        int i = col1 + 1;
        double columnWidthInPixels = sheet.getColumnWidthInPixels(col1);
        if (z) {
            dx1 = columnWidthInPixels * (1.0d - (((double) clientAnchor.getDx1()) / 1024.0d));
        } else {
            dx1 = columnWidthInPixels - (((double) clientAnchor.getDx1()) / 9525.0d);
        }
        while (i < clientAnchor.getCol2()) {
            dx1 += (double) sheet.getColumnWidthInPixels(i);
            i++;
        }
        if (z) {
            dx2 = ((double) (sheet.getColumnWidthInPixels(i) * clientAnchor.getDx2())) / 1024.0d;
        } else {
            dx2 = ((double) clientAnchor.getDx2()) / 9525.0d;
        }
        double d2 = dx1 + dx2;
        int row1 = clientAnchor.getRow1();
        int i2 = row1 + 1;
        double rowHeightInPixels = getRowHeightInPixels(sheet, row1);
        if (z) {
            dy1 = rowHeightInPixels * (1.0d - (((double) clientAnchor.getDy1()) / 256.0d));
        } else {
            dy1 = rowHeightInPixels - (((double) clientAnchor.getDy1()) / 9525.0d);
        }
        while (i2 < clientAnchor.getRow2()) {
            dy1 += getRowHeightInPixels(sheet, i2);
            i2++;
        }
        if (z) {
            dy2 = dy1 + ((getRowHeightInPixels(sheet, i2) * ((double) clientAnchor.getDy2())) / 256.0d);
            d = 9525.0d;
        } else {
            d = 9525.0d;
            dy2 = dy1 + (((double) clientAnchor.getDy2()) / 9525.0d);
        }
        return new Dimension((int) Math.rint(d2 * d), (int) Math.rint(dy2 * d));
    }

    public static double getRowHeightInPixels(Sheet sheet, int i) {
        Row row = sheet.getRow(i);
        return ((double) Units.toEMU(row == null ? sheet.getDefaultRowHeightInPoints() : row.getHeightInPoints())) / 9525.0d;
    }
}
