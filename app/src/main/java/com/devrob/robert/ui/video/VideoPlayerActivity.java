package com.devrob.robert.ui.video;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.devrob.robert.R;

public class VideoPlayerActivity extends AppCompatActivity {
    private VideoView videoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_video_player);
        Intent intent = getIntent();
        String uri = intent.getStringExtra(ListVideosActivity.EXTRA_URI);
        //createVideoPlayer(uri);
    }

    private void createVideoPlayer(String uri){
        MediaController mediaController = new MediaController(this);
        videoView = findViewById(R.id.video_player);
        videoView.setVideoURI(Uri.parse(uri));
        videoView.setMediaController(mediaController);
        videoView.start();
    }
}