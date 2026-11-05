package org.apache.commons.collections4.sequence;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ReplacementsFinder<T> implements CommandVisitor<T> {
    private final ReplacementsHandler<T> handler;
    private final List<T> pendingInsertions = new ArrayList();
    private final List<T> pendingDeletions = new ArrayList();
    private int skipped = 0;

    public ReplacementsFinder(ReplacementsHandler<T> replacementsHandler) {
        this.handler = replacementsHandler;
    }

    @Override // org.apache.commons.collections4.sequence.CommandVisitor
    public void visitInsertCommand(T t) {
        this.pendingInsertions.add(t);
    }

    @Override // org.apache.commons.collections4.sequence.CommandVisitor
    public void visitKeepCommand(T t) {
        if (this.pendingDeletions.isEmpty() && this.pendingInsertions.isEmpty()) {
            this.skipped++;
            return;
        }
        this.handler.handleReplacement(this.skipped, this.pendingDeletions, this.pendingInsertions);
        this.pendingDeletions.clear();
        this.pendingInsertions.clear();
        this.skipped = 1;
    }

    @Override // org.apache.commons.collections4.sequence.CommandVisitor
    public void visitDeleteCommand(T t) {
        this.pendingDeletions.add(t);
    }
}
