package com.github.nagromc.nzbgetclient.net.listener;

import android.util.Log;

import com.github.nagromc.nzbgetclient.NZBGetContext;
import com.github.nagromc.nzbgetclient.activity.main.MainActivity;
import com.github.nagromc.nzbgetclient.activity.main.tab.downloads.DownloadsTabFragment;
import com.github.nagromc.nzbgetclient.model.Download;
import com.github.nagromc.nzbgetclient.model.DownloadItem;
import com.github.nagromc.nzbgetclient.net.api.listgroups.ListGroupsResponseDto;
import com.github.nagromc.nzbgetclient.net.volley.NzbGetListener;

import java.util.ArrayList;
import java.util.List;

public class ListGroupsListener extends NzbGetListener<ListGroupsResponseDto.ListGroupsResultDto[]> {

    private static final String TAG = ListGroupsListener.class.getName();

    public ListGroupsListener(MainActivity activity) {
        super(activity);
    }

    @Override
    public void onResponse(ListGroupsResponseDto.ListGroupsResultDto[] result) {
        Log.d(TAG, "ListGroupsListener.onResponse");

        List<DownloadItem> downloads = new ArrayList<DownloadItem>();
        for (ListGroupsResponseDto.ListGroupsResultDto listGroupsResultDto : result) {
            DownloadItem download = new DownloadItem(listGroupsResultDto);
            downloads.add(download);
        }

        NZBGetContext instance = NZBGetContext.getInstance();
        instance.setDownloads(downloads);
        instance.notifyObservers();
    }

}
