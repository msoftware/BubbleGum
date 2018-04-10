package com.hold1.bubblegumdemo

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var animScreen: Fragment? = null
    var slideScreen: Fragment? = null
    var buildFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(bottomNavListener)
        displayAnimScreen()
    }

    private val bottomNavListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navAnimate -> {
                displayAnimScreen()
            }
            R.id.navSlide -> {
                displaySlideScreen()

            }
            R.id.navBuild -> {
                displayBuildScreen()
            }
        }
        false
    }

    fun displayAnimScreen() {
        if (animScreen == null)
            animScreen = AnimationFragment()
        supportFragmentManager.beginTransaction().replace(R.id.appContent, animScreen).commit()
    }

    fun displaySlideScreen(){
        if (slideScreen==null)
            slideScreen = SlideFragment()
        supportFragmentManager.beginTransaction().replace(R.id.appContent, slideScreen).commit()
    }

    fun displayBuildScreen(){
        if (buildFragment==null)
            buildFragment = BuildFragment()
        supportFragmentManager.beginTransaction().replace(R.id.appContent, buildFragment).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
