package com.github.nagromc.nzbgetclient.model;

import com.github.nagromc.nzbgetclient.net.api.listgroups.ListGroupsResponseDto;
import com.github.nagromc.nzbgetclient.utils.DownloadUtils;

public class DownloadItem extends Download {

    /** Display name */
    private String name;
    /** Current status */
    private DownloadStatus status;

    public DownloadItem(ListGroupsResponseDto.ListGroupsResultDto dto) {
        this.name = dto.getNZBName();
        this.status = DownloadStatus.getDownloadStatusFromDto(dto.getStatus());
        final long totalSize = DownloadUtils.computeSize(dto.getFileSizeLo(), dto.getFileSizeHi());
        this.totalSize = totalSize;
        // TODO check if correct
        final long remainingSize = DownloadUtils.computeSize(dto.getRemainingSizeLo(), dto.getRemainingSizeHi());
        this.downloadedSize = totalSize - remainingSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DownloadStatus getStatus() {
        return status;
    }

    public void setStatus(DownloadStatus status) {
        this.status = status;
    }
}
