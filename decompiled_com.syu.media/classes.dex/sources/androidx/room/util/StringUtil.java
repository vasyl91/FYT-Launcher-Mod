package androidx.room.util;

import android.util.Log;
import chip.FinalChip;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class StringUtil {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    public static StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    public static void appendPlaceholders(StringBuilder builder, int count) {
        for (int i = 0; i < count; i++) {
            builder.append("?");
            if (i < count - 1) {
                builder.append(",");
            }
        }
    }

    public static List<Integer> splitToIntList(String input) {
        if (input == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(input, ",");
        while (stringTokenizer.hasMoreElements()) {
            try {
                arrayList.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
            } catch (NumberFormatException e) {
                Log.e("ROOM", "Malformed integer list", e);
            }
        }
        return arrayList;
    }

    public static String joinIntoString(List<Integer> input) {
        if (input == null) {
            return null;
        }
        int size = input.size();
        if (size == 0) {
            return FinalChip.BSP_PLATFORM_Null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(Integer.toString(input.get(i).intValue()));
            if (i < size - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private StringUtil() {
    }
}
