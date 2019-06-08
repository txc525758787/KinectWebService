package com.txc.kinect.mvc.model;

public class HttpCode {
	//成功
	public final static int SUCCESS = 200;

	//错误码
	public final static int ERROR = 9999; //服务错误
	public final static int DATA_ACCESS_ERROR = 9001; //数据访问错误

	//其他
	public final static int LOGIN_FAIL = 401; //登录失败
	public final static int IP_CHANGED = 403; //ip地址变更


}
