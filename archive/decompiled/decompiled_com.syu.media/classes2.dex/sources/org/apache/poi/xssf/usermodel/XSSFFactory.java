package org.apache.poi.xssf.usermodel;

import java.lang.reflect.InvocationTargetException;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLFactory;
import org.apache.poi.POIXMLRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class XSSFFactory extends POIXMLFactory {
    private static final XSSFFactory inst = new XSSFFactory();

    private XSSFFactory() {
    }

    public static XSSFFactory getInstance() {
        return inst;
    }

    @Override // org.apache.poi.POIXMLFactory
    protected POIXMLRelation getDescriptor(String str) {
        return XSSFRelation.getInstance(str);
    }

    @Override // org.apache.poi.POIXMLFactory
    protected POIXMLDocumentPart createDocumentPart(Class<? extends POIXMLDocumentPart> cls, Class<?>[] clsArr, Object[] objArr) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, InvocationTargetException {
        return cls.getDeclaredConstructor(clsArr).newInstance(objArr);
    }
}
