package org.apache.xmlbeans.impl.jam.visitor;

import java.util.HashMap;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JMethod;
import org.apache.xmlbeans.impl.jam.JProperty;
import org.apache.xmlbeans.impl.jam.internal.elements.PropertyImpl;
import org.apache.xmlbeans.impl.jam.mutable.MClass;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class PropertyInitializer extends MVisitor {
    @Override // org.apache.xmlbeans.impl.jam.visitor.MVisitor
    public void visit(MClass mClass) {
        addProperties(mClass, true);
        addProperties(mClass, false);
    }

    private void addProperties(MClass mClass, boolean z) {
        JMethod[] declaredMethods = z ? mClass.getDeclaredMethods() : mClass.getMethods();
        HashMap map = new HashMap();
        for (int i = 0; i < declaredMethods.length; i++) {
            String simpleName = declaredMethods[i].getSimpleName();
            if ((simpleName.startsWith("get") && simpleName.length() > 3) || (simpleName.startsWith("is") && simpleName.length() > 2)) {
                JClass returnType = declaredMethods[i].getReturnType();
                if (returnType != null && declaredMethods[i].getParameters().length <= 0) {
                    if (simpleName.startsWith("get")) {
                        simpleName = simpleName.substring(3);
                    } else {
                        simpleName = simpleName.substring(2);
                    }
                    JProperty jProperty = (JProperty) map.get(simpleName);
                    if (jProperty == null) {
                        map.put(simpleName, z ? mClass.addNewDeclaredProperty(simpleName, declaredMethods[i], null) : mClass.addNewProperty(simpleName, declaredMethods[i], null));
                    } else if (returnType.equals(jProperty.getType())) {
                        ((PropertyImpl) jProperty).setGetter(declaredMethods[i]);
                    }
                    if (!simpleName.startsWith("set")) {
                    }
                }
            } else if (!simpleName.startsWith("set") && simpleName.length() > 3 && declaredMethods[i].getParameters().length == 1) {
                JClass type = declaredMethods[i].getParameters()[0].getType();
                String strSubstring = simpleName.substring(3);
                JProperty jProperty2 = (JProperty) map.get(strSubstring);
                if (jProperty2 == null) {
                    map.put(strSubstring, z ? mClass.addNewDeclaredProperty(strSubstring, null, declaredMethods[i]) : mClass.addNewProperty(strSubstring, null, declaredMethods[i]));
                } else if (type.equals(jProperty2.getType())) {
                    ((PropertyImpl) jProperty2).setSetter(declaredMethods[i]);
                }
            }
        }
    }
}
