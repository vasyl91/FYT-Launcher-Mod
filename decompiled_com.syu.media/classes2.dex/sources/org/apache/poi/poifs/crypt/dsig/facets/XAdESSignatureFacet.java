package org.apache.poi.poifs.crypt.dsig.facets;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import javax.xml.crypto.dom.DOMStructure;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.XMLObject;
import javax.xml.crypto.dsig.XMLSignatureException;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.crypt.dsig.SignatureConfig;
import org.apache.poi.poifs.crypt.dsig.services.SignaturePolicyService;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.etsi.uri.x01903.v13.AnyType;
import org.etsi.uri.x01903.v13.CertIDType;
import org.etsi.uri.x01903.v13.DataObjectFormatType;
import org.etsi.uri.x01903.v13.DigestAlgAndValueType;
import org.etsi.uri.x01903.v13.ObjectIdentifierType;
import org.etsi.uri.x01903.v13.QualifyingPropertiesDocument;
import org.etsi.uri.x01903.v13.QualifyingPropertiesType;
import org.etsi.uri.x01903.v13.SignaturePolicyIdType;
import org.etsi.uri.x01903.v13.SignedPropertiesType;
import org.etsi.uri.x01903.v13.SignedSignaturePropertiesType;
import org.etsi.uri.x01903.v13.SignerRoleType;
import org.w3.x2000.x09.xmldsig.X509IssuerSerialType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XAdESSignatureFacet extends SignatureFacet {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) XAdESSignatureFacet.class);
    private static final String XADES_TYPE = "http://uri.etsi.org/01903#SignedProperties";
    private Map<String, String> dataObjectFormatMimeTypes = new HashMap();

    @Override // org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet
    public void preSign(Document document, List<Reference> list, List<XMLObject> list2) throws XMLSignatureException {
        LOG.log(1, "preSign");
        QualifyingPropertiesType qualifyingPropertiesTypeAddNewQualifyingProperties = QualifyingPropertiesDocument.Factory.newInstance().addNewQualifyingProperties();
        qualifyingPropertiesTypeAddNewQualifyingProperties.setTarget("#" + this.signatureConfig.getPackageSignatureId());
        SignedPropertiesType signedPropertiesTypeAddNewSignedProperties = qualifyingPropertiesTypeAddNewQualifyingProperties.addNewSignedProperties();
        signedPropertiesTypeAddNewSignedProperties.setId(this.signatureConfig.getXadesSignatureId());
        SignedSignaturePropertiesType signedSignaturePropertiesTypeAddNewSignedSignatureProperties = signedPropertiesTypeAddNewSignedProperties.addNewSignedSignatureProperties();
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Z"), Locale.ROOT);
        calendar.setTime(this.signatureConfig.getExecutionTime());
        calendar.clear(14);
        signedSignaturePropertiesTypeAddNewSignedSignatureProperties.setSigningTime(calendar);
        if (this.signatureConfig.getSigningCertificateChain() == null || this.signatureConfig.getSigningCertificateChain().isEmpty()) {
            throw new RuntimeException("no signing certificate chain available");
        }
        setCertID(signedSignaturePropertiesTypeAddNewSignedSignatureProperties.addNewSigningCertificate().addNewCert(), this.signatureConfig, this.signatureConfig.isXadesIssuerNameNoReverseOrder(), this.signatureConfig.getSigningCertificateChain().get(0));
        String xadesRole = this.signatureConfig.getXadesRole();
        if (xadesRole != null && !xadesRole.isEmpty()) {
            SignerRoleType signerRoleTypeAddNewSignerRole = signedSignaturePropertiesTypeAddNewSignedSignatureProperties.addNewSignerRole();
            signedSignaturePropertiesTypeAddNewSignedSignatureProperties.setSignerRole(signerRoleTypeAddNewSignerRole);
            AnyType anyTypeAddNewClaimedRole = signerRoleTypeAddNewSignerRole.addNewClaimedRoles().addNewClaimedRole();
            XmlString xmlStringNewInstance = XmlString.Factory.newInstance();
            xmlStringNewInstance.setStringValue(xadesRole);
            insertXChild(anyTypeAddNewClaimedRole, xmlStringNewInstance);
        }
        SignaturePolicyService signaturePolicyService = this.signatureConfig.getSignaturePolicyService();
        if (signaturePolicyService != null) {
            SignaturePolicyIdType signaturePolicyIdTypeAddNewSignaturePolicyId = signedSignaturePropertiesTypeAddNewSignedSignatureProperties.addNewSignaturePolicyIdentifier().addNewSignaturePolicyId();
            ObjectIdentifierType objectIdentifierTypeAddNewSigPolicyId = signaturePolicyIdTypeAddNewSignaturePolicyId.addNewSigPolicyId();
            objectIdentifierTypeAddNewSigPolicyId.setDescription(signaturePolicyService.getSignaturePolicyDescription());
            objectIdentifierTypeAddNewSigPolicyId.addNewIdentifier().setStringValue(signaturePolicyService.getSignaturePolicyIdentifier());
            setDigestAlgAndValue(signaturePolicyIdTypeAddNewSignaturePolicyId.addNewSigPolicyHash(), signaturePolicyService.getSignaturePolicyDocument(), this.signatureConfig.getDigestAlgo());
            String signaturePolicyDownloadUrl = signaturePolicyService.getSignaturePolicyDownloadUrl();
            if (signaturePolicyDownloadUrl != null) {
                AnyType anyTypeAddNewSigPolicyQualifier = signaturePolicyIdTypeAddNewSignaturePolicyId.addNewSigPolicyQualifiers().addNewSigPolicyQualifier();
                XmlString xmlStringNewInstance2 = XmlString.Factory.newInstance();
                xmlStringNewInstance2.setStringValue(signaturePolicyDownloadUrl);
                insertXChild(anyTypeAddNewSigPolicyQualifier, xmlStringNewInstance2);
            }
        } else if (this.signatureConfig.isXadesSignaturePolicyImplied()) {
            signedSignaturePropertiesTypeAddNewSignedSignatureProperties.addNewSignaturePolicyIdentifier().addNewSignaturePolicyImplied();
        }
        if (!this.dataObjectFormatMimeTypes.isEmpty()) {
            List dataObjectFormatList = signedPropertiesTypeAddNewSignedProperties.addNewSignedDataObjectProperties().getDataObjectFormatList();
            for (Map.Entry<String, String> entry : this.dataObjectFormatMimeTypes.entrySet()) {
                DataObjectFormatType dataObjectFormatTypeNewInstance = DataObjectFormatType.Factory.newInstance();
                dataObjectFormatTypeNewInstance.setObjectReference("#" + entry.getKey());
                dataObjectFormatTypeNewInstance.setMimeType(entry.getValue());
                dataObjectFormatList.add(dataObjectFormatTypeNewInstance);
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DOMStructure((Element) document.importNode((Element) qualifyingPropertiesTypeAddNewQualifyingProperties.getDomNode(), true)));
        list2.add(getSignatureFactory().newXMLObject(arrayList, (String) null, (String) null, (String) null));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315"));
        list.add(newReference("#" + this.signatureConfig.getXadesSignatureId(), arrayList2, XADES_TYPE, null, null));
    }

    protected static void setDigestAlgAndValue(DigestAlgAndValueType digestAlgAndValueType, byte[] bArr, HashAlgorithm hashAlgorithm) {
        digestAlgAndValueType.addNewDigestMethod().setAlgorithm(SignatureConfig.getDigestMethodUri(hashAlgorithm));
        digestAlgAndValueType.setDigestValue(CryptoFunctions.getMessageDigest(hashAlgorithm).digest(bArr));
    }

    protected static void setCertID(CertIDType certIDType, SignatureConfig signatureConfig, boolean z, X509Certificate x509Certificate) {
        String string;
        X509IssuerSerialType x509IssuerSerialTypeAddNewIssuerSerial = certIDType.addNewIssuerSerial();
        if (z) {
            string = x509Certificate.getIssuerDN().getName().replace(",", ", ");
        } else {
            string = x509Certificate.getIssuerX500Principal().toString();
        }
        x509IssuerSerialTypeAddNewIssuerSerial.setX509IssuerName(string);
        x509IssuerSerialTypeAddNewIssuerSerial.setX509SerialNumber(x509Certificate.getSerialNumber());
        try {
            setDigestAlgAndValue(certIDType.addNewCertDigest(), x509Certificate.getEncoded(), signatureConfig.getXadesDigestAlgo());
        } catch (CertificateEncodingException e) {
            throw new RuntimeException("certificate encoding error: " + e.getMessage(), e);
        }
    }

    public void addMimeType(String str, String str2) {
        this.dataObjectFormatMimeTypes.put(str, str2);
    }

    protected static void insertXChild(XmlObject xmlObject, XmlObject xmlObject2) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        xmlCursorNewCursor.toEndToken();
        XmlCursor xmlCursorNewCursor2 = xmlObject2.newCursor();
        xmlCursorNewCursor2.toNextToken();
        xmlCursorNewCursor2.moveXml(xmlCursorNewCursor);
        xmlCursorNewCursor2.dispose();
        xmlCursorNewCursor.dispose();
    }
}
