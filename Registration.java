package com.example.loginform;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar; //import Calendar class for DatePicker

public class Registration extends AppCompatActivity {

    Button btn1;
    EditText dob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btn1=findViewById(R.id.signup);
        dob= findViewById(R.id.edit_dob);
        // Date Picker -> select date rom the calendar by tapping on 'date of birth' editText field
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal=Calendar.getInstance();
                int yr=cal.get(Calendar.YEAR);
                int m=cal.get(Calendar.MONTH);
                int d=cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog=new DatePickerDialog(Registration.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dob.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, yr,m,d);
                datePickerDialog.show();
            }
        });
        // Tap signup button, then get the toast msg as 'account created successfully for a user' -> it will redirect to the login pg
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Registration.this,"Account created successfully!",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Registration.this, User_Login.class);
                startActivity(intent);
            }
        });

    }
}