package persona.mvp.sample.demo.view.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.frag_home.*
import persona.mvp.sample.demo.R

/**
 * Created by Administrator on 2017/12/9 0009.
 */
class DemoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var mRootView = inflater?.inflate(R.layout.frag_home , container , false) ;
//        val message = mRootView?.findViewById<TextView>(R.id.message) ;
//        message?.text = "hello2"
        return mRootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState) ;
        message?.text = "hello" ;
    }
}