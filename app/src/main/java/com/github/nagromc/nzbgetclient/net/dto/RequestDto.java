package com.github.nagromc.nzbgetclient.net.dto;


public abstract class RequestDto<T> {

	protected String method;
	protected Object[] params;

	public RequestDto(String methodName, Object... params) {
		this.method = methodName;
		this.params = params;
	}

	public abstract Class<T> getResultClass();

}
