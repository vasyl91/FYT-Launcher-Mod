package org.apache.poi.xslf.usermodel;

import java.lang.reflect.InvocationTargetException;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLFactory;
import org.apache.poi.POIXMLRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class XSLFFactory extends POIXMLFactory {
    private static final XSLFFactory inst = new XSLFFactory();

    private XSLFFactory() {
    }

    public static XSLFFactory getInstance() {
        return inst;
    }

    @Override // org.apache.poi.POIXMLFactory
    protected POIXMLRelation getDescriptor(String str) {
        return XSLFRelation.getInstance(str);
    }

    @Override // org.apache.poi.POIXMLFactory
    protected POIXMLDocumentPart createDocumentPart(Class<? extends POIXMLDocumentPart> cls, Class<?>[] clsArr, Object[] objArr) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, InvocationTargetException {
        return cls.getDeclaredConstructor(clsArr).newInstance(objArr);
    }
}
