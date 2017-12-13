/*
******************************* Copyright (c)*********************************\
**
**                 (c) Copyright 2017
**                          All Rights Reserved
**
**                           By(公司)
**
**-----------------------------------版本信息------------------------------------
** 版    本: V1.0
**
**------------------------------------------------------------------------------
********************************End of Head************************************\
*/
package personal.ztcao.baseframe.mvp.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lufficc.stateLayout.StateLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import personal.ztcao.baseframe.mvp.R;

/**
 * 工程名:mvp
 * 文 件 名: BaseMvpActivity
 * 创 建 人: 曹振田
 * 描述:MVP Fragment基类
 * 创建日期: 2017/11/12 0012 19:40
 * 修改时间：
 * 修改备注：
 */
public abstract class BaseMvpSingleRecylerFragment<T extends BasePresenter, Item> extends BaseFragment implements BaseStatePageView<Item> {

    //@Inject
    protected T mPresenter;

    //子类中布局中必须包括state_layout布局 约定
    protected StateLayout mStateLayout ;

    protected SmartRefreshLayout mRefreshLayout  ;
    protected RecyclerView mRecyclerView ;

    protected BaseQuickAdapter<Item ,BaseViewHolder> mItemBaseQuickAdapter ;

//    protected FragmentComponent getFragmentComponent(){
//        return DaggerFragmentComponent.builder()
//                .appComponent(App.getAppComponent())
//                .fragmentModule(getFragmentModule())
//                .build();
//    }
//
//    protected FragmentModule getFragmentModule(){
//        return new FragmentModule(this);
//    }


    @Override
    protected @LayoutRes  int getLayout() {
        return R.layout.frag_base_state_recycler_view_fragment ;
    }

    @Override
    protected void initView() {
        super.initView();
        mStateLayout    = mRootView.findViewById(R.id.state_layout) ;
        mRefreshLayout  = mRootView.findViewById(R.id.refreshLayout) ;
        mRecyclerView = mRootView.findViewById(R.id.recyle_view) ;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initInject();
        mPresenter.attachView(this);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroyView();
    }

    @Override
    public void showErrorMsg(String msg) {
        //SnackbarUtil.show(((ViewGroup) getActivity().findViewById(android.R.id.content)).getChildAt(0), msg);
    }

    @Override
    public void useNightMode(boolean isNight) {

    }

    @Override
    public void stateError() {
        mStateLayout.showErrorView();
    }

    @Override
    public void stateEmpty() {
        mStateLayout.showEmptyView();
    }

    @Override
    public void stateLoading() {
        mStateLayout.showProgressView();
    }

    @Override
    public void stateMain() {
        mStateLayout.showContentView();
    }

    @Override
    public void renderData(List<Item> datas) {

    }

    @Override
    public void renderMoreData(List<Item> datas) {

    }

    @Override
    public void noMoreData() {

    }

    @Override
    public void finishLoadMore() {

    }

    @Override
    public void finishRefresh() {

    }

    protected abstract void initInject();
}