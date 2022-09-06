package com.example.nparks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener{

    VideoView videoView;
    Button skipAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = (VideoView) findViewById(R.id.videoView);

        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.intro);
        videoView.setVideoURI(video);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(false);
                videoView.start();
            }
        });

        videoView.postDelayed(new Runnable() {
            @Override
            public void run() {
                skipAd.setVisibility(View.VISIBLE);
            }
        }, 5000);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.skipAd){
            finish();
            Intent intent = new Intent(VideoActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}