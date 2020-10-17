package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_userName = this.findViewById(R.id.et_main_userName);
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


    }


}
