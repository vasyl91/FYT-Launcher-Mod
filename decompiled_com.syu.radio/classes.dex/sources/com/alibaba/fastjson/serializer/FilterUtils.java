package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class FilterUtils {
    public static Type getExtratype(DefaultJSONParser parser, Object object, String key) {
        List<ExtraTypeProvider> extraTypeProviders = parser.getExtraTypeProvidersDirect();
        if (extraTypeProviders == null) {
            return null;
        }
        Type type = null;
        for (ExtraTypeProvider extraProvider : extraTypeProviders) {
            type = extraProvider.getExtraType(object, key);
        }
        return type;
    }

    public static void processExtra(DefaultJSONParser parser, Object object, String key, Object value) {
        List<ExtraProcessor> extraProcessors = parser.getExtraProcessorsDirect();
        if (extraProcessors != null) {
            for (ExtraProcessor process : extraProcessors) {
                process.processExtra(object, key, value);
            }
        }
    }

    public static char writeBefore(JSONSerializer serializer, Object object, char seperator) {
        List<BeforeFilter> beforeFilters = serializer.getBeforeFiltersDirect();
        if (beforeFilters != null) {
            for (BeforeFilter beforeFilter : beforeFilters) {
                seperator = beforeFilter.writeBefore(serializer, object, seperator);
            }
        }
        return seperator;
    }

    public static char writeAfter(JSONSerializer serializer, Object object, char seperator) {
        List<AfterFilter> afterFilters = serializer.getAfterFiltersDirect();
        if (afterFilters != null) {
            for (AfterFilter afterFilter : afterFilters) {
                seperator = afterFilter.writeAfter(serializer, object, seperator);
            }
        }
        return seperator;
    }

    public static Object processValue(JSONSerializer serializer, Object object, String key, Object propertyValue) {
        List<ValueFilter> valueFilters = serializer.getValueFiltersDirect();
        if (valueFilters != null) {
            for (ValueFilter valueFilter : valueFilters) {
                propertyValue = valueFilter.process(object, key, propertyValue);
            }
        }
        return propertyValue;
    }

    public static String processKey(JSONSerializer serializer, Object object, String key, Object propertyValue) {
        List<NameFilter> nameFilters = serializer.getNameFiltersDirect();
        if (nameFilters != null) {
            for (NameFilter nameFilter : nameFilters) {
                key = nameFilter.process(object, key, propertyValue);
            }
        }
        return key;
    }

    public static String processKey(JSONSerializer serializer, Object object, String key, byte intValue) {
        List<NameFilter> nameFilters = serializer.getNameFiltersDirect();
        if (nameFilters != null) {
            Byte propertyValue = Byte.valueOf(intValue);
            for (NameFilter nameFilter : nameFilters) {
                key = nameFilter.process(object, key, propertyValue);
            }
        }
        return key;
    }

    public static String processKey(JSONSerializer serializer, Object object, String key, short intValue) {
        List<NameFilter> nameFilters = serializer.getNameFiltersDirect();
        if (nameFilters != null) {
            Short propertyValue = Short.valueOf(intValue);
            for (NameFilter nameFilter : nameFilters) {
                key = nameFilter.process(object, key, propertyValue);
            }
        }
        return key;
    }

    public static String processKey(JSONSerializer serializer, Object object, String key, int intValue) {
        List<NameFilter> nameFilters = serializer.getNameFiltersDirect();
        if (nameFilters != null) {
            Integer propertyValue = Integer.valueOf(intValue);
            for (NameFilter nameFilter : nameFilters) {
                key = nameFilter.process(object, key, propertyValue);
            }
        }
        return key;
    }

    public static String processKey(JSONSerializer serializer, Object object, String key, long intValue) {
        List<NameFilter> nameFilters = serializer.getNameFiltersDirect();
        if (nameFilters != null) {
            Long propertyValue = Long.valueOf(intValue);
            for (NameFilter nameFilter : nameFilters) {
                key = nameFilter.process(object, key, propertyValue);
            }
        }
        return key;
    }

    public static String processKey(JSONSerializer serializer, Object object, String key, float intValue) {
        List<NameFilter> nameFilters = serializer.getNameFiltersDirect();
        if (nameFilters != null) {
            Float propertyValue = Float.valueOf(intValue);
            for (NameFilter nameFilter : nameFilters) {
                key = nameFilter.process(object, key, propertyValue);
            }
        }
        return key;
    }

    public static String processKey(JSONSerializer serializer, Object object, String key, double intValue) {
        List<NameFilter> nameFilters = serializer.getNameFiltersDirect();
        if (nameFilters != null) {
            Double propertyValue = Double.valueOf(intValue);
            for (NameFilter nameFilter : nameFilters) {
                key = nameFilter.process(object, key, propertyValue);
            }
        }
        return key;
    }

    public static String processKey(JSONSerializer serializer, Object object, String key, boolean intValue) {
        List<NameFilter> nameFilters = serializer.getNameFiltersDirect();
        if (nameFilters != null) {
            Boolean propertyValue = Boolean.valueOf(intValue);
            for (NameFilter nameFilter : nameFilters) {
                key = nameFilter.process(object, key, propertyValue);
            }
        }
        return key;
    }

    public static String processKey(JSONSerializer serializer, Object object, String key, char intValue) {
        List<NameFilter> nameFilters = serializer.getNameFiltersDirect();
        if (nameFilters != null) {
            Character propertyValue = Character.valueOf(intValue);
            for (NameFilter nameFilter : nameFilters) {
                key = nameFilter.process(object, key, propertyValue);
            }
        }
        return key;
    }

    public static boolean applyName(JSONSerializer serializer, Object object, String key) {
        List<PropertyPreFilter> filters = serializer.getPropertyPreFiltersDirect();
        if (filters == null) {
            return true;
        }
        for (PropertyPreFilter filter : filters) {
            if (!filter.apply(serializer, object, key)) {
                return false;
            }
        }
        return true;
    }

    public static boolean apply(JSONSerializer serializer, Object object, String key, Object propertyValue) {
        List<PropertyFilter> propertyFilters = serializer.getPropertyFiltersDirect();
        if (propertyFilters == null) {
            return true;
        }
        for (PropertyFilter propertyFilter : propertyFilters) {
            if (!propertyFilter.apply(object, key, propertyValue)) {
                return false;
            }
        }
        return true;
    }

    public static boolean apply(JSONSerializer serializer, Object object, String key, byte value) {
        List<PropertyFilter> propertyFilters = serializer.getPropertyFiltersDirect();
        if (propertyFilters != null) {
            Byte propertyValue = Byte.valueOf(value);
            for (PropertyFilter propertyFilter : propertyFilters) {
                if (!propertyFilter.apply(object, key, propertyValue)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static boolean apply(JSONSerializer serializer, Object object, String key, short value) {
        List<PropertyFilter> propertyFilters = serializer.getPropertyFiltersDirect();
        if (propertyFilters != null) {
            Short propertyValue = Short.valueOf(value);
            for (PropertyFilter propertyFilter : propertyFilters) {
                if (!propertyFilter.apply(object, key, propertyValue)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static boolean apply(JSONSerializer serializer, Object object, String key, int value) {
        List<PropertyFilter> propertyFilters = serializer.getPropertyFiltersDirect();
        if (propertyFilters != null) {
            Integer propertyValue = Integer.valueOf(value);
            for (PropertyFilter propertyFilter : propertyFilters) {
                if (!propertyFilter.apply(object, key, propertyValue)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static boolean apply(JSONSerializer serializer, Object object, String key, char value) {
        List<PropertyFilter> propertyFilters = serializer.getPropertyFiltersDirect();
        if (propertyFilters != null) {
            Character propertyValue = Character.valueOf(value);
            for (PropertyFilter propertyFilter : propertyFilters) {
                if (!propertyFilter.apply(object, key, propertyValue)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static boolean apply(JSONSerializer serializer, Object object, String key, long value) {
        List<PropertyFilter> propertyFilters = serializer.getPropertyFiltersDirect();
        if (propertyFilters != null) {
            Long propertyValue = Long.valueOf(value);
            for (PropertyFilter propertyFilter : propertyFilters) {
                if (!propertyFilter.apply(object, key, propertyValue)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static boolean apply(JSONSerializer serializer, Object object, String key, float value) {
        List<PropertyFilter> propertyFilters = serializer.getPropertyFiltersDirect();
        if (propertyFilters != null) {
            Float propertyValue = Float.valueOf(value);
            for (PropertyFilter propertyFilter : propertyFilters) {
                if (!propertyFilter.apply(object, key, propertyValue)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static boolean apply(JSONSerializer serializer, Object object, String key, double value) {
        List<PropertyFilter> propertyFilters = serializer.getPropertyFiltersDirect();
        if (propertyFilters != null) {
            Double propertyValue = Double.valueOf(value);
            for (PropertyFilter propertyFilter : propertyFilters) {
                if (!propertyFilter.apply(object, key, propertyValue)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static boolean applyLabel(JSONSerializer serializer, String label) {
        List<LabelFilter> viewFilters = serializer.getLabelFiltersDirect();
        if (viewFilters != null) {
            for (LabelFilter propertyFilter : viewFilters) {
                if (!propertyFilter.apply(label)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }
}
