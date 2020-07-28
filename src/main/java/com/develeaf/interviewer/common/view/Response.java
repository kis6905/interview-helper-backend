package com.develeaf.interviewer.common.view;

import lombok.Data;

@Data
public class Response {
	
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
	private Object data;
	
	public Response() {
	}
	
	public Response(Result result) {
		this.resultCode = result.code;
		this.resultMessage = result.message;
	}
	
	public Response(Result result, Object data) {
		this.resultCode = result.code;
		this.resultMessage = result.message;
		this.data = data;
	}
	
	public static Response createSuccess() {
		return new Response(Result.SUCCESS);
	}
	
	public static Response createSuccess(Object data) {
		return new Response(Result.SUCCESS, data);
	}
	
	public static Response createResponse(Result result) {
		return new Response(result);
	}
	
	public static Response createResponse(Result result, Object data) {
		return new Response(result, data);
	}
	
}
