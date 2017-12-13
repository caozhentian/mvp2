package personal.ztcao.baseframe.mvp.base.bean;

import java.io.Serializable;

/**
 * Created by ztcao on 2017/12/4 0004.
 */

public class PageInfoWithKey<KEY1 extends Serializable, KEY2 extends   Serializable> extends PageInfo{

    public static final int PAGE_FIRST_INDEX   = 0 ;
    public static final int PAGE_DEFAULT_SIZE  = 5 ;

    private int nextPage = PAGE_FIRST_INDEX     ;

    private int pageSize =  PAGE_DEFAULT_SIZE   ;

    private KEY1 key1  ;

    private KEY2 key2  ;

    public PageInfoWithKey(int nextPage) {
        super(nextPage);
    }

    public PageInfoWithKey(int nextPage, int pageSize) {
        super(nextPage, pageSize);
    }


    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
