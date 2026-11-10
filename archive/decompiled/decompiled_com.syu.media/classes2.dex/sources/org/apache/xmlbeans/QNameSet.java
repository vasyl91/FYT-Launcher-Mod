package org.apache.xmlbeans;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.xml.namespace.QName;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class QNameSet implements QNameSetSpecification, Serializable {
    private static final long serialVersionUID = 1;
    private final Set _excludedQNames;
    private final Set _includedQNames;
    private final Set _includedURIs;
    private final boolean _inverted;
    public static final QNameSet EMPTY = new QNameSet(null, Collections.EMPTY_SET, Collections.EMPTY_SET, Collections.EMPTY_SET);
    public static final QNameSet ALL = new QNameSet(Collections.EMPTY_SET, null, Collections.EMPTY_SET, Collections.EMPTY_SET);
    public static final QNameSet LOCAL = new QNameSet(null, Collections.singleton(""), Collections.EMPTY_SET, Collections.EMPTY_SET);
    public static final QNameSet NONLOCAL = new QNameSet(Collections.singleton(""), null, Collections.EMPTY_SET, Collections.EMPTY_SET);

    private static Set minSetCopy(Set set) {
        if (set == null) {
            return null;
        }
        if (set.isEmpty()) {
            return Collections.EMPTY_SET;
        }
        if (set.size() == 1) {
            return Collections.singleton(set.iterator().next());
        }
        return new HashSet(set);
    }

    public static QNameSet forSets(Set set, Set set2, Set set3, Set set4) {
        if ((set != null) == (set2 != null)) {
            throw new IllegalArgumentException("Exactly one of excludedURIs and includedURIs must be null");
        }
        if (set == null && set2.isEmpty() && set4.isEmpty()) {
            return EMPTY;
        }
        if (set2 == null && set.isEmpty() && set3.isEmpty()) {
            return ALL;
        }
        if (set == null && set2.size() == 1 && set2.contains("") && set4.isEmpty() && set3.isEmpty()) {
            return LOCAL;
        }
        if (set2 == null && set.size() == 1 && set.contains("") && set3.isEmpty() && set4.isEmpty()) {
            return NONLOCAL;
        }
        return new QNameSet(minSetCopy(set), minSetCopy(set2), minSetCopy(set3), minSetCopy(set4));
    }

    public static QNameSet forArray(QName[] qNameArr) {
        if (qNameArr == null) {
            throw new IllegalArgumentException("includedQNames cannot be null");
        }
        return new QNameSet(null, Collections.EMPTY_SET, Collections.EMPTY_SET, new HashSet(Arrays.asList(qNameArr)));
    }

    public static QNameSet forSpecification(QNameSetSpecification qNameSetSpecification) {
        if (qNameSetSpecification instanceof QNameSet) {
            return (QNameSet) qNameSetSpecification;
        }
        return forSets(qNameSetSpecification.excludedURIs(), qNameSetSpecification.includedURIs(), qNameSetSpecification.excludedQNamesInIncludedURIs(), qNameSetSpecification.includedQNamesInExcludedURIs());
    }

    public static QNameSet forWildcardNamespaceString(String str, String str2) {
        return forSpecification(new QNameSetBuilder(str, str2));
    }

    public static QNameSet singleton(QName qName) {
        return new QNameSet(null, Collections.EMPTY_SET, Collections.EMPTY_SET, Collections.singleton(qName));
    }

    private QNameSet(Set set, Set set2, Set set3, Set set4) {
        if (set2 != null && set == null) {
            this._inverted = false;
            this._includedURIs = set2;
            this._excludedQNames = set3;
            this._includedQNames = set4;
            return;
        }
        if (set != null && set2 == null) {
            this._inverted = true;
            this._includedURIs = set;
            this._excludedQNames = set4;
            this._includedQNames = set3;
            return;
        }
        throw new IllegalArgumentException("Exactly one of excludedURIs and includedURIs must be null");
    }

    private static String nsFromName(QName qName) {
        String namespaceURI = qName.getNamespaceURI();
        return namespaceURI == null ? "" : namespaceURI;
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
        return this._inverted && this._includedURIs.isEmpty() && this._includedQNames.isEmpty();
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public boolean isEmpty() {
        return !this._inverted && this._includedURIs.isEmpty() && this._includedQNames.isEmpty();
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
        QNameSet qNameSet = EMPTY;
        if (this == qNameSet) {
            return ALL;
        }
        if (this == ALL) {
            return qNameSet;
        }
        QNameSet qNameSet2 = LOCAL;
        if (this == qNameSet2) {
            return NONLOCAL;
        }
        return this == NONLOCAL ? qNameSet2 : new QNameSet(includedURIs(), excludedURIs(), includedQNamesInExcludedURIs(), excludedQNamesInIncludedURIs());
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
        stringBuffer.append("QNameSet");
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
}
