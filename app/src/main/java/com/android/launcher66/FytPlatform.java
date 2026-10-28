package com.android.launcher66;

import java.util.Locale;

/**
 * Which FYT platform a device is, told by its chipset. Free of android.* so the rules can be
 * tested; DeviceIdentity reads the system and keeps the answer.
 *
 * The most certain identifier is the ro.fyt.platform property. FYT's own apps (the canbus ones in
 * decompiled_FYT_jars, e.g. Air_Activity_All_Normal) compare it with "6312", "6315", "6316",
 * "6318", "6521" and "823", and the number is also that of the platform's update branch
 * (lsecNNNNupdate). The device names the fallback looks for are Build.MODEL values such as
 * ums512_1h10_Natv (7862) and uis7870sc_2h10_nosec (7870): Build.BOARD is ro.product.board on
 * these units and what it holds is not known.
 *
 * A chipset without the FYT mark is not an FYT platform: Teyes units and tablets use the UMS512
 * (T618) as well, with firmware that is not FYT's.
 */
public final class FytPlatform {

    private FytPlatform() {}

    /** Bump it when the rules change: the results saved under the older ones are made again. */
    static final int RULES_VERSION = 1;

    public enum Chipset {
        FYT_7870("FYT 7870", "6318"),
        FYT_7862("FYT 7862", "6315"),
        FYT_8581("FYT 8581", "6316"),
        FYT_9853I("FYT 9853i", "6521"),
        /** An FYT unit whose chipset is not one of the above (ro.fyt.platform 6312, 823, ...). */
        UNKNOWN_FYT("FYT", ""),
        NOT_FYT("", "");

        final String label;
        final String platformCode;

        Chipset(String label, String platformCode) {
            this.label = label;
            this.platformCode = platformCode;
        }
    }

    /**
     * Whether this is an FYT unit: the build says FYT in its board, manufacturer or display id, or
     * it has ro.fyt.platform or ro.build.fytmanufacturer (FYT's number for the customer). The
     * build alone misses units that do not say FYT anywhere.
     */
    static boolean isFyt(String productBoard, String productManufacturer, String fytPlatform,
                         String display, String fytManufacturer) {
        return containsFyt(productBoard) || containsFyt(productManufacturer)
                || notBlank(fytPlatform) || containsFyt(display) || notBlank(fytManufacturer);
    }

    /**
     * @param fyt the result of isFyt()
     * @param fytPlatform ro.fyt.platform
     * @param ids the device names to look in when there is no code: model, board, product, ...
     */
    static Chipset classify(boolean fyt, String fytPlatform, String... ids) {
        if (!fyt) {
            return Chipset.NOT_FYT;
        }
        String code = fytPlatform == null ? "" : fytPlatform.trim();
        if (!code.isEmpty()) {
            for (Chipset chipset : Chipset.values()) {
                if (!chipset.platformCode.isEmpty() && chipset.platformCode.equals(code)) {
                    return chipset;
                }
            }
        }
        StringBuilder joined = new StringBuilder();
        if (ids != null) {
            for (String id : ids) {
                if (id != null) {
                    joined.append(id).append(' ');
                }
            }
        }
        String names = joined.toString().toLowerCase(Locale.ROOT);
        if (names.contains("7870")) {
            return Chipset.FYT_7870;
        }
        if (names.contains("ums512") || names.contains("7862")) {
            return Chipset.FYT_7862;
        }
        if (names.contains("8581") || names.contains("9863")) {
            return Chipset.FYT_8581;
        }
        if (names.contains("9853")) {
            return Chipset.FYT_9853I;
        }
        return Chipset.UNKNOWN_FYT;
    }

    /** The saved chipset, or null if there is none or it is not one that is known. */
    static Chipset fromSaved(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }
        try {
            return Chipset.valueOf(name);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /** The Android version for the user: from the SDK level, the release string only if it is new. */
    static String androidVersion(int sdk, String release) {
        switch (sdk) {
            case 26: return "8.0";
            case 27: return "8.1";
            case 28: return "9";
            case 29: return "10";
            case 30: return "11";
            case 31: return "12";
            case 32: return "12L";
            case 33: return "13";
            case 34: return "14";
            case 35: return "15";
            case 36: return "16";
            case 37: return "17";
            default:
                return notBlank(release) ? release.trim() : "API " + sdk;
        }
    }

    /**
     * The device for the settings, e.g. "FYT 7862 (ums512_1h10_Natv) · Android 10" or
     * "Samsung SM-A556B · Android 16".
     */
    static String deviceLine(Chipset chipset, String manufacturer, String model,
                             String fytPlatform, int sdk, String release) {
        String name;
        String cleanModel = model == null ? "" : model.trim();
        String cleanManufacturer = manufacturer == null ? "" : manufacturer.trim();
        if (chipset == Chipset.NOT_FYT) {
            name = notFytName(cleanManufacturer, cleanModel);
        } else if (chipset == Chipset.UNKNOWN_FYT) {
            String code = fytPlatform == null ? "" : fytPlatform.trim();
            String details = cleanModel.isEmpty() ? code
                    : code.isEmpty() ? cleanModel : cleanModel + ", " + code;
            name = details.isEmpty() ? chipset.label : chipset.label + " (" + details + ")";
        } else {
            name = cleanModel.isEmpty() ? chipset.label : chipset.label + " (" + cleanModel + ")";
        }
        String android = "Android " + androidVersion(sdk, release);
        return name.isEmpty() ? android : name + " · " + android;
    }

    private static String notFytName(String manufacturer, String model) {
        if (manufacturer.isEmpty()) {
            return model;
        }
        if (model.isEmpty()) {
            return capitalize(manufacturer);
        }
        // Some models carry the maker's name already: "Xiaomi Redmi Note 8T" stays as it is.
        if (model.toLowerCase(Locale.ROOT).startsWith(manufacturer.toLowerCase(Locale.ROOT))) {
            return model;
        }
        return capitalize(manufacturer) + " " + model;
    }

    private static String capitalize(String text) {
        return text.substring(0, 1).toUpperCase(Locale.ROOT) + text.substring(1);
    }

    private static boolean containsFyt(String value) {
        return value != null && value.toUpperCase(Locale.ROOT).contains("FYT");
    }

    private static boolean notBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
