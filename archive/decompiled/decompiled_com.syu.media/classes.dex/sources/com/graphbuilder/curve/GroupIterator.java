package com.graphbuilder.curve;

import com.fasterxml.aalto.util.XmlConsts;
import com.graphbuilder.math.Expression;
import com.graphbuilder.math.ExpressionParseException;
import com.graphbuilder.math.ExpressionTree;
import com.graphbuilder.math.FuncMap;
import com.graphbuilder.math.VarMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class GroupIterator {
    protected String controlString;
    protected int[] group;
    protected int index_i = 0;
    protected int count_j = 0;

    public GroupIterator(String str, int i) {
        this.controlString = null;
        this.group = null;
        if (str == null) {
            throw new IllegalArgumentException("control string cannot be null");
        }
        this.group = parseControlString(str, i);
        this.controlString = str;
    }

    public GroupIterator(int[] iArr) {
        this.controlString = null;
        this.group = null;
        if (iArr == null) {
            throw new IllegalArgumentException("group array cannot be null");
        }
        if (iArr.length == 0) {
            throw new IllegalArgumentException("group array length cannot be 0");
        }
        if (iArr.length % 2 != 0) {
            throw new IllegalArgumentException("group array must have even length");
        }
        double dLog = Math.log(10.0d);
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int iLog = 0;
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            iArr2[i] = i2;
            if (i2 < 0) {
                iLog++;
                i2 = -i2;
            }
            iLog += ((int) (Math.log(i2) / dLog)) + 1;
        }
        this.group = iArr2;
        StringBuffer stringBuffer = new StringBuffer(iLog + (length / 2) + (length - 1));
        stringBuffer.append(iArr2[0]);
        stringBuffer.append(":");
        stringBuffer.append(iArr2[1]);
        for (int i3 = 2; i3 < iArr.length; i3 += 2) {
            stringBuffer.append(",");
            stringBuffer.append(iArr[i3]);
            stringBuffer.append(":");
            stringBuffer.append(iArr[i3 + 1]);
        }
        this.controlString = stringBuffer.toString();
    }

    public static int[] parseControlString(String str, int i) {
        char c;
        char c2;
        char c3;
        int i2;
        int length = str.length();
        int i3 = 1;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            c = ')';
            c2 = '(';
            c3 = ',';
            if (i5 >= length) {
                break;
            }
            char cCharAt = str.charAt(i5);
            if (cCharAt == ',' && i6 == 0) {
                i3++;
            } else if (cCharAt == '(') {
                i6++;
            } else if (cCharAt == ')') {
                i6--;
            }
            i5++;
        }
        if (i6 != 0) {
            throw new ControlStringParseException("round brackets do not balance");
        }
        int[] iArr = new int[i3 * 2];
        VarMap varMap = new VarMap();
        FuncMap funcMap = new FuncMap();
        funcMap.loadDefaultFunctions();
        int i7 = 0;
        int i8 = i6;
        int i9 = -1;
        int i10 = 0;
        while (i4 <= length) {
            char cCharAt2 = i4 < length ? str.charAt(i4) : XmlConsts.CHAR_SPACE;
            if (i4 == length || (cCharAt2 == c3 && i8 == 0)) {
                if (i9 == -1) {
                    int iRound = (int) Math.round(setVariables(str, varMap, i, i10, i4).eval(varMap, funcMap));
                    iArr[i7] = iRound;
                    iArr[i7 + 1] = iRound;
                    i7 += 2;
                } else {
                    int i11 = i7 + 1;
                    iArr[i7] = (int) Math.round(setVariables(str, varMap, i, i10, i9).eval(varMap, funcMap));
                    i7 = i11 + 1;
                    iArr[i11] = (int) Math.round(setVariables(str, varMap, i, i9 + 1, i4).eval(varMap, funcMap));
                }
                i2 = i4 + 1;
                i9 = -1;
            } else {
                if (cCharAt2 == c2) {
                    i8++;
                } else if (cCharAt2 == c) {
                    i8--;
                } else if (cCharAt2 == ':') {
                    i9 = i4;
                }
                i2 = i10;
            }
            i4++;
            i10 = i2;
            c = ')';
            c2 = '(';
            c3 = ',';
        }
        return iArr;
    }

    private static Expression setVariables(String str, VarMap varMap, int i, int i2, int i3) {
        try {
            Expression expression = ExpressionTree.parse(str.substring(i2, i3));
            if (expression == null) {
                throw new ControlStringParseException("control substring is empty", i2, i3);
            }
            String[] variableNames = expression.getVariableNames();
            if (variableNames.length > 1) {
                throw new ControlStringParseException("too many variables", i2, i3);
            }
            if (variableNames.length == 1) {
                varMap.setValue(variableNames[0], i);
            }
            return expression;
        } catch (ExpressionParseException e) {
            throw new ControlStringParseException("error parsing expression", i2, i3, e);
        }
    }

    public String getControlString() {
        return this.controlString;
    }

    public int getGroupLength() {
        return this.group.length;
    }

    public int getGroupValue(int i) {
        if (i >= 0) {
            int[] iArr = this.group;
            if (i < iArr.length) {
                return iArr[i];
            }
        }
        throw new IllegalArgumentException("required: (index >= 0 && index < group.length) but: (index = " + i + ", group.length = " + this.group.length + ")");
    }

    public int getGroupSize() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.group;
            if (i >= iArr.length) {
                return i2;
            }
            int i3 = iArr[i] - iArr[i + 1];
            if (i3 < 0) {
                i3 = -i3;
            }
            i2 += i3 + 1;
            i += 2;
        }
    }

    public void copyGroupArray(int[] iArr) {
        if (iArr == null) {
            throw new IllegalArgumentException("specified array cannot be null");
        }
        if (iArr.length < this.group.length) {
            throw new IllegalArgumentException("specified array is too small");
        }
        int i = 0;
        while (true) {
            int[] iArr2 = this.group;
            if (i >= iArr2.length) {
                return;
            }
            iArr[i] = iArr2[i];
            i++;
        }
    }

    public boolean hasNext() {
        return this.index_i < this.group.length;
    }

    public int next() {
        int i;
        int[] iArr = this.group;
        int i2 = this.index_i;
        int i3 = iArr[i2];
        int i4 = iArr[i2 + 1];
        if (i3 <= i4) {
            int i5 = this.count_j;
            i = i3 + i5;
            if (i >= i4) {
                this.count_j = 0;
                this.index_i = i2 + 2;
            } else {
                this.count_j = i5 + 1;
            }
        } else {
            int i6 = this.count_j;
            i = i3 - i6;
            if (i <= i4) {
                this.count_j = 0;
                this.index_i = i2 + 2;
            } else {
                this.count_j = i6 + 1;
            }
        }
        return i;
    }

    public void set(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("index_i >= 0 required");
        }
        if (i % 2 == 1) {
            throw new IllegalArgumentException("index_i must be an even number");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("count_j >= 0 required");
        }
        this.index_i = i;
        this.count_j = i2;
    }

    public int index_i() {
        return this.index_i;
    }

    public int count_j() {
        return this.count_j;
    }

    public void reset() {
        this.index_i = 0;
        this.count_j = 0;
    }

    public boolean isInRange(int i, int i2) {
        int i3 = 0;
        while (true) {
            int[] iArr = this.group;
            if (i3 >= iArr.length) {
                return true;
            }
            int i4 = iArr[i3];
            if (i4 < i || i4 >= i2) {
                return false;
            }
            i3++;
        }
    }
}
