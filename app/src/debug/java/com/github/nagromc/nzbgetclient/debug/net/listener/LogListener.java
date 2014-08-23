package com.github.nagromc.nzbgetclient.debug.net.listener;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

import com.github.nagromc.nzbgetclient.R;
import com.github.nagromc.nzbgetclient.net.api.log.LogResponseDto.LogResultDto;
import com.github.nagromc.nzbgetclient.net.volley.NzbGetListener;

public class LogListener extends NzbGetListener<LogResultDto[]> {

	private static final String TAG = LogListener.class.getName();

	public LogListener(Activity callingActivity) {
		super(callingActivity);
	}

	@Override
	public void onResponse(LogResultDto[] results) {
		StringBuffer buf = new StringBuffer();
		
		for (LogResultDto result : results) {
			buf.append(result.getText() + " \n ");
		}
		
		Log.i(TAG, String.format("result: %s", buf.toString()));

		TextView textView = (TextView) this.activity.findViewById(R.id.textView_result);
		textView.setText(buf.toString());
	}

}
