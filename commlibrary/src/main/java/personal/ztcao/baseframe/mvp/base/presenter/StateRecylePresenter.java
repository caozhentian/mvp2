package personal.ztcao.baseframe.mvp.base.presenter;


import personal.ztcao.baseframe.mvp.base.BaseMvpStatePageView;
import personal.ztcao.baseframe.mvp.base.bean.PageInfo;

/**
 * Created by ztcao
 */

abstract public class StateRecylePresenter<T extends BaseMvpStatePageView, P extends PageInfo>
        implements BaseStatePagePresenter<T , P> {


    private PageInfo mPageInfo = new PageInfo();


    @Override
    public void loadData() {
        mPageInfo.reset();
        loadDataByPage() ;
    }

    @Override
    public void loadMoreData() {
        mPageInfo.addPage();
        loadDataByPage() ;
    }

    //子类实现从网络中加载数据
    abstract protected  void loadDataFromNet( ) ;

    private void loadDataByPage(){
        //loadDataFromNet(subscriber)  ;
    }



}
