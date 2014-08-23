package com.github.nagromc.nzbgetclient.net.api.version;

import com.github.nagromc.nzbgetclient.net.dto.RequestDto;

public class VersionRequestDto extends RequestDto<String> {

	private static final String METHOD_NAME = "version";

	public VersionRequestDto() {
		super(METHOD_NAME);
	}

	@Override
	public Class<String> getResultClass() {
		return String.class;
	}

}
