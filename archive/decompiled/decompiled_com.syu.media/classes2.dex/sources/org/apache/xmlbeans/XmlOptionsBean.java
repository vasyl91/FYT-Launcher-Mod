package org.apache.xmlbeans;

import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import org.xml.sax.EntityResolver;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XmlOptionsBean extends XmlOptions {
    public XmlOptionsBean() {
    }

    public XmlOptionsBean(XmlOptions xmlOptions) {
        super(xmlOptions);
    }

    public void setSaveNamespacesFirst(boolean z) {
        if (z) {
            super.setSaveNamespacesFirst();
        } else {
            remove(XmlOptions.SAVE_NAMESPACES_FIRST);
        }
    }

    public boolean isSaveNamespacesFirst() {
        return hasOption(XmlOptions.SAVE_NAMESPACES_FIRST);
    }

    public void setSavePrettyPrint(boolean z) {
        if (z) {
            super.setSavePrettyPrint();
        } else {
            remove(XmlOptions.SAVE_PRETTY_PRINT);
        }
    }

    public boolean isSavePrettyPrint() {
        return hasOption(XmlOptions.SAVE_PRETTY_PRINT);
    }

    public Integer getSavePrettyPrintIndent() {
        return (Integer) get(XmlOptions.SAVE_PRETTY_PRINT_INDENT);
    }

    public Integer getSavePrettyPrintOffset() {
        return (Integer) get(XmlOptions.SAVE_PRETTY_PRINT_OFFSET);
    }

    public String getCharacterEncoding() {
        return (String) get(XmlOptions.CHARACTER_ENCODING);
    }

    public SchemaType getDocumentType() {
        return (SchemaType) get(XmlOptions.DOCUMENT_TYPE);
    }

    public void setSaveAggressiveNamespaces(boolean z) {
        if (z) {
            super.setSaveAggressiveNamespaces();
        } else {
            remove(XmlOptions.SAVE_AGGRESSIVE_NAMESPACES);
        }
    }

    public boolean isSaveAggressiveNamespaces() {
        return hasOption(XmlOptions.SAVE_AGGRESSIVE_NAMESPACES);
    }

    public QName getSaveSyntheticDocumentElement() {
        return (QName) get(XmlOptions.SAVE_SYNTHETIC_DOCUMENT_ELEMENT);
    }

    public void setUseDefaultNamespace(boolean z) {
        if (z) {
            super.setUseDefaultNamespace();
        } else {
            remove(XmlOptions.SAVE_USE_DEFAULT_NAMESPACE);
        }
    }

    public boolean isUseDefaultNamespace() {
        return hasOption(XmlOptions.SAVE_USE_DEFAULT_NAMESPACE);
    }

    public Map getSaveImplicitNamespaces() {
        return (Map) get(XmlOptions.SAVE_IMPLICIT_NAMESPACES);
    }

    public Map getSaveSuggestedPrefixes() {
        return (Map) get(XmlOptions.SAVE_SUGGESTED_PREFIXES);
    }

    public String getSaveFilterProcinst() {
        return (String) get(XmlOptions.SAVE_FILTER_PROCINST);
    }

    public XmlOptionCharEscapeMap getSaveSubstituteCharacters() {
        return (XmlOptionCharEscapeMap) get(XmlOptions.SAVE_SUBSTITUTE_CHARACTERS);
    }

    public void setSaveUseOpenFrag(boolean z) {
        if (z) {
            super.setSaveUseOpenFrag();
        } else {
            remove(XmlOptions.SAVE_USE_OPEN_FRAGMENT);
        }
    }

    public boolean isSaveUseOpenFrag() {
        return hasOption(XmlOptions.SAVE_USE_OPEN_FRAGMENT);
    }

    public void setSaveOuter(boolean z) {
        if (z) {
            super.setSaveOuter();
        } else {
            remove(XmlOptions.SAVE_OUTER);
        }
    }

    public boolean isSaveOuter() {
        return hasOption(XmlOptions.SAVE_OUTER);
    }

    public void setSaveInner(boolean z) {
        if (z) {
            super.setSaveInner();
        } else {
            remove(XmlOptions.SAVE_INNER);
        }
    }

    public boolean isSaveInner() {
        return hasOption(XmlOptions.SAVE_INNER);
    }

    public void setSaveNoXmlDecl(boolean z) {
        if (z) {
            super.setSaveNoXmlDecl();
        } else {
            remove(XmlOptions.SAVE_NO_XML_DECL);
        }
    }

    public boolean isSaveNoXmlDecl() {
        return hasOption(XmlOptions.SAVE_NO_XML_DECL);
    }

    public Integer getSaveCDataLengthThreshold() {
        return (Integer) get(XmlOptions.SAVE_CDATA_LENGTH_THRESHOLD);
    }

    public Integer getSaveCDataEntityCountThreshold() {
        return (Integer) get(XmlOptions.SAVE_CDATA_ENTITY_COUNT_THRESHOLD);
    }

    public void setSaveSaxNoNSDeclsInAttributes(boolean z) {
        if (z) {
            super.setSaveSaxNoNSDeclsInAttributes();
        } else {
            remove(XmlOptions.SAVE_SAX_NO_NSDECLS_IN_ATTRIBUTES);
        }
    }

    public boolean isSaveSaxNoNSDeclsInAttributes() {
        return hasOption(XmlOptions.SAVE_SAX_NO_NSDECLS_IN_ATTRIBUTES);
    }

    public QName getLoadReplaceDocumentElement() {
        return (QName) get(XmlOptions.LOAD_REPLACE_DOCUMENT_ELEMENT);
    }

    public void setLoadStripWhitespace(boolean z) {
        if (z) {
            super.setLoadStripWhitespace();
        } else {
            remove(XmlOptions.LOAD_STRIP_WHITESPACE);
        }
    }

    public boolean isSetLoadStripWhitespace() {
        return hasOption(XmlOptions.LOAD_STRIP_WHITESPACE);
    }

    public void setLoadStripComments(boolean z) {
        if (z) {
            super.setLoadStripComments();
        } else {
            remove(XmlOptions.LOAD_STRIP_COMMENTS);
        }
    }

    public boolean isLoadStripComments() {
        return hasOption(XmlOptions.LOAD_STRIP_COMMENTS);
    }

    public void setLoadStripProcinsts(boolean z) {
        if (z) {
            super.setLoadStripProcinsts();
        } else {
            remove(XmlOptions.LOAD_STRIP_PROCINSTS);
        }
    }

    public boolean isLoadStripProcinsts() {
        return hasOption(XmlOptions.LOAD_STRIP_PROCINSTS);
    }

    public void setLoadLineNumbers(boolean z) {
        if (z) {
            super.setLoadLineNumbers();
        } else {
            remove(XmlOptions.LOAD_LINE_NUMBERS);
        }
    }

    public boolean isLoadLineNumbers() {
        return hasOption(XmlOptions.LOAD_LINE_NUMBERS);
    }

    public Map getLoadSubstituteNamespaces() {
        return (Map) get(XmlOptions.LOAD_SUBSTITUTE_NAMESPACES);
    }

    public void setLoadTrimTextBuffer(boolean z) {
        if (z) {
            super.setLoadTrimTextBuffer();
        } else {
            remove(XmlOptions.LOAD_TRIM_TEXT_BUFFER);
        }
    }

    public boolean isLoadTrimTextBuffer() {
        return hasOption(XmlOptions.LOAD_TRIM_TEXT_BUFFER);
    }

    public Map getLoadAdditionalNamespaces() {
        return (Map) get(XmlOptions.LOAD_ADDITIONAL_NAMESPACES);
    }

    public void setLoadMessageDigest(boolean z) {
        if (z) {
            super.setLoadMessageDigest();
        } else {
            remove(XmlOptions.LOAD_MESSAGE_DIGEST);
        }
    }

    public boolean isLoadMessageDigest() {
        return hasOption(XmlOptions.LOAD_MESSAGE_DIGEST);
    }

    public void setLoadUseDefaultResolver(boolean z) {
        if (z) {
            super.setLoadUseDefaultResolver();
        } else {
            remove(XmlOptions.LOAD_USE_DEFAULT_RESOLVER);
        }
    }

    public boolean isLoadUseDefaultResolver() {
        return hasOption(XmlOptions.LOAD_USE_DEFAULT_RESOLVER);
    }

    public String getXqueryCurrentNodeVar() {
        return (String) get(XmlOptions.XQUERY_CURRENT_NODE_VAR);
    }

    public Map getXqueryVariables() {
        return (Map) get(XmlOptions.XQUERY_VARIABLE_MAP);
    }

    public String getDocumentSourceName() {
        return (String) get(XmlOptions.DOCUMENT_SOURCE_NAME);
    }

    public Map getCompileSubstituteNames() {
        return (Map) get(XmlOptions.COMPILE_SUBSTITUTE_NAMES);
    }

    public void setCompileNoUpaRule(boolean z) {
        if (z) {
            super.setCompileNoUpaRule();
        } else {
            remove(XmlOptions.COMPILE_NO_UPA_RULE);
        }
    }

    public boolean isCompileNoUpaRule() {
        return hasOption(XmlOptions.COMPILE_NO_UPA_RULE);
    }

    public void setCompileNoPvrRule(boolean z) {
        if (z) {
            super.setCompileNoPvrRule();
        } else {
            remove(XmlOptions.COMPILE_NO_PVR_RULE);
        }
    }

    public boolean isCompileNoPvrRule() {
        return hasOption(XmlOptions.COMPILE_NO_PVR_RULE);
    }

    public void setCompileNoAnnotations(boolean z) {
        if (z) {
            super.setCompileNoAnnotations();
        } else {
            remove(XmlOptions.COMPILE_NO_ANNOTATIONS);
        }
    }

    public boolean isCompileNoAnnotations() {
        return hasOption(XmlOptions.COMPILE_NO_ANNOTATIONS);
    }

    public void setCompileDownloadUrls(boolean z) {
        if (z) {
            super.setCompileDownloadUrls();
        } else {
            remove(XmlOptions.COMPILE_DOWNLOAD_URLS);
        }
    }

    public boolean isCompileDownloadUrls() {
        return hasOption(XmlOptions.COMPILE_DOWNLOAD_URLS);
    }

    public Set getCompileMdefNamespaces() {
        return (Set) get(XmlOptions.COMPILE_MDEF_NAMESPACES);
    }

    public void setValidateOnSet(boolean z) {
        if (z) {
            super.setValidateOnSet();
        } else {
            remove(XmlOptions.VALIDATE_ON_SET);
        }
    }

    public boolean isValidateOnSet() {
        return hasOption(XmlOptions.VALIDATE_ON_SET);
    }

    public void setValidateTreatLaxAsSkip(boolean z) {
        if (z) {
            super.setValidateTreatLaxAsSkip();
        } else {
            remove(XmlOptions.VALIDATE_TREAT_LAX_AS_SKIP);
        }
    }

    public boolean isValidateTreatLaxAsSkip() {
        return hasOption(XmlOptions.VALIDATE_TREAT_LAX_AS_SKIP);
    }

    public void setValidateStrict(boolean z) {
        if (z) {
            super.setValidateStrict();
        } else {
            remove(XmlOptions.VALIDATE_STRICT);
        }
    }

    public boolean isValidateStrict() {
        return hasOption(XmlOptions.VALIDATE_STRICT);
    }

    public void setUnsynchronized(boolean z) {
        if (z) {
            super.setUnsynchronized();
        } else {
            remove(XmlOptions.UNSYNCHRONIZED);
        }
    }

    public boolean isUnsynchronized() {
        return hasOption(XmlOptions.UNSYNCHRONIZED);
    }

    public EntityResolver getEntityResolver() {
        return (EntityResolver) get(XmlOptions.ENTITY_RESOLVER);
    }

    public String getGenerateJavaVersion() {
        return (String) get(XmlOptions.GENERATE_JAVA_VERSION);
    }

    public int getEntityExpansionLimit() {
        Integer num = (Integer) get(XmlOptions.ENTITY_EXPANSION_LIMIT);
        if (num == null) {
            return 2048;
        }
        return num.intValue();
    }

    public boolean isLoadDTDGrammar() {
        Boolean bool = (Boolean) get(XmlOptions.LOAD_DTD_GRAMMAR);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isLoadExternalDTD() {
        Boolean bool = (Boolean) get(XmlOptions.LOAD_EXTERNAL_DTD);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
