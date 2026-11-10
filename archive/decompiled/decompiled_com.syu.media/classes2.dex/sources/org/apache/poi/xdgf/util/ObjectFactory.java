package org.apache.poi.xdgf.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.POIXMLException;
import org.apache.xmlbeans.XmlObject;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ObjectFactory<T, X extends XmlObject> {
    Map<String, Constructor<? extends T>> _types = new HashMap();

    public void put(String str, Class<? extends T> cls, Class<?>... clsArr) throws NoSuchMethodException, SecurityException {
        this._types.put(str, cls.getDeclaredConstructor(clsArr));
    }

    public T load(String str, Object... objArr) {
        Constructor<? extends T> constructor = this._types.get(str);
        if (constructor == null) {
            throw new POIXMLException("Invalid '" + ((XmlObject) objArr[0]).schemaType().getName().getLocalPart() + "' name '" + str + "'");
        }
        try {
            return constructor.newInstance(objArr);
        } catch (InvocationTargetException e) {
            throw new POIXMLException(e.getCause());
        } catch (Exception e2) {
            throw new POIXMLException(e2);
        }
    }
}
