package com.github.nagromc.nzbgetclient.activity.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.util.Patterns;
import android.widget.Toast;

import com.github.nagromc.nzbgetclient.R;
import com.github.nagromc.nzbgetclient.utils.NZBGetConstant;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SettingsActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private EditTextPreference hostEtp;
    private EditTextPreference portEtp;

    /** Triggered when the user edits the host field */
    private Preference.OnPreferenceChangeListener onHostListener = new Preference.OnPreferenceChangeListener(){
        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {
            String host = (String) newValue;

            if (StringUtils.isBlank(host)) {
                return false;
            }

            Pattern pDomainName = Patterns.DOMAIN_NAME;
            Matcher mDomainName = pDomainName.matcher(host);

            Pattern pIpAddress = Patterns.IP_ADDRESS;
            Matcher mIpAddress = pIpAddress.matcher(host);

            if (!mDomainName.matches() && !mIpAddress.matches()) {
                String message = getString(R.string.pref_host_error_message, host);
                Toast toast = Toast.makeText(preference.getContext(), message, Toast.LENGTH_LONG);
                toast.show();
                return false;
            }
            return true;
        }
    };

    /** Triggered when the user edits the port field */
    private Preference.OnPreferenceChangeListener onPortListener = new Preference.OnPreferenceChangeListener(){
        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {
            String portStr = (String) newValue;
            if (StringUtils.isBlank(portStr)) {
                return false;
            }

            // TODO possible to store integer instead of String?
            int port = Integer.parseInt(portStr);

            if (port < NZBGetConstant.MIN_PORT_NUMBER || port > NZBGetConstant.MAX_PORT_NUMBER) {
                String message = getString(R.string.pref_port_error_message, port, NZBGetConstant.MIN_PORT_NUMBER, NZBGetConstant.MAX_PORT_NUMBER);
                Toast toast = Toast.makeText(preference.getContext(), message, Toast.LENGTH_LONG);
                toast.show();
                return false;
            }

            return true;
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

        hostEtp = (EditTextPreference) findPreference(SettingsKeys.NZBGET_SERVER_HOST);
        hostEtp.setSummary(getSummary(SettingsKeys.NZBGET_SERVER_HOST, R.string.pref_host_summ, R.string.pref_host_summ_empty));
        hostEtp.setOnPreferenceChangeListener(onHostListener);

        portEtp = (EditTextPreference) findPreference(SettingsKeys.NZBGET_SERVER_PORT);
        portEtp.setSummary(getSummary(SettingsKeys.NZBGET_SERVER_PORT, R.string.pref_port_summ, R.string.pref_port_summ_empty));
        portEtp.setOnPreferenceChangeListener(onPortListener);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (SettingsKeys.NZBGET_SERVER_HOST.equals(key)) {
            hostEtp.setSummary(getSummary(SettingsKeys.NZBGET_SERVER_HOST, R.string.pref_host_summ, R.string.pref_host_summ_empty));
        } else if (SettingsKeys.NZBGET_SERVER_PORT.equals(key)) {
            portEtp.setSummary(getSummary(SettingsKeys.NZBGET_SERVER_PORT, R.string.pref_port_summ, R.string.pref_port_summ_empty));
        }
    }

    /**
     * Returns the summary
     * @param key the key of the {@link SharedPreferences}
     * @param idMessage the ID of the message when the {@link SharedPreferences} is set
     * @param idEmpty the ID of the message when the {@link SharedPreferences} is not set
     */
    private String getSummary(String key, int idMessage, int idEmpty) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String param = prefs.getString(key, null);

        if (param == null) {
            return getString(idEmpty);
        } else {
            return getString(idMessage, param);
        }
    }

}
