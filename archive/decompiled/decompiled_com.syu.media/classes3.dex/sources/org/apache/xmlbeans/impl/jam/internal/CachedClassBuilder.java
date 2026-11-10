package org.apache.xmlbeans.impl.jam.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.apache.xmlbeans.impl.jam.mutable.MClass;
import org.apache.xmlbeans.impl.jam.provider.JamClassBuilder;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CachedClassBuilder extends JamClassBuilder {
    private Map mQcname2jclass = null;
    private List mClassNames = new ArrayList();

    @Override // org.apache.xmlbeans.impl.jam.provider.JamClassBuilder
    public MClass build(String str, String str2) {
        if (this.mQcname2jclass == null) {
            return null;
        }
        if (str.trim().length() > 0) {
            str2 = str + NameUtil.PERIOD + str2;
        }
        return (MClass) this.mQcname2jclass.get(str2);
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamClassBuilder
    public MClass createClassToBuild(String str, String str2, String[] strArr) {
        String str3 = str.trim().length() > 0 ? str + NameUtil.PERIOD + str2 : str2;
        Map map = this.mQcname2jclass;
        if (map != null) {
            MClass mClass = (MClass) map.get(str3);
            if (mClass != null) {
                return mClass;
            }
        } else {
            this.mQcname2jclass = new HashMap();
        }
        MClass mClassCreateClassToBuild = super.createClassToBuild(str, str2, strArr);
        this.mQcname2jclass.put(str3, mClassCreateClassToBuild);
        this.mClassNames.add(str3);
        return mClassCreateClassToBuild;
    }

    public String[] getClassNames() {
        String[] strArr = new String[this.mClassNames.size()];
        this.mClassNames.toArray(strArr);
        return strArr;
    }
}
