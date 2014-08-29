package com.github.nagromc.nzbgetclient.net.listener;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.util.Log;

import com.github.nagromc.nzbgetclient.NZBGetContext;
import com.github.nagromc.nzbgetclient.R;
import com.github.nagromc.nzbgetclient.model.GlobalDownloadStatus;
import com.github.nagromc.nzbgetclient.model.Status;
import com.github.nagromc.nzbgetclient.net.volley.NzbGetListener;

public class ResumeDownloadListener extends NzbGetListener<Boolean> {

    private static final String TAG = ResumeDownloadListener.class.getName();

    public ResumeDownloadListener(Activity activity) {
        super(activity);
    }

    @Override
    public void onResponse(Boolean isDownloading) {
        Log.d(TAG, "ResumeDownloadListener.onResponse");

        Status status = NZBGetContext.getInstance().getStatus();
        status.setGlobalDownloadStatus(GlobalDownloadStatus.fromBoolean(isDownloading));

        ActionMenuItemView actionView = (ActionMenuItemView) this.activity.findViewById(R.id.action_toggle_pause_resume);
        Drawable icon = activity.getResources().getDrawable(status.getGlobalDownloadStatus().getResourceId());
        actionView.setIcon(icon);
    }

}
