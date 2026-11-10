package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.TransformIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Deprecated
public class MultiValueMap<K, V> extends AbstractMapDecorator<K, Object> implements MultiMap<K, V>, Serializable {
    private static final long serialVersionUID = -2214159910087182007L;
    private final Factory<? extends Collection<V>> collectionFactory;
    private transient Collection<V> valuesView;

    public static <K, V> MultiValueMap<K, V> multiValueMap(Map<K, ? super Collection<V>> map) {
        return multiValueMap(map, ArrayList.class);
    }

    public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, ? super C> map, Class<C> cls) {
        return new MultiValueMap<>(map, new ReflectionFactory(cls));
    }

    public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, ? super C> map, Factory<C> factory) {
        return new MultiValueMap<>(map, factory);
    }

    public MultiValueMap() {
        this(new HashMap(), new ReflectionFactory(ArrayList.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected <C extends Collection<V>> MultiValueMap(Map<K, ? super C> map, Factory<C> factory) {
        super(map);
        if (factory == 0) {
            throw new IllegalArgumentException("The factory must not be null");
        }
        this.collectionFactory = factory;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        decorated().clear();
    }

    @Override // org.apache.commons.collections4.MultiMap
    public boolean removeMapping(Object obj, Object obj2) {
        Collection<V> collection = getCollection(obj);
        if (collection == null || !collection.remove(obj2)) {
            return false;
        }
        if (!collection.isEmpty()) {
            return true;
        }
        remove(obj);
        return true;
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public boolean containsValue(Object obj) {
        Set<Map.Entry<K, V>> setEntrySet = decorated().entrySet();
        if (setEntrySet == null) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = setEntrySet.iterator();
        while (it.hasNext()) {
            if (((Collection) it.next().getValue()).contains(obj)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public Object put(K k, Object obj) {
        boolean zAdd;
        Collection<V> collection = getCollection(k);
        if (collection == null) {
            zAdd = true;
            Collection<V> collectionCreateCollection = createCollection(1);
            collectionCreateCollection.add(obj);
            if (collectionCreateCollection.size() > 0) {
                decorated().put(k, collectionCreateCollection);
            } else {
                zAdd = false;
            }
        } else {
            zAdd = collection.add(obj);
        }
        if (zAdd) {
            return obj;
        }
        return null;
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends K, ?> map) {
        if (map instanceof MultiMap) {
            for (Map.Entry<K, Object> entry : ((MultiMap) map).entrySet()) {
                putAll(entry.getKey(), (Collection) entry.getValue());
            }
            return;
        }
        for (Map.Entry<? extends K, ?> entry2 : map.entrySet()) {
            put(entry2.getKey(), entry2.getValue());
        }
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, Object>> entrySet() {
        return super.entrySet();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public Collection<Object> values() {
        Collection<V> collection = this.valuesView;
        if (collection != null) {
            return collection;
        }
        Values values = new Values();
        this.valuesView = values;
        return values;
    }

    public boolean containsValue(Object obj, Object obj2) {
        Collection<V> collection = getCollection(obj);
        if (collection == null) {
            return false;
        }
        return collection.contains(obj2);
    }

    public Collection<V> getCollection(Object obj) {
        return (Collection) decorated().get(obj);
    }

    public int size(Object obj) {
        Collection<V> collection = getCollection(obj);
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean putAll(K k, Collection<V> collection) {
        if (collection == 0 || collection.size() == 0) {
            return false;
        }
        Collection<V> collection2 = getCollection(k);
        if (collection2 == null) {
            Collection<V> collectionCreateCollection = createCollection(collection.size());
            collectionCreateCollection.addAll(collection);
            if (collectionCreateCollection.size() <= 0) {
                return false;
            }
            decorated().put(k, collectionCreateCollection);
            return true;
        }
        return collection2.addAll(collection);
    }

    public Iterator<V> iterator(Object obj) {
        if (!containsKey(obj)) {
            return EmptyIterator.emptyIterator();
        }
        return new ValuesIterator(obj);
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        final Iterator it = new ArrayList(keySet()).iterator();
        return new LazyIteratorChain<Map.Entry<K, V>>() { // from class: org.apache.commons.collections4.map.MultiValueMap.1
            @Override // org.apache.commons.collections4.iterators.LazyIteratorChain
            protected Iterator<? extends Map.Entry<K, V>> nextIterator(int i) {
                if (!it.hasNext()) {
                    return null;
                }
                final Object next = it.next();
                return new TransformIterator(new ValuesIterator(next), new Transformer<V, Map.Entry<K, V>>() { // from class: org.apache.commons.collections4.map.MultiValueMap.1.1
                    @Override // org.apache.commons.collections4.Transformer
                    public Map.Entry<K, V> transform(final V v) {
                        return new Map.Entry<K, V>() { // from class: org.apache.commons.collections4.map.MultiValueMap.1.1.1
                            @Override // java.util.Map.Entry
                            public K getKey() {
                                return (K) next;
                            }

                            @Override // java.util.Map.Entry
                            public V getValue() {
                                return (V) v;
                            }

                            @Override // java.util.Map.Entry
                            public V setValue(V v2) {
                                throw new UnsupportedOperationException();
                            }
                        };
                    }
                });
            }
        };
    }

    public int totalSize() {
        Iterator<V> it = decorated().values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += CollectionUtils.size(it.next());
        }
        return size;
    }

    protected Collection<V> createCollection(int i) {
        return this.collectionFactory.create();
    }

    private class Values extends AbstractCollection<V> {
        private Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            IteratorChain iteratorChain = new IteratorChain();
            Iterator<K> it = MultiValueMap.this.keySet().iterator();
            while (it.hasNext()) {
                iteratorChain.addIterator(new ValuesIterator(it.next()));
            }
            return iteratorChain;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return MultiValueMap.this.totalSize();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            MultiValueMap.this.clear();
        }
    }

    private class ValuesIterator implements Iterator<V> {
        private final Iterator<V> iterator;
        private final Object key;
        private final Collection<V> values;

        public ValuesIterator(Object obj) {
            this.key = obj;
            Collection<V> collection = MultiValueMap.this.getCollection(obj);
            this.values = collection;
            this.iterator = collection.iterator();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
            if (this.values.isEmpty()) {
                MultiValueMap.this.remove(this.key);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return this.iterator.next();
        }
    }

    private static class ReflectionFactory<T extends Collection<?>> implements Factory<T>, Serializable {
        private static final long serialVersionUID = 2986114157496788874L;
        private final Class<T> clazz;

        public ReflectionFactory(Class<T> cls) {
            this.clazz = cls;
        }

        @Override // org.apache.commons.collections4.Factory
        public T create() {
            try {
                return this.clazz.newInstance();
            } catch (Exception e) {
                throw new FunctorException("Cannot instantiate class: " + this.clazz, e);
            }
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            Class<T> cls = this.clazz;
            if (cls != null && !Collection.class.isAssignableFrom(cls)) {
                throw new UnsupportedOperationException();
            }
        }
    }
}
