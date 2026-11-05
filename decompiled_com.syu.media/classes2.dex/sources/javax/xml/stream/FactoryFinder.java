package javax.xml.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
class FactoryFinder {
    static /* synthetic */ Class class$javax$xml$stream$FactoryFinder = null;
    private static boolean debug = false;

    /* JADX INFO: renamed from: javax.xml.stream.FactoryFinder$1, reason: invalid class name */
    class AnonymousClass1 {
    }

    FactoryFinder() {
    }

    static {
        try {
            debug = System.getProperty("xml.stream.debug") != null;
        } catch (Exception unused) {
        }
    }

    private static void debugPrintln(String str) {
        if (debug) {
            System.err.println(new StringBuffer("STREAM: ").append(str).toString());
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private static ClassLoader findClassLoader() throws FactoryConfigurationError {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            Class clsClass$ = class$javax$xml$stream$FactoryFinder;
            if (clsClass$ == null) {
                clsClass$ = class$("javax.xml.stream.FactoryFinder");
                class$javax$xml$stream$FactoryFinder = clsClass$;
            }
            return ((ClassLoaderFinder) Class.forName(stringBuffer.append(clsClass$.getName()).append("$ClassLoaderFinderConcrete").toString()).newInstance()).getContextClassLoader();
        } catch (ClassNotFoundException unused) {
            Class clsClass$2 = class$javax$xml$stream$FactoryFinder;
            if (clsClass$2 == null) {
                clsClass$2 = class$("javax.xml.stream.FactoryFinder");
                class$javax$xml$stream$FactoryFinder = clsClass$2;
            }
            return clsClass$2.getClassLoader();
        } catch (Exception e) {
            throw new FactoryConfigurationError(e.toString(), e);
        } catch (LinkageError unused2) {
            Class clsClass$3 = class$javax$xml$stream$FactoryFinder;
            if (clsClass$3 == null) {
                clsClass$3 = class$("javax.xml.stream.FactoryFinder");
                class$javax$xml$stream$FactoryFinder = clsClass$3;
            }
            return clsClass$3.getClassLoader();
        }
    }

    private static Object newInstance(String str, ClassLoader classLoader) throws FactoryConfigurationError {
        Class<?> clsLoadClass;
        try {
            if (classLoader == null) {
                clsLoadClass = Class.forName(str);
            } else {
                clsLoadClass = classLoader.loadClass(str);
            }
            return clsLoadClass.newInstance();
        } catch (ClassNotFoundException e) {
            throw new FactoryConfigurationError(new StringBuffer("Provider ").append(str).append(" not found").toString(), e);
        } catch (Exception e2) {
            throw new FactoryConfigurationError(new StringBuffer("Provider ").append(str).append(" could not be instantiated: ").append(e2).toString(), e2);
        }
    }

    static Object find(String str) throws FactoryConfigurationError {
        return find(str, null);
    }

    static Object find(String str, String str2) throws FactoryConfigurationError {
        return find(str, str2, findClassLoader());
    }

    static Object find(String str, String str2, ClassLoader classLoader) throws FactoryConfigurationError {
        InputStream resourceAsStream;
        try {
            String property = System.getProperty(str);
            if (property != null) {
                debugPrintln(new StringBuffer("found system property").append(property).toString());
                return newInstance(property, classLoader);
            }
        } catch (SecurityException unused) {
        }
        try {
            File file = new File(new StringBuffer().append(System.getProperty("java.home")).append(File.separator).append("lib").append(File.separator).append("jaxp.properties").toString());
            if (file.exists()) {
                Properties properties = new Properties();
                properties.load(new FileInputStream(file));
                String property2 = properties.getProperty(str);
                debugPrintln(new StringBuffer("found java.home property ").append(property2).toString());
                return newInstance(property2, classLoader);
            }
        } catch (Exception e) {
            if (debug) {
                e.printStackTrace();
            }
        }
        String string = new StringBuffer("META-INF/services/").append(str).toString();
        try {
            if (classLoader == null) {
                resourceAsStream = ClassLoader.getSystemResourceAsStream(string);
            } else {
                resourceAsStream = classLoader.getResourceAsStream(string);
            }
            if (resourceAsStream != null) {
                debugPrintln(new StringBuffer("found ").append(string).toString());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, "UTF-8"));
                String line = bufferedReader.readLine();
                bufferedReader.close();
                if (line != null && !"".equals(line)) {
                    debugPrintln(new StringBuffer("loaded from services: ").append(line).toString());
                    return newInstance(line, classLoader);
                }
            }
        } catch (Exception e2) {
            if (debug) {
                e2.printStackTrace();
            }
        }
        if (str2 == null) {
            throw new FactoryConfigurationError(new StringBuffer("Provider for ").append(str).append(" cannot be found").toString(), (Exception) null);
        }
        debugPrintln(new StringBuffer("loaded from fallback value: ").append(str2).toString());
        return newInstance(str2, classLoader);
    }

    private static abstract class ClassLoaderFinder {
        abstract ClassLoader getContextClassLoader();

        private ClassLoaderFinder() {
        }

        /* synthetic */ ClassLoaderFinder(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static class ClassLoaderFinderConcrete extends ClassLoaderFinder {
        ClassLoaderFinderConcrete() {
            super(null);
        }

        @Override // javax.xml.stream.FactoryFinder.ClassLoaderFinder
        ClassLoader getContextClassLoader() {
            return Thread.currentThread().getContextClassLoader();
        }
    }
}
