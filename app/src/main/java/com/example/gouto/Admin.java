package com.example.gouto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_admin);


    }


    public void Map(View view){

        Intent intent=new Intent(Admin.this,Home.class);

        startActivity(intent);

    }
    public void Comptes(View view){

        Intent intent=new Intent(Admin.this,List.class);

        startActivity(intent);

    }
}