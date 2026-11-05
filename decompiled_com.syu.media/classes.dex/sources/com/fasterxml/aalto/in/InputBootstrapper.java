package com.fasterxml.aalto.in;

import chip.FinalChip;
import com.fasterxml.aalto.WFCException;
import com.fasterxml.aalto.util.XmlConsts;
import java.io.IOException;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public abstract class InputBootstrapper implements XmlConsts {
    public static final String ERR_XMLDECL_END_MARKER = "; expected \"?>\" end marker";
    public static final String ERR_XMLDECL_EXP_ATTRVAL = "; expected a quote character enclosing value for ";
    public static final String ERR_XMLDECL_EXP_EQ = "; expected '=' after ";
    public static final String ERR_XMLDECL_EXP_SPACE = "; expected a white space";
    public static final String ERR_XMLDECL_KW_ENCODING = "; expected keyword 'encoding'";
    public static final String ERR_XMLDECL_KW_STANDALONE = "; expected keyword 'standalone'";
    public static final String ERR_XMLDECL_KW_VERSION = "; expected keyword 'version'";
    final ReaderConfig _config;
    protected int _inputProcessed = 0;
    protected int _inputRow = 0;
    protected int _inputRowStart = 0;
    int mDeclaredXmlVersion = 0;
    String mFoundEncoding;
    final char[] mKeyword;
    String mStandalone;

    public abstract XmlScanner bootstrap() throws XMLStreamException;

    protected abstract int checkKeyword(String str) throws XMLStreamException, IOException;

    protected abstract Location getLocation();

    protected abstract int getNext() throws XMLStreamException, IOException;

    protected abstract int getNextAfterWs(boolean z) throws XMLStreamException, IOException;

    protected abstract void pushback();

    protected abstract int readQuotedValue(char[] cArr, int i) throws XMLStreamException, IOException;

    protected InputBootstrapper(ReaderConfig readerConfig) {
        this._config = readerConfig;
        this.mKeyword = readerConfig.allocSmallCBuffer(60);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void readXmlDeclaration() throws XMLStreamException, IOException {
        int nextAfterWs = getNextAfterWs(false);
        if (nextAfterWs != 118) {
            reportUnexpectedChar(nextAfterWs, ERR_XMLDECL_KW_VERSION);
        } else {
            this.mDeclaredXmlVersion = readXmlVersion();
            nextAfterWs = getWsOrChar(63);
        }
        if (nextAfterWs == 101) {
            this.mFoundEncoding = readXmlEncoding();
            nextAfterWs = getWsOrChar(63);
        }
        if (nextAfterWs == 115) {
            this.mStandalone = readXmlStandalone();
            nextAfterWs = getWsOrChar(63);
        }
        if (nextAfterWs != 63) {
            reportUnexpectedChar(nextAfterWs, ERR_XMLDECL_END_MARKER);
        }
        int next = getNext();
        if (next != 62) {
            reportUnexpectedChar(next, ERR_XMLDECL_END_MARKER);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private final int readXmlVersion() throws XMLStreamException, IOException {
        String str;
        int iCheckKeyword = checkKeyword(XmlConsts.XML_DECL_KW_VERSION);
        if (iCheckKeyword != 0) {
            reportUnexpectedChar(iCheckKeyword, XmlConsts.XML_DECL_KW_VERSION);
        }
        int quotedValue = readQuotedValue(this.mKeyword, handleEq(XmlConsts.XML_DECL_KW_VERSION));
        if (quotedValue == 3) {
            char[] cArr = this.mKeyword;
            if (cArr[0] == '1' && cArr[1] == '.') {
                char c = cArr[2];
                if (c == '0') {
                    return 256;
                }
                if (c == '1') {
                    return 272;
                }
            }
        }
        if (quotedValue < 0) {
            str = "'" + new String(this.mKeyword) + "[..]'";
        } else {
            str = quotedValue == 0 ? "<empty>" : "'" + new String(this.mKeyword, 0, quotedValue) + "'";
        }
        reportPseudoAttrProblem(XmlConsts.XML_DECL_KW_VERSION, str, "1.0", XmlConsts.XML_V_11_STR);
        return 0;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private final String readXmlEncoding() throws XMLStreamException, IOException {
        int iCheckKeyword = checkKeyword(XmlConsts.XML_DECL_KW_ENCODING);
        if (iCheckKeyword != 0) {
            reportUnexpectedChar(iCheckKeyword, XmlConsts.XML_DECL_KW_ENCODING);
        }
        int quotedValue = readQuotedValue(this.mKeyword, handleEq(XmlConsts.XML_DECL_KW_ENCODING));
        if (quotedValue == 0) {
            reportPseudoAttrProblem(XmlConsts.XML_DECL_KW_ENCODING, null, null, null);
        }
        if (quotedValue < 0) {
            return new String(this.mKeyword);
        }
        return new String(this.mKeyword, 0, quotedValue);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private final String readXmlStandalone() throws XMLStreamException, IOException {
        String str;
        int iCheckKeyword = checkKeyword(XmlConsts.XML_DECL_KW_STANDALONE);
        if (iCheckKeyword != 0) {
            reportUnexpectedChar(iCheckKeyword, XmlConsts.XML_DECL_KW_STANDALONE);
        }
        int quotedValue = readQuotedValue(this.mKeyword, handleEq(XmlConsts.XML_DECL_KW_STANDALONE));
        if (quotedValue == 2) {
            char[] cArr = this.mKeyword;
            if (cArr[0] == 'n' && cArr[1] == 'o') {
                return XmlConsts.XML_SA_NO;
            }
        } else if (quotedValue == 3) {
            char[] cArr2 = this.mKeyword;
            if (cArr2[0] == 'y' && cArr2[1] == 'e' && cArr2[2] == 's') {
                return XmlConsts.XML_SA_YES;
            }
        }
        if (quotedValue < 0) {
            str = "'" + new String(this.mKeyword) + "[..]'";
        } else {
            str = quotedValue == 0 ? "<empty>" : "'" + new String(this.mKeyword, 0, quotedValue) + "'";
        }
        reportPseudoAttrProblem(XmlConsts.XML_DECL_KW_STANDALONE, str, XmlConsts.XML_SA_YES, XmlConsts.XML_SA_NO);
        return str;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private final int handleEq(String str) throws XMLStreamException, IOException {
        int nextAfterWs = getNextAfterWs(false);
        if (nextAfterWs != 61) {
            reportUnexpectedChar(nextAfterWs, "; expected '=' after '" + str + "'");
        }
        int nextAfterWs2 = getNextAfterWs(false);
        if (nextAfterWs2 != 34 && nextAfterWs2 != 39) {
            reportUnexpectedChar(nextAfterWs2, "; expected a quote character enclosing value for '" + str + "'");
        }
        return nextAfterWs2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private final int getWsOrChar(int i) throws XMLStreamException, IOException {
        int next = getNext();
        if (next == i) {
            return next;
        }
        if (next > 32) {
            reportUnexpectedChar(next, "; expected either '" + ((char) i) + "' or white space");
        }
        if (next == 10 || next == 13) {
            pushback();
        }
        return getNextAfterWs(false);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportXmlProblem(String str) throws XMLStreamException {
        throw new WFCException(str, getLocation());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportNull() throws XMLStreamException {
        reportXmlProblem("Illegal null byte/char in input stream");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportEof() throws XMLStreamException {
        reportXmlProblem("Unexpected end-of-input in xml declaration");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportUnexpectedChar(int i, String str) throws XMLStreamException {
        String str2;
        char c = (char) i;
        if (Character.isISOControl(c)) {
            str2 = "Unexpected character (CTRL-CHAR, code " + i + ")" + str;
        } else {
            str2 = "Unexpected character '" + c + "' (code " + i + ")" + str;
        }
        reportXmlProblem(str2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final void reportPseudoAttrProblem(String str, String str2, String str3, String str4) throws XMLStreamException {
        String str5 = str3 == null ? FinalChip.BSP_PLATFORM_Null : "; expected \"" + str3 + "\" or \"" + str4 + "\"";
        if (str2 == null || str2.length() == 0) {
            reportXmlProblem("Missing XML pseudo-attribute '" + str + "' value" + str5);
        }
        reportXmlProblem("Invalid XML pseudo-attribute '" + str + "' value " + str2 + str5);
    }
}
