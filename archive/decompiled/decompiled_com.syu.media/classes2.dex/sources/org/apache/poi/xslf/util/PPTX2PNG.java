package org.apache.poi.xslf.util;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import javax.imageio.ImageIO;
import org.apache.poi.openxml4j.opc.ContentTypes;
import org.apache.poi.sl.draw.DrawFactory;
import org.apache.poi.sl.usermodel.Slide;
import org.apache.poi.sl.usermodel.SlideShow;
import org.apache.poi.sl.usermodel.SlideShowFactory;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class PPTX2PNG {
    static void usage(String str) {
        System.out.println("Usage: PPTX2PNG [options] <ppt or pptx file>\n" + (str == null ? "" : "Error: " + str + "\n") + "Options:\n    -scale <float>   scale factor\n    -slide <integer> 1-based index of a slide to render\n    -format <type>   png,gif,jpg (,null for testing)    -outdir <dir>    output directory, defaults to origin of the ppt/pptx file    -quiet           do not write to console (for normal processing)");
    }

    public static void main(String[] strArr) throws Exception {
        boolean z;
        if (strArr.length == 0) {
            usage(null);
            return;
        }
        String str = "-1";
        float f = 1.0f;
        String str2 = ContentTypes.EXTENSION_PNG;
        File file = null;
        File parentFile = null;
        int i = 0;
        boolean z2 = false;
        while (i < strArr.length) {
            if (strArr[i].startsWith("-")) {
                if ("-scale".equals(strArr[i])) {
                    i++;
                    f = Float.parseFloat(strArr[i]);
                } else if ("-slide".equals(strArr[i])) {
                    i++;
                    str = strArr[i];
                } else if ("-format".equals(strArr[i])) {
                    i++;
                    str2 = strArr[i];
                } else if ("-outdir".equals(strArr[i])) {
                    i++;
                    parentFile = new File(strArr[i]);
                } else if ("-quiet".equals(strArr[i])) {
                    z2 = true;
                }
            } else {
                file = new File(strArr[i]);
            }
            i++;
        }
        if (file == null || !file.exists()) {
            usage("File not specified or it doesn't exist");
            return;
        }
        if (str2 == null || !str2.matches("^(png|gif|jpg|null)$")) {
            usage("Invalid format given");
            return;
        }
        if (parentFile == null) {
            parentFile = file.getParentFile();
        }
        if (!"null".equals(str2) && (parentFile == null || !parentFile.exists() || !parentFile.isDirectory())) {
            usage("Output directory doesn't exist");
            return;
        }
        if (f < 0.0f) {
            usage("Invalid scale given");
            return;
        }
        if (!z2) {
            System.out.println("Processing " + file);
        }
        SlideShow<?, ?> slideShowCreate = SlideShowFactory.create(file, null, true);
        try {
            List slides = slideShowCreate.getSlides();
            Set<Integer> setSlideIndexes = slideIndexes(slides.size(), str);
            if (setSlideIndexes.isEmpty()) {
                usage("slidenum must be either -1 (for all) or within range: [1.." + slides.size() + "] for " + file);
                slideShowCreate.close();
                return;
            }
            Dimension pageSize = slideShowCreate.getPageSize();
            int i2 = (int) (pageSize.width * f);
            int i3 = (int) (pageSize.height * f);
            Iterator<Integer> it = setSlideIndexes.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                Slide slide = (Slide) slides.get(next.intValue());
                String title = slide.getTitle();
                if (z2) {
                    z2 = z2;
                } else {
                    System.out.println("Rendering slide " + next + (title == null ? "" : ": " + title));
                }
                BufferedImage bufferedImage = new BufferedImage(i2, i3, 2);
                Graphics2D graphics2DCreateGraphics = bufferedImage.createGraphics();
                DrawFactory.getInstance(graphics2DCreateGraphics).fixFonts(graphics2DCreateGraphics);
                graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
                int i4 = i3;
                double d = f;
                graphics2DCreateGraphics.scale(d, d);
                slide.draw(graphics2DCreateGraphics);
                if ("null".equals(str2)) {
                    z = true;
                } else {
                    z = true;
                    ImageIO.write(bufferedImage, str2, new File(parentFile, String.format(Locale.ROOT, "%1$s-%2$04d.%3$s", file.getName().replaceFirst(".pptx?", ""), next, str2)));
                }
                graphics2DCreateGraphics.dispose();
                bufferedImage.flush();
                it = it;
                i3 = i4;
                slides = slides;
                z2 = z2;
            }
            boolean z3 = z2;
            slideShowCreate.close();
            if (z3) {
                return;
            }
            System.out.println("Done");
        } catch (Throwable th) {
            slideShowCreate.close();
            throw th;
        }
    }

    private static Set<Integer> slideIndexes(int i, String str) {
        TreeSet treeSet = new TreeSet();
        if ("-1".equals(str)) {
            for (int i2 = 0; i2 < i; i2++) {
                treeSet.add(Integer.valueOf(i2));
            }
        } else {
            for (String str2 : str.split(",")) {
                String[] strArrSplit = str2.split("-");
                int length = strArrSplit.length;
                if (length == 1) {
                    int i3 = Integer.parseInt(strArrSplit[0]);
                    if (str2.contains("-")) {
                        int i4 = str2.startsWith("-") ? 0 : i3;
                        int iMin = str2.endsWith("-") ? i : Math.min(i3, i);
                        for (int iMax = Math.max(i4, 1); iMax < iMin; iMax++) {
                            treeSet.add(Integer.valueOf(iMax - 1));
                        }
                    } else {
                        treeSet.add(Integer.valueOf(Math.max(i3, 1) - 1));
                    }
                } else if (length == 2) {
                    int iMin2 = Math.min(Integer.parseInt(strArrSplit[0]), i);
                    int iMin3 = Math.min(Integer.parseInt(strArrSplit[1]), i);
                    for (int iMax2 = Math.max(iMin2, 1); iMax2 < iMin3; iMax2++) {
                        treeSet.add(Integer.valueOf(iMax2 - 1));
                    }
                }
            }
        }
        return treeSet;
    }
}
