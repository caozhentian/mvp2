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
package personal.ztcao.baseframe.mvp.base.view;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;

import com.lufficc.stateLayout.StateLayout;

import personal.ztcao.baseframe.mvp.R;
import personal.ztcao.baseframe.mvp.base.BaseMvpStateMvpView;
import personal.ztcao.baseframe.mvp.base.presenter.BasePresenter;

/**
 * 工程名:mvp
 * 文 件 名: BaseMvpActivity
 * 创 建 人: 曹振田
 * 描述:MVP Fragment基类
 * 创建日期: 2017/11/12 0012 19:40
 * 修改时间：
 * 修改备注：
 */
public abstract class BaseMvpMvpStateFragment<T extends BasePresenter> extends BaseFragment implements BaseMvpStateMvpView {

    //@Inject
    protected T mPresenter;

    //子类中布局中必须包括state_layout布局 约定
    protected StateLayout mStateLayout ;

    @Override
    protected @LayoutRes  int getLayout() {
        return R.layout.frag_base_state_fragment ;
    }

    @Override
    protected void initView() {
        super.initView();
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

    protected abstract void initInject();
}