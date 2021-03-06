package com.example.humleporten.BeerLibrary;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.humleporten.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;


public class BeerLibraryActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{
    static final String GOOGLE_API_KEY = "";
    static final String YOUTUBE_VIDEO_ID ="AVV3UJCFnA4";
    static final String YOUTUBE_PLAYLIST ="";
    private static final String TAG = "BeerLibraryActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ConstraintLayout layout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_beer_library, null);
        setContentView(layout);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer,boolean wasRestored){
        Log.d(TAG, "onInitializationSuccess: provider is"+ provider.getClass().toString());
        Toast.makeText(this,"Initialization Successfully", Toast.LENGTH_SHORT).show();
        youTubePlayer.setPlaybackEventListener(playbackEventListener);
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        if (!wasRestored){
            youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        final int REQUEST_CODE = 1;

        if (youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this, REQUEST_CODE).show();
        } else
            {String errorMessage = String.format("An error as orrures initializing the YoutubePlayer (%1$s)", youTubeInitializationResult.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();

        }
    }
    private final YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {
            Toast.makeText(com.example.humleporten.BeerLibrary.BeerLibraryActivity.this, "Video is Playing", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onPaused() {
            Toast.makeText(com.example.humleporten.BeerLibrary.BeerLibraryActivity.this, "Video Paused", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onStopped() {
            Toast.makeText(com.example.humleporten.BeerLibrary.BeerLibraryActivity.this, "Video Stopped", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };

    private final YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {
            Toast.makeText(com.example.humleporten.BeerLibrary.BeerLibraryActivity.this, "Click Ad", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onVideoStarted() {
            Toast.makeText(com.example.humleporten.BeerLibrary.BeerLibraryActivity.this, "Video Started", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onVideoEnded() {
            Toast.makeText(com.example.humleporten.BeerLibrary.BeerLibraryActivity.this, "Video Finished", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };

}
