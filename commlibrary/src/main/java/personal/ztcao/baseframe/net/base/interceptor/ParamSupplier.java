package personal.ztcao.baseframe.net.base.interceptor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/20.
 */

public class ParamSupplier {
    public static final String ISMI = "ismi";

    private static Map<String, String> sParamMap = new HashMap();

    public static final Map<String , String> supplyParamMap(){
        sParamMap.put(ISMI , "AEDA32DE") ;
        return sParamMap ;
    }
}
