package org.apache.poi.xdgf.util;

import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import org.apache.poi.xdgf.usermodel.XDGFPage;
import org.apache.poi.xdgf.usermodel.XDGFShape;
import org.apache.poi.xdgf.usermodel.XmlVisioDocument;
import org.apache.poi.xdgf.usermodel.shape.ShapeVisitor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HierarchyPrinter {
    public static void printHierarchy(XDGFPage xDGFPage, File file) throws UnsupportedEncodingException, FileNotFoundException {
        PrintStream printStream = new PrintStream((OutputStream) new FileOutputStream(new File(file, "page" + xDGFPage.getPageNumber() + "-" + Util.sanitizeFilename(xDGFPage.getName()) + ".txt")), false, "utf-8");
        printHierarchy(xDGFPage, printStream);
        printStream.close();
    }

    public static void printHierarchy(XDGFPage xDGFPage, final PrintStream printStream) {
        xDGFPage.getContent().visitShapes(new ShapeVisitor() { // from class: org.apache.poi.xdgf.util.HierarchyPrinter.1
            @Override // org.apache.poi.xdgf.usermodel.shape.ShapeVisitor
            public void visit(XDGFShape xDGFShape, AffineTransform affineTransform, int i) {
                for (int i2 = 0; i2 < i; i2++) {
                    printStream.append((CharSequence) "  ");
                }
                printStream.println(xDGFShape + " [" + xDGFShape.getShapeType() + ", " + xDGFShape.getSymbolName() + "] " + xDGFShape.getMasterShape() + " " + xDGFShape.getTextAsString().trim());
            }
        });
    }

    public static void printHierarchy(XmlVisioDocument xmlVisioDocument, String str) throws UnsupportedEncodingException, FileNotFoundException {
        File file = new File(str);
        Iterator<XDGFPage> it = xmlVisioDocument.getPages().iterator();
        while (it.hasNext()) {
            printHierarchy(it.next(), file);
        }
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length != 2) {
            System.err.println("Usage: in.vsdx outdir");
            System.exit(1);
        }
        String str = strArr[0];
        printHierarchy(new XmlVisioDocument(new FileInputStream(str)), strArr[1]);
    }
}
