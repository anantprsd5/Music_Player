package com.example.anant.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button PlayButton = (Button)findViewById(R.id.Play);
        mediaPlayer = MediaPlayer.create(this,R.raw.number_eight);
        PlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                Toast.makeText(getApplicationContext(),"Playing music",Toast.LENGTH_SHORT).show();
            }
        });

        Button PauseButton = (Button)findViewById(R.id.Pause);
        PauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                Toast.makeText(getApplicationContext(),"Paused",Toast.LENGTH_SHORT).show();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(getApplicationContext(),"Completed",Toast.LENGTH_LONG).show();
                        Log.d("Tag", "Completed");
                    }
                });
            }
        });
    }
}
