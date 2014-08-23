package com.github.nagromc.nzbgetclient.debug.net.listener;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

import com.github.nagromc.nzbgetclient.R;
import com.github.nagromc.nzbgetclient.net.volley.NzbGetListener;

public class PauseDownloadListener extends NzbGetListener<Boolean> {

	private static final String TAG = PauseDownloadListener.class.getName();

	public PauseDownloadListener(Activity callingActivity) {
		super(callingActivity);
	}

	@Override
	public void onResponse(Boolean result) {
		Log.i(TAG, "Download paused");

		TextView textView = (TextView) this.activity.findViewById(R.id.textView_result);
		textView.setText(String.format("Download paused (server replied %s)", result.toString()));
	}

}
