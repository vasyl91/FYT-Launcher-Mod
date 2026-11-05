package org.apache.poi.ss.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DateFormatConverter {
    private static POILogger logger = POILogFactory.getLogger((Class<?>) DateFormatConverter.class);
    private static Map<String, String> tokenConversions = prepareTokenConversions();
    private static Map<String, String> localePrefixes = prepareLocalePrefixes();

    public static class DateFormatTokenizer {
        String format;
        int pos;

        public DateFormatTokenizer(String str) {
            this.format = str;
        }

        public String getNextToken() {
            if (this.pos >= this.format.length()) {
                return null;
            }
            int i = this.pos;
            char cCharAt = this.format.charAt(i);
            this.pos++;
            if (cCharAt == '\'') {
                while (this.pos < this.format.length() && this.format.charAt(this.pos) != '\'') {
                    this.pos++;
                }
                if (this.pos < this.format.length()) {
                    this.pos++;
                }
            } else {
                while (this.pos < this.format.length() && this.format.charAt(this.pos) == cCharAt) {
                    this.pos++;
                }
            }
            return this.format.substring(i, this.pos);
        }

        public static String[] tokenize(String str) {
            ArrayList arrayList = new ArrayList();
            DateFormatTokenizer dateFormatTokenizer = new DateFormatTokenizer(str);
            while (true) {
                String nextToken = dateFormatTokenizer.getNextToken();
                if (nextToken != null) {
                    arrayList.add(nextToken);
                } else {
                    return (String[]) arrayList.toArray(new String[0]);
                }
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            DateFormatTokenizer dateFormatTokenizer = new DateFormatTokenizer(this.format);
            while (true) {
                String nextToken = dateFormatTokenizer.getNextToken();
                if (nextToken != null) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append("[").append(nextToken).append("]");
                } else {
                    return sb.toString();
                }
            }
        }
    }

    private static Map<String, String> prepareTokenConversions() {
        HashMap map = new HashMap();
        map.put("EEEE", "dddd");
        map.put("EEE", "ddd");
        map.put("EE", "ddd");
        map.put("E", "d");
        map.put("Z", "");
        map.put("z", "");
        map.put("a", "am/pm");
        map.put("A", "AM/PM");
        map.put("K", "H");
        map.put("KK", "HH");
        map.put("k", "h");
        map.put("kk", "hh");
        map.put("S", "0");
        map.put("SS", "00");
        map.put("SSS", "000");
        return map;
    }

    private static Map<String, String> prepareLocalePrefixes() {
        HashMap map = new HashMap();
        map.put("af", "[$-0436]");
        map.put("am", "[$-45E]");
        map.put("ar_ae", "[$-3801]");
        map.put("ar_bh", "[$-3C01]");
        map.put("ar_dz", "[$-1401]");
        map.put("ar_eg", "[$-C01]");
        map.put("ar_iq", "[$-0801]");
        map.put("ar_jo", "[$-2C01]");
        map.put("ar_kw", "[$-3401]");
        map.put("ar_lb", "[$-3001]");
        map.put("ar_ly", "[$-1001]");
        map.put("ar_ma", "[$-1801]");
        map.put("ar_om", "[$-2001]");
        map.put("ar_qa", "[$-4001]");
        map.put("ar_sa", "[$-0401]");
        map.put("ar_sy", "[$-2801]");
        map.put("ar_tn", "[$-1C01]");
        map.put("ar_ye", "[$-2401]");
        map.put("as", "[$-44D]");
        map.put("az_az", "[$-82C]");
        map.put("az_az", "[$-42C]");
        map.put("be", "[$-0423]");
        map.put("bg", "[$-0402]");
        map.put("bn", "[$-0845]");
        map.put("bn", "[$-0445]");
        map.put("bo", "[$-0451]");
        map.put("bs", "[$-141A]");
        map.put("ca", "[$-0403]");
        map.put("cs", "[$-0405]");
        map.put("cy", "[$-0452]");
        map.put("da", "[$-0406]");
        map.put("de_at", "[$-C07]");
        map.put("de_ch", "[$-0807]");
        map.put("de_de", "[$-0407]");
        map.put("de_li", "[$-1407]");
        map.put("de_lu", "[$-1007]");
        map.put("dv", "[$-0465]");
        map.put("el", "[$-0408]");
        map.put("en_au", "[$-C09]");
        map.put("en_bz", "[$-2809]");
        map.put("en_ca", "[$-1009]");
        map.put("en_cb", "[$-2409]");
        map.put("en_gb", "[$-0809]");
        map.put("en_ie", "[$-1809]");
        map.put("en_in", "[$-4009]");
        map.put("en_jm", "[$-2009]");
        map.put("en_nz", "[$-1409]");
        map.put("en_ph", "[$-3409]");
        map.put("en_tt", "[$-2C09]");
        map.put("en_us", "[$-0409]");
        map.put("en_za", "[$-1C09]");
        map.put("es_ar", "[$-2C0A]");
        map.put("es_bo", "[$-400A]");
        map.put("es_cl", "[$-340A]");
        map.put("es_co", "[$-240A]");
        map.put("es_cr", "[$-140A]");
        map.put("es_do", "[$-1C0A]");
        map.put("es_ec", "[$-300A]");
        map.put("es_es", "[$-40A]");
        map.put("es_gt", "[$-100A]");
        map.put("es_hn", "[$-480A]");
        map.put("es_mx", "[$-80A]");
        map.put("es_ni", "[$-4C0A]");
        map.put("es_pa", "[$-180A]");
        map.put("es_pe", "[$-280A]");
        map.put("es_pr", "[$-500A]");
        map.put("es_py", "[$-3C0A]");
        map.put("es_sv", "[$-440A]");
        map.put("es_uy", "[$-380A]");
        map.put("es_ve", "[$-200A]");
        map.put("et", "[$-0425]");
        map.put("eu", "[$-42D]");
        map.put("fa", "[$-0429]");
        map.put("fi", "[$-40B]");
        map.put("fo", "[$-0438]");
        map.put("fr_be", "[$-80C]");
        map.put("fr_ca", "[$-C0C]");
        map.put("fr_ch", "[$-100C]");
        map.put("fr_fr", "[$-40C]");
        map.put("fr_lu", "[$-140C]");
        map.put("gd", "[$-43C]");
        map.put("gd_ie", "[$-83C]");
        map.put("gn", "[$-0474]");
        map.put("gu", "[$-0447]");
        map.put("he", "[$-40D]");
        map.put("hi", "[$-0439]");
        map.put("hr", "[$-41A]");
        map.put("hu", "[$-40E]");
        map.put("hy", "[$-42B]");
        map.put("id", "[$-0421]");
        map.put("is", "[$-40F]");
        map.put("it_ch", "[$-0810]");
        map.put("it_it", "[$-0410]");
        map.put("ja", "[$-0411]");
        map.put("kk", "[$-43F]");
        map.put("km", "[$-0453]");
        map.put("kn", "[$-44B]");
        map.put("ko", "[$-0412]");
        map.put("ks", "[$-0460]");
        map.put("la", "[$-0476]");
        map.put("lo", "[$-0454]");
        map.put("lt", "[$-0427]");
        map.put("lv", "[$-0426]");
        map.put("mi", "[$-0481]");
        map.put("mk", "[$-42F]");
        map.put("ml", "[$-44C]");
        map.put("mn", "[$-0850]");
        map.put("mn", "[$-0450]");
        map.put("mr", "[$-44E]");
        map.put("ms_bn", "[$-83E]");
        map.put("ms_my", "[$-43E]");
        map.put("mt", "[$-43A]");
        map.put("my", "[$-0455]");
        map.put("ne", "[$-0461]");
        map.put("nl_be", "[$-0813]");
        map.put("nl_nl", "[$-0413]");
        map.put("no_no", "[$-0814]");
        map.put("or", "[$-0448]");
        map.put("pa", "[$-0446]");
        map.put("pl", "[$-0415]");
        map.put("pt_br", "[$-0416]");
        map.put("pt_pt", "[$-0816]");
        map.put("rm", "[$-0417]");
        map.put("ro", "[$-0418]");
        map.put("ro_mo", "[$-0818]");
        map.put("ru", "[$-0419]");
        map.put("ru_mo", "[$-0819]");
        map.put("sa", "[$-44F]");
        map.put("sb", "[$-42E]");
        map.put("sd", "[$-0459]");
        map.put("si", "[$-45B]");
        map.put("sk", "[$-41B]");
        map.put("sl", "[$-0424]");
        map.put("so", "[$-0477]");
        map.put("sq", "[$-41C]");
        map.put("sr_sp", "[$-C1A]");
        map.put("sr_sp", "[$-81A]");
        map.put("sv_fi", "[$-81D]");
        map.put("sv_se", "[$-41D]");
        map.put("sw", "[$-0441]");
        map.put("ta", "[$-0449]");
        map.put("te", "[$-44A]");
        map.put("tg", "[$-0428]");
        map.put("th", "[$-41E]");
        map.put("tk", "[$-0442]");
        map.put("tn", "[$-0432]");
        map.put("tr", "[$-41F]");
        map.put("ts", "[$-0431]");
        map.put("tt", "[$-0444]");
        map.put("uk", "[$-0422]");
        map.put("ur", "[$-0420]");
        map.put("UTF_8", "[$-0000]");
        map.put("uz_uz", "[$-0843]");
        map.put("uz_uz", "[$-0443]");
        map.put("vi", "[$-42A]");
        map.put("xh", "[$-0434]");
        map.put("yi", "[$-43D]");
        map.put("zh_cn", "[$-0804]");
        map.put("zh_hk", "[$-C04]");
        map.put("zh_mo", "[$-1404]");
        map.put("zh_sg", "[$-1004]");
        map.put("zh_tw", "[$-0404]");
        map.put("zu", "[$-0435]");
        map.put("ar", "[$-0401]");
        map.put("bn", "[$-0845]");
        map.put("de", "[$-0407]");
        map.put("en", "[$-0409]");
        map.put("es", "[$-40A]");
        map.put("fr", "[$-40C]");
        map.put("it", "[$-0410]");
        map.put("ms", "[$-43E]");
        map.put("nl", "[$-0413]");
        map.put("nn", "[$-0814]");
        map.put("no", "[$-0414]");
        map.put("pt", "[$-0816]");
        map.put("sr", "[$-C1A]");
        map.put("sv", "[$-41D]");
        map.put("uz", "[$-0843]");
        map.put("zh", "[$-0804]");
        map.put("ga", "[$-43C]");
        map.put("ga_ie", "[$-83C]");
        map.put("in", "[$-0421]");
        map.put("iw", "[$-40D]");
        map.put("", "[$-0409]");
        return map;
    }

    public static String getPrefixForLocale(Locale locale) {
        String lowerCase = locale.toString().toLowerCase(locale);
        String str = localePrefixes.get(lowerCase);
        if (str != null || (str = localePrefixes.get(lowerCase.substring(0, 2))) != null) {
            return str;
        }
        logger.log(7, "Unable to find prefix for " + locale + "(" + locale.getDisplayName(Locale.ROOT) + ") or " + lowerCase.substring(0, 2) + "(" + new Locale(lowerCase.substring(0, 2)).getDisplayName(Locale.ROOT) + ")");
        return "";
    }

    public static String convert(Locale locale, DateFormat dateFormat) {
        return convert(locale, ((SimpleDateFormat) dateFormat).toPattern());
    }

    public static String convert(Locale locale, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(getPrefixForLocale(locale));
        DateFormatTokenizer dateFormatTokenizer = new DateFormatTokenizer(str);
        while (true) {
            String nextToken = dateFormatTokenizer.getNextToken();
            if (nextToken != null) {
                if (nextToken.startsWith("'")) {
                    sb.append(nextToken.replaceAll("'", "\""));
                } else if (!Character.isLetter(nextToken.charAt(0))) {
                    sb.append(nextToken);
                } else {
                    String str2 = tokenConversions.get(nextToken);
                    if (str2 != null) {
                        nextToken = str2;
                    }
                    sb.append(nextToken);
                }
            } else {
                sb.append(";@");
                return sb.toString().trim();
            }
        }
    }

    public static String getJavaDatePattern(int i, Locale locale) {
        DateFormat dateInstance = DateFormat.getDateInstance(i, locale);
        if (dateInstance instanceof SimpleDateFormat) {
            return ((SimpleDateFormat) dateInstance).toPattern();
        }
        if (i == 0) {
            return "dddd, MMMM d, yyyy";
        }
        if (i != 1) {
            return i != 3 ? "MMM d, yyyy" : "d/MM/yy";
        }
        return "MMMM d, yyyy";
    }

    public static String getJavaTimePattern(int i, Locale locale) {
        DateFormat timeInstance = DateFormat.getTimeInstance(i, locale);
        if (timeInstance instanceof SimpleDateFormat) {
            return ((SimpleDateFormat) timeInstance).toPattern();
        }
        return i != 3 ? "h:mm:ss a" : "h:mm a";
    }

    public static String getJavaDateTimePattern(int i, Locale locale) {
        DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(i, i, locale);
        if (dateTimeInstance instanceof SimpleDateFormat) {
            return ((SimpleDateFormat) dateTimeInstance).toPattern();
        }
        if (i == 0) {
            return "dddd, MMMM d, yyyy h:mm:ss a";
        }
        if (i != 1) {
            return i != 3 ? "MMM d, yyyy h:mm:ss a" : "M/d/yy h:mm a";
        }
        return "MMMM d, yyyy h:mm:ss a";
    }
}
