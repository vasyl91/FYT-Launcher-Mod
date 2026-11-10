package android.support.v4.widget;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class SearchViewCompat {
    private static final SearchViewCompatImpl IMPL;

    interface SearchViewCompatImpl {
        CharSequence getQuery(View view);

        boolean isIconified(View view);

        boolean isQueryRefinementEnabled(View view);

        boolean isSubmitButtonEnabled(View view);

        Object newOnCloseListener(OnCloseListenerCompat onCloseListenerCompat);

        Object newOnQueryTextListener(OnQueryTextListenerCompat onQueryTextListenerCompat);

        View newSearchView(Context context);

        void setIconified(View view, boolean z);

        void setImeOptions(View view, int i);

        void setInputType(View view, int i);

        void setMaxWidth(View view, int i);

        void setOnCloseListener(Object obj, Object obj2);

        void setOnQueryTextListener(Object obj, Object obj2);

        void setQuery(View view, CharSequence charSequence, boolean z);

        void setQueryHint(View view, CharSequence charSequence);

        void setQueryRefinementEnabled(View view, boolean z);

        void setSearchableInfo(View view, ComponentName componentName);

        void setSubmitButtonEnabled(View view, boolean z);
    }

    static class SearchViewCompatStubImpl implements SearchViewCompatImpl {
        SearchViewCompatStubImpl() {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public View newSearchView(Context context) {
            return null;
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setSearchableInfo(View searchView, ComponentName searchableComponent) {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setImeOptions(View searchView, int imeOptions) {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setInputType(View searchView, int inputType) {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public Object newOnQueryTextListener(OnQueryTextListenerCompat listener) {
            return null;
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setOnQueryTextListener(Object searchView, Object listener) {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public Object newOnCloseListener(OnCloseListenerCompat listener) {
            return null;
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setOnCloseListener(Object searchView, Object listener) {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public CharSequence getQuery(View searchView) {
            return null;
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setQuery(View searchView, CharSequence query, boolean submit) {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setQueryHint(View searchView, CharSequence hint) {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setIconified(View searchView, boolean iconify) {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public boolean isIconified(View searchView) {
            return true;
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setSubmitButtonEnabled(View searchView, boolean enabled) {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public boolean isSubmitButtonEnabled(View searchView) {
            return false;
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setQueryRefinementEnabled(View searchView, boolean enable) {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public boolean isQueryRefinementEnabled(View searchView) {
            return false;
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setMaxWidth(View searchView, int maxpixels) {
        }
    }

    static class SearchViewCompatHoneycombImpl extends SearchViewCompatStubImpl {
        SearchViewCompatHoneycombImpl() {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public View newSearchView(Context context) {
            return SearchViewCompatHoneycomb.newSearchView(context);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setSearchableInfo(View searchView, ComponentName searchableComponent) {
            SearchViewCompatHoneycomb.setSearchableInfo(searchView, searchableComponent);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public Object newOnQueryTextListener(final OnQueryTextListenerCompat listener) {
            return SearchViewCompatHoneycomb.newOnQueryTextListener(new SearchViewCompatHoneycomb.OnQueryTextListenerCompatBridge() { // from class: android.support.v4.widget.SearchViewCompat.SearchViewCompatHoneycombImpl.1
                @Override // android.support.v4.widget.SearchViewCompatHoneycomb.OnQueryTextListenerCompatBridge
                public boolean onQueryTextSubmit(String query) {
                    return listener.onQueryTextSubmit(query);
                }

                @Override // android.support.v4.widget.SearchViewCompatHoneycomb.OnQueryTextListenerCompatBridge
                public boolean onQueryTextChange(String newText) {
                    return listener.onQueryTextChange(newText);
                }
            });
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setOnQueryTextListener(Object searchView, Object listener) {
            SearchViewCompatHoneycomb.setOnQueryTextListener(searchView, listener);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public Object newOnCloseListener(final OnCloseListenerCompat listener) {
            return SearchViewCompatHoneycomb.newOnCloseListener(new SearchViewCompatHoneycomb.OnCloseListenerCompatBridge() { // from class: android.support.v4.widget.SearchViewCompat.SearchViewCompatHoneycombImpl.2
                @Override // android.support.v4.widget.SearchViewCompatHoneycomb.OnCloseListenerCompatBridge
                public boolean onClose() {
                    return listener.onClose();
                }
            });
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setOnCloseListener(Object searchView, Object listener) {
            SearchViewCompatHoneycomb.setOnCloseListener(searchView, listener);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public CharSequence getQuery(View searchView) {
            return SearchViewCompatHoneycomb.getQuery(searchView);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setQuery(View searchView, CharSequence query, boolean submit) {
            SearchViewCompatHoneycomb.setQuery(searchView, query, submit);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setQueryHint(View searchView, CharSequence hint) {
            SearchViewCompatHoneycomb.setQueryHint(searchView, hint);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setIconified(View searchView, boolean iconify) {
            SearchViewCompatHoneycomb.setIconified(searchView, iconify);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public boolean isIconified(View searchView) {
            return SearchViewCompatHoneycomb.isIconified(searchView);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setSubmitButtonEnabled(View searchView, boolean enabled) {
            SearchViewCompatHoneycomb.setSubmitButtonEnabled(searchView, enabled);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public boolean isSubmitButtonEnabled(View searchView) {
            return SearchViewCompatHoneycomb.isSubmitButtonEnabled(searchView);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setQueryRefinementEnabled(View searchView, boolean enable) {
            SearchViewCompatHoneycomb.setQueryRefinementEnabled(searchView, enable);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public boolean isQueryRefinementEnabled(View searchView) {
            return SearchViewCompatHoneycomb.isQueryRefinementEnabled(searchView);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setMaxWidth(View searchView, int maxpixels) {
            SearchViewCompatHoneycomb.setMaxWidth(searchView, maxpixels);
        }
    }

    static class SearchViewCompatIcsImpl extends SearchViewCompatHoneycombImpl {
        SearchViewCompatIcsImpl() {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatHoneycombImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public View newSearchView(Context context) {
            return SearchViewCompatIcs.newSearchView(context);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setImeOptions(View searchView, int imeOptions) {
            SearchViewCompatIcs.setImeOptions(searchView, imeOptions);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setInputType(View searchView, int inputType) {
            SearchViewCompatIcs.setInputType(searchView, inputType);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new SearchViewCompatIcsImpl();
        } else if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new SearchViewCompatHoneycombImpl();
        } else {
            IMPL = new SearchViewCompatStubImpl();
        }
    }

    private SearchViewCompat(Context context) {
    }

    public static View newSearchView(Context context) {
        return IMPL.newSearchView(context);
    }

    public static void setSearchableInfo(View searchView, ComponentName searchableComponent) {
        IMPL.setSearchableInfo(searchView, searchableComponent);
    }

    public static void setImeOptions(View searchView, int imeOptions) {
        IMPL.setImeOptions(searchView, imeOptions);
    }

    public static void setInputType(View searchView, int inputType) {
        IMPL.setInputType(searchView, inputType);
    }

    public static void setOnQueryTextListener(View searchView, OnQueryTextListenerCompat listener) {
        IMPL.setOnQueryTextListener(searchView, listener.mListener);
    }

    public static abstract class OnQueryTextListenerCompat {
        final Object mListener = SearchViewCompat.IMPL.newOnQueryTextListener(this);

        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        public boolean onQueryTextChange(String newText) {
            return false;
        }
    }

    public static void setOnCloseListener(View searchView, OnCloseListenerCompat listener) {
        IMPL.setOnCloseListener(searchView, listener.mListener);
    }

    public static abstract class OnCloseListenerCompat {
        final Object mListener = SearchViewCompat.IMPL.newOnCloseListener(this);

        public boolean onClose() {
            return false;
        }
    }

    public static CharSequence getQuery(View searchView) {
        return IMPL.getQuery(searchView);
    }

    public static void setQuery(View searchView, CharSequence query, boolean submit) {
        IMPL.setQuery(searchView, query, submit);
    }

    public static void setQueryHint(View searchView, CharSequence hint) {
        IMPL.setQueryHint(searchView, hint);
    }

    public static void setIconified(View searchView, boolean iconify) {
        IMPL.setIconified(searchView, iconify);
    }

    public static boolean isIconified(View searchView) {
        return IMPL.isIconified(searchView);
    }

    public static void setSubmitButtonEnabled(View searchView, boolean enabled) {
        IMPL.setSubmitButtonEnabled(searchView, enabled);
    }

    public static boolean isSubmitButtonEnabled(View searchView) {
        return IMPL.isSubmitButtonEnabled(searchView);
    }

    public static void setQueryRefinementEnabled(View searchView, boolean enable) {
        IMPL.setQueryRefinementEnabled(searchView, enable);
    }

    public static boolean isQueryRefinementEnabled(View searchView) {
        return IMPL.isQueryRefinementEnabled(searchView);
    }

    public static void setMaxWidth(View searchView, int maxpixels) {
        IMPL.setMaxWidth(searchView, maxpixels);
    }
}
