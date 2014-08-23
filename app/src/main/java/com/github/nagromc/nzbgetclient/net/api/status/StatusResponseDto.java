package com.github.nagromc.nzbgetclient.net.api.status;

import com.github.nagromc.nzbgetclient.model.Download;
import com.github.nagromc.nzbgetclient.net.dto.ResponseDto;
import com.github.nagromc.nzbgetclient.utils.DownloadUtils;
import com.github.nagromc.nzbgetclient.utils.NZBGetFormatter;

import java.util.Date;

public class StatusResponseDto extends ResponseDto<StatusResponseDto.StatusResultDto> {

	public static class StatusResultDto {

        /** Need to be declared as {@code long} since {@code integer}s are signed until Java 8 */
		private Long RemainingSizeLo;
        /** Need to be declared as {@code long} since {@code integer}s are signed until Java 8 */
		private Long RemainingSizeHi;
		private Integer RemainingSizeMB;
        /**
         * Need to be declared as {@code long} since {@code integer}s are signed until Java 8
         * @since 13.0
         */
		private Long ForcedSizeLo;
        /**
         * Need to be declared as {@code long} since {@code integer}s are signed until Java 8
         * @since 13.0
         */
		private Long ForcedSizeHi;
        /** @since 13.0 */
		private Integer ForcedSizeMB;
        /** Need to be declared as {@code long} since {@code integer}s are signed until Java 8 */
		private Long DownloadedSizeLo;
        /** Need to be declared as {@code long} since {@code integer}s are signed until Java 8 */
		private Long DownloadedSizeHi;
		private Integer DownloadedSizeMB;
		private Integer DownloadRate;
		private Integer AverageDownloadRate;
		private Integer DownloadLimit;
		private Integer ThreadCount;
		private Integer PostJobCount;
        /** @deprecated use PostJobCount instead */
		@Deprecated
		private Integer ParJobCount;
		private Integer UrlCount;
		private Integer UpTimeSec;
		private Integer DownloadTimeSec;
		private Boolean ServerStandBy;
		private Boolean DownloadPaused;
        /** @deprecated there is no second pause register in v13 */
		@Deprecated
		private Boolean Download2Paused;
        /** @deprecated use DownloadPaused instead */
		@Deprecated
		private Boolean ServerPaused;
		private Boolean PostPaused;
		private Boolean ScanPaused;
		private Date ServerTime;
		private Date ResumeTime;
		private Boolean FeedActive;

        public long getRemainingSize() {
            return DownloadUtils.computeSize(RemainingSizeLo, RemainingSizeHi);
        }

        public long getDownloadedSize() {
            return DownloadUtils.computeSize(DownloadedSizeLo, DownloadedSizeHi);
        }

		public Long getRemainingSizeLo() {
			return RemainingSizeLo;
		}

		public void setRemainingSizeLo(Long remainingSizeLo) {
			RemainingSizeLo = remainingSizeLo;
		}

		public Long getRemainingSizeHi() {
			return RemainingSizeHi;
		}

		public void setRemainingSizeHi(Long remainingSizeHi) {
			RemainingSizeHi = remainingSizeHi;
		}

		public Integer getRemainingSizeMB() {
			return RemainingSizeMB;
		}

		public void setRemainingSizeMB(Integer remainingSizeMB) {
			RemainingSizeMB = remainingSizeMB;
		}

		public Long getForcedSizeLo() {
			return ForcedSizeLo;
		}

		public void setForcedSizeLo(Long forcedSizeLo) {
			ForcedSizeLo = forcedSizeLo;
		}

		public Long getForcedSizeHi() {
			return ForcedSizeHi;
		}

		public void setForcedSizeHi(Long forcedSizeHi) {
			ForcedSizeHi = forcedSizeHi;
		}

		public Integer getForcedSizeMB() {
			return ForcedSizeMB;
		}

		public void setForcedSizeMB(Integer forcedSizeMB) {
			ForcedSizeMB = forcedSizeMB;
		}

