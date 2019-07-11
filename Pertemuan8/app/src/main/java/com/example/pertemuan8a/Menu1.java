package com.example.pertemuan8a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Menu1 extends AppCompatActivity {
    EditText txt_angka;
    TextView lbl_hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

        txt_angka = findViewById(R.id.edit_angka);
        lbl_hasil = findViewById(R.id.label_hasil);

    }
    public void Tampil_hasil (View v){
        if (txt_angka.getText().length() > 0) {
        int angka = Integer.parseInt(txt_angka.getText().toString());
        int hasil;
        hasil = angka%2;

        if (hasil == 0){
            lbl_hasil.setText(hasil +" Adalah Genap");
        }else {
            lbl_hasil.setText(hasil +" Adalah Ganjil");
        }
        }else {
            Toast toast = Toast.makeText(Menu1.this, "Mohon Masukkan Angka", Toast.LENGTH_LONG);
            toast.show();

        }
    }
}
