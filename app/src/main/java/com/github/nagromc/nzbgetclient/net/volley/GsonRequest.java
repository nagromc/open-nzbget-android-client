package com.github.nagromc.nzbgetclient.net.volley;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Map;

public class GsonRequest<T> extends Request<T> {
	/** Charset for request. */
	private static final String PROTOCOL_CHARSET = "UTF-8";

	private final Gson gson;
	JsonSerializer<Date> ser = new JsonSerializer<Date>() {
		@Override
		public JsonElement serialize(Date src, Type typeOfSrc,
				JsonSerializationContext context) {
			return src == null ? null
					: new JsonPrimitive(src.getTime() / 1000L);
		}
	};

	JsonDeserializer<Date> deser = new JsonDeserializer<Date>() {
		@Override
		public Date deserialize(JsonElement json, Type typeOfT,
				JsonDeserializationContext context) throws JsonParseException {
			return json == null ? null : new Date(json.getAsLong() * 1000L);
		}
	};
	private final Type type;
	private final Map<String, String> headers;
	private final Listener<T> listener;
	private final String requestBody;

	/**
	 * Make a GET request and return a parsed object from JSON.
	 * 
	 * @param url
	 *            URL of the request to make
	 * @param request
	 *            The {@link GSon} bean request
	 * @param type
	 *            Relevant type object, for Gson's reflection
	 * @param headers
	 *            Map of request headers
	 * @param listener
	 *            The response listener
	 * @param errorListener
	 *            The error listener
	 */
	public GsonRequest(String url, Object request, Type type,
			Map<String, String> headers, Listener<T> listener,
			ErrorListener errorListener) {
		super(Method.POST, url, errorListener);
		gson = new GsonBuilder().registerTypeAdapter(Date.class, ser)
				.registerTypeAdapter(Date.class, deser).create();
		this.requestBody = gson.toJson(request);
		this.type = type;
		this.headers = headers;
		this.listener = listener;
	}

	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		return headers != null ? headers : super.getHeaders();
	}

	@Override
	protected void deliverResponse(T response) {
		listener.onResponse(response);
	}

	@Override
	protected Response<T> parseNetworkResponse(NetworkResponse response) {
		try {
			String json = new String(response.data,
					HttpHeaderParser.parseCharset(response.headers));
            // TODO handle {"version" : "1.1", "error" : {"name" : "JSONRPCError", "code" : 1, "message" : "Invalid procedure"} }
			return (Response<T>) Response.success(gson.fromJson(json, type), HttpHeaderParser.parseCacheHeaders(response));
		} catch (UnsupportedEncodingException e) {
			return Response.error(new ParseError(e));
		} catch (JsonSyntaxException e) {
			return Response.error(new ParseError(e));
		}
	}

	@Override
	public byte[] getBody() {
		try {
			byte[] bytes = requestBody == null ? null : requestBody
					.getBytes(PROTOCOL_CHARSET);
			return bytes;
		} catch (UnsupportedEncodingException uee) {
			VolleyLog
					.wtf("Unsupported Encoding while trying to get the bytes of %s using %s",
							requestBody, PROTOCOL_CHARSET);
			return null;
		}
	}

}
