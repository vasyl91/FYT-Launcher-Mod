package org.apache.xmlbeans;

import java.math.BigInteger;
import javax.xml.namespace.QName;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface SchemaParticle {
    public static final int ALL = 1;
    public static final int CHOICE = 2;
    public static final int ELEMENT = 4;
    public static final int LAX = 2;
    public static final int SEQUENCE = 3;
    public static final int SKIP = 3;
    public static final int STRICT = 1;
    public static final int WILDCARD = 5;

    QNameSet acceptedStartNames();

    boolean canStartWithElement(QName qName);

    int countOfParticleChild();

    String getDefaultText();

    XmlAnySimpleType getDefaultValue();

    int getIntMaxOccurs();

    int getIntMinOccurs();

    BigInteger getMaxOccurs();

    BigInteger getMinOccurs();

    QName getName();

    SchemaParticle getParticleChild(int i);

    SchemaParticle[] getParticleChildren();

    int getParticleType();

    SchemaType getType();

    int getWildcardProcess();

    QNameSet getWildcardSet();

    boolean isDefault();

    boolean isFixed();

    boolean isNillable();

    boolean isSingleton();

    boolean isSkippable();
}
