package com.google.games.bridge;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.AccountPicker;
import com.google.android.gms.common.api.PendingResult;
import java.util.ArrayList;
import java.util.List;

@TargetApi(11)
public class TokenFragment extends Fragment {
    private static final String FRAGMENT_TAG = "gpg.TokenSupport";
    private static final int RC_ACCT = 9002;
    private static final String TAG = "TokenFragment";
    private static String currentPlayerId;
    private static boolean mIsSelecting = false;
    private static final List<TokenRequest> pendingTokenRequests = new ArrayList();
    private static String selectedAccountName;

    private static class TokenRequest {
        private boolean doAccessToken;
        private boolean doEmail;
        private boolean doIdToken;
        private TokenPendingResult pendingResponse = new TokenPendingResult();
        private String rationale;
        private String scope;

        public TokenRequest(boolean fetchEmail, boolean fetchAccessToken, boolean fetchIdToken, String scope) {
            this.doEmail = fetchEmail;
            this.doAccessToken = fetchAccessToken;
            this.doIdToken = fetchIdToken;
            this.scope = scope;
        }

        public PendingResult getPendingResponse() {
            return this.pendingResponse;
        }

        public void setResult(int code) {
            this.pendingResponse.setStatus(code);
        }

        public void setEmail(String email) {
            this.pendingResponse.setEmail(email);
        }

        public void cancel() {
            this.pendingResponse.cancel();
        }

        public String getScope() {
            return this.scope;
        }

        public void setAccessToken(String accessToken) {
            this.pendingResponse.setAccessToken(accessToken);
        }

        public void setIdToken(String idToken) {
            this.pendingResponse.setIdToken(idToken);
        }

        public String getEmail() {
            return this.pendingResponse.result.getEmail();
        }

        public String getIdToken() {
            return this.pendingResponse.result.getIdToken();
        }

        public String getAccessToken() {
            return this.pendingResponse.result.getAccessToken();
        }

        public String getRationale() {
            return this.rationale;
        }

        public void setRationale(String rationale) {
            this.rationale = rationale;
        }

