package com.example.myrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHape;
    private ArrayList<Hp> list = new ArrayList<>();

    private String title = "Mode List";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle(title);

        rvHape = findViewById(R.id.rv_hp);
        rvHape.setHasFixedSize(true);

        list.addAll(HapeData.getListData());
        showRecyclerList();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int selectedMode) {
        switch (selectedMode){
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;
            case R.id.action_grid:
                title = "Mode Grid";
                showRecyclerGrid();
                break;
            case R.id.action_cardView:
                title = "Mode CardView";
                showRecyclerCardView();
                break;
        }
    }

    private void showRecyclerCardView() {
        rvHape.setLayoutManager(new LinearLayoutManager(this));
        CardViewHeroAdapter cardViewHeroAdapter = new CardViewHeroAdapter(list);
        rvHape.setAdapter(cardViewHeroAdapter);
    }


    private void showRecyclerList() {
        rvHape.setLayoutManager(new LinearLayoutManager(this));
        ListHpAdapter listHpAdapter = new ListHpAdapter(list);
        rvHape.setAdapter(listHpAdapter);

        listHpAdapter.setOnItemClickCallback(new ListHpAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(Hp data) {
                showSelectedHero (data);
            }
        });


    }
    private void showRecyclerGrid(){
        rvHape.setLayoutManager(new GridLayoutManager(this, 2));
        GridHeroAdapter gridHeroAdapter = new GridHeroAdapter(list);
        rvHape.setAdapter(gridHeroAdapter);

        gridHeroAdapter.setOnItemClickCallback(new GridHeroAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hp data) {
                showSelectedHero(data);
            }
        });
    }
    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
    public void showSelectedHero (Hp hp){
        Toast.makeText(this, "Kamu memilih" + hp.getName(), Toast.LENGTH_SHORT).show();
    }


}
