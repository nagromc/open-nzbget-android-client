package com.github.nagromc.nzbgetclient.net.api.resumedownload;

import com.github.nagromc.nzbgetclient.net.dto.RequestDto;

public class ResumeDownloadRequestDto extends
 RequestDto<Boolean> {

	private static final String METHOD_NAME = "resumedownload";

	public ResumeDownloadRequestDto() {
		super(METHOD_NAME);
	}

	@Override
	public Class<Boolean> getResultClass() {
		return Boolean.class;
	}

}
