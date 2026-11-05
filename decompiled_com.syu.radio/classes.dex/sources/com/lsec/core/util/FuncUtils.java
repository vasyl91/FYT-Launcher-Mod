package com.lsec.core.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.YuvImage;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.StatFs;
import android.os.SystemClock;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.lsec.core.util.data.FinalChip;
import com.syu.ipc.ModuleObject;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class FuncUtils {
    private static long lastClickTime;
    private static Calendar mCalendar;
    private static SimpleDateFormat mClockFormat;
    private static long mCurMillis;
    private static long mLastMillis;
    public static HashMap<String, Typeface> mTypeFaces;
    BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.lsec.core.util.FuncUtils.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.intent.action.TIMEZONE_CHANGED")) {
                String tz = intent.getStringExtra("time-zone");
                FuncUtils.mCalendar = Calendar.getInstance(TimeZone.getTimeZone(tz));
                if (FuncUtils.mClockFormat != null) {
                    FuncUtils.mClockFormat.setTimeZone(FuncUtils.mCalendar.getTimeZone());
                }
            }
        }
    };
    public static DisplayMetrics mDispayMetrics = new DisplayMetrics();
    private static Hashtable<String, String> LOCALE_TO_CHARSET_MAP = new Hashtable<>();

    static {
        LOCALE_TO_CHARSET_MAP.put("ar", "ISO-8859-6");
        LOCALE_TO_CHARSET_MAP.put("be", "ISO-8859-5");
        LOCALE_TO_CHARSET_MAP.put("bg", "ISO-8859-5");
        LOCALE_TO_CHARSET_MAP.put("ca", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("cs", "ISO-8859-2");
        LOCALE_TO_CHARSET_MAP.put("da", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("de", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("el", "ISO-8859-7");
        LOCALE_TO_CHARSET_MAP.put("es", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("et", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("fi", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("fr", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("hr", "ISO-8859-2");
        LOCALE_TO_CHARSET_MAP.put("hu", "ISO-8859-2");
        LOCALE_TO_CHARSET_MAP.put("is", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("it", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("iw", "ISO-8859-8");
        LOCALE_TO_CHARSET_MAP.put("ja", "Shift_JIS");
        LOCALE_TO_CHARSET_MAP.put("ko", "EUC-KR");
        LOCALE_TO_CHARSET_MAP.put("lt", "ISO-8859-2");
        LOCALE_TO_CHARSET_MAP.put("lv", "ISO-8859-2");
        LOCALE_TO_CHARSET_MAP.put("mk", "ISO-8859-5");
        LOCALE_TO_CHARSET_MAP.put("nl", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("no", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("pl", "ISO-8859-2");
        LOCALE_TO_CHARSET_MAP.put("pt", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("ro", "ISO-8859-2");
        LOCALE_TO_CHARSET_MAP.put("ru", "ISO-8859-5");
        LOCALE_TO_CHARSET_MAP.put("sh", "ISO-8859-5");
        LOCALE_TO_CHARSET_MAP.put("sk", "ISO-8859-2");
        LOCALE_TO_CHARSET_MAP.put("sl", "ISO-8859-2");
        LOCALE_TO_CHARSET_MAP.put("sq", "ISO-8859-2");
        LOCALE_TO_CHARSET_MAP.put("sr", "ISO-8859-5");
        LOCALE_TO_CHARSET_MAP.put("sv", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("tr", "ISO-8859-9");
        LOCALE_TO_CHARSET_MAP.put("uk", "ISO-8859-5");
        mTypeFaces = new HashMap<>();
    }

    public static String getCharset(Locale locale) {
        String charset = LOCALE_TO_CHARSET_MAP.get(locale.toString());
        if (charset != null) {
            return charset;
        }
        String charset2 = LOCALE_TO_CHARSET_MAP.get(locale.getLanguage());
        if (charset2 == null) {
            charset2 = "GB18030";
        }
        return charset2;
    }

    public static boolean delayIsDone(int delay) {
        mCurMillis = System.currentTimeMillis();
        if (Math.abs(mCurMillis - mLastMillis) <= delay) {
            return false;
        }
        mLastMillis = mCurMillis;
        return true;
    }

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        if (Math.abs(time - lastClickTime) < 400) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    public static boolean isFastDoubleClick(int mills) {
        long time = System.currentTimeMillis();
        if (Math.abs(time - lastClickTime) < mills) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    public static void sleep(int mills) {
        try {
            Thread.sleep(mills);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String byteArray2String(byte[] data) {
        String strByte = FinalChip.BSP_PLATFORM_Null;
        for (int i = 0; i < data.length; i++) {
            int heightData = (data[i] & 240) / 16;
            int lowData = data[i] & 15;
            strByte = String.valueOf(strByte) + intTo0xChar(heightData) + intTo0xChar(lowData);
        }
        return strByte;
    }

    public static char intTo0xChar(int data) {
        char ret;
        if (data < 0 || data > 15) {
            return '?';
        }
        if (data < 10) {
            ret = (char) (data + 48);
        } else {
            ret = (char) ((data - 10) + 97);
        }
        return ret;
    }

    public static int byte2int(byte data) {
        if ((data & 128) == 0) {
            return data;
        }
        int ret = data & 255;
        return ret;
    }

    public static byte[] String2ByteArray(String strCommand) {
        byte[] bCommand = new byte[strCommand.length() / 2];
        for (int i = 0; i < strCommand.length(); i += 2) {
            byte heightData = (byte) (char20xByte(strCommand.charAt(i)) << 4);
            byte lowData = char20xByte(strCommand.charAt(i + 1));
            bCommand[i / 2] = (byte) (heightData | lowData);
        }
        return bCommand;
    }

    private static byte char20xByte(char cSrc) {
        if ('0' <= cSrc && cSrc <= '9') {
            byte bDest = (byte) (cSrc - '0');
            return bDest;
        }
        if ('a' <= cSrc && cSrc <= 'f') {
            byte bDest2 = (byte) ((cSrc - 'a') + 10);
            return bDest2;
        }
        if ('A' > cSrc || cSrc > 'F') {
            return (byte) 0;
        }
        byte bDest3 = (byte) ((cSrc - 'A') + 10);
        return bDest3;
    }

    public static byte[] getBytes(char[] chars) {
        Charset cs = Charset.forName(HTTP.UTF_8);
        CharBuffer cb = CharBuffer.allocate(chars.length);
        cb.put(chars);
        cb.flip();
        ByteBuffer bb = cs.encode(cb);
        return bb.array();
    }

    public static char[] getChars(byte[] bytes) {
        Charset cs = Charset.forName(HTTP.UTF_8);
        ByteBuffer bb = ByteBuffer.allocate(bytes.length);
        bb.put(bytes);
        bb.flip();
        CharBuffer cb = cs.decode(bb);
        return cb.array();
    }

    public static String getFileExtension(File f) {
        String filename;
        int i;
        if (f == null || (i = (filename = f.getName()).lastIndexOf(46)) <= 0 || i >= filename.length() - 1) {
            return null;
        }
        return filename.substring(i + 1).toLowerCase(Locale.US);
    }

    public static String getUrlExtension(String url) {
        int i;
        return (TextUtils.isEmpty(url) || (i = url.lastIndexOf(46)) <= 0 || i >= url.length() + (-1)) ? FinalChip.BSP_PLATFORM_Null : url.substring(i + 1).toLowerCase(Locale.US);
    }

    public static Bitmap getAssetsBitmap(AssetManager am, String PhotoPath) {
        Bitmap photo = null;
        InputStream is = null;
        try {
            is = am.open(PhotoPath);
            photo = BitmapFactory.decodeStream(is);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return photo;
    }

    public static int getIdStyle(Context context, String name) {
        if (context != null) {
            return context.getResources().getIdentifier(name, "style", context.getPackageName());
        }
        return 0;
    }

    public static Typeface getTypefaceFromFile(String fontPath) {
        if (mTypeFaces.containsKey(fontPath)) {
            return mTypeFaces.get(fontPath);
        }
        Typeface typeface = null;
        File fontFile = new File(fontPath);
        if (fontFile.exists()) {
            typeface = Typeface.createFromFile(fontFile);
        }
        mTypeFaces.put(fontPath, typeface);
        return typeface;
    }

    public static String getDateStr() {
        return DateFormat.getDateInstance(1).format(new Date());
    }

    public static CharSequence getTimeUtil(boolean isLocal, Context context) {
        String temp = FinalChip.BSP_PLATFORM_Null;
        try {
            if (!android.text.format.DateFormat.is24HourFormat(context)) {
                if (isLocal) {
                    temp = DateUtils.getAMPMString(Calendar.getInstance().get(9));
                } else {
                    temp = Calendar.getInstance().get(9) == 0 ? "AM" : "PM";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static String getCurrentTime(Context context) {
        String formatTime = android.text.format.DateFormat.is24HourFormat(context) ? "H:mm" : "h:mm";
        return new SimpleDateFormat(formatTime).format(Calendar.getInstance().getTime());
    }

    public static String FormatTime(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
        return format.format(Long.valueOf(time));
    }

    public static String formatHistoryTimeString(Context context, long when) {
        int format_flags;
        Time then = new Time();
        then.set(when);
        Time now = new Time();
        now.setToNow();
        int format_flags2 = 527104;
        if (then.year != now.year) {
            format_flags = 527104 | 20;
        } else {
            if (then.yearDay != now.yearDay) {
                format_flags2 = 527104 | 16;
            }
            format_flags = format_flags2 | 129;
        }
        return DateUtils.formatDateTime(context, when, format_flags);
    }

    public static String sFDuration(int data) {
        if (data <= 0) {
            return "00:00";
        }
        StringBuffer sDest = new StringBuffer();
        int second = data % 60;
        int minute = (data / 60) % 60;
        int hour = ((data / 60) / 60) % 60;
        if (hour > 0) {
            sDest.append(String.valueOf(hour) + ":");
        }
        if (minute < 10) {
            sDest.append("0");
        }
        sDest.append(String.valueOf(minute) + ":");
        if (second < 10) {
            sDest.append("0");
        }
        sDest.append(second);
        return sDest.toString();
    }

    public static String msFDuration(long s) {
        long s2 = s / 1000;
        if (s2 < 0) {
            return "00:00";
        }
        if (s2 < 60) {
            String str = String.format(Locale.US, "00:%02d", Long.valueOf(s2));
            return str;
        }
        if (s2 < 3600) {
            String str2 = String.format(Locale.US, "%02d:%02d", Long.valueOf(s2 / 60), Long.valueOf(s2 % 60));
            return str2;
        }
        String str3 = String.format(Locale.US, "%d %02d:%02d", Long.valueOf(s2 / 3600), Long.valueOf((s2 % 3600) / 60), Long.valueOf(s2 % 60));
        return str3;
    }

    public static String formatDuration(long duration) {
        long time = duration / 1000;
        if (time <= 0) {
            return "00:00:00";
        }
        long min = (time / 60) % 60;
        long hour = (time / 60) / 60;
        long second = time % 60;
        return String.format(Locale.US, "%02d:%02d:%02d", Long.valueOf(hour), Long.valueOf(min), Long.valueOf(second));
    }

    public static String formatDuration_Sec(long duration) {
        if (duration <= 0) {
            return "00:00:00";
        }
        long min = (duration / 60) % 60;
        long hour = (duration / 60) / 60;
        long second = duration % 60;
        return String.format(Locale.US, "%02d:%02d:%02d", Long.valueOf(hour), Long.valueOf(min), Long.valueOf(second));
    }

    public static boolean isEquals(String src, String des) {
        if (src == null || des == null) {
            return false;
        }
        boolean bRet = src.equals(des);
        return bRet;
    }

    public static String readStrFromStream(InputStream is) throws Throwable {
        String strRet = null;
        if (is != null) {
            InputStreamReader isr = null;
            BufferedReader reader = null;
            try {
                try {
                    InputStreamReader isr2 = new InputStreamReader(is);
                    try {
                        BufferedReader reader2 = new BufferedReader(isr2);
                        try {
                            StringBuffer buffer = new StringBuffer();
                            while (true) {
                                String str = reader2.readLine();
                                if (str == null) {
                                    break;
                                }
                                buffer.append(str);
                            }
                            strRet = buffer.toString();
                            if (reader2 != null) {
                                try {
                                    reader2.close();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            if (isr2 != null) {
                                try {
                                    isr2.close();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            if (is != null) {
                                try {
                                    is.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                            reader = reader2;
                            isr = isr2;
                            e.printStackTrace();
                            if (reader != null) {
                                try {
                                    reader.close();
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (isr != null) {
                                try {
                                    isr.close();
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                }
                            }
                            if (is != null) {
                                try {
                                    is.close();
                                } catch (Exception e7) {
                                    e7.printStackTrace();
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            reader = reader2;
                            isr = isr2;
                            if (reader != null) {
                                try {
                                    reader.close();
                                } catch (Exception e8) {
                                    e8.printStackTrace();
                                }
                            }
                            if (isr != null) {
                                try {
                                    isr.close();
                                } catch (Exception e9) {
                                    e9.printStackTrace();
                                }
                            }
                            if (is != null) {
                                try {
                                    is.close();
                                    throw th;
                                } catch (Exception e10) {
                                    e10.printStackTrace();
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e11) {
                        e = e11;
                        isr = isr2;
                    } catch (Throwable th2) {
                        th = th2;
                        isr = isr2;
                    }
                } catch (Exception e12) {
                    e = e12;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return strRet;
    }

    public static boolean check(int[] ints, int index) {
        return ints != null && ints.length > index;
    }

    public static boolean check(Object[] objs, int index) {
        return objs != null && objs.length > index;
    }

    public static Bitmap getBitmapFromDrawable(Drawable drawable, int w, int h) {
        if (w <= 0 || h <= 0) {
            return null;
        }
        Bitmap bitmap = Bitmap.createBitmap(w, h, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        drawable.draw(canvas);
        return bitmap;
    }

    public static String getFormatSize(double size) {
        double kiloByte = size / 1024.0d;
        if (kiloByte < 1.0d) {
            return String.valueOf(size) + "Byte(s)";
        }
        double megaByte = kiloByte / 1024.0d;
        if (megaByte < 1.0d) {
            BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
            return String.valueOf(result1.setScale(2, 4).toPlainString()) + "KB";
        }
        double gigaByte = megaByte / 1024.0d;
        if (gigaByte < 1.0d) {
            BigDecimal result2 = new BigDecimal(Double.toString(megaByte));
            return String.valueOf(result2.setScale(2, 4).toPlainString()) + "MB";
        }
        double teraBytes = gigaByte / 1024.0d;
        if (teraBytes < 1.0d) {
            BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
            return String.valueOf(result3.setScale(2, 4).toPlainString()) + "GB";
        }
        BigDecimal result4 = new BigDecimal(teraBytes);
        return String.valueOf(result4.setScale(2, 4).toPlainString()) + "TB";
    }

    public static String getExternalStorageDirectory() throws Throwable {
        String[] columns;
        String dir = new String();
        Runtime runtime = Runtime.getRuntime();
        Process proc = null;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            try {
                proc = runtime.exec("mount");
                is = proc.getInputStream();
                InputStreamReader isr2 = new InputStreamReader(is);
                try {
                    BufferedReader br2 = new BufferedReader(isr2);
                    while (true) {
                        try {
                            String line = br2.readLine();
                            if (line == null) {
                                break;
                            }
                            if (!line.contains(ClientCookie.SECURE_ATTR) && !line.contains("asec")) {
                                if (line.contains("fat")) {
                                    String[] columns2 = line.split(" ");
                                    if (columns2 != null && columns2.length > 1) {
                                        dir = dir.concat(String.valueOf(columns2[1]) + "\n");
                                    }
                                } else if (line.contains("fuse") && (columns = line.split(" ")) != null && columns.length > 1) {
                                    dir = dir.concat(String.valueOf(columns[1]) + "\n");
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            br = br2;
                            isr = isr2;
                            e.printStackTrace();
                            if (br != null) {
                                try {
                                    br.close();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            if (isr != null) {
                                try {
                                    isr.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            if (is != null) {
                                try {
                                    is.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (proc != null) {
                                try {
                                    proc.destroy();
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            br = br2;
                            isr = isr2;
                            if (br != null) {
                                try {
                                    br.close();
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                }
                            }
                            if (isr != null) {
                                try {
                                    isr.close();
                                } catch (Exception e7) {
                                    e7.printStackTrace();
                                }
                            }
                            if (is != null) {
                                try {
                                    is.close();
                                } catch (Exception e8) {
                                    e8.printStackTrace();
                                }
                            }
                            if (proc != null) {
                                try {
                                    proc.destroy();
                                    throw th;
                                } catch (Exception e9) {
                                    e9.printStackTrace();
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    }
                    if (br2 != null) {
                        try {
                            br2.close();
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                    }
                    if (isr2 != null) {
                        try {
                            isr2.close();
                        } catch (Exception e11) {
                            e11.printStackTrace();
                        }
                    }
                    if (is != null) {
                        try {
                            is.close();
                        } catch (Exception e12) {
                            e12.printStackTrace();
                        }
                    }
                    if (proc != null) {
                        try {
                            proc.destroy();
                        } catch (Exception e13) {
                            e13.printStackTrace();
                        }
                    }
                } catch (Exception e14) {
                    e = e14;
                    isr = isr2;
                } catch (Throwable th2) {
                    th = th2;
                    isr = isr2;
                }
            } catch (Exception e15) {
                e = e15;
            }
            return dir;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static boolean isFileExist(String strFile) {
        if (TextUtils.isEmpty(strFile)) {
            return false;
        }
        File file = new File(strFile);
        return file.exists();
    }

    public static Intent getVideoFileIntent(String strPath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        Uri uri = Uri.fromFile(new File(strPath));
        intent.setDataAndType(uri, "video/*");
        return intent;
    }

    public static Intent getAudioFileIntent(String strPath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        Uri uri = Uri.fromFile(new File(strPath));
        intent.setDataAndType(uri, "audio/*");
        return intent;
    }

    public static Intent getPhotoFileIntent(String strPath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        Uri uri = Uri.fromFile(new File(strPath));
        intent.setDataAndType(uri, "image/*");
        return intent;
    }

    public static int get(ModuleObject obj, int valueIfNotOk) {
        if (obj != null && obj.ints != null && obj.ints.length >= 1) {
            return obj.ints[0];
        }
        return valueIfNotOk;
    }

    public static String get(ModuleObject obj, String valueIfNotOk) {
        if (obj != null && obj.strs != null && obj.strs.length >= 1) {
            return obj.strs[0];
        }
        return valueIfNotOk;
    }

    public static String getFileNameNoSuffix(String strNameWithSuffix) {
        if (TextUtils.isEmpty(strNameWithSuffix)) {
            return " ";
        }
        int posDot = strNameWithSuffix.lastIndexOf(".");
        if (posDot < 0) {
            return strNameWithSuffix;
        }
        String strName = strNameWithSuffix.substring(0, posDot);
        return strName;
    }

    public static boolean checkFilter(String name, String[] strFilters) {
        if (TextUtils.isEmpty(name) || strFilters == null) {
            return false;
        }
        for (String str : strFilters) {
            if (name.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static int getNumSlash(String path) {
        String[] strArray;
        if (TextUtils.isEmpty(path) || (strArray = path.split("/")) == null) {
            return 0;
        }
        int iNumSlash = strArray.length;
        return iNumSlash;
    }

    public static int getVal(int value, int min, int max) {
        if (value < min) {
            return min;
        }
        return value > max ? max : value;
    }

    public static boolean strEqual(String a, String b) {
        if (a == null) {
            if (b != null) {
                return false;
            }
            return true;
        }
        return a.equals(b);
    }

    public static int makeInt(byte high, byte low) {
        return ((high & 255) << 8) | (low & 255);
    }

    public static int makeInt(byte high, byte mid, byte low) {
        return ((high & 255) << 16) | ((mid & 255) << 8) | (low & 255);
    }

    public static int makeInt(byte B3, byte B2, byte B1, byte B0) {
        return ((B3 & 255) << 24) | ((B2 & 255) << 16) | ((B1 & 255) << 8) | (B0 & 255);
    }

    public static int[] convert(byte[] value) {
        if (value == null) {
            return null;
        }
        int size = value.length;
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = value[i];
        }
        return data;
    }

    public static byte[] convert(int[] value) {
        if (value == null) {
            return null;
        }
        int size = value.length;
        byte[] data = new byte[size];
        for (int i = 0; i < size; i++) {
            data[i] = (byte) value[i];
        }
        return data;
    }

    public static int fileSize(String path) {
        int result = -1;
        try {
            InputStream in = new FileInputStream(path);
            result = in.available();
            in.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
    }

    public static byte[] readFile(String path) {
        byte[] buffer = null;
        try {
            InputStream in = new FileInputStream(path);
            buffer = new byte[in.available()];
            in.read(buffer);
            in.close();
            return buffer;
        } catch (Exception e) {
            e.printStackTrace();
            return buffer;
        }
    }

    public static boolean equals(int[] array1, int[] array2) {
        if (array1 == array2) {
            return true;
        }
        if (array1 == null || array2 == null || array1.length != array2.length) {
            return false;
        }
        int len = array1.length;
        for (int i = 0; i < len; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int getUnsignedByte(byte b) {
        return b & 255;
    }

    public static Process createSuProcess() throws IOException {
        File rootUser = new File("/system/xbin/ru");
        return rootUser.exists() ? Runtime.getRuntime().exec(rootUser.getAbsolutePath()) : Runtime.getRuntime().exec("su");
    }

    public static Process createSuProcess(String cmd) throws Throwable {
        DataOutputStream os = null;
        Process process = createSuProcess();
        try {
            DataOutputStream os2 = new DataOutputStream(process.getOutputStream());
            try {
                os2.writeBytes(String.valueOf(cmd) + "\n");
                os2.writeBytes("exit $?\n");
                if (os2 != null) {
                    try {
                        os2.close();
                    } catch (IOException e) {
                    }
                }
                return process;
            } catch (Throwable th) {
                th = th;
                os = os2;
                if (os != null) {
                    try {
                        os.close();
                    } catch (IOException e2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void setDateTime(int hour, int minute) {
        try {
            requestPermission();
            Calendar c = Calendar.getInstance();
            c.set(11, hour);
            c.set(12, minute);
            long when = c.getTimeInMillis();
            if (when / 1000 < 2147483647L) {
                SystemClock.setCurrentTimeMillis(when);
            }
            long now = Calendar.getInstance().getTimeInMillis();
            if (now - when > 1000) {
                throw new IOException("failed to set Date.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void requestPermission() throws InterruptedException, IOException {
        createSuProcess("chmod 666 /dev/alarm").waitFor();
    }

    public static byte bcd2_hex(byte val) {
        byte i = (byte) (val & 15);
        return (byte) (i + ((byte) (((byte) (((byte) (val >> 4)) & 15)) * 10)));
    }

    public static int bytes2mb(long bytes) {
        BigDecimal filesize = new BigDecimal(bytes);
        BigDecimal megabyte = new BigDecimal(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START);
        try {
            return filesize.divide(megabyte, 2, 0).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getSDcardSpace() {
        StatFs stat = new StatFs(Environment.getDataDirectory().getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        long left = blockSize * availableBlocks;
        return bytes2mb(left);
    }

    public static int getNavigationBarHeight(Context context) {
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("navigation_bar_height").get(object).toString());
            int statusHeight = context.getResources().getDimensionPixelSize(height);
            return statusHeight;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int getStatusHeight(Context context) {
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height").get(object).toString());
            int statusHeight = context.getResources().getDimensionPixelSize(height);
            return statusHeight;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int getStatusWidth(Context context) {
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int width = Integer.parseInt(clazz.getField("status_bar_width").get(object).toString());
            int statusWidth = context.getResources().getDimensionPixelSize(width);
            return statusWidth;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void forgetWIFIpwd(Context ctx) {
        WifiManager wifiManager = (WifiManager) ctx.getSystemService("wifi");
        wifiManager.setWifiEnabled(false);
        List<WifiConfiguration> conlist = wifiManager.getConfiguredNetworks();
        if (conlist != null && conlist.size() > 0) {
            wifiManager.removeNetwork(conlist.get(0).networkId);
        }
    }

    public static Bitmap createBmp(Bitmap bmp, int width, int height) {
        if (bmp != null && bmp.getWidth() != 0 && bmp.getHeight() != 0) {
            float scaleWidth = width / bmp.getWidth();
            float scaleHeight = height / bmp.getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale(scaleWidth, scaleHeight);
            return Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), matrix, true);
        }
        return bmp;
    }

    public static boolean isAppInstalled(Context context, String packageName) {
        if (TextUtils.isEmpty(packageName)) {
            return false;
        }
        PackageInfo packageInfo = null;
        PackageManager packageManager = context.getPackageManager();
        try {
            packageInfo = packageManager.getPackageInfo(packageName, 0);
        } catch (Exception e) {
        }
        return packageInfo != null;
    }

    public static int HexToBcd(int hex) {
        return (((hex % 100) / 10) << 4) | (hex % 10);
    }

    public static int myParseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return 0;
        }
    }

    public static long myParseLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            return 0L;
        }
    }

    public static int myParseColor(String str) {
        try {
            return Color.parseColor(str);
        } catch (Exception e) {
            return 0;
        }
    }

    public static long myParseTime(String str) {
        try {
            return Date.parse(str);
        } catch (Exception e) {
            return 0L;
        }
    }

    public static int dp2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((dpValue * scale) + 0.5f);
    }

    public static int px2dp(Context context, float pxValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((pxValue / scale) + 0.5f);
    }

    public static void getDisplayMetrics(Context context) {
        if (context != null) {
            WindowManager wm = (WindowManager) context.getSystemService("window");
            Display display = wm.getDefaultDisplay();
            display.getMetrics(mDispayMetrics);
            Point realSize = new Point();
            try {
                Display.class.getMethod("getRealSize", Point.class).invoke(display, realSize);
                mDispayMetrics.widthPixels = realSize.x;
                mDispayMetrics.heightPixels = realSize.y;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void openApp(String packageName, Context context) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        if (intent != null) {
            context.startActivity(intent);
        }
    }

    public static void saveYUV2File(String strPath, byte[] yuv, int mWidth, int mHeight) {
        try {
            YuvImage image = new YuvImage(yuv, 17, mWidth, mHeight, null);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            image.compressToJpeg(new Rect(0, 0, mWidth, mHeight), 100, stream);
            FileOutputStream outStream = new FileOutputStream(strPath);
            try {
                outStream.write(stream.toByteArray());
                outStream.flush();
                outStream.close();
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static void saveBitmap(String strPath, Bitmap b) {
        try {
            File f = new File(strPath);
            if (f.exists()) {
                f.delete();
            }
            FileOutputStream fos = new FileOutputStream(f);
            if (fos != null) {
                try {
                    b.compress(Bitmap.CompressFormat.PNG, 100, fos);
                    fos.flush();
                    fos.close();
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static boolean isLangZh() {
        Locale localeDefault = Locale.getDefault();
        if (Build.VERSION.SDK_INT >= 24) {
            localeDefault = LocaleList.getDefault().get(0);
        }
        if (localeDefault == null) {
            return false;
        }
        String strLang = localeDefault.getLanguage();
        return "zh".equals(strLang);
    }

    public static boolean isLongLang() {
        Locale localeDefault = Locale.getDefault();
        if (Build.VERSION.SDK_INT >= 24) {
            localeDefault = LocaleList.getDefault().get(0);
        }
        return isLongLang(localeDefault);
    }

    public static boolean isLongLang(Locale localeDefault) {
        if (localeDefault != null) {
            String strLang = localeDefault.getLanguage();
            if ("vi".equals(strLang) || "ko".equals(strLang) || "ru".equals(strLang)) {
                return true;
            }
        }
        return false;
    }

    public static Drawable getDrawableFromPath(String path) throws Throwable {
        InputStream is = null;
        try {
            try {
                File file = new File(path);
                InputStream is2 = new FileInputStream(file);
                try {
                    Bitmap bitmap = BitmapFactory.decodeStream(is2);
                    if (bitmap != null) {
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                        if (is2 != null) {
                            try {
                                is2.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        return bitmapDrawable;
                    }
                    if (is2 != null) {
                        try {
                            is2.close();
                            is = is2;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            is = is2;
                        }
                    } else {
                        is = is2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    is = is2;
                    e.printStackTrace();
                    if (is != null) {
                        try {
                            is.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                } catch (OutOfMemoryError e5) {
                    e = e5;
                    is = is2;
                    e.printStackTrace();
                    if (is != null) {
                        try {
                            is.close();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    is = is2;
                    if (is != null) {
                        try {
                            is.close();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e8) {
            e = e8;
        } catch (OutOfMemoryError e9) {
            e = e9;
        }
        return null;
    }
}
