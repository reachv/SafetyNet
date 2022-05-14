package com.example.mainsafetynet.SettingsStuff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mainsafetynet.MainActivity;
import com.example.mainsafetynet.R;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

public class SoftEcontPhoneNumbers extends AppCompatActivity {

    ParseUser user = ParseUser.getCurrentUser();
    List<String> contacts;
    EditText phonenumbers;
    Button save, done;
    RecyclerView recyclerView;
    PSECadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft_econt_phone_numbers);

        phonenumbers = findViewById(R.id.PhoneNumberSEC);
        save = findViewById(R.id.SaveSEC);
        recyclerView = findViewById(R.id.rvSEC);
        contacts = new ArrayList<>();
        done = findViewById(R.id.DoneSEPH);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               contacts.add(phonenumbers.getText().toString());
               user.put("Econtact", contacts);
               user.saveInBackground(new SaveCallback() {
                   @Override
                   public void done(ParseException e) {
                       if(e != null) {
                           Log.e("SoftEcontPhoneNumbers", "52" + e);
                       }
                   }
               });
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        adapter = new PSECadapter(contacts);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}