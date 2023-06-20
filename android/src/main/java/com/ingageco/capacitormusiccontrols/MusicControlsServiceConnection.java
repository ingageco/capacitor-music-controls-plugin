package com.ingageco.capacitormusiccontrols;

import android.app.Activity;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

public class MusicControlsServiceConnection implements ServiceConnection {
    protected MusicControlsNotificationKiller service;
    protected Activity activity;

    MusicControlsServiceConnection(Activity activity) {
        this.activity = activity;
    }

    public void onServiceConnected(ComponentName className, IBinder binder) {
        this.service = ((KillBinder) binder).service;
        this.service.startService(new Intent(activity, MusicControlsNotificationKiller.class));
    }

    public void onServiceDisconnected(ComponentName className) {
    }

    void setNotification(Notification notification, boolean isPlaying) {
        if (this.service == null) {
            return;
        }

        if (isPlaying) {
            this.service.setForeground(notification);
        } else {
            this.service.clearForeground();
        }
    }
}