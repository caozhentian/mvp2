package persona.mvp.sample.demo.app

import android.app.Application
import personal.ztcao.baseframe.net.base.RetrofitManager

/**
 * Created by Administrator on 2017/12/12 0012.
 */
class ProjectApp : Application() {

    override fun onCreate() {
        super.onCreate()
        RetrofitManager.setBaseUrl(SERVER_URL)
    }
}