package org.apache.xmlbeans.impl.jam.internal.javadoc;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class JavadocClassloadingException extends RuntimeException {
    private static String ALTERNATE_EXPLANATION = null;
    private static final String SOME_CLASS_IN_TOOLS_JAR = "com.sun.javadoc.Doclet";
    private static final String STANDARD_EXPLANATION = "An error has occurred while invoking javadoc to inspect your source\nfiles.  This may be due to the fact that $JAVA_HOME/lib/tools.jar does\nnot seem to be in your system classloader.  One common case in which \nthis happens is when using the 'ant' tool, which uses a special\ncontext classloader to load classes from tools.jar.\n\nThis situation elicits what is believed to a javadoc bug in the initial\nrelease of JDK 1.5.  Javadoc attempts to use its own context classloader\ntools.jar but ignores one that may have already been set, which leads\nto some classes being loaded into two different classloaders.  The\ntelltale sign of this problem is a javadoc error message saying that\n'languageVersion() must return LanguageVersion - you might see this\nmessage in your process' output.\n\nThis will hopefully be fixed in a later release of JDK 1.5; if a new\nversion of 1.5 has become available, you might be able to solve this\nby simply upgrading to the latest JDK.\n\nAlternatively, you can work around it by simply including \n$JAVA_HOME/lib/tools.jar in the java -classpath\nparameter.  If you are running ant, you will need to modify the standard\nant script to include tools.jar in the -classpath.\n";

    public static boolean isClassloadingProblemPresent() {
        try {
            ClassLoader.getSystemClassLoader().loadClass(SOME_CLASS_IN_TOOLS_JAR);
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public JavadocClassloadingException() {
        String str = ALTERNATE_EXPLANATION;
        super(str == null ? STANDARD_EXPLANATION : str);
    }

    public static void setExplanation(String str) {
        ALTERNATE_EXPLANATION = str;
    }
}
