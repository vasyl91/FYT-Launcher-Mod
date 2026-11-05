package org.apache.poi.poifs.crypt.dsig;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.crypto.Cipher;
import javax.xml.crypto.MarshalException;
import javax.xml.crypto.URIDereferencer;
import javax.xml.crypto.dsig.Manifest;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.XMLObject;
import javax.xml.crypto.dsig.XMLSignContext;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.XMLValidateContext;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.SignatureMethodParameterSpec;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.apache.jcp.xml.dsig.internal.dom.DOMReference;
import org.apache.jcp.xml.dsig.internal.dom.DOMSignedInfo;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.ContentTypes;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
import org.apache.poi.poifs.crypt.dsig.services.RelationshipTransformService;
import org.apache.poi.util.DocumentHelper;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.xml.security.Init;
import org.apache.xml.security.utils.Base64;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.w3.x2000.x09.xmldsig.SignatureDocument;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SignatureInfo implements SignatureConfig.SignatureConfigurable {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) SignatureInfo.class);
    private static boolean isInitialized = false;
    private SignatureConfig signatureConfig;

    public class SignaturePart {
        private List<X509Certificate> certChain;
        private final PackagePart signaturePart;
        private X509Certificate signer;

        private SignaturePart(PackagePart packagePart) {
            this.signaturePart = packagePart;
        }

        public PackagePart getPackagePart() {
            return this.signaturePart;
        }

        public X509Certificate getSigner() {
            return this.signer;
        }

        public List<X509Certificate> getCertChain() {
            return this.certChain;
        }

        public SignatureDocument getSignatureDocument() throws XmlException, IOException {
            return SignatureDocument.Factory.parse(this.signaturePart.getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        }

        public boolean validate() {
            KeyInfoKeySelector keyInfoKeySelector = new KeyInfoKeySelector();
            try {
                Document document = DocumentHelper.readDocument(this.signaturePart.getInputStream());
                NodeList nodeList = (NodeList) XPathFactory.newInstance().newXPath().compile("//*[@Id]").evaluate(document, XPathConstants.NODESET);
                int length = nodeList.getLength();
                for (int i = 0; i < length; i++) {
                    ((Element) nodeList.item(i)).setIdAttribute(PackageRelationship.ID_ATTRIBUTE_NAME, true);
                }
                DOMValidateContext dOMValidateContext = new DOMValidateContext(keyInfoKeySelector, document);
                dOMValidateContext.setProperty("org.jcp.xml.dsig.validateManifests", Boolean.TRUE);
                dOMValidateContext.setURIDereferencer(SignatureInfo.this.signatureConfig.getUriDereferencer());
                SignatureInfo.this.brokenJvmWorkaround((XMLValidateContext) dOMValidateContext);
                XMLSignature xMLSignatureUnmarshalXMLSignature = SignatureInfo.this.signatureConfig.getSignatureFactory().unmarshalXMLSignature(dOMValidateContext);
                Iterator it = xMLSignatureUnmarshalXMLSignature.getSignedInfo().getReferences().iterator();
                while (it.hasNext()) {
                    SignatureFacet.brokenJvmWorkaround((Reference) it.next());
                }
                Iterator it2 = xMLSignatureUnmarshalXMLSignature.getObjects().iterator();
                while (it2.hasNext()) {
                    for (Manifest manifest : ((XMLObject) it2.next()).getContent()) {
                        if (manifest instanceof Manifest) {
                            Iterator it3 = manifest.getReferences().iterator();
                            while (it3.hasNext()) {
                                SignatureFacet.brokenJvmWorkaround((Reference) it3.next());
                            }
                        }
                    }
                }
                boolean zValidate = xMLSignatureUnmarshalXMLSignature.validate(dOMValidateContext);
                if (zValidate) {
                    this.signer = keyInfoKeySelector.getSigner();
                    this.certChain = keyInfoKeySelector.getCertChain();
                }
                return zValidate;
            } catch (XMLSignatureException e) {
                SignatureInfo.LOG.log(7, "error in validating the signature", e);
                throw new EncryptedDocumentException("error in validating the signature", e);
            } catch (MarshalException e2) {
                SignatureInfo.LOG.log(7, "error in unmarshalling the signature", e2);
                throw new EncryptedDocumentException("error in unmarshalling the signature", e2);
            } catch (IOException e3) {
                SignatureInfo.LOG.log(7, "error in reading document", e3);
                throw new EncryptedDocumentException("error in reading document", e3);
            } catch (XPathExpressionException e4) {
                SignatureInfo.LOG.log(7, "error in searching document with xpath expression", e4);
                throw new EncryptedDocumentException("error in searching document with xpath expression", e4);
            } catch (SAXException e5) {
                SignatureInfo.LOG.log(7, "error in parsing document", e5);
                throw new EncryptedDocumentException("error in parsing document", e5);
            }
        }
    }

    public SignatureInfo() {
        initXmlProvider();
    }

    public SignatureConfig getSignatureConfig() {
        return this.signatureConfig;
    }

    @Override // org.apache.poi.poifs.crypt.dsig.SignatureConfig.SignatureConfigurable
    public void setSignatureConfig(SignatureConfig signatureConfig) {
        this.signatureConfig = signatureConfig;
    }

    public boolean verifySignature() {
        Iterator<SignaturePart> it = getSignatureParts().iterator();
        if (it.hasNext()) {
            return it.next().validate();
        }
        return false;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.MarshalException */
    public void confirmSignature() throws MarshalException, XMLSignatureException {
        Document documentCreateDocument = DocumentHelper.createDocument();
        postSign(documentCreateDocument, signDigest(preSign(documentCreateDocument, null).digestValue));
    }

    public byte[] signDigest(byte[] bArr) {
        Cipher cipher = CryptoFunctions.getCipher(this.signatureConfig.getKey(), CipherAlgorithm.rsa, ChainingMode.ecb, null, 1, "PKCS1Padding");
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(this.signatureConfig.getHashMagic());
            byteArrayOutputStream.write(bArr);
            return cipher.doFinal(byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            throw new EncryptedDocumentException(e);
        }
    }

    public Iterable<SignaturePart> getSignatureParts() {
        this.signatureConfig.init(true);
        return new Iterable<SignaturePart>() { // from class: org.apache.poi.poifs.crypt.dsig.SignatureInfo.1
            @Override // java.lang.Iterable
            public Iterator<SignaturePart> iterator() {
                return new Iterator<SignaturePart>() { // from class: org.apache.poi.poifs.crypt.dsig.SignatureInfo.1.1
                    OPCPackage pkg;
                    Iterator<PackageRelationship> sigOrigRels;
                    PackagePart sigPart;
                    Iterator<PackageRelationship> sigRels;

                    {
                        OPCPackage opcPackage = SignatureInfo.this.signatureConfig.getOpcPackage();
                        this.pkg = opcPackage;
                        this.sigOrigRels = opcPackage.getRelationshipsByType(PackageRelationshipTypes.DIGITAL_SIGNATURE_ORIGIN).iterator();
                        this.sigRels = null;
                        this.sigPart = null;
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        while (true) {
                            Iterator<PackageRelationship> it = this.sigRels;
                            if (it != null && it.hasNext()) {
                                return true;
                            }
                            if (!this.sigOrigRels.hasNext()) {
                                return false;
                            }
                            this.sigPart = this.pkg.getPart(this.sigOrigRels.next());
                            SignatureInfo.LOG.log(1, "Digital Signature Origin part", this.sigPart);
                            try {
                                this.sigRels = this.sigPart.getRelationshipsByType(PackageRelationshipTypes.DIGITAL_SIGNATURE).iterator();
                            } catch (InvalidFormatException e) {
                                SignatureInfo.LOG.log(5, "Reference to signature is invalid.", e);
                            }
                        }
                    }

                    @Override // java.util.Iterator
                    public SignaturePart next() {
                        PackagePart relatedPart = null;
                        do {
                            try {
                                if (!hasNext()) {
                                    throw new NoSuchElementException();
                                }
                                relatedPart = this.sigPart.getRelatedPart(this.sigRels.next());
                                SignatureInfo.LOG.log(1, "XML Signature part", relatedPart);
                            } catch (InvalidFormatException e) {
                                SignatureInfo.LOG.log(5, "Reference to signature is invalid.", e);
                            }
                        } while (this.sigPart == null);
                        return new SignaturePart(relatedPart);
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    protected static synchronized void initXmlProvider() {
        if (isInitialized) {
            return;
        }
        isInitialized = true;
        try {
            Init.init();
            RelationshipTransformService.registerDsigProvider();
            CryptoFunctions.registerBouncyCastle();
        } catch (Exception e) {
            throw new RuntimeException("Xml & BouncyCastle-Provider initialization failed", e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.dsig.XMLSignatureException */
    public DigestInfo preSign(Document document, List<DigestInfo> list) throws MarshalException, XMLSignatureException {
        this.signatureConfig.init(false);
        EventTarget eventTarget = (EventTarget) document;
        EventListener signatureMarshalListener = this.signatureConfig.getSignatureMarshalListener();
        if (signatureMarshalListener != null) {
            if (signatureMarshalListener instanceof SignatureMarshalListener) {
                ((SignatureMarshalListener) signatureMarshalListener).setEventTarget(eventTarget);
            }
            SignatureMarshalListener.setListener(eventTarget, signatureMarshalListener, true);
        }
        DOMSignContext dOMSignContext = new DOMSignContext(this.signatureConfig.getKey(), document);
        URIDereferencer uriDereferencer = this.signatureConfig.getUriDereferencer();
        if (uriDereferencer != null) {
            dOMSignContext.setURIDereferencer(uriDereferencer);
        }
        for (Map.Entry<String, String> entry : this.signatureConfig.getNamespacePrefixes().entrySet()) {
            dOMSignContext.putNamespacePrefix(entry.getKey(), entry.getValue());
        }
        dOMSignContext.setDefaultNamespacePrefix("");
        brokenJvmWorkaround((XMLSignContext) dOMSignContext);
        XMLSignatureFactory signatureFactory = this.signatureConfig.getSignatureFactory();
        ArrayList arrayList = new ArrayList();
        for (DigestInfo digestInfo : safe(list)) {
            arrayList.add(SignatureFacet.newReference(new File(digestInfo.description).getName(), null, null, null, digestInfo.digestValue, this.signatureConfig));
        }
        ArrayList<XMLObject> arrayList2 = new ArrayList();
        for (SignatureFacet signatureFacet : this.signatureConfig.getSignatureFacets()) {
            LOG.log(1, "invoking signature facet: " + signatureFacet.getClass().getSimpleName());
            signatureFacet.preSign(document, arrayList, arrayList2);
        }
        try {
            DOMSignedInfo dOMSignedInfoNewSignedInfo = signatureFactory.newSignedInfo(signatureFactory.newCanonicalizationMethod(this.signatureConfig.getCanonicalizationMethod(), (C14NMethodParameterSpec) null), signatureFactory.newSignatureMethod(this.signatureConfig.getSignatureMethodUri(), (SignatureMethodParameterSpec) null), arrayList);
            signatureFactory.newXMLSignature(dOMSignedInfoNewSignedInfo, (KeyInfo) null, arrayList2, this.signatureConfig.getPackageSignatureId(), this.signatureConfig.getPackageSignatureId() + "-signature-value").sign(dOMSignContext);
            for (XMLObject xMLObject : arrayList2) {
                LOG.log(1, "object java type: " + xMLObject.getClass().getName());
                for (Manifest manifest : xMLObject.getContent()) {
                    LOG.log(1, "object content java type: " + manifest.getClass().getName());
                    if (manifest instanceof Manifest) {
                        for (DOMReference dOMReference : manifest.getReferences()) {
                            if (dOMReference.getDigestValue() == null) {
                                dOMReference.digest(dOMSignContext);
                            }
                        }
                    }
                }
            }
            for (DOMReference dOMReference2 : dOMSignedInfoNewSignedInfo.getReferences()) {
                if (dOMReference2.getDigestValue() == null) {
                    dOMReference2.digest(dOMSignContext);
                }
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            dOMSignedInfoNewSignedInfo.canonicalize(dOMSignContext, byteArrayOutputStream);
            return new DigestInfo(CryptoFunctions.getMessageDigest(this.signatureConfig.getDigestAlgo()).digest(byteArrayOutputStream.toByteArray()), this.signatureConfig.getDigestAlgo(), this.signatureConfig.getSignatureDescription());
        } catch (GeneralSecurityException e) {
            throw new XMLSignatureException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.MarshalException */
    public void postSign(Document document, byte[] bArr) throws MarshalException {
        LOG.log(1, "postSign");
        String packageSignatureId = this.signatureConfig.getPackageSignatureId();
        if (!packageSignatureId.equals(document.getDocumentElement().getAttribute(PackageRelationship.ID_ATTRIBUTE_NAME))) {
            throw new RuntimeException("ds:Signature not found for @Id: " + packageSignatureId);
        }
        NodeList elementsByTagNameNS = document.getElementsByTagNameNS(SignatureFacet.XML_DIGSIG_NS, "SignatureValue");
        if (elementsByTagNameNS.getLength() != 1) {
            throw new RuntimeException("preSign has to be called before postSign");
        }
        elementsByTagNameNS.item(0).setTextContent(Base64.encode(bArr));
        Iterator<SignatureFacet> it = this.signatureConfig.getSignatureFacets().iterator();
        while (it.hasNext()) {
            it.next().postSign(document);
        }
        writeDocument(document);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.MarshalException */
    protected void writeDocument(Document document) throws MarshalException {
        XmlOptions xmlOptions = new XmlOptions();
        HashMap map = new HashMap();
        for (Map.Entry<String, String> entry : this.signatureConfig.getNamespacePrefixes().entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        xmlOptions.setSaveSuggestedPrefixes(map);
        xmlOptions.setUseDefaultNamespace();
        LOG.log(1, "output signed Office OpenXML document");
        OPCPackage opcPackage = this.signatureConfig.getOpcPackage();
        try {
            PackagePartName packagePartNameCreatePartName = PackagingURIHelper.createPartName("/_xmlsignatures/sig1.xml");
            PackagePartName packagePartNameCreatePartName2 = PackagingURIHelper.createPartName("/_xmlsignatures/origin.sigs");
            PackagePart part = opcPackage.getPart(packagePartNameCreatePartName);
            if (part == null) {
                part = opcPackage.createPart(packagePartNameCreatePartName, ContentTypes.DIGITAL_SIGNATURE_XML_SIGNATURE_PART);
            }
            try {
                OutputStream outputStream = part.getOutputStream();
                SignatureDocument.Factory.parse(document, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).save(outputStream, xmlOptions);
                outputStream.close();
                PackagePart part2 = opcPackage.getPart(packagePartNameCreatePartName2);
                if (part2 == null) {
                    part2 = opcPackage.createPart(packagePartNameCreatePartName2, ContentTypes.DIGITAL_SIGNATURE_ORIGIN_PART);
                }
                Iterator<PackageRelationship> it = opcPackage.getRelationshipsByType(PackageRelationshipTypes.DIGITAL_SIGNATURE_ORIGIN).iterator();
                while (it.hasNext()) {
                    opcPackage.removeRelationship(it.next().getId());
                }
                opcPackage.addRelationship(packagePartNameCreatePartName2, TargetMode.INTERNAL, PackageRelationshipTypes.DIGITAL_SIGNATURE_ORIGIN);
                part2.addRelationship(packagePartNameCreatePartName, TargetMode.INTERNAL, PackageRelationshipTypes.DIGITAL_SIGNATURE);
            } catch (Exception e) {
                throw new MarshalException("Unable to write signature document", e);
            }
        } catch (InvalidFormatException e2) {
            throw new MarshalException(e2);
        }
    }

    private static <T> List<T> safe(List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }

    private void brokenJvmWorkaround(XMLSignContext xMLSignContext) {
        Provider provider = Security.getProvider("BC");
        if (provider != null) {
            xMLSignContext.setProperty("org.jcp.xml.dsig.internal.dom.SignatureProvider", provider);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brokenJvmWorkaround(XMLValidateContext xMLValidateContext) {
        Provider provider = Security.getProvider("BC");
        if (provider != null) {
            xMLValidateContext.setProperty("org.jcp.xml.dsig.internal.dom.SignatureProvider", provider);
        }
    }
}
