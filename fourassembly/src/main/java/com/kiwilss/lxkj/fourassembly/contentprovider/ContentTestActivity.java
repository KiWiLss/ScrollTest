package com.kiwilss.lxkj.fourassembly.contentprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.kiwilss.lxkj.fourassembly.R;

/**
 * @author : Lss kiwilss
 * @FileName: ContentTestActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019-05-07
 * @desc : {DESCRIPTION}
 */
public class ContentTestActivity extends AppCompatActivity {

    private MyDataBaseHelper mDb;
    private SQLiteDatabase mSqd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        mDb = new MyDataBaseHelper(this, "BookStore.db", null, 1);



    }

    public void createSQ(View view) {
        mSqd = mDb.getWritableDatabase();
    }

    public void addData(View view) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name","The Da Vinci Code");
        contentValues.put("author", "Dan Brown");
        contentValues.put("pages", 454);
        contentValues.put("price", 16.96);
        mSqd.insert("Book", null, contentValues); // 插入第一条数据

        contentValues.clear();
// 开始组装第二条数据
        contentValues.put("name", "The Lost Symbol");
        contentValues.put("author", "Dan Brown");
        contentValues.put("pages", 510);
        contentValues.put("price", 19.95);
        mSqd.insert("Book", null, contentValues); // 插入第二条数据
    }

    public void deleteData(View view) {
        mSqd.delete("Book","pages > ?",new String[]{"500"});
    }

    public void queryData(View view) {
        //查询所有的数据
        Cursor cursor = mSqd.query("Book", null, null, null, null, null, null);
        if (cursor.moveToFirst()){
            do{
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String author = cursor.getString(cursor.getColumnIndex("author"));
                int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));
                Log.e("MMM", "book name is " + name);
                Log.e("MMM", "book author is " + author);
                Log.e("MMM", "book pages is " + pages);
                Log.e("MMM", "book price is " + price);
                Log.i("MMM", "-------------------------------------");
            }while (cursor.moveToNext());
        }
        cursor.close();
    }

    public void updateData(View view) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("price",10.99);
        mSqd.update("Book",contentValues,"name = ?",
                new String[]{"The Da Vinci Code"});
    }

    public void addData2(View view) {

    }

    /**进程内
     * @param view
     */
    public void process1(View view) {
        /**
         * 对user表进行操作
         */

        // 设置URI
        Uri uri_user = Uri.parse("content://com.kiwilss.lxkj.myprovider/user");

        // 插入表中数据
        ContentValues values = new ContentValues();
        values.put("_id", 3);
        values.put("name", "Iverson");


        // 获取ContentResolver
        ContentResolver resolver =  getContentResolver();
        // 通过ContentResolver 根据URI 向ContentProvider中插入数据
        resolver.insert(uri_user,values);

        // 通过ContentResolver 向ContentProvider中查询数据
        Cursor cursor = resolver.query(uri_user, new String[]{"_id","name"}, null, null, null);
        while (cursor.moveToNext()){
            Log.e("MMM", "process1: " + cursor.getInt(0) +" "+ cursor.getString(1));
            //System.out.println("query book:" + cursor.getInt(0) +" "+ cursor.getString(1));
            // 将表中数据全部输出
        }
        cursor.close();
        // 关闭游标

//        /**
//         * 对job表进行操作
//         */
//        // 和上述类似,只是URI需要更改,从而匹配不同的URI CODE,从而找到不同的数据资源
//        Uri uri_job = Uri.parse("content://cn.scu.myprovider/job");
//
//        // 插入表中数据
//        ContentValues values2 = new ContentValues();
//        values2.put("_id", 3);
//        values2.put("job", "NBA Player");
//
//        // 获取ContentResolver
//        ContentResolver resolver2 =  getContentResolver();
//        // 通过ContentResolver 根据URI 向ContentProvider中插入数据
//        resolver2.insert(uri_job,values2);
//
//        // 通过ContentResolver 向ContentProvider中查询数据
//        Cursor cursor2 = resolver2.query(uri_job, new String[]{"_id","job"}, null, null, null);
//        while (cursor2.moveToNext()){
//            Log.e("MMM", "process1: " + cursor2.getInt(0) +" "+ cursor2.getString(1));
//            System.out.println("query job:" + cursor2.getInt(0) +" "+ cursor2.getString(1));
//            // 将表中数据全部输出
//        }
//        cursor2.close();
//        // 关闭游标

    }
}
