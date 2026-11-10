package qin.utils;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import qin.reflex.ReflexMethod;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class Utils {
    public static int[] array(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = 0;
        }
        return iArr;
    }

    public static int byteIndex(int i, int i2) {
        return (i >> (i2 * 8)) & 255;
    }

    public static String[] bytes2Hex(byte... bArr) {
        return ints2Hex(bytes2Ints(bArr));
    }

    public static int[] bytes2Ints(byte... bArr) {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = bArr[i] & 255;
        }
        return iArr;
    }

    public static String bytes2str(byte[] bArr, String str) {
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String bytes2utf8(byte[] bArr) {
        return bytes2str(bArr, "utf-8");
    }

    public static boolean checkIndex(byte[] bArr, int i) {
        return bArr != null && i >= 0 && bArr.length > i;
    }

    public static boolean equals(String str, String str2) {
        if (isEmptyStr(str) || isEmptyStr(str2)) {
            return false;
        }
        return str.equals(str2);
    }

    public static boolean getPropForBoolean(String str, boolean z) {
        Boolean bool;
        try {
            bool = (Boolean) new ReflexMethod("getBoolean").setupClass(Class.forName("android.os.SystemProperties")).params(str, Boolean.valueOf(z)).call();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            bool = null;
        }
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static int getPropForInt(String str, int i) {
        Integer num;
        try {
            num = (Integer) new ReflexMethod("getInt").setupClass(Class.forName("android.os.SystemProperties")).params(str, Integer.valueOf(i)).call();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            num = null;
        }
        return num == null ? i : num.intValue();
    }

    public static String getPropForString(String str, String str2) {
        String str3;
        try {
            str3 = (String) new ReflexMethod("get").setupClass(Class.forName("android.os.SystemProperties")).params(str, str2).call();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            str3 = null;
        }
        return str3 == null ? str2 : str3;
    }

    public static JSONArray intArrayToJson(int[] iArr) {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < iArr.length; i++) {
            try {
                jSONArray.put(i, iArr[i]);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONArray;
    }

    public static int[] ints(int i, int i2) {
        if (i <= 0) {
            throw new IllegalArgumentException("len of array is 0 or < 0!!");
        }
        int[] iArr = new int[i];
        for (int i3 = 0; i3 < i; i3++) {
            iArr[i3] = i2;
        }
        return iArr;
    }

    public static byte[] ints2Bytes(int... iArr) {
        int length = iArr.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) (iArr[i] & 255);
        }
        return bArr;
    }

    public static String[] ints2Hex(int... iArr) {
        int length = iArr == null ? 0 : iArr.length;
        if (length <= 0) {
            return null;
        }
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = Integer.toHexString(iArr[i]).toUpperCase();
        }
        return strArr;
    }

    public static String ints2utf8(int[] iArr) {
        return bytes2utf8(ints2Bytes(iArr));
    }

    public static boolean isEmptyStr(String str) {
        return str == null || str.isEmpty();
    }

    public static ArrayList<String> jsonToList(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(jSONArray.getString(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static String[] jsonToStrs(String str) {
        String[] strArr = null;
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = jSONArray.getString(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strArr;
    }

    public static JSONArray listToJson(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            try {
                jSONArray.put(i, list.get(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONArray;
    }

    public static int make16Int(int i, int i2) {
        return ((i & 255) << 8) | (i2 & 255);
    }

    public static int make24Int(int i, int i2, int i3) {
        return ((i & 255) << 16) | ((i2 & 255) << 8) | (i3 & 255);
    }

    public static int make32Int(int i, int i2, int i3, int i4) {
        return ((i & 255) << 24) | ((i2 & 255) << 16) | ((i3 & 255) << 8) | (i4 & 255);
    }

    public static void methodStrack(String str) {
        StackTraceElement[] stackTraceElementArr = Thread.getAllStackTraces().get(Thread.currentThread());
        Log.e("Qin", "========>>>> called method :" + str);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(String.valueOf(stackTraceElement.getFileName()) + ":" + stackTraceElement.getMethodName() + ":(" + stackTraceElement.getLineNumber() + ")");
            stringBuffer.append("\n");
            Log.e("Qin", "========>>>>" + stringBuffer.toString());
        }
    }

    public static void sleep(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int[] stringToInts(String str) {
        int[] iArr = null;
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            iArr = new int[length];
            for (int i = 0; i < length; i++) {
                iArr[i] = jSONArray.getInt(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iArr;
    }

    public static String[] strs(int i, String str) {
        if (i <= 0) {
            throw new IllegalArgumentException("len of array is 0 or < 0!!");
        }
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            strArr[i2] = str;
        }
        return strArr;
    }

    public static void writeSystemProperties(String str, String str2) {
        try {
            new ReflexMethod("set").setupClass(Class.forName("android.os.SystemProperties")).params(str, str2).call();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkIndex(float[] fArr, int i) {
        return fArr != null && i >= 0 && fArr.length > i;
    }

    public static boolean checkIndex(int[] iArr, int i) {
        return iArr != null && i >= 0 && iArr.length > i;
    }

    public static <T> boolean checkIndex(T[] tArr, int i) {
        return tArr != null && i >= 0 && tArr.length > i;
    }
}
