package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        Bundle bundle1 = getIntent().getExtras();
        if (bundle1!=null){
            EditText et_userNamea = this.findViewById(R.id.et_reg_userName);
            EditText et_password1a = this.findViewById(R.id.et_reg_password1);
            EditText et_password2a = this.findViewById(R.id.et_reg_password2);
            EditText et_namea = this.findViewById(R.id.et_reg_name);
            EditText et_agea = this.findViewById(R.id.et_reg_age);
            EditText et_birthdaya = this.findViewById(R.id.et_reg_birthday);
            EditText et_phoneNumbera = this.findViewById(R.id.et_reg_phoneNumber);
            et_userNamea.setText(bundle1.getString("userName"));
            et_password1a.setText(bundle1.getString("password"));
            et_password2a.setText(bundle1.getString("password"));
            et_namea.setText(bundle1.getString("name"));
            et_agea.setText(bundle1.getString("age"));
            et_birthdaya.setText(bundle1.getString("birth"));
            et_phoneNumbera.setText(bundle1.getString("phoneNumber"));
        }

        Button bt_commit = this.findViewById(R.id.bt_commit);

        final EditText et_userName = this.findViewById(R.id.et_reg_userName);
        final EditText et_password1 = this.findViewById(R.id.et_reg_password1);
        final EditText et_password2 = this.findViewById(R.id.et_reg_password2);
        final EditText et_name = this.findViewById(R.id.et_reg_name);
        final EditText et_age = this.findViewById(R.id.et_reg_age);
        final EditText et_birthday = this.findViewById(R.id.et_reg_birthday);
        final EditText et_phoneNumber = this.findViewById(R.id.et_reg_phoneNumber);

        bt_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = et_userName.getText().toString();
                String password1 = et_password1.getText().toString();
                String password2 = et_password2.getText().toString();
                String name = et_name.getText().toString();
                String age = et_age.getText().toString();
                String birthday = et_birthday.getText().toString();
                String phoneNumber = et_phoneNumber.getText().toString();

                if (userName.equals("")) {
                    Toast.makeText(RegActivity.this,"用户名不能为空",Toast.LENGTH_LONG).show();
                } else if (password1.equals("")||password2.equals("")) {
                    Toast.makeText(RegActivity.this,"密码不能为空",Toast.LENGTH_LONG).show();
                } else if (name.equals("")) {
                    Toast.makeText(RegActivity.this,"姓名不能为空",Toast.LENGTH_LONG).show();
                } else if (age.equals("")) {
                    Toast.makeText(RegActivity.this,"年龄不能为空",Toast.LENGTH_LONG).show();
                } else if (birthday.equals("")) {
                    Toast.makeText(RegActivity.this,"生日不能为空",Toast.LENGTH_LONG).show();
                } else if (phoneNumber.equals("")) {
                    Toast.makeText(RegActivity.this,"手机不能为空",Toast.LENGTH_LONG).show();
                }else if (!password1.equals(password2)){
                    Toast.makeText(RegActivity.this,"两次输入的密码不一致，请重新输入！",Toast.LENGTH_LONG).show();
                    et_password1.setText("");
                    et_password2.setText("");
                }else {
                    Toast.makeText(RegActivity.this,"正在跳转到确认页面......",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegActivity.this, InforActivity.class);
                    Bundle bundle = new Bundle();
                    //System.out.println("userName = "+userName);
                    bundle.putString("userName",userName);
                    bundle.putString("password",password1);
                    bundle.putString("name",name);
                    bundle.putString("age",age);
                    bundle.putString("birthday",birthday);
                    bundle.putString("phoneNumber",phoneNumber);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
}
