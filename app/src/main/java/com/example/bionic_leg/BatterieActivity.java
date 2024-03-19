package com.example.bionic_leg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.lzyzsd.circleprogress.CircleProgress;

public class BatterieActivity extends AppCompatActivity {

    private CircleProgress circleProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batterie);

        // Récupérer la référence vers le CircleProgress dans le layout
        circleProgress = findViewById(R.id.circle_progress);

        // Enregistrer le récepteur pour le niveau de batterie
        registerBatteryLevelReceiver();
    }

    private void registerBatteryLevelReceiver() {
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(batteryLevelReceiver, filter);
    }

    private final BroadcastReceiver batteryLevelReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction())) {
                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

                float batteryPct = level / (float) scale;
                int batteryPercentage = (int) (batteryPct * 100);

                // Mettre à jour le cercle de progression avec le niveau de batterie
                circleProgress.setProgress(batteryPercentage);
            }
        }
    };

    @Override
    protected void onDestroy() {
        // Désenregistrer le récepteur lorsque l'activité est détruite
        unregisterReceiver(batteryLevelReceiver);
        super.onDestroy();
    }
}
