package com.example.bionic_leg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class pages extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pages);

        int pageId = getIntent().getIntExtra("id",0);

        TextView textpageId = findViewById(R.id.textPageId);
        textpageId.setText("PAGE : " + pageId);
    }
}