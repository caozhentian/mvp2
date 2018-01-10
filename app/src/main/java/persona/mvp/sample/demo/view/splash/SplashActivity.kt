package persona.mvp.sample.demo.view.splash

import android.support.annotation.LayoutRes
import com.jaeger.library.StatusBarUtil
import persona.mvp.sample.demo.R
import personal.ztcao.baseframe.mvp.base.BaseActivity



/**
 * Created by Administrator on 2018/1/9.
 */
class SplashActivity : BaseActivity(){
    override fun initEventAndData() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


//    override fun preAddContentView() {
//        super.preAddContentView()
//        val decorView = window.decorView
//        // Hide the status bar.
//        val uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
//        decorView.setSystemUiVisibility(uiOptions);
//    }
//
//    //告诉BaseActivity 处于全屏模式
//    override fun isFullScreen(): Boolean {
//        return true
//    }

    override fun setStatusBar() {
        //StatusBarUtil.setTranslucent(this, 30);
        StatusBarUtil.setTranslucent(this);
    }

    @LayoutRes
    override fun getLayout(): Int {
        return R.layout.frag_splash
    }
}