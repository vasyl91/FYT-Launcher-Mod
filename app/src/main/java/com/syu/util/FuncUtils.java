package com.syu.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.format.Time;

import com.syu.ipc.ModuleObject;
import com.syu.ipc.data.FinalCanbus;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;
import java.util.TimeZone;

public class FuncUtils {
    private static Exception e;
    private static Throwable th;
    private static final Hashtable<String, String> LOCALE_TO_CHARSET_MAP = new Hashtable<>();
    private static long lastClickTime;
    private static Calendar mCalendar;
    private static SimpleDateFormat mClockFormat;
    private static long mCurMillis;
    private static final boolean mIsDelay;
    private static long mLastMillis;
    public static HashMap<String, Typeface> mTypeFaces;
    BroadcastReceiver mReceiver = new BroadcastReceiver() { 
        @Override
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
        mIsDelay = true;
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
        if (!mIsDelay) {
            return true;
        }
        mCurMillis = System.currentTimeMillis();
        if (mCurMillis - mLastMillis > delay) {
            mLastMillis = mCurMillis;
            return true;
        }
        return false;
    }

    public static void sleep(int mills) {
        try {
            Thread.sleep(mills);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 400) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    public static boolean isFastDoubleClick(int mills) {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < mills) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    public static String byteArray2String(byte[] data) {
        String strByte = "";
        for (int i = 0; i < data.length; i++) {
            int heightData = (data[i] & 240) / 16;
            int lowData = data[i] & 15;
            strByte = strByte + intTo0xChar(heightData) + intTo0xChar(lowData);
        }
        return strByte;
    }

    public static char intTo0xChar(int int0x) {
        char char0x;
        if (int0x < 0 || int0x > 15) {
            return '?';
        }
        if (int0x < 10) {
            char0x = (char) (int0x + 48);
        } else {
            char0x = (char) ((int0x - 10) + 97);
        }
        return char0x;
    }

    public static int byte2int(byte data) {
        if ((data & 128) == 0) {
            return data;
        }
        int iDest = data & 255;
        return iDest;
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
        Charset cs = StandardCharsets.UTF_8;
        CharBuffer cb = CharBuffer.allocate(chars.length);
        cb.put(chars);
        cb.flip();
        ByteBuffer bb = cs.encode(cb);
        return bb.array();
    }

    public static char[] getChars(byte[] bytes) {
        Charset cs = StandardCharsets.UTF_8;
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
        return filename.substring(i + 1).toLowerCase();
    }

    public static String getUrlExtension(String url) {
        int i;
        return (TextUtils.isEmpty(url) || (i = url.lastIndexOf(46)) <= 0 || i >= url.length() + (-1)) ? "" : url.substring(i + 1).toLowerCase();
    }

    public static Bitmap getAssetsBitmap(AssetManager am, String PhotoPath) {
        Bitmap photo = null;
        InputStream is = null;
        try {
            try {
                is = am.open(PhotoPath);
                photo = BitmapFactory.decodeStream(is);
                if (is != null) {
                    try {
                        is.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (is != null) {
                    try {
                        is.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
            return photo;
        } catch (Throwable th) {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean isAssetsFileExists(Context ctx, String path, String fileName) {
        try {
            String[] fonts = ctx.getAssets().list(path);
            for (String str : fonts) {
                if (str.equalsIgnoreCase(fileName)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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
        String temp = "";
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
            format_flags = format_flags2 | FinalCanbus.CAR_WC2_XueTieLongC5;
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
            sDest.append(hour + ":");
        }
        if (minute < 10) {
            sDest.append("0");
        }
        sDest.append(minute + ":");
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
            if (s2 < 10) {
                return "00:0" + s2;
            }
            return "00:" + s2;
        }
        if (s2 < 3600) {
            String str = s2 % 60 < 10 ? ":0" + (s2 % 60) : ":" + (s2 % 60);
            return s2 / 60 < 10 ? "0" + (s2 / 60) + str : s2 / 60 + str;
        }
        String str2 = s2 % 60 < 10 ? ":0" + (s2 % 60) : ":" + (s2 % 60);
        return s2 / 3600 + " " + ((s2 % 3600) / 60 < 10 ? "0" + ((s2 % 3600) / 60) + str2 : (s2 % 3600) / 60 + str2);
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
        InputStreamReader isr = null;
        BufferedReader reader = null;
        String strRet = null;
        if (is != null) {
            InputStreamReader isr2 = null;
            BufferedReader reader2 = null;
            try {
                try {
                    isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                    try {
                        reader = new BufferedReader(isr);
                    } catch (Exception e) {
                        e = e;
                        isr2 = isr;
                    } catch (Throwable th) {
                        th = th;
                        isr2 = isr;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                StringBuffer buffer = new StringBuffer();
                while (true) {
                    String str = reader.readLine();
                    if (str == null) {
                        break;
                    }
                    buffer.append(str);
                }
                strRet = buffer.toString();
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                if (isr != null) {
                    try {
                        isr.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                if (is != null) {
                    try {
                        is.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
            } catch (Exception e6) {
                e = e6;
                reader2 = reader;
                isr2 = isr;
                e.printStackTrace();
                if (reader2 != null) {
                    try {
                        reader2.close();
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (isr2 != null) {
                    try {
                        isr2.close();
                    } catch (Exception e8) {
                        e8.printStackTrace();
                    }
                }
                if (is != null) {
                    try {
                        is.close();
                    } catch (Exception e9) {
                        e9.printStackTrace();
                    }
                }
                return strRet;
            } catch (Throwable th3) {
                th = th3;
                reader2 = reader;
                isr2 = isr;
                if (reader2 != null) {
                    try {
                        reader2.close();
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
                        throw th;
                    } catch (Throwable e12) {
                        e12.printStackTrace();
                        throw th;
                    }
                }
                throw th;
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
        Bitmap bitmap = Bitmap.createBitmap(w, h, drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        drawable.draw(canvas);
        return bitmap;
    }

    public static String getFormatSize(double size) {
        double kiloByte = size / 1024.0d;
        if (kiloByte < 1.0d) {
            return size + "Byte(s)";
        }
        double megaByte = kiloByte / 1024.0d;
        if (megaByte < 1.0d) {
            BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
            return result1.setScale(2, RoundingMode.HALF_UP).toPlainString() + "KB";
        }
        double gigaByte = megaByte / 1024.0d;
        if (gigaByte < 1.0d) {
            BigDecimal result2 = new BigDecimal(Double.toString(megaByte));
            return result2.setScale(2, RoundingMode.HALF_UP).toPlainString() + "MB";
        }
        double teraBytes = gigaByte / 1024.0d;
        if (teraBytes < 1.0d) {
            BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
            return result3.setScale(2, RoundingMode.HALF_UP).toPlainString() + "GB";
        }
        BigDecimal result4 = new BigDecimal(teraBytes);
        return result4.setScale(2, RoundingMode.HALF_UP).toPlainString() + "TB";
    }

    public static String getExternalStorageDirectory() {
        String[] columns;
        String dir = "";
        Runtime runtime = Runtime.getRuntime();
        Process proc = null;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            try {
                proc = runtime.exec("mount");
                is = proc.getInputStream();
                InputStreamReader isr2 = new InputStreamReader(is, StandardCharsets.UTF_8);
                try {
                    BufferedReader br2 = new BufferedReader(isr2);
                    while (true) {
                        try {
                            String line = br2.readLine();
                            if (line == null) {
                                break;
                            }
                            if (!line.contains("secure") && !line.contains("asec")) {
                                if (line.contains("fat")) {
                                    String[] columns2 = line.split(" ");
                                    if (columns2 != null && columns2.length > 1) {
                                        dir = dir.concat(columns2[1] + "\n");
                                    }
                                } else if (line.contains("fuse") && (columns = line.split(" ")) != null && columns.length > 1) {
                                    dir = dir.concat(columns[1] + "\n");
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
                            return dir;
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
                } catch (Exception e13) {
                    e = e13;
                    isr = isr2;
                } catch (Throwable th2) {
                    th = th2;
                    isr = isr2;
                }
            } catch (Exception e14) {
                e = e14;
            }
            if (proc != null) {
                try {
                    proc.destroy();
                } catch (Exception e15) {
                    e15.printStackTrace();
                }
                return dir;
            }
            return dir;
        } catch (Throwable th3) {
            th = th3;
        }
        return dir;
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
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        Uri uri = Uri.fromFile(new File(strPath));
        intent.setDataAndType(uri, "video/*");
        return intent;
    }

    public static Intent getAudioFileIntent(String strPath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        Uri uri = Uri.fromFile(new File(strPath));
        intent.setDataAndType(uri, "audio/*");
        return intent;
    }

    public static Intent getPhotoFileIntent(String strPath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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
}
