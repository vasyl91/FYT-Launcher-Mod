package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class NodeListIterator implements Iterator<Node> {
    private int index = 0;
    private final NodeList nodeList;

    public NodeListIterator(Node node) {
        if (node == null) {
            throw new NullPointerException("Node must not be null.");
        }
        this.nodeList = node.getChildNodes();
    }

    public NodeListIterator(NodeList nodeList) {
        if (nodeList == null) {
            throw new NullPointerException("NodeList must not be null.");
        }
        this.nodeList = nodeList;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        NodeList nodeList = this.nodeList;
        return nodeList != null && this.index < nodeList.getLength();
    }

    @Override // java.util.Iterator
    public Node next() {
        NodeList nodeList = this.nodeList;
        if (nodeList != null && this.index < nodeList.getLength()) {
            NodeList nodeList2 = this.nodeList;
            int i = this.index;
            this.index = i + 1;
            return nodeList2.item(i);
        }
        throw new NoSuchElementException("underlying nodeList has no more elements");
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() method not supported for a NodeListIterator.");
    }
}
