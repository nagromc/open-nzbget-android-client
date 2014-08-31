package com.github.nagromc.nzbgetclient.activity.main.tab.downloads;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.nagromc.nzbgetclient.NZBGetContext;
import com.github.nagromc.nzbgetclient.R;
import com.github.nagromc.nzbgetclient.model.Download;
import com.github.nagromc.nzbgetclient.model.DownloadItem;
import com.github.nagromc.nzbgetclient.model.Status;
import com.github.nagromc.nzbgetclient.utils.NZBGetFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class DownloadsTabFragment extends ListFragment implements Observer {

    private static final String TAG = DownloadsTabFragment.class.getName();
    public static final String TAB_TITLE = "Downloads";

    private List<DownloadItem> downloads = new ArrayList<DownloadItem>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        DownloadListAdapter adapter = new DownloadListAdapter(getActivity(), R.layout.download_item, this.downloads);
        setListAdapter(adapter);

        // add observer to refresh UI when model changes
        NZBGetContext.getInstance().addObserver(this);

        return inflater.inflate(R.layout.fragment_downloads_tab, container, false);
    }

    public void refreshDownloads(List<DownloadItem> downloads) {
        if (downloads == null) {
            return;
        }

        DownloadListAdapter adapter = (DownloadListAdapter) getListAdapter();

        this.downloads.clear();
        this.downloads.addAll(downloads);

        adapter.notifyDataSetChanged();
    }

    public void refreshFooter(Status status) {
        if (status == null) {
            return;
        }

        TextView totalDownloadRate = (TextView) this.getActivity().findViewById(R.id.totalDownloadRate);
        totalDownloadRate.setText(NZBGetFormatter.formatDownloadRate(this.getActivity(), status.getTotalDownload().getRate()));

        TextView totalEta = (TextView) this.getActivity().findViewById(R.id.totalEta);
        totalEta.setText(NZBGetFormatter.formatDownloadRemainingSizeAndTime(this.getActivity(), status.getTotalDownload()));

        ProgressBar progressBar = (ProgressBar) this.getActivity().findViewById(R.id.totalProgressBar);
        progressBar.setProgress(status.getTotalDownload().getPercentage());
    }

    @Override
    public void update(Observable observable, Object data) {
        Log.d(TAG, "Update MainActivity");

        // refresh footer
        this.refreshFooter(NZBGetContext.getInstance().getStatus());

        // refresh download list
        this.refreshDownloads(NZBGetContext.getInstance().getDownloads());
    }

}
