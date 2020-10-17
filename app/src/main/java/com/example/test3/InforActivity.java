package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class InforActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor);

        String userName = "";
        String password = "";
        String name = "";
        String age = "";
        String birthday = "";
        String phoneNumber = "";

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            userName = bundle.getString("userName");
            password = bundle.getString("password");
            name = bundle.getString("name");
            age = bundle.getString("age");
            birthday = bundle.getString("birthday");
            phoneNumber = bundle.getString("phoneNumber");
        }

    }
}
