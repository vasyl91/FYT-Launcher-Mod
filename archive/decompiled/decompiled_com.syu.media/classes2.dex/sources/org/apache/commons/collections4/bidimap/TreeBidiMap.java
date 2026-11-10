package org.apache.commons.collections4.bidimap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.AbstractSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.OrderedBidiMap;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedMapIterator;
import org.apache.commons.collections4.keyvalue.UnmodifiableMapEntry;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class TreeBidiMap<K extends Comparable<K>, V extends Comparable<V>> implements OrderedBidiMap<K, V>, Serializable {
    private static final long serialVersionUID = 721969328361807L;
    private transient Set<Map.Entry<K, V>> entrySet;
    private transient TreeBidiMap<K, V>.Inverse inverse;
    private transient Set<K> keySet;
    private transient int modifications;
    private transient int nodeCount;
    private transient Node<K, V>[] rootNode;
    private transient Set<V> valuesSet;

    enum DataElement {
        KEY("key"),
        VALUE("value");

        private final String description;

        DataElement(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }
    }

    public TreeBidiMap() {
        this.nodeCount = 0;
        this.modifications = 0;
        this.inverse = null;
        this.rootNode = new Node[2];
    }

    public TreeBidiMap(Map<? extends K, ? extends V> map) {
        this();
        putAll(map);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public int size() {
        return this.nodeCount;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean isEmpty() {
        return this.nodeCount == 0;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsKey(Object obj) {
        checkKey(obj);
        return lookupKey(obj) != null;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsValue(Object obj) {
        checkValue(obj);
        return lookupValue(obj) != null;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V get(Object obj) {
        checkKey(obj);
        Node<K, V> nodeLookupKey = lookupKey(obj);
        if (nodeLookupKey == null) {
            return null;
        }
        return (V) nodeLookupKey.getValue();
    }

    @Override // org.apache.commons.collections4.BidiMap, java.util.Map, org.apache.commons.collections4.Put
    public V put(K k, V v) {
        V v2 = (V) get((Object) k);
        doPut(k, v);
        return v2;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put((Comparable) entry.getKey(), (Comparable) entry.getValue());
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V remove(Object obj) {
        return (V) doRemoveKey(obj);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        modify();
        this.nodeCount = 0;
        this.rootNode[DataElement.KEY.ordinal()] = null;
        this.rootNode[DataElement.VALUE.ordinal()] = null;
    }

    @Override // org.apache.commons.collections4.BidiMap
    public K getKey(Object obj) {
        checkValue(obj);
        Node<K, V> nodeLookupValue = lookupValue(obj);
        if (nodeLookupValue == null) {
            return null;
        }
        return (K) nodeLookupValue.getKey();
    }

    @Override // org.apache.commons.collections4.BidiMap
    public K removeValue(Object obj) {
        return (K) doRemoveValue(obj);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        if (this.nodeCount == 0) {
            throw new NoSuchElementException("Map is empty");
        }
        return (K) leastNode(this.rootNode[DataElement.KEY.ordinal()], DataElement.KEY).getKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        if (this.nodeCount == 0) {
            throw new NoSuchElementException("Map is empty");
        }
        return (K) greatestNode(this.rootNode[DataElement.KEY.ordinal()], DataElement.KEY).getKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(K k) {
        checkKey(k);
        Node<K, V> nodeNextGreater = nextGreater(lookupKey(k), DataElement.KEY);
        if (nodeNextGreater == null) {
            return null;
        }
        return (K) nodeNextGreater.getKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(K k) {
        checkKey(k);
        Node<K, V> nodeNextSmaller = nextSmaller(lookupKey(k), DataElement.KEY);
        if (nodeNextSmaller == null) {
            return null;
        }
        return (K) nodeNextSmaller.getKey();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Set<K> keySet() {
        if (this.keySet == null) {
            this.keySet = new KeyView(DataElement.KEY);
        }
        return this.keySet;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Set<V> values() {
        if (this.valuesSet == null) {
            this.valuesSet = new ValueView(DataElement.KEY);
        }
        return this.valuesSet;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new EntryView();
        }
        return this.entrySet;
    }

    @Override // org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        if (isEmpty()) {
            return EmptyOrderedMapIterator.emptyOrderedMapIterator();
        }
        return new ViewMapIterator(DataElement.KEY);
    }

    @Override // org.apache.commons.collections4.BidiMap
    public OrderedBidiMap<V, K> inverseBidiMap() {
        if (this.inverse == null) {
            this.inverse = new Inverse();
        }
        return this.inverse;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return doEquals(obj, DataElement.KEY);
    }

    @Override // java.util.Map
    public int hashCode() {
        return doHashCode(DataElement.KEY);
    }

    public String toString() {
        return doToString(DataElement.KEY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPut(K k, V v) {
        checkKeyAndValue(k, v);
        doRemoveKey(k);
        doRemoveValue(v);
        Node<K, V> left = this.rootNode[DataElement.KEY.ordinal()];
        if (left == null) {
            Node<K, V> node = new Node<>(k, v);
            this.rootNode[DataElement.KEY.ordinal()] = node;
            this.rootNode[DataElement.VALUE.ordinal()] = node;
            grow();
            return;
        }
        while (true) {
            int iCompare = compare(k, left.getKey());
            if (iCompare == 0) {
                throw new IllegalArgumentException("Cannot store a duplicate key (\"" + k + "\") in this Map");
            }
            if (iCompare < 0) {
                if (left.getLeft(DataElement.KEY) == null) {
                    Node<K, V> node2 = new Node<>(k, v);
                    insertValue(node2);
                    left.setLeft(node2, DataElement.KEY);
                    node2.setParent(left, DataElement.KEY);
                    doRedBlackInsert(node2, DataElement.KEY);
                    grow();
                    return;
                }
                left = left.getLeft(DataElement.KEY);
            } else {
                if (left.getRight(DataElement.KEY) == null) {
                    Node<K, V> node3 = new Node<>(k, v);
                    insertValue(node3);
                    left.setRight(node3, DataElement.KEY);
                    node3.setParent(left, DataElement.KEY);
                    doRedBlackInsert(node3, DataElement.KEY);
                    grow();
                    return;
                }
                left = left.getRight(DataElement.KEY);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V doRemoveKey(Object obj) {
        Node<K, V> nodeLookupKey = lookupKey(obj);
        if (nodeLookupKey == null) {
            return null;
        }
        doRedBlackDelete(nodeLookupKey);
        return (V) nodeLookupKey.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public K doRemoveValue(Object obj) {
        Node<K, V> nodeLookupValue = lookupValue(obj);
        if (nodeLookupValue == null) {
            return null;
        }
        doRedBlackDelete(nodeLookupValue);
        return (K) nodeLookupValue.getKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends Comparable<T>> Node<K, V> lookup(Object obj, DataElement dataElement) {
        Node<K, V> left = this.rootNode[dataElement.ordinal()];
        while (left != null) {
            int iCompare = compare((Comparable) obj, (Comparable) left.getData(dataElement));
            if (iCompare == 0) {
                return left;
            }
            left = iCompare < 0 ? left.getLeft(dataElement) : left.getRight(dataElement);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Node<K, V> lookupKey(Object obj) {
        return lookup(obj, DataElement.KEY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Node<K, V> lookupValue(Object obj) {
        return lookup(obj, DataElement.VALUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Node<K, V> nextGreater(Node<K, V> node, DataElement dataElement) {
        if (node == null) {
            return null;
        }
        if (node.getRight(dataElement) != null) {
            return leastNode(node.getRight(dataElement), dataElement);
        }
        Node<K, V> parent = node.getParent(dataElement);
        while (true) {
            Node<K, V> node2 = parent;
            Node<K, V> node3 = node;
            node = node2;
            if (node == null || node3 != node.getRight(dataElement)) {
                return node;
            }
            parent = node.getParent(dataElement);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Node<K, V> nextSmaller(Node<K, V> node, DataElement dataElement) {
        if (node == null) {
            return null;
        }
        if (node.getLeft(dataElement) != null) {
            return greatestNode(node.getLeft(dataElement), dataElement);
        }
        Node<K, V> parent = node.getParent(dataElement);
        while (true) {
            Node<K, V> node2 = parent;
            Node<K, V> node3 = node;
            node = node2;
            if (node == null || node3 != node.getLeft(dataElement)) {
                return node;
            }
            parent = node.getParent(dataElement);
        }
    }

    private static <T extends Comparable<T>> int compare(T t, T t2) {
        return t.compareTo(t2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Node<K, V> leastNode(Node<K, V> node, DataElement dataElement) {
        if (node != null) {
            while (node.getLeft(dataElement) != null) {
                node = node.getLeft(dataElement);
            }
        }
        return node;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Node<K, V> greatestNode(Node<K, V> node, DataElement dataElement) {
        if (node != null) {
            while (node.getRight(dataElement) != null) {
                node = node.getRight(dataElement);
            }
        }
        return node;
    }

    private void copyColor(Node<K, V> node, Node<K, V> node2, DataElement dataElement) {
        if (node2 != null) {
            if (node == null) {
                node2.setBlack(dataElement);
            } else {
                node2.copyColor(node, dataElement);
            }
        }
    }

    private static boolean isRed(Node<?, ?> node, DataElement dataElement) {
        return node != null && node.isRed(dataElement);
    }

    private static boolean isBlack(Node<?, ?> node, DataElement dataElement) {
        return node == null || node.isBlack(dataElement);
    }

    private static void makeRed(Node<?, ?> node, DataElement dataElement) {
        if (node != null) {
            node.setRed(dataElement);
        }
    }

    private static void makeBlack(Node<?, ?> node, DataElement dataElement) {
        if (node != null) {
            node.setBlack(dataElement);
        }
    }

    private Node<K, V> getGrandParent(Node<K, V> node, DataElement dataElement) {
        return getParent(getParent(node, dataElement), dataElement);
    }

    private Node<K, V> getParent(Node<K, V> node, DataElement dataElement) {
        if (node == null) {
            return null;
        }
        return node.getParent(dataElement);
    }

    private Node<K, V> getRightChild(Node<K, V> node, DataElement dataElement) {
        if (node == null) {
            return null;
        }
        return node.getRight(dataElement);
    }

    private Node<K, V> getLeftChild(Node<K, V> node, DataElement dataElement) {
        if (node == null) {
            return null;
        }
        return node.getLeft(dataElement);
    }

    private void rotateLeft(Node<K, V> node, DataElement dataElement) {
        Node<K, V> right = node.getRight(dataElement);
        node.setRight(right.getLeft(dataElement), dataElement);
        if (right.getLeft(dataElement) != null) {
            right.getLeft(dataElement).setParent(node, dataElement);
        }
        right.setParent(node.getParent(dataElement), dataElement);
        if (node.getParent(dataElement) == null) {
            this.rootNode[dataElement.ordinal()] = right;
        } else if (node.getParent(dataElement).getLeft(dataElement) == node) {
            node.getParent(dataElement).setLeft(right, dataElement);
        } else {
            node.getParent(dataElement).setRight(right, dataElement);
        }
        right.setLeft(node, dataElement);
        node.setParent(right, dataElement);
    }

    private void rotateRight(Node<K, V> node, DataElement dataElement) {
        Node<K, V> left = node.getLeft(dataElement);
        node.setLeft(left.getRight(dataElement), dataElement);
        if (left.getRight(dataElement) != null) {
            left.getRight(dataElement).setParent(node, dataElement);
        }
        left.setParent(node.getParent(dataElement), dataElement);
        if (node.getParent(dataElement) == null) {
            this.rootNode[dataElement.ordinal()] = left;
        } else if (node.getParent(dataElement).getRight(dataElement) == node) {
            node.getParent(dataElement).setRight(left, dataElement);
        } else {
            node.getParent(dataElement).setLeft(left, dataElement);
        }
        left.setRight(node, dataElement);
        node.setParent(left, dataElement);
    }

    private void doRedBlackInsert(Node<K, V> node, DataElement dataElement) {
        makeRed(node, dataElement);
        while (node != null && node != this.rootNode[dataElement.ordinal()] && isRed(node.getParent(dataElement), dataElement)) {
            if (node.isLeftChild(dataElement)) {
                Node<K, V> rightChild = getRightChild(getGrandParent(node, dataElement), dataElement);
                if (isRed(rightChild, dataElement)) {
                    makeBlack(getParent(node, dataElement), dataElement);
                    makeBlack(rightChild, dataElement);
                    makeRed(getGrandParent(node, dataElement), dataElement);
                    node = getGrandParent(node, dataElement);
                } else {
                    if (node.isRightChild(dataElement)) {
                        node = getParent(node, dataElement);
                        rotateLeft(node, dataElement);
                    }
                    makeBlack(getParent(node, dataElement), dataElement);
                    makeRed(getGrandParent(node, dataElement), dataElement);
                    if (getGrandParent(node, dataElement) != null) {
                        rotateRight(getGrandParent(node, dataElement), dataElement);
                    }
                }
            } else {
                Node<K, V> leftChild = getLeftChild(getGrandParent(node, dataElement), dataElement);
                if (isRed(leftChild, dataElement)) {
                    makeBlack(getParent(node, dataElement), dataElement);
                    makeBlack(leftChild, dataElement);
                    makeRed(getGrandParent(node, dataElement), dataElement);
                    node = getGrandParent(node, dataElement);
                } else {
                    if (node.isLeftChild(dataElement)) {
                        node = getParent(node, dataElement);
                        rotateRight(node, dataElement);
                    }
                    makeBlack(getParent(node, dataElement), dataElement);
                    makeRed(getGrandParent(node, dataElement), dataElement);
                    if (getGrandParent(node, dataElement) != null) {
                        rotateLeft(getGrandParent(node, dataElement), dataElement);
                    }
                }
            }
        }
        makeBlack(this.rootNode[dataElement.ordinal()], dataElement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRedBlackDelete(Node<K, V> node) {
        for (DataElement dataElement : DataElement.values()) {
            if (node.getLeft(dataElement) != null && node.getRight(dataElement) != null) {
                swapPosition(nextGreater(node, dataElement), node, dataElement);
            }
            Node<K, V> left = node.getLeft(dataElement) != null ? node.getLeft(dataElement) : node.getRight(dataElement);
            if (left != null) {
                left.setParent(node.getParent(dataElement), dataElement);
                if (node.getParent(dataElement) == null) {
                    this.rootNode[dataElement.ordinal()] = left;
                } else if (node == node.getParent(dataElement).getLeft(dataElement)) {
                    node.getParent(dataElement).setLeft(left, dataElement);
                } else {
                    node.getParent(dataElement).setRight(left, dataElement);
                }
                node.setLeft(null, dataElement);
                node.setRight(null, dataElement);
                node.setParent(null, dataElement);
                if (isBlack(node, dataElement)) {
                    doRedBlackDeleteFixup(left, dataElement);
                }
            } else if (node.getParent(dataElement) == null) {
                this.rootNode[dataElement.ordinal()] = null;
            } else {
                if (isBlack(node, dataElement)) {
                    doRedBlackDeleteFixup(node, dataElement);
                }
                if (node.getParent(dataElement) != null) {
                    if (node == node.getParent(dataElement).getLeft(dataElement)) {
                        node.getParent(dataElement).setLeft(null, dataElement);
                    } else {
                        node.getParent(dataElement).setRight(null, dataElement);
                    }
                    node.setParent(null, dataElement);
                }
            }
        }
        shrink();
    }

    private void doRedBlackDeleteFixup(Node<K, V> node, DataElement dataElement) {
        while (node != this.rootNode[dataElement.ordinal()] && isBlack(node, dataElement)) {
            if (node.isLeftChild(dataElement)) {
                Node<K, V> rightChild = getRightChild(getParent(node, dataElement), dataElement);
                if (isRed(rightChild, dataElement)) {
                    makeBlack(rightChild, dataElement);
                    makeRed(getParent(node, dataElement), dataElement);
                    rotateLeft(getParent(node, dataElement), dataElement);
                    rightChild = getRightChild(getParent(node, dataElement), dataElement);
                }
                if (isBlack(getLeftChild(rightChild, dataElement), dataElement) && isBlack(getRightChild(rightChild, dataElement), dataElement)) {
                    makeRed(rightChild, dataElement);
                    node = getParent(node, dataElement);
                } else {
                    if (isBlack(getRightChild(rightChild, dataElement), dataElement)) {
                        makeBlack(getLeftChild(rightChild, dataElement), dataElement);
                        makeRed(rightChild, dataElement);
                        rotateRight(rightChild, dataElement);
                        rightChild = getRightChild(getParent(node, dataElement), dataElement);
                    }
                    copyColor(getParent(node, dataElement), rightChild, dataElement);
                    makeBlack(getParent(node, dataElement), dataElement);
                    makeBlack(getRightChild(rightChild, dataElement), dataElement);
                    rotateLeft(getParent(node, dataElement), dataElement);
                    node = this.rootNode[dataElement.ordinal()];
                }
            } else {
                Node<K, V> leftChild = getLeftChild(getParent(node, dataElement), dataElement);
                if (isRed(leftChild, dataElement)) {
                    makeBlack(leftChild, dataElement);
                    makeRed(getParent(node, dataElement), dataElement);
                    rotateRight(getParent(node, dataElement), dataElement);
                    leftChild = getLeftChild(getParent(node, dataElement), dataElement);
                }
                if (isBlack(getRightChild(leftChild, dataElement), dataElement) && isBlack(getLeftChild(leftChild, dataElement), dataElement)) {
                    makeRed(leftChild, dataElement);
                    node = getParent(node, dataElement);
                } else {
                    if (isBlack(getLeftChild(leftChild, dataElement), dataElement)) {
                        makeBlack(getRightChild(leftChild, dataElement), dataElement);
                        makeRed(leftChild, dataElement);
                        rotateLeft(leftChild, dataElement);
                        leftChild = getLeftChild(getParent(node, dataElement), dataElement);
                    }
                    copyColor(getParent(node, dataElement), leftChild, dataElement);
                    makeBlack(getParent(node, dataElement), dataElement);
                    makeBlack(getLeftChild(leftChild, dataElement), dataElement);
                    rotateRight(getParent(node, dataElement), dataElement);
                    node = this.rootNode[dataElement.ordinal()];
                }
            }
        }
        makeBlack(node, dataElement);
    }

    private void swapPosition(Node<K, V> node, Node<K, V> node2, DataElement dataElement) {
        Node<K, V> parent = node.getParent(dataElement);
        Node left = node.getLeft(dataElement);
        Node right = node.getRight(dataElement);
        Node<K, V> parent2 = node2.getParent(dataElement);
        Node left2 = node2.getLeft(dataElement);
        Node right2 = node2.getRight(dataElement);
        boolean z = node.getParent(dataElement) != null && node == node.getParent(dataElement).getLeft(dataElement);
        boolean z2 = node2.getParent(dataElement) != null && node2 == node2.getParent(dataElement).getLeft(dataElement);
        if (node == parent2) {
            node.setParent(node2, dataElement);
            if (z2) {
                node2.setLeft(node, dataElement);
                node2.setRight(right, dataElement);
            } else {
                node2.setRight(node, dataElement);
                node2.setLeft(left, dataElement);
            }
        } else {
            node.setParent(parent2, dataElement);
            if (parent2 != null) {
                if (z2) {
                    parent2.setLeft(node, dataElement);
                } else {
                    parent2.setRight(node, dataElement);
                }
            }
            node2.setLeft(left, dataElement);
            node2.setRight(right, dataElement);
        }
        if (node2 == parent) {
            node2.setParent(node, dataElement);
            if (z) {
                node.setLeft(node2, dataElement);
                node.setRight(right2, dataElement);
            } else {
                node.setRight(node2, dataElement);
                node.setLeft(left2, dataElement);
            }
        } else {
            node2.setParent(parent, dataElement);
            if (parent != null) {
                if (z) {
                    parent.setLeft(node2, dataElement);
                } else {
                    parent.setRight(node2, dataElement);
                }
            }
            node.setLeft(left2, dataElement);
            node.setRight(right2, dataElement);
        }
        if (node.getLeft(dataElement) != null) {
            node.getLeft(dataElement).setParent(node, dataElement);
        }
        if (node.getRight(dataElement) != null) {
            node.getRight(dataElement).setParent(node, dataElement);
        }
        if (node2.getLeft(dataElement) != null) {
            node2.getLeft(dataElement).setParent(node2, dataElement);
        }
        if (node2.getRight(dataElement) != null) {
            node2.getRight(dataElement).setParent(node2, dataElement);
        }
        node.swapColors(node2, dataElement);
        if (this.rootNode[dataElement.ordinal()] == node) {
            this.rootNode[dataElement.ordinal()] = node2;
        } else if (this.rootNode[dataElement.ordinal()] == node2) {
            this.rootNode[dataElement.ordinal()] = node;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkNonNullComparable(Object obj, DataElement dataElement) {
        if (obj == null) {
            throw new NullPointerException(dataElement + " cannot be null");
        }
        if (!(obj instanceof Comparable)) {
            throw new ClassCastException(dataElement + " must be Comparable");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkKey(Object obj) {
        checkNonNullComparable(obj, DataElement.KEY);
    }

    private static void checkValue(Object obj) {
        checkNonNullComparable(obj, DataElement.VALUE);
    }

    private static void checkKeyAndValue(Object obj, Object obj2) {
        checkKey(obj);
        checkValue(obj2);
    }

    private void modify() {
        this.modifications++;
    }

    private void grow() {
        modify();
        this.nodeCount++;
    }

    private void shrink() {
        modify();
        this.nodeCount--;
    }

    private void insertValue(Node<K, V> node) throws IllegalArgumentException {
        Node<K, V> left = this.rootNode[DataElement.VALUE.ordinal()];
        while (true) {
            int iCompare = compare(node.getValue(), left.getValue());
            if (iCompare == 0) {
                throw new IllegalArgumentException("Cannot store a duplicate value (\"" + node.getData(DataElement.VALUE) + "\") in this Map");
            }
            if (iCompare < 0) {
                if (left.getLeft(DataElement.VALUE) != null) {
                    left = left.getLeft(DataElement.VALUE);
                } else {
                    left.setLeft(node, DataElement.VALUE);
                    node.setParent(left, DataElement.VALUE);
                    doRedBlackInsert(node, DataElement.VALUE);
                    return;
                }
            } else if (left.getRight(DataElement.VALUE) != null) {
                left = left.getRight(DataElement.VALUE);
            } else {
                left.setRight(node, DataElement.VALUE);
                node.setParent(left, DataElement.VALUE);
                doRedBlackInsert(node, DataElement.VALUE);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doEquals(Object obj, DataElement dataElement) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (map.size() != size()) {
            return false;
        }
        if (this.nodeCount > 0) {
            try {
                MapIterator<?, ?> mapIterator = getMapIterator(dataElement);
                while (mapIterator.hasNext()) {
                    if (!mapIterator.getValue().equals(map.get(mapIterator.next()))) {
                        return false;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int doHashCode(DataElement dataElement) {
        int iHashCode = 0;
        if (this.nodeCount > 0) {
            MapIterator<?, ?> mapIterator = getMapIterator(dataElement);
            while (mapIterator.hasNext()) {
                iHashCode += mapIterator.next().hashCode() ^ mapIterator.getValue().hashCode();
            }
        }
        return iHashCode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String doToString(DataElement dataElement) {
        if (this.nodeCount == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.nodeCount * 32);
        sb.append('{');
        MapIterator<?, ?> mapIterator = getMapIterator(dataElement);
        boolean zHasNext = mapIterator.hasNext();
        while (zHasNext) {
            Object next = mapIterator.next();
            Object value = mapIterator.getValue();
            if (next == this) {
                next = "(this Map)";
            }
            StringBuilder sbAppend = sb.append(next).append('=');
            if (value == this) {
                value = "(this Map)";
            }
            sbAppend.append(value);
            zHasNext = mapIterator.hasNext();
            if (zHasNext) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    /* JADX INFO: renamed from: org.apache.commons.collections4.bidimap.TreeBidiMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$collections4$bidimap$TreeBidiMap$DataElement;

        static {
            int[] iArr = new int[DataElement.values().length];
            $SwitchMap$org$apache$commons$collections4$bidimap$TreeBidiMap$DataElement = iArr;
            try {
                iArr[DataElement.KEY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$collections4$bidimap$TreeBidiMap$DataElement[DataElement.VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private MapIterator<?, ?> getMapIterator(DataElement dataElement) {
        int i = AnonymousClass1.$SwitchMap$org$apache$commons$collections4$bidimap$TreeBidiMap$DataElement[dataElement.ordinal()];
        if (i == 1) {
            return new ViewMapIterator(DataElement.KEY);
        }
        if (i == 2) {
            return new InverseViewMapIterator(DataElement.VALUE);
        }
        throw new IllegalArgumentException();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.rootNode = new Node[2];
        int i = objectInputStream.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            put((Comparable) objectInputStream.readObject(), (Comparable) objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    abstract class View<E> extends AbstractSet<E> {
        final DataElement orderType;

        View(DataElement dataElement) {
            this.orderType = dataElement;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TreeBidiMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TreeBidiMap.this.clear();
        }
    }

    class KeyView extends TreeBidiMap<K, V>.View<K> {
        public KeyView(DataElement dataElement) {
            super(dataElement);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new ViewMapIterator(this.orderType);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            TreeBidiMap.checkNonNullComparable(obj, DataElement.KEY);
            return TreeBidiMap.this.lookupKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return TreeBidiMap.this.doRemoveKey(obj) != null;
        }
    }

    class ValueView extends TreeBidiMap<K, V>.View<V> {
        public ValueView(DataElement dataElement) {
            super(dataElement);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new InverseViewMapIterator(this.orderType);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            TreeBidiMap.checkNonNullComparable(obj, DataElement.VALUE);
            return TreeBidiMap.this.lookupValue(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return TreeBidiMap.this.doRemoveValue(obj) != null;
        }
    }

    class EntryView extends TreeBidiMap<K, V>.View<Map.Entry<K, V>> {
        EntryView() {
            super(DataElement.KEY);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object value = entry.getValue();
            Node nodeLookupKey = TreeBidiMap.this.lookupKey(entry.getKey());
            return nodeLookupKey != null && nodeLookupKey.getValue().equals(value);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object value = entry.getValue();
            Node nodeLookupKey = TreeBidiMap.this.lookupKey(entry.getKey());
            if (nodeLookupKey == null || !nodeLookupKey.getValue().equals(value)) {
                return false;
            }
            TreeBidiMap.this.doRedBlackDelete(nodeLookupKey);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new ViewMapEntryIterator();
        }
    }

    class InverseEntryView extends TreeBidiMap<K, V>.View<Map.Entry<V, K>> {
        InverseEntryView() {
            super(DataElement.VALUE);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object value = entry.getValue();
            Node nodeLookupValue = TreeBidiMap.this.lookupValue(entry.getKey());
            return nodeLookupValue != null && nodeLookupValue.getKey().equals(value);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object value = entry.getValue();
            Node nodeLookupValue = TreeBidiMap.this.lookupValue(entry.getKey());
            if (nodeLookupValue == null || !nodeLookupValue.getKey().equals(value)) {
                return false;
            }
            TreeBidiMap.this.doRedBlackDelete(nodeLookupValue);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<V, K>> iterator() {
            return new InverseViewMapEntryIterator();
        }
    }

    abstract class ViewIterator {
        private int expectedModifications;
        private Node<K, V> nextNode;
        private final DataElement orderType;
        Node<K, V> lastReturnedNode = null;
        private Node<K, V> previousNode = null;

        ViewIterator(DataElement dataElement) {
            this.orderType = dataElement;
            this.expectedModifications = TreeBidiMap.this.modifications;
            this.nextNode = TreeBidiMap.this.leastNode(TreeBidiMap.this.rootNode[dataElement.ordinal()], dataElement);
        }

        public final boolean hasNext() {
            return this.nextNode != null;
        }

        protected Node<K, V> navigateNext() {
            if (this.nextNode != null) {
                if (TreeBidiMap.this.modifications != this.expectedModifications) {
                    throw new ConcurrentModificationException();
                }
                Node<K, V> node = this.nextNode;
                this.lastReturnedNode = node;
                this.previousNode = node;
                this.nextNode = TreeBidiMap.this.nextGreater(node, this.orderType);
                return this.lastReturnedNode;
            }
            throw new NoSuchElementException();
        }

        public boolean hasPrevious() {
            return this.previousNode != null;
        }

        protected Node<K, V> navigatePrevious() {
            if (this.previousNode != null) {
                if (TreeBidiMap.this.modifications != this.expectedModifications) {
                    throw new ConcurrentModificationException();
                }
                Node<K, V> node = this.lastReturnedNode;
                this.nextNode = node;
                if (node == null) {
                    this.nextNode = TreeBidiMap.this.nextGreater(this.previousNode, this.orderType);
                }
                Node<K, V> node2 = this.previousNode;
                this.lastReturnedNode = node2;
                this.previousNode = TreeBidiMap.this.nextSmaller(node2, this.orderType);
                return this.lastReturnedNode;
            }
            throw new NoSuchElementException();
        }

        public final void remove() {
            if (this.lastReturnedNode != null) {
                if (TreeBidiMap.this.modifications == this.expectedModifications) {
                    TreeBidiMap.this.doRedBlackDelete(this.lastReturnedNode);
                    this.expectedModifications++;
                    this.lastReturnedNode = null;
                    Node<K, V> node = this.nextNode;
                    if (node != null) {
                        this.previousNode = TreeBidiMap.this.nextSmaller(node, this.orderType);
                        return;
                    } else {
                        TreeBidiMap treeBidiMap = TreeBidiMap.this;
                        this.previousNode = treeBidiMap.greatestNode(treeBidiMap.rootNode[this.orderType.ordinal()], this.orderType);
                        return;
                    }
                }
                throw new ConcurrentModificationException();
            }
            throw new IllegalStateException();
        }
    }

    class ViewMapIterator extends TreeBidiMap<K, V>.ViewIterator implements OrderedMapIterator<K, V> {
        ViewMapIterator(DataElement dataElement) {
            super(dataElement);
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getKey() {
            if (this.lastReturnedNode == null) {
                throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
            }
            return (K) this.lastReturnedNode.getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            if (this.lastReturnedNode == null) {
                throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
            }
            return (V) this.lastReturnedNode.getValue();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V setValue(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            return (K) navigateNext().getKey();
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public K previous() {
            return (K) navigatePrevious().getKey();
        }
    }

    class InverseViewMapIterator extends TreeBidiMap<K, V>.ViewIterator implements OrderedMapIterator<V, K> {
        public InverseViewMapIterator(DataElement dataElement) {
            super(dataElement);
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getKey() {
            if (this.lastReturnedNode == null) {
                throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
            }
            return (V) this.lastReturnedNode.getValue();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getValue() {
            if (this.lastReturnedNode == null) {
                throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
            }
            return (K) this.lastReturnedNode.getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K setValue(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public V next() {
            return (V) navigateNext().getValue();
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public V previous() {
            return (V) navigatePrevious().getValue();
        }
    }

    class ViewMapEntryIterator extends TreeBidiMap<K, V>.ViewIterator implements OrderedIterator<Map.Entry<K, V>> {
        ViewMapEntryIterator() {
            super(DataElement.KEY);
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return navigateNext();
        }

        @Override // org.apache.commons.collections4.OrderedIterator
        public Map.Entry<K, V> previous() {
            return navigatePrevious();
        }
    }

    class InverseViewMapEntryIterator extends TreeBidiMap<K, V>.ViewIterator implements OrderedIterator<Map.Entry<V, K>> {
        InverseViewMapEntryIterator() {
            super(DataElement.VALUE);
        }

        @Override // java.util.Iterator
        public Map.Entry<V, K> next() {
            return createEntry(navigateNext());
        }

        @Override // org.apache.commons.collections4.OrderedIterator
        public Map.Entry<V, K> previous() {
            return createEntry(navigatePrevious());
        }

        private Map.Entry<V, K> createEntry(Node<K, V> node) {
            return new UnmodifiableMapEntry(node.getValue(), node.getKey());
        }
    }

    static class Node<K extends Comparable<K>, V extends Comparable<V>> implements Map.Entry<K, V>, KeyValue<K, V> {
        private int hashcodeValue;
        private final K key;
        private final V value;
        private final Node<K, V>[] leftNode = new Node[2];
        private final Node<K, V>[] rightNode = new Node[2];
        private final Node<K, V>[] parentNode = new Node[2];
        private final boolean[] blackColor = {true, true};
        private boolean calculatedHashCode = false;

        Node(K k, V v) {
            this.key = k;
            this.value = v;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object getData(DataElement dataElement) {
            int i = AnonymousClass1.$SwitchMap$org$apache$commons$collections4$bidimap$TreeBidiMap$DataElement[dataElement.ordinal()];
            if (i == 1) {
                return getKey();
            }
            if (i == 2) {
                return getValue();
            }
            throw new IllegalArgumentException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLeft(Node<K, V> node, DataElement dataElement) {
            this.leftNode[dataElement.ordinal()] = node;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Node<K, V> getLeft(DataElement dataElement) {
            return this.leftNode[dataElement.ordinal()];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRight(Node<K, V> node, DataElement dataElement) {
            this.rightNode[dataElement.ordinal()] = node;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Node<K, V> getRight(DataElement dataElement) {
            return this.rightNode[dataElement.ordinal()];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setParent(Node<K, V> node, DataElement dataElement) {
            this.parentNode[dataElement.ordinal()] = node;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Node<K, V> getParent(DataElement dataElement) {
            return this.parentNode[dataElement.ordinal()];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void swapColors(Node<K, V> node, DataElement dataElement) {
            boolean[] zArr = this.blackColor;
            int iOrdinal = dataElement.ordinal();
            zArr[iOrdinal] = zArr[iOrdinal] ^ node.blackColor[dataElement.ordinal()];
            boolean[] zArr2 = node.blackColor;
            int iOrdinal2 = dataElement.ordinal();
            zArr2[iOrdinal2] = zArr2[iOrdinal2] ^ this.blackColor[dataElement.ordinal()];
            boolean[] zArr3 = this.blackColor;
            int iOrdinal3 = dataElement.ordinal();
            zArr3[iOrdinal3] = node.blackColor[dataElement.ordinal()] ^ zArr3[iOrdinal3];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isBlack(DataElement dataElement) {
            return this.blackColor[dataElement.ordinal()];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isRed(DataElement dataElement) {
            return !this.blackColor[dataElement.ordinal()];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBlack(DataElement dataElement) {
            this.blackColor[dataElement.ordinal()] = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRed(DataElement dataElement) {
            this.blackColor[dataElement.ordinal()] = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void copyColor(Node<K, V> node, DataElement dataElement) {
            this.blackColor[dataElement.ordinal()] = node.blackColor[dataElement.ordinal()];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isLeftChild(DataElement dataElement) {
            return this.parentNode[dataElement.ordinal()] != null && this.parentNode[dataElement.ordinal()].leftNode[dataElement.ordinal()] == this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isRightChild(DataElement dataElement) {
            return this.parentNode[dataElement.ordinal()] != null && this.parentNode[dataElement.ordinal()].rightNode[dataElement.ordinal()] == this;
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Map.Entry.setValue is not supported");
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return getKey().equals(entry.getKey()) && getValue().equals(entry.getValue());
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.calculatedHashCode) {
                this.hashcodeValue = getKey().hashCode() ^ getValue().hashCode();
                this.calculatedHashCode = true;
            }
            return this.hashcodeValue;
        }
    }

    class Inverse implements OrderedBidiMap<V, K> {
        private Set<Map.Entry<V, K>> inverseEntrySet;
        private Set<V> inverseKeySet;
        private Set<K> inverseValuesSet;

        Inverse() {
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public int size() {
            return TreeBidiMap.this.size();
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public boolean isEmpty() {
            return TreeBidiMap.this.isEmpty();
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public K get(Object obj) {
            return (K) TreeBidiMap.this.getKey(obj);
        }

        @Override // org.apache.commons.collections4.BidiMap
        public V getKey(Object obj) {
            return (V) TreeBidiMap.this.get(obj);
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public boolean containsKey(Object obj) {
            return TreeBidiMap.this.containsValue(obj);
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public boolean containsValue(Object obj) {
            return TreeBidiMap.this.containsKey(obj);
        }

        @Override // org.apache.commons.collections4.OrderedMap
        public V firstKey() {
            if (TreeBidiMap.this.nodeCount == 0) {
                throw new NoSuchElementException("Map is empty");
            }
            TreeBidiMap treeBidiMap = TreeBidiMap.this;
            return (V) treeBidiMap.leastNode(treeBidiMap.rootNode[DataElement.VALUE.ordinal()], DataElement.VALUE).getValue();
        }

        @Override // org.apache.commons.collections4.OrderedMap
        public V lastKey() {
            if (TreeBidiMap.this.nodeCount == 0) {
                throw new NoSuchElementException("Map is empty");
            }
            TreeBidiMap treeBidiMap = TreeBidiMap.this;
            return (V) treeBidiMap.greatestNode(treeBidiMap.rootNode[DataElement.VALUE.ordinal()], DataElement.VALUE).getValue();
        }

        @Override // org.apache.commons.collections4.OrderedMap
        public V nextKey(V v) {
            TreeBidiMap.checkKey(v);
            TreeBidiMap treeBidiMap = TreeBidiMap.this;
            Node nodeNextGreater = treeBidiMap.nextGreater(treeBidiMap.lookup(v, DataElement.VALUE), DataElement.VALUE);
            if (nodeNextGreater == null) {
                return null;
            }
            return (V) nodeNextGreater.getValue();
        }

        @Override // org.apache.commons.collections4.OrderedMap
        public V previousKey(V v) {
            TreeBidiMap.checkKey(v);
            TreeBidiMap treeBidiMap = TreeBidiMap.this;
            Node nodeNextSmaller = treeBidiMap.nextSmaller(treeBidiMap.lookup(v, DataElement.VALUE), DataElement.VALUE);
            if (nodeNextSmaller == null) {
                return null;
            }
            return (V) nodeNextSmaller.getValue();
        }

        @Override // org.apache.commons.collections4.BidiMap, java.util.Map, org.apache.commons.collections4.Put
        public K put(V v, K k) {
            K k2 = (K) get((Object) v);
            TreeBidiMap.this.doPut(k, v);
            return k2;
        }

        @Override // java.util.Map, org.apache.commons.collections4.Put
        public void putAll(Map<? extends V, ? extends K> map) {
            for (Map.Entry<? extends V, ? extends K> entry : map.entrySet()) {
                put((Comparable) entry.getKey(), (Comparable) entry.getValue());
            }
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public K remove(Object obj) {
            return (K) TreeBidiMap.this.removeValue(obj);
        }

        @Override // org.apache.commons.collections4.BidiMap
        public V removeValue(Object obj) {
            return (V) TreeBidiMap.this.remove(obj);
        }

        @Override // java.util.Map, org.apache.commons.collections4.Put
        public void clear() {
            TreeBidiMap.this.clear();
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public Set<V> keySet() {
            if (this.inverseKeySet == null) {
                this.inverseKeySet = new ValueView(DataElement.VALUE);
            }
            return this.inverseKeySet;
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public Set<K> values() {
            if (this.inverseValuesSet == null) {
                this.inverseValuesSet = new KeyView(DataElement.VALUE);
            }
            return this.inverseValuesSet;
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public Set<Map.Entry<V, K>> entrySet() {
            if (this.inverseEntrySet == null) {
                this.inverseEntrySet = new InverseEntryView();
            }
            return this.inverseEntrySet;
        }

        @Override // org.apache.commons.collections4.IterableGet
        public OrderedMapIterator<V, K> mapIterator() {
            if (isEmpty()) {
                return EmptyOrderedMapIterator.emptyOrderedMapIterator();
            }
            return new InverseViewMapIterator(DataElement.VALUE);
        }

        @Override // org.apache.commons.collections4.BidiMap
        public OrderedBidiMap<K, V> inverseBidiMap() {
            return TreeBidiMap.this;
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            return TreeBidiMap.this.doEquals(obj, DataElement.VALUE);
        }

        @Override // java.util.Map
        public int hashCode() {
            return TreeBidiMap.this.doHashCode(DataElement.VALUE);
        }

        public String toString() {
            return TreeBidiMap.this.doToString(DataElement.VALUE);
        }
    }
}
