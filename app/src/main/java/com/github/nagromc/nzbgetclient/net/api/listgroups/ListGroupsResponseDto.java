package com.github.nagromc.nzbgetclient.net.api.listgroups;

import com.github.nagromc.nzbgetclient.net.api.log.LogResponseDto;
import com.github.nagromc.nzbgetclient.net.dto.ResponseDto;

import java.util.Map;

public class ListGroupsResponseDto extends ResponseDto<ListGroupsResponseDto.ListGroupsResultDto[]> {

    public static class ListGroupsResultDto {

        private Integer NZBID;
        /** @deprecated in v13 has the same value as NZBID (for compatibility with software using this field when calling method editqueue) */
        @Deprecated
        private Integer FirstID;
        /** @deprecated in v13 has the same value as NZBID (for compatibility with software using this field when calling method editqueue) */
        @Deprecated
        private Integer LastID;
        private String NZBFilename;
        private String NZBName;
        /** @deprecated use NZBName instead */
        @Deprecated
        private String NZBNicename;
        /** @since 13.0 */
        private String Kind;
        /** @since 13.0 */
        private String URL;
        private String DestDir;
        private String FinalDir;
        private String Category;
        /** Need to be declared as {@code long} since {@code integer}s are signed until Java 8 */
        private Long FileSizeLo;
        /** Need to be declared as {@code long} since {@code integer}s are signed until Java 8 */
        private Long FileSizeHi;
        private Integer FileSizeMB;
        /** Need to be declared as {@code long} since {@code integer}s are signed until Java 8 */
        private Long RemainingSizeLo;
        /** Need to be declared as {@code long} since {@code integer}s are signed until Java 8 */
        private Long RemainingSizeHi;
        private Integer RemainingSizeMB;
        /** Need to be declared as {@code long} since {@code integer}s are signed until Java 8 */
        private Long PausedSizeLo;
        /** Need to be declared as {@code long} since {@code integer}s are signed until Java 8 */
        private Long PausedSizeHi;
        private Integer PausedSizeMB;
        private Integer FileCount;
        private Integer RemainingFileCount;
        private Integer RemainingParCount;
        private Integer MinPostTime;
        private Integer MaxPostTime;
        /** @deprecated use MaxPriority instead */
        @Deprecated
        private Integer MinPriority;
        private Integer MaxPriority;
        private Integer ActiveDownloads;
        /** @since 13.0 */
        private GroupStatusDto Status;
        private Integer TotalArticles;
        private Integer SuccessArticles;
        private Integer FailedArticles;
        private Integer Health;
        private Integer CriticalHealth;
        private String DupeKey;
        private Integer DupeScore;
        private String DupeMode;
        private Map<String, String>[] Parameters;
        /** @deprecated use DeleteStatus instead */
        @Deprecated
        private Boolean Deleted;
        private Map<String, Object>[] ServerStats;
        // TODO official doc not clear
        //String ParStatus, UnpackStatus, MoveStatus, ScriptStatus, DeleteStatus, MarkStatus, ScriptStatuses
        /** @since 13.0 */
        private String PostInfoText;
        /** @since 13.0 */
        private Integer PostStageProgress;
        /** @since 13.0 */
        private Integer PostTotalTimeSec;
        /** @since 13.0 */
        private Integer PostStageTimeSec;
        /** @since 13.0 */
        private LogResponseDto.LogResultDto[] Log;


        public Integer getNZBID() {
            return NZBID;
        }

        public void setNZBID(Integer NZBID) {
            this.NZBID = NZBID;
        }

        public Integer getFirstID() {
            return FirstID;
        }

        public void setFirstID(Integer firstID) {
            FirstID = firstID;
        }

        public Integer getLastID() {
            return LastID;
        }

        public void setLastID(Integer lastID) {
            LastID = lastID;
        }

        public String getNZBFilename() {
            return NZBFilename;
        }

        public void setNZBFilename(String NZBFilename) {
            this.NZBFilename = NZBFilename;
        }

        public String getNZBName() {
            return NZBName;
        }

        public void setNZBName(String NZBName) {
            this.NZBName = NZBName;
        }

        public String getNZBNicename() {
            return NZBNicename;
        }

        public void setNZBNicename(String NZBNicename) {
            this.NZBNicename = NZBNicename;
        }

        public String getKind() {
            return Kind;
        }

        public void setKind(String kind) {
            Kind = kind;
        }

        public String getURL() {
            return URL;
        }

        public void setURL(String URL) {
            this.URL = URL;
        }

        public String getDestDir() {
            return DestDir;
        }

        public void setDestDir(String destDir) {
            DestDir = destDir;
        }

        public String getFinalDir() {
            return FinalDir;
        }

        public void setFinalDir(String finalDir) {
            FinalDir = finalDir;
        }

        public String getCategory() {
            return Category;
        }

        public void setCategory(String category) {
            Category = category;
        }

        public Long getFileSizeLo() {
            return FileSizeLo;
        }

        public void setFileSizeLo(Long fileSizeLo) {
            FileSizeLo = fileSizeLo;
        }

        public Long getFileSizeHi() {
            return FileSizeHi;
        }

        public void setFileSizeHi(Long fileSizeHi) {
            FileSizeHi = fileSizeHi;
        }

        public Integer getFileSizeMB() {
            return FileSizeMB;
        }

