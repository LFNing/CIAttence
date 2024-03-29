package com.example.testit;

import java.io.Serializable;

public class User implements Serializable {
    private String name;//用户名
    private String password;//密码
    private String state;//上班状态
    private String date;//日期
    private String startTime;//上班时间
    private String endTime;//下班时间
    private String overWorkDate;//加班时段
    private String outWordDate;//出差时段
    private String mark;//备注

    User(){}

    public User(String name){
        this.name = name;
    }

    public User(String name,String password,String state){
        this.name = name;
        this.password = password;
        this.state = state;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setStartTime(String startTime){
        this.startTime = startTime;
    }

    public void setEndTime(String endTime){
        this.endTime = endTime;
    }

    @Override
    public String toString(){
        return "User{"+
                "name='"+name+'\''+
                ",password='"+password+'\''+
                ",state='"+state+'\''+
                '}';
    }
}
