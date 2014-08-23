package com.github.nagromc.nzbgetclient.activity.main.tab.history;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.nagromc.nzbgetclient.R;

public class HistoryTabFragment extends Fragment {

    public static final String TAB_TITLE = "History";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history_tab, container, false);
    }
}
