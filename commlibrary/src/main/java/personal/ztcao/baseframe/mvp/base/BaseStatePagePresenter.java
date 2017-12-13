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

import personal.ztcao.baseframe.mvp.base.bean.PageInfo;

/**
 * 工程名:mvp
 * 文 件 名: BaseStatePagePresenter
 * 创 建 人: 曹振田
 * 描述:MVP模式中Presenter基类
 * 创建日期: 2017/12/4
 * 修改时间：
 * 修改备注：
 */

public interface BaseStatePagePresenter<T extends BaseView, P extends PageInfo> extends BasePresenter<T>{

    void loadData( )      ;

    void loadMoreData( ) ;
}
