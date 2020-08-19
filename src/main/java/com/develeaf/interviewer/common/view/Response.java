package com.develeaf.interviewer.common.view;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Response<T> {
	
	enum Result {
		SUCCESS("0000", "ok");
		
		private String code;
		private String message;
		Result(String code, String message) {
			this.code = code;
			this.message = message;
		}
	}
	
	private String resultCode;
	private String resultMessage;
	private T data;
	
	public Response() {
	}
	
	public Response(Result result) {
		this.resultCode = result.code;
		this.resultMessage = result.message;
		log(this);
	}
	
	public Response(Result result, T data) {
		this.resultCode = result.code;
		this.resultMessage = result.message;
		this.data = data;
		log(this);
	}
	
	public static <T> Response<T> createSuccess() {
		return new Response<T>(Result.SUCCESS);
	}
	
	public static <T> Response<T> createSuccess(T data) {
		return new Response<T>(Result.SUCCESS, data);
	}
	
	public static Response<?> createResponse(Result result) {
		return new Response<>(result);
	}
	
	public static <T> Response<T> createResponse(Result result, T data) {
		return new Response<T>(result, data);
	}
	
	private static void log(Response<?> response) {
		if (log.isDebugEnabled()) {
			log.debug("## resultCode   : {}", response.getResultCode());
			log.debug("## resultMessage: {}", response.getResultMessage());
			log.debug("## data         : {}", response.getData());
		}
	}
	
}
