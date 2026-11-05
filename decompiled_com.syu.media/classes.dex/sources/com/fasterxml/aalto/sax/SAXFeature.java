package com.fasterxml.aalto.sax;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public enum SAXFeature {
    EXTERNAL_GENERAL_ENTITIES("external-general-entities"),
    EXTERNAL_PARAMETER_ENTITIES("external-parameter-entities"),
    IS_STANDALONE("is-standalone"),
    LEXICAL_HANDLER_PARAMETER_ENTITIES("lexical-handler/parameter-entities"),
    NAMESPACES("namespaces"),
    NAMESPACE_PREFIXES("namespace-prefixes"),
    RESOLVE_DTD_URIS("resolve-dtd-uris"),
    STRING_INTERNING("string-interning"),
    UNICODE_NORMALIZATION_CHECKING("unicode-normalization-checking"),
    USE_ATTRIBUTES2("use-attributes2"),
    USE_LOCATOR2("use-locator2"),
    USE_ENTITY_RESOLVER2("use-entity-resolver2"),
    VALIDATION("validation"),
    XMLNS_URIS("xmlns-uris"),
    XML_1_1("xml-1.1");

    public static final String STD_FEATURE_PREFIX = "http://xml.org/sax/features/";
    private final String mSuffix;

    SAXFeature(String str) {
        this.mSuffix = str;
    }

    public String getSuffix() {
        return this.mSuffix;
    }

    public String toExternal() {
        return STD_FEATURE_PREFIX + this.mSuffix;
    }
}
