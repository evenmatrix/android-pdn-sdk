package com.viblast.android.vbplayerdemo;

import android.app.Activity;
import android.os.Bundle;

import com.viblast.android.ViblastConfig;
import com.viblast.android.ViblastPlayer;
import com.viblast.android.ViblastView;

public class MainActivity extends Activity {
	private ViblastPlayer viblastPlayer;
	private ViblastView viblastView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		viblastView = (ViblastView)findViewById(R.id.viblast_view);
		
		final ViblastConfig vbConfig = new ViblastConfig();
		
		// start faster, using the lowest resolution:
		vbConfig.advancedConfig.put("initial-abr-index", "0");

		vbConfig.setCdnStream("https://nimble.viblast.com:8081/live/abr.smil/playlist.m3u8");
		
		vbConfig.advancedConfig.put("enable-pdn", "true");
		vbConfig.advancedConfig.put("enable-realtime-loggger", "true");
		vbConfig.advancedConfig.put("realtime-logger-server", "wss://cs.viblast.com/rt");

		viblastPlayer = new ViblastPlayer(viblastView, vbConfig);
	}

	@Override
	protected void onStart() {
		super.onStart();
		
		viblastPlayer.start();
	}

	

	@Override
	protected void onStop() {
		viblastPlayer.stop();
		
		super.onStop();
	}


}