package com.example.xdhacks.Activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import com.example.xdhacks.R;

public class MainActivity extends AppCompatActivity {

    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainenter);
        mVideoView = (VideoView) findViewById(R.id.bgVideoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.loginvid);

        mVideoView.setVideoURI(uri);
        mVideoView.start();

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
    }
    public void gotoprofile(View v){
        Intent intent = new Intent(this, newProfile.class);
        startActivity(intent);
    }

    public void gotoLogin(View v){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}