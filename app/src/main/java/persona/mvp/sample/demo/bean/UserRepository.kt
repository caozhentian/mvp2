package com.example.repository

import com.example.repository.BaseRepository
import com.zhouyou.http.EasyHttp
import com.zhouyou.http.callback.CallClazzProxy
import io.reactivex.Observable
import persona.mvp.sample.demo.api.CustomApiResult
import persona.mvp.sample.demo.bean.UserInstance


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
}