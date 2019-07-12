package com.example.pertemuan9a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txt_nama, txt_nim, txt_kampus;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_nama = findViewById(R.id.edit_nama);
        txt_nim = findViewById(R.id.edit_nim);
        txt_kampus = findViewById(R.id.edit_kampus);
        hasil = findViewById(R.id.hasil);
    }
    public void tampil_hasil (View v){
        hasil.setText("Hasil : \n Nama : "+txt_nama.getText()+"\n NIM : "+txt_nim.getText()+"\n Kampus : "+txt_kampus.getText() );

    }
}
