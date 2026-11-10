package com.syu.xml;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class Element implements IElement, IParser {
    protected String text;
    protected List<Element> elements = new LinkedList();
    protected Map<String, String> attrs = new HashMap();
    protected String tag = tag();

    @Override // com.syu.xml.IElement
    public void addElement(Element element) {
        if (element == null || !this.elements.contains(element)) {
            this.elements.add(element);
        }
    }

    @Override // com.syu.xml.IParser
    public void attributes(Node node, XMLParser xMLParser) {
        this.tag = node.getNodeName();
        if (node.hasAttributes()) {
            NamedNodeMap attributes = node.getAttributes();
            if (attributes.getLength() > 0) {
                for (int i = 0; i < attributes.getLength(); i++) {
                    Node nodeItem = attributes.item(i);
                    this.attrs.put(nodeItem.getNodeName(), nodeItem.getNodeValue());
                }
            }
        }
        if (node.hasChildNodes()) {
            NodeList childNodes = node.getChildNodes();
            int length = childNodes.getLength();
            if (childNodes.getLength() > 0) {
                if (length != 1) {
                    for (int i2 = 0; i2 < length; i2++) {
                        Element elementLoadElement = loadElement(childNodes.item(i2), xMLParser);
                        if (elementLoadElement != null) {
                            addElement(elementLoadElement);
                        }
                    }
                    return;
                }
                Node nodeItem2 = childNodes.item(0);
                if (nodeItem2.getNodeType() == 3) {
                    this.text = node.getTextContent();
                    return;
                }
                Element elementLoadElement2 = loadElement(nodeItem2, xMLParser);
                if (elementLoadElement2 != null) {
                    addElement(elementLoadElement2);
                }
            }
        }
    }

    @Override // com.syu.xml.IElement
    public Element findChildByTag(String str) {
        for (Element element : this.elements) {
            if (element.tag.equals(str)) {
                return element;
            }
        }
        return null;
    }

    @Override // com.syu.xml.IElement
    public String getAttribute(String str) {
        return this.attrs.get(str);
    }

    public int hashCode() {
        String string = toString();
        return string.isEmpty() ? super.hashCode() : string.hashCode();
    }

    public <T extends Element> T loadElement(Node node, XMLParser xMLParser) {
        Class<? extends Element> clsSupportElement = xMLParser.supportElement(node.getNodeName());
        T t = null;
        if (clsSupportElement == null) {
            return null;
        }
        try {
            Element elementNewInstance = clsSupportElement.newInstance();
            if (!(elementNewInstance instanceof Element)) {
                return null;
            }
            T t2 = (T) elementNewInstance;
            try {
                t2.attributes(node, xMLParser);
                return t2;
            } catch (Exception e) {
                e = e;
                t = t2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        e.printStackTrace();
        return t;
    }

    @Override // com.syu.xml.IElement
    public void nodes(List<Element> list) {
        Iterator<Element> it = list.iterator();
        while (it.hasNext()) {
            addElement(it.next());
        }
    }

    @Override // com.syu.xml.IElement
    public void setAttribute(String str, String str2) {
        this.attrs.put(str, str2);
    }

    public String tag() {
        return getClass().getSimpleName().toLowerCase();
    }

    public String toString() {
        String str;
        String str2;
        if (this.elements.size() <= 0 && this.attrs.size() <= 0 && ((str2 = this.text) == null || str2.isEmpty())) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<" + this.tag);
        if (this.attrs.size() > 0) {
            for (Map.Entry<String, String> entry : this.attrs.entrySet()) {
                stringBuffer.append(" " + entry.getKey() + "=\"" + entry.getValue() + "\"");
            }
        }
        if (this.elements.size() > 0 || this.text != null) {
            stringBuffer.append(">");
            if (this.elements.size() > 0) {
                Iterator<Element> it = this.elements.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(it.next().toString());
                }
            } else {
                stringBuffer.append(this.text);
            }
            str = "</" + this.tag + ">\n";
        } else {
            str = "/>";
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
