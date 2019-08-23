package com.example.testit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private DBOpenHelper mDBOpenHelper;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin= this.<Button>findViewById(R.id.btn_Login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginActivity.this.onClick(view);
            }
        });
        mDBOpenHelper = new DBOpenHelper(this);
    }

    public void onClick(View view){
        EditText editTextName = (EditText)findViewById(R.id.editText);
        String name = editTextName.getText().toString().trim();
        EditText editTextPassword = (EditText)findViewById(R.id.editText2);
        String password = editTextPassword.getText().toString().trim();
        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)){//判断用户名密码是否为空
            ArrayList<User> data = mDBOpenHelper.getAllData();
            User user = new User();
            boolean match = false;
            for(int i = 0;i<data.size();i++){
                user = data.get(i);
                if(name.equals(user.getName()) && password.equals(user.getPassword())){
                    match = true;
                    break;
                }else{
                    match = false;
                }
            }

            if(match){
                Toast.makeText(this,"登陆成功",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,UserActivity.class);
                intent.putExtra("UserInfo",user);
                startActivity(intent);
                finish();//销毁此Activity
            }else{
                Toast.makeText(this,"用户名或密码不正确，请重新输入",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
