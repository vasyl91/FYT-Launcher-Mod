package org.apache.poi.sl.draw;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.sl.usermodel.PictureShape;
import org.apache.poi.sl.usermodel.RectAlign;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DrawPictureShape extends DrawSimpleShape {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) DrawPictureShape.class);
    private static final String WMF_IMAGE_RENDERER = "org.apache.poi.hwmf.draw.HwmfSLImageRenderer";

    public DrawPictureShape(PictureShape<?, ?> pictureShape) {
        super(pictureShape);
    }

    @Override // org.apache.poi.sl.draw.DrawShape, org.apache.poi.sl.draw.Drawable
    public void drawContent(Graphics2D graphics2D) {
        PictureData pictureData = getShape().getPictureData();
        if (pictureData == null) {
            return;
        }
        Rectangle2D anchor = getAnchor(graphics2D, getShape());
        Insets clipping = getShape().getClipping();
        try {
            ImageRenderer imageRenderer = getImageRenderer(graphics2D, pictureData.getContentType());
            imageRenderer.loadImage(pictureData.getData(), pictureData.getContentType());
            imageRenderer.drawImage(graphics2D, anchor, clipping);
        } catch (IOException e) {
            LOG.log(7, "image can't be loaded/rendered.", e);
        }
    }

    public static ImageRenderer getImageRenderer(Graphics2D graphics2D, String str) {
        ImageRenderer imageRenderer = (ImageRenderer) graphics2D.getRenderingHint(Drawable.IMAGE_RENDERER);
        if (imageRenderer != null) {
            return imageRenderer;
        }
        if (PictureData.PictureType.WMF.contentType.equals(str)) {
            try {
                return (ImageRenderer) Thread.currentThread().getContextClassLoader().loadClass(WMF_IMAGE_RENDERER).newInstance();
            } catch (Exception e) {
                LOG.log(7, "WMF image renderer is not on the classpath - include poi-scratchpad jar!", e);
            }
        }
        return new BitmapImageRenderer();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.poi.sl.draw.DrawSimpleShape, org.apache.poi.sl.draw.DrawShape
    public PictureShape<?, ?> getShape() {
        return (PictureShape) this.shape;
    }

    public void resize() {
        PictureShape<?, ?> shape = getShape();
        Dimension imageDimension = shape.getPictureData().getImageDimension();
        Rectangle2D anchor = shape.getAnchor();
        shape.setAnchor(new Rectangle2D.Double(anchor.getX(), anchor.getY(), imageDimension.getWidth(), imageDimension.getHeight()));
    }

    public void resize(Rectangle2D rectangle2D) {
        resize(rectangle2D, RectAlign.CENTER);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void resize(Rectangle2D rectangle2D, RectAlign rectAlign) {
        double height;
        double d;
        double d2;
        PictureShape<?, ?> shape = getShape();
        Dimension imageDimension = shape.getPictureData().getImageDimension();
        if (imageDimension.width <= 0 || imageDimension.height <= 0) {
            shape.setAnchor(rectangle2D);
            return;
        }
        double width = rectangle2D.getWidth();
        double height2 = rectangle2D.getHeight();
        double d3 = width / ((double) imageDimension.width);
        double d4 = height2 / ((double) imageDimension.height);
        double width2 = 0.0d;
        if (d3 > d4) {
            double d5 = d4 * ((double) imageDimension.width);
            d = d5;
            d2 = height2;
            height = 0.0d;
            width2 = rectangle2D.getWidth() - d5;
        } else if (d4 > d3) {
            double d6 = ((double) imageDimension.height) * d3;
            height = rectangle2D.getHeight() - d6;
            d = width;
            d2 = d6;
        } else {
            shape.setAnchor(rectangle2D);
            return;
        }
        double x = rectangle2D.getX();
        double y = rectangle2D.getY();
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$RectAlign[rectAlign.ordinal()]) {
            case 1:
                width2 /= 2.0d;
                x += width2;
                break;
            case 2:
                x += width2;
                break;
            case 3:
                x += width2;
                height /= 2.0d;
                y += height;
                break;
            case 4:
                x += width2;
                y += height;
                break;
            case 5:
                width2 /= 2.0d;
                x += width2;
                y += height;
                break;
            case 6:
                y += height;
                break;
            case 7:
                height /= 2.0d;
                y += height;
                break;
            case 8:
                break;
            default:
                width2 /= 2.0d;
                x += width2;
                height /= 2.0d;
                y += height;
                break;
        }
        shape.setAnchor(new Rectangle2D.Double(x, y, d, d2));
    }

    /* JADX INFO: renamed from: org.apache.poi.sl.draw.DrawPictureShape$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$RectAlign;

        static {
            int[] iArr = new int[RectAlign.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$RectAlign = iArr;
            try {
                iArr[RectAlign.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$RectAlign[RectAlign.TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$RectAlign[RectAlign.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$RectAlign[RectAlign.BOTTOM_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$RectAlign[RectAlign.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$RectAlign[RectAlign.BOTTOM_LEFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$RectAlign[RectAlign.LEFT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$RectAlign[RectAlign.TOP_LEFT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }
}
