package io.github.tobiahshaw.base.ui.activity

import android.os.Bundle
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import io.github.tobiahshaw.base.common.AppManager

open class BaseActivity : RxAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.instance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.finishActivity(this)
    }
}