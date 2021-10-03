package com.masai.jiocinmea;

import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;


import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.ui.PlayerView;



public class VideoPlayerActivity extends AppCompatActivity {
    private PlayerView videoPlayer;
    private SimpleExoPlayer simpleExoPlayer;
    private  static  final  String FILE_URL ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);


        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        videoPlayer = findViewById(R.id.exo_player);
        setUpExoPlayer(getIntent().getStringExtra("url"));

    }

    private  void setUpExoPlayer(String url){
        simpleExoPlayer = new SimpleExoPlayer.Builder(this).build();
        videoPlayer.setPlayer(simpleExoPlayer);
        MediaItem mediaItem = new MediaItem.Builder()
                .setUri(Uri.parse(url)).build();
       simpleExoPlayer.addMediaItem(mediaItem);
       simpleExoPlayer.prepare();
       simpleExoPlayer.play();




    }
}