package com.github.nagromc.nzbgetclient.model;

public class Status {

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
    }

    public Download getTotalDownload() {
        return totalDownload;
    }

    public void setTotalDownload(Download totalDownload) {
        this.totalDownload = totalDownload;
    }

    public boolean isDownloading() {
        return GlobalDownloadStatus.DOWNLOADING.equals(getGlobalDownloadStatus());
    }

}
