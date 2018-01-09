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
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import personal.ztcao.baseframe.mvp.R;
import personal.ztcao.baseframe.mvp.base.BaseActivity;
import personal.ztcao.baseframe.mvp.base.presenter.BasePresenter;

/**
 * 工程名:mvp
 * 文 件 名: BaseView
 * 创 建 人: 曹振田
 * 描述:实现状态功能的MVP的基类Activity， 同时只包含一个Fragment
 * 创建日期: 2017/11/12 0012 19:33
 * 修改时间：
 * 修改备注：
 */
abstract public class BaseSingleFragmentActivity<T extends BasePresenter>  extends BaseActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragmentContainer, fragment)
                    .commit();
        }
    }

    @Override
    protected @LayoutRes  int getLayout() {
        return R.layout.act_base_single_fragment;
    }

    protected abstract Fragment createFragment();
    

    protected  void initEventAndData(){

    }


}