        public void setFileSizeMB(Integer fileSizeMB) {
            FileSizeMB = fileSizeMB;
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

        public Long getPausedSizeLo() {
            return PausedSizeLo;
        }

        public void setPausedSizeLo(Long pausedSizeLo) {
            PausedSizeLo = pausedSizeLo;
        }

        public Long getPausedSizeHi() {
            return PausedSizeHi;
        }

        public void setPausedSizeHi(Long pausedSizeHi) {
            PausedSizeHi = pausedSizeHi;
        }

        public Integer getPausedSizeMB() {
            return PausedSizeMB;
        }

        public void setPausedSizeMB(Integer pausedSizeMB) {
            PausedSizeMB = pausedSizeMB;
        }

        public Integer getFileCount() {
            return FileCount;
        }

        public void setFileCount(Integer fileCount) {
            FileCount = fileCount;
        }

        public Integer getRemainingFileCount() {
            return RemainingFileCount;
        }

        public void setRemainingFileCount(Integer remainingFileCount) {
            RemainingFileCount = remainingFileCount;
        }

        public Integer getRemainingParCount() {
            return RemainingParCount;
        }

        public void setRemainingParCount(Integer remainingParCount) {
            RemainingParCount = remainingParCount;
        }

        public Integer getMinPostTime() {
            return MinPostTime;
        }

        public void setMinPostTime(Integer minPostTime) {
            MinPostTime = minPostTime;
        }

        public Integer getMaxPostTime() {
            return MaxPostTime;
        }

        public void setMaxPostTime(Integer maxPostTime) {
            MaxPostTime = maxPostTime;
        }

        public Integer getMinPriority() {
            return MinPriority;
        }

        public void setMinPriority(Integer minPriority) {
            MinPriority = minPriority;
        }

        public Integer getMaxPriority() {
            return MaxPriority;
        }

        public void setMaxPriority(Integer maxPriority) {
            MaxPriority = maxPriority;
        }

        public Integer getActiveDownloads() {
            return ActiveDownloads;
        }

        public void setActiveDownloads(Integer activeDownloads) {
            ActiveDownloads = activeDownloads;
        }

        public GroupStatusDto getStatus() {
            return Status;
        }

        public void setStatus(GroupStatusDto status) {
            Status = status;
        }

        public Integer getTotalArticles() {
            return TotalArticles;
        }

        public void setTotalArticles(Integer totalArticles) {
            TotalArticles = totalArticles;
        }

        public Integer getSuccessArticles() {
            return SuccessArticles;
        }

        public void setSuccessArticles(Integer successArticles) {
            SuccessArticles = successArticles;
        }

        public Integer getFailedArticles() {
            return FailedArticles;
        }

        public void setFailedArticles(Integer failedArticles) {
            FailedArticles = failedArticles;
        }

        public Integer getHealth() {
            return Health;
        }

        public void setHealth(Integer health) {
            Health = health;
        }

        public Integer getCriticalHealth() {
            return CriticalHealth;
        }

        public void setCriticalHealth(Integer criticalHealth) {
            CriticalHealth = criticalHealth;
        }

        public String getDupeKey() {
            return DupeKey;
        }

        public void setDupeKey(String dupeKey) {
            DupeKey = dupeKey;
        }

        public Integer getDupeScore() {
            return DupeScore;
        }

        public void setDupeScore(Integer dupeScore) {
            DupeScore = dupeScore;
        }

        public String getDupeMode() {
            return DupeMode;
        }

        public void setDupeMode(String dupeMode) {
            DupeMode = dupeMode;
        }

        public Map<String, String>[] getParameters() {
            return Parameters;
        }

        public void setParameters(Map<String, String>[] parameters) {
            Parameters = parameters;
        }

        public Boolean isDeleted() {
            return Deleted;
        }

        public void setDeleted(Boolean deleted) {
            Deleted = deleted;
        }

        public Map<String, Object>[] getServerStats() {
            return ServerStats;
        }

        public void setServerStats(Map<String, Object>[] serverStats) {
            ServerStats = serverStats;
        }

        public String getPostInfoText() {
            return PostInfoText;
        }

        public void setPostInfoText(String postInfoText) {
            PostInfoText = postInfoText;
        }

        public Integer getPostStageProgress() {
            return PostStageProgress;
        }

        public void setPostStageProgress(Integer postStageProgress) {
            PostStageProgress = postStageProgress;
        }

        public Integer getPostTotalTimeSec() {
            return PostTotalTimeSec;
        }

        public void setPostTotalTimeSec(Integer postTotalTimeSec) {
            PostTotalTimeSec = postTotalTimeSec;
        }

        public Integer getPostStageTimeSec() {
            return PostStageTimeSec;
        }

        public void setPostStageTimeSec(Integer postStageTimeSec) {
            PostStageTimeSec = postStageTimeSec;
        }

        public LogResponseDto.LogResultDto[] getLog() {
            return Log;
        }

        public void setLog(LogResponseDto.LogResultDto[] log) {
            Log = log;
        }

        public enum GroupStatusDto {
            QUEUED, PAUSED, DOWNLOADING, FETCHING, PP_QUEUED, LOADING_PARS, VERIFYING_SOURCES,
            REPAIRING, VERIFYING_REPAIRED, RENAMING, UNPACKING, MOVING, EXECUTING_SCRIPT,
            PP_FINISHED
        }
    }

}
