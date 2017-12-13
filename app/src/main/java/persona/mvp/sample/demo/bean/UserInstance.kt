package persona.mvp.sample.demo.bean

import io.reactivex.Observable
import persona.mvp.sample.demo.api.ApiServiceFactory
import persona.mvp.sample.demo.api.UserApi
import persona.mvp.sample.demo.api.UserRespDto

/**
 * Created by Administrator on 2017/12/12 0012.
 */
object UserInstance {

    var userName : String    = "admin" ;
    var userPassword:String = "123456" ;

    fun login() : Observable<UserRespDto> = ApiServiceFactory.createRetrofitService(UserApi::class.java).login(userName ,userPassword) ;
}