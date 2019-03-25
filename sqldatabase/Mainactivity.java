package com.example.sql;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;

import android.view.View;

import android.view.Menu;

import android.view.MenuItem;

import android.widget.EditText;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText myInput;

    TextView myText;

    MyDBHandler dbHandler;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        myInput = (EditText) findViewById(R.id.myInput);

        myText = (TextView) findViewById(R.id.myText);

        dbHandler =new MyDBHandler(this,null,null,1);

        printDatabase();

    }

    public void printDatabase(){

        String dbSting= dbHandler.databasetostring();

        myText.setText(dbSting);

        myInput.setText("");

    }

    public void addButtonClick(View view)

    {

        products products = new products(myInput.getText().toString());

        dbHandler.addProduct(products);

        printDatabase();

    }

    public void deleteButtonClick(View view)

    {

        String inputText= myInput.getText().toString();

        dbHandler.deleteProduct(inputText);

        printDatabase();

    }

}