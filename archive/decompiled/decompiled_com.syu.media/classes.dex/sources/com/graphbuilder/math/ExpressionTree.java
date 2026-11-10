package com.graphbuilder.math;

import com.graphbuilder.struc.Stack;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class ExpressionTree {
    private ExpressionTree() {
    }

    public static Expression parse(String str) {
        if (str == null) {
            throw new ExpressionParseException("Expression string cannot be null.", -1);
        }
        return build(str, 0);
    }

    private static Expression build(String str, int i) {
        int i2;
        char cCharAt;
        if (str.trim().length() == 0) {
            return null;
        }
        Stack stack = new Stack();
        Stack stack2 = new Stack();
        int i3 = 0;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = false;
        while (i3 < str.length()) {
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 == ' ' || cCharAt2 == '\t' || cCharAt2 == '\n') {
                i2 = 1;
            } else if (z) {
                if (cCharAt2 == '(') {
                    if (z3) {
                        throw new ExpressionParseException("Open bracket found after negate.", i3);
                    }
                    stack2.push("(");
                    i2 = 1;
                } else if (z2 || !(cCharAt2 == '+' || cCharAt2 == '-')) {
                    if ((cCharAt2 >= '0' && cCharAt2 <= '9') || cCharAt2 == '.') {
                        int i4 = i3 + 1;
                        while (i4 < str.length()) {
                            char cCharAt3 = str.charAt(i4);
                            if ((cCharAt3 < '0' || cCharAt3 > '9') && cCharAt3 != '.') {
                                if (cCharAt3 != 'e' && cCharAt3 != 'E') {
                                    break;
                                }
                                i4++;
                                if (i4 < str.length()) {
                                    char cCharAt4 = str.charAt(i4);
                                    if (cCharAt4 != '+' && cCharAt4 != '-' && (cCharAt4 < '0' || cCharAt4 > '9')) {
                                        throw new ExpressionParseException("Expected digit, plus sign or minus sign but found: " + String.valueOf(cCharAt4), i4 + i);
                                    }
                                    i4++;
                                }
                                while (i4 < str.length() && (cCharAt = str.charAt(i4)) >= '0' && cCharAt <= '9') {
                                    i4++;
                                }
                                break;
                            }
                            i4++;
                        }
                        String strSubstring = str.substring(i3, i4);
                        try {
                            double d = Double.parseDouble(strSubstring);
                            if (z3) {
                                d = -d;
                            }
                            stack.push(new ValNode(d));
                            i3 = i4 - 1;
                        } catch (Throwable unused) {
                            throw new ExpressionParseException("Improperly formatted value: " + strSubstring, i3 + i);
                        }
                    } else if (cCharAt2 != ',' && cCharAt2 != ')' && cCharAt2 != '^' && cCharAt2 != '*' && cCharAt2 != '/' && cCharAt2 != '+' && cCharAt2 != '-') {
                        int i5 = i3 + 1;
                        while (i5 < str.length() && (cCharAt2 = str.charAt(i5)) != ',' && cCharAt2 != ' ' && cCharAt2 != '\t' && cCharAt2 != '\n' && cCharAt2 != '(' && cCharAt2 != ')' && cCharAt2 != '^' && cCharAt2 != '*' && cCharAt2 != '/' && cCharAt2 != '+' && cCharAt2 != '-') {
                            i5++;
                        }
                        if (i5 < str.length()) {
                            int i6 = i5;
                            while (true) {
                                if ((cCharAt2 != ' ' && cCharAt2 != '\t' && cCharAt2 != '\n') || (i6 = i6 + 1) == str.length()) {
                                    break;
                                }
                                cCharAt2 = str.charAt(i6);
                            }
                            if (cCharAt2 == '(') {
                                FuncNode funcNode = new FuncNode(str.substring(i3, i5), z3);
                                int i7 = i6 + 1;
                                int i8 = 1;
                                while (i8 != 0) {
                                    i6++;
                                    if (i6 >= str.length()) {
                                        throw new ExpressionParseException("Missing function close bracket.", i3 + i);
                                    }
                                    char cCharAt5 = str.charAt(i6);
                                    if (cCharAt5 == ')') {
                                        i8--;
                                    } else if (cCharAt5 == '(') {
                                        i8++;
                                    } else if (cCharAt5 == ',' && i8 == 1) {
                                        Expression expressionBuild = build(str.substring(i7, i6), i7);
                                        if (expressionBuild == null) {
                                            throw new ExpressionParseException("Incomplete function.", i7 + i);
                                        }
                                        funcNode.add(expressionBuild);
                                        i7 = i6 + 1;
                                    }
                                }
                                Expression expressionBuild2 = build(str.substring(i7, i6), i7);
                                if (expressionBuild2 == null) {
                                    if (funcNode.numChildren() > 0) {
                                        throw new ExpressionParseException("Incomplete function.", i7 + i);
                                    }
                                } else {
                                    funcNode.add(expressionBuild2);
                                }
                                stack.push(funcNode);
                            } else {
                                stack.push(new VarNode(str.substring(i3, i5), z3));
                                i6--;
                            }
                            i3 = i6;
                        } else {
                            stack.push(new VarNode(str.substring(i3, i5), z3));
                            i3 = i5 - 1;
                        }
                    } else {
                        throw new ExpressionParseException("Unexpected character: " + String.valueOf(cCharAt2), i3 + i);
                    }
                    i2 = 1;
                    z = false;
                    z2 = false;
                    z3 = false;
                } else {
                    i2 = 1;
                    z2 = true;
                    if (cCharAt2 == '-') {
                        z3 = true;
                    }
                }
            } else if (cCharAt2 == ')') {
                Stack stack3 = new Stack();
                Stack stack4 = new Stack();
                while (true) {
                    if (stack2.isEmpty()) {
                        throw new ExpressionParseException("Missing open bracket.", i3 + i);
                    }
                    Object objPop = stack2.pop();
                    if (!objPop.equals("(")) {
                        stack3.addToTail(stack.pop());
                        stack4.addToTail(objPop);
                    } else {
                        stack3.addToTail(stack.pop());
                        stack.push(build(stack3, stack4));
                        break;
                    }
                }
                i2 = 1;
            } else if (cCharAt2 == '^' || cCharAt2 == '*' || cCharAt2 == '/' || cCharAt2 == '+' || cCharAt2 == '-') {
                stack2.push(String.valueOf(cCharAt2));
                i2 = 1;
                z = true;
            } else {
                throw new ExpressionParseException("Expected operator or close bracket but found: " + String.valueOf(cCharAt2), i3 + i);
            }
            i3 += i2;
        }
        if (stack.size() != stack2.size() + 1) {
            throw new ExpressionParseException("Incomplete expression.", i + str.length());
        }
        return build(stack, stack2);
    }

    private static Expression build(Stack stack, Stack stack2) {
        Stack stack3 = new Stack();
        Stack stack4 = new Stack();
        while (!stack2.isEmpty()) {
            Object objRemoveTail = stack2.removeTail();
            Object objRemoveTail2 = stack.removeTail();
            Object objRemoveTail3 = stack.removeTail();
            if (objRemoveTail.equals("^")) {
                stack.addToTail(new PowNode((Expression) objRemoveTail2, (Expression) objRemoveTail3));
            } else {
                stack.addToTail(objRemoveTail3);
                stack4.push(objRemoveTail);
                stack3.push(objRemoveTail2);
            }
        }
        stack3.push(stack.pop());
        while (!stack4.isEmpty()) {
            Object objRemoveTail4 = stack4.removeTail();
            Object objRemoveTail5 = stack3.removeTail();
            Object objRemoveTail6 = stack3.removeTail();
            if (objRemoveTail4.equals("*")) {
                stack3.addToTail(new MultNode((Expression) objRemoveTail5, (Expression) objRemoveTail6));
            } else if (objRemoveTail4.equals("/")) {
                stack3.addToTail(new DivNode((Expression) objRemoveTail5, (Expression) objRemoveTail6));
            } else {
                stack3.addToTail(objRemoveTail6);
                stack2.push(objRemoveTail4);
                stack.push(objRemoveTail5);
            }
        }
        stack.push(stack3.pop());
        while (!stack2.isEmpty()) {
            Object objRemoveTail7 = stack2.removeTail();
            Object objRemoveTail8 = stack.removeTail();
            Object objRemoveTail9 = stack.removeTail();
            if (objRemoveTail7.equals("+")) {
                stack.addToTail(new AddNode((Expression) objRemoveTail8, (Expression) objRemoveTail9));
            } else if (objRemoveTail7.equals("-")) {
                stack.addToTail(new SubNode((Expression) objRemoveTail8, (Expression) objRemoveTail9));
            } else {
                throw new ExpressionParseException("Unknown operator: " + objRemoveTail7, -1);
            }
        }
        return (Expression) stack.pop();
    }
}
