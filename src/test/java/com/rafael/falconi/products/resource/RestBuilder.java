package com.rafael.falconi.products.resource;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class RestBuilder<T> {
	private static final String SERVER_URI_DEFAULT = "http://localhost";

	private static final int PORT_DEFAULT = 8080;

	private RestTemplate restTemplate = new RestTemplate();

	private String serverUri;

	private int port;

	private String path;

	private List<Object> expandList;

	private Map<String, String> headerValues;

	private List<MediaType> mediaTytes;

	private String authorization = null;

	private Object body = null;

	private MultiValueMap<String, String> params;

	private Class<T> clazz;

	private HttpMethod method;

	private boolean log;

	public RestBuilder(String serverUri, int port) {
		restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		this.serverUri = serverUri;
		this.port = port;
		this.path = "";
		this.expandList = new ArrayList<>();
		this.headerValues = new HashMap<>();
		this.mediaTytes = new ArrayList<>();
		this.params = new HttpHeaders();
		this.log = false;
	}

	public RestBuilder() {
		this(SERVER_URI_DEFAULT, PORT_DEFAULT);
	}

	public RestBuilder(int port) {
		this(SERVER_URI_DEFAULT, port);
	}

	public RestBuilder(String serverUri) {
		this(serverUri, PORT_DEFAULT);
	}

	public RestBuilder<T> port(int port) {
		this.port = port;
		return this;
	}

	public RestBuilder<T> path(String path) {
		this.path = this.path + path;
		return this;
	}

	public RestBuilder<T> expand(Object... values) {
		for (Object value : values) {
			this.expandList.add(value);
		}
		return this;
	}

	public RestBuilder<T> basicAuth(String nick, String pass) {
		String auth = nick + ":" + pass;
		String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
		String authHeader = "Basic " + encodedAuth;
		this.authorization = authHeader;
		return this;
	}

	public RestBuilder<T> param(String key, String value) {
		this.params.add(key, value);
		return this;
	}

	public RestBuilder<T> header(String key, String value) {
		this.headerValues.put(key, value);
		return this;
	}

	public RestBuilder<T> body(Object body) {
		this.body = body;
		return this;
	}

	public RestBuilder<T> accept(MediaType mediaType) {
		if (this.mediaTytes.isEmpty()) {
			this.mediaTytes.add(MediaType.APPLICATION_JSON);
		}
		this.mediaTytes.add(mediaType);
		return this;
	}

	public RestBuilder<T> notError() {
		restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
			protected boolean hasError(HttpStatus statusCode) {
				return false;
			}
		});
		return this;
	}

	public RestBuilder<T> clazz(Class<T> clazz) {
		this.clazz = clazz;
		return this;
	}

	private HttpHeaders headers() {
		HttpHeaders headers = new HttpHeaders();
		for (String key : headerValues.keySet()) {
			headers.set(key, headerValues.get(key));
		}
		if (authorization != null) {
			headers.set("Authorization", authorization);
		}
		if (!this.mediaTytes.isEmpty()) {
			headers.setAccept(this.mediaTytes);
		}
		return headers;
	}

	private URI uri() {
		UriComponents uriComponents;
		if (params.isEmpty()) {
			uriComponents = UriComponentsBuilder.fromHttpUrl(serverUri + ":" + port + path).build();
		} else {
			uriComponents = UriComponentsBuilder.fromHttpUrl(serverUri + ":" + port + path).queryParams(params).build();
		}
		if (!expandList.isEmpty()) {
			uriComponents = uriComponents.expand(expandList.toArray());
		}
		return uriComponents.encode().toUri();

	}

	public RestBuilder<T> log() {
		this.log = true;
		return this;
	}

	public T build() {
		ResponseEntity<T> response;
		if (log) {
			Logger.getLogger(this.getClass()).info(method + " " + this.path + this.headers() + "{" + this.body + "}");
		}
		if (body != null && !method.equals(HttpMethod.GET)) {
			response = restTemplate.exchange(this.uri(), method, new HttpEntity<Object>(body, this.headers()), clazz);
			if (log) {
				Logger.getLogger(this.getClass()).info(response.getStatusCode() + "==" + response.getHeaders());
			}
			return response.getBody();
		} else {
			response = restTemplate.exchange(this.uri(), method, new HttpEntity<Object>(this.headers()), clazz);
			if (log) {
				Logger.getLogger(this.getClass()).info(response.getStatusCode() + "==" + response.getHeaders());
			}
			return response.getBody();
		}
	}

	public RestBuilder<T> post() {
		this.method = HttpMethod.POST;
		return this;
	}

	public RestBuilder<T> get() {
		this.method = HttpMethod.GET;
		return this;
	}

	public RestBuilder<T> put() {
		this.method = HttpMethod.PUT;
		return this;
	}

	public RestBuilder<T> patch() {
		this.method = HttpMethod.PATCH;
		return this;
	}

	public RestBuilder<T> delete() {
		this.method = HttpMethod.DELETE;
		return this;
	}

}
