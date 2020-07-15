package com.dev.startoonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.threeten.bp.LocalDate;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import org.threeten.bp.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Thankyou_page extends AppCompatActivity {

    ImageButton X;
    TextView Date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou_page);

        X = findViewById(R.id.ty_close);
        Date = findViewById(R.id.date);

        //Date Print
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("hh:mm aa, dd MMM yyyy", Locale.getDefault());
        String formattedDate = df.format(c);
        //Log.d("DATE", "Date -> " + formattedDate);
        Date.setText(formattedDate);



        X.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),HomePage.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}
