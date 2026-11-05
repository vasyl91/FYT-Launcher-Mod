package com.lsec.core.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Markup {
    public XmlItem mItemCur;
    public List<XmlItem> mItems;
    public int mLenData;
    public boolean mNoError;
    public String mStrData;

    public class XmlItem {
        public HashMap<String, String> mAttrs;
        public XmlItem mChild;
        public XmlItem mNext;
        public XmlItem mParent;
        public int mPosEnd;
        public int mPosStart;
        public String mStrBuff;

        public XmlItem() {
        }
    }

    public void ReadXML(String strXml) {
        if (strXml != null && strXml.length() > 0) {
            this.mStrData = new String(strXml);
            if (this.mStrData != null) {
                this.mLenData = this.mStrData.length();
                this.mNoError = true;
                ParseItem(0, null);
                if (this.mNoError && this.mItems != null && this.mItems.size() > 0) {
                    this.mItemCur = this.mItems.get(0);
                }
            }
        }
    }

    public int ParseItem(int iStart, XmlItem parent) {
        int iPosEnd;
        String strTemp;
        String strAttr;
        if (this.mLenData <= iStart || iStart < 0) {
            return -1;
        }
        XmlItem prev = null;
        while (this.mLenData > iStart && iStart >= 0) {
            int iIndex = this.mStrData.indexOf(60, iStart);
            while (iIndex + 3 < this.mLenData && this.mStrData.charAt(iIndex + 1) == '!' && this.mStrData.charAt(iIndex + 2) == '-' && this.mStrData.charAt(iIndex + 3) == '-') {
                int iIndexStart = iIndex + 3;
                int iIndexTmp = this.mStrData.indexOf("-->", iIndexStart);
                if (iIndexTmp >= iIndexStart) {
                    iStart = iIndexTmp + 3;
                    iIndex = this.mStrData.indexOf(60, iStart);
                }
            }
            if (iIndex >= 0) {
                int iPosStart = iIndex + 1;
                int iIndexTmp2 = this.mStrData.indexOf(62, iIndex);
                if (iIndexTmp2 >= 1) {
                    boolean bFinish = false;
                    if (this.mStrData.charAt(iIndexTmp2 - 1) == '/') {
                        bFinish = true;
                    }
                    if (bFinish) {
                        iPosEnd = iIndexTmp2 - 1;
                    } else {
                        iPosEnd = iIndexTmp2;
                    }
                    iStart = iPosEnd + 1;
                    char c = this.mStrData.charAt(iIndex + 1);
                    if (c != '!' && c != '?') {
                        if (c == '/') {
                            return iStart;
                        }
                        XmlItem next = new XmlItem();
                        next.mNext = null;
                        next.mChild = null;
                        next.mParent = parent;
                        next.mPosStart = iPosStart;
                        next.mPosEnd = iPosEnd;
                        next.mStrBuff = new String(this.mStrData.substring(iPosStart, iPosEnd));
                        next.mAttrs = new HashMap<>();
                        int[] iTmpStart = {0};
                        int iTmpLen = next.mPosEnd - next.mPosStart;
                        while (iTmpStart[0] >= 0 && iTmpStart[0] < iTmpLen && (strTemp = FindToken(next.mStrBuff, iTmpLen, iTmpStart[0], iTmpStart)) != null && iTmpStart[0] < iTmpLen) {
                            if (next.mStrBuff.charAt(iTmpStart[0] - 1) == '=' && (strAttr = FindToken(next.mStrBuff, iTmpLen, iTmpStart[0], iTmpStart)) != null) {
                                next.mAttrs.put(strTemp, strAttr);
                            }
                        }
                        if (prev != null) {
                            prev.mNext = next;
                        } else if (parent != null) {
                            parent.mChild = next;
                        }
                        prev = next;
                        if (this.mItems == null) {
                            this.mItems = new ArrayList();
                        }
                        if (this.mItems != null) {
                            this.mItems.add(next);
                        }
                        if (!bFinish) {
                            iStart = ParseItem(iStart, next);
                        }
                    }
                } else {
                    this.mNoError = false;
                    return -1;
                }
            } else {
                return -1;
            }
        }
        return iStart;
    }

    public void ToRoot() {
        if (this.mNoError && this.mItems != null && this.mItems.size() > 0) {
            this.mItemCur = this.mItems.get(0);
        }
    }

    public boolean HeadItem() {
        if (this.mItemCur != null) {
            if (this.mItemCur.mParent != null) {
                this.mItemCur = this.mItemCur.mParent.mChild;
                return true;
            }
            return true;
        }
        ToRoot();
        return true;
    }

    public boolean NextItem() {
        if (this.mItemCur == null || this.mItemCur.mNext == null) {
            return false;
        }
        this.mItemCur = this.mItemCur.mNext;
        return true;
    }

    public boolean FindItem(String strName) {
        boolean bRet = false;
        if (strName != null) {
            XmlItem itemBak = this.mItemCur;
            while (this.mItemCur != null) {
                String strTemp = FindToken(this.mStrData, this.mLenData, this.mItemCur.mPosStart, null);
                if (strName.equals(strTemp)) {
                    bRet = true;
                    break;
                }
                this.mItemCur = this.mItemCur.mNext;
            }
            this.mItemCur = itemBak;
        }
        return bRet;
    }

    public boolean FindNextItem(String strName) {
        if (!NextItem()) {
            return false;
        }
        boolean bRet = FindItem(strName);
        return bRet;
    }

    public boolean IntoItem() {
        if (this.mItemCur == null || this.mItemCur.mChild == null) {
            return false;
        }
        this.mItemCur = this.mItemCur.mChild;
        return true;
    }

    public void ExitItem() {
        if (this.mItemCur != null) {
            this.mItemCur = this.mItemCur.mParent;
        }
    }

    public String GetData() {
        if (this.mItemCur == null || this.mItemCur.mChild != null) {
            return null;
        }
        return GetData(this.mStrData, this.mLenData, this.mItemCur.mPosEnd + 1, null);
    }

    public String GetAttr(String strName) {
        if (strName == null || this.mItemCur == null || !this.mItemCur.mAttrs.containsKey(strName)) {
            return null;
        }
        String strRet = this.mItemCur.mAttrs.get(strName);
        return strRet;
    }

    public String GetData(String strData, int iLenData, int iStart, int[] iStartNew) {
        String strRet = null;
        if (iStartNew != null) {
            iStartNew[0] = -1;
        }
        if (iStart >= 0 && iStart < iLenData && strData != null) {
            int iStartPos = iStart;
            char c = strData.charAt(iStartPos);
            while (true) {
                if ((c != ' ' && c != '\t' && c != '\r' && c != '\n' && c != '=' && c != '<') || iStartPos >= iLenData - 1) {
                    break;
                }
                iStartPos++;
                c = strData.charAt(iStartPos);
            }
            int iEndPos = iStartPos;
            if (c == '\'' || c == '\"') {
                iStartPos++;
                iEndPos++;
                if (iEndPos < iLenData) {
                    char cTmp = strData.charAt(iEndPos);
                    while (cTmp != c && iEndPos < iLenData - 1) {
                        iEndPos++;
                        cTmp = strData.charAt(iEndPos);
                    }
                }
            } else {
                char cTmp2 = strData.charAt(iEndPos);
                while (cTmp2 != '<' && iEndPos < iLenData - 1) {
                    iEndPos++;
                    cTmp2 = strData.charAt(iEndPos);
                }
            }
            if (iEndPos > iStartPos) {
                strRet = strData.substring(iStartPos, iEndPos);
            }
            if (iStartNew != null) {
                iStartNew[0] = iEndPos + 1;
            }
        }
        return strRet;
    }

    public String FindToken(String strData, int iLenData, int iStart, int[] iStartNew) {
        String strRet = null;
        if (iStartNew != null) {
            iStartNew[0] = -1;
        }
        if (iStart >= 0 && iStart < iLenData && strData != null) {
            int iStartPos = iStart;
            char c = strData.charAt(iStartPos);
            while (true) {
                if ((c != ' ' && c != '\t' && c != '\r' && c != '\n' && c != '=' && c != '<') || iStartPos >= iLenData - 1) {
                    break;
                }
                iStartPos++;
                c = strData.charAt(iStartPos);
            }
            int iEndPos = iStartPos;
            if (c == '\'' || c == '\"') {
                iStartPos++;
                iEndPos++;
                if (iEndPos < iLenData) {
                    char cTmp = strData.charAt(iEndPos);
                    while (cTmp != c && iEndPos < iLenData - 1) {
                        iEndPos++;
                        cTmp = strData.charAt(iEndPos);
                    }
                }
            } else {
                char cTmp2 = strData.charAt(iEndPos);
                while (cTmp2 != ' ' && cTmp2 != '\t' && cTmp2 != '\r' && cTmp2 != '\n' && cTmp2 != '=' && cTmp2 != '<' && iEndPos < iLenData - 1) {
                    iEndPos++;
                    cTmp2 = strData.charAt(iEndPos);
                }
            }
            if (iEndPos > iStartPos) {
                strRet = strData.substring(iStartPos, iEndPos);
            }
            if (iStartNew != null) {
                iStartNew[0] = iEndPos + 1;
            }
        }
        return strRet;
    }
}
