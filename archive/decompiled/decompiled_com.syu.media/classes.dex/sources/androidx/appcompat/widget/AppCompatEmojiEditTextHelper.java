package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.R;
import androidx.emoji2.viewsintegration.EmojiEditTextHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
class AppCompatEmojiEditTextHelper {
    private final EmojiEditTextHelper mEmojiEditTextHelper;
    private final EditText mView;

    AppCompatEmojiEditTextHelper(EditText editText) {
        this.mView = editText;
        this.mEmojiEditTextHelper = new EmojiEditTextHelper(editText, false);
    }

    void loadFromAttributes(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i, 0);
        try {
            boolean z = typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_emojiCompatEnabled) ? typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppCompatTextView_emojiCompatEnabled, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            setEnabled(z);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    void initKeyListener() {
        boolean zIsFocusable = this.mView.isFocusable();
        int inputType = this.mView.getInputType();
        EditText editText = this.mView;
        editText.setKeyListener(editText.getKeyListener());
        this.mView.setRawInputType(inputType);
        this.mView.setFocusable(zIsFocusable);
    }

    void setEnabled(boolean z) {
        this.mEmojiEditTextHelper.setEnabled(z);
    }

    boolean isEnabled() {
        return this.mEmojiEditTextHelper.isEnabled();
    }

    KeyListener getKeyListener(KeyListener keyListener) {
        return this.mEmojiEditTextHelper.getKeyListener(keyListener);
    }

    InputConnection onCreateInputConnection(InputConnection inputConnection, EditorInfo editorInfo) {
        return this.mEmojiEditTextHelper.onCreateInputConnection(inputConnection, editorInfo);
    }
}
