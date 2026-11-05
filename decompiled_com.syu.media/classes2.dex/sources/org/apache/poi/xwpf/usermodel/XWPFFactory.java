package org.apache.poi.xwpf.usermodel;

import java.lang.reflect.InvocationTargetException;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLFactory;
import org.apache.poi.POIXMLRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class XWPFFactory extends POIXMLFactory {
    private static final XWPFFactory inst = new XWPFFactory();

    private XWPFFactory() {
    }

    public static XWPFFactory getInstance() {
        return inst;
    }

    @Override // org.apache.poi.POIXMLFactory
    protected POIXMLRelation getDescriptor(String str) {
        return XWPFRelation.getInstance(str);
    }

    @Override // org.apache.poi.POIXMLFactory
    protected POIXMLDocumentPart createDocumentPart(Class<? extends POIXMLDocumentPart> cls, Class<?>[] clsArr, Object[] objArr) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, InvocationTargetException {
        return cls.getDeclaredConstructor(clsArr).newInstance(objArr);
    }
}
