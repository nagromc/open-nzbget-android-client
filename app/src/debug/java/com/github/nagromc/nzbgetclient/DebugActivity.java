package com.github.nagromc.nzbgetclient;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.github.nagromc.nzbgetclient.net.VolleySingleton;
import com.github.nagromc.nzbgetclient.debug.net.listener.ListGroupsListener;
import com.github.nagromc.nzbgetclient.net.api.listgroups.ListGroupsRequestDto;
import com.github.nagromc.nzbgetclient.debug.net.listener.LogListener;
import com.github.nagromc.nzbgetclient.net.api.log.LogRequestDto;
import com.github.nagromc.nzbgetclient.debug.net.listener.PauseDownloadListener;
import com.github.nagromc.nzbgetclient.net.api.pausedownload.PauseDownloadRequestDto;
import com.github.nagromc.nzbgetclient.debug.net.listener.ResumeDownloadListener;
import com.github.nagromc.nzbgetclient.net.api.resumedownload.ResumeDownloadRequestDto;
import com.github.nagromc.nzbgetclient.debug.net.listener.StatusListener;
import com.github.nagromc.nzbgetclient.net.api.status.StatusRequestDto;
import com.github.nagromc.nzbgetclient.debug.net.listener.VersionListener;
import com.github.nagromc.nzbgetclient.net.api.version.VersionRequestDto;
import com.github.nagromc.nzbgetclient.net.dto.RequestDto;
import com.github.nagromc.nzbgetclient.net.volley.NzbGetGsonRequest;
import com.github.nagromc.nzbgetclient.net.volley.NzbGetListener;


public class DebugActivity extends ActionBarActivity {

    public static final String TAG = DebugActivity.class.getName();

    private static final String HOST = "s.ploki.fr";
    private static final int PORT = 6790;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.debug, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getVersion(View view) {
        Log.i(TAG, "version button clicked");

        VersionRequestDto request = new VersionRequestDto();

        sendRequest(request, new VersionListener(this));
    }

    public void getLog(View view) {
        Log.i(TAG, "log button clicked");

        LogRequestDto request = new LogRequestDto(0, 100);

        sendRequest(request, new LogListener(this));
    }

    public void getPauseDownload(View view) {
        Log.i(TAG, "pause button clicked");

        PauseDownloadRequestDto request = new PauseDownloadRequestDto();

        sendRequest(request, new PauseDownloadListener(this));
    }

    public void getResumeDownload(View view) {
        Log.i(TAG, "resume button clicked");

        ResumeDownloadRequestDto request = new ResumeDownloadRequestDto();

        sendRequest(request, new ResumeDownloadListener(this));
    }

    public void getStatus(View view) {
        Log.i(TAG, "status button clicked");

        StatusRequestDto request = new StatusRequestDto();

        sendRequest(request, new StatusListener(this));
    }

    public void getListGroups(View view) {
        Log.i(TAG, "listgroups button clicked");

        ListGroupsRequestDto request = new ListGroupsRequestDto(10);

        sendRequest(request, new ListGroupsListener(this));
    }

    private <T> void sendRequest(RequestDto<T> request,
                                 NzbGetListener<T> listener) {
        NzbGetGsonRequest<T> gsonRequest = new NzbGetGsonRequest<T>(HOST, PORT, request, request.getResultClass(), listener);

        VolleySingleton volley = VolleySingleton.getInstance(this);
        volley.getRequestQueue().add(gsonRequest);
    }

}
