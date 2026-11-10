package org.apache.xmlbeans;

import java.math.BigInteger;
import javax.xml.namespace.QName;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface SchemaProperty {
    public static final int CONSISTENTLY = 2;
    public static final int JAVA_BIG_DECIMAL = 8;
    public static final int JAVA_BIG_INTEGER = 9;
    public static final int JAVA_BOOLEAN = 1;
    public static final int JAVA_BYTE = 4;
    public static final int JAVA_BYTE_ARRAY = 11;
    public static final int JAVA_CALENDAR = 17;
    public static final int JAVA_DATE = 14;
    public static final int JAVA_DOUBLE = 3;
    public static final int JAVA_ENUM = 18;
    public static final int JAVA_FIRST_PRIMITIVE = 1;
    public static final int JAVA_FLOAT = 2;
    public static final int JAVA_GDATE = 12;
    public static final int JAVA_GDURATION = 13;
    public static final int JAVA_INT = 6;
    public static final int JAVA_LAST_PRIMITIVE = 7;
    public static final int JAVA_LIST = 16;
    public static final int JAVA_LONG = 7;
    public static final int JAVA_OBJECT = 19;
    public static final int JAVA_QNAME = 15;
    public static final int JAVA_SHORT = 5;
    public static final int JAVA_STRING = 10;
    public static final int JAVA_USER = 20;
    public static final int NEVER = 0;
    public static final int VARIABLE = 1;
    public static final int XML_OBJECT = 0;

    QName[] acceptedNames();

    boolean extendsJavaArray();

    boolean extendsJavaOption();

    boolean extendsJavaSingleton();

    SchemaType getContainerType();

    String getDefaultText();

    XmlAnySimpleType getDefaultValue();

    String getJavaPropertyName();

    QNameSet getJavaSetterDelimiter();

    int getJavaTypeCode();

    BigInteger getMaxOccurs();

    BigInteger getMinOccurs();

    QName getName();

    SchemaType getType();

    int hasDefault();

    int hasFixed();

    int hasNillable();

    boolean isAttribute();

    boolean isReadOnly();

    SchemaType javaBasedOnType();
}
