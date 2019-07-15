package com.example.pertemuan10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void pindahinternal(View v){
        Intent i = new Intent(MainActivity.this, InternalActivity.class);
        startActivity(i);
    }
    public void pindahexternal(View v){
        Intent ex = new Intent(MainActivity.this, ExternalActivity.class);
        startActivity(ex);
    }
}
