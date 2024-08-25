package com.example.quote;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FavoriteQuotes extends AppCompatActivity {

    private ListView favoriteQuotesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_quotes);

        favoriteQuotesListView = findViewById(R.id.favorite_quotes_list_view);

        // Load favorite quotes from database or storage
        ArrayList<String> favoriteQuotes = new ArrayList<>();
        // Add favorite quotes to the list view
        FavoriteQuotesAdapter adapter = new FavoriteQuotesAdapter(this, favoriteQuotes);
        favoriteQuotesListView.setAdapter(adapter);
    }
}