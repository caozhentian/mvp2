package personal.ztcao.baseframe.net.base;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/12/20.
 */

public class SchedulersTransformer<T> implements ObservableTransformer<T ,T> {

    @Override
    public ObservableSource<T> apply(Observable upstream) {
        return ((Observable) upstream).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
