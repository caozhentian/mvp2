package personal.ztcao.baseframe.mvp.base;


import personal.ztcao.baseframe.mvp.base.bean.PageInfo;

/**
 * Created by ztcao
 */

abstract public class StateRecylePresenter<T extends BaseStatePageView, P extends PageInfo>
        implements BaseStatePagePresenter<T , P> {

    private T  view;

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
