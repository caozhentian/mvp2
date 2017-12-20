package persona.mvp.sample.demo.view.main

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.frag_home.*
import persona.mvp.sample.demo.R
import persona.mvp.sample.demo.api.UserRespDto
import persona.mvp.sample.demo.bean.UserInstance
import personal.ztcao.baseframe.mvp.base.BaseFragment
import personal.ztcao.baseframe.mvp.base.toast.ToastUtil
import personal.ztcao.baseframe.net.base.ErrorTransformer
import personal.ztcao.baseframe.net.base.RxUtil
import personal.ztcao.baseframe.net.base.observer.BaseProgressObserver


class HomeFragment : BaseFragment() {

    override fun getLayout(): Int {
        return R.layout.frag_home
    }

    override fun initView() {
        super.initView()
        message.text = "hello kotlin"
        UserInstance.userName = "13186075290"
        UserInstance.userPassword ="czt123456"

        UserInstance.login()
                .compose(RxUtil.applySchedulers())
                .compose(ErrorTransformer<UserRespDto>())
                .subscribe(object : BaseProgressObserver<UserRespDto>(context){
                    override fun onNext(t: UserRespDto) {
                        ToastUtil.showMsg(context , t.nickName22) ;
                    }
                })
    }

}
