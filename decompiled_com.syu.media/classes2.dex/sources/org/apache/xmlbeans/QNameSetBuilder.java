package org.apache.xmlbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.xml.namespace.QName;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class QNameSetBuilder implements QNameSetSpecification, Serializable {
    private static final String[] EMPTY_STRINGARRAY = new String[0];
    private static final long serialVersionUID = 1;
    private Set _excludedQNames;
    private Set _includedQNames;
    private Set _includedURIs;
    private boolean _inverted;

    private static boolean isSpace(char c) {
        return c == '\t' || c == '\n' || c == '\r' || c == ' ';
    }

    public QNameSetBuilder() {
        this._inverted = false;
        this._includedURIs = new HashSet();
        this._excludedQNames = new HashSet();
        this._includedQNames = new HashSet();
    }

    public QNameSetBuilder(QNameSetSpecification qNameSetSpecification) {
        Set setIncludedURIs = qNameSetSpecification.includedURIs();
        if (setIncludedURIs != null) {
            this._inverted = false;
            this._includedURIs = new HashSet(setIncludedURIs);
            this._excludedQNames = new HashSet(qNameSetSpecification.excludedQNamesInIncludedURIs());
            this._includedQNames = new HashSet(qNameSetSpecification.includedQNamesInExcludedURIs());
            return;
        }
        this._inverted = true;
        this._includedURIs = new HashSet(qNameSetSpecification.excludedURIs());
        this._excludedQNames = new HashSet(qNameSetSpecification.includedQNamesInExcludedURIs());
        this._includedQNames = new HashSet(qNameSetSpecification.excludedQNamesInIncludedURIs());
    }

    public QNameSetBuilder(Set set, Set set2, Set set3, Set set4) {
        if (set2 != null && set == null) {
            this._inverted = false;
            this._includedURIs = new HashSet(set2);
            this._excludedQNames = new HashSet(set3);
            this._includedQNames = new HashSet(set4);
            return;
        }
        if (set != null && set2 == null) {
            this._inverted = true;
            this._includedURIs = new HashSet(set);
            this._excludedQNames = new HashSet(set4);
            this._includedQNames = new HashSet(set3);
            return;
        }
        throw new IllegalArgumentException("Exactly one of excludedURIs and includedURIs must be null");
    }

    public QNameSetBuilder(String str, String str2) {
        this();
        String[] strArrSplitList = splitList(str == null ? "##any" : str);
        for (int i = 0; i < strArrSplitList.length; i++) {
            String str3 = strArrSplitList[i];
            if (str3.startsWith("##")) {
                if (str3.equals("##other")) {
                    if (str2 == null) {
                        throw new IllegalArgumentException();
                    }
                    QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
                    qNameSetBuilder.addNamespace(str2);
                    qNameSetBuilder.addNamespace("");
                    qNameSetBuilder.invert();
                    addAll(qNameSetBuilder);
                } else if (str3.equals("##any")) {
                    clear();
                    invert();
                } else {
                    if (strArrSplitList[i].equals("##targetNamespace")) {
                        if (str2 == null) {
                            throw new IllegalArgumentException();
                        }
                        str3 = str2;
                    } else if (strArrSplitList[i].equals("##local")) {
                        str3 = "";
                    }
                    addNamespace(str3);
                }
            } else {
                addNamespace(str3);
            }
        }
    }

    private static String nsFromName(QName qName) {
        String namespaceURI = qName.getNamespaceURI();
        return namespaceURI == null ? "" : namespaceURI;
    }

    private static String[] splitList(String str) {
        if (str.length() == 0) {
            return EMPTY_STRINGARRAY;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            if (i < str.length() && isSpace(str.charAt(i))) {
                i++;
            } else {
                if (i >= str.length()) {
                    return (String[]) arrayList.toArray(EMPTY_STRINGARRAY);
                }
                int i2 = i;
                while (i2 < str.length() && !isSpace(str.charAt(i2))) {
                    i2++;
                }
                arrayList.add(str.substring(i, i2));
                i = i2;
            }
        }
    }

    private static void removeAllMatchingNs(String str, Set set) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (str.equals(nsFromName((QName) it.next()))) {
                it.remove();
            }
        }
    }

    private static void removeAllMatchingFirstOnly(Set set, Set set2, Set set3) {
        Iterator it = set3.iterator();
        while (it.hasNext()) {
            String strNsFromName = nsFromName((QName) it.next());
            if (set.contains(strNsFromName) && !set2.contains(strNsFromName)) {
                it.remove();
            }
        }
    }

    private static void removeAllMatchingBoth(Set set, Set set2, Set set3) {
        Iterator it = set3.iterator();
        while (it.hasNext()) {
            String strNsFromName = nsFromName((QName) it.next());
            if (set.contains(strNsFromName) && set2.contains(strNsFromName)) {
                it.remove();
            }
        }
    }

    private static void removeAllMatchingNeither(Set set, Set set2, Set set3) {
        Iterator it = set3.iterator();
        while (it.hasNext()) {
            String strNsFromName = nsFromName((QName) it.next());
            if (!set.contains(strNsFromName) && !set2.contains(strNsFromName)) {
                it.remove();
            }
        }
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public boolean contains(QName qName) {
        boolean zContains;
        if (this._includedURIs.contains(nsFromName(qName))) {
            zContains = !this._excludedQNames.contains(qName);
        } else {
            zContains = this._includedQNames.contains(qName);
        }
        return zContains ^ this._inverted;
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public boolean isAll() {
        return this._inverted && this._includedURIs.size() == 0 && this._includedQNames.size() == 0;
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public boolean isEmpty() {
        return !this._inverted && this._includedURIs.size() == 0 && this._includedQNames.size() == 0;
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public QNameSet intersect(QNameSetSpecification qNameSetSpecification) {
        QNameSetBuilder qNameSetBuilder = new QNameSetBuilder(this);
        qNameSetBuilder.restrict(qNameSetSpecification);
        return qNameSetBuilder.toQNameSet();
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public QNameSet union(QNameSetSpecification qNameSetSpecification) {
        QNameSetBuilder qNameSetBuilder = new QNameSetBuilder(this);
        qNameSetBuilder.addAll(qNameSetSpecification);
        return qNameSetBuilder.toQNameSet();
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public QNameSet inverse() {
        return QNameSet.forSets(includedURIs(), excludedURIs(), includedQNamesInExcludedURIs(), excludedQNamesInIncludedURIs());
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public boolean containsAll(QNameSetSpecification qNameSetSpecification) {
        if (this._inverted || qNameSetSpecification.excludedURIs() == null) {
            return inverse().isDisjoint(qNameSetSpecification);
        }
        return false;
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public boolean isDisjoint(QNameSetSpecification qNameSetSpecification) {
        if (this._inverted && qNameSetSpecification.excludedURIs() != null) {
            return false;
        }
        if (this._inverted) {
            return isDisjointImpl(qNameSetSpecification, this);
        }
        return isDisjointImpl(this, qNameSetSpecification);
    }

    private boolean isDisjointImpl(QNameSetSpecification qNameSetSpecification, QNameSetSpecification qNameSetSpecification2) {
        Set setIncludedURIs = qNameSetSpecification.includedURIs();
        Set setIncludedURIs2 = qNameSetSpecification2.includedURIs();
        if (setIncludedURIs2 != null) {
            Iterator it = setIncludedURIs.iterator();
            while (it.hasNext()) {
                if (setIncludedURIs2.contains(it.next())) {
                    return false;
                }
            }
        } else {
            Set setExcludedURIs = qNameSetSpecification2.excludedURIs();
            Iterator it2 = setIncludedURIs.iterator();
            while (it2.hasNext()) {
                if (!setExcludedURIs.contains(it2.next())) {
                    return false;
                }
            }
        }
        Iterator it3 = qNameSetSpecification.includedQNamesInExcludedURIs().iterator();
        while (it3.hasNext()) {
            if (qNameSetSpecification2.contains((QName) it3.next())) {
                return false;
            }
        }
        if (setIncludedURIs.size() <= 0) {
            return true;
        }
        Iterator it4 = qNameSetSpecification2.includedQNamesInExcludedURIs().iterator();
        while (it4.hasNext()) {
            if (qNameSetSpecification.contains((QName) it4.next())) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        this._inverted = false;
        this._includedURIs.clear();
        this._excludedQNames.clear();
        this._includedQNames.clear();
    }

    public void invert() {
        this._inverted = !this._inverted;
    }

    public void add(QName qName) {
        if (!this._inverted) {
            addImpl(qName);
        } else {
            removeImpl(qName);
        }
    }

    public void addNamespace(String str) {
        if (!this._inverted) {
            addNamespaceImpl(str);
        } else {
            removeNamespaceImpl(str);
        }
    }

    public void addAll(QNameSetSpecification qNameSetSpecification) {
        if (this._inverted) {
            removeAllImpl(qNameSetSpecification.includedURIs(), qNameSetSpecification.excludedURIs(), qNameSetSpecification.includedQNamesInExcludedURIs(), qNameSetSpecification.excludedQNamesInIncludedURIs());
        } else {
            addAllImpl(qNameSetSpecification.includedURIs(), qNameSetSpecification.excludedURIs(), qNameSetSpecification.includedQNamesInExcludedURIs(), qNameSetSpecification.excludedQNamesInIncludedURIs());
        }
    }

    public void remove(QName qName) {
        if (this._inverted) {
            addImpl(qName);
        } else {
            removeImpl(qName);
        }
    }

    public void removeNamespace(String str) {
        if (this._inverted) {
            addNamespaceImpl(str);
        } else {
            removeNamespaceImpl(str);
        }
    }

    public void removeAll(QNameSetSpecification qNameSetSpecification) {
        if (this._inverted) {
            addAllImpl(qNameSetSpecification.includedURIs(), qNameSetSpecification.excludedURIs(), qNameSetSpecification.includedQNamesInExcludedURIs(), qNameSetSpecification.excludedQNamesInIncludedURIs());
        } else {
            removeAllImpl(qNameSetSpecification.includedURIs(), qNameSetSpecification.excludedURIs(), qNameSetSpecification.includedQNamesInExcludedURIs(), qNameSetSpecification.excludedQNamesInIncludedURIs());
        }
    }

    public void restrict(QNameSetSpecification qNameSetSpecification) {
        if (this._inverted) {
            addAllImpl(qNameSetSpecification.excludedURIs(), qNameSetSpecification.includedURIs(), qNameSetSpecification.excludedQNamesInIncludedURIs(), qNameSetSpecification.includedQNamesInExcludedURIs());
        } else {
            removeAllImpl(qNameSetSpecification.excludedURIs(), qNameSetSpecification.includedURIs(), qNameSetSpecification.excludedQNamesInIncludedURIs(), qNameSetSpecification.includedQNamesInExcludedURIs());
        }
    }

    private void addImpl(QName qName) {
        if (this._includedURIs.contains(nsFromName(qName))) {
            this._excludedQNames.remove(qName);
        } else {
            this._includedQNames.add(qName);
        }
    }

    private void addNamespaceImpl(String str) {
        if (this._includedURIs.contains(str)) {
            removeAllMatchingNs(str, this._excludedQNames);
        } else {
            removeAllMatchingNs(str, this._includedQNames);
            this._includedURIs.add(str);
        }
    }

    private void addAllImpl(Set set, Set set2, Set set3, Set set4) {
        boolean z = set2 != null;
        Set set5 = z ? set2 : set;
        Iterator it = this._excludedQNames.iterator();
        while (it.hasNext()) {
            QName qName = (QName) it.next();
            if ((set5.contains(nsFromName(qName)) ^ z) && !set4.contains(qName)) {
                it.remove();
            }
        }
        Iterator it2 = set4.iterator();
        while (it2.hasNext()) {
            QName qName2 = (QName) it2.next();
            if (!this._includedURIs.contains(nsFromName(qName2)) && !this._includedQNames.contains(qName2)) {
                this._excludedQNames.add(qName2);
            }
        }
        Iterator it3 = set3.iterator();
        while (it3.hasNext()) {
            QName qName3 = (QName) it3.next();
            if (!this._includedURIs.contains(nsFromName(qName3))) {
                this._includedQNames.add(qName3);
            } else {
                this._excludedQNames.remove(qName3);
            }
        }
        if (!z) {
            removeAllMatchingFirstOnly(set, this._includedURIs, this._includedQNames);
            this._includedURIs.addAll(set);
            return;
        }
        removeAllMatchingNeither(set2, this._includedURIs, this._includedQNames);
        Iterator it4 = this._includedURIs.iterator();
        while (it4.hasNext()) {
            if (!set2.contains((String) it4.next())) {
                it4.remove();
            }
        }
        Iterator it5 = set2.iterator();
        while (it5.hasNext()) {
            String str = (String) it5.next();
            if (!this._includedURIs.contains(str)) {
                this._includedURIs.add(str);
            } else {
                this._includedURIs.remove(str);
            }
        }
        Set set6 = this._excludedQNames;
        this._excludedQNames = this._includedQNames;
        this._includedQNames = set6;
        this._inverted = !this._inverted;
    }

    private void removeImpl(QName qName) {
        if (this._includedURIs.contains(nsFromName(qName))) {
            this._excludedQNames.add(qName);
        } else {
            this._includedQNames.remove(qName);
        }
    }

    private void removeNamespaceImpl(String str) {
        if (this._includedURIs.contains(str)) {
            removeAllMatchingNs(str, this._excludedQNames);
            this._includedURIs.remove(str);
        } else {
            removeAllMatchingNs(str, this._includedQNames);
        }
    }

    private void removeAllImpl(Set set, Set set2, Set set3, Set set4) {
        boolean z = set2 != null;
        Set set5 = z ? set2 : set;
        Iterator it = this._includedQNames.iterator();
        while (it.hasNext()) {
            QName qName = (QName) it.next();
            if (set5.contains(nsFromName(qName)) ^ z) {
                if (!set4.contains(qName)) {
                    it.remove();
                }
            } else if (set3.contains(qName)) {
                it.remove();
            }
        }
        Iterator it2 = set3.iterator();
        while (it2.hasNext()) {
            QName qName2 = (QName) it2.next();
            if (this._includedURIs.contains(nsFromName(qName2))) {
                this._excludedQNames.add(qName2);
            }
        }
        Iterator it3 = set4.iterator();
        while (it3.hasNext()) {
            QName qName3 = (QName) it3.next();
            if (this._includedURIs.contains(nsFromName(qName3)) && !this._excludedQNames.contains(qName3)) {
                this._includedQNames.add(qName3);
            }
        }
        if (z) {
            removeAllMatchingFirstOnly(this._includedURIs, set2, this._excludedQNames);
        } else {
            removeAllMatchingBoth(this._includedURIs, set, this._excludedQNames);
        }
        Iterator it4 = this._includedURIs.iterator();
        while (it4.hasNext()) {
            if (set5.contains(it4.next()) ^ z) {
                it4.remove();
            }
        }
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public Set excludedURIs() {
        if (this._inverted) {
            return Collections.unmodifiableSet(this._includedURIs);
        }
        return null;
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public Set includedURIs() {
        if (this._inverted) {
            return null;
        }
        return this._includedURIs;
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public Set excludedQNamesInIncludedURIs() {
        return Collections.unmodifiableSet(this._inverted ? this._includedQNames : this._excludedQNames);
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public Set includedQNamesInExcludedURIs() {
        return Collections.unmodifiableSet(this._inverted ? this._excludedQNames : this._includedQNames);
    }

    private String prettyQName(QName qName) {
        if (qName.getNamespaceURI() == null) {
            return qName.getLocalPart();
        }
        return qName.getLocalPart() + "@" + qName.getNamespaceURI();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("QNameSetBuilder");
        stringBuffer.append(this._inverted ? "-(" : "+(");
        Iterator it = this._includedURIs.iterator();
        while (it.hasNext()) {
            stringBuffer.append("+*@");
            stringBuffer.append(it.next());
            stringBuffer.append(", ");
        }
        Iterator it2 = this._excludedQNames.iterator();
        while (it2.hasNext()) {
            stringBuffer.append("-");
            stringBuffer.append(prettyQName((QName) it2.next()));
            stringBuffer.append(", ");
        }
        Iterator it3 = this._includedQNames.iterator();
        while (it3.hasNext()) {
            stringBuffer.append("+");
            stringBuffer.append(prettyQName((QName) it3.next()));
            stringBuffer.append(", ");
        }
        int iLastIndexOf = stringBuffer.lastIndexOf(", ");
        if (iLastIndexOf > 0) {
            stringBuffer.setLength(iLastIndexOf);
        }
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public QNameSet toQNameSet() {
        return QNameSet.forSpecification(this);
    }
}
