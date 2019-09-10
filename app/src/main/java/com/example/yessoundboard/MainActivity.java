package com.example.yessoundboard;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private SoundPool soundPool;
    private int sound1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                                                .setContentType(AudioAttributes.CONTENT_TYPE_MOVIE).build();

        soundPool = new SoundPool.Builder().setMaxStreams(1).setAudioAttributes(audioAttributes).build();

        sound1 = soundPool.load(this, R.raw.no, 1);


    }
    public void playSound(View v){
        switch (v.getId()){
            case R.id.button_soundNO:
                soundPool.play(sound1,1, 1, 3, 0, 1);
                break;
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }
}
