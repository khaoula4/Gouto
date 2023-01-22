package com.example.gouto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {
    //Variables
    TextInputLayout regName, regUsername, regEmail,  regPassword;
    Button regBtn, regToLoginBtn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_registration);



        regEmail = findViewById(R.id.username);
        regPassword = findViewById(R.id.password);
        regBtn = findViewById(R.id.reg);


        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("users");

        //Save data in FireBase on button click

    }//onCreate Method End


    private Boolean validateEmail() {
        String val = regEmail.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            regEmail.setError("Cette case ne peut pas être vide");
            return false;
        } else if (!val.matches(emailPattern)) {
            regEmail.setError("Forme invalide , essayer une forme ##@##.##");
            return false;
        } else {
            regEmail.setError(null);
            regEmail.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validatePassword() {
        String val = regPassword.getEditText().getText().toString();
        String passwordVal = "^" +
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";
        String passwordVal2 = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=*])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";

        if (val.isEmpty()) {
            regPassword.setError("Cette case ne peut pas être vide");
            return false;
        } else if (!val.matches(passwordVal)) {
            regPassword.setError("Le mot de passe est doit contenir au moins 4 lettres sans espaces");
            return false;
        } else if (val.matches(passwordVal2)) {
            regPassword.setError("Le mot de passe ne doit pas contenir des caractères spéciales");
            return false;
        }
        else {
            regPassword.setError(null);
            regPassword.setErrorEnabled(false);
            return true;
        }
    }

    //This function will execute when user click on Register Button
    public void registerUser(View view) {

        if( !validatePassword() |  !validateEmail() ){
            return;
        }
        else{

            String email = regEmail.getEditText().getText().toString();
            String password = regPassword.getEditText().getText().toString();
            User user = new User(email, password);
            reference.child(password).setValue(user);

            Toast.makeText(this,"Utilisateur ajouté", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Registration.this,List.class);
            startActivity(intent);
            finish();
        }

    }



}