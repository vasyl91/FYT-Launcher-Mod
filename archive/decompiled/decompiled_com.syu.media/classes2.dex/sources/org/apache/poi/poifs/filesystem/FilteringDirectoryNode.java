package org.apache.poi.poifs.filesystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.poi.hpsf.ClassID;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class FilteringDirectoryNode implements DirectoryEntry {
    private DirectoryEntry directory;
    private Set<String> excludes = new HashSet();
    private Map<String, List<String>> childExcludes = new HashMap();

    @Override // org.apache.poi.poifs.filesystem.Entry
    public boolean isDirectoryEntry() {
        return true;
    }

    @Override // org.apache.poi.poifs.filesystem.Entry
    public boolean isDocumentEntry() {
        return false;
    }

    public FilteringDirectoryNode(DirectoryEntry directoryEntry, Collection<String> collection) {
        this.directory = directoryEntry;
        for (String str : collection) {
            int iIndexOf = str.indexOf(47);
            if (iIndexOf == -1) {
                this.excludes.add(str);
            } else {
                String strSubstring = str.substring(0, iIndexOf);
                String strSubstring2 = str.substring(iIndexOf + 1);
                if (!this.childExcludes.containsKey(strSubstring)) {
                    this.childExcludes.put(strSubstring, new ArrayList());
                }
                this.childExcludes.get(strSubstring).add(strSubstring2);
            }
        }
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public DirectoryEntry createDirectory(String str) throws IOException {
        return this.directory.createDirectory(str);
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public DocumentEntry createDocument(String str, InputStream inputStream) throws IOException {
        return this.directory.createDocument(str, inputStream);
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public DocumentEntry createDocument(String str, int i, POIFSWriterListener pOIFSWriterListener) throws IOException {
        return this.directory.createDocument(str, i, pOIFSWriterListener);
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public Iterator<Entry> getEntries() {
        return new FilteringIterator();
    }

    @Override // java.lang.Iterable
    public Iterator<Entry> iterator() {
        return getEntries();
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public int getEntryCount() {
        int entryCount = this.directory.getEntryCount();
        Iterator<String> it = this.excludes.iterator();
        while (it.hasNext()) {
            if (this.directory.hasEntry(it.next())) {
                entryCount--;
            }
        }
        return entryCount;
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public Set<String> getEntryNames() {
        HashSet hashSet = new HashSet();
        for (String str : this.directory.getEntryNames()) {
            if (!this.excludes.contains(str)) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public boolean isEmpty() {
        return getEntryCount() == 0;
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public boolean hasEntry(String str) {
        if (this.excludes.contains(str)) {
            return false;
        }
        return this.directory.hasEntry(str);
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public Entry getEntry(String str) throws FileNotFoundException {
        if (this.excludes.contains(str)) {
            throw new FileNotFoundException(str);
        }
        return wrapEntry(this.directory.getEntry(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Entry wrapEntry(Entry entry) {
        String name = entry.getName();
        return (this.childExcludes.containsKey(name) && (entry instanceof DirectoryEntry)) ? new FilteringDirectoryNode((DirectoryEntry) entry, this.childExcludes.get(name)) : entry;
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public ClassID getStorageClsid() {
        return this.directory.getStorageClsid();
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public void setStorageClsid(ClassID classID) {
        this.directory.setStorageClsid(classID);
    }

    @Override // org.apache.poi.poifs.filesystem.Entry
    public boolean delete() {
        return this.directory.delete();
    }

    @Override // org.apache.poi.poifs.filesystem.Entry
    public boolean renameTo(String str) {
        return this.directory.renameTo(str);
    }

    @Override // org.apache.poi.poifs.filesystem.Entry
    public String getName() {
        return this.directory.getName();
    }

    @Override // org.apache.poi.poifs.filesystem.Entry
    public DirectoryEntry getParent() {
        return this.directory.getParent();
    }

    private class FilteringIterator implements Iterator<Entry> {
        private Entry next;
        private Iterator<Entry> parent;

        private FilteringIterator() {
            this.parent = FilteringDirectoryNode.this.directory.getEntries();
            locateNext();
        }

        private void locateNext() {
            this.next = null;
            while (this.parent.hasNext() && this.next == null) {
                Entry next = this.parent.next();
                if (!FilteringDirectoryNode.this.excludes.contains(next.getName())) {
                    this.next = FilteringDirectoryNode.this.wrapEntry(next);
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public Entry next() {
            Entry entry = this.next;
            locateNext();
            return entry;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Remove not supported");
        }
    }
}
