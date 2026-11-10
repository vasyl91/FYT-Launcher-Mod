package com.syu.radio.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import com.lsec.core.frame.app.MyAct;
import com.lsec.core.frame.app.MyActivity;
import com.lsec.core.frame.app.MyApp;
import com.lsec.core.frame.app.MyApplication;
import com.lsec.core.frame.app.MyUi;
import com.lsec.core.frame.ctrl.JPage;
import com.syu.app.App;
import com.syu.radio.Act_Radio;
import com.syu.radio.App_Radio;
import com.syu.radio.data.FinalRadioCtrl;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ActRadio extends MyActivity {
    ArrayList<MyAct> mListMyActs = new ArrayList<>();
    Act_Radio mActRadio = new Act_Radio();

    @Override // com.lsec.core.frame.app.MyActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        this.mListMyActs.add(this.mActRadio);
        Log.d("fmbd5", " ** 00 onCreate ActRadio  Set Transparent");
        super.onCreate(savedInstanceState);
    }

    @Override // com.lsec.core.frame.app.MyActivity, android.app.Activity
    protected void onDestroy() {
        for (MyAct myAct : this.mListMyActs) {
            myAct.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.lsec.core.frame.app.MyActivity
    public void handleIntent(Intent intent) {
        for (MyAct myAct : this.mListMyActs) {
            myAct.onNewIntent(intent, this);
        }
    }

    @Override // com.lsec.core.frame.app.MyActivity
    public void doActionResume() {
        super.doActionResume();
        if (!App_Radio.includePage(MyApplication.sPage_WillBe)) {
            MyApplication.sPage_WillBe = FinalRadioCtrl.Page_Radio;
        }
        MyAct myAct = getFixAct(MyApplication.sPage_WillBe);
        if (myAct != null && myAct.myActivity == null) {
            myAct.onCreate(this);
        }
        goPage(MyApplication.sPage_WillBe);
        if (myAct != null) {
            myAct.onResume();
        }
    }

    @Override // com.lsec.core.frame.app.MyActivity
    public void doActionPause() {
        super.doActionPause();
        MyAct myAct = getFixAct(MyApplication.sPage_Current);
        if (myAct != null) {
            myAct.onPause();
        }
        if (this.mPageCurrent != null) {
            this.mPageCurrent.pause();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        MyAct myAct = getFixAct(MyApplication.sPage_Current);
        if (myAct == null || !myAct.onKeyDown(keyCode, event)) {
            return super.onKeyDown(keyCode, event);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        MyAct myAct = getFixAct(MyApplication.sPage_Current);
        if (myAct == null || !myAct.onKeyUp(keyCode, event)) {
            return super.onKeyUp(keyCode, event);
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent event) {
        MyAct myAct = getFixAct(MyApplication.sPage_Current);
        if (myAct != null) {
            myAct.onTouchEvent(event);
        }
        return super.onTouchEvent(event);
    }

    @Override // com.lsec.core.frame.app.MyActivity
    public void requestAppIdRight() {
        MyApp myApp = getFixApp(MyApplication.sPage_Current);
        if (myApp != null) {
            myApp.requestAppIdRight();
        }
    }

    public MyAct getFixAct(int idPage) {
        for (MyAct myAct : this.mListMyActs) {
            if (myAct.includePage(idPage)) {
                return myAct;
            }
        }
        return null;
    }

    public MyApp getFixApp(int idPage) {
        for (MyAct myAct : this.mListMyActs) {
            if (myAct.includePage(idPage)) {
                return myAct.getMyApp();
            }
        }
        return null;
    }

    public MyUi getFixUi(int idPage) {
        MyAct myAct = getFixAct(idPage);
        if (myAct != null) {
            return myAct.ui;
        }
        return null;
    }

    @Override // com.lsec.core.frame.app.MyActivity
    public void goPage(int idPageTo) {
        Log.d("gdy10", "  00 goPage");
        MyAct myAct = getFixAct(idPageTo);
        if (myAct != null) {
            if (myAct.myActivity == null) {
                myAct.onCreate(this);
            }
            this.mPageMain.setBackground(myAct.getBackground());
            Log.d("gdy10", " **   goPage  App_Radio.bSetTransparent = " + App_Radio.bSetTransparent + " isTransparentPage = " + myAct.isTransparentPage(idPageTo) + " mStrCustomer = " + App.mStrCustomer);
            if (App_Radio.bSetTransparent) {
                myAct.getMyApp().myApplication.getTopActivity().setTransParentWindow(true);
                Window window = myAct.myActivity.getWindow();
                window.clearFlags(67108864);
                window.addFlags(ExploreByTouchHelper.INVALID_ID);
                window.setStatusBarColor(0);
            } else {
                myAct.setTransParentWindow(idPageTo);
            }
            myAct.addChild2Parent(this.mPageMain);
            idPageTo = myAct.getRightPage(idPageTo);
        }
        MyUi uiTo = getFixUi(idPageTo);
        if (uiTo != null) {
            int idPageFrom = -1;
            JPage pageFrom = this.mPageCurrent;
            if (pageFrom != null && (idPageFrom = pageFrom.getId()) == idPageTo) {
                if (!pageFrom.isNeedReload()) {
                    pageFrom.resume();
                    return;
                }
                pageFrom.removeFromUiPages();
            }
            JPage pageTo = uiTo.loadPage(true, idPageTo);
            if (pageTo != null) {
                Log.d("gdy10", "  11 goPage");
                MyApplication.sPage_Current = idPageTo;
                MyApplication.sPage_WillBe = MyApplication.sPage_Current;
                MyApp myApp = getFixApp(idPageTo);
                if (myApp != null) {
                    myApp.sPage = idPageTo;
                }
                if (this.mPageMain.indexOfChild(pageTo) < 0) {
                    this.mPageMain.addView(pageTo);
                }
                this.mPageCurrent = pageTo;
                if (pageFrom != null) {
                    Log.d("gdy10", "  33 goPage");
                    pageFrom.pause();
                    if (idPageFrom != idPageTo) {
                        pageFrom.removeFromUiPages();
                    }
                    ViewParent viewParent = pageFrom.getParent();
                    if (viewParent instanceof ViewGroup) {
                        ((ViewGroup) viewParent).removeView(pageFrom);
                    }
                }
                Log.d("gdy10", "  44 goPage");
                pageTo.resume();
                for (MyAct myActTmp : this.mListMyActs) {
                    myActTmp.doActionWhenGoPage(idPageTo);
                    if (!myActTmp.includePage(idPageTo)) {
                        myActTmp.removeChildFromParent(this.mPageMain);
                    }
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.d("gdd", "  00 onWindowFocusChanged   hasFocus = " + hasFocus);
        if (this.mActRadio != null) {
            this.mActRadio.windowFocusChanged(hasFocus);
        }
    }
}
