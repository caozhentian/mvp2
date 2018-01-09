package persona.mvp.sample.demo.view.splash

import personal.ztcao.baseframe.mvp.base.presenter.BasePresenter
import personal.ztcao.baseframe.mvp.base.view.BaseMvpView


/**
 * Created by Administrator on 2018/1/9.
 */
class SplashContracts {
    interface SplashPresenter : BasePresenter<SplashView>{
       fun loadPic()
    }

    interface SplashView : BaseMvpView {
        fun renderPic()
    }
}