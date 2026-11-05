package com.fasterxml.aalto.out;

import chip.FinalChip;
import com.fasterxml.aalto.impl.ErrorConsts;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.ri.typed.AsciiValueEncoder;
import org.codehaus.stax2.validation.XMLValidator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class RepairingStreamWriter extends StreamWriterBase {
    int[] _autoNsSeq;
    final String _cfgAutomaticNsPrefix;
    String _suggestedDefNs;
    HashMap<String, String> _suggestedPrefixes;

    public RepairingStreamWriter(WriterConfig writerConfig, XmlWriter xmlWriter, WNameTable wNameTable) {
        super(writerConfig, xmlWriter, wNameTable);
        this._autoNsSeq = null;
        this._suggestedDefNs = null;
        this._suggestedPrefixes = null;
        this._cfgAutomaticNsPrefix = writerConfig.getAutomaticNsPrefix();
    }

    @Override // com.fasterxml.aalto.out.StreamWriterBase
    public void setDefaultNamespace(String str) throws XMLStreamException {
        if (str == null || str.length() == 0) {
            str = null;
        }
        this._suggestedDefNs = str;
    }

    @Override // com.fasterxml.aalto.out.StreamWriterBase
    public void _setPrefix(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            HashMap<String, String> map = this._suggestedPrefixes;
            if (map != null) {
                Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    if (it.next().getValue().equals(str)) {
                        it.remove();
                    }
                }
                return;
            }
            return;
        }
        if (this._suggestedPrefixes == null) {
            this._suggestedPrefixes = new HashMap<>(16);
        }
        this._suggestedPrefixes.put(str2, str);
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
            wNameFindSymbol = _generateAttrName(null, str2, str);
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
        if (str2 == null || str2.length() == 0) {
            wNameFindSymbol = this._symbols.findSymbol(str3);
        } else {
            wNameFindSymbol = _generateAttrName(str, str3, str2);
        }
        _writeAttribute(wNameFindSymbol, str4);
    }

    @Override // com.fasterxml.aalto.out.StreamWriterBase
    public void writeDefaultNamespace(String str) throws XMLStreamException {
        if (!this._stateStartElementOpen) {
            throwOutputError(ErrorConsts.WERR_NS_NO_ELEM);
        }
        if (!this._currElem.hasPrefix()) {
            this._currElem.setDefaultNsURI(str);
            _writeDefaultNamespace(str);
        }
        _writeDefaultNamespace(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.StreamWriterBase
    public void writeEmptyElement(String str, String str2) throws XMLStreamException {
        _writeStartOrEmpty(null, str2, str, true);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.StreamWriterBase
    public void writeEmptyElement(String str, String str2, String str3) throws XMLStreamException {
        _writeStartOrEmpty(str, str2, str3, true);
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
        if (this._currElem.isPrefixUnbound(str, this._rootNsContext)) {
            this._currElem.addPrefix(str, str2);
            _writeNamespace(str, str2);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.StreamWriterBase
    public void writeStartElement(String str, String str2) throws XMLStreamException {
        _writeStartOrEmpty(null, str2, str, false);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.StreamWriterBase
    public void writeStartElement(String str, String str2, String str3) throws XMLStreamException {
        _writeStartOrEmpty(str, str2, str3, false);
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
    protected String _serializeQName(QName qName) throws XMLStreamException {
        String namespaceURI = qName.getNamespaceURI();
        String prefix = qName.getPrefix();
        String localPart = qName.getLocalPart();
        if (this._currElem.isPrefixBoundTo(prefix, namespaceURI, this._rootNsContext)) {
            return (prefix == null || prefix.length() == 0) ? localPart : prefix + ":" + localPart;
        }
        return _generateAttrName(prefix, localPart, namespaceURI).getPrefixedName();
    }

    /* JADX INFO: renamed from: com.fasterxml.aalto.out.RepairingStreamWriter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$aalto$out$OutputElement$PrefixState;

        static {
            int[] iArr = new int[OutputElement.PrefixState.values().length];
            $SwitchMap$com$fasterxml$aalto$out$OutputElement$PrefixState = iArr;
            try {
                iArr[OutputElement.PrefixState.UNBOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fasterxml$aalto$out$OutputElement$PrefixState[OutputElement.PrefixState.OK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fasterxml$aalto$out$OutputElement$PrefixState[OutputElement.PrefixState.MISBOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
    
        if (r1 != 2) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.fasterxml.aalto.out.WName _generateAttrName(java.lang.String r5, java.lang.String r6, java.lang.String r7) throws javax.xml.stream.XMLStreamException {
        /*
            r4 = this;
            r0 = 1
            if (r5 == 0) goto L2e
            int r1 = r5.length()
            if (r1 <= 0) goto L2e
            int[] r1 = com.fasterxml.aalto.out.RepairingStreamWriter.AnonymousClass1.$SwitchMap$com$fasterxml$aalto$out$OutputElement$PrefixState
            com.fasterxml.aalto.out.OutputElement r2 = r4._currElem
            javax.xml.namespace.NamespaceContext r3 = r4._rootNsContext
            com.fasterxml.aalto.out.OutputElement$PrefixState r2 = r2.checkPrefixValidity(r5, r7, r3)
            int r2 = r2.ordinal()
            r1 = r1[r2]
            if (r1 == r0) goto L1f
            r2 = 2
            if (r1 == r2) goto L27
            goto L2e
        L1f:
            r4._writeNamespace(r5, r7)
            com.fasterxml.aalto.out.OutputElement r0 = r4._currElem
            r0.addPrefix(r5, r7)
        L27:
            com.fasterxml.aalto.out.WNameTable r7 = r4._symbols
            com.fasterxml.aalto.out.WName r5 = r7.findSymbol(r5, r6)
            return r5
        L2e:
            com.fasterxml.aalto.out.OutputElement r5 = r4._currElem
            javax.xml.namespace.NamespaceContext r1 = r4._rootNsContext
            java.lang.String r5 = r5.getExplicitPrefix(r7, r1)
            if (r5 != 0) goto L57
            int[] r5 = r4._autoNsSeq
            if (r5 != 0) goto L43
            int[] r5 = new int[r0]
            r4._autoNsSeq = r5
            r1 = 0
            r5[r1] = r0
        L43:
            com.fasterxml.aalto.out.OutputElement r5 = r4._currElem
            javax.xml.namespace.NamespaceContext r0 = r4._rootNsContext
            java.lang.String r1 = r4._cfgAutomaticNsPrefix
            int[] r2 = r4._autoNsSeq
            java.lang.String r5 = r5.generatePrefix(r0, r1, r2)
            r4._writeNamespace(r5, r7)
            com.fasterxml.aalto.out.OutputElement r0 = r4._currElem
            r0.addPrefix(r5, r7)
        L57:
            com.fasterxml.aalto.out.WNameTable r7 = r4._symbols
            com.fasterxml.aalto.out.WName r5 = r7.findSymbol(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.aalto.out.RepairingStreamWriter._generateAttrName(java.lang.String, java.lang.String, java.lang.String):com.fasterxml.aalto.out.WName");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void _writeStartOrEmpty(String str, String str2, String str3, boolean z) throws XMLStreamException {
        if (str3 == null || str3.length() == 0) {
            _verifyStartElement(null, str2);
            _writeStartTag(this._symbols.findSymbol(str2), z, null);
            if (!this._currElem.hasEmptyDefaultNs()) {
                _writeDefaultNamespace(str3);
                this._currElem.setDefaultNsURI(FinalChip.BSP_PLATFORM_Null);
            }
            if (this._validator != null) {
                this._validator.validateElementStart(str2, FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null);
                return;
            }
            return;
        }
        if (str == null) {
            str = this._currElem.getPrefix(str3);
            if (str != null) {
                _writeStartAndVerify(str, str2, str3, z);
            } else {
                str = _generateElemPrefix(str3);
                if (_writeStartAndVerify(str, str2, str3, z)) {
                    _writeDefaultNamespace(str3);
                    this._currElem.setDefaultNsURI(str3);
                } else {
                    _writeNamespace(str, str3);
                    this._currElem.addPrefix(str, str3);
                }
            }
        } else {
            boolean z_writeStartAndVerify = _writeStartAndVerify(str, str2, str3, z);
            if (!this._currElem.isPrefixBoundTo(str, str3, this._rootNsContext)) {
                if (z_writeStartAndVerify) {
                    _writeDefaultNamespace(str3);
                    this._currElem.setDefaultNsURI(str3);
                } else {
                    _writeNamespace(str, str3);
                    this._currElem.addPrefix(str, str3);
                }
            }
        }
        if (this._validator != null) {
            XMLValidator xMLValidator = this._validator;
            if (str == null) {
                str = FinalChip.BSP_PLATFORM_Null;
            }
            xMLValidator.validateElementStart(str2, FinalChip.BSP_PLATFORM_Null, str);
        }
    }

    private final boolean _writeStartAndVerify(String str, String str2, String str3, boolean z) throws XMLStreamException {
        if (str == null || str.length() == 0) {
            _verifyStartElement(null, str2);
            _writeStartTag(this._symbols.findSymbol(str2), z, str3);
            return true;
        }
        _verifyStartElement(str, str2);
        _writeStartTag(this._symbols.findSymbol(str, str2), z, str3);
        return false;
    }

    protected final String _generateElemPrefix(String str) throws XMLStreamException {
        String str2;
        String str3 = this._suggestedDefNs;
        if (str3 != null && str3.equals(str)) {
            return null;
        }
        HashMap<String, String> map = this._suggestedPrefixes;
        if (map != null && (str2 = map.get(str)) != null) {
            return str2;
        }
        if (this._autoNsSeq == null) {
            this._autoNsSeq = new int[]{1};
        }
        return this._currElem.generatePrefix(this._rootNsContext, this._cfgAutomaticNsPrefix, this._autoNsSeq);
    }
}
