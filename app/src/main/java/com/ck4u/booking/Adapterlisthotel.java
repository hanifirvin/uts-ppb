package com.ck4u.booking;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Adapterlisthotel extends RecyclerView.Adapter<Adapterlisthotel.ViewHolder> {

    private List<hotel> listhotel = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hotel, parent, false);
        return new ViewHolder(v);
    }

    public void setListhotel(List<hotel> listhotel){
        this.listhotel.clear();
        this.listhotel.addAll(listhotel);
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        hotel hotel = listhotel.get(position);

        holder.namahotel.setText(hotel.getName());
        holder.lokasihotel.setText(hotel.getLocation());

        holder.ulasanhotel.setText(hotel.getReview() + " Ulasan");

        Glide.with(holder.itemView.getContext())
                .load(hotel.getImage())
                .into(holder.imghotel);

        holder.deskripsi.setText(hotel.getDescription());
        holder.harga.setText(hotel.getPrice());

        holder.keterangan.setText(hotel.getNote());
        holder.tipehotel.setRating(hotel.getHotelType());

        if(hotel.isFavorite()){
            Glide.with(holder.itemView.getContext())
                    .load(R.drawable.ic_baseline_favorite_24)
                    .into(holder.iconfavorit);
        } else {
            Glide.with(holder.itemView.getContext())
                    .load(R.drawable.ic_baseline_favorite_border_24)
                    .into(holder.iconfavorit);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), Activitydetailhotel.class);
                intent.putExtra("id", hotel.getId());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listhotel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imghotel, iconfavorit;
        TextView namahotel, ulasanhotel, lokasihotel, deskripsi, harga, keterangan;
        RatingBar tipehotel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imghotel = itemView.findViewById(R.id.img_hotel);
            iconfavorit = itemView.findViewById(R.id.icFavorite);
            namahotel = itemView.findViewById(R.id.tvNama);
            ulasanhotel = itemView.findViewById(R.id.tvReview);
            lokasihotel = itemView.findViewById(R.id.tvLocation);
            deskripsi = itemView.findViewById(R.id.tvDesc);
            harga = itemView.findViewById(R.id.tvPrice);
            keterangan = itemView.findViewById(R.id.tvNote);
            tipehotel = itemView.findViewById(R.id.hotelType);

        }
    }
}
