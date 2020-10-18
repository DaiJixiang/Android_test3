package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText et_userName = this.findViewById(R.id.et_main_userName);
        final EditText et_password = this.findViewById(R.id.et_main_password);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String userName = bundle.getString("userName");
            System.out.println(userName);
            et_userName.setText(userName);
        }else {
            System.out.println("bundle is null");
        }



        //点击注册按钮跳转到注册页面
        Button main_reg = this.findViewById(R.id.bt_main_reg);
        main_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_reg = new Intent(MainActivity.this, RegActivity.class);
                startActivity(intent_reg);
            }
        });


        //登录
        Button bt_login = this.findViewById(R.id.bt_main_login);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = et_userName.getText().toString();
                String password = et_password.getText().toString();
                if (userName.equals("")){
                    Toast.makeText(MainActivity.this, "用户名不能为空", Toast.LENGTH_LONG).show();
                } else if (password.equals("")) {
                    Toast.makeText(MainActivity.this, "密码不能为空", Toast.LENGTH_LONG).show();
                }else {
                    dbHelper = new DBHelper(MainActivity.this);
                    sqLiteDatabase = dbHelper.getReadableDatabase();
                    Cursor cursor =
                            sqLiteDatabase.rawQuery("select * from userInfo where userName='" + userName + "' and password='" + password+"'", null);
                    if (cursor != null && cursor.getCount() > 0) {
                        Intent intent1 = new Intent(MainActivity.this, WelActivity.class);
                        Bundle bundle1 = new Bundle();
                        bundle1.putString("userName",userName);
                        intent1.putExtras(bundle1);
                        startActivity(intent1);
                    }else {
                        Toast.makeText(MainActivity.this, "用户名或密码错误，请重新输入！", Toast.LENGTH_LONG).show();
                        et_password.setText("");
                    }
                    cursor.close();
                }

            }
        });


        //忘记密码
        TextView tv_forget_password = this.findViewById(R.id.tv_forget_password);
        tv_forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = et_userName.getText().toString();
                if (userName.equals("")) {
                    Toast.makeText(MainActivity.this, "用户名不能为空", Toast.LENGTH_LONG).show();
                }else {
                    dbHelper = new DBHelper(MainActivity.this);
                    sqLiteDatabase = dbHelper.getReadableDatabase();
                    Cursor cursor = sqLiteDatabase.rawQuery("select * from userInfo where " +
                            "userName='" + userName+"'", null);
                    if (cursor != null && cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        String password = cursor.getString(2);
                        et_password.setText(password);
                    }else {
                        Toast.makeText(MainActivity.this, "用户不存在，请先注册！", Toast.LENGTH_LONG).show();
                    }
                    cursor.close();
                }
            }
        });

    }


}
