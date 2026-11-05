package org.apache.xmlbeans.impl.jam;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.xmlbeans.impl.jam.internal.JamPrinter;
import org.apache.xmlbeans.impl.jam.provider.JamServiceFactoryImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class JamServiceFactory {
    private static final JamServiceFactory DEFAULT = new JamServiceFactoryImpl();

    public abstract JamClassLoader createJamClassLoader(ClassLoader classLoader);

    public abstract JamService createService(JamServiceParams jamServiceParams) throws IOException;

    public abstract JamServiceParams createServiceParams();

    public abstract JamClassLoader createSystemJamClassLoader();

    public static JamServiceFactory getInstance() {
        return DEFAULT;
    }

    protected JamServiceFactory() {
    }

    public static void main(String[] strArr) {
        try {
            JamServiceParams jamServiceParamsCreateServiceParams = getInstance().createServiceParams();
            for (String str : strArr) {
                jamServiceParamsCreateServiceParams.includeSourcePattern(new File[]{new File(".")}, str);
            }
            JamService jamServiceCreateService = getInstance().createService(jamServiceParamsCreateServiceParams);
            JamPrinter jamPrinterNewInstance = JamPrinter.newInstance();
            PrintWriter printWriter = new PrintWriter(System.out);
            JamClassIterator classes = jamServiceCreateService.getClasses();
            while (classes.hasNext()) {
                printWriter.println("-------- ");
                jamPrinterNewInstance.print(classes.nextClass(), printWriter);
            }
            printWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.flush();
        System.err.flush();
    }
}
