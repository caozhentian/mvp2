package persona.mvp.sample.demo.api;

import com.zhouyou.http.model.ApiResult;

/**
 * Created by Administrator on 2017/12/25.
 */

public class CustomApiResult<T> extends ApiResult<T> {

    private String message;
    private T object;

    @Override
    public String getMsg() {
        return message ;
    }

    @Override
    public void setMsg(String msg) {
        message = msg ;
    }

    @Override
    public T getData() {
        return getObject();
    }

    @Override
    public void setData(T data) {
       setObject(data);
    }

    @Override
    public boolean isOk() {
        return getCode() == 1;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
