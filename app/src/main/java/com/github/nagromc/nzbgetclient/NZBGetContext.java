package com.github.nagromc.nzbgetclient;

import com.github.nagromc.nzbgetclient.model.Download;
import com.github.nagromc.nzbgetclient.model.DownloadItem;
import com.github.nagromc.nzbgetclient.model.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class NZBGetContext extends Observable implements Observer {

    private Status status;
    private List<DownloadItem> downloads;

    private static NZBGetContext instance;

    public static NZBGetContext getInstance() {
        if (instance == null) {
            instance = new NZBGetContext();
        }

        return instance;
    }

    public NZBGetContext() {
        this.status = new Status();
        this.downloads = new ArrayList<DownloadItem>();

        // trigger the observers of NZBGetContext
        status.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object data) {
        instance.setChanged();
        instance.notifyObservers();
    }

    public Status getStatus() {
        return status;
    }

    public List<DownloadItem> getDownloads() {
        return downloads;
    }

    public void setDownloads(List<DownloadItem> downloads) {
        this.downloads = downloads;
        instance.setChanged();
    }
}
