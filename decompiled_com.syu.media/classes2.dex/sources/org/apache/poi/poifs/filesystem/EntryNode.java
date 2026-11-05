package org.apache.poi.poifs.filesystem;

import org.apache.poi.poifs.property.Property;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class EntryNode implements Entry {
    private DirectoryNode _parent;
    private Property _property;

    protected abstract boolean isDeleteOK();

    @Override // org.apache.poi.poifs.filesystem.Entry
    public boolean isDirectoryEntry() {
        return false;
    }

    @Override // org.apache.poi.poifs.filesystem.Entry
    public boolean isDocumentEntry() {
        return false;
    }

    protected EntryNode(Property property, DirectoryNode directoryNode) {
        this._property = property;
        this._parent = directoryNode;
    }

    protected Property getProperty() {
        return this._property;
    }

    protected boolean isRoot() {
        return this._parent == null;
    }

    @Override // org.apache.poi.poifs.filesystem.Entry
    public String getName() {
        return this._property.getName();
    }

    @Override // org.apache.poi.poifs.filesystem.Entry
    public DirectoryEntry getParent() {
        return this._parent;
    }

    @Override // org.apache.poi.poifs.filesystem.Entry
    public boolean delete() {
        if (isRoot() || !isDeleteOK()) {
            return false;
        }
        return this._parent.deleteEntry(this);
    }

    @Override // org.apache.poi.poifs.filesystem.Entry
    public boolean renameTo(String str) {
        if (isRoot()) {
            return false;
        }
        return this._parent.changeName(getName(), str);
    }
}
