package org.apache.xmlbeans.impl.common;

import org.apache.xmlbeans.xml.stream.XMLEvent;
import org.apache.xmlbeans.xml.stream.events.ElementTypeNames;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class XmlEventBase implements XMLEvent {
    private int _type;

    public XmlEventBase() {
    }

    public XmlEventBase(int i) {
        this._type = i;
    }

    public void setType(int i) {
        this._type = i;
    }

    @Override // org.apache.xmlbeans.xml.stream.XMLEvent
    public int getType() {
        return this._type;
    }

    @Override // org.apache.xmlbeans.xml.stream.XMLEvent
    public String getTypeAsString() {
        return ElementTypeNames.getName(this._type);
    }

    @Override // org.apache.xmlbeans.xml.stream.XMLEvent
    public boolean isStartElement() {
        return this._type == 2;
    }

    @Override // org.apache.xmlbeans.xml.stream.XMLEvent
    public boolean isEndElement() {
        return this._type == 4;
    }

    @Override // org.apache.xmlbeans.xml.stream.XMLEvent
    public boolean isEntityReference() {
        return this._type == 8192;
    }

    @Override // org.apache.xmlbeans.xml.stream.XMLEvent
    public boolean isStartPrefixMapping() {
        return this._type == 1024;
    }

    @Override // org.apache.xmlbeans.xml.stream.XMLEvent
    public boolean isEndPrefixMapping() {
        return this._type == 2048;
    }

    @Override // org.apache.xmlbeans.xml.stream.XMLEvent
    public boolean isChangePrefixMapping() {
        return this._type == 4096;
    }

    @Override // org.apache.xmlbeans.xml.stream.XMLEvent
    public boolean isProcessingInstruction() {
        return this._type == 8;
    }

    @Override // org.apache.xmlbeans.xml.stream.XMLEvent
    public boolean isCharacterData() {
        return this._type == 16;
    }

    @Override // org.apache.xmlbeans.xml.stream.XMLEvent
    public boolean isSpace() {
        return this._type == 64;
    }

    @Override // org.apache.xmlbeans.xml.stream.XMLEvent
    public boolean isNull() {
        return this._type == 128;
    }

    @Override // org.apache.xmlbeans.xml.stream.XMLEvent
    public boolean isStartDocument() {
        return this._type == 256;
    }

    @Override // org.apache.xmlbeans.xml.stream.XMLEvent
    public boolean isEndDocument() {
        return this._type == 512;
    }
}
