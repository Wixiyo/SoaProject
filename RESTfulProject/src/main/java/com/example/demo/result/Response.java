package com.example.demo.result;
//实现返回对象实体
public class Response {
	/** 返回信息码*/
	private String rspCode="000000";
	/** 返回信息内容*/
	private String rspMsg="操作成功";

	//四个重载构造函数
	public Response() {
	}
	
	public Response(ExceptionMsg msg){
		this.rspCode=msg.getCode();
		this.rspMsg=msg.getMsg();
	}
	
	public Response(String rspCode) {
		this.rspCode = rspCode;
		this.rspMsg = "";
	}

	public Response(String rspCode, String rspMsg) {
		this.rspCode = rspCode;
		this.rspMsg = rspMsg;
	}

	//getter和setter方法
	public String getRspCode() {
		return rspCode;
	}
	public void setRspCode(String rspCode) {
		this.rspCode = rspCode;
	}
	public String getRspMsg() {
		return rspMsg;
	}
	public void setRspMsg(String rspMsg) {
		this.rspMsg = rspMsg;
	}

	//重写toString
	@Override
	public String toString() {
		return "Response{" +
				"rspCode='" + rspCode + '\'' +
				", rspMsg='" + rspMsg + '\'' +
				'}';
	}
}
