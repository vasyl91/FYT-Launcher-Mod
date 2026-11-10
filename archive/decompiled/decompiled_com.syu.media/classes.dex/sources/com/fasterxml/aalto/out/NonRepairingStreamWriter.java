package com.fasterxml.aalto.out;

import com.fasterxml.aalto.impl.ErrorConsts;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.ri.typed.AsciiValueEncoder;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class NonRepairingStreamWriter extends StreamWriterBase {
    public NonRepairingStreamWriter(WriterConfig writerConfig, XmlWriter xmlWriter, WNameTable wNameTable) {
        super(writerConfig, xmlWriter, wNameTable);
    }

    @Override // com.fasterxml.aalto.out.StreamWriterBase
    public void setDefaultNamespace(String str) throws XMLStreamException {
        this._currElem.setDefaultNsURI(str);
    }

    @Override // com.fasterxml.aalto.out.StreamWriterBase
    public void _setPrefix(String str, String str2) {
        this._currElem.addPrefix(str, str2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.StreamWriterBase
    public void writeAttribute(String str, String str2, String str3) throws XMLStreamException {
        WName wNameFindSymbol;
        if (!this._stateStartElementOpen) {
            throwOutputError(ErrorConsts.WERR_ATTR_NO_ELEM);
        }
        if (str == null || str.length() == 0) {
            wNameFindSymbol = this._symbols.findSymbol(str2);
        } else {
            String explicitPrefix = this._currElem.getExplicitPrefix(str, this._rootNsContext);
            if (explicitPrefix == null) {
                throwOutputError("Unbound namespace URI '" + str + "'");
            }
            wNameFindSymbol = this._symbols.findSymbol(explicitPrefix, str2);
        }
        _writeAttribute(wNameFindSymbol, str3);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.StreamWriterBase
    public void writeAttribute(String str, String str2, String str3, String str4) throws XMLStreamException {
        WName wNameFindSymbol;
        if (!this._stateStartElementOpen) {
            throwOutputError(ErrorConsts.WERR_ATTR_NO_ELEM);
        }
        if (str == null || str.length() == 0) {
            wNameFindSymbol = this._symbols.findSymbol(str3);
        } else {
            wNameFindSymbol = this._symbols.findSymbol(str, str3);
        }
        _writeAttribute(wNameFindSymbol, str4);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.StreamWriterBase
    public void writeDefaultNamespace(String str) throws XMLStreamException {
        if (!this._stateStartElementOpen) {
            throwOutputError(ErrorConsts.WERR_NS_NO_ELEM);
        }
        _writeDefaultNamespace(str);
        setDefaultNamespace(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.StreamWriterBase
    public void writeEmptyElement(String str, String str2) throws XMLStreamException {
        WName wNameFindSymbol;
        String prefix = this._currElem.getPrefix(str);
        if (prefix == null) {
            throwOutputError("Unbound namespace URI '" + str + "'");
        }
        if (prefix.length() == 0) {
            wNameFindSymbol = this._symbols.findSymbol(str2);
            prefix = null;
        } else {
            wNameFindSymbol = this._symbols.findSymbol(prefix, str2);
        }
        _verifyStartElement(prefix, str2);
        _writeStartTag(wNameFindSymbol, true, str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.StreamWriterBase
    public void writeEmptyElement(String str, String str2, String str3) throws XMLStreamException {
        WName wNameFindSymbol;
        _verifyStartElement(str, str2);
        if (str == null || str.length() == 0) {
            wNameFindSymbol = this._symbols.findSymbol(str2);
        } else {
            wNameFindSymbol = this._symbols.findSymbol(str, str2);
        }
        _writeStartTag(wNameFindSymbol, true, str3);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.StreamWriterBase
    public void writeNamespace(String str, String str2) throws XMLStreamException {
        if (str == null || str.length() == 0) {
            writeDefaultNamespace(str2);
            return;
        }
        if (!this._stateStartElementOpen) {
            throwOutputError(ErrorConsts.WERR_NS_NO_ELEM);
        }
        _writeNamespace(str, str2);
        setPrefix(str, str2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.StreamWriterBase
    public void writeStartElement(String str, String str2) throws XMLStreamException {
        WName wNameFindSymbol;
        String prefix = this._currElem.getPrefix(str);
        if (prefix == null) {
            throwOutputError("Unbound namespace URI '" + str + "'");
        }
        if (prefix.length() == 0) {
            wNameFindSymbol = this._symbols.findSymbol(str2);
            prefix = null;
        } else {
            wNameFindSymbol = this._symbols.findSymbol(prefix, str2);
        }
        _verifyStartElement(prefix, str2);
        _writeStartTag(wNameFindSymbol, false);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.StreamWriterBase
    public void writeStartElement(String str, String str2, String str3) throws XMLStreamException {
        WName wNameFindSymbol;
        _verifyStartElement(str, str2);
        if (str == null || str.length() == 0) {
            wNameFindSymbol = this._symbols.findSymbol(str2);
        } else {
            wNameFindSymbol = this._symbols.findSymbol(str, str2);
        }
        _writeStartTag(wNameFindSymbol, false, str3);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.StreamWriterBase
    public void writeTypedAttribute(String str, String str2, String str3, AsciiValueEncoder asciiValueEncoder) throws XMLStreamException {
        WName wNameFindSymbol;
        if (!this._stateStartElementOpen) {
            throwOutputError(ErrorConsts.WERR_ATTR_NO_ELEM);
        }
        if (str == null || str.length() == 0) {
            wNameFindSymbol = this._symbols.findSymbol(str3);
        } else {
            wNameFindSymbol = this._symbols.findSymbol(str, str3);
        }
        _writeAttribute(wNameFindSymbol, asciiValueEncoder);
    }

    @Override // com.fasterxml.aalto.out.StreamWriterBase
    protected String _serializeQName(QName qName) {
        String prefix = qName.getPrefix();
        String localPart = qName.getLocalPart();
        return (prefix == null || prefix.length() == 0) ? localPart : prefix + ":" + localPart;
    }
}
