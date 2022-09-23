package com.example.loginform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class User_Login extends AppCompatActivity {

    EditText name,pwd;
    Button login,signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name=(EditText) findViewById(R.id.editName);
        pwd=(EditText) findViewById(R.id.editPassword);
        login=(Button)findViewById(R.id.login);
        signup=(Button) findViewById(R.id.signup);
        // When you click login button,gets toast msg and it will open home pg
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(User_Login.this,"Logged in successfully!",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(User_Login.this, Home.class);
                startActivity(intent);
            }
        });
        // If the user don't have account, click on signup button -> it will open signup pg
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=name.getText().toString().trim();
                String pswd=pwd.getText().toString().trim();
                Intent intent=new Intent(User_Login.this, Registration.class);
                intent.putExtra("Name",uname);
                intent.putExtra("password",pswd);
                startActivity(intent);
            }
        });
    }
}
