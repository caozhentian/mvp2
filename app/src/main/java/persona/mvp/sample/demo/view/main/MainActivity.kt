package persona.mvp.sample.demo.view.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import persona.mvp.sample.demo.R
import personal.ztcao.baseframe.mvp.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun getLayout(): Int {
        return R.layout.activity_main ;
    }

    override fun initEventAndData() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        initFragment()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                viewPager.currentItem = 0
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                viewPager.currentItem = 1
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                viewPager.currentItem = 2
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    fun initFragment(){
        var fragments = ArrayList<Fragment>()
        fragments.add(HomeFragment())
        fragments.add(DemoFragment())
        viewPager.adapter = SectionsPagerAdapter(supportFragmentManager, fragments)
        viewPager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }
            override fun onPageSelected(position: Int) {
                navigation.getMenu().getItem(position).setChecked(true);
            }
        });
    }
}
