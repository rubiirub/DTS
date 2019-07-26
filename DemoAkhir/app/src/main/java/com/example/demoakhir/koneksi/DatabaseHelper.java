package com.example.demoakhir.koneksi;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.demoakhir.LoginActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseHelper extends SQLiteOpenHelper{

    //ini ketik manual
    public DatabaseHelper(Context context){
        super(context,"uas.db",null,1);
    }

    //ini gunakan implement
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //paste dari SQLITE
        sqLiteDatabase.execSQL("CREATE TABLE 't_teman'('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'nama' TEXT, 'alamat' TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE 't_login'('username' TEXT PRIMARY KEY, 'password' TEXT)");
    }

    //ini gunakan implement
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int l) {
        //paste dari SQLITE
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS 't_teman'");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS 't_login'");
        onCreate(sqLiteDatabase);
    }

    //yang ini verifikasi login
    public String cekLogin(String input_user, String input_password){
        String ketemu="";
        SQLiteDatabase database = this.getWritableDatabase();
        String cekQuery = "SELECT * FROM 't_login' WHERE username='" + input_user + "' AND password='" + input_password + "' ";
        Cursor cursor = database.rawQuery(cekQuery, null);
        if (cursor.getCount()>0) {
            ketemu="1";
        }else
            ketemu="0";
        return ketemu;
    }

    //yang ini hanya untuk login saja
    public void registrasi(String input_user, String input_password){
        SQLiteDatabase database = this.getWritableDatabase();
        String regQuery = "INSERT INTO 't_login'(username, password) VALUES ('" + input_user + "','" + input_password + "')";
        database.execSQL(regQuery);
        database.close();
    }

    public void insert(String input_nama, String input_alamat){
        SQLiteDatabase database = this.getWritableDatabase();
        String insertQuery = "INSERT INTO 't_teman'(nama, alamat) VALUES ('" + input_nama + "','" + input_alamat + "')";
        database.execSQL(insertQuery);
        database.close();
    }

    public void update(int id, String input_nama, String input_alamat){
        SQLiteDatabase database = this.getWritableDatabase();
        String updateQuery = "UPDATE 't_teman' SET nama='" + input_nama + "',alamat='" + input_alamat + "' WHERE id= '" + id + "'";
        database.execSQL(updateQuery);
        database.close();
    }

    public void delete(int id){
        SQLiteDatabase database = this.getWritableDatabase();
        String deleteQuery = "DELETE FROM 't_teman' WHERE id= '" + id + "'";
        database.execSQL(deleteQuery);
        database.close();
    }

    public ArrayList<HashMap<String, String>> getAllData() {
        // Coding view data dari table
        ArrayList<HashMap<String, String >> wordList;
        wordList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT * FROM 't_teman'";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        // looping semua data pada dan dimasukkan ke arraylist
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("id", cursor.getString(0));
                map.put("nama", cursor.getString(1));
                map.put("alamat", cursor.getString(2));
                wordList.add(map);
            } while (cursor.moveToNext());
        }
        database.close();
        return wordList;
    }
}
