package personal.ztcao.baseframe.net.base;

import com.google.gson.annotations.SerializedName;

public class BaseResponse<T> {

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String msg;
    @SerializedName("object")
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isOk() {
        return code == 1;
    }

}
