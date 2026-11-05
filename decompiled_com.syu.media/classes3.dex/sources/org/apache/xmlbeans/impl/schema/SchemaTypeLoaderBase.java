package org.apache.xmlbeans.impl.schema;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlFactoryHook;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlSaxHandler;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.store.Locale;
import org.apache.xmlbeans.impl.validator.ValidatingXMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class SchemaTypeLoaderBase implements SchemaTypeLoader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String USER_AGENT = "XMLBeans/" + XmlBeans.getVersion() + " (" + XmlBeans.getTitle() + ")";
    private static final Method _pathCompiler = getMethod("org.apache.xmlbeans.impl.store.Path", "compilePath", new Class[]{String.class, XmlOptions.class});
    private static final Method _queryCompiler = getMethod("org.apache.xmlbeans.impl.store.Query", "compileQuery", new Class[]{String.class, XmlOptions.class});

    private static Method getMethod(String str, String str2, Class[] clsArr) {
        try {
            return Class.forName(str).getDeclaredMethod(str2, clsArr);
        } catch (Exception unused) {
            throw new IllegalStateException("Cannot find " + str + "." + str2 + ".  verify that xmlstore (from xbean.jar) is on classpath");
        }
    }

    private static Object invokeMethod(Method method, Object[] objArr) {
        try {
            return method.invoke(method, objArr);
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        } catch (Exception e2) {
            IllegalStateException illegalStateException2 = new IllegalStateException(e2.getMessage());
            illegalStateException2.initCause(e2);
            throw illegalStateException2;
        }
    }

    private static String doCompilePath(String str, XmlOptions xmlOptions) {
        return (String) invokeMethod(_pathCompiler, new Object[]{str, xmlOptions});
    }

    private static String doCompileQuery(String str, XmlOptions xmlOptions) {
        return (String) invokeMethod(_queryCompiler, new Object[]{str, xmlOptions});
    }

    public SchemaType findType(QName qName) {
        SchemaType.Ref refFindTypeRef = findTypeRef(qName);
        if (refFindTypeRef == null) {
            return null;
        }
        return refFindTypeRef.get();
    }

    public SchemaType findDocumentType(QName qName) {
        SchemaType.Ref refFindDocumentTypeRef = findDocumentTypeRef(qName);
        if (refFindDocumentTypeRef == null) {
            return null;
        }
        return refFindDocumentTypeRef.get();
    }

    public SchemaType findAttributeType(QName qName) {
        SchemaType.Ref refFindAttributeTypeRef = findAttributeTypeRef(qName);
        if (refFindAttributeTypeRef == null) {
            return null;
        }
        return refFindAttributeTypeRef.get();
    }

    public SchemaModelGroup findModelGroup(QName qName) {
        SchemaModelGroup.Ref refFindModelGroupRef = findModelGroupRef(qName);
        if (refFindModelGroupRef == null) {
            return null;
        }
        return refFindModelGroupRef.get();
    }

    public SchemaAttributeGroup findAttributeGroup(QName qName) {
        SchemaAttributeGroup.Ref refFindAttributeGroupRef = findAttributeGroupRef(qName);
        if (refFindAttributeGroupRef == null) {
            return null;
        }
        return refFindAttributeGroupRef.get();
    }

    public SchemaGlobalElement findElement(QName qName) {
        SchemaGlobalElement.Ref refFindElementRef = findElementRef(qName);
        if (refFindElementRef == null) {
            return null;
        }
        return refFindElementRef.get();
    }

    public SchemaGlobalAttribute findAttribute(QName qName) {
        SchemaGlobalAttribute.Ref refFindAttributeRef = findAttributeRef(qName);
        if (refFindAttributeRef == null) {
            return null;
        }
        return refFindAttributeRef.get();
    }

    public XmlObject newInstance(SchemaType schemaType, XmlOptions xmlOptions) {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (hook != null) {
            return hook.newInstance(this, schemaType, xmlOptions);
        }
        return Locale.newInstance(this, schemaType, xmlOptions);
    }

    public XmlObject parse(String str, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (hook != null) {
            return hook.parse(this, str, schemaType, xmlOptions);
        }
        return Locale.parseToXmlObject(this, str, schemaType, xmlOptions);
    }

    public XmlObject parse(XMLInputStream xMLInputStream, SchemaType schemaType, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (hook != null) {
            return hook.parse(this, xMLInputStream, schemaType, xmlOptions);
        }
        return Locale.parseToXmlObject(this, xMLInputStream, schemaType, xmlOptions);
    }

    public XmlObject parse(XMLStreamReader xMLStreamReader, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (hook != null) {
            return hook.parse(this, xMLStreamReader, schemaType, xmlOptions);
        }
        return Locale.parseToXmlObject(this, xMLStreamReader, schemaType, xmlOptions);
    }

    public XmlObject parse(File file, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException {
        if (xmlOptions == null) {
            xmlOptions = new XmlOptions();
            xmlOptions.put("DOCUMENT_SOURCE_NAME", file.toURI().normalize().toString());
        } else if (!xmlOptions.hasOption("DOCUMENT_SOURCE_NAME")) {
            XmlOptions xmlOptions2 = new XmlOptions(xmlOptions);
            xmlOptions2.put("DOCUMENT_SOURCE_NAME", file.toURI().normalize().toString());
            xmlOptions = xmlOptions2;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return parse(fileInputStream, schemaType, xmlOptions);
        } finally {
            fileInputStream.close();
        }
    }

    public XmlObject parse(URL url, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException {
        InputStream inputStream;
        URLConnection uRLConnectionOpenConnection;
        if (xmlOptions == null) {
            xmlOptions = new XmlOptions();
            xmlOptions.put("DOCUMENT_SOURCE_NAME", url.toString());
        } else if (!xmlOptions.hasOption("DOCUMENT_SOURCE_NAME")) {
            XmlOptions xmlOptions2 = new XmlOptions(xmlOptions);
            xmlOptions2.put("DOCUMENT_SOURCE_NAME", url.toString());
            xmlOptions = xmlOptions2;
        }
        int i = 0;
        boolean z = false;
        do {
            inputStream = null;
            try {
                uRLConnectionOpenConnection = url.openConnection();
                uRLConnectionOpenConnection.addRequestProperty("User-Agent", USER_AGENT);
                uRLConnectionOpenConnection.addRequestProperty("Accept", "application/xml, text/xml, */*");
                if (uRLConnectionOpenConnection instanceof HttpURLConnection) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                    int responseCode = httpURLConnection.getResponseCode();
                    boolean z2 = responseCode == 301 || responseCode == 302;
                    if (z2 && i > 5) {
                        z2 = false;
                    }
                    if (z2) {
                        String headerField = httpURLConnection.getHeaderField("Location");
                        if (headerField == null) {
                            z = false;
                        } else {
                            url = new URL(headerField);
                            i++;
                            z = z2;
                        }
                    } else {
                        z = z2;
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } while (z);
        inputStream = uRLConnectionOpenConnection.getInputStream();
        XmlObject xmlObject = parse(inputStream, schemaType, xmlOptions);
        if (inputStream != null) {
            inputStream.close();
        }
        return xmlObject;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlException */
    public XmlObject parse(InputStream inputStream, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException {
        DigestInputStream digestInputStream;
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (xmlOptions == null || !xmlOptions.hasOption("LOAD_MESSAGE_DIGEST")) {
            digestInputStream = null;
        } else {
            try {
                digestInputStream = new DigestInputStream(inputStream, MessageDigest.getInstance("SHA"));
                inputStream = digestInputStream;
            } catch (NoSuchAlgorithmException unused) {
                digestInputStream = null;
            }
        }
        if (hook != null) {
            return hook.parse(this, inputStream, schemaType, xmlOptions);
        }
        XmlObject toXmlObject = Locale.parseToXmlObject(this, inputStream, schemaType, xmlOptions);
        if (digestInputStream != null) {
            toXmlObject.documentProperties().setMessageDigest(digestInputStream.getMessageDigest().digest());
        }
        return toXmlObject;
    }

    public XmlObject parse(Reader reader, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (hook != null) {
            return hook.parse(this, reader, schemaType, xmlOptions);
        }
        return Locale.parseToXmlObject(this, reader, schemaType, xmlOptions);
    }

    public XmlObject parse(Node node, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (hook != null) {
            return hook.parse(this, node, schemaType, xmlOptions);
        }
        return Locale.parseToXmlObject(this, node, schemaType, xmlOptions);
    }

    public XmlSaxHandler newXmlSaxHandler(SchemaType schemaType, XmlOptions xmlOptions) {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (hook != null) {
            return hook.newXmlSaxHandler(this, schemaType, xmlOptions);
        }
        return Locale.newSaxHandler(this, schemaType, xmlOptions);
    }

    public DOMImplementation newDomImplementation(XmlOptions xmlOptions) {
        return Locale.newDomImplementation(this, xmlOptions);
    }

    public XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, SchemaType schemaType, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
        return new ValidatingXMLInputStream(xMLInputStream, this, schemaType, xmlOptions);
    }

    public String compilePath(String str) {
        return compilePath(str, null);
    }

    public String compilePath(String str, XmlOptions xmlOptions) {
        return doCompilePath(str, xmlOptions);
    }

    public String compileQuery(String str) {
        return compileQuery(str, null);
    }

    public String compileQuery(String str, XmlOptions xmlOptions) {
        return doCompileQuery(str, xmlOptions);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0154  */
    /* JADX WARN: Code duplicated, block: B:110:0x0177  */
    /* JADX WARN: Code duplicated, block: B:113:0x0186  */
    /* JADX WARN: Code duplicated, block: B:156:0x00cb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:158:0x010a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:161:0x0139 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:162:0x0138 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:163:0x0147 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x0185 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:176:0x01c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00c3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:66:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:78:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:81:0x010b  */
    /* JADX WARN: Code duplicated, block: B:88:0x0128 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:89:0x012a  */
    /* JADX WARN: Code duplicated, block: B:94:0x013f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:95:0x0141  */
    /* JADX WARN: Code duplicated, block: B:98:0x0148  */
    public SchemaType typeForSignature(String str) {
        String strSubstring;
        SchemaGlobalAttribute schemaGlobalAttributeFindAttribute;
        SchemaType[] anonymousTypes;
        int i;
        SchemaField containerField;
        SchemaGlobalElement schemaGlobalElementFindElement;
        SchemaType[] anonymousTypes2;
        int i2;
        SchemaField containerField2;
        int iIndexOf = str.indexOf(64);
        if (iIndexOf < 0) {
            iIndexOf = str.length();
            strSubstring = "";
        } else {
            strSubstring = str.substring(iIndexOf + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 < iIndexOf) {
            int iIndexOf2 = str.indexOf(58, i3);
            int iIndexOf3 = str.indexOf(124, i3);
            if (iIndexOf2 < 0 || (iIndexOf3 >= 0 && iIndexOf2 >= iIndexOf3)) {
                iIndexOf2 = iIndexOf3;
            }
            if (iIndexOf2 < 0 || iIndexOf2 > iIndexOf) {
                iIndexOf2 = iIndexOf;
            }
            arrayList.add(str.substring(i3, iIndexOf2));
            i3 = iIndexOf2 + 1;
        }
        SchemaType type = null;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            String str2 = (String) arrayList.get(size);
            if (str2.length() < 1) {
                throw new IllegalArgumentException();
            }
            int i4 = (str2.length() < 2 || str2.charAt(1) != '=') ? 1 : 2;
            char cCharAt = str2.charAt(0);
            if (cCharAt == 'I') {
                if (type == null) {
                    throw new IllegalArgumentException();
                }
                if (type.getSimpleVariety() != 3) {
                    return null;
                }
                SchemaType[] anonymousTypes3 = type.getAnonymousTypes();
                if (anonymousTypes3.length != 1) {
                    return null;
                }
                type = anonymousTypes3[0];
            } else if (cCharAt == 'M') {
                if (type == null) {
                    throw new IllegalArgumentException();
                }
                try {
                    int i5 = Integer.parseInt(str2.substring(i4));
                    if (type.getSimpleVariety() != 2) {
                        return null;
                    }
                    SchemaType[] anonymousTypes4 = type.getAnonymousTypes();
                    if (anonymousTypes4.length <= i5) {
                        return null;
                    }
                    type = anonymousTypes4[i5];
                } catch (Exception unused) {
                    throw new IllegalArgumentException();
                }
            } else if (cCharAt == 'Q') {
                if (type != null) {
                    if (type.isSimpleType()) {
                        return null;
                    }
                    anonymousTypes = type.getAnonymousTypes();
                    String strSubstring2 = str2.substring(i4);
                    for (i = 0; i < anonymousTypes.length; i++) {
                        containerField = anonymousTypes[i].getContainerField();
                        if (containerField == null && containerField.isAttribute() && containerField.getName().getLocalPart().equals(strSubstring2)) {
                            type = anonymousTypes[i];
                        }
                    }
                    return null;
                }
                schemaGlobalAttributeFindAttribute = findAttribute(QNameHelper.forLNS(str2.substring(i4), strSubstring));
                if (schemaGlobalAttributeFindAttribute == null) {
                    return null;
                }
                type = schemaGlobalAttributeFindAttribute.getType();
            } else if (cCharAt == 'R') {
                if (type == null) {
                    throw new IllegalArgumentException();
                }
                type = findAttributeType(QNameHelper.forLNS(str2.substring(i4), strSubstring));
                if (type == null) {
                    return null;
                }
            } else if (cCharAt == 'T') {
                if (type != null) {
                    throw new IllegalArgumentException();
                }
                type = findType(QNameHelper.forLNS(str2.substring(i4), strSubstring));
                if (type == null) {
                    return null;
                }
            } else if (cCharAt == 'U') {
                if (type != null) {
                    if (type.getContentType() < 3) {
                        return null;
                    }
                    anonymousTypes2 = type.getAnonymousTypes();
                    String strSubstring3 = str2.substring(i4);
                    while (i2 < anonymousTypes2.length) {
                        containerField2 = anonymousTypes2[i2].getContainerField();
                        if (containerField2 == null) {
                        }
                    }
                    return null;
                }
                schemaGlobalElementFindElement = findElement(QNameHelper.forLNS(str2.substring(i4), strSubstring));
                if (schemaGlobalElementFindElement == null) {
                    return null;
                }
                type = schemaGlobalElementFindElement.getType();
            } else {
                switch (cCharAt) {
                    case 'A':
                        if (type != null) {
                            if (type.isSimpleType()) {
                                return null;
                            }
                            anonymousTypes = type.getAnonymousTypes();
                            String strSubstring4 = str2.substring(i4);
                            while (i < anonymousTypes.length) {
                                containerField = anonymousTypes[i].getContainerField();
                                if (containerField == null) {
                                }
                            }
                            return null;
                        }
                        schemaGlobalAttributeFindAttribute = findAttribute(QNameHelper.forLNS(str2.substring(i4), strSubstring));
                        if (schemaGlobalAttributeFindAttribute == null) {
                            return null;
                        }
                        type = schemaGlobalAttributeFindAttribute.getType();
                        break;
                        break;
                    case 'B':
                        if (type == null) {
                            throw new IllegalArgumentException();
                        }
                        if (type.getSimpleVariety() != 1) {
                            return null;
                        }
                        SchemaType[] anonymousTypes5 = type.getAnonymousTypes();
                        if (anonymousTypes5.length != 1) {
                            return null;
                        }
                        type = anonymousTypes5[0];
                        break;
                        break;
                    case 'C':
                        if (type == null) {
                            throw new IllegalArgumentException();
                        }
                        type = findAttributeType(QNameHelper.forLNS(str2.substring(i4), strSubstring));
                        if (type == null) {
                            return null;
                        }
                        break;
                        break;
                    case 'D':
                        if (type != null) {
                            throw new IllegalArgumentException();
                        }
                        type = findDocumentType(QNameHelper.forLNS(str2.substring(i4), strSubstring));
                        if (type == null) {
                            return null;
                        }
                        break;
                        break;
                    case 'E':
                        if (type != null) {
                            if (type.getContentType() < 3) {
                                return null;
                            }
                            anonymousTypes2 = type.getAnonymousTypes();
                            String strSubstring5 = str2.substring(i4);
                            for (i2 = 0; i2 < anonymousTypes2.length; i2++) {
                                containerField2 = anonymousTypes2[i2].getContainerField();
                                if (containerField2 == null && !containerField2.isAttribute() && containerField2.getName().getLocalPart().equals(strSubstring5)) {
                                    type = anonymousTypes2[i2];
                                }
                                break;
                            }
                            return null;
                        }
                        schemaGlobalElementFindElement = findElement(QNameHelper.forLNS(str2.substring(i4), strSubstring));
                        if (schemaGlobalElementFindElement == null) {
                            return null;
                        }
                        type = schemaGlobalElementFindElement.getType();
                        break;
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        }
        return type;
    }
}
