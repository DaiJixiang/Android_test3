package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

        TextView textView_name=this.findViewById(R.id.infor_name);
        TextView textView_age=this.findViewById(R.id.infor_age);
        TextView textView_birth = this.findViewById(R.id.infor_birth);
        TextView textView_tel=this.findViewById(R.id.infor_tel);

        final Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        if (bundle != null) {
            userName = bundle.getString("userName");
            password = bundle.getString("password");
            name = bundle.getString("name");
            age = bundle.getString("age");
            birthday = bundle.getString("birthday");
            phoneNumber = bundle.getString("phoneNumber");

            textView_name.setText(name);
            textView_age.setText(age);
            textView_birth.setText(birthday);
            textView_tel.setText(phoneNumber);
        }
            Button infor_return=this.findViewById(R.id.infor_return);

            final String finalUserName = userName;
            final String finalPassword = password;
            final String finalName = name;
            final String finalAge = age;
            final String finalBirthday = birthday;
            final String finalPhoneNumber = phoneNumber;
            infor_return.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                Intent intent1 = new Intent(InforActivity.this,RegActivity.class);
                Bundle bundle1 = new Bundle();
                bundle.putString("userName", finalUserName);
                bundle.putString("password", finalPassword);
                bundle.putString("name", finalName);
                bundle.putString("age", finalAge);
                bundle.putString("birth", finalBirthday);
                bundle.putString("phoneNumber", finalPhoneNumber);
                intent.putExtras(bundle);
                startActivity(intent);
                }
            });
            Button infor_yes = this.findViewById(R.id.infor_yes);
            infor_yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent2 = new Intent(InforActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            });



    }
}
