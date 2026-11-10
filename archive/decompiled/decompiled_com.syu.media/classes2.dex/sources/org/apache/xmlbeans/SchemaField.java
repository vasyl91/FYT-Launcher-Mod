package org.apache.xmlbeans;

import java.math.BigInteger;
import javax.xml.namespace.QName;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface SchemaField {
    String getDefaultText();

    XmlAnySimpleType getDefaultValue();

    BigInteger getMaxOccurs();

    BigInteger getMinOccurs();

    QName getName();

    SchemaType getType();

    Object getUserData();

    boolean isAttribute();

    boolean isDefault();

    boolean isFixed();

    boolean isNillable();
}
