package com.example.xdhacks.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.VideoView;

import com.example.xdhacks.R;

public class newProfile extends Activity {
    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_profile);



//        mVideoView = findViewById(R.id.videoView2);
//        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.backgroundlogin);
//        mVideoView.setVideoURI(uri);
//        mVideoView.start();
//
//        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mediaPlayer) {
//                mediaPlayer.setLooping(true);
//            }
//        });


        Spinner preferences= findViewById(R.id.preferences);
        String [] FoodPrefs = new String[]{"Vegan","Vegetarian","Carnivore"};
        // here get the string array of the users drinks
        ArrayAdapter<String> adaptercoffee = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,FoodPrefs);
        preferences.setAdapter(adaptercoffee);

    }

    public void gotoLogin(View v){
        Intent intent = new Intent(this, main.class);
        startActivity(intent);
    }


}
