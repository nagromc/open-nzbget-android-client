package com.github.nagromc.nzbgetclient.net.listener;

import android.app.Activity;
import android.util.Log;

import com.github.nagromc.nzbgetclient.NZBGetContext;
import com.github.nagromc.nzbgetclient.model.GlobalDownloadStatus;
import com.github.nagromc.nzbgetclient.model.Status;
import com.github.nagromc.nzbgetclient.net.volley.NzbGetListener;

public class PauseDownloadListener extends NzbGetListener<Boolean> {

    private static final String TAG = PauseDownloadListener.class.getName();

    public PauseDownloadListener(Activity activity) {
        super(activity);
    }

    @Override
    public void onResponse(Boolean isPaused) {
        Log.d(TAG, "PauseDownloadListener.onResponse");

        Status status = NZBGetContext.getInstance().getStatus();
        status.setGlobalDownloadStatus(GlobalDownloadStatus.fromBoolean(!isPaused));
        status.notifyObservers();
    }

}
