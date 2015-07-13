package com.example.bthomas.androidapp;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MotionActivity extends ActionBarActivity {

    private SoundPool spool;
    private int snd_fireball_id;
    private int snd_coin_id;
    private int snd_jump_id;
    private int snd_mushroom_id;

    AudioManager amgr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion);

        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        // for API 21 and newer
//        SoundPool.Builder builder = new SoundPool.Builder();
//        builder.setMaxStreams(5);
//        AudioAttributes.Builder aab = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_GAME).setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION);
//        builder.setAudioAttributes(aab.build());
//        spool = builder.build();

        spool = new SoundPool(5,AudioManager.STREAM_MUSIC, 0);
        snd_fireball_id = spool.load(this, R.raw.smb_fireball, 1);
        snd_coin_id = spool.load(this, R.raw.smb_coin, 1);
        snd_jump_id = spool.load(this, R.raw.smb_jump_small, 1);
        snd_mushroom_id = spool.load(this, R.raw.smb_powerup, 1);
        amgr = (AudioManager) getSystemService(AUDIO_SERVICE);

        final Button btn_fireball = (Button) findViewById(R.id.btn_fireball);
        btn_fireball.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                play_fireball();
            }
        });
        final Button btn_coin = (Button) findViewById(R.id.btn_coin);
        btn_coin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                play_coin();
            }
        });
        final Button btn_mario = (Button) findViewById(R.id.btn_mario);
        btn_mario.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                play_jump();
            }
        });
        final Button btn_mushroom = (Button) findViewById(R.id.btn_mushroom);
        btn_mushroom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                play_powerup();
            }
        });
    }

    private void play_fireball() {
        float volume = (float) amgr.getStreamVolume(AudioManager.STREAM_MUSIC);
        spool.play(snd_fireball_id, volume, volume, 1, 0, 1f);
    }
    private void play_coin() {
        float volume = (float) amgr.getStreamVolume(AudioManager.STREAM_MUSIC);
        spool.play(snd_coin_id, volume, volume, 1, 0, 1f);
    }
    private void play_jump() {
        float volume = (float) amgr.getStreamVolume(AudioManager.STREAM_MUSIC);
        spool.play(snd_jump_id, volume, volume, 1, 0, 1f);
    }
    private void play_powerup() {
        float volume = (float) amgr.getStreamVolume(AudioManager.STREAM_MUSIC);
        spool.play(snd_mushroom_id, volume, volume, 1, 0, 1f);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_motion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
