package com.github.nagromc.nzbgetclient.debug.net.listener;

import java.util.Locale;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

import com.github.nagromc.nzbgetclient.R;
import com.github.nagromc.nzbgetclient.net.api.status.StatusResponseDto;
import com.github.nagromc.nzbgetclient.net.volley.NzbGetListener;

public class StatusListener extends
		NzbGetListener<StatusResponseDto.StatusResultDto> {

	private static final String TAG = StatusListener.class.getName();

	public StatusListener(Activity callingActivity) {
		super(callingActivity);
	}

	@Override
	public void onResponse(StatusResponseDto.StatusResultDto result) {
		String resultString = String.format(Locale.US,
				"RemainingSizeLo: %d,\n"
				+ "RemainingSizeHi: %d,\n"
				+ "RemainingSizeMB: %d,\n" 
				+ "ForcedSizeLo: %d,\n"
				+ "ForcedSizeHi: %d,\n" 
				+ "ForcedSizeMB: %d,\n"
				+ "DownloadedSizeLo: %d,\n" 
				+ "DownloadedSizeHi: %d,\n"
				+ "DownloadedSizeMB: %d,\n" 
				+ "DownloadRate: %d,\n"
				+ "AverageDownloadRate: %d,\n" 
				+ "DownloadLimit: %d,\n"
				+ "ThreadCount: %d,\n" 
				+ "PostJobCount: %d,\n"
				+ "ParJobCount: %d,\n" 
				+ "UrlCount: %d,\n" 
				+ "UpTimeSec: %d,\n"
				+ "DownloadTimeSec: %d,\n"
				+ "ServerStandBy: %b,\n"
				+ "DownloadPaused: %b,\n"
				+ "Download2Paused: %b,\n"
				+ "ServerPaused: %b,\n"
				+ "PostPaused: %b,\n"
				+ "ScanPaused: %b,\n"
				+ "ServerTime: %s,\n"
				+ "ResumeTime: %s,\n"
				+ "FeedActive: %b,\n",
				result.getRemainingSizeLo(),
				result.getRemainingSizeHi(),
				result.getRemainingSizeMB(),
				result.getForcedSizeLo(),
				result.getForcedSizeHi(),
				result.getForcedSizeMB(),
				result.getDownloadedSizeLo(),
				result.getDownloadedSizeHi(),
				result.getDownloadedSizeMB(),
				result.getDownloadRate(),
				result.getAverageDownloadRate(),
				result.getDownloadLimit(),
				result.getThreadCount(),
				result.getPostJobCount(),
				result.getParJobCount(),
				result.getUrlCount(),
				result.getUpTimeSec(),
				result.getDownloadTimeSec(),
				result.isServerStandBy(),
				result.isDownloadPaused(),
				result.isDownload2Paused(),
				result.isServerPaused(),
				result.isPostPaused(),
				result.isScanPaused(),
				result.getServerTime(),
				result.getResumeTime(),
				result.isFeedActive());

		Log.i(TAG, String.format("Result: %s", resultString));

		TextView textView = (TextView) this.activity.findViewById(R.id.textView_result);
		textView.setText(resultString);
	}

}
