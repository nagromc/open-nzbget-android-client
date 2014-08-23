package com.github.nagromc.nzbgetclient.debug.net.listener;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

import com.github.nagromc.nzbgetclient.R;
import com.github.nagromc.nzbgetclient.net.volley.NzbGetListener;

public class VersionListener extends NzbGetListener<String> {

	private static final String TAG = VersionListener.class.getName();

	public VersionListener(Activity callingActivity) {
		super(callingActivity);
	}

	@Override
	public void onResponse(String result) {
		Log.i(TAG, String.format("Version number: %s", result));

		TextView textView = (TextView) this.activity.findViewById(R.id.textView_result);
		textView.setText(result.toString());
	}

}
