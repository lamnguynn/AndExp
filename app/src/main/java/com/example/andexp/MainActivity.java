package com.example.andexp;

import androidx.appcompat.app.AppCompatActivity;
import com.spotify.android.appremote.api.ConnectionParams;
import com.spotify.android.appremote.api.Connector;
import com.spotify.android.appremote.api.SpotifyAppRemote;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button submitButton;
    TextView nameLabel;

    private static final String CLIENT_ID = "your_client_id";
    private static final String REDIRECT_URI = "http://com.yourdomain.yourapp/callback";
    private SpotifyAppRemote mSpotifyAppRemote;
    private ConnectionParams connectionParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {}

        setContentView(R.layout.activity_main);

        setupAssets();
        setupAuth();
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
                showSpotifyAuth();
            }
        });
    }

    public void setupAuth() {
        connectionParams =
                new ConnectionParams.Builder(CLIENT_ID)
                        .setRedirectUri(REDIRECT_URI)
                        .showAuthView(true)
                        .build();

    }

    private void showSpotifyAuth() {
        //Check to see if spotify is downloaded before providing auth
        if( SpotifyAppRemote.isSpotifyInstalled(this) ) {

            //Connect to spotify to provide auth
            SpotifyAppRemote.connect(this, connectionParams,
                    new Connector.ConnectionListener() {
            
                        @Override
                        public void onConnected(SpotifyAppRemote spotifyAppRemote) {
                            mSpotifyAppRemote = spotifyAppRemote;
                            Log.d("MainActivity", "Connected! Yay!");

                            // Now you can start interacting with App Remote
                            System.out.println("Connected....");
                        }

                        @Override
                        public void onFailure(Throwable throwable) {
                            Log.e("MainActivity", throwable.getMessage(), throwable);

                            // Something went wrong when attempting to connect! Handle errors here
                        }
                    });
        }
        else {
            Log.d("MainActivity", "Spotify NOT installed");
        }
    }
}