package com.example.aditi.tyrotrojan;

import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.content.Context;


class PhoneCallListener extends PhoneStateListener {

    String TAG = "LOGGING PHONE CALL";
    private boolean phoneCalling = false;
    @Override
    public void onCallStateChanged(int state, String incomingNumber) {

        if (TelephonyManager.CALL_STATE_RINGING == state) {
            Log.i(TAG, "RINGING, number: " + incomingNumber);
        }
        if (TelephonyManager.CALL_STATE_OFFHOOK == state) {

            Log.i(TAG, "OFFHOOK");

            phoneCalling = true;

        }


        if (TelephonyManager.CALL_STATE_IDLE == state) {

            Log.i(TAG, "IDLE");

            if (phoneCalling) {
                Log.i(TAG, "restart app");
                // restart app
               // Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
               // i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
               // startActivity(i);
                phoneCalling = false;
            }
        }
    }
}