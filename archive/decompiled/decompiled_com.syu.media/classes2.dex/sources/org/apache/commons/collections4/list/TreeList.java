package org.apache.commons.collections4.list;

import java.util.AbstractList;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.OrderedIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class TreeList<E> extends AbstractList<E> {
    private AVLNode<E> root;
    private int size;

    public TreeList() {
    }

    public TreeList(Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return;
        }
        this.root = new AVLNode<>(collection);
        this.size = collection.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        checkInterval(i, 0, size() - 1);
        return this.root.get(i).getValue();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i) {
        checkInterval(i, 0, size());
        return new TreeListIterator(this, i);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        AVLNode<E> aVLNode = this.root;
        if (aVLNode == null) {
            return -1;
        }
        return aVLNode.indexOf(obj, ((AVLNode) aVLNode).relativePosition);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        AVLNode<E> aVLNode = this.root;
        if (aVLNode != null) {
            aVLNode.toArray(objArr, ((AVLNode) aVLNode).relativePosition);
        }
        return objArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        this.modCount++;
        checkInterval(i, 0, size());
        AVLNode<E> aVLNode = this.root;
        if (aVLNode == null) {
            this.root = new AVLNode<>(i, e, null, null);
        } else {
            this.root = aVLNode.insert(i, e);
        }
        this.size++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        this.modCount += collection.size();
        AVLNode<E> aVLNode = new AVLNode<>(collection);
        AVLNode<E> aVLNode2 = this.root;
        if (aVLNode2 != null) {
            aVLNode = aVLNode2.addAll(aVLNode, this.size);
        }
        this.root = aVLNode;
        this.size += collection.size();
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        checkInterval(i, 0, size() - 1);
        AVLNode<E> aVLNode = this.root.get(i);
        E e2 = (E) ((AVLNode) aVLNode).value;
        aVLNode.setValue(e);
        return e2;
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i) {
        this.modCount++;
        checkInterval(i, 0, size() - 1);
        E e = get(i);
        this.root = this.root.remove(i);
        this.size--;
        return e;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.modCount++;
        this.root = null;
        this.size = 0;
    }

    private void checkInterval(int i, int i2, int i3) {
        if (i < i2 || i > i3) {
            throw new IndexOutOfBoundsException("Invalid index:" + i + ", size=" + size());
        }
    }

    static class AVLNode<E> {
        private int height;
        private AVLNode<E> left;
        private boolean leftIsPrevious;
        private int relativePosition;
        private AVLNode<E> right;
        private boolean rightIsNext;
        private E value;

        private AVLNode(int i, E e, AVLNode<E> aVLNode, AVLNode<E> aVLNode2) {
            this.relativePosition = i;
            this.value = e;
            this.rightIsNext = true;
            this.leftIsPrevious = true;
            this.right = aVLNode;
            this.left = aVLNode2;
        }

        private AVLNode(Collection<? extends E> collection) {
            this(collection.iterator(), 0, collection.size() - 1, 0, null, null);
        }

        private AVLNode(Iterator<? extends E> it, int i, int i2, int i3, AVLNode<E> aVLNode, AVLNode<E> aVLNode2) {
            int i4 = i + ((i2 - i) / 2);
            if (i < i4) {
                this.left = new AVLNode<>(it, i, i4 - 1, i4, aVLNode, this);
            } else {
                this.leftIsPrevious = true;
                this.left = aVLNode;
            }
            this.value = it.next();
            this.relativePosition = i4 - i3;
            if (i4 < i2) {
                this.right = new AVLNode<>(it, i4 + 1, i2, i4, this, aVLNode2);
            } else {
                this.rightIsNext = true;
                this.right = aVLNode2;
            }
            recalcHeight();
        }

        E getValue() {
            return this.value;
        }

        void setValue(E e) {
            this.value = e;
        }

        AVLNode<E> get(int i) {
            int i2 = i - this.relativePosition;
            if (i2 == 0) {
                return this;
            }
            AVLNode<E> leftSubTree = i2 < 0 ? getLeftSubTree() : getRightSubTree();
            if (leftSubTree == null) {
                return null;
            }
            return leftSubTree.get(i2);
        }

        int indexOf(Object obj, int i) {
            if (getLeftSubTree() != null) {
                AVLNode<E> aVLNode = this.left;
                int iIndexOf = aVLNode.indexOf(obj, aVLNode.relativePosition + i);
                if (iIndexOf != -1) {
                    return iIndexOf;
                }
            }
            E e = this.value;
            if (e != null ? e.equals(obj) : e == obj) {
                return i;
            }
            if (getRightSubTree() == null) {
                return -1;
            }
            AVLNode<E> aVLNode2 = this.right;
            return aVLNode2.indexOf(obj, i + aVLNode2.relativePosition);
        }

        void toArray(Object[] objArr, int i) {
            objArr[i] = this.value;
            if (getLeftSubTree() != null) {
                AVLNode<E> aVLNode = this.left;
                aVLNode.toArray(objArr, aVLNode.relativePosition + i);
            }
            if (getRightSubTree() != null) {
                AVLNode<E> aVLNode2 = this.right;
                aVLNode2.toArray(objArr, i + aVLNode2.relativePosition);
            }
        }

        AVLNode<E> next() {
            AVLNode<E> aVLNode;
            if (this.rightIsNext || (aVLNode = this.right) == null) {
                return this.right;
            }
            return aVLNode.min();
        }

        AVLNode<E> previous() {
            AVLNode<E> aVLNode;
            if (this.leftIsPrevious || (aVLNode = this.left) == null) {
                return this.left;
            }
            return aVLNode.max();
        }

        AVLNode<E> insert(int i, E e) {
            int i2 = i - this.relativePosition;
            if (i2 <= 0) {
                return insertOnLeft(i2, e);
            }
            return insertOnRight(i2, e);
        }

        private AVLNode<E> insertOnLeft(int i, E e) {
            if (getLeftSubTree() == null) {
                setLeft(new AVLNode<>(-1, e, this, this.left), null);
            } else {
                setLeft(this.left.insert(i, e), null);
            }
            int i2 = this.relativePosition;
            if (i2 >= 0) {
                this.relativePosition = i2 + 1;
            }
            AVLNode<E> aVLNodeBalance = balance();
            recalcHeight();
            return aVLNodeBalance;
        }

        private AVLNode<E> insertOnRight(int i, E e) {
            if (getRightSubTree() == null) {
                setRight(new AVLNode<>(1, e, this.right, this), null);
            } else {
                setRight(this.right.insert(i, e), null);
            }
            int i2 = this.relativePosition;
            if (i2 < 0) {
                this.relativePosition = i2 - 1;
            }
            AVLNode<E> aVLNodeBalance = balance();
            recalcHeight();
            return aVLNodeBalance;
        }

        private AVLNode<E> getLeftSubTree() {
            if (this.leftIsPrevious) {
                return null;
            }
            return this.left;
        }

        private AVLNode<E> getRightSubTree() {
            if (this.rightIsNext) {
                return null;
            }
            return this.right;
        }

        private AVLNode<E> max() {
            return getRightSubTree() == null ? this : this.right.max();
        }

        private AVLNode<E> min() {
            return getLeftSubTree() == null ? this : this.left.min();
        }

        AVLNode<E> remove(int i) {
            int i2 = i - this.relativePosition;
            if (i2 == 0) {
                return removeSelf();
            }
            if (i2 > 0) {
                setRight(this.right.remove(i2), this.right.right);
                int i3 = this.relativePosition;
                if (i3 < 0) {
                    this.relativePosition = i3 + 1;
                }
            } else {
                setLeft(this.left.remove(i2), this.left.left);
                int i4 = this.relativePosition;
                if (i4 > 0) {
                    this.relativePosition = i4 - 1;
                }
            }
            recalcHeight();
            return balance();
        }

        private AVLNode<E> removeMax() {
            if (getRightSubTree() == null) {
                return removeSelf();
            }
            setRight(this.right.removeMax(), this.right.right);
            int i = this.relativePosition;
            if (i < 0) {
                this.relativePosition = i + 1;
            }
            recalcHeight();
            return balance();
        }

        private AVLNode<E> removeMin() {
            if (getLeftSubTree() == null) {
                return removeSelf();
            }
            setLeft(this.left.removeMin(), this.left.left);
            int i = this.relativePosition;
            if (i > 0) {
                this.relativePosition = i - 1;
            }
            recalcHeight();
            return balance();
        }

        private AVLNode<E> removeSelf() {
            if (getRightSubTree() == null && getLeftSubTree() == null) {
                return null;
            }
            if (getRightSubTree() == null) {
                int i = this.relativePosition;
                if (i > 0) {
                    this.left.relativePosition += i + (i <= 0 ? 1 : 0);
                }
                this.left.max().setRight(null, this.right);
                return this.left;
            }
            if (getLeftSubTree() == null) {
                AVLNode<E> aVLNode = this.right;
                int i2 = aVLNode.relativePosition;
                int i3 = this.relativePosition;
                aVLNode.relativePosition = i2 + (i3 - (i3 >= 0 ? 1 : 0));
                aVLNode.min().setLeft(null, this.left);
                return this.right;
            }
            if (heightRightMinusLeft() > 0) {
                AVLNode<E> aVLNodeMin = this.right.min();
                this.value = aVLNodeMin.value;
                if (this.leftIsPrevious) {
                    this.left = aVLNodeMin.left;
                }
                this.right = this.right.removeMin();
                int i4 = this.relativePosition;
                if (i4 < 0) {
                    this.relativePosition = i4 + 1;
                }
            } else {
                AVLNode<E> aVLNodeMax = this.left.max();
                this.value = aVLNodeMax.value;
                if (this.rightIsNext) {
                    this.right = aVLNodeMax.right;
                }
                AVLNode<E> aVLNode2 = this.left;
                AVLNode<E> aVLNode3 = aVLNode2.left;
                AVLNode<E> aVLNodeRemoveMax = aVLNode2.removeMax();
                this.left = aVLNodeRemoveMax;
                if (aVLNodeRemoveMax == null) {
                    this.left = aVLNode3;
                    this.leftIsPrevious = true;
                }
                int i5 = this.relativePosition;
                if (i5 > 0) {
                    this.relativePosition = i5 - 1;
                }
            }
            recalcHeight();
            return this;
        }

        private AVLNode<E> balance() {
            int iHeightRightMinusLeft = heightRightMinusLeft();
            if (iHeightRightMinusLeft == -2) {
                if (this.left.heightRightMinusLeft() > 0) {
                    setLeft(this.left.rotateLeft(), null);
                }
                return rotateRight();
            }
            if (iHeightRightMinusLeft == -1 || iHeightRightMinusLeft == 0 || iHeightRightMinusLeft == 1) {
                return this;
            }
            if (iHeightRightMinusLeft == 2) {
                if (this.right.heightRightMinusLeft() < 0) {
                    setRight(this.right.rotateRight(), null);
                }
                return rotateLeft();
            }
            throw new RuntimeException("tree inconsistent!");
        }

        private int getOffset(AVLNode<E> aVLNode) {
            if (aVLNode == null) {
                return 0;
            }
            return aVLNode.relativePosition;
        }

        private int setOffset(AVLNode<E> aVLNode, int i) {
            if (aVLNode == null) {
                return 0;
            }
            int offset = getOffset(aVLNode);
            aVLNode.relativePosition = i;
            return offset;
        }

        private void recalcHeight() {
            this.height = Math.max(getLeftSubTree() == null ? -1 : getLeftSubTree().height, getRightSubTree() != null ? getRightSubTree().height : -1) + 1;
        }

        private int getHeight(AVLNode<E> aVLNode) {
            if (aVLNode == null) {
                return -1;
            }
            return aVLNode.height;
        }

        private int heightRightMinusLeft() {
            return getHeight(getRightSubTree()) - getHeight(getLeftSubTree());
        }

        private AVLNode<E> rotateLeft() {
            AVLNode<E> aVLNode = this.right;
            AVLNode<E> leftSubTree = getRightSubTree().getLeftSubTree();
            int offset = this.relativePosition + getOffset(aVLNode);
            int i = -aVLNode.relativePosition;
            int offset2 = getOffset(aVLNode) + getOffset(leftSubTree);
            setRight(leftSubTree, aVLNode);
            aVLNode.setLeft(this, null);
            setOffset(aVLNode, offset);
            setOffset(this, i);
            setOffset(leftSubTree, offset2);
            return aVLNode;
        }

        private AVLNode<E> rotateRight() {
            AVLNode<E> aVLNode = this.left;
            AVLNode<E> rightSubTree = getLeftSubTree().getRightSubTree();
            int offset = this.relativePosition + getOffset(aVLNode);
            int i = -aVLNode.relativePosition;
            int offset2 = getOffset(aVLNode) + getOffset(rightSubTree);
            setLeft(rightSubTree, aVLNode);
            aVLNode.setRight(this, null);
            setOffset(aVLNode, offset);
            setOffset(this, i);
            setOffset(rightSubTree, offset2);
            return aVLNode;
        }

        private void setLeft(AVLNode<E> aVLNode, AVLNode<E> aVLNode2) {
            boolean z = aVLNode == null;
            this.leftIsPrevious = z;
            if (z) {
                aVLNode = aVLNode2;
            }
            this.left = aVLNode;
            recalcHeight();
        }

        private void setRight(AVLNode<E> aVLNode, AVLNode<E> aVLNode2) {
            boolean z = aVLNode == null;
            this.rightIsNext = z;
            if (z) {
                aVLNode = aVLNode2;
            }
            this.right = aVLNode;
            recalcHeight();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AVLNode<E> addAll(AVLNode<E> aVLNode, int i) {
            int i2;
            int i3;
            AVLNode<E> aVLNodeMax = max();
            AVLNode<E> aVLNodeMin = aVLNode.min();
            int i4 = 0;
            if (aVLNode.height > this.height) {
                AVLNode<E> aVLNodeRemoveMax = removeMax();
                ArrayDeque arrayDeque = new ArrayDeque();
                int i5 = aVLNode.relativePosition + i;
                AVLNode<E> aVLNode2 = aVLNode;
                loop0: while (true) {
                    int i6 = i5;
                    i3 = i4;
                    i4 = i6;
                    while (true) {
                        if (aVLNode2 == null || aVLNode2.height <= getHeight(aVLNodeRemoveMax)) {
                            break loop0;
                        }
                        arrayDeque.push(aVLNode2);
                        aVLNode2 = aVLNode2.left;
                        if (aVLNode2 != null) {
                            break;
                        }
                        i3 = i4;
                    }
                    i5 = aVLNode2.relativePosition + i4;
                }
                aVLNodeMax.setLeft(aVLNodeRemoveMax, null);
                aVLNodeMax.setRight(aVLNode2, aVLNodeMin);
                if (aVLNodeRemoveMax != null) {
                    aVLNodeRemoveMax.max().setRight(null, aVLNodeMax);
                    aVLNodeRemoveMax.relativePosition -= i - 1;
                }
                if (aVLNode2 != null) {
                    aVLNode2.min().setLeft(null, aVLNodeMax);
                    aVLNode2.relativePosition = (i4 - i) + 1;
                }
                aVLNodeMax.relativePosition = (i - 1) - i3;
                aVLNode.relativePosition += i;
                while (!arrayDeque.isEmpty()) {
                    AVLNode aVLNode3 = (AVLNode) arrayDeque.pop();
                    aVLNode3.setLeft(aVLNodeMax, null);
                    aVLNodeMax = aVLNode3.balance();
                }
                return aVLNodeMax;
            }
            AVLNode<E> aVLNodeRemoveMin = aVLNode.removeMin();
            ArrayDeque arrayDeque2 = new ArrayDeque();
            int i7 = this.relativePosition;
            AVLNode<E> aVLNode4 = this;
            loop3: while (true) {
                int i8 = i4;
                i4 = i7;
                i2 = i8;
                while (true) {
                    if (aVLNode4 == null || aVLNode4.height <= getHeight(aVLNodeRemoveMin)) {
                        break loop3;
                    }
                    arrayDeque2.push(aVLNode4);
                    aVLNode4 = aVLNode4.right;
                    if (aVLNode4 != null) {
                        break;
                    }
                    i2 = i4;
                }
                i7 = aVLNode4.relativePosition + i4;
            }
            aVLNodeMin.setRight(aVLNodeRemoveMin, null);
            aVLNodeMin.setLeft(aVLNode4, aVLNodeMax);
            if (aVLNodeRemoveMin != null) {
                aVLNodeRemoveMin.min().setLeft(null, aVLNodeMin);
                aVLNodeRemoveMin.relativePosition++;
            }
            if (aVLNode4 != null) {
                aVLNode4.max().setRight(null, aVLNodeMin);
                aVLNode4.relativePosition = i4 - i;
            }
            aVLNodeMin.relativePosition = i - i2;
            while (!arrayDeque2.isEmpty()) {
                AVLNode aVLNode5 = (AVLNode) arrayDeque2.pop();
                aVLNode5.setRight(aVLNodeMin, null);
                aVLNodeMin = aVLNode5.balance();
            }
            return aVLNodeMin;
        }

        public String toString() {
            return "AVLNode(" + this.relativePosition + ',' + (this.left != null) + ',' + this.value + ',' + (getRightSubTree() != null) + ", faedelung " + this.rightIsNext + " )";
        }
    }

    static class TreeListIterator<E> implements ListIterator<E>, OrderedIterator<E> {
        private AVLNode<E> current;
        private int currentIndex;
        private int expectedModCount;
        private AVLNode<E> next;
        private int nextIndex;
        private final TreeList<E> parent;

        protected TreeListIterator(TreeList<E> treeList, int i) throws IndexOutOfBoundsException {
            this.parent = treeList;
            this.expectedModCount = treeList.modCount;
            this.next = ((TreeList) treeList).root == null ? null : ((TreeList) treeList).root.get(i);
            this.nextIndex = i;
            this.currentIndex = -1;
        }

        protected void checkModCount() {
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.nextIndex < this.parent.size();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            checkModCount();
            if (!hasNext()) {
                throw new NoSuchElementException("No element at index " + this.nextIndex + ".");
            }
            if (this.next == null) {
                this.next = ((TreeList) this.parent).root.get(this.nextIndex);
            }
            E value = this.next.getValue();
            AVLNode<E> aVLNode = this.next;
            this.current = aVLNode;
            int i = this.nextIndex;
            this.nextIndex = i + 1;
            this.currentIndex = i;
            this.next = aVLNode.next();
            return value;
        }

        @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
        public boolean hasPrevious() {
            return this.nextIndex > 0;
        }

        @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
        public E previous() {
            checkModCount();
            if (!hasPrevious()) {
                throw new NoSuchElementException("Already at start of list.");
            }
            AVLNode<E> aVLNode = this.next;
            if (aVLNode == null) {
                this.next = ((TreeList) this.parent).root.get(this.nextIndex - 1);
            } else {
                this.next = aVLNode.previous();
            }
            E value = this.next.getValue();
            this.current = this.next;
            int i = this.nextIndex - 1;
            this.nextIndex = i;
            this.currentIndex = i;
            return value;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.nextIndex;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return nextIndex() - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            checkModCount();
            int i = this.currentIndex;
            if (i == -1) {
                throw new IllegalStateException();
            }
            this.parent.remove(i);
            int i2 = this.nextIndex;
            if (i2 != this.currentIndex) {
                this.nextIndex = i2 - 1;
            }
            this.next = null;
            this.current = null;
            this.currentIndex = -1;
            this.expectedModCount++;
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            checkModCount();
            AVLNode<E> aVLNode = this.current;
            if (aVLNode == null) {
                throw new IllegalStateException();
            }
            aVLNode.setValue(e);
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            checkModCount();
            this.parent.add(this.nextIndex, e);
            this.current = null;
            this.currentIndex = -1;
            this.nextIndex++;
            this.expectedModCount++;
        }
    }
}
