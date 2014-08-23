package com.github.nagromc.nzbgetclient.activity.main.tab.downloads;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.nagromc.nzbgetclient.R;
import com.github.nagromc.nzbgetclient.model.Download;
import com.github.nagromc.nzbgetclient.model.DownloadItem;
import com.github.nagromc.nzbgetclient.utils.NZBGetFormatter;

import java.util.List;

public class DownloadListAdapter extends ArrayAdapter<DownloadItem> {

    private final Context context;
    private final LayoutInflater inflater;

    public DownloadListAdapter(Context context, int resource, List<DownloadItem> objects) {
        super(context, resource, objects);

        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView status;
        TextView name;
        TextView rate;
        TextView remainingSizeAndTime;
        ProgressBar progressBar;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.download_item, parent, false);
            status = (ImageView) convertView.findViewById(R.id.status);
            name = (TextView) convertView.findViewById(R.id.downloadName);
            rate = (TextView) convertView.findViewById(R.id.downloadRate);
            remainingSizeAndTime = (TextView) convertView.findViewById(R.id.remainingSizeAndTime);
            progressBar = (ProgressBar) convertView.findViewById(R.id.progressBar);
            convertView.setTag(new ViewHolder(status, name, rate, remainingSizeAndTime, progressBar));
        } else {
            ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            status = viewHolder.status;
            name = viewHolder.name;
            rate = viewHolder.rate;
            remainingSizeAndTime = viewHolder.eta;
            progressBar = viewHolder.progressBar;
        }

        DownloadItem download = getItem(position);
        status.setImageResource(download.getStatus().getResourceId());
        name.setText(download.getName());
        rate.setText(NZBGetFormatter.formatDownloadRate(context, download.getRate()));
        remainingSizeAndTime.setText(NZBGetFormatter.formatDownloadRemainingSizeAndTime(context, download));
        progressBar.setProgress(download.getPercentage());

        return convertView;
    }

    private static class ViewHolder {
        public final ImageView status;
        public final TextView name;
        public final TextView rate;
        public final TextView eta;
        public final ProgressBar progressBar;

        private ViewHolder(ImageView status, TextView name, TextView rate, TextView eta, ProgressBar progressBar) {
            this.status = status;
            this.name = name;
            this.rate = rate;
            this.eta = eta;
            this.progressBar = progressBar;
        }
    }

}
