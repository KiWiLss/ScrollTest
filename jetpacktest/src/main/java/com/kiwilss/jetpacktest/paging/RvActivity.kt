/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: RvActivity
 * Author:   kiwilss
 * Date:     2019/3/9 19:55
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.jetpacktest.paging

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.kiwilss.jetpacktest.R
import com.lxj.androidktx.bus.LiveDataBus
import com.lxj.androidktx.core.e
import com.lxj.androidktx.core.toast
import kotlinx.android.synthetic.main.activity_rv.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


/**
 *@FileName: RvActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/9
 * @desc   : {DESCRIPTION}
 */
class RvActivity: AppCompatActivity(), BaseQuickAdapter.RequestLoadMoreListener{
    override fun onLoadMoreRequested() {
        mCurrent += 10
        initData(mCurrent)
    }

    companion object {
        private const val PAGE_SIZE = 15

        private const val ENABLE_PLACEHOLDERS = false
    }

    private var mCurrent = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv)



        initData(mCurrent)

        initAdapter()

        LiveDataBus.with<List<String>>("data").observe(this,observer = Observer {
            it?.forEach {
                it.e()
            }
        })
    }

    private val mAdapter by lazy {
        MyAdapter()
    }

    private fun initAdapter() {//实现无限滑动

        rv_rv_list.layoutManager = LinearLayoutManager(this)

      rv_rv_list.adapter = mAdapter

        mAdapter.setOnLoadMoreListener(this,rv_rv_list)
       //mAdapter.addData(mDataList)
        //adapter.submitList(list)

        //预加载
        mAdapter.setPreLoadNumber(5)

        mAdapter.setOnItemClickListener { adapter, view, position ->
            val any: String = adapter.data[position] as String
            toast(any)
        }
    }



    //val list = PagedList<Student>()



    private fun initData(start: Int) {
        start.toString().e()
        GlobalScope.launch {
            SystemClock.sleep(500)

            val list = arrayListOf<String>()
            for (i in start until (start + 10)){
                list.add("$i 个数据")
            }
            LiveDataBus.with<List<String>>("data").postValue(list)
            runOnUiThread {
                //mDataList.addAll(list)
                if (start == 0){
                    mAdapter.replaceData(list)
                }else{
                    mAdapter.addData(list)
                }
                mAdapter.loadMoreComplete()
            }

        }




    }
}

class MyAdapter: BaseQuickAdapter<String,BaseViewHolder>(R.layout.student_item) {
    override fun convert(helper: BaseViewHolder?, item: String?) {
        helper!!.setText(R.id.name,item)
    }
}

