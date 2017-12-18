package persona.mvp.sample.demo.view.main

import android.content.Context
import io.reactivex.disposables.Disposable
import personal.ztcao.baseframe.net.base.BaseObserver
import personal.ztcao.baseframe.net.base.ExceptionHandle

/**
 * Created by Administrator on 2017/12/18.
 */
open class LoginBaseObserver(context: Context?) : BaseObserver<LoginRespDto>(context) {

    override fun onError(e: Throwable) {
        super.onError(e)
    }

    override fun onSubscribe(d: Disposable) {
        super.onSubscribe(d)
    }

    override fun hideDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onComplete() {
        super.onComplete()
    }

    override fun onError(e: ExceptionHandle.ResponeThrowable?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onNext(t: LoginRespDto) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}