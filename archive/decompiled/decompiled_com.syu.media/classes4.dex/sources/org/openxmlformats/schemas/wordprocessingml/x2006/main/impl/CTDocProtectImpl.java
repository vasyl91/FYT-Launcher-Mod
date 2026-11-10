package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STAlgClass;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STAlgType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STCryptProv;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDocProtect;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLongHexNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STString;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTDocProtectImpl extends XmlComplexContentImpl implements CTDocProtect {
    private static final QName EDIT$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "edit");
    private static final QName FORMATTING$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "formatting");
    private static final QName ENFORCEMENT$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "enforcement");
    private static final QName CRYPTPROVIDERTYPE$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cryptProviderType");
    private static final QName CRYPTALGORITHMCLASS$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cryptAlgorithmClass");
    private static final QName CRYPTALGORITHMTYPE$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cryptAlgorithmType");
    private static final QName CRYPTALGORITHMSID$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cryptAlgorithmSid");
    private static final QName CRYPTSPINCOUNT$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cryptSpinCount");
    private static final QName CRYPTPROVIDER$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cryptProvider");
    private static final QName ALGIDEXT$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "algIdExt");
    private static final QName ALGIDEXTSOURCE$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "algIdExtSource");
    private static final QName CRYPTPROVIDERTYPEEXT$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cryptProviderTypeExt");
    private static final QName CRYPTPROVIDERTYPEEXTSOURCE$24 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cryptProviderTypeExtSource");
    private static final QName HASH$26 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hash");
    private static final QName SALT$28 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "salt");

    public CTDocProtectImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public byte[] getAlgIdExt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ALGIDEXT$18);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public String getAlgIdExtSource() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ALGIDEXTSOURCE$20);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STAlgClass.Enum getCryptAlgorithmClass() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CRYPTALGORITHMCLASS$8);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STAlgClass.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public BigInteger getCryptAlgorithmSid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CRYPTALGORITHMSID$12);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STAlgType.Enum getCryptAlgorithmType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CRYPTALGORITHMTYPE$10);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STAlgType.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public String getCryptProvider() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CRYPTPROVIDER$16);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STCryptProv.Enum getCryptProviderType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CRYPTPROVIDERTYPE$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STCryptProv.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public byte[] getCryptProviderTypeExt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CRYPTPROVIDERTYPEEXT$22);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public String getCryptProviderTypeExtSource() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CRYPTPROVIDERTYPEEXTSOURCE$24);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public BigInteger getCryptSpinCount() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CRYPTSPINCOUNT$14);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STDocProtect.Enum getEdit() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(EDIT$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STDocProtect.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STOnOff.Enum getEnforcement() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ENFORCEMENT$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STOnOff.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STOnOff.Enum getFormatting() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FORMATTING$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STOnOff.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public byte[] getHash() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HASH$26);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public byte[] getSalt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SALT$28);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetAlgIdExt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALGIDEXT$18) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetAlgIdExtSource() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALGIDEXTSOURCE$20) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetCryptAlgorithmClass() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CRYPTALGORITHMCLASS$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetCryptAlgorithmSid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CRYPTALGORITHMSID$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetCryptAlgorithmType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CRYPTALGORITHMTYPE$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetCryptProvider() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CRYPTPROVIDER$16) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetCryptProviderType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CRYPTPROVIDERTYPE$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetCryptProviderTypeExt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CRYPTPROVIDERTYPEEXT$22) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetCryptProviderTypeExtSource() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CRYPTPROVIDERTYPEEXTSOURCE$24) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetCryptSpinCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CRYPTSPINCOUNT$14) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetEdit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(EDIT$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetEnforcement() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ENFORCEMENT$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetFormatting() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FORMATTING$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetHash() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HASH$26) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public boolean isSetSalt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SALT$28) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setAlgIdExt(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALGIDEXT$18;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setAlgIdExtSource(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALGIDEXTSOURCE$20;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setCryptAlgorithmClass(STAlgClass.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTALGORITHMCLASS$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setCryptAlgorithmSid(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTALGORITHMSID$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setCryptAlgorithmType(STAlgType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTALGORITHMTYPE$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setCryptProvider(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTPROVIDER$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setCryptProviderType(STCryptProv.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTPROVIDERTYPE$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setCryptProviderTypeExt(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTPROVIDERTYPEEXT$22;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setCryptProviderTypeExtSource(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTPROVIDERTYPEEXTSOURCE$24;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setCryptSpinCount(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTSPINCOUNT$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setEdit(STDocProtect.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EDIT$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setEnforcement(STOnOff.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENFORCEMENT$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setFormatting(STOnOff.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORMATTING$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setHash(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HASH$26;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void setSalt(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SALT$28;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetAlgIdExt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALGIDEXT$18);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetAlgIdExtSource() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALGIDEXTSOURCE$20);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetCryptAlgorithmClass() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CRYPTALGORITHMCLASS$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetCryptAlgorithmSid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CRYPTALGORITHMSID$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetCryptAlgorithmType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CRYPTALGORITHMTYPE$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetCryptProvider() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CRYPTPROVIDER$16);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetCryptProviderType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CRYPTPROVIDERTYPE$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetCryptProviderTypeExt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CRYPTPROVIDERTYPEEXT$22);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetCryptProviderTypeExtSource() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CRYPTPROVIDERTYPEEXTSOURCE$24);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetCryptSpinCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CRYPTSPINCOUNT$14);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetEdit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(EDIT$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetEnforcement() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ENFORCEMENT$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetFormatting() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FORMATTING$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetHash() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HASH$26);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void unsetSalt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SALT$28);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STLongHexNumber xgetAlgIdExt() {
        STLongHexNumber sTLongHexNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTLongHexNumberFind_attribute_user = get_store().find_attribute_user(ALGIDEXT$18);
        }
        return sTLongHexNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STString xgetAlgIdExtSource() {
        STString sTStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTStringFind_attribute_user = get_store().find_attribute_user(ALGIDEXTSOURCE$20);
        }
        return sTStringFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STAlgClass xgetCryptAlgorithmClass() {
        STAlgClass sTAlgClassFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTAlgClassFind_attribute_user = get_store().find_attribute_user(CRYPTALGORITHMCLASS$8);
        }
        return sTAlgClassFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STDecimalNumber xgetCryptAlgorithmSid() {
        STDecimalNumber sTDecimalNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumberFind_attribute_user = get_store().find_attribute_user(CRYPTALGORITHMSID$12);
        }
        return sTDecimalNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STAlgType xgetCryptAlgorithmType() {
        STAlgType sTAlgTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTAlgTypeFind_attribute_user = get_store().find_attribute_user(CRYPTALGORITHMTYPE$10);
        }
        return sTAlgTypeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STString xgetCryptProvider() {
        STString sTStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTStringFind_attribute_user = get_store().find_attribute_user(CRYPTPROVIDER$16);
        }
        return sTStringFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STCryptProv xgetCryptProviderType() {
        STCryptProv sTCryptProvFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTCryptProvFind_attribute_user = get_store().find_attribute_user(CRYPTPROVIDERTYPE$6);
        }
        return sTCryptProvFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STLongHexNumber xgetCryptProviderTypeExt() {
        STLongHexNumber sTLongHexNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTLongHexNumberFind_attribute_user = get_store().find_attribute_user(CRYPTPROVIDERTYPEEXT$22);
        }
        return sTLongHexNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STString xgetCryptProviderTypeExtSource() {
        STString sTStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTStringFind_attribute_user = get_store().find_attribute_user(CRYPTPROVIDERTYPEEXTSOURCE$24);
        }
        return sTStringFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STDecimalNumber xgetCryptSpinCount() {
        STDecimalNumber sTDecimalNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumberFind_attribute_user = get_store().find_attribute_user(CRYPTSPINCOUNT$14);
        }
        return sTDecimalNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STDocProtect xgetEdit() {
        STDocProtect sTDocProtectFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTDocProtectFind_attribute_user = get_store().find_attribute_user(EDIT$0);
        }
        return sTDocProtectFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STOnOff xgetEnforcement() {
        STOnOff sTOnOffFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOffFind_attribute_user = get_store().find_attribute_user(ENFORCEMENT$4);
        }
        return sTOnOffFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public STOnOff xgetFormatting() {
        STOnOff sTOnOffFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOffFind_attribute_user = get_store().find_attribute_user(FORMATTING$2);
        }
        return sTOnOffFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public XmlBase64Binary xgetHash() {
        XmlBase64Binary xmlBase64BinaryFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_attribute_user = get_store().find_attribute_user(HASH$26);
        }
        return xmlBase64BinaryFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public XmlBase64Binary xgetSalt() {
        XmlBase64Binary xmlBase64BinaryFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_attribute_user = get_store().find_attribute_user(SALT$28);
        }
        return xmlBase64BinaryFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetAlgIdExt(STLongHexNumber sTLongHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALGIDEXT$18;
            STLongHexNumber sTLongHexNumberFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTLongHexNumberFind_attribute_user == null) {
                sTLongHexNumberFind_attribute_user = (STLongHexNumber) get_store().add_attribute_user(qName);
            }
            sTLongHexNumberFind_attribute_user.set(sTLongHexNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetAlgIdExtSource(STString sTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALGIDEXTSOURCE$20;
            STString sTStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTStringFind_attribute_user == null) {
                sTStringFind_attribute_user = (STString) get_store().add_attribute_user(qName);
            }
            sTStringFind_attribute_user.set(sTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetCryptAlgorithmClass(STAlgClass sTAlgClass) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTALGORITHMCLASS$8;
            STAlgClass sTAlgClassFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTAlgClassFind_attribute_user == null) {
                sTAlgClassFind_attribute_user = (STAlgClass) get_store().add_attribute_user(qName);
            }
            sTAlgClassFind_attribute_user.set((XmlObject) sTAlgClass);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetCryptAlgorithmSid(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTALGORITHMSID$12;
            STDecimalNumber sTDecimalNumberFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTDecimalNumberFind_attribute_user == null) {
                sTDecimalNumberFind_attribute_user = (STDecimalNumber) get_store().add_attribute_user(qName);
            }
            sTDecimalNumberFind_attribute_user.set(sTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetCryptAlgorithmType(STAlgType sTAlgType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTALGORITHMTYPE$10;
            STAlgType sTAlgTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTAlgTypeFind_attribute_user == null) {
                sTAlgTypeFind_attribute_user = (STAlgType) get_store().add_attribute_user(qName);
            }
            sTAlgTypeFind_attribute_user.set((XmlObject) sTAlgType);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetCryptProvider(STString sTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTPROVIDER$16;
            STString sTStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTStringFind_attribute_user == null) {
                sTStringFind_attribute_user = (STString) get_store().add_attribute_user(qName);
            }
            sTStringFind_attribute_user.set(sTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetCryptProviderType(STCryptProv sTCryptProv) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTPROVIDERTYPE$6;
            STCryptProv sTCryptProvFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTCryptProvFind_attribute_user == null) {
                sTCryptProvFind_attribute_user = (STCryptProv) get_store().add_attribute_user(qName);
            }
            sTCryptProvFind_attribute_user.set((XmlObject) sTCryptProv);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetCryptProviderTypeExt(STLongHexNumber sTLongHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTPROVIDERTYPEEXT$22;
            STLongHexNumber sTLongHexNumberFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTLongHexNumberFind_attribute_user == null) {
                sTLongHexNumberFind_attribute_user = (STLongHexNumber) get_store().add_attribute_user(qName);
            }
            sTLongHexNumberFind_attribute_user.set(sTLongHexNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetCryptProviderTypeExtSource(STString sTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTPROVIDERTYPEEXTSOURCE$24;
            STString sTStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTStringFind_attribute_user == null) {
                sTStringFind_attribute_user = (STString) get_store().add_attribute_user(qName);
            }
            sTStringFind_attribute_user.set(sTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetCryptSpinCount(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRYPTSPINCOUNT$14;
            STDecimalNumber sTDecimalNumberFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTDecimalNumberFind_attribute_user == null) {
                sTDecimalNumberFind_attribute_user = (STDecimalNumber) get_store().add_attribute_user(qName);
            }
            sTDecimalNumberFind_attribute_user.set(sTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetEdit(STDocProtect sTDocProtect) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EDIT$0;
            STDocProtect sTDocProtectFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTDocProtectFind_attribute_user == null) {
                sTDocProtectFind_attribute_user = (STDocProtect) get_store().add_attribute_user(qName);
            }
            sTDocProtectFind_attribute_user.set((XmlObject) sTDocProtect);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetEnforcement(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENFORCEMENT$4;
            STOnOff sTOnOffFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTOnOffFind_attribute_user == null) {
                sTOnOffFind_attribute_user = (STOnOff) get_store().add_attribute_user(qName);
            }
            sTOnOffFind_attribute_user.set((XmlObject) sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetFormatting(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORMATTING$2;
            STOnOff sTOnOffFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTOnOffFind_attribute_user == null) {
                sTOnOffFind_attribute_user = (STOnOff) get_store().add_attribute_user(qName);
            }
            sTOnOffFind_attribute_user.set((XmlObject) sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetHash(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HASH$26;
            XmlBase64Binary xmlBase64BinaryFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBase64BinaryFind_attribute_user == null) {
                xmlBase64BinaryFind_attribute_user = (XmlBase64Binary) get_store().add_attribute_user(qName);
            }
            xmlBase64BinaryFind_attribute_user.set(xmlBase64Binary);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect
    public void xsetSalt(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SALT$28;
            XmlBase64Binary xmlBase64BinaryFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBase64BinaryFind_attribute_user == null) {
                xmlBase64BinaryFind_attribute_user = (XmlBase64Binary) get_store().add_attribute_user(qName);
            }
            xmlBase64BinaryFind_attribute_user.set(xmlBase64Binary);
        }
    }
}
