package com.github.nagromc.nzbgetclient.debug.net.listener;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

import com.github.nagromc.nzbgetclient.R;
import com.github.nagromc.nzbgetclient.net.volley.NzbGetListener;

public class ResumeDownloadListener extends NzbGetListener<Boolean> {

	private static final String TAG = ResumeDownloadListener.class.getName();

	public ResumeDownloadListener(Activity callingActivity) {
		super(callingActivity);
	}

	@Override
	public void onResponse(Boolean result) {
		Log.i(TAG, "Download resumed");

		TextView textView = (TextView) this.activity.findViewById(R.id.textView_result);
		textView.setText(String.format("Download resumed (server replied %s)",
				result.toString()));
	}

}
