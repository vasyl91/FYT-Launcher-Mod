package org.apache.commons.collections4;

import java.util.LinkedList;
import java.util.Queue;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.queue.TransformedQueue;
import org.apache.commons.collections4.queue.UnmodifiableQueue;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class QueueUtils {
    public static final Queue EMPTY_QUEUE = UnmodifiableQueue.unmodifiableQueue(new LinkedList());

    private QueueUtils() {
    }

    public static <E> Queue<E> unmodifiableQueue(Queue<? extends E> queue) {
        return UnmodifiableQueue.unmodifiableQueue(queue);
    }

    public static <E> Queue<E> predicatedQueue(Queue<E> queue, Predicate<? super E> predicate) {
        return PredicatedQueue.predicatedQueue(queue, predicate);
    }

    public static <E> Queue<E> transformingQueue(Queue<E> queue, Transformer<? super E, ? extends E> transformer) {
        return TransformedQueue.transformingQueue(queue, transformer);
    }

    public static <E> Queue<E> emptyQueue() {
        return EMPTY_QUEUE;
    }
}
