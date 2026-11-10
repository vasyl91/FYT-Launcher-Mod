package org.apache.xmlbeans.impl.repackage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class Repackager {
    private Matcher[] _fromMatchers;
    private String[] _toPackageNames;
    private List _fromPackages = new ArrayList();
    private List _toPackages = new ArrayList();

    public Repackager(String str) {
        boolean z;
        ArrayList arrayListSplitPath = splitPath(str, ';');
        do {
            z = false;
            for (int i = 1; i < arrayListSplitPath.size(); i++) {
                int i2 = i - 1;
                String str2 = (String) arrayListSplitPath.get(i2);
                String str3 = (String) arrayListSplitPath.get(i);
                if (str2.indexOf(58) < str3.indexOf(58)) {
                    arrayListSplitPath.set(i2, str3);
                    arrayListSplitPath.set(i, str2);
                    z = true;
                }
            }
        } while (z);
        for (int i3 = 0; i3 < arrayListSplitPath.size(); i3++) {
            String str4 = (String) arrayListSplitPath.get(i3);
            int iIndexOf = str4.indexOf(58);
            if (iIndexOf >= 0) {
                int i4 = iIndexOf + 1;
                if (str4.indexOf(58, i4) < 0) {
                    String strSubstring = str4.substring(0, iIndexOf);
                    String strSubstring2 = str4.substring(i4);
                    this._fromPackages.add(splitPath(strSubstring, NameUtil.PERIOD));
                    this._toPackages.add(splitPath(strSubstring2, NameUtil.PERIOD));
                }
            }
            throw new RuntimeException("Illegal repackage specification: " + str4);
        }
        this._fromMatchers = new Matcher[this._fromPackages.size() * 2];
        this._toPackageNames = new String[this._fromPackages.size() * 2];
        addPatterns(NameUtil.PERIOD, 0);
        addPatterns('/', this._fromPackages.size());
    }

    void addPatterns(char c, int i) {
        for (int i2 = 0; i2 < this._fromPackages.size(); i2++) {
            List list = (List) this._fromPackages.get(i2);
            List list2 = (List) this._toPackages.get(i2);
            String str = "";
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (i3 > 0) {
                    str = str + "\\" + c;
                }
                str = str + list.get(i3);
            }
            String str2 = "";
            for (int i4 = 0; i4 < list2.size(); i4++) {
                if (i4 > 0) {
                    str2 = str2 + c;
                }
                str2 = str2 + list2.get(i4);
            }
            int i5 = i + i2;
            this._fromMatchers[i5] = Pattern.compile(str).matcher("");
            this._toPackageNames[i5] = str2;
        }
    }

    public StringBuffer repackage(StringBuffer stringBuffer) {
        int i = 0;
        StringBuffer stringBuffer2 = null;
        while (true) {
            Matcher[] matcherArr = this._fromMatchers;
            if (i >= matcherArr.length) {
                return stringBuffer;
            }
            Matcher matcher = matcherArr[i];
            matcher.reset(stringBuffer);
            while (matcher.find()) {
                if (stringBuffer2 == null) {
                    stringBuffer2 = new StringBuffer();
                }
                matcher.appendReplacement(stringBuffer2, this._toPackageNames[i]);
            }
            if (stringBuffer2 != null) {
                matcher.appendTail(stringBuffer2);
                stringBuffer = stringBuffer2;
                stringBuffer2 = null;
            }
            i++;
        }
    }

    public List getFromPackages() {
        return this._fromPackages;
    }

    public List getToPackages() {
        return this._toPackages;
    }

    public static ArrayList splitPath(String str, char c) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            int iIndexOf = str.indexOf(c);
            if (iIndexOf < 0) {
                break;
            }
            arrayList.add(str.substring(0, iIndexOf));
            str = str.substring(iIndexOf + 1);
        }
        if (str.length() > 0) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public static String dirForPath(String str) {
        return new File(str).getParent();
    }
}
