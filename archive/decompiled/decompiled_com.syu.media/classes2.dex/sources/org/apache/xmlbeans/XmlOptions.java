package org.apache.xmlbeans;

import java.io.Serializable;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import org.xml.sax.EntityResolver;
import org.xml.sax.XMLReader;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XmlOptions implements Serializable {
    public static final String BASE_URI = "BASE_URI";
    public static final String CHARACTER_ENCODING = "CHARACTER_ENCODING";
    public static final String COMPILE_DOWNLOAD_URLS = "COMPILE_DOWNLOAD_URLS";
    public static final String COMPILE_MDEF_NAMESPACES = "COMPILE_MDEF_NAMESPACES";
    public static final String COMPILE_NO_ANNOTATIONS = "COMPILE_NO_ANNOTATIONS";
    public static final String COMPILE_NO_PVR_RULE = "COMPILE_NO_PVR_RULE";
    public static final String COMPILE_NO_UPA_RULE = "COMPILE_NO_UPA_RULE";
    public static final String COMPILE_NO_VALIDATION = "COMPILE_NO_VALIDATION";
    public static final String COMPILE_SUBSTITUTE_NAMES = "COMPILE_SUBSTITUTE_NAMES";
    public static final String COPY_USE_NEW_SYNC_DOMAIN = "COPY_USE_NEW_LOCALE";
    public static final int DEFAULT_ENTITY_EXPANSION_LIMIT = 2048;
    public static final String DOCUMENT_SOURCE_NAME = "DOCUMENT_SOURCE_NAME";
    public static final String DOCUMENT_TYPE = "DOCUMENT_TYPE";
    private static final XmlOptions EMPTY_OPTIONS;
    public static final String ENTITY_EXPANSION_LIMIT = "ENTITY_EXPANSION_LIMIT";
    public static final String ENTITY_RESOLVER = "ENTITY_RESOLVER";
    public static final String ERROR_LISTENER = "ERROR_LISTENER";
    public static final String GENERATE_JAVA_14 = "1.4";
    public static final String GENERATE_JAVA_15 = "1.5";
    public static final String GENERATE_JAVA_VERSION = "GENERATE_JAVA_VERSION";
    public static final String LOAD_ADDITIONAL_NAMESPACES = "LOAD_ADDITIONAL_NAMESPACES";
    public static final String LOAD_DTD_GRAMMAR = "LOAD_DTD_GRAMMAR";
    public static final String LOAD_ENTITY_BYTES_LIMIT = "LOAD_ENTITY_BYTES_LIMIT";
    public static final String LOAD_EXTERNAL_DTD = "LOAD_EXTERNAL_DTD";
    public static final String LOAD_LINE_NUMBERS = "LOAD_LINE_NUMBERS";
    public static final String LOAD_LINE_NUMBERS_END_ELEMENT = "LOAD_LINE_NUMBERS_END_ELEMENT";
    public static final String LOAD_MESSAGE_DIGEST = "LOAD_MESSAGE_DIGEST";
    public static final String LOAD_REPLACE_DOCUMENT_ELEMENT = "LOAD_REPLACE_DOCUMENT_ELEMENT";
    public static final String LOAD_SAVE_CDATA_BOOKMARKS = "LOAD_SAVE_CDATA_BOOKMARKS";
    public static final String LOAD_STRIP_COMMENTS = "LOAD_STRIP_COMMENTS";
    public static final String LOAD_STRIP_PROCINSTS = "LOAD_STRIP_PROCINSTS";
    public static final String LOAD_STRIP_WHITESPACE = "LOAD_STRIP_WHITESPACE";
    public static final String LOAD_SUBSTITUTE_NAMESPACES = "LOAD_SUBSTITUTE_NAMESPACES";
    public static final String LOAD_TRIM_TEXT_BUFFER = "LOAD_TRIM_TEXT_BUFFER";
    public static final String LOAD_USE_DEFAULT_RESOLVER = "LOAD_USE_DEFAULT_RESOLVER";
    public static final String LOAD_USE_XMLREADER = "LOAD_USE_XMLREADER";
    public static final String SAVE_AGGRESSIVE_NAMESPACES = "SAVE_AGGRESSIVE_NAMESPACES";
    public static final String SAVE_CDATA_ENTITY_COUNT_THRESHOLD = "SAVE_CDATA_ENTITY_COUNT_THRESHOLD";
    public static final String SAVE_CDATA_LENGTH_THRESHOLD = "SAVE_CDATA_LENGTH_THRESHOLD";
    public static final String SAVE_FILTER_PROCINST = "SAVE_FILTER_PROCINST";
    public static final String SAVE_IMPLICIT_NAMESPACES = "SAVE_IMPLICIT_NAMESPACES";
    public static final String SAVE_INNER = "SAVE_INNER";
    public static final String SAVE_NAMESPACES_FIRST = "SAVE_NAMESPACES_FIRST";
    public static final String SAVE_NO_XML_DECL = "SAVE_NO_XML_DECL";
    public static final String SAVE_OPTIMIZE_FOR_SPEED = "SAVE_OPTIMIZE_FOR_SPEED";
    public static final String SAVE_OUTER = "SAVE_OUTER";
    public static final String SAVE_PRETTY_PRINT = "SAVE_PRETTY_PRINT";
    public static final String SAVE_PRETTY_PRINT_INDENT = "SAVE_PRETTY_PRINT_INDENT";
    public static final String SAVE_PRETTY_PRINT_OFFSET = "SAVE_PRETTY_PRINT_OFFSET";
    public static final String SAVE_SAX_NO_NSDECLS_IN_ATTRIBUTES = "SAVE_SAX_NO_NSDECLS_IN_ATTRIBUTES";
    public static final String SAVE_SUBSTITUTE_CHARACTERS = "SAVE_SUBSTITUTE_CHARACTERS";
    public static final String SAVE_SUGGESTED_PREFIXES = "SAVE_SUGGESTED_PREFIXES";
    public static final String SAVE_SYNTHETIC_DOCUMENT_ELEMENT = "SAVE_SYNTHETIC_DOCUMENT_ELEMENT";
    public static final String SAVE_USE_DEFAULT_NAMESPACE = "SAVE_USE_DEFAULT_NAMESPACE";
    public static final String SAVE_USE_OPEN_FRAGMENT = "SAVE_USE_OPEN_FRAGMENT";
    public static final String SCHEMA_CODE_PRINTER = "SCHEMA_CODE_PRINTER";
    public static final String UNSYNCHRONIZED = "UNSYNCHRONIZED";
    public static final String VALIDATE_ON_SET = "VALIDATE_ON_SET";
    public static final String VALIDATE_STRICT = "VALIDATE_STRICT";
    public static final String VALIDATE_TEXT_ONLY = "VALIDATE_TEXT_ONLY";
    public static final String VALIDATE_TREAT_LAX_AS_SKIP = "VALIDATE_TREAT_LAX_AS_SKIP";
    public static final String XQUERY_CURRENT_NODE_VAR = "XQUERY_CURRENT_NODE_VAR";
    public static final String XQUERY_VARIABLE_MAP = "XQUERY_VARIABLE_MAP";
    private static final long serialVersionUID = 1;
    private Map _map;

    public XmlOptions() {
        this._map = new HashMap();
    }

    public XmlOptions(XmlOptions xmlOptions) {
        HashMap map = new HashMap();
        this._map = map;
        if (xmlOptions != null) {
            map.putAll(xmlOptions._map);
        }
    }

    public XmlOptions setSaveNamespacesFirst() {
        return set(SAVE_NAMESPACES_FIRST);
    }

    public XmlOptions setSavePrettyPrint() {
        return set(SAVE_PRETTY_PRINT);
    }

    public XmlOptions setSavePrettyPrintIndent(int i) {
        return set(SAVE_PRETTY_PRINT_INDENT, i);
    }

    public XmlOptions setSavePrettyPrintOffset(int i) {
        return set(SAVE_PRETTY_PRINT_OFFSET, i);
    }

    public XmlOptions setCharacterEncoding(String str) {
        return set(CHARACTER_ENCODING, str);
    }

    public XmlOptions setDocumentType(SchemaType schemaType) {
        return set(DOCUMENT_TYPE, schemaType);
    }

    public XmlOptions setErrorListener(Collection collection) {
        return set(ERROR_LISTENER, collection);
    }

    public XmlOptions setSaveAggressiveNamespaces() {
        return set(SAVE_AGGRESSIVE_NAMESPACES);
    }

    public XmlOptions setSaveAggresiveNamespaces() {
        return setSaveAggressiveNamespaces();
    }

    public XmlOptions setSaveSyntheticDocumentElement(QName qName) {
        return set(SAVE_SYNTHETIC_DOCUMENT_ELEMENT, qName);
    }

    public XmlOptions setUseDefaultNamespace() {
        return set(SAVE_USE_DEFAULT_NAMESPACE);
    }

    public XmlOptions setSaveImplicitNamespaces(Map map) {
        return set(SAVE_IMPLICIT_NAMESPACES, map);
    }

    public XmlOptions setSaveSuggestedPrefixes(Map map) {
        return set(SAVE_SUGGESTED_PREFIXES, map);
    }

    public XmlOptions setSaveFilterProcinst(String str) {
        return set(SAVE_FILTER_PROCINST, str);
    }

    public XmlOptions setSaveSubstituteCharacters(XmlOptionCharEscapeMap xmlOptionCharEscapeMap) {
        return set(SAVE_SUBSTITUTE_CHARACTERS, xmlOptionCharEscapeMap);
    }

    public XmlOptions setSaveUseOpenFrag() {
        return set(SAVE_USE_OPEN_FRAGMENT);
    }

    public XmlOptions setSaveOuter() {
        return set(SAVE_OUTER);
    }

    public XmlOptions setSaveInner() {
        return set(SAVE_INNER);
    }

    public XmlOptions setSaveNoXmlDecl() {
        return set(SAVE_NO_XML_DECL);
    }

    public XmlOptions setSaveCDataLengthThreshold(int i) {
        return set(SAVE_CDATA_LENGTH_THRESHOLD, i);
    }

    public XmlOptions setSaveCDataEntityCountThreshold(int i) {
        return set(SAVE_CDATA_ENTITY_COUNT_THRESHOLD, i);
    }

    public XmlOptions setUseCDataBookmarks() {
        return set(LOAD_SAVE_CDATA_BOOKMARKS);
    }

    public XmlOptions setSaveSaxNoNSDeclsInAttributes() {
        return set(SAVE_SAX_NO_NSDECLS_IN_ATTRIBUTES);
    }

    public XmlOptions setLoadReplaceDocumentElement(QName qName) {
        return set(LOAD_REPLACE_DOCUMENT_ELEMENT, qName);
    }

    public XmlOptions setLoadStripWhitespace() {
        return set(LOAD_STRIP_WHITESPACE);
    }

    public XmlOptions setLoadStripComments() {
        return set(LOAD_STRIP_COMMENTS);
    }

    public XmlOptions setLoadStripProcinsts() {
        return set(LOAD_STRIP_PROCINSTS);
    }

    public XmlOptions setLoadLineNumbers() {
        return set(LOAD_LINE_NUMBERS);
    }

    public XmlOptions setLoadLineNumbers(String str) {
        return setLoadLineNumbers().set(str);
    }

    public XmlOptions setLoadSubstituteNamespaces(Map map) {
        return set(LOAD_SUBSTITUTE_NAMESPACES, map);
    }

    public XmlOptions setLoadTrimTextBuffer() {
        return set(LOAD_TRIM_TEXT_BUFFER);
    }

    public XmlOptions setLoadAdditionalNamespaces(Map map) {
        return set(LOAD_ADDITIONAL_NAMESPACES, map);
    }

    public XmlOptions setLoadMessageDigest() {
        return set(LOAD_MESSAGE_DIGEST);
    }

    public XmlOptions setLoadUseDefaultResolver() {
        return set(LOAD_USE_DEFAULT_RESOLVER);
    }

    public XmlOptions setLoadUseXMLReader(XMLReader xMLReader) {
        return set(LOAD_USE_XMLREADER, xMLReader);
    }

    public XmlOptions setXqueryCurrentNodeVar(String str) {
        return set(XQUERY_CURRENT_NODE_VAR, str);
    }

    public XmlOptions setXqueryVariables(Map map) {
        return set(XQUERY_VARIABLE_MAP, map);
    }

    public XmlOptions setDocumentSourceName(String str) {
        return set(DOCUMENT_SOURCE_NAME, str);
    }

    public XmlOptions setCompileSubstituteNames(Map map) {
        return set(COMPILE_SUBSTITUTE_NAMES, map);
    }

    public XmlOptions setCompileNoValidation() {
        return set(COMPILE_NO_VALIDATION);
    }

    public XmlOptions setCompileNoUpaRule() {
        return set(COMPILE_NO_UPA_RULE);
    }

    public XmlOptions setCompileNoPvrRule() {
        return set(COMPILE_NO_PVR_RULE);
    }

    public XmlOptions setCompileNoAnnotations() {
        return set(COMPILE_NO_ANNOTATIONS);
    }

    public XmlOptions setCompileDownloadUrls() {
        return set(COMPILE_DOWNLOAD_URLS);
    }

    public XmlOptions setCompileMdefNamespaces(Set set) {
        return set(COMPILE_MDEF_NAMESPACES, set);
    }

    public XmlOptions setValidateOnSet() {
        return set(VALIDATE_ON_SET);
    }

    public XmlOptions setValidateTreatLaxAsSkip() {
        return set(VALIDATE_TREAT_LAX_AS_SKIP);
    }

    public XmlOptions setValidateStrict() {
        return set(VALIDATE_STRICT);
    }

    public XmlOptions setUnsynchronized() {
        return set(UNSYNCHRONIZED);
    }

    public XmlOptions setEntityResolver(EntityResolver entityResolver) {
        return set(ENTITY_RESOLVER, entityResolver);
    }

    public XmlOptions setBaseURI(URI uri) {
        return set(BASE_URI, uri);
    }

    public XmlOptions setSchemaCodePrinter(SchemaCodePrinter schemaCodePrinter) {
        return set(SCHEMA_CODE_PRINTER, schemaCodePrinter);
    }

    public XmlOptions setGenerateJavaVersion(String str) {
        return set(GENERATE_JAVA_VERSION, str);
    }

    public XmlOptions setCopyUseNewSynchronizationDomain(boolean z) {
        return set(COPY_USE_NEW_SYNC_DOMAIN, Boolean.valueOf(z));
    }

    public XmlOptions setLoadEntityBytesLimit(int i) {
        return set(LOAD_ENTITY_BYTES_LIMIT, i);
    }

    public XmlOptions setEntityExpansionLimit(int i) {
        return set(ENTITY_EXPANSION_LIMIT, i);
    }

    public XmlOptions setLoadDTDGrammar(boolean z) {
        return set(LOAD_DTD_GRAMMAR, Boolean.valueOf(z));
    }

    public XmlOptions setLoadExternalDTD(boolean z) {
        return set(LOAD_EXTERNAL_DTD, Boolean.valueOf(z));
    }

    static {
        XmlOptions xmlOptions = new XmlOptions();
        EMPTY_OPTIONS = xmlOptions;
        xmlOptions._map = Collections.unmodifiableMap(xmlOptions._map);
    }

    public static XmlOptions maskNull(XmlOptions xmlOptions) {
        return xmlOptions == null ? EMPTY_OPTIONS : xmlOptions;
    }

    public void put(Object obj) {
        put(obj, (Object) null);
    }

    public void put(Object obj, Object obj2) {
        this._map.put(obj, obj2);
    }

    public void put(Object obj, int i) {
        put(obj, new Integer(i));
    }

    private XmlOptions set(Object obj) {
        return set(obj, (Object) null);
    }

    private XmlOptions set(Object obj, Object obj2) {
        this._map.put(obj, obj2);
        return this;
    }

    private XmlOptions set(Object obj, int i) {
        return set(obj, new Integer(i));
    }

    public boolean hasOption(Object obj) {
        return this._map.containsKey(obj);
    }

    public static boolean hasOption(XmlOptions xmlOptions, Object obj) {
        if (xmlOptions == null) {
            return false;
        }
        return xmlOptions.hasOption(obj);
    }

    public Object get(Object obj) {
        return this._map.get(obj);
    }

    public void remove(Object obj) {
        this._map.remove(obj);
    }

    public static Object safeGet(XmlOptions xmlOptions, Object obj) {
        if (xmlOptions == null) {
            return null;
        }
        return xmlOptions.get(obj);
    }
}
