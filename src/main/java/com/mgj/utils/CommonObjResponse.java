package com.mgj.utils;

import com.mgj.utils.Result.BaseResponse;

public class CommonObjResponse<T> extends BaseResponse {
	private T content;

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}
}
