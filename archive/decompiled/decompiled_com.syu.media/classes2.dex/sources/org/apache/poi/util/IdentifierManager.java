package org.apache.poi.util;

import java.util.LinkedList;
import java.util.ListIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class IdentifierManager {
    public static final long MAX_ID = 9223372036854775806L;
    public static final long MIN_ID = 0;
    private final long lowerbound;
    private LinkedList<Segment> segments;
    private final long upperbound;

    public IdentifierManager(long j, long j2) {
        if (j > j2) {
            throw new IllegalArgumentException("lowerbound must not be greater than upperbound, had " + j + " and " + j2);
        }
        if (j < 0) {
            throw new IllegalArgumentException("lowerbound must be greater than or equal to " + Long.toString(0L));
        }
        if (j2 > MAX_ID) {
            throw new IllegalArgumentException("upperbound must be less than or equal to " + Long.toString(MAX_ID) + " but had " + j2);
        }
        this.lowerbound = j;
        this.upperbound = j2;
        LinkedList<Segment> linkedList = new LinkedList<>();
        this.segments = linkedList;
        linkedList.add(new Segment(j, j2));
    }

    public long reserve(long j) {
        if (j < this.lowerbound || j > this.upperbound) {
            throw new IllegalArgumentException("Value for parameter 'id' was out of bounds, had " + j + ", but should be within [" + this.lowerbound + ":" + this.upperbound + "]");
        }
        verifyIdentifiersLeft();
        if (j == this.upperbound) {
            Segment last = this.segments.getLast();
            long j2 = last.end;
            long j3 = this.upperbound;
            if (j2 == j3) {
                last.end = j3 - 1;
                if (last.start > last.end) {
                    this.segments.removeLast();
                }
                return j;
            }
            return reserveNew();
        }
        if (j == this.lowerbound) {
            Segment first = this.segments.getFirst();
            long j4 = first.start;
            long j5 = this.lowerbound;
            if (j4 == j5) {
                first.start = j5 + 1;
                if (first.end < first.start) {
                    this.segments.removeFirst();
                }
                return j;
            }
            return reserveNew();
        }
        ListIterator<Segment> listIterator = this.segments.listIterator();
        while (listIterator.hasNext()) {
            Segment next = listIterator.next();
            if (next.end >= j) {
                if (next.start > j) {
                    break;
                }
                if (next.start == j) {
                    next.start = 1 + j;
                    if (next.end < next.start) {
                        listIterator.remove();
                    }
                    return j;
                }
                if (next.end == j) {
                    next.end = j - 1;
                    if (next.start > next.end) {
                        listIterator.remove();
                    }
                    return j;
                }
                listIterator.add(new Segment(j + 1, next.end));
                next.end = j - 1;
                return j;
            }
        }
        return reserveNew();
    }

    public long reserveNew() {
        verifyIdentifiersLeft();
        Segment first = this.segments.getFirst();
        long j = first.start;
        first.start++;
        if (first.start > first.end) {
            this.segments.removeFirst();
        }
        return j;
    }

    public boolean release(long j) {
        long j2 = this.lowerbound;
        if (j >= j2) {
            long j3 = this.upperbound;
            if (j <= j3) {
                if (j == j3) {
                    Segment last = this.segments.getLast();
                    long j4 = last.end;
                    long j5 = this.upperbound;
                    if (j4 == j5 - 1) {
                        last.end = j5;
                        return true;
                    }
                    if (last.end == this.upperbound) {
                        return false;
                    }
                    LinkedList<Segment> linkedList = this.segments;
                    long j6 = this.upperbound;
                    linkedList.add(new Segment(j6, j6));
                    return true;
                }
                if (j == j2) {
                    Segment first = this.segments.getFirst();
                    long j7 = first.start;
                    long j8 = this.lowerbound;
                    if (j7 == 1 + j8) {
                        first.start = j8;
                        return true;
                    }
                    if (first.start == this.lowerbound) {
                        return false;
                    }
                    LinkedList<Segment> linkedList2 = this.segments;
                    long j9 = this.lowerbound;
                    linkedList2.addFirst(new Segment(j9, j9));
                    return true;
                }
                long j10 = j + 1;
                long j11 = j - 1;
                ListIterator<Segment> listIterator = this.segments.listIterator();
                while (listIterator.hasNext()) {
                    Segment next = listIterator.next();
                    if (next.end >= j11) {
                        if (next.start <= j10) {
                            if (next.start != j10) {
                                if (next.end != j11) {
                                    break;
                                }
                                next.end = j;
                                if (listIterator.hasNext()) {
                                    Segment next2 = listIterator.next();
                                    if (next2.start == next.end + 1) {
                                        next.end = next2.end;
                                        listIterator.remove();
                                    }
                                }
                                return true;
                            }
                            next.start = j;
                            return true;
                        }
                        listIterator.previous();
                        listIterator.add(new Segment(j, j));
                        return true;
                    }
                }
                return false;
            }
        }
        throw new IllegalArgumentException("Value for parameter 'id' was out of bounds, had " + j + ", but should be within [" + this.lowerbound + ":" + this.upperbound + "]");
    }

    public long getRemainingIdentifiers() {
        long j = 0;
        for (Segment segment : this.segments) {
            j = (j - segment.start) + segment.end + 1;
        }
        return j;
    }

    private void verifyIdentifiersLeft() {
        if (this.segments.isEmpty()) {
            throw new IllegalStateException("No identifiers left");
        }
    }

    private static class Segment {
        public long end;
        public long start;

        public Segment(long j, long j2) {
            this.start = j;
            this.end = j2;
        }

        public String toString() {
            return "[" + this.start + "; " + this.end + "]";
        }
    }
}
