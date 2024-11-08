package de.bbs_technik_koblenz.jl.mytestapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextClock;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ProgressBar spinner;
    private ProgressBar progressBarValue;
    private TextClock textClockTime;
    private RatingBar ratingBar;
    private Button updateButton;
    private Button nextScreenButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nextScreenButton = findViewById(R.id.btn_switchScreen);

        nextScreenButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent buttonScreen = new Intent(MainActivity.this, de.bbs_technik_koblenz.jl.mytestapp.buttonScreen.class);
                startActivity(buttonScreen);
            }
        });

        Toast.makeText(this, "App created", Toast.LENGTH_SHORT).show();
        Log.d("logJl", "App created");


        updateElements();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "App paused", Toast.LENGTH_LONG).show();
        Log.d("logJl", "App has been paused");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "App resumed", Toast.LENGTH_SHORT).show();
        Log.d("logJl", "App has been resumed");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "App started", Toast.LENGTH_SHORT).show();
        Log.d("logJl", "App has been started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "App stopped", Toast.LENGTH_SHORT).show();
        Log.d("logJl", "App has been stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "App destroyed", Toast.LENGTH_SHORT).show();
        Log.d("logJl", "App has been destroyed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "App restarted", Toast.LENGTH_SHORT).show();
        Log.d("logJl", "App has been restarted");
    }

    private void updateElements() {
        ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setRating(randomFloat(0f,5f));

        spinner = findViewById(R.id.spinner);
        spinner.setBackgroundColor(0xFF_333333);

        progressBarValue = findViewById(R.id.progressBar);
        progressBarValue.setProgress(Math.round(randomFloat(0f,100f)));

        textClockTime = findViewById(R.id.textClock);
        textClockTime.setFormat24Hour("HH:mm:ss Z");
        textClockTime.refreshTime();

        updateButton = findViewById(R.id.update);

        updateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                updateElements();
            }
        });

        Log.d("logJl", "UI Elements updated");
    }


    private float randomFloat(float min, float max) {
        Random r = new Random();
        return min + r.nextFloat() * (max - min);
    }

}