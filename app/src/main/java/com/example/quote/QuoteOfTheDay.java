package com.example.quote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class QuoteOfTheDay extends AppCompatActivity {

    private TextView quoteTextView;
    private Button refreshButton;
    private Button shareButton;
    private Button favoriteButton;

    private String[] quotes = {
            "Believe you can and you're halfway there. - Theodore Roosevelt",
            "The only way to do great work is to love what you do. - Steve Jobs",
            "Success is not final, failure is not fatal: It is the courage to continue that counts. - Winston Churchill",
            // Add more quotes here
    };

    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_of_the_day);

        quoteTextView = findViewById(R.id.quote_text_view);
        refreshButton = findViewById(R.id.refresh_button);
        shareButton = findViewById(R.id.share_button);
        favoriteButton = findViewById(R.id.favorite_button);

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshQuote();
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareQuote();
            }
        });

        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFavoriteQuote();
            }
        });

        refreshQuote();
    }

    private void refreshQuote() {
        int randomIndex = random.nextInt(quotes.length);
        String randomQuote = quotes[randomIndex];
        quoteTextView.setText(randomQuote);
    }

    private void shareQuote() {
        String quote = quoteTextView.getText().toString();
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, quote);
        startActivity(Intent.createChooser(shareIntent, "Share Quote"));
    }

    private void addFavoriteQuote() {
        String quote = quoteTextView.getText().toString();
        // Add quote to favorites database or storage
        Toast.makeText(this, "Quote added to favorites!", Toast.LENGTH_SHORT).show();
    }
}