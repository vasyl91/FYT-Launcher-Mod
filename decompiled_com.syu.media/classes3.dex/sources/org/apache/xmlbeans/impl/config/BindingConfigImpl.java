package org.apache.xmlbeans.impl.config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.BindingConfig;
import org.apache.xmlbeans.InterfaceExtension;
import org.apache.xmlbeans.PrePostExtension;
import org.apache.xmlbeans.UserType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.jam.JamClassLoader;
import org.apache.xmlbeans.impl.jam.JamServiceFactory;
import org.apache.xmlbeans.impl.jam.JamServiceParams;
import org.apache.xmlbeans.impl.schema.StscState;
import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument;
import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;
import org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig;
import org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig;
import org.apache.xmlbeans.impl.xb.xmlconfig.Qnametargetenum;
import org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class BindingConfigImpl extends BindingConfig {
    private List _interfaceExtensions;
    private Map _packageMap;
    private Map _packageMapByUriPrefix;
    private List _prePostExtensions;
    private Map _prefixMap;
    private Map _prefixMapByUriPrefix;
    private Map _qnameAttMap;
    private Map _qnameDocTypeMap;
    private Map _qnameElemMap;
    private Map _qnameTypeMap;
    private Map _suffixMap;
    private Map _suffixMapByUriPrefix;
    private Map _userTypes;

    private BindingConfigImpl() {
        this._packageMap = Collections.EMPTY_MAP;
        this._prefixMap = Collections.EMPTY_MAP;
        this._suffixMap = Collections.EMPTY_MAP;
        this._packageMapByUriPrefix = Collections.EMPTY_MAP;
        this._prefixMapByUriPrefix = Collections.EMPTY_MAP;
        this._suffixMapByUriPrefix = Collections.EMPTY_MAP;
        this._qnameTypeMap = Collections.EMPTY_MAP;
        this._qnameDocTypeMap = Collections.EMPTY_MAP;
        this._qnameElemMap = Collections.EMPTY_MAP;
        this._qnameAttMap = Collections.EMPTY_MAP;
        this._interfaceExtensions = new ArrayList();
        this._prePostExtensions = new ArrayList();
        this._userTypes = Collections.EMPTY_MAP;
    }

    public static BindingConfig forConfigDocuments(ConfigDocument.Config[] configArr, File[] fileArr, File[] fileArr2) {
        return new BindingConfigImpl(configArr, fileArr, fileArr2);
    }

    private BindingConfigImpl(ConfigDocument.Config[] configArr, File[] fileArr, File[] fileArr2) {
        this._packageMap = new LinkedHashMap();
        this._prefixMap = new LinkedHashMap();
        this._suffixMap = new LinkedHashMap();
        this._packageMapByUriPrefix = new LinkedHashMap();
        this._prefixMapByUriPrefix = new LinkedHashMap();
        this._suffixMapByUriPrefix = new LinkedHashMap();
        this._qnameTypeMap = new LinkedHashMap();
        this._qnameDocTypeMap = new LinkedHashMap();
        this._qnameElemMap = new LinkedHashMap();
        this._qnameAttMap = new LinkedHashMap();
        this._interfaceExtensions = new ArrayList();
        this._prePostExtensions = new ArrayList();
        this._userTypes = new LinkedHashMap();
        for (ConfigDocument.Config config : configArr) {
            Nsconfig[] namespaceArray = config.getNamespaceArray();
            for (int i = 0; i < namespaceArray.length; i++) {
                recordNamespaceSetting(namespaceArray[i].getUri(), namespaceArray[i].getPackage(), this._packageMap);
                recordNamespaceSetting(namespaceArray[i].getUri(), namespaceArray[i].getPrefix(), this._prefixMap);
                recordNamespaceSetting(namespaceArray[i].getUri(), namespaceArray[i].getSuffix(), this._suffixMap);
                recordNamespacePrefixSetting(namespaceArray[i].getUriprefix(), namespaceArray[i].getPackage(), this._packageMapByUriPrefix);
                recordNamespacePrefixSetting(namespaceArray[i].getUriprefix(), namespaceArray[i].getPrefix(), this._prefixMapByUriPrefix);
                recordNamespacePrefixSetting(namespaceArray[i].getUriprefix(), namespaceArray[i].getSuffix(), this._suffixMapByUriPrefix);
            }
            Qnameconfig[] qnameArray = config.getQnameArray();
            for (int i2 = 0; i2 < qnameArray.length; i2++) {
                List listXgetListValue = qnameArray[i2].xgetTarget().xgetListValue();
                QName name = qnameArray[i2].getName();
                String javaname = qnameArray[i2].getJavaname();
                for (int i3 = 0; i3 < listXgetListValue.size(); i3++) {
                    int iIntValue = ((Qnametargetenum) listXgetListValue.get(i3)).enumValue().intValue();
                    if (iIntValue == 1) {
                        this._qnameTypeMap.put(name, javaname);
                    } else if (iIntValue == 2) {
                        this._qnameDocTypeMap.put(name, javaname);
                    } else if (iIntValue == 3) {
                        this._qnameElemMap.put(name, javaname);
                    } else if (iIntValue == 4) {
                        this._qnameAttMap.put(name, javaname);
                    }
                }
            }
            for (Extensionconfig extensionconfig : config.getExtensionArray()) {
                recordExtensionSetting(fileArr, fileArr2, extensionconfig);
            }
            for (Usertypeconfig usertypeconfig : config.getUsertypeArray()) {
                recordUserTypeSetting(fileArr, fileArr2, usertypeconfig);
            }
        }
        secondPhaseValidation();
    }

    void addInterfaceExtension(InterfaceExtensionImpl interfaceExtensionImpl) {
        if (interfaceExtensionImpl == null) {
            return;
        }
        this._interfaceExtensions.add(interfaceExtensionImpl);
    }

    void addPrePostExtension(PrePostExtensionImpl prePostExtensionImpl) {
        if (prePostExtensionImpl == null) {
            return;
        }
        this._prePostExtensions.add(prePostExtensionImpl);
    }

    void secondPhaseValidation() {
        HashMap map = new HashMap();
        int i = 0;
        for (int i2 = 0; i2 < this._interfaceExtensions.size(); i2++) {
            InterfaceExtensionImpl.MethodSignatureImpl[] methodSignatureImplArr = (InterfaceExtensionImpl.MethodSignatureImpl[]) ((InterfaceExtensionImpl) this._interfaceExtensions.get(i2)).getMethods();
            for (int i3 = 0; i3 < methodSignatureImplArr.length; i3++) {
                InterfaceExtensionImpl.MethodSignatureImpl methodSignatureImpl = methodSignatureImplArr[i3];
                if (map.containsKey(methodSignatureImpl)) {
                    InterfaceExtensionImpl.MethodSignatureImpl methodSignatureImpl2 = (InterfaceExtensionImpl.MethodSignatureImpl) map.get(methodSignatureImplArr[i3]);
                    if (methodSignatureImpl.getReturnType().equals(methodSignatureImpl2.getReturnType())) {
                        return;
                    }
                    error("Colliding methods '" + methodSignatureImpl.getSignature() + "' in interfaces " + methodSignatureImpl.getInterfaceName() + " and " + methodSignatureImpl2.getInterfaceName() + ".", null);
                    return;
                }
                InterfaceExtensionImpl.MethodSignatureImpl methodSignatureImpl3 = methodSignatureImplArr[i3];
                map.put(methodSignatureImpl3, methodSignatureImpl3);
            }
        }
        while (true) {
            if (i >= this._prePostExtensions.size() - 1) {
                return;
            }
            PrePostExtensionImpl prePostExtensionImpl = (PrePostExtensionImpl) this._prePostExtensions.get(i);
            for (int i4 = 1; i4 < this._prePostExtensions.size(); i4++) {
                PrePostExtensionImpl prePostExtensionImpl2 = (PrePostExtensionImpl) this._prePostExtensions.get(i4);
                if (prePostExtensionImpl.hasNameSetIntersection(prePostExtensionImpl2)) {
                    error("The applicable domain for handler '" + prePostExtensionImpl.getHandlerNameForJavaSource() + "' intersects with the one for '" + prePostExtensionImpl2.getHandlerNameForJavaSource() + "'.", null);
                }
            }
            i++;
        }
    }

    private static void recordNamespaceSetting(Object obj, String str, Map map) {
        if (str == null) {
            return;
        }
        if (obj == null) {
            map.put("", str);
            return;
        }
        if ((obj instanceof String) && "##any".equals(obj)) {
            map.put(obj, str);
            return;
        }
        if (obj instanceof List) {
            for (String str2 : (List) obj) {
                if ("##local".equals(str2)) {
                    str2 = "";
                }
                map.put(str2, str);
            }
        }
    }

    private static void recordNamespacePrefixSetting(List list, String str, Map map) {
        if (str == null || list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            map.put(it.next(), str);
        }
    }

    private void recordExtensionSetting(File[] fileArr, File[] fileArr2, Extensionconfig extensionconfig) {
        NameSet nameSet;
        Object obj = extensionconfig.getFor();
        if ((obj instanceof String) && "*".equals(obj)) {
            nameSet = NameSet.EVERYTHING;
        } else if (obj instanceof List) {
            NameSetBuilder nameSetBuilder = new NameSetBuilder();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                nameSetBuilder.add((String) it.next());
            }
            nameSet = nameSetBuilder.toNameSet();
        } else {
            nameSet = null;
        }
        if (nameSet == null) {
            error("Invalid value of attribute 'for' : '" + obj + "'.", extensionconfig);
        }
        Extensionconfig.Interface[] interfaceArray = extensionconfig.getInterfaceArray();
        Extensionconfig.PrePostSet prePostSet = extensionconfig.getPrePostSet();
        if (interfaceArray.length > 0 || prePostSet != null) {
            JamClassLoader jamLoader = getJamLoader(fileArr, fileArr2);
            for (Extensionconfig.Interface r0 : interfaceArray) {
                addInterfaceExtension(InterfaceExtensionImpl.newInstance(jamLoader, nameSet, r0));
            }
            addPrePostExtension(PrePostExtensionImpl.newInstance(jamLoader, nameSet, prePostSet));
        }
    }

    private void recordUserTypeSetting(File[] fileArr, File[] fileArr2, Usertypeconfig usertypeconfig) {
        UserTypeImpl userTypeImplNewInstance = UserTypeImpl.newInstance(getJamLoader(fileArr, fileArr2), usertypeconfig);
        this._userTypes.put(userTypeImplNewInstance.getName(), userTypeImplNewInstance);
    }

    private String lookup(Map map, Map map2, String str) {
        String strLookupByUriPrefix;
        if (str == null) {
            str = "";
        }
        String str2 = (String) map.get(str);
        if (str2 != null) {
            return str2;
        }
        return (map2 == null || (strLookupByUriPrefix = lookupByUriPrefix(map2, str)) == null) ? (String) map.get("##any") : strLookupByUriPrefix;
    }

    private String lookupByUriPrefix(Map map, String str) {
        if (str != null && !map.isEmpty()) {
            String str2 = null;
            for (String str3 : map.keySet()) {
                if (str2 == null || str3.length() >= str2.length()) {
                    if (str.startsWith(str3)) {
                        str2 = str3;
                    }
                }
            }
            if (str2 != null) {
                return (String) map.get(str2);
            }
        }
        return null;
    }

    static void warning(String str, XmlObject xmlObject) {
        StscState.get().error(str, 1, xmlObject);
    }

    static void error(String str, XmlObject xmlObject) {
        StscState.get().error(str, 0, xmlObject);
    }

    public String lookupPackageForNamespace(String str) {
        return lookup(this._packageMap, this._packageMapByUriPrefix, str);
    }

    public String lookupPrefixForNamespace(String str) {
        return lookup(this._prefixMap, this._prefixMapByUriPrefix, str);
    }

    public String lookupSuffixForNamespace(String str) {
        return lookup(this._suffixMap, this._suffixMapByUriPrefix, str);
    }

    public String lookupJavanameForQName(QName qName) {
        String str = (String) this._qnameTypeMap.get(qName);
        return str != null ? str : (String) this._qnameDocTypeMap.get(qName);
    }

    public String lookupJavanameForQName(QName qName, int i) {
        if (i == 1) {
            return (String) this._qnameTypeMap.get(qName);
        }
        if (i == 2) {
            return (String) this._qnameDocTypeMap.get(qName);
        }
        if (i == 3) {
            return (String) this._qnameElemMap.get(qName);
        }
        if (i != 4) {
            return null;
        }
        return (String) this._qnameAttMap.get(qName);
    }

    public UserType lookupUserTypeForQName(QName qName) {
        if (qName == null) {
            return null;
        }
        return (UserType) this._userTypes.get(qName);
    }

    public InterfaceExtension[] getInterfaceExtensions() {
        List list = this._interfaceExtensions;
        return (InterfaceExtension[]) list.toArray(new InterfaceExtension[list.size()]);
    }

    public InterfaceExtension[] getInterfaceExtensions(String str) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this._interfaceExtensions.size(); i++) {
            InterfaceExtensionImpl interfaceExtensionImpl = (InterfaceExtensionImpl) this._interfaceExtensions.get(i);
            if (interfaceExtensionImpl.contains(str)) {
                arrayList.add(interfaceExtensionImpl);
            }
        }
        return (InterfaceExtension[]) arrayList.toArray(new InterfaceExtension[arrayList.size()]);
    }

    public PrePostExtension[] getPrePostExtensions() {
        List list = this._prePostExtensions;
        return (PrePostExtension[]) list.toArray(new PrePostExtension[list.size()]);
    }

    public PrePostExtension getPrePostExtension(String str) {
        for (int i = 0; i < this._prePostExtensions.size(); i++) {
            PrePostExtensionImpl prePostExtensionImpl = (PrePostExtensionImpl) this._prePostExtensions.get(i);
            if (prePostExtensionImpl.contains(str)) {
                return prePostExtensionImpl;
            }
        }
        return null;
    }

    private JamClassLoader getJamLoader(File[] fileArr, File[] fileArr2) {
        JamServiceFactory jamServiceFactory = JamServiceFactory.getInstance();
        JamServiceParams jamServiceParamsCreateServiceParams = jamServiceFactory.createServiceParams();
        jamServiceParamsCreateServiceParams.set14WarningsEnabled(false);
        jamServiceParamsCreateServiceParams.setShowWarnings(false);
        if (fileArr != null) {
            for (File file : fileArr) {
                jamServiceParamsCreateServiceParams.includeSourceFile(file);
            }
        }
        jamServiceParamsCreateServiceParams.addClassLoader(getClass().getClassLoader());
        if (fileArr2 != null) {
            for (File file2 : fileArr2) {
                jamServiceParamsCreateServiceParams.addClasspath(file2);
            }
        }
        try {
            return jamServiceFactory.createService(jamServiceParamsCreateServiceParams).getClassLoader();
        } catch (IOException unused) {
            error("Error when accessing .java files.", null);
            return null;
        }
    }
}
