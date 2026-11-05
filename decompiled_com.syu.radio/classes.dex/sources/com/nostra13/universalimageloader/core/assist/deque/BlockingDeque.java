package com.nostra13.universalimageloader.core.assist.deque;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface BlockingDeque<E> extends BlockingQueue<E>, Deque<E> {
    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, java.util.Collection, com.nostra13.universalimageloader.core.assist.deque.Deque
    boolean add(E e);

    @Override // com.nostra13.universalimageloader.core.assist.deque.Deque
    void addFirst(E e);

    @Override // com.nostra13.universalimageloader.core.assist.deque.Deque
    void addLast(E e);

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection, com.nostra13.universalimageloader.core.assist.deque.Deque
    boolean contains(Object obj);

    @Override // java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.Deque
    E element();

    @Override // java.util.Collection, java.lang.Iterable, com.nostra13.universalimageloader.core.assist.deque.Deque
    Iterator<E> iterator();

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.Deque
    boolean offer(E e);

    @Override // java.util.concurrent.BlockingQueue
    boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException;

    @Override // com.nostra13.universalimageloader.core.assist.deque.Deque
    boolean offerFirst(E e);

    boolean offerFirst(E e, long j, TimeUnit timeUnit) throws InterruptedException;

    @Override // com.nostra13.universalimageloader.core.assist.deque.Deque
    boolean offerLast(E e);

    boolean offerLast(E e, long j, TimeUnit timeUnit) throws InterruptedException;

    @Override // java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.Deque
    E peek();

    @Override // java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.Deque
    E poll();

    @Override // java.util.concurrent.BlockingQueue
    E poll(long j, TimeUnit timeUnit) throws InterruptedException;

    E pollFirst(long j, TimeUnit timeUnit) throws InterruptedException;

    E pollLast(long j, TimeUnit timeUnit) throws InterruptedException;

    @Override // com.nostra13.universalimageloader.core.assist.deque.Deque
    void push(E e);

    @Override // java.util.concurrent.BlockingQueue
    void put(E e) throws InterruptedException;

    void putFirst(E e) throws InterruptedException;

    void putLast(E e) throws InterruptedException;

    @Override // java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.Deque
    E remove();

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection, com.nostra13.universalimageloader.core.assist.deque.Deque
    boolean remove(Object obj);

    @Override // com.nostra13.universalimageloader.core.assist.deque.Deque
    boolean removeFirstOccurrence(Object obj);

    @Override // com.nostra13.universalimageloader.core.assist.deque.Deque
    boolean removeLastOccurrence(Object obj);

    @Override // java.util.Collection, com.nostra13.universalimageloader.core.assist.deque.Deque
    int size();

    @Override // java.util.concurrent.BlockingQueue
    E take() throws InterruptedException;

    E takeFirst() throws InterruptedException;

    E takeLast() throws InterruptedException;
}
