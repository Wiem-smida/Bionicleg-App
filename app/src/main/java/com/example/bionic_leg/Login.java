package com.example.bionic_leg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

      Button loginButton = findViewById(R.id.sign_in);
        // TODO: 14/02/2024 test if connected
      loginButton.setOnClickListener(view -> {
          Intent intent = new Intent(this, CardViewBionicLeg.class);
          startActivity(intent);
          finish();
      });
    }
}