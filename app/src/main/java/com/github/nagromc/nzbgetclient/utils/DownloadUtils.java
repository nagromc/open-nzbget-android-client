package com.github.nagromc.nzbgetclient.utils;

public class DownloadUtils {

    /**
     * Returns the remaining time (aka ETA) of a download is seconds.
     *
     * @param downloadedSize the downloaded size
     * @param totalSize the total size
     * @param rate the download rate
     * @return
     */
    public static long computeEta(long downloadedSize, long totalSize, long rate) {
        long remainingSize = totalSize - downloadedSize;
        return remainingSize / rate;
    }

    /**
     * Returns the completion percentage of a download.
     *
     * @param downloadedSize the downloaded size
     * @param totalSize the total size
     * @return
     */
    public static int computePercentage(long downloadedSize, long totalSize) {
        return (int) (downloadedSize * 100 / totalSize);
    }

    /**
     * Returns a size from a lower et upper parts.
     *
     * @param lower
     * @param upper
     * @return
     */
    public static long computeSize(long lower, long upper) {
        return lower + (upper << 32);
    }

}
