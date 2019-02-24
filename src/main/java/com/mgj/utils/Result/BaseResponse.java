package com.mgj.utils.Result;


/**
 * 接口公共响应参数
 * 
 * @author chengh
 * 
 */
public class BaseResponse {

	private Integer code = 0; // 响应结构
	private String message; // 响应消息

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setResultCode(ResultCode resultCode) {
		this.code = resultCode.getCode();
		this.message = resultCode.getMsg();
	}
	
	public ResultCode getResultCode() {
	    for(ResultCode rc : ResultCode.values()) {
	        if(rc.getCode().equals(this.code)) {
	            return rc;
	        }
	    }
	    return null;
	}

	@Override
	public String toString() {
		return "BaseResponse [result=" + code + ", message=" + message + "]";
	}

}
