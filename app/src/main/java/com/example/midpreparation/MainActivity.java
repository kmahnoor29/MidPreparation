package com.example.midpreparation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
String Username ,Password , Email,SQLiteDataBaseQueryHolder;;
    EditText username , email ,password;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  username = findViewById(R.id.username);
  email = findViewById(R.id.email);
  password = findViewById(R.id.password);

        Button regiser = findViewById(R.id.register);

        regiser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Username = username.getText().toString();
Password = password.getText().toString();
Email = email.getText().toString();
                Save_Data();
                SQLiteDataBaseBuild();

                SQLiteDataBaseInsert();

                Toast.makeText(getApplicationContext(),"Logged"+"\n"+"Username:"+
                                Username+"\n"+ "Password:"+
                        Password, Toast.LENGTH_LONG
                        ).show();


                Intent intent = new Intent(MainActivity.this,Login.class);

                intent.putExtra("username",Username);
                intent.putExtra("password",Password);

                startActivity(intent);


            }
        });




    }

    public void Save_Data() {

        SharedPreferences sharedpreferences = getSharedPreferences("MYPREFS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("Name", username.getText().toString());
        editor.putString("Email", email.getText().toString());
        editor.putString("Pass", password.getText().toString());
        editor.commit();
        Toast.makeText(MainActivity.this, "Thanks Data Saved", Toast.LENGTH_LONG).show();
    }

public void SQLiteDataBaseBuild(){
        sqLiteDatabase = openOrCreateDatabase("RegisterDB", Context.MODE_PRIVATE,null);
   sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS USERS(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, username VARCHAR, email VARCHAR, password VARCHAR);");

    }

    public void SQLiteDataBaseInsert(){
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        Username = username.getText().toString();
        Password = password.getText().toString();
        Email = email.getText().toString();

        SQLiteDataBaseQueryHolder = "INSERT INTO USERS (username,email,password) VALUES('"+Username+"', '"+Email+"','"+Password+"');";

        sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);


    }

}
