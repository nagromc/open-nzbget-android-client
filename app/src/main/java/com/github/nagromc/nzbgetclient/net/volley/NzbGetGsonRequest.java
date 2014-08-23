package com.github.nagromc.nzbgetclient.net.volley;

import com.android.volley.Response.Listener;
import com.github.nagromc.nzbgetclient.net.dto.RequestDto;
import com.github.nagromc.nzbgetclient.net.dto.ResponseDto;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class NzbGetGsonRequest<T> extends GsonRequest<ResponseDto<T>> {

	// TODO externalize
	private static final String SERVER_URL = "http://s.ploki.fr:6790/jsonrpc";
	private static final Map<String, String> headers = new HashMap<String, String>();

	public NzbGetGsonRequest(final RequestDto<T> request,
			final Class<T> resultClass, final NzbGetListener<T> listener) {
		// TODO clean up
		super(SERVER_URL, request, new ParameterizedType() {
			@Override
			public Type getRawType() {
				return ResponseDto.class;
			}

			@Override
			public Type getOwnerType() {
				return null;
			}

			@Override
			public Type[] getActualTypeArguments() {
				return new Type[] { resultClass };
			}
		}, headers, new Listener<ResponseDto<T>>() {

			@Override
			public void onResponse(ResponseDto<T> response) {
				listener.onResponse(response.getResult());
			}

		}, listener);

	}

}
