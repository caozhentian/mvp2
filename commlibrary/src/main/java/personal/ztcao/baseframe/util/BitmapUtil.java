package personal.ztcao.baseframe.util;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/12/22.
 */

public class BitmapUtil {
    /**
     * 清空图片的内存
     */
    public static void clearImgMemory(ImageView iv)
    {
        Drawable d = iv.getDrawable();
        if(d!=null&&d instanceof BitmapDrawable)
        {
            Bitmap bmp=((BitmapDrawable)d).getBitmap();
            bmp.recycle();
            bmp=null;
        }
        iv.setImageBitmap(null);
        if(d!=null){
            d.setCallback(null);
        }
    }
}
