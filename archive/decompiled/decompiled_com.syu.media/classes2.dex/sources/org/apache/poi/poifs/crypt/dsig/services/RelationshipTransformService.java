package org.apache.poi.poifs.crypt.dsig.services;

import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.Provider;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import javax.xml.crypto.Data;
import javax.xml.crypto.MarshalException;
import javax.xml.crypto.OctetStreamData;
import javax.xml.crypto.XMLCryptoContext;
import javax.xml.crypto.XMLStructure;
import javax.xml.crypto.dom.DOMStructure;
import javax.xml.crypto.dsig.TransformException;
import javax.xml.crypto.dsig.TransformService;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import org.apache.jcp.xml.dsig.internal.dom.ApacheNodeSetData;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.util.DocumentHelper;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTRelationshipReference;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.RelationshipReferenceDocument;
import org.w3.x2000.x09.xmldsig.TransformDocument;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class RelationshipTransformService extends TransformService {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) RelationshipTransformService.class);
    public static final String TRANSFORM_URI = "http://schemas.openxmlformats.org/package/2006/RelationshipTransform";
    private final List<String> sourceIds;

    public static class RelationshipTransformParameterSpec implements TransformParameterSpec {
        List<String> sourceIds = new ArrayList();

        public void addRelationshipReference(String str) {
            this.sourceIds.add(str);
        }

        public boolean hasSourceIds() {
            return !this.sourceIds.isEmpty();
        }
    }

    public RelationshipTransformService() {
        LOG.log(1, "constructor");
        this.sourceIds = new ArrayList();
    }

    public static synchronized void registerDsigProvider() {
        if (Security.getProperty("POIXmlDsigProvider") == null) {
            Provider provider = new Provider("POIXmlDsigProvider", 1.0d, "POIXmlDsigProvider") { // from class: org.apache.poi.poifs.crypt.dsig.services.RelationshipTransformService.1
                static final long serialVersionUID = 1;
            };
            provider.put("TransformService.http://schemas.openxmlformats.org/package/2006/RelationshipTransform", RelationshipTransformService.class.getName());
            provider.put("TransformService.http://schemas.openxmlformats.org/package/2006/RelationshipTransform MechanismType", "DOM");
            Security.addProvider(provider);
        }
    }

    public void init(TransformParameterSpec transformParameterSpec) throws InvalidAlgorithmParameterException {
        LOG.log(1, "init(params)");
        if (!(transformParameterSpec instanceof RelationshipTransformParameterSpec)) {
            throw new InvalidAlgorithmParameterException();
        }
        Iterator<String> it = ((RelationshipTransformParameterSpec) transformParameterSpec).sourceIds.iterator();
        while (it.hasNext()) {
            this.sourceIds.add(it.next());
        }
    }

    public void init(XMLStructure xMLStructure, XMLCryptoContext xMLCryptoContext) throws InvalidAlgorithmParameterException {
        POILogger pOILogger = LOG;
        pOILogger.log(1, "init(parent,context)");
        pOILogger.log(1, "parent java type: " + xMLStructure.getClass().getName());
        try {
            CTRelationshipReference[] cTRelationshipReferenceArrSelectChildren = TransformDocument.Factory.parse(((DOMStructure) xMLStructure).getNode(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getTransform().selectChildren(RelationshipReferenceDocument.type.getDocumentElementName());
            if (cTRelationshipReferenceArrSelectChildren.length == 0) {
                pOILogger.log(5, "no RelationshipReference/@SourceId parameters present");
            }
            for (CTRelationshipReference cTRelationshipReference : cTRelationshipReferenceArrSelectChildren) {
                String sourceId = cTRelationshipReference.getSourceId();
                LOG.log(1, "sourceId: ", sourceId);
                this.sourceIds.add(sourceId);
            }
        } catch (XmlException e) {
            throw new InvalidAlgorithmParameterException(e);
        }
    }

    public void marshalParams(XMLStructure xMLStructure, XMLCryptoContext xMLCryptoContext) throws MarshalException {
        LOG.log(1, "marshallParams(parent,context)");
        Element element = (Element) ((DOMStructure) xMLStructure).getNode();
        Document ownerDocument = element.getOwnerDocument();
        for (String str : this.sourceIds) {
            Element elementCreateElementNS = ownerDocument.createElementNS("http://schemas.openxmlformats.org/package/2006/digital-signature", "mdssi:RelationshipReference");
            elementCreateElementNS.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:mdssi", "http://schemas.openxmlformats.org/package/2006/digital-signature");
            elementCreateElementNS.setAttribute("SourceId", str);
            element.appendChild(elementCreateElementNS);
        }
    }

    public AlgorithmParameterSpec getParameterSpec() {
        LOG.log(1, "getParameterSpec");
        return null;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.dsig.TransformException */
    public Data transform(Data data, XMLCryptoContext xMLCryptoContext) throws TransformException {
        POILogger pOILogger = LOG;
        pOILogger.log(1, "transform(data,context)");
        pOILogger.log(1, "data java type: " + data.getClass().getName());
        OctetStreamData octetStreamData = (OctetStreamData) data;
        pOILogger.log(1, "URI: " + octetStreamData.getURI());
        try {
            Element documentElement = DocumentHelper.readDocument(octetStreamData.getOctetStream()).getDocumentElement();
            NodeList childNodes = documentElement.getChildNodes();
            TreeMap treeMap = new TreeMap();
            for (int length = childNodes.getLength() - 1; length >= 0; length--) {
                Node nodeItem = childNodes.item(length);
                if (PackageRelationship.RELATIONSHIP_TAG_NAME.equals(nodeItem.getLocalName())) {
                    Element element = (Element) nodeItem;
                    String attribute = element.getAttribute(PackageRelationship.ID_ATTRIBUTE_NAME);
                    if (this.sourceIds.contains(attribute)) {
                        if ("".equals(element.getAttribute(PackageRelationship.TARGET_MODE_ATTRIBUTE_NAME))) {
                            element.setAttribute(PackageRelationship.TARGET_MODE_ATTRIBUTE_NAME, "Internal");
                        }
                        treeMap.put(attribute, element);
                    }
                }
                documentElement.removeChild(nodeItem);
            }
            Iterator it = treeMap.values().iterator();
            while (it.hasNext()) {
                documentElement.appendChild((Element) it.next());
            }
            LOG.log(1, "# Relationship elements: ", Integer.valueOf(treeMap.size()));
            return new ApacheNodeSetData(new XMLSignatureInput(documentElement));
        } catch (Exception e) {
            throw new TransformException(e.getMessage(), e);
        }
    }

    public Data transform(Data data, XMLCryptoContext xMLCryptoContext, OutputStream outputStream) throws TransformException {
        LOG.log(1, "transform(data,context,os)");
        return null;
    }

    public boolean isFeatureSupported(String str) {
        LOG.log(1, "isFeatureSupported(feature)");
        return false;
    }
}
