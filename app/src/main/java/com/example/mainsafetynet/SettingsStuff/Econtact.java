package com.example.mainsafetynet.SettingsStuff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mainsafetynet.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class Econtact extends AppCompatActivity {

    String econt = "";
    EditText password;
    Button login;
    Location location;
    SmsManager smsManager = SmsManager.getDefault();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_econtact);
        password = findViewById(R.id.PasswordEc);
        login = findViewById(R.id.LoginEC);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser.logInInBackground(ParseUser.getCurrentUser().getUsername(), password.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if(e != null){
                            //Hard Ping Initiated
                            smsManager.sendTextMessage(econt, null, "Possible Kidnapping: " + location.getLatitude() + "," + location.getLongitude(), null, null);
                            Log.e("Emergency Contact Hard", "Sent");
                            finish();
                        }
                        //Password Cleared
                        finish();
                    }
                });
            }
        });
    }
}