package com.ingageco.capacitormusiccontrols;


import com.getcapacitor.JSObject;

import android.util.Log;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.content.BroadcastReceiver;
import android.view.KeyEvent;

public class MusicControlsBroadcastReceiver extends BroadcastReceiver {

	private static final String TAG = "CMCBroadRcvr";


	private CapacitorMusicControls musicControls;


	public MusicControlsBroadcastReceiver(CapacitorMusicControls musicControls){
		this.musicControls=musicControls;
	}


	public void stopListening(){

		JSObject ret = new JSObject();
		ret.put("message", "music-controls-stop-listening");

		this.musicControls.controlsNotification(ret);

	}

	@Override
	public void onReceive(Context context, Intent intent) {

		String message = intent.getAction();
		JSObject ret = new JSObject();

		Log.i(TAG, "onReceive fired "  + message);



		if(message.equals(Intent.ACTION_HEADSET_PLUG)){
				// Headphone plug/unplug
				int state = intent.getIntExtra("state", -1);
				switch (state) {
					case 0:

						ret.put("message", "music-controls-headset-unplugged");

						this.musicControls.controlsNotification(ret);

						this.musicControls.unregisterMediaButtonEvent();
						break;
					case 1:


						ret.put("message", "music-controls-headset-plugged");

						this.musicControls.registerMediaButtonEvent();
						break;
					default:
						break;
				}
			} else if (message.equals("music-controls-media-button")){
				// Media button
				KeyEvent event = (KeyEvent) intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
				if (event.getAction() == KeyEvent.ACTION_DOWN) {

					int keyCode = event.getKeyCode();
					switch (keyCode) {
						case KeyEvent.KEYCODE_MEDIA_NEXT:
							ret.put("message", "music-controls-media-button-next");
							this.musicControls.controlsNotification(ret);
							break;
						case KeyEvent.KEYCODE_MEDIA_PAUSE:
							ret.put("message", "music-controls-media-button-pause");
							this.musicControls.controlsNotification(ret);
							//this.cb.success("{\"message\": \"music-controls-media-button-pause\"}");
							break;
						case KeyEvent.KEYCODE_MEDIA_PLAY:
							ret.put("message", "music-controls-media-button-play");
							this.musicControls.controlsNotification(ret);
							//this.cb.success("{\"message\": \"music-controls-media-button-play\"}");
							break;
						case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE:
							ret.put("message", "music-controls-media-button-play-pause");
							this.musicControls.controlsNotification(ret);
							//this.cb.success("{\"message\": \"music-controls-media-button-play-pause\"}");
							break;
						case KeyEvent.KEYCODE_MEDIA_PREVIOUS:
							ret.put("message", "music-controls-media-button-previous");
							this.musicControls.controlsNotification(ret);
							//this.cb.success("{\"message\": \"music-controls-media-button-previous\"}");
							break;
						case KeyEvent.KEYCODE_MEDIA_STOP:
							ret.put("message", "music-controls-media-button-stop");
							this.musicControls.controlsNotification(ret);
							//this.cb.success("{\"message\": \"music-controls-media-button-stop\"}");
							break;
						case KeyEvent.KEYCODE_MEDIA_FAST_FORWARD:
							ret.put("message", "music-controls-media-button-fast-forward");
							this.musicControls.controlsNotification(ret);
							//this.cb.success("{\"message\": \"music-controls-media-button-fast-forward\"}");
							break;
						case KeyEvent.KEYCODE_MEDIA_REWIND:
							ret.put("message", "music-controls-media-button-rewind");
							this.musicControls.controlsNotification(ret);
							//this.cb.success("{\"message\": \"music-controls-media-button-rewind\"}");
							break;
						case KeyEvent.KEYCODE_MEDIA_SKIP_BACKWARD:
							ret.put("message", "music-controls-media-button-skip-backward");
							this.musicControls.controlsNotification(ret);
							//this.cb.success("{\"message\": \"music-controls-media-button-skip-backward\"}");
							break;
						case KeyEvent.KEYCODE_MEDIA_SKIP_FORWARD:
							ret.put("message", "music-controls-media-button-skip-forward");
							this.musicControls.controlsNotification(ret);
							//this.cb.success("{\"message\": \"music-controls-media-button-skip-forward\"}");
							break;
						case KeyEvent.KEYCODE_MEDIA_STEP_BACKWARD:
							ret.put("message", "music-controls-media-button-step-backward");
							this.musicControls.controlsNotification(ret);
							//this.cb.success("{\"message\": \"music-controls-media-button-step-backward\"}");
							break;
						case KeyEvent.KEYCODE_MEDIA_STEP_FORWARD:
							ret.put("message", "music-controls-media-button-step-forward");
							this.musicControls.controlsNotification(ret);
							//this.cb.success("{\"message\": \"music-controls-media-button-step-forward\"}");
							break;
						case KeyEvent.KEYCODE_META_LEFT:
							ret.put("message", "music-controls-media-button-meta-left");
							this.musicControls.controlsNotification(ret);
							//this.cb.success("{\"message\": \"music-controls-media-button-meta-left\"}");
							break;
						case KeyEvent.KEYCODE_META_RIGHT:
							ret.put("message", "music-controls-media-button-meta-right");
							this.musicControls.controlsNotification(ret);
							//this.cb.success("{\"message\": \"music-controls-media-button-meta-right\"}");
							break;
						case KeyEvent.KEYCODE_MUSIC:
							ret.put("message", "music-controls-media-button-music");
							this.musicControls.controlsNotification(ret);
							//this.cb.success("{\"message\": \"music-controls-media-button-music\"}");
							break;
						case KeyEvent.KEYCODE_VOLUME_UP:
							ret.put("message", "music-controls-media-button-volume-up");
							this.musicControls.controlsNotification(ret);
							//this.cb.success("{\"message\": \"music-controls-media-button-volume-up\"}");
							break;
						case KeyEvent.KEYCODE_VOLUME_DOWN:
							ret.put("message", "music-controls-media-button-volume-down");
							this.musicControls.controlsNotification(ret);
							//this.cb.success("{\"message\": \"music-controls-media-button-volume-down\"}");
							break;
						case KeyEvent.KEYCODE_VOLUME_MUTE:
							ret.put("message", "music-controls-media-button-volume-mute");
							this.musicControls.controlsNotification(ret);
							//this.cb.success("{\"message\": \"music-controls-media-button-volume-mute\"}");
							break;
						case KeyEvent.KEYCODE_HEADSETHOOK:
							ret.put("message", "music-controls-media-button-headset-hook");
							this.musicControls.controlsNotification(ret);
							//this.cb.success("{\"message\": \"music-controls-media-button-headset-hook\"}");
							break;
						default:
							ret.put("message", message);
							this.musicControls.controlsNotification(ret);
							//this.cb.success("{\"message\": \"" + message + "\"}");
							break;
					}
				}
			} else if (message.equals("music-controls-destroy")){
				// Close Button
			ret.put("message", "music-controls-destroy");

			this.musicControls.controlsNotification(ret);
//				this.cb.success("{\"message\": \"music-controls-destroy\"}");
//				this.cb = null;
				this.musicControls.destroyPlayerNotification();
			} else {
			ret.put("message", message);
			this.musicControls.controlsNotification(ret);
//				this.cb.success("{\"message\": \"" + message + "\"}");
//				this.cb = null;
			}


	}
}
