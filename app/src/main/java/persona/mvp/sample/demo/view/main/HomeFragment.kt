package persona.mvp.sample.demo.view.main

import android.app.ProgressDialog
import com.example.repository.LoginRequestDto
import com.example.repository.UserRepository
import com.example.repository.UserRespDto
import com.zhouyou.http.exception.ApiException
import com.zhouyou.http.subsciber.IProgressDialog
import com.zhouyou.http.subsciber.ProgressSubscriber
import kotlinx.android.synthetic.main.frag_home.*
import persona.mvp.sample.demo.R
import persona.mvp.sample.demo.bean.UserInstance
import personal.ztcao.baseframe.mvp.base.BaseFragment
import personal.ztcao.baseframe.mvp.base.toast.ToastUtil
import com.zhouyou.http.callback.CallClazzProxy
import com.zhouyou.http.EasyHttp
import com.google.gson.reflect.TypeToken


class HomeFragment : BaseFragment() {

    override fun getLayout(): Int {
        return R.layout.frag_home
    }

    override fun initView() {
        super.initView()
        message.text = "hello kotlin"
        UserInstance.userName = "13186075290"
        UserInstance.userPassword ="czt123456"

        val mProgressDialog = IProgressDialog {
            val dialog = ProgressDialog(context)
            dialog.setMessage("登录中...")
            dialog
        }

        val loginRequestDto = LoginRequestDto(UserInstance.userName , UserInstance.userPassword) ;
        val observable = UserRepository.login(loginRequestDto) ;
        observable.subscribe(object : ProgressSubscriber<UserRespDto>(context, mProgressDialog) {
            override fun onError(e: ApiException) {
                super.onError(e)
                ToastUtil.showMsg(context , e.message)
            }

            override fun onNext(result: UserRespDto) {
                ToastUtil.showMsg(context , result.toString())
            }
        })


    }

}
