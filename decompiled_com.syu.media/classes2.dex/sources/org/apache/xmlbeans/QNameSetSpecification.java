package org.apache.xmlbeans;

import java.util.Set;
import javax.xml.namespace.QName;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface QNameSetSpecification {
    boolean contains(QName qName);

    boolean containsAll(QNameSetSpecification qNameSetSpecification);

    Set excludedQNamesInIncludedURIs();

    Set excludedURIs();

    Set includedQNamesInExcludedURIs();

    Set includedURIs();

    QNameSet intersect(QNameSetSpecification qNameSetSpecification);

    QNameSet inverse();

    boolean isAll();

    boolean isDisjoint(QNameSetSpecification qNameSetSpecification);

    boolean isEmpty();

    QNameSet union(QNameSetSpecification qNameSetSpecification);
}
