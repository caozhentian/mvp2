package persona.mvp.sample.demo.api

import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by Administrator on 2017/12/10 0010.
 */
interface UserApi {
    @POST("driver/login")
    @FormUrlEncoded
    fun  login(@Field("userName") userName : String , @Field("password") password : String ) :Observable<UserRespDto>
}