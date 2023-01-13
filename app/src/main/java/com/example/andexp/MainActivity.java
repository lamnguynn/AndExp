package com.example.andexp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button submitButton;
    TextView nameLabel;
    int numClicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {}

        setContentView(R.layout.activity_main);

        setupAssets();
    }

    public void setupAssets() {
        nameLabel = findViewById(R.id.titleLabel);
        nameLabel.setText("");

        submitButton = findViewById(R.id.submitButton);
        submitButton.setText("Submit");

        //submitButton.setBackgroundColor(ContextCompat.getColor(this, R.color.black));

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numClicked += 1;
                nameLabel.setText(Integer.toString(numClicked));
            }
        });
    }
}