package persona.mvp.sample.demo.view.main

import android.util.Log
import android.widget.Toast
import com.trello.rxlifecycle2.android.FragmentEvent
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.frag_home.*
import persona.mvp.sample.demo.R
import persona.mvp.sample.demo.api.UserRespDto
import persona.mvp.sample.demo.bean.UserInstance
import personal.ztcao.baseframe.mvp.base.BaseFragment
import personal.ztcao.baseframe.net.base.*


class HomeFragment : BaseFragment() {

    override fun getLayout(): Int {
        return R.layout.frag_home
    }

    override fun initView() {
        super.initView()
        message.text = "hello kotlin"
        UserInstance.userName = "13186075290"
        UserInstance.userPassword ="czt123456"
        val login = UserInstance.login() ;
//        dto.subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(object: Consumer<UserRespDto> {
//                    override fun accept(p0: UserRespDto) {
//                       val t = p0.userName
//                    }
//         })


        login.compose(RxUtil.applySchedulers(this, FragmentEvent.CREATE))
                .subscribe(object: Consumer<BaseResponse<UserRespDto>> {
                    override fun accept(p0: BaseResponse<UserRespDto>) {
                        val t = p0.msg ;
                    }
        })
        var  dto:Observable<UserRespDto> = login.compose(ErrorTransformer<UserRespDto>())
                .compose(RxUtil.applySchedulers(this, FragmentEvent.STOP)) ;

        dto.subscribe(object :BaseObserver<UserRespDto>(context){
            override fun hideDialog() {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onNext(t: UserRespDto) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun showDialog() {
               //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onError(e: ExceptionHandle.ResponeThrowable?) {

            }

        })
//        dto.subscribe(object: Observer<UserRespDto>{
//                    override fun onSubscribe(d: Disposable) {
//
//                    }
//
//                    override fun onComplete() {
//
//                    }
//
//                    override fun onError(e: Throwable) {
//
//                    }
//
//                    override fun onNext(t: UserRespDto) {
//
//                    }
//
//                });
    }

}
