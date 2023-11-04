package com.example.test007;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class Spinner extends AppCompatActivity {
    /*
    private Spinner spinn;
    private String arruser[],arrpass[];
    private SQLiteDatabase db;
    DataHandler dbb;
    Context context;
    DataHandler dataHandler = new DataHandler(this);
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        context = this;
        dbb=new DataHandler(context);
             spinn = findViewById(R.id.spinnerX);

        //spinn.setOnItemSelectedListener(this);
        db= openOrCreateDatabase("WJcon",SQLiteDatabase.CREATE_IF_NECESSARY,null);
        Cursor c = db.rawQuery("select * from admins",null);
        arruser=new String[c.getCount()];
        arrpass=new String[c.getCount()];
        c.moveToFirst();
        for (int i=0;i < arruser.length ;i++){
            arruser[i]=c.getString(0);
            arrpass[i]=c.getString(1);
            c.moveToNext();
        }
        ArrayAdapter<String> adp=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arruser);
       //spinn.setAdapter(adp);


    }*/
}