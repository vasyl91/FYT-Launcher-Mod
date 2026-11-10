package com.alibaba.fastjson.serializer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public final class ListSerializer implements ObjectSerializer {
    public static final ListSerializer instance = new ListSerializer();

    /* JADX WARN: Not initialized variable reg: 15, insn: 0x018b: MOVE (r6 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY] A[D('itemSerializer' com.alibaba.fastjson.serializer.ObjectSerializer)]), block:B:70:0x018b */
    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws Throwable {
        ObjectSerializer itemSerializer;
        boolean writeClassName = serializer.isEnabled(SerializerFeature.WriteClassName);
        SerializeWriter out = serializer.getWriter();
        Type elementType = null;
        if (writeClassName && (fieldType instanceof ParameterizedType)) {
            ParameterizedType param = (ParameterizedType) fieldType;
            elementType = param.getActualTypeArguments()[0];
        }
        if (object == null) {
            if (out.isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
                out.write("[]");
                return;
            } else {
                out.writeNull();
                return;
            }
        }
        List<?> list = (List) object;
        if (list.size() == 0) {
            out.append("[]");
            return;
        }
        SerialContext context = serializer.getContext();
        serializer.setContext(context, object, fieldName, 0);
        try {
            try {
                if (out.isEnabled(SerializerFeature.PrettyFormat)) {
                    out.append('[');
                    serializer.incrementIndent();
                    int i = 0;
                    for (Object item : list) {
                        if (i != 0) {
                            out.append(',');
                        }
                        serializer.println();
                        if (item != null) {
                            if (serializer.containsReference(item)) {
                                serializer.writeReference(item);
                            } else {
                                ObjectSerializer itemSerializer2 = serializer.getObjectWriter(item.getClass());
                                SerialContext itemContext = new SerialContext(context, object, fieldName, 0, 0);
                                serializer.setContext(itemContext);
                                itemSerializer2.write(serializer, item, Integer.valueOf(i), elementType, 0);
                            }
                        } else {
                            serializer.getWriter().writeNull();
                        }
                        i++;
                    }
                    serializer.decrementIdent();
                    serializer.println();
                    out.append(']');
                    serializer.setContext(context);
                    return;
                }
                out.append('[');
                int i2 = 0;
                ObjectSerializer itemSerializer3 = null;
                for (Object item2 : list) {
                    if (i2 != 0) {
                        out.append(',');
                    }
                    if (item2 == null) {
                        out.append("null");
                        itemSerializer = itemSerializer3;
                    } else {
                        Class<?> clazz = item2.getClass();
                        if (clazz == Integer.class) {
                            out.writeInt(((Integer) item2).intValue());
                            itemSerializer = itemSerializer3;
                        } else if (clazz == Long.class) {
                            long val = ((Long) item2).longValue();
                            if (writeClassName) {
                                out.writeLongAndChar(val, 'L');
                                itemSerializer = itemSerializer3;
                            } else {
                                out.writeLong(val);
                                itemSerializer = itemSerializer3;
                            }
                        } else {
                            SerialContext itemContext2 = new SerialContext(context, object, fieldName, 0, 0);
                            serializer.setContext(itemContext2);
                            if (serializer.containsReference(item2)) {
                                serializer.writeReference(item2);
                                itemSerializer = itemSerializer3;
                            } else {
                                itemSerializer = serializer.getObjectWriter(item2.getClass());
                                itemSerializer.write(serializer, item2, Integer.valueOf(i2), elementType, 0);
                            }
                        }
                    }
                    i2++;
                    itemSerializer3 = itemSerializer;
                }
                out.append(']');
                serializer.setContext(context);
            } catch (Throwable th) {
                th = th;
                serializer.setContext(context);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
