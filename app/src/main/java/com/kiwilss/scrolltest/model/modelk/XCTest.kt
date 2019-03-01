/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: XCTest
 * Author:   kiwilss
 * Date:     2019/2/28 16:02
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.scrolltest.model.modelk

import kotlinx.coroutines.*

/**
 *@FileName: XCTest
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/2/28
 * @desc   : {DESCRIPTION}
 */


 fun main(args: Array<String>) {

    //在后台启动一个新的协程并继续
//    GlobalScope.launch {
//        delay(1000L)//非堵塞1秒
//        print("hello")
//    }
//    println("world,") // 协程已在等待时主线程还在继续
//    Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证 JVM 存活

    //效果同上
//    thread {
//        Thread.sleep(1000L)
//        print("hello")
//    }
//
//    println("world")
//    Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证 JVM 存活


    //桥接堵塞与非堵塞
//    GlobalScope.launch {
//        delay(1000)
//        println("word")
//    }
//    println("hello")//主线程中立刻执行
//    //这个表达式会堵塞主线程
//    runBlocking {
//        delay(2000)
//    }

    val job = GlobalScope.launch {
        delay(1000)
        println("word")
    }
    println("hello")
    //job.join()


    GlobalScope.launch {


    }
    GlobalScope.async {


    }


}




            fun test() = runBlocking{

            }