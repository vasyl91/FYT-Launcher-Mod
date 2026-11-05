package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.ptg.ArrayPtg;
import org.apache.poi.ss.formula.ptg.AttrPtg;
import org.apache.poi.ss.formula.ptg.FuncVarPtg;
import org.apache.poi.ss.formula.ptg.MemAreaPtg;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;
import org.apache.poi.ss.formula.ptg.Ptg;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class ParseNode {
    public static final ParseNode[] EMPTY_ARRAY = new ParseNode[0];
    private final ParseNode[] _children;
    private boolean _isIf;
    private final Ptg _token;
    private final int _tokenCount;

    public ParseNode(Ptg ptg, ParseNode[] parseNodeArr) {
        if (ptg == null) {
            throw new IllegalArgumentException("token must not be null");
        }
        this._token = ptg;
        this._children = (ParseNode[]) parseNodeArr.clone();
        this._isIf = isIf(ptg);
        int tokenCount = 1;
        for (ParseNode parseNode : parseNodeArr) {
            tokenCount += parseNode.getTokenCount();
        }
        this._tokenCount = this._isIf ? tokenCount + parseNodeArr.length : tokenCount;
    }

    public ParseNode(Ptg ptg) {
        this(ptg, EMPTY_ARRAY);
    }

    public ParseNode(Ptg ptg, ParseNode parseNode) {
        this(ptg, new ParseNode[]{parseNode});
    }

    public ParseNode(Ptg ptg, ParseNode parseNode, ParseNode parseNode2) {
        this(ptg, new ParseNode[]{parseNode, parseNode2});
    }

    private int getTokenCount() {
        return this._tokenCount;
    }

    public int getEncodedSize() {
        Ptg ptg = this._token;
        int size = ptg instanceof ArrayPtg ? 8 : ptg.getSize();
        int i = 0;
        while (true) {
            ParseNode[] parseNodeArr = this._children;
            if (i >= parseNodeArr.length) {
                return size;
            }
            size += parseNodeArr[i].getEncodedSize();
            i++;
        }
    }

    public static Ptg[] toTokenArray(ParseNode parseNode) {
        TokenCollector tokenCollector = new TokenCollector(parseNode.getTokenCount());
        parseNode.collectPtgs(tokenCollector);
        return tokenCollector.getResult();
    }

    private void collectPtgs(TokenCollector tokenCollector) {
        if (isIf(this._token)) {
            collectIfPtgs(tokenCollector);
            return;
        }
        Ptg ptg = this._token;
        boolean z = (ptg instanceof MemFuncPtg) || (ptg instanceof MemAreaPtg);
        if (z) {
            tokenCollector.add(ptg);
        }
        for (int i = 0; i < getChildren().length; i++) {
            getChildren()[i].collectPtgs(tokenCollector);
        }
        if (z) {
            return;
        }
        tokenCollector.add(this._token);
    }

    private void collectIfPtgs(TokenCollector tokenCollector) {
        getChildren()[0].collectPtgs(tokenCollector);
        int iCreatePlaceholder = tokenCollector.createPlaceholder();
        getChildren()[1].collectPtgs(tokenCollector);
        int iCreatePlaceholder2 = tokenCollector.createPlaceholder();
        AttrPtg attrPtgCreateIf = AttrPtg.createIf(tokenCollector.sumTokenSizes(iCreatePlaceholder + 1, iCreatePlaceholder2) + 4);
        if (getChildren().length > 2) {
            getChildren()[2].collectPtgs(tokenCollector);
            int iCreatePlaceholder3 = tokenCollector.createPlaceholder();
            AttrPtg attrPtgCreateSkip = AttrPtg.createSkip(((tokenCollector.sumTokenSizes(iCreatePlaceholder2 + 1, iCreatePlaceholder3) + 4) + 4) - 1);
            AttrPtg attrPtgCreateSkip2 = AttrPtg.createSkip(3);
            tokenCollector.setPlaceholder(iCreatePlaceholder, attrPtgCreateIf);
            tokenCollector.setPlaceholder(iCreatePlaceholder2, attrPtgCreateSkip);
            tokenCollector.setPlaceholder(iCreatePlaceholder3, attrPtgCreateSkip2);
        } else {
            AttrPtg attrPtgCreateSkip3 = AttrPtg.createSkip(3);
            tokenCollector.setPlaceholder(iCreatePlaceholder, attrPtgCreateIf);
            tokenCollector.setPlaceholder(iCreatePlaceholder2, attrPtgCreateSkip3);
        }
        tokenCollector.add(this._token);
    }

    private static boolean isIf(Ptg ptg) {
        return (ptg instanceof FuncVarPtg) && "IF".equals(((FuncVarPtg) ptg).getName());
    }

    public Ptg getToken() {
        return this._token;
    }

    public ParseNode[] getChildren() {
        return this._children;
    }

    private static final class TokenCollector {
        private int _offset = 0;
        private final Ptg[] _ptgs;

        public TokenCollector(int i) {
            this._ptgs = new Ptg[i];
        }

        public int sumTokenSizes(int i, int i2) {
            int size = 0;
            while (i < i2) {
                size += this._ptgs[i].getSize();
                i++;
            }
            return size;
        }

        public int createPlaceholder() {
            int i = this._offset;
            this._offset = i + 1;
            return i;
        }

        public void add(Ptg ptg) {
            if (ptg == null) {
                throw new IllegalArgumentException("token must not be null");
            }
            Ptg[] ptgArr = this._ptgs;
            int i = this._offset;
            ptgArr[i] = ptg;
            this._offset = i + 1;
        }

        public void setPlaceholder(int i, Ptg ptg) {
            Ptg[] ptgArr = this._ptgs;
            if (ptgArr[i] != null) {
                throw new IllegalStateException("Invalid placeholder index (" + i + ")");
            }
            ptgArr[i] = ptg;
        }

        public Ptg[] getResult() {
            return this._ptgs;
        }
    }
}
