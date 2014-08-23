package com.github.nagromc.nzbgetclient.net.api.listgroups;

import com.github.nagromc.nzbgetclient.net.dto.RequestDto;

public class ListGroupsRequestDto extends RequestDto<ListGroupsResponseDto.ListGroupsResultDto[]> {

    private static final String METHOD_NAME = "listgroups";

    public ListGroupsRequestDto(int numberOfLogEntries) {
        super(METHOD_NAME, numberOfLogEntries);
    }

    public ListGroupsRequestDto() {
        super(METHOD_NAME);
    }

    @Override
    public Class<ListGroupsResponseDto.ListGroupsResultDto[]> getResultClass() {
        return ListGroupsResponseDto.ListGroupsResultDto[].class;
    }
}
