package com.github.nagromc.nzbgetclient.net.listener;

import android.graphics.drawable.Drawable;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.util.Log;
import android.view.View;

import com.github.nagromc.nzbgetclient.NZBGetContext;
import com.github.nagromc.nzbgetclient.R;
import com.github.nagromc.nzbgetclient.activity.main.MainActivity;
import com.github.nagromc.nzbgetclient.activity.main.tab.downloads.DownloadsTabFragment;
import com.github.nagromc.nzbgetclient.model.Download;
import com.github.nagromc.nzbgetclient.model.GlobalDownloadStatus;
import com.github.nagromc.nzbgetclient.model.Status;
import com.github.nagromc.nzbgetclient.net.api.status.StatusResponseDto;
import com.github.nagromc.nzbgetclient.net.volley.NzbGetListener;

public class StatusListener extends NzbGetListener<StatusResponseDto.StatusResultDto> {

    private static final String TAG = StatusListener.class.getName();

    public StatusListener(MainActivity activity) {
        super(activity);
    }

    @Override
    public void onResponse(StatusResponseDto.StatusResultDto statusResultDto) {
        Log.d(TAG, "StatusListener.onResponse");

        Status status = NZBGetContext.getInstance().getStatus();
        Download totalDownload = status.getTotalDownload();

        long totalSize = statusResultDto.getDownloadedSize() + statusResultDto.getRemainingSize();
        totalDownload.setTotalSize(totalSize);
        totalDownload.setDownloadedSize(totalSize - statusResultDto.getRemainingSize());
        totalDownload.setRate(statusResultDto.getDownloadRate());

        DownloadsTabFragment downloadsFragment = ((MainActivity) activity).getPagerAdapter().getDownloadsTabFragment();
        downloadsFragment.refreshFooter(status);


        status.setGlobalDownloadStatus(GlobalDownloadStatus.fromBoolean(!statusResultDto.isDownloadPaused()));
    }

}
