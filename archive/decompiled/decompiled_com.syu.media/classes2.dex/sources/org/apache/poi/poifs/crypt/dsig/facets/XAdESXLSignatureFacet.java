package org.apache.poi.poifs.crypt.dsig.facets;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.CRLException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import javax.xml.crypto.MarshalException;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.poifs.crypt.dsig.services.RevocationData;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.xml.security.c14n.Canonicalizer;
import org.apache.xmlbeans.XmlException;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.cert.ocsp.BasicOCSPResp;
import org.bouncycastle.cert.ocsp.OCSPResp;
import org.etsi.uri.x01903.v13.CRLIdentifierType;
import org.etsi.uri.x01903.v13.CRLRefType;
import org.etsi.uri.x01903.v13.CRLRefsType;
import org.etsi.uri.x01903.v13.CRLValuesType;
import org.etsi.uri.x01903.v13.CertIDListType;
import org.etsi.uri.x01903.v13.CertificateValuesType;
import org.etsi.uri.x01903.v13.CompleteCertificateRefsType;
import org.etsi.uri.x01903.v13.CompleteRevocationRefsType;
import org.etsi.uri.x01903.v13.EncapsulatedPKIDataType;
import org.etsi.uri.x01903.v13.OCSPIdentifierType;
import org.etsi.uri.x01903.v13.OCSPRefType;
import org.etsi.uri.x01903.v13.OCSPRefsType;
import org.etsi.uri.x01903.v13.OCSPValuesType;
import org.etsi.uri.x01903.v13.QualifyingPropertiesDocument;
import org.etsi.uri.x01903.v13.QualifyingPropertiesType;
import org.etsi.uri.x01903.v13.ResponderIDType;
import org.etsi.uri.x01903.v13.RevocationValuesType;
import org.etsi.uri.x01903.v13.UnsignedPropertiesType;
import org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType;
import org.etsi.uri.x01903.v13.XAdESTimeStampType;
import org.etsi.uri.x01903.v14.ValidationDataType;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XAdESXLSignatureFacet extends SignatureFacet {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) XAdESXLSignatureFacet.class);
    private final CertificateFactory certificateFactory;

    public XAdESXLSignatureFacet() {
        try {
            this.certificateFactory = CertificateFactory.getInstance("X.509");
        } catch (CertificateException e) {
            throw new RuntimeException("X509 JCA error: " + e.getMessage(), e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.MarshalException */
    @Override // org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet
    public void postSign(Document document) throws MarshalException {
        POILogger pOILogger = LOG;
        pOILogger.log(1, "XAdES-X-L post sign phase");
        NodeList elementsByTagNameNS = document.getElementsByTagNameNS(SignatureFacet.XADES_132_NS, "QualifyingProperties");
        if (elementsByTagNameNS.getLength() == 1) {
            try {
                QualifyingPropertiesType qualifyingProperties = QualifyingPropertiesDocument.Factory.parse(elementsByTagNameNS.item(0), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getQualifyingProperties();
                UnsignedPropertiesType unsignedProperties = qualifyingProperties.getUnsignedProperties();
                if (unsignedProperties == null) {
                    unsignedProperties = qualifyingProperties.addNewUnsignedProperties();
                }
                UnsignedSignaturePropertiesType unsignedSignatureProperties = unsignedProperties.getUnsignedSignatureProperties();
                if (unsignedSignatureProperties == null) {
                    unsignedSignatureProperties = unsignedProperties.addNewUnsignedSignatureProperties();
                }
                NodeList elementsByTagNameNS2 = document.getElementsByTagNameNS(SignatureFacet.XML_DIGSIG_NS, "SignatureValue");
                if (elementsByTagNameNS2.getLength() != 1) {
                    throw new IllegalArgumentException("SignatureValue is not set.");
                }
                RevocationData revocationData = new RevocationData();
                pOILogger.log(1, "creating XAdES-T time-stamp");
                XAdESTimeStampType xAdESTimeStampTypeCreateXAdESTimeStamp = createXAdESTimeStamp(Collections.singletonList(elementsByTagNameNS2.item(0)), revocationData);
                unsignedSignatureProperties.addNewSignatureTimeStamp().set(xAdESTimeStampTypeCreateXAdESTimeStamp);
                if (revocationData.hasRevocationDataEntries()) {
                    XAdESSignatureFacet.insertXChild(unsignedSignatureProperties, createValidationData(revocationData));
                }
                if (this.signatureConfig.getRevocationDataService() == null) {
                    return;
                }
                CompleteCertificateRefsType completeCertificateRefsTypeAddNewCompleteCertificateRefs = unsignedSignatureProperties.addNewCompleteCertificateRefs();
                CertIDListType certIDListTypeAddNewCertRefs = completeCertificateRefsTypeAddNewCompleteCertificateRefs.addNewCertRefs();
                List<X509Certificate> signingCertificateChain = this.signatureConfig.getSigningCertificateChain();
                int size = signingCertificateChain.size();
                if (size > 1) {
                    Iterator<X509Certificate> it = signingCertificateChain.subList(1, size).iterator();
                    while (it.hasNext()) {
                        XAdESSignatureFacet.setCertID(certIDListTypeAddNewCertRefs.addNewCert(), this.signatureConfig, false, it.next());
                    }
                }
                CompleteRevocationRefsType completeRevocationRefsTypeAddNewCompleteRevocationRefs = unsignedSignatureProperties.addNewCompleteRevocationRefs();
                RevocationData revocationData2 = this.signatureConfig.getRevocationDataService().getRevocationData(signingCertificateChain);
                if (revocationData2.hasCRLs()) {
                    CRLRefsType cRLRefsTypeAddNewCRLRefs = completeRevocationRefsTypeAddNewCompleteRevocationRefs.addNewCRLRefs();
                    completeRevocationRefsTypeAddNewCompleteRevocationRefs.setCRLRefs(cRLRefsTypeAddNewCRLRefs);
                    for (Iterator<byte[]> it2 = revocationData2.getCRLs().iterator(); it2.hasNext(); it2 = it2) {
                        byte[] next = it2.next();
                        CRLRefType cRLRefTypeAddNewCRLRef = cRLRefsTypeAddNewCRLRefs.addNewCRLRef();
                        try {
                            CRLRefsType cRLRefsType = cRLRefsTypeAddNewCRLRefs;
                            X509CRL x509crl = (X509CRL) this.certificateFactory.generateCRL(new ByteArrayInputStream(next));
                            CRLIdentifierType cRLIdentifierTypeAddNewCRLIdentifier = cRLRefTypeAddNewCRLRef.addNewCRLIdentifier();
                            cRLIdentifierTypeAddNewCRLIdentifier.setIssuer(x509crl.getIssuerDN().getName().replace(",", ", "));
                            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Z"), Locale.ROOT);
                            calendar.setTime(x509crl.getThisUpdate());
                            cRLIdentifierTypeAddNewCRLIdentifier.setIssueTime(calendar);
                            cRLIdentifierTypeAddNewCRLIdentifier.setNumber(getCrlNumber(x509crl));
                            XAdESSignatureFacet.setDigestAlgAndValue(cRLRefTypeAddNewCRLRef.addNewDigestAlgAndValue(), next, this.signatureConfig.getDigestAlgo());
                            cRLRefsTypeAddNewCRLRefs = cRLRefsType;
                            elementsByTagNameNS = elementsByTagNameNS;
                        } catch (CRLException e) {
                            throw new RuntimeException("CRL parse error: " + e.getMessage(), e);
                        }
                    }
                }
                NodeList nodeList = elementsByTagNameNS;
                if (revocationData2.hasOCSPs()) {
                    OCSPRefsType oCSPRefsTypeAddNewOCSPRefs = completeRevocationRefsTypeAddNewCompleteRevocationRefs.addNewOCSPRefs();
                    for (byte[] bArr : revocationData2.getOCSPs()) {
                        try {
                            OCSPRefType oCSPRefTypeAddNewOCSPRef = oCSPRefsTypeAddNewOCSPRefs.addNewOCSPRef();
                            XAdESSignatureFacet.setDigestAlgAndValue(oCSPRefTypeAddNewOCSPRef.addNewDigestAlgAndValue(), bArr, this.signatureConfig.getDigestAlgo());
                            OCSPIdentifierType oCSPIdentifierTypeAddNewOCSPIdentifier = oCSPRefTypeAddNewOCSPRef.addNewOCSPIdentifier();
                            BasicOCSPResp basicOCSPResp = (BasicOCSPResp) new OCSPResp(bArr).getResponseObject();
                            Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("Z"), Locale.ROOT);
                            calendar2.setTime(basicOCSPResp.getProducedAt());
                            oCSPIdentifierTypeAddNewOCSPIdentifier.setProducedAt(calendar2);
                            ResponderIDType responderIDTypeAddNewResponderID = oCSPIdentifierTypeAddNewOCSPIdentifier.addNewResponderID();
                            DERTaggedObject aSN1Primitive = basicOCSPResp.getResponderId().toASN1Primitive().toASN1Primitive();
                            if (2 == aSN1Primitive.getTagNo()) {
                                responderIDTypeAddNewResponderID.setByKey(aSN1Primitive.getObject().getOctets());
                            } else {
                                responderIDTypeAddNewResponderID.setByName(X500Name.getInstance(aSN1Primitive.getObject()).toString());
                            }
                        } catch (Exception e2) {
                            throw new RuntimeException("OCSP decoding error: " + e2.getMessage(), e2);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(elementsByTagNameNS2.item(0));
                arrayList.add(xAdESTimeStampTypeCreateXAdESTimeStamp.getDomNode());
                arrayList.add(completeCertificateRefsTypeAddNewCompleteCertificateRefs.getDomNode());
                arrayList.add(completeRevocationRefsTypeAddNewCompleteRevocationRefs.getDomNode());
                RevocationData revocationData3 = new RevocationData();
                LOG.log(1, "creating XAdES-X time-stamp");
                XAdESTimeStampType xAdESTimeStampTypeCreateXAdESTimeStamp2 = createXAdESTimeStamp(arrayList, revocationData3);
                if (revocationData3.hasRevocationDataEntries()) {
                    XAdESSignatureFacet.insertXChild(unsignedSignatureProperties, createValidationData(revocationData3));
                }
                unsignedSignatureProperties.addNewSigAndRefsTimeStamp().set(xAdESTimeStampTypeCreateXAdESTimeStamp2);
                CertificateValuesType certificateValuesTypeAddNewCertificateValues = unsignedSignatureProperties.addNewCertificateValues();
                Iterator<X509Certificate> it3 = signingCertificateChain.iterator();
                while (it3.hasNext()) {
                    try {
                        certificateValuesTypeAddNewCertificateValues.addNewEncapsulatedX509Certificate().setByteArrayValue(it3.next().getEncoded());
                    } catch (CertificateEncodingException e3) {
                        throw new RuntimeException("certificate encoding error: " + e3.getMessage(), e3);
                    }
                }
                createRevocationValues(unsignedSignatureProperties.addNewRevocationValues(), revocationData2);
                nodeList.item(0).getParentNode().replaceChild(document.importNode(qualifyingProperties.getDomNode(), true), nodeList.item(0));
                return;
            } catch (XmlException e4) {
                throw new MarshalException(e4);
            }
        }
        throw new MarshalException("no XAdES-BES extension present");
    }

    public static byte[] getC14nValue(List<Node> list, String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            Iterator<Node> it = list.iterator();
            while (it.hasNext()) {
                byteArrayOutputStream.write(Canonicalizer.getInstance(str).canonicalizeSubtree(it.next()));
            }
            return byteArrayOutputStream.toByteArray();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new RuntimeException("c14n error: " + e2.getMessage(), e2);
        }
    }

    private BigInteger getCrlNumber(X509CRL x509crl) throws Throwable {
        ASN1InputStream aSN1InputStream;
        byte[] extensionValue = x509crl.getExtensionValue(Extension.cRLNumber.getId());
        Closeable closeable = null;
        try {
            if (extensionValue == null) {
                return null;
            }
            try {
                aSN1InputStream = new ASN1InputStream(extensionValue);
                try {
                    Closeable aSN1InputStream2 = new ASN1InputStream(aSN1InputStream.readObject().getOctets());
                    try {
                        BigInteger positiveValue = aSN1InputStream2.readObject().getPositiveValue();
                        IOUtils.closeQuietly(aSN1InputStream2);
                        IOUtils.closeQuietly(aSN1InputStream);
                        return positiveValue;
                    } catch (Throwable th) {
                        th = th;
                        closeable = aSN1InputStream2;
                        IOUtils.closeQuietly(closeable);
                        IOUtils.closeQuietly(aSN1InputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                aSN1InputStream = null;
            }
        } catch (IOException e) {
            throw new RuntimeException("I/O error: " + e.getMessage(), e);
        }
    }

    private XAdESTimeStampType createXAdESTimeStamp(List<Node> list, RevocationData revocationData) {
        return createXAdESTimeStamp(getC14nValue(list, this.signatureConfig.getXadesCanonicalizationMethod()), revocationData);
    }

    private XAdESTimeStampType createXAdESTimeStamp(byte[] bArr, RevocationData revocationData) {
        try {
            byte[] bArrTimeStamp = this.signatureConfig.getTspService().timeStamp(bArr, revocationData);
            XAdESTimeStampType xAdESTimeStampTypeNewInstance = XAdESTimeStampType.Factory.newInstance();
            xAdESTimeStampTypeNewInstance.setId("time-stamp-" + UUID.randomUUID());
            xAdESTimeStampTypeNewInstance.addNewCanonicalizationMethod().setAlgorithm(this.signatureConfig.getXadesCanonicalizationMethod());
            EncapsulatedPKIDataType encapsulatedPKIDataTypeAddNewEncapsulatedTimeStamp = xAdESTimeStampTypeNewInstance.addNewEncapsulatedTimeStamp();
            encapsulatedPKIDataTypeAddNewEncapsulatedTimeStamp.setByteArrayValue(bArrTimeStamp);
            encapsulatedPKIDataTypeAddNewEncapsulatedTimeStamp.setId("time-stamp-token-" + UUID.randomUUID());
            return xAdESTimeStampTypeNewInstance;
        } catch (Exception e) {
            throw new RuntimeException("error while creating a time-stamp: " + e.getMessage(), e);
        }
    }

    private ValidationDataType createValidationData(RevocationData revocationData) {
        ValidationDataType validationDataTypeNewInstance = ValidationDataType.Factory.newInstance();
        createRevocationValues(validationDataTypeNewInstance.addNewRevocationValues(), revocationData);
        return validationDataTypeNewInstance;
    }

    private void createRevocationValues(RevocationValuesType revocationValuesType, RevocationData revocationData) {
        if (revocationData.hasCRLs()) {
            CRLValuesType cRLValuesTypeAddNewCRLValues = revocationValuesType.addNewCRLValues();
            Iterator<byte[]> it = revocationData.getCRLs().iterator();
            while (it.hasNext()) {
                cRLValuesTypeAddNewCRLValues.addNewEncapsulatedCRLValue().setByteArrayValue(it.next());
            }
        }
        if (revocationData.hasOCSPs()) {
            OCSPValuesType oCSPValuesTypeAddNewOCSPValues = revocationValuesType.addNewOCSPValues();
            Iterator<byte[]> it2 = revocationData.getOCSPs().iterator();
            while (it2.hasNext()) {
                oCSPValuesTypeAddNewOCSPValues.addNewEncapsulatedOCSPValue().setByteArrayValue(it2.next());
            }
        }
    }
}
