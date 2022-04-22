package com.ck4u.booking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Adapterlisthotel adapterlisthotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView Listhotel = findViewById(R.id.recycler);
        adapterlisthotel = new Adapterlisthotel();
        Listhotel.setAdapter(adapterlisthotel);
        Listhotel.setHasFixedSize(true);
        Listhotel.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();

        booking booking = (booking) getApplication();
        List<hotel> listHotel = booking.getListHotel();
        adapterlisthotel.setListhotel(listHotel);
    }
}