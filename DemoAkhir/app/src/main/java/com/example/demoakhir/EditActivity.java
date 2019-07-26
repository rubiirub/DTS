package com.example.demoakhir;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demoakhir.koneksi.DatabaseHelper;

public class EditActivity extends AppCompatActivity {
    DatabaseHelper database;
    EditText txt_nama;
    EditText txt_alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        database = new DatabaseHelper(this);
        txt_nama = findViewById(R.id.ed_user);
        txt_alamat = findViewById(R.id.ed_pass);

        String data_nama = getIntent().getStringExtra(MainActivity.TAG_NAMA);
        String data_alamat = getIntent().getStringExtra(MainActivity.TAG_ALAMAT);

        txt_nama.setText(data_nama);
        txt_alamat.setText(data_alamat);
    }

    public void updateData(View v){
        int    input_id = Integer.parseInt(getIntent().getStringExtra(MainActivity.TAG_ID));//karena tidak ada objek dengan nama id pada xml
        String input_nama = txt_nama.getText().toString().trim();
        String input_alamat = txt_alamat.getText().toString().trim();
        database.update(input_id,input_nama,input_alamat);
        Toast.makeText(EditActivity.this,"Data Telah Diperharui",Toast.LENGTH_LONG).show();
    }
}
