package com.github.nagromc.nzbgetclient.net.api.log;

import com.github.nagromc.nzbgetclient.net.api.log.LogResponseDto.LogResultDto;
import com.github.nagromc.nzbgetclient.net.dto.RequestDto;

public class LogRequestDto extends RequestDto<LogResultDto[]> {

	private static final String METHOD_NAME = "log";

	public LogRequestDto(int ifFrom, int numberOfEntries) {
		super(METHOD_NAME, ifFrom, numberOfEntries);
	}

	@Override
	public Class<LogResultDto[]> getResultClass() {
		return LogResultDto[].class;
	}
}
