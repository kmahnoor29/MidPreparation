package com.example.midpreparation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
TextView username , password;
    Intent getintent;
    String Username , Password;
    Button clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

         username = findViewById(R.id.username);
         password = findViewById(R.id.password);


        SharedPreferences sharedpreferences = getSharedPreferences("MYPREFS", Context.MODE_PRIVATE);

        Username = sharedpreferences.getString("Name", "");
        username.setText(Username);
        Password = sharedpreferences.getString("Pass", "");
        password.setText(Password);

        clear = findViewById(R.id.clear);

        //getintent = getIntent();
       // Bundle data_bundle = getintent.getExtras();



        //Username = data_bundle.getString("username");
        //Password = data_bundle.getString("password");

      //username.setText(Username);
      //password.setText(Password);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = findViewById(R.id.username);
                password = findViewById(R.id.password);
                username.setText(" ");
                password.setText(" ");
            }
        });

    }
}
