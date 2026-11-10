package com.fasterxml.aalto.dom;

import chip.FinalChip;
import javax.xml.namespace.NamespaceContext;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class DOMOutputElement extends OutputElementBase {
    private boolean _defaultNsSet;
    private Element _element;
    private DOMOutputElement _parent;

    private DOMOutputElement() {
        this._parent = null;
        this._element = null;
        this._nsMapping = null;
        this._nsMapShared = false;
        this._defaultNsURI = FinalChip.BSP_PLATFORM_Null;
        this._rootNsContext = null;
        this._defaultNsSet = false;
    }

    private DOMOutputElement(DOMOutputElement dOMOutputElement, Element element, BijectiveNsMap bijectiveNsMap) {
        super(dOMOutputElement, bijectiveNsMap);
        this._parent = dOMOutputElement;
        this._element = element;
        this._nsMapping = bijectiveNsMap;
        this._nsMapShared = bijectiveNsMap != null;
        this._defaultNsURI = dOMOutputElement._defaultNsURI;
        this._rootNsContext = dOMOutputElement._rootNsContext;
        this._defaultNsSet = false;
    }

    private void relink(DOMOutputElement dOMOutputElement, Element element) {
        super.relink(dOMOutputElement);
        this._parent = dOMOutputElement;
        this._element = element;
        dOMOutputElement.appendNode(element);
        this._defaultNsSet = false;
    }

    public static DOMOutputElement createRoot() {
        return new DOMOutputElement();
    }

    protected DOMOutputElement createAndAttachChild(Element element) {
        if (isRoot()) {
            element.getOwnerDocument().appendChild(element);
        } else {
            this._element.appendChild(element);
        }
        return createChild(element);
    }

    protected DOMOutputElement createChild(Element element) {
        return new DOMOutputElement(this, element, this._nsMapping);
    }

    protected DOMOutputElement reuseAsChild(DOMOutputElement dOMOutputElement, Element element) {
        DOMOutputElement dOMOutputElement2 = this._parent;
        relink(dOMOutputElement, element);
        return dOMOutputElement2;
    }

    protected void addToPool(DOMOutputElement dOMOutputElement) {
        this._parent = dOMOutputElement;
    }

    public DOMOutputElement getParent() {
        return this._parent;
    }

    @Override // com.fasterxml.aalto.dom.OutputElementBase
    public boolean isRoot() {
        return this._parent == null;
    }

    @Override // com.fasterxml.aalto.dom.OutputElementBase
    public String getNameDesc() {
        Element element = this._element;
        return element != null ? element.getLocalName() : "#error";
    }

    @Override // com.fasterxml.aalto.dom.OutputElementBase
    public void setDefaultNsUri(String str) {
        this._defaultNsURI = str;
        this._defaultNsSet = true;
    }

    @Override // com.fasterxml.aalto.dom.OutputElementBase
    protected void setRootNsContext(NamespaceContext namespaceContext) {
        String namespaceURI;
        this._rootNsContext = namespaceContext;
        if (this._defaultNsSet || (namespaceURI = namespaceContext.getNamespaceURI(FinalChip.BSP_PLATFORM_Null)) == null || namespaceURI.length() <= 0) {
            return;
        }
        this._defaultNsURI = namespaceURI;
    }

    protected void appendNode(Node node) {
        if (isRoot()) {
            this._element.getOwnerDocument().appendChild(node);
        } else {
            this._element.appendChild(node);
        }
    }

    protected void addAttribute(String str, String str2) {
        this._element.setAttribute(str, str2);
    }

    protected void addAttribute(String str, String str2, String str3) {
        this._element.setAttributeNS(str, str2, str3);
    }

    public void appendChild(Node node) {
        this._element.appendChild(node);
    }
}
