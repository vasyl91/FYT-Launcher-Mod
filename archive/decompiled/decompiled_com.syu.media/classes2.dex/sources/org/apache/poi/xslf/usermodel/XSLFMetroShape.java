package org.apache.poi.xslf.usermodel;

import java.io.ByteArrayInputStream;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public class XSLFMetroShape {
    public static Shape<?, ?> parseShape(byte[] bArr) throws Throwable {
        PackagePartName packagePartNameCreatePartName = PackagingURIHelper.createPartName("/drs/shapexml.xml");
        OPCPackage oPCPackage = null;
        try {
            OPCPackage oPCPackageOpen = OPCPackage.open(new ByteArrayInputStream(bArr));
            try {
                XSLFShape xSLFShape = new XSLFGroupShape(CTGroupShape.Factory.parse(oPCPackageOpen.getPart(packagePartNameCreatePartName).getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS), null).getShapes().get(0);
                if (oPCPackageOpen != null) {
                    oPCPackageOpen.close();
                }
                return xSLFShape;
            } catch (Throwable th) {
                th = th;
                oPCPackage = oPCPackageOpen;
                if (oPCPackage != null) {
                    oPCPackage.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
