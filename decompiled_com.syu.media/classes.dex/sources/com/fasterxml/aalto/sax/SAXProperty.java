package com.fasterxml.aalto.sax;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public enum SAXProperty {
    DECLARATION_HANDLER("declaration-handler"),
    DOCUMENT_XML_VERSION("document-xml-version"),
    DOM_NODE("dom-node"),
    LEXICAL_HANDLER("lexical-handler"),
    XML_STRING("xml-string");

    public static final String STD_PROPERTY_PREFIX = "http://xml.org/sax/properties/";
    private final String mSuffix;

    SAXProperty(String str) {
        this.mSuffix = str;
    }

    public String getSuffix() {
        return this.mSuffix;
    }

    public String toExternal() {
        return STD_PROPERTY_PREFIX + this.mSuffix;
    }
}
