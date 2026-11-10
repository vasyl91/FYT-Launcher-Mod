package org.apache.poi.xdgf.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import org.apache.poi.openxml4j.opc.ContentTypes;
import org.apache.poi.xdgf.geom.Dimension2dDouble;
import org.apache.poi.xdgf.usermodel.XDGFPage;
import org.apache.poi.xdgf.usermodel.XmlVisioDocument;
import org.apache.poi.xdgf.usermodel.shape.ShapeDebuggerRenderer;
import org.apache.poi.xdgf.usermodel.shape.ShapeRenderer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class VsdxToPng {
    public static void renderToPng(XDGFPage xDGFPage, String str, double d, ShapeRenderer shapeRenderer) throws IOException {
        renderToPng(xDGFPage, new File(str), d, shapeRenderer);
    }

    public static void renderToPngDir(XDGFPage xDGFPage, File file, double d, ShapeRenderer shapeRenderer) throws IOException {
        File file2 = new File(file, "page" + xDGFPage.getPageNumber() + "-" + Util.sanitizeFilename(xDGFPage.getName()) + ".png");
        System.out.println("** Writing image to " + file2);
        renderToPng(xDGFPage, file2, d, shapeRenderer);
    }

    public static void renderToPng(XDGFPage xDGFPage, File file, double d, ShapeRenderer shapeRenderer) throws IOException {
        Dimension2dDouble pageSize = xDGFPage.getPageSize();
        int width = (int) (pageSize.getWidth() * d);
        int height = (int) (pageSize.getHeight() * d);
        BufferedImage bufferedImage = new BufferedImage(width, height, 1);
        Graphics2D graphics2DCreateGraphics = bufferedImage.createGraphics();
        graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        graphics2DCreateGraphics.setColor(Color.black);
        graphics2DCreateGraphics.setBackground(Color.white);
        graphics2DCreateGraphics.clearRect(0, 0, width, height);
        graphics2DCreateGraphics.translate(0, bufferedImage.getHeight());
        graphics2DCreateGraphics.scale(d, -d);
        shapeRenderer.setGraphics(graphics2DCreateGraphics);
        xDGFPage.getContent().visitShapes(shapeRenderer);
        graphics2DCreateGraphics.dispose();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            ImageIO.write(bufferedImage, ContentTypes.EXTENSION_PNG, fileOutputStream);
        } finally {
            fileOutputStream.close();
        }
    }

    public static void renderToPng(XmlVisioDocument xmlVisioDocument, String str, double d, ShapeRenderer shapeRenderer) throws IOException {
        File file = new File(str);
        Iterator<XDGFPage> it = xmlVisioDocument.getPages().iterator();
        while (it.hasNext()) {
            renderToPngDir(it.next(), file, d, shapeRenderer);
        }
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length > 2) {
            System.err.println("Usage: [--debug] in.vsdx outdir");
            System.exit(1);
        }
        ShapeRenderer shapeRenderer = new ShapeRenderer();
        String str = strArr[0];
        String str2 = strArr[1];
        if (str.equals("--debug")) {
            str = strArr[1];
            str2 = strArr[2];
            shapeRenderer = new ShapeDebuggerRenderer();
        }
        renderToPng(new XmlVisioDocument(new FileInputStream(str)), str2, 181.8181818181818d, shapeRenderer);
    }
}
