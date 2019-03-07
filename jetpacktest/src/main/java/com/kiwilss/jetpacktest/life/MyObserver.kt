package com.kiwilss.jetpacktest.life

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent


/**
 * @author : Lss kiwilss
 * @FileName: MyObserver
 * @e-mail : kiwilss@163.com
 * @time : 2019/3/7
 * @desc : {DESCRIPTION}
 */
class MyObserver(val lifecycler: Lifecycle, private val callback: Callback): LifecycleObserver{

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun connectOnCreate(){
        p("connectOnCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
     fun connectOnResume() {
        p("connectOnResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
     fun disConnectOnDestroy() {
        p("disConnectOnDestroy")
    }

    fun p(string: String) {
        callback.update(string)
    }

}


interface Callback{
    fun update(string: String)
}
