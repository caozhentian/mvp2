package persona.mvp.sample.demo.app

import com.blankj.utilcode.util.Utils
import com.zhouyou.http.EasyHttp
import com.zhouyou.http.cache.converter.SerializableDiskConverter
import com.zhouyou.http.model.HttpHeaders
import com.zhouyou.http.model.HttpParams
import persona.mvp.sample.demo.net.interceptor.CustomSignInterceptor
import persona.mvp.sample.demo.net.interceptor.TokenInterceptor
import personal.ztcao.baseframe.mvp.base.app.App


/**
 * Created by Administor on 2017/12/12 0012.
 */
class ProjectApp : App() {
    override fun onCreate() {
        super.onCreate()
        appContext = this ;
        initEasyHttp() ;
        Utils.init(this);
    }

    fun initEasyHttp(){
        EasyHttp.init(this)//默认初始化
        //设置请求头
        val headers = HttpHeaders()
        headers.put("User-Agent", "AE1883")
        //设置请求参数
        val params = HttpParams()
        params.put("ismi",  "DE784923XB")
        params.put("appId",  "AE1883")
        EasyHttp.getInstance()
                .debug("RxEasyHttp", true)
                .setReadTimeOut((60 * 1000).toLong())
                .setWriteTimeOut((60 * 1000).toLong())
                .setConnectTimeout((60 * 1000).toLong())
                .setRetryCount(3)//默认网络不好自动重试3次
                .setRetryDelay(500)//每次延时500ms重试
                .setRetryIncreaseDelay(500)//每次延时叠加500ms
                .setBaseUrl(SERVER_URL)
                .setCacheDiskConverter(SerializableDiskConverter())//默认缓存使用序列化转化
                .setCacheMaxSize((50 * 1024 * 1024).toLong())//设置缓存大小为50M
                .setCacheVersion(1)//缓存版本为1
                //.setHostnameVerifier(UnSafeHostnameVerifier(Url))//全局访问规则
                .setCertificates()//信任所有证书
                //.addConverterFactory(GsonConverterFactory.create(gson))//本框架没有采用Retrofit的Gson转化，所以不用配置
                .addCommonHeaders(headers)//设置全局公共头
                .addCommonParams(params)//设置全局公共参数
                .addInterceptor(CustomSignInterceptor())//添加参数签名拦截器
                .addInterceptor(TokenInterceptor())
                //.addInterceptor(new HeTInterceptor());//处理自己业务的拦截器

    }

    companion object {
        lateinit var appContext : ProjectApp ;

    }
}