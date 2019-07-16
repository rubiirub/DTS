package com.example.pertemuan11.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText etname;
    private DatabaseHelper databaseHelper;
    private TextView tvnames;
    private ArrayList<String> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DatabaseHelper(this);
        tvnames = findViewById(R.id.tvnames);
        etname = findViewById(R.id.etname);
    }

    public void SimpanData(View v) {
        databaseHelper.insertData(etname.getText().toString());
        etname.setText("");
        Toast.makeText(MainActivity.this, "Data Tersimpan !", Toast.LENGTH_SHORT).show();
    }

    public void TampilData(View v) {
        arrayList = databaseHelper.getAllDataList();
        tvnames.setText("");
        for (int i = 0; i < arrayList.size(); i++){
            if (i == 0){
                tvnames.setText(arrayList.get(i));
            }else {
            tvnames.setText(tvnames.getText().toString() + ", " + arrayList.get(i));
        }
        }
    }

}
