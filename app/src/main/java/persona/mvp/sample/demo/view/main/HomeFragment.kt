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


class HomeFragment : BaseFragment() {

    override fun getLayout(): Int {
        return R.layout.frag_home
    }

    override fun initView() {
        super.initView()
        message.text = "hello kotlin"
        UserInstance.userName = "13186075290"
        UserInstance.userPassword ="czt123456"

//        UserInstance.login()
//                .compose(RxUtil.applySchedulers())
//                .compose(ErrorTransformer<UserRespDto>())
//                .subscribe(object : BaseProgressObserver<UserRespDto>(context){
//                    override fun onNext(t: UserRespDto) {
//                        ToastUtil.showMsg(context , t.nickName22) ;
//                    }
//                })
        val mProgressDialog = IProgressDialog {
            val dialog = ProgressDialog(context)
            dialog.setMessage("登录中...")
            dialog
        }
//        EasyHttp.post("m/user/login")
//                .params("userName", UserInstance.userName)
//                .params("password", UserInstance.userPassword)
//                .sign(true)
//                .timeStamp(true)
//                .execute(object : ProgressDialogCallBack<ApiResult<UserRespDto>>(mProgressDialog, true, true) {
//
//                    override fun onError(e: ApiException) {
//                        super.onError(e)
//                        //showToast("登录失败！" + e.getMessage())
//                    }
//
//                    override fun onSuccess(authModel: ApiResult<UserRespDto>) {
//                        ToastUtil.showMsg(context , "登录成功")
//                        //授权类信息存入缓存
//                        //TokenManager.getInstance().setAuthModel(authModel)
//                        //将用户和密码存入缓存
//                        //LoginCache.getInstance().save(name, pass)
//                        //Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                        //startActivity(intent);
//                        //finish()
//                    }
//                })
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
