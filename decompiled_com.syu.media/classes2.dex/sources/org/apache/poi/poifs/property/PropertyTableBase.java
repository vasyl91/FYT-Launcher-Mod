package org.apache.poi.poifs.property;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.apache.poi.poifs.filesystem.BATManaged;
import org.apache.poi.poifs.storage.HeaderBlock;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class PropertyTableBase implements BATManaged {
    private static final POILogger _logger = POILogFactory.getLogger((Class<?>) PropertyTableBase.class);
    private final HeaderBlock _header_block;
    protected final List<Property> _properties;

    public PropertyTableBase(HeaderBlock headerBlock) {
        this._header_block = headerBlock;
        this._properties = new ArrayList();
        addProperty(new RootProperty());
    }

    public PropertyTableBase(HeaderBlock headerBlock, List<Property> list) throws IOException {
        this._header_block = headerBlock;
        this._properties = list;
        populatePropertyTree((DirectoryProperty) list.get(0));
    }

    public void addProperty(Property property) {
        this._properties.add(property);
    }

    public void removeProperty(Property property) {
        this._properties.remove(property);
    }

    public RootProperty getRoot() {
        return (RootProperty) this._properties.get(0);
    }

    private void populatePropertyTree(DirectoryProperty directoryProperty) throws IOException {
        int childIndex = directoryProperty.getChildIndex();
        if (Property.isValidIndex(childIndex)) {
            Stack stack = new Stack();
            stack.push(this._properties.get(childIndex));
            while (!stack.empty()) {
                Property property = (Property) stack.pop();
                if (property != null) {
                    directoryProperty.addChild(property);
                    if (property.isDirectory()) {
                        populatePropertyTree((DirectoryProperty) property);
                    }
                    int previousChildIndex = property.getPreviousChildIndex();
                    if (isValidIndex(previousChildIndex)) {
                        stack.push(this._properties.get(previousChildIndex));
                    }
                    int nextChildIndex = property.getNextChildIndex();
                    if (isValidIndex(nextChildIndex)) {
                        stack.push(this._properties.get(nextChildIndex));
                    }
                }
            }
        }
    }

    protected boolean isValidIndex(int i) {
        if (!Property.isValidIndex(i)) {
            return false;
        }
        if (i >= 0 && i < this._properties.size()) {
            return true;
        }
        _logger.log(5, "Property index " + i + "outside the valid range 0.." + this._properties.size());
        return false;
    }

    public int getStartBlock() {
        return this._header_block.getPropertyStart();
    }

    @Override // org.apache.poi.poifs.filesystem.BATManaged
    public void setStartBlock(int i) {
        this._header_block.setPropertyStart(i);
    }
}
