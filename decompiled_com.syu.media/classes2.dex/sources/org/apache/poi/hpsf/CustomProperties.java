package org.apache.poi.hpsf;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.apache.poi.util.CodePageUtil;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CustomProperties implements Map<String, Object> {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) CustomProperties.class);
    private final HashMap<Long, CustomProperty> props = new HashMap<>();
    private final TreeBidiMap<Long, String> dictionary = new TreeBidiMap<>();
    private boolean isPure = true;
    private int codepage = -1;

    public CustomProperty put(String str, CustomProperty customProperty) {
        if (str == null) {
            this.isPure = false;
            return null;
        }
        if (!str.equals(customProperty.getName())) {
            throw new IllegalArgumentException("Parameter \"name\" (" + str + ") and custom property's name (" + customProperty.getName() + ") do not match.");
        }
        checkCodePage(str);
        this.props.remove(this.dictionary.getKey((Object) str));
        this.dictionary.put(Long.valueOf(customProperty.getID()), str);
        return this.props.put(Long.valueOf(customProperty.getID()), customProperty);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0047  */
    /* JADX WARN: Code duplicated, block: B:32:0x004b  */
    /* JADX WARN: Code duplicated, block: B:35:0x0060  */
    @Override // java.util.Map
    public Object put(String str, Object obj) {
        int i;
        if (obj instanceof String) {
            i = 30;
        } else if (obj instanceof Short) {
            i = 2;
        } else if (obj instanceof Integer) {
            i = 3;
        } else if (obj instanceof Long) {
            i = 20;
        } else if (obj instanceof Float) {
            i = 4;
        } else if (obj instanceof Double) {
            i = 5;
        } else if (obj instanceof Boolean) {
            i = 11;
        } else if (obj instanceof BigInteger) {
            BigInteger bigInteger = (BigInteger) obj;
            if (bigInteger.bitLength() <= 64 && bigInteger.compareTo(BigInteger.ZERO) >= 0) {
                i = 21;
            } else {
                if (obj instanceof java.util.Date) {
                    throw new IllegalStateException("unsupported datatype - currently String,Short,Integer,Long,Float,Double,Boolean,BigInteger(unsigned long),Date can be processed.");
                }
                i = 64;
            }
        } else {
            if (obj instanceof java.util.Date) {
                throw new IllegalStateException("unsupported datatype - currently String,Short,Integer,Long,Float,Double,Boolean,BigInteger(unsigned long),Date can be processed.");
            }
            i = 64;
        }
        return put(new CustomProperty(new MutableProperty(-1L, i, obj), str));
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        CustomProperty customProperty = this.props.get((Long) this.dictionary.getKey(obj));
        if (customProperty != null) {
            return customProperty.getValue();
        }
        return null;
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return this.props.remove((Long) this.dictionary.removeValue(obj));
    }

    @Override // java.util.Map
    public int size() {
        return this.props.size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.props.isEmpty();
    }

    @Override // java.util.Map
    public void clear() {
        this.props.clear();
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.props.hashCode();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj instanceof CustomProperties) {
            return this.props.equals(((CustomProperties) obj).props);
        }
        return false;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Object> map) {
        for (Map.Entry<? extends String, ? extends Object> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public List<CustomProperty> properties() {
        ArrayList arrayList = new ArrayList(this.props.size());
        Iterator it = this.dictionary.keySet().iterator();
        while (it.hasNext()) {
            arrayList.add(this.props.get((Long) it.next()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        ArrayList arrayList = new ArrayList(this.props.size());
        Iterator it = this.dictionary.keySet().iterator();
        while (it.hasNext()) {
            arrayList.add(this.props.get((Long) it.next()).getValue());
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.props.size());
        Iterator it = this.dictionary.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getValue(), this.props.get(entry.getKey()).getValue());
        }
        return Collections.unmodifiableSet(linkedHashMap.entrySet());
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return Collections.unmodifiableSet(this.dictionary.values());
    }

    public Set<String> nameSet() {
        return Collections.unmodifiableSet(this.dictionary.values());
    }

    public Set<Long> idSet() {
        return Collections.unmodifiableSet(this.dictionary.keySet());
    }

    public void setCodepage(int i) {
        this.codepage = i;
    }

    public int getCodepage() {
        return this.codepage;
    }

    Map<Long, String> getDictionary() {
        return this.dictionary;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return ((obj instanceof Long) && this.dictionary.containsKey(obj)) || this.dictionary.containsValue(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        if (obj instanceof CustomProperty) {
            return this.props.containsValue(obj);
        }
        Iterator<CustomProperty> it = this.props.values().iterator();
        while (it.hasNext()) {
            if (it.next().getValue() == obj) {
                return true;
            }
        }
        return false;
    }

    public boolean isPure() {
        return this.isPure;
    }

    public void setPure(boolean z) {
        this.isPure = z;
    }

    private Object put(CustomProperty customProperty) throws ClassCastException {
        String name = customProperty.getName();
        Long l = name == null ? null : (Long) this.dictionary.getKey((Object) name);
        if (l != null) {
            customProperty.setID(l.longValue());
        } else {
            customProperty.setID(Math.max(this.dictionary.isEmpty() ? 0L : ((Long) this.dictionary.lastKey()).longValue(), 31L) + 1);
        }
        return put(name, customProperty);
    }

    private void checkCodePage(String str) {
        String strCodepageToEncoding;
        int codepage = getCodepage();
        if (codepage == -1) {
            codepage = 1252;
        }
        if (codepage == 1200) {
            return;
        }
        try {
            strCodepageToEncoding = CodePageUtil.codepageToEncoding(codepage, false);
        } catch (UnsupportedEncodingException unused) {
            LOG.log(7, "Codepage '" + codepage + "' can't be found.");
            strCodepageToEncoding = "";
        }
        if (strCodepageToEncoding.isEmpty() || !Charset.forName(strCodepageToEncoding).newEncoder().canEncode(str)) {
            LOG.log(1, "Charset '" + strCodepageToEncoding + "' can't encode '" + str + "' - switching to unicode.");
            setCodepage(1200);
        }
    }
}
