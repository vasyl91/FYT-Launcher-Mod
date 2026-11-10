package org.apache.xmlbeans.impl.schema;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaLocalAttribute;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SchemaAttributeModelImpl implements SchemaAttributeModel {
    private static final SchemaLocalAttribute[] EMPTY_SLA_ARRAY = new SchemaLocalAttribute[0];
    private Map attrMap;
    private int wcProcess;
    private QNameSet wcSet;

    public SchemaAttributeModelImpl() {
        this.attrMap = new LinkedHashMap();
        this.wcSet = null;
        this.wcProcess = 0;
    }

    public SchemaAttributeModelImpl(SchemaAttributeModel schemaAttributeModel) {
        this.attrMap = new LinkedHashMap();
        if (schemaAttributeModel == null) {
            this.wcSet = null;
            this.wcProcess = 0;
            return;
        }
        SchemaLocalAttribute[] attributes = schemaAttributeModel.getAttributes();
        for (int i = 0; i < attributes.length; i++) {
            this.attrMap.put(attributes[i].getName(), attributes[i]);
        }
        if (schemaAttributeModel.getWildcardProcess() != 0) {
            this.wcSet = schemaAttributeModel.getWildcardSet();
            this.wcProcess = schemaAttributeModel.getWildcardProcess();
        }
    }

    public SchemaLocalAttribute[] getAttributes() {
        return (SchemaLocalAttribute[]) this.attrMap.values().toArray(EMPTY_SLA_ARRAY);
    }

    public SchemaLocalAttribute getAttribute(QName qName) {
        return (SchemaLocalAttribute) this.attrMap.get(qName);
    }

    public void addAttribute(SchemaLocalAttribute schemaLocalAttribute) {
        this.attrMap.put(schemaLocalAttribute.getName(), schemaLocalAttribute);
    }

    public void removeProhibitedAttribute(QName qName) {
        this.attrMap.remove(qName);
    }

    public QNameSet getWildcardSet() {
        QNameSet qNameSet = this.wcSet;
        return qNameSet == null ? QNameSet.EMPTY : qNameSet;
    }

    public void setWildcardSet(QNameSet qNameSet) {
        this.wcSet = qNameSet;
    }

    public int getWildcardProcess() {
        return this.wcProcess;
    }

    public void setWildcardProcess(int i) {
        this.wcProcess = i;
    }
}
