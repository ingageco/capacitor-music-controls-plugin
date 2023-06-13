package com.ingageco.capacitormusiccontrols;

import android.os.Binder;

public class KillBinder extends Binder {
	public final MusicControlsNotificationKiller service;

	public KillBinder(MusicControlsNotificationKiller service) {
		this.service = service;
	}
}
