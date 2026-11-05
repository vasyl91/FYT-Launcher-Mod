package org.apache.xmlbeans.impl.jam.internal.parser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.apache.xmlbeans.impl.jam.JamClassLoader;
import org.apache.xmlbeans.impl.jam.mutable.MClass;
import org.apache.xmlbeans.impl.jam.provider.JamClassBuilder;
import org.apache.xmlbeans.impl.jam.provider.JamClassPopulator;
import org.apache.xmlbeans.impl.jam.provider.JamServiceContext;
import org.apache.xmlbeans.impl.jam.provider.ResourcePath;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ParserClassBuilder extends JamClassBuilder implements JamClassPopulator {
    private static final boolean VERBOSE = false;
    private PrintWriter mOut;
    private ResourcePath mSourcePath;
    private boolean mVerbose;

    private ParserClassBuilder() {
        this.mVerbose = VERBOSE;
        this.mOut = new PrintWriter(System.out);
    }

    public ParserClassBuilder(JamServiceContext jamServiceContext) {
        this.mVerbose = VERBOSE;
        this.mOut = new PrintWriter(System.out);
        this.mSourcePath = jamServiceContext.getInputSourcepath();
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamClassBuilder
    public MClass build(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("null pkg");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("null name");
        }
        String str3 = str.replace(NameUtil.PERIOD, File.separatorChar) + File.separatorChar + str2 + ".java";
        if (str2.indexOf(".") != -1) {
            throw new IllegalArgumentException("inner classes are NYI at the moment");
        }
        InputStream inputStreamFindInPath = this.mSourcePath.findInPath(str3);
        if (inputStreamFindInPath == null) {
            if (this.mVerbose) {
                this.mOut.println("[ParserClassBuilder] could not find " + str3);
            }
            return null;
        }
        if (this.mVerbose) {
            this.mOut.println("[ParserClassBuilder] loading class " + str + "  " + str2);
            this.mOut.println("[ParserClassBuilder] from file " + str3);
        }
        try {
            new InputStreamReader(inputStreamFindInPath).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamClassPopulator
    public void populate(MClass mClass) {
        throw new IllegalStateException("NYI");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MClass[] parse(Reader reader, JamClassLoader jamClassLoader) throws Exception {
        if (reader == null) {
            throw new IllegalArgumentException("null in");
        }
        if (jamClassLoader == null) {
            throw new IllegalArgumentException("null loader");
        }
        throw new IllegalStateException("temporarily NI");
    }

    public static void main(String[] strArr) {
        new MainTool().process(strArr);
    }

    static class MainTool {
        private List mFailures = new ArrayList();
        private int mCount = 0;
        private PrintWriter mOut = new PrintWriter(System.out);
        private long mStartTime = System.currentTimeMillis();

        MainTool() {
        }

        public void process(String[] strArr) {
            for (String str : strArr) {
                try {
                    parse(new ParserClassBuilder(), new File(str));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.mOut.println("\n\n\n");
            int size = this.mFailures.size();
            if (size != 0) {
                this.mOut.println("The following files failed to parse:");
                for (int i = 0; i < size; i++) {
                    this.mOut.println(((File) this.mFailures.get(i)).getAbsolutePath());
                }
            }
            PrintWriter printWriter = this.mOut;
            StringBuilder sb = new StringBuilder();
            int i2 = this.mCount;
            printWriter.println(sb.append(((i2 - size) * 100) / i2).append("% (").append(this.mCount - size).append("/").append(this.mCount).append(") of input java files successfully parsed.").toString());
            this.mOut.println("Total time: " + ((System.currentTimeMillis() - this.mStartTime) / 1000) + " seconds.");
            this.mOut.flush();
            System.out.flush();
            System.err.flush();
        }

        private void parse(ParserClassBuilder parserClassBuilder, File file) throws Exception {
            System.gc();
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    parse(parserClassBuilder, file2);
                }
                return;
            }
            if (file.getName().endsWith(".java")) {
                this.mCount++;
                try {
                    if (ParserClassBuilder.parse(new FileReader(file), null) == null) {
                        this.mOut.println("[error, parser result is null]");
                        addFailure(file);
                    }
                } catch (Throwable th) {
                    th.printStackTrace(this.mOut);
                    addFailure(file);
                }
            }
        }

        private void addFailure(File file) {
            this.mFailures.add(file);
        }
    }
}
