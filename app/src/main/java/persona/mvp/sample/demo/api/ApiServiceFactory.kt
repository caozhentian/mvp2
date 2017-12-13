package persona.mvp.sample.demo.api

import personal.ztcao.baseframe.net.base.RetrofitManager

/**
 * Created by Administrator on 2017/12/11 0011.
 */
object ApiServiceFactory {
    fun <T> createRetrofitService(clazz: Class<T>): T {
        return RetrofitManager.getInstance().create(clazz)
    }
}