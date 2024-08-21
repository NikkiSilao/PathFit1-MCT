package com.example.pathfit1mct.Main;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Handler;

import com.example.pathfit1mct.MainActivity;
import com.example.pathfit1mct.R;

public class SplashScreenActivity extends AppCompatActivity {

    private final Handler handler = new Handler();
    private Runnable colorChangeRunnable;
    private Button getStartedButton;

    private static final String TAG = "MainActivity"; // Tag for logging

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Set the layout file for MainActivity
        setContentView(R.layout.activity_splash_screen);

        // Initialize views and components
        initializeViews();
        setupButtonClick();

        // Apply system bars insets to main layout
        applySystemBarsInsets();

        // Apply custom font to TextViews
//        applyCustomFont();

    }

    // Method to initialize views and components
    private void initializeViews() {
        getStartedButton = findViewById(R.id.button);
    }

    // Method to set onClickListener for Get Started button
    private void setupButtonClick() {
        if (getStartedButton != null) {
            getStartedButton.setOnClickListener(v -> {
                // Navigate to HomeActivity when button is clicked
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Finish current activity
            });
        } else {
            Log.e(TAG, "Get Started Button is null. Check if the ID is correct in activity_main.xml.");
        }
    }

    // Method to apply system bars insets to main layout
    private void applySystemBarsInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_layout), (v, insets) -> {
            // Retrieve system bars insets
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

            // Apply insets as padding to the main layout
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            // Return the insets without consuming them
            return insets;
        });
    }

    // Method to apply custom font to TextViews
//    private void applyCustomFont() {
//        Typeface typeface = ResourcesCompat.getFont(this, R.font.interbold);
//
//        TextView textViewPart1 = findViewById(R.id.text_view_part1);
//        TextView textViewPart2 = findViewById(R.id.text_view_part2);
//
//        if (textViewPart1 != null) {
//            textViewPart1.setTypeface(typeface);
//        }
//
//        if (textViewPart2 != null) {
//            textViewPart2.setTypeface(typeface);
//        }
//    }


}
