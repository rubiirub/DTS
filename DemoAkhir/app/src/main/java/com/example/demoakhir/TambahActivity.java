package com.example.demoakhir;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demoakhir.koneksi.DatabaseHelper;

public class TambahActivity extends AppCompatActivity {
    DatabaseHelper database;
    EditText txt_nama;
    EditText txt_alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        database = new DatabaseHelper(this);
        txt_nama = findViewById(R.id.ed_user);
        txt_alamat = findViewById(R.id.ed_pass);

    }

    public void simpanData(View v){
        String input_nama = txt_nama.getText().toString().trim();
        String input_alamat = txt_alamat.getText().toString().trim();
        database.insert(input_nama,input_alamat);
        Toast.makeText(TambahActivity.this,"Data Baru Tersimpan",Toast.LENGTH_LONG).show();
    }
}
