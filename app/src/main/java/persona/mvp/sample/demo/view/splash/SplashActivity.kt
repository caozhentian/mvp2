package persona.mvp.sample.demo.view.splash

import android.support.v4.app.Fragment
import android.view.Window
import personal.ztcao.baseframe.mvp.base.view.BaseSingleFragmentActivity

/**
 * Created by Administrator on 2018/1/9.
 */
class SplashActivity :BaseSingleFragmentActivity<SplashPresenter>(){

    override fun createFragment(): Fragment {
        return SplashFramgent() ;
    }

    override fun preAddContentView() {
        window.requestFeature(Window.FEATURE_NO_TITLE)
    }

}