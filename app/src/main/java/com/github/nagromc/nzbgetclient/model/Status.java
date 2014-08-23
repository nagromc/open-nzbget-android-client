package com.github.nagromc.nzbgetclient.model;

import com.github.nagromc.nzbgetclient.utils.DownloadUtils;

public class Status {

    private Download totalDownload;

    public Status() {
        this.totalDownload = new Download();
    }

    public Download getTotalDownload() {
        return totalDownload;
    }

    public void setTotalDownload(Download totalDownload) {
        this.totalDownload = totalDownload;
    }
}
