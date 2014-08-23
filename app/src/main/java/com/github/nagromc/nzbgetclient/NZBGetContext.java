package com.github.nagromc.nzbgetclient;

import com.github.nagromc.nzbgetclient.model.Download;
import com.github.nagromc.nzbgetclient.model.Status;

import java.util.ArrayList;
import java.util.List;

public class NZBGetContext {

    private Status status;
    private List<Download> downloads;

    private static NZBGetContext instance;

    public static NZBGetContext getInstance() {
        if (instance == null) {
            instance = new NZBGetContext();
        }

        return instance;
    }

    public NZBGetContext() {
        this.status = new Status();
        this.downloads = new ArrayList<Download>();
    }

    public List<Download> getDownloads() {
        return downloads;
    }

    public void setDownloads(List<Download> downloads) {
        this.downloads = downloads;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
