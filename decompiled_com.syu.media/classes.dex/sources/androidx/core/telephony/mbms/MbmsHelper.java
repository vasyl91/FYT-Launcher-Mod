package androidx.core.telephony.mbms;

import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.telephony.mbms.ServiceInfo;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class MbmsHelper {
    private MbmsHelper() {
    }

    public static CharSequence getBestNameForService(Context context, ServiceInfo serviceInfo) {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        LocaleList locales = context.getResources().getConfiguration().getLocales();
        int size = serviceInfo.getNamedContentLocales().size();
        if (size == 0) {
            return null;
        }
        String[] strArr = new String[size];
        Iterator<Locale> it = serviceInfo.getNamedContentLocales().iterator();
        int i = 0;
        while (it.hasNext()) {
            strArr[i] = it.next().toLanguageTag();
            i++;
        }
        Locale firstMatch = locales.getFirstMatch(strArr);
        if (firstMatch == null) {
            return null;
        }
        return serviceInfo.getNameForLocale(firstMatch);
    }
}
