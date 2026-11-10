package syu.recyclerview;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H&J\u0014\u0010\u0002\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H&J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0010\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\nH&J\u001a\u0010\b\u001a\u00020\u00032\u0010\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\nH&J*\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0010\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\nH&J\"\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00012\u0010\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\nH&J$\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H&J\u001c\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H&J\u0016\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0001H&J\u000e\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H&J\u0016\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001e\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H&J\u001a\u0010\u0016\u001a\u00020\u00032\u0010\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\nH&J\u0014\u0010\u0016\u001a\u00020\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H&J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0018\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H&J\"\u0010\u0018\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00012\u0010\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\nH&J\u001c\u0010\u0018\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H&J\u001a\u0010\u0019\u001a\u00020\u00032\u0010\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\nH&J\"\u0010\u001a\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00012\u0010\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\nH&J\"\u0010\u001b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00012\u0010\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\nH&J\u001a\u0010\u001c\u001a\u00020\u00032\u0010\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\nH&J\b\u0010\u0017\u001a\u00020\u0005H&¨\u0006\u001d"}, d2 = {"Lsyu/recyclerview/IGroup;", "", "add", "", "position", "", "node", "Lsyu/recyclerview/Node;", "addAll", "list", "", "addAllByTag", "tag", "addByTag", "clear", "contains", "", "data", "findNode", "lastNode", "nodeAt", "nodeAtByTag", "remove", "size", "removeByTag", "replace", "replaceByTag", "replaceByTagWithoutNotify", "replaceWithoutNotify", "Library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IGroup {
    int add(Node<?> node);

    void add(int position, Node<?> node);

    void addAll(int position, List<Node<?>> list);

    void addAll(List<Node<?>> list);

    void addAllByTag(Object tag, int position, List<Node<?>> list);

    void addAllByTag(Object tag, List<Node<?>> list);

    int addByTag(Object tag, Node<?> node);

    void addByTag(Object tag, int position, Node<?> node);

    void clear();

    boolean contains(Object data);

    Node<?> findNode(Object tag);

    Node<?> lastNode();

    Node<?> nodeAt(int position);

    Node<?> nodeAtByTag(Object tag, int position);

    void remove(int position);

    void remove(int position, int size);

    void remove(List<Node<?>> list);

    void remove(Node<?> node);

    void removeByTag(Object tag, int position);

    void removeByTag(Object tag, int position, int size);

    void removeByTag(Object tag, List<Node<?>> list);

    void removeByTag(Object tag, Node<?> node);

    void replace(List<Node<?>> list);

    void replaceByTag(Object tag, List<Node<?>> list);

    void replaceByTagWithoutNotify(Object tag, List<Node<?>> list);

    void replaceWithoutNotify(List<Node<?>> list);

    int size();
}
