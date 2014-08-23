package com.github.nagromc.nzbgetclient.model;

import com.github.nagromc.nzbgetclient.R;
import com.github.nagromc.nzbgetclient.net.api.listgroups.ListGroupsResponseDto;

public enum DownloadStatus {

    PAUSED(R.drawable.ic_action_pause),
    DOWNLOADING(R.drawable.ic_action_download),
    COMPLETED(R.drawable.ic_action_accept),
    POST_PROCESSING(R.drawable.ic_action_help),
    // TODO see http://nzbget.net/forum/viewtopic.php?f=3&t=1013
    UNKNOWN(0);

    private int resourceId;

    private DownloadStatus(int resourceId) {
        this.resourceId = resourceId;
    }

    public static DownloadStatus getDownloadStatusFromDto(ListGroupsResponseDto.ListGroupsResultDto.GroupStatusDto dto) {
        if (dto == null) {
            return UNKNOWN;
        }

        switch (dto) {
            case QUEUED:
            case PAUSED:
            case FETCHING:
                return PAUSED;

            case DOWNLOADING:
                return DOWNLOADING;



            default:
                throw new IllegalArgumentException(String.format("The status '%s' is not supported.", dto.name()));
        }
    }

    public int getResourceId() {
        return resourceId;
    }

}
