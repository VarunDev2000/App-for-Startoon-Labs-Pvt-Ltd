package com.dev.startoonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    FirebaseAuth fAuth;
    TextInputLayout phoneNumber;
    ImageButton next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        phoneNumber = findViewById(R.id.phonenumber);
        next = findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!phoneNumber.getEditText().getText().toString().isEmpty() && phoneNumber.getEditText().getText().toString().length() == 10){
                    String phoneNum = "+91" + phoneNumber.getEditText().getText().toString();
                    Log.d("TAG", "onClick: Phone NO -> " + phoneNum);

                    Intent intent = new Intent(getApplicationContext(),VerifyPhoneNo.class);
                    intent.putExtra("phoneNo",phoneNum);
                    startActivity(intent);
                }

                else{
                    phoneNumber.setError("Phone number is not valid");
                }
            }
        });
    }
}
