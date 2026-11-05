package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class RunXQuery {
    public static void printUsage() {
        System.out.println("Run an XQuery against an XML instance");
        System.out.println("Usage:");
        System.out.println("xquery [-verbose] [-pretty] [-q <query> | -qf query.xq] [file.xml]*");
        System.out.println(" -q <query> to specify a query on the command-line");
        System.out.println(" -qf <query> to specify a file containing a query");
        System.out.println(" -pretty pretty-prints the results");
        System.out.println(" -license prints license information");
        System.out.println(" the query is run on each XML file specified");
        System.out.println("");
    }

    public static void main(String[] strArr) throws Exception {
        HashSet hashSet = new HashSet();
        hashSet.add("h");
        hashSet.add("help");
        hashSet.add("usage");
        hashSet.add("license");
        hashSet.add("version");
        hashSet.add("verbose");
        hashSet.add("pretty");
        CommandLine commandLine = new CommandLine(strArr, hashSet, Arrays.asList("q", "qf"));
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
            System.exit(0);
            return;
        }
        boolean z = commandLine.getOpt("verbose") != null;
        boolean z2 = commandLine.getOpt("pretty") != null;
        String opt = commandLine.getOpt("q");
        String opt2 = commandLine.getOpt("qf");
        if (opt == null && opt2 == null) {
            System.err.println("No query specified");
            System.exit(0);
            return;
        }
        if (opt != null && opt2 != null) {
            System.err.println("Specify -qf or -q, not both.");
            System.exit(0);
            return;
        }
        if (opt2 != null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(new File(opt2));
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    int i = inputStreamReader.read();
                    if (i < 0) {
                        break;
                    } else {
                        stringBuffer.append((char) i);
                    }
                }
                inputStreamReader.close();
                fileInputStream.close();
                opt = stringBuffer.toString();
            } catch (Throwable th) {
                System.err.println("Cannot read query file: " + th.getMessage());
                System.exit(1);
                return;
            }
        }
        if (z) {
            System.out.println("Compile Query:");
            System.out.println(opt);
            System.out.println();
        }
        try {
            String strCompileQuery = XmlBeans.compileQuery(opt);
            File[] files = commandLine.getFiles();
            for (int i2 = 0; i2 < files.length; i2++) {
                if (z) {
                    try {
                        FileInputStream fileInputStream2 = new FileInputStream(files[i2]);
                        while (true) {
                            int i3 = fileInputStream2.read();
                            if (i3 < 0) {
                                break;
                            } else {
                                System.out.write(i3);
                            }
                        }
                        fileInputStream2.close();
                        System.out.println();
                    } catch (Throwable th2) {
                        System.err.println("Error parsing instance: " + th2.getMessage());
                        System.exit(1);
                        return;
                    }
                }
                XmlObject xmlObject = XmlObject.Factory.parse(files[i2]);
                if (z) {
                    System.out.println("Executing Query...");
                    System.err.println();
                }
                try {
                    XmlObject[] xmlObjectArrExecQuery = xmlObject.execQuery(strCompileQuery);
                    if (z) {
                        System.out.println("Query Result:");
                    }
                    XmlOptions xmlOptions = new XmlOptions();
                    xmlOptions.setSaveOuter();
                    if (z2) {
                        xmlOptions.setSavePrettyPrint();
                    }
                    for (XmlObject xmlObject2 : xmlObjectArrExecQuery) {
                        xmlObject2.save(System.out, xmlOptions);
                        System.out.println();
                    }
                } catch (Throwable th3) {
                    System.err.println("Error executing query: " + th3.getMessage());
                    System.exit(1);
                    return;
                }
            }
        } catch (Exception e) {
            System.err.println("Error compiling query: " + e.getMessage());
            System.exit(1);
        }
    }
}
