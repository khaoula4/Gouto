package com.example.gouto;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class Add extends AppCompatActivity {


    TextInputLayout X,Y,Code,Profendeur,Debit,t,e_r,Commune,Province;
    EditText dateEdt;
    Button add;


    AutoCompleteTextView A,A1,A2,A3;
    ArrayList<String> L,L1,L2,L3;
    ArrayAdapter<String> AS,AS1,AS2,AS3;

    int i=0;
    Button AddBtn;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Forage");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.add);



        X = findViewById(R.id.X);
        Y = findViewById(R.id.Y);
        Code = findViewById(R.id.code);
        Profendeur = findViewById(R.id.profendeur);
        Debit = findViewById(R.id.Debit);
        t = findViewById(R.id.Pos_neg);
        e_r = findViewById(R.id.ex_rec);
        Commune = findViewById(R.id.Commune);
        Province = findViewById(R.id.Province);
        dateEdt = findViewById(R.id.idEdtDate);

        add =findViewById(R.id.add);


        A = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        A1 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        A2 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView2);
        A3 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView3);



        L=new ArrayList<>();
        L1=new ArrayList<>();
        L2=new ArrayList<>();
        L3=new ArrayList<>();


        L.add("Positif");
        L.add("Negatif");

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
        L2.add("Bni Arouss ");
        L2.add("Boujedyane");
        L2.add("Ksar Bjir ");
        L2.add("Ksar El Kébir");
        L2.add("Larache");
        L2.add("Oulad Ouchih");
        L2.add("Rissana Chamalia");
        L2.add("Rissana Janoubia");
        L2.add("Sahel ");
        L2.add("Souaken ");
        L2.add("Souk L'Qolla ");
        L2.add("Souk Tolba");
        L2.add("Tatoft");
        L2.add("Tazroute");
        L2.add("Zaaroura ");
        L2.add("Zouada");
        L2.add("Ain Beida ");
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




        AS=new ArrayAdapter<>(getApplicationContext(),R.layout.dropdown_item,L);
        AS1=new ArrayAdapter<>(getApplicationContext(),R.layout.dropdown_item,L1);
        AS2=new ArrayAdapter<>(getApplicationContext(),R.layout.dropdown_item,L2);
        AS3=new ArrayAdapter<>(getApplicationContext(),R.layout.dropdown_item,L3);



        A.setAdapter(AS);
        A.setThreshold(1);

        A1.setAdapter(AS1);
        A1.setThreshold(1);

        A2.setAdapter(AS2);
        A2.setThreshold(1);

        A3.setAdapter(AS3);
        A3.setThreshold(1);



        dateEdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final Calendar c = Calendar.getInstance();

                // on below line we are getting
                // our day, month and year.
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // on below line we are creating a variable for date picker dialog.
                DatePickerDialog datePickerDialog = new DatePickerDialog(Add.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our edit text.
                                dateEdt.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        },
                        // on below line we are passing year,
                        // month and day for selected date in our date picker.
                        year, month, day);
                // at last we are calling show to
                // display our date picker dialog.
                datePickerDialog.show();
            }
        });



      //  i++;
      //  Forage forage2 =new Forage("22","60","hahaha","prof","debit","60","hahaha","prof","debit","fgdfd");
      //  myRef.child("Forage"+"2").setValue(forage2);




    }

    private Boolean validateX() {
        String val = X.getEditText().getText().toString();

        String pattern ="(-)?+[0-9]+\\.+\\d{6}";

        if (val.isEmpty()) {
            X.setError("Cette case ne peut pas être vide");
            return false;
        }
        else if(!val.matches(pattern)){

            X.setError("Format non valide, Essayer un nombre avec 6 chiffres après le point, eg: 36.010000");

            return false;
        }
        else {
            X.setError(null);
            X.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateY() {

        String val2 = Y.getEditText().getText().toString();
        String pattern ="(-)?+[0-9]+\\.+\\d{6}";

        if (val2.isEmpty()) {
            Y.setError("Cette case ne peut pas être vide");
            return false;
        }
        else if(!val2.matches(pattern)){

            Y.setError("Format non valide, Essayer un nombre avec 6 chiffres après le point, eg: -5.010000");
       
            return false;
        }
        else {
           Y.setError(null);
           Y.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateCode() {
        String val = Code.getEditText().getText().toString();
        String codePattern = "[0-9]+/+[0-9]+";

        if (val.isEmpty()) {
            Code.setError("Cette case ne peut pas être vide");
            return false;
        } else if (!val.matches(codePattern)) {
            Code.setError("Format non valide ,Essayer une format x/y");
            return false;
        } else {
            Code.setError(null);
            Code.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateProf() {
        String val = Profendeur.getEditText().getText().toString();


        if (val.isEmpty()) {
            Profendeur.setError("Cette case ne peut pas être vide");
            return false;
        } else {
            Profendeur.setError(null);
            Profendeur.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatedate() {
        String val = dateEdt.getText().toString();



        if (val.isEmpty()) {
            dateEdt.setError("Cette case ne peut pas être vide");
            return false;
        }
        else {
            dateEdt.setError(null);

            return true;
        }
    }
    private Boolean validateprov() {

        String val2 = Province.getEditText().getText().toString();



        if (val2.isEmpty()) {
            Province.setError("Cette case ne peut pas être vide");
            return false;
        }
        else {
            Province.setError(null);
            Province.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatecom() {

        String val2 = Commune.getEditText().getText().toString();



        if (val2.isEmpty()) {
            Commune.setError("Cette case ne peut pas être vide");
            return false;
        }
        else {
            Commune.setError(null);
            Commune.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatepos() {

        String val2 = t.getEditText().getText().toString();



        if (val2.isEmpty()) {
            t.setError("Cette case ne peut pas être vide");
            return false;
        }
        else {
            t.setError(null);
            t.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatex() {

        String val2 = e_r.getEditText().getText().toString();



        if (val2.isEmpty()) {
            e_r.setError("Cette case ne peut pas être vide");
            return false;
        }
        else {
            e_r.setError(null);
            e_r.setErrorEnabled(false);
            return true;
        }
    }

    public void registerUser(View view) {

        if(!validatecom() | !validateprov() |  !validateProf() | !validatedate() | !validateCode() |  !validateX() | !validatex() | !validatepos() | !validateY()){
            return;
        }
        else{
            String ex = e_r.getEditText().getText().toString();
            String pos = t.getEditText().getText().toString();
            String x = X.getEditText().getText().toString();
            String y = Y.getEditText().getText().toString();
            String pro = Province.getEditText().getText().toString();
            String prof = Profendeur.getEditText().getText().toString();
            String Com = Commune.getEditText().getText().toString();
            String date = dateEdt.getText().toString();
            String code =Code.getEditText().getText().toString();
            String Deb =Debit.getEditText().getText().toString();

            Forage forage = new Forage(x,y,code,prof,Deb,date,Com,pro,ex,pos);


            database.getReference("Forage").push().setValue(forage);
            forage.setKey(database.getReference("Forage").push().getKey());

            Toast.makeText(this,"Forage ajouté", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(Add.this,MapsActivity.class);

            startActivity(intent);
            finish();
        }
      //  35.5888995 , -5.3625516
    }
}