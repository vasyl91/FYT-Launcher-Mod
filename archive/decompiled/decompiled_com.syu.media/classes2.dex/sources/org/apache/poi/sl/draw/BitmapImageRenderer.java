package org.apache.poi.sl.draw;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.RescaleOp;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.MemoryCacheImageInputStream;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class BitmapImageRenderer implements ImageRenderer {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) ImageRenderer.class);
    protected BufferedImage img;

    @Override // org.apache.poi.sl.draw.ImageRenderer
    public void loadImage(InputStream inputStream, String str) throws IOException {
        this.img = readImage(inputStream, str);
    }

    @Override // org.apache.poi.sl.draw.ImageRenderer
    public void loadImage(byte[] bArr, String str) throws IOException {
        this.img = readImage(new ByteArrayInputStream(bArr), str);
    }

    private static BufferedImage readImage(InputStream inputStream, String str) throws Throwable {
        int iFindTruncatedBlackBox;
        int iFindTruncatedBlackBox2;
        if (inputStream.markSupported()) {
            inputStream.mark(inputStream.available());
        }
        ImageInputStream memoryCacheImageInputStream = new MemoryCacheImageInputStream(inputStream);
        try {
            ImageInputStream memoryCacheImageInputStream2 = new MemoryCacheImageInputStream(inputStream);
            try {
                memoryCacheImageInputStream2.mark();
                Iterator imageReaders = ImageIO.getImageReaders(memoryCacheImageInputStream2);
                BufferedImage bufferedImage = null;
                IOException iOException = null;
                while (bufferedImage == null && imageReaders.hasNext()) {
                    ImageReader imageReader = (ImageReader) imageReaders.next();
                    ImageReadParam defaultReadParam = imageReader.getDefaultReadParam();
                    int i = 0;
                    ImageInputStream imageInputStream = memoryCacheImageInputStream2;
                    BufferedImage bufferedImageCreateBufferedImage = bufferedImage;
                    IOException e = iOException;
                    ImageInputStream memoryCacheImageInputStream3 = imageInputStream;
                    while (bufferedImageCreateBufferedImage == null && i < 3) {
                        try {
                            try {
                                memoryCacheImageInputStream3.reset();
                            } catch (IOException e2) {
                                e = e2;
                                if (inputStream.markSupported()) {
                                    inputStream.reset();
                                    inputStream.mark(inputStream.available());
                                    memoryCacheImageInputStream3.close();
                                    memoryCacheImageInputStream3 = new MemoryCacheImageInputStream(inputStream);
                                } else {
                                    imageReader.dispose();
                                    ImageInputStream imageInputStream2 = memoryCacheImageInputStream3;
                                    iOException = e;
                                    bufferedImage = bufferedImageCreateBufferedImage;
                                    memoryCacheImageInputStream2 = imageInputStream2;
                                }
                            }
                            memoryCacheImageInputStream3.mark();
                            if (i == 0) {
                                imageReader.setInput(memoryCacheImageInputStream3, false, true);
                                bufferedImageCreateBufferedImage = imageReader.read(0, defaultReadParam);
                            } else if (i != 1) {
                                if (i == 2) {
                                    try {
                                        imageReader.setInput(memoryCacheImageInputStream3, false, true);
                                        int height = imageReader.getHeight(0);
                                        int width = imageReader.getWidth(0);
                                        Iterator imageTypes = imageReader.getImageTypes(0);
                                        if (imageTypes.hasNext()) {
                                            bufferedImageCreateBufferedImage = ((ImageTypeSpecifier) imageTypes.next()).createBufferedImage(width, height);
                                            defaultReadParam.setDestination(bufferedImageCreateBufferedImage);
                                            try {
                                                imageReader.read(0, defaultReadParam);
                                                if (bufferedImageCreateBufferedImage.getType() != 2 && (iFindTruncatedBlackBox2 = findTruncatedBlackBox(bufferedImageCreateBufferedImage, width, height)) < height) {
                                                    BufferedImage bufferedImage2 = new BufferedImage(width, height, 2);
                                                    Graphics2D graphics2DCreateGraphics = bufferedImage2.createGraphics();
                                                    graphics2DCreateGraphics.clipRect(0, 0, width, iFindTruncatedBlackBox2);
                                                    graphics2DCreateGraphics.drawImage(bufferedImageCreateBufferedImage, 0, 0, (ImageObserver) null);
                                                    graphics2DCreateGraphics.dispose();
                                                    bufferedImageCreateBufferedImage.flush();
                                                    bufferedImageCreateBufferedImage = bufferedImage2;
                                                }
                                            } catch (Throwable th) {
                                                if (bufferedImageCreateBufferedImage.getType() != 2 && (iFindTruncatedBlackBox = findTruncatedBlackBox(bufferedImageCreateBufferedImage, width, height)) < height) {
                                                    BufferedImage bufferedImage3 = new BufferedImage(width, height, 2);
                                                    Graphics2D graphics2DCreateGraphics2 = bufferedImage3.createGraphics();
                                                    graphics2DCreateGraphics2.clipRect(0, 0, width, iFindTruncatedBlackBox);
                                                    graphics2DCreateGraphics2.drawImage(bufferedImageCreateBufferedImage, 0, 0, (ImageObserver) null);
                                                    graphics2DCreateGraphics2.dispose();
                                                    bufferedImageCreateBufferedImage.flush();
                                                    bufferedImageCreateBufferedImage = bufferedImage3;
                                                }
                                                throw th;
                                            }
                                        } else {
                                            e = new IOException("unable to load even a truncated version of the image.");
                                        }
                                    } catch (IOException e3) {
                                        e = e3;
                                        if (i < 2) {
                                        }
                                    } catch (RuntimeException e4) {
                                        if (i < 2) {
                                            e = new IOException("ImageIO runtime exception - " + (i == 0 ? "normal" : "fallback"), e4);
                                        }
                                    }
                                }
                                i++;
                            } else {
                                Iterator imageTypes2 = imageReader.getImageTypes(0);
                                while (imageTypes2.hasNext()) {
                                    ImageTypeSpecifier imageTypeSpecifier = (ImageTypeSpecifier) imageTypes2.next();
                                    if (imageTypeSpecifier.getBufferedImageType() == 10) {
                                        defaultReadParam.setDestinationType(imageTypeSpecifier);
                                        break;
                                    }
                                }
                                imageReader.setInput(memoryCacheImageInputStream3, false, true);
                                bufferedImageCreateBufferedImage = imageReader.read(0, defaultReadParam);
                            }
                            e = null;
                            i++;
                        } catch (Throwable th2) {
                            th = th2;
                            memoryCacheImageInputStream = memoryCacheImageInputStream3;
                            memoryCacheImageInputStream.close();
                            throw th;
                        }
                    }
                    imageReader.dispose();
                    ImageInputStream imageInputStream3 = memoryCacheImageInputStream3;
                    iOException = e;
                    bufferedImage = bufferedImageCreateBufferedImage;
                    memoryCacheImageInputStream2 = imageInputStream3;
                }
                memoryCacheImageInputStream2.close();
                if (bufferedImage == null) {
                    if (iOException != null) {
                        throw iOException;
                    }
                    LOG.log(5, "Content-type: " + str + " is not support. Image ignored.");
                    return null;
                }
                if (bufferedImage.getType() == 2) {
                    return bufferedImage;
                }
                BufferedImage bufferedImage4 = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), 2);
                Graphics graphics = bufferedImage4.getGraphics();
                graphics.drawImage(bufferedImage, 0, 0, (ImageObserver) null);
                graphics.dispose();
                return bufferedImage4;
            } catch (Throwable th3) {
                th = th3;
                memoryCacheImageInputStream = memoryCacheImageInputStream2;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private static int findTruncatedBlackBox(BufferedImage bufferedImage, int i, int i2) {
        for (int i3 = i2 - 1; i3 > 0; i3--) {
            int i4 = i - 1;
            while (i4 > 0) {
                if (bufferedImage.getRGB(i4, i3) != -16777216) {
                    return i3 + 1;
                }
                i4 -= i / 10;
            }
        }
        return 0;
    }

    @Override // org.apache.poi.sl.draw.ImageRenderer
    public BufferedImage getImage() {
        return this.img;
    }

    @Override // org.apache.poi.sl.draw.ImageRenderer
    public BufferedImage getImage(Dimension dimension) {
        double width = this.img.getWidth();
        double height = this.img.getHeight();
        BufferedImage bufferedImage = new BufferedImage((int) width, (int) height, 2);
        double width2 = dimension.getWidth();
        double height2 = dimension.getHeight();
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.scale(width2 / width, height2 / height);
        new AffineTransformOp(affineTransform, 2).filter(this.img, bufferedImage);
        return bufferedImage;
    }

    @Override // org.apache.poi.sl.draw.ImageRenderer
    public Dimension getDimension() {
        return this.img == null ? new Dimension(0, 0) : new Dimension(this.img.getWidth(), this.img.getHeight());
    }

    @Override // org.apache.poi.sl.draw.ImageRenderer
    public void setAlpha(double d) {
        if (this.img == null) {
            return;
        }
        Dimension dimension = getDimension();
        BufferedImage bufferedImage = new BufferedImage((int) dimension.getWidth(), (int) dimension.getHeight(), 2);
        Graphics2D graphics2DCreateGraphics = bufferedImage.createGraphics();
        graphics2DCreateGraphics.drawImage(this.img, new RescaleOp(new float[]{1.0f, 1.0f, 1.0f, (float) d}, new float[]{0.0f, 0.0f, 0.0f, 0.0f}, (RenderingHints) null), 0, 0);
        graphics2DCreateGraphics.dispose();
        this.img = bufferedImage;
    }

    @Override // org.apache.poi.sl.draw.ImageRenderer
    public boolean drawImage(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        return drawImage(graphics2D, rectangle2D, null);
    }

    @Override // org.apache.poi.sl.draw.ImageRenderer
    public boolean drawImage(Graphics2D graphics2D, Rectangle2D rectangle2D, Insets insets) {
        Insets insets2;
        boolean z = false;
        if (this.img == null) {
            return false;
        }
        if (insets == null) {
            insets2 = new Insets(0, 0, 0, 0);
        } else {
            insets2 = insets;
            z = true;
        }
        int width = this.img.getWidth();
        int height = this.img.getHeight();
        double d = ((double) ((100000 - insets2.left) - insets2.right)) / 100000.0d;
        double d2 = ((double) ((100000 - insets2.top) - insets2.bottom)) / 100000.0d;
        boolean z2 = z;
        double d3 = width;
        double width2 = rectangle2D.getWidth() / (d * d3);
        double d4 = height;
        double height2 = rectangle2D.getHeight() / (d2 * d4);
        AffineTransform affineTransform = new AffineTransform(width2, 0.0d, 0.0d, height2, rectangle2D.getX() - (((d3 * width2) * ((double) insets2.left)) / 100000.0d), rectangle2D.getY() - (((d4 * height2) * ((double) insets2.top)) / 100000.0d));
        Shape clip = graphics2D.getClip();
        if (z2) {
            graphics2D.clip(rectangle2D.getBounds2D());
        }
        graphics2D.drawRenderedImage(this.img, affineTransform);
        graphics2D.setClip(clip);
        return true;
    }
}
