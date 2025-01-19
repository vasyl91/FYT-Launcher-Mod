package com.android.launcher66;

import android.content.ContentValues;
import java.util.ArrayList;

class FolderInfo extends ItemInfo {
    ArrayList<ShortcutInfo> contents = new ArrayList<>();
    ArrayList<FolderListener> listeners = new ArrayList<>();
    boolean opened;

    interface FolderListener {
        void onAdd(ShortcutInfo shortcutInfo);

        void onItemsChanged();

        void onRemove(ShortcutInfo shortcutInfo);

        void onTitleChanged(CharSequence charSequence);
    }

    FolderInfo() {
        this.itemType = 2;
    }

    public void add(ShortcutInfo item) {
        this.contents.add(item);
        for (int i = 0; i < this.listeners.size(); i++) {
            this.listeners.get(i).onAdd(item);
        }
        itemsChanged();
    }

    public void remove(ShortcutInfo item) {
        this.contents.remove(item);
        for (int i = 0; i < this.listeners.size(); i++) {
            this.listeners.get(i).onRemove(item);
        }
        itemsChanged();
    }

    public void setTitle(CharSequence title) {
        this.title = title;
        for (int i = 0; i < this.listeners.size(); i++) {
            this.listeners.get(i).onTitleChanged(title);
        }
    }

    @Override
    void onAddToDatabase(ContentValues values) {
        super.onAddToDatabase(values);
        values.put("title", this.title.toString());
    }

    void addListener(FolderListener listener) {
        this.listeners.add(listener);
    }

    void removeListener(FolderListener listener) {
        if (this.listeners.contains(listener)) {
            this.listeners.remove(listener);
        }
    }

    void itemsChanged() {
        for (int i = 0; i < this.listeners.size(); i++) {
            this.listeners.get(i).onItemsChanged();
        }
    }

    @Override
    void unbind() {
        super.unbind();
        this.listeners.clear();
    }

    @Override
    public String toString() {
        return "FolderInfo(id=" + this.id + " type=" + this.itemType + " container=" + this.container + " screen=" + this.screenId + " cellX=" + this.cellX + " cellY=" + this.cellY + " spanX=" + this.spanX + " spanY=" + this.spanY + " dropPos=" + this.dropPos + ")";
    }
}
