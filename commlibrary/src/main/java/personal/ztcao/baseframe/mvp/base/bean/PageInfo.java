package personal.ztcao.baseframe.mvp.base.bean;

import java.io.Serializable;

/**
 * Created by ztcao on 2017/12/4 0004.
 */

public class PageInfo implements   Serializable {

    public static final int PAGE_FIRST_INDEX   = 0 ;
    public static final int PAGE_DEFAULT_SIZE  = 5 ;

    private int nextPage = PAGE_FIRST_INDEX     ;

    private int pageSize =  PAGE_DEFAULT_SIZE   ;

    public PageInfo() {
    }

    public PageInfo(int nextPage) {
        this.nextPage = nextPage;
    }

    public PageInfo(int nextPage, int pageSize) {
        this.nextPage = nextPage;
        this.pageSize = pageSize;
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

    public  void reset(){
        nextPage = 0 ;
    }

    public void addPage(){
        nextPage ++ ;
    }

    public void subPage(){
        nextPage -- ;
    }

    public static final int sGetFirstPageIndex(){
        return PAGE_FIRST_INDEX ;
    }
}
