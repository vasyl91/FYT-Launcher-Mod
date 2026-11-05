package org.apache.commons.collections4.sequence;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DeleteCommand<T> extends EditCommand<T> {
    public DeleteCommand(T t) {
        super(t);
    }

    @Override // org.apache.commons.collections4.sequence.EditCommand
    public void accept(CommandVisitor<T> commandVisitor) {
        commandVisitor.visitDeleteCommand(getObject());
    }
}
