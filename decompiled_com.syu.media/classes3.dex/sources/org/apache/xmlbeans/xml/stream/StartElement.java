package org.apache.xmlbeans.xml.stream;

import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface StartElement extends XMLEvent {
    Attribute getAttributeByName(XMLName xMLName);

    AttributeIterator getAttributes();

    AttributeIterator getAttributesAndNamespaces();

    Map getNamespaceMap();

    String getNamespaceUri(String str);

    AttributeIterator getNamespaces();
}
