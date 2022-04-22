package com.ck4u.booking;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class booking extends Application {
    private List<hotel> listHotel = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();

        listHotel.add(new hotel(0, "Anyer Hotel", "Anyer", "Rp 800.000", "Harga Untuk 1 Malam, 2 Dewasa", "Termasuk Sarapan", 4, R.drawable.anyer_hotel, 1500, false));
        listHotel.add(new hotel(1, "Bali Resorts", "Bali", "Rp 1.500.000", "Harga Untuk 1 Malam, 2 Dewasa", "Termasuk Pajak, Laundry dan Sarapan", 5, R.drawable.bali_resorts, 4000, false));
        listHotel.add(new hotel(2, "Jakarta Hotel", "Jakarta", "Rp 400.000", "Harga Untuk 1 Malam, 2 Dewasa", "Tidak Termasuk Sarapan", 3, R.drawable.jakarta_hotel, 800, false));
        listHotel.add(new hotel(3, "Karimun Jawa Hotel", "Karimun Jawa", "Rp 750.000", "Harga Untuk 1 Malam, 2 Dewasa", "Termasuk Sarapan dan Gym", 4, R.drawable.karimun_jawa_hotel, 1200, false));
        listHotel.add(new hotel(4, "Komodo Island Hotel", "Pulau Komodo", "Rp 1.200.000", "Harga Untuk 1 Malam, 2 Dewasa", "Termasuk Sarapan dan Biaya Tour Pulau Komodo", 4, R.drawable.komodo_island_hotel, 2200, false));
        listHotel.add(new hotel(5, "Lombok Resorts", "Lombok", "Rp 1.800.000", "Harga Untuk 1 Malam, 2 Dewasa", "Termasuk Sarapan", 5, R.drawable.lombok_resorts, 3200, false));
        listHotel.add(new hotel(6, "Nusa Dua Resorts", "Nusa Dua", "Rp 750.000", "Harga Untuk 1 Malam, 2 Dewasa", "Termasuk Sarapan dan Merchandise Hotel", 4, R.drawable.nusa_dua_resort, 1750, false));
        listHotel.add(new hotel(7, "Raja Ampat Hotel", "Raja Ampat", "Rp 600.000", "Harga Untuk 1 Malam, 2 Dewasa", "Teramasuk Sarapan", 4, R.drawable.rajaampat_hotel, 1500, false));
        listHotel.add(new hotel(8, "Surabaya Hotel", "Surabaya", "Rp 950.000", "Harga Untuk 1 Malam, 2 Dewasa", "Termasuk Sarapan", 5, R.drawable.surabaya_hotel, 3500, false));
        listHotel.add(new hotel(9, "Tabanan Resorts", "Tabanan", "Rp 1.200.000", "Harga Untuk 1 Malam, 2 Dewasa", "Termasuk Sarapan dan Gym", 5, R.drawable.tabanan_resorts, 1800, false));
    }

    public List<hotel> getListHotel() {
        return listHotel;
    }

    public hotel getHotelById(int id){
        return listHotel.get(id);
    }

    public void addFavorite(int id){
        listHotel.get(id).setFavorite(true);
    }

    public void removeFavorite(int id){
        listHotel.get(id).setFavorite(false);
    }

    public void addReview(int id){
        int review = listHotel.get(id).getReview();
        review += 1;
        listHotel.get(id).setReview(review);
    }
}
