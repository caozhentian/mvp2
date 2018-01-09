package persona.mvp.sample.demo.view.main

import android.app.ProgressDialog
import com.example.repository.LoginRequestDto
import com.example.repository.UserRepository
import com.google.gson.reflect.TypeToken
import com.zhouyou.http.exception.ApiException
import com.zhouyou.http.subsciber.IProgressDialog
import com.zhouyou.http.subsciber.ProgressSubscriber
import io.reactivex.Observable
import persona.mvp.sample.demo.R
import persona.mvp.sample.demo.bean.PageRespBase
import persona.mvp.sample.demo.bean.Record
import persona.mvp.sample.demo.bean.UserInstance
import personal.ztcao.baseframe.mvp.base.view.BaseFragment
import personal.ztcao.baseframe.mvp.base.toast.ToastUtil


class HomeFragment : BaseFragment() {

    override fun getLayout(): Int {
        return R.layout.frag_home
    }

    override fun initView() {
        super.initView()
        //message.text = "hello kotlin"
        UserInstance.userName = "13186075290"
        UserInstance.userPassword ="czt123456"

        val mProgressDialog = IProgressDialog {
            val dialog = ProgressDialog(context)
            dialog.setMessage("登录中...")
            dialog
        }

        val loginRequestDto = LoginRequestDto(UserInstance.userName , UserInstance.userPassword) ;
        val observable = UserRepository.login(loginRequestDto) ;
//        observable.subscribe(object : ProgressSubscriber<UserRespDto>(context, mProgressDialog) {
//            override fun onError(e: ApiException) {
//                super.onError(e)
//                ToastUtil.showMsg(context , e.message)
//            }
//
//            override fun onNext(result: UserRespDto) {
//                ToastUtil.showMsg(context , result.toString())
//            }
//        })


//        UserRepository.queryRecord2().subscribe(object : ProgressSubscriber<PageRespBase<Record>>(context, mProgressDialog) {
//                    override fun onError(e: ApiException) {
//                        super.onError(e)
//                        ToastUtil.showMsg(context, e.message)
//                    }
//
//                    override fun onNext(result: PageRespBase<Record>) {
//                        ToastUtil.showMsg(context, result.toString())
//                    }
//                })
        val type = object : TypeToken<PageRespBase<Record>>() {}.type;
        val observable4: Observable<PageRespBase<Record>>  = UserRepository.remoteQueryDataByPage(type) ;
        observable4.subscribe(object : ProgressSubscriber<PageRespBase<Record>>(context, mProgressDialog) {
            override fun onError(e: ApiException) {
                super.onError(e)
                ToastUtil.showMsg(context, e.message)
            }

            override fun onNext(result: PageRespBase<Record>) {
                ToastUtil.showMsg(context, result.toString())
            }
        })

    }

}
