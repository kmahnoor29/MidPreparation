package com.example.midpreparation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username ;
    EditText password ;
    String Username , Password, um ,pass;
    Button login;
    Intent getintent;
    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       username = findViewById(R.id.username);
        password = findViewById(R.id.password);
         login = findViewById(R.id.login);

         getintent = getIntent();
        Bundle data_bundle = getintent.getExtras();



        Username = data_bundle.getString("username");
        Password = data_bundle.getString("password");

username.setText(Username);
password.setText(Password);



       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               um =   username.getText().toString();
               pass = password.getText().toString();
if(Username.equals(um) && Password.equals(pass)){

                   Intent go = new Intent(Login.this,Welcome.class);

                   Toast.makeText(getApplicationContext(),"Logged"
                   +"Username:"+"\n"+um+
                           "Password"+"\n"
                   +pass,Toast.LENGTH_LONG).show();

    go.putExtra("username",um);
    go.putExtra("password",pass);


                   startActivity(go);


           }else{

}
           }
       });




    }



}
