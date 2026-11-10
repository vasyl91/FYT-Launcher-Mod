package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class DateSerializer implements ObjectSerializer {
    public static final DateSerializer instance = new DateSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        Date date;
        char[] buf;
        SerializeWriter out = serializer.getWriter();
        if (object == null) {
            out.writeNull();
            return;
        }
        if (object instanceof Date) {
            date = (Date) object;
        } else {
            date = TypeUtils.castToDate(object);
        }
        if (out.isEnabled(SerializerFeature.WriteDateUseDateFormat)) {
            DateFormat format = serializer.getDateFormat();
            if (format == null) {
                format = new SimpleDateFormat(JSON.DEFFAULT_DATE_FORMAT);
            }
            String text = format.format(date);
            out.writeString(text);
            return;
        }
        if (out.isEnabled(SerializerFeature.WriteClassName) && object.getClass() != fieldType) {
            if (object.getClass() == Date.class) {
                out.write("new Date(");
                out.writeLongAndChar(((Date) object).getTime(), ')');
                return;
            }
            out.write('{');
            out.writeFieldName(JSON.DEFAULT_TYPE_KEY);
            serializer.write(object.getClass().getName());
            out.writeFieldValue(',', "val", ((Date) object).getTime());
            out.write('}');
            return;
        }
        long time = date.getTime();
        if (serializer.isEnabled(SerializerFeature.UseISO8601DateFormat)) {
            if (serializer.isEnabled(SerializerFeature.UseSingleQuotes)) {
                out.append('\'');
            } else {
                out.append('\"');
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(time);
            int year = calendar.get(1);
            int month = calendar.get(2) + 1;
            int day = calendar.get(5);
            int hour = calendar.get(11);
            int minute = calendar.get(12);
            int second = calendar.get(13);
            int millis = calendar.get(14);
            if (millis != 0) {
                buf = "0000-00-00T00:00:00.000".toCharArray();
                IOUtils.getChars(millis, 23, buf);
                IOUtils.getChars(second, 19, buf);
                IOUtils.getChars(minute, 16, buf);
                IOUtils.getChars(hour, 13, buf);
                IOUtils.getChars(day, 10, buf);
                IOUtils.getChars(month, 7, buf);
                IOUtils.getChars(year, 4, buf);
            } else if (second == 0 && minute == 0 && hour == 0) {
                buf = "0000-00-00".toCharArray();
                IOUtils.getChars(day, 10, buf);
                IOUtils.getChars(month, 7, buf);
                IOUtils.getChars(year, 4, buf);
            } else {
                buf = "0000-00-00T00:00:00".toCharArray();
                IOUtils.getChars(second, 19, buf);
                IOUtils.getChars(minute, 16, buf);
                IOUtils.getChars(hour, 13, buf);
                IOUtils.getChars(day, 10, buf);
                IOUtils.getChars(month, 7, buf);
                IOUtils.getChars(year, 4, buf);
            }
            out.write(buf);
            int timeZone = calendar.getTimeZone().getRawOffset() / 3600000;
            if (timeZone == 0) {
                out.append("Z");
            } else if (timeZone > 0) {
                out.append("+").append((CharSequence) String.format("%02d", Integer.valueOf(timeZone))).append(":00");
            } else {
                out.append("-").append((CharSequence) String.format("%02d", Integer.valueOf(-timeZone))).append(":00");
            }
            if (serializer.isEnabled(SerializerFeature.UseSingleQuotes)) {
                out.append('\'');
                return;
            } else {
                out.append('\"');
                return;
            }
        }
        out.writeLong(time);
    }
}
