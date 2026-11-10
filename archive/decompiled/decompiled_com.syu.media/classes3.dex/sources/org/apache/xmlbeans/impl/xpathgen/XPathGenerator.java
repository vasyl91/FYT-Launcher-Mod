package org.apache.xmlbeans.impl.xpathgen;

import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XPathGenerator {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlException */
    /* JADX WARN: Byte code manipulation detected: skipped illegal throws declarations: [org.apache.xmlbeans.impl.xpathgen.XPathGenerationException] */
    public static String generateXPath(XmlCursor xmlCursor, XmlCursor xmlCursor2, NamespaceContext namespaceContext) throws XmlException {
        if (xmlCursor == null) {
            throw new IllegalArgumentException("Null node");
        }
        if (namespaceContext == null) {
            throw new IllegalArgumentException("Null namespace context");
        }
        XmlCursor.TokenType tokenTypeCurrentTokenType = xmlCursor.currentTokenType();
        if (xmlCursor2 != null && xmlCursor.isAtSamePositionAs(xmlCursor2)) {
            return ".";
        }
        int iIntValue = tokenTypeCurrentTokenType.intValue();
        if (iIntValue == 1 || iIntValue == 3) {
            return generateInternal(xmlCursor, xmlCursor2, namespaceContext);
        }
        if (iIntValue == 5) {
            int iCountTextTokens = countTextTokens(xmlCursor);
            xmlCursor.toParent();
            String strGenerateInternal = generateInternal(xmlCursor, xmlCursor2, namespaceContext);
            if (iCountTextTokens == 0) {
                return strGenerateInternal + "/text()";
            }
            return strGenerateInternal + "/text()[position()=" + iCountTextTokens + ']';
        }
        if (iIntValue == 6) {
            QName name = xmlCursor.getName();
            xmlCursor.toParent();
            return generateInternal(xmlCursor, xmlCursor2, namespaceContext) + "/@" + qnameToString(name, namespaceContext);
        }
        if (iIntValue == 7) {
            QName name2 = xmlCursor.getName();
            xmlCursor.toParent();
            String strGenerateInternal2 = generateInternal(xmlCursor, xmlCursor2, namespaceContext);
            String localPart = name2.getLocalPart();
            if (localPart.length() == 0) {
                return strGenerateInternal2 + "/@xmlns";
            }
            return strGenerateInternal2 + "/@xmlns:" + localPart;
        }
        throw new XPathGenerationException("Cannot generate XPath for cursor position: " + tokenTypeCurrentTokenType.toString());
    }

    /* JADX WARN: Byte code manipulation detected: skipped illegal throws declarations: [org.apache.xmlbeans.impl.xpathgen.XPathGenerationException] */
    private static String generateInternal(XmlCursor xmlCursor, XmlCursor xmlCursor2, NamespaceContext namespaceContext) {
        StringBuilder sb;
        StringBuilder sbAppend;
        if (xmlCursor.isStartdoc()) {
            return "";
        }
        if (xmlCursor2 != null && xmlCursor.isAtSamePositionAs(xmlCursor2)) {
            return ".";
        }
        QName name = xmlCursor.getName();
        XmlCursor xmlCursorNewCursor = xmlCursor.newCursor();
        if (!xmlCursor.toParent()) {
            return "/" + name;
        }
        xmlCursor.push();
        if (!xmlCursor.toChild(name)) {
            throw new IllegalStateException("Must have at least one child with name: " + name);
        }
        int i = 0;
        int i2 = 1;
        do {
            if (xmlCursor.isAtSamePositionAs(xmlCursorNewCursor)) {
                i = i2;
            } else {
                i2++;
            }
        } while (xmlCursor.toNextSibling(name));
        xmlCursor.pop();
        xmlCursorNewCursor.dispose();
        String strGenerateInternal = generateInternal(xmlCursor, xmlCursor2, namespaceContext);
        if (i2 == 1) {
            sb = new StringBuilder();
            sbAppend = sb.append(strGenerateInternal).append('/').append(qnameToString(name, namespaceContext));
        } else {
            sb = new StringBuilder();
            sbAppend = sb.append(strGenerateInternal).append('/').append(qnameToString(name, namespaceContext)).append('[').append(i).append(']');
        }
        return sbAppend.toString();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlException */
    /* JADX WARN: Byte code manipulation detected: skipped illegal throws declarations: [org.apache.xmlbeans.impl.xpathgen.XPathGenerationException] */
    private static String qnameToString(QName qName, NamespaceContext namespaceContext) throws XmlException {
        String localPart = qName.getLocalPart();
        String namespaceURI = qName.getNamespaceURI();
        if (namespaceURI.length() == 0) {
            return localPart;
        }
        String prefix = qName.getPrefix();
        if (prefix != null && prefix.length() > 0 && namespaceURI.equals(namespaceContext.getNamespaceURI(prefix))) {
            return prefix + NameUtil.COLON + localPart;
        }
        String prefix2 = namespaceContext.getPrefix(namespaceURI);
        if (prefix2 == null) {
            throw new XPathGenerationException("Could not obtain a prefix for URI: " + namespaceURI);
        }
        if (prefix2.length() == 0) {
            throw new XPathGenerationException("Can not use default prefix in XPath for URI: " + namespaceURI);
        }
        return prefix2 + NameUtil.COLON + localPart;
    }

    private static int countTextTokens(XmlCursor xmlCursor) {
        XmlCursor xmlCursorNewCursor = xmlCursor.newCursor();
        xmlCursor.push();
        xmlCursor.toParent();
        XmlCursor.TokenType firstContentToken = xmlCursor.toFirstContentToken();
        int i = 0;
        int i2 = 0;
        while (!firstContentToken.isEnd()) {
            if (firstContentToken.isText()) {
                if (xmlCursor.comparePosition(xmlCursorNewCursor) > 0) {
                    i++;
                } else {
                    i2++;
                }
            } else if (firstContentToken.isStart()) {
                xmlCursor.toEndToken();
            }
            firstContentToken = xmlCursor.toNextToken();
        }
        xmlCursor.pop();
        if (i == 0) {
            return 0;
        }
        return i2;
    }

    public static void main(String[] strArr) throws XmlException {
        NamespaceContext namespaceContext = new NamespaceContext() { // from class: org.apache.xmlbeans.impl.xpathgen.XPathGenerator.1
            @Override // javax.xml.namespace.NamespaceContext
            public String getPrefix(String str) {
                return null;
            }

            @Override // javax.xml.namespace.NamespaceContext
            public Iterator getPrefixes(String str) {
                return null;
            }

            @Override // javax.xml.namespace.NamespaceContext
            public String getNamespaceURI(String str) {
                if ("ns".equals(str)) {
                    return "http://a.com";
                }
                return null;
            }
        };
        XmlCursor xmlCursorNewCursor = XmlObject.Factory.parse("<root>\n<ns:a xmlns:ns=\"http://a.com\"><b foo=\"value\">text1<c/>text2<c/>text3<c>text</c>text4</b></ns:a>\n</root>").newCursor();
        xmlCursorNewCursor.toFirstContentToken();
        xmlCursorNewCursor.toFirstContentToken();
        xmlCursorNewCursor.toFirstChild();
        xmlCursorNewCursor.toFirstChild();
        xmlCursorNewCursor.push();
        System.out.println(generateXPath(xmlCursorNewCursor, null, namespaceContext));
        xmlCursorNewCursor.pop();
        xmlCursorNewCursor.toNextSibling();
        xmlCursorNewCursor.toNextSibling();
        xmlCursorNewCursor.push();
        System.out.println(generateXPath(xmlCursorNewCursor, null, namespaceContext));
        xmlCursorNewCursor.pop();
        XmlCursor xmlCursorNewCursor2 = xmlCursorNewCursor.newCursor();
        xmlCursorNewCursor2.toParent();
        xmlCursorNewCursor.push();
        System.out.println(generateXPath(xmlCursorNewCursor, xmlCursorNewCursor2, namespaceContext));
        xmlCursorNewCursor.pop();
        xmlCursorNewCursor2.toParent();
        xmlCursorNewCursor.push();
        System.out.println(generateXPath(xmlCursorNewCursor, xmlCursorNewCursor2, namespaceContext));
        xmlCursorNewCursor.pop();
        xmlCursorNewCursor.toFirstContentToken();
        xmlCursorNewCursor.push();
        System.out.println(generateXPath(xmlCursorNewCursor, xmlCursorNewCursor2, namespaceContext));
        xmlCursorNewCursor.pop();
        xmlCursorNewCursor.toParent();
        xmlCursorNewCursor.toPrevToken();
        xmlCursorNewCursor.push();
        System.out.println(generateXPath(xmlCursorNewCursor, xmlCursorNewCursor2, namespaceContext));
        xmlCursorNewCursor.pop();
        xmlCursorNewCursor.toParent();
        xmlCursorNewCursor.push();
        System.out.println(generateXPath(xmlCursorNewCursor, xmlCursorNewCursor2, namespaceContext));
        xmlCursorNewCursor.pop();
        xmlCursorNewCursor.toFirstAttribute();
        xmlCursorNewCursor.push();
        System.out.println(generateXPath(xmlCursorNewCursor, xmlCursorNewCursor2, namespaceContext));
        xmlCursorNewCursor.pop();
        xmlCursorNewCursor.toParent();
        xmlCursorNewCursor.toParent();
        xmlCursorNewCursor.toNextToken();
        xmlCursorNewCursor.push();
        System.out.println(generateXPath(xmlCursorNewCursor, xmlCursorNewCursor2, namespaceContext));
        xmlCursorNewCursor.pop();
        xmlCursorNewCursor.push();
        System.out.println(generateXPath(xmlCursorNewCursor, null, namespaceContext));
        xmlCursorNewCursor.pop();
    }
}
