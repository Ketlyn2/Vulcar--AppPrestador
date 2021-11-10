package com.example.appprestador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    public Thread thread;
    public Handler handler;
    public int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Remove a status bar da tela
        getSupportActionBar().hide();

        handler = new Handler();
        thread = new Thread(this::run);
        thread.start();

    }

    public void run(){
        i = 1;
        try {
            //Duração definida pelo while
            while(i < 100) {
                Thread.sleep(15);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        i++;
                    }
                });
            }
        } catch (Exception e){

        }

        startActivity(new Intent(this, Login.class));
    }
}