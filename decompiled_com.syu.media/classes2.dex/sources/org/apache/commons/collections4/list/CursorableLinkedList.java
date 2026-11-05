package org.apache.commons.collections4.list;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CursorableLinkedList<E> extends AbstractLinkedList<E> implements Serializable {
    private static final long serialVersionUID = 8836393098519411393L;
    private transient List<WeakReference<Cursor<E>>> cursors;

    public CursorableLinkedList() {
        init();
    }

    public CursorableLinkedList(Collection<? extends E> collection) {
        super(collection);
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList
    protected void init() {
        super.init();
        this.cursors = new ArrayList();
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList, java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return super.listIterator(0);
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList, java.util.List
    public ListIterator<E> listIterator() {
        return cursor(0);
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList, java.util.List
    public ListIterator<E> listIterator(int i) {
        return cursor(i);
    }

    public Cursor<E> cursor() {
        return cursor(0);
    }

    public Cursor<E> cursor(int i) {
        Cursor<E> cursor = new Cursor<>(this, i);
        registerCursor(cursor);
        return cursor;
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList
    protected void updateNode(AbstractLinkedList.Node<E> node, E e) {
        super.updateNode(node, e);
        broadcastNodeChanged(node);
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList
    protected void addNode(AbstractLinkedList.Node<E> node, AbstractLinkedList.Node<E> node2) {
        super.addNode(node, node2);
        broadcastNodeInserted(node);
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList
    protected void removeNode(AbstractLinkedList.Node<E> node) {
        super.removeNode(node);
        broadcastNodeRemoved(node);
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList
    protected void removeAllNodes() {
        if (size() > 0) {
            Iterator<E> it = iterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
        }
    }

    protected void registerCursor(Cursor<E> cursor) {
        Iterator<WeakReference<Cursor<E>>> it = this.cursors.iterator();
        while (it.hasNext()) {
            if (it.next().get() == null) {
                it.remove();
            }
        }
        this.cursors.add(new WeakReference<>(cursor));
    }

    protected void unregisterCursor(Cursor<E> cursor) {
        Iterator<WeakReference<Cursor<E>>> it = this.cursors.iterator();
        while (it.hasNext()) {
            WeakReference<Cursor<E>> next = it.next();
            Cursor<E> cursor2 = next.get();
            if (cursor2 == null) {
                it.remove();
            } else if (cursor2 == cursor) {
                next.clear();
                it.remove();
                return;
            }
        }
    }

    protected void broadcastNodeChanged(AbstractLinkedList.Node<E> node) {
        Iterator<WeakReference<Cursor<E>>> it = this.cursors.iterator();
        while (it.hasNext()) {
            Cursor<E> cursor = it.next().get();
            if (cursor == null) {
                it.remove();
            } else {
                cursor.nodeChanged(node);
            }
        }
    }

    protected void broadcastNodeRemoved(AbstractLinkedList.Node<E> node) {
        Iterator<WeakReference<Cursor<E>>> it = this.cursors.iterator();
        while (it.hasNext()) {
            Cursor<E> cursor = it.next().get();
            if (cursor == null) {
                it.remove();
            } else {
                cursor.nodeRemoved(node);
            }
        }
    }

    protected void broadcastNodeInserted(AbstractLinkedList.Node<E> node) {
        Iterator<WeakReference<Cursor<E>>> it = this.cursors.iterator();
        while (it.hasNext()) {
            Cursor<E> cursor = it.next().get();
            if (cursor == null) {
                it.remove();
            } else {
                cursor.nodeInserted(node);
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList
    protected ListIterator<E> createSubListListIterator(AbstractLinkedList.LinkedSubList<E> linkedSubList, int i) {
        SubCursor subCursor = new SubCursor(linkedSubList, i);
        registerCursor(subCursor);
        return subCursor;
    }

    public static class Cursor<E> extends AbstractLinkedList.LinkedListIterator<E> {
        boolean currentRemovedByAnother;
        boolean nextIndexValid;
        boolean valid;

        protected void nodeChanged(AbstractLinkedList.Node<E> node) {
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ boolean hasNext() {
            return super.hasNext();
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
        public /* bridge */ /* synthetic */ boolean hasPrevious() {
            return super.hasPrevious();
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return super.next();
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
        public /* bridge */ /* synthetic */ Object previous() {
            return super.previous();
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ int previousIndex() {
            return super.previousIndex();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            super.set(obj);
        }

        protected Cursor(CursorableLinkedList<E> cursorableLinkedList, int i) {
            super(cursorableLinkedList, i);
            this.nextIndexValid = true;
            this.currentRemovedByAnother = false;
            this.valid = true;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public void remove() {
            if (this.current != null || !this.currentRemovedByAnother) {
                checkModCount();
                this.parent.removeNode(getLastNodeReturned());
            }
            this.currentRemovedByAnother = false;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public void add(E e) {
            super.add(e);
            this.next = this.next.next;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public int nextIndex() {
            if (!this.nextIndexValid) {
                if (this.next == this.parent.header) {
                    this.nextIndex = this.parent.size();
                } else {
                    int i = 0;
                    for (AbstractLinkedList.Node<E> node = this.parent.header.next; node != this.next; node = node.next) {
                        i++;
                    }
                    this.nextIndex = i;
                }
                this.nextIndexValid = true;
            }
            return this.nextIndex;
        }

        protected void nodeRemoved(AbstractLinkedList.Node<E> node) {
            if (node == this.next && node == this.current) {
                this.next = node.next;
                this.current = null;
                this.currentRemovedByAnother = true;
            } else if (node == this.next) {
                this.next = node.next;
                this.currentRemovedByAnother = false;
            } else if (node == this.current) {
                this.current = null;
                this.currentRemovedByAnother = true;
                this.nextIndex--;
            } else {
                this.nextIndexValid = false;
                this.currentRemovedByAnother = false;
            }
        }

        protected void nodeInserted(AbstractLinkedList.Node<E> node) {
            if (node.previous == this.current) {
                this.next = node;
            } else if (this.next.previous == node) {
                this.next = node;
            } else {
                this.nextIndexValid = false;
            }
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator
        protected void checkModCount() {
            if (!this.valid) {
                throw new ConcurrentModificationException("Cursor closed");
            }
        }

        public void close() {
            if (this.valid) {
                ((CursorableLinkedList) this.parent).unregisterCursor(this);
                this.valid = false;
            }
        }
    }

    protected static class SubCursor<E> extends Cursor<E> {
        protected final AbstractLinkedList.LinkedSubList<E> sub;

        protected SubCursor(AbstractLinkedList.LinkedSubList<E> linkedSubList, int i) {
            super((CursorableLinkedList) linkedSubList.parent, i + linkedSubList.offset);
            this.sub = linkedSubList;
        }

        @Override // org.apache.commons.collections4.list.CursorableLinkedList.Cursor, org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return nextIndex() < this.sub.size;
        }

        @Override // org.apache.commons.collections4.list.CursorableLinkedList.Cursor, org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
        public boolean hasPrevious() {
            return previousIndex() >= 0;
        }

        @Override // org.apache.commons.collections4.list.CursorableLinkedList.Cursor, org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public int nextIndex() {
            return super.nextIndex() - this.sub.offset;
        }

        @Override // org.apache.commons.collections4.list.CursorableLinkedList.Cursor, org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public void add(E e) {
            super.add(e);
            this.sub.expectedModCount = this.parent.modCount;
            this.sub.size++;
        }

        @Override // org.apache.commons.collections4.list.CursorableLinkedList.Cursor, org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public void remove() {
            super.remove();
            this.sub.expectedModCount = this.parent.modCount;
            this.sub.size--;
        }
    }
}
