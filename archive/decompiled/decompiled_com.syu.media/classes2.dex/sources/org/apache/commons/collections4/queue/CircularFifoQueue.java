package org.apache.commons.collections4.queue;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import org.apache.commons.collections4.BoundedCollection;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CircularFifoQueue<E> extends AbstractCollection<E> implements Queue<E>, BoundedCollection<E>, Serializable {
    private static final long serialVersionUID = -8423413834657610406L;
    private transient E[] elements;
    private transient int end;
    private transient boolean full;
    private final int maxElements;
    private transient int start;

    @Override // org.apache.commons.collections4.BoundedCollection
    public boolean isFull() {
        return false;
    }

    public CircularFifoQueue() {
        this(32);
    }

    public CircularFifoQueue(int i) {
        this.start = 0;
        this.end = 0;
        this.full = false;
        if (i <= 0) {
            throw new IllegalArgumentException("The size must be greater than 0");
        }
        E[] eArr = (E[]) new Object[i];
        this.elements = eArr;
        this.maxElements = eArr.length;
    }

    public CircularFifoQueue(Collection<? extends E> collection) {
        this(collection.size());
        addAll(collection);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.elements = (E[]) new Object[this.maxElements];
        int i = objectInputStream.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            ((E[]) this.elements)[i2] = objectInputStream.readObject();
        }
        this.start = 0;
        boolean z = i == this.maxElements;
        this.full = z;
        if (z) {
            this.end = 0;
        } else {
            this.end = i;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        int i = this.end;
        int i2 = this.start;
        if (i < i2) {
            return (this.maxElements - i2) + i;
        }
        if (i == i2) {
            return this.full ? this.maxElements : 0;
        }
        return i - i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isAtFullCapacity() {
        return size() == this.maxElements;
    }

    @Override // org.apache.commons.collections4.BoundedCollection
    public int maxSize() {
        return this.maxElements;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.full = false;
        this.start = 0;
        this.end = 0;
        Arrays.fill(this.elements, (Object) null);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException("Attempted to add null object to queue");
        }
        if (isAtFullCapacity()) {
            remove();
        }
        E[] eArr = this.elements;
        int i = this.end;
        int i2 = i + 1;
        this.end = i2;
        eArr[i] = e;
        if (i2 >= this.maxElements) {
            this.end = 0;
        }
        if (this.end == this.start) {
            this.full = true;
        }
        return true;
    }

    public E get(int i) {
        int size = size();
        if (i < 0 || i >= size) {
            throw new NoSuchElementException(String.format("The specified index (%1$d) is outside the available range [0, %2$d)", Integer.valueOf(i), Integer.valueOf(size)));
        }
        return this.elements[(this.start + i) % this.maxElements];
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        return add(e);
    }

    @Override // java.util.Queue
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return remove();
    }

    @Override // java.util.Queue
    public E element() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return peek();
    }

    @Override // java.util.Queue
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return this.elements[this.start];
    }

    @Override // java.util.Queue
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        E[] eArr = this.elements;
        int i = this.start;
        E e = eArr[i];
        if (e != null) {
            int i2 = i + 1;
            this.start = i2;
            eArr[i] = null;
            if (i2 >= this.maxElements) {
                this.start = 0;
            }
            this.full = false;
        }
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int increment(int i) {
        int i2 = i + 1;
        if (i2 >= this.maxElements) {
            return 0;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int decrement(int i) {
        int i2 = i - 1;
        return i2 < 0 ? this.maxElements - 1 : i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new Iterator<E>() { // from class: org.apache.commons.collections4.queue.CircularFifoQueue.1
            private int index;
            private boolean isFirst;
            private int lastReturnedIndex = -1;

            {
                this.index = CircularFifoQueue.this.start;
                this.isFirst = CircularFifoQueue.this.full;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.isFirst || this.index != CircularFifoQueue.this.end;
            }

            @Override // java.util.Iterator
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.isFirst = false;
                int i = this.index;
                this.lastReturnedIndex = i;
                this.index = CircularFifoQueue.this.increment(i);
                return (E) CircularFifoQueue.this.elements[this.lastReturnedIndex];
            }

            @Override // java.util.Iterator
            public void remove() {
                int i = this.lastReturnedIndex;
                if (i != -1) {
                    if (i == CircularFifoQueue.this.start) {
                        CircularFifoQueue.this.remove();
                        this.lastReturnedIndex = -1;
                        return;
                    }
                    int iIncrement = this.lastReturnedIndex + 1;
                    if (CircularFifoQueue.this.start >= this.lastReturnedIndex || iIncrement >= CircularFifoQueue.this.end) {
                        while (iIncrement != CircularFifoQueue.this.end) {
                            if (iIncrement >= CircularFifoQueue.this.maxElements) {
                                CircularFifoQueue.this.elements[iIncrement - 1] = CircularFifoQueue.this.elements[0];
                                iIncrement = 0;
                            } else {
                                CircularFifoQueue.this.elements[CircularFifoQueue.this.decrement(iIncrement)] = CircularFifoQueue.this.elements[iIncrement];
                                iIncrement = CircularFifoQueue.this.increment(iIncrement);
                            }
                        }
                    } else {
                        System.arraycopy(CircularFifoQueue.this.elements, iIncrement, CircularFifoQueue.this.elements, this.lastReturnedIndex, CircularFifoQueue.this.end - iIncrement);
                    }
                    this.lastReturnedIndex = -1;
                    CircularFifoQueue circularFifoQueue = CircularFifoQueue.this;
                    circularFifoQueue.end = circularFifoQueue.decrement(circularFifoQueue.end);
                    CircularFifoQueue.this.elements[CircularFifoQueue.this.end] = null;
                    CircularFifoQueue.this.full = false;
                    this.index = CircularFifoQueue.this.decrement(this.index);
                    return;
                }
                throw new IllegalStateException();
            }
        };
    }
}
