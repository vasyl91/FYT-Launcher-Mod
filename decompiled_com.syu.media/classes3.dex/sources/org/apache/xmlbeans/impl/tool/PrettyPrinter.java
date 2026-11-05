package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashSet;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class PrettyPrinter {
    private static final int DEFAULT_INDENT = 2;

    public static void printUsage() {
        System.out.println("Pretty prints XML files.");
        System.out.println("Usage: xpretty [switches] file.xml");
        System.out.println("Switches:");
        System.out.println("    -indent #   use the given indent");
        System.out.println("    -license prints license information");
    }

    public static void main(String[] strArr) {
        HashSet hashSet = new HashSet();
        hashSet.add("h");
        hashSet.add("help");
        hashSet.add("usage");
        hashSet.add("license");
        hashSet.add("version");
        CommandLine commandLine = new CommandLine(strArr, hashSet, Collections.singleton("indent"));
        if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null) {
            printUsage();
            System.exit(0);
            return;
        }
        String[] badOpts = commandLine.getBadOpts();
        if (badOpts.length > 0) {
            for (String str : badOpts) {
                System.out.println("Unrecognized option: " + str);
            }
            printUsage();
            System.exit(0);
            return;
        }
        if (commandLine.getOpt("license") != null) {
            CommandLine.printLicense();
            System.exit(0);
            return;
        }
        if (commandLine.getOpt("version") != null) {
            CommandLine.printVersion();
            System.exit(0);
            return;
        }
        if (commandLine.args().length == 0) {
            printUsage();
            return;
        }
        String opt = commandLine.getOpt("indent");
        int i = opt == null ? 2 : Integer.parseInt(opt);
        File[] files = commandLine.getFiles();
        for (int i2 = 0; i2 < files.length; i2++) {
            try {
                try {
                    XmlObject.Factory.parse(files[i2], new XmlOptions().setLoadLineNumbers()).save(System.out, new XmlOptions().setSavePrettyPrint().setSavePrettyPrintIndent(i));
                } catch (IOException e) {
                    System.err.println("Unable to pretty print " + files[i2] + ": " + e.getMessage());
                }
            } catch (Exception e2) {
                System.err.println(files[i2] + " not loadable: " + e2.getMessage());
            }
        }
    }

    public static String indent(String str) throws XmlException, IOException {
        StringWriter stringWriter = new StringWriter();
        XmlObject.Factory.parse(str, new XmlOptions().setLoadLineNumbers()).save(stringWriter, new XmlOptions().setSavePrettyPrint().setSavePrettyPrintIndent(2));
        stringWriter.close();
        return stringWriter.getBuffer().toString();
    }
}
