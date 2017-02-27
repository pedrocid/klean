package com.lorcapp.klean.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import com.lorcapp.klean.R

abstract class SingleFragmentActivity<out T : BasePresenter<U>, U : BasePresenter.View> : BaseActivity<T, U>() {

    companion object {

        val TAG_FRAGMENT = "SingleActivityFragment"
    }

    override val activityLayout: Int
        get() = R.layout.activity_single_fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, initializeFragment(), TAG_FRAGMENT)
                    .commit()
        }
    }

    protected abstract fun initializeFragment(): Fragment
}