package com.github.nagromc.nzbgetclient.model;

import java.util.Observable;

public class Status extends Observable {

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
        this.setChanged();
    }

    public Download getTotalDownload() {
        return totalDownload;
    }

    public void setTotalDownload(Download totalDownload) {
        this.totalDownload = totalDownload;
        this.setChanged();
    }

    public boolean isDownloading() {
        return GlobalDownloadStatus.DOWNLOADING.equals(getGlobalDownloadStatus());
    }

}
