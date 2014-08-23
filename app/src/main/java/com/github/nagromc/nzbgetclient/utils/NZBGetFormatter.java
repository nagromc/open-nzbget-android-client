package com.github.nagromc.nzbgetclient.utils;

import android.content.Context;
import android.text.format.Formatter;

import com.github.nagromc.nzbgetclient.model.Download;

import org.joda.time.DateTimeConstants;
import org.joda.time.Period;
import org.joda.time.Seconds;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import java.util.Locale;

public class NZBGetFormatter {

    public static String formatDuration(long durationInSec) {
        String result;

        Seconds seconds = Seconds.seconds((int) (durationInSec * DateTimeConstants.MILLIS_PER_SECOND));
        PeriodFormatter formatter = new PeriodFormatterBuilder()
                .appendDays()
                .appendSuffix(" d ")
                .appendHours()
                .appendSuffix(" h ")
                .appendMinutes()
                .appendSuffix(" m ")
                .appendSeconds()
                .appendSuffix(" s ")
                .toFormatter();
        result = formatter.print(new Period(seconds).normalizedStandard());

        return result;
    }

    public static String formatDownloadRemainingSizeAndTime(Context context, Download download) {
        String result;
        Locale locale = context.getResources().getConfiguration().locale;

        result = String.format(locale, "%s/%s",
                Formatter.formatFileSize(context, download.getDownloadedSize()),
                Formatter.formatFileSize(context, download.getTotalSize()));

        if (download.getRate() > 0) {
            result = String.format(locale, "%s (%s)", result, formatDuration(download.getEta()));
        }

        return result;
    }

    public static String formatDownloadRate(Context context, long downloadRate) {
        String result = null;

        if (downloadRate > 0) {
            result = String.format("%s/s", Formatter.formatFileSize(context, downloadRate));
        }

        return result;
    }

}
