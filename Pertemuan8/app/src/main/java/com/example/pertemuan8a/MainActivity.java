package com.example.pertemuan8a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu1) {
            startActivity(new Intent(this, Menu1.class));
        }
        return true;
    }
    EditText txt_bil1, txt_bil2;
    TextView lbl_hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    txt_bil1 = findViewById(R.id.edit_bil1);
    txt_bil2 = findViewById(R.id.edit_bil2);
    lbl_hasil = findViewById(R.id.label_hasil);

    }
    public void tambah(View v){
        if (txt_bil1.getText().length()>0 && txt_bil2.getText().length()>0) {
            int bilangan1 = Integer.parseInt(txt_bil1.getText().toString());
            int bilangan2 = Integer.parseInt(txt_bil2.getText().toString());
            int hasil;
            hasil = bilangan1 + bilangan2;
            lbl_hasil.setText(Integer.toString(hasil));
        }else{
            Toast toast = Toast.makeText(MainActivity.this, "Mohon Masukkan Angka", Toast.LENGTH_LONG);
            toast.show();
        }
    }
    public void kurang(View v){
        if (txt_bil1.getText().length()>0 && txt_bil2.getText().length()>0){
            int bilangan1 =Integer.parseInt(txt_bil1.getText().toString());
            int bilangan2 = Integer.parseInt(txt_bil1.getText().toString());
            int hasil;
            hasil = bilangan1-bilangan2;
            lbl_hasil.setText(Integer.toString(hasil));
        }else{
            Toast toast = Toast.makeText(MainActivity.this, "Mohon Masukkan Angka", Toast.LENGTH_LONG);
            toast.show();
        }
    }
    public void kali(View v){
        if (txt_bil1.getText().length()>0 && txt_bil2.getText().length()>0) {
            int bilangan1 = Integer.parseInt(txt_bil1.getText().toString());
            int bilangan2 = Integer.parseInt(txt_bil2.getText().toString());
            int hasil;
            hasil = bilangan1 * bilangan2;
            lbl_hasil.setText(Integer.toString(hasil));
        }else {
            Toast toast = Toast.makeText(MainActivity.this, "Mohon Masukkan Angka", Toast.LENGTH_LONG);
            toast.show();
        }
    }
    public void bagi(View v){
        if (txt_bil1.getText().length()>0 && txt_bil2.getText().length()>0) {
            int bilangan1 = Integer.parseInt(txt_bil1.getText().toString());
            int bilangan2 = Integer.parseInt(txt_bil2.getText().toString());
            int hasil;
            hasil = bilangan1 / bilangan2;
            lbl_hasil.setText(Integer.toString(hasil));
        }else {
            Toast toast = Toast.makeText(MainActivity.this, "Mohon Masukkan Angka", Toast.LENGTH_LONG);
            toast.show();
        }
    }
    public void clear(View v){
        lbl_hasil.setText("0");
        txt_bil1.setText("");
        txt_bil2.setText("");
    }


}
