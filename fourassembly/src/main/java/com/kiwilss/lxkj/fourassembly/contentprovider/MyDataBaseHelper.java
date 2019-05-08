package com.kiwilss.lxkj.fourassembly.contentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * @author : Lss kiwilss
 * @FileName: MyDataBaseHelper
 * @e-mail : kiwilss@163.com
 * @time : 2019-05-07
 * @desc : {DESCRIPTION}
 */
public class MyDataBaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_BOOK = "create table book ("
            + "id integer primary key autoincrement,"
            + "author text,"
            + "price real,"
            + "pages integer,"
            + "name text)";

    private Context mContext;


    public MyDataBaseHelper( @Nullable Context context,  @Nullable String name,
                             @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建数据库
        db.execSQL(CREATE_BOOK);
        Toast.makeText(mContext, "create success four", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
