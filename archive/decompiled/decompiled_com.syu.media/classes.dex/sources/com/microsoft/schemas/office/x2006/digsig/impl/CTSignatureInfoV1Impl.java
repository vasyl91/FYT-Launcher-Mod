package com.microsoft.schemas.office.x2006.digsig.impl;

import com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1;
import com.microsoft.schemas.office.x2006.digsig.STPositiveInteger;
import com.microsoft.schemas.office.x2006.digsig.STSignatureComments;
import com.microsoft.schemas.office.x2006.digsig.STSignatureProviderUrl;
import com.microsoft.schemas.office.x2006.digsig.STSignatureText;
import com.microsoft.schemas.office.x2006.digsig.STSignatureType;
import com.microsoft.schemas.office.x2006.digsig.STUniqueIdentifierWithBraces;
import com.microsoft.schemas.office.x2006.digsig.STVersion;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CTSignatureInfoV1Impl extends XmlComplexContentImpl implements CTSignatureInfoV1 {
    private static final QName SETUPID$0 = new QName("http://schemas.microsoft.com/office/2006/digsig", "SetupID");
    private static final QName SIGNATURETEXT$2 = new QName("http://schemas.microsoft.com/office/2006/digsig", "SignatureText");
    private static final QName SIGNATUREIMAGE$4 = new QName("http://schemas.microsoft.com/office/2006/digsig", "SignatureImage");
    private static final QName SIGNATURECOMMENTS$6 = new QName("http://schemas.microsoft.com/office/2006/digsig", "SignatureComments");
    private static final QName WINDOWSVERSION$8 = new QName("http://schemas.microsoft.com/office/2006/digsig", "WindowsVersion");
    private static final QName OFFICEVERSION$10 = new QName("http://schemas.microsoft.com/office/2006/digsig", "OfficeVersion");
    private static final QName APPLICATIONVERSION$12 = new QName("http://schemas.microsoft.com/office/2006/digsig", "ApplicationVersion");
    private static final QName MONITORS$14 = new QName("http://schemas.microsoft.com/office/2006/digsig", "Monitors");
    private static final QName HORIZONTALRESOLUTION$16 = new QName("http://schemas.microsoft.com/office/2006/digsig", "HorizontalResolution");
    private static final QName VERTICALRESOLUTION$18 = new QName("http://schemas.microsoft.com/office/2006/digsig", "VerticalResolution");
    private static final QName COLORDEPTH$20 = new QName("http://schemas.microsoft.com/office/2006/digsig", "ColorDepth");
    private static final QName SIGNATUREPROVIDERID$22 = new QName("http://schemas.microsoft.com/office/2006/digsig", "SignatureProviderId");
    private static final QName SIGNATUREPROVIDERURL$24 = new QName("http://schemas.microsoft.com/office/2006/digsig", "SignatureProviderUrl");
    private static final QName SIGNATUREPROVIDERDETAILS$26 = new QName("http://schemas.microsoft.com/office/2006/digsig", "SignatureProviderDetails");
    private static final QName SIGNATURETYPE$28 = new QName("http://schemas.microsoft.com/office/2006/digsig", "SignatureType");
    private static final QName DELEGATESUGGESTEDSIGNER$30 = new QName("http://schemas.microsoft.com/office/2006/digsig", "DelegateSuggestedSigner");
    private static final QName DELEGATESUGGESTEDSIGNER2$32 = new QName("http://schemas.microsoft.com/office/2006/digsig", "DelegateSuggestedSigner2");
    private static final QName DELEGATESUGGESTEDSIGNEREMAIL$34 = new QName("http://schemas.microsoft.com/office/2006/digsig", "DelegateSuggestedSignerEmail");
    private static final QName MANIFESTHASHALGORITHM$36 = new QName("http://schemas.microsoft.com/office/2006/digsig", "ManifestHashAlgorithm");

    public CTSignatureInfoV1Impl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public String getApplicationVersion() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(APPLICATIONVERSION$12, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public int getColorDepth() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(COLORDEPTH$20, 0);
            if (simpleValueFind_element_user == null) {
                return 0;
            }
            return simpleValueFind_element_user.getIntValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public String getDelegateSuggestedSigner() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(DELEGATESUGGESTEDSIGNER$30, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public String getDelegateSuggestedSigner2() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(DELEGATESUGGESTEDSIGNER2$32, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public String getDelegateSuggestedSignerEmail() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(DELEGATESUGGESTEDSIGNEREMAIL$34, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public int getHorizontalResolution() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(HORIZONTALRESOLUTION$16, 0);
            if (simpleValueFind_element_user == null) {
                return 0;
            }
            return simpleValueFind_element_user.getIntValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public String getManifestHashAlgorithm() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(MANIFESTHASHALGORITHM$36, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public int getMonitors() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(MONITORS$14, 0);
            if (simpleValueFind_element_user == null) {
                return 0;
            }
            return simpleValueFind_element_user.getIntValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public String getOfficeVersion() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(OFFICEVERSION$10, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public String getSetupID() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(SETUPID$0, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public String getSignatureComments() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(SIGNATURECOMMENTS$6, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public byte[] getSignatureImage() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(SIGNATUREIMAGE$4, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getByteArrayValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public int getSignatureProviderDetails() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(SIGNATUREPROVIDERDETAILS$26, 0);
            if (simpleValueFind_element_user == null) {
                return 0;
            }
            return simpleValueFind_element_user.getIntValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public String getSignatureProviderId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(SIGNATUREPROVIDERID$22, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public String getSignatureProviderUrl() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(SIGNATUREPROVIDERURL$24, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public String getSignatureText() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(SIGNATURETEXT$2, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public int getSignatureType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(SIGNATURETYPE$28, 0);
            if (simpleValueFind_element_user == null) {
                return 0;
            }
            return simpleValueFind_element_user.getIntValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public int getVerticalResolution() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(VERTICALRESOLUTION$18, 0);
            if (simpleValueFind_element_user == null) {
                return 0;
            }
            return simpleValueFind_element_user.getIntValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public String getWindowsVersion() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(WINDOWSVERSION$8, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public boolean isSetDelegateSuggestedSigner() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DELEGATESUGGESTEDSIGNER$30) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public boolean isSetDelegateSuggestedSigner2() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DELEGATESUGGESTEDSIGNER2$32) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public boolean isSetDelegateSuggestedSignerEmail() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DELEGATESUGGESTEDSIGNEREMAIL$34) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public boolean isSetManifestHashAlgorithm() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MANIFESTHASHALGORITHM$36) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setApplicationVersion(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = APPLICATIONVERSION$12;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setColorDepth(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLORDEPTH$20;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setIntValue(i);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setDelegateSuggestedSigner(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DELEGATESUGGESTEDSIGNER$30;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setDelegateSuggestedSigner2(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DELEGATESUGGESTEDSIGNER2$32;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setDelegateSuggestedSignerEmail(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DELEGATESUGGESTEDSIGNEREMAIL$34;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setHorizontalResolution(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HORIZONTALRESOLUTION$16;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setIntValue(i);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setManifestHashAlgorithm(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MANIFESTHASHALGORITHM$36;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setMonitors(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MONITORS$14;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setIntValue(i);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setOfficeVersion(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OFFICEVERSION$10;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setSetupID(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SETUPID$0;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setSignatureComments(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNATURECOMMENTS$6;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setSignatureImage(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNATUREIMAGE$4;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setByteArrayValue(bArr);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setSignatureProviderDetails(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNATUREPROVIDERDETAILS$26;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setIntValue(i);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setSignatureProviderId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNATUREPROVIDERID$22;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setSignatureProviderUrl(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNATUREPROVIDERURL$24;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setSignatureText(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNATURETEXT$2;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setSignatureType(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNATURETYPE$28;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setIntValue(i);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setVerticalResolution(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VERTICALRESOLUTION$18;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setIntValue(i);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setWindowsVersion(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WINDOWSVERSION$8;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void unsetDelegateSuggestedSigner() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DELEGATESUGGESTEDSIGNER$30, 0);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void unsetDelegateSuggestedSigner2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DELEGATESUGGESTEDSIGNER2$32, 0);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void unsetDelegateSuggestedSignerEmail() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DELEGATESUGGESTEDSIGNEREMAIL$34, 0);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void unsetManifestHashAlgorithm() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MANIFESTHASHALGORITHM$36, 0);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public STVersion xgetApplicationVersion() {
        STVersion sTVersionFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTVersionFind_element_user = get_store().find_element_user(APPLICATIONVERSION$12, 0);
        }
        return sTVersionFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public STPositiveInteger xgetColorDepth() {
        STPositiveInteger sTPositiveIntegerFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTPositiveIntegerFind_element_user = get_store().find_element_user(COLORDEPTH$20, 0);
        }
        return sTPositiveIntegerFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public XmlString xgetDelegateSuggestedSigner() {
        XmlString xmlStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_element_user = get_store().find_element_user(DELEGATESUGGESTEDSIGNER$30, 0);
        }
        return xmlStringFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public XmlString xgetDelegateSuggestedSigner2() {
        XmlString xmlStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_element_user = get_store().find_element_user(DELEGATESUGGESTEDSIGNER2$32, 0);
        }
        return xmlStringFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public XmlString xgetDelegateSuggestedSignerEmail() {
        XmlString xmlStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_element_user = get_store().find_element_user(DELEGATESUGGESTEDSIGNEREMAIL$34, 0);
        }
        return xmlStringFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public STPositiveInteger xgetHorizontalResolution() {
        STPositiveInteger sTPositiveIntegerFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTPositiveIntegerFind_element_user = get_store().find_element_user(HORIZONTALRESOLUTION$16, 0);
        }
        return sTPositiveIntegerFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public XmlAnyURI xgetManifestHashAlgorithm() {
        XmlAnyURI xmlAnyURIFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURIFind_element_user = get_store().find_element_user(MANIFESTHASHALGORITHM$36, 0);
        }
        return xmlAnyURIFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public STPositiveInteger xgetMonitors() {
        STPositiveInteger sTPositiveIntegerFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTPositiveIntegerFind_element_user = get_store().find_element_user(MONITORS$14, 0);
        }
        return sTPositiveIntegerFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public STVersion xgetOfficeVersion() {
        STVersion sTVersionFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTVersionFind_element_user = get_store().find_element_user(OFFICEVERSION$10, 0);
        }
        return sTVersionFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public STUniqueIdentifierWithBraces xgetSetupID() {
        STUniqueIdentifierWithBraces sTUniqueIdentifierWithBracesFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTUniqueIdentifierWithBracesFind_element_user = get_store().find_element_user(SETUPID$0, 0);
        }
        return sTUniqueIdentifierWithBracesFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public STSignatureComments xgetSignatureComments() {
        STSignatureComments sTSignatureCommentsFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTSignatureCommentsFind_element_user = get_store().find_element_user(SIGNATURECOMMENTS$6, 0);
        }
        return sTSignatureCommentsFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public XmlBase64Binary xgetSignatureImage() {
        XmlBase64Binary xmlBase64BinaryFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_element_user = get_store().find_element_user(SIGNATUREIMAGE$4, 0);
        }
        return xmlBase64BinaryFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public XmlInt xgetSignatureProviderDetails() {
        XmlInt xmlIntFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntFind_element_user = get_store().find_element_user(SIGNATUREPROVIDERDETAILS$26, 0);
        }
        return xmlIntFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public STUniqueIdentifierWithBraces xgetSignatureProviderId() {
        STUniqueIdentifierWithBraces sTUniqueIdentifierWithBracesFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTUniqueIdentifierWithBracesFind_element_user = get_store().find_element_user(SIGNATUREPROVIDERID$22, 0);
        }
        return sTUniqueIdentifierWithBracesFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public STSignatureProviderUrl xgetSignatureProviderUrl() {
        STSignatureProviderUrl sTSignatureProviderUrlFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTSignatureProviderUrlFind_element_user = get_store().find_element_user(SIGNATUREPROVIDERURL$24, 0);
        }
        return sTSignatureProviderUrlFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public STSignatureText xgetSignatureText() {
        STSignatureText sTSignatureTextFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTSignatureTextFind_element_user = get_store().find_element_user(SIGNATURETEXT$2, 0);
        }
        return sTSignatureTextFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public STSignatureType xgetSignatureType() {
        STSignatureType sTSignatureTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTSignatureTypeFind_element_user = get_store().find_element_user(SIGNATURETYPE$28, 0);
        }
        return sTSignatureTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public STPositiveInteger xgetVerticalResolution() {
        STPositiveInteger sTPositiveIntegerFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTPositiveIntegerFind_element_user = get_store().find_element_user(VERTICALRESOLUTION$18, 0);
        }
        return sTPositiveIntegerFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public STVersion xgetWindowsVersion() {
        STVersion sTVersionFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTVersionFind_element_user = get_store().find_element_user(WINDOWSVERSION$8, 0);
        }
        return sTVersionFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetApplicationVersion(STVersion sTVersion) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = APPLICATIONVERSION$12;
            STVersion sTVersionFind_element_user = typeStore.find_element_user(qName, 0);
            if (sTVersionFind_element_user == null) {
                sTVersionFind_element_user = (STVersion) get_store().add_element_user(qName);
            }
            sTVersionFind_element_user.set(sTVersion);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetColorDepth(STPositiveInteger sTPositiveInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLORDEPTH$20;
            STPositiveInteger sTPositiveIntegerFind_element_user = typeStore.find_element_user(qName, 0);
            if (sTPositiveIntegerFind_element_user == null) {
                sTPositiveIntegerFind_element_user = (STPositiveInteger) get_store().add_element_user(qName);
            }
            sTPositiveIntegerFind_element_user.set(sTPositiveInteger);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetDelegateSuggestedSigner(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DELEGATESUGGESTEDSIGNER$30;
            XmlString xmlStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlStringFind_element_user == null) {
                xmlStringFind_element_user = (XmlString) get_store().add_element_user(qName);
            }
            xmlStringFind_element_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetDelegateSuggestedSigner2(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DELEGATESUGGESTEDSIGNER2$32;
            XmlString xmlStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlStringFind_element_user == null) {
                xmlStringFind_element_user = (XmlString) get_store().add_element_user(qName);
            }
            xmlStringFind_element_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetDelegateSuggestedSignerEmail(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DELEGATESUGGESTEDSIGNEREMAIL$34;
            XmlString xmlStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlStringFind_element_user == null) {
                xmlStringFind_element_user = (XmlString) get_store().add_element_user(qName);
            }
            xmlStringFind_element_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetHorizontalResolution(STPositiveInteger sTPositiveInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HORIZONTALRESOLUTION$16;
            STPositiveInteger sTPositiveIntegerFind_element_user = typeStore.find_element_user(qName, 0);
            if (sTPositiveIntegerFind_element_user == null) {
                sTPositiveIntegerFind_element_user = (STPositiveInteger) get_store().add_element_user(qName);
            }
            sTPositiveIntegerFind_element_user.set(sTPositiveInteger);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetManifestHashAlgorithm(XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MANIFESTHASHALGORITHM$36;
            XmlAnyURI xmlAnyURIFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlAnyURIFind_element_user == null) {
                xmlAnyURIFind_element_user = (XmlAnyURI) get_store().add_element_user(qName);
            }
            xmlAnyURIFind_element_user.set(xmlAnyURI);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetMonitors(STPositiveInteger sTPositiveInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MONITORS$14;
            STPositiveInteger sTPositiveIntegerFind_element_user = typeStore.find_element_user(qName, 0);
            if (sTPositiveIntegerFind_element_user == null) {
                sTPositiveIntegerFind_element_user = (STPositiveInteger) get_store().add_element_user(qName);
            }
            sTPositiveIntegerFind_element_user.set(sTPositiveInteger);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetOfficeVersion(STVersion sTVersion) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OFFICEVERSION$10;
            STVersion sTVersionFind_element_user = typeStore.find_element_user(qName, 0);
            if (sTVersionFind_element_user == null) {
                sTVersionFind_element_user = (STVersion) get_store().add_element_user(qName);
            }
            sTVersionFind_element_user.set(sTVersion);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetSetupID(STUniqueIdentifierWithBraces sTUniqueIdentifierWithBraces) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SETUPID$0;
            STUniqueIdentifierWithBraces sTUniqueIdentifierWithBracesFind_element_user = typeStore.find_element_user(qName, 0);
            if (sTUniqueIdentifierWithBracesFind_element_user == null) {
                sTUniqueIdentifierWithBracesFind_element_user = (STUniqueIdentifierWithBraces) get_store().add_element_user(qName);
            }
            sTUniqueIdentifierWithBracesFind_element_user.set(sTUniqueIdentifierWithBraces);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetSignatureComments(STSignatureComments sTSignatureComments) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNATURECOMMENTS$6;
            STSignatureComments sTSignatureCommentsFind_element_user = typeStore.find_element_user(qName, 0);
            if (sTSignatureCommentsFind_element_user == null) {
                sTSignatureCommentsFind_element_user = (STSignatureComments) get_store().add_element_user(qName);
            }
            sTSignatureCommentsFind_element_user.set(sTSignatureComments);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetSignatureImage(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNATUREIMAGE$4;
            XmlBase64Binary xmlBase64BinaryFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlBase64BinaryFind_element_user == null) {
                xmlBase64BinaryFind_element_user = (XmlBase64Binary) get_store().add_element_user(qName);
            }
            xmlBase64BinaryFind_element_user.set(xmlBase64Binary);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetSignatureProviderDetails(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNATUREPROVIDERDETAILS$26;
            XmlInt xmlIntFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlIntFind_element_user == null) {
                xmlIntFind_element_user = (XmlInt) get_store().add_element_user(qName);
            }
            xmlIntFind_element_user.set(xmlInt);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetSignatureProviderId(STUniqueIdentifierWithBraces sTUniqueIdentifierWithBraces) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNATUREPROVIDERID$22;
            STUniqueIdentifierWithBraces sTUniqueIdentifierWithBracesFind_element_user = typeStore.find_element_user(qName, 0);
            if (sTUniqueIdentifierWithBracesFind_element_user == null) {
                sTUniqueIdentifierWithBracesFind_element_user = (STUniqueIdentifierWithBraces) get_store().add_element_user(qName);
            }
            sTUniqueIdentifierWithBracesFind_element_user.set(sTUniqueIdentifierWithBraces);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetSignatureProviderUrl(STSignatureProviderUrl sTSignatureProviderUrl) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNATUREPROVIDERURL$24;
            STSignatureProviderUrl sTSignatureProviderUrlFind_element_user = typeStore.find_element_user(qName, 0);
            if (sTSignatureProviderUrlFind_element_user == null) {
                sTSignatureProviderUrlFind_element_user = (STSignatureProviderUrl) get_store().add_element_user(qName);
            }
            sTSignatureProviderUrlFind_element_user.set(sTSignatureProviderUrl);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetSignatureText(STSignatureText sTSignatureText) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNATURETEXT$2;
            STSignatureText sTSignatureTextFind_element_user = typeStore.find_element_user(qName, 0);
            if (sTSignatureTextFind_element_user == null) {
                sTSignatureTextFind_element_user = (STSignatureText) get_store().add_element_user(qName);
            }
            sTSignatureTextFind_element_user.set(sTSignatureText);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetSignatureType(STSignatureType sTSignatureType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNATURETYPE$28;
            STSignatureType sTSignatureTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (sTSignatureTypeFind_element_user == null) {
                sTSignatureTypeFind_element_user = (STSignatureType) get_store().add_element_user(qName);
            }
            sTSignatureTypeFind_element_user.set(sTSignatureType);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetVerticalResolution(STPositiveInteger sTPositiveInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VERTICALRESOLUTION$18;
            STPositiveInteger sTPositiveIntegerFind_element_user = typeStore.find_element_user(qName, 0);
            if (sTPositiveIntegerFind_element_user == null) {
                sTPositiveIntegerFind_element_user = (STPositiveInteger) get_store().add_element_user(qName);
            }
            sTPositiveIntegerFind_element_user.set(sTPositiveInteger);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetWindowsVersion(STVersion sTVersion) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WINDOWSVERSION$8;
            STVersion sTVersionFind_element_user = typeStore.find_element_user(qName, 0);
            if (sTVersionFind_element_user == null) {
                sTVersionFind_element_user = (STVersion) get_store().add_element_user(qName);
            }
            sTVersionFind_element_user.set(sTVersion);
        }
    }
}
