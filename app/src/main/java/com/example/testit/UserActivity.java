package com.example.testit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserActivity extends AppCompatActivity {

    private User user = new User();
    private SIOpenHelper mSIOpenHelper;
    private DBOpenHelper mDBOenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        user = (User)getIntent().getExtras().get("UserInfo");

    }

    public void onClickSignIn(View view){
        //更改签到时间和状态
        Date date = new Date();
        String startTime = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(date);
        user.setStartTime(startTime);
        user.setState("True");
        mDBOenHelper.update(user.getName(),user.getState());
        mSIOpenHelper.update(user.getName(),startTime,"");
    }

    public void onClickSignOut(View view){
        //更改退签时间和状态
        Date date = new Date();
        String endTime = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(date);
        user.setEndTime(endTime);
        user.setState("False");
        mDBOenHelper.update(user.getName(),user.getState());
        mSIOpenHelper.update(user.getName(),"",endTime);
    }
}
