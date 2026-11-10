package com.fasterxml.aalto.impl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class ErrorConsts {
    public static String ERR_INTERNAL = "Internal error";
    public static String ERR_NS_EMPTY = "Non-default namespace can not map to empty URI (as per Namespace 1.0 # 2) in XML 1.0 documents";
    public static String ERR_NS_REDECL_XML = "Trying to redeclare prefix 'xml' from its default URI 'http://www.w3.org/XML/1998/namespace' to \"{0}\"";
    public static String ERR_NS_REDECL_XMLNS = "Trying to declare prefix 'xmlns' (illegal as per NS 1.1 #4)";
    public static String ERR_NS_REDECL_XMLNS_URI = "Trying to bind URI 'http://www.w3.org/2000/xmlns/ to prefix \"{0}\" (can not be explicitly bound)";
    public static String ERR_NS_REDECL_XML_URI = "Trying to bind URI 'http://www.w3.org/XML/1998/namespace to prefix \"{0}\" (can only bind to 'xml')";
    public static String ERR_NS_UNDECLARED = "Undeclared namespace prefix \"{0}\"";
    public static String ERR_NS_UNDECLARED_FOR_ATTR = "Undeclared namespace prefix \"{0}\" (for attribute \"{1}\")";
    public static String ERR_NULL_ARG = "Illegal to pass null as argument";
    public static String ERR_STATE_NOT_ELEM = "Current state not START_ELEMENT or END_ELEMENT";
    public static String ERR_STATE_NOT_PI = "Current state not PROCESSING_INSTRUCTION";
    public static String ERR_STATE_NOT_STELEM = "Current state not START_ELEMENT";
    public static String ERR_STATE_NOT_STELEM_OR_TEXT = "Current state not START_ELEMENT, CHARACTERS or CDATA";
    public static String ERR_WF_DUP_ATTRS = "Duplicate attributes \"{0}\" (index {1}), \"{2}\" (index {3})";
    public static String ERR_WF_PI_XML_TARGET = "Illegal processing instruction target: 'xml' (case insensitive) is reserved by the xml specification";
    public static String SUFFIX_IN_EPILOG = " in epilog";
    public static String SUFFIX_IN_PROLOG = " in prolog";
    public static String SUFFIX_IN_TREE = " in xml document";
    public static String VERR_ANY = "Element <{0}> has ANY content specification; can not contain {1}";
    public static String VERR_EMPTY = "Element <{0}> has EMPTY content specification; can not contain {1}";
    public static String VERR_NON_MIXED = "Element <{0}> has non-mixed content specification; can not contain non-white space text, or any CDATA sections";
    public static String WERR_ATTR_NO_ELEM = "Trying to write an attribute when there is no open start element.";
    public static String WERR_CDATA_CONTENT = "Illegal input: CDATA block has embedded ']]>' in it (index {0})";
    public static String WERR_COMMENT_CONTENT = "Illegal input: comment content has embedded '--' in it (index {0})";
    public static String WERR_DUP_XML_DECL = "Can not output XML declaration, after other output has already been done.";
    public static String WERR_NAME_EMPTY = "Illegal to pass empty name";
    public static String WERR_NAME_ILLEGAL_CHAR = "Illegal name character {0}";
    public static String WERR_NAME_ILLEGAL_FIRST_CHAR = "Illegal first name character {0}";
    public static String WERR_NO_ESCAPING = "Illegal input: {0} contains a character (code {1}) that can only be output as character entity";
    public static String WERR_NS_NO_ELEM = "Trying to write a namespace declaration when there is no open start element.";
    public static String WERR_PI_CONTENT = "Illegal input: processing instruction content has embedded '?>' in it (index {0})";
    public static String WERR_PROLOG_CDATA = "Trying to output a CDATA block outside main element tree (in prolog or epilog)";
    public static String WERR_PROLOG_ENTITY = "Trying to output an entity reference outside main element tree (in prolog or epilog)";
    public static String WERR_PROLOG_NO_ROOT = "Trying to write END_DOCUMENT when document has no root (ie. trying to output empty document).";
    public static String WERR_PROLOG_SECOND_ROOT = "Trying to output second root, <{0}>";
    public static String WERR_SPACE_CONTENT = "Illegal input: SPACE content has a non-whitespace character (code {0}) in it (index {1})";
    public static String WT_ATTR_DECL = "attribute declaration";
    public static String WT_DT_DECL = "doctype declaration";
    public static String WT_ELEM_DECL = "element declaration";
    public static String WT_ENT_DECL = "entity declaration";
    public static String WT_NS_DECL = "namespace declaration";
    public static String WT_VALIDATION = "schema validation";
    public static String WT_XML_DECL = "xml declaration";
    public static String W_MIXED_ENCODINGS = "Inconsistent text encoding; declared as \"{0}\" in xml declaration, application had passed \"{1}\"";

    public static String tokenTypeDesc(int i) {
        switch (i) {
            case 1:
                return "START_ELEMENT";
            case 2:
                return "END_ELEMENT";
            case 3:
                return "PROCESSING_INSTRUCTION";
            case 4:
                return "CHARACTERS";
            case 5:
                return "COMMENT";
            case 6:
                return "SPACE";
            case 7:
                return "START_DOCUMENT";
            case 8:
                return "END_DOCUMENT";
            case 9:
                return "ENTITY_REFERENCE";
            case 10:
            default:
                return "[" + i + "]";
            case 11:
                return "DTD";
            case 12:
                return "CDATA";
        }
    }

    public static void throwInternalError() {
        throwInternalError(null);
    }

    public static void throwInternalError(String str) {
        throw new RuntimeException(str != null ? "Internal error: " + str : "Internal error");
    }
}
