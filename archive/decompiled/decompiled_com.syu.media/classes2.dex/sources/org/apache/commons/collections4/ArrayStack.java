package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.EmptyStackException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Deprecated
public class ArrayStack<E> extends ArrayList<E> {
    private static final long serialVersionUID = 2130079159931574599L;

    public ArrayStack() {
    }

    public ArrayStack(int i) {
        super(i);
    }

    public boolean empty() {
        return isEmpty();
    }

    public E peek() throws EmptyStackException {
        int size = size();
        if (size <= 0) {
            throw new EmptyStackException();
        }
        return get(size - 1);
    }

    public E peek(int i) throws EmptyStackException {
        int size = (size() - i) - 1;
        if (size < 0) {
            throw new EmptyStackException();
        }
        return get(size);
    }

    public E pop() throws EmptyStackException {
        int size = size();
        if (size <= 0) {
            throw new EmptyStackException();
        }
        return remove(size - 1);
    }

    public E push(E e) {
        add(e);
        return e;
    }

    public int search(Object obj) {
        int i = 1;
        int size = size() - 1;
        while (size >= 0) {
            E e = get(size);
            if ((obj == null && e == null) || (obj != null && obj.equals(e))) {
                return i;
            }
            size--;
            i++;
        }
        return -1;
    }
}
