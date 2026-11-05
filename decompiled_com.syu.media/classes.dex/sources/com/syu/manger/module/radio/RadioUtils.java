package com.syu.manger.module.radio;

import android.util.Log;
import chip.FinalChip;
import com.syu.media.provider.Media;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/syu/manger/module/radio/RadioUtils;", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "band", FinalChip.BSP_PLATFORM_Null, "isFm", "freq", FinalChip.BSP_PLATFORM_Null, "freq2Text", "unitOfBand", "isFmFreq", "unitOfFreq", "index", "indexUi2Local", "indexLocal2Ui", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public final class RadioUtils {
    public static final RadioUtils INSTANCE = new RadioUtils();

    public final String freq2Text(int freq) {
        if (!isFmFreq(freq)) {
            return String.valueOf(freq);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%.02f", Arrays.copyOf(new Object[]{Float.valueOf(freq / 100.0f)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        return str;
    }

    public final int indexLocal2Ui(int index) {
        int i = 0;
        if (index >= 0 && index < 18) {
            i = index + 65536;
        } else {
            if (18 <= index && index < 30) {
                i = (index + 0) - 18;
            }
        }
        Log.e(Media.ONLINE_TABLE, "--------------->>> indexLocal2Ui index : " + index + " to ui: " + i);
        return i;
    }

    public final int indexUi2Local(int index) {
        int i;
        if (index < 65536 || index >= 131072) {
            i = (index < 0 || index >= 65536) ? 0 : index + 0 + 18;
        } else {
            i = index - 65536;
        }
        Log.e(Media.ONLINE_TABLE, "--------------->>> indexUi2Local index : " + index + " to local: " + i);
        return i;
    }

    public final boolean isFm(int band) {
        return band >= 65536 && band < 131072;
    }

    public final boolean isFmFreq(int freq) {
        Rang.Companion companion = Rang.INSTANCE;
        return freq <= companion.getCHINA().getMax() && companion.getOIRT().getMin() <= freq;
    }

    public final String unitOfBand(int band) {
        return isFm(band) ? "MHz" : "KHz";
    }

    public final String unitOfFreq(int freq) {
        return isFmFreq(freq) ? "MHz" : "KHz";
    }

    public final String freq2Text(int freq, int band) {
        if (!isFm(band)) {
            return String.valueOf(freq);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%.02f", Arrays.copyOf(new Object[]{Float.valueOf(freq / 100.0f)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        return str;
    }
}
