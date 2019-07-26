package com.example.demoakhir;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demoakhir.koneksi.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {
    EditText txt_username;
    EditText txt_password;
    DatabaseHelper database;
    public String ketemu="99";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        database = new DatabaseHelper(this);
        txt_username = findViewById(R.id.ed_username);
        txt_password = findViewById(R.id.ed_password);
    }

    public void login(View v){
        ketemu = database.cekLogin(txt_username.getText().toString(),txt_password.getText().toString());
        if (ketemu=="1") {
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(LoginActivity.this,"Username dan Password Salah",Toast.LENGTH_LONG).show();
        }
    }

    public void register(View v){
        Intent intent = new Intent(LoginActivity.this,RegistrasiActivity.class);
        startActivity(intent);
        finish();
    }

    public void keluar(View v){
        finish();
    }
}
