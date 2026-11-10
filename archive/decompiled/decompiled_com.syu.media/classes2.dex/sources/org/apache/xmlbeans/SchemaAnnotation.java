package org.apache.xmlbeans;

import javax.xml.namespace.QName;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface SchemaAnnotation extends SchemaComponent {

    public interface Attribute {
        QName getName();

        String getValue();

        String getValueUri();
    }

    XmlObject[] getApplicationInformation();

    Attribute[] getAttributes();

    XmlObject[] getUserInformation();
}
