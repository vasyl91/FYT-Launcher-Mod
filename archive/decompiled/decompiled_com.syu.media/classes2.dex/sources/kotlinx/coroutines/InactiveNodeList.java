package kotlinx.coroutines;

import kotlin.Metadata;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/InactiveNodeList;", "Lkotlinx/coroutines/Incomplete;", XmlErrorCodes.LIST, "Lkotlinx/coroutines/NodeList;", "(Lkotlinx/coroutines/NodeList;)V", "isActive", "", "()Z", "getList", "()Lkotlinx/coroutines/NodeList;", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InactiveNodeList implements Incomplete {
    private final NodeList list;

    @Override // kotlinx.coroutines.Incomplete
    /* JADX INFO: renamed from: isActive */
    public boolean getIsActive() {
        return false;
    }

    public InactiveNodeList(NodeList nodeList) {
        this.list = nodeList;
    }

    @Override // kotlinx.coroutines.Incomplete
    public NodeList getList() {
        return this.list;
    }

    public String toString() {
        return DebugKt.getDEBUG() ? getList().getString("New") : super.toString();
    }
}
