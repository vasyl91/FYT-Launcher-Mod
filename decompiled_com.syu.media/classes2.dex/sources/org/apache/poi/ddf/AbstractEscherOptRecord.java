package org.apache.poi.ddf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class AbstractEscherOptRecord extends EscherRecord {
    private List<EscherProperty> properties = new ArrayList();

    public void addEscherProperty(EscherProperty escherProperty) {
        this.properties.add(escherProperty);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int header = readHeader(bArr, i);
        short instance = readInstance(bArr, i);
        this.properties = new EscherPropertyFactory().createProperties(bArr, i + 8, instance);
        return header + 8;
    }

    public List<EscherProperty> getEscherProperties() {
        return this.properties;
    }

    public EscherProperty getEscherProperty(int i) {
        return this.properties.get(i);
    }

    private int getPropertiesSize() {
        Iterator<EscherProperty> it = this.properties.iterator();
        int propertySize = 0;
        while (it.hasNext()) {
            propertySize += it.next().getPropertySize();
        }
        return propertySize;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return getPropertiesSize() + 8;
    }

    public <T extends EscherProperty> T lookup(int i) {
        Iterator<EscherProperty> it = this.properties.iterator();
        while (it.hasNext()) {
            T t = (T) it.next();
            if (t.getPropertyNumber() == i) {
                return t;
            }
        }
        return null;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        LittleEndian.putShort(bArr, i, getOptions());
        LittleEndian.putShort(bArr, i + 2, getRecordId());
        LittleEndian.putInt(bArr, i + 4, getPropertiesSize());
        int iSerializeComplexPart = i + 8;
        Iterator<EscherProperty> it = this.properties.iterator();
        while (it.hasNext()) {
            iSerializeComplexPart += it.next().serializeSimplePart(bArr, iSerializeComplexPart);
        }
        Iterator<EscherProperty> it2 = this.properties.iterator();
        while (it2.hasNext()) {
            iSerializeComplexPart += it2.next().serializeComplexPart(bArr, iSerializeComplexPart);
        }
        int i2 = iSerializeComplexPart - i;
        escherSerializationListener.afterRecordSerialize(iSerializeComplexPart, getRecordId(), i2, this);
        return i2;
    }

    public void sortProperties() {
        Collections.sort(this.properties, new Comparator<EscherProperty>() { // from class: org.apache.poi.ddf.AbstractEscherOptRecord.1
            @Override // java.util.Comparator
            public int compare(EscherProperty escherProperty, EscherProperty escherProperty2) {
                short propertyNumber = escherProperty.getPropertyNumber();
                short propertyNumber2 = escherProperty2.getPropertyNumber();
                if (propertyNumber < propertyNumber2) {
                    return -1;
                }
                return propertyNumber == propertyNumber2 ? 0 : 1;
            }
        });
    }

    public void setEscherProperty(EscherProperty escherProperty) {
        Iterator<EscherProperty> it = this.properties.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == escherProperty.getId()) {
                it.remove();
            }
        }
        this.properties.add(escherProperty);
        sortProperties();
    }

    public void removeEscherProperty(int i) {
        Iterator<EscherProperty> it = getEscherProperties().iterator();
        while (it.hasNext()) {
            if (it.next().getPropertyNumber() == i) {
                it.remove();
            }
        }
    }

    @Override // org.apache.poi.ddf.EscherRecord
    protected Object[][] getAttributeMap() {
        ArrayList arrayList = new ArrayList((this.properties.size() * 2) + 2);
        arrayList.add("properties");
        arrayList.add(Integer.valueOf(this.properties.size()));
        for (EscherProperty escherProperty : this.properties) {
            arrayList.add(escherProperty.getName());
            arrayList.add(escherProperty);
        }
        return new Object[][]{new Object[]{"isContainer", Boolean.valueOf(isContainerRecord())}, new Object[]{"numchildren", Integer.valueOf(getChildRecords().size())}, arrayList.toArray()};
    }
}
