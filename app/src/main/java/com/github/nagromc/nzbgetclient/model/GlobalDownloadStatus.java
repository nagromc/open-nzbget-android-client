package com.github.nagromc.nzbgetclient.model;

import com.github.nagromc.nzbgetclient.R;

public enum GlobalDownloadStatus {

    // display "play" icon when NZBGet is paused
    PAUSED(R.drawable.ic_actionbar_action_play),
    // display "pause" icon when NZBGet is downloading
    DOWNLOADING(R.drawable.ic_actionbar_action_pause);

    private int resourceId;

    private GlobalDownloadStatus(int resourceId) {
        this.resourceId = resourceId;
    }

    public static GlobalDownloadStatus fromBoolean(boolean isDownloading) {
        return isDownloading ? DOWNLOADING : PAUSED;
    }

    public int getResourceId() {
        return resourceId;
    }

}
