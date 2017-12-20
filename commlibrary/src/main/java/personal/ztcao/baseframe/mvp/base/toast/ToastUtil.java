package personal.ztcao.baseframe.mvp.base.toast;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/12/20.
 */

public class ToastUtil {

    public static final void showMsg(Context context , String message){
        Toast.makeText(context , message , Toast.LENGTH_LONG).show() ;
    }
}
