package com.syu.xml;

import android.util.Log;
import com.syu.xml.gpx.Ele;
import com.syu.xml.gpx.Gpx;
import com.syu.xml.gpx.Name;
import com.syu.xml.gpx.Pt;
import com.syu.xml.gpx.Ptseg;
import com.syu.xml.gpx.Rte;
import com.syu.xml.gpx.Time;
import com.syu.xml.gpx.Trk;
import com.syu.xml.gpx.Trkpt;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilderFactory;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XMLParser {
    public static final String TAG = "XMLParser";
    public HashMap<String, Class<? extends Element>> supportClasses = new HashMap<>();
    public final Pattern pattern = Pattern.compile("^([a-z]|[A-Z])");

    public XMLParser(Class... clsArr) {
        if (clsArr.length > 0) {
            for (Class cls : clsArr) {
                this.supportClasses.put(cls.getSimpleName().toLowerCase(), (Class<? extends Element>) cls);
            }
        }
    }

    public static XMLParser createGpxParser(Class<? extends Element>... clsArr) {
        XMLParser xMLParser = new XMLParser(new Class[0]);
        if (clsArr == null || clsArr.length == 0) {
            xMLParser.supportClasses.put("Gpx".toLowerCase(), Gpx.class);
            xMLParser.supportClasses.put("Trk".toLowerCase(), Trk.class);
            xMLParser.supportClasses.put("Trkpt".toLowerCase(), Trkpt.class);
            xMLParser.supportClasses.put("Trkseg".toLowerCase(), Trkpt.class);
            xMLParser.supportClasses.put("Ele".toLowerCase(), Ele.class);
            xMLParser.supportClasses.put("Time".toLowerCase(), Time.class);
            xMLParser.supportClasses.put("Name".toLowerCase(), Name.class);
            xMLParser.supportClasses.put("Pt".toLowerCase(), Pt.class);
            xMLParser.supportClasses.put("Ptseg".toLowerCase(), Ptseg.class);
            xMLParser.supportClasses.put("Rte".toLowerCase(), Rte.class);
        } else if (clsArr.length > 0) {
            xMLParser.supportClasses.put("Gpx".toLowerCase(), Gpx.class);
            for (Class<? extends Element> cls : clsArr) {
                xMLParser.supportClasses.put(cls.getSimpleName().toLowerCase(), cls);
            }
        }
        return xMLParser;
    }

    public Gpx parse(InputStream inputStream) {
        Log.e(TAG, " parse start!!");
        try {
            try {
                org.w3c.dom.Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement();
                Log.e(TAG, documentElement.getTagName());
                if (!"Gpx".toLowerCase().equals(documentElement.getTagName())) {
                    try {
                        inputStream.close();
                        Log.e(TAG, " parse end!!");
                        return null;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                Gpx gpx = new Gpx();
                gpx.attributes(documentElement, this);
                try {
                    inputStream.close();
                    Log.e(TAG, " parse end!!");
                    return gpx;
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            } catch (Exception e3) {
                throw new RuntimeException(e3);
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
                Log.e(TAG, " parse end!!");
                throw th;
            } catch (IOException e4) {
                throw new RuntimeException(e4);
            }
        }
    }

    public Class<? extends Element> supportElement(String str) {
        if (!this.pattern.matcher(str).find()) {
            return null;
        }
        if (this.supportClasses.size() > 0) {
            return this.supportClasses.get(str);
        }
        try {
            return Class.forName("qin.car.gpx." + (str.substring(0, 1).toUpperCase() + str.substring(1)));
        } catch (Exception unused) {
            return null;
        }
    }
}
