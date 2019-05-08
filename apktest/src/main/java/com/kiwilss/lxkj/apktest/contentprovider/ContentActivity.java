package com.kiwilss.lxkj.apktest.contentprovider;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.kiwilss.lxkj.apktest.R;

/**
 * @author : Lss kiwilss
 * @FileName: ContentActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019-05-08
 * @desc : {DESCRIPTION}  contentProvider 应用内通信，增删改查等
 */
public class ContentActivity extends AppCompatActivity {

    private String newId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);


    }

    public void addListener(View view) {
        // 添加数据
        Uri uri = Uri.parse("content://com.example.databasetest.provider/book");
        ContentValues values = new ContentValues();
        values.put("name", "A Clash of Kings");
        values.put("author", "George Martin");
        values.put("pages", 1040);
        values.put("price", 22.85);
        Uri newUri = getContentResolver().insert(uri, values);
        newId = newUri.getPathSegments().get(1);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void query(View view) {
// 查询数据
        Uri uri = Uri.parse("content://com.example.databasetest.provider/book");
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.
                        getColumnIndex("name"));
                String author = cursor.getString(cursor.
                        getColumnIndex("author"));

                int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                //289
                //第一行代码——Android
                double price = cursor.getDouble(cursor.
                        getColumnIndex("price"));
                Log.i("MMM", "book name is " + name);
                Log.i("MMM", "book author is " + author);
                Log.i("MMM", "book pages is " + pages);
                Log.i("MMM", "book price is " + price);
            }
            cursor.close();

        }
    }

    public void update(View view) {
        // 更新数据
        Uri uri = Uri.parse("content://com.example.databasetest.provider/book/" + newId);
                ContentValues values = new ContentValues();
        values.put("name", "A Storm of Swords");
        values.put("pages", 1216);
        values.put("price", 24.05);
        getContentResolver().update(uri, values, null, null);
    }

    public void delete(View view) {
        // 删除数据
        Uri uri = Uri.parse("content://com.example.databasetest.provider/book/" + newId);
        getContentResolver().delete(uri, null, null);
    }
}
