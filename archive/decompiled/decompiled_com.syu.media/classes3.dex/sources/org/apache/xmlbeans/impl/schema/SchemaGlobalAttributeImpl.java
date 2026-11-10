package org.apache.xmlbeans.impl.schema;

import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlObject;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SchemaGlobalAttributeImpl extends SchemaLocalAttributeImpl implements SchemaGlobalAttribute {
    private boolean _chameleon;
    SchemaContainer _container;
    String _filename;
    private String _parseTNS;
    private SchemaGlobalAttribute.Ref _selfref = new SchemaGlobalAttribute.Ref(this);

    public int getComponentType() {
        return 3;
    }

    public SchemaGlobalAttributeImpl(SchemaContainer schemaContainer) {
        this._container = schemaContainer;
    }

    public SchemaTypeSystem getTypeSystem() {
        return this._container.getTypeSystem();
    }

    SchemaContainer getContainer() {
        return this._container;
    }

    public String getSourceName() {
        return this._filename;
    }

    public void setFilename(String str) {
        this._filename = str;
    }

    public void setParseContext(XmlObject xmlObject, String str, boolean z) {
        this._parseObject = xmlObject;
        this._parseTNS = str;
        this._chameleon = z;
    }

    public XmlObject getParseObject() {
        return this._parseObject;
    }

    public String getTargetNamespace() {
        return this._parseTNS;
    }

    public String getChameleonNamespace() {
        if (this._chameleon) {
            return this._parseTNS;
        }
        return null;
    }

    public SchemaGlobalAttribute.Ref getRef() {
        return this._selfref;
    }

    public SchemaComponent.Ref getComponentRef() {
        return getRef();
    }
}
