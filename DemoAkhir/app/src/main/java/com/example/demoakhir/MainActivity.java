package com.example.demoakhir;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.demoakhir.koneksi.DatabaseHelper;
import com.example.demoakhir.koneksi.MyAdapter;
import com.example.demoakhir.koneksi.MyData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    AlertDialog.Builder dialog;
    List<MyData> itemList = new ArrayList<MyData>();
    MyAdapter adapter;
    DatabaseHelper SQLite = new DatabaseHelper(this);

    public static final String TAG_ID="id";
    public static final String TAG_NAMA="nama";
    public static final String TAG_ALAMAT="alamat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //disni letak code bebas
        SQLite = new DatabaseHelper(getApplicationContext());
        listView = findViewById(R.id.list_view);
        ///////////////////////

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TambahActivity.class);
                startActivity(intent);
            }
        });


        //letakkan coding adapter listview untuk edit dan hapus disini
        adapter = new MyAdapter(MainActivity.this,itemList);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final String id_list = itemList.get(position).getId();
                final String nama_list = itemList.get(position).getNama_teman();
                final String alamat_list = itemList.get(position).getAlamat_teman();

                final CharSequence[] dialogitem = {"Edit","Hapus"};
                dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setCancelable(true);
                dialog.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                                //jika memilih edit
                                Intent intent = new Intent(MainActivity.this,EditActivity.class);
                                intent.putExtra(TAG_ID,id_list);
                                intent.putExtra(TAG_NAMA,nama_list);
                                intent.putExtra(TAG_ALAMAT,alamat_list);
                                startActivity(intent);
                                break;
                            case 1:
                                //jika memilih hapus
                                SQLite.delete(Integer.parseInt(id_list));
                                itemList.clear();
                                getAllData();
                                break;
                        }
                    }
                }).show();
                return false;
            }
        });
        getAllData();
    }

    //otomatis generate sendiri
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //gunakan generate onOptionsItemSelected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void getAllData(){
        ArrayList<HashMap<String, String>> row = SQLite.getAllData();
        for (int i = 0; i < row.size(); i++) {
            String id = row.get(i).get(TAG_ID);
            String nama = row.get(i).get(TAG_NAMA);
            String alamat = row.get(i).get(TAG_ALAMAT);
            MyData data = new MyData();
            data.setId(id);
            data.setNama_teman(nama);
            data.setAlamat_teman(alamat);
            itemList.add(data);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume(){
        super.onResume();
        itemList.clear();
        getAllData();
    }
}
