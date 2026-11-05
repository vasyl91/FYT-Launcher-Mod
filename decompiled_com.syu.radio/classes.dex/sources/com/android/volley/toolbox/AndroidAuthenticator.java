package com.android.volley.toolbox;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.android.volley.AuthFailureError;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class AndroidAuthenticator implements Authenticator {
    private final Account mAccount;
    private final AccountManager mAccountManager;
    private final String mAuthTokenType;
    private final boolean mNotifyAuthFailure;

    public AndroidAuthenticator(Context context, Account account, String authTokenType) {
        this(context, account, authTokenType, false);
    }

    public AndroidAuthenticator(Context context, Account account, String authTokenType, boolean notifyAuthFailure) {
        this(AccountManager.get(context), account, authTokenType, notifyAuthFailure);
    }

    AndroidAuthenticator(AccountManager accountManager, Account account, String authTokenType, boolean notifyAuthFailure) {
        this.mAccountManager = accountManager;
        this.mAccount = account;
        this.mAuthTokenType = authTokenType;
        this.mNotifyAuthFailure = notifyAuthFailure;
    }

    public Account getAccount() {
        return this.mAccount;
    }

    @Override // com.android.volley.toolbox.Authenticator
    public String getAuthToken() throws AuthFailureError {
        AccountManagerFuture<Bundle> future = this.mAccountManager.getAuthToken(this.mAccount, this.mAuthTokenType, this.mNotifyAuthFailure, null, null);
        try {
            Bundle result = future.getResult();
            String authToken = null;
            if (future.isDone() && !future.isCancelled()) {
                if (result.containsKey("intent")) {
                    Intent intent = (Intent) result.getParcelable("intent");
                    throw new AuthFailureError(intent);
                }
                authToken = result.getString("authtoken");
            }
            if (authToken == null) {
                throw new AuthFailureError("Got null auth token for type: " + this.mAuthTokenType);
            }
            return authToken;
        } catch (Exception e) {
            throw new AuthFailureError("Error while retrieving auth token", e);
        }
    }

    @Override // com.android.volley.toolbox.Authenticator
    public void invalidateAuthToken(String authToken) {
        this.mAccountManager.invalidateAuthToken(this.mAccount.type, authToken);
    }
}