        public String toString() {
            return Integer.toHexString(hashCode()) + " (e:" + this.doEmail + " a:" + this.doAccessToken + " i:" + this.doIdToken + ")";
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.common.api.PendingResult fetchToken(android.app.Activity r9, java.lang.String r10, java.lang.String r11, boolean r12, boolean r13, boolean r14, java.lang.String r15) {
        /*
        r2 = new com.google.games.bridge.TokenFragment$TokenRequest;
        r2.<init>(r12, r13, r14, r15);
        r2.setRationale(r11);
        r6 = pendingTokenRequests;
        monitor-enter(r6);
        if (r10 == 0) goto L_0x0015;
    L_0x000d:
        r5 = currentPlayerId;	 Catch:{ all -> 0x0083 }
        r5 = r10.equals(r5);	 Catch:{ all -> 0x0083 }
        if (r5 != 0) goto L_0x001a;
    L_0x0015:
        currentPlayerId = r10;	 Catch:{ all -> 0x0083 }
        r5 = 0;
        selectedAccountName = r5;	 Catch:{ all -> 0x0083 }
    L_0x001a:
        r5 = selectedAccountName;	 Catch:{ all -> 0x0083 }
        if (r5 == 0) goto L_0x004d;
    L_0x001e:
        if (r12 == 0) goto L_0x004d;
    L_0x0020:
        if (r13 != 0) goto L_0x004d;
    L_0x0022:
        if (r14 != 0) goto L_0x004d;
    L_0x0024:
        r5 = "TokenFragment";
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0083 }
        r7.<init>();	 Catch:{ all -> 0x0083 }
        r8 = "Returning accountName: ";
        r7 = r7.append(r8);	 Catch:{ all -> 0x0083 }
        r8 = selectedAccountName;	 Catch:{ all -> 0x0083 }
        r7 = r7.append(r8);	 Catch:{ all -> 0x0083 }
        r7 = r7.toString();	 Catch:{ all -> 0x0083 }
        android.util.Log.i(r5, r7);	 Catch:{ all -> 0x0083 }
        r5 = selectedAccountName;	 Catch:{ all -> 0x0083 }
        r2.setEmail(r5);	 Catch:{ all -> 0x0083 }
        r5 = 0;
        r2.setResult(r5);	 Catch:{ all -> 0x0083 }
        r5 = r2.getPendingResponse();	 Catch:{ all -> 0x0083 }
        monitor-exit(r6);	 Catch:{ all -> 0x0083 }
    L_0x004c:
        return r5;
    L_0x004d:
        r5 = pendingTokenRequests;	 Catch:{ all -> 0x0083 }
        r5.add(r2);	 Catch:{ all -> 0x0083 }
        monitor-exit(r6);	 Catch:{ all -> 0x0083 }
        r5 = r9.getFragmentManager();
        r6 = "gpg.TokenSupport";
        r0 = r5.findFragmentByTag(r6);
        r0 = (com.google.games.bridge.TokenFragment) r0;
        if (r0 != 0) goto L_0x00b5;
    L_0x0061:
        r5 = "TokenFragment";
        r6 = "Creating fragment";
        android.util.Log.d(r5, r6);	 Catch:{ Throwable -> 0x0086 }
        r1 = new com.google.games.bridge.TokenFragment;	 Catch:{ Throwable -> 0x0086 }
        r1.<init>();	 Catch:{ Throwable -> 0x0086 }
        r5 = r9.getFragmentManager();	 Catch:{ Throwable -> 0x00cc }
        r4 = r5.beginTransaction();	 Catch:{ Throwable -> 0x00cc }
        r5 = "gpg.TokenSupport";
        r4.add(r1, r5);	 Catch:{ Throwable -> 0x00cc }
        r4.commit();	 Catch:{ Throwable -> 0x00cc }
        r0 = r1;
    L_0x007e:
        r5 = r2.getPendingResponse();
        goto L_0x004c;
    L_0x0083:
        r5 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0083 }
        throw r5;
    L_0x0086:
        r3 = move-exception;
    L_0x0087:
        r5 = "TokenFragment";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "Cannot launch token fragment:";
        r6 = r6.append(r7);
        r7 = r3.getMessage();
        r6 = r6.append(r7);
        r6 = r6.toString();
        android.util.Log.e(r5, r6, r3);
        r5 = 13;
        r2.setResult(r5);
        r6 = pendingTokenRequests;
        monitor-enter(r6);
        r5 = pendingTokenRequests;	 Catch:{ all -> 0x00b2 }
        r5.remove(r2);	 Catch:{ all -> 0x00b2 }
        monitor-exit(r6);	 Catch:{ all -> 0x00b2 }
        goto L_0x007e;
    L_0x00b2:
        r5 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x00b2 }
        throw r5;
    L_0x00b5:
        r6 = pendingTokenRequests;
        monitor-enter(r6);
        r5 = mIsSelecting;	 Catch:{ all -> 0x00c9 }
        if (r5 != 0) goto L_0x00c7;
    L_0x00bc:
        r5 = "TokenFragment";
        r7 = "Fragment exists.. and not selecting calling processRequests";
        android.util.Log.d(r5, r7);	 Catch:{ all -> 0x00c9 }
        r5 = 0;
        r0.processRequests(r5);	 Catch:{ all -> 0x00c9 }
    L_0x00c7:
        monitor-exit(r6);	 Catch:{ all -> 0x00c9 }
        goto L_0x007e;
    L_0x00c9:
        r5 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x00c9 }
        throw r5;
    L_0x00cc:
        r3 = move-exception;
        r0 = r1;
        goto L_0x0087;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.games.bridge.TokenFragment.fetchToken(android.app.Activity, java.lang.String, java.lang.String, boolean, boolean, boolean, java.lang.String):com.google.android.gms.common.api.PendingResult");
    }

    private void processRequests(int errorCode) {
        TokenRequest request = null;
        if (errorCode != 0) {
            synchronized (pendingTokenRequests) {
                while (!pendingTokenRequests.isEmpty()) {
                    request = (TokenRequest) pendingTokenRequests.remove(0);
                    Log.d(TAG, " Setting result to " + errorCode + " for " + request);
                    request.setResult(errorCode);
                }
            }
            return;
        }
        synchronized (pendingTokenRequests) {
            if (!pendingTokenRequests.isEmpty()) {
                request = (TokenRequest) pendingTokenRequests.get(0);
            }
            String acctName = selectedAccountName;
        }
        if (request != null) {
            if (acctName == null) {
                synchronized (pendingTokenRequests) {
                    mIsSelecting = true;
                }
                ArrayList arrayList = null;
                startActivityForResult(AccountPicker.newChooseAccountIntent(null, arrayList, new String[]{"com.google"}, true, request.getRationale(), null, null, null), 9002);
            } else {
                synchronized (pendingTokenRequests) {
                    while (!pendingTokenRequests.isEmpty()) {
                        try {
                            request = (TokenRequest) pendingTokenRequests.remove(0);
                            if (request != null) {
                                doGetToken(request, acctName);
                            }
                        } catch (Throwable th) {
                            if (request != null) {
                                Log.e(TAG, "Cannot process request", th);
                                request.setResult(13);
                            }
                        }
                    }
                }
            }
            Log.d(TAG, "Done with processRequests!");
        }
    }

    private void doGetToken(final TokenRequest tokenRequest, final String accountName) {
        final Activity theActivity = getActivity();
        Log.d(TAG, "Calling doGetToken for e: " + tokenRequest.doEmail + " a:" + tokenRequest.doAccessToken + " i:" + tokenRequest.doIdToken);
        new AsyncTask<Object, Integer, Integer>() {
            protected Integer doInBackground(Object[] params) {
                int statusCode = 0;
                tokenRequest.setEmail(accountName);
                if (tokenRequest.doAccessToken && accountName != null) {
                    String accessScope = "oauth2:https://www.googleapis.com/auth/plus.me";
                    try {
                        Log.d(TokenFragment.TAG, "getting accessToken for " + accountName);
                        tokenRequest.setAccessToken(GoogleAuthUtil.getToken(theActivity, accountName, accessScope));
                    } catch (Throwable th) {
                        Log.e(TokenFragment.TAG, "Exception getting access token", th);
                        statusCode = 8;
                    }
                }
                if (!tokenRequest.doIdToken || accountName == null) {
                    if (tokenRequest.doIdToken) {
                        Log.e(TokenFragment.TAG, "Skipping ID token: email is empty?");
                    }
                } else if (tokenRequest.getScope() == null || tokenRequest.getScope().isEmpty()) {
                    Log.w(TokenFragment.TAG, "Skipping ID token: scope is empty");
                    statusCode = 10;
                } else {
                    try {
                        Log.d(TokenFragment.TAG, "Getting ID token.  Scope = " + tokenRequest.getScope() + " email: " + accountName);
                        tokenRequest.setIdToken(GoogleAuthUtil.getToken(theActivity, accountName, tokenRequest.getScope()));
                    } catch (Throwable th2) {
                        Log.e(TokenFragment.TAG, "Exception getting access token", th2);
                        statusCode = 8;
                    }
                }
                Log.d(TokenFragment.TAG, "Done with tokenRequest status: " + statusCode);
                return Integer.valueOf(statusCode);
            }

            protected void onCancelled() {
                super.onCancelled();
                tokenRequest.cancel();
            }

            protected void onPostExecute(Integer statusCode) {
                Log.d(TokenFragment.TAG, "onPostExecute for the token fetch");
                tokenRequest.setResult(statusCode.intValue());
            }
        }.execute(new Object[0]);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult: " + requestCode + ": " + resultCode);
        if (requestCode == 9002) {
            int status = resultCode;
            String accountName = selectedAccountName;
            if (resultCode == -1) {
                status = 0;
                accountName = data.getStringExtra("authAccount");
            } else if (resultCode == 0) {
                status = 16;
            }
            synchronized (pendingTokenRequests) {
                selectedAccountName = accountName;
                mIsSelecting = false;
            }
            processRequests(status);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void onResume() {
        Log.d(TAG, "onResume called");
        processRequests(0);
        super.onResume();
    }
}
