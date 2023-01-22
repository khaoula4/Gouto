package com.example.gouto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class who extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_who);


    }
    public void Admin(View view){

        Intent intent=new Intent(who.this,Login.class);

        startActivity(intent);

    }
    public void abhl(View view){

        Intent intent=new Intent(who.this,Login2.class);

        startActivity(intent);

    }
    public void visit(View view){

        Intent intent=new Intent(who.this,home3.class);

        startActivity(intent);

    }

}