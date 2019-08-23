package com.example.testit;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SIOpenHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;

    public SIOpenHelper(Context context){//context:上下文，类所在包的路径
        super(context,"db_test",null,1);
        db = getReadableDatabase();//可写入状态
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS signTime("+
                "_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "name TEXT,"+
                "startTime TEXT,"+
                "endTime TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("DROP TABLE IF EXISTS signTime");
        onCreate(db);
    }

    //增删改功能实现
    public void add(String name,String startTime,String endTime){
        db.execSQL("INSERT INTO signTime(name,startTime,endTime) VALUES(?,?,?)",new Object[]{name,startTime,endTime});
    }
    public void delete(String name){
        db.execSQL("DELETE FROM signTime WHERE name ="+name);
    }
    public void update(String name,String startTime,String endTime){
        if(endTime==""){
            db.execSQL("UPDATE signTime SET startTime = ? WHERE name = "+name,new Object[]{startTime});
        }else if(startTime == ""){
            db.execSQL("UPDATE signTime SET endTime = ? WHERE name = "+name,new Object[]{endTime});
        }
    }

    //查询表signTime的全部内容。使用游标Cursor
    public ArrayList<User> getAllData(){
        ArrayList<User> list = new ArrayList<User>();
        Cursor cursor = db.query("signTime",null,null,null,null,null,"name DESC");
        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String startTime = cursor.getString(cursor.getColumnIndex("startTime"));
            String endTime = cursor.getString(cursor.getColumnIndex("endTime"));
            User user = new User(name);
            user.setStartTime(startTime);
            user.setEndTime(endTime);
            list.add(user);
        }
        return list;
    }

}
