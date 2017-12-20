package personal.ztcao.baseframe.net.base.observer;

import android.content.Context;

import com.syd.oden.circleprogressdialog.core.CircleProgressDialog;

import personal.ztcao.baseframe.mvp.base.toast.ToastUtil;
import personal.ztcao.baseframe.net.base.ExceptionHandle;

/**
 * Created by Administrator on 2017/12/20.
 */

public abstract class BaseProgressObserver<T> extends BaseObserver<T> {

    private CircleProgressDialog circleProgressDialog ;

    public BaseProgressObserver(Context context , CircleProgressDialog circleProgressDialog) {
        super(context);
        this.circleProgressDialog = circleProgressDialog;
    }

    public BaseProgressObserver(Context context){
        super(context) ;
    }

    @Override
    protected void hideDialog() {
        if(circleProgressDialog != null) {
            circleProgressDialog.dismiss();
        }
    }

    @Override
    protected void showDialog() {
        if(circleProgressDialog == null ){
            circleProgressDialog = new CircleProgressDialog(context) ;
        }
        circleProgressDialog.setCancelable(false) ;
        circleProgressDialog.showDialog();
    }

    @Override
    public void onComplete() {
        hideDialog() ;
    }

    @Override
    public void onError(ExceptionHandle.ResponeThrowable e) {
        hideDialog() ;
        ToastUtil.showMsg(context , e.message);
    }

}
