package com.android.praktikum.pariwisata;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewPantaiAdapter extends RecyclerView.Adapter<CardViewPantaiAdapter.CardViewViewHolder> {
    private ArrayList<Pantai> listPantai;

    private OnItemClickedCallback onItemClickedCallback;

    public void setOnItemClickedCallback(OnItemClickedCallback onItemClickedCallback){
        this.onItemClickedCallback = onItemClickedCallback;
    }



    public CardViewPantaiAdapter(ArrayList<Pantai> list){
        this.listPantai = list;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_pantai,viewGroup,false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {
        final Pantai pantai = listPantai.get(position);

        Glide.with(holder.itemView.getContext())
                .load(pantai.getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgPhoto);

        holder.tvName.setText(pantai.getNameBeach());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickedCallback.onItemClicked(pantai);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listPantai.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgPhoto;
        public TextView tvName;


        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.imagepantai);
            tvName = itemView.findViewById(R.id.tvPlaceName);

        }
    }
}
