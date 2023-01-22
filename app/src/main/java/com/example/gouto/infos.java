package com.example.gouto;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class infos extends AppCompatActivity {
    String x1,date,date2;
    public TextView X,Y,code,Debit,Profendeur,Province1,Commune1,Date,Pos_neg,ex_rec,g2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos);

        X = findViewById(R.id.X);
        Y = findViewById(R.id.Y);
        code = findViewById(R.id.code);
        Pos_neg = findViewById(R.id.p_n);
        Profendeur = findViewById(R.id.prof);
        ex_rec =findViewById(R.id.ex);
        Commune1 = findViewById(R.id.com);
        Province1 = findViewById(R.id.prov);
        Date = findViewById(R.id.da);
        Debit=findViewById(R.id.debit);
        g2 =findViewById(R.id.g2);

        Intent intent = getIntent();



        if (intent.hasExtra("date")){
            String va = intent.getStringExtra("date");
            date2=va;

        }
        else{
            date2="";
        }


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Forage");




        Query checkUser = myRef.orderByChild("date_Realisation").equalTo(date2);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){




                    String x = snapshot.child(date2).child("x").getValue(String.class);
                    String y = snapshot.child(date2).child("y").getValue(String.class);
                    String code2 = snapshot.child(date2).child("code").getValue(String.class);
                    String pos = snapshot.child(date2).child("pos_neg").getValue(String.class);
                    String ex = snapshot.child(date2).child("exp_rec").getValue(String.class);
                    String prof= snapshot.child(date2).child("profendeur").getValue(String.class);
                    String deb= snapshot.child(date2).child("debit").getValue(String.class);
                    String pro = snapshot.child(date2).child("province").getValue(String.class);
                    String com = snapshot.child(date2).child("commune").getValue(String.class);

                    X.setText(x);
                    Y.setText(y);
                    code.setText(code2);
                    Pos_neg.setText(pos);
                    Profendeur.setText(prof);
                    Province1.setText(pro);
                    Commune1.setText(com);
                    Debit.setText(deb);
                    ex_rec.setText(ex);
                    Date.setText(date2);


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });




//       myRef.orderByChild("x").equalTo(x1).addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
//                date=dataSnapshot.getKey();
//
//            }
//
//           @Override
//           public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//           }
//
//           @Override
//           public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//           }
//
//           @Override
//           public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//           }
//
//           @Override
//           public void onCancelled(@NonNull DatabaseError error) {
//
//           }
//
//
//        });

//                myRef.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        {
////
//                            for (DataSnapshot dsp: snapshot.getChildren()){
//
//                                Map<String, Object> datas = (Map<String, Object>) dsp.getValue();
//                                String x = datas.get("x").toString();
//                                if(x.equals(x1)){
//
//                                    String y = datas.get("y").toString();
//                                    String codedb = datas.get("code").toString();
//                                    String exp = datas.get("exp_rec").toString();
//                                    String pos = datas.get("pos_neg").toString();
//                                    String prov = datas.get("province").toString();
//                                    String com = datas.get("commune").toString();
//                                    String deb = datas.get("debit").toString();
//                                    String prof = datas.get("profendeur").toString();
//                                    String date = datas.get("date_Realisation").toString();
//
//                                    X.setText(x);
//                                    Y.setText(y);
//                                    code.setText(codedb);
//                                    Pos_neg.setText(pos);
//                                    Profendeur.setText(prof);
//                                    Province1.setText(prov);
//                                    Commune1.setText(com);
//                                    Debit.setText(deb);
//                                    ex_rec.setText(exp);
//                                    Date.setText(date);
//
//
//                                }
//                            }
//
//                        }
//                    }
//
//
//                    @Override
//                    public void onCancelled (@NonNull DatabaseError error){
//
//                    }
//
//
//                });

    }
}