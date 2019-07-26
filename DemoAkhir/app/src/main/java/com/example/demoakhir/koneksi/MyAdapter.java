package com.example.demoakhir.koneksi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.demoakhir.R;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Activity myActivity;
    private LayoutInflater myInflater;
    private List<MyData> myItems;

    //generate constructor tanpa inflater
    public MyAdapter(Activity myActivity, List<MyData> myItems) {
        this.myActivity = myActivity;
        this.myItems = myItems;
    }

    //generate dengan overide getView
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (myInflater == null)
            myInflater = (LayoutInflater) myActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null)
            view = myInflater.inflate(R.layout.list_row, null);
        TextView lbl_id = view.findViewById(R.id.id);
        TextView lbl_nama = view.findViewById(R.id.nama_teman);
        TextView lbl_alamat = view.findViewById(R.id.alamat_teman);

        MyData data = myItems.get(i);
        lbl_id.setText(data.getId());
        lbl_nama.setText(data.getNama_teman());
        lbl_alamat.setText(data.getAlamat_teman());

        return view;
    }

    @Override
    public int getCount() {
        return myItems.size();
    }

    @Override
    public Object getItem(int i) {
        return myItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
}
