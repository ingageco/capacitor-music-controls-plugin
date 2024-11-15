package com.ingageco.capacitormusiccontrols;

import android.app.Activity;
import android.app.Notification;
import android.app.Service;
import android.os.Build;
import android.os.IBinder;
import android.os.Binder;
import android.app.NotificationManager;
import android.content.Intent;
import android.util.Log;

public class MusicControlsNotificationKiller extends Service {
	private static final String TAG = "MusicControlsNotificationKiller";

	private static int NOTIFICATION_ID;
	private NotificationManager mNM;
	private final IBinder mBinder = new KillBinder(this);
	private boolean isRunning = false;

	@Override
	public IBinder onBind(Intent intent) {
		this.NOTIFICATION_ID=intent.getIntExtra("notificationID",1);
		return mBinder;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i(TAG, "onStartCommand");

		return Service.START_STICKY;
	}

	@Override
	public void onCreate() {
		Log.i(TAG, "onCreate");

		// this.startForeground();

		mNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		mNM.cancel(NOTIFICATION_ID);
	}

	@Override
	public void onDestroy() {
		Log.i(TAG, "onDestroy");

		mNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		mNM.cancel(NOTIFICATION_ID);
		this.isRunning = false;
	}

	@Override
	public void onTaskRemoved(Intent intent) {
		Log.i(TAG, "onTaskRemoved");

		mNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		mNM.cancel(NOTIFICATION_ID);
	}

	public void setForeground(Notification notification, Activity activity) {

		Log.i(TAG, "setForeground");

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && !this.isRunning) {
            Log.i(TAG, "startForegroundService");
            this.isRunning = true;
            this.startForegroundService(new Intent(activity, MusicControlsNotificationKiller.class));
        }

		this.startForeground(this.NOTIFICATION_ID, notification);
	}

	public void clearForeground() {
		if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
			return;
		}

		Log.i(TAG, "clearForeground");

		this.stopForeground(STOP_FOREGROUND_DETACH);
	}

}
