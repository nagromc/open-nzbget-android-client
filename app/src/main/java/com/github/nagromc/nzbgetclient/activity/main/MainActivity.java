package com.github.nagromc.nzbgetclient.activity.main;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.github.nagromc.nzbgetclient.R;
import com.github.nagromc.nzbgetclient.activity.main.tab.MainPagerAdapter;
import com.github.nagromc.nzbgetclient.model.Download;
import com.github.nagromc.nzbgetclient.model.Status;
import com.github.nagromc.nzbgetclient.net.VolleySingleton;
import com.github.nagromc.nzbgetclient.net.api.listgroups.ListGroupsRequestDto;
import com.github.nagromc.nzbgetclient.net.api.status.StatusRequestDto;
import com.github.nagromc.nzbgetclient.net.dto.RequestDto;
import com.github.nagromc.nzbgetclient.net.listener.ListGroupsListener;
import com.github.nagromc.nzbgetclient.net.listener.StatusListener;
import com.github.nagromc.nzbgetclient.net.volley.NzbGetGsonRequest;
import com.github.nagromc.nzbgetclient.net.volley.NzbGetListener;

import java.util.List;


public class MainActivity extends ActionBarActivity implements ActionBar.TabListener {

    private static final String TAG = MainActivity.class.getName();

    private MainPagerAdapter pagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        pagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.mainPager);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        for (int i = 0 ; i < pagerAdapter.getCount() ; i++) {
            ActionBar.Tab tab = actionBar.newTab();
            tab.setText(pagerAdapter.getPageTitle(i));
            tab.setTabListener(this);

            actionBar.addTab(tab);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                return true;

            case R.id.action_refresh:
                Log.d(TAG, "refresh button clicked");
                refresh();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    private void refresh() {
        ListGroupsRequestDto listGroupsRequest = new ListGroupsRequestDto();
        StatusRequestDto statusRequest = new StatusRequestDto();

        sendRequest(listGroupsRequest, new ListGroupsListener(this));
        sendRequest(statusRequest, new StatusListener(this));
    }

    private <T> void sendRequest(RequestDto<T> request, NzbGetListener<T> listener) {
        NzbGetGsonRequest<T> gsonRequest = new NzbGetGsonRequest<T>(request, request.getResultClass(), listener);

        VolleySingleton volley = VolleySingleton.getInstance(this);
        volley.getRequestQueue().add(gsonRequest);
    }

    public MainPagerAdapter getPagerAdapter() {
        return pagerAdapter;
    }

}
