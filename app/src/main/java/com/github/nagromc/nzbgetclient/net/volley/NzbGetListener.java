package com.github.nagromc.nzbgetclient.net.volley;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.github.nagromc.nzbgetclient.R;
import com.github.nagromc.nzbgetclient.activity.main.MainActivity;

import java.net.UnknownHostException;

public abstract class NzbGetListener<T> implements Listener<T>,
		ErrorListener {

	private static final String TAG = NzbGetListener.class.getName();

	protected Activity activity;

	public NzbGetListener(Activity activity) {
		this.activity = activity;
	}

	public void onErrorResponse(VolleyError error) {
		String logErrorMessage = String.format("%s (in class %s)", error.getMessage(), this.getClass());
		Log.e(TAG, logErrorMessage, error.getCause());

		String message;
		if (error.getCause() instanceof UnknownHostException) {
			message = activity.getResources().getString(R.string.error_message_unreachable_host);
		} else {
			message = activity.getResources().getString(R.string.error_message_unkown);
		}

		Toast toast = Toast.makeText(activity, message, Toast.LENGTH_LONG);
		toast.show();
	}

}
