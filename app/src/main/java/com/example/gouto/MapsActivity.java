package com.example.gouto;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.gouto.databinding.ActivityMapsBinding;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.gouto.databinding.ActivityMapsBinding;

import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback  {

    private GoogleMap mMap;

    String val ,val1,val2,vl,x1,date2;

    TextInputLayout Province,Commune,e_r,e;
    //EditText e;

    public TextView X,Y,code,Debit,Profendeur,Province1,Commune1,Date,Pos_neg,ex_rec,g2;

    AutoCompleteTextView A1,A2,A3;
    ArrayList<String> L1,L2,L3;
    ArrayAdapter<String> AS1,AS2,AS3;

    Marker mymarker;
    int i=0;


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Forage");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);




        Intent intent = getIntent();



        if (intent.hasExtra("nire")){
            String va = intent.getStringExtra("nire");
            vl=va;

        }
        else{
            vl="";
        }

        if (intent.hasExtra("e_r1")) {
            String valeur = intent.getStringExtra("e_r1");
            val=valeur;
            if (intent.hasExtra("commune1")) {
                String valeur1 = intent.getStringExtra("commune1");
                val1=valeur1;
                if (intent.hasExtra("province1")) {
                    String valeur2 = intent.getStringExtra("province1");
                    val2=valeur2;
                }
                else {
                    val2="";
                }
            }
            else {
                val1="";
                if (intent.hasExtra("province1")) {
                    String valeur2 = intent.getStringExtra("province1");
                    val2=valeur2;
                }
                else {
                    val2="";
                }
            }

        }
        else {
            val="";
            if (intent.hasExtra("commune1")) {
                String valeur1 = intent.getStringExtra("commune1");
                val1=valeur1;
                if (intent.hasExtra("province1")) {
                    String valeur2 = intent.getStringExtra("province1");
                    val2=valeur2;
                }
                else {
                    val2="";
                }
            }
            else {
                val1="";
                if (intent.hasExtra("province1")) {
                    String valeur2 = intent.getStringExtra("province1");
                    val2=valeur2;
                }
                else {
                    val2="";
                }
            }
        }


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
      //  g2 =findViewById(R.id.g2);


        e_r = findViewById(R.id.ex_rec1);
        Commune = findViewById(R.id.Comm);
        Province = findViewById(R.id.Prov);

        e = findViewById(R.id.edit);



        A1 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView10);
        A2 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView20);
        A3 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView30);




        L1=new ArrayList<>();
        L2=new ArrayList<>();
        L3=new ArrayList<>();



        L1.add("Exploitation");
        L1.add("Reconaissance");

        L2.add("Ain Lahsan ");
        L2.add("Al Hamra");
        L2.add("Al Kharroub");
        L2.add("Al Oued ");
        L2.add("Azla");
        L2.add("Beni Ider ");
        L2.add("Bghaghza");
        L2.add("Bni Harchen ");
        L2.add("Bni Leit");
        L2.add("Bni Said");
        L2.add("Dar Bni Karrich");
        L2.add("Jbel El Hbib");
        L2.add("Mallalienne");
        L2.add("Oued Laou ");
        L2.add("Oulad Ali Mansour");
        L2.add("Saddina ");
        L2.add("Sahtryine ");
        L2.add("Souk Kdim");
        L2.add("Tétouan");
        L2.add("Zaitoune");
        L2.add("Zaouiat Sidi Kacem ");
        L2.add("Zinat");
        L2.add("Abdelghaya Souahel ");
        L2.add("Aït Kamra ");
        L2.add("Aït Youssef Ou Ali");
        L2.add("Ajdir ");
        L2.add("Al Hoceïma ");
        L2.add("Arbaa Taourirt");
        L2.add("Bni Abdallah ");
        L2.add("Bni Ahmed Imoukzan ");
        L2.add("Bni Ammart ");
        L2.add("Bni Bchir");
        L2.add("Bni Bouayach ");
        L2.add("Bni Bouchibet ");
        L2.add("Bni Boufrah ");
        L2.add("Bni Bounsar ");
        L2.add("Bni Gmil ");
        L2.add("Bni Gmil Maksouline ");
        L2.add("Bni Hadifa");
        L2.add("Chakrane");
        L2.add("Imrabten ");
        L2.add("Imzouren ");
        L2.add("Issaguen ");
        L2.add("Izemmouren");
        L2.add("Ketama");
        L2.add("Louta");
        L2.add("Moulay Ahmed Cherif");
        L2.add("Nekkour");
        L2.add("Rouadi");
        L2.add("Sidi Boutmim ");
        L2.add("Sidi Bouzineb ");
        L2.add("Snada");
        L2.add("Taghzout ");
        L2.add("Tamsaout ");
        L2.add("Targuist");
        L2.add("Tifarouine");
        L2.add("Zaouiat Sidi Abdelkader ");
        L2.add("Zarkt");
        L2.add("Auámra");
        L2.add("Ayacha");
        L2.add("Beni Gorfet");
        L2.add("Bni Arouss");
        L2.add("Boujedyane");
        L2.add("Ksar Bjir ");
        L2.add("Ksar El Kébir");
        L2.add("Larache");
        L2.add("Oulad Ouchih");
        L2.add("Rissana Chamalia");
        L2.add("Rissana Janoubia");
        L2.add("Sahel");
        L2.add("Souaken");
        L2.add("Souk L'Qolla");
        L2.add("Souk Tolba");
        L2.add("Tatoft");
        L2.add("Tazroute");
        L2.add("Zaaroura ");
        L2.add("Zouada");
        L2.add("Ain Beida");
        L2.add("Asjen");
        L2.add("Bni Quolla");
        L2.add("Brikcha");
        L2.add("Kalaat Bouqorra");
        L2.add("Lamjaara");
        L2.add("Lamjaara");
        L2.add("Moqrisset ");
        L2.add("Mzefroune");
        L2.add("Ouezzane");
        L2.add("Ounnana");
        L2.add("Sidi Ahmed Cherif");
        L2.add("Sidi Ahmed Cherif");
        L2.add("Sidi Redouane");
        L2.add("Teroual");
        L2.add("Zghira");
        L2.add("Zoumi");
        L2.add("Amtar");
        L2.add("Bab Berred ");
        L2.add("Bab Taza");
        L2.add("Beni Ahamed Charquía ");
        L2.add("Beni Buzra ");
        L2.add("Bni Ahmed Gharbia");
        L2.add("Bni Darkoul ");
        L2.add("Bni Faghloum ");
        L2.add("Bni Mansour ");
        L2.add("Bni Rzine ");
        L2.add("Bni Salah ");
        L2.add("Bni Selmane ");
        L2.add("Bni Smih");
        L2.add("Chefchaouen");
        L2.add("Derdara");
        L2.add("Fifi");
        L2.add("Iounane");
        L2.add("Laghdir");
        L2.add("M'Tioua ");
        L2.add("Mensora");
        L2.add("Ouaouzgane");
        L2.add("Oeud Melha");
        L2.add("Steha");
        L2.add("Talambot ");
        L2.add("Tamorot ");
        L2.add("Tanacob ");
        L2.add("Tassift ");
        L2.add("Tizgane");
        L2.add("Tizgane");
        L2.add("El Bahrarín");
        L2.add("Jouamaa");
        L2.add("Ksar El Majaz");
        L2.add("Ksar Sghir");
        L2.add("Mellousa");
        L2.add("Tagramt");
        L2.add("Allyene");
        L2.add("Belyounech");
        L2.add("Fnideq");
        L2.add("M'diq ");
        L2.add("Martil");
        L2.add("Al Manzla ");
        L2.add("Aquouass Briech ");
        L2.add("Assilah");
        L2.add("Boukhalef");
        L2.add("Dar Chaoui");
        L2.add("Gueznaia");
        L2.add("Had El Gharbía");
        L2.add("Hjar Ennhal");
        L2.add("Laauama");
        L2.add("Sahel Chamali");
        L2.add("Sidi Lyamani");
        L2.add("Tanger");
        L2.add("Sebt Zinat");



        L3.add("Tanger-Asilah");
        L3.add("Tétouan");
        L3.add("Al Hoceima");
        L3.add("Larache");
        L3.add("Ouezzane");
        L3.add("Chefchaouen ");
        L3.add("M’diq-Fnideq");
        L3.add("Fahs Anjra");

        Collections.sort(L2, String.CASE_INSENSITIVE_ORDER);
        Collections.sort(L3, String.CASE_INSENSITIVE_ORDER);
        Collections.sort(L1, String.CASE_INSENSITIVE_ORDER);

        AS1=new ArrayAdapter<>(getApplicationContext(),R.layout.dropdown_item,L1);
        AS2=new ArrayAdapter<>(getApplicationContext(),R.layout.dropdown_item,L2);
        AS3=new ArrayAdapter<>(getApplicationContext(),R.layout.dropdown_item,L3);




        A1.setAdapter(AS1);
        A1.setThreshold(1);

        A2.setAdapter(AS2);
        A2.setThreshold(1);

        A3.setAdapter(AS3);
        A3.setThreshold(1);


    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        if (vl.equals("")){
            add();
        }
        else {
            add2();
        }




        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {


                LatLng position = marker.getPosition();
                DecimalFormat df = new DecimalFormat("##.######");

                 x1=String.format("%.6f",position.latitude);
                 x1=x1.replace(",",".");






                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Forage");

                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        {
//
                            for (DataSnapshot dsp: snapshot.getChildren()){

                                Map<String, Object> datas = (Map<String, Object>) dsp.getValue();
                                String x = datas.get("x").toString();
                                if(x.equals(x1)){

                                    String y = datas.get("y").toString();
                                    String codedb = datas.get("code").toString();
                                    String exp = datas.get("exp_rec").toString();
                                    String pos = datas.get("pos_neg").toString();
                                    String prov = datas.get("province").toString();
                                    String com = datas.get("commune").toString();
                                    String deb = datas.get("debit").toString();
                                    String prof = datas.get("profendeur").toString();
                                    String date = datas.get("date_Realisation").toString();

                                    X.setText(x);
                                    Y.setText(y);
                                    code.setText(codedb);
                                    Pos_neg.setText(pos);
                                    Profendeur.setText(prof);
                                    Province1.setText(prov);
                                    Commune1.setText(com);
                                    Debit.setText(deb);
                                    ex_rec.setText(exp);
                                    Date.setText(date);


                                }
                            }


                            openBottomSheet();
                        }
                    }


                    @Override
                    public void onCancelled (@NonNull DatabaseError error){

                    }


                });




                return true;
            }
        });

    }



    public void Addmarker ( LatLng latlng) {
        // mMap = googleMap;
        mymarker = mMap.addMarker(new MarkerOptions().position(latlng).icon(BitmapDescriptorFactory.fromResource(R.drawable.water)));
        // mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng,15f));
        i++;

    }
    public void Addmarker2 ( LatLng latlng) {
        // mMap = googleMap;
        mymarker = mMap.addMarker(new MarkerOptions().position(latlng).icon(BitmapDescriptorFactory.fromResource(R.drawable.red)));
        // mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng,15f));
        i++;

    }


    private void add2(){
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dsp: snapshot.getChildren()) {


                    Map<String, Object> datas = (Map<String, Object>) dsp.getValue();
                    if(vl.equals(datas.get("code").toString())) {
                        String x = datas.get("x").toString();
                        String y = datas.get("y").toString();

                        String p = datas.get("pos_neg").toString();


                        if (p.equals("Positif")) {
                            Addmarker(new LatLng(Double.valueOf(x), Double.valueOf(y)));
                        } else {
                            Addmarker2(new LatLng(Double.valueOf(x), Double.valueOf(y)));
                        }
                    }
                }

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }




    private void add( ) {

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {



                if (val.equals("")){
                    if(val1.equals("")){
                        if(val2.equals("")){
                            for (DataSnapshot dsp: snapshot.getChildren()) {
                                Map<String, Object> datas = (Map<String, Object>) dsp.getValue();
                                String x = datas.get("x").toString();
                                String y = datas.get("y").toString();

                                //  Forage forage = dsp.getValue(Forage.class);
                                //    String x = forage.getX();
                                //    String y = forage.getY();
                                String p = datas.get("pos_neg").toString();


                                if(p.equals("Positif")){
                                    Addmarker(new LatLng(Double.valueOf(x),Double.valueOf(y)));
                                }
                                else{
                                    Addmarker2(new LatLng(Double.valueOf(x),Double.valueOf(y)));
                                }




                            }

                        }
                        else{
                            for (DataSnapshot dsp: snapshot.getChildren()) {
                                Map<String, Object> datas = (Map<String, Object>) dsp.getValue();
                                if(val2.equals(datas.get("province").toString())){
                                    String x = datas.get("x").toString();
                                    String y = datas.get("y").toString();

                                    //  Forage forage = dsp.getValue(Forage.class);
                                    //    String x = forage.getX();
                                    //    String y = forage.getY();
                                    String p = datas.get("pos_neg").toString();


                                    if(p.equals("Positif")){
                                        Addmarker(new LatLng(Double.valueOf(x),Double.valueOf(y)));
                                    }
                                    else{
                                        Addmarker2(new LatLng(Double.valueOf(x),Double.valueOf(y)));
                                    }
                                }

                            }
                        }
                    }
                    else{


                        if(val2.equals("")){
                            for (DataSnapshot dsp: snapshot.getChildren()) {
                                Map<String, Object> datas = (Map<String, Object>) dsp.getValue();
                                if(val1.equals(datas.get("commune").toString())){
                                    String x = datas.get("x").toString();
                                    String y = datas.get("y").toString();

                                    //  Forage forage = dsp.getValue(Forage.class);
                                    //    String x = forage.getX();
                                    //    String y = forage.getY();
                                    String p = datas.get("pos_neg").toString();


                                    if(p.equals("Positif")){
                                        Addmarker(new LatLng(Double.valueOf(x),Double.valueOf(y)));
                                    }
                                    else{
                                        Addmarker2(new LatLng(Double.valueOf(x),Double.valueOf(y)));
                                    }
                                }
                            }

                        }
                        else{
                            for (DataSnapshot dsp: snapshot.getChildren()) {
                                Map<String, Object> datas = (Map<String, Object>) dsp.getValue();
                                if(val2.equals(datas.get("province").toString())&&val1.equals(datas.get("commune").toString())){
                                    String x = datas.get("x").toString();
                                    String y = datas.get("y").toString();

                                    //  Forage forage = dsp.getValue(Forage.class);
                                    //    String x = forage.getX();
                                    //    String y = forage.getY();
                                    String p = datas.get("pos_neg").toString();


                                    if(p.equals("Positif")){
                                        Addmarker(new LatLng(Double.valueOf(x),Double.valueOf(y)));
                                    }
                                    else{
                                        Addmarker2(new LatLng(Double.valueOf(x),Double.valueOf(y)));
                                    }
                                }

                            }
                        }
                    }

                }
                else{
                    if(val1.equals("")){
                        if(val2.equals("")){
                            for (DataSnapshot dsp: snapshot.getChildren()) {
                                Map<String, Object> datas = (Map<String, Object>) dsp.getValue();
                                if(val.equals(datas.get("exp_rec").toString())){
                                    String x = datas.get("x").toString();
                                    String y = datas.get("y").toString();

                                    //  Forage forage = dsp.getValue(Forage.class);
                                    //    String x = forage.getX();
                                    //    String y = forage.getY();
                                    String p = datas.get("pos_neg").toString();


                                    if(p.equals("Positif")){
                                        Addmarker(new LatLng(Double.valueOf(x),Double.valueOf(y)));
                                    }
                                    else{
                                        Addmarker2(new LatLng(Double.valueOf(x),Double.valueOf(y)));
                                    }
                                }
                            }

                        }
                        else{
                            for (DataSnapshot dsp: snapshot.getChildren()) {
                                Map<String, Object> datas = (Map<String, Object>) dsp.getValue();
                                if(val2.equals(datas.get("province").toString())&&val.equals(datas.get("exp_rec").toString())){
                                    String x = datas.get("x").toString();
                                    String y = datas.get("y").toString();

                                    //  Forage forage = dsp.getValue(Forage.class);
                                    //    String x = forage.getX();
                                    //    String y = forage.getY();
                                    String p = datas.get("pos_neg").toString();


                                    if(p.equals("Positif")){
                                        Addmarker(new LatLng(Double.valueOf(x),Double.valueOf(y)));
                                    }
                                    else{
                                        Addmarker2(new LatLng(Double.valueOf(x),Double.valueOf(y)));
                                    }
                                }

                            }
                        }
                    }
                    else{


                        if(val2.equals("")){
                            for (DataSnapshot dsp: snapshot.getChildren()) {
                                Map<String, Object> datas = (Map<String, Object>) dsp.getValue();
                                if(val1.equals(datas.get("commune").toString())&&val.equals(datas.get("exp_rec").toString())){
                                    String x = datas.get("x").toString();
                                    String y = datas.get("y").toString();
                                    String p = datas.get("pos_neg").toString();


                                    if(p.equals("Positif")){
                                        Addmarker(new LatLng(Double.valueOf(x),Double.valueOf(y)));
                                    }
                                    else{
                                        Addmarker2(new LatLng(Double.valueOf(x),Double.valueOf(y)));
                                    }
                                }
                            }

                        }
                        else{
                            for (DataSnapshot dsp: snapshot.getChildren()) {
                                Map<String, Object> datas = (Map<String, Object>) dsp.getValue();
                                if(val2.equals(datas.get("province").toString())&&val1.equals(datas.get("commune").toString())&&val.equals(datas.get("exp_rec").toString())){
                                    String x = datas.get("x").toString();
                                    String y = datas.get("y").toString();

                                    //  Forage forage = dsp.getValue(Forage.class);
                                    //    String x = forage.getX();
                                    //    String y = forage.getY();
                                    String p = datas.get("pos_neg").toString();


                                    if(p.equals("Positif")){
                                        Addmarker(new LatLng(Double.valueOf(x),Double.valueOf(y)));
                                    }
                                    else{
                                        Addmarker2(new LatLng(Double.valueOf(x),Double.valueOf(y)));
                                    }
                                }

                            }
                        }
                    }
                }

                Toast.makeText(MapsActivity.this,i+ " Résultats",Toast.LENGTH_LONG).show();


            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }


//    public void openTopSheet1() {
//        View sheet = findViewById(R.id.top_sheet);
//        TopSheetBehavior.from(sheet).setState(TopSheetBehavior.STATE_EXPANDED);
//    }

    public void openTopSheet(View v) {
        View sheet = findViewById(R.id.top_sheet);
        TopSheetBehavior.from(sheet).setState(TopSheetBehavior.STATE_EXPANDED);
    }

    public void openTopSheet2(View v) {
        View sheet = findViewById(R.id.top_sheet2);
        TopSheetBehavior.from(sheet).setState(TopSheetBehavior.STATE_EXPANDED);
    }


    public void openBottomSheet() {
        View sheet = findViewById(R.id.bottom_sheet);
        BottomSheetBehavior.from(sheet).setState(BottomSheetBehavior.STATE_EXPANDED);
  }



    public void filter (View view ){

        String val = e_r.getEditText().getText().toString();
        String val1 = Commune.getEditText().getText().toString();
        String val2 = Province.getEditText().getText().toString();
        Intent intent = new Intent(MapsActivity.this,MapsActivity.class);
        intent.putExtra("e_r1", val);
        intent.putExtra("commune1", val1);
        intent.putExtra("province1", val2);
        startActivity(intent);
        finish();
    }

    public void search(View view){
        String val = e.getEditText().getText().toString();

        Intent intent = new Intent(MapsActivity.this,MapsActivity.class);
        intent.putExtra("nire", val);
        startActivity(intent);
        finish();
    }


}