package com.example.repository

import com.zhouyou.http.EasyHttp
import com.zhouyou.http.callback.CallClazzProxy
import io.reactivex.Observable
import persona.mvp.sample.demo.net.api.CustomApiResult
import persona.mvp.sample.demo.bean.PageRespBase
import java.lang.reflect.Type

/**
 * Created by Administrator on 2017/12/26.
 */
open class BaseRepository {

    open  fun<T> remoteQueryDataByPage(type : Type): Observable<PageRespBase<T>> {

        val observable = EasyHttp.post("m/customer/findCustomerNEStatusPage2")
                .params("nextPage", "0")
                .params("pageSize", "10")
                .params("sortData", """[{property:'a.create_Time',direction:'DESC'}]""")
                .params("loginId",  "117")
                .params("employeeId" ,"18")
                .execute(object : CallClazzProxy<CustomApiResult<PageRespBase<T>>, PageRespBase<T>>(type) {
                })
        return observable ;
    }
}