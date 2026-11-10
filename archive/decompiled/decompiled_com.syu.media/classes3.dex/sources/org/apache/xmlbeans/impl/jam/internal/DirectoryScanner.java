package org.apache.xmlbeans.impl.jam.internal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
import org.apache.xmlbeans.impl.jam.provider.JamLogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class DirectoryScanner {
    private Vector mDirsIncluded;
    private String[] mExcludes;
    private Vector mFilesIncluded;
    private String[] mIncludes;
    private JamLogger mLogger;
    private File mRoot;
    private boolean mCaseSensitive = true;
    private List mIncludeList = null;
    private List mExcludeList = null;
    private boolean mIsDirty = false;
    private String[] mIncludedFilesCache = null;

    public DirectoryScanner(File file, JamLogger jamLogger) {
        if (jamLogger == null) {
            throw new IllegalArgumentException("null logger");
        }
        this.mLogger = jamLogger;
        this.mRoot = file;
    }

    public void include(String str) {
        if (this.mIncludeList == null) {
            this.mIncludeList = new ArrayList();
        }
        this.mIncludeList.add(str);
        this.mIsDirty = true;
    }

    public void exclude(String str) {
        if (this.mExcludeList == null) {
            this.mExcludeList = new ArrayList();
        }
        this.mExcludeList.add(str);
        this.mIsDirty = true;
    }

    public String[] getIncludedFiles() throws IOException {
        String[] strArr;
        if (!this.mIsDirty && (strArr = this.mIncludedFilesCache) != null) {
            return strArr;
        }
        List list = this.mIncludeList;
        if (list != null) {
            String[] strArr2 = new String[list.size()];
            this.mIncludeList.toArray(strArr2);
            setIncludes(strArr2);
        } else {
            setIncludes(null);
        }
        List list2 = this.mExcludeList;
        if (list2 != null) {
            String[] strArr3 = new String[list2.size()];
            this.mExcludeList.toArray(strArr3);
            setExcludes(strArr3);
        } else {
            setExcludes(null);
        }
        scan();
        String[] strArr4 = new String[this.mFilesIncluded.size()];
        this.mIncludedFilesCache = strArr4;
        this.mFilesIncluded.copyInto(strArr4);
        return this.mIncludedFilesCache;
    }

    public void setDirty() {
        this.mIsDirty = true;
    }

    public File getRoot() {
        return this.mRoot;
    }

    private void setIncludes(String[] strArr) {
        if (strArr == null) {
            this.mIncludes = null;
            return;
        }
        this.mIncludes = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String strReplace = strArr[i].replace('/', File.separatorChar).replace('\\', File.separatorChar);
            if (strReplace.endsWith(File.separator)) {
                strReplace = strReplace + "**";
            }
            this.mIncludes[i] = strReplace;
        }
    }

    private void setExcludes(String[] strArr) {
        if (strArr == null) {
            this.mExcludes = null;
            return;
        }
        this.mExcludes = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String strReplace = strArr[i].replace('/', File.separatorChar).replace('\\', File.separatorChar);
            if (strReplace.endsWith(File.separator)) {
                strReplace = strReplace + "**";
            }
            this.mExcludes[i] = strReplace;
        }
    }

    private void scan() throws IllegalStateException, IOException {
        if (this.mIncludes == null) {
            this.mIncludes = new String[]{"**"};
        }
        if (this.mExcludes == null) {
            this.mExcludes = new String[0];
        }
        this.mFilesIncluded = new Vector();
        this.mDirsIncluded = new Vector();
        if (isIncluded("") && !isExcluded("")) {
            this.mDirsIncluded.addElement("");
        }
        scandir(this.mRoot, "", true);
    }

    private void scandir(File file, String str, boolean z) throws IOException {
        if (this.mLogger.isVerbose(this)) {
            this.mLogger.verbose("[DirectoryScanner] scanning dir " + file + " for '" + str + "'");
        }
        String[] list = file.list();
        if (list == null) {
            throw new IOException("IO error scanning directory " + file.getAbsolutePath());
        }
        for (int i = 0; i < list.length; i++) {
            String str2 = str + list[i];
            File file2 = new File(file, list[i]);
            if (file2.isDirectory()) {
                if (isIncluded(str2) && !isExcluded(str2)) {
                    this.mDirsIncluded.addElement(str2);
                    if (this.mLogger.isVerbose(this)) {
                        this.mLogger.verbose("...including dir " + str2);
                    }
                    scandir(file2, str2 + File.separator, z);
                } else if (couldHoldIncluded(str2)) {
                    scandir(file2, str2 + File.separator, z);
                }
            } else if (file2.isFile() && isIncluded(str2)) {
                if (!isExcluded(str2)) {
                    this.mFilesIncluded.addElement(str2);
                    if (this.mLogger.isVerbose(this)) {
                        this.mLogger.verbose("...including " + str2 + " under '" + file);
                    }
                } else if (this.mLogger.isVerbose(this)) {
                    this.mLogger.verbose("...EXCLUDING " + str2 + " under '" + file);
                }
            }
        }
    }

    private boolean isIncluded(String str) {
        int i = 0;
        while (true) {
            String[] strArr = this.mIncludes;
            if (i >= strArr.length) {
                return false;
            }
            if (matchPath(strArr[i], str, this.mCaseSensitive)) {
                return true;
            }
            i++;
        }
    }

    private boolean couldHoldIncluded(String str) {
        int i = 0;
        while (true) {
            String[] strArr = this.mIncludes;
            if (i >= strArr.length) {
                return false;
            }
            if (matchPatternStart(strArr[i], str, this.mCaseSensitive)) {
                return true;
            }
            i++;
        }
    }

    private boolean isExcluded(String str) {
        int i = 0;
        while (true) {
            String[] strArr = this.mExcludes;
            if (i >= strArr.length) {
                return false;
            }
            if (matchPath(strArr[i], str, this.mCaseSensitive)) {
                return true;
            }
            i++;
        }
    }

    private static boolean matchPatternStart(String str, String str2, boolean z) {
        if (str2.startsWith(File.separator) != str.startsWith(File.separator)) {
            return false;
        }
        Vector vector = tokenizePath(str);
        Vector vector2 = tokenizePath(str2);
        int size = vector.size() - 1;
        int size2 = vector2.size() - 1;
        int i = 0;
        int i2 = 0;
        while (i <= size && i2 <= size2) {
            String str3 = (String) vector.elementAt(i);
            if (str3.equals("**")) {
                break;
            }
            if (!match(str3, (String) vector2.elementAt(i2), z)) {
                return false;
            }
            i++;
            i2++;
        }
        return i2 > size2 || i <= size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean matchPath(String str, String str2, boolean z) {
        int i;
        int i2 = 0;
        if (str2.startsWith(File.separator) != str.startsWith(File.separator)) {
            return false;
        }
        Vector vector = tokenizePath(str);
        Vector vector2 = tokenizePath(str2);
        int i3 = 1;
        int size = vector.size() - 1;
        int size2 = vector2.size() - 1;
        int i4 = 0;
        int i5 = 0;
        while (i4 <= size && i5 <= size2) {
            String str3 = (String) vector.elementAt(i4);
            if (str3.equals("**")) {
                break;
            }
            if (!match(str3, (String) vector2.elementAt(i5), z)) {
                return false;
            }
            i4++;
            i5++;
        }
        if (i5 > size2) {
            while (i4 <= size) {
                if (!vector.elementAt(i4).equals("**")) {
                    return false;
                }
                i4++;
            }
            return true;
        }
        if (i4 > size) {
            return false;
        }
        while (i4 <= size && i5 <= size2) {
            String str4 = (String) vector.elementAt(size);
            if (str4.equals("**")) {
                break;
            }
            if (!match(str4, (String) vector2.elementAt(size2), z)) {
                return false;
            }
            size--;
            size2--;
        }
        if (i5 > size2) {
            while (i4 <= size) {
                if (!vector.elementAt(i4).equals("**")) {
                    return false;
                }
                i4++;
            }
            return true;
        }
        while (i4 != size && i5 <= size2) {
            int i6 = i4 + 1;
            int i7 = i6;
            while (true) {
                if (i7 > size) {
                    i7 = -1;
                    break;
                }
                if (vector.elementAt(i7).equals("**")) {
                    break;
                }
                i7++;
            }
            if (i7 == i6) {
                i4 = i6;
            } else {
                int i8 = (i7 - i4) - i3;
                int i9 = (size2 - i5) + i3;
                int i10 = i2;
                while (true) {
                    if (i10 > i9 - i8) {
                        i = -1;
                        break;
                    }
                    int i11 = i2;
                    while (true) {
                        if (i11 >= i8) {
                            i = i5 + i10;
                            break;
                        }
                        if (!match((String) vector.elementAt(i4 + i11 + 1), (String) vector2.elementAt(i5 + i10 + i11), z)) {
                            break;
                        }
                        i11++;
                    }
                    i10++;
                    i2 = 0;
                }
                if (i == -1) {
                    return false;
                }
                i5 = i + i8;
                i2 = 0;
                i4 = i7;
                i3 = 1;
            }
        }
        boolean z2 = i2;
        while (i4 <= size) {
            if (!vector.elementAt(i4).equals("**")) {
                return z2;
            }
            i4++;
        }
        return true;
    }

    private static boolean match(String str, String str2, boolean z) {
        boolean z2;
        int i;
        char[] charArray = str.toCharArray();
        char[] charArray2 = str2.toCharArray();
        int i2 = 1;
        int length = charArray.length - 1;
        int length2 = charArray2.length - 1;
        int i3 = 0;
        while (true) {
            if (i3 >= charArray.length) {
                z2 = false;
                break;
            }
            if (charArray[i3] == '*') {
                z2 = true;
                break;
            }
            i3++;
        }
        char c = '?';
        if (!z2) {
            if (length != length2) {
                return false;
            }
            for (int i4 = 0; i4 <= length; i4++) {
                char c2 = charArray[i4];
                if (c2 != '?') {
                    if (z && c2 != charArray2[i4]) {
                        return false;
                    }
                    if (!z && Character.toUpperCase(c2) != Character.toUpperCase(charArray2[i4])) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (length == 0) {
            return true;
        }
        int i5 = 0;
        int i6 = 0;
        while (true) {
            char c3 = charArray[i5];
            if (c3 == '*' || i6 > length2) {
                break;
            }
            if (c3 != '?') {
                if (z && c3 != charArray2[i6]) {
                    return false;
                }
                if (!z && Character.toUpperCase(c3) != Character.toUpperCase(charArray2[i6])) {
                    return false;
                }
            }
            i5++;
            i6++;
        }
        if (i6 > length2) {
            while (i5 <= length) {
                if (charArray[i5] != '*') {
                    return false;
                }
                i5++;
            }
            return true;
        }
        while (true) {
            char c4 = charArray[length];
            if (c4 == '*' || i6 > length2) {
                break;
            }
            if (c4 != '?') {
                if (z && c4 != charArray2[length2]) {
                    return false;
                }
                if (!z && Character.toUpperCase(c4) != Character.toUpperCase(charArray2[length2])) {
                    return false;
                }
            }
            length--;
            length2--;
        }
        if (i6 > length2) {
            while (i5 <= length) {
                if (charArray[i5] != '*') {
                    return false;
                }
                i5++;
            }
            return true;
        }
        while (i5 != length && i6 <= length2) {
            int i7 = i5 + 1;
            int i8 = i7;
            while (true) {
                if (i8 > length) {
                    i8 = -1;
                    break;
                }
                if (charArray[i8] == '*') {
                    break;
                }
                i8++;
            }
            if (i8 == i7) {
                i5 = i7;
            } else {
                int i9 = (i8 - i5) - i2;
                int i10 = (length2 - i6) + i2;
                int i11 = 0;
                while (true) {
                    if (i11 > i10 - i9) {
                        i = -1;
                        break;
                    }
                    int i12 = 0;
                    while (true) {
                        if (i12 >= i9) {
                            i = i6 + i11;
                            break;
                        }
                        char c5 = charArray[i5 + i12 + 1];
                        if (c5 != c && ((z && c5 != charArray2[i6 + i11 + i12]) || (!z && Character.toUpperCase(c5) != Character.toUpperCase(charArray2[i6 + i11 + i12])))) {
                            break;
                        }
                        i12++;
                        c = '?';
                    }
                    i11++;
                    c = '?';
                }
                if (i == -1) {
                    return false;
                }
                i6 = i + i9;
                i5 = i8;
                i2 = 1;
                c = '?';
            }
        }
        while (i5 <= length) {
            if (charArray[i5] != '*') {
                return false;
            }
            i5++;
        }
        return true;
    }

    private static Vector tokenizePath(String str) {
        Vector vector = new Vector();
        StringTokenizer stringTokenizer = new StringTokenizer(str, File.separator);
        while (stringTokenizer.hasMoreTokens()) {
            vector.addElement(stringTokenizer.nextToken());
        }
        return vector;
    }
}
