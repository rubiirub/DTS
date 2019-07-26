package com.example.demoakhir;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demoakhir.koneksi.DatabaseHelper;

public class RegistrasiActivity extends AppCompatActivity {
    DatabaseHelper database;
    EditText txt_user;
    EditText txt_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        database = new DatabaseHelper(this);
        txt_user = findViewById(R.id.ed_user);
        txt_pass = findViewById(R.id.ed_pass);
    }

    public void daftarkanData(View v){
        String input_user = txt_user.getText().toString().trim();
        String input_pass = txt_pass.getText().toString().trim();
        database.registrasi(input_user,input_pass);
        Toast.makeText(RegistrasiActivity.this,"Data Baru Tersimpan",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(RegistrasiActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
