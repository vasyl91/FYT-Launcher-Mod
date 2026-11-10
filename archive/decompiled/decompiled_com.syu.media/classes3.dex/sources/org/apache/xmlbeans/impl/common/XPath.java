package org.apache.xmlbeans.impl.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlException;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XPath {
    public static final String _DEFAULT_ELT_NS = "$xmlbeans!default_uri";
    public static final String _NS_BOUNDARY = "$xmlbeans!ns_boundary";
    private final boolean _sawDeepDot;
    private final Selector _selector;

    public static class XPathCompileException extends XmlException {
        XPathCompileException(XmlError xmlError) {
            super(xmlError.toString(), (Throwable) null, xmlError);
        }
    }

    public static class ExecutionContext {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final int ATTRS = 4;
        public static final int DESCEND = 2;
        public static final int HIT = 1;
        private PathContext[] _paths;
        private ArrayList _stack = new ArrayList();
        private XPath _xpath;

        public final void init(XPath xPath) {
            int i = 0;
            if (this._xpath != xPath) {
                this._xpath = xPath;
                this._paths = new PathContext[xPath._selector._paths.length];
                int i2 = 0;
                while (true) {
                    PathContext[] pathContextArr = this._paths;
                    if (i2 >= pathContextArr.length) {
                        break;
                    }
                    pathContextArr[i2] = new PathContext();
                    i2++;
                }
            }
            this._stack.clear();
            while (true) {
                PathContext[] pathContextArr2 = this._paths;
                if (i >= pathContextArr2.length) {
                    return;
                }
                pathContextArr2[i].init(xPath._selector._paths[i]);
                i++;
            }
        }

        public final int start() {
            int i = 0;
            int iStart = 0;
            while (true) {
                PathContext[] pathContextArr = this._paths;
                if (i >= pathContextArr.length) {
                    return iStart;
                }
                iStart |= pathContextArr[i].start();
                i++;
            }
        }

        public final int element(QName qName) {
            this._stack.add(qName);
            int i = 0;
            int iElement = 0;
            while (true) {
                PathContext[] pathContextArr = this._paths;
                if (i >= pathContextArr.length) {
                    return iElement;
                }
                iElement |= pathContextArr[i].element(qName);
                i++;
            }
        }

        public final boolean attr(QName qName) {
            int i = 0;
            boolean zAttr = false;
            while (true) {
                PathContext[] pathContextArr = this._paths;
                if (i >= pathContextArr.length) {
                    return zAttr;
                }
                zAttr |= pathContextArr[i].attr(qName);
                i++;
            }
        }

        public final void end() {
            ArrayList arrayList = this._stack;
            arrayList.remove(arrayList.size() - 1);
            int i = 0;
            while (true) {
                PathContext[] pathContextArr = this._paths;
                if (i >= pathContextArr.length) {
                    return;
                }
                pathContextArr[i].end();
                i++;
            }
        }

        private final class PathContext {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            private Step _curr;
            private List _prev = new ArrayList();

            PathContext() {
            }

            void init(Step step) {
                this._curr = step;
                this._prev.clear();
            }

            private QName top(int i) {
                return (QName) ExecutionContext.this._stack.get((ExecutionContext.this._stack.size() - 1) - i);
            }

            private void backtrack() {
                if (this._curr._hasBacktrack) {
                    this._curr = this._curr._backtrack;
                    return;
                }
                this._curr = this._curr._prev;
                while (!this._curr._deep) {
                    Step step = this._curr;
                    int i = 0;
                    while (!step._deep) {
                        int i2 = i + 1;
                        if (!step.match(top(i))) {
                            this._curr = this._curr._prev;
                        } else {
                            step = step._prev;
                            i = i2;
                        }
                    }
                    return;
                }
            }

            int start() {
                if (this._curr._name != null) {
                    return this._curr._flags;
                }
                this._curr = null;
                return 1;
            }

            int element(QName qName) {
                this._prev.add(this._curr);
                Step step = this._curr;
                if (step == null) {
                    return 0;
                }
                if (!step._attr && this._curr.match(qName)) {
                    Step step2 = this._curr._next;
                    this._curr = step2;
                    if (step2._name != null) {
                        return this._curr._flags;
                    }
                    backtrack();
                    Step step3 = this._curr;
                    if (step3 == null) {
                        return 1;
                    }
                    return 1 | step3._flags;
                }
                do {
                    backtrack();
                    Step step4 = this._curr;
                    if (step4 == null) {
                        return 0;
                    }
                    if (step4.match(qName)) {
                        this._curr = this._curr._next;
                        break;
                    }
                } while (!this._curr._deep);
                return this._curr._flags;
            }

            boolean attr(QName qName) {
                Step step = this._curr;
                if (step != null && step._attr && this._curr.match(qName)) {
                    return true;
                }
                return ExecutionContext.$assertionsDisabled;
            }

            void end() {
                List list = this._prev;
                this._curr = (Step) list.remove(list.size() - 1);
            }
        }
    }

    /* JADX WARN: Byte code manipulation detected: skipped illegal throws declarations: [org.apache.xmlbeans.impl.common.XPath$XPathCompileException] */
    public static XPath compileXPath(String str) {
        return compileXPath(str, "$this", null);
    }

    /* JADX WARN: Byte code manipulation detected: skipped illegal throws declarations: [org.apache.xmlbeans.impl.common.XPath$XPathCompileException] */
    public static XPath compileXPath(String str, String str2) {
        return compileXPath(str, str2, null);
    }

    /* JADX WARN: Byte code manipulation detected: skipped illegal throws declarations: [org.apache.xmlbeans.impl.common.XPath$XPathCompileException] */
    public static XPath compileXPath(String str, Map map) {
        return compileXPath(str, "$this", map);
    }

    /* JADX WARN: Byte code manipulation detected: skipped illegal throws declarations: [org.apache.xmlbeans.impl.common.XPath$XPathCompileException] */
    public static XPath compileXPath(String str, String str2, Map map) {
        return new CompilationContext(map, str2).compile(str);
    }

    private static class CompilationContext {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int _column;
        private String _currentNodeVar;
        private String _expr;
        private Map _externalNamespaces;
        private boolean _lastDeepDot;
        private int _line;
        protected Map _namespaces;
        private int _offset;
        private boolean _sawDeepDot;

        private void processNonXpathDecls() {
        }

        CompilationContext(Map map, String str) {
            if (str == null) {
                this._currentNodeVar = "$this";
            } else {
                this._currentNodeVar = str;
            }
            this._namespaces = new HashMap();
            this._externalNamespaces = map == null ? new HashMap() : map;
        }

        /* JADX WARN: Byte code manipulation detected: skipped illegal throws declarations: [org.apache.xmlbeans.impl.common.XPath$XPathCompileException] */
        XPath compile(String str) {
            this._offset = 0;
            this._line = 1;
            this._column = 1;
            this._expr = str;
            return tokenizeXPath();
        }

        int currChar() {
            return currChar(0);
        }

        int currChar(int i) {
            if (this._offset + i >= this._expr.length()) {
                return -1;
            }
            return this._expr.charAt(this._offset + i);
        }

        void advance() {
            if (this._offset < this._expr.length()) {
                char cCharAt = this._expr.charAt(this._offset);
                int i = this._offset + 1;
                this._offset = i;
                this._column++;
                if (cCharAt == '\r' || cCharAt == '\n') {
                    this._line++;
                    this._column = 1;
                    if (i + 1 < this._expr.length()) {
                        char cCharAt2 = this._expr.charAt(this._offset + 1);
                        if ((cCharAt2 == '\r' || cCharAt2 == '\n') && cCharAt != cCharAt2) {
                            this._offset++;
                        }
                    }
                }
            }
        }

        void advance(int i) {
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    return;
                }
                advance();
                i = i2;
            }
        }

        boolean isWhitespace() {
            return isWhitespace(0);
        }

        boolean isWhitespace(int i) {
            int iCurrChar = currChar(i);
            return iCurrChar == 32 || iCurrChar == 9 || iCurrChar == 10 || iCurrChar == 13;
        }

        boolean isNCNameStart() {
            if (currChar() == -1) {
                return false;
            }
            return XMLChar.isNCNameStart(currChar());
        }

        boolean isNCName() {
            if (currChar() == -1) {
                return false;
            }
            return XMLChar.isNCName(currChar());
        }

        boolean startsWith(String str) {
            return startsWith(str, 0);
        }

        boolean startsWith(String str, int i) {
            if (this._offset + i >= this._expr.length()) {
                return false;
            }
            return this._expr.startsWith(str, this._offset + i);
        }

        private XPathCompileException newError(String str) {
            return new XPathCompileException(XmlError.forLocation(str, 0, (String) null, this._line, this._column, this._offset));
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlException */
        /* JADX WARN: Byte code manipulation detected: skipped illegal throws declarations: [org.apache.xmlbeans.impl.common.XPath$XPathCompileException] */
        String lookupPrefix(String str) throws XmlException {
            if (this._namespaces.containsKey(str)) {
                return (String) this._namespaces.get(str);
            }
            if (this._externalNamespaces.containsKey(str)) {
                return (String) this._externalNamespaces.get(str);
            }
            if (str.equals(Sax2Dom.XML_PREFIX)) {
                return XMLValidationSchema.SCHEMA_ID_DTD;
            }
            if (str.equals("xs")) {
                return XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA;
            }
            if (str.equals("xsi")) {
                return "http://www.w3.org/2001/XMLSchema-instance";
            }
            if (str.equals("fn")) {
                return "http://www.w3.org/2002/11/xquery-functions";
            }
            if (str.equals("xdt")) {
                return "http://www.w3.org/2003/11/xpath-datatypes";
            }
            if (str.equals("local")) {
                return "http://www.w3.org/2003/11/xquery-local-functions";
            }
            throw newError("Undefined prefix: " + str);
        }

        /* JADX WARN: Byte code manipulation detected: skipped illegal throws declarations: [org.apache.xmlbeans.impl.common.XPath$XPathCompileException] */
        private boolean parseWhitespace() {
            boolean z = false;
            while (isWhitespace()) {
                advance();
                z = true;
            }
            return z;
        }

        private boolean tokenize(String str) {
            int i = 0;
            while (isWhitespace(i)) {
                i++;
            }
            if (!startsWith(str, i)) {
                return false;
            }
            advance(i + str.length());
            return true;
        }

        private boolean tokenize(String str, String str2) {
            int i = 0;
            while (isWhitespace(i)) {
                i++;
            }
            if (!startsWith(str, i)) {
                return false;
            }
            int length = i + str.length();
            while (isWhitespace(length)) {
                length++;
            }
            if (!startsWith(str2, length)) {
                return false;
            }
            advance(length + str2.length());
            return true;
        }

        private boolean tokenize(String str, String str2, String str3) {
            int i = 0;
            while (isWhitespace(i)) {
                i++;
            }
            if (!startsWith(str, i)) {
                return false;
            }
            int length = i + str.length();
            while (isWhitespace(length)) {
                length++;
            }
            if (!startsWith(str2, length)) {
                return false;
            }
            int length2 = length + str2.length();
            while (isWhitespace(length2)) {
                length2++;
            }
            if (!startsWith(str3, length2)) {
                return false;
            }
            int length3 = length2 + str3.length();
            while (isWhitespace(length3)) {
                length3++;
            }
            advance(length3);
            return true;
        }

        private boolean tokenize(String str, String str2, String str3, String str4) {
            int i = 0;
            while (isWhitespace(i)) {
                i++;
            }
            if (!startsWith(str, i)) {
                return false;
            }
            int length = i + str.length();
            while (isWhitespace(length)) {
                length++;
            }
            if (!startsWith(str2, length)) {
                return false;
            }
            int length2 = length + str2.length();
            while (isWhitespace(length2)) {
                length2++;
            }
            if (!startsWith(str3, length2)) {
                return false;
            }
            int length3 = length2 + str3.length();
            while (isWhitespace(length3)) {
                length3++;
            }
            if (!startsWith(str4, length3)) {
                return false;
            }
            advance(length3 + str4.length());
            return true;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlException */
        /* JADX WARN: Byte code manipulation detected: skipped illegal throws declarations: [org.apache.xmlbeans.impl.common.XPath$XPathCompileException] */
        private String tokenizeNCName() throws XmlException {
            parseWhitespace();
            if (!isNCNameStart()) {
                throw newError("Expected non-colonized name");
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append((char) currChar());
            while (true) {
                advance();
                if (isNCName()) {
                    stringBuffer.append((char) currChar());
                } else {
                    return stringBuffer.toString();
                }
            }
        }

        private QName getAnyQName() {
            return new QName("", "");
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlException */
        /* JADX WARN: Byte code manipulation detected: skipped illegal throws declarations: [org.apache.xmlbeans.impl.common.XPath$XPathCompileException] */
        private QName tokenizeQName() throws XmlException {
            if (tokenize("*")) {
                return getAnyQName();
            }
            String str = tokenizeNCName();
            if (!tokenize(":")) {
                return new QName(lookupPrefix(""), str);
            }
            return new QName(lookupPrefix(str), tokenize("*") ? "" : tokenizeNCName());
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlException */
        /* JADX WARN: Byte code manipulation detected: skipped illegal throws declarations: [org.apache.xmlbeans.impl.common.XPath$XPathCompileException] */
        private String tokenizeQuotedUri() throws XmlException {
            int i;
            if (tokenize("\"")) {
                i = 34;
            } else {
                if (!tokenize("'")) {
                    throw newError("Expected quote (\" or ')");
                }
                i = 39;
            }
            StringBuffer stringBuffer = new StringBuffer();
            while (currChar() != -1) {
                if (currChar() == i) {
                    advance();
                    if (currChar() != i) {
                        return stringBuffer.toString();
                    }
                }
                stringBuffer.append((char) currChar());
                advance();
            }
            throw newError("Path terminated in URI literal");
        }

        private Step addStep(boolean z, boolean z2, QName qName, Step step) {
            Step step2 = new Step(z, z2, qName);
            if (step == null) {
                return step2;
            }
            Step step3 = step;
            while (step3._next != null) {
                step3 = step3._next;
            }
            step3._next = step2;
            step2._prev = step3;
            return step;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlException */
        /* JADX WARN: Byte code manipulation detected: skipped illegal throws declarations: [org.apache.xmlbeans.impl.common.XPath$XPathCompileException] */
        private Step tokenizeSteps() throws XmlException {
            boolean z;
            boolean z2;
            if (tokenize("/")) {
                throw newError("Absolute paths unsupported");
            }
            if (tokenize("$", this._currentNodeVar, "//") || tokenize(".", "//")) {
                z = true;
            } else {
                if (!tokenize("$", this._currentNodeVar, "/") && !tokenize(".", "/") && (tokenize("$", this._currentNodeVar) || tokenize("."))) {
                    return addStep(false, false, null, null);
                }
                z = false;
            }
            Step stepAddStep = null;
            loop0: while (true) {
                z2 = false;
                while (true) {
                    if (tokenize("attribute", "::") || tokenize("@")) {
                        stepAddStep = addStep(z, true, tokenizeQName(), stepAddStep);
                        break loop0;
                    }
                    if (tokenize(".")) {
                        z2 = z2 || z;
                    } else {
                        tokenize("child", "::");
                        QName qName = tokenizeQName();
                        if (qName != null) {
                            stepAddStep = addStep(z, false, qName, stepAddStep);
                            z = false;
                        }
                    }
                    if (!tokenize("//")) {
                        if (!tokenize("/")) {
                            break loop0;
                        }
                        if (z2) {
                            z = true;
                        }
                    } else {
                        break;
                    }
                }
                z = true;
            }
            this._lastDeepDot = z2;
            if (z2) {
                this._lastDeepDot = true;
                stepAddStep = addStep(true, false, getAnyQName(), stepAddStep);
            }
            return addStep(false, false, null, stepAddStep);
        }

        /* JADX WARN: Byte code manipulation detected: skipped illegal throws declarations: [org.apache.xmlbeans.impl.common.XPath$XPathCompileException] */
        private void computeBacktrack(Step step) {
            Step step2;
            while (step != null) {
                Step step3 = step._next;
                while (step3 != null && !step3._deep) {
                    step3 = step3._next;
                }
                if (step._deep) {
                    int i = 0;
                    Step step4 = step;
                    int i2 = 0;
                    while (step4 != step3 && step4._name != null && !step4.isWild() && !step4._attr) {
                        i2++;
                        step4 = step4._next;
                    }
                    int i3 = i2 + 1;
                    Object[] objArr = new QName[i3];
                    int[] iArr = new int[i3];
                    Step step5 = step;
                    for (int i4 = 0; i4 < i2; i4++) {
                        objArr[i4] = step5._name;
                        step5 = step5._next;
                    }
                    objArr[i2] = getAnyQName();
                    iArr[0] = -1;
                    int i5 = 0;
                    int i6 = -1;
                    while (i5 < i2) {
                        while (i6 > -1 && !objArr[i5].equals(objArr[i6])) {
                            i6 = iArr[i6];
                        }
                        i5++;
                        i6++;
                        if (objArr[i5].equals(objArr[i6])) {
                            iArr[i5] = iArr[i6];
                        } else {
                            iArr[i5] = i6;
                        }
                    }
                    for (Step step6 = step; step6 != step4; step6 = step6._next) {
                        step6._hasBacktrack = true;
                        step6._backtrack = step;
                        for (int i7 = iArr[i]; i7 > 0; i7--) {
                            step6._backtrack = step6._backtrack._next;
                        }
                        i++;
                    }
                    if (i2 > 1) {
                        step2 = step;
                        for (int i8 = iArr[i2 - 1]; i8 > 0; i8--) {
                            step2 = step2._next;
                        }
                    } else {
                        step2 = step;
                    }
                    if (step4 != step3 && step4._attr) {
                        step4._hasBacktrack = true;
                        step4._backtrack = step2;
                        step4 = step4._next;
                    }
                    if (step4 != step3 && step4._name == null) {
                        step4._hasBacktrack = true;
                        step4._backtrack = step2;
                    }
                    step._hasBacktrack = true;
                    step._backtrack = step;
                } else {
                    while (step != step3) {
                        step._hasBacktrack = true;
                        step = step._next;
                    }
                }
                step = step3;
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlException */
        /* JADX WARN: Byte code manipulation detected: skipped illegal throws declarations: [org.apache.xmlbeans.impl.common.XPath$XPathCompileException] */
        private void tokenizePath(ArrayList arrayList) throws XmlException {
            this._lastDeepDot = false;
            Step step = tokenizeSteps();
            computeBacktrack(step);
            arrayList.add(step);
            if (this._lastDeepDot) {
                this._sawDeepDot = true;
                Step stepAddStep = null;
                while (step != null) {
                    if (step._next != null && step._next._next == null) {
                        stepAddStep = addStep(step._deep, true, step._name, stepAddStep);
                    } else {
                        stepAddStep = addStep(step._deep, step._attr, step._name, stepAddStep);
                    }
                    step = step._next;
                }
                computeBacktrack(stepAddStep);
                arrayList.add(stepAddStep);
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlException */
        /* JADX WARN: Byte code manipulation detected: skipped illegal throws declarations: [org.apache.xmlbeans.impl.common.XPath$XPathCompileException] */
        private Selector tokenizeSelector() throws XmlException {
            ArrayList arrayList = new ArrayList();
            tokenizePath(arrayList);
            while (tokenize("|")) {
                tokenizePath(arrayList);
            }
            return new Selector((Step[]) arrayList.toArray(new Step[0]));
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlException */
        /* JADX WARN: Byte code manipulation detected: skipped illegal throws declarations: [org.apache.xmlbeans.impl.common.XPath$XPathCompileException] */
        private XPath tokenizeXPath() throws XmlException {
            while (true) {
                if (tokenize("declare", "namespace")) {
                    if (!parseWhitespace()) {
                        throw newError("Expected prefix after 'declare namespace'");
                    }
                    String str = tokenizeNCName();
                    if (!tokenize("=")) {
                        throw newError("Expected '='");
                    }
                    String str2 = tokenizeQuotedUri();
                    if (this._namespaces.containsKey(str)) {
                        throw newError("Redefinition of namespace prefix: " + str);
                    }
                    this._namespaces.put(str, str2);
                    if (this._externalNamespaces.containsKey(str)) {
                        throw newError("Redefinition of namespace prefix: " + str);
                    }
                    this._externalNamespaces.put(str, str2);
                    tokenize(";");
                    this._externalNamespaces.put(XPath._NS_BOUNDARY, new Integer(this._offset));
                } else if (tokenize("declare", "default", "element", "namespace")) {
                    String str3 = tokenizeQuotedUri();
                    if (this._namespaces.containsKey("")) {
                        throw newError("Redefinition of default element namespace");
                    }
                    this._namespaces.put("", str3);
                    if (this._externalNamespaces.containsKey(XPath._DEFAULT_ELT_NS)) {
                        throw newError("Redefinition of default element namespace : ");
                    }
                    this._externalNamespaces.put(XPath._DEFAULT_ELT_NS, str3);
                    if (!tokenize(";")) {
                        throw newError("Default Namespace declaration must end with ;");
                    }
                    this._externalNamespaces.put(XPath._NS_BOUNDARY, new Integer(this._offset));
                } else {
                    if (!this._namespaces.containsKey("")) {
                        this._namespaces.put("", "");
                    }
                    Selector selector = tokenizeSelector();
                    parseWhitespace();
                    if (currChar() != -1) {
                        throw newError("Unexpected char '" + ((char) currChar()) + "'");
                    }
                    return new XPath(selector, this._sawDeepDot);
                }
            }
        }
    }

    private static final class Step {
        final boolean _attr;
        Step _backtrack;
        final boolean _deep;
        int _flags;
        boolean _hasBacktrack;
        final QName _name;
        Step _next;
        Step _prev;

        Step(boolean z, boolean z2, QName qName) {
            this._name = qName;
            this._deep = z;
            this._attr = z2;
            int i = (z || !z2) ? 2 : 0;
            this._flags = z2 ? i | 4 : i;
        }

        boolean isWild() {
            return this._name.getLocalPart().length() == 0;
        }

        boolean match(QName qName) {
            String localPart = this._name.getLocalPart();
            String localPart2 = qName.getLocalPart();
            int length = localPart.length();
            if (length == 0) {
                String namespaceURI = this._name.getNamespaceURI();
                if (namespaceURI.length() == 0) {
                    return true;
                }
                return namespaceURI.equals(qName.getNamespaceURI());
            }
            if (length != localPart2.length()) {
                return false;
            }
            String namespaceURI2 = this._name.getNamespaceURI();
            String namespaceURI3 = qName.getNamespaceURI();
            if (namespaceURI2.length() != namespaceURI3.length()) {
                return false;
            }
            return localPart.equals(localPart2) && namespaceURI2.equals(namespaceURI3);
        }
    }

    private static final class Selector {
        final Step[] _paths;

        Selector(Step[] stepArr) {
            this._paths = stepArr;
        }
    }

    private XPath(Selector selector, boolean z) {
        this._selector = selector;
        this._sawDeepDot = z;
    }

    public boolean sawDeepDot() {
        return this._sawDeepDot;
    }
}
