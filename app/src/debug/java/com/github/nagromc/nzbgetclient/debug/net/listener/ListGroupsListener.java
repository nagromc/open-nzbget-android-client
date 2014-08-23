package com.github.nagromc.nzbgetclient.debug.net.listener;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

import com.github.nagromc.nzbgetclient.R;
import com.github.nagromc.nzbgetclient.net.api.listgroups.ListGroupsResponseDto;
import com.github.nagromc.nzbgetclient.net.volley.NzbGetListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ListGroupsListener extends NzbGetListener<ListGroupsResponseDto.ListGroupsResultDto[]> {

    private static final String TAG = ListGroupsListener.class.getName();

    public ListGroupsListener(Activity callingActivity) {
        super(callingActivity);
    }

    @Override
    public void onResponse(ListGroupsResponseDto.ListGroupsResultDto[] result) {

        List<String> resultString = new ArrayList<String>();

        for (ListGroupsResponseDto.ListGroupsResultDto uniqueResult : result) {
            String uniqueResultString = String.format(Locale.US,
                    "NZBID: %d,\n" +
                    "FirstID: %d,\n" +
                    "LastID: %d,\n" +
                    "NZBFilename: %s,\n" +
                    "NZBName: %s,\n" +
                    "NZBNicename: %s,\n" +
                    "Kind: %s,\n" +
                    "URL: %s,\n" +
                    "DestDir: %s,\n" +
                    "FinalDir: %s,\n" +
                    "Category: %s,\n" +
                    "FileSizeLo: %d,\n" +
                    "FileSizeHi: %d,\n" +
                    "FileSizeMB: %d,\n" +
                    "RemainingSizeLo: %d,\n" +
                    "RemainingSizeHi: %d,\n" +
                    "RemainingSizeMB: %d,\n" +
                    "PausedSizeLo: %d,\n" +
                    "PausedSizeHi: %d,\n" +
                    "PausedSizeMB: %d,\n" +
                    "FileCount: %d,\n" +
                    "RemainingFileCount: %d,\n" +
                    "RemainingParCount: %d,\n" +
                    "MinPostTime: %d,\n" +
                    "MaxPostTime: %d,\n" +
                    "MinPriority: %d,\n" +
                    "MaxPriority: %d,\n" +
                    "ActiveDownloads: %d,\n" +
                    "Status: %s,\n" +
                    "TotalArticles: %d,\n" +
                    "SuccessArticles: %d,\n" +
                    "FailedArticles: %d,\n" +
                    "Health: %d,\n" +
                    "CriticalHealth: %d,\n" +
                    "DupeKey: %s,\n" +
                    "DupeScore: %d,\n" +
                    "DupeMode: %s,\n" +
                    "Parameters: %s,\n" +
                    "Deleted: %b,\n" +
                    "ServerStats: %s,\n" +
                    // TODO
                    "ParStatus, UnpackStatus, MoveStatus, ScriptStatus, DeleteStatus, MarkStatus, ScriptStatuses: ?,\n" +
                    "PostInfoText: %s,\n" +
                    "PostStageProgress: %d,\n" +
                    "PostTotalTimeSec: %d,\n" +
                    "PostStageTimeSec: %d,\n" +
                    "Log: %s",
                    uniqueResult.getNZBID(),
                    uniqueResult.getFirstID(),
                    uniqueResult.getLastID(),
                    uniqueResult.getNZBFilename(),
                    uniqueResult.getNZBName(),
                    uniqueResult.getNZBNicename(),
                    uniqueResult.getKind(),
                    uniqueResult.getURL(),
                    uniqueResult.getDestDir(),
                    uniqueResult.getFinalDir(),
                    uniqueResult.getCategory(),
                    uniqueResult.getFileSizeLo(),
                    uniqueResult.getFileSizeHi(),
                    uniqueResult.getFileSizeMB(),
                    uniqueResult.getRemainingSizeLo(),
                    uniqueResult.getRemainingSizeHi(),
                    uniqueResult.getRemainingSizeMB(),
                    uniqueResult.getPausedSizeLo(),
                    uniqueResult.getPausedSizeHi(),
                    uniqueResult.getPausedSizeMB(),
                    uniqueResult.getFileCount(),
                    uniqueResult.getRemainingFileCount(),
                    uniqueResult.getRemainingParCount(),
                    uniqueResult.getMinPostTime(),
                    uniqueResult.getMaxPostTime(),
                    uniqueResult.getMinPriority(),
                    uniqueResult.getMaxPriority(),
                    uniqueResult.getActiveDownloads(),
                    uniqueResult.getStatus(),
                    uniqueResult.getTotalArticles(),
                    uniqueResult.getSuccessArticles(),
                    uniqueResult.getFailedArticles(),
                    uniqueResult.getHealth(),
                    uniqueResult.getCriticalHealth(),
                    uniqueResult.getDupeKey(),
                    uniqueResult.getDupeScore(),
                    uniqueResult.getDupeMode(),
                    Arrays.toString(uniqueResult.getParameters()[0].entrySet().toArray()),
                    uniqueResult.isDeleted(),
                    Arrays.toString(uniqueResult.getServerStats()[0].entrySet().toArray()),
                    uniqueResult.getPostInfoText(),
                    uniqueResult.getPostStageProgress(),
                    uniqueResult.getPostTotalTimeSec(),
                    uniqueResult.getPostStageTimeSec(),
                    Arrays.toString(uniqueResult.getLog()));

            resultString.add(uniqueResultString.toString());
        }


        String logString = Arrays.toString(resultString.toArray());

        Log.i(TAG, String.format("Result: %s", logString));

        TextView textView = (TextView) this.activity.findViewById(R.id.textView_result);
        textView.setText(logString);
    }

}
