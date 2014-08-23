package com.github.nagromc.nzbgetclient.net.api.status;

import com.github.nagromc.nzbgetclient.net.api.status.StatusResponseDto.StatusResultDto;
import com.github.nagromc.nzbgetclient.net.dto.RequestDto;

public class StatusRequestDto extends RequestDto<StatusResultDto> {

	private static final String METHOD_NAME = "status";

	public StatusRequestDto() {
		super(METHOD_NAME);
	}

	@Override
	public Class<StatusResultDto> getResultClass() {
		return StatusResultDto.class;
	}

}
