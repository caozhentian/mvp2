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

import android.support.v7.app.AppCompatDelegate;

import com.lufficc.stateLayout.StateLayout;

import personal.ztcao.baseframe.mvp.R ;

/**仅单独使用Activity 完成的UI 集成
 * 工程名:mvp
 * 文 件 名: BaseMvpActivity
 * 创 建 人: 曹振田
 * 描述:需要MVP支持的activity基类
 * 创建日期: 2017/11/12 0012 19:40
 * 修改时间：
 * 修改备注：
 */
public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView {

    //@Inject
    protected T mPresenter;
//    protected ActivityComponent getActivityComponent(){
//        return  DaggerActivityComponent.builder()
//                .appComponent(App.getAppComponent())
//                .activityModule(getActivityModule())
//                .build();
//    }
//
//    protected ActivityModule getActivityModule(){
//        return new ActivityModule(this);
//    }

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    @Override
    public void showErrorMsg(String msg) {
        //SnackbarUtil.show(((ViewGroup) findViewById(android.R.id.content)).getChildAt(0), msg);
    }

    @Override
    public void useNightMode(boolean isNight) {
        if (isNight) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
        }
        recreate();
    }

    protected abstract void initInject();
}