package com.github.nagromc.nzbgetclient.model;

import com.github.nagromc.nzbgetclient.utils.DownloadUtils;

import java.util.Observable;

public class Download extends Observable {

    /** Total size of the download in bytes */
    protected long totalSize;
    /** Downloaded size in bytes */
    protected long downloadedSize;
    /** Download rate in bytes/s */
    protected long rate;

    /**
     * Returns the remaining time (aka ETA) in seconds to be downloaded.
     */
    public long getEta() {
        return DownloadUtils.computeEta(this.downloadedSize, this.totalSize, this.rate);
    }

    /**
     * Returns the completion percentage.
     */
    public int getPercentage() {
        return DownloadUtils.computePercentage(this.downloadedSize, this.totalSize);
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public long getDownloadedSize() {
        return downloadedSize;
    }

    public void setDownloadedSize(long downloadedSize) {
        this.downloadedSize = downloadedSize;
    }

    public long getRate() {
        return rate;
    }

    public void setRate(long rate) {
        this.rate = rate;
    }
}
