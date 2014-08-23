package com.github.nagromc.nzbgetclient;

import android.app.Application;

import com.github.nagromc.nzbgetclient.model.Download;
import com.github.nagromc.nzbgetclient.model.Status;

import net.danlew.android.joda.JodaTimeAndroid;

import java.util.List;

public class NZBGetAndroidClientApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        JodaTimeAndroid.init(this);
    }

}
