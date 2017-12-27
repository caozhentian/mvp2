package persona.mvp.sample.demo.view.main

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.repository.UserRepository
import com.example.repository.UserRespDto
import com.zhouyou.http.exception.ApiException
import com.zhouyou.http.subsciber.IProgressDialog
import com.zhouyou.http.subsciber.ProgressSubscriber
import kotlinx.android.synthetic.main.frag_home.*
import persona.mvp.sample.demo.R
import persona.mvp.sample.demo.bean.TaskEntity
import persona.mvp.sample.demo.bean.TaskReqDto
import persona.mvp.sample.demo.bean.TaskRespDto
import personal.ztcao.baseframe.mvp.base.toast.ToastUtil

/**
 * Created by Administrator on 2017/12/9 0009.
 */
class DemoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var mRootView = inflater?.inflate(R.layout.frag_home , container , false) ;
        return mRootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState) ;
        message?.text = "hello" ;
        val mProgressDialog = IProgressDialog {
            val dialog = ProgressDialog(context)
            dialog.setMessage("查询中...")
            dialog
        }

        UserRepository.queryTask(TaskReqDto()).subscribe(object : ProgressSubscriber<List<TaskEntity>>(context, mProgressDialog) {
            override fun onError(e: ApiException) {
                super.onError(e)
                ToastUtil.showMsg(context , e.message)
            }

            override fun onNext(result: List<TaskEntity>) {
                ToastUtil.showMsg(context , result.toString())
            }
        })
    }
}