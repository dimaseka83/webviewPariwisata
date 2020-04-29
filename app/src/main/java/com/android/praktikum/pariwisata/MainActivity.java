package com.android.praktikum.pariwisata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvPantai;
    private ArrayList<Pantai> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPantai = findViewById(R.id.rv_mybeach);
        rvPantai.setHasFixedSize(true);

        list.addAll(MybeachData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvPantai.setLayoutManager(new LinearLayoutManager(this));
        CardViewPantaiAdapter cardViewPantaiAdapter = new CardViewPantaiAdapter(list);
        rvPantai.setAdapter(cardViewPantaiAdapter);

        cardViewPantaiAdapter.setOnItemClickedCallback(new OnItemClickedCallback() {
            @Override
            public void onItemClicked(Pantai pantai) {
                Intent pindah = new Intent(MainActivity.this, ActivityWeb.class);
                pindah.putExtra(ActivityWeb.ITEM_EXTRA, pantai);
                startActivity(pindah);

            }
        });
    }
}
