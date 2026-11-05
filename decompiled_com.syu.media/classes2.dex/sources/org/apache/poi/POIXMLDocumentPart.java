package org.apache.poi;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.exceptions.PartAlreadyExistsException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.util.Internal;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class POIXMLDocumentPart {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) POIXMLDocumentPart.class);
    private String coreDocumentRel;
    private PackagePart packagePart;
    private POIXMLDocumentPart parent;
    private int relationCounter;
    private Map<String, RelationPart> relations;

    protected void commit() throws IOException {
    }

    protected void onDocumentCreate() throws IOException {
    }

    protected void onDocumentRead() throws IOException {
    }

    protected void onDocumentRemove() throws IOException {
    }

    public static class RelationPart {
        private final POIXMLDocumentPart documentPart;
        private final PackageRelationship relationship;

        RelationPart(PackageRelationship packageRelationship, POIXMLDocumentPart pOIXMLDocumentPart) {
            this.relationship = packageRelationship;
            this.documentPart = pOIXMLDocumentPart;
        }

        public PackageRelationship getRelationship() {
            return this.relationship;
        }

        public <T extends POIXMLDocumentPart> T getDocumentPart() {
            return (T) this.documentPart;
        }
    }

    int incrementRelationCounter() {
        int i = this.relationCounter + 1;
        this.relationCounter = i;
        return i;
    }

    int decrementRelationCounter() {
        int i = this.relationCounter - 1;
        this.relationCounter = i;
        return i;
    }

    int getRelationCounter() {
        return this.relationCounter;
    }

    public POIXMLDocumentPart(OPCPackage oPCPackage) {
        this(oPCPackage, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument");
    }

    public POIXMLDocumentPart(OPCPackage oPCPackage, String str) {
        this(getPartFromOPCPackage(oPCPackage, str));
        this.coreDocumentRel = str;
    }

    public POIXMLDocumentPart() {
        this.coreDocumentRel = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument";
        this.relations = new LinkedHashMap();
        this.relationCounter = 0;
    }

    public POIXMLDocumentPart(PackagePart packagePart) {
        this((POIXMLDocumentPart) null, packagePart);
    }

    public POIXMLDocumentPart(POIXMLDocumentPart pOIXMLDocumentPart, PackagePart packagePart) {
        this.coreDocumentRel = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument";
        this.relations = new LinkedHashMap();
        this.relationCounter = 0;
        this.packagePart = packagePart;
        this.parent = pOIXMLDocumentPart;
    }

    protected final void rebase(OPCPackage oPCPackage) throws InvalidFormatException {
        PackageRelationshipCollection relationshipsByType = this.packagePart.getRelationshipsByType(this.coreDocumentRel);
        if (relationshipsByType.size() != 1) {
            throw new IllegalStateException("Tried to rebase using " + this.coreDocumentRel + " but found " + relationshipsByType.size() + " parts of the right type");
        }
        this.packagePart = this.packagePart.getRelatedPart(relationshipsByType.getRelationship(0));
    }

    public final PackagePart getPackagePart() {
        return this.packagePart;
    }

    public final List<POIXMLDocumentPart> getRelations() {
        ArrayList arrayList = new ArrayList();
        Iterator<RelationPart> it = this.relations.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getDocumentPart());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final List<RelationPart> getRelationParts() {
        return Collections.unmodifiableList(new ArrayList(this.relations.values()));
    }

    public final POIXMLDocumentPart getRelationById(String str) {
        RelationPart relationPart = this.relations.get(str);
        if (relationPart == null) {
            return null;
        }
        return relationPart.getDocumentPart();
    }

    public final String getRelationId(POIXMLDocumentPart pOIXMLDocumentPart) {
        for (RelationPart relationPart : this.relations.values()) {
            if (relationPart.getDocumentPart() == pOIXMLDocumentPart) {
                return relationPart.getRelationship().getId();
            }
        }
        return null;
    }

    public final RelationPart addRelation(String str, POIXMLRelation pOIXMLRelation, POIXMLDocumentPart pOIXMLDocumentPart) {
        PackageRelationship packageRelationshipFindExistingRelation = this.packagePart.findExistingRelation(pOIXMLDocumentPart.getPackagePart());
        if (packageRelationshipFindExistingRelation == null) {
            packageRelationshipFindExistingRelation = this.packagePart.addRelationship(pOIXMLDocumentPart.getPackagePart().getPartName(), TargetMode.INTERNAL, pOIXMLRelation.getRelation(), str);
        }
        addRelation(packageRelationshipFindExistingRelation, pOIXMLDocumentPart);
        return new RelationPart(packageRelationshipFindExistingRelation, pOIXMLDocumentPart);
    }

    private void addRelation(PackageRelationship packageRelationship, POIXMLDocumentPart pOIXMLDocumentPart) {
        this.relations.put(packageRelationship.getId(), new RelationPart(packageRelationship, pOIXMLDocumentPart));
        pOIXMLDocumentPart.incrementRelationCounter();
    }

    protected final void removeRelation(POIXMLDocumentPart pOIXMLDocumentPart) {
        removeRelation(pOIXMLDocumentPart, true);
    }

    protected final boolean removeRelation(POIXMLDocumentPart pOIXMLDocumentPart, boolean z) {
        String relationId = getRelationId(pOIXMLDocumentPart);
        if (relationId == null) {
            return false;
        }
        pOIXMLDocumentPart.decrementRelationCounter();
        getPackagePart().removeRelationship(relationId);
        this.relations.remove(relationId);
        if (!z || pOIXMLDocumentPart.getRelationCounter() != 0) {
            return true;
        }
        try {
            pOIXMLDocumentPart.onDocumentRemove();
            getPackagePart().getPackage().removePart(pOIXMLDocumentPart.getPackagePart());
            return true;
        } catch (IOException e) {
            throw new POIXMLException(e);
        }
    }

    public final POIXMLDocumentPart getParent() {
        return this.parent;
    }

    public String toString() {
        PackagePart packagePart = this.packagePart;
        return packagePart == null ? "" : packagePart.toString();
    }

    protected final void onSave(Set<PackagePart> set) throws IOException {
        prepareForCommit();
        commit();
        set.add(getPackagePart());
        Iterator<RelationPart> it = this.relations.values().iterator();
        while (it.hasNext()) {
            POIXMLDocumentPart documentPart = it.next().getDocumentPart();
            if (!set.contains(documentPart.getPackagePart())) {
                documentPart.onSave(set);
            }
        }
    }

    protected void prepareForCommit() {
        PackagePart packagePart = getPackagePart();
        if (packagePart != null) {
            packagePart.clear();
        }
    }

    public final POIXMLDocumentPart createRelationship(POIXMLRelation pOIXMLRelation, POIXMLFactory pOIXMLFactory) {
        return createRelationship(pOIXMLRelation, pOIXMLFactory, -1, false).getDocumentPart();
    }

    public final POIXMLDocumentPart createRelationship(POIXMLRelation pOIXMLRelation, POIXMLFactory pOIXMLFactory, int i) {
        return createRelationship(pOIXMLRelation, pOIXMLFactory, i, false).getDocumentPart();
    }

    protected final int getNextPartNumber(POIXMLRelation pOIXMLRelation, int i) {
        OPCPackage oPCPackage = this.packagePart.getPackage();
        try {
            String defaultFileName = pOIXMLRelation.getDefaultFileName();
            if (defaultFileName.equals(pOIXMLRelation.getFileName(9999))) {
                return oPCPackage.containPart(PackagingURIHelper.createPartName(defaultFileName)) ? -1 : 0;
            }
            int size = i + oPCPackage.getParts().size();
            for (int i2 = i < 0 ? 1 : i; i2 <= size; i2++) {
                if (!oPCPackage.containPart(PackagingURIHelper.createPartName(pOIXMLRelation.getFileName(i2)))) {
                    return i2;
                }
            }
            return -1;
        } catch (InvalidFormatException e) {
            throw new POIXMLException(e);
        }
    }

    protected final RelationPart createRelationship(POIXMLRelation pOIXMLRelation, POIXMLFactory pOIXMLFactory, int i, boolean z) {
        try {
            PackagePartName packagePartNameCreatePartName = PackagingURIHelper.createPartName(pOIXMLRelation.getFileName(i));
            PackagePart packagePartCreatePart = this.packagePart.getPackage().createPart(packagePartNameCreatePartName, pOIXMLRelation.getContentType());
            PackageRelationship packageRelationshipAddRelationship = !z ? this.packagePart.addRelationship(packagePartNameCreatePartName, TargetMode.INTERNAL, pOIXMLRelation.getRelation()) : null;
            POIXMLDocumentPart pOIXMLDocumentPartNewDocumentPart = pOIXMLFactory.newDocumentPart(pOIXMLRelation);
            pOIXMLDocumentPartNewDocumentPart.packagePart = packagePartCreatePart;
            pOIXMLDocumentPartNewDocumentPart.parent = this;
            if (!z) {
                addRelation(packageRelationshipAddRelationship, pOIXMLDocumentPartNewDocumentPart);
            }
            return new RelationPart(packageRelationshipAddRelationship, pOIXMLDocumentPartNewDocumentPart);
        } catch (PartAlreadyExistsException e) {
            throw e;
        } catch (Exception e2) {
            throw new POIXMLException(e2);
        }
    }

    protected void read(POIXMLFactory pOIXMLFactory, Map<PackagePart, POIXMLDocumentPart> map) throws OpenXML4JException {
        PackagePartName packagePartNameCreatePartName;
        PackagePart packagePart = getPackagePart();
        POIXMLDocumentPart pOIXMLDocumentPartPut = map.put(packagePart, this);
        if (pOIXMLDocumentPartPut != null && pOIXMLDocumentPartPut != this) {
            throw new POIXMLException("Unique PackagePart-POIXMLDocumentPart relation broken!");
        }
        if (packagePart.hasRelationships()) {
            PackageRelationshipCollection relationships = this.packagePart.getRelationships();
            ArrayList arrayList = new ArrayList();
            for (PackageRelationship packageRelationship : relationships) {
                if (packageRelationship.getTargetMode() == TargetMode.INTERNAL) {
                    URI targetURI = packageRelationship.getTargetURI();
                    if (targetURI.getRawFragment() != null) {
                        packagePartNameCreatePartName = PackagingURIHelper.createPartName(targetURI.getPath());
                    } else {
                        packagePartNameCreatePartName = PackagingURIHelper.createPartName(targetURI);
                    }
                    PackagePart part = this.packagePart.getPackage().getPart(packagePartNameCreatePartName);
                    if (part == null) {
                        logger.log(7, "Skipped invalid entry " + packageRelationship.getTargetURI());
                    } else {
                        POIXMLDocumentPart pOIXMLDocumentPartCreateDocumentPart = map.get(part);
                        if (pOIXMLDocumentPartCreateDocumentPart == null) {
                            pOIXMLDocumentPartCreateDocumentPart = pOIXMLFactory.createDocumentPart(this, part);
                            pOIXMLDocumentPartCreateDocumentPart.parent = this;
                            map.put(part, pOIXMLDocumentPartCreateDocumentPart);
                            arrayList.add(pOIXMLDocumentPartCreateDocumentPart);
                        }
                        addRelation(packageRelationship, pOIXMLDocumentPartCreateDocumentPart);
                    }
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((POIXMLDocumentPart) it.next()).read(pOIXMLFactory, map);
            }
        }
    }

    protected PackagePart getTargetPart(PackageRelationship packageRelationship) throws InvalidFormatException {
        return getPackagePart().getRelatedPart(packageRelationship);
    }

    @Internal
    @Deprecated
    public static void _invokeOnDocumentRead(POIXMLDocumentPart pOIXMLDocumentPart) throws IOException {
        pOIXMLDocumentPart.onDocumentRead();
    }

    private static PackagePart getPartFromOPCPackage(OPCPackage oPCPackage, String str) {
        PackageRelationship relationship = oPCPackage.getRelationshipsByType(str).getRelationship(0);
        if (relationship != null) {
            PackagePart part = oPCPackage.getPart(relationship);
            if (part != null) {
                return part;
            }
            throw new POIXMLException("OOXML file structure broken/invalid - core document '" + relationship.getTargetURI() + "' not found.");
        }
        if (oPCPackage.getRelationshipsByType(PackageRelationshipTypes.STRICT_CORE_DOCUMENT).getRelationship(0) != null) {
            throw new POIXMLException("Strict OOXML isn't currently supported, please see bug #57699");
        }
        throw new POIXMLException("OOXML file structure broken/invalid - no core document found!");
    }
}
