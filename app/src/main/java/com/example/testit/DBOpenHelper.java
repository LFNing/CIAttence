package com.example.testit;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBOpenHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;//AndroidSDK自带的数据度变量

    public DBOpenHelper(Context context){//context:上下文，类所在包的路径
        super(context,"db_test",null,1);
        db = getReadableDatabase();//可写入状态
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS user("+
                "_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "name TEXT,"+
                "password TEXT,"+
                "state TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }

    //增删改查方法
    public void add(String name,String password,String state){
        db.execSQL("INSERT INTO user(name,password,state) VALUES(?,?,?)",new Object[]{name,password,state});
    }
    public void delete(String name,String password){
        db.execSQL("DELETE FROM user WHERE name = AND password ="+name+password);
    }
    public void update(String name,String state){
        db.execSQL("UPDATE user SET state = ? WHERE name ="+name,new Object[]{state});
    }

    //查询表user的全部内容。使用游标Cursor
    public ArrayList<User>getAllData(){
        ArrayList<User> list = new ArrayList<User>();
        Cursor cursor = db.query("user",null,null,null,null,null,"name DESC");
        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            String state = cursor.getString(cursor.getColumnIndex("state"));
            list.add(new User(name,password,state));
        }
        return list;
    }
}









