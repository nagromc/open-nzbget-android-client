package com.github.nagromc.nzbgetclient.net.api.pausedownload;

import com.github.nagromc.nzbgetclient.net.dto.RequestDto;

public class PauseDownloadRequestDto extends
 RequestDto<Boolean> {

	private static final String METHOD_NAME = "pausedownload";

	public PauseDownloadRequestDto() {
		super(METHOD_NAME);
	}

	@Override
	public Class<Boolean> getResultClass() {
		return Boolean.class;
	}

}
