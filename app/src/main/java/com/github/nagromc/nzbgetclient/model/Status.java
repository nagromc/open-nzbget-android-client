package com.github.nagromc.nzbgetclient.model;

import java.util.Observable;

public class Status extends Observable {

    private boolean isUpdated = false;
    private GlobalDownloadStatus globalDownloadStatus;
    private Download totalDownload;

    public Status() {
        this.totalDownload = new Download();
    }

    public GlobalDownloadStatus getGlobalDownloadStatus() {
        return globalDownloadStatus;
    }

    public void setGlobalDownloadStatus(GlobalDownloadStatus globalDownloadStatus) {
        this.globalDownloadStatus = globalDownloadStatus;
        setUpdated();
    }

    public Download getTotalDownload() {
        return totalDownload;
    }

    public void setTotalDownload(Download totalDownload) {
        this.totalDownload = totalDownload;
        setUpdated();
    }

    public boolean isDownloading() {
        return GlobalDownloadStatus.DOWNLOADING.equals(getGlobalDownloadStatus());
    }

    private void setUpdated() {
        isUpdated = true;
        this.setChanged();
    }

    public boolean isUpdated() {
        return isUpdated;
    }
}
