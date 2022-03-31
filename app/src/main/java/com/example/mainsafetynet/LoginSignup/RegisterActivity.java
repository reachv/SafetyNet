package com.example.mainsafetynet.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mainsafetynet.MainActivity;
import com.example.mainsafetynet.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegisterActivity extends AppCompatActivity {

    EditText Username, Password, DOB, Email;
    Button Signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Assigning Values
        Username = findViewById(R.id.User);
        Password = findViewById(R.id.Pass);
        Email = findViewById(R.id.Email);
        Signup = findViewById(R.id.SignUp);

        //Registry
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = Username.getText().toString();
                String password = Password.getText().toString();
                String email = Email.getText().toString();

                //Parse User Registration
                ParseUser user = new ParseUser();
                user.setUsername(username);
                user.setPassword(password);
                user.setEmail(email);

                /* ADD DATE OF BIRTH */


                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e != null){
                            Log.e("RegistryActivity", "ParseUserSignup", e);
                            return;
                        }
                        ParseUser.logInInBackground(username, password, new LogInCallback() {
                            @Override
                            public void done(ParseUser user, ParseException e) {
                                if(e != null){
                                    Log.e("RegistryActivity", "ParseUserLogin", e);
                                    return;
                                }
                                goMainactivity();
                            }
                        });
                    }
                });
            }
        });

    }
    void goMainactivity(){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
    }
}