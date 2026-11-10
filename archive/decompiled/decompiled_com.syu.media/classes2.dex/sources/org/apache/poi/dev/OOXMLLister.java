package org.apache.poi.dev;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Iterator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class OOXMLLister implements Closeable {
    private final OPCPackage container;
    private final PrintStream disp;

    public OOXMLLister(OPCPackage oPCPackage) {
        this(oPCPackage, System.out);
    }

    public OOXMLLister(OPCPackage oPCPackage, PrintStream printStream) {
        this.container = oPCPackage;
        this.disp = printStream;
    }

    public static long getSize(PackagePart packagePart) throws IOException {
        InputStream inputStream = packagePart.getInputStream();
        try {
            byte[] bArr = new byte[8192];
            long j = 0;
            int i = 0;
            while (i > -1) {
                i = inputStream.read(bArr);
                if (i > 0) {
                    j += (long) i;
                }
            }
            inputStream.close();
            return j;
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    public void displayParts() throws InvalidFormatException, IOException {
        for (PackagePart packagePart : this.container.getParts()) {
            this.disp.println(packagePart.getPartName());
            this.disp.println("\t" + packagePart.getContentType());
            if (!packagePart.getPartName().toString().equals("/docProps/core.xml")) {
                this.disp.println("\t" + getSize(packagePart) + " bytes");
            }
            if (!packagePart.isRelationshipPart()) {
                this.disp.println("\t" + packagePart.getRelationships().size() + " relations");
                Iterator<PackageRelationship> it = packagePart.getRelationships().iterator();
                while (it.hasNext()) {
                    displayRelation(it.next(), "\t  ");
                }
            }
        }
    }

    public void displayRelations() {
        Iterator<PackageRelationship> it = this.container.getRelationships().iterator();
        while (it.hasNext()) {
            displayRelation(it.next(), "");
        }
    }

    private void displayRelation(PackageRelationship packageRelationship, String str) {
        this.disp.println(str + "Relationship:");
        this.disp.println(str + "\tFrom: " + packageRelationship.getSourceURI());
        this.disp.println(str + "\tTo:   " + packageRelationship.getTargetURI());
        this.disp.println(str + "\tID:   " + packageRelationship.getId());
        this.disp.println(str + "\tMode: " + packageRelationship.getTargetMode());
        this.disp.println(str + "\tType: " + packageRelationship.getRelationshipType());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.container.close();
    }

    public static void main(String[] strArr) throws InvalidFormatException, IOException {
        if (strArr.length == 0) {
            System.err.println("Use:");
            System.err.println("\tjava OOXMLLister <filename>");
            System.exit(1);
        }
        File file = new File(strArr[0]);
        if (!file.exists()) {
            System.err.println("Error, file not found!");
            System.err.println("\t" + file);
            System.exit(2);
        }
        OOXMLLister oOXMLLister = new OOXMLLister(OPCPackage.open(file.toString(), PackageAccess.READ));
        try {
            oOXMLLister.disp.println(file + "\n");
            oOXMLLister.displayParts();
            oOXMLLister.disp.println();
            oOXMLLister.displayRelations();
        } finally {
            oOXMLLister.close();
        }
    }
}
