package com.fakecompany.amora.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service
{
    MediaPlayer myPlayer;

    public MyService()
    {
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate()
    {
        Toast.makeText(this, "Service Created", Toast.LENGTH_LONG).show();
        myPlayer = MediaPlayer.create(this, R.raw.run);
        myPlayer.setLooping(false);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startid)
    {
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        myPlayer.start();
        return START_STICKY;
    }


    @Override
    public void onDestroy()
    {
        Toast.makeText(this, "Service Done", Toast.LENGTH_SHORT).show();
        myPlayer.stop();
    }

}
