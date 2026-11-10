package org.etsi.uri.x01903.v13.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.CertificateValuesType;
import org.etsi.uri.x01903.v13.CompleteCertificateRefsType;
import org.etsi.uri.x01903.v13.CompleteRevocationRefsType;
import org.etsi.uri.x01903.v13.CounterSignatureType;
import org.etsi.uri.x01903.v13.RevocationValuesType;
import org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType;
import org.etsi.uri.x01903.v13.XAdESTimeStampType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class UnsignedSignaturePropertiesTypeImpl extends XmlComplexContentImpl implements UnsignedSignaturePropertiesType {
    private static final QName COUNTERSIGNATURE$0 = new QName("http://uri.etsi.org/01903/v1.3.2#", "CounterSignature");
    private static final QName SIGNATURETIMESTAMP$2 = new QName("http://uri.etsi.org/01903/v1.3.2#", "SignatureTimeStamp");
    private static final QName COMPLETECERTIFICATEREFS$4 = new QName("http://uri.etsi.org/01903/v1.3.2#", "CompleteCertificateRefs");
    private static final QName COMPLETEREVOCATIONREFS$6 = new QName("http://uri.etsi.org/01903/v1.3.2#", "CompleteRevocationRefs");
    private static final QName ATTRIBUTECERTIFICATEREFS$8 = new QName("http://uri.etsi.org/01903/v1.3.2#", "AttributeCertificateRefs");
    private static final QName ATTRIBUTEREVOCATIONREFS$10 = new QName("http://uri.etsi.org/01903/v1.3.2#", "AttributeRevocationRefs");
    private static final QName SIGANDREFSTIMESTAMP$12 = new QName("http://uri.etsi.org/01903/v1.3.2#", "SigAndRefsTimeStamp");
    private static final QName REFSONLYTIMESTAMP$14 = new QName("http://uri.etsi.org/01903/v1.3.2#", "RefsOnlyTimeStamp");
    private static final QName CERTIFICATEVALUES$16 = new QName("http://uri.etsi.org/01903/v1.3.2#", "CertificateValues");
    private static final QName REVOCATIONVALUES$18 = new QName("http://uri.etsi.org/01903/v1.3.2#", "RevocationValues");
    private static final QName ATTRAUTHORITIESCERTVALUES$20 = new QName("http://uri.etsi.org/01903/v1.3.2#", "AttrAuthoritiesCertValues");
    private static final QName ATTRIBUTEREVOCATIONVALUES$22 = new QName("http://uri.etsi.org/01903/v1.3.2#", "AttributeRevocationValues");
    private static final QName ARCHIVETIMESTAMP$24 = new QName("http://uri.etsi.org/01903/v1.3.2#", "ArchiveTimeStamp");
    private static final QName ID$26 = new QName("", "Id");

    public UnsignedSignaturePropertiesTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public XAdESTimeStampType addNewArchiveTimeStamp() {
        XAdESTimeStampType xAdESTimeStampType;
        synchronized (monitor()) {
            check_orphaned();
            xAdESTimeStampType = (XAdESTimeStampType) get_store().add_element_user(ARCHIVETIMESTAMP$24);
        }
        return xAdESTimeStampType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CertificateValuesType addNewAttrAuthoritiesCertValues() {
        CertificateValuesType certificateValuesType;
        synchronized (monitor()) {
            check_orphaned();
            certificateValuesType = (CertificateValuesType) get_store().add_element_user(ATTRAUTHORITIESCERTVALUES$20);
        }
        return certificateValuesType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CompleteCertificateRefsType addNewAttributeCertificateRefs() {
        CompleteCertificateRefsType completeCertificateRefsType;
        synchronized (monitor()) {
            check_orphaned();
            completeCertificateRefsType = (CompleteCertificateRefsType) get_store().add_element_user(ATTRIBUTECERTIFICATEREFS$8);
        }
        return completeCertificateRefsType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CompleteRevocationRefsType addNewAttributeRevocationRefs() {
        CompleteRevocationRefsType completeRevocationRefsType;
        synchronized (monitor()) {
            check_orphaned();
            completeRevocationRefsType = (CompleteRevocationRefsType) get_store().add_element_user(ATTRIBUTEREVOCATIONREFS$10);
        }
        return completeRevocationRefsType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public RevocationValuesType addNewAttributeRevocationValues() {
        RevocationValuesType revocationValuesType;
        synchronized (monitor()) {
            check_orphaned();
            revocationValuesType = (RevocationValuesType) get_store().add_element_user(ATTRIBUTEREVOCATIONVALUES$22);
        }
        return revocationValuesType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CertificateValuesType addNewCertificateValues() {
        CertificateValuesType certificateValuesType;
        synchronized (monitor()) {
            check_orphaned();
            certificateValuesType = (CertificateValuesType) get_store().add_element_user(CERTIFICATEVALUES$16);
        }
        return certificateValuesType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CompleteCertificateRefsType addNewCompleteCertificateRefs() {
        CompleteCertificateRefsType completeCertificateRefsType;
        synchronized (monitor()) {
            check_orphaned();
            completeCertificateRefsType = (CompleteCertificateRefsType) get_store().add_element_user(COMPLETECERTIFICATEREFS$4);
        }
        return completeCertificateRefsType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CompleteRevocationRefsType addNewCompleteRevocationRefs() {
        CompleteRevocationRefsType completeRevocationRefsType;
        synchronized (monitor()) {
            check_orphaned();
            completeRevocationRefsType = (CompleteRevocationRefsType) get_store().add_element_user(COMPLETEREVOCATIONREFS$6);
        }
        return completeRevocationRefsType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CounterSignatureType addNewCounterSignature() {
        CounterSignatureType counterSignatureTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            counterSignatureTypeAdd_element_user = get_store().add_element_user(COUNTERSIGNATURE$0);
        }
        return counterSignatureTypeAdd_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public XAdESTimeStampType addNewRefsOnlyTimeStamp() {
        XAdESTimeStampType xAdESTimeStampType;
        synchronized (monitor()) {
            check_orphaned();
            xAdESTimeStampType = (XAdESTimeStampType) get_store().add_element_user(REFSONLYTIMESTAMP$14);
        }
        return xAdESTimeStampType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public RevocationValuesType addNewRevocationValues() {
        RevocationValuesType revocationValuesType;
        synchronized (monitor()) {
            check_orphaned();
            revocationValuesType = (RevocationValuesType) get_store().add_element_user(REVOCATIONVALUES$18);
        }
        return revocationValuesType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public XAdESTimeStampType addNewSigAndRefsTimeStamp() {
        XAdESTimeStampType xAdESTimeStampType;
        synchronized (monitor()) {
            check_orphaned();
            xAdESTimeStampType = (XAdESTimeStampType) get_store().add_element_user(SIGANDREFSTIMESTAMP$12);
        }
        return xAdESTimeStampType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public XAdESTimeStampType addNewSignatureTimeStamp() {
        XAdESTimeStampType xAdESTimeStampType;
        synchronized (monitor()) {
            check_orphaned();
            xAdESTimeStampType = (XAdESTimeStampType) get_store().add_element_user(SIGNATURETIMESTAMP$2);
        }
        return xAdESTimeStampType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public XAdESTimeStampType getArchiveTimeStampArray(int i) {
        XAdESTimeStampType xAdESTimeStampType;
        synchronized (monitor()) {
            check_orphaned();
            xAdESTimeStampType = (XAdESTimeStampType) get_store().find_element_user(ARCHIVETIMESTAMP$24, i);
            if (xAdESTimeStampType == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xAdESTimeStampType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public XAdESTimeStampType[] getArchiveTimeStampArray() {
        XAdESTimeStampType[] xAdESTimeStampTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ARCHIVETIMESTAMP$24, arrayList);
            xAdESTimeStampTypeArr = new XAdESTimeStampType[arrayList.size()];
            arrayList.toArray(xAdESTimeStampTypeArr);
        }
        return xAdESTimeStampTypeArr;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public List<XAdESTimeStampType> getArchiveTimeStampList() {
        1ArchiveTimeStampList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ArchiveTimeStampList(this);
        }
        return r1;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CertificateValuesType getAttrAuthoritiesCertValuesArray(int i) {
        CertificateValuesType certificateValuesType;
        synchronized (monitor()) {
            check_orphaned();
            certificateValuesType = (CertificateValuesType) get_store().find_element_user(ATTRAUTHORITIESCERTVALUES$20, i);
            if (certificateValuesType == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return certificateValuesType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CertificateValuesType[] getAttrAuthoritiesCertValuesArray() {
        CertificateValuesType[] certificateValuesTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ATTRAUTHORITIESCERTVALUES$20, arrayList);
            certificateValuesTypeArr = new CertificateValuesType[arrayList.size()];
            arrayList.toArray(certificateValuesTypeArr);
        }
        return certificateValuesTypeArr;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public List<CertificateValuesType> getAttrAuthoritiesCertValuesList() {
        1AttrAuthoritiesCertValuesList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AttrAuthoritiesCertValuesList(this);
        }
        return r1;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CompleteCertificateRefsType getAttributeCertificateRefsArray(int i) {
        CompleteCertificateRefsType completeCertificateRefsType;
        synchronized (monitor()) {
            check_orphaned();
            completeCertificateRefsType = (CompleteCertificateRefsType) get_store().find_element_user(ATTRIBUTECERTIFICATEREFS$8, i);
            if (completeCertificateRefsType == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return completeCertificateRefsType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CompleteCertificateRefsType[] getAttributeCertificateRefsArray() {
        CompleteCertificateRefsType[] completeCertificateRefsTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ATTRIBUTECERTIFICATEREFS$8, arrayList);
            completeCertificateRefsTypeArr = new CompleteCertificateRefsType[arrayList.size()];
            arrayList.toArray(completeCertificateRefsTypeArr);
        }
        return completeCertificateRefsTypeArr;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public List<CompleteCertificateRefsType> getAttributeCertificateRefsList() {
        1AttributeCertificateRefsList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AttributeCertificateRefsList(this);
        }
        return r1;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CompleteRevocationRefsType getAttributeRevocationRefsArray(int i) {
        CompleteRevocationRefsType completeRevocationRefsType;
        synchronized (monitor()) {
            check_orphaned();
            completeRevocationRefsType = (CompleteRevocationRefsType) get_store().find_element_user(ATTRIBUTEREVOCATIONREFS$10, i);
            if (completeRevocationRefsType == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return completeRevocationRefsType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CompleteRevocationRefsType[] getAttributeRevocationRefsArray() {
        CompleteRevocationRefsType[] completeRevocationRefsTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ATTRIBUTEREVOCATIONREFS$10, arrayList);
            completeRevocationRefsTypeArr = new CompleteRevocationRefsType[arrayList.size()];
            arrayList.toArray(completeRevocationRefsTypeArr);
        }
        return completeRevocationRefsTypeArr;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public List<CompleteRevocationRefsType> getAttributeRevocationRefsList() {
        1AttributeRevocationRefsList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AttributeRevocationRefsList(this);
        }
        return r1;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public RevocationValuesType getAttributeRevocationValuesArray(int i) {
        RevocationValuesType revocationValuesType;
        synchronized (monitor()) {
            check_orphaned();
            revocationValuesType = (RevocationValuesType) get_store().find_element_user(ATTRIBUTEREVOCATIONVALUES$22, i);
            if (revocationValuesType == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return revocationValuesType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public RevocationValuesType[] getAttributeRevocationValuesArray() {
        RevocationValuesType[] revocationValuesTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ATTRIBUTEREVOCATIONVALUES$22, arrayList);
            revocationValuesTypeArr = new RevocationValuesType[arrayList.size()];
            arrayList.toArray(revocationValuesTypeArr);
        }
        return revocationValuesTypeArr;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public List<RevocationValuesType> getAttributeRevocationValuesList() {
        1AttributeRevocationValuesList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AttributeRevocationValuesList(this);
        }
        return r1;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CertificateValuesType getCertificateValuesArray(int i) {
        CertificateValuesType certificateValuesType;
        synchronized (monitor()) {
            check_orphaned();
            certificateValuesType = (CertificateValuesType) get_store().find_element_user(CERTIFICATEVALUES$16, i);
            if (certificateValuesType == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return certificateValuesType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CertificateValuesType[] getCertificateValuesArray() {
        CertificateValuesType[] certificateValuesTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CERTIFICATEVALUES$16, arrayList);
            certificateValuesTypeArr = new CertificateValuesType[arrayList.size()];
            arrayList.toArray(certificateValuesTypeArr);
        }
        return certificateValuesTypeArr;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public List<CertificateValuesType> getCertificateValuesList() {
        1CertificateValuesList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CertificateValuesList(this);
        }
        return r1;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CompleteCertificateRefsType getCompleteCertificateRefsArray(int i) {
        CompleteCertificateRefsType completeCertificateRefsType;
        synchronized (monitor()) {
            check_orphaned();
            completeCertificateRefsType = (CompleteCertificateRefsType) get_store().find_element_user(COMPLETECERTIFICATEREFS$4, i);
            if (completeCertificateRefsType == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return completeCertificateRefsType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CompleteCertificateRefsType[] getCompleteCertificateRefsArray() {
        CompleteCertificateRefsType[] completeCertificateRefsTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COMPLETECERTIFICATEREFS$4, arrayList);
            completeCertificateRefsTypeArr = new CompleteCertificateRefsType[arrayList.size()];
            arrayList.toArray(completeCertificateRefsTypeArr);
        }
        return completeCertificateRefsTypeArr;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public List<CompleteCertificateRefsType> getCompleteCertificateRefsList() {
        1CompleteCertificateRefsList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CompleteCertificateRefsList(this);
        }
        return r1;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CompleteRevocationRefsType getCompleteRevocationRefsArray(int i) {
        CompleteRevocationRefsType completeRevocationRefsType;
        synchronized (monitor()) {
            check_orphaned();
            completeRevocationRefsType = (CompleteRevocationRefsType) get_store().find_element_user(COMPLETEREVOCATIONREFS$6, i);
            if (completeRevocationRefsType == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return completeRevocationRefsType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CompleteRevocationRefsType[] getCompleteRevocationRefsArray() {
        CompleteRevocationRefsType[] completeRevocationRefsTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COMPLETEREVOCATIONREFS$6, arrayList);
            completeRevocationRefsTypeArr = new CompleteRevocationRefsType[arrayList.size()];
            arrayList.toArray(completeRevocationRefsTypeArr);
        }
        return completeRevocationRefsTypeArr;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public List<CompleteRevocationRefsType> getCompleteRevocationRefsList() {
        1CompleteRevocationRefsList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CompleteRevocationRefsList(this);
        }
        return r1;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CounterSignatureType getCounterSignatureArray(int i) {
        CounterSignatureType counterSignatureTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            counterSignatureTypeFind_element_user = get_store().find_element_user(COUNTERSIGNATURE$0, i);
            if (counterSignatureTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return counterSignatureTypeFind_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CounterSignatureType[] getCounterSignatureArray() {
        CounterSignatureType[] counterSignatureTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COUNTERSIGNATURE$0, arrayList);
            counterSignatureTypeArr = new CounterSignatureType[arrayList.size()];
            arrayList.toArray(counterSignatureTypeArr);
        }
        return counterSignatureTypeArr;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public List<CounterSignatureType> getCounterSignatureList() {
        1CounterSignatureList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CounterSignatureList(this);
        }
        return r1;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$26);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public XAdESTimeStampType getRefsOnlyTimeStampArray(int i) {
        XAdESTimeStampType xAdESTimeStampType;
        synchronized (monitor()) {
            check_orphaned();
            xAdESTimeStampType = (XAdESTimeStampType) get_store().find_element_user(REFSONLYTIMESTAMP$14, i);
            if (xAdESTimeStampType == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xAdESTimeStampType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public XAdESTimeStampType[] getRefsOnlyTimeStampArray() {
        XAdESTimeStampType[] xAdESTimeStampTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(REFSONLYTIMESTAMP$14, arrayList);
            xAdESTimeStampTypeArr = new XAdESTimeStampType[arrayList.size()];
            arrayList.toArray(xAdESTimeStampTypeArr);
        }
        return xAdESTimeStampTypeArr;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public List<XAdESTimeStampType> getRefsOnlyTimeStampList() {
        1RefsOnlyTimeStampList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RefsOnlyTimeStampList(this);
        }
        return r1;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public RevocationValuesType getRevocationValuesArray(int i) {
        RevocationValuesType revocationValuesType;
        synchronized (monitor()) {
            check_orphaned();
            revocationValuesType = (RevocationValuesType) get_store().find_element_user(REVOCATIONVALUES$18, i);
            if (revocationValuesType == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return revocationValuesType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public RevocationValuesType[] getRevocationValuesArray() {
        RevocationValuesType[] revocationValuesTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(REVOCATIONVALUES$18, arrayList);
            revocationValuesTypeArr = new RevocationValuesType[arrayList.size()];
            arrayList.toArray(revocationValuesTypeArr);
        }
        return revocationValuesTypeArr;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public List<RevocationValuesType> getRevocationValuesList() {
        1RevocationValuesList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RevocationValuesList(this);
        }
        return r1;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public XAdESTimeStampType getSigAndRefsTimeStampArray(int i) {
        XAdESTimeStampType xAdESTimeStampType;
        synchronized (monitor()) {
            check_orphaned();
            xAdESTimeStampType = (XAdESTimeStampType) get_store().find_element_user(SIGANDREFSTIMESTAMP$12, i);
            if (xAdESTimeStampType == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xAdESTimeStampType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public XAdESTimeStampType[] getSigAndRefsTimeStampArray() {
        XAdESTimeStampType[] xAdESTimeStampTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SIGANDREFSTIMESTAMP$12, arrayList);
            xAdESTimeStampTypeArr = new XAdESTimeStampType[arrayList.size()];
            arrayList.toArray(xAdESTimeStampTypeArr);
        }
        return xAdESTimeStampTypeArr;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public List<XAdESTimeStampType> getSigAndRefsTimeStampList() {
        1SigAndRefsTimeStampList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SigAndRefsTimeStampList(this);
        }
        return r1;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public XAdESTimeStampType getSignatureTimeStampArray(int i) {
        XAdESTimeStampType xAdESTimeStampType;
        synchronized (monitor()) {
            check_orphaned();
            xAdESTimeStampType = (XAdESTimeStampType) get_store().find_element_user(SIGNATURETIMESTAMP$2, i);
            if (xAdESTimeStampType == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xAdESTimeStampType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public XAdESTimeStampType[] getSignatureTimeStampArray() {
        XAdESTimeStampType[] xAdESTimeStampTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SIGNATURETIMESTAMP$2, arrayList);
            xAdESTimeStampTypeArr = new XAdESTimeStampType[arrayList.size()];
            arrayList.toArray(xAdESTimeStampTypeArr);
        }
        return xAdESTimeStampTypeArr;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public List<XAdESTimeStampType> getSignatureTimeStampList() {
        1SignatureTimeStampList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SignatureTimeStampList(this);
        }
        return r1;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public XAdESTimeStampType insertNewArchiveTimeStamp(int i) {
        XAdESTimeStampType xAdESTimeStampType;
        synchronized (monitor()) {
            check_orphaned();
            xAdESTimeStampType = (XAdESTimeStampType) get_store().insert_element_user(ARCHIVETIMESTAMP$24, i);
        }
        return xAdESTimeStampType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CertificateValuesType insertNewAttrAuthoritiesCertValues(int i) {
        CertificateValuesType certificateValuesType;
        synchronized (monitor()) {
            check_orphaned();
            certificateValuesType = (CertificateValuesType) get_store().insert_element_user(ATTRAUTHORITIESCERTVALUES$20, i);
        }
        return certificateValuesType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CompleteCertificateRefsType insertNewAttributeCertificateRefs(int i) {
        CompleteCertificateRefsType completeCertificateRefsType;
        synchronized (monitor()) {
            check_orphaned();
            completeCertificateRefsType = (CompleteCertificateRefsType) get_store().insert_element_user(ATTRIBUTECERTIFICATEREFS$8, i);
        }
        return completeCertificateRefsType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CompleteRevocationRefsType insertNewAttributeRevocationRefs(int i) {
        CompleteRevocationRefsType completeRevocationRefsType;
        synchronized (monitor()) {
            check_orphaned();
            completeRevocationRefsType = (CompleteRevocationRefsType) get_store().insert_element_user(ATTRIBUTEREVOCATIONREFS$10, i);
        }
        return completeRevocationRefsType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public RevocationValuesType insertNewAttributeRevocationValues(int i) {
        RevocationValuesType revocationValuesType;
        synchronized (monitor()) {
            check_orphaned();
            revocationValuesType = (RevocationValuesType) get_store().insert_element_user(ATTRIBUTEREVOCATIONVALUES$22, i);
        }
        return revocationValuesType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CertificateValuesType insertNewCertificateValues(int i) {
        CertificateValuesType certificateValuesType;
        synchronized (monitor()) {
            check_orphaned();
            certificateValuesType = (CertificateValuesType) get_store().insert_element_user(CERTIFICATEVALUES$16, i);
        }
        return certificateValuesType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CompleteCertificateRefsType insertNewCompleteCertificateRefs(int i) {
        CompleteCertificateRefsType completeCertificateRefsType;
        synchronized (monitor()) {
            check_orphaned();
            completeCertificateRefsType = (CompleteCertificateRefsType) get_store().insert_element_user(COMPLETECERTIFICATEREFS$4, i);
        }
        return completeCertificateRefsType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CompleteRevocationRefsType insertNewCompleteRevocationRefs(int i) {
        CompleteRevocationRefsType completeRevocationRefsType;
        synchronized (monitor()) {
            check_orphaned();
            completeRevocationRefsType = (CompleteRevocationRefsType) get_store().insert_element_user(COMPLETEREVOCATIONREFS$6, i);
        }
        return completeRevocationRefsType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public CounterSignatureType insertNewCounterSignature(int i) {
        CounterSignatureType counterSignatureTypeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            counterSignatureTypeInsert_element_user = get_store().insert_element_user(COUNTERSIGNATURE$0, i);
        }
        return counterSignatureTypeInsert_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public XAdESTimeStampType insertNewRefsOnlyTimeStamp(int i) {
        XAdESTimeStampType xAdESTimeStampType;
        synchronized (monitor()) {
            check_orphaned();
            xAdESTimeStampType = (XAdESTimeStampType) get_store().insert_element_user(REFSONLYTIMESTAMP$14, i);
        }
        return xAdESTimeStampType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public RevocationValuesType insertNewRevocationValues(int i) {
        RevocationValuesType revocationValuesType;
        synchronized (monitor()) {
            check_orphaned();
            revocationValuesType = (RevocationValuesType) get_store().insert_element_user(REVOCATIONVALUES$18, i);
        }
        return revocationValuesType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public XAdESTimeStampType insertNewSigAndRefsTimeStamp(int i) {
        XAdESTimeStampType xAdESTimeStampType;
        synchronized (monitor()) {
            check_orphaned();
            xAdESTimeStampType = (XAdESTimeStampType) get_store().insert_element_user(SIGANDREFSTIMESTAMP$12, i);
        }
        return xAdESTimeStampType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public XAdESTimeStampType insertNewSignatureTimeStamp(int i) {
        XAdESTimeStampType xAdESTimeStampType;
        synchronized (monitor()) {
            check_orphaned();
            xAdESTimeStampType = (XAdESTimeStampType) get_store().insert_element_user(SIGNATURETIMESTAMP$2, i);
        }
        return xAdESTimeStampType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$26) != null;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void removeArchiveTimeStamp(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ARCHIVETIMESTAMP$24, i);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void removeAttrAuthoritiesCertValues(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ATTRAUTHORITIESCERTVALUES$20, i);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void removeAttributeCertificateRefs(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ATTRIBUTECERTIFICATEREFS$8, i);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void removeAttributeRevocationRefs(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ATTRIBUTEREVOCATIONREFS$10, i);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void removeAttributeRevocationValues(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ATTRIBUTEREVOCATIONVALUES$22, i);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void removeCertificateValues(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CERTIFICATEVALUES$16, i);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void removeCompleteCertificateRefs(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMPLETECERTIFICATEREFS$4, i);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void removeCompleteRevocationRefs(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMPLETEREVOCATIONREFS$6, i);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void removeCounterSignature(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COUNTERSIGNATURE$0, i);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void removeRefsOnlyTimeStamp(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(REFSONLYTIMESTAMP$14, i);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void removeRevocationValues(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(REVOCATIONVALUES$18, i);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void removeSigAndRefsTimeStamp(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIGANDREFSTIMESTAMP$12, i);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void removeSignatureTimeStamp(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIGNATURETIMESTAMP$2, i);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setArchiveTimeStampArray(int i, XAdESTimeStampType xAdESTimeStampType) {
        synchronized (monitor()) {
            check_orphaned();
            XAdESTimeStampType xAdESTimeStampType2 = (XAdESTimeStampType) get_store().find_element_user(ARCHIVETIMESTAMP$24, i);
            if (xAdESTimeStampType2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xAdESTimeStampType2.set(xAdESTimeStampType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setArchiveTimeStampArray(XAdESTimeStampType[] xAdESTimeStampTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xAdESTimeStampTypeArr, ARCHIVETIMESTAMP$24);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setAttrAuthoritiesCertValuesArray(int i, CertificateValuesType certificateValuesType) {
        synchronized (monitor()) {
            check_orphaned();
            CertificateValuesType certificateValuesType2 = (CertificateValuesType) get_store().find_element_user(ATTRAUTHORITIESCERTVALUES$20, i);
            if (certificateValuesType2 == null) {
                throw new IndexOutOfBoundsException();
            }
            certificateValuesType2.set(certificateValuesType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setAttrAuthoritiesCertValuesArray(CertificateValuesType[] certificateValuesTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(certificateValuesTypeArr, ATTRAUTHORITIESCERTVALUES$20);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setAttributeCertificateRefsArray(int i, CompleteCertificateRefsType completeCertificateRefsType) {
        synchronized (monitor()) {
            check_orphaned();
            CompleteCertificateRefsType completeCertificateRefsType2 = (CompleteCertificateRefsType) get_store().find_element_user(ATTRIBUTECERTIFICATEREFS$8, i);
            if (completeCertificateRefsType2 == null) {
                throw new IndexOutOfBoundsException();
            }
            completeCertificateRefsType2.set(completeCertificateRefsType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setAttributeCertificateRefsArray(CompleteCertificateRefsType[] completeCertificateRefsTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(completeCertificateRefsTypeArr, ATTRIBUTECERTIFICATEREFS$8);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setAttributeRevocationRefsArray(int i, CompleteRevocationRefsType completeRevocationRefsType) {
        synchronized (monitor()) {
            check_orphaned();
            CompleteRevocationRefsType completeRevocationRefsType2 = (CompleteRevocationRefsType) get_store().find_element_user(ATTRIBUTEREVOCATIONREFS$10, i);
            if (completeRevocationRefsType2 == null) {
                throw new IndexOutOfBoundsException();
            }
            completeRevocationRefsType2.set(completeRevocationRefsType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setAttributeRevocationRefsArray(CompleteRevocationRefsType[] completeRevocationRefsTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(completeRevocationRefsTypeArr, ATTRIBUTEREVOCATIONREFS$10);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setAttributeRevocationValuesArray(int i, RevocationValuesType revocationValuesType) {
        synchronized (monitor()) {
            check_orphaned();
            RevocationValuesType revocationValuesType2 = (RevocationValuesType) get_store().find_element_user(ATTRIBUTEREVOCATIONVALUES$22, i);
            if (revocationValuesType2 == null) {
                throw new IndexOutOfBoundsException();
            }
            revocationValuesType2.set(revocationValuesType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setAttributeRevocationValuesArray(RevocationValuesType[] revocationValuesTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(revocationValuesTypeArr, ATTRIBUTEREVOCATIONVALUES$22);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setCertificateValuesArray(int i, CertificateValuesType certificateValuesType) {
        synchronized (monitor()) {
            check_orphaned();
            CertificateValuesType certificateValuesType2 = (CertificateValuesType) get_store().find_element_user(CERTIFICATEVALUES$16, i);
            if (certificateValuesType2 == null) {
                throw new IndexOutOfBoundsException();
            }
            certificateValuesType2.set(certificateValuesType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setCertificateValuesArray(CertificateValuesType[] certificateValuesTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(certificateValuesTypeArr, CERTIFICATEVALUES$16);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setCompleteCertificateRefsArray(int i, CompleteCertificateRefsType completeCertificateRefsType) {
        synchronized (monitor()) {
            check_orphaned();
            CompleteCertificateRefsType completeCertificateRefsType2 = (CompleteCertificateRefsType) get_store().find_element_user(COMPLETECERTIFICATEREFS$4, i);
            if (completeCertificateRefsType2 == null) {
                throw new IndexOutOfBoundsException();
            }
            completeCertificateRefsType2.set(completeCertificateRefsType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setCompleteCertificateRefsArray(CompleteCertificateRefsType[] completeCertificateRefsTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(completeCertificateRefsTypeArr, COMPLETECERTIFICATEREFS$4);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setCompleteRevocationRefsArray(int i, CompleteRevocationRefsType completeRevocationRefsType) {
        synchronized (monitor()) {
            check_orphaned();
            CompleteRevocationRefsType completeRevocationRefsType2 = (CompleteRevocationRefsType) get_store().find_element_user(COMPLETEREVOCATIONREFS$6, i);
            if (completeRevocationRefsType2 == null) {
                throw new IndexOutOfBoundsException();
            }
            completeRevocationRefsType2.set(completeRevocationRefsType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setCompleteRevocationRefsArray(CompleteRevocationRefsType[] completeRevocationRefsTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(completeRevocationRefsTypeArr, COMPLETEREVOCATIONREFS$6);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setCounterSignatureArray(int i, CounterSignatureType counterSignatureType) {
        synchronized (monitor()) {
            check_orphaned();
            CounterSignatureType counterSignatureTypeFind_element_user = get_store().find_element_user(COUNTERSIGNATURE$0, i);
            if (counterSignatureTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            counterSignatureTypeFind_element_user.set(counterSignatureType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setCounterSignatureArray(CounterSignatureType[] counterSignatureTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) counterSignatureTypeArr, COUNTERSIGNATURE$0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$26;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setRefsOnlyTimeStampArray(int i, XAdESTimeStampType xAdESTimeStampType) {
        synchronized (monitor()) {
            check_orphaned();
            XAdESTimeStampType xAdESTimeStampType2 = (XAdESTimeStampType) get_store().find_element_user(REFSONLYTIMESTAMP$14, i);
            if (xAdESTimeStampType2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xAdESTimeStampType2.set(xAdESTimeStampType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setRefsOnlyTimeStampArray(XAdESTimeStampType[] xAdESTimeStampTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xAdESTimeStampTypeArr, REFSONLYTIMESTAMP$14);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setRevocationValuesArray(int i, RevocationValuesType revocationValuesType) {
        synchronized (monitor()) {
            check_orphaned();
            RevocationValuesType revocationValuesType2 = (RevocationValuesType) get_store().find_element_user(REVOCATIONVALUES$18, i);
            if (revocationValuesType2 == null) {
                throw new IndexOutOfBoundsException();
            }
            revocationValuesType2.set(revocationValuesType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setRevocationValuesArray(RevocationValuesType[] revocationValuesTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(revocationValuesTypeArr, REVOCATIONVALUES$18);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setSigAndRefsTimeStampArray(int i, XAdESTimeStampType xAdESTimeStampType) {
        synchronized (monitor()) {
            check_orphaned();
            XAdESTimeStampType xAdESTimeStampType2 = (XAdESTimeStampType) get_store().find_element_user(SIGANDREFSTIMESTAMP$12, i);
            if (xAdESTimeStampType2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xAdESTimeStampType2.set(xAdESTimeStampType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setSigAndRefsTimeStampArray(XAdESTimeStampType[] xAdESTimeStampTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xAdESTimeStampTypeArr, SIGANDREFSTIMESTAMP$12);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setSignatureTimeStampArray(int i, XAdESTimeStampType xAdESTimeStampType) {
        synchronized (monitor()) {
            check_orphaned();
            XAdESTimeStampType xAdESTimeStampType2 = (XAdESTimeStampType) get_store().find_element_user(SIGNATURETIMESTAMP$2, i);
            if (xAdESTimeStampType2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xAdESTimeStampType2.set(xAdESTimeStampType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void setSignatureTimeStampArray(XAdESTimeStampType[] xAdESTimeStampTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xAdESTimeStampTypeArr, SIGNATURETIMESTAMP$2);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public int sizeOfArchiveTimeStampArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ARCHIVETIMESTAMP$24);
        }
        return iCount_elements;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public int sizeOfAttrAuthoritiesCertValuesArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ATTRAUTHORITIESCERTVALUES$20);
        }
        return iCount_elements;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public int sizeOfAttributeCertificateRefsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ATTRIBUTECERTIFICATEREFS$8);
        }
        return iCount_elements;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public int sizeOfAttributeRevocationRefsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ATTRIBUTEREVOCATIONREFS$10);
        }
        return iCount_elements;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public int sizeOfAttributeRevocationValuesArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ATTRIBUTEREVOCATIONVALUES$22);
        }
        return iCount_elements;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public int sizeOfCertificateValuesArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CERTIFICATEVALUES$16);
        }
        return iCount_elements;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public int sizeOfCompleteCertificateRefsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COMPLETECERTIFICATEREFS$4);
        }
        return iCount_elements;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public int sizeOfCompleteRevocationRefsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COMPLETEREVOCATIONREFS$6);
        }
        return iCount_elements;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public int sizeOfCounterSignatureArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COUNTERSIGNATURE$0);
        }
        return iCount_elements;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public int sizeOfRefsOnlyTimeStampArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(REFSONLYTIMESTAMP$14);
        }
        return iCount_elements;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public int sizeOfRevocationValuesArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(REVOCATIONVALUES$18);
        }
        return iCount_elements;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public int sizeOfSigAndRefsTimeStampArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SIGANDREFSTIMESTAMP$12);
        }
        return iCount_elements;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public int sizeOfSignatureTimeStampArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SIGNATURETIMESTAMP$2);
        }
        return iCount_elements;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$26);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public XmlID xgetId() {
        XmlID xmlIDFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIDFind_attribute_user = get_store().find_attribute_user(ID$26);
        }
        return xmlIDFind_attribute_user;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType
    public void xsetId(XmlID xmlID) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$26;
            XmlID xmlIDFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIDFind_attribute_user == null) {
                xmlIDFind_attribute_user = (XmlID) get_store().add_attribute_user(qName);
            }
            xmlIDFind_attribute_user.set(xmlID);
        }
    }
}
