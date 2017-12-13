package persona.mvp.sample.demo.view.main

import com.trello.rxlifecycle2.android.FragmentEvent
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.frag_home.*
import persona.mvp.sample.demo.R
import persona.mvp.sample.demo.api.UserRespDto
import persona.mvp.sample.demo.bean.UserInstance
import personal.ztcao.baseframe.mvp.base.BaseFragment
import personal.ztcao.baseframe.net.base.RxUtil

class HomeFragment : BaseFragment() {

    override fun getLayout(): Int {
        return R.layout.frag_home
    }

    override fun initView() {
        super.initView()
        message.text = "hello kotlin"
        UserInstance.userName = "admin"
        UserInstance.userPassword ="123"
        val dto = UserInstance.login() ;
//        dto.subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(object: Consumer<UserRespDto> {
//                    override fun accept(p0: UserRespDto) {
//                       val t = p0.userName
//                    }
//         })


        dto.compose(RxUtil.applySchedulers(this, FragmentEvent.CREATE))
                .subscribe(object: Consumer<UserRespDto> {
                    override fun accept(p0: UserRespDto) {
                        val t = p0.userName
                    }
                })
    }

}
