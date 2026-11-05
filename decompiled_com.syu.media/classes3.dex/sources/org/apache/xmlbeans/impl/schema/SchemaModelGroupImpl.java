package org.apache.xmlbeans.impl.schema;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlObject;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SchemaModelGroupImpl implements SchemaModelGroup {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private SchemaAnnotation _annotation;
    private String _attFormDefault;
    private boolean _chameleon;
    private SchemaContainer _container;
    private String _elemFormDefault;
    private String _filename;
    private QName _name;
    private XmlObject _parseObject;
    private String _parseTNS;
    private boolean _redefinition;
    private SchemaModelGroup.Ref _selfref = new SchemaModelGroup.Ref(this);
    private Object _userData;

    public int getComponentType() {
        return 6;
    }

    public SchemaModelGroupImpl(SchemaContainer schemaContainer) {
        this._container = schemaContainer;
    }

    public SchemaModelGroupImpl(SchemaContainer schemaContainer, QName qName) {
        this._container = schemaContainer;
        this._name = qName;
    }

    public void init(QName qName, String str, boolean z, String str2, String str3, boolean z2, XmlObject xmlObject, SchemaAnnotation schemaAnnotation, Object obj) {
        this._name = qName;
        this._parseTNS = str;
        this._chameleon = z;
        this._elemFormDefault = str2;
        this._attFormDefault = str3;
        this._redefinition = z2;
        this._parseObject = xmlObject;
        this._annotation = schemaAnnotation;
        this._userData = obj;
    }

    public SchemaTypeSystem getTypeSystem() {
        return this._container.getTypeSystem();
    }

    SchemaContainer getContainer() {
        return this._container;
    }

    public void setFilename(String str) {
        this._filename = str;
    }

    public String getSourceName() {
        return this._filename;
    }

    public QName getName() {
        return this._name;
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

    public String getElemFormDefault() {
        return this._elemFormDefault;
    }

    public String getAttFormDefault() {
        return this._attFormDefault;
    }

    public boolean isRedefinition() {
        return this._redefinition;
    }

    public SchemaAnnotation getAnnotation() {
        return this._annotation;
    }

    public SchemaModelGroup.Ref getRef() {
        return this._selfref;
    }

    public SchemaComponent.Ref getComponentRef() {
        return getRef();
    }

    public Object getUserData() {
        return this._userData;
    }
}
