package com.lsec.core.frame.app;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.Xml;
import android.view.animation.Animation;
import com.lsec.core.frame.ninepatch.NinePatchChunk;
import com.lsec.core.util.FuncUtils;
import com.lsec.core.util.Markup;
import com.lsec.core.util.data.FinalChip;
import com.syu.radio.db.Radio_Info;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.lingala.zip4j.io.ZipFile;
import net.lingala.zip4j.io.ZipFileHeader;
import net.lingala.zip4j.io.ZipIn;
import net.lingala.zip4j.io.ZipJni;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Zip4jUtilFunc {
    public static HashMap<String, MyZipFile> mHashMapZipFile = new HashMap<>();
    public Context mContext;

    public Zip4jUtilFunc(Context context) {
        this.mContext = context;
    }

    public class MyZipFile {
        HashMap<String, ZipFileHeader> mListFileHeaders = new HashMap<>();
        public ZipFile zipFile;

        public MyZipFile() {
        }

        public ZipFileHeader getFileHead(String strKey) {
            if (this.mListFileHeaders != null) {
                return this.mListFileHeaders.get(strKey);
            }
            return null;
        }

        public ZipFileHeader getEntryName_Drawable(String key) {
            ZipFileHeader fileHeader = getFileHead("drawable-" + FuncUtils.mDispayMetrics.widthPixels + "x" + FuncUtils.mDispayMetrics.heightPixels + "/" + key);
            if (fileHeader != null) {
                return fileHeader;
            }
            Locale localeDefault = Locale.getDefault();
            if (Build.VERSION.SDK_INT >= 24) {
                localeDefault = LocaleList.getDefault().get(0);
            }
            ZipFileHeader fileHeader2 = getFileHead("drawable-" + localeDefault.getLanguage() + "-nodpi/" + key);
            if (fileHeader2 != null) {
                return fileHeader2;
            }
            ZipFileHeader fileHeader3 = getFileHead("drawable-nodpi/" + key);
            if (fileHeader3 != null) {
                return fileHeader3;
            }
            ZipFileHeader fileHeader4 = getFileHead("drawable/" + key);
            if (fileHeader4 != null) {
                return fileHeader4;
            }
            ZipFileHeader fileHeader5 = getFileHead("anim/" + key);
            if (fileHeader5 != null) {
                return fileHeader5;
            }
            return null;
        }

        public ZipFileHeader getEntryName_Drawable(String strFolder, String key) {
            return getFileHead(String.valueOf(strFolder) + "/" + key);
        }

        public ZipFileHeader getEntryName_Raw(String key) {
            ZipFileHeader fileHeader = getFileHead("raw-" + FuncUtils.mDispayMetrics.widthPixels + "x" + FuncUtils.mDispayMetrics.heightPixels + "/" + key);
            return fileHeader != null ? fileHeader : getFileHead("raw/" + key);
        }

        public ZipFileHeader getEntryName_Anim(String key) {
            return getFileHead("anim/" + key);
        }
    }

    /* JADX WARN: Code duplicated, block: B:59:0x0176  */
    /* JADX WARN: Code duplicated, block: B:60:0x0179  */
    public MyZipFile getZipFile(String strZipFile) throws Throwable {
        MyZipFile myZipFile;
        HashMap<String, ZipFileHeader> listFileHeaders;
        MyZipFile myZipFile2 = null;
        try {
            int index = strZipFile.lastIndexOf("/");
            if (index < 0) {
                myZipFile = null;
            } else {
                String strResName = strZipFile.substring(index + 1);
                try {
                    AssetManager assetManager = this.mContext.getAssets();
                    AssetManager.AssetInputStream is = null;
                    String strAsset = FinalChip.BSP_PLATFORM_Null;
                    if (!TextUtils.isEmpty(MyApplication.mStrFolderAsset)) {
                        strAsset = "core_ogg/" + MyApplication.mStrFolderAsset + "/" + strResName;
                        is = (AssetManager.AssetInputStream) assetManager.open(strAsset);
                    }
                    if (is == null) {
                        strAsset = "core_ogg/" + strResName;
                        is = (AssetManager.AssetInputStream) assetManager.open(strAsset);
                    }
                    if (is == null) {
                        myZipFile = null;
                    } else {
                        myZipFile = new MyZipFile();
                        try {
                            myZipFile.zipFile = new ZipFile(this.mContext, strAsset);
                            is.close();
                        } catch (Exception e) {
                            myZipFile2 = myZipFile;
                            myZipFile = myZipFile2;
                        }
                    }
                } catch (Exception e2) {
                }
            }
            if (myZipFile == null) {
                try {
                    File file = new File(strZipFile);
                    if (file.exists()) {
                        myZipFile2 = new MyZipFile();
                        myZipFile2.zipFile = new ZipFile(file);
                    } else {
                        myZipFile2 = myZipFile;
                    }
                } catch (Exception e3) {
                    e = e3;
                    myZipFile2 = myZipFile;
                    e.printStackTrace();
                }
            } else {
                myZipFile2 = myZipFile;
            }
            if (myZipFile2.zipFile != null && (listFileHeaders = myZipFile2.zipFile.getFileHeaders()) != null) {
                for (Map.Entry<String, ZipFileHeader> entry : listFileHeaders.entrySet()) {
                    String strKey = entry.getKey();
                    int index1 = strKey.lastIndexOf("/");
                    if (index1 >= 0) {
                        int index2 = strKey.indexOf(".", index1);
                        if (index2 >= 0) {
                            strKey = strKey.substring(0, index2);
                        }
                        myZipFile2.mListFileHeaders.put(strKey, entry.getValue());
                    } else {
                        myZipFile2.mListFileHeaders.put(strKey, entry.getValue());
                    }
                }
            }
        } catch (Exception e4) {
            e = e4;
        }
        if (myZipFile2 != null) {
            try {
                ZipFileHeader fileHeader = myZipFile2.getFileHead("3c6e0b8a9c15224a8228b9a98ca1531d");
                if (fileHeader != null) {
                    ZipJni zipJni = ZipJni.getInstance();
                    if (zipJni != null) {
                        zipJni.initKeyDefault();
                    }
                    InputStream inputStream = myZipFile2.zipFile.getInputStream(fileHeader);
                    if (inputStream != null) {
                        String strTxt = FuncUtils.readStrFromStream(inputStream);
                        if (zipJni != null) {
                            zipJni.initKeyByTxt(strTxt, this);
                        }
                        inputStream.close();
                    }
                }
            } catch (Exception e5) {
            }
        }
        mHashMapZipFile.put(strZipFile, myZipFile2);
        return myZipFile2;
    }

    public int readInt(InputStream inputStream, byte[] readBuffer) throws IOException {
        readFully(inputStream, readBuffer, 0, 4);
        return ((readBuffer[3] & 255) << 24) | ((readBuffer[2] & 255) << 16) | ((readBuffer[1] & 255) << 8) | ((readBuffer[0] & 255) << 0);
    }

    public void readFully(InputStream inputStream, byte[] b, int off, int len) throws IOException {
        if (len < 0) {
            throw new IndexOutOfBoundsException();
        }
        int n = 0;
        while (n < len) {
            int count = inputStream.read(b, off + n, len - n);
            if (count < 0) {
                throw new EOFException();
            }
            n += count;
        }
    }

    public Drawable getDrawableFromZip(MyUi ui, String strZipFile, String resName, HashMap<String, Drawable> mapDrawables, HashMap<String, Drawable> tmpMapDrawables) throws Throwable {
        ZipFileHeader fileHeader;
        InputStream inputStream;
        Drawable drawable = null;
        try {
            MyZipFile myZipFile = mHashMapZipFile.get(strZipFile);
            if (myZipFile == null) {
                myZipFile = getZipFile(strZipFile);
            }
            if (myZipFile != null && myZipFile.zipFile != null && (fileHeader = myZipFile.getEntryName_Drawable(resName)) != null && (inputStream = myZipFile.zipFile.getInputStream(fileHeader)) != null) {
                if (fileHeader.getFileName().endsWith(".xml")) {
                    drawable = getXmlDrawableFromZip(ui, inputStream, fileHeader.getFileName(), mapDrawables, tmpMapDrawables);
                } else if (fileHeader.getFileName().endsWith(".dat")) {
                    byte[] readBuffer = new byte[4];
                    int w = readInt(inputStream, readBuffer);
                    int h = readInt(inputStream, readBuffer);
                    int size = w * h;
                    int[] imageData = new int[size];
                    for (int i = 0; i < size; i++) {
                        imageData[i] = readInt(inputStream, readBuffer);
                    }
                    Bitmap bitmap = Bitmap.createBitmap(imageData, w, h, Bitmap.Config.ARGB_8888);
                    drawable = new BitmapDrawable(this.mContext.getResources(), bitmap);
                } else if (fileHeader.getFileName().endsWith(".9.png")) {
                    drawable = NinePatchChunk.create9PatchDrawable(this.mContext, inputStream, fileHeader.getFileName());
                } else {
                    drawable = Drawable.createFromStream(inputStream, null);
                }
                inputStream.close();
            }
        } catch (Exception e) {
        }
        return drawable;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public Drawable getXmlDrawableFromZip(MyUi ui, InputStream inputStream, String strEntryName, HashMap<String, Drawable> mapDrawables, HashMap<String, Drawable> tmpMapDrawables) throws Throwable {
        Drawable drawable = null;
        if (inputStream != null) {
            try {
                String strXml = FuncUtils.readStrFromStream(inputStream);
                if (!TextUtils.isEmpty(strXml)) {
                    Markup xml = new Markup();
                    xml.ReadXML(strXml);
                    String strTemp = xml.FindToken(xml.mItemCur.mStrBuff, xml.mItemCur.mPosEnd - xml.mItemCur.mPosStart, 0, null);
                    switch (strTemp.hashCode()) {
                        case -1493546681:
                            if (strTemp.equals("animation-list")) {
                                drawable = MyUi.getXmlAnimationDrawable(ui, xml, mapDrawables, tmpMapDrawables);
                            }
                            break;
                        case -1388777169:
                            if (strTemp.equals("bitmap")) {
                                drawable = MyUi.getXmlBitmapDrawable(ui, xml, mapDrawables, tmpMapDrawables);
                            }
                            break;
                        case -925180581:
                            if (strTemp.equals("rotate")) {
                                drawable = MyUi.getXmlRotateDrawable(ui, xml, mapDrawables, tmpMapDrawables);
                            }
                            break;
                        case 94842723:
                            if (strTemp.equals("color")) {
                                drawable = MyUi.getXmlColorDrawable(xml);
                            }
                            break;
                        case 109399969:
                            if (strTemp.equals("shape")) {
                                drawable = MyUi.getXmlGradientDrawable(this.mContext, xml);
                            }
                            break;
                        case 160680263:
                            if (strTemp.equals("level-list")) {
                                drawable = MyUi.getXmlLevelListDrawable(ui, xml, mapDrawables, tmpMapDrawables);
                            }
                            break;
                        case 1191572447:
                            if (strTemp.equals("selector")) {
                                drawable = MyUi.getXmlStateListDrawable(ui, xml, mapDrawables, tmpMapDrawables);
                            }
                            break;
                    }
                }
                inputStream.close();
            } catch (Exception e) {
            }
        }
        return drawable;
    }

    public Bitmap getBitmapFromZipAssets(String strZipFile, String strFolder, String resName) throws Throwable {
        ZipFileHeader fileHeader;
        InputStream inputStream;
        Bitmap bmp = null;
        try {
            MyZipFile myZipFile = mHashMapZipFile.get(strZipFile);
            if (myZipFile == null) {
                myZipFile = getZipFile(strZipFile);
            }
            if (myZipFile == null || myZipFile.zipFile == null || (fileHeader = myZipFile.getEntryName_Drawable(strFolder, resName)) == null || (inputStream = myZipFile.zipFile.getInputStream(fileHeader)) == null) {
                return null;
            }
            bmp = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            return bmp;
        } catch (Exception e) {
            return bmp;
        }
    }

    public String getRawFromZip(String strZipFile, String resName) throws Throwable {
        InputStream inputStream;
        String strXml = FinalChip.BSP_PLATFORM_Null;
        try {
            MyZipFile myZipFile = mHashMapZipFile.get(strZipFile);
            if (myZipFile == null) {
                myZipFile = getZipFile(strZipFile);
            }
            if (myZipFile == null || myZipFile.zipFile == null) {
                return FinalChip.BSP_PLATFORM_Null;
            }
            ZipFileHeader fileHeader = null;
            if (!TextUtils.isEmpty(MyUi.mStrHeadXml)) {
                fileHeader = myZipFile.getEntryName_Raw(String.valueOf(MyUi.mStrHeadXml) + resName);
            }
            if (fileHeader == null && FuncUtils.mDispayMetrics.widthPixels < FuncUtils.mDispayMetrics.heightPixels) {
                fileHeader = myZipFile.getEntryName_Raw("port_" + resName);
            }
            if (fileHeader == null) {
                fileHeader = myZipFile.getEntryName_Raw(resName);
            }
            if (fileHeader == null || (inputStream = myZipFile.zipFile.getInputStream(fileHeader)) == null) {
                return FinalChip.BSP_PLATFORM_Null;
            }
            strXml = FuncUtils.readStrFromStream(inputStream);
            inputStream.close();
            return strXml;
        } catch (Exception e) {
            return strXml;
        }
    }

    public Animation loadAnimation(MyUi ui, String strZipFile, String resName) throws Throwable {
        ZipFileHeader fileHeader;
        InputStream inputStream;
        Animation animation = null;
        try {
            MyZipFile myZipFile = mHashMapZipFile.get(strZipFile);
            if (myZipFile == null) {
                myZipFile = getZipFile(strZipFile);
            }
            if (myZipFile == null || myZipFile.zipFile == null || (fileHeader = myZipFile.getEntryName_Anim(resName)) == null || (inputStream = myZipFile.zipFile.getInputStream(fileHeader)) == null) {
                return null;
            }
            XmlPullParser xmlPullParser = Xml.newPullParser();
            xmlPullParser.setInput(inputStream, "utf-8");
            animation = MyUi.createAnimationFromXml(ui.mContext, xmlPullParser, null, Xml.asAttributeSet(xmlPullParser));
            inputStream.close();
            return animation;
        } catch (Exception e) {
            return animation;
        }
    }

    public String getStringFromZip(MyUi ui, String strZipFile, String resName) throws Throwable {
        String str;
        String str2 = FinalChip.BSP_PLATFORM_Null;
        Locale localeDefault = Locale.getDefault();
        if (Build.VERSION.SDK_INT >= 24) {
            localeDefault = LocaleList.getDefault().get(0);
        }
        try {
            MyZipFile myZipFile = mHashMapZipFile.get(strZipFile);
            if (myZipFile == null) {
                myZipFile = getZipFile(strZipFile);
            }
            if (myZipFile == null || myZipFile.zipFile == null) {
                return FinalChip.BSP_PLATFORM_Null;
            }
            String strLangXml = "values-" + localeDefault.getLanguage() + "-" + ZipIn.READ_MODE + localeDefault.getCountry() + "/strings";
            if (strLangXml.equals(ui.mStrLangXml)) {
                str = ui.mMapString.get(resName);
            } else {
                ui.mMapString.clear();
                ui.mStrLangXml = strLangXml;
                ZipFileHeader fileHeader = myZipFile.getFileHead(strLangXml);
                if (fileHeader == null) {
                    strLangXml = "values-" + localeDefault.getLanguage() + "/strings";
                    fileHeader = myZipFile.getFileHead(strLangXml);
                }
                str = getStringFromZipEntry(ui, myZipFile, fileHeader, strLangXml, resName);
            }
            if (TextUtils.isEmpty(str)) {
                str2 = getStringFromZipEntry(ui, myZipFile, myZipFile.getFileHead("values/strings"), "values/strings", resName);
                return str2;
            }
            return str;
        } catch (Exception e) {
            return str2;
        }
    }

    public String getStringFromZipEntry(MyUi ui, MyZipFile myZipFile, ZipFileHeader fileHeader, String strLangXml, String resName) throws Throwable {
        String str = FinalChip.BSP_PLATFORM_Null;
        HashMap<String, String> map = ui.mMapString;
        if (strLangXml.startsWith("values/")) {
            map = ui.mMapString_Common;
            if (map.size() > 0) {
                return map.get(resName);
            }
        }
        if (fileHeader != null) {
            try {
                InputStream inputStream = myZipFile.zipFile.getInputStream(fileHeader);
                if (inputStream != null) {
                    String strXml = FuncUtils.readStrFromStream(inputStream);
                    if (!TextUtils.isEmpty(strXml)) {
                        Markup xml = new Markup();
                        xml.ReadXML(strXml);
                        if (xml.IntoItem()) {
                            do {
                                String strTemp = xml.GetAttr(Radio_Info.NAME);
                                if (strTemp != null) {
                                    String strData = xml.GetData();
                                    map.put(strTemp, strData);
                                    if (strTemp.equals(resName)) {
                                        str = strData;
                                    }
                                }
                            } while (xml.NextItem());
                            xml.ExitItem();
                        }
                    }
                    inputStream.close();
                }
            } catch (Exception e) {
            }
        }
        return str;
    }

    public String[] getStringArrayFromZip(MyUi ui, String strZipFile, String resName) throws Throwable {
        ZipFileHeader fileHeader;
        InputStream inputStream;
        String strTemp;
        String[] strArray = null;
        try {
            MyZipFile myZipFile = mHashMapZipFile.get(strZipFile);
            if (myZipFile == null) {
                myZipFile = getZipFile(strZipFile);
            }
            if (myZipFile != null && myZipFile.zipFile != null && (strArray = ui.mMapStringArray.get(resName)) == null && ui.mMapStringArray.size() == 0 && (fileHeader = myZipFile.getFileHead("values/arrays")) != null && (inputStream = myZipFile.zipFile.getInputStream(fileHeader)) != null) {
                String strXml = FuncUtils.readStrFromStream(inputStream);
                if (!TextUtils.isEmpty(strXml)) {
                    Markup xml = new Markup();
                    xml.ReadXML(strXml);
                    if (xml.IntoItem()) {
                        do {
                            if (xml.FindToken(xml.mItemCur.mStrBuff, xml.mItemCur.mPosEnd - xml.mItemCur.mPosStart, 0, null).equals("string-array") && (strTemp = xml.GetAttr(Radio_Info.NAME)) != null) {
                                List<String> list = new ArrayList<>();
                                if (xml.IntoItem()) {
                                    do {
                                        String strData = xml.GetData();
                                        if (!TextUtils.isEmpty(strData)) {
                                            list.add(strData);
                                        }
                                    } while (xml.NextItem());
                                    xml.ExitItem();
                                }
                                if (list.size() > 0) {
                                    String[] strArrayTmp = new String[list.size()];
                                    for (int i = 0; i < list.size(); i++) {
                                        strArrayTmp[i] = list.get(i);
                                    }
                                    ui.mMapStringArray.put(strTemp, strArrayTmp);
                                    if (strTemp.equals(resName)) {
                                        strArray = strArrayTmp;
                                    }
                                }
                            }
                        } while (xml.NextItem());
                        xml.ExitItem();
                    }
                }
                inputStream.close();
            }
        } catch (Exception e) {
        }
        return strArray;
    }

    public List<String> getList(String strZipFile, String strFolder) throws Throwable {
        List<String> list = new ArrayList<>();
        try {
            MyZipFile myZipFile = mHashMapZipFile.get(strZipFile);
            if (myZipFile == null) {
                myZipFile = getZipFile(strZipFile);
                mHashMapZipFile.put(strZipFile, myZipFile);
            }
            if (myZipFile != null && myZipFile.mListFileHeaders != null) {
                String strTmp = String.valueOf(strFolder) + "/";
                Collection<ZipFileHeader> collection = myZipFile.mListFileHeaders.values();
                for (ZipFileHeader fileHeader : collection) {
                    if (fileHeader.getFileName().startsWith(strTmp)) {
                        list.add(fileHeader.getFileName().substring(strTmp.length()));
                    }
                }
            }
        } catch (Exception e) {
        }
        return list;
    }
}
