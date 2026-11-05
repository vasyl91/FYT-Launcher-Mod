package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.ptg.AbstractFunctionPtg;
import org.apache.poi.ss.formula.ptg.AttrPtg;
import org.apache.poi.ss.formula.ptg.ControlPtg;
import org.apache.poi.ss.formula.ptg.FuncVarPtg;
import org.apache.poi.ss.formula.ptg.IntersectionPtg;
import org.apache.poi.ss.formula.ptg.MemAreaPtg;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.RangePtg;
import org.apache.poi.ss.formula.ptg.UnionPtg;
import org.apache.poi.ss.formula.ptg.ValueOperatorPtg;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class OperandClassTransformer {
    private final FormulaType _formulaType;

    public OperandClassTransformer(FormulaType formulaType) {
        this._formulaType = formulaType;
    }

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.OperandClassTransformer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$formula$FormulaType;

        static {
            int[] iArr = new int[FormulaType.values().length];
            $SwitchMap$org$apache$poi$ss$formula$FormulaType = iArr;
            try {
                iArr[FormulaType.CELL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$FormulaType[FormulaType.ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$FormulaType[FormulaType.NAMEDRANGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$FormulaType[FormulaType.DATAVALIDATION_LIST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public void transformFormula(ParseNode parseNode) {
        byte b;
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$formula$FormulaType[this._formulaType.ordinal()];
        if (i == 1) {
            b = 32;
        } else if (i == 2) {
            b = Ptg.CLASS_ARRAY;
        } else {
            if (i != 3 && i != 4) {
                throw new RuntimeException("Incomplete code - formula type (" + this._formulaType + ") not supported yet");
            }
            b = 0;
        }
        transformNode(parseNode, b, false);
    }

    private void transformNode(ParseNode parseNode, byte b, boolean z) {
        Ptg token = parseNode.getToken();
        ParseNode[] children = parseNode.getChildren();
        int i = 0;
        if (isSimpleValueFunction(token)) {
            boolean z2 = b == 64;
            while (i < children.length) {
                transformNode(children[i], b, z2);
                i++;
            }
            setSimpleValueFuncClass((AbstractFunctionPtg) token, b, z);
            return;
        }
        if (isSingleArgSum(token)) {
            token = FuncVarPtg.SUM;
        }
        if ((token instanceof ValueOperatorPtg) || (token instanceof ControlPtg) || (token instanceof MemFuncPtg) || (token instanceof MemAreaPtg) || (token instanceof UnionPtg) || (token instanceof IntersectionPtg)) {
            if (b == 0) {
                b = 32;
            }
            while (i < children.length) {
                transformNode(children[i], b, z);
                i++;
            }
            return;
        }
        if (token instanceof AbstractFunctionPtg) {
            transformFunctionNode((AbstractFunctionPtg) token, children, b, z);
            return;
        }
        if (children.length > 0) {
            if (token != RangePtg.instance) {
                throw new IllegalStateException("Node should not have any children");
            }
        } else {
            if (token.isBaseToken()) {
                return;
            }
            token.setClass(transformClass(token.getPtgClass(), b, z));
        }
    }

    private static boolean isSingleArgSum(Ptg ptg) {
        if (ptg instanceof AttrPtg) {
            return ((AttrPtg) ptg).isSum();
        }
        return false;
    }

    private static boolean isSimpleValueFunction(Ptg ptg) {
        if (!(ptg instanceof AbstractFunctionPtg)) {
            return false;
        }
        AbstractFunctionPtg abstractFunctionPtg = (AbstractFunctionPtg) ptg;
        if (abstractFunctionPtg.getDefaultOperandClass() != 32) {
            return false;
        }
        for (int numberOfOperands = abstractFunctionPtg.getNumberOfOperands() - 1; numberOfOperands >= 0; numberOfOperands--) {
            if (abstractFunctionPtg.getParameterClass(numberOfOperands) != 32) {
                return false;
            }
        }
        return true;
    }

    private byte transformClass(byte b, byte b2, boolean z) {
        if (b2 == 0) {
            if (z) {
                return (byte) 0;
            }
            return b;
        }
        if (b2 != 32) {
            if (b2 != 64) {
                throw new IllegalStateException("Unexpected operand class (" + ((int) b2) + ")");
            }
        } else if (!z) {
            return (byte) 32;
        }
        return Ptg.CLASS_ARRAY;
    }

    private void transformFunctionNode(AbstractFunctionPtg abstractFunctionPtg, ParseNode[] parseNodeArr, byte b, boolean z) {
        byte defaultOperandClass = abstractFunctionPtg.getDefaultOperandClass();
        boolean z2 = true;
        if (z) {
            if (defaultOperandClass != 0) {
                if (defaultOperandClass == 32) {
                    abstractFunctionPtg.setClass(Ptg.CLASS_ARRAY);
                } else if (defaultOperandClass == 64) {
                    abstractFunctionPtg.setClass(Ptg.CLASS_ARRAY);
                } else {
                    throw new IllegalStateException("Unexpected operand class (" + ((int) defaultOperandClass) + ")");
                }
            } else if (b == 0) {
                abstractFunctionPtg.setClass((byte) 0);
            } else {
                abstractFunctionPtg.setClass(Ptg.CLASS_ARRAY);
            }
            z2 = false;
        } else {
            if (defaultOperandClass == b) {
                abstractFunctionPtg.setClass(defaultOperandClass);
            } else if (b != 0) {
                if (b == 32) {
                    abstractFunctionPtg.setClass((byte) 32);
                } else {
                    if (b != 64) {
                        throw new IllegalStateException("Unexpected operand class (" + ((int) b) + ")");
                    }
                    if (defaultOperandClass == 0) {
                        abstractFunctionPtg.setClass((byte) 0);
                    } else if (defaultOperandClass == 32) {
                        abstractFunctionPtg.setClass(Ptg.CLASS_ARRAY);
                    } else {
                        throw new IllegalStateException("Unexpected operand class (" + ((int) defaultOperandClass) + ")");
                    }
                    if (defaultOperandClass != 32) {
                    }
                }
            } else if (defaultOperandClass == 32) {
                abstractFunctionPtg.setClass((byte) 32);
            } else if (defaultOperandClass == 64) {
                abstractFunctionPtg.setClass(Ptg.CLASS_ARRAY);
            } else {
                throw new IllegalStateException("Unexpected operand class (" + ((int) defaultOperandClass) + ")");
            }
            z2 = false;
        }
        for (int i = 0; i < parseNodeArr.length; i++) {
            transformNode(parseNodeArr[i], abstractFunctionPtg.getParameterClass(i), z2);
        }
    }

    private void setSimpleValueFuncClass(AbstractFunctionPtg abstractFunctionPtg, byte b, boolean z) {
        if (z || b == 64) {
            abstractFunctionPtg.setClass(Ptg.CLASS_ARRAY);
        } else {
            abstractFunctionPtg.setClass((byte) 32);
        }
    }
}
