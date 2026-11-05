package org.apache.poi.poifs.crypt.dsig;

import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MutationEvent;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SignatureMarshalListener implements EventListener, SignatureConfig.SignatureConfigurable {
    SignatureConfig signatureConfig;
    ThreadLocal<EventTarget> target = new ThreadLocal<>();

    public void setEventTarget(EventTarget eventTarget) {
        this.target.set(eventTarget);
    }

    public void handleEvent(Event event) {
        if (event instanceof MutationEvent) {
            EventTarget target = ((MutationEvent) event).getTarget();
            if (target instanceof Element) {
                handleElement((Element) target);
            }
        }
    }

    public void handleElement(Element element) {
        EventTarget eventTarget = this.target.get();
        if (element.hasAttribute(PackageRelationship.ID_ATTRIBUTE_NAME)) {
            element.setIdAttribute(PackageRelationship.ID_ATTRIBUTE_NAME, true);
        }
        setListener(eventTarget, this, false);
        if ("http://schemas.openxmlformats.org/package/2006/digital-signature".equals(element.getNamespaceURI()) && !"http://schemas.openxmlformats.org/package/2006/digital-signature".equals(element.getParentNode().getNamespaceURI()) && !element.hasAttributeNS("http://www.w3.org/2000/xmlns/", "mdssi")) {
            element.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:mdssi", "http://schemas.openxmlformats.org/package/2006/digital-signature");
        }
        setPrefix(element);
        setListener(eventTarget, this, true);
    }

    public static void setListener(EventTarget eventTarget, EventListener eventListener, boolean z) {
        if (z) {
            eventTarget.addEventListener("DOMSubtreeModified", eventListener, false);
        } else {
            eventTarget.removeEventListener("DOMSubtreeModified", eventListener, false);
        }
    }

    protected void setPrefix(Node node) {
        String str = this.signatureConfig.getNamespacePrefixes().get(node.getNamespaceURI());
        if (str != null && node.getPrefix() == null) {
            node.setPrefix(str);
        }
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            setPrefix(childNodes.item(i));
        }
    }

    @Override // org.apache.poi.poifs.crypt.dsig.SignatureConfig.SignatureConfigurable
    public void setSignatureConfig(SignatureConfig signatureConfig) {
        this.signatureConfig = signatureConfig;
    }
}
