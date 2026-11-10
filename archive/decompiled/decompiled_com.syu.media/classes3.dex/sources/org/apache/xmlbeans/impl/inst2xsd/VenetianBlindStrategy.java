package org.apache.xmlbeans.impl.inst2xsd;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.impl.inst2xsd.util.Element;
import org.apache.xmlbeans.impl.inst2xsd.util.Type;
import org.apache.xmlbeans.impl.inst2xsd.util.TypeSystemHolder;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class VenetianBlindStrategy extends RussianDollStrategy implements XsdGenStrategy {
    private boolean compatibleTypes(Type type, Type type2) {
        return true;
    }

    @Override // org.apache.xmlbeans.impl.inst2xsd.RussianDollStrategy
    protected void checkIfReferenceToGlobalTypeIsNeeded(Element element, TypeSystemHolder typeSystemHolder, Inst2XsdOptions inst2XsdOptions) {
        Type type = element.getType();
        QName name = element.getName();
        if (type.isGlobal() || !type.isComplexType()) {
            return;
        }
        int i = 0;
        while (true) {
            type.setName(new QName(name.getNamespaceURI(), name.getLocalPart() + "Type" + (i != 0 ? "" + i : "")));
            Type globalType = typeSystemHolder.getGlobalType(type.getName());
            if (globalType == null) {
                type.setGlobal(true);
                typeSystemHolder.addGlobalType(type);
                return;
            } else {
                if (compatibleTypes(globalType, type)) {
                    combineTypes(globalType, type, inst2XsdOptions);
                    element.setType(globalType);
                    return;
                }
                i++;
            }
        }
    }
}
