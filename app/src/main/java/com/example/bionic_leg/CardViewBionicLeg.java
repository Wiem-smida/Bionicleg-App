package com.example.bionic_leg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class CardViewBionicLeg extends AppCompatActivity {

    ArrayList<RecyclerListItem> RecyclerListItem;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview_bionic_leg);

        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        RecyclerListItem = new ArrayList<RecyclerListItem>();
        RecyclerListItem.add(new RecyclerListItem(R.drawable.capteur,"Devices"));
        RecyclerListItem.add(new RecyclerListItem(R.drawable.batterie,"Batterie"));
        RecyclerListItem.add(new RecyclerListItem(R.drawable.voter,"Preferences"));
        RecyclerListItem.add(new RecyclerListItem(R.drawable.historique,"History"));
        RecyclerListItem.add(new RecyclerListItem(R.drawable.reglage_prothese,"Settings"));
        RecyclerListItem.add(new RecyclerListItem(R.drawable.activity,"Health"));

        CardRecyclerAdapter CardRecyclerAdapter = new CardRecyclerAdapter(RecyclerListItem,this);
        recyclerView.setAdapter(CardRecyclerAdapter);
    }
}