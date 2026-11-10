package org.apache.xmlbeans.impl.schema;

import java.util.Arrays;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.impl.values.TypeStoreVisitor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SchemaTypeVisitorImpl implements TypeStoreVisitor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final boolean CHECK_VALIDITY = false;
    static final boolean PROBE_VALIDITY = true;
    private boolean _isValid;
    private SchemaParticle _matchedParticle;
    private VisitorState[] _rollback;
    private int _rollbackIndex;
    int _rollbackSize;
    private VisitorState[] _stack;
    int _stackSize;
    private VisitorState _top;

    public SchemaTypeVisitorImpl(SchemaParticle schemaParticle) {
        init(schemaParticle);
    }

    public SchemaTypeVisitorImpl() {
    }

    public void init(SchemaParticle schemaParticle) {
        if (this._stack == null) {
            this._stack = expand(null);
        }
        if (this._rollback == null) {
            this._rollback = expand(null);
        }
        this._stackSize = 0;
        this._rollbackSize = 0;
        if (schemaParticle != null) {
            push(schemaParticle);
            this._rollbackIndex = 1;
        }
    }

    public VisitorState[] expand(VisitorState[] visitorStateArr) {
        int length = visitorStateArr == null ? 4 : visitorStateArr.length * 2;
        VisitorState[] visitorStateArr2 = new VisitorState[length];
        if (visitorStateArr != null) {
            System.arraycopy(visitorStateArr, 0, visitorStateArr2, 0, visitorStateArr.length);
        }
        for (int length2 = visitorStateArr != null ? visitorStateArr.length : 0; length2 < length; length2++) {
            visitorStateArr2[length2] = new VisitorState();
        }
        return visitorStateArr2;
    }

    private static class VisitorState {
        int _childCount;
        int _curCount;
        int _curMax;
        int _curMin;
        SchemaParticle _curPart;
        int _processedChildCount;
        boolean[] _seen;

        private VisitorState() {
        }

        public void copy(VisitorState visitorState) {
            this._curPart = visitorState._curPart;
            this._curCount = visitorState._curCount;
            this._curMin = visitorState._curMin;
            this._curMax = visitorState._curMax;
            this._processedChildCount = visitorState._processedChildCount;
            this._childCount = visitorState._childCount;
            boolean[] zArr = visitorState._seen;
            if (zArr != null) {
                boolean[] zArr2 = new boolean[zArr.length];
                this._seen = zArr2;
                boolean[] zArr3 = visitorState._seen;
                System.arraycopy(zArr3, 0, zArr2, 0, zArr3.length);
            }
        }

        public void init(SchemaParticle schemaParticle) {
            this._curPart = schemaParticle;
            this._curMin = schemaParticle.getIntMinOccurs();
            this._curMax = schemaParticle.getIntMaxOccurs();
            this._curCount = 0;
            this._processedChildCount = 0;
            this._childCount = schemaParticle.countOfParticleChild();
            this._seen = schemaParticle.getParticleType() == 1 ? new boolean[this._childCount] : null;
        }
    }

    VisitorState topRef() {
        return this._stack[this._stackSize - 1];
    }

    void saveCopy(VisitorState visitorState) {
        VisitorState[] visitorStateArr = this._rollback;
        if (visitorStateArr.length == this._rollbackSize) {
            this._rollback = expand(visitorStateArr);
        }
        this._rollback[this._rollbackSize].copy(visitorState);
        this._rollbackSize++;
    }

    void addParticle(SchemaParticle schemaParticle) {
        VisitorState[] visitorStateArr = this._stack;
        if (visitorStateArr.length == this._stackSize) {
            this._stack = expand(visitorStateArr);
        }
        this._stack[this._stackSize].init(schemaParticle);
        this._stackSize++;
    }

    boolean prepare() {
        if (this._rollbackIndex == 0) {
            this._top = null;
            return false;
        }
        VisitorState visitorState = topRef();
        this._top = visitorState;
        saveCopy(visitorState);
        this._rollbackIndex = this._stackSize - 1;
        return PROBE_VALIDITY;
    }

    void push(SchemaParticle schemaParticle) {
        addParticle(schemaParticle);
        this._top = topRef();
    }

    boolean pop() {
        int i = this._stackSize - 1;
        this._stackSize = i;
        if (i <= this._rollbackIndex) {
            return prepare();
        }
        this._top = topRef();
        return PROBE_VALIDITY;
    }

    void commit() {
        this._top = null;
        this._rollbackIndex = this._stackSize;
        this._rollbackSize = 0;
    }

    void rollback() {
        while (true) {
            int i = this._rollbackSize;
            if (i > 0) {
                int i2 = i - 1;
                this._rollbackSize = i2;
                VisitorState[] visitorStateArr = this._stack;
                int i3 = this._rollbackIndex;
                VisitorState visitorState = visitorStateArr[i3];
                VisitorState[] visitorStateArr2 = this._rollback;
                visitorStateArr[i3] = visitorStateArr2[i2];
                visitorStateArr2[i2] = visitorState;
                this._rollbackIndex = i3 + 1;
            } else {
                this._stackSize = this._rollbackIndex;
                this._top = null;
                return;
            }
        }
    }

    boolean notValid() {
        this._isValid = false;
        this._matchedParticle = null;
        rollback();
        return false;
    }

    boolean ok(SchemaParticle schemaParticle, boolean z) {
        if (!z) {
            this._matchedParticle = schemaParticle;
            commit();
            return PROBE_VALIDITY;
        }
        rollback();
        return PROBE_VALIDITY;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreVisitor
    public boolean visit(QName qName) {
        return visit(qName, false);
    }

    /* JADX WARN: Code duplicated, block: B:113:0x018b A[EDGE_INSN: B:113:0x018b->B:93:0x018b BREAK  A[LOOP:0: B:7:0x000d->B:123:0x000d], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:126:0x000d A[SYNTHETIC] */
    public boolean visit(QName qName, boolean z) {
        if (!prepare()) {
            return notValid();
        }
        int i = -2;
        int i2 = -2;
        loop0: while (true) {
            if (this._top._curCount > this._top._curMin && i == this._top._processedChildCount && i2 == this._stackSize) {
                VisitorState visitorState = this._top;
                visitorState._curCount = visitorState._curMax;
            }
            i = this._top._processedChildCount;
            i2 = this._stackSize;
            while (this._top._curCount >= this._top._curMax) {
                if (!pop()) {
                    break loop0;
                }
            }
            int particleType = this._top._curPart.getParticleType();
            int i3 = 0;
            if (particleType == 1) {
                int i4 = this._top._processedChildCount;
                int i5 = 0;
                while (true) {
                    if (i5 < this._top._childCount) {
                        if (!this._top._seen[i5]) {
                            SchemaParticle particleChild = this._top._curPart.getParticleChild(i5);
                            if (particleChild.canStartWithElement(qName)) {
                                this._top._processedChildCount++;
                                this._top._seen[i5] = PROBE_VALIDITY;
                                push(particleChild);
                            } else if (particleChild.isSkippable()) {
                                i4++;
                            }
                        }
                        i5++;
                    } else if (i4 < this._top._childCount) {
                        if (this._top._curCount < this._top._curMin) {
                            return notValid();
                        }
                        if (!pop()) {
                            break;
                            break;
                        }
                    } else {
                        this._top._curCount++;
                        this._top._processedChildCount = 0;
                        Arrays.fill(this._top._seen, false);
                    }
                }
            } else if (particleType != 2) {
                if (particleType == 3) {
                    int i6 = this._top._processedChildCount;
                    while (true) {
                        if (i6 < this._top._childCount) {
                            SchemaParticle particleChild2 = this._top._curPart.getParticleChild(i6);
                            if (particleChild2.canStartWithElement(qName)) {
                                this._top._processedChildCount = i6 + 1;
                                push(particleChild2);
                            } else if (particleChild2.isSkippable()) {
                                i6++;
                            } else if (this._top._processedChildCount != 0 || this._top._curCount < this._top._curMin) {
                                return notValid();
                            }
                        } else {
                            this._top._curCount++;
                            this._top._processedChildCount = 0;
                        }
                    }
                } else if (particleType != 4) {
                    if (!this._top._curPart.canStartWithElement(qName)) {
                        if (this._top._curCount < this._top._curMin) {
                            return notValid();
                        }
                    } else {
                        this._top._curCount++;
                        return ok(this._top._curPart, z);
                    }
                } else if (!this._top._curPart.canStartWithElement(qName)) {
                    if (this._top._curCount < this._top._curMin) {
                        return notValid();
                    }
                } else {
                    this._top._curCount++;
                    return ok(this._top._curPart, z);
                }
                if (!pop()) {
                    break;
                }
            } else {
                while (true) {
                    if (i3 < this._top._childCount) {
                        SchemaParticle particleChild3 = this._top._curPart.getParticleChild(i3);
                        if (particleChild3.canStartWithElement(qName)) {
                            this._top._curCount++;
                            push(particleChild3);
                        } else {
                            i3++;
                        }
                    } else {
                        if (this._top._curCount < this._top._curMin && !this._top._curPart.isSkippable()) {
                            return notValid();
                        }
                        if (!pop()) {
                            break;
                            break;
                        }
                    }
                }
            }
        }
        if (qName == null) {
            return ok(null, z);
        }
        return notValid();
    }

    public boolean testValid(QName qName) {
        return visit(qName, PROBE_VALIDITY);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreVisitor
    public int get_elementflags() {
        if (currentParticle() == null || currentParticle().getParticleType() != 4) {
            return 0;
        }
        SchemaLocalElement schemaLocalElementCurrentParticle = currentParticle();
        return (schemaLocalElementCurrentParticle.isNillable() ? 1 : 0) | (schemaLocalElementCurrentParticle.isDefault() ? 2 : 0) | (schemaLocalElementCurrentParticle.isFixed() ? 4 : 0);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreVisitor
    public String get_default_text() {
        if (currentParticle() == null || currentParticle().getParticleType() != 4) {
            return null;
        }
        return currentParticle().getDefaultText();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreVisitor
    public SchemaField get_schema_field() {
        if (currentParticle() instanceof SchemaField) {
            return currentParticle();
        }
        return null;
    }

    public SchemaParticle currentParticle() {
        return this._matchedParticle;
    }

    public boolean isAllValid() {
        return this._isValid;
    }
}
