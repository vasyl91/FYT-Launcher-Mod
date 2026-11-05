package com.fasterxml.aalto.dom;

import chip.FinalChip;
import com.fasterxml.aalto.out.WriterConfig;
import java.util.HashMap;
import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.dom.DOMResult;
import org.codehaus.stax2.ri.EmptyNamespaceContext;
import org.codehaus.stax2.ri.dom.DOMWrappingWriter;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class DOMWriterImpl extends DOMWrappingWriter {
    protected int[] _autoNsSeq;
    protected String _automaticNsPrefix;
    protected final WriterConfig _config;
    protected DOMOutputElement _currElem;
    protected DOMOutputElement _openElement;
    protected String _suggestedDefNs;
    HashMap<String, String> _suggestedPrefixes;

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private DOMWriterImpl(WriterConfig writerConfig, Node node) throws XMLStreamException {
        super(node, true, writerConfig.willRepairNamespaces());
        this._suggestedDefNs = null;
        this._suggestedPrefixes = null;
        this._config = writerConfig;
        this._autoNsSeq = null;
        this._automaticNsPrefix = writerConfig.getAutomaticNsPrefix();
        short nodeType = node.getNodeType();
        if (nodeType == 1) {
            DOMOutputElement dOMOutputElementCreateChild = DOMOutputElement.createRoot().createChild((Element) node);
            this._currElem = dOMOutputElementCreateChild;
            this._openElement = dOMOutputElementCreateChild;
        } else {
            if (nodeType == 9 || nodeType == 11) {
                this._currElem = DOMOutputElement.createRoot();
                this._openElement = null;
                return;
            }
            throw new XMLStreamException("Can not create an XMLStreamWriter for a DOM node of type " + node.getClass());
        }
    }

    public static DOMWriterImpl createFrom(WriterConfig writerConfig, DOMResult dOMResult) throws XMLStreamException {
        return new DOMWriterImpl(writerConfig, dOMResult.getNode());
    }

    public NamespaceContext getNamespaceContext() {
        if (!this.mNsAware) {
            return EmptyNamespaceContext.getInstance();
        }
        return this._currElem;
    }

    public String getPrefix(String str) {
        String prefix;
        if (this.mNsAware) {
            return (this.mNsContext == null || (prefix = this.mNsContext.getPrefix(str)) == null) ? this._currElem.getPrefix(str) : prefix;
        }
        return null;
    }

    public Object getProperty(String str) {
        return this._config.getProperty(str, false);
    }

    public void setDefaultNamespace(String str) {
        if (str == null || str.length() == 0) {
            str = null;
        }
        this._suggestedDefNs = str;
    }

    public void setPrefix(String str, String str2) throws XMLStreamException {
        if (str == null) {
            throw new NullPointerException("Can not pass null 'prefix' value");
        }
        if (str.length() == 0) {
            setDefaultNamespace(str2);
            return;
        }
        if (str2 == null) {
            throw new NullPointerException("Can not pass null 'uri' value");
        }
        if (str.equals("xml")) {
            if (!str2.equals("http://www.w3.org/XML/1998/namespace")) {
                throwOutputError("Trying to redeclare prefix 'xml' from its default URI 'http://www.w3.org/XML/1998/namespace' to \"" + str2 + "\"");
            }
        } else if (str.equals("xmlns")) {
            if (str2.equals("http://www.w3.org/2000/xmlns/")) {
                return;
            }
            throwOutputError("Trying to declare prefix 'xmlns' (illegal as per NS 1.1 #4)");
            return;
        } else if (str2.equals("http://www.w3.org/XML/1998/namespace")) {
            throwOutputError("Trying to bind URI 'http://www.w3.org/XML/1998/namespace to prefix \"" + str + "\" (can only bind to 'xml')");
        } else if (str2.equals("http://www.w3.org/2000/xmlns/")) {
            throwOutputError("Trying to bind URI 'http://www.w3.org/2000/xmlns/ to prefix \"" + str + "\" (can not be explicitly bound)");
        }
        if (this._suggestedPrefixes == null) {
            this._suggestedPrefixes = new HashMap<>(16);
        }
        this._suggestedPrefixes.put(str2, str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeAttribute(String str, String str2) throws XMLStreamException {
        outputAttribute(null, null, str, str2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeAttribute(String str, String str2, String str3) throws XMLStreamException {
        outputAttribute(str, null, str2, str3);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeAttribute(String str, String str2, String str3, String str4) throws XMLStreamException {
        outputAttribute(str2, str, str3, str4);
    }

    public void writeDefaultNamespace(String str) {
        if (this._openElement == null) {
            throw new IllegalStateException("No currently open START_ELEMENT, cannot write attribute");
        }
        setDefaultNamespace(str);
        this._openElement.addAttribute("http://www.w3.org/2000/xmlns/", "xmlns", str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeEmptyElement(String str) throws XMLStreamException {
        writeEmptyElement(null, str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeEmptyElement(String str, String str2) throws XMLStreamException {
        createStartElem(str, null, str2, true);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeEmptyElement(String str, String str2, String str3) throws XMLStreamException {
        if (str == null) {
            str = FinalChip.BSP_PLATFORM_Null;
        }
        createStartElem(str3, str, str2, true);
    }

    public void writeEndDocument() {
        this._openElement = null;
        this._currElem = null;
    }

    public void writeEndElement() {
        DOMOutputElement dOMOutputElement = this._currElem;
        if (dOMOutputElement == null || dOMOutputElement.isRoot()) {
            throw new IllegalStateException("No open start element to close");
        }
        this._openElement = null;
        this._currElem = this._currElem.getParent();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeNamespace(String str, String str2) throws XMLStreamException {
        if (str == null || str.length() == 0) {
            writeDefaultNamespace(str2);
            return;
        }
        if (!this.mNsAware) {
            throwOutputError("Can not write namespaces with non-namespace writer.");
        }
        outputAttribute("http://www.w3.org/2000/xmlns/", "xmlns", str, str2);
        this._currElem.addPrefix(str, str2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeStartElement(String str) throws XMLStreamException {
        writeStartElement(null, str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeStartElement(String str, String str2) throws XMLStreamException {
        createStartElem(str, null, str2, false);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeStartElement(String str, String str2, String str3) throws XMLStreamException {
        createStartElem(str3, str, str2, false);
    }

    public boolean isPropertySupported(String str) {
        return this._config.isPropertySupported(str);
    }

    public boolean setProperty(String str, Object obj) {
        return this._config.setProperty(str, obj);
    }

    public void writeDTD(String str, String str2, String str3, String str4) throws XMLStreamException {
        if (this._currElem != null) {
            throw new IllegalStateException("Operation only allowed to the document before adding root element");
        }
        reportUnsupported("writeDTD()");
    }

    protected void appendLeaf(Node node) throws IllegalStateException {
        this._currElem.appendNode(node);
        this._openElement = null;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void createStartElem(String str, String str2, String str3, boolean z) throws XMLStreamException {
        DOMOutputElement dOMOutputElementCreateAndAttachChild;
        if (!this.mNsAware) {
            if (str != null && str.length() > 0) {
                throwOutputError("Can not specify non-empty uri/prefix in non-namespace mode");
            }
            dOMOutputElementCreateAndAttachChild = this._currElem.createAndAttachChild(this.mDocument.createElement(str3));
        } else if (this.mNsRepairing) {
            String strValidateElemPrefix = validateElemPrefix(str2, str, this._currElem);
            if (strValidateElemPrefix != null) {
                if (strValidateElemPrefix.length() != 0) {
                    dOMOutputElementCreateAndAttachChild = this._currElem.createAndAttachChild(this.mDocument.createElementNS(str, strValidateElemPrefix + ":" + str3));
                } else {
                    dOMOutputElementCreateAndAttachChild = this._currElem.createAndAttachChild(this.mDocument.createElementNS(str, str3));
                }
            } else {
                if (str2 == null) {
                    str2 = FinalChip.BSP_PLATFORM_Null;
                }
                String strGenerateElemPrefix = generateElemPrefix(str2, str, this._currElem);
                boolean z2 = strGenerateElemPrefix.length() != 0;
                if (z2) {
                    str3 = strGenerateElemPrefix + ":" + str3;
                }
                DOMOutputElement dOMOutputElementCreateAndAttachChild2 = this._currElem.createAndAttachChild(this.mDocument.createElementNS(str, str3));
                this._openElement = dOMOutputElementCreateAndAttachChild2;
                if (z2) {
                    writeNamespace(strGenerateElemPrefix, str);
                    dOMOutputElementCreateAndAttachChild2.addPrefix(strGenerateElemPrefix, str);
                } else {
                    writeDefaultNamespace(str);
                    dOMOutputElementCreateAndAttachChild2.setDefaultNsUri(str);
                }
                dOMOutputElementCreateAndAttachChild = dOMOutputElementCreateAndAttachChild2;
            }
        } else {
            if (str2 == null && str != null && str.length() > 0) {
                HashMap<String, String> map = this._suggestedPrefixes;
                str2 = map == null ? null : map.get(str);
                if (str2 == null) {
                    throwOutputError("Can not find prefix for namespace \"" + str + "\"");
                }
            }
            if (str2 != null && str2.length() != 0) {
                str3 = str2 + ":" + str3;
            }
            dOMOutputElementCreateAndAttachChild = this._currElem.createAndAttachChild(this.mDocument.createElementNS(str, str3));
        }
        this._openElement = dOMOutputElementCreateAndAttachChild;
        if (z) {
            return;
        }
        this._currElem = dOMOutputElementCreateAndAttachChild;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void outputAttribute(String str, String str2, String str3, String str4) throws XMLStreamException {
        if (this._openElement == null) {
            throw new IllegalStateException("No currently open START_ELEMENT, cannot write attribute");
        }
        if (this.mNsAware) {
            if (this.mNsRepairing) {
                str2 = findOrCreateAttrPrefix(str2, str, this._openElement);
            }
            if (str2 != null && str2.length() > 0) {
                str3 = str2 + ":" + str3;
            }
            this._openElement.addAttribute(str, str3, str4);
            return;
        }
        if (str2 != null && str2.length() > 0) {
            str3 = str2 + ":" + str3;
        }
        this._openElement.addAttribute(str3, str4);
    }

    private final String validateElemPrefix(String str, String str2, DOMOutputElement dOMOutputElement) throws XMLStreamException {
        if (str2 == null || str2.length() == 0) {
            String defaultNsUri = dOMOutputElement.getDefaultNsUri();
            if (defaultNsUri == null || defaultNsUri.length() == 0) {
                return FinalChip.BSP_PLATFORM_Null;
            }
            return null;
        }
        if (dOMOutputElement.isPrefixValid(str, str2, true) == 1) {
            return str;
        }
        return null;
    }

    protected final String findElemPrefix(String str, DOMOutputElement dOMOutputElement) throws XMLStreamException {
        if (str == null || str.length() == 0) {
            String defaultNsUri = dOMOutputElement.getDefaultNsUri();
            if (defaultNsUri == null || defaultNsUri.length() <= 0) {
                return FinalChip.BSP_PLATFORM_Null;
            }
            return null;
        }
        return this._currElem.getPrefix(str);
    }

    protected final String generateElemPrefix(String str, String str2, DOMOutputElement dOMOutputElement) throws XMLStreamException {
        if (str2 == null || str2.length() == 0) {
            return FinalChip.BSP_PLATFORM_Null;
        }
        if (str != null) {
            return str;
        }
        String str3 = this._suggestedDefNs;
        if (str3 != null && str3.equals(str2)) {
            return FinalChip.BSP_PLATFORM_Null;
        }
        HashMap<String, String> map = this._suggestedPrefixes;
        String str4 = map == null ? null : map.get(str2);
        if (str4 != null) {
            return str4;
        }
        if (this._autoNsSeq == null) {
            this._autoNsSeq = new int[]{1};
        }
        return dOMOutputElement.generateMapping(this._automaticNsPrefix, str2, this._autoNsSeq);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final String findOrCreateAttrPrefix(String str, String str2, DOMOutputElement dOMOutputElement) throws XMLStreamException {
        String strGenerateMapping = null;
        if (str2 != null && str2.length() != 0) {
            if (str != null) {
                int iIsPrefixValid = dOMOutputElement.isPrefixValid(str, str2, false);
                if (iIsPrefixValid == 1) {
                    return str;
                }
                if (iIsPrefixValid == 0) {
                    dOMOutputElement.addPrefix(str, str2);
                    writeNamespace(str, str2);
                    return str;
                }
            }
            String explicitPrefix = dOMOutputElement.getExplicitPrefix(str2);
            if (explicitPrefix != null) {
                return explicitPrefix;
            }
            if (str == null) {
                HashMap<String, String> map = this._suggestedPrefixes;
                str = map != null ? map.get(str2) : explicitPrefix;
            }
            if (str == null || (str.length() != 0 && dOMOutputElement.getNamespaceURI(str) == null)) {
                strGenerateMapping = str;
            }
            if (strGenerateMapping == null) {
                if (this._autoNsSeq == null) {
                    this._autoNsSeq = new int[]{1};
                }
                strGenerateMapping = this._currElem.generateMapping(this._automaticNsPrefix, str2, this._autoNsSeq);
            }
            dOMOutputElement.addPrefix(strGenerateMapping, str2);
            writeNamespace(strGenerateMapping, str2);
        }
        return strGenerateMapping;
    }
}
