package org.apache.poi.xdgf.extractor;

import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xdgf.usermodel.XDGFPage;
import org.apache.poi.xdgf.usermodel.XmlVisioDocument;
import org.apache.poi.xdgf.usermodel.shape.ShapeTextVisitor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XDGFVisioExtractor extends POIXMLTextExtractor {
    protected final XmlVisioDocument document;

    public XDGFVisioExtractor(XmlVisioDocument xmlVisioDocument) {
        super(xmlVisioDocument);
        this.document = xmlVisioDocument;
    }

    public XDGFVisioExtractor(OPCPackage oPCPackage) throws IOException {
        this(new XmlVisioDocument(oPCPackage));
    }

    @Override // org.apache.poi.POITextExtractor
    public String getText() {
        ShapeTextVisitor shapeTextVisitor = new ShapeTextVisitor();
        Iterator<XDGFPage> it = this.document.getPages().iterator();
        while (it.hasNext()) {
            it.next().getContent().visitShapes(shapeTextVisitor);
        }
        return shapeTextVisitor.getText().toString();
    }

    public static void main(String[] strArr) throws IOException {
        if (strArr.length < 1) {
            System.err.println("Use:");
            System.err.println("  XDGFVisioExtractor <filename.vsdx>");
            System.exit(1);
        }
        XDGFVisioExtractor xDGFVisioExtractor = new XDGFVisioExtractor(POIXMLDocument.openPackage(strArr[0]));
        System.out.println(xDGFVisioExtractor.getText());
        xDGFVisioExtractor.close();
    }
}
