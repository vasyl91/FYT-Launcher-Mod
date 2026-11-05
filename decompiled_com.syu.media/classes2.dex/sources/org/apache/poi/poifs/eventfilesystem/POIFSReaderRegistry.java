package org.apache.poi.poifs.eventfilesystem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.poi.poifs.filesystem.DocumentDescriptor;
import org.apache.poi.poifs.filesystem.POIFSDocumentPath;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
class POIFSReaderRegistry {
    private Set<POIFSReaderListener> omnivorousListeners = new HashSet();
    private Map<POIFSReaderListener, Set<DocumentDescriptor>> selectiveListeners = new HashMap();
    private Map<DocumentDescriptor, Set<POIFSReaderListener>> chosenDocumentDescriptors = new HashMap();

    POIFSReaderRegistry() {
    }

    void registerListener(POIFSReaderListener pOIFSReaderListener, POIFSDocumentPath pOIFSDocumentPath, String str) {
        if (this.omnivorousListeners.contains(pOIFSReaderListener)) {
            return;
        }
        Set<DocumentDescriptor> hashSet = this.selectiveListeners.get(pOIFSReaderListener);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.selectiveListeners.put(pOIFSReaderListener, hashSet);
        }
        DocumentDescriptor documentDescriptor = new DocumentDescriptor(pOIFSDocumentPath, str);
        if (hashSet.add(documentDescriptor)) {
            Set<POIFSReaderListener> hashSet2 = this.chosenDocumentDescriptors.get(documentDescriptor);
            if (hashSet2 == null) {
                hashSet2 = new HashSet<>();
                this.chosenDocumentDescriptors.put(documentDescriptor, hashSet2);
            }
            hashSet2.add(pOIFSReaderListener);
        }
    }

    void registerListener(POIFSReaderListener pOIFSReaderListener) {
        if (this.omnivorousListeners.contains(pOIFSReaderListener)) {
            return;
        }
        removeSelectiveListener(pOIFSReaderListener);
        this.omnivorousListeners.add(pOIFSReaderListener);
    }

    Iterator<POIFSReaderListener> getListeners(POIFSDocumentPath pOIFSDocumentPath, String str) {
        HashSet hashSet = new HashSet(this.omnivorousListeners);
        Set<POIFSReaderListener> set = this.chosenDocumentDescriptors.get(new DocumentDescriptor(pOIFSDocumentPath, str));
        if (set != null) {
            hashSet.addAll(set);
        }
        return hashSet.iterator();
    }

    private void removeSelectiveListener(POIFSReaderListener pOIFSReaderListener) {
        Set<DocumentDescriptor> setRemove = this.selectiveListeners.remove(pOIFSReaderListener);
        if (setRemove != null) {
            Iterator<DocumentDescriptor> it = setRemove.iterator();
            while (it.hasNext()) {
                dropDocument(pOIFSReaderListener, it.next());
            }
        }
    }

    private void dropDocument(POIFSReaderListener pOIFSReaderListener, DocumentDescriptor documentDescriptor) {
        Set<POIFSReaderListener> set = this.chosenDocumentDescriptors.get(documentDescriptor);
        set.remove(pOIFSReaderListener);
        if (set.size() == 0) {
            this.chosenDocumentDescriptors.remove(documentDescriptor);
        }
    }
}
