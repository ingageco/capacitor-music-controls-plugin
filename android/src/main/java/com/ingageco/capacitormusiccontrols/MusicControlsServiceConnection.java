package com.ingageco.capacitormusiccontrols;

import android.app.Activity;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import android.os.Build;


public class MusicControlsServiceConnection implements ServiceConnection {
    private static final String TAG = "MusicControlsServiceConnection";

    protected MusicControlsNotificationKiller service;
    protected Activity activity;

    MusicControlsServiceConnection(Activity activity) {
        this.activity = activity;
    }

    public void onServiceConnected(ComponentName className, IBinder binder) {

        Log.i(TAG, "onServiceConnected");

        this.service = ((KillBinder) binder).service;

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            this.service.startService(new Intent(activity, MusicControlsNotificationKiller.class));
        }
    }

    public void onServiceDisconnected(ComponentName className) {
        Log.i(TAG, "onServiceDisconnected");

    }

    void setNotification(Notification notification, boolean isPlaying) {
        if (this.service == null) {
            return;
        }

        Log.i(TAG, "setNotification");

        if (isPlaying) {
            this.service.setForeground(notification, this.activity);
        } else {
            this.service.clearForeground();
        }
    }
}