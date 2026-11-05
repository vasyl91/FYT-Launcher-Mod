package org.apache.poi.poifs.filesystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.poi.hpsf.ClassID;
import org.apache.poi.poifs.dev.POIFSViewable;
import org.apache.poi.poifs.property.DirectoryProperty;
import org.apache.poi.poifs.property.DocumentProperty;
import org.apache.poi.poifs.property.Property;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DirectoryNode extends EntryNode implements DirectoryEntry, POIFSViewable, Iterable<Entry> {
    private Map<String, Entry> _byname;
    private ArrayList<Entry> _entries;
    private NPOIFSFileSystem _nfilesystem;
    private OPOIFSFileSystem _ofilesystem;
    private POIFSDocumentPath _path;

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public Object[] getViewableArray() {
        return new Object[0];
    }

    @Override // org.apache.poi.poifs.filesystem.EntryNode, org.apache.poi.poifs.filesystem.Entry
    public boolean isDirectoryEntry() {
        return true;
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public boolean preferArray() {
        return false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    DirectoryNode(DirectoryProperty directoryProperty, OPOIFSFileSystem oPOIFSFileSystem, DirectoryNode directoryNode) {
        this(directoryProperty, directoryNode, oPOIFSFileSystem, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    DirectoryNode(DirectoryProperty directoryProperty, NPOIFSFileSystem nPOIFSFileSystem, DirectoryNode directoryNode) {
        this(directoryProperty, directoryNode, null, nPOIFSFileSystem);
    }

    private DirectoryNode(DirectoryProperty directoryProperty, DirectoryNode directoryNode, OPOIFSFileSystem oPOIFSFileSystem, NPOIFSFileSystem nPOIFSFileSystem) {
        Entry documentNode;
        super(directoryProperty, directoryNode);
        this._ofilesystem = oPOIFSFileSystem;
        this._nfilesystem = nPOIFSFileSystem;
        if (directoryNode == null) {
            this._path = new POIFSDocumentPath();
        } else {
            this._path = new POIFSDocumentPath(directoryNode._path, new String[]{directoryProperty.getName()});
        }
        this._byname = new HashMap();
        this._entries = new ArrayList<>();
        Iterator<Property> children = directoryProperty.getChildren();
        while (children.hasNext()) {
            Property next = children.next();
            if (next.isDirectory()) {
                DirectoryProperty directoryProperty2 = (DirectoryProperty) next;
                OPOIFSFileSystem oPOIFSFileSystem2 = this._ofilesystem;
                if (oPOIFSFileSystem2 != null) {
                    documentNode = new DirectoryNode(directoryProperty2, oPOIFSFileSystem2, this);
                } else {
                    documentNode = new DirectoryNode(directoryProperty2, this._nfilesystem, this);
                }
            } else {
                documentNode = new DocumentNode((DocumentProperty) next, this);
            }
            this._entries.add(documentNode);
            this._byname.put(documentNode.getName(), documentNode);
        }
    }

    public POIFSDocumentPath getPath() {
        return this._path;
    }

    public NPOIFSFileSystem getFileSystem() {
        return this._nfilesystem;
    }

    public OPOIFSFileSystem getOFileSystem() {
        return this._ofilesystem;
    }

    public NPOIFSFileSystem getNFileSystem() {
        return this._nfilesystem;
    }

    public DocumentInputStream createDocumentInputStream(String str) throws IOException {
        return createDocumentInputStream(getEntry(str));
    }

    public DocumentInputStream createDocumentInputStream(Entry entry) throws IOException {
        if (!entry.isDocumentEntry()) {
            throw new IOException("Entry '" + entry.getName() + "' is not a DocumentEntry");
        }
        return new DocumentInputStream((DocumentEntry) entry);
    }

    DocumentEntry createDocument(OPOIFSDocument oPOIFSDocument) throws IOException {
        DocumentProperty documentProperty = oPOIFSDocument.getDocumentProperty();
        DocumentNode documentNode = new DocumentNode(documentProperty, this);
        ((DirectoryProperty) getProperty()).addChild(documentProperty);
        this._ofilesystem.addDocument(oPOIFSDocument);
        this._entries.add(documentNode);
        this._byname.put(documentProperty.getName(), documentNode);
        return documentNode;
    }

    DocumentEntry createDocument(NPOIFSDocument nPOIFSDocument) throws IOException {
        DocumentProperty documentProperty = nPOIFSDocument.getDocumentProperty();
        DocumentNode documentNode = new DocumentNode(documentProperty, this);
        ((DirectoryProperty) getProperty()).addChild(documentProperty);
        this._nfilesystem.addDocument(nPOIFSDocument);
        this._entries.add(documentNode);
        this._byname.put(documentProperty.getName(), documentNode);
        return documentNode;
    }

    boolean changeName(String str, String str2) {
        EntryNode entryNode = (EntryNode) this._byname.get(str);
        if (entryNode == null) {
            return false;
        }
        boolean zChangeName = ((DirectoryProperty) getProperty()).changeName(entryNode.getProperty(), str2);
        if (!zChangeName) {
            return zChangeName;
        }
        this._byname.remove(str);
        this._byname.put(entryNode.getProperty().getName(), entryNode);
        return zChangeName;
    }

    boolean deleteEntry(EntryNode entryNode) {
        boolean zDeleteChild = ((DirectoryProperty) getProperty()).deleteChild(entryNode.getProperty());
        if (zDeleteChild) {
            this._entries.remove(entryNode);
            this._byname.remove(entryNode.getName());
            OPOIFSFileSystem oPOIFSFileSystem = this._ofilesystem;
            if (oPOIFSFileSystem != null) {
                oPOIFSFileSystem.remove(entryNode);
            } else {
                try {
                    this._nfilesystem.remove(entryNode);
                } catch (IOException unused) {
                }
            }
        }
        return zDeleteChild;
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public Iterator<Entry> getEntries() {
        return this._entries.iterator();
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public Set<String> getEntryNames() {
        return this._byname.keySet();
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public boolean isEmpty() {
        return this._entries.isEmpty();
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public int getEntryCount() {
        return this._entries.size();
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public boolean hasEntry(String str) {
        return str != null && this._byname.containsKey(str);
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public Entry getEntry(String str) throws FileNotFoundException {
        Entry entry = str != null ? this._byname.get(str) : null;
        if (entry != null) {
            return entry;
        }
        throw new FileNotFoundException("no such entry: \"" + str + "\", had: " + this._byname.keySet());
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public DocumentEntry createDocument(String str, InputStream inputStream) throws IOException {
        if (this._nfilesystem != null) {
            return createDocument(new NPOIFSDocument(str, this._nfilesystem, inputStream));
        }
        return createDocument(new OPOIFSDocument(str, inputStream));
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public DocumentEntry createDocument(String str, int i, POIFSWriterListener pOIFSWriterListener) throws IOException {
        if (this._nfilesystem != null) {
            return createDocument(new NPOIFSDocument(str, i, this._nfilesystem, pOIFSWriterListener));
        }
        return createDocument(new OPOIFSDocument(str, i, this._path, pOIFSWriterListener));
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public DirectoryEntry createDirectory(String str) throws IOException {
        DirectoryNode directoryNode;
        DirectoryProperty directoryProperty = new DirectoryProperty(str);
        OPOIFSFileSystem oPOIFSFileSystem = this._ofilesystem;
        if (oPOIFSFileSystem != null) {
            directoryNode = new DirectoryNode(directoryProperty, oPOIFSFileSystem, this);
            this._ofilesystem.addDirectory(directoryProperty);
        } else {
            directoryNode = new DirectoryNode(directoryProperty, this._nfilesystem, this);
            this._nfilesystem.addDirectory(directoryProperty);
        }
        ((DirectoryProperty) getProperty()).addChild(directoryProperty);
        this._entries.add(directoryNode);
        this._byname.put(str, directoryNode);
        return directoryNode;
    }

    public DocumentEntry createOrUpdateDocument(String str, InputStream inputStream) throws IOException {
        if (!hasEntry(str)) {
            return createDocument(str, inputStream);
        }
        DocumentNode documentNode = (DocumentNode) getEntry(str);
        if (this._nfilesystem != null) {
            new NPOIFSDocument(documentNode).replaceContents(inputStream);
            return documentNode;
        }
        deleteEntry(documentNode);
        return createDocument(str, inputStream);
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public ClassID getStorageClsid() {
        return getProperty().getStorageClsid();
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public void setStorageClsid(ClassID classID) {
        getProperty().setStorageClsid(classID);
    }

    @Override // org.apache.poi.poifs.filesystem.EntryNode
    protected boolean isDeleteOK() {
        return isEmpty();
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public Iterator<Object> getViewableIterator() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getProperty());
        Iterator<Entry> it = this._entries.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList.iterator();
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public String getShortDescription() {
        return getName();
    }

    @Override // java.lang.Iterable
    public Iterator<Entry> iterator() {
        return getEntries();
    }
}
