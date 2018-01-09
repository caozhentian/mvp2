package personal.ztcao.baseframe.mvp.base.presenter;

import personal.ztcao.baseframe.mvp.base.view.BaseMvpView;

/**
 * Created by Administrator on 2018/1/9.
 */

public class BaseMvpPresenter<T extends BaseMvpView> implements BasePresenter {

    private T view ;
    @Override
    public void attachView(BaseMvpView view) {
        this.view = (T) view;
    }

    @Override
    public void detachView() {
        this.view = null ;
    }
}
