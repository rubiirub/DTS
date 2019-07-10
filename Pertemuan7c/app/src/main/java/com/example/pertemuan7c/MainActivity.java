package com.example.pertemuan7c;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edit_nama;
    TextView label_hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_nama = findViewById(R.id.edit_nama);
        label_hasil = findViewById(R.id.label_hasil);
    }
    public void tampil_nama (View v){
        label_hasil.setText(edit_nama.getText());
    }
}
