package com.example.gouto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class Home extends AppCompatActivity {
    TextInputLayout e;
    String vl;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Forage");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();


        setContentView(R.layout.activity_home);

        e = findViewById(R.id.edit);




    }

    public void map(View view){

        Intent intent=new Intent(Home.this,MapsActivity.class);

        startActivity(intent);

    }

    public void Add(View view){

        Intent intent=new Intent(Home.this, Add.class);

        startActivity(intent);

    }
    public void UP(View view){

        Intent intent=new Intent(Home.this,who.class);

        startActivity(intent);

    }
    public void Search(View view){

        Intent intent=new Intent(Home.this,who.class);

        startActivity(intent);

    }


    public void openBottomSheet2(View v) {
        View sheet = findViewById(R.id.bottom_sheet2);
        BottomSheetBehavior.from(sheet).setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    public void go(View view){


        String val = e.getEditText().getText().toString();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dsp: snapshot.getChildren()) {


                    Map<String, Object> datas = (Map<String, Object>) dsp.getValue();
                    if(val.equals(datas.get("code").toString())) {
                        String d = datas.get("code").toString();

                        String x = datas.get("x").toString();
                        String y = datas.get("y").toString();

                        String exp = datas.get("exp_rec").toString();
                        String pos = datas.get("pos_neg").toString();
                        String prov = datas.get("province").toString();
                        String com = datas.get("commune").toString();
                        String deb = datas.get("debit").toString();
                        String prof = datas.get("profendeur").toString();
                        String date = datas.get("date_Realisation").toString();
                        String key =dsp.getKey();

                        Intent intent = new Intent(Home.this,modif.class);
                        intent.putExtra("code", d);
                        intent.putExtra("x", x);
                        intent.putExtra("y", y);
                        intent.putExtra("pos_neg", pos);
                        intent.putExtra("province", prov);
                        intent.putExtra("commune",com);
                        intent.putExtra("debit", deb);
                        intent.putExtra("exp_rec", exp);
                        intent.putExtra("profendeur", prof);
                        intent.putExtra("date", date);
                        intent.putExtra("key", key);
                        startActivity(intent);
                        finish();

                        return;



                    }

                }
                Toast.makeText(Home.this,"N°IRE invalide", Toast.LENGTH_LONG).show();

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });


    }



}