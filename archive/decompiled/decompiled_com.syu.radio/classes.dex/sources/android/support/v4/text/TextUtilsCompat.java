package android.support.v4.text;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.lsec.core.util.data.FinalChip;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class TextUtilsCompat {
    public static final Locale ROOT = new Locale(FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null);
    private static String ARAB_SCRIPT_SUBTAG = "Arab";
    private static String HEBR_SCRIPT_SUBTAG = "Hebr";

    @NonNull
    public static String htmlEncode(@NonNull String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '\"':
                    sb.append("&quot;");
                    break;
                case '&':
                    sb.append("&amp;");
                    break;
                case '\'':
                    sb.append("&#39;");
                    break;
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }
        return sb.toString();
    }

    public static int getLayoutDirectionFromLocale(@Nullable Locale locale) {
        if (locale != null && !locale.equals(ROOT)) {
            String scriptSubtag = ICUCompat.getScript(ICUCompat.addLikelySubtags(locale.toString()));
            if (scriptSubtag == null) {
                return getLayoutDirectionFromFirstChar(locale);
            }
            if (scriptSubtag.equalsIgnoreCase(ARAB_SCRIPT_SUBTAG) || scriptSubtag.equalsIgnoreCase(HEBR_SCRIPT_SUBTAG)) {
                return 1;
            }
        }
        return 0;
    }

    private static int getLayoutDirectionFromFirstChar(Locale locale) {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            case 1:
            case 2:
                return 1;
            default:
                return 0;
        }
    }
}
