package org.apache.poi.xwpf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.NumberingDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XWPFNumbering extends POIXMLDocumentPart {
    protected List<XWPFAbstractNum> abstractNums;
    private CTNumbering ctNumbering;
    boolean isNew;
    protected List<XWPFNum> nums;

    public XWPFNumbering(PackagePart packagePart) throws OpenXML4JException, IOException {
        super(packagePart);
        this.abstractNums = new ArrayList();
        this.nums = new ArrayList();
        this.isNew = true;
    }

    public XWPFNumbering() {
        this.abstractNums = new ArrayList();
        this.nums = new ArrayList();
        this.abstractNums = new ArrayList();
        this.nums = new ArrayList();
        this.isNew = true;
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void onDocumentRead() throws IOException {
        InputStream inputStream = getPackagePart().getInputStream();
        try {
            try {
                CTNumbering numbering = NumberingDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getNumbering();
                this.ctNumbering = numbering;
                for (CTNum cTNum : numbering.getNumArray()) {
                    this.nums.add(new XWPFNum(cTNum, this));
                }
                for (CTAbstractNum cTAbstractNum : this.ctNumbering.getAbstractNumArray()) {
                    this.abstractNums.add(new XWPFAbstractNum(cTAbstractNum, this));
                }
                this.isNew = false;
                inputStream.close();
            } catch (XmlException unused) {
                throw new POIXMLException();
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTNumbering.type.getName().getNamespaceURI(), "numbering"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        this.ctNumbering.save(outputStream, xmlOptions);
        outputStream.close();
    }

    public void setNumbering(CTNumbering cTNumbering) {
        this.ctNumbering = cTNumbering;
    }

    public boolean numExist(BigInteger bigInteger) {
        Iterator<XWPFNum> it = this.nums.iterator();
        while (it.hasNext()) {
            if (it.next().getCTNum().getNumId().equals(bigInteger)) {
                return true;
            }
        }
        return false;
    }

    public BigInteger addNum(XWPFNum xWPFNum) {
        this.ctNumbering.addNewNum();
        this.ctNumbering.setNumArray(this.ctNumbering.sizeOfNumArray() - 1, xWPFNum.getCTNum());
        this.nums.add(xWPFNum);
        return xWPFNum.getCTNum().getNumId();
    }

    public BigInteger addNum(BigInteger bigInteger) {
        CTNum cTNumAddNewNum = this.ctNumbering.addNewNum();
        cTNumAddNewNum.addNewAbstractNumId();
        cTNumAddNewNum.getAbstractNumId().setVal(bigInteger);
        cTNumAddNewNum.setNumId(BigInteger.valueOf(this.nums.size() + 1));
        this.nums.add(new XWPFNum(cTNumAddNewNum, this));
        return cTNumAddNewNum.getNumId();
    }

    public void addNum(BigInteger bigInteger, BigInteger bigInteger2) {
        CTNum cTNumAddNewNum = this.ctNumbering.addNewNum();
        cTNumAddNewNum.addNewAbstractNumId();
        cTNumAddNewNum.getAbstractNumId().setVal(bigInteger);
        cTNumAddNewNum.setNumId(bigInteger2);
        this.nums.add(new XWPFNum(cTNumAddNewNum, this));
    }

    public XWPFNum getNum(BigInteger bigInteger) {
        for (XWPFNum xWPFNum : this.nums) {
            if (xWPFNum.getCTNum().getNumId().equals(bigInteger)) {
                return xWPFNum;
            }
        }
        return null;
    }

    public XWPFAbstractNum getAbstractNum(BigInteger bigInteger) {
        for (XWPFAbstractNum xWPFAbstractNum : this.abstractNums) {
            if (xWPFAbstractNum.getAbstractNum().getAbstractNumId().equals(bigInteger)) {
                return xWPFAbstractNum;
            }
        }
        return null;
    }

    public BigInteger getIdOfAbstractNum(XWPFAbstractNum xWPFAbstractNum) {
        XWPFAbstractNum xWPFAbstractNum2 = new XWPFAbstractNum(xWPFAbstractNum.getCTAbstractNum().copy(), this);
        for (int i = 0; i < this.abstractNums.size(); i++) {
            xWPFAbstractNum2.getCTAbstractNum().setAbstractNumId(BigInteger.valueOf(i));
            xWPFAbstractNum2.setNumbering(this);
            if (xWPFAbstractNum2.getCTAbstractNum().valueEquals(this.abstractNums.get(i).getCTAbstractNum())) {
                return xWPFAbstractNum2.getCTAbstractNum().getAbstractNumId();
            }
        }
        return null;
    }

    public BigInteger addAbstractNum(XWPFAbstractNum xWPFAbstractNum) {
        int size = this.abstractNums.size();
        if (xWPFAbstractNum.getAbstractNum() != null) {
            this.ctNumbering.addNewAbstractNum().set(xWPFAbstractNum.getAbstractNum());
        } else {
            this.ctNumbering.addNewAbstractNum();
            xWPFAbstractNum.getAbstractNum().setAbstractNumId(BigInteger.valueOf(size));
            this.ctNumbering.setAbstractNumArray(size, xWPFAbstractNum.getAbstractNum());
        }
        this.abstractNums.add(xWPFAbstractNum);
        return xWPFAbstractNum.getCTAbstractNum().getAbstractNumId();
    }

    public boolean removeAbstractNum(BigInteger bigInteger) {
        if (bigInteger.byteValue() >= this.abstractNums.size()) {
            return false;
        }
        this.ctNumbering.removeAbstractNum(bigInteger.byteValue());
        this.abstractNums.remove(bigInteger.byteValue());
        return true;
    }

    public BigInteger getAbstractNumID(BigInteger bigInteger) {
        XWPFNum num = getNum(bigInteger);
        if (num == null || num.getCTNum() == null || num.getCTNum().getAbstractNumId() == null) {
            return null;
        }
        return num.getCTNum().getAbstractNumId().getVal();
    }
}
