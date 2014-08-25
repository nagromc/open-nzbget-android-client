package com.github.nagromc.nzbgetclient.net.volley;

import com.android.volley.Response.Listener;
import com.github.nagromc.nzbgetclient.net.dto.RequestDto;
import com.github.nagromc.nzbgetclient.net.dto.ResponseDto;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class NzbGetGsonRequest<T> extends GsonRequest<ResponseDto<T>> {

	private static final String SERVER_URL_PATTERN = "http://%s:%d/jsonrpc";
	private static final Map<String, String> headers = new HashMap<String, String>();

	public NzbGetGsonRequest(final String host, final int port, final RequestDto<T> request, final Class<T> resultClass, final NzbGetListener<T> listener) {
		// TODO clean up
		super(String.format(SERVER_URL_PATTERN, host, port),
                request,
                new ParameterizedType() {
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
                },
                headers,
                new Listener<ResponseDto<T>>() {
                    @Override
                    public void onResponse(ResponseDto<T> response) {
                        listener.onResponse(response.getResult());
                    }
		        },
                listener);
	}

}
