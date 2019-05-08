package com.kiwilss.lxkj.apktest

import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.kiwilss.lxkj.apktest.contentprovider.ContentActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var newId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_main_singleInstance.setOnClickListener {
            val intent = Intent()
            intent.action = "com.castiel.demo.singleinstance"
            startActivity(intent)
        }
        btn_main_create.setOnClickListener {
            startActivity(Intent(this,ContentActivity::class.java))
        }
        btn_main_two.setOnClickListener {

            //直接访问进程一中的数据
            /**
             * 对user表进行操作
             */

            // 设置URI  cn.scu.myprovider
            val uri_user = Uri.parse("content://com.kiwilss.lxkj.myprovider/user")

            // 插入表中数据
            val values = ContentValues()
            values.put("_id", 4)
            values.put("name", "Jordan")


            // 获取ContentResolver
            val resolver = contentResolver
            // 通过ContentResolver 根据URI 向ContentProvider中插入数据
            resolver.insert(uri_user, values)

            // 通过ContentResolver 向ContentProvider中查询数据
            val cursor = resolver.query(uri_user, arrayOf("_id", "name"), null, null, null)
            while (cursor!!.moveToNext()) {
                Log.e("MMM", ": "+ cursor.getInt(0) + " " + cursor.getString(1));
                System.out.println("query book:" + cursor.getInt(0) + " " + cursor.getString(1))
                // 将表中数据全部输出
            }
            cursor.close()
            // 关闭游标

//            /**
//             * 对job表进行操作
//             */
//            // 和上述类似,只是URI需要更改,从而匹配不同的URI CODE,从而找到不同的数据资源
//            val uri_job = Uri.parse("content://scut.carson_ho.myprovider/job")
//
//            // 插入表中数据
//            val values2 = ContentValues()
//            values2.put("_id", 4)
//            values2.put("job", "NBA Player")
//
//            // 获取ContentResolver
//            val resolver2 = contentResolver
//            // 通过ContentResolver 根据URI 向ContentProvider中插入数据
//            resolver2.insert(uri_job, values2)
//
//            // 通过ContentResolver 向ContentProvider中查询数据
//            val cursor2 = resolver2.query(uri_job, arrayOf("_id", "job"), null, null, null)
//            while (cursor2!!.moveToNext()) {
//                Log.e("MMM", ": "+ cursor2.getInt(0) + " " + cursor2.getString(1));
//                System.out.println("query job:" + cursor2.getInt(0) + " " + cursor2.getString(1))
//                // 将表中数据全部输出
//            }
//            cursor2.close()
//            // 关闭游标
        }

//        add_data.setOnClickListener {
//            // 添加数据
//
//            val uri = Uri.parse("content://com.example.databasetest.provider/book")
//            val values = ContentValues()
//            values.put("name", "A Clash of Kings");
//            values.put("author", "George Martin");
//            values.put("pages", 1040);
//            values.put("price", 22.85);
//            val newUri = contentResolver.insert(uri, values);
//            newId= newUri.pathSegments[1]
//        }
//        query_data.setOnClickListener {
//
//        }
//        update_data.setOnClickListener {
//
//        }
//        delete_data.setOnClickListener {
//
//        }
    }
}
