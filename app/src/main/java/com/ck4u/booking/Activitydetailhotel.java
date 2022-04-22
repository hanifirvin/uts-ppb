package com.ck4u.booking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class Activitydetailhotel extends AppCompatActivity {

    boolean isFavorite = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hotel);

        int id = getIntent().getIntExtra("id", -1);
        booking booking = (booking) getApplication();
        hotel hotel = booking.getHotelById(id);

        TextView name = findViewById(R.id.tvNama);
        TextView desc = findViewById(R.id.tvDesc);
        ImageView imgHotel = findViewById(R.id.img_hotel);
        ImageButton btnFavorite = findViewById(R.id.btnFavorite);
        TextView price = findViewById(R.id.tvPrice);
        TextView note = findViewById(R.id.tvNote);
        RatingBar hotelType = findViewById(R.id.hotelType);
        EditText review = findViewById(R.id.edtReview);
        Button btnSubmit = findViewById(R.id.btn_submit);

        name.setText(hotel.getName());
        desc.setText(hotel.getDescription());
        price.setText(hotel.getPrice());
        note.setText(hotel.getNote());

        hotelType.setRating(hotel.getHotelType());

        Glide.with(this)
                .load(hotel.getImage())
                .into(imgHotel);

        if(hotel.isFavorite()){
            btnFavorite.setImageResource(R.drawable.ic_baseline_favorite_24);
            isFavorite = true;
        } else {
            btnFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24);
            isFavorite = false;
        }

        if(getSupportActionBar() != null){
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(review.getText().toString().isEmpty()){
                    review.setError("Review Tidak Boleh Kosong");
                } else {
                    booking.addReview(hotel.getId());
                    Toast.makeText(Activitydetailhotel.this, "Berhasil memberikan ulasan", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isFavorite){
                    booking.removeFavorite(hotel.getId());
                    btnFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24);
                    isFavorite = false;

                    Toast.makeText(Activitydetailhotel.this, "Hotel dihapus dari Favorite", Toast.LENGTH_SHORT).show();
                } else {
                    booking.addFavorite(hotel.getId());
                    btnFavorite.setImageResource(R.drawable.ic_baseline_favorite_24);
                    isFavorite = true;

                    Toast.makeText(Activitydetailhotel.this, "Hotel ditambahkan ke Favorite", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}