package com.example.demo.result;
//返回结果数据格式封装
public class ResponseData extends Response {
    private Object data;

    //五个重载的构造函数
    public ResponseData(Object data) {
        this.data = data;
    }

    public ResponseData(ExceptionMsg msg) {
        super(msg);
    }

    public ResponseData(String rspCode, String rspMsg) {
        super(rspCode, rspMsg);
    }

    public ResponseData(String rspCode, String rspMsg, Object data) {
        super(rspCode, rspMsg);
        this.data = data;
    }

    public ResponseData(ExceptionMsg msg, Object data) {
        super(msg);
        this.data = data;
    }
    //Data的getter和setter方法
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }

    //重写toString方法
    @Override
    public String toString() {
        return "ResponseData{" +
                "data=" + data +
                "} " + super.toString();
    }
}

/*return new ResponseData(ExceptionMsg.SUCCESS,"你好");*/
