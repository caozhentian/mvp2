/*
******************************* Copyright (c)*********************************\
**
**                 (c) Copyright 2017
**                          All Rights Reserved
**
**                           By(公司)
**
**-----------------------------------版本信息------------------------------------
** 版    本: V1.0
**
**------------------------------------------------------------------------------
********************************End of Head************************************\
*/
package personal.ztcao.baseframe.net.base;

import java.io.Serializable;

/**
 * 工程名:mvp
 * 文 件 名: HttpResult
 * 创 建 人: 曹振田
 * 描述:网络的响应
 * 创建日期: 2017/11/18  10:16
 * 修改时间：
 * 修改备注：
 */
@SuppressWarnings("unused")
public class HttpResult<T> implements Serializable {
    private int code;
    private String msg;
    private T result;

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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
