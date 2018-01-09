package com.example.repository

import com.google.gson.reflect.TypeToken
import com.zhouyou.http.EasyHttp
import com.zhouyou.http.callback.CallClazzProxy
import io.reactivex.Observable
import persona.mvp.sample.demo.net.api.CustomApiResult
import persona.mvp.sample.demo.bean.*


/**
 * Created by Administrator on 2017/12/26.
 */
object UserRepository : BaseRepository(){

    fun login(loginRequestDto: LoginRequestDto):Observable<UserRespDto> {
        val observable = EasyHttp.post("m/user/login")
                .readTimeOut((30 * 1000).toLong())//局部定义读超时
                .writeTimeOut((30 * 1000).toLong())
                //.baseUrl("http://apis.juhe.cn")
                .params("userName", loginRequestDto.name)
                .params("password", loginRequestDto.password)

                .execute(object : CallClazzProxy<CustomApiResult<UserRespDto>, UserRespDto>(UserRespDto::class.java) {
                })
        return observable ;
    }


    fun queryTask(taskReqDto: TaskReqDto):Observable<List<TaskEntity>>{
        val type = object : TypeToken<List<TaskEntity>>() {}.type;
        val observable = EasyHttp.post("m/feedback/findTeamworkList")
                .readTimeOut((30 * 1000).toLong())//局部定义读超时
                .writeTimeOut((30 * 1000).toLong())
                //.baseUrl("http://apis.juhe.cn")
                .params("nextPage", taskReqDto.nextPage.toString())
                .params("pageSize", taskReqDto.pageSize.toString())
                .params("pageSize", taskReqDto.employeeId)
                .params("workType", taskReqDto.workType.toString())
                .params("loginId",  taskReqDto.loginId.toString())
                .params("employeeId" ,taskReqDto.employeeId)
                .params("title", "")
                .execute(object : CallClazzProxy<CustomApiResult<List<TaskEntity>>,List<TaskEntity>>(type) {
                })
        return observable ;
    }


    fun queryRecord2():Observable<PageRespBase<Record>> {
        val type = object : TypeToken<PageRespBase<Record>>() {}.type;
        val observable = EasyHttp.post("m/customer/findCustomerNEStatusPage2")
                .readTimeOut((30 * 1000).toLong())//局部定义读超时
                .writeTimeOut((30 * 1000).toLong())
                .params("nextPage", "0")
                .params("pageSize", "10")
                .params("sortData", """[{property:'a.create_Time',direction:'DESC'}]""")
                .params("loginId",  "117")
                .params("employeeId" ,"18")
                .execute(object : CallClazzProxy<CustomApiResult<PageRespBase<Record>>,PageRespBase<Record>>(type) {
                })
        return observable ;
    }
}