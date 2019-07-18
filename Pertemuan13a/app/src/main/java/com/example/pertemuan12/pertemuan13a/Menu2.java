package com.example.pertemuan12.pertemuan13a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Menu2 extends AppCompatActivity {
    EditText txt_nim, txt_nama;
    TextView lbl_hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        txt_nim = findViewById(R.id.txt_nim);
        txt_nama = findViewById(R.id.txt_nim);
        lbl_hasil = findViewById(R.id.label_hasil);
    }

    public void hasil (View v){
        lbl_hasil.setText("Nim anda adalah : " +txt_nim.getText()+"\nNama anda adalah : "+txt_nama.getText());

    }
}
