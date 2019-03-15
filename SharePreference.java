package com.example.sharepreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText user,password;
    private Button addbtn,displaybtn;
    private TextView diplaytext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=findViewById(R.id.useredittext);
        password=findViewById(R.id.passwordedittext);
        addbtn=findViewById(R.id.addbuttonid);
       displaybtn=findViewById(R.id.diplaybuttonid);
        diplaytext=findViewById(R.id.displaytextid);
    }
    public void add(View v)
    {
        SharedPreferences sharedpref=getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedpref.edit();
        editor.putString("username",user.getText().toString());
        editor.putString("password",password.getText().toString());
        editor.apply();
        Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show();
    }
    public void display(View v)
    {
        SharedPreferences sharedPreferences=getSharedPreferences("userinfo",Context.MODE_PRIVATE);
        String name=sharedPreferences.getString("username"," ");
        String pass=sharedPreferences.getString("password"," ");
        Toast.makeText(this,"Display",Toast.LENGTH_LONG).show();
        diplaytext.setText(name+" "+pass);
    }
}
