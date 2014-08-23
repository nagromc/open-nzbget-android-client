package com.github.nagromc.nzbgetclient.activity.main.tab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.github.nagromc.nzbgetclient.activity.main.tab.downloads.DownloadsTabFragment;
import com.github.nagromc.nzbgetclient.activity.main.tab.history.HistoryTabFragment;

public class MainPagerAdapter extends FragmentPagerAdapter {

    public static final int TAB_NUMBER = 2;

    private DownloadsTabFragment downloadsTabFragment;
    private HistoryTabFragment historyTabFragment;

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
        downloadsTabFragment = new DownloadsTabFragment();
        historyTabFragment = new HistoryTabFragment();
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return downloadsTabFragment;

            case 1:
                return historyTabFragment;

            default:
                throw new IllegalArgumentException(String.format("The item %d does not exist.", i));
        }
    }

    @Override
    public int getCount() {
        return TAB_NUMBER;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return DownloadsTabFragment.TAB_TITLE;

            case 1:
                return HistoryTabFragment.TAB_TITLE;

            default:
                throw new IllegalArgumentException(String.format("The item %d does not exist.", position));
        }
    }

    public HistoryTabFragment getHistoryTabFragment() {
        return historyTabFragment;
    }

    public DownloadsTabFragment getDownloadsTabFragment() {
        return downloadsTabFragment;
    }

}
