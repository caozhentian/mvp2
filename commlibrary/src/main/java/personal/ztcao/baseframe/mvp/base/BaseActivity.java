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

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.io.Serializable;
import java8.util.Optional;

import personal.ztcao.baseframe.mvp.base.app.App;

/**
 * 工程名:mvp
 * 文 件 名: BaseActivity
 * 创 建 人: 曹振田
 * 描述:无MVP的activity基类
 * 创建日期: 2017/11/12 0012 19:30
 * 修改时间：
 * 修改备注：
 */

public abstract class BaseActivity extends RxAppCompatActivity {

    public static  final String INTENT_PARAM_KEY = "INTENT_PARAM_KEY" ;

    public static final <ActivityClass>  Intent newIntent(Context packageContext, Class<ActivityClass> activityClass){
        Intent intent = new Intent(packageContext ,activityClass ) ;
        return  intent ;
    }

    public static final <ActivityClass, IntentParam extends Serializable> Intent newIntent(Context packageContext,
                                                          Class<ActivityClass> activityClass ,
                                                          IntentParam intentParam){
        Intent intent = new Intent(packageContext ,activityClass ) ;
        intent.putExtra(INTENT_PARAM_KEY , intentParam) ;
        return  intent ;
    }

    public static final <IntentParam extends Serializable>  Optional<IntentParam> getIntentParam(Intent intent){
        IntentParam intentParam = (IntentParam) intent.getSerializableExtra(INTENT_PARAM_KEY);
        return Optional.ofNullable(intentParam);
    }

    protected Activity mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mContext = this;
        onViewCreated();
        App.getInstance().addActivity(this);
        initEventAndData();
    }

    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //onBackPressedSupport();
            }
        });
    }

    protected void onViewCreated() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getInstance().removeActivity(this);
    }

    protected abstract @LayoutRes  int getLayout();


    protected abstract void initEventAndData();

    /**
     * 跳转到指定的Activity
     *  <p>下文获取传参请使用getIntent().getIntExtra()方式,getIntent().getExtras()可能引起空指针</p>
     */
    protected void startToActivity(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 跳转到指定的Activity并结束当前Activity
     *  <p>下文获取传参请使用getIntent().getIntExtra()方式,getIntent().getExtras()可能引起空指针</p>
     */
    protected void startToActivityAndFinish(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (bundle != null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
        finish();
    }

    /**
     * 带返回的跳转到指定Activity
     * <p>下文获取传参请使用getIntent().getIntExtra()方式,getIntent().getExtras()可能引起空指针</p>
     */
    protected void startToActivityForResult(Class<?> clazz, Bundle bundle, int requestCode) {
        Intent intent = new Intent(this, clazz);
        if (bundle != null){
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 关闭Activity,并返回参数
     */
    protected void closeActivity(Bundle bundle) {
        if (bundle != null){
            Intent intent = new Intent();
            intent.putExtras(bundle);
            setResult(RESULT_OK, intent);
        }
        finish();
    }

    /**
     * 关闭Activity,并返回参数
     */
    protected void closeActivity() {
        finish();
    }
}
