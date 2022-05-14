package com.example.mainsafetynet.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mainsafetynet.R;
import com.example.mainsafetynet.SettingsStuff.SoftEcontPhoneNumbers;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;


public class SettingsFragment extends Fragment {

    //Data Values
    EditText username;
    EditText password;
    EditText email;
    TextView EmergencyContact;
    Button save;


    public SettingsFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        //User Information
        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.Password);
        email = view.findViewById(R.id.Email);
        save = view.findViewById(R.id.Save);
        EmergencyContact = view.findViewById(R.id.Ephone);

        username.setText(ParseUser.getCurrentUser().getUsername());
        email.setText(ParseUser.getCurrentUser().getEmail());

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser user = ParseUser.getCurrentUser();
                if(username.getText().toString() != user.getUsername()){
                    user.setUsername(username.getText().toString());
                }else if(!password.getText().toString().isEmpty()){
                    user.setPassword(password.getText().toString());
                }else if(user.getEmail() != email.getText().toString()){
                    user.setEmail(email.getText().toString());
                }
                user.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e != null){
                            Log.e("SettingFragment", "75"+e);
                        }
                    }
                });
                return;
            }
        });

        EmergencyContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), SoftEcontPhoneNumbers.class);
                startActivity(i);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}