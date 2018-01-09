package persona.mvp.sample.demo.view.splash

import android.os.Handler
import android.view.Window
import kotlinx.android.synthetic.main.frag_splash.*
import persona.mvp.sample.demo.R
import persona.mvp.sample.demo.view.main.MainActivity
import personal.ztcao.baseframe.mvp.base.BaseActivity
import personal.ztcao.baseframe.mvp.base.view.BaseFragment

/**
 * Created by Administrator on 2018/1/9.
 */
class SplashFramgent:BaseFragment(),SplashContracts.SplashView {

    override fun renderPic() {
        iv_splash.setImageDrawable(resources.getDrawable(R.mipmap.ic_launcher_round))
    }

    override fun getLayout(): Int {
       return R.layout.frag_splash
    }

    override  fun initView() {
        super.initView()
        renderPic()
        val handler = Handler()
        handler.postDelayed(
                {gotoActivity(MainActivity::class.java ,true)},
                3000) // 延迟3秒，跳转到下界面

    }
}