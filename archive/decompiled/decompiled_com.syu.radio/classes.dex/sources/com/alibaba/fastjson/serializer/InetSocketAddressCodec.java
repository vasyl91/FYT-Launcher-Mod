package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class InetSocketAddressCodec implements ObjectSerializer, ObjectDeserializer {
    public static InetSocketAddressCodec instance = new InetSocketAddressCodec();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        if (object == null) {
            serializer.writeNull();
            return;
        }
        SerializeWriter out = serializer.getWriter();
        InetSocketAddress address = (InetSocketAddress) object;
        InetAddress inetAddress = address.getAddress();
        out.write('{');
        if (inetAddress != null) {
            out.writeFieldName("address");
            serializer.write(inetAddress);
            out.write(',');
        }
        out.writeFieldName(ClientCookie.PORT_ATTR);
        out.writeInt(address.getPort());
        out.write('}');
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer lexer = defaultJSONParser.getLexer();
        if (lexer.token() == 8) {
            lexer.nextToken();
            return null;
        }
        defaultJSONParser.accept(12);
        InetAddress inetAddress = null;
        int iIntValue = 0;
        while (true) {
            String strStringVal = lexer.stringVal();
            lexer.nextToken(17);
            if (strStringVal.equals("address")) {
                defaultJSONParser.accept(17);
                inetAddress = (InetAddress) defaultJSONParser.parseObject((Class) InetAddress.class);
            } else if (strStringVal.equals(ClientCookie.PORT_ATTR)) {
                defaultJSONParser.accept(17);
                if (lexer.token() != 2) {
                    throw new JSONException("port is not int");
                }
                iIntValue = lexer.intValue();
                lexer.nextToken();
            } else {
                defaultJSONParser.accept(17);
                defaultJSONParser.parse();
            }
            if (lexer.token() == 16) {
                lexer.nextToken();
            } else {
                defaultJSONParser.accept(13);
                return (T) new InetSocketAddress(inetAddress, iIntValue);
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }
}
