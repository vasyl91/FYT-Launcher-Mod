package org.apache.poi.xdgf.usermodel;

import java.lang.reflect.InvocationTargetException;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLFactory;
import org.apache.poi.POIXMLRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XDGFFactory extends POIXMLFactory {
    private final XDGFDocument document;

    public XDGFFactory(XDGFDocument xDGFDocument) {
        this.document = xDGFDocument;
    }

    @Override // org.apache.poi.POIXMLFactory
    protected POIXMLRelation getDescriptor(String str) {
        return XDGFRelation.getInstance(str);
    }

    @Override // org.apache.poi.POIXMLFactory
    protected POIXMLDocumentPart createDocumentPart(Class<? extends POIXMLDocumentPart> cls, Class<?>[] clsArr, Object[] objArr) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, InvocationTargetException {
        Object[] objArr2;
        Class<?>[] clsArr2;
        if (clsArr == null) {
            clsArr2 = new Class[]{XDGFDocument.class};
            objArr2 = new Object[]{this.document};
        } else {
            Class<?>[] clsArr3 = new Class[clsArr.length + 1];
            System.arraycopy(clsArr, 0, clsArr3, 0, clsArr.length);
            clsArr3[clsArr.length] = XDGFDocument.class;
            Object[] objArr3 = new Object[objArr.length + 1];
            System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
            objArr3[objArr.length] = this.document;
            objArr2 = objArr3;
            clsArr2 = clsArr3;
        }
        return cls.getDeclaredConstructor(clsArr2).newInstance(objArr2);
    }
}
