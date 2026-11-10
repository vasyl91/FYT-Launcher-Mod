package org.apache.poi.extractor;

import java.io.File;
import org.apache.poi.POITextExtractor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CommandLineTextExtractor {
    public static final String DIVIDER = "=======================";

    public static void main(String[] strArr) throws Exception {
        if (strArr.length < 1) {
            System.err.println("Use:");
            System.err.println("   CommandLineTextExtractor <filename> [filename] [filename]");
            System.exit(1);
        }
        for (String str : strArr) {
            System.out.println(DIVIDER);
            File file = new File(str);
            System.out.println(file);
            POITextExtractor pOITextExtractorCreateExtractor = ExtractorFactory.createExtractor(file);
            try {
                POITextExtractor metadataTextExtractor = pOITextExtractorCreateExtractor.getMetadataTextExtractor();
                System.out.println("   =======================");
                String text = metadataTextExtractor.getText();
                System.out.println(text);
                System.out.println("   =======================");
                String text2 = pOITextExtractorCreateExtractor.getText();
                System.out.println(text2);
                System.out.println(DIVIDER);
                System.out.println("Had " + text.length() + " characters of metadata and " + text2.length() + " characters of text");
                pOITextExtractorCreateExtractor.close();
            } catch (Throwable th) {
                pOITextExtractorCreateExtractor.close();
                throw th;
            }
        }
    }
}
