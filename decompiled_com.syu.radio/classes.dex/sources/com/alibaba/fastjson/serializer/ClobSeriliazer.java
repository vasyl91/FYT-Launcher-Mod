package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.sql.Clob;
import java.sql.SQLException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ClobSeriliazer implements ObjectSerializer {
    public static final ClobSeriliazer instance = new ClobSeriliazer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        try {
            if (object == null) {
                serializer.writeNull();
                return;
            }
            Clob clob = (Clob) object;
            Reader reader = clob.getCharacterStream();
            StringWriter writer = new StringWriter();
            char[] buf = new char[1024];
            while (true) {
                int len = reader.read(buf);
                if (len != -1) {
                    writer.write(buf, 0, len);
                } else {
                    reader.close();
                    String text = writer.toString();
                    serializer.write(text);
                    return;
                }
            }
        } catch (SQLException e) {
            throw new IOException("write clob error", e);
        }
    }
}
