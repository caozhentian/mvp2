package persona.mvp.sample.demo.bean

/**
 * Created by Administrator on 2017/12/28.
 */
class PageRespBase<T> {

    lateinit var content :List<T> ;
    var totalPages  : Int  = 0 ;
    var totalElements:Int  = 0 ;

}