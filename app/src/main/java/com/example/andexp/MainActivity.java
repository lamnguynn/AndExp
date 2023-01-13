package com.example.andexp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button submitButton;
    TextView nameLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupAssets();
    }

    public void setupAssets() {
        submitButton = findViewById(R.id.submitButton);
        submitButton.setText("Submit");

        nameLabel = findViewById(R.id.titleLabel);
    }
}