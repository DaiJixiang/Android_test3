package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WelActivity extends AppCompatActivity {

    private TextView wel_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel);
        wel_name=(TextView)findViewById(R.id.wel_name);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String userName = bundle.getString("userName");
        wel_name.setText(userName);
    }
}
