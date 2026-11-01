package com.android.launcher66;

/**
 * Names of the ActivityInfo.CONFIG_* bits, for the log line that says why the Launcher was
 * recreated. The values are the framework's fixed ones; several (CONFIG_ASSETS_PATHS,
 * CONFIG_WINDOW_CONFIGURATION, ...) are not in the public SDK, so they are written out here.
 */
final class ConfigChanges {

    private ConfigChanges() {}

    private static final int[] BITS = {
            0x00000001, 0x00000002, 0x00000004, 0x00000008, 0x00000010, 0x00000020, 0x00000040,
            0x00000080, 0x00000100, 0x00000200, 0x00000400, 0x00000800, 0x00001000, 0x00002000,
            0x00004000, 0x00008000, 0x08000000, 0x10000000, 0x20000000, 0x40000000, 0x80000000,
    };
    private static final String[] NAMES = {
            "mcc", "mnc", "locale", "touchscreen", "keyboard", "keyboardHidden", "navigation",
            "orientation", "screenLayout", "uiMode", "screenSize", "smallestScreenSize", "density",
            "layoutDirection", "colorMode", "grammaticalGender", "resourcesUnused",
            "fontWeightAdjustment", "windowConfiguration", "fontScale", "assetsPaths",
    };

    /** "uiMode|assetsPaths"; "none" for 0; a bit that is not known as 0x... */
    static String configChangeNames(int bits) {
        if (bits == 0) return "none";
        StringBuilder sb = new StringBuilder();
        int unknown = bits;
        for (int i = 0; i < BITS.length; i++) {
            if ((bits & BITS[i]) != 0) {
                if (sb.length() > 0) sb.append('|');
                sb.append(NAMES[i]);
                unknown &= ~BITS[i];
            }
        }
        if (unknown != 0) {
            if (sb.length() > 0) sb.append('|');
            sb.append("0x").append(Integer.toHexString(unknown));
        }
        return sb.toString();
    }
}
