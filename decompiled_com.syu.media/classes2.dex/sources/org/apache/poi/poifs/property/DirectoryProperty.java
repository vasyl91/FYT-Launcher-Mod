package org.apache.poi.poifs.property;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DirectoryProperty extends Property implements Parent, Iterable<Property> {
    private List<Property> _children;
    private Set<String> _children_names;

    @Override // org.apache.poi.poifs.property.Property
    public boolean isDirectory() {
        return true;
    }

    public DirectoryProperty(String str) {
        this._children = new ArrayList();
        this._children_names = new HashSet();
        setName(str);
        setSize(0);
        setPropertyType((byte) 1);
        setStartBlock(0);
        setNodeColor((byte) 1);
    }

    protected DirectoryProperty(int i, byte[] bArr, int i2) {
        super(i, bArr, i2);
        this._children = new ArrayList();
        this._children_names = new HashSet();
    }

    public boolean changeName(Property property, String str) {
        String name = property.getName();
        property.setName(str);
        String name2 = property.getName();
        if (this._children_names.contains(name2)) {
            property.setName(name);
            return false;
        }
        this._children_names.add(name2);
        this._children_names.remove(name);
        return true;
    }

    public boolean deleteChild(Property property) {
        boolean zRemove = this._children.remove(property);
        if (zRemove) {
            this._children_names.remove(property.getName());
        }
        return zRemove;
    }

    public static class PropertyComparator implements Comparator<Property>, Serializable {
        @Override // java.util.Comparator
        public int compare(Property property, Property property2) {
            String name = property.getName();
            String name2 = property2.getName();
            int length = name.length() - name2.length();
            if (length != 0) {
                return length;
            }
            if (name.compareTo("_VBA_PROJECT") != 0) {
                if (name2.compareTo("_VBA_PROJECT") != 0) {
                    if (name.startsWith("__") && name2.startsWith("__")) {
                        return name.compareToIgnoreCase(name2);
                    }
                    if (!name.startsWith("__")) {
                        if (!name2.startsWith("__")) {
                            return name.compareToIgnoreCase(name2);
                        }
                    }
                }
                return -1;
            }
            return 1;
        }
    }

    @Override // org.apache.poi.poifs.property.Property
    protected void preWrite() {
        if (this._children.size() > 0) {
            Child[] childArr = (Property[]) this._children.toArray(new Property[0]);
            Arrays.sort(childArr, new PropertyComparator());
            int length = childArr.length / 2;
            setChildProperty(childArr[length].getIndex());
            childArr[0].setPreviousChild(null);
            childArr[0].setNextChild(null);
            for (int i = 1; i < length; i++) {
                childArr[i].setPreviousChild(childArr[i - 1]);
                childArr[i].setNextChild(null);
            }
            if (length != 0) {
                childArr[length].setPreviousChild(childArr[length - 1]);
            }
            if (length != childArr.length - 1) {
                Property property = childArr[length];
                int i2 = length + 1;
                property.setNextChild(childArr[i2]);
                while (i2 < childArr.length - 1) {
                    childArr[i2].setPreviousChild(null);
                    Child child = childArr[i2];
                    i2++;
                    child.setNextChild(childArr[i2]);
                }
                childArr[childArr.length - 1].setPreviousChild(null);
                childArr[childArr.length - 1].setNextChild(null);
                return;
            }
            childArr[length].setNextChild(null);
        }
    }

    @Override // org.apache.poi.poifs.property.Parent
    public Iterator<Property> getChildren() {
        return this._children.iterator();
    }

    @Override // java.lang.Iterable
    public Iterator<Property> iterator() {
        return getChildren();
    }

    @Override // org.apache.poi.poifs.property.Parent
    public void addChild(Property property) throws IOException {
        String name = property.getName();
        if (this._children_names.contains(name)) {
            throw new IOException("Duplicate name \"" + name + "\"");
        }
        this._children_names.add(name);
        this._children.add(property);
    }
}