		public Long getDownloadedSizeLo() {
			return DownloadedSizeLo;
		}

		public void setDownloadedSizeLo(Long downloadedSizeLo) {
			DownloadedSizeLo = downloadedSizeLo;
		}

		public Long getDownloadedSizeHi() {
			return DownloadedSizeHi;
		}

		public void setDownloadedSizeHi(Long downloadedSizeHi) {
			DownloadedSizeHi = downloadedSizeHi;
		}

		public Integer getDownloadedSizeMB() {
			return DownloadedSizeMB;
		}

		public void setDownloadedSizeMB(Integer downloadedSizeMB) {
			DownloadedSizeMB = downloadedSizeMB;
		}

		public Integer getDownloadRate() {
			return DownloadRate;
		}

		public void setDownloadRate(Integer downloadRate) {
			DownloadRate = downloadRate;
		}

		public Integer getAverageDownloadRate() {
			return AverageDownloadRate;
		}

		public void setAverageDownloadRate(Integer averageDownloadRate) {
			AverageDownloadRate = averageDownloadRate;
		}

		public Integer getDownloadLimit() {
			return DownloadLimit;
		}

		public void setDownloadLimit(Integer downloadLimit) {
			DownloadLimit = downloadLimit;
		}

		public Integer getThreadCount() {
			return ThreadCount;
		}

		public void setThreadCount(Integer threadCount) {
			ThreadCount = threadCount;
		}

		public Integer getPostJobCount() {
			return PostJobCount;
		}

		public void setPostJobCount(Integer postJobCount) {
			PostJobCount = postJobCount;
		}

		public Integer getParJobCount() {
			return ParJobCount;
		}

		public void setParJobCount(Integer parJobCount) {
			ParJobCount = parJobCount;
		}

		public Integer getUrlCount() {
			return UrlCount;
		}

		public void setUrlCount(Integer urlCount) {
			UrlCount = urlCount;
		}

		public Integer getUpTimeSec() {
			return UpTimeSec;
		}

		public void setUpTimeSec(Integer upTimeSec) {
			UpTimeSec = upTimeSec;
		}

		public Integer getDownloadTimeSec() {
			return DownloadTimeSec;
		}

		public void setDownloadTimeSec(Integer downloadTimeSec) {
			DownloadTimeSec = downloadTimeSec;
		}

		public Boolean isServerStandBy() {
			return ServerStandBy;
		}

		public void setServerStandBy(Boolean serverStandBy) {
			ServerStandBy = serverStandBy;
		}

		public Boolean isDownloadPaused() {
			return DownloadPaused;
		}

		public void setDownloadPaused(Boolean downloadPaused) {
			DownloadPaused = downloadPaused;
		}

		public Boolean isDownload2Paused() {
			return Download2Paused;
		}

		public void setDownload2Paused(Boolean download2Paused) {
			Download2Paused = download2Paused;
		}

		public Boolean isServerPaused() {
			return ServerPaused;
		}

		public void setServerPaused(Boolean serverPaused) {
			ServerPaused = serverPaused;
		}

		public Boolean isPostPaused() {
			return PostPaused;
		}

		public void setPostPaused(Boolean postPaused) {
			PostPaused = postPaused;
		}

		public Boolean isScanPaused() {
			return ScanPaused;
		}

		public void setScanPaused(Boolean scanPaused) {
			ScanPaused = scanPaused;
		}

		public Date getServerTime() {
			return ServerTime;
		}

		public void setServerTime(Date serverTime) {
			ServerTime = serverTime;
		}

		public Date getResumeTime() {
			return ResumeTime;
		}

		public void setResumeTime(Date resumeTime) {
			ResumeTime = resumeTime;
		}

		public Boolean isFeedActive() {
			return FeedActive;
		}

		public void setFeedActive(Boolean feedActive) {
			FeedActive = feedActive;
		}

	}

}
