package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.math.BigDecimal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public enum ToNumberPolicy implements ToNumberStrategy {
    DOUBLE { // from class: com.google.gson.ToNumberPolicy.1
        @Override // com.google.gson.ToNumberStrategy
        public Double readNumber(JsonReader jsonReader) throws IOException {
            return Double.valueOf(jsonReader.nextDouble());
        }
    },
    LAZILY_PARSED_NUMBER { // from class: com.google.gson.ToNumberPolicy.2
        @Override // com.google.gson.ToNumberStrategy
        public Number readNumber(JsonReader jsonReader) throws IOException {
            return new LazilyParsedNumber(jsonReader.nextString());
        }
    },
    LONG_OR_DOUBLE { // from class: com.google.gson.ToNumberPolicy.3
        @Override // com.google.gson.ToNumberStrategy
        public Number readNumber(JsonReader jsonReader) throws JsonParseException, IOException {
            String strNextString = jsonReader.nextString();
            try {
                try {
                    return Long.valueOf(Long.parseLong(strNextString));
                } catch (NumberFormatException e) {
                    throw new JsonParseException("Cannot parse " + strNextString + "; at path " + jsonReader.getPreviousPath(), e);
                }
            } catch (NumberFormatException unused) {
                Double dValueOf = Double.valueOf(strNextString);
                if ((dValueOf.isInfinite() || dValueOf.isNaN()) && !jsonReader.isLenient()) {
                    throw new MalformedJsonException("JSON forbids NaN and infinities: " + dValueOf + "; at path " + jsonReader.getPreviousPath());
                }
                return dValueOf;
            }
        }
    },
    BIG_DECIMAL { // from class: com.google.gson.ToNumberPolicy.4
        @Override // com.google.gson.ToNumberStrategy
        public BigDecimal readNumber(JsonReader jsonReader) throws IOException {
            String strNextString = jsonReader.nextString();
            try {
                return new BigDecimal(strNextString);
            } catch (NumberFormatException e) {
                throw new JsonParseException("Cannot parse " + strNextString + "; at path " + jsonReader.getPreviousPath(), e);
            }
        }
    }
}
