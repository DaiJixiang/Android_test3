package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InforActivity extends AppCompatActivity {

    DBHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;


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
                    dbHelper = new DBHelper(InforActivity.this);
                    sqLiteDatabase = dbHelper.getWritableDatabase();

                    ContentValues values = new ContentValues();
                    values.put("userName",finalUserName);
                    values.put("password",finalPassword);
                    values.put("name",finalName);
                    values.put("age",finalAge);
                    values.put("birthday",finalBirthday);
                    values.put("phoneNumber",finalPhoneNumber);
                    sqLiteDatabase.insert("userInfo",null,values);

                    Cursor cursor = sqLiteDatabase.query("userInfo", new String[]{"userName",
                            "password", "name", "age", "birthday", "phoneNumber"}, null, null,
                            null, null, null);
                    int count = 0;
                    while (cursor.moveToNext()) {
                        System.out.println(++count);
                        System.out.println("userName="+cursor.getString(2));
                        System.out.println("password="+cursor.getString(3));
                        System.out.println();
                    }
                    cursor.close();

                    Intent intent2 = new Intent(InforActivity.this,MainActivity.class);
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("userName",finalUserName);
                    intent2.putExtras(bundle1);
                    startActivity(intent2);
                }
            });



    }
}
