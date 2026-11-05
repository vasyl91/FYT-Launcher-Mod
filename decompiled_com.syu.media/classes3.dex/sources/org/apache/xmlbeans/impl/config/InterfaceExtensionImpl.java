package org.apache.xmlbeans.impl.config;

import org.apache.xmlbeans.InterfaceExtension;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JMethod;
import org.apache.xmlbeans.impl.jam.JParameter;
import org.apache.xmlbeans.impl.jam.JamClassLoader;
import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class InterfaceExtensionImpl implements InterfaceExtension {
    private String _delegateToClassName;
    private String _interfaceClassName;
    private MethodSignatureImpl[] _methods;
    private NameSet _xbeanSet;

    static InterfaceExtensionImpl newInstance(JamClassLoader jamClassLoader, NameSet nameSet, Extensionconfig.Interface r5) {
        InterfaceExtensionImpl interfaceExtensionImpl = new InterfaceExtensionImpl();
        interfaceExtensionImpl._xbeanSet = nameSet;
        JClass jClassValidateInterface = validateInterface(jamClassLoader, r5.getName(), r5);
        if (jClassValidateInterface == null) {
            BindingConfigImpl.error("Interface '" + r5.getStaticHandler() + "' not found.", r5);
            return null;
        }
        interfaceExtensionImpl._interfaceClassName = jClassValidateInterface.getQualifiedName();
        String staticHandler = r5.getStaticHandler();
        interfaceExtensionImpl._delegateToClassName = staticHandler;
        JClass jClassValidateClass = validateClass(jamClassLoader, staticHandler, r5);
        if (jClassValidateClass == null) {
            BindingConfigImpl.warning("Handler class '" + r5.getStaticHandler() + "' not found on classpath, skip validation.", r5);
            return interfaceExtensionImpl;
        }
        if (interfaceExtensionImpl.validateMethods(jClassValidateInterface, jClassValidateClass, r5)) {
            return interfaceExtensionImpl;
        }
        return null;
    }

    private static JClass validateInterface(JamClassLoader jamClassLoader, String str, XmlObject xmlObject) {
        return validateJava(jamClassLoader, str, true, xmlObject);
    }

    static JClass validateClass(JamClassLoader jamClassLoader, String str, XmlObject xmlObject) {
        return validateJava(jamClassLoader, str, false, xmlObject);
    }

    static JClass validateJava(JamClassLoader jamClassLoader, String str, boolean z, XmlObject xmlObject) {
        if (jamClassLoader == null) {
            return null;
        }
        String str2 = z ? "Interface" : "Class";
        JClass jClassLoadClass = jamClassLoader.loadClass(str);
        if (jClassLoadClass == null || jClassLoadClass.isUnresolvedType()) {
            BindingConfigImpl.error(str2 + " '" + str + "' not found.", xmlObject);
            return null;
        }
        if ((z && !jClassLoadClass.isInterface()) || (!z && jClassLoadClass.isInterface())) {
            BindingConfigImpl.error("'" + str + "' must be " + (z ? "an interface" : "a class") + ".", xmlObject);
        }
        if (!jClassLoadClass.isPublic()) {
            BindingConfigImpl.error(str2 + " '" + str + "' is not public.", xmlObject);
        }
        return jClassLoadClass;
    }

    private boolean validateMethods(JClass jClass, JClass jClass2, XmlObject xmlObject) {
        JMethod[] methods = jClass.getMethods();
        this._methods = new MethodSignatureImpl[methods.length];
        boolean z = true;
        for (int i = 0; i < methods.length; i++) {
            JMethod jMethodValidateMethod = validateMethod(jClass, jClass2, methods[i], xmlObject);
            if (jMethodValidateMethod != null) {
                this._methods[i] = new MethodSignatureImpl(getStaticHandler(), jMethodValidateMethod);
            } else {
                z = false;
            }
        }
        return z;
    }

    private JMethod validateMethod(JClass jClass, JClass jClass2, JMethod jMethod, XmlObject xmlObject) {
        String simpleName = jMethod.getSimpleName();
        JParameter[] parameters = jMethod.getParameters();
        JClass returnType = jMethod.getReturnType();
        int length = parameters.length + 1;
        JClass[] jClassArr = new JClass[length];
        jClassArr[0] = returnType.forName("org.apache.xmlbeans.XmlObject");
        for (int i = 1; i < length; i++) {
            jClassArr[i] = parameters[i - 1].getType();
        }
        JMethod method = getMethod(jClass2, simpleName, jClassArr);
        if (method == null) {
            BindingConfigImpl.error("Handler class '" + jClass2.getQualifiedName() + "' does not contain method " + simpleName + "(" + listTypes(jClassArr) + ")", xmlObject);
            return null;
        }
        JClass[] exceptionTypes = jMethod.getExceptionTypes();
        JClass[] exceptionTypes2 = method.getExceptionTypes();
        if (exceptionTypes2.length != exceptionTypes.length) {
            BindingConfigImpl.error("Handler method '" + jClass2.getQualifiedName() + "." + simpleName + "(" + listTypes(jClassArr) + ")' must declare the same exceptions as the interface method '" + jClass.getQualifiedName() + "." + simpleName + "(" + listTypes(parameters), xmlObject);
            return null;
        }
        for (int i2 = 0; i2 < exceptionTypes2.length; i2++) {
            if (exceptionTypes2[i2] != exceptionTypes[i2]) {
                BindingConfigImpl.error("Handler method '" + jClass2.getQualifiedName() + "." + simpleName + "(" + listTypes(jClassArr) + ")' must declare the same exceptions as the interface method '" + jClass.getQualifiedName() + "." + simpleName + "(" + listTypes(parameters), xmlObject);
                return null;
            }
        }
        if (!method.isPublic() || !method.isStatic()) {
            BindingConfigImpl.error("Method '" + jClass2.getQualifiedName() + "." + simpleName + "(" + listTypes(jClassArr) + ")' must be declared public and static.", xmlObject);
            return null;
        }
        if (returnType.equals(method.getReturnType())) {
            return jMethod;
        }
        BindingConfigImpl.error("Return type for method '" + method.getReturnType() + " " + jClass2.getQualifiedName() + "." + simpleName + "(" + listTypes(jClassArr) + ")' does not match the return type of the interface method :'" + returnType + "'.", xmlObject);
        return null;
    }

    static JMethod getMethod(JClass jClass, String str, JClass[] jClassArr) {
        for (JMethod jMethod : jClass.getMethods()) {
            if (str.equals(jMethod.getSimpleName())) {
                JParameter[] parameters = jMethod.getParameters();
                if (parameters.length == jClassArr.length) {
                    for (int i = 0; i < parameters.length; i++) {
                        parameters[i].getType().equals(jClassArr[i]);
                    }
                    return jMethod;
                }
            }
        }
        return null;
    }

    private static String listTypes(JClass[] jClassArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < jClassArr.length; i++) {
            JClass jClass = jClassArr[i];
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(emitType(jClass));
        }
        return stringBuffer.toString();
    }

    private static String listTypes(JParameter[] jParameterArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < jParameterArr.length; i++) {
            JClass type = jParameterArr[i].getType();
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(emitType(type));
        }
        return stringBuffer.toString();
    }

    public static String emitType(JClass jClass) {
        if (jClass.isArrayType()) {
            return emitType(jClass.getArrayComponentType()) + "[]";
        }
        return jClass.getQualifiedName().replace('$', NameUtil.PERIOD);
    }

    public boolean contains(String str) {
        return this._xbeanSet.contains(str);
    }

    public String getStaticHandler() {
        return this._delegateToClassName;
    }

    public String getInterface() {
        return this._interfaceClassName;
    }

    public InterfaceExtension.MethodSignature[] getMethods() {
        return this._methods;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("  static handler: ");
        stringBuffer.append(this._delegateToClassName).append("\n  interface: ");
        stringBuffer.append(this._interfaceClassName).append("\n  name set: ");
        stringBuffer.append(this._xbeanSet).append("\n");
        for (int i = 0; i < this._methods.length; i++) {
            stringBuffer.append("  method[").append(i).append("]=").append(this._methods[i]).append("\n");
        }
        return stringBuffer.toString();
    }

    static class MethodSignatureImpl implements InterfaceExtension.MethodSignature {
        private final int NOTINITIALIZED = -1;
        private String[] _exceptions;
        private int _hashCode;
        private String _intfName;
        private String _name;
        private String[] _params;
        private String _return;
        private String _signature;

        MethodSignatureImpl(String str, JMethod jMethod) {
            this._hashCode = -1;
            if (str == null || jMethod == null) {
                throw new IllegalArgumentException("Interface: " + str + " method: " + jMethod);
            }
            this._intfName = str;
            this._hashCode = -1;
            this._signature = null;
            this._name = jMethod.getSimpleName();
            this._return = jMethod.getReturnType().getQualifiedName().replace('$', NameUtil.PERIOD);
            JParameter[] parameters = jMethod.getParameters();
            this._params = new String[parameters.length];
            for (int i = 0; i < parameters.length; i++) {
                this._params[i] = parameters[i].getType().getQualifiedName().replace('$', NameUtil.PERIOD);
            }
            JClass[] exceptionTypes = jMethod.getExceptionTypes();
            this._exceptions = new String[exceptionTypes.length];
            for (int i2 = 0; i2 < exceptionTypes.length; i2++) {
                this._exceptions[i2] = exceptionTypes[i2].getQualifiedName().replace('$', NameUtil.PERIOD);
            }
        }

        String getInterfaceName() {
            return this._intfName;
        }

        public String getName() {
            return this._name;
        }

        public String getReturnType() {
            return this._return;
        }

        public String[] getParameterTypes() {
            return this._params;
        }

        public String[] getExceptionTypes() {
            return this._exceptions;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof MethodSignatureImpl)) {
                return false;
            }
            MethodSignatureImpl methodSignatureImpl = (MethodSignatureImpl) obj;
            if (!methodSignatureImpl.getName().equals(getName())) {
                return false;
            }
            String[] parameterTypes = getParameterTypes();
            String[] parameterTypes2 = methodSignatureImpl.getParameterTypes();
            if (parameterTypes2.length != parameterTypes.length) {
                return false;
            }
            for (int i = 0; i < parameterTypes.length; i++) {
                if (!parameterTypes2[i].equals(parameterTypes[i])) {
                    return false;
                }
            }
            return this._intfName.equals(methodSignatureImpl._intfName);
        }

        public int hashCode() {
            int i = this._hashCode;
            if (i != -1) {
                return i;
            }
            int iHashCode = getName().hashCode();
            for (String str : getParameterTypes()) {
                iHashCode = (iHashCode * 19) + str.hashCode();
            }
            int iHashCode2 = iHashCode + (this._intfName.hashCode() * 21);
            this._hashCode = iHashCode2;
            return iHashCode2;
        }

        String getSignature() {
            String str = this._signature;
            if (str != null) {
                return str;
            }
            StringBuffer stringBuffer = new StringBuffer(60);
            stringBuffer.append(this._name).append("(");
            int i = 0;
            while (i < this._params.length) {
                stringBuffer.append(i == 0 ? "" : " ,").append(this._params[i]);
                i++;
            }
            stringBuffer.append(")");
            String string = stringBuffer.toString();
            this._signature = string;
            return string;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(getReturnType()).append(" ").append(getSignature());
            return stringBuffer.toString();
        }
    }
}
