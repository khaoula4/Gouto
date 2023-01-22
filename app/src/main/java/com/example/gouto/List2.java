package com.example.gouto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class List2 extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    Adab2 myAdapter;
    String x1;
    FloatingActionButton fab;
    ArrayList<Forage> list = new ArrayList<Forage>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_list2);

        Intent intent = getIntent();

        if (intent.hasExtra("x")){
            String va = intent.getStringExtra("x");
            x1=va;

        }
        else{
            x1="";
        }

        fab= findViewById(R.id.fab);
        recyclerView = findViewById(R.id.forageList);
        database = FirebaseDatabase.getInstance().getReference("Forage");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new Adab2(this,list);
        recyclerView.setAdapter(myAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){


                    Forage forage = dataSnapshot.getValue(Forage.class);
                    forage.setKey(dataSnapshot.getKey());
                   // String b=dataSnapshot.child("x").getValue(String.class);

                    if("36.000002".equals(x1)){
                        Toast.makeText(List2.this, x1, Toast.LENGTH_SHORT).show();
                        list.add(forage);
                    }
//                  list.add(forage);


                }
                myAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
    public void AddC(View view){

        Intent intent=new Intent(List2.this,who.class);

        startActivity(intent);
        finish();

    }
}